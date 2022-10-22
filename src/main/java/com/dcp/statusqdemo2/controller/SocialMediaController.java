package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.dto.SocialMediaDTO;
import com.dcp.statusqdemo2.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/socialMedia")
@CrossOrigin
public class SocialMediaController {

    @Autowired
    private SocialMediaService socialMediaService;

    @PostMapping("/saveSocialMedia")
    public SocialMediaDTO saveSocialMedia(@RequestBody SocialMediaDTO socialMediaDTO){
        return socialMediaService.saveSocialMedia(socialMediaDTO);
    }
}
