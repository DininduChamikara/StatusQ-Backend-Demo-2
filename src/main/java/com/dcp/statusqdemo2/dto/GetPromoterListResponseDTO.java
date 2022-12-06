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
public class GetPromoterListResponseDTO {
    private String responseCode;
    private String status;
    private String message;
    private List<PromoterListFinalResponseItemDTO> promoterListFinalResponseItemDTO;
}
