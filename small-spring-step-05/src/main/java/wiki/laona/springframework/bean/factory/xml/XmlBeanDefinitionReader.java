package wiki.laona.springframework.bean.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import wiki.laona.springframework.bean.BeansException;
import wiki.laona.springframework.bean.PropertyValue;
import wiki.laona.springframework.bean.factory.config.BeanDefinition;
import wiki.laona.springframework.bean.factory.config.BeanReference;
import wiki.laona.springframework.bean.factory.support.AbstractBeanDefinitionReader;
import wiki.laona.springframework.bean.factory.support.BeanDefinitionRegistry;
import wiki.laona.springframework.core.io.Resource;
import wiki.laona.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by laona
 **/
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()){
                doLoadBeanDefinitions(inputStream);
            }
        }catch (IOException | ClassNotFoundException ex) {
            throw new BeansException("IOException parsing XML document from " + resource, ex);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }


    private void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {

        final String beanNodeName = "bean";
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {

            // 判断元素
            if (!((childNodes.item(i)) instanceof Element)) {
                continue;
            }
            // 判断对象
            if (!beanNodeName.equals(childNodes.item(i).getNodeName())) {
                continue;
            }

            // 判断标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            // 获取Class，方便取类中的名称
            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                String simpleName = clazz.getSimpleName();
                beanName = StrUtil.lowerFirst(simpleName);
            }

            // 定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            // 读取属性并填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!((bean.getChildNodes().item(j)) instanceof Element)) {
                    continue;
                }
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }
                // 解析标签: property
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性值
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }

            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 beanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
