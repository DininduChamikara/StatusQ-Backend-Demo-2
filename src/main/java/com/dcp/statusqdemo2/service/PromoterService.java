package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.CampaignDTO;
import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.dto.PromoterDTO;
import com.dcp.statusqdemo2.dto.SocialMediaDTO;
import com.dcp.statusqdemo2.model.Campaign;
import com.dcp.statusqdemo2.model.Promoter;
import com.dcp.statusqdemo2.repo.PromoterRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PromoterService {

    @Autowired
    private PromoterRepo promoterRepo;

    @Autowired
    private SocialMediaService socialMediaService;

    @Autowired
    private ModelMapper modelMapper;

    public PromoterDTO savePromoter(PromoterDTO promoterDTO){
        Promoter promoter = promoterRepo.save(modelMapper.map(promoterDTO, Promoter.class));

        SocialMediaDTO socialMediaDTO = new SocialMediaDTO();
        socialMediaDTO.setPromoterSocialMedia(promoter);

        for(int i = 0; i<promoterDTO.getSocialMediaList().size(); i++){
            socialMediaDTO.setPlatform(promoterDTO.getSocialMediaList().get(i).getPlatform());
            socialMediaDTO.setAccessibleViewsCount(promoterDTO.getSocialMediaList().get(i).getAccessibleViewsCount());
            socialMediaService.saveSocialMedia(socialMediaDTO);
        }

        return promoterDTO;
    }
}
