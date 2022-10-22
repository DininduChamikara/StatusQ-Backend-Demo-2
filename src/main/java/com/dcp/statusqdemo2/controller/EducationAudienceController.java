package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.service.EducationAudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/educationAudience")
@CrossOrigin
public class EducationAudienceController {

    @Autowired
    private EducationAudienceService educationAudienceService;

    @PostMapping("/saveEducationAudience")
    public EducationAudienceDTO saveEducationAudience(@RequestBody EducationAudienceDTO educationAudienceDTO){
        return educationAudienceService.saveEducationAudience(educationAudienceDTO);
    }
}
