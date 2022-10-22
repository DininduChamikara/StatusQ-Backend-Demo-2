package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.CampaignDTO;
import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.model.Campaign;
import com.dcp.statusqdemo2.repo.CampaignRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CampaignService {
    @Autowired
    private CampaignRepo campaignRepo;

    @Autowired
    private EducationAudienceService educationAudienceService;

    @Autowired
    private ModelMapper modelMapper;

    public CampaignDTO saveCampaign(CampaignDTO campaignDTO){
        Campaign campaign = campaignRepo.save(modelMapper.map(campaignDTO, Campaign.class));

        EducationAudienceDTO educationAudienceDTO = new EducationAudienceDTO();
        educationAudienceDTO.setCampaignEducationAudience(campaign);
        educationAudienceDTO.setEducationGroup("Group 1");
        educationAudienceService.saveEducationAudience(educationAudienceDTO);

        return campaignDTO;
    }
}
