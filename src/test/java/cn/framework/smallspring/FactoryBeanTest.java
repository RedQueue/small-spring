package cn.framework.smallspring;

import cn.framework.smallspring.bean.NewUserService;
import cn.framework.smallspring.bean.UserService;
import cn.framework.smallspring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class FactoryBeanTest {
    //单例&原型
    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        NewUserService userService01 = applicationContext.getBean("newUserService", NewUserService.class);
        NewUserService userService02 = applicationContext.getBean("newUserService", NewUserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        NewUserService newUserService = applicationContext.getBean("newUserService", NewUserService.class);
        System.out.println("测试结果：" + newUserService.queryUserInfo());
    }
}
