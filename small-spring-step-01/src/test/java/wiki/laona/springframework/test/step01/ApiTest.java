package wiki.laona.springframework.test.step01;

import org.junit.jupiter.api.Test;
import wiki.laona.springframework.BeanDefinition;
import wiki.laona.springframework.BeanFactory;
import wiki.laona.springframework.test.step01.bean.UserService;

/**
 * @author laona
 * @description
 * @date 2022-08-04 11:11
 **/
public class ApiTest {

    @Test
    public void test_beanFactory() {
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注册 bean
        final String USER_SERVICE = "userService";
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition( USER_SERVICE, beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean(USER_SERVICE);
        userService.queryUserInfo();
    }
}
