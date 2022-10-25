package com.dcp.statusqdemo2.service;

import com.dcp.statusqdemo2.dto.ReviewDTO;
import com.dcp.statusqdemo2.dto.ReviewResponseDTO;
import com.dcp.statusqdemo2.model.Review;
import com.dcp.statusqdemo2.model.User;
import com.dcp.statusqdemo2.repo.ReviewRepo;
import com.dcp.statusqdemo2.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    public ReviewDTO saveReview(ReviewDTO reviewDTO){
        reviewRepo.save(modelMapper.map(reviewDTO, Review.class));
        return reviewDTO;
    }

    public List<ReviewResponseDTO> getAllReviewResponse(){
        List<Review> reviewList = reviewRepo.findAll();
        System.out.println(reviewList);

        List<ReviewResponseDTO> reviewResponseDTOList = new ArrayList<>();

        for(Review review:reviewList){
            User user = userRepo.findUserByUserId(review.getUserReview().getUserId());
            ReviewResponseDTO reviewResponseDTO = new ReviewResponseDTO();

            reviewResponseDTO.setFirstname(user.getFirstname());
            reviewResponseDTO.setLastname(user.getLastname());
            reviewResponseDTO.setProfileImgUrl(user.getProfileImageURL());
            reviewResponseDTO.setDate(review.getDate());
            reviewResponseDTO.setDescription(review.getDescription());
            reviewResponseDTO.setRatingCount(review.getRatingCount());

            reviewResponseDTOList.add(reviewResponseDTO);

        }
        return reviewResponseDTOList;
    }


}
