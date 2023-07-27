package cn.framework.smallspring.aop;

/**
 * 切入点
 */
public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
