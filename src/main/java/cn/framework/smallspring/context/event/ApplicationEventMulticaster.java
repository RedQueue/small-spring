package cn.framework.smallspring.context.event;

import cn.framework.smallspring.context.ApplicationEvent;
import cn.framework.smallspring.context.ApplicationListener;

/**
 * 事件广播器
 */
public interface ApplicationEventMulticaster {
    //添加监听器
    void addApplicationListener(ApplicationListener<?> listener);
    //删除监听器
    void removeApplicationListener(ApplicationListener<?> listener);
    //广播事件
    void multicastEvent(ApplicationEvent event);
}
