package cn.framework.smallspring.beans.factory.support;

import cn.framework.smallspring.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(BeanDefinition beanDefinition);
}
