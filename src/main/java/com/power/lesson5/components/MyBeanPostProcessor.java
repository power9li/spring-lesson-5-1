package com.power.lesson5.components;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by shenli on 2017/1/23.
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        Class<?>[] interfaces = bean.getClass().getInterfaces();
        if(declaredFields.length > 4 || interfaces.length > 2){
            System.out.println("warning "+beanName+" has "+declaredFields.length+" properties, implements "+interfaces.length+" interface");
            for (Field field : declaredFields) {
                System.out.println("\t property " + field.getName() + " type " + field.getGenericType());
            }
            for (Class<?> clazz : interfaces) {
                System.out.println("\t interface " + clazz);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
