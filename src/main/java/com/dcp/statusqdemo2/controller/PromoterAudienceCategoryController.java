package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.PromoterAudienceCategoryDTO;
import com.dcp.statusqdemo2.service.PromoterAudienceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/promoterAudienceCategory")
@CrossOrigin
public class PromoterAudienceCategoryController {

   @Autowired
   private PromoterAudienceCategoryService promoterAudienceCategoryService;

   @GetMapping("/getAudienceCount/{promoterId}/{categoryType}/{category}/{platform}")
   public int findCountByPromoterIdAndCategoryTypeAndCategory(@PathVariable("promoterId") int promoterId, @PathVariable("categoryType") String categoryType, @PathVariable("category") String category, @PathVariable("platform") String platform){
      return promoterAudienceCategoryService.getAudienceCount(promoterId, categoryType, category, platform);
   }

}
