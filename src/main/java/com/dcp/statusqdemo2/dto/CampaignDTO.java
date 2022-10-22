package com.dcp.statusqdemo2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CampaignDTO {
    private int campaignId;
    private String platform;
    //    private int advertiserId;
    private int numberOfViews;
    private int viewsFromEachPromoter;
    private String paymentState;
    private String state;
}
