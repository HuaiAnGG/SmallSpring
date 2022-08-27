package wiki.laona.springframework.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.jupiter.api.Test;
import wiki.laona.springframework.PropertyValue;
import wiki.laona.springframework.PropertyValues;
import wiki.laona.springframework.factory.config.BeanDefinition;
import wiki.laona.springframework.factory.config.BeanReference;
import wiki.laona.springframework.factory.support.DefaultListableBeanFactory;
import wiki.laona.springframework.test.bean.UserDao;
import wiki.laona.springframework.test.bean.UserService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
