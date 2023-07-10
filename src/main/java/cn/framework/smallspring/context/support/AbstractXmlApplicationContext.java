package cn.framework.smallspring.context.support;

import cn.framework.smallspring.beans.BeansException;
import cn.framework.smallspring.beans.factory.support.DefaultListableBeanFactory;
import cn.framework.smallspring.beans.factory.xml.XmlBeanDefinitionReader;

//上下文对资源的加载
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            try {
                beanDefinitionReader.loadBeanDefinitions(configLocations);
            } catch (BeansException e) {
                throw new RuntimeException("load BeanDefinition is not ok !");
            }
        }
    }

    //抽象方法：从入口上下文类，获取配置信息的地址描述
    protected abstract String[] getConfigLocations();
}
