package com.productStore.service;

import com.productStore.domain.Users;

/**
 * Created by ravi on 11/5/17.
 */
public interface UserService {
    public void addUser(Users user);
    public Users findByUsername(String username);

    public void Email(String email,String token);
   /* public Roles findByAuthority(String role);*/
}
