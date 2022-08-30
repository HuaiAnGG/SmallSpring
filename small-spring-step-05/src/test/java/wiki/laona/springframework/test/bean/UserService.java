package wiki.laona.springframework.test.bean;

/**
 * @author laona
 * @description
 * @date 2022-08-04 16:59
 **/
public class UserService {

    private String uId;
    private UserDao userDao;

    public String queryUserInfo() {
        String userInfo = userDao.queryUserName(uId);
        System.out.println("查询到的用户信息: " + userInfo);
        return userInfo;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
