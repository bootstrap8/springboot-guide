package com.fit.h4.importguide;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-07-23
 */
@Component
@Import({BeanByImport.class, MyClass.class})
public class ImportGuide implements ApplicationContextAware {

    @Bean
    public Account accountBean() {
        return new Account();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println("ImportGuide-->" + name);
        }
    }
}
