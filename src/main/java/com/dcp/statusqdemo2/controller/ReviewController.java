package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.ReviewDTO;
import com.dcp.statusqdemo2.dto.ReviewResponseDTO;
import com.dcp.statusqdemo2.dto.SaveReviewOutputDTO;
import com.dcp.statusqdemo2.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/review")
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/saveReview")
    public SaveReviewOutputDTO saveReview(@RequestBody ReviewDTO reviewDTO){
        SaveReviewOutputDTO saveReviewOutputDTO = new SaveReviewOutputDTO();

        try {
            saveReviewOutputDTO.setReviewDTO(reviewService.saveReview(reviewDTO));
            saveReviewOutputDTO.setResponseCode("00");
            saveReviewOutputDTO.setStatus("success");
            saveReviewOutputDTO.setMessage("You are successfully submitted the review");
        }catch (Exception e){
            System.out.println(e.getMessage());
            saveReviewOutputDTO.setResponseCode("1000");
            saveReviewOutputDTO.setStatus("failure");
            saveReviewOutputDTO.setMessage("Something went wrong, try again");
        } finally {
            return saveReviewOutputDTO;
        }
    }

    @GetMapping("/getAllReviewResponses")
    public List<ReviewResponseDTO> getAllReviewResponses(){
        return reviewService.getAllReviewResponse();
    }

}
