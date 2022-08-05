package wiki.laona.springframework;

/**
 * @author laona
 * @date 2022-08-04 10:46
 **/
public class BeanDefinition {

    private Object bean;

    public BeanDefinition() {
    }

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
