package cn.framework.smallspring.beans.factory.support;

import cn.framework.smallspring.core.io.DefaultResourceLoader;
import cn.framework.smallspring.core.io.ResourceLoader;

/**
 * 抽象类实现了getRegistry和getResourceLoader接口，避免污染接口功能
 * 这两个是为了服务后面三个loadBeanDefinitions
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
