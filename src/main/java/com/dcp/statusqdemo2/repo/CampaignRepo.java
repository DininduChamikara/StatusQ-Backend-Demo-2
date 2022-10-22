package com.dcp.statusqdemo2.repo;

import com.dcp.statusqdemo2.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepo extends JpaRepository<Campaign, Integer> {
}
