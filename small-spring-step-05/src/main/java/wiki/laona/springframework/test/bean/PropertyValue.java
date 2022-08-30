package wiki.laona.springframework.test.bean;

/**
 * Created by laona
 **/
public class PropertyValue {
    private String name;
    private Object value;

    public PropertyValue() {
    }

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
