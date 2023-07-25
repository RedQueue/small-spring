package cn.framework.smallspring.context.event;

import cn.framework.smallspring.beans.factory.BeanFactory;
import cn.framework.smallspring.context.ApplicationEvent;
import cn.framework.smallspring.context.ApplicationListener;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
