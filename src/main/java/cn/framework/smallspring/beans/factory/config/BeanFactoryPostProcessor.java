package cn.framework.smallspring.beans.factory.config;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {
    // 在所有的 BeanDefinition 记载后，实例化 Bean 对象之前，提供修改 BeanDefinition 的机制
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
