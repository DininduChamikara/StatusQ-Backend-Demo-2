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
public class PromoterAudienceCategoryDTO {
    private int recordId;
    private Promoter promoterPromoterAudienceCategory;
    private String platform;
    private String categoryType;
    private String category;
    private int count;
}
