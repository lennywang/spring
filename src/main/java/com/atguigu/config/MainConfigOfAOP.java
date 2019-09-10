package com.atguigu.config;

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCaculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    @Bean
    public MathCaculator caculator(){
        return new MathCaculator();
    }

    @Bean
    public LogAspects logAspects()
    {
        return new LogAspects();
    }

}
