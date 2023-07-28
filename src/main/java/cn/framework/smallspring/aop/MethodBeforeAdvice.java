package cn.framework.smallspring.aop;

import java.lang.reflect.Method;

public interface MethodBeforeAdvice extends BeforeAdvice {
    /**
     * 调用给定方法之前的回调
     */
    void before(Method method, Object[] args, Object target) throws Throwable;
}
