package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.AgeAudienceDTO;
import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.service.AgeAudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/ageAudience")
@CrossOrigin
public class AgeAudienceController {

    @Autowired
    private AgeAudienceService ageAudienceService;

    @PostMapping("/saveAgeAudience")
    public AgeAudienceDTO saveAgeAudience(@RequestBody AgeAudienceDTO ageAudienceDTO){
        return ageAudienceService.saveAgeAudience(ageAudienceDTO);
    }
}
