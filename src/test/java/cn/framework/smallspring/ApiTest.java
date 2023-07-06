package cn.framework.smallspring;

import cn.framework.smallspring.bean.UserService;
import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.factory.config.BeanDefinition;
import cn.framework.smallspring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

public class ApiTest {
    @Test
    public void test_BeanFactory() throws BeansException {
        //1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //3.第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        //4.第二次获取bean
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();

        //5.第一次获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService", "笑话");
//        userService.queryUserInfo();
//
//        //6.第二次获取bean
//        UserService userService_singleton = (UserService) beanFactory.getBean("userService", "笑话111");
//        userService_singleton.queryUserInfo();
    }
}
