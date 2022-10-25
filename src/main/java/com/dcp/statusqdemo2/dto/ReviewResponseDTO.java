package com.dcp.statusqdemo2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewResponseDTO {
    private String firstname;
    private String lastname;
    private String profileImgUrl;
    private int ratingCount;
    private Date date;
    private String description;
}
