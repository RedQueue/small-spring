package cn.framework.smallspring.bean;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.PropertyValue;
import cn.framework.smallspring.beans.PropertyValues;
import cn.framework.smallspring.beans.factory.config.BeanDefinition;
import cn.framework.smallspring.beans.factory.config.BeanReference;
import cn.framework.smallspring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

public class populationBeanTest {
    @Test
    public void test_BeanFactory() throws BeansException {
        //1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.注册bean UserDao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //3.UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "100"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        //4.UserService 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService1.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //5.UserService 获取 bean
        UserService1 userService = (UserService1) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
