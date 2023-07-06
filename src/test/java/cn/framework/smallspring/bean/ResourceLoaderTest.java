package cn.framework.smallspring.bean;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.factory.support.DefaultListableBeanFactory;
import cn.framework.smallspring.beans.factory.xml.XmlBeanDefinitionReader;
import cn.framework.smallspring.core.io.DefaultResourceLoader;
import cn.framework.smallspring.core.io.Resource;
import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ResourceLoaderTest {
    private DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties"
        );
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
                InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://www.baidu.com/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() throws BeansException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 读取配置文件&注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3. 获取 Bean 对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        System.out.println("测试结果：");
        userService.queryUserInfo();
    }
}
