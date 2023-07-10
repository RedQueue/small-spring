package cn.framework.smallspring.beans.factory.support;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.factory.DisposableBean;
import cn.framework.smallspring.beans.factory.config.SingletonBeanRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//单例注册接口实现
public class DefaultSingletonBeanRegister implements SingletonBeanRegister {
    private Map<String, Object> singletonObjects = new HashMap<>();
    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    //受保护的方法，可以被继承此类的子类调用
    protected void addSingleton(String beanName, Object singleton) {
        singletonObjects.put(beanName, singleton);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    @Override
    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();
        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new RuntimeException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}

//Set<String> keySet = this.disposableBeans.keySet();
//        Object[] disposableBeanNames = keySet.toArray();
//
//        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
//            Object beanName = disposableBeanNames[i];
//            DisposableBean disposableBean = disposableBeans.remove(beanName);
//            try {
//                disposableBean.destroy();
//            } catch (Exception e) {
//                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
//            }
//        }