package cn.framework.smallspring.beans.factory;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.factory.config.AutowireCapableBeanFactory;
import cn.framework.smallspring.beans.factory.config.BeanDefinition;
import cn.framework.smallspring.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
