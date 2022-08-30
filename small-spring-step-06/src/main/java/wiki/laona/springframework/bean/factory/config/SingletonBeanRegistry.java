package wiki.laona.springframework.bean.factory.config;

/**
 * @author laona
 * @description 单例注册表
 * @date 2022-08-04 15:23
 **/
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
