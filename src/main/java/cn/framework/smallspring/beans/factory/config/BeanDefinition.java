package cn.framework.smallspring.beans.factory.config;

import cn.framework.smallspring.beans.PropertyValues;

// 定义bean实例化信息
public class BeanDefinition {
    private Class beanClass; //存放bean对象

    private PropertyValues propertyValues; //属性集合

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
