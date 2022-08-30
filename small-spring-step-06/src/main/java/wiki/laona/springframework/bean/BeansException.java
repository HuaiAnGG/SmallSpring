package wiki.laona.springframework.bean;

/**
 * @author laona
 * @description
 * @date 2022-08-04 15:21
 **/
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
