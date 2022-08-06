package wiki.laona.springframework.factory;

import wiki.laona.springframework.BeansException;

import java.beans.Beans;

/**
 * @author laona
 * @description
 * @date 2022-08-04 15:22
 **/
public interface BeanFactory {

    public Object getBean(String name) throws BeansException;

    public Object getBean(String name, Object[] args) throws BeansException;
}
