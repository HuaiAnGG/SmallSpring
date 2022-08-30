package wiki.laona.springframework.test.common;

import wiki.laona.springframework.bean.BeansException;
import wiki.laona.springframework.bean.PropertyValue;
import wiki.laona.springframework.bean.PropertyValues;
import wiki.laona.springframework.bean.factory.ConfigurableListableBeanFactory;
import wiki.laona.springframework.bean.factory.config.BeanDefinition;
import wiki.laona.springframework.bean.factory.config.BeanFactoryPostProcessor;

/**
 * Created by laona
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
