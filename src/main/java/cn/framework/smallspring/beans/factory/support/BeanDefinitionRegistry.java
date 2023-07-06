package cn.framework.smallspring.beans.factory.support;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    //向注册表中注册BeanDefinition
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    //判断是否包含指定名称的BeanDefinition
    boolean containsBeanDefinition(String beanName);

    //返回注册表中所有的Bean名称
    String[] getBeanDefinitionNames();
}
