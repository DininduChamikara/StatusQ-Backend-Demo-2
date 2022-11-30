package com.dcp.statusqdemo2.repo;

import com.dcp.statusqdemo2.model.PromoterAudienceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PromoterAudienceCategoryRepo extends JpaRepository<PromoterAudienceCategory, Integer> {

    @Query(value = "SELECT count FROM promoter_audience_category WHERE promoter_id = ?1 AND category_type = ?2 AND category = ?3 AND platform = ?4", nativeQuery = true)
    int getAudienceCount(int promoterId, String categoryType, String category, String platform);
}
