package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.*;
import com.dcp.statusqdemo2.service.PromoterService;
import com.dcp.statusqdemo2.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/promoter")
@CrossOrigin
public class PromoterController {

    @Autowired
    private PromoterService promoterService;

    @Autowired
    private SocialMediaService socialMediaService;

    @PostMapping("/savePromoter")
    public SavePromoterOutputDTO savePromoter(@RequestBody PromoterDTO promoterDTO){
        SavePromoterOutputDTO savePromoterOutputDTO = new SavePromoterOutputDTO();

        try{
            savePromoterOutputDTO.setPromoterDTO(promoterService.savePromoter(promoterDTO));
            savePromoterOutputDTO.setResponseCode("00");
            savePromoterOutputDTO.setStatus("success");
            savePromoterOutputDTO.setMessage("You are successfully submitted the promoter survey");
        }catch(Exception e){
            System.out.println(e.getMessage());
            savePromoterOutputDTO.setResponseCode("1000");
            savePromoterOutputDTO.setStatus("failure");
            savePromoterOutputDTO.setMessage("Something went wrong, try again");
        }finally {
            return savePromoterOutputDTO;
        }
//        return promoterService.savePromoter(promoterDTO);
    }

    @PostMapping("/getPromotersList")
    public List<SocialMediaResponseDTO> getPromotersList(@RequestBody PromoterListRequestDTO promoterListRequestDTO){

        List<SocialMediaResponseDTO> promoterIdDataList = socialMediaService.getPromoterIdList(promoterListRequestDTO.getPlatform(), promoterListRequestDTO.getMinAccessibleViews());

        return promoterIdDataList;
    }

}
