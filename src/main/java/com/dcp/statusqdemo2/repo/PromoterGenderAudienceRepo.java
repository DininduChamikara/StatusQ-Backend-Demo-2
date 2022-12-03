package com.dcp.statusqdemo2.repo;

import com.dcp.statusqdemo2.model.PromoterGenderAudience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PromoterGenderAudienceRepo extends JpaRepository<PromoterGenderAudience, Integer> {
    @Query(value = "SELECT male_percentage FROM promoter_gender_audience WHERE promoter_id = ?1 AND platform = ?2", nativeQuery = true)
    int getMalePercentage(int promoterId, String platform);
}
