package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.dto.SocialMediaDTO;
import com.dcp.statusqdemo2.model.EducationAudience;
import com.dcp.statusqdemo2.model.SocialMedia;
import com.dcp.statusqdemo2.repo.SocialMediaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaService {

    @Autowired
    private SocialMediaRepo socialMediaRepo;

    @Autowired
    private ModelMapper modelMapper;

    public SocialMediaDTO saveSocialMedia(SocialMediaDTO socialMediaDTO){
        socialMediaRepo.save(modelMapper.map(socialMediaDTO, SocialMedia.class));
        return socialMediaDTO;
    }
}
