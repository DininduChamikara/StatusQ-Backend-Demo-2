package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.CampaignDTO;
import com.dcp.statusqdemo2.dto.PromoterDTO;
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
    public PromoterDTO savePromoter(@RequestBody PromoterDTO promoterDTO){
        return promoterService.savePromoter(promoterDTO);
    }

}
