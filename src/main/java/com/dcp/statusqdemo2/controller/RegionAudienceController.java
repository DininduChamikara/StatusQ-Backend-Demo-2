package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.AgeAudienceDTO;
import com.dcp.statusqdemo2.dto.RegionAudienceDTO;
import com.dcp.statusqdemo2.service.AgeAudienceService;
import com.dcp.statusqdemo2.service.RegionAudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/regionAudience")
@CrossOrigin
public class RegionAudienceController {
    @Autowired
    private RegionAudienceService regionAudienceService;

    @PostMapping("/saveRegionAudience")
    public RegionAudienceDTO saveRegionAudience(@RequestBody RegionAudienceDTO regionAudienceDTO){
        return regionAudienceService.saveRegionAudience(regionAudienceDTO);
    }
}
