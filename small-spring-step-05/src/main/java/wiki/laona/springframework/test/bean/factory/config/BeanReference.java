package wiki.laona.springframework.test.bean.factory.config;

/**
 * Created by laona
 **/
public class BeanReference {
    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
