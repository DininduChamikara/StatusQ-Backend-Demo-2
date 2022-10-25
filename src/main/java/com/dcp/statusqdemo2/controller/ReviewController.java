package com.dcp.statusqdemo2.controller;

import com.dcp.statusqdemo2.dto.ReviewDTO;
import com.dcp.statusqdemo2.dto.ReviewResponseDTO;
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
    public ReviewDTO saveReview(@RequestBody ReviewDTO reviewDTO){
        return reviewService.saveReview(reviewDTO);
    }

    @GetMapping("/getAllReviewResponses")
    public List<ReviewResponseDTO> getAllReviewResponses(){
        return reviewService.getAllReviewResponse();
    }

}
