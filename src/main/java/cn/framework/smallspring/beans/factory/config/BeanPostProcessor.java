package cn.framework.smallspring.beans.factory.config;

import cn.framework.smallspring.beans.BeansException;

public interface BeanPostProcessor {
    // 在 Bean 对象执行初始化方法之前，执行此方法
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    // 在 Bean 对象执行初始化方法之后，执行此方法
    Object postProcessAfterInitialization(Object bean, String beanName);
}
