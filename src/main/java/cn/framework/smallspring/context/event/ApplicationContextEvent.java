package cn.framework.smallspring.context.event;

import cn.framework.smallspring.context.ApplicationContext;
import cn.framework.smallspring.context.ApplicationEvent;

public class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
