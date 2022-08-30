package wiki.laona.springframework.test.bean.factory.config;

import wiki.laona.springframework.test.bean.factory.HierarchicalBeanFactory;

/**
 * Created by laona
 **/
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
