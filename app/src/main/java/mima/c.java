package mima;

/**
 * Created by Timber on 2018/1/2.
 */

import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class c {
    private static int[] a = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

    protected c() {
    }

    private static byte[] a(String var0, byte[] var1, byte[] var2) {
        try {
            Mac var4 = Mac.getInstance(var0);
            SecretKeySpec var5 = new SecretKeySpec(var1, "RAW");
            var4.init(var5);
            return var4.doFinal(var2);
        } catch (GeneralSecurityException var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    private static byte[] a(String bArray) {
        byte[] var3;
        byte[] ret = new byte[(var3 = (new BigInteger("10" + bArray, 16)).toByteArray()).length - 1];

        for(int i = 0; i < ret.length; ++i) {
            ret[i] = var3[i + 1];
        }

        return ret;
    }

    protected static String a(String var0, String var1, String var2, String var3) {
        int var8 = Integer.decode(var2).intValue();
        byte[] var4 = new byte[8];
        byte[] var7;
        if(var1.length() > 0) {
            int var5;
            if((var7 = (new BigInteger(var1, 16)).toByteArray()).length == 9) {
                for(var5 = 0; var5 < 8 && var5 < var7.length; ++var5) {
                    var4[var5 + 8 - var7.length] = var7[var5 + 1];
                }
            } else {
                for(var5 = 0; var5 < 8 && var5 < var7.length; ++var5) {
                    var4[var5 + 8 - var7.length] = var7[var5];
                }
            }
        }

        var7 = a(var0);
        byte[] var9;
        int var6 = (var9 = a(var3, var7, var4))[var9.length - 1] & 15;

        for(var0 = Integer.toString(((var9[var6] & 127) << 24 | (var9[var6 + 1] & 255) << 16 | (var9[var6 + 2] & 255) << 8 | var9[var6 + 3] & 255) % a[var8]); var0.length() < var8; var0 = "0" + var0) {
            ;
        }

        return var0;
    }
}