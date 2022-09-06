package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.StatLogger;
/* loaded from: classes2.dex */
public class StatMid {

    /* renamed from: a */
    private static StatLogger f18336a = C4420k.m5197b();

    /* renamed from: b */
    private static DeviceInfo f18337b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized DeviceInfo m5282a(Context context) {
        DeviceInfo deviceInfo;
        synchronized (StatMid.class) {
            C4396a m5262a = C4396a.m5262a(context);
            DeviceInfo m5279a = m5279a(m5262a.m5255d(DeviceInfo.TAG_FLAG, null));
            f18336a.m5238d("get device info from internal storage:" + m5279a);
            DeviceInfo m5279a2 = m5279a(m5262a.m5253f(DeviceInfo.TAG_FLAG, null));
            f18336a.m5238d("get device info from setting.system:" + m5279a2);
            DeviceInfo m5279a3 = m5279a(m5262a.m5259b(DeviceInfo.TAG_FLAG, null));
            f18336a.m5238d("get device info from SharedPreference:" + m5279a3);
            f18337b = m5280a(m5279a3, m5279a2, m5279a);
            if (f18337b == null) {
                f18337b = new DeviceInfo();
            }
            DeviceInfo m5121b = C4436n.m5134a(context).m5121b(context);
            if (m5121b != null) {
                f18337b.m5302d(m5121b.getImei());
                f18337b.m5301e(m5121b.getMac());
                f18337b.m5306b(m5121b.getUserType());
            }
            deviceInfo = f18337b;
        }
        return deviceInfo;
    }

    /* renamed from: a */
    static DeviceInfo m5281a(DeviceInfo deviceInfo, DeviceInfo deviceInfo2) {
        if (deviceInfo != null && deviceInfo2 != null) {
            return deviceInfo.m5309a(deviceInfo2) >= 0 ? deviceInfo : deviceInfo2;
        } else if (deviceInfo != null) {
            return deviceInfo;
        } else {
            if (deviceInfo2 == null) {
                return null;
            }
            return deviceInfo2;
        }
    }

    /* renamed from: a */
    static DeviceInfo m5280a(DeviceInfo deviceInfo, DeviceInfo deviceInfo2, DeviceInfo deviceInfo3) {
        return m5281a(m5281a(deviceInfo, deviceInfo2), m5281a(deviceInfo2, deviceInfo3));
    }

    /* renamed from: a */
    private static DeviceInfo m5279a(String str) {
        if (str != null) {
            return DeviceInfo.m5308a(C4420k.m5188d(str));
        }
        return null;
    }

    public static DeviceInfo getDeviceInfo(Context context) {
        if (context == null) {
            f18336a.error("Context for StatConfig.getDeviceInfo is null.");
            return null;
        }
        if (f18337b == null) {
            m5282a(context);
        }
        return f18337b;
    }

    public static String getMid(Context context) {
        if (f18337b == null) {
            getDeviceInfo(context);
        }
        return f18337b.getMid();
    }

    public static void updateDeviceInfo(Context context, String str) {
        try {
            getDeviceInfo(context);
            f18337b.m5303c(str);
            f18337b.m5311a(f18337b.m5312a() + 1);
            f18337b.m5310a(System.currentTimeMillis());
            String jSONObject = f18337b.m5304c().toString();
            f18336a.m5238d("save DeviceInfo:" + jSONObject);
            String replace = C4420k.m5191c(jSONObject).replace("\n", "");
            C4396a m5262a = C4396a.m5262a(context);
            m5262a.m5257c(DeviceInfo.TAG_FLAG, replace);
            m5262a.m5254e(DeviceInfo.TAG_FLAG, replace);
            m5262a.m5261a(DeviceInfo.TAG_FLAG, replace);
        } catch (Throwable th) {
            f18336a.m5236e(th);
        }
    }
}
