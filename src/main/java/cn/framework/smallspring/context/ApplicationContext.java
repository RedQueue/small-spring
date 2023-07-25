package cn.framework.smallspring.context;

import cn.framework.smallspring.beans.factory.HierarchicalBeanFactory;
import cn.framework.smallspring.beans.factory.ListableBeanFactory;
import cn.framework.smallspring.core.io.ResourceLoader;

// 定义上下文接口
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
