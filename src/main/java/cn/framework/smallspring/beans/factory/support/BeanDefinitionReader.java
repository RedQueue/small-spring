package cn.framework.smallspring.beans.factory.support;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.core.io.Resource;
import cn.framework.smallspring.core.io.ResourceLoader;

//对资源的具体使用，将配置信息注册到spring容器中
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
