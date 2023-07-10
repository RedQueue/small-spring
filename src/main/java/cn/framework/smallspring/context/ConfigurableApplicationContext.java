package cn.framework.smallspring.context;

import cn.framework.smallspring.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {
    // 刷新容器
    void refresh() throws BeansException;
}
