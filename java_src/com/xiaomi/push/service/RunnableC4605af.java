package com.xiaomi.push.service;

import com.xiaomi.stats.C4761h;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.af */
/* loaded from: classes2.dex */
public final class RunnableC4605af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f18941a;

    /* renamed from: b */
    final /* synthetic */ boolean f18942b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4605af(List list, boolean z) {
        this.f18941a = list;
        this.f18942b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean m4404b;
        boolean m4404b2;
        m4404b = C4604ae.m4404b("www.baidu.com:80");
        Iterator it2 = this.f18941a.iterator();
        while (true) {
            boolean z = m4404b;
            if (!it2.hasNext()) {
                m4404b = z;
                break;
            }
            String str = (String) it2.next();
            if (!z) {
                m4404b2 = C4604ae.m4404b(str);
                if (!m4404b2) {
                    m4404b = false;
                    if (!m4404b && !this.f18942b) {
                        break;
                    }
                }
            }
            m4404b = true;
            if (!m4404b) {
            }
        }
        C4761h.m3782a(m4404b ? 1 : 2);
    }
}
