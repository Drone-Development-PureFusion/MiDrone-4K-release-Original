package com.fimi.soul.utils;

import android.content.Context;
import android.text.TextUtils;
import com.fimi.kernel.C2238c;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2613z;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.User;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.receiver.NetworkStateReceiver;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FlyLogTools extends NetworkStateReceiver {

    /* renamed from: c */
    public static FlyLogTools f14737c;

    /* renamed from: d */
    static long f14738d;

    /* renamed from: b */
    C3707w f14739b;

    /* renamed from: e */
    private Context f14740e;

    /* renamed from: com.fimi.soul.utils.FlyLogTools$a */
    /* loaded from: classes.dex */
    public interface AbstractC3620a {
        /* renamed from: a */
        void mo7772a();
    }

    /* renamed from: com.fimi.soul.utils.FlyLogTools$b */
    /* loaded from: classes.dex */
    private class C3621b implements AbstractC2538k {

        /* renamed from: b */
        private String f14746b;

        /* renamed from: c */
        private AbstractC3620a f14747c;

        public C3621b(String str, AbstractC3620a abstractC3620a) {
            this.f14746b = str;
            this.f14747c = abstractC3620a;
        }

        @Override // com.fimi.soul.biz.p183l.AbstractC2538k
        /* renamed from: a */
        public void mo6501a(PlaneMsg planeMsg, File file) {
            if (planeMsg.isSuccess()) {
                if (FlyLogTools.this.f14739b == null || "".equals(this.f14746b)) {
                    return;
                }
                FlyLogTools.this.f14739b.m7406b(this.f14746b);
            }
            if (this.f14747c != null) {
                this.f14747c.mo7772a();
            }
        }
    }

    public FlyLogTools() {
    }

    public FlyLogTools(Context context) {
        this.f14739b = C3707w.m7410a(context);
    }

    /* renamed from: a */
    public static FlyLogTools m7776a(Context context) {
        if (f14737c == null) {
            f14737c = new FlyLogTools(context);
        }
        return f14737c;
    }

    /* renamed from: a */
    public void m7775a(final AbstractC2538k abstractC2538k) {
        try {
            new Thread(new Runnable() { // from class: com.fimi.soul.utils.FlyLogTools.1
                @Override // java.lang.Runnable
                public void run() {
                    Context m13131a = C2238c.m13131a();
                    if (m13131a == null) {
                        return;
                    }
                    C2613z m11525a = C2613z.m11525a(m13131a);
                    String m7905i = C3579a.m7971a().m7970a(0).m7905i();
                    User m12507c = C2353b.m12507c(m13131a);
                    if (m12507c == null && TextUtils.isEmpty(m12507c.getUserID())) {
                        return;
                    }
                    C2238c.m13125c();
                    m11525a.m11504d(m7905i, m12507c.getUserID(), abstractC2538k);
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fimi.soul.receiver.NetworkStateReceiver
    /* renamed from: a */
    public void mo7774a(NetworkStateReceiver.EnumC3591a enumC3591a, Context context) {
        if (enumC3591a == NetworkStateReceiver.EnumC3591a.Wifi || enumC3591a == NetworkStateReceiver.EnumC3591a.Mobile) {
            this.f14740e = context;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f14738d < 1000) {
                return;
            }
            f14738d = currentTimeMillis;
            m7773a((AbstractC3620a) null);
        }
    }

    /* renamed from: a */
    public void m7773a(final AbstractC3620a abstractC3620a) {
        try {
            new Thread(new Runnable() { // from class: com.fimi.soul.utils.FlyLogTools.2
                @Override // java.lang.Runnable
                public void run() {
                    Context m13131a = C2238c.m13131a();
                    if (m13131a == null) {
                        return;
                    }
                    C2613z m11525a = C2613z.m11525a(m13131a);
                    String m7905i = C3579a.m7971a().m7970a(0).m7905i();
                    User m12507c = C2353b.m12507c(m13131a);
                    if (m12507c == null && TextUtils.isEmpty(m12507c.getUserID())) {
                        return;
                    }
                    String userID = m12507c.getUserID();
                    FlyLogTools.this.f14739b = C3707w.m7410a(m13131a);
                    synchronized (FlyLogTools.this.f14739b) {
                        List<C3709x> m7408a = FlyLogTools.this.f14739b.m7408a(m12507c.getUserID());
                        if (m7408a != null && m7408a.size() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            try {
                                for (C3709x c3709x : m7408a) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("planeID", m7905i);
                                    jSONObject.put("flyTime", c3709x.m7395d());
                                    jSONObject.put("flyJourney", c3709x.m7394e());
                                    jSONObject.put("userID", userID);
                                    jSONObject.put("clientType", "0");
                                    jSONObject.put("deviceType", c3709x.m7405a());
                                    jSONObject.put("latitude", c3709x.m7393f());
                                    jSONObject.put("longitude", c3709x.m7392g());
                                    jSONArray.put(jSONObject);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            m11525a.m11511b(jSONArray.toString(), new C3621b(userID, abstractC3620a));
                        } else if (abstractC3620a != null) {
                            abstractC3620a.mo7772a();
                        }
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
