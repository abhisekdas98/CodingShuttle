package com.codingshuttle.abhisek.week1Introduction.IntroductionToSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("ProdDb")
@Primary
@ConditionalOnProperty(name = "deploy.env" , havingValue = "production")
public class ProdDB implements DB{
    public String getData(){

        return "Prod DB";
    }
}
