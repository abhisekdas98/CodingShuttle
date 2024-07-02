package com.codingshuttle.abhisek.week1Introduction.IntroductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
public class DBService {


   final private DB db;
// this can be final only when constructor injection is used , else if we use @Autowired annotation we will get erro

    public DBService(DB db){
      this.db=db;
    }

    String getData(){

        return  db.getData();
    }


}
