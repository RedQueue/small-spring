package cn.framework.smallspring.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> map = new HashMap<>();

    public void initDataMethod(){
        System.out.println("执行：init-method");
        map.put("100", "yy");
        map.put("101", "qq");
        map.put("102", "ww");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        map.clear();
    }

    public String queryUserName(String uId) {
        return map.get(uId);
    }
}
