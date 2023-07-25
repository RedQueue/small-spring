package cn.framework.smallspring.event;

import cn.framework.smallspring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

public class EventTest {
    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }
}
