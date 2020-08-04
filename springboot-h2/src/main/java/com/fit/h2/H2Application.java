package com.fit.h2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
//@MapperScan("com.fit.h2.*.dao")
@MapperScan("com.fit.h2.*.dao")
@ComponentScan(basePackages = {"com.fit.h2"}, basePackageClasses = {com.fit.h4.H4Application.class, com.fit.h4.importguide.MyClass.class})
//@ComponentScan(basePackages = {"com.fit.h2", "com.fit.h4"}, basePackageClasses = {com.fit.h4.H4Application.class})
public class H2Application {

    /**
     * basePackageClasses
     * 可以指定多个类或接口的class,扫描时会在（这些指定的类和接口）所属的包进行扫描
     */
    public static void main(String[] args) {
        SpringApplication.run(H2Application.class, args);
    }

}
