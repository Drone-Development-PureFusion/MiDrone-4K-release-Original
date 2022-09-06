package com.fimi.soul.biz.p178g;

import android.content.Context;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.entity.User;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.NetUtil;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.p248a.p249a.p282o.C5356f;
/* renamed from: com.fimi.soul.biz.g.j */
/* loaded from: classes.dex */
public class C2459j implements Cloneable {

    /* renamed from: a */
    private int f8463a;

    /* renamed from: b */
    private double f8464b;

    /* renamed from: c */
    private double f8465c;

    /* renamed from: d */
    private double f8466d;

    /* renamed from: e */
    private double f8467e;

    /* renamed from: f */
    private String f8468f;

    /* renamed from: g */
    private String f8469g;

    /* renamed from: h */
    private String f8470h;

    /* renamed from: com.fimi.soul.biz.g.j$a */
    /* loaded from: classes.dex */
    private static class C2461a {

        /* renamed from: a */
        private static final C2459j f8474a = new C2459j();

        private C2461a() {
        }
    }

    private C2459j() {
    }

    /* renamed from: a */
    public static C2459j m12118a() {
        return C2461a.f8474a;
    }

    /* renamed from: a */
    public void m12117a(double d) {
        this.f8467e = d;
    }

    /* renamed from: a */
    public void m12116a(int i) {
        if (i > this.f8463a) {
            this.f8463a = i;
        }
    }

    /* renamed from: a */
    public void m12115a(final Context context) {
        try {
            if (!C3658ar.m7601b(context)) {
                return;
            }
            User m12507c = C2353b.m12507c(context);
            m12114a(m12507c.getUserID());
            if (C5356f.m1297a(m12507c.getUserID())) {
                return;
            }
            final ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("commandCode", "getRealTimeFly"));
            arrayList.add(new BasicNameValuePair("jsonStr", new Gson().toJson(clone())));
            C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.g.j.1
                @Override // java.lang.Runnable
                public void run() {
                    NetUtil.m7767a(C2353b.f7951i, arrayList, context);
                }
            });
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m12114a(String str) {
        this.f8468f = str;
    }

    /* renamed from: b */
    public double m12113b() {
        return this.f8467e;
    }

    /* renamed from: b */
    public void m12112b(double d) {
        this.f8466d = d;
    }

    /* renamed from: b */
    public void m12111b(String str) {
        this.f8469g = str;
    }

    /* renamed from: c */
    public double m12110c() {
        return this.f8466d;
    }

    /* renamed from: c */
    public void m12109c(double d) {
        if (d > this.f8465c) {
            this.f8465c = d;
        }
    }

    /* renamed from: c */
    public void m12108c(String str) {
        this.f8470h = str;
    }

    /* renamed from: d */
    public double m12107d() {
        return this.f8465c;
    }

    /* renamed from: d */
    public void m12106d(double d) {
        if (d > this.f8464b) {
            this.f8464b = d;
        }
    }

    /* renamed from: e */
    public int m12105e() {
        return this.f8463a;
    }

    /* renamed from: f */
    public double m12104f() {
        return this.f8464b;
    }

    /* renamed from: g */
    public String m12103g() {
        return this.f8468f;
    }

    /* renamed from: h */
    public String m12102h() {
        return this.f8469g;
    }

    /* renamed from: i */
    public String m12101i() {
        return this.f8470h;
    }

    /* renamed from: j */
    public void m12100j() {
        this.f8465c = 0.0d;
        this.f8464b = 0.0d;
        this.f8463a = 0;
    }
}
