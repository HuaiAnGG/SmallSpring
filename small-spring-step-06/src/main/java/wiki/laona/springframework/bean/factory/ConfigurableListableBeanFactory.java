package wiki.laona.springframework.bean.factory;

import wiki.laona.springframework.bean.BeansException;
import wiki.laona.springframework.bean.factory.config.AutowireCapableBeanFactory;
import wiki.laona.springframework.bean.factory.config.BeanDefinition;
import wiki.laona.springframework.bean.factory.config.BeanPostProcessor;
import wiki.laona.springframework.bean.factory.config.ConfigurableBeanFactory;

/**
 * Created by laona
 **/
public interface ConfigurableListableBeanFactory
        extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
