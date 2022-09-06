package com.fimi.soul.biz.p168a;

import android.text.TextUtils;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.EnumC2222d;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.kernel.p157b.p161d.C2225c;
import com.fimi.kernel.p157b.p161d.C2227d;
import com.fimi.kernel.utils.C2269n;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.RelayEntity;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.entity.DeviceType;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.module.update.p210a.C3583e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.a.d */
/* loaded from: classes.dex */
public class C2367d implements AbstractC2221d {

    /* renamed from: b */
    private static C2367d f8015b = new C2367d();

    /* renamed from: a */
    int f8016a;

    /* renamed from: d */
    private String f8018d;

    /* renamed from: e */
    private String f8019e;

    /* renamed from: g */
    private int f8021g;

    /* renamed from: k */
    private boolean f8025k;

    /* renamed from: l */
    private String f8026l;

    /* renamed from: m */
    private String f8027m;

    /* renamed from: f */
    private volatile String f8020f = "5G";

    /* renamed from: h */
    private boolean f8022h = false;

    /* renamed from: i */
    private boolean f8023i = false;

    /* renamed from: j */
    private JSONObject f8024j = null;

    /* renamed from: n */
    private List<AbstractC2369a> f8028n = new ArrayList();

    /* renamed from: c */
    private C2225c f8017c = (C2225c) C2238c.m13128a(EnumC2222d.Socket);

    /* renamed from: com.fimi.soul.biz.a.d$a */
    /* loaded from: classes.dex */
    public interface AbstractC2369a {
        /* renamed from: a */
        void mo7975a(RelayEntity relayEntity);
    }

    private C2367d() {
        C2227d m13167f = this.f8017c.m13167f();
        m13167f.a(C2427e.m12220b());
        m13167f.a(8080);
        m13167f.m13162b(C2227d.f7442b);
        m13167f.m13160b(true);
        m13167f.m13163a(true);
        this.f8017c.m13177b(this);
    }

    /* renamed from: a */
    public static synchronized C2367d m12459a() {
        C2367d c2367d;
        synchronized (C2367d.class) {
            if (f8015b == null) {
                f8015b = new C2367d();
            }
            c2367d = f8015b;
        }
        return c2367d;
    }

    /* renamed from: f */
    private void m12443f(String str) {
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).get("fwdap");
            this.f8026l = jSONObject.getString("ssid");
            this.f8027m = jSONObject.getString("key");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m12458a(AbstractC2221d abstractC2221d) {
        this.f8017c.m13177b(abstractC2221d);
    }

    /* renamed from: a */
    public void m12457a(AbstractC2369a abstractC2369a) {
        this.f8028n.add(abstractC2369a);
    }

    @Override // com.fimi.kernel.p157b.p160c.AbstractC2221d
    /* renamed from: a */
    public void mo6431a(String str) {
        if (!TextUtils.isEmpty(str)) {
            C2654j.m11362b(str);
            this.f8023i = true;
            RelayEntity relayEntity = new RelayEntity();
            try {
                this.f8024j = new JSONObject(str);
                String jSONObject = this.f8024j.getJSONObject("system").toString();
                String jSONObject2 = this.f8024j.getJSONObject("camera").toString();
                this.f8024j = new JSONObject(jSONObject);
                this.f8020f = this.f8024j.optString("device_type");
                relayEntity.setDevice_type(this.f8020f);
                if (!this.f8025k) {
                    if ("4K".equalsIgnoreCase(this.f8020f)) {
                        C2277v.m12784a(DroidPlannerApp.m12520g()).m12762f(DeviceType.DEVICE_4K);
                    } else {
                        C2277v.m12784a(DroidPlannerApp.m12520g()).m12762f(DeviceType.DEVICE_1080P);
                    }
                    this.f8025k = true;
                }
                if (TextUtils.isEmpty(this.f8018d) && !TextUtils.isEmpty(this.f8024j.getString("sw_version"))) {
                    if ("4K".equalsIgnoreCase(this.f8020f)) {
                        if (this.f8024j.getString("sw_version").startsWith("X6E")) {
                        }
                        C3579a.m7971a().m7968a(new C3583e(this.f8019e, 15, Integer.valueOf(C2269n.m12875n(this.f8024j.getString("sw_version"))).intValue()));
                        C3579a.m7971a().m7969a(15, Integer.valueOf(C2269n.m12875n(this.f8024j.getString("sw_version"))).intValue());
                    } else {
                        C3579a.m7971a().m7968a(new C3583e(this.f8019e, 11, Integer.valueOf(C2269n.m12875n(this.f8024j.getString("sw_version"))).intValue()));
                        C3579a.m7971a().m7969a(11, Integer.valueOf(C2269n.m12875n(this.f8024j.getString("sw_version"))).intValue());
                    }
                }
                this.f8018d = this.f8024j.getString("sw_version");
                this.f8019e = this.f8024j.getString("hw_version");
                this.f8016a = this.f8024j.getInt("firmupg_finished");
                relayEntity.setFirmupg_finished(this.f8016a);
                relayEntity.setHw_version(this.f8019e);
                relayEntity.setSw_version(this.f8018d);
                this.f8024j = new JSONObject(jSONObject2);
                this.f8021g = this.f8024j.getInt("quality");
                this.f8022h = this.f8024j.getBoolean("connected");
                relayEntity.setQuality(this.f8021g);
                relayEntity.setIsConnectCamera(this.f8022h);
                if (str.contains("fwdap")) {
                    m12443f(str);
                } else {
                    this.f8026l = null;
                    this.f8027m = null;
                }
            } catch (JSONException e) {
                C2654j.m11362b("e:" + e.getMessage().toString());
                e.printStackTrace();
            }
            if (this.f8028n == null || this.f8028n.size() <= 0) {
                return;
            }
            for (AbstractC2369a abstractC2369a : this.f8028n) {
                abstractC2369a.mo7975a(relayEntity);
            }
        }
    }

