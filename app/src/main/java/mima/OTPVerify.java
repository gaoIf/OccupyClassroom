package mima;

/**
 * Created by Timber on 2018/1/2.
 */

import java.util.HashMap;
import java.util.Map;

public class OTPVerify {
    public static final long OTP_SUCCESS = 0L;
    public static final long OTP_ERR_INVALID_PARAMETER = 1L;
    public static final long OTP_ERR_CHECK_PWD = 2L;
    public static final long OTP_ERR_SYN_PWD = 3L;
    public static final long OTP_ERR_REPLAY = 4L;

    public OTPVerify() {
    }

    public static Map ITSecurity_CheckPwd(String var0, long var1, long var3, String var5) {
        HashMap var6 = new HashMap();
        if(var0 != null && var5 != null) {
            int var7;
            for(var7 = 0; (long)var7 < var3; ++var7) {
                String var8 = d.a(var0, var1);
                ++var1;
                if(var8.equalsIgnoreCase(var5)) {
                    break;
                }
            }

            if((long)var7 == var3) {
                var6.put("returnCode", new Long(2L));
                var6.put("currentAuthNum", new Long(0L));
                return var6;
            } else {
                var6.put("returnCode", new Long(0L));
                var6.put("currentAuthNum", new Long(var1));
                return var6;
            }
        } else {
            var6.put("returnCode", new Long(1L));
            var6.put("currentAuthNum", new Long(0L));
            return var6;
        }
    }

    public static Map ITSecurity_PSW_SYN(String var0, long var1, String var3, String var4, int var5) {
        HashMap var6 = new HashMap();
        if(var0 != null && var3 != null && var4 != null) {
            String var8 = d.a(var0, var1);

            for(int var7 = 1; var7 <= var5; ++var7) {
                ++var1;
                String var9 = d.a(var0, var1);
                if(var8.equalsIgnoreCase(var3) && var9.equalsIgnoreCase(var4)) {
                    ++var1;
                    var6.put("returnCode", new Long(0L));
                    var6.put("currentAuthNum", new Long(var1));
                    return var6;
                }

                var8 = var9;
            }

            var6.put("returnCode", new Long(3L));
            var6.put("currentAuthNum", new Long(0L));
            return var6;
        } else {
            var6.put("returnCode", new Long(1L));
            var6.put("currentAuthNum", new Long(0L));
            return var6;
        }
    }

    public static Map ITSecurity_CheckPwdC200(String var0, long var1, long var3, int var5, int var6, int var7, long var8, String var10) {
        HashMap var11 = new HashMap();
        if(var0 != null && var10 != null) {
            if(a(var10, var0, var1, var6, var8, (long)var7, var3, var5)) {
                var11.put("returnCode", new Long(4L));
                var11.put("currentUTCEpoch", new Long(0L));
                var11.put("currentDrift", new Long(0L));
                return var11;
            } else {
                long var12 = var1 + (long)(var6 * var5);
                if(d.a(var0, var12, var3, var5).equalsIgnoreCase(var10)) {
                    var11.put("returnCode", new Long(0L));
                    var11.put("currentUTCEpoch", new Long(var12));
                    var11.put("currentDrift", new Long((long)var6));
                    return var11;
                } else {
                    int var2 = var7 / 2;

                    for(var7 = 1; var7 <= var2; ++var7) {
                        long var17 = var12 + (long)(var7 * var5);
                        if(d.a(var0, var17, var3, var5).equalsIgnoreCase(var10)) {
                            if(var17 <= var8) {
                                var11.put("returnCode", new Long(4L));
                                var11.put("currentUTCEpoch", new Long(0L));
                                var11.put("currentDrift", new Long(0L));
                                return var11;
                            }

                            var11.put("returnCode", new Long(0L));
                            var11.put("currentUTCEpoch", new Long(var17));
                            var11.put("currentDrift", new Long((long)(var6 + var7)));
                            return var11;
                        }

                        var17 = var12 - (long)(var7 * var5);
                        if(d.a(var0, var17, var3, var5).equalsIgnoreCase(var10)) {
                            if(var17 <= var8) {
                                var11.put("returnCode", new Long(4L));
                                var11.put("currentUTCEpoch", new Long(0L));
                                var11.put("currentDrift", new Long(0L));
                                return var11;
                            }

                            var11.put("returnCode", new Long(0L));
                            var11.put("currentUTCEpoch", new Long(var17));
                            var11.put("currentDrift", new Long((long)(var6 - var7)));
                            return var11;
                        }
                    }

                    var11.put("returnCode", new Long(2L));
                    var11.put("currentUTCEpoch", new Long(0L));
                    var11.put("currentDrift", new Long(0L));
                    return var11;
                }
            }
        } else {
            var11.put("returnCode", new Long(1L));
            var11.put("currentUTCEpoch", new Long(0L));
            var11.put("currentDrift", new Long(0L));
            return var11;
        }
    }

