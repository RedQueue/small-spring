package cn.framework.smallspring.common;

import cn.framework.smallspring.bean.UserService;
import cn.framework.smallspring.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("我的家在天津");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
