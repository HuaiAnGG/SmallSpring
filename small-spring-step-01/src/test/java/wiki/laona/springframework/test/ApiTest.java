package wiki.laona.springframework.test;

import org.junit.jupiter.api.Test;
import wiki.laona.framework.BeanDefinition;
import wiki.laona.framework.BeanFactory;
import wiki.laona.springframework.test.bean.UserService;

/**
 * Created by laona
 **/
public class ApiTest {

    @Test
    public void test_query_user_info() {
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        final String USER_SERVICE = "userService";
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition(USER_SERVICE, beanDefinition);

        UserService userService = (UserService) beanFactory.getBean(USER_SERVICE);
        userService.queryUserInfo();
    }
}
