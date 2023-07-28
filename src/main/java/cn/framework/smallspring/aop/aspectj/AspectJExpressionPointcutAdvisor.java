package cn.framework.smallspring.aop.aspectj;

import cn.framework.smallspring.aop.Pointcut;
import cn.framework.smallspring.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * 把切面，拦截方法和表达式包装到一起
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    //切面
    private AspectJExpressionPointcut pointcut;
    //具体的拦截方法
    private Advice advice;
    //表达式
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
