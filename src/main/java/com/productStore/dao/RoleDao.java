package com.productStore.dao;

import com.productStore.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ravi on 17/5/17.
 */

@Repository("roleRepository")
public interface RoleDao {
   public Roles findByRole(String role);
}

