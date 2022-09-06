package com.tencent.open.p228a;

import android.text.format.Time;
import android.util.Log;
import com.fimi.soul.module.setting.newhand.C3530b;
import com.xiaomi.mipush.sdk.Constants;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.tencent.open.a.h */
/* loaded from: classes2.dex */
public final class C4333h {

    /* renamed from: a */
    public static final C4333h f18123a = new C4333h();

    /* renamed from: a */
    public final String m5434a(int i) {
        switch (i) {
            case 1:
                return "V";
            case 2:
                return "D";
            case 4:
                return "I";
            case 8:
                return "W";
            case 16:
                return "E";
            case 32:
                return "A";
            default:
                return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    /* renamed from: a */
    public String m5433a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        long j2 = j % 1000;
        Time time = new Time();
        time.set(j);
        StringBuilder sb = new StringBuilder();
        sb.append(m5434a(i)).append('/').append(time.format("%Y-%m-%d %H:%M:%S")).append(C0359h.f677G);
        if (j2 < 10) {
            sb.append("00");
        } else if (j2 < 100) {
            sb.append('0');
        }
        sb.append(j2).append(C5122l.f21763c).append('[');
        if (thread == null) {
            sb.append(C3530b.f14164ao);
        } else {
            sb.append(thread.getName());
        }
        sb.append(']').append('[').append(str).append(']').append(C5122l.f21763c).append(str2).append('\n');
        if (th != null) {
            sb.append("* Exception : \n").append(Log.getStackTraceString(th)).append('\n');
        }
        return sb.toString();
    }
}
