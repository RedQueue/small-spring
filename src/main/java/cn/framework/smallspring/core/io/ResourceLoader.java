package cn.framework.smallspring.core.io;

//定义获取资源接口
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
