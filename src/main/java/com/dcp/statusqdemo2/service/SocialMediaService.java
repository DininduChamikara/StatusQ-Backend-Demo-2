package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.*;
import com.dcp.statusqdemo2.model.EducationAudience;
import com.dcp.statusqdemo2.model.SocialMedia;
import com.dcp.statusqdemo2.model.User;
import com.dcp.statusqdemo2.repo.SocialMediaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.String.valueOf;

@Service
public class SocialMediaService {

    @Autowired
    private SocialMediaRepo socialMediaRepo;

    @Autowired
    private ModelMapper modelMapper;

    public SocialMediaDTO saveSocialMedia(SocialMediaDTO socialMediaDTO){
        socialMediaRepo.save(modelMapper.map(socialMediaDTO, SocialMedia.class));
        return socialMediaDTO;
    }

    public SocialMediaDTO getPromoterByPlatformAndAccessibleViewsCount(String platform, int accessibleViewsCount){
        SocialMedia socialMedia = socialMediaRepo.findSocialMediaByPlatformAndAccessibleViewsCount(platform, accessibleViewsCount);
        return modelMapper.map(socialMedia, SocialMediaDTO.class);
    }

    public List<SocialMediaResponseDTO> getPromoterIdList(String platform, int accessibleViewsCount){
        ArrayList<SocialMediaResponseDTO> promoterIdDataList = socialMediaRepo.getPromoterIdList(platform, accessibleViewsCount);

        Iterator itr = promoterIdDataList.iterator();

        List <SocialMediaResponseDTO> socialMediaResponseDTOList = new ArrayList<>();

        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();

            SocialMediaResponseDTO socialMediaResponseDTO = new SocialMediaResponseDTO();

            socialMediaResponseDTO.setRecordId(Integer.parseInt(valueOf(obj[0])));
            socialMediaResponseDTO.setPromoterId(Integer.parseInt(valueOf(obj[1])));
            socialMediaResponseDTO.setPlatform(valueOf(obj[2]));
            socialMediaResponseDTO.setAccessibleViewsCount(Integer.parseInt(valueOf(obj[3])));

            socialMediaResponseDTOList.add(socialMediaResponseDTO);
        }

        return socialMediaResponseDTOList;
    }
}
