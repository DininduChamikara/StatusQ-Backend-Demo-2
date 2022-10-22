package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.EducationAudienceDTO;
import com.dcp.statusqdemo2.dto.LanguageAudienceDTO;
import com.dcp.statusqdemo2.model.EducationAudience;
import com.dcp.statusqdemo2.model.LanguageAudience;
import com.dcp.statusqdemo2.repo.EducationAudienceRepo;
import com.dcp.statusqdemo2.repo.LanguageAudienceRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageAudienceService {
    @Autowired
    private LanguageAudienceRepo languageAudienceRepo;

    @Autowired
    private ModelMapper modelMapper;

    public LanguageAudienceDTO saveLanguageAudience(LanguageAudienceDTO languageAudienceDTO){
        languageAudienceRepo.save(modelMapper.map(languageAudienceDTO, LanguageAudience.class));
        return languageAudienceDTO;
    }
}
