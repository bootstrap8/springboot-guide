package com.fit.h2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fit.h2.*.dao")
public class SpringbootGuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGuideApplication.class, args);
    }

}
