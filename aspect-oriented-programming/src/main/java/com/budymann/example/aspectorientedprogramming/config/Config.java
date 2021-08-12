package com.budymann.example.aspectorientedprogramming.config;

import com.budymann.example.aspectorientedprogramming.aspect.CommonAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class Config {

//    @Bean
//    public CommonAspect aspect() {
//        return new CommonAspect();
//    }
}
