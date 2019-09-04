package com.atguigu.condition;

import com.atguigu.bean.RainBlow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean b = beanDefinitionRegistry.containsBeanDefinition("com.atguigu.bean.Red");
        boolean b2 = beanDefinitionRegistry.containsBeanDefinition("com.atguigu.bean.Blue");
        if (b&&b2){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBlow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainblow",rootBeanDefinition);
        }
    }
}
