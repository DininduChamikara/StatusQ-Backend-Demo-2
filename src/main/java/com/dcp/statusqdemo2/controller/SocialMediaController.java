package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.dto.SocialMediaDTO;
import com.dcp.statusqdemo2.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getPromoterId/{platform}/{accessibleViewsCount}")
    public SocialMediaDTO getPromoterByPlatformAndAccessibleViewsCount(@PathVariable("platform") String platform, @PathVariable("accessibleViewsCount") int accessibleViewsCount){
        return socialMediaService.getPromoterByPlatformAndAccessibleViewsCount(platform, accessibleViewsCount);
    }

    @GetMapping("/getPromoterIdList/{platform}/{accessibleViewsCount}")
    public List getPromoterIdList(@PathVariable("platform") String platform, @PathVariable("accessibleViewsCount") int accessibleViewsCount){
        return socialMediaService.getPromoterIdList(platform, accessibleViewsCount);
    }
}
