package wiki.laona.springframework.test.bean.factory;

import wiki.laona.springframework.test.bean.BeansException;
import wiki.laona.springframework.test.bean.factory.config.AutowireCapableBeanFactory;
import wiki.laona.springframework.test.bean.factory.config.BeanDefinition;
import wiki.laona.springframework.test.bean.factory.config.ConfigurableBeanFactory;

/**
 * Created by laona
 **/
public interface ConfigurableListableBeanFactory
        extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
