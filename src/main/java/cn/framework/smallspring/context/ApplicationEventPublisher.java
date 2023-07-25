package cn.framework.smallspring.context;

/**
 * 事件发布接口
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
