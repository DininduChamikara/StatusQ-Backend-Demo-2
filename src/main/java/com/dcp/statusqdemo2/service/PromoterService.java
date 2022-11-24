package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.*;
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
    private PromoterGenderAudienceService promoterGenderAudienceService;

    @Autowired
    private PromoterAudienceCategoryService promoterAudienceCategoryService;

    @Autowired
    private ModelMapper modelMapper;

    public PromoterDTO savePromoter(PromoterDTO promoterDTO){
        Promoter promoter = promoterRepo.save(modelMapper.map(promoterDTO, Promoter.class));

        SocialMediaDTO socialMediaDTO = new SocialMediaDTO();
        socialMediaDTO.setPromoterSocialMedia(promoter);

        PromoterGenderAudienceDTO promoterGenderAudienceDTO = new PromoterGenderAudienceDTO();
        promoterGenderAudienceDTO.setPromoterPromoterGenderAudience(promoter);

        PromoterAudienceCategoryDTO promoterAudienceCategoryDTO = new PromoterAudienceCategoryDTO();
        promoterAudienceCategoryDTO.setPromoterPromoterAudienceCategory(promoter);

        for(int i = 0; i<promoterDTO.getSocialMediaList().size(); i++){
            socialMediaDTO.setPlatform(promoterDTO.getSocialMediaList().get(i).getPlatform());
            socialMediaDTO.setAccessibleViewsCount(promoterDTO.getSocialMediaList().get(i).getAccessibleViewsCount());
            socialMediaService.saveSocialMedia(socialMediaDTO);
        }

        for(int i = 0; i<promoterDTO.getPromoterGenderAudienceList().size(); i++){
            promoterGenderAudienceDTO.setPlatform(promoterDTO.getPromoterGenderAudienceList().get(i).getPlatform());
            promoterGenderAudienceDTO.setMalePercentage(promoterDTO.getPromoterGenderAudienceList().get(i).getMalePercentage());
            promoterGenderAudienceDTO.setFemalePercentage(promoterDTO.getPromoterGenderAudienceList().get(i).getFemalePercentage());
            promoterGenderAudienceService.savePromoterGenderAudience(promoterGenderAudienceDTO);
        }

        for (int i = 0; i < promoterDTO.getPromoterAudienceCategoryList().size(); i++){
            promoterAudienceCategoryDTO.setPlatform(promoterDTO.getPromoterAudienceCategoryList().get(i).getPlatform());
            promoterAudienceCategoryDTO.setCategoryType(promoterDTO.getPromoterAudienceCategoryList().get(i).getCategoryType());
            promoterAudienceCategoryDTO.setCategory(promoterDTO.getPromoterAudienceCategoryList().get(i).getCategory());
            promoterAudienceCategoryDTO.setCount(promoterDTO.getPromoterAudienceCategoryList().get(i).getCount());
            promoterAudienceCategoryService.savePromoterAudienceCategory(promoterAudienceCategoryDTO);
        }

        return promoterDTO;
    }
}
