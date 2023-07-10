package cn.framework.smallspring.beans.factory;

public interface DisposableBean {
    void destroy() throws Exception;
}
