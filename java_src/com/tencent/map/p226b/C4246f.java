package com.tencent.map.p226b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.fimi.soul.utils.C3670av;
import com.tencent.map.p224a.p225a.C4226b;
import com.tencent.map.p224a.p225a.C4227c;
import com.tencent.map.p224a.p225a.C4228d;
import com.tencent.map.p226b.C4231b;
import com.tencent.map.p226b.C4237d;
import com.tencent.map.p226b.C4242e;
import com.tencent.map.p226b.C4252g;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.tencent.map.b.f */
/* loaded from: classes.dex */
public final class C4246f implements C4231b.AbstractC4232a, C4237d.AbstractC4241c, C4242e.AbstractC4245c, C4252g.AbstractC4256c {

    /* renamed from: t */
    private static boolean f17631t = false;

    /* renamed from: u */
    private static C4246f f17632u = null;

    /* renamed from: c */
    private C4242e f17651c;

    /* renamed from: d */
    private C4237d f17652d;

    /* renamed from: e */
    private C4252g f17653e;

    /* renamed from: k */
    private int f17659k;

    /* renamed from: l */
    private int f17660l;

    /* renamed from: m */
    private int f17661m;

    /* renamed from: a */
    private long f17649a = 5000;

    /* renamed from: b */
    private Context f17650b = null;

    /* renamed from: f */
    private int f17654f = 1024;

    /* renamed from: g */
    private int f17655g = 4;

    /* renamed from: h */
    private C4234c f17656h = null;

    /* renamed from: i */
    private C4231b f17657i = null;

    /* renamed from: j */
    private C4226b f17658j = null;

    /* renamed from: n */
    private byte[] f17662n = new byte[0];

    /* renamed from: o */
    private byte[] f17663o = new byte[0];

    /* renamed from: p */
    private boolean f17664p = false;

    /* renamed from: q */
    private HandlerC4251c f17665q = null;

    /* renamed from: r */
    private C4250b f17666r = null;

    /* renamed from: s */
    private C4249a f17667s = null;

    /* renamed from: v */
    private long f17668v = -1;

    /* renamed from: w */
    private C4242e.C4244b f17669w = null;

    /* renamed from: x */
    private C4237d.C4240b f17670x = null;

    /* renamed from: y */
    private C4252g.C4255b f17671y = null;

    /* renamed from: z */
    private C4228d f17672z = null;

    /* renamed from: A */
    private C4228d f17633A = null;

    /* renamed from: B */
    private int f17634B = 0;

    /* renamed from: C */
    private int f17635C = 0;

    /* renamed from: D */
    private int f17636D = 1;

    /* renamed from: E */
    private String f17637E = "";

    /* renamed from: F */
    private String f17638F = "";

    /* renamed from: G */
    private String f17639G = "";

    /* renamed from: H */
    private String f17640H = "";

    /* renamed from: I */
    private String f17641I = "";

    /* renamed from: J */
    private String f17642J = "";

    /* renamed from: K */
    private boolean f17643K = false;

    /* renamed from: L */
    private boolean f17644L = false;

    /* renamed from: M */
    private long f17645M = 0;

    /* renamed from: N */
    private Handler f17646N = null;

    /* renamed from: O */
    private Runnable f17647O = new Runnable() { // from class: com.tencent.map.b.f.1
        @Override // java.lang.Runnable
        public final void run() {
            if (System.currentTimeMillis() - C4246f.this.f17645M < 8000) {
                return;
            }
            if (!C4246f.this.f17653e.m5710b() || !C4246f.this.f17653e.m5708c()) {
                C4246f.this.m5739d();
            } else {
                C4246f.this.f17653e.m5714a(0L);
            }
        }
    };

    /* renamed from: P */
    private final BroadcastReceiver f17648P = new BroadcastReceiver() { // from class: com.tencent.map.b.f.2
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("noConnectivity", false) || C4246f.this.f17665q == null) {
                return;
            }
            C4246f.this.f17665q.sendEmptyMessage(256);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.map.b.f$a */
    /* loaded from: classes.dex */
    public class C4249a extends Thread {

        /* renamed from: a */
        private C4242e.C4244b f17675a;

