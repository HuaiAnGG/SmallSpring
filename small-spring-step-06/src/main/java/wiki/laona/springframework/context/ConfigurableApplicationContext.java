package wiki.laona.springframework.context;

import wiki.laona.springframework.bean.BeansException;

/**
 * Created by laona
 **/
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
