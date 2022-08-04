package wiki.laona.springframework.factory.support;

import wiki.laona.springframework.BeansException;
import wiki.laona.springframework.factory.BeanFactory;
import wiki.laona.springframework.factory.config.BeanDefinition;

import java.beans.Beans;

/**
 * @author laona
 * @description
 * @date 2022-08-04 15:28
 **/
public abstract class AbstractBeanFactory  extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
