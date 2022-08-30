package wiki.laona.springframework.test.bean.factory.support;

import wiki.laona.springframework.test.bean.BeansException;
import wiki.laona.springframework.test.bean.factory.config.BeanDefinition;

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
