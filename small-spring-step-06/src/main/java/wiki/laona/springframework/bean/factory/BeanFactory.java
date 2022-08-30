package wiki.laona.springframework.bean.factory;

import wiki.laona.springframework.bean.BeansException;

/**
 * @author laona
 * @description
 * @date 2022-08-04 15:22
 **/
public interface BeanFactory {

    public Object getBean(String name) throws BeansException;

    public Object getBean(String name, Object[] args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
