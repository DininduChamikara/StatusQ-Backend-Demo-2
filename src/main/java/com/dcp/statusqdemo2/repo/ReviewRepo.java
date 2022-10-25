package com.dcp.statusqdemo2.repo;

import com.dcp.statusqdemo2.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
