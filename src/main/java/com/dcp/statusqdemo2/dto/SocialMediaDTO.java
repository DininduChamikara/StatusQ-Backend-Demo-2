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
public class SocialMediaDTO {
    private int recordId;
    private Promoter promoterSocialMedia;
    private String platform;
    private int accessibleViewsCount;
}
