package com.productStore.dao;

import com.productStore.domain.Roles;
import com.productStore.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ravi on 9/5/17.
 */

public interface UserDao {
    public void addUser(Users user);
    public Users findByUsername(String username);
    public Roles findByAuthority(String role);
}

