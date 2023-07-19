package cn.framework.smallspring.context;

import cn.framework.smallspring.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {
    // 刷新容器
    void refresh() throws BeansException;

    //钩子函数：优雅关闭容器
    void registerShutdownHook();

    void close();
}
