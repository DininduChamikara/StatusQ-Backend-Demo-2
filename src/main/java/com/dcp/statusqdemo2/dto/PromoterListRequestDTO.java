package com.dcp.statusqdemo2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoterListRequestDTO {
    private String platform;
    private int minAccessibleViews;
    private List educationAudience;
    private List ageAudience;
    private List regionalAudience;
    private List languageAudience;
    private List genderAudience;
    private int responseCount;
    private String state;
}
