package com.github.dolphineor.springboot.support;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created on 2016-01-06.
 *
 * @author dolphineor
 */
public class MD5Helper {

    public static String getMD5(String source, Object salt) {
        return generateMD5(source + "{" + salt.toString() + "}");
    }

    private static String generateMD5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuilder buf = new StringBuilder("");
            for (byte aB : b) {
                i = aB;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
