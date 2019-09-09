package com.atguigu.test;

import com.atguigu.bean.Yellow;
import com.atguigu.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    @Test
    public void test01()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("dev");
        applicationContext.register(MainConfigOfProfile.class);
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string:beanNamesForType
             ) {
            System.out.println(string);
        }

        Yellow yellow = applicationContext.getBean(Yellow.class);
        System.out.println(yellow);
        applicationContext.close();
    }

}
