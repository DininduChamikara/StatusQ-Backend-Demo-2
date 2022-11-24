package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.PromoterGenderAudienceDTO;
import com.dcp.statusqdemo2.service.PromoterGenderAudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/promoterGenderAudience")
@CrossOrigin
public class PromoterGenderAudienceController {

    @Autowired
    private PromoterGenderAudienceService promoterGenderAudienceService;

    @PostMapping("/savePromoterGenderAudience")
    public PromoterGenderAudienceDTO savePromoterGenderAudience(@RequestBody PromoterGenderAudienceDTO promoterGenderAudienceDTO){
        return promoterGenderAudienceService.savePromoterGenderAudience(promoterGenderAudienceDTO);
    }
}
