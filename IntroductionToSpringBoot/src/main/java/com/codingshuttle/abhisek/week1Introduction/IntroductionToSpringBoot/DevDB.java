package com.codingshuttle.abhisek.week1Introduction.IntroductionToSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component("DevDb")
@ConditionalOnProperty(name = "deploy.env" , havingValue = "development")
public class DevDB implements  DB{

    public String getData(){

        return "DEV DB";
    }
}
