package wiki.laona.springframework.test;

import org.junit.jupiter.api.Test;
import wiki.laona.springframework.BeanDefinition;
import wiki.laona.springframework.BeanFactory;
import wiki.laona.springframework.test.bean.UserService;

/**
 * Created by laona
 **/
public class ApiTest {
    /**
     * 用户服务
     */
    final String USER_SERVICE = "userService";

    @Test
    public void test_query_user_info() {
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition(USER_SERVICE, beanDefinition);

        UserService userService = (UserService) beanFactory.getBean(USER_SERVICE);
        userService.queryUserInfo();
    }
}
