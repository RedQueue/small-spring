package cn.framework.smallspring.beans.factory.config;


import cn.framework.smallspring.beans.BeansException;

//单例注册接口定义
public interface SingletonBeanRegister {
    //获取单例bean
    Object getSingleton(String beanName);

    //销毁单例对象
    void destroySingletons() throws BeansException;
}
