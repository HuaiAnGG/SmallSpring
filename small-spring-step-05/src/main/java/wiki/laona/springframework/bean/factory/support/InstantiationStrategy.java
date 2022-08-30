package wiki.laona.springframework.bean.factory.support;

import wiki.laona.springframework.bean.BeansException;
import wiki.laona.springframework.bean.factory.config.BeanDefinition;

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
