package com.productStore.service;

import org.springframework.stereotype.Service;

/**
 * Created by ravi on 22/5/17.
 */

@Service
public class CheckAspectServiceImpl implements CheckAspectService {
    @Override
    public void sayHi() {
        System.out.println("Hi");
    }

    @Override
    public void sayBye() {
        System.out.println("Bye");
    }
}
