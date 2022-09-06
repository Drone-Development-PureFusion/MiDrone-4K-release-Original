package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.baidu.tts.chainofresponsibility.logger.e */
/* loaded from: classes.dex */
public class C1666e {

    /* renamed from: a */
    private List<String> f5825a = new ArrayList();

    /* renamed from: b */
    private List<String> f5826b = new ArrayList();

    /* renamed from: a */
    public void m15063a() {
        if (this.f5825a != null) {
            this.f5825a.clear();
        }
        if (this.f5826b != null) {
            this.f5826b.clear();
        }
    }

    /* renamed from: a */
    public void m15062a(C1661c c1661c, Void r9, C1662d c1662d) {
        boolean z;
        String m15083b = c1661c.m15083b();
        String m15081c = c1661c.m15081c();
        String m15080d = c1661c.m15080d();
        String str = m15080d != null ? "(" + m15080d + ")" + m15081c : m15081c;
        if (this.f5826b == null || this.f5826b.isEmpty()) {
            z = true;
        } else if (this.f5826b.contains(m15083b)) {
            z = false;
        } else {
            Iterator<String> it2 = this.f5826b.iterator();
            z = true;
            while (it2.hasNext()) {
                String next = it2.next();
                z = (next == null || str == null || !str.contains(next)) ? z : false;
            }
        }
        if (this.f5825a != null && !this.f5825a.isEmpty()) {
            if (this.f5825a.contains(m15083b)) {
                z = true;
            } else {
                for (String str2 : this.f5825a) {
                    if (str2 != null && str != null) {
                        z = str.contains(str2);
                    }
                }
            }
        }
        if (z) {
            Log.println(c1661c.m15086a(), "bdtts-" + m15083b, str);
        }
    }

    /* renamed from: a */
    public void m15061a(String str) {
        if (this.f5825a == null || this.f5825a.contains(str)) {
            return;
        }
        this.f5825a.add(str);
    }

    /* renamed from: a */
    public void m15060a(List<String> list) {
        if (this.f5825a != null) {
            this.f5825a.addAll(list);
        }
    }

    /* renamed from: b */
    public void m15059b(String str) {
        if (this.f5826b == null || this.f5826b.contains(str)) {
            return;
        }
        this.f5826b.add(str);
    }
}
