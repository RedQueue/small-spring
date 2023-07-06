package cn.framework.smallspring.beans.factory.support;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

//实例化策略接口
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName,
                       Constructor ctor, Object[] args) throws BeansException;
}
