package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.CampaignDTO;
import com.dcp.statusqdemo2.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/campaign")
@CrossOrigin
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping("/saveCampaign")
    public CampaignDTO saveCampaign(@RequestBody CampaignDTO campaignDTO){
        return campaignService.saveCampaign(campaignDTO);
    }
}
