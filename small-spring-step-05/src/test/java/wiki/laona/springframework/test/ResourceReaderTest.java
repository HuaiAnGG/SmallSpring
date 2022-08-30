package wiki.laona.springframework.test;

import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import wiki.laona.springframework.core.io.DefaultResourceLoader;
import wiki.laona.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by laona
 **/
public class ResourceReaderTest {

    private static DefaultResourceLoader resourceLoader;

    @BeforeAll
    public static void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource propertyResource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = propertyResource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource propertyResource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = propertyResource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() throws IOException {
        // 网络原因可能导致GitHub不能读取，可以放到自己的Gitee仓库。读取后可以从内容中搜索关键字；OLpj9823dZ
        Resource propertyResource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = propertyResource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}
