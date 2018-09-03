package com.fortech.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.fortech")
@EntityScan("com.fortech.model")
//@ComponentScan({"com.fortech.model","com.fortech.restapi","com.fortech.restapiimpl","com.fortech.serviceapi","com.fortech.serviceapiimpl"})
public class BootApplication{

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
