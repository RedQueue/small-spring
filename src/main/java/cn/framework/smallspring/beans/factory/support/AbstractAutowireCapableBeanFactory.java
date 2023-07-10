package cn.framework.smallspring.beans.factory.support;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.PropertyValue;
import cn.framework.smallspring.beans.PropertyValues;
import cn.framework.smallspring.beans.factory.config.AutowireCapableBeanFactory;
import cn.framework.smallspring.beans.factory.config.BeanDefinition;
import cn.framework.smallspring.beans.factory.config.BeanPostProcessor;
import cn.framework.smallspring.beans.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Constructor;

//实例化bean类
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            //bean实例化
            bean = createBeanInstance(beanDefinition, beanName, args);
            //给bean填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            //执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws BeansException {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();//获取到所有的构造函数

        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        //jdk或者cglib实例化
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * Bean属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) throws BeansException {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    //A依赖B,获取B的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                //属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) throws BeansException {
        // 1.执行 BeanPostProcessor 前置处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        // 2.执行 Bean 初始化方法
        invokeInitMethods(beanName, wrappedBean, beanDefinition);
        // 3.执行 BeanPostProcessor 后置处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }
}

//private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
//        // 1. 执行 BeanPostProcessor Before 处理
//        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
//
//        // 待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
//        invokeInitMethods(beanName, wrappedBean, beanDefinition);
//
//        // 2. 执行 BeanPostProcessor After 处理
//        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
//        return wrappedBean;
//    }
//
//    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {
//
//    }
//
//    @Override
//    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
//        Object result = existingBean;
//        for (BeanPostProcessor processor : getBeanPostProcessors()) {
//            Object current = processor.postProcessBeforeInitialization(result, beanName);
//            if (null == current) return result;
//            result = current;
//        }
//        return result;
//    }
//
//    @Override
//    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
//        Object result = existingBean;
//        for (BeanPostProcessor processor : getBeanPostProcessors()) {
//            Object current = processor.postProcessAfterInitialization(result, beanName);
//            if (null == current) return result;
//            result = current;
//        }
//        return result;
//    }