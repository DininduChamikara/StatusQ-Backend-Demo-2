package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.UserResponseDTO;
import com.dcp.statusqdemo2.dto.UserDTO;
import com.dcp.statusqdemo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public String getUser(){
        return "statusQ";
    }

    @GetMapping("/getUser/{email}/{password}")
    public UserResponseDTO getUserByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password){
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        try{
            UserDTO userDTO = userService.getUserByEmailAndPassword(email,password);
            userResponseDTO.setUser(userDTO);
            userResponseDTO.setResponseCode("00");
            userResponseDTO.setStatus("success");
            userResponseDTO.setMessage("You are logged successfully");
        }catch(Exception e){
            System.out.println(e.getMessage());
            userResponseDTO.setResponseCode("1000");
            userResponseDTO.setStatus("failure");
            userResponseDTO.setMessage("Invalid Username or Password");
        }finally {
            return userResponseDTO;
        }
    }

    @PostMapping("/saveUser")
    public UserResponseDTO saveUser(@RequestBody UserDTO userDTO){
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        try{
            UserDTO checkUser = userService.getUserByEmail(userDTO.getEmail());
            if(checkUser != null){
                System.out.println(checkUser.getEmail());
                userResponseDTO.setResponseCode("1000");
                userResponseDTO.setStatus("error");
                userResponseDTO.setMessage("Already you have an account");
            }
        }catch (Exception e){
            userService.saveUser(userDTO);
            userResponseDTO.setUser(userDTO);
            userResponseDTO.setResponseCode("00");
            userResponseDTO.setStatus("success");
            userResponseDTO.setMessage("You are registered successfully");
        }finally {
            return userResponseDTO;
        }

    }
}
