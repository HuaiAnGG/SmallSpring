package wiki.laona.springframework.factory.support;

import wiki.laona.springframework.BeansException;
import wiki.laona.springframework.factory.BeanFactory;
import wiki.laona.springframework.factory.config.BeanDefinition;

/**
 * @author laona
 * @description
 * @date 2022-08-04 15:28
 **/
public abstract class AbstractBeanFactory  extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
       return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
