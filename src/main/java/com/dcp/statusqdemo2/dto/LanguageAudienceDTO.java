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
public class LanguageAudienceDTO {
    private int recordId;
    private Campaign campaignLanguageAudience;
    private String language;
}
