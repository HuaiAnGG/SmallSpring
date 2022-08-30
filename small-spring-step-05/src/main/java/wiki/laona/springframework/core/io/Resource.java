package wiki.laona.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by laona
 **/
public interface Resource {

    InputStream getInputStream() throws IOException;
}
