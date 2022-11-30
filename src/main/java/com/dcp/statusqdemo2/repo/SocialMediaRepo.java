package com.dcp.statusqdemo2.repo;

import com.dcp.statusqdemo2.dto.SocialMediaDTO;
import com.dcp.statusqdemo2.dto.SocialMediaResponseDTO;
import com.dcp.statusqdemo2.model.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface SocialMediaRepo extends JpaRepository<SocialMedia, Integer> {

    SocialMedia findSocialMediaByPlatformAndAccessibleViewsCount(String platform, int accessibleViewsCount);

    @Query(value = "SELECT * FROM social_media WHERE platform = ?1 AND accessible_views_count >= ?2", nativeQuery = true)
    ArrayList getPromoterIdList(String platform, int accessible_views_count);

}
