package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.RegionAudienceDTO;
import com.dcp.statusqdemo2.model.RegionAudience;
import com.dcp.statusqdemo2.repo.RegionAudienceRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionAudienceService {
    @Autowired
    private RegionAudienceRepo regionAudienceRepo;

    @Autowired
    private ModelMapper modelMapper;

    public RegionAudienceDTO saveRegionAudience(RegionAudienceDTO regionAudienceDTO){
        regionAudienceRepo.save(modelMapper.map(regionAudienceDTO, RegionAudience.class));
        return regionAudienceDTO;
    }
}
