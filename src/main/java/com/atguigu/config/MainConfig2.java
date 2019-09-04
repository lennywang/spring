package com.atguigu.config;

import com.atguigu.bean.Color;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.atguigu.condition.MyImportSelector;
import com.atguigu.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 *
 **/

@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    @Lazy
    //@Scope("prototype")
    @Bean
    public Person person()
    {
        System.out.println("给容器中添加Person 。。。");
        return  new Person("张三",25);
    }

    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01()
    {
        return new Person("Bill Gates",62);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linux")
    public Person person02()
    {
        return new Person("linux",48);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean()
    {
        return new ColorFactoryBean();
    }
}
