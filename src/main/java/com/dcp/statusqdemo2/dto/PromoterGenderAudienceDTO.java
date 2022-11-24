package com.dcp.statusqdemo2.dto;

import com.dcp.statusqdemo2.model.Promoter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoterGenderAudienceDTO {
    private int recordId;
    private Promoter promoterPromoterGenderAudience;
    private String platform;
    private int malePercentage;
    private int femalePercentage;
}
