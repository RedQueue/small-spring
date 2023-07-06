package cn.framework.smallspring.core.io;

import java.io.IOException;
import java.io.InputStream;

//获取InputStream流
public interface Resource {
    InputStream getInputStream() throws IOException;
}
