package cn.framework.smallspring.core.io;

import java.io.*;
import java.util.ArrayList;

//通过指定路径获取文件信息
public class FileSystemResource implements Resource {
    private final String path;
    private final File file;

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.path = file.getPath();
        this.file = file;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        ArrayList<Integer> aa = new ArrayList<>();
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return this.path;
    }
}