    public static Map ITSecurity_PSW_SYNC200(String var0, long var1, long var3, int var5, int var6, int var7, long var8, String var10, String var11) {
        HashMap var12 = new HashMap();
        if(var0 != null && var10 != null && var11 != null) {
            if(!a(var10, var0, var1, var6, var8, (long)var7, var3, var5) && !a(var11, var0, var1, var6, var8, (long)var7, var3, var5)) {
                long var14 = var1 + (long)(var6 * var5);
                String var2;
                String var9 = var2 = d.a(var0, var14, var3, var5);

                for(int var22 = 1; var22 <= var7; ++var22) {
                    long var20 = var14 + (long)(var22 * var5);
                    String var23 = d.a(var0, var20, var3, var5);
                    if(var2.equalsIgnoreCase(var10) && var23.equalsIgnoreCase(var11)) {
                        var12.put("returnCode", new Long(0L));
                        var12.put("currentUTCEpoch", new Long(var20));
                        var12.put("currentDrift", new Long((long)(var6 + var22)));
                        return var12;
                    }

                    var2 = var23;
                    var20 = var14 - (long)(var22 * var5);
                    if((var23 = d.a(var0, var20, var3, var5)).equalsIgnoreCase(var10) && var9.equalsIgnoreCase(var11)) {
                        var12.put("returnCode", new Long(0L));
                        var12.put("currentUTCEpoch", new Long(var14 - (long)((var22 - 1) * var5)));
                        var12.put("currentDrift", new Long((long)(var6 - (var22 - 1))));
                        return var12;
                    }

                    var9 = var23;
                }

                var12.put("returnCode", new Long(3L));
                var12.put("currentUTCEpoch", new Long(0L));
                var12.put("currentDrift", new Long(0L));
                return var12;
            } else {
                var12.put("returnCode", new Long(4L));
                var12.put("currentUTCEpoch", new Long(0L));
                var12.put("currentDrift", new Long(0L));
                return var12;
            }
        } else {
            var12.put("returnCode", new Long(1L));
            var12.put("currentUTCEpoch", new Long(0L));
            var12.put("currentDrift", new Long(0L));
            return var12;
        }
    }

