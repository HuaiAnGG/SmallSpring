package wiki.laona.springframework.test.common;

import wiki.laona.springframework.bean.BeansException;
import wiki.laona.springframework.bean.factory.config.BeanPostProcessor;
import wiki.laona.springframework.test.bean.UserService;

/**
 * Created by laona
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
