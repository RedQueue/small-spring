package cn.framework.smallspring.beans.factory;

import cn.framework.smallspring.beans.BeansException;

public interface BeanFactory {
    //类
    Object getBean(String name) throws BeansException;

    //构造器入参
    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
