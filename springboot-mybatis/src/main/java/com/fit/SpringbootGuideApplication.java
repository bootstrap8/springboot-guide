package com.fit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.fit.*.dao")
//@ComponentScan(basePackages = {"com.fit"})
public class SpringbootGuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGuideApplication.class, args);
    }

}
