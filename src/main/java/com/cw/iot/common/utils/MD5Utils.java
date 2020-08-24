package com.cw.iot.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lulif
 * @program: iot_manage
 * @create 2020-08-15 15:57
 **/


import java.io.UnsupportedEncodingException;

/**
 * MD5加密工具类
 *
 * @author hezhao
 * @version v01.00.00 $Revision$
 * @date 2015年4月17日
 * @time 下午5:15:50
 */
public class MD5Utils {

    private MD5Utils() {
        // 私用构造主法.因为此类是工具类.
    }

    /**
     * 对字符串自行2次MD5加密MD5(MD5(s))
     *
     * @param s
     * @return
     * @author hezhao
     */
    public final static String md5x2(String s) {
        return md5(md5(s));
    }

    /**
     * MD5加密工具类
     *
     * @param s
     * @return
     * @author hezhao
     */
    public final static String md5(String s) {

        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 使用MD5 对两端加密后的密文进行比较
     *
     * @param strOne 未加密的字符串
     * @param strTwo 已加密的字符串
     * @return boolean
     * @author hezhao
     * @Time 2017年7月31日 下午4:30:11
     */
    public static boolean check(String strOne, String strTwo) {
        if (md5x2(strOne).equals(strTwo))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(md5x2("Even"));
    }
}
