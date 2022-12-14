package wiki.laona.springframework.test;

import org.junit.jupiter.api.Test;
import wiki.laona.springframework.test.bean.UserService;
import wiki.laona.springframework.bean.factory.support.DefaultListableBeanFactory;
import wiki.laona.springframework.bean.factory.xml.XmlBeanDefinitionReader;

/**
 * @author laona
 * @description
 **/
public class ApiTest {


    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
