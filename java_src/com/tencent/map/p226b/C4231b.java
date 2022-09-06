package com.tencent.map.p226b;

import android.location.Location;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.tencent.map.b.b */
/* loaded from: classes.dex */
public class C4231b {

    /* renamed from: b */
    private static C4231b f17559b;

    /* renamed from: i */
    private AbstractC4232a f17567i;

    /* renamed from: c */
    private double f17561c = 0.0d;

    /* renamed from: d */
    private double f17562d = 0.0d;

    /* renamed from: e */
    private double f17563e = 0.0d;

    /* renamed from: f */
    private double f17564f = 0.0d;

    /* renamed from: g */
    private double f17565g = 0.0d;

    /* renamed from: h */
    private double f17566h = 0.0d;

    /* renamed from: j */
    private C4233b f17568j = null;

    /* renamed from: k */
    private boolean f17569k = false;

    /* renamed from: a */
    public String f17560a = "";

    /* renamed from: com.tencent.map.b.b$a */
    /* loaded from: classes.dex */
    public interface AbstractC4232a {
        /* renamed from: a */
        void mo5766a(double d, double d2);
    }

    /* renamed from: com.tencent.map.b.b$b */
    /* loaded from: classes.dex */
    public class C4233b extends Thread {
        public C4233b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                byte[] m5687a = C4259j.m5687a(C4231b.this.f17560a.getBytes());
                C4231b.this.f17569k = true;
                C4264n m5805a = C4231b.m5805a("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", m5687a);
                C4231b.this.f17569k = false;
                C4231b.m5807a(C4231b.this, C4259j.m5686b(m5805a.f17736a), m5805a.f17737b);
            } catch (Exception e) {
                int i = 0;
                while (true) {
                    i++;
                    if (i > 3) {
                        C4231b.this.f17569k = false;
                        if (C4231b.this.f17567i == null) {
                            return;
                        }
                        C4231b.this.f17567i.mo5766a(360.0d, 360.0d);
                        return;
                    }
                    try {
                        sleep(2000L);
                        C4264n m5805a2 = C4231b.m5805a("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", C4259j.m5687a(C4231b.this.f17560a.getBytes()));
                        C4231b.this.f17569k = false;
                        C4231b.m5807a(C4231b.this, C4259j.m5686b(m5805a2.f17736a), m5805a2.f17737b);
                        return;
                    } catch (Exception e2) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static C4231b m5811a() {
        if (f17559b == null) {
            f17559b = new C4231b();
        }
        return f17559b;
    }

    /* renamed from: a */
    public static C4264n m5805a(String str, String str2, byte[] bArr) {
        boolean z = true;
        if (C4262l.m5673b() == null) {
            z = false;
        }
        if (!z) {
            throw new C4265o();
        }
        try {
            return C4267q.m5664a(false, str, str2, null, bArr, false, true);
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5807a(C4231b c4231b, byte[] bArr, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(new String(bArr, str));
        } catch (Exception e) {
            if (c4231b.f17567i != null) {
                c4231b.f17567i.mo5766a(360.0d, 360.0d);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(stringBuffer.toString()).getJSONObject("location");
            double d = jSONObject.getDouble("latitude");
            double d2 = jSONObject.getDouble("longitude");
            c4231b.f17565g = d - c4231b.f17563e;
            c4231b.f17566h = d2 - c4231b.f17564f;
            c4231b.f17561c = c4231b.f17563e;
            c4231b.f17562d = c4231b.f17564f;
            if (c4231b.f17567i == null) {
                return;
            }
            c4231b.f17567i.mo5766a(d, d2);
        } catch (JSONException e2) {
            if (c4231b.f17567i == null) {
                return;
            }
            c4231b.f17567i.mo5766a(360.0d, 360.0d);
        }
    }

    /* renamed from: a */
    public static boolean m5806a(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: a */
    public final void m5810a(double d, double d2, AbstractC4232a abstractC4232a) {
        this.f17567i = abstractC4232a;
        if (this.f17565g != 0.0d && this.f17566h != 0.0d) {
            float[] fArr = new float[10];
            Location.distanceBetween(d, d2, this.f17561c, this.f17562d, fArr);
            if (fArr[0] < 1500.0f) {
                this.f17567i.mo5766a(this.f17565g + d, this.f17566h + d2);
                return;
            }
        }
        if (!this.f17569k) {
            this.f17560a = "{\"source\":101,\"access_token\":\"160e7bd42dec9428721034e0146fc6dd\",\"location\":{\"latitude\":" + d + ",\"longitude\":" + d2 + "}\t}";
            this.f17563e = d;
            this.f17564f = d2;
            this.f17568j = new C4233b();
            this.f17568j.start();
        }
    }
}
