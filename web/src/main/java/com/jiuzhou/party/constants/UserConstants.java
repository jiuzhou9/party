package com.jiuzhou.party.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjiuzhou (jiuzhou@shanshu.ai)
 * @date 2019/06/29
 */
public class UserConstants {

    private static Map<String, String[]> users;
    //username password
    private static String[] jialebihaidai = {"加勒比海带", "12345"};
    private static String[] jiuzhou = {"九州", "12345"};
    private static String[] bochong = {"薄冲", "12345"};

    static {
        users = new HashMap<>();
        users.put("加勒比海带", jialebihaidai);
        users.put("九州", jiuzhou);
        users.put("薄冲", bochong);
    }

    public static boolean login(String username, String password){
        String[] strings = users.get(username);
        if (strings != null && strings.length != 0 && strings[1].equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
