package com.cjs.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author chengjiansheng
 */
@EnableCaching
@SpringBootApplication
public class CjsCaffeineExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjsCaffeineExampleApplication.class, args);
    }

}
