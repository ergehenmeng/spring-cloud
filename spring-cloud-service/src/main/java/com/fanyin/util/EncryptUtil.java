package com.fanyin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 日常加解密工具类
 * @author fanyin
 * @create 2017-06-29 17:24
 */
public class EncryptUtil {

    public static String md5(String str){
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            byte[] resultByte = digest.digest();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < resultByte.length; i++) {
                int by = (int)resultByte[i];
                by = by < 0 ? 0x100 + by : by;
                String hex = Integer.toHexString(by);
                if(hex.length() == 1 ){
                    buffer.append("0");
                }else {
                    buffer.append(hex);
                }
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(md5("123456"));
    }
}
