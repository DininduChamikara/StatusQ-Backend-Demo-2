package com.dcp.statusqdemo2.dto;

import com.dcp.statusqdemo2.model.PromoterAudienceCategory;
import com.dcp.statusqdemo2.model.PromoterGenderAudience;
import com.dcp.statusqdemo2.model.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoterDTO {
    private int promoterId;
    private int userId;
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

    private List<SocialMedia> socialMediaList;
    private List<PromoterGenderAudience> promoterGenderAudienceList;
    private List<PromoterAudienceCategory> promoterAudienceCategoryList;

    private String state;
}
