package com.dcp.statusqdemo2.repo;

import com.dcp.statusqdemo2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