    public static Map ET_CheckPwdz201(String var0, long var1, long var3, int var5, int var6, int var7, long var8, String var10) {
        HashMap var11 = new HashMap();
        if(var0 != null && var10 != null) {
            String var14;
            if((var14 = d.a(var0)) == null) {
                var11.put("returnCode", new Long(1L));
                var11.put("currentUTCEpoch", new Long(0L));
                var11.put("currentDrift", new Long(0L));
                return var11;
            } else if(a(var10, var14, var1, var6, var8, (long)var7, var3, var5)) {
                var11.put("returnCode", new Long(4L));
                var11.put("currentUTCEpoch", new Long(0L));
                var11.put("currentDrift", new Long(0L));
                return var11;
            } else {
                long var12 = var1 + (long)(var6 * var5);
                if(d.a(var14, var12, var3, var5).equalsIgnoreCase(var10)) {
                    var11.put("returnCode", new Long(0L));
                    var11.put("currentUTCEpoch", new Long(var12));
                    var11.put("currentDrift", new Long((long)var6));
                    return var11;
                } else {
                    int var20 = var7 / 2;

                    for(int var2 = 1; var2 <= var20; ++var2) {
                        long var18 = var12 + (long)(var2 * var5);
                        if(d.a(var14, var18, var3, var5).equalsIgnoreCase(var10)) {
                            if(var18 <= var8) {
                                var11.put("returnCode", new Long(4L));
                                var11.put("currentUTCEpoch", new Long(0L));
                                var11.put("currentDrift", new Long(0L));
                                return var11;
                            }

                            var11.put("returnCode", new Long(0L));
                            var11.put("currentUTCEpoch", new Long(var18));
                            var11.put("currentDrift", new Long((long)(var6 + var2)));
                            return var11;
                        }

                        var18 = var12 - (long)(var2 * var5);
                        if(d.a(var14, var18, var3, var5).equalsIgnoreCase(var10)) {
                            if(var18 <= var8) {
                                var11.put("returnCode", new Long(4L));
                                var11.put("currentUTCEpoch", new Long(0L));
                                var11.put("currentDrift", new Long(0L));
                                return var11;
                            }

                            var11.put("returnCode", new Long(0L));
                            var11.put("currentUTCEpoch", new Long(var18));
                            var11.put("currentDrift", new Long((long)(var6 - var2)));
                            return var11;
                        }
                    }

                    var11.put("returnCode", new Long(2L));
                    var11.put("currentUTCEpoch", new Long(0L));
                    var11.put("currentDrift", new Long(0L));
                    return var11;
                }
            }
        } else {
            var11.put("returnCode", new Long(1L));
            var11.put("currentUTCEpoch", new Long(0L));
            var11.put("currentDrift", new Long(0L));
            return var11;
        }
    }

    public static Map ET_Syncz201(String var0, long var1, long var3, int var5, int var6, int var7, long var8, String var10, String var11) {
        HashMap var12 = new HashMap();
        if(var0 != null && var10 != null && var11 != null) {
            String var13;
            if((var13 = d.a(var0)) == null) {
                var12.put("returnCode", new Long(1L));
                var12.put("currentUTCEpoch", new Long(0L));
                var12.put("currentDrift", new Long(0L));
                return var12;
            } else if(!a(var10, var13, var1, var6, var8, (long)var7, var3, var5) && !a(var11, var13, var1, var6, var8, (long)var7, var3, var5)) {
                long var14 = var1 + (long)(var6 * var5);
                String var24;
                String var25 = var24 = d.a(var13, var14, var3, var5);

                for(int var23 = 1; var23 <= var7; ++var23) {
                    long var21 = var14 + (long)(var23 * var5);
                    String var2 = d.a(var13, var21, var3, var5);
                    if(var24.equalsIgnoreCase(var10) && var2.equalsIgnoreCase(var11)) {
                        var12.put("returnCode", new Long(0L));
                        var12.put("currentUTCEpoch", new Long(var21));
                        var12.put("currentDrift", new Long((long)(var6 + var23)));
                        return var12;
                    }

                    var24 = var2;
                    var21 = var14 - (long)(var23 * var5);
                    if((var2 = d.a(var13, var21, var3, var5)).equalsIgnoreCase(var10) && var25.equalsIgnoreCase(var11)) {
                        var12.put("returnCode", new Long(0L));
                        var12.put("currentUTCEpoch", new Long(var14 - (long)((var23 - 1) * var5)));
                        var12.put("currentDrift", new Long((long)(var6 - (var23 - 1))));
                        return var12;
                    }

                    var25 = var2;
                }

                var12.put("returnCode", new Long(3L));
                var12.put("currentUTCEpoch", new Long(0L));
                var12.put("currentDrift", new Long(0L));
                return var12;
            } else {
                var12.put("returnCode", new Long(4L));
                var12.put("currentUTCEpoch", new Long(0L));
                var12.put("currentDrift", new Long(0L));
                return var12;
            }
        } else {
            var12.put("returnCode", new Long(1L));
            var12.put("currentUTCEpoch", new Long(0L));
            var12.put("currentDrift", new Long(0L));
            return var12;
        }
    }

    private static boolean a(String var0, String var1, long var2, int var4, long var5, long var7, long var9, int var11) {
        if(!d.a(var1, var5, var9, var11).equalsIgnoreCase(var0)) {
            return false;
        } else {
            long var13 = var2 + (long)(var4 * var11);
            return var5 >= var13 - (var7 + 2L) / 2L * (long)var11 && var5 <= var13 + (var7 + 2L) / 2L * (long)var11;
        }
    }
}