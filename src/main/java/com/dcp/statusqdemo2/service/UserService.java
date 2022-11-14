package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.UserDTO;
import com.dcp.statusqdemo2.model.User;
import com.dcp.statusqdemo2.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public UserDTO getUserByEmailAndPassword(String email,String password){
        User user = userRepo.findUserByEmailAndPassword(email,password);
        return modelMapper.map(user,UserDTO.class);
    }

    public UserDTO getUserByUserId(int userId){
        User user = userRepo.findUserByUserId(userId);
        return modelMapper.map(user,UserDTO.class);
    }

    public UserDTO getUserByEmail(String email){
        User user = userRepo.findUserByEmail(email);
        return modelMapper.map(user,UserDTO.class);
    }
}
