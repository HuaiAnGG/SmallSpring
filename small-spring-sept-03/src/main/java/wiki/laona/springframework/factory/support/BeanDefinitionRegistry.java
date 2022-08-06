package wiki.laona.springframework.factory.support;

import wiki.laona.springframework.factory.config.BeanDefinition;

/**
 * @author laona
 * @description
 * @date 2022-08-04 15:30
 **/
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
