package com.dcp.statusqdemo2.repo;

import com.dcp.statusqdemo2.model.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaRepo extends JpaRepository<SocialMedia, Integer> {
}
