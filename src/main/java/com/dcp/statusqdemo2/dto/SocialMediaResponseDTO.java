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
public class SocialMediaResponseDTO {
    private int recordId;
    private String promoterId;
    private String platform;
    private int accessibleViewsCount;
}
