package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.dto.GenderAudienceDTO;
import com.dcp.statusqdemo2.service.EducationAudienceService;
import com.dcp.statusqdemo2.service.GenderAudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/genderAudience")
@CrossOrigin
public class GenderAudienceController {

    @Autowired
    private GenderAudienceService genderAudienceService;

    @PostMapping("/saveGenderAudience")
    public GenderAudienceDTO saveGenderAudience(@RequestBody GenderAudienceDTO genderAudienceDTO){
        return genderAudienceService.saveGenderAudience(genderAudienceDTO);
    }
}
