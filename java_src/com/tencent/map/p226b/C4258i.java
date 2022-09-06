package com.tencent.map.p226b;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.telephony.NeighboringCellInfo;
import com.fimi.kernel.C2172a;
import com.fimi.kernel.p157b.p161d.C2227d;
import com.fimi.soul.service.CameraSocketService;
import com.tencent.map.p226b.C4237d;
import com.tencent.map.p226b.C4242e;
import com.tencent.map.p226b.C4252g;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* renamed from: com.tencent.map.b.i */
/* loaded from: classes.dex */
public final class C4258i {

    /* renamed from: a */
    public static String f17701a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";

    /* renamed from: b */
    public static int[] f17702b = {0, 49345, 49537, 320, 49921, 960, 640, 49729, 50689, 1728, 1920, 51009, C2172a.f7290f, 50625, 50305, 1088, 52225, 3264, 3456, 52545, 3840, 53185, 52865, 3648, 2560, 51905, 52097, 2880, 51457, 2496, 2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 7680, 57025, 57217, 8000, 56577, 7616, 7296, 56385, 5120, 54465, 54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 4352, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 15232, 64321, 14592, 63937, 63617, 14400, C2227d.f7442b, 59585, 59777, 10560, 60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 24960, 41281, 25344, 41921, 41601, 25152, CameraSocketService.f14615a, 42689, 42881, 26432, 42241, 26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 32640, 48961, 32000, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 17280, 33601, 16640, 33217, 32897, 16448};

    static {
        int[] iArr = {93629, 99879, 79843, 75029, 59699, 55667, 46867, 38039};
    }

    /* renamed from: a */
    public static double m5698a(double d, int i) {
        try {
            if (!Double.isNaN(d)) {
                return BigDecimal.valueOf(d).setScale(i, RoundingMode.HALF_DOWN).doubleValue();
            }
            return 0.0d;
        } catch (Exception e) {
            return 0.0d;
        }
    }

    /* renamed from: a */
    public static int m5699a(char c) {
        int i = 256;
        if (c >= 'A' && c <= 'Z') {
            i = c - 'A';
        }
        if (c >= 'a' && c <= 'z') {
            i = (c - 'a') + 64;
        }
        return (c < '0' || c > '9') ? i : (c + 128) - 48;
    }

    /* renamed from: a */
    private static String m5696a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"mcc\":");
        sb.append(i);
        sb.append(",\"mnc\":");
        sb.append(i2);
        sb.append(",\"lac\":");
        sb.append(i3);
        sb.append(",\"cellid\":");
        sb.append(i4);
        sb.append(",\"rss\":");
        sb.append(i5);
        if (i6 != Integer.MAX_VALUE && i7 != Integer.MAX_VALUE) {
            sb.append(",\"stationLat\":");
            sb.append(String.format("%.6f", Float.valueOf(i6 / 14400.0f)));
            sb.append(",\"stationLng\":");
            sb.append(String.format("%.6f", Float.valueOf(i7 / 14400.0f)));
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public static String m5695a(C4237d.C4240b c4240b, List<NeighboringCellInfo> list) {
        int i;
        int i2 = 0;
        if (c4240b == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i3 = c4240b.f17607b;
        int i4 = c4240b.f17608c;
        if (m5697a(c4240b.f17606a, i3, i4, c4240b.f17609d, c4240b.f17610e)) {
            sb.append(m5696a(i3, i4, c4240b.f17609d, c4240b.f17610e, c4240b.f17611f, c4240b.f17612g, c4240b.f17613h));
            i2 = 1;
        }
        if (list != null) {
            try {
                Method method = Class.forName("android.telephony.NeighboringCellInfo").getMethod("getLac", new Class[0]);
                for (NeighboringCellInfo neighboringCellInfo : list) {
                    int parseInt = Integer.parseInt(method.invoke(neighboringCellInfo, new Object[0]).toString());
                    if (m5697a(c4240b.f17606a, i3, i4, parseInt, neighboringCellInfo.getCid())) {
                        if (i2 > 0) {
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        sb.append(m5696a(i3, i4, parseInt, neighboringCellInfo.getCid(), (neighboringCellInfo.getRssi() << 1) - 113, Integer.MAX_VALUE, Integer.MAX_VALUE));
                        i = i2 + 1;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
            } catch (Exception e) {
            }
            list.clear();
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    public static String m5694a(C4242e.C4244b c4244b) {
        if (c4244b.m5768b() == null) {
            return "{}";
        }
        Location m5768b = c4244b.m5768b();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"latitude\":");
        sb.append(m5768b.getLatitude());
        sb.append(",\"longitude\":");
        sb.append(m5768b.getLongitude());
        sb.append(",\"additional\":");
        sb.append("\"" + m5768b.getAltitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + m5768b.getAccuracy() + Constants.ACCEPT_TIME_SEPARATOR_SP + m5768b.getBearing() + Constants.ACCEPT_TIME_SEPARATOR_SP + m5768b.getSpeed() + Constants.ACCEPT_TIME_SEPARATOR_SP + m5768b.getTime() + "\"");
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public static String m5693a(C4252g.C4255b c4255b) {
        if (c4255b == null || c4255b.m5703a() == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (c4255b.m5703a() == null || c4255b.m5703a().size() <= 0) {
            sb.append("]");
            return sb.toString();
        }
        List<ScanResult> m5703a = c4255b.m5703a();
        int i = 0;
        for (ScanResult scanResult : m5703a) {
            if (scanResult.level >= (m5703a.size() < 6 ? -95 : -90)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append("{\"mac\":\"").append(scanResult.BSSID).append("\",");
                sb.append("\"rssi\":").append(scanResult.level).append("}");
                i++;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    public static String m5691a(String str, String str2, String str3, String str4, boolean z) {
        return "{\"imei\":\"" + str + "\",\"imsi\":\"" + str2 + "\",\"phonenum\":\"" + str3 + "\",\"roaming\":\"" + z + "\",\"qq\":\"" + str4 + "\"}";
    }

    /* renamed from: a */
    public static boolean m5697a(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return i2 >= 0 && i3 >= 0 && i4 >= 0 && i4 <= 65535 && i5 >= 0 && i5 <= 65535 && !(i3 == 0 && i4 == 0 && i5 == 0);
        } else if (i2 < 0 || i3 < 0 || i4 <= 0 || i4 >= 65535) {
            return false;
        } else {
            return (i5 == 268435455 || i5 == Integer.MAX_VALUE || i5 == 50594049 || i5 == 65535 || i5 == 8 || i5 == 10 || i5 == 33 || i5 <= 0) ? false : true;
        }
    }

    /* renamed from: a */
    public static boolean m5692a(String str) {
        return str != null && str.length() <= 32 && str.length() >= 6 && Pattern.compile("[a-zA-Z0-9_]{6,32}").matcher(str).matches();
    }

    /* renamed from: b */
    public static boolean m5690b(String str) {
        return str != null && str.length() == 29 && Pattern.compile("([A-Z2-7]{5}){1}(-[A-Z2-7]{5}){4}").matcher(str).matches();
    }

    /* renamed from: c */
    public static boolean m5689c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (str.contains("latitude")) || (jSONObject.getJSONArray("cells").length() > 0) || (jSONObject.getJSONArray("wifis").length() > 0);
        } catch (Exception e) {
            return false;
        }
    }
}
