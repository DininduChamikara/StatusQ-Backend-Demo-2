package com.dcp.statusqdemo2.dto;

import com.dcp.statusqdemo2.model.Campaign;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenderAudienceDTO {
    private int recordId;
    private Campaign campaignGenderAudience;
    private String genderGroup;
}
