package wiki.laona.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by laona
 **/
public class UserDao {
    private static final Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "老衲");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}