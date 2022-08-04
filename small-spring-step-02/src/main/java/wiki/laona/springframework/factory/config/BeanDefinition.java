package wiki.laona.springframework.factory.config;

/**
 * @author laona
 * @description
 * @date 2022-08-04 15:22
 **/
public class BeanDefinition {


    private Class beanClass;

    public BeanDefinition() {
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

}
