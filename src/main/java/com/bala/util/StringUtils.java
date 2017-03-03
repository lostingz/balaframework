/**
 * Chsi
 * Created on 2017年03月03日
 */
package com.bala.util;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class StringUtils {
    public static boolean equalAny(String theStr, String... others) {
        if(others == null) {
            return theStr == null;
        } else {
            String[] var2 = others;
            int var3 = others.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String s = var2[var4];
                if(org.apache.commons.lang3.StringUtils.equals(theStr, s)) {
                    return true;
                }
            }
            return false;
        }
    }
}
