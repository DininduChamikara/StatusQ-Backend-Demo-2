package com.dcp.statusqdemo2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Promoter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promoterId;

    @OneToOne
    @JoinColumn(name="userId", referencedColumnName = "userId")
    private User userPromoter;

    private String fullName;
    private String nameWithInit;
//    private SimpleDateFormat dob;
    private Date dob;
    private String gender;
    private int age;
    private String nic;
    private String address;
    private String postcode;
    private String province;
    private String language;
    private String educationalCategory;

    @OneToMany(mappedBy = "promoterSocialMedia")
    private Set<SocialMedia> socialMediaSet;

    private String state;
}
