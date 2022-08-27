package wiki.laona.springframework.test.bean;

/**
 * @author laona
 * @description
 * @date 2022-08-04 16:59
 **/
public class UserService {

    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
