package cn.framework.smallspring.beans.factory.config;


//单例注册接口定义
public interface SingletonBeanRegister {
    //获取单例bean
    Object getSingleton(String beanName);
}
