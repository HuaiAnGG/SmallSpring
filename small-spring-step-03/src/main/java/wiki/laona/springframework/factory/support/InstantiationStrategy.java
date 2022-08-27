package wiki.laona.springframework.factory.support;

import wiki.laona.springframework.BeansException;
import wiki.laona.springframework.factory.config.BeanDefinition;

import java.beans.Beans;
import java.lang.reflect.Constructor;

/**
 * Created by laona
 **/
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition,
                       String beanName,
                       Constructor ctor,
                       Object[] args) throws BeansException;
}
