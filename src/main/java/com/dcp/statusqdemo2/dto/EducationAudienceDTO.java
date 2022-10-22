package com.dcp.statusqdemo2.dto;

import com.dcp.statusqdemo2.model.Campaign;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EducationAudienceDTO {
    private int recordId;
    private Campaign campaignEducationAudience;
    private String educationGroup;
//    private List<String> educationGroups;
}
