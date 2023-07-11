package cn.framework.smallspring.context;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.factory.Aware;

/**
 * 实现此接口，既能感知到所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
