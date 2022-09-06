package com.baidu.tts.p099g.p101b;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p104i.AbstractC1724b;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
/* renamed from: com.baidu.tts.g.b.b */
/* loaded from: classes.dex */
public class C1719b implements AbstractC1724b {

    /* renamed from: a */
    private static volatile C1719b f6202a = null;

    /* renamed from: c */
    private WeakReference<Context> f6204c;

    /* renamed from: b */
    private Hashtable<WeakReference<Context>, C1718a> f6203b = new Hashtable<>();

    /* renamed from: d */
    private Hashtable<String, Object> f6205d = new Hashtable<>();

    private C1719b() {
        this.f6205d.put(EnumC1704g.CTP.m14898a(), "10");
        this.f6205d.put(EnumC1704g.VERSION.m14898a(), "v2.2.7");
    }

    /* renamed from: a */
    public static C1719b m14869a() {
        if (f6202a == null) {
            synchronized (C1719b.class) {
                if (f6202a == null) {
                    f6202a = new C1719b();
                }
            }
        }
        return f6202a;
    }

    /* renamed from: a */
    public C1718a m14866a(WeakReference<Context> weakReference) {
        if (weakReference == null) {
            return null;
        }
        C1718a c1718a = this.f6203b.get(weakReference);
        if (c1718a != null) {
            return c1718a;
        }
        C1718a c1718a2 = new C1718a(weakReference);
        this.f6203b.put(weakReference, c1718a2);
        return c1718a2;
    }

    /* renamed from: a */
    public String m14867a(String str) {
        try {
            return (String) this.f6205d.get(str);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public void m14868a(Context context) {
        this.f6204c = new WeakReference<>(context);
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: b */
    public TtsError mo14683b() {
        return null;
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: c */
    public void mo14682c() {
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: d */
    public void mo14681d() {
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: e */
    public void mo14680e() {
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: f */
    public void mo14679f() {
        if (this.f6203b != null) {
            this.f6203b.clear();
        }
        this.f6204c = null;
    }

    /* renamed from: g */
    public C1718a m14865g() {
        return m14866a(this.f6204c);
    }

    /* renamed from: h */
    public Context m14864h() {
        return this.f6204c.get();
    }

    /* renamed from: i */
    public String m14863i() {
        try {
            C1718a m14865g = m14865g();
            if (m14865g != null) {
                return m14865g.m14872a();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: j */
    public String m14862j() {
        return m14867a(EnumC1704g.VERSION.m14898a());
    }
}
