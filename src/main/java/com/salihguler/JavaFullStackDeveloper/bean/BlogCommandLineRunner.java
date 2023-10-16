package com.salihguler.JavaFullStackDeveloper.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class BlogCommandLineRunner {

    //proje ayağa kalktığında
    @Bean
    public CommandLineRunner blogCommandLineMethod()
    {

            //Lambda expression
            return args->{
                System.out.println("CommandLine Runner Çalıştı!!!");
                log.info("CommandLine Runner Çalıştı!!!");
            };
        }
    }

