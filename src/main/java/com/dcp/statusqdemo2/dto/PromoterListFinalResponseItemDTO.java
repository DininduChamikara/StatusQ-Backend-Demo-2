package com.dcp.statusqdemo2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoterListFinalResponseItemDTO {
    private int promoterId;
    private String platform;
    private List<CategoryCountDTO> education;
    private List<CategoryCountDTO> age;
    private List<CategoryCountDTO> region;
    private List<CategoryCountDTO> language;
    private double malePercentage;
    private double femalePercentage;
}
