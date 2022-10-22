package com.dcp.statusqdemo2.repo;

import com.dcp.statusqdemo2.model.GenderAudience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderAudienceRepo extends JpaRepository<GenderAudience, Integer> {
}
