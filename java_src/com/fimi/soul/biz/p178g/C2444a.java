package com.fimi.soul.biz.p178g;

import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p203i.C2871ab;
/* renamed from: com.fimi.soul.biz.g.a */
/* loaded from: classes.dex */
public class C2444a {

    /* renamed from: b */
    private static C2444a f8423b;

    /* renamed from: a */
    private String f8424a;

    private C2444a() {
    }

    /* renamed from: a */
    public static C2444a m12164a() {
        if (f8423b == null) {
            synchronized (C2444a.class) {
                if (f8423b == null) {
                    f8423b = new C2444a();
                }
            }
        }
        return f8423b;
    }

    /* renamed from: a */
    public void m12163a(final C2871ab c2871ab) {
        if (c2871ab != null) {
            C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.g.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c2871ab.m10692a() == 0) {
                        C2770c m10683i = c2871ab.m10683i();
                        StringBuilder sb = new StringBuilder();
                        if (m10683i != null) {
                            byte[] m11066f = m10683i.m11066f();
                            for (int i = 0; i < m11066f.length; i++) {
                                sb.append(Character.forDigit((m11066f[i] & 240) >> 4, 16));
                                sb.append(Character.forDigit(m11066f[i] & 15, 16));
                            }
                        }
                        String substring = sb.toString().substring(18, sb.toString().length() - 4);
                        String str = "";
                        String str2 = "";
                        String str3 = "";
                        String str4 = "";
                        if (substring.length() >= 32) {
                            str = substring.substring(0, 8);
                            str2 = substring.substring(8, 16);
                            str3 = substring.substring(16, 24);
                            str4 = substring.substring(24, 32);
                        } else if (substring.length() >= 24) {
                            str = substring.substring(0, 8);
                            str2 = substring.substring(8, 16);
                            str3 = substring.substring(16, 24);
                            str4 = "00000000";
                        } else if (substring.length() >= 16) {
                            str = substring.substring(0, 8);
                            str2 = substring.substring(8, 16);
                            str3 = "00000000";
                            str4 = "00000000";
                        }
                        sb.delete(0, sb.length());
                        sb.append(str4);
                        sb.append(str3);
                        sb.append(str2);
                        sb.append(str);
                        C2444a.this.m12162a(sb.toString());
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m12162a(String str) {
        this.f8424a = str;
    }

    /* renamed from: b */
    public String m12161b() {
        return this.f8424a;
    }
}
