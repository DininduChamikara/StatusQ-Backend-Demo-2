package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.dto.LanguageAudienceDTO;
import com.dcp.statusqdemo2.service.LanguageAudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/languageAudience")
@CrossOrigin
public class LanguageAudienceController {

    @Autowired
    private LanguageAudienceService languageAudienceService;

    @PostMapping("/saveLanguageAudience")
    public LanguageAudienceDTO saveLanguageAudience(@RequestBody LanguageAudienceDTO languageAudienceDTO){
        return languageAudienceService.saveLanguageAudience(languageAudienceDTO);
    }
}
