package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.PromoterAudienceCategoryDTO;
import com.dcp.statusqdemo2.dto.PromoterGenderAudienceDTO;
import com.dcp.statusqdemo2.model.PromoterAudienceCategory;
import com.dcp.statusqdemo2.model.PromoterGenderAudience;
import com.dcp.statusqdemo2.repo.PromoterAudienceCategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromoterAudienceCategoryService {

    @Autowired
    private PromoterAudienceCategoryRepo promoterAudienceCategoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public PromoterAudienceCategoryDTO savePromoterAudienceCategory(PromoterAudienceCategoryDTO promoterAudienceCategoryDTO){
        promoterAudienceCategoryRepo.save(modelMapper.map(promoterAudienceCategoryDTO, PromoterAudienceCategory.class));
        return promoterAudienceCategoryDTO;
    }
}
