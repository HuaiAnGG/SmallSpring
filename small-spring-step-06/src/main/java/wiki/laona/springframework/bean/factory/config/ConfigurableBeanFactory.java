package wiki.laona.springframework.bean.factory.config;

import wiki.laona.springframework.bean.factory.HierarchicalBeanFactory;

/**
 * Created by laona
 **/
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
