package com.fimi.p154i;

import android.util.Log;
import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p145f.C2112b;
import com.fimi.p147d.AbstractC2119b;
import com.fimi.p148e.p149a.C2125d;
import com.fimi.p148e.p150b.C2132b;
import com.fimi.p151f.C2139b;
import com.fimi.p151f.C2145d;
import com.fimi.p152g.C2148b;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3583e;
import com.xiaomi.mipush.sdk.Constants;
/* renamed from: com.fimi.i.a */
/* loaded from: classes.dex */
public class C2158a implements AbstractC2119b {

    /* renamed from: a */
    public static final int f7256a = 0;

    /* renamed from: b */
    public static final int f7257b = 1;

    /* renamed from: e */
    private AbstractC2160a f7260e;

    /* renamed from: d */
    private String f7259d = "";

    /* renamed from: c */
    C2423d f7258c = (C2423d) C2379b.m12410a().m12394d();

    /* renamed from: com.fimi.i.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC2160a {
        /* renamed from: a */
        void m13379a(String str);
    }

    public C2158a() {
        C2139b.m13466b().m13468a(this);
    }

    /* renamed from: a */
    public void m13387a() {
        C2139b.m13466b().m13465b(this);
    }

    /* renamed from: a */
    public void m13386a(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // com.fimi.p147d.AbstractC2119b
    /* renamed from: a */
    public void mo6481a(int i, C2104c c2104c) {
        AbstractC2103b m13702g = c2104c.m13702g();
        if (m13702g instanceof C2125d) {
            C2125d c2125d = (C2125d) m13702g;
            c2125d.m13549l();
            C2161b c2161b = new C2161b(c2125d.b(), c2125d.m13548m(), c2125d.m13550k(), c2125d.m13549l(), c2125d.m13553h(), c2125d.m13552i(), c2125d.m13551j(), null);
            c2161b.m13368j();
            C2163d.m13353a().m13351a(c2161b);
            byte[] bArr = new byte[12];
            System.arraycopy(c2125d.m13553h(), 0, bArr, 0, 4);
            System.arraycopy(c2125d.m13552i(), 0, bArr, 4, 4);
            System.arraycopy(c2125d.m13551j(), 0, bArr, 8, 4);
            String m13657a = C2112b.m13657a(bArr);
            C3579a.m7971a().m7968a(new C3583e(c2125d.b(), c2125d.m13548m(), c2125d.m13549l(), String.valueOf(c2125d.m13550k()), c2125d.m13553h(), c2125d.m13552i(), c2125d.m13551j(), new byte[4]));
            C3579a.m7971a().m7969a(c2125d.b(), c2125d.m13549l());
            this.f7259d += "T: " + ((int) c2125d.b()) + " " + c2125d.m13548m() + " V: " + c2125d.m13549l() + " [" + m13657a + "]\n";
            Log.i("zhej", "versionInfo:" + this.f7259d);
        }
    }

    /* renamed from: a */
    public void m13385a(AbstractC2160a abstractC2160a) {
        this.f7260e = abstractC2160a;
    }

    /* renamed from: a */
    public void m13384a(byte[] bArr) {
        C2145d.m13447b().m13448a(bArr, bArr.length);
    }

    /* renamed from: b */
    public void m13383b() {
        this.f7258c.m12233u().m12281k();
        C2148b.m13440a().m13438a(new Runnable() { // from class: com.fimi.i.a.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.i("zhej", "run: " + C3579a.m7971a().m7970a(3).m7912d() + Constants.ACCEPT_TIME_SEPARATOR_SP + C3579a.m7971a().m7970a(8).m7912d());
                    if (C3579a.m7971a().m7970a(3).m7912d() == 0) {
                        C2158a.this.m13382c();
                        C2158a.this.m13386a(500);
                    }
                    if (C3579a.m7971a().m7970a(8).m7912d() == 0) {
                        C2158a.this.m13381d();
                        C2158a.this.m13386a(1000);
                    }
                    if (C3579a.m7971a().m7970a(6).m7912d() == 0) {
                        C2158a.this.m13380e();
                        C2158a.this.m13386a(1000);
                    }
                }
            }
        });
        if (this.f7260e != null) {
            this.f7260e.m13379a(this.f7259d);
        }
    }

    /* renamed from: c */
    public void m13382c() {
        C2132b c2132b = new C2132b();
        c2132b.c(2);
        c2132b.d(1);
        c2132b.a(0);
        c2132b.b(C2132b.f7144a);
        c2132b.mo13507a((byte) 3);
        m13384a(c2132b.mo13473g().m13703f());
    }

    /* renamed from: d */
    public void m13381d() {
        C2132b c2132b = new C2132b();
        c2132b.c(3);
        c2132b.d(1);
        c2132b.a(0);
        c2132b.b(C2132b.f7144a);
        c2132b.mo13507a((byte) 8);
        m13384a(c2132b.mo13473g().m13703f());
    }

    /* renamed from: e */
    public void m13380e() {
        C2132b c2132b = new C2132b();
        c2132b.c(2);
        c2132b.d(1);
        c2132b.a(0);
        c2132b.b(C2132b.f7144a);
        c2132b.mo13507a((byte) 6);
        m13384a(c2132b.mo13473g().m13703f());
    }
}
