package cn.framework.smallspring.context.event;

import cn.framework.smallspring.context.ApplicationEvent;

/**
 * 监听刷新事件
 */
public class ContextRefreshedEvent extends ApplicationEvent {

    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
