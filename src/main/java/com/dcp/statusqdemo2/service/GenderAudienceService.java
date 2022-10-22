package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.dto.GenderAudienceDTO;
import com.dcp.statusqdemo2.model.EducationAudience;
import com.dcp.statusqdemo2.model.GenderAudience;
import com.dcp.statusqdemo2.repo.EducationAudienceRepo;
import com.dcp.statusqdemo2.repo.GenderAudienceRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderAudienceService {
    @Autowired
    private GenderAudienceRepo genderAudienceRepo;

    @Autowired
    private ModelMapper modelMapper;

    public GenderAudienceDTO saveGenderAudience(GenderAudienceDTO genderAudienceDTO){
        genderAudienceRepo.save(modelMapper.map(genderAudienceDTO, GenderAudience.class));
        return genderAudienceDTO;
    }
}
