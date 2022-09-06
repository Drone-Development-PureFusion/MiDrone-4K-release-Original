package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.gc */
/* loaded from: classes.dex */
public class C1025gc {

    /* renamed from: a */
    private C1016fu f3205a;

    public C1025gc(Context context) {
        try {
            this.f3205a = new C1016fu(context, C1016fu.m17968a((Class<? extends AbstractC1015ft>) C1024gb.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m17941c(String str, Class<? extends AbstractC1026gd> cls) {
        this.f3205a.m17961a(AbstractC1026gd.m17932c(str), (Class) cls);
    }

    /* renamed from: a */
    public List<? extends AbstractC1026gd> m17946a(int i, Class<? extends AbstractC1026gd> cls) {
        try {
            return this.f3205a.m17952b(AbstractC1026gd.m17933c(i), cls);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "LogDB", "ByState");
            return null;
        }
    }

    /* renamed from: a */
    public void m17945a(AbstractC1026gd abstractC1026gd) {
        if (abstractC1026gd == null) {
            return;
        }
        String m17932c = AbstractC1026gd.m17932c(abstractC1026gd.m17937b());
        List m17960a = this.f3205a.m17960a(m17932c, (Class) abstractC1026gd.getClass(), true);
        if (m17960a == null || m17960a.size() == 0) {
            this.f3205a.m17962a((C1016fu) abstractC1026gd, true);
            return;
        }
        AbstractC1026gd abstractC1026gd2 = (AbstractC1026gd) m17960a.get(0);
        if (abstractC1026gd.m17940a() == 0) {
            abstractC1026gd2.m17936b(abstractC1026gd2.m17934c() + 1);
        } else {
            abstractC1026gd2.m17936b(0);
        }
        this.f3205a.m17958a(m17932c, (Object) abstractC1026gd2, true);
    }

    /* renamed from: a */
    public void m17944a(String str, Class<? extends AbstractC1026gd> cls) {
        try {
            m17941c(str, cls);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "LogDB", "delLog");
        }
    }

    /* renamed from: b */
    public void m17943b(AbstractC1026gd abstractC1026gd) {
        try {
            this.f3205a.m17959a(AbstractC1026gd.m17932c(abstractC1026gd.m17937b()), abstractC1026gd);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "LogDB", "updateLogInfo");
        }
    }

    /* renamed from: b */
    public void m17942b(String str, Class<? extends AbstractC1026gd> cls) {
        try {
            m17941c(str, cls);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
