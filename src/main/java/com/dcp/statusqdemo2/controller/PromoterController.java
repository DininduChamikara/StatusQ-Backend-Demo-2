package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.CampaignDTO;
import com.dcp.statusqdemo2.dto.PromoterDTO;
import com.dcp.statusqdemo2.dto.SavePromoterOutputDTO;
import com.dcp.statusqdemo2.service.PromoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/promoter")
@CrossOrigin
public class PromoterController {

    @Autowired
    private PromoterService promoterService;

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

}
