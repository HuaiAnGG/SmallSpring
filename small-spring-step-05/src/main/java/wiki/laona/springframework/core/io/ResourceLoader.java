package wiki.laona.springframework.core.io;

/**
 * Created by laona
 **/
public interface ResourceLoader {

    /**
     * Pseudo URL prefix gor loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
