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
    public List<PromoterListFinalResponseItemDTO> getPromotersList(@RequestBody PromoterListRequestDTO promoterListRequestDTO){

        List<SocialMediaResponseDTO> promoterIdDataList = socialMediaService.getPromoterIdList(promoterListRequestDTO.getPlatform(), promoterListRequestDTO.getMinAccessibleViews());

        double audienceMatchingIndex = 0;
        double count = 0;

        ArrayList<ResponsePromoterListItemDTO> responsePromoterList = new ArrayList<>();

        // category
        String[] educationCategories = {"ol_cat","al_cat","undergraduate_cat", "postgraduate_cat"};
        String[] ageCategories = {"ageLevel_13_15", "ageLevel_16_18", "ageLevel_19_25", "ageLevel_26_35", "ageLevel_35_60", "ageGroup_over_60"};
        String[] regionCategories = {"westernProvince","centralProvince","southernProvince","uwaProvince","nothernProvince","easternProvince","sabaragamuwaProvince","northernWesternProvince","northCentralProvince"};
        String[] languageCategories = {"sinhala", "english", "tamil"};

        int categoryCount = 0;

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

        Collections.sort(responsePromoterList, new Comparator<ResponsePromoterListItemDTO>() {
            @Override
            public int compare(ResponsePromoterListItemDTO c1, ResponsePromoterListItemDTO c2) {
                return Double.compare(c2.getAudienceMatchingIndex(), c1.getAudienceMatchingIndex());
            }
        });

        ArrayList<ResponsePromoterListItemDTO> filteredResponsePromoterList = new ArrayList<>();

        for (int i=0; i<promoterListRequestDTO.getResponseCount(); i++){
            try {
                filteredResponsePromoterList.add(responsePromoterList.get(i));
            }catch (Exception e){

            }
        }

        // final response
        List<PromoterListFinalResponseItemDTO> finalResponseItemDTOList = new ArrayList<>();

        for (int i=0; i<filteredResponsePromoterList.size(); i++){

            List<CategoryCountDTO> educationCategoryDTOList = new ArrayList<>();
            List<CategoryCountDTO> ageCategoryDTOList = new ArrayList<>();
            List<CategoryCountDTO> regionCategoryDTOList = new ArrayList<>();
            List<CategoryCountDTO> languageCategoryDTOList = new ArrayList<>();

            //education
            for(int j=0; j<educationCategories.length; j++){
                CategoryCountDTO categoryCountDTO = new CategoryCountDTO();
                try{
                    categoryCount = promoterAudienceCategoryService.getAudienceCount(filteredResponsePromoterList.get(i).getPromoterId(), "education", educationCategories[j], promoterListRequestDTO.getPlatform());

                    categoryCountDTO.setCategory(educationCategories[j]);
                    categoryCountDTO.setCount(categoryCount);

                }catch (Exception e){
                    categoryCountDTO.setCategory(educationCategories[j]);
                    categoryCountDTO.setCount(0);
                }finally {
                    educationCategoryDTOList.add(categoryCountDTO);
                }
            }

            // age
            for(int j=0; j<ageCategories.length; j++){
                CategoryCountDTO categoryCountDTO = new CategoryCountDTO();
                try{
                    categoryCount = promoterAudienceCategoryService.getAudienceCount(filteredResponsePromoterList.get(i).getPromoterId(), "age", ageCategories[j], promoterListRequestDTO.getPlatform());

                    categoryCountDTO.setCategory(ageCategories[j]);
                    categoryCountDTO.setCount(categoryCount);

                }catch (Exception e){
                    categoryCountDTO.setCategory(ageCategories[j]);
                    categoryCountDTO.setCount(0);
                }finally {
                    ageCategoryDTOList.add(categoryCountDTO);
                }
            }

            // region
            for(int j=0; j<regionCategories.length; j++){
                CategoryCountDTO categoryCountDTO = new CategoryCountDTO();
                try{
                    categoryCount = promoterAudienceCategoryService.getAudienceCount(filteredResponsePromoterList.get(i).getPromoterId(), "region", regionCategories[j], promoterListRequestDTO.getPlatform());

                    categoryCountDTO.setCategory(regionCategories[j]);
                    categoryCountDTO.setCount(categoryCount);

                }catch (Exception e){
                    categoryCountDTO.setCategory(regionCategories[j]);
                    categoryCountDTO.setCount(0);
                }finally {
                    regionCategoryDTOList.add(categoryCountDTO);
                }
            }

            // language
            for(int j=0; j<languageCategories.length; j++){
                CategoryCountDTO categoryCountDTO = new CategoryCountDTO();
                try{
                    categoryCount = promoterAudienceCategoryService.getAudienceCount(filteredResponsePromoterList.get(i).getPromoterId(), "language", languageCategories[j], promoterListRequestDTO.getPlatform());

                    categoryCountDTO.setCategory(languageCategories[j]);
                    categoryCountDTO.setCount(categoryCount);

                }catch (Exception e){
                    categoryCountDTO.setCategory(languageCategories[j]);
                    categoryCountDTO.setCount(0);
                }finally {
                    languageCategoryDTOList.add(categoryCountDTO);
                }
            }

            double malePercentage = 0;

            try {
                malePercentage = promoterGenderAudienceService.getMalePercentage(filteredResponsePromoterList.get(i).getPromoterId(), promoterListRequestDTO.getPlatform());
            }catch (Exception e){

            }


            PromoterListFinalResponseItemDTO promoterListFinalResponseItemDTO = new PromoterListFinalResponseItemDTO();
            promoterListFinalResponseItemDTO.setPromoterId(filteredResponsePromoterList.get(i).getPromoterId());
            promoterListFinalResponseItemDTO.setPlatform(promoterListRequestDTO.getPlatform());

            promoterListFinalResponseItemDTO.setEducation(educationCategoryDTOList);
            promoterListFinalResponseItemDTO.setAge(ageCategoryDTOList);
            promoterListFinalResponseItemDTO.setRegion(regionCategoryDTOList);
            promoterListFinalResponseItemDTO.setLanguage(languageCategoryDTOList);

            promoterListFinalResponseItemDTO.setMalePercentage(malePercentage);
            promoterListFinalResponseItemDTO.setFemalePercentage(100 - malePercentage);

            finalResponseItemDTOList.add(promoterListFinalResponseItemDTO);

        }


        return finalResponseItemDTOList;
    }

}
