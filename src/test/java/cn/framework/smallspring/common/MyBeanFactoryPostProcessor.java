package cn.framework.smallspring.common;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.PropertyValue;
import cn.framework.smallspring.beans.PropertyValues;
import cn.framework.smallspring.beans.factory.ConfigurableListableBeanFactory;
import cn.framework.smallspring.beans.factory.config.BeanDefinition;
import cn.framework.smallspring.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "字节跳动"));
    }
}
