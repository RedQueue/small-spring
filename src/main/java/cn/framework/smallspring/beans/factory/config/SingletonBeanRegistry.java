package cn.framework.smallspring.beans.factory.config;


//单例注册接口定义
public interface SingletonBeanRegistry {
    //获取单例bean
    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
