package wiki.laona.springframework.test;

import org.junit.jupiter.api.Test;
import wiki.laona.springframework.factory.config.BeanDefinition;
import wiki.laona.springframework.factory.support.DefaultListableBeanFactory;
import wiki.laona.springframework.test.bean.UserService;

/**
 * @author laona
 * @description
 * @date 2022-08-04 17:00
 **/
public class ApiTest {


    @Test
    public void test_bean_factory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        final String USER_SERVICE = "userService";
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition(USER_SERVICE, beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean(USER_SERVICE);
        userService.queryUserInfo();

        // 4. 第二次获取 bean form Singleton
        UserService userService4Singleton = (UserService) beanFactory.getBean(USER_SERVICE);
        userService4Singleton.queryUserInfo();
    }
}
