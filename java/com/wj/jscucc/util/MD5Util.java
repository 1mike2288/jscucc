package com.wj.jscucc.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

//MD5 ,密码加密
public class MD5Util {

    public static void main(String[] args) {
        System.out.println(md5("123456"));
    }

    public static String md5(String str) {
        String pwd ="";
        try {
            MessageDigest md =
                    MessageDigest.getInstance("MD5");
            //MD5.不能直接对字符串加密，
            //必须先转成字节数组，才能加密
            byte[] input = str.getBytes();
            //digest(input)，MD加密方法
            byte[] output = md.digest(input);
            //将output转成 字符串，采用Base64算法
            pwd = Base64.encodeBase64String(output);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pwd;
    }
}
