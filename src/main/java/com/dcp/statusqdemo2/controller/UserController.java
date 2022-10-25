package com.dcp.statusqdemo2.controller;

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
    public UserDTO getUserByEmailAndPassword(@PathVariable("email") String email,@PathVariable("password") String password){
        return userService.getUserByEmailAndPassword(email,password);
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }
}
