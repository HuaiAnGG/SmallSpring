package wiki.laona.springframework.factory;

import wiki.laona.springframework.BeansException;
import wiki.laona.springframework.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author laona
 * @description
 * @date 2022-08-04 15:22
 **/
public interface BeanFactory {

    public Object getBean(String name) throws BeansException;
}