        /* renamed from: b */
        private C4237d.C4240b f17676b;

        /* renamed from: c */
        private C4252g.C4255b f17677c;

        C4249a(C4242e.C4244b c4244b, C4237d.C4240b c4240b, C4252g.C4255b c4255b) {
            this.f17675a = null;
            this.f17676b = null;
            this.f17677c = null;
            if (c4244b != null) {
                this.f17675a = (C4242e.C4244b) c4244b.clone();
            }
            if (c4240b != null) {
                this.f17676b = (C4237d.C4240b) c4240b.clone();
            }
            if (c4255b != null) {
                this.f17677c = (C4252g.C4255b) c4255b.clone();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            if (!C4246f.f17631t) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) C4246f.this.f17650b.getSystemService("phone");
                    C4246f.this.f17637E = telephonyManager.getDeviceId();
                    C4246f.this.f17638F = telephonyManager.getSubscriberId();
                    C4246f.this.f17639G = telephonyManager.getLine1Number();
                    Pattern compile = Pattern.compile("[0-9a-zA-Z+-]*");
                    C4246f.this.f17637E = C4246f.this.f17637E == null ? "" : C4246f.this.f17637E;
                    if (compile.matcher(C4246f.this.f17637E).matches()) {
                        C4246f.this.f17637E = C4246f.this.f17637E == null ? "" : C4246f.this.f17637E;
                    } else {
                        C4246f.this.f17637E = "";
                    }
                    C4246f.this.f17638F = C4246f.this.f17638F == null ? "" : C4246f.this.f17638F;
                    if (compile.matcher(C4246f.this.f17638F).matches()) {
                        C4246f.this.f17638F = C4246f.this.f17638F == null ? "" : C4246f.this.f17638F;
                    } else {
                        C4246f.this.f17638F = "";
                    }
                    C4246f.this.f17639G = C4246f.this.f17639G == null ? "" : C4246f.this.f17639G;
                    if (compile.matcher(C4246f.this.f17639G).matches()) {
                        C4246f.this.f17639G = C4246f.this.f17639G == null ? "" : C4246f.this.f17639G;
                    } else {
                        C4246f.this.f17639G = "";
                    }
                } catch (Exception e) {
                }
                boolean unused = C4246f.f17631t = true;
                C4246f.this.f17637E = C4246f.this.f17637E == null ? "" : C4246f.this.f17637E;
                C4246f.this.f17638F = C4246f.this.f17638F == null ? "" : C4246f.this.f17638F;
                C4246f.this.f17639G = C4246f.this.f17639G == null ? "" : C4246f.this.f17639G;
                C4246f.this.f17641I = C4259j.m5688a(C4246f.this.f17637E == null ? "0123456789ABCDEF" : C4246f.this.f17637E);
            }
            String m5693a = C4246f.this.f17655g == 4 ? C4258i.m5693a(this.f17677c) : "[]";
            String m5695a = C4258i.m5695a(this.f17676b, C4246f.this.f17652d.m5791b());
            String m5691a = C4258i.m5691a(C4246f.this.f17637E, C4246f.this.f17638F, C4246f.this.f17639G, C4246f.this.f17640H, C4246f.this.f17643K);
            C4246f.this.f17665q.sendMessage(C4246f.this.f17665q.obtainMessage(16, (("{\"version\":\"1.1.8\",\"address\":" + C4246f.this.f17660l) + ",\"source\":203,\"access_token\":\"" + C4246f.this.f17641I + "\",\"app_name\":\"" + C4246f.this.f17642J + "\",\"bearing\":1") + ",\"attribute\":" + m5691a + ",\"location\":" + ((this.f17675a == null || !this.f17675a.m5769a()) ? "{}" : C4258i.m5694a(this.f17675a)) + ",\"cells\":" + m5695a + ",\"wifis\":" + m5693a + "}"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.map.b.f$b */
    /* loaded from: classes.dex */
    public class C4250b extends Thread {

        /* renamed from: a */
        private String f17679a;

        /* renamed from: b */
        private String f17680b;

        /* renamed from: c */
        private String f17681c = null;

        public C4250b(String str) {
            this.f17679a = null;
            this.f17680b = null;
            this.f17679a = str;
            this.f17680b = (C4246f.this.f17636D == 0 ? "http://lstest.map.soso.com/loc?c=1" : "http://lbs.map.qq.com/loc?c=1") + "&mars=" + C4246f.this.f17661m;
        }

        /* renamed from: a */
        private String m5716a(byte[] bArr, String str) {
            C4246f.this.f17645M = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append(new String(bArr, str));
                return stringBuffer.toString();
            } catch (Exception e) {
                return null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Message message = new Message();
            message.what = 8;
            try {
                byte[] m5687a = C4259j.m5687a(this.f17679a.getBytes());
                C4246f.this.f17664p = true;
                C4264n m5805a = C4231b.m5805a(this.f17680b, "SOSO MAP LBS SDK", m5687a);
                C4246f.this.f17664p = false;
                this.f17681c = m5716a(C4259j.m5686b(m5805a.f17736a), m5805a.f17737b);
                if (this.f17681c != null) {
                    message.arg1 = 0;
                    message.obj = this.f17681c;
                } else {
                    message.arg1 = 1;
                }
            } catch (Exception e) {
                int i = 0;
                while (true) {
                    i++;
                    if (i > 3) {
                        break;
                    }
                    try {
                        sleep(1000L);
                        byte[] m5687a2 = C4259j.m5687a(this.f17679a.getBytes());
                        C4246f.this.f17664p = true;
                        C4264n m5805a2 = C4231b.m5805a(this.f17680b, "SOSO MAP LBS SDK", m5687a2);
                        C4246f.this.f17664p = false;
                        this.f17681c = m5716a(C4259j.m5686b(m5805a2.f17736a), m5805a2.f17737b);
                        if (this.f17681c != null) {
                            message.arg1 = 0;
                            message.obj = this.f17681c;
                        } else {
                            message.arg1 = 1;
                        }
                    } catch (Exception e2) {
                    }
                }
                C4246f.this.f17664p = false;
                message.arg1 = 1;
            }
            C4246f.m5728j(C4246f.this);
            C4246f.this.f17665q.sendMessage(message);
        }
    }

    /* renamed from: com.tencent.map.b.f$c */
    /* loaded from: classes.dex */
    class HandlerC4251c extends Handler {
        public HandlerC4251c() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    C4246f.m5756a(C4246f.this, (C4242e.C4244b) message.obj);
                    return;
                case 2:
                    C4246f.m5757a(C4246f.this, (C4237d.C4240b) message.obj);
                    return;
                case 3:
                    C4246f.m5754a(C4246f.this, (C4252g.C4255b) message.obj);
                    return;
                case 4:
                    C4246f.m5760a(C4246f.this, message.arg1);
                    return;
                case 5:
                    C4246f.m5745b(C4246f.this, message.arg1);
                    return;
                case 6:
                    C4246f.m5758a(C4246f.this, (Location) message.obj);
                    return;
                case 8:
                    if (message.arg1 == 0) {
                        C4246f.this.m5751a((String) message.obj);
                        return;
                    } else if (C4246f.this.f17669w != null && C4246f.this.f17669w.m5769a()) {
                        return;
                    } else {
                        C4246f.this.m5736e();
                        return;
                    }
                case 16:
                    if (message.obj == null) {
                        return;
                    }
                    C4246f.m5753a(C4246f.this, (String) message.obj);
                    C4246f.this.f17667s = null;
                    return;
                case 256:
                    if (C4246f.this.f17634B != 1) {
                        return;
                    }
                    C4246f.this.m5739d();
                    return;
                default:
                    return;
            }
        }
    }

