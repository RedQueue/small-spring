package cn.framework.smallspring.bean;

public class UserService {
    private String name;

    public UserService() {}

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println(name + "查询用户信息");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("").append(name);
        return sb.toString();
    }
}
