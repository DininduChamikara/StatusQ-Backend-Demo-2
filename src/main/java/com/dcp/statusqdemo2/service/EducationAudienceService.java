package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.model.EducationAudience;
import com.dcp.statusqdemo2.repo.EducationAudienceRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EducationAudienceService {
    @Autowired
    private EducationAudienceRepo educationAudienceRepo;

    @Autowired
    private ModelMapper modelMapper;

    public EducationAudienceDTO saveEducationAudience(EducationAudienceDTO educationAudienceDTO){
        educationAudienceRepo.save(modelMapper.map(educationAudienceDTO, EducationAudience.class));
        return educationAudienceDTO;
    }
}
