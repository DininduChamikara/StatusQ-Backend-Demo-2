package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.AgeAudienceDTO;
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
    private AgeAudienceService ageAudienceService;

    @Autowired
    private ModelMapper modelMapper;

    public CampaignDTO saveCampaign(CampaignDTO campaignDTO){
        Campaign campaign = campaignRepo.save(modelMapper.map(campaignDTO, Campaign.class));

        // Education Audience
        EducationAudienceDTO educationAudienceDTO = new EducationAudienceDTO();
        educationAudienceDTO.setCampaignEducationAudience(campaign);

        for(int i = 0; i<campaignDTO.getEducationAudience().size(); i++){
            educationAudienceDTO.setEducationGroup(campaignDTO.getEducationAudience().get(i));
            educationAudienceService.saveEducationAudience(educationAudienceDTO);
        }

        // Age Audience
        AgeAudienceDTO ageAudienceDTO = new AgeAudienceDTO();
        ageAudienceDTO.setCampaignAgeAudience(campaign);

        for(int i = 0; i<campaignDTO.getAgeAudience().size(); i++){
            ageAudienceDTO.setAgeGroup(campaignDTO.getAgeAudience().get(i));
            ageAudienceService.saveAgeAudience(ageAudienceDTO);
        }

        return campaignDTO;
    }
}
