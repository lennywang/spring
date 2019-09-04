package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

/**
 *
 **/
@Configuration

@ComponentScans(value = {
        @ComponentScan(value = "com.atguigu",includeFilters = {
                @Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
                @Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        },useDefaultFilters = false)
})
public class MainConfig {

    @Bean(name="person")
    public Person person1(){
        return new Person("lisi",20);
    }



}
