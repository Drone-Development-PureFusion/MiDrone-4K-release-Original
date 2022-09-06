package com.fimi.soul.biz.p168a;

import android.text.TextUtils;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.EnumC2222d;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.kernel.p157b.p161d.C2225c;
import com.fimi.kernel.p157b.p161d.C2227d;
import com.fimi.kernel.utils.C2269n;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.RelayEntity;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.module.update.p210a.C3583e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.a.c */
/* loaded from: classes.dex */
public class C2364c implements AbstractC2221d {

    /* renamed from: b */
    private static C2364c f8007b = new C2364c();

    /* renamed from: a */
    int f8008a;

    /* renamed from: d */
    private String f8010d;

    /* renamed from: e */
    private String f8011e;

    /* renamed from: f */
    private JSONObject f8012f = null;

    /* renamed from: g */
    private List<AbstractC2366a> f8013g = new ArrayList();

    /* renamed from: c */
    private C2225c f8009c = (C2225c) C2238c.m13128a(EnumC2222d.Socket);

    /* renamed from: com.fimi.soul.biz.a.c$a */
    /* loaded from: classes.dex */
    public interface AbstractC2366a {
        /* renamed from: a */
        void mo7974a(RelayEntity relayEntity);
    }

    private C2364c() {
        C2227d m13167f = this.f8009c.m13167f();
        m13167f.a(C2427e.m12219c());
        m13167f.a(8080);
        m13167f.m13162b(C2227d.f7442b);
        m13167f.m13160b(true);
        m13167f.m13163a(true);
        this.f8009c.m13177b(this);
    }

    /* renamed from: a */
    public static synchronized C2364c m12469a() {
        C2364c c2364c;
        synchronized (C2364c.class) {
            if (f8007b == null) {
                f8007b = new C2364c();
            }
            c2364c = f8007b;
        }
        return c2364c;
    }

    /* renamed from: a */
    public void m12468a(AbstractC2366a abstractC2366a) {
        this.f8013g.add(abstractC2366a);
    }

    @Override // com.fimi.kernel.p157b.p160c.AbstractC2221d
    /* renamed from: a */
    public void mo6431a(String str) {
        if (!TextUtils.isEmpty(str)) {
            RelayEntity relayEntity = new RelayEntity();
            C2654j.m11357c("msg:" + str);
            try {
                this.f8012f = new JSONObject(str);
                this.f8012f = new JSONObject(this.f8012f.getJSONObject("system").toString());
                this.f8010d = this.f8012f.optString("device_type");
                relayEntity.setDevice_type(this.f8010d);
                if (TextUtils.isEmpty(this.f8011e) && !TextUtils.isEmpty(this.f8012f.getString("sw_version"))) {
                    int i = this.f8012f.getString("sw_version").startsWith("X6E") ? 14 : 25;
                    C3579a.m7971a().m7968a(new C3583e(this.f8011e, i, Integer.valueOf(C2269n.m12875n(this.f8012f.getString("sw_version"))).intValue()));
                    C3579a.m7971a().m7969a(i, Integer.valueOf(C2269n.m12875n(this.f8012f.getString("sw_version"))).intValue());
                }
                this.f8011e = this.f8012f.getString("sw_version");
                this.f8008a = this.f8012f.getInt("firmupg_finished");
                relayEntity.setFirmupg_finished(this.f8008a);
                relayEntity.setSw_version(this.f8011e);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f8013g == null || this.f8013g.size() <= 0) {
                return;
            }
            for (AbstractC2366a abstractC2366a : this.f8013g) {
                abstractC2366a.mo7974a(relayEntity);
            }
        }
    }

    /* renamed from: b */
    public void m12466b() {
        C2281x.m12704a(new Runnable() { // from class: com.fimi.soul.biz.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                C2364c.this.f8009c.m13171d();
            }
        });
    }

    /* renamed from: b */
    public void m12465b(AbstractC2366a abstractC2366a) {
        this.f8013g.remove(abstractC2366a);
    }

    /* renamed from: b */
    public void m12464b(String str) {
        this.f8011e = str;
    }

    /* renamed from: c */
    public int m12463c() {
        return this.f8008a;
    }

    /* renamed from: d */
    public boolean m12462d() {
        return this.f8008a > 0;
    }

    /* renamed from: e */
    public String m12461e() {
        C3580b c3580b;
        return (!TextUtils.isEmpty(this.f8011e) || (c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class)) == null) ? C2269n.m12875n(this.f8011e) + "" : c3580b.m7939k() + "";
    }

    /* renamed from: f */
    public C2225c m12460f() {
        return this.f8009c;
    }
}
