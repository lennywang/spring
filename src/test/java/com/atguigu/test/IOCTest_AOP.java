package com.atguigu.test;

import com.atguigu.aop.MathCaculator;
import com.atguigu.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_AOP {

    @Test
    public void test01()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCaculator mathCaculator = applicationContext.getBean(MathCaculator.class);
        mathCaculator.div(1,0);
        applicationContext.close();
    }
}
