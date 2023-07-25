package cn.framework.smallspring.context;

import java.util.EventListener;

public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    // Handle an application event
    void onApplicationEvent(E event);
}
