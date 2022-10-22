package com.dcp.statusqdemo2.repo;

import com.dcp.statusqdemo2.model.Promoter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoterRepo extends JpaRepository<Promoter, Integer> {
}
