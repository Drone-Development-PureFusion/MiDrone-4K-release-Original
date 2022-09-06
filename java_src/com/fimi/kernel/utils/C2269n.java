package com.fimi.kernel.utils;

import com.fimi.kernel.C2238c;
import com.fimi.soul.media.player.FimiMediaMeta;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/* renamed from: com.fimi.kernel.utils.n */
/* loaded from: classes.dex */
public class C2269n {
    /* renamed from: a */
    public static int m12894a(String str, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 = str.substring(i3, i3 + 1).matches("[Α-￥]") ? i2 + 2 : i2 + 1;
            if (i2 >= i) {
                return i3;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m12892a(String str, String str2) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            return str.getBytes(str2).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public static String m12897a(long j) {
        String str = "B";
        if (j >= FimiMediaMeta.AV_CH_SIDE_RIGHT) {
            str = "K";
            j >>= 10;
            if (j >= FimiMediaMeta.AV_CH_SIDE_RIGHT) {
                str = "M";
                j >>= 10;
                if (j >= FimiMediaMeta.AV_CH_SIDE_RIGHT) {
                    str = "G";
                    j >>= 10;
                }
            }
        }
        return j + str;
    }

    /* renamed from: a */
    public static String m12896a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (sb.indexOf("\n") != -1 && sb.lastIndexOf("\n") == sb.length() - 1) {
            sb.delete(sb.lastIndexOf("\n"), sb.lastIndexOf("\n") + 1);
        }
        try {
            inputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m12895a(String str) {
        if (str == null || "null".equals(str.trim())) {
            str = "";
        }
        return str.trim();
    }

    /* renamed from: a */
    public static String m12893a(String str, int i, String str2) {
        int i2 = 0;
        if (m12892a(str, "GBK") <= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char c = charArray[i3];
            stringBuffer.append(c);
            i2 = c > 256 ? i2 + 2 : i2 + 1;
            if (i2 < i) {
                i3++;
            } else if (str2 != null) {
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m12891a(String str, String str2, int i) {
        int indexOf;
        return (!m12889b(str) && (indexOf = str.indexOf(str2)) != -1 && str.length() > indexOf + i) ? str.substring(indexOf + i) : "";
    }

    /* renamed from: a */
    public static void m12890a(String[] strArr) {
        System.out.println(m12878k("2012-3-2 12:2:20"));
    }

    /* renamed from: b */
    public static String m12888b(String str, int i) {
        return m12893a(str, i, "");
    }

    /* renamed from: b */
    public static String m12887b(String str, String str2) {
        return m12889b(str) ? "" : str.substring(0, str.indexOf(str2));
    }

    /* renamed from: b */
    public static boolean m12889b(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: c */
    public static int m12886c(String str) {
        if (!m12889b(str)) {
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (str.substring(i2, i2 + 1).matches("[Α-￥]")) {
                    i += 2;
                }
            }
            return i;
        }
        return 0;
    }

    /* renamed from: d */
    public static int m12885d(String str) {
        if (!m12889b(str)) {
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                i = str.substring(i2, i2 + 1).matches("[Α-￥]") ? i + 2 : i + 1;
            }
            return i;
        }
        return 0;
    }

    /* renamed from: e */
    public static Boolean m12884e(String str) {
        boolean z = false;
        try {
            return Boolean.valueOf(Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$").matcher(str).matches());
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    /* renamed from: f */
    public static Boolean m12883f(String str) {
        return str.matches("^[A-Za-z0-9]+$");
    }

    /* renamed from: g */
    public static Boolean m12882g(String str) {
        return str.matches("^[0-9]+$");
    }

    /* renamed from: h */
    public static Boolean m12881h(String str) {
        return str.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
    }

    /* renamed from: i */
    public static Boolean m12880i(String str) {
        if (!m12889b(str)) {
            boolean z = true;
            for (int i = 0; i < str.length(); i++) {
                if (!str.substring(i, i + 1).matches("[Α-￥]")) {
                    z = false;
                }
            }
            return z;
        }
        return true;
    }

    /* renamed from: j */
    public static Boolean m12879j(String str) {
        boolean z = false;
        if (!m12889b(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.substring(i, i + 1).matches("[Α-￥]")) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: k */
    public static String m12878k(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            if (m12889b(str)) {
                return null;
            }
            String[] split = str.split(" ");
            if (split.length > 0) {
                for (String str2 : split) {
                    if (str2.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) != -1) {
                        String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        for (int i = 0; i < split2.length; i++) {
                            sb.append(m12877l(split2[i]));
                            if (i < split2.length - 1) {
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            }
                        }
                    } else if (str2.indexOf(":") != -1) {
                        sb.append(" ");
                        String[] split3 = str2.split(":");
                        for (int i2 = 0; i2 < split3.length; i2++) {
                            sb.append(m12877l(split3[i2]));
                            if (i2 < split3.length - 1) {
                                sb.append(":");
                            }
                        }
                    }
                }
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: l */
    public static String m12877l(String str) {
        try {
            return str.length() <= 1 ? "0" + str : str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: m */
    public static long m12876m(String str) {
        String[] split = str.replace(".", Constants.ACCEPT_TIME_SEPARATOR_SP).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        return Long.valueOf(split[3]).longValue() | (Long.valueOf(split[0]).longValue() << 24) | (Long.valueOf(split[1]).longValue() << 16) | (Long.valueOf(split[2]).longValue() << 8);
    }

    /* renamed from: n */
    public static int m12875n(String str) {
        if (str == null || str == "") {
            return -1;
        }
        try {
            int lastIndexOf = str.toLowerCase().lastIndexOf("sp");
            return Integer.valueOf(str.substring(lastIndexOf - 2, lastIndexOf) + str.substring(lastIndexOf + 2, lastIndexOf + 4)).intValue();
        } catch (Exception e) {
            C2284z.m12690b(C2238c.m13131a(), "解析逻辑版本出错!");
            return -1;
        }
    }
}
