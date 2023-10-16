package com.salihguler.JavaFullStackDeveloper.bean;


import lombok.extern.log4j.Log4j2;

@Log4j2
public class BeanConfig {

    public void firstBeforeBean()
    {
        log.info("Bean Doğdu!");
        System.out.println("Bean Başlamdan önce Çalıştı");

    }

    public void firstAfterBean()
    {
        log.info("Bean Öldü");
        System.out.println("Bean Bitmden Önce Çalıştı");
    }
}
