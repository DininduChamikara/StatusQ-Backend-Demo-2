package com.dcp.statusqdemo2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String profileImageURL;
    private String userType;
    private String state;
}
