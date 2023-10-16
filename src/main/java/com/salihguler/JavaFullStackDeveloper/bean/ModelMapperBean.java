package com.salihguler.JavaFullStackDeveloper.bean;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Entity->DTO    DTO->Entity

@Configuration
public class ModelMapperBean {

    //@Bean(initMethod = "firstBeforeBean",destroyMethod = "firstAfterBean")
    @Bean
    public ModelMapper modelMapperMethod()
    {
        return new ModelMapper();
    }



}
