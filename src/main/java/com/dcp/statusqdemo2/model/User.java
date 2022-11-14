package com.dcp.statusqdemo2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String email;
    private String password;
    private String profileImageURL;
    private String userType;
    private String state;
}
