package com.codingshuttle.abhisek.week1Introduction.IntroductionToSpringBoot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Apple {

    void eatApple(){

        System.out.println("I am eating Apple");
    }

    @PostConstruct
    void callThisBeforeAppleIsUsed(){
        System.out.println("Creating the apple before use");
    }

    @PreDestroy
    void callThisBeforeDestroy(){
        System.out.println("Destroying the apple after use");
    }

}
