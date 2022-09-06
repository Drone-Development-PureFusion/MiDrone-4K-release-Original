package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.ca */
/* loaded from: classes.dex */
public abstract class AbstractC0864ca {

    /* renamed from: a */
    protected int f2406a;

    /* renamed from: b */
    protected C0790aw f2407b;

    public AbstractC0864ca(int i, C0790aw c0790aw) {
        this.f2406a = i;
        this.f2407b = c0790aw;
    }

    /* renamed from: a */
    public void mo18725a() {
        C0856bu.m18754a("Wrong call delete()  State: " + m18723b() + "  " + getClass());
    }

    /* renamed from: a */
    public void mo18718a(int i) {
        C0856bu.m18754a("Wrong call fail()  State: " + m18723b() + "  " + getClass());
    }

    /* renamed from: a */
    public boolean m18724a(AbstractC0864ca abstractC0864ca) {
        return abstractC0864ca.m18723b() == m18723b();
    }

    /* renamed from: b */
    public int m18723b() {
        return this.f2406a;
    }

    /* renamed from: b */
    public void m18722b(AbstractC0864ca abstractC0864ca) {
        C0856bu.m18754a(m18723b() + " ==> " + abstractC0864ca.m18723b() + "   " + getClass() + "==>" + abstractC0864ca.getClass());
    }

    /* renamed from: c */
    public abstract void mo18717c();

    /* renamed from: d */
    public void mo18716d() {
        C0856bu.m18754a("Wrong call start()  State: " + m18723b() + "  " + getClass());
    }

    /* renamed from: e */
    public void mo18720e() {
        C0856bu.m18754a("Wrong call continueDownload()  State: " + m18723b() + "  " + getClass());
    }

    /* renamed from: f */
    public void mo18715f() {
        C0856bu.m18754a("Wrong call pause()  State: " + m18723b() + "  " + getClass());
    }

    /* renamed from: g */
    public void mo18721g() {
        C0856bu.m18754a("Wrong call hasNew()  State: " + m18723b() + "  " + getClass());
    }

    /* renamed from: h */
    public void mo18719h() {
        C0856bu.m18754a("Wrong call complete()  State: " + m18723b() + "  " + getClass());
    }
}
