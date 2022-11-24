package com.dcp.statusqdemo2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaveReviewOutputDTO {
    private String responseCode;
    private String status;
    private String message;
    private ReviewDTO reviewDTO;
}
