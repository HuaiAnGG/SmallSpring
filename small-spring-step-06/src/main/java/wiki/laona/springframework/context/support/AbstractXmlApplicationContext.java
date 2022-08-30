package wiki.laona.springframework.context.support;

import wiki.laona.springframework.bean.factory.support.DefaultListableBeanFactory;
import wiki.laona.springframework.bean.factory.xml.XmlBeanDefinitionReader;

/**
 * Created by laona
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
