package wiki.laona.springframework;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author laona
 * @description
 * @date 2022-08-04 10:46
 **/
public class BeanFactory {

    private final Map<String, BeanDefinition> beanMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition){
        if (beanMap.containsKey(name)) {
            throw new RuntimeException("当前 Bean 已经存在");
        }
        beanMap.put(name, beanDefinition);
    }
}
