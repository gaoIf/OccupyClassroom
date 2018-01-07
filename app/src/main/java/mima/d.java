package mima;

/**
 * Created by Timber on 2018/1/2.
 */

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class d {
    public d() {
    }

    public static String a(String var0, long var1, long var3, int var5) {
        long var10000 = var1;
        int var11 = var5;
        long var7 = var10000;
        new BigInteger("0");
        if(var5 == 0) {
            var11 = 60;
        }

        String var12;
        for(var12 = (new BigInteger("0" + var7)).subtract(new BigInteger("0" + var3)).divide(new BigInteger("0" + var11)).toString(16).toUpperCase(); var12.length() < 16; var12 = "0" + var12) {
            ;
        }

        return a.a(var0, var12, "6");
    }

    public static String a(String key, long cnt) {
        return b.a(key, Long.toHexString(cnt), "6");
    }

    public static String a(String var0) {
        if(var0.indexOf("ll") == -1) {
            return var0;
        } else {
            byte[] var10000;
            byte[] var6;
            if((var0 = var0.substring(2)).length() % 2 != 0) {
                var10000 = null;
            } else {
                int var1;
                byte[] var2 = new byte[var1 = var0.length() / 2];
                var6 = var0.getBytes();

                for(int var3 = 0; var3 < var1; ++var3) {
                    byte var10002 = var6[var3 << 1];
                    byte var5 = var6[(var3 << 1) + 1];
                    byte var4 = var10002;
                    var4 = (byte)(Byte.parseByte(new String(new byte[]{var4}), 16) << 4);
                    var5 = Byte.parseByte(new String(new byte[]{var5}), 16);
                    var2[var3] = (byte)(var4 ^ var5);
                }

                var10000 = var2;
            }

            if((var6 = a(var10000)) != null) {
                byte[] var7 = new byte[var6[0]];
                System.arraycopy(var6, 1, var7, 0, var6[0]);
                return b(var7);
            } else {
                return null;
            }
        }
    }

    private static byte[] a(byte[] var0) {
        byte[] var1 = new byte[]{-126, 35, 18, 68, -104, -85, -4, -46, -23, 101, 82, -11, 77, 108, -29, 17, 118, 9, -73, -52, 29, 84, -89, -32};
        byte[] var2 = new byte[]{-108, -60, -35, 41, 110, -114, 31, 34};

        try {
            SecureRandom var3 = new SecureRandom();
            DESedeKeySpec var6 = new DESedeKeySpec(var1);
            SecretKey var7 = SecretKeyFactory.getInstance("DESede").generateSecret(var6);
            IvParameterSpec var8 = new IvParameterSpec(var2);
            Cipher var4;
            (var4 = Cipher.getInstance("DESede/CBC/NoPadding")).init(2, var7, var8, var3);
            return var4.doFinal(var0);
        } catch (Exception var5) {
            return null;
        }
    }

    private static String b(byte[] var0) {
        StringBuffer var1 = new StringBuffer();

        for(int var2 = 0; var2 < var0.length; ++var2) {
            byte var3 = var0[var2];
            StringBuffer var4;
            (var4 = new StringBuffer()).append("0123456789ABCDEF".charAt(15 & var3 >> 4));
            var4.append("0123456789ABCDEF".charAt(var3 & 15));
            var1.append(var4.toString());
        }

        return var1.toString();
    }
}
