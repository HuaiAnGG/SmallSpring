package wiki.laona.springframework.factory.support;

import wiki.laona.springframework.BeansException;
import wiki.laona.springframework.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laona
 * @description
 * @date 2022-08-04 15:29
 **/
public class DefaultListableBeanFactory extends AbstractAutoWriteCapableBeanFactory implements BeanDefinitionRegistry{

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined!");
        }
        return beanDefinition;
    }

}
