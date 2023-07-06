package cn.framework.smallspring.beans.factory.support;

import cn.framework.smallspring.beans.factory.config.SingletonBeanRegister;

import java.util.HashMap;
import java.util.Map;

//单例注册接口实现
public class DefaultSingletonBeanRegister implements SingletonBeanRegister {
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    //受保护的方法，可以被继承此类的子类调用
    protected void addSingleton(String beanName, Object singleton) {
        singletonObjects.put(beanName, singleton);
    }
}
