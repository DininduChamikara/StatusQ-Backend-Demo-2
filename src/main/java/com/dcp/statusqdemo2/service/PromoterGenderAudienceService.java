package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.PromoterGenderAudienceDTO;
import com.dcp.statusqdemo2.dto.SocialMediaDTO;
import com.dcp.statusqdemo2.model.PromoterGenderAudience;
import com.dcp.statusqdemo2.model.SocialMedia;
import com.dcp.statusqdemo2.repo.PromoterGenderAudienceRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromoterGenderAudienceService {
    @Autowired
    private PromoterGenderAudienceRepo promoterGenderAudienceRepo;

    @Autowired
    private ModelMapper modelMapper;

    public PromoterGenderAudienceDTO savePromoterGenderAudience(PromoterGenderAudienceDTO promoterGenderAudienceDTO){
        promoterGenderAudienceRepo.save(modelMapper.map(promoterGenderAudienceDTO, PromoterGenderAudience.class));
        return promoterGenderAudienceDTO;
    }

    public double getMalePercentage(int promoterId, String platform){
        double malePercentage = promoterGenderAudienceRepo.getMalePercentage(promoterId, platform);
        return malePercentage;
    }
}
