package com.tencent.open.p229b;

import android.os.SystemClock;
import com.tencent.open.utils.Util;
/* renamed from: com.tencent.open.b.d */
/* loaded from: classes.dex */
public class C4340d {

    /* renamed from: a */
    protected static C4340d f18136a;

    protected C4340d() {
    }

    /* renamed from: a */
    public static synchronized C4340d m5413a() {
        C4340d c4340d;
        synchronized (C4340d.class) {
            if (f18136a == null) {
                f18136a = new C4340d();
            }
            c4340d = f18136a;
        }
        return c4340d;
    }

    /* renamed from: a */
    public void m5412a(int i, String str, String str2, String str3, String str4, Long l, int i2, int i3, String str5) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
        long j = (l.longValue() == 0 || elapsedRealtime < 0) ? 0L : elapsedRealtime;
        StringBuffer stringBuffer = new StringBuffer("http://c.isdspeed.qq.com/code.cgi");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=").append(i).append("&code=").append(i2).append("&time=").append(j).append("&rate=").append(i3).append("&uin=").append(str2).append("&data=");
        C4343g.m5402a().m5395a(stringBuffer.toString(), "GET", Util.composeHaboCgiReportParams(String.valueOf(i), String.valueOf(i2), String.valueOf(j), String.valueOf(i3), str, str2, str3, str4, str5), true);
    }

    /* renamed from: a */
    public void m5411a(String str, String str2, String str3, String str4, String str5, String str6) {
        C4343g.m5402a().m5400a(Util.composeViaReportParams(str, str3, str4, str5, str2, str6), str2, true);
    }

    /* renamed from: a */
    public void m5410a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        C4343g.m5402a().m5400a(Util.composeViaReportParams(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    /* renamed from: a */
    public void m5409a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C4343g.m5402a().m5400a(Util.composeViaReportParams(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }
}
