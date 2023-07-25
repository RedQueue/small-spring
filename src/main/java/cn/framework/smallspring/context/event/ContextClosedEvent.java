package cn.framework.smallspring.context.event;

import cn.framework.smallspring.context.ApplicationEvent;

/**
 * 监听关闭事件
 */
public class ContextClosedEvent extends ApplicationEvent {

    public ContextClosedEvent(Object source) {
        super(source);
    }
}
