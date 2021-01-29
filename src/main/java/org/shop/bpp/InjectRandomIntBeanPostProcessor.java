package org.shop.bpp;

import org.shop.annotations.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();

        for (Field declaredField : declaredFields) {

            InjectRandomInt annotation = declaredField.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                Random random = new Random();
                int min = annotation.min();
                int max = annotation.max();
                int randomNumber = min + random.nextInt(max - min);
                declaredField.setAccessible(true);
                ReflectionUtils.setField(declaredField, bean, randomNumber);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
