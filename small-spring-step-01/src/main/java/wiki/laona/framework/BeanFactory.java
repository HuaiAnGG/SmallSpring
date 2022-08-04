package wiki.laona.framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by laona
 **/
public class BeanFactory {

    private final Map<String, BeanDefinition> objectMap = new ConcurrentHashMap<>();

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition){
        objectMap.put(beanName, beanDefinition);
    }

    public Object getBean(String beanName) {
        return this.objectMap.get(beanName).getBean();
    }
}
