package cn.framework.smallspring.beans.factory.config;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName);
}
