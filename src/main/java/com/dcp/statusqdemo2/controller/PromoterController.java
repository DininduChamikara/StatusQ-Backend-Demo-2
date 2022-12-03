package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.*;
import com.dcp.statusqdemo2.service.PromoterAudienceCategoryService;
import com.dcp.statusqdemo2.service.PromoterGenderAudienceService;
import com.dcp.statusqdemo2.service.PromoterService;
import com.dcp.statusqdemo2.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "api/v1/promoter")
@CrossOrigin
public class PromoterController {

    @Autowired
    private PromoterService promoterService;

    @Autowired
    private SocialMediaService socialMediaService;

    @Autowired
    private PromoterAudienceCategoryService promoterAudienceCategoryService;

    @Autowired
    private PromoterGenderAudienceService promoterGenderAudienceService;


    @PostMapping("/savePromoter")
    public SavePromoterOutputDTO savePromoter(@RequestBody PromoterDTO promoterDTO){
        SavePromoterOutputDTO savePromoterOutputDTO = new SavePromoterOutputDTO();

        try{
            savePromoterOutputDTO.setPromoterDTO(promoterService.savePromoter(promoterDTO));
            savePromoterOutputDTO.setResponseCode("00");
            savePromoterOutputDTO.setStatus("success");
            savePromoterOutputDTO.setMessage("You are successfully submitted the promoter survey");
        }catch(Exception e){
            System.out.println(e.getMessage());
            savePromoterOutputDTO.setResponseCode("1000");
            savePromoterOutputDTO.setStatus("failure");
            savePromoterOutputDTO.setMessage("Something went wrong, try again");
        }finally {
            return savePromoterOutputDTO;
        }
//        return promoterService.savePromoter(promoterDTO);
    }

    @PostMapping("/getPromotersList")
    public List<ResponsePromoterListItemDTO> getPromotersList(@RequestBody PromoterListRequestDTO promoterListRequestDTO){

        List<SocialMediaResponseDTO> promoterIdDataList = socialMediaService.getPromoterIdList(promoterListRequestDTO.getPlatform(), promoterListRequestDTO.getMinAccessibleViews());

        double audienceMatchingIndex = 0;
        double count = 0;

        ArrayList<ResponsePromoterListItemDTO> responsePromoterList = new ArrayList<>();

        for(int i=0; i<promoterIdDataList.size(); i++){

            double matchIndexForEducation = 0.0;
            double matchIndexForAge = 0.0;
            double matchIndexForRegion = 0.0;
            double matchIndexForLanguage = 0.0;
            double matchIndexForGender = 0.0;

            // education matching
            List educationList = promoterListRequestDTO.getEducationAudience();
            for (int j=0; j<educationList.size(); j++){
                try{
                    count = promoterAudienceCategoryService.getAudienceCount(promoterIdDataList.get(i).getPromoterId(), "education", educationList.get(j).toString(), promoterListRequestDTO.getPlatform());
                    matchIndexForEducation = matchIndexForEducation + (count/promoterListRequestDTO.getMinAccessibleViews());
                }catch (Exception e){

                }
            }

            // age matching
            List ageList = promoterListRequestDTO.getAgeAudience();
            for (int j=0; j<ageList.size(); j++){
                try{
                    count = promoterAudienceCategoryService.getAudienceCount(promoterIdDataList.get(i).getPromoterId(), "age", ageList.get(j).toString(), promoterListRequestDTO.getPlatform());
                    matchIndexForAge = matchIndexForAge + (count/promoterListRequestDTO.getMinAccessibleViews());
                }catch (Exception e){

                }
            }

            // region matching
            List regionList = promoterListRequestDTO.getAgeAudience();
            for (int j=0; j<regionList.size(); j++){
                try{
                    count = promoterAudienceCategoryService.getAudienceCount(promoterIdDataList.get(i).getPromoterId(), "region", regionList.get(j).toString(), promoterListRequestDTO.getPlatform());
                    matchIndexForRegion = matchIndexForRegion + (count/promoterListRequestDTO.getMinAccessibleViews());
                }catch (Exception e){

                }
            }

            // language matching
            List languageList = promoterListRequestDTO.getLanguageAudience();
            for (int j=0; j<languageList.size(); j++){
                try{
                    count = promoterAudienceCategoryService.getAudienceCount(promoterIdDataList.get(i).getPromoterId(), "language", languageList.get(j).toString(), promoterListRequestDTO.getPlatform());
                    matchIndexForLanguage = matchIndexForLanguage + (count/promoterListRequestDTO.getMinAccessibleViews());
                }catch (Exception e){

                }
            }

            // gender matching
            List genderList = promoterListRequestDTO.getGenderAudience();
            for (int j=0; j<genderList.size(); j++){
                try{
                    if(genderList.get(j).toString().equals("male")){
                        matchIndexForGender = matchIndexForGender + (promoterGenderAudienceService.getMalePercentage(promoterIdDataList.get(i).getPromoterId(), promoterListRequestDTO.getPlatform()))/100;
                    }
                    if(genderList.get(j).toString().equals("female")){
                        matchIndexForGender = matchIndexForGender + (100 - promoterGenderAudienceService.getMalePercentage(promoterIdDataList.get(i).getPromoterId(), promoterListRequestDTO.getPlatform()))/100;
                    }

                }catch (Exception e){

                }
            }

            audienceMatchingIndex = matchIndexForEducation + matchIndexForAge + matchIndexForRegion + matchIndexForLanguage + matchIndexForGender;

            ResponsePromoterListItemDTO responsePromoterListItemDTO = new ResponsePromoterListItemDTO();
            responsePromoterListItemDTO.setPromoterId(promoterIdDataList.get(i).getPromoterId());
            responsePromoterListItemDTO.setAudienceMatchingIndex(audienceMatchingIndex);

            responsePromoterList.add(responsePromoterListItemDTO);

        }

//        System.out.println(responsePromoterList);

//        responsePromoterList.sort((o1, o2) -> o1.);

        Collections.sort(responsePromoterList, new Comparator<ResponsePromoterListItemDTO>() {
            @Override
            public int compare(ResponsePromoterListItemDTO c1, ResponsePromoterListItemDTO c2) {
                return Double.compare(c2.getAudienceMatchingIndex(), c1.getAudienceMatchingIndex());
            }
        });

        return responsePromoterList;
    }

}
