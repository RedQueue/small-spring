package cn.framework.smallspring.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("100", "yy");
        map.put("101", "qq");
        map.put("102", "ww");
    }

    public String queryUserName(String uId) {
        return map.get(uId);
    }
}
