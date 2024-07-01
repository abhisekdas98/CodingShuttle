package com.codingshuttle.abhisek.week1Introduction.IntroductionToSpringBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    Apple getApple(){
        return new Apple();
    }

    @Bean
    Apple getApple2(){
        return new Apple();
    }
}
