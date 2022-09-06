package com.amap.api.services.core;

import com.fimi.kernel.utils.C2258f;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.services.core.d */
/* loaded from: classes.dex */
public class C1233d {
    /* renamed from: a */
    public static double m17035a(double d) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d));
    }

    /* renamed from: a */
    public static double m17034a(int i) {
        return i / 111700.0d;
    }

    /* renamed from: a */
    public static String m17033a(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return "";
        }
        double m17035a = m17035a(latLonPoint.getLongitude());
        return m17035a + Constants.ACCEPT_TIME_SEPARATOR_SP + m17035a(latLonPoint.getLatitude());
    }

    /* renamed from: a */
    public static String m17030a(Date date) {
        return date != null ? new SimpleDateFormat(C2258f.f7533h).format(date) : "";
    }

    /* renamed from: a */
    public static String m17029a(List<LatLonPoint> list) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                return stringBuffer.toString();
            }
            LatLonPoint latLonPoint = list.get(i2);
            double m17035a = m17035a(latLonPoint.getLongitude());
            stringBuffer.append(m17035a).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(m17035a(latLonPoint.getLatitude()));
            stringBuffer.append(";");
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public static void m17031a(Throwable th, String str, String str2) {
        C1190ay m17176b = C1190ay.m17176b();
        if (m17176b != null) {
            m17176b.m17175b(th, str, str2);
        }
        th.printStackTrace();
    }

    /* renamed from: a */
    public static boolean m17032a(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: b */
    public static void m17028b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                return;
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            if (string.equals("1") || !string.equals("0")) {
                return;
            }
            if (string2.equals("INVALID_USER_KEY") || string2.equals("INSUFFICIENT_PRIVILEGES") || string2.equals("INVALID_USER_SCODE") || string2.equals("INVALID_USER_SIGNATURE")) {
                throw new AMapException("key鉴权失败");
            }
            if (string2.equals("SERVICE_NOT_EXIST") || string2.equals("服务正在维护中")) {
                throw new AMapException(AMapException.ERROR_SERVER);
            }
            if (string2.startsWith("UNKNOWN_ERROR")) {
                throw new AMapException("未知的错误");
            }
            if (string2.equals("INVALID_PARAMS") || string2.equals("参数缺失或格式非法") || string2.equals("账号未激活或已被冻结")) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (string2.equals("OVER_QUOTA") || string2.equals("USER_VISIT_TOO_FREQUENTLY") || string2.equals("USER_DAILY_VISITS_EXCESS") || string2.equals("IP_FORBIDDEN")) {
                throw new AMapException(AMapException.ERROR_QUOTA);
            }
            if (!string2.equals("SERVICE_RESPONSE_ERROR")) {
                throw new AMapException(string2);
            }
            throw new AMapException(AMapException.ERROR_SERVICE);
        } catch (JSONException e) {
            m17031a(e, "CoreUtil", "paseAuthFailurJson");
        }
    }

    /* renamed from: c */
    public static Date m17027c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(str);
            } catch (ParseException e2) {
                m17031a(e, "CoreUtil", "parseString2Date");
                return null;
            }
        }
    }

    /* renamed from: d */
    public static Date m17026d(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HHmm").parse(str);
        } catch (ParseException e) {
            m17031a(e, "CoreUtil", "parseString2Time");
            return null;
        }
    }

    /* renamed from: e */
    public static Date m17025e(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat(C2258f.f7533h).parse(str);
        } catch (ParseException e) {
            m17031a(e, "CoreUtil", "parseTime");
            return null;
        }
    }
}
