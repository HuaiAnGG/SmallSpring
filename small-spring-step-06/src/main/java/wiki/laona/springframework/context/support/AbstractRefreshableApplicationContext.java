package wiki.laona.springframework.context.support;

import wiki.laona.springframework.bean.BeansException;
import wiki.laona.springframework.bean.factory.ConfigurableListableBeanFactory;
import wiki.laona.springframework.bean.factory.support.DefaultListableBeanFactory;

/**
 * Created by laona
 **/
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
