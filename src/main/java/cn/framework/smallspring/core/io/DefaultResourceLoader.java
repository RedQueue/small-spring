package cn.framework.smallspring.core.io;

import org.springframework.util.Assert;

import java.net.MalformedURLException;
import java.net.URL;

//获取资源实现类
public class DefaultResourceLoader implements ResourceLoader{

    //设计模式的体现，只关心返回结果，对细节进行封装
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must be not null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
