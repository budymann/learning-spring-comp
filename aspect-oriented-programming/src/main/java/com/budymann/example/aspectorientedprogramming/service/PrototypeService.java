package com.budymann.example.aspectorientedprogramming.service;

import com.budymann.example.aspectorientedprogramming.aspect.Retry;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class PrototypeService {

    @Retry(retryAmt = 5)
    public String printMyName(String name){
        return name;
    }

}
