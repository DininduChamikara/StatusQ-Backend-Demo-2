package com.dcp.statusqdemo2.dto;

import com.dcp.statusqdemo2.model.Campaign;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgeAudienceDTO {
    private int recordId;
    private Campaign campaignAgeAudience;
    private String ageGroup;
}
