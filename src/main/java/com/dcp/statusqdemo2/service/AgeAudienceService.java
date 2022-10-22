package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.AgeAudienceDTO;
import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.model.AgeAudience;
import com.dcp.statusqdemo2.model.EducationAudience;
import com.dcp.statusqdemo2.repo.AgeAudienceRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgeAudienceService {

    @Autowired
    private AgeAudienceRepo ageAudienceRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AgeAudienceDTO saveAgeAudience(AgeAudienceDTO ageAudienceDTO){
        ageAudienceRepo.save(modelMapper.map(ageAudienceDTO, AgeAudience.class));
        return ageAudienceDTO;
    }
}