    private C4246f() {
        this.f17651c = null;
        this.f17652d = null;
        this.f17653e = null;
        this.f17651c = new C4242e();
        this.f17652d = new C4237d();
        this.f17653e = new C4252g();
    }

    /* renamed from: a */
    public static synchronized C4246f m5767a() {
        C4246f c4246f;
        synchronized (C4246f.class) {
            if (f17632u == null) {
                f17632u = new C4246f();
            }
            c4246f = f17632u;
        }
        return c4246f;
    }

    /* renamed from: a */
    private static ArrayList<C4227c> m5749a(JSONArray jSONArray) {
        int length = jSONArray.length();
        ArrayList<C4227c> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new C4227c(jSONObject.getString("name"), jSONObject.getString("addr"), jSONObject.getString("catalog"), jSONObject.getDouble("dist"), Double.parseDouble(jSONObject.getString("latitude")), Double.parseDouble(jSONObject.getString("longitude"))));
        }
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ void m5760a(C4246f c4246f, int i) {
        if (i == 0) {
            c4246f.f17669w = null;
        }
        c4246f.f17654f = i == 0 ? 1 : 2;
        if (c4246f.f17658j != null) {
            c4246f.f17658j.mo5386a(c4246f.f17654f);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5758a(C4246f c4246f, Location location) {
        if (location == null || location.getLatitude() > 359.0d || location.getLongitude() > 359.0d) {
            if (c4246f.f17669w == null || !c4246f.f17669w.m5769a()) {
                c4246f.m5736e();
            } else {
                c4246f.m5743b(true);
            }
        }
        c4246f.f17672z = new C4228d();
        c4246f.f17672z.f17556z = 0;
        c4246f.f17672z.f17555y = 0;
        c4246f.f17672z.f17532b = C4258i.m5698a(location.getLatitude(), 6);
        c4246f.f17672z.f17533c = C4258i.m5698a(location.getLongitude(), 6);
        if (c4246f.f17669w != null && c4246f.f17669w.m5769a()) {
            c4246f.f17672z.f17535e = C4258i.m5698a(c4246f.f17669w.m5768b().getAccuracy(), 1);
            c4246f.f17672z.f17534d = C4258i.m5698a(c4246f.f17669w.m5768b().getAltitude(), 1);
            c4246f.f17672z.f17536f = C4258i.m5698a(c4246f.f17669w.m5768b().getSpeed(), 1);
            c4246f.f17672z.f17537g = C4258i.m5698a(c4246f.f17669w.m5768b().getBearing(), 1);
            c4246f.f17672z.f17531a = 0;
        }
        c4246f.f17672z.f17554x = true;
        if (c4246f.f17660l != 0 && c4246f.f17633A != null && c4246f.f17634B == 0) {
            if ((c4246f.f17660l == 3 || c4246f.f17660l == 4) && c4246f.f17660l == c4246f.f17633A.f17556z) {
                c4246f.f17672z.f17539i = c4246f.f17633A.f17539i;
                c4246f.f17672z.f17540j = c4246f.f17633A.f17540j;
                c4246f.f17672z.f17541k = c4246f.f17633A.f17541k;
                c4246f.f17672z.f17542l = c4246f.f17633A.f17542l;
                c4246f.f17672z.f17543m = c4246f.f17633A.f17543m;
                c4246f.f17672z.f17544n = c4246f.f17633A.f17544n;
                c4246f.f17672z.f17545o = c4246f.f17633A.f17545o;
                c4246f.f17672z.f17546p = c4246f.f17633A.f17546p;
                c4246f.f17672z.f17556z = 3;
            }
            if (c4246f.f17660l == 4 && c4246f.f17660l == c4246f.f17633A.f17556z && c4246f.f17633A.f17553w != null) {
                c4246f.f17672z.f17553w = new ArrayList<>();
                Iterator<C4227c> it2 = c4246f.f17633A.f17553w.iterator();
                while (it2.hasNext()) {
                    c4246f.f17672z.f17553w.add(new C4227c(it2.next()));
                }
                c4246f.f17672z.f17556z = 4;
            }
            if (c4246f.f17660l == 7 && c4246f.f17660l == c4246f.f17633A.f17556z) {
                c4246f.f17672z.f17556z = 7;
                c4246f.f17672z.f17538h = c4246f.f17633A.f17538h;
                c4246f.f17672z.f17539i = c4246f.f17633A.f17539i;
                if (c4246f.f17633A.f17538h == 0) {
                    c4246f.f17672z.f17540j = c4246f.f17633A.f17540j;
                    c4246f.f17672z.f17541k = c4246f.f17633A.f17541k;
                    c4246f.f17672z.f17542l = c4246f.f17633A.f17542l;
                    c4246f.f17672z.f17543m = c4246f.f17633A.f17543m;
                    c4246f.f17672z.f17544n = c4246f.f17633A.f17544n;
                    c4246f.f17672z.f17545o = c4246f.f17633A.f17545o;
                    c4246f.f17672z.f17546p = c4246f.f17633A.f17546p;
                } else {
                    c4246f.f17672z.f17547q = c4246f.f17633A.f17547q;
                    c4246f.f17672z.f17548r = c4246f.f17633A.f17548r;
                    c4246f.f17672z.f17549s = c4246f.f17633A.f17549s;
                    c4246f.f17672z.f17550t = c4246f.f17633A.f17550t;
                    c4246f.f17672z.f17551u = c4246f.f17633A.f17551u;
                    c4246f.f17672z.f17552v = c4246f.f17633A.f17552v;
                }
            }
        }
        if (c4246f.f17634B == 0 && c4246f.f17633A == null) {
            return;
        }
        if (c4246f.f17634B != 0) {
            c4246f.f17672z.f17555y = c4246f.f17634B;
        }
        if (System.currentTimeMillis() - c4246f.f17668v < c4246f.f17649a || c4246f.f17658j == null || c4246f.f17659k != 1) {
            return;
        }
        c4246f.f17658j.mo5385a(c4246f.f17672z);
        c4246f.f17668v = System.currentTimeMillis();
    }

    /* renamed from: a */
    static /* synthetic */ void m5757a(C4246f c4246f, C4237d.C4240b c4240b) {
        c4246f.f17670x = c4240b;
        if (c4246f.f17653e != null && c4246f.f17653e.m5710b() && c4246f.f17653e.m5708c()) {
            c4246f.f17653e.m5714a(0L);
            return;
        }
        if (c4246f.f17635C > 0 && !C4258i.m5697a(c4240b.f17606a, c4240b.f17607b, c4240b.f17608c, c4240b.f17609d, c4240b.f17610e)) {
            c4246f.f17635C--;
        }
        c4246f.m5739d();
    }

    /* renamed from: a */
    static /* synthetic */ void m5756a(C4246f c4246f, C4242e.C4244b c4244b) {
        if (c4244b != null) {
            c4246f.f17669w = c4244b;
            if (c4246f.f17659k != 1 || c4246f.f17669w == null || !c4246f.f17669w.m5769a()) {
                return;
            }
            if (c4246f.f17661m == 0) {
                c4246f.m5743b(false);
            } else if (c4246f.f17661m != 1 || c4246f.f17657i == null) {
            } else {
                C4231b c4231b = c4246f.f17657i;
                double latitude = c4246f.f17669w.m5768b().getLatitude();
                double longitude = c4246f.f17669w.m5768b().getLongitude();
                Context context = c4246f.f17650b;
                c4231b.m5810a(latitude, longitude, c4246f);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5754a(C4246f c4246f, C4252g.C4255b c4255b) {
        if (c4255b != null) {
            c4246f.f17671y = c4255b;
            c4246f.m5739d();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5753a(C4246f c4246f, String str) {
        byte[] bArr;
        if (!C4258i.m5689c(str)) {
            if (c4246f.f17635C > 0) {
                c4246f.f17635C--;
            } else if (c4246f.f17659k == 0 && c4246f.f17658j != null) {
                c4246f.f17658j.mo5384a(null, -1);
            } else if (c4246f.f17659k != 1 || c4246f.f17658j == null) {
            } else {
                c4246f.f17672z = new C4228d();
                c4246f.f17634B = 3;
                c4246f.f17672z.f17555y = 3;
                c4246f.f17672z.f17556z = -1;
                c4246f.f17658j.mo5385a(c4246f.f17672z);
            }
        } else if (c4246f.f17659k == 0 && c4246f.f17658j != null) {
            try {
                bArr = str.getBytes();
            } catch (Exception e) {
                bArr = null;
            }
            c4246f.f17658j.mo5384a(bArr, 0);
        } else {
            String m5798b = c4246f.f17656h == null ? null : (c4246f.f17670x == null || c4246f.f17671y == null) ? null : c4246f.f17656h.m5798b(c4246f.f17670x.f17607b, c4246f.f17670x.f17608c, c4246f.f17670x.f17609d, c4246f.f17670x.f17610e, c4246f.f17671y.m5703a());
            if (m5798b != null) {
                c4246f.m5751a(m5798b);
                return;
            }
            if (c4246f.f17656h != null && c4246f.f17670x != null && c4246f.f17671y != null) {
                c4246f.f17656h.m5803a(c4246f.f17670x.f17607b, c4246f.f17670x.f17608c, c4246f.f17670x.f17609d, c4246f.f17670x.f17610e, c4246f.f17671y.m5703a());
            }
            if (c4246f.f17664p) {
                return;
            }
            if (c4246f.f17666r != null) {
                c4246f.f17666r.interrupt();
            }
            c4246f.f17666r = null;
            c4246f.f17666r = new C4250b(str);
            c4246f.f17666r.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5751a(String str) {
        double d;
        int i = 0;
        try {
            this.f17672z = new C4228d();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("location");
            this.f17672z.f17531a = 1;
            this.f17672z.f17532b = C4258i.m5698a(jSONObject2.getDouble("latitude"), 6);
            this.f17672z.f17533c = C4258i.m5698a(jSONObject2.getDouble("longitude"), 6);
            this.f17672z.f17534d = C4258i.m5698a(jSONObject2.getDouble("altitude"), 1);
            this.f17672z.f17535e = C4258i.m5698a(jSONObject2.getDouble("accuracy"), 1);
            this.f17672z.f17554x = this.f17661m == 1;
            String string = jSONObject.getString("bearing");
            int i2 = -100;
            if (string != null && string.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length > 1) {
                i = Integer.parseInt(string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1]);
            }
            if (this.f17670x != null) {
                i2 = this.f17670x.f17611f;
            }
            C4228d c4228d = this.f17672z;
            double d2 = this.f17672z.f17535e;
            if (i >= 6) {
                d = 40.0d;
            } else if (i == 5) {
                d = 60.0d;
            } else if (i == 4) {
                d = 70.0d;
            } else if (i == 3) {
                d = 90.0d;
            } else if (i == 2) {
                d = 110.0d;
            } else {
                d = (i2 < -72 || i != 0) ? d2 <= 100.0d ? ((int) (((d2 - 1.0d) / 10.0d) + 1.0d)) * 10 : (d2 <= 100.0d || d2 > 800.0d) ? ((int) ((0.8d * d2) / 10.0d)) * 10 : ((int) ((0.85d * d2) / 10.0d)) * 10 : ((int) ((0.45d * d2) / 10.0d)) * 10;
            }
            c4228d.f17535e = d;
            this.f17672z.f17556z = 0;
            if ((this.f17660l == 3 || this.f17660l == 4) && this.f17661m == 1) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("details").getJSONObject("subnation");
                this.f17672z.m5816a(jSONObject3.getString("name"));
                this.f17672z.f17543m = jSONObject3.getString("town");
                this.f17672z.f17544n = jSONObject3.getString("village");
                this.f17672z.f17545o = jSONObject3.getString("street");
                this.f17672z.f17546p = jSONObject3.getString("street_no");
                this.f17672z.f17556z = 3;
                this.f17672z.f17538h = 0;
            }
            if (this.f17660l == 4 && this.f17661m == 1) {
                this.f17672z.f17553w = m5749a(jSONObject.getJSONObject("details").getJSONArray("poilist"));
                this.f17672z.f17556z = 4;
            }
            if (this.f17660l == 7 && this.f17661m == 1) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("details");
                int i3 = jSONObject4.getInt("stat");
                JSONObject jSONObject5 = jSONObject4.getJSONObject("subnation");
                if (i3 == 0) {
                    this.f17672z.m5816a(jSONObject5.getString("name"));
                    this.f17672z.f17543m = jSONObject5.getString("town");
                    this.f17672z.f17544n = jSONObject5.getString("village");
                    this.f17672z.f17545o = jSONObject5.getString("street");
                    this.f17672z.f17546p = jSONObject5.getString("street_no");
                } else if (i3 == 1) {
                    this.f17672z.f17539i = jSONObject5.getString("nation");
                    this.f17672z.f17547q = jSONObject5.getString("admin_level_1");
                    this.f17672z.f17548r = jSONObject5.getString("admin_level_2");
                    this.f17672z.f17549s = jSONObject5.getString("admin_level_3");
                    this.f17672z.f17550t = jSONObject5.getString("locality");
                    this.f17672z.f17551u = jSONObject5.getString("sublocality");
                    this.f17672z.f17552v = jSONObject5.getString(C3670av.f14874a);
                }
                this.f17672z.f17538h = i3;
                this.f17672z.f17556z = 7;
            }
            this.f17672z.f17555y = 0;
            this.f17633A = new C4228d(this.f17672z);
            this.f17634B = 0;
            if (this.f17656h != null) {
                this.f17656h.m5802a(str);
            }
        } catch (Exception e) {
            this.f17672z = new C4228d();
            this.f17672z.f17556z = -1;
            this.f17672z.f17555y = 2;
            this.f17634B = 2;
        }
        if (this.f17658j == null || this.f17659k != 1) {
            return;
        }
        if (this.f17669w != null && this.f17669w.m5769a()) {
            return;
        }
        this.f17658j.mo5385a(this.f17672z);
        this.f17668v = System.currentTimeMillis();
    }

    /* renamed from: b */
    static /* synthetic */ void m5745b(C4246f c4246f, int i) {
        int i2 = 3;
        if (i == 3) {
            i2 = 4;
        }
        c4246f.f17655g = i2;
        if (c4246f.f17658j != null) {
            c4246f.f17658j.mo5386a(c4246f.f17655g);
        }
    }

    /* renamed from: b */
    private void m5743b(boolean z) {
        if (this.f17669w == null || !this.f17669w.m5769a()) {
            return;
        }
        Location m5768b = this.f17669w.m5768b();
        this.f17672z = new C4228d();
        this.f17672z.f17532b = C4258i.m5698a(m5768b.getLatitude(), 6);
        this.f17672z.f17533c = C4258i.m5698a(m5768b.getLongitude(), 6);
        this.f17672z.f17534d = C4258i.m5698a(m5768b.getAltitude(), 1);
        this.f17672z.f17535e = C4258i.m5698a(m5768b.getAccuracy(), 1);
        this.f17672z.f17536f = C4258i.m5698a(m5768b.getSpeed(), 1);
        this.f17672z.f17537g = C4258i.m5698a(m5768b.getBearing(), 1);
        this.f17672z.f17531a = 0;
        this.f17672z.f17554x = false;
        if (!z) {
            this.f17672z.f17555y = 0;
        } else {
            this.f17672z.f17555y = 1;
        }
        this.f17672z.f17556z = 0;
        this.f17633A = new C4228d(this.f17672z);
        this.f17634B = 0;
        if (System.currentTimeMillis() - this.f17668v < this.f17649a || this.f17658j == null || this.f17659k != 1) {
            return;
        }
        this.f17658j.mo5385a(this.f17672z);
        this.f17668v = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5739d() {
        if (this.f17667s != null) {
            return;
        }
        this.f17667s = new C4249a(this.f17669w, this.f17670x, this.f17671y);
        this.f17667s.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5736e() {
        this.f17672z = new C4228d();
        this.f17634B = 1;
        this.f17672z.f17555y = 1;
        this.f17672z.f17556z = -1;
        this.f17672z.f17531a = 1;
        if (this.f17658j == null || this.f17659k != 1) {
            return;
        }
        this.f17658j.mo5385a(this.f17672z);
    }

    /* renamed from: j */
    static /* synthetic */ void m5728j(C4246f c4246f) {
    }

    @Override // com.tencent.map.p226b.C4231b.AbstractC4232a
    /* renamed from: a */
    public final void mo5766a(double d, double d2) {
        synchronized (this.f17663o) {
            Message obtainMessage = this.f17665q.obtainMessage(6);
            Location location = new Location("Deflect");
            location.setLatitude(d);
            location.setLongitude(d2);
            obtainMessage.obj = location;
            this.f17665q.sendMessage(obtainMessage);
        }
    }

    @Override // com.tencent.map.p226b.C4242e.AbstractC4245c
    /* renamed from: a */
    public final void mo5765a(int i) {
        synchronized (this.f17663o) {
            this.f17665q.sendMessage(this.f17665q.obtainMessage(4, i, 0));
        }
    }

    @Override // com.tencent.map.p226b.C4237d.AbstractC4241c
    /* renamed from: a */
    public final void mo5763a(C4237d.C4240b c4240b) {
        synchronized (this.f17663o) {
            this.f17665q.sendMessage(this.f17665q.obtainMessage(2, c4240b));
        }
    }

    @Override // com.tencent.map.p226b.C4242e.AbstractC4245c
    /* renamed from: a */
    public final void mo5762a(C4242e.C4244b c4244b) {
        synchronized (this.f17663o) {
            this.f17665q.sendMessage(this.f17665q.obtainMessage(1, c4244b));
        }
    }

    @Override // com.tencent.map.p226b.C4252g.AbstractC4256c
    /* renamed from: a */
    public final void mo5702a(C4252g.C4255b c4255b) {
        synchronized (this.f17663o) {
            this.f17665q.sendMessage(this.f17665q.obtainMessage(3, c4255b));
        }
    }

    /* renamed from: a */
    public final boolean m5764a(Context context, C4226b c4226b) {
        synchronized (this.f17662n) {
            if (context == null || c4226b == null) {
                return false;
            }
            if (!C4258i.m5692a(this.f17642J)) {
                return false;
            }
            this.f17665q = new HandlerC4251c();
            this.f17646N = new Handler(Looper.getMainLooper());
            this.f17650b = context;
            this.f17658j = c4226b;
            C4262l.m5675a().m5674a(this.f17650b.getApplicationContext());
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                    this.f17643K = connectivityManager.getActiveNetworkInfo().isRoaming();
                }
                this.f17650b.registerReceiver(this.f17648P, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e) {
            }
            this.f17659k = this.f17658j.m5820a();
            this.f17660l = this.f17658j.m5819b();
            this.f17661m = this.f17658j.m5818c();
            this.f17668v = -1L;
            if (this.f17660l == 7) {
                this.f17660l = 0;
            }
            this.f17644L = false;
            this.f17636D = 1;
            boolean m5784a = this.f17651c.m5784a(this, this.f17650b);
            boolean m5795a = this.f17652d.m5795a(this.f17650b, this);
            boolean m5713a = this.f17653e.m5713a(this.f17650b, this, 1);
            this.f17656h = C4234c.m5804a();
            this.f17657i = C4231b.m5811a();
            this.f17669w = null;
            this.f17670x = null;
            this.f17671y = null;
            this.f17672z = null;
            this.f17633A = null;
            this.f17634B = 0;
            if (this.f17656h != null) {
                this.f17656h.m5799b();
            }
            this.f17635C = 1;
            if (m5784a && this.f17661m == 0) {
                return true;
            }
            return m5795a || m5713a;
        }
    }

    /* renamed from: a */
    public final boolean m5750a(String str, String str2) {
        boolean z;
        synchronized (this.f17662n) {
            if (C4229a.m5815a().m5813a(str, str2)) {
                this.f17642J = str;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public final void m5747b() {
        synchronized (this.f17662n) {
            try {
                if (this.f17658j != null) {
                    this.f17658j = null;
                    this.f17646N.removeCallbacks(this.f17647O);
                    this.f17650b.unregisterReceiver(this.f17648P);
                    this.f17651c.m5785a();
                    this.f17652d.m5797a();
                    this.f17653e.m5715a();
                }
            } catch (Exception e) {
            }
        }
    }

    @Override // com.tencent.map.p226b.C4252g.AbstractC4256c
    /* renamed from: b */
    public final void mo5701b(int i) {
        synchronized (this.f17663o) {
            this.f17665q.sendMessage(this.f17665q.obtainMessage(5, i, 0));
        }
    }
}
