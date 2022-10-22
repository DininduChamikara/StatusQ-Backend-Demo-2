package com.dcp.statusqdemo2.dto;

import com.dcp.statusqdemo2.model.EducationAudience;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CampaignDTO {
    private int campaignId;
    private String platform;
    private int numberOfViews;
    private int viewsFromEachPromoter;
    private String paymentState;
    private String state;

    private List<String> educationAudience;

//    private List<EducationAudience> educationAudiences;
//    public List<EducationAudience> getEducationAudience() { return educationAudiences; }
//    public void setEducationAudience(List<EducationAudience> educationAudiences){
//        this.educationAudiences = educationAudiences;
//    }
}
