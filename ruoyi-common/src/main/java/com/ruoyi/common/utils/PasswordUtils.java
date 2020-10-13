package com.ruoyi.common.utils;

/**
 * @date 2020/10/4 -- 12:20
 **/
public class PasswordUtils {
    /**
     * 校验密码是否合规
     * @param password 未加密的密码
     * @param qualifiedNum 需要符合规则的次数
     * @return
     */
    public static Boolean checkPassword(String password,int qualifiedNum){
        Boolean isQualified= false;
        int result=0;
        result+=containsNum(password);
        result+=containsLowerCase(password);
        result+=containsUpperCase(password);
        result+=containsSpecialChar(password);

        if (result>=qualifiedNum){
            isQualified=true;
        }
        return isQualified;
    }

    private static int containsSpecialChar(String password) {
        if (password.matches(".*[^A-Za-z0-9_].*")){
            return 1;
        }
        return 0;
    }

    private static int containsUpperCase(String password) {
        if (password.matches(".*[A-Z].*")){
            return 1;
        }
        return 0;
    }

    private static int containsLowerCase(String password) {
        if (password.matches(".*[a-z]{1,}.*")){
            return 1;
        }
        return 0;
    }

    private static int containsNum(String password) {
        if (password.matches(".*[0-9]{1,}.*")){
           return 1;
        }
        return 0;
    }
}
