package com.zyz.seckill.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";
//第一次MD5

    public static String inputPassFormPass(String inputpass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputpass + salt.charAt(5) + salt.charAt(4);
  //      String str1 = salt.charAt(0) + salt.charAt(2) + inputpass + salt.charAt(5) + salt.charAt(4);
  //     System.out.println(str);
  //     System.out.println(str1);
        return md5(str);

    }

    public static String formPassFormPass(String fromPass, String salt) {
        String str ="" + salt.charAt(0) + salt.charAt(2) + fromPass + salt.charAt(5) + salt.charAt(4);

        return md5(str);

    }
    public static String inputPassToDbPass(String input, String saltDB) {
       String formPass =  inputPassFormPass(input);
        String dbPass = formPassFormPass(formPass, saltDB);
        return dbPass;
    }

    public static void main(String[] args) {
//        System.out.println(inputPassFormPass("123456"));//12 123456 c3
//        System.out.println(salt);
//        System.out.println();
//        System.out.println(formPassFormPass(inputPassFormPass("123456"), "1a2b3c4d"));
        System.out.println(inputPassToDbPass("123456","1a2b3c4d"));
    }
}