    /* renamed from: a */
    public void m12455a(boolean z) {
        this.f8022h = z;
    }

    /* renamed from: b */
    public void m12454b() {
        this.f8017c.m13165g();
        this.f8017c.m13171d();
    }

    /* renamed from: b */
    public void m12453b(AbstractC2369a abstractC2369a) {
        this.f8028n.remove(abstractC2369a);
    }

    /* renamed from: b */
    public void m12452b(String str) {
        this.f8018d = str;
    }

    /* renamed from: b */
    public void m12451b(boolean z) {
        this.f8023i = z;
        if (!z) {
            this.f8025k = false;
        }
    }

    /* renamed from: c */
    public void m12450c() {
        C2281x.m12704a(new Runnable() { // from class: com.fimi.soul.biz.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                C2367d.this.f8017c.m13171d();
            }
        });
    }

    /* renamed from: c */
    public void m12449c(String str) {
        this.f8020f = str;
    }

    /* renamed from: d */
    public String m12448d() {
        C3580b c3580b;
        return (!TextUtils.isEmpty(this.f8018d) || (c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class)) == null) ? this.f8018d : c3580b.m7951e() + "";
    }

    /* renamed from: d */
    public void m12447d(String str) {
        this.f8027m = str;
    }

    /* renamed from: e */
    public String m12446e() {
        return this.f8019e;
    }

    /* renamed from: e */
    public void m12445e(String str) {
        this.f8026l = str;
    }

    /* renamed from: f */
    public int m12444f() {
        return this.f8021g;
    }

    /* renamed from: g */
    public int m12442g() {
        return this.f8016a;
    }

    /* renamed from: h */
    public boolean m12441h() {
        return this.f8016a > 0;
    }

    /* renamed from: i */
    public boolean m12440i() {
        return "4K".equalsIgnoreCase(this.f8020f);
    }

    /* renamed from: j */
    public boolean m12439j() {
        return TextUtils.isEmpty(this.f8020f);
    }

    /* renamed from: k */
    public boolean m12438k() {
        return "4K".equalsIgnoreCase(this.f8020f);
    }

    /* renamed from: l */
    public boolean m12437l() {
        return "5G".equalsIgnoreCase(this.f8020f);
    }

    /* renamed from: m */
    public boolean m12436m() {
        return this.f8022h;
    }

    /* renamed from: n */
    public boolean m12435n() {
        return this.f8023i;
    }

    /* renamed from: o */
    public C2225c m12434o() {
        return this.f8017c;
    }

    /* renamed from: p */
    public String m12433p() {
        return this.f8027m;
    }

    /* renamed from: q */
    public String m12432q() {
        return this.f8026l;
    }
}
