package com.p080b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.fimi.soul.media.player.IMediaPlayer;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.p080b.C1435at;
import com.tencent.open.GameAppOperation;
import com.tencent.p227mm.sdk.platformtools.Util;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import org.json.JSONObject;
import org.p318d.AbstractC5756f;
import p004b.p005a.p006a.p028b.p051m.p052a.C0477f;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* renamed from: com.b.as */
/* loaded from: classes.dex */
public class C1430as {

    /* renamed from: d */
    C1435at f4942d;

    /* renamed from: p */
    private C1452bb f4954p;

    /* renamed from: c */
    public static final StringBuilder f4909c = new StringBuilder();

    /* renamed from: ae */
    private static int f4908ae = -1;

    /* renamed from: m */
    private Context f4951m = null;

    /* renamed from: n */
    private ConnectivityManager f4952n = null;

    /* renamed from: o */
    private C1455bc f4953o = null;

    /* renamed from: q */
    private ArrayList<ScanResult> f4955q = new ArrayList<>();

    /* renamed from: r */
    private ArrayList<ScanResult> f4956r = new ArrayList<>();

    /* renamed from: s */
    private HashMap<String, ArrayList<ScanResult>> f4957s = new HashMap<>();

    /* renamed from: t */
    private C1434b f4958t = new C1434b();

    /* renamed from: u */
    private WifiInfo f4959u = null;

    /* renamed from: v */
    private JSONObject f4960v = null;

    /* renamed from: w */
    private AmapLoc f4961w = null;

    /* renamed from: x */
    private long f4962x = 0;

    /* renamed from: y */
    private long f4963y = 0;

    /* renamed from: z */
    private long f4964z = 0;

    /* renamed from: A */
    private boolean f4910A = false;

    /* renamed from: B */
    private boolean f4911B = false;

    /* renamed from: C */
    private long f4912C = 0;

    /* renamed from: D */
    private long f4913D = 0;

    /* renamed from: E */
    private int f4914E = 0;

    /* renamed from: F */
    private String f4915F = "00:00:00:00:00:00";

    /* renamed from: G */
    private String f4916G = null;

    /* renamed from: H */
    private C1472bo f4917H = null;

    /* renamed from: I */
    private Timer f4918I = null;

    /* renamed from: J */
    private TimerTask f4919J = null;

    /* renamed from: K */
    private int f4920K = 0;

    /* renamed from: L */
    private C1486by f4921L = null;

    /* renamed from: M */
    private C1495ce f4922M = null;

    /* renamed from: a */
    public boolean f4936a = false;

    /* renamed from: N */
    private int[] f4923N = {0, 0, 0};

    /* renamed from: O */
    private String f4924O = null;

    /* renamed from: P */
    private String f4925P = null;

    /* renamed from: Q */
    private long f4926Q = 0;

    /* renamed from: R */
    private long f4927R = 0;

    /* renamed from: S */
    private String f4928S = null;

    /* renamed from: T */
    private C1451ba f4929T = null;

    /* renamed from: b */
    C1467bl f4941b = null;

    /* renamed from: e */
    int f4943e = -1;

    /* renamed from: f */
    boolean f4944f = false;

    /* renamed from: U */
    private AmapLoc f4930U = null;

    /* renamed from: V */
    private String f4931V = null;

    /* renamed from: W */
    private Timer f4932W = null;

    /* renamed from: X */
    private TimerTask f4933X = null;

    /* renamed from: Y */
    private String f4934Y = null;

    /* renamed from: Z */
    private int f4935Z = 0;

    /* renamed from: aa */
    private int f4937aa = 0;

    /* renamed from: g */
    AmapLoc f4945g = null;

    /* renamed from: ab */
    private boolean f4938ab = true;

    /* renamed from: ac */
    private boolean f4939ac = true;

    /* renamed from: ad */
    private long f4940ad = 0;

    /* renamed from: h */
    Object f4946h = new Object();

    /* renamed from: i */
    public boolean f4947i = false;

    /* renamed from: j */
    int f4948j = 12;

    /* renamed from: k */
    boolean f4949k = true;

    /* renamed from: l */
    C1433a f4950l = new C1433a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.b.as$a */
    /* loaded from: classes.dex */
    public class C1433a implements C1435at.AbstractC1438a {
        C1433a() {
        }

        @Override // com.p080b.C1435at.AbstractC1438a
        /* renamed from: a */
        public void mo16236a(int i) {
            C1430as.this.f4943e = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.b.as$b */
    /* loaded from: classes.dex */
    public class C1434b extends BroadcastReceiver {
        private C1434b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                C1455bc c1455bc = C1430as.this.f4953o;
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    if (c1455bc == null) {
                        return;
                    }
                    List<ScanResult> m16146a = c1455bc.m16146a();
                    if (m16146a != null) {
                        synchronized (C1430as.this.f4946h) {
                            C1430as.this.f4956r.clear();
                            C1430as.this.f4956r.addAll(m16146a);
                        }
                    }
                    C1430as.this.f4913D = C1477bs.m15997b();
                } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    if (C1430as.this.f4953o == null) {
                        return;
                    }
                    int m16140c = c1455bc.m16140c();
                    if (C1430as.this.f4956r == null) {
                        C1430as.this.f4956r = new ArrayList();
                    }
                    switch (m16140c) {
                        case 0:
                            C1430as.this.m16256n();
                            return;
                        case 1:
                            C1430as.this.m16256n();
                            return;
                        case 2:
                        case 3:
                        default:
                            return;
                        case 4:
                            C1430as.this.m16256n();
                            return;
                    }
                } else if (action.equals("android.intent.action.SCREEN_ON")) {
                    C1430as.this.f4949k = true;
                } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                    C1430as.this.f4949k = false;
                    if (C1430as.this.f4921L == null) {
                        return;
                    }
                    C1430as.this.m16249u();
                } else if (action.equals("android.intent.action.AIRPLANE_MODE") || action.equals("android.location.GPS_FIX_CHANGE") || !action.equals("android.net.conn.CONNECTIVITY_CHANGE") || !C1430as.this.m16324A()) {
                } else {
                    C1430as.this.m16288a(true, 2);
                }
            } catch (Throwable th) {
                C1514cx.m15728a(th, "APS", "onReceive");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public boolean m16324A() {
        if (this.f4953o == null || this.f4952n == null) {
            return false;
        }
        return this.f4953o.m16145a(this.f4952n);
    }

    /* renamed from: B */
    private void m16323B() {
        if (!C1477bs.m16000a(this.f4960v, "poiid")) {
            this.f4916G = null;
            return;
        }
        try {
            String string = this.f4960v.getString("poiid");
            if (TextUtils.isEmpty(string)) {
                this.f4916G = null;
            } else if (string.length() > 32) {
                this.f4916G = null;
            } else {
                this.f4916G = string;
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "setPoiid");
        }
    }

    /* renamed from: C */
    private String m16322C() {
        try {
            return C1486by.m15917a(GameAppOperation.QQFAV_DATALINE_VERSION);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "getCollVer");
            return null;
        }
    }

    /* renamed from: D */
    private void m16321D() {
        if (this.f4953o == null || this.f4951m == null || !this.f4936a) {
            return;
        }
        this.f4953o.m16142a(this.f4936a);
    }

    /* renamed from: E */
    private boolean m16320E() {
        if (this.f4951m == null) {
            f4909c.append("context is null");
            return false;
        } else if (TextUtils.isEmpty(C1514cx.f5410e)) {
            f4909c.append("src is null");
            return false;
        } else if (!TextUtils.isEmpty(C1514cx.f5411f)) {
            return true;
        } else {
            f4909c.append("license is null");
            return false;
        }
    }

    /* renamed from: F */
    private void m16319F() {
        SharedPreferences sharedPreferences;
        if (this.f4951m == null || this.f4923N[0] == 0 || (sharedPreferences = this.f4951m.getSharedPreferences("pref", 0)) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f4923N.length; i++) {
            sb.append(this.f4923N[i]).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        try {
            sb.deleteCharAt(this.f4923N.length - 1);
            sharedPreferences.edit().putString("coluphist", C1544dr.m15602b(sb.toString().getBytes("UTF-8")));
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "setColUpHist");
        }
        sb.delete(0, sb.length());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008d  */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AmapLoc m16318G() {
        Throwable th;
        C1451ba c1451ba;
        String m16282b;
        AmapLoc m16294a;
        if (f4909c.length() > 0) {
            f4909c.delete(0, f4909c.length());
        }
        try {
            if (!this.f4910A) {
                this.f4954p.m16162f();
                this.f4954p.m16167d();
                c1451ba = this.f4954p.m16174b();
            } else {
                c1451ba = null;
            }
        } catch (Throwable th2) {
            th = th2;
            c1451ba = null;
        }
        try {
            m16276d();
            ArrayList<ScanResult> arrayList = this.f4955q;
            if (arrayList != null && arrayList.isEmpty()) {
                this.f4913D = C1477bs.m15997b();
                List<ScanResult> m16146a = this.f4953o.m16146a();
                if (m16146a != null) {
                    arrayList.addAll(m16146a);
                    synchronized (this.f4946h) {
                        if (this.f4956r != null && this.f4956r.isEmpty()) {
                            this.f4956r.addAll(m16146a);
                        }
                    }
                }
            }
            m16274e();
        } catch (Throwable th3) {
            th = th3;
            C1514cx.m15728a(th, "APS", "doFirstLocate");
            m16282b = m16282b(false);
            if (!TextUtils.isEmpty(m16282b)) {
            }
            return m16294a;
        }
        m16282b = m16282b(false);
        if (!TextUtils.isEmpty(m16282b)) {
            m16294a = 0 == 0 ? new AmapLoc() : null;
            m16294a.m16538b(this.f4948j);
            m16294a.m16537b(f4909c.toString());
        } else {
            String str = m16282b + "&" + this.f4939ac + "&" + this.f4938ab;
            StringBuilder m16277c = m16277c(true);
            AmapLoc m16113a = C1459bf.m16116a().m16113a(str, m16277c);
            if (C1477bs.m16006a(m16113a)) {
                this.f4927R = 0L;
                m16113a.m16546a(4);
                this.f4961w = m16113a;
                m16317H();
                return m16113a;
            }
            AmapLoc m16292a = m16292a(m16272f(), false, true);
            if (C1477bs.m16006a(m16292a)) {
                m16292a.m16525f("new");
                this.f4928S = m16277c.toString();
                this.f4929T = c1451ba;
                this.f4962x = C1477bs.m15997b();
                this.f4961w = m16292a;
                C1459bf.m16116a().m16112a(str, m16277c, this.f4961w, this.f4951m, true);
                m16317H();
                m16294a = m16292a;
            } else {
                m16294a = m16294a(m16282b, m16277c.toString());
                if (!C1477bs.m16006a(m16294a)) {
                    return m16292a;
                }
                this.f4928S = m16277c.toString();
                m16294a.m16525f("file");
                m16294a.m16546a(8);
                m16294a.m16537b("离线定位结果，在线定位失败原因:" + m16292a.m16530d());
                this.f4961w = m16294a;
            }
        }
        return m16294a;
    }

    /* renamed from: H */
    private void m16317H() {
        this.f4930U = null;
        this.f4931V = null;
    }

    /* renamed from: I */
    private void m16316I() {
        if (!C1473bp.m16040i()) {
            m16315J();
        } else if (C1449az.f5016a[1] > 2000) {
            m16315J();
        } else if (this.f4932W != null && this.f4933X != null) {
        } else {
            this.f4933X = new TimerTask() { // from class: com.b.as.2
                /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x008e  */
                @Override // java.util.TimerTask, java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    boolean equals;
                    ArrayList<C1462bh> m16086b;
                    ArrayList<String> m16093b;
                    int size;
                    int i;
                    if (C1449az.f5016a[1] > 2000) {
                        C1430as.this.m16315J();
                        return;
                    }
                    Thread.currentThread().setPriority(1);
                    try {
                        if (C1477bs.m16000a(C1430as.this.f4960v, "fetchoffdatamobile")) {
                            try {
                                equals = "1".equals(C1430as.this.f4960v.getString("fetchoffdatamobile"));
                            } catch (Throwable th) {
                                C1514cx.m15728a(th, "APS", "timerTaskO part");
                            }
                            m16086b = C1463bi.m16090a().m16086b();
                            if (m16086b != null && (size = m16086b.size()) > 0) {
                                if (C1430as.this.f4934Y == null) {
                                    C1430as.this.f4934Y = C1430as.this.m16282b(true);
                                }
                                for (i = 0; i < size && i < 20; i++) {
                                    C1449az.m16201a(C1430as.this.f4951m, C1430as.this.f4934Y, m16086b.get(i).m16092a(), 1, 0, equals, true);
                                }
                            }
                            C1430as.this.m16313L();
                            m16093b = C1461bg.m16100a().m16093b(C1430as.this.f4951m, 1);
                            if (m16093b == null || m16093b.size() <= 0) {
                                return;
                            }
                            Iterator<String> it2 = m16093b.iterator();
                            while (it2.hasNext()) {
                                C1449az.m16196a(C1430as.this.f4934Y, it2.next(), 1, 0);
                            }
                            return;
                        }
                        m16093b = C1461bg.m16100a().m16093b(C1430as.this.f4951m, 1);
                        if (m16093b == null) {
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        C1514cx.m15728a(th2, "APS", "timerTaskO");
                        return;
                    }
                    equals = false;
                    m16086b = C1463bi.m16090a().m16086b();
                    if (m16086b != null) {
                        if (C1430as.this.f4934Y == null) {
                        }
                        while (i < size) {
                            C1449az.m16201a(C1430as.this.f4951m, C1430as.this.f4934Y, m16086b.get(i).m16092a(), 1, 0, equals, true);
                        }
                    }
                    C1430as.this.m16313L();
                }
            };
            this.f4932W = new Timer("T-O", false);
            this.f4932W.schedule(this.f4933X, 0L, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public void m16315J() {
        if (this.f4933X != null) {
            this.f4933X.cancel();
            this.f4933X = null;
        }
        if (this.f4932W != null) {
            this.f4932W.cancel();
            this.f4932W.purge();
            this.f4932W = null;
        }
    }

    /* renamed from: K */
    private void m16314K() {
        this.f4935Z = 0;
        this.f4937aa = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m16313L() {
        SharedPreferences sharedPreferences;
        if (this.f4951m == null || C1449az.f5016a[0] == 0 || (sharedPreferences = this.f4951m.getSharedPreferences("pref", 0)) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C1449az.f5016a.length; i++) {
            sb.append(C1449az.f5016a[i]).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        try {
            sb.deleteCharAt(sb.length() - 1);
            sharedPreferences.edit().putString("activityoffdl", C1477bs.m15987c(sb.toString())).commit();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "setOffDlHist");
        }
        sb.delete(0, sb.length());
    }

    /* renamed from: M */
    private double[] m16312M() {
        double[] dArr = new double[2];
        if (C1477bs.m16006a(this.f4961w)) {
            dArr[0] = this.f4961w.m16520i();
            dArr[1] = this.f4961w.m16522h();
        } else if (C1477bs.m16006a(this.f4945g)) {
            dArr[0] = this.f4945g.m16520i();
            dArr[1] = this.f4945g.m16522h();
        } else {
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
        }
        return dArr;
    }

    /* renamed from: N */
    private void m16311N() {
        try {
            this.f4928S = null;
            this.f4961w = null;
            this.f4927R = 0L;
            this.f4962x = 0L;
            C1444aw.m16218a().m16216b();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "cleanCache");
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x006c -> B:23:0x0009). Please submit an issue!!! */
    /* renamed from: a */
    private AmapLoc m16294a(String str, String str2) {
        AmapLoc amapLoc;
        ArrayList<String> m16193a;
        if (!C1473bp.m16040i()) {
            return null;
        }
        if (str != null && str.equals(this.f4931V) && this.f4930U != null) {
            return this.f4930U;
        }
        m16316I();
        ArrayList<C1462bh> m16086b = C1463bi.m16090a().m16086b();
        try {
            if (C1449az.m16190b() && (m16193a = C1449az.m16193a(str, false)) != null) {
                int size = m16193a.size();
                for (int i = 0; i < size; i++) {
                    String str3 = m16193a.get(i);
                    amapLoc = m16293a(str, str2, null, str3.substring(str3.lastIndexOf(File.separator) + 1, str3.length()), 0);
                    if (C1477bs.m16006a(amapLoc)) {
                        this.f4931V = str;
                        this.f4930U = amapLoc;
                        break;
                    }
                }
            }
            int size2 = m16086b.size();
            if (size2 != 0) {
                for (int i2 = 0; i2 < size2; i2++) {
                    amapLoc = m16293a(str, str2, null, m16086b.get(i2).m16092a(), 0);
                    if (C1477bs.m16006a(amapLoc)) {
                        this.f4931V = str;
                        this.f4930U = amapLoc;
                        break;
                    }
                }
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "getPureOfflineLocation");
        }
        amapLoc = null;
        return amapLoc;
    }

    /* renamed from: a */
    private AmapLoc m16293a(String str, String str2, double[] dArr, String str3, int i) {
        if (!C1477bs.m15973k()) {
            return null;
        }
        if (TextUtils.isEmpty(str3)) {
            if (dArr == null) {
                dArr = m16312M();
            }
            if (dArr[0] == 0.0d || dArr[1] == 0.0d) {
                return null;
            }
        }
        C1477bs.m15997b();
        return C1449az.m16191a(dArr, str3, str, str2, i, this.f4951m, new int[]{this.f4937aa, this.f4935Z});
    }

    /* renamed from: a */
    private AmapLoc m16292a(String str, boolean z, boolean z2) {
        if (this.f4951m == null) {
            f4909c.append("context is null");
            AmapLoc amapLoc = new AmapLoc();
            amapLoc.m16538b(1);
            amapLoc.m16537b(f4909c.toString());
            return amapLoc;
        } else if (str == null || str.length() == 0) {
            AmapLoc amapLoc2 = new AmapLoc();
            amapLoc2.m16538b(3);
            amapLoc2.m16537b(f4909c.toString());
            return amapLoc2;
        } else {
            new AmapLoc();
            C1469bn c1469bn = new C1469bn();
            try {
                byte[] m16069a = this.f4941b.m16069a(this.f4951m, this.f4960v, this.f4917H, C1514cx.m15733a());
                if (m16069a == null) {
                    AmapLoc amapLoc3 = new AmapLoc();
                    amapLoc3.m16538b(4);
                    f4909c.append("please check the network");
                    amapLoc3.m16537b(f4909c.toString());
                    return amapLoc3;
                }
                this.f4940ad = C1477bs.m16020a();
                String str2 = new String(m16069a, "UTF-8");
                if (str2.contains("\"status\":\"0\"")) {
                    return c1469bn.m16062b(str2);
                }
                String m16133a = C1456bd.m16133a(m16069a);
                if (m16133a == null) {
                    AmapLoc amapLoc4 = new AmapLoc();
                    amapLoc4.m16538b(5);
                    f4909c.append("decrypt response data error");
                    amapLoc4.m16537b(f4909c.toString());
                    return amapLoc4;
                }
                AmapLoc m16063a = c1469bn.m16063a(m16133a);
                if (!C1477bs.m16006a(m16063a)) {
                    if (m16063a != null) {
                        this.f4924O = m16063a.m16510n();
                        m16063a.m16538b(6);
                        f4909c.append("location faile retype:" + m16063a.m16512m() + " rdesc:" + (this.f4924O != null ? this.f4924O : "null"));
                        m16063a.m16537b(f4909c.toString());
                        return m16063a;
                    }
                    AmapLoc amapLoc5 = new AmapLoc();
                    amapLoc5.m16538b(6);
                    f4909c.append("location is null");
                    amapLoc5.m16537b(f4909c.toString());
                    return amapLoc5;
                }
                if (m16063a.m16551E() != null) {
                }
                if (m16063a.m16549a() == 0 && m16063a.m16541b() == 0) {
                    if ("-5".equals(m16063a.m16512m()) || "1".equals(m16063a.m16512m()) || "2".equals(m16063a.m16512m()) || com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(m16063a.m16512m()) || "24".equals(m16063a.m16512m()) || "-1".equals(m16063a.m16512m())) {
                        m16063a.m16546a(5);
                    } else {
                        m16063a.m16546a(6);
                    }
                    m16063a.m16537b(m16063a.m16512m());
                }
                m16063a.m16542a(this.f4939ac);
                m16063a.m16536b(this.f4938ab);
                return m16063a;
            } catch (Throwable th) {
                C1514cx.m15728a(th, "APS", "getApsLoc");
                AmapLoc amapLoc6 = new AmapLoc();
                amapLoc6.m16538b(4);
                f4909c.append("please check the network");
                amapLoc6.m16537b(f4909c.toString());
                return amapLoc6;
            }
        }
    }

    /* renamed from: a */
    private String m16308a(int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("e", i);
        jSONObject.put(C0477f.f1054a, i2);
        jSONObject.put("u", i3);
        return jSONObject.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0529 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x06c9  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private StringBuilder m16296a(Object obj) {
        String str;
        String str2;
        boolean z;
        int i;
        String sb;
        StringBuilder sb2 = new StringBuilder();
        String str3 = C1514cx.f5414i;
        C1514cx.f5407b = "888888888888888";
        C1514cx.f5408c = "888888888888888";
        C1514cx.f5409d = "";
        int m16017a = C1477bs.m16017a(-32768, 32767);
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = C1514cx.f5410e;
        String str8 = C1514cx.f5411f;
        if (!this.f4939ac) {
            str = "UC_nlp_20131029";
            str2 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        } else {
            str = str7;
            str2 = str8;
        }
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        C1452bb c1452bb = this.f4954p;
        int m16170c = c1452bb.m16170c();
        TelephonyManager m16164e = c1452bb.m16164e();
        ArrayList<C1451ba> m16185a = c1452bb.m16185a();
        String str9 = m16170c == 2 ? "1" : "0";
        if (m16164e != null) {
            if (TextUtils.isEmpty(C1514cx.f5407b)) {
                C1514cx.f5407b = "888888888888888";
                try {
                    C1514cx.f5407b = C1542dq.m15615q(this.f4951m);
                } catch (Throwable th) {
                    C1514cx.m15728a(th, "APS", "getApsReq part4");
                }
            } else if ("888888888888888".equals(C1514cx.f5407b)) {
                C1514cx.f5407b = "888888888888888";
                try {
                    C1514cx.f5407b = C1542dq.m15615q(this.f4951m);
                } catch (Throwable th2) {
                    C1514cx.m15728a(th2, "APS", "getApsReq part3");
                }
            }
            if (TextUtils.isEmpty(C1514cx.f5407b)) {
                C1514cx.f5407b = "888888888888888";
            }
            if (TextUtils.isEmpty(C1514cx.f5408c)) {
                C1514cx.f5408c = "888888888888888";
                try {
                    C1514cx.f5408c = m16164e.getSubscriberId();
                } catch (Throwable th3) {
                    C1514cx.m15728a(th3, "APS", "getApsReq part2");
                }
            } else if ("888888888888888".equals(C1514cx.f5408c)) {
                C1514cx.f5408c = "888888888888888";
                try {
                    C1514cx.f5408c = m16164e.getSubscriberId();
                } catch (Throwable th4) {
                    C1514cx.m15728a(th4, "APS", "getApsReq part1");
                }
            }
            if (TextUtils.isEmpty(C1514cx.f5408c)) {
                C1514cx.f5408c = "888888888888888";
            }
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = this.f4952n.getActiveNetworkInfo();
        } catch (Throwable th5) {
            C1514cx.m15728a(th5, "APS", "getApsReq part");
        }
        if (C1477bs.m16011a(networkInfo) != -1) {
            String m15993b = C1477bs.m15993b(m16164e);
            String str10 = (!m16254p() || !m16304a(this.f4959u)) ? "1" : "2";
            if (!m16254p()) {
                m16256n();
                str4 = m15993b;
                str5 = str10;
            } else {
                str4 = m15993b;
                str5 = str10;
            }
        } else {
            this.f4959u = null;
        }
        m16323B();
        sb2.append("<?xml version=\"1.0\" encoding=\"");
        sb2.append("GBK").append("\"?>");
        sb2.append("<Cell_Req ver=\"3.0\"><HDR version=\"3.0\" cdma=\"");
        sb2.append(str9);
        sb2.append("\" gtype=\"").append("0");
        if ("0".equals("1")) {
            sb2.append("\" gmock=\"").append(this.f4911B ? "1" : "0");
        }
        sb2.append("\" glong=\"").append("0");
        sb2.append("\" glat=\"").append("0");
        sb2.append("\" precision=\"").append("0");
        sb2.append("\"><src>").append(str);
        sb2.append("</src><license>").append(str2);
        sb2.append("</license><key>").append(str3);
        sb2.append("</key><clientid>").append(C1514cx.f5413h);
        sb2.append("</clientid><imei>").append(C1514cx.f5407b);
        sb2.append("</imei><imsi>").append(C1514cx.f5408c);
        sb2.append("</imsi><reqid>").append(m16017a);
        sb2.append("</reqid><smac>").append(this.f4915F);
        sb2.append("</smac><sdkv>").append(m16281c());
        sb2.append("</sdkv><corv>").append(m16322C());
        sb2.append("</corv><poiid>").append(this.f4916G);
        sb2.append("</poiid></HDR><DRR phnum=\"").append(C1514cx.f5409d);
        sb2.append("\" nettype=\"").append(str4);
        sb2.append("\" inftype=\"").append(str5).append("\">");
        if (!m16185a.isEmpty()) {
            StringBuilder sb6 = new StringBuilder();
            switch (m16170c) {
                case 1:
                    m16314K();
                    C1451ba c1451ba = m16185a.get(0);
                    sb6.delete(0, sb6.length());
                    sb6.append("<mcc>").append(c1451ba.f5026a).append("</mcc>");
                    sb6.append("<mnc>").append(c1451ba.f5027b).append("</mnc>");
                    sb6.append("<lac>").append(c1451ba.f5028c).append("</lac>");
                    sb6.append("<cellid>").append(c1451ba.f5029d);
                    sb6.append("</cellid>");
                    sb6.append("<signal>").append(c1451ba.f5035j);
                    sb6.append("</signal>");
                    String sb7 = sb6.toString();
                    int i2 = 1;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= m16185a.size()) {
                            sb = sb7;
                            break;
                        } else {
                            C1451ba c1451ba2 = m16185a.get(i3);
                            sb3.append(c1451ba2.f5028c).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            sb3.append(c1451ba2.f5029d).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            sb3.append(c1451ba2.f5035j);
                            if (i3 < m16185a.size() - 1) {
                                sb3.append(AbstractC5756f.f23062a);
                            }
                            i2 = i3 + 1;
                        }
                    }
                case 2:
                    C1451ba c1451ba3 = m16185a.get(0);
                    sb6.delete(0, sb6.length());
                    sb6.append("<mcc>").append(c1451ba3.f5026a).append("</mcc>");
                    sb6.append("<sid>").append(c1451ba3.f5032g).append("</sid>");
                    sb6.append("<nid>").append(c1451ba3.f5033h).append("</nid>");
                    sb6.append("<bid>").append(c1451ba3.f5034i).append("</bid>");
                    if (c1451ba3.f5031f <= 0 || c1451ba3.f5030e <= 0) {
                        m16314K();
                    } else {
                        this.f4935Z = c1451ba3.f5031f;
                        this.f4937aa = c1451ba3.f5030e;
                        sb6.append("<lon>").append(c1451ba3.f5031f).append("</lon>");
                        sb6.append("<lat>").append(c1451ba3.f5030e).append("</lat>");
                    }
                    sb6.append("<signal>").append(c1451ba3.f5035j).append("</signal>");
                    sb = sb6.toString();
                    break;
                default:
                    m16314K();
                    sb = str6;
                    break;
            }
            sb6.delete(0, sb6.length());
            str6 = sb;
        }
        if (m16254p()) {
            if (m16304a(this.f4959u)) {
                sb5.append(this.f4959u.getBSSID()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int rssi = this.f4959u.getRssi();
                if (rssi < -128) {
                    rssi = 0;
                } else if (rssi > 127) {
                    rssi = 0;
                }
                sb5.append(rssi).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String ssid = this.f4959u.getSSID();
                try {
                    i = this.f4959u.getSSID().getBytes("UTF-8").length;
                } catch (Throwable th6) {
                    C1514cx.m15728a(th6, "APS", "getApsReq");
                    i = 32;
                }
                if (i >= 32) {
                    ssid = "unkwn";
                }
                sb5.append(ssid.replace(AbstractC5756f.f23062a, "."));
            }
            ArrayList<ScanResult> arrayList = this.f4955q;
            int i4 = 0;
            int min = Math.min(arrayList.size(), 15);
            while (true) {
                int i5 = i4;
                if (i5 < min) {
                    ScanResult scanResult = arrayList.get(i5);
                    sb4.append(scanResult.BSSID).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb4.append(scanResult.level).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb4.append(scanResult.SSID).append(AbstractC5756f.f23062a);
                    i4 = i5 + 1;
                }
            }
        } else {
            m16256n();
        }
        sb2.append(str6);
        sb2.append(String.format(Locale.US, "<nb>%s</nb>", sb3));
        if (sb4.length() == 0) {
            sb4.append((CharSequence) sb5);
            sb2.append("<macs>");
            sb2.append(String.format(Locale.US, "<![CDATA[%s]]>", sb5));
            sb2.append("</macs>");
        } else {
            sb4.deleteCharAt(sb4.length() - 1);
            sb2.append("<macs>");
            sb2.append(String.format(Locale.US, "<![CDATA[%s]]>", sb4));
            sb2.append("</macs>");
            sb2.append("<macsage>").append(C1477bs.m15997b() - this.f4913D);
            sb2.append("</macsage>");
        }
        sb2.append("<mmac>");
        sb2.append(String.format(Locale.US, "<![CDATA[%s]]>", sb5));
        sb2.append("</mmac>").append("</DRR></Cell_Req>");
        m16291a(sb2);
        if (C1477bs.m16000a(this.f4960v, "reversegeo")) {
            try {
                z = this.f4960v.getBoolean("reversegeo");
            } catch (Throwable th7) {
                C1514cx.m15728a(th7, "APS", "getApsReq part");
            }
            if (z) {
                this.f4917H.f5113b = (short) 2;
            } else {
                this.f4917H.f5113b = (short) 0;
            }
            if (C1477bs.m16000a(this.f4960v, "multi")) {
                try {
                    if (this.f4960v.getString("multi").equals("1")) {
                        this.f4917H.f5113b = (short) 1;
                    }
                } catch (Throwable th8) {
                    C1514cx.m15728a(th8, "APS", "getApsReq");
                }
            }
            this.f4917H.f5114c = str;
            this.f4917H.f5115d = str2;
            this.f4917H.f5117f = C1477bs.m15979f();
            this.f4917H.f5118g = "android" + C1477bs.m15977g();
            if (TextUtils.isEmpty(C1514cx.f5416k)) {
                C1514cx.f5416k = C1477bs.m15994b(this.f4951m);
            }
            this.f4917H.f5119h = C1514cx.f5416k;
            this.f4917H.f5120i = str9;
            this.f4917H.f5121j = "0";
            this.f4917H.f5122k = !this.f4911B ? "1" : "0";
            this.f4917H.f5123l = "0";
            this.f4917H.f5124m = "0";
            this.f4917H.f5125n = "0";
            this.f4917H.f5126o = str3;
            this.f4917H.f5127p = C1514cx.f5407b;
            this.f4917H.f5128q = C1514cx.f5408c;
            this.f4917H.f5130s = String.valueOf(m16017a);
            this.f4917H.f5131t = this.f4915F;
            this.f4917H.f5133v = m16281c();
            this.f4917H.f5134w = m16322C();
            this.f4917H.f5110F = this.f4916G;
            this.f4917H.f5132u = C1514cx.f5409d;
            this.f4917H.f5135x = str4;
            this.f4917H.f5136y = str5;
            this.f4917H.f5137z = String.valueOf(m16170c);
            this.f4917H.f5105A = str6;
            this.f4917H.f5106B = sb3.toString();
            this.f4917H.f5108D = sb4.toString();
            this.f4917H.f5109E = String.valueOf(C1477bs.m15997b() - this.f4913D);
            this.f4917H.f5107C = sb5.toString();
            sb3.delete(0, sb3.length());
            sb4.delete(0, sb4.length());
            sb5.delete(0, sb5.length());
            return sb2;
        }
        z = true;
        if (z) {
        }
        if (C1477bs.m16000a(this.f4960v, "multi")) {
        }
        this.f4917H.f5114c = str;
        this.f4917H.f5115d = str2;
        this.f4917H.f5117f = C1477bs.m15979f();
        this.f4917H.f5118g = "android" + C1477bs.m15977g();
        if (TextUtils.isEmpty(C1514cx.f5416k)) {
        }
        this.f4917H.f5119h = C1514cx.f5416k;
        this.f4917H.f5120i = str9;
        this.f4917H.f5121j = "0";
        this.f4917H.f5122k = !this.f4911B ? "1" : "0";
        this.f4917H.f5123l = "0";
        this.f4917H.f5124m = "0";
        this.f4917H.f5125n = "0";
        this.f4917H.f5126o = str3;
        this.f4917H.f5127p = C1514cx.f5407b;
        this.f4917H.f5128q = C1514cx.f5408c;
        this.f4917H.f5130s = String.valueOf(m16017a);
        this.f4917H.f5131t = this.f4915F;
        this.f4917H.f5133v = m16281c();
        this.f4917H.f5134w = m16322C();
        this.f4917H.f5110F = this.f4916G;
        this.f4917H.f5132u = C1514cx.f5409d;
        this.f4917H.f5135x = str4;
        this.f4917H.f5136y = str5;
        this.f4917H.f5137z = String.valueOf(m16170c);
        this.f4917H.f5105A = str6;
        this.f4917H.f5106B = sb3.toString();
        this.f4917H.f5108D = sb4.toString();
        this.f4917H.f5109E = String.valueOf(C1477bs.m15997b() - this.f4913D);
        this.f4917H.f5107C = sb5.toString();
        sb3.delete(0, sb3.length());
        sb4.delete(0, sb4.length());
        sb5.delete(0, sb5.length());
        return sb2;
    }

    /* renamed from: a */
    private void m16305a(SharedPreferences sharedPreferences) {
        String str = null;
        if (this.f4951m == null || sharedPreferences == null) {
            return;
        }
        if (sharedPreferences.contains("smac")) {
            try {
                str = C1544dr.m15602b(sharedPreferences.getString("smac", null).getBytes("UTF-8"));
            } catch (Throwable th) {
                C1514cx.m15728a(th, "APS", "getSmac");
                sharedPreferences.edit().remove("smac").commit();
            }
        }
        if (TextUtils.isEmpty(str) || str.equals("00:00:00:00:00:00")) {
            return;
        }
        this.f4915F = str;
    }

    /* renamed from: a */
    private void m16291a(StringBuilder sb) {
        String[] strArr;
        if (sb == null) {
            return;
        }
        for (String str : new String[]{" phnum=\"\"", " nettype=\"\"", " nettype=\"UNKWN\"", " inftype=\"\"", "<macs><![CDATA[]]></macs>", "<nb></nb>", "<mmac><![CDATA[]]></mmac>", " gtype=\"0\"", " gmock=\"0\"", " glong=\"0.0\"", " glat=\"0.0\"", " precision=\"0.0\"", " glong=\"0\"", " glat=\"0\"", " precision=\"0\"", "<smac>null</smac>", "<smac>00:00:00:00:00:00</smac>", "<imei>000000000000000</imei>", "<imsi>000000000000000</imsi>", "<mcc>000</mcc>", "<mcc>0</mcc>", "<lac>0</lac>", "<cellid>0</cellid>", "<key></key>", "<poiid></poiid>", "<poiid>null</poiid>"}) {
            while (sb.indexOf(str) != -1) {
                int indexOf = sb.indexOf(str);
                sb.delete(indexOf, str.length() + indexOf);
            }
        }
        while (sb.indexOf("*<") != -1) {
            sb.deleteCharAt(sb.indexOf("*<"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16288a(boolean z, int i) {
        if (!z) {
            m16245y();
        } else {
            m16280c(i);
        }
    }

    /* renamed from: a */
    private boolean m16309a(int i) {
        int i2 = 20;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e) {
            C1514cx.m15728a(e, "APS", "wifiSigFine");
        }
        return i2 >= 1;
    }

    /* renamed from: a */
    private boolean m16307a(long j) {
        if (C1477bs.m15997b() - j < 800) {
            long j2 = 0;
            if (C1477bs.m16006a(this.f4961w)) {
                j2 = C1477bs.m16020a() - this.f4961w.m16516k();
            }
            return j2 <= AbstractC0517a.f1169e;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m16304a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getBSSID()) && wifiInfo.getSSID() != null && !wifiInfo.getBSSID().equals("00:00:00:00:00:00") && !wifiInfo.getBSSID().contains(" :") && !TextUtils.isEmpty(wifiInfo.getSSID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m16286b(int i) {
        int i2 = 70254591;
        if (!m16253q()) {
            return;
        }
        try {
            m16244z();
            switch (i) {
                case 1:
                    i2 = 674234367;
                    break;
                case 2:
                    if (m16324A()) {
                        i2 = 2083520511;
                        break;
                    } else {
                        i2 = 674234367;
                        break;
                    }
            }
            this.f4921L.m15918a((C1495ce) null, m16308a(1, i2, 1));
            this.f4922M = this.f4921L.m15903e();
            if (this.f4922M != null) {
                byte[] m15867a = this.f4922M.m15867a();
                String m16067a = this.f4941b.m16067a(m15867a, this.f4951m, "http://cgicol.amap.com/collection/writedata?ver=v1.0_ali&", false);
                if (m16253q()) {
                    if (TextUtils.isEmpty(m16067a) || !m16067a.equals("true")) {
                        this.f4920K++;
                        this.f4921L.m15918a(this.f4922M, m16308a(1, i2, 0));
                    } else {
                        this.f4921L.m15918a(this.f4922M, m16308a(1, i2, 1));
                        String m16014a = C1477bs.m16014a(0L, "yyyyMMdd");
                        if (m16014a.equals(String.valueOf(this.f4923N[0]))) {
                            int[] iArr = this.f4923N;
                            iArr[1] = m15867a.length + iArr[1];
                        } else {
                            this.f4923N[0] = Integer.parseInt(m16014a);
                            this.f4923N[1] = m15867a.length;
                        }
                        this.f4923N[2] = this.f4923N[2] + 1;
                        m16319F();
                    }
                }
            }
            m16250t();
            if (m16253q() && this.f4921L.m15898g() == 0) {
                m16245y();
            } else if (this.f4920K < 3) {
            } else {
                m16245y();
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "up");
        }
    }

    /* renamed from: b */
    private void m16284b(SharedPreferences sharedPreferences) {
        SharedPreferences sharedPreferences2;
        if (this.f4951m == null || (sharedPreferences2 = this.f4951m.getSharedPreferences("pref", 0)) == null || !sharedPreferences2.contains("coluphist")) {
            return;
        }
        try {
            String[] split = C1544dr.m15602b(sharedPreferences2.getString("coluphist", null).getBytes("UTF-8")).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (int i = 0; i < 3; i++) {
                this.f4923N[i] = Integer.parseInt(split[i]);
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "getColUpHist");
            sharedPreferences2.edit().remove("coluphist").commit();
        }
    }

    /* renamed from: c */
    private void m16280c(final int i) {
        if (this.f4919J == null) {
            this.f4919J = new TimerTask() { // from class: com.b.as.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Thread.currentThread().setPriority(1);
                    if (C1477bs.m15997b() - C1430as.this.f4964z < AbstractC0517a.f1169e) {
                        return;
                    }
                    if (C1430as.this.m16324A()) {
                        C1430as.this.m16286b(i);
                    } else {
                        C1430as.this.m16245y();
                    }
                }
            };
        }
        if (this.f4918I == null) {
            this.f4918I = new Timer("T-U", false);
            this.f4918I.schedule(this.f4919J, 2000L, 2000L);
        }
    }

    /* renamed from: c */
    private void m16279c(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null && sharedPreferences.contains("activityoffdl")) {
            try {
                String[] split = C1477bs.m15983d(sharedPreferences.getString("activityoffdl", null)).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                for (int i = 0; i < 2; i++) {
                    C1449az.f5016a[i] = Integer.parseInt(split[i]);
                }
            } catch (Throwable th) {
                C1514cx.m15728a(th, "APS", "getOffDlHist");
                sharedPreferences.edit().remove("activityoffdl").commit();
            }
        }
    }

    /* renamed from: i */
    private void m16266i() {
        try {
            this.f4953o = new C1455bc(this.f4951m, (WifiManager) C1477bs.m16012a(this.f4951m, "wifi"), this.f4960v);
            this.f4952n = (ConnectivityManager) C1477bs.m16012a(this.f4951m, "connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            intentFilter.addAction("android.location.GPS_FIX_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f4951m.registerReceiver(this.f4958t, intentFilter);
            m16255o();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "initBroadcastListener");
        }
    }

    /* renamed from: j */
    private void m16264j() {
        this.f4954p = new C1452bb(this.f4951m, this.f4960v);
        this.f4954p.m16158h();
    }

    /* renamed from: k */
    private void m16262k() {
        List<ScanResult> m16146a;
        long m15997b = C1477bs.m15997b();
        if (m16260l()) {
            ArrayList<ScanResult> arrayList = this.f4956r;
            if (m15997b - this.f4963y >= AbstractC0517a.f1169e) {
                synchronized (this.f4946h) {
                    arrayList.clear();
                }
            }
            m16255o();
            if (m15997b - this.f4963y >= AbstractC0517a.f1169e) {
                for (int i = 20; i > 0 && arrayList.isEmpty(); i--) {
                    try {
                        Thread.sleep(3000 / 20);
                    } catch (Throwable th) {
                        C1514cx.m15728a(th, "APS", "mayWaitForWifi");
                    }
                }
            }
            synchronized (this.f4946h) {
            }
            if (!arrayList.isEmpty() || this.f4953o == null || (m16146a = this.f4953o.m16146a()) == null) {
                return;
            }
            arrayList.addAll(m16146a);
        }
    }

    /* renamed from: l */
    private boolean m16260l() {
        boolean z = false;
        if (!TextUtils.isEmpty(this.f4916G)) {
            return true;
        }
        if (m16254p()) {
            if (this.f4912C == 0) {
                z = true;
            } else if (C1477bs.m15997b() - this.f4912C >= 3000 && C1477bs.m15997b() - this.f4913D >= 1500) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: m */
    private boolean m16258m() {
        return this.f4962x == 0 || C1477bs.m15997b() - this.f4962x > 20000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m16256n() {
        this.f4913D = 0L;
        this.f4955q.clear();
        this.f4959u = null;
        synchronized (this.f4946h) {
            this.f4956r.clear();
            this.f4957s.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m16255o() {
        boolean z;
        boolean z2 = false;
        if (!m16254p()) {
            return;
        }
        if (C1477bs.m15990c() < 18 && C1477bs.m15990c() > 3 && C1477bs.m16000a(this.f4960v, "wifiactivescan")) {
            try {
                z = "1".equals(this.f4960v.getString("wifiactivescan"));
            } catch (Throwable th) {
                C1514cx.m15728a(th, "APS", "updateWifi part1");
            }
            if (z) {
                try {
                    z2 = this.f4953o.m16138e();
                    if (z2) {
                        this.f4912C = C1477bs.m15997b();
                    }
                } catch (Throwable th2) {
                    C1514cx.m15728a(th2, "APS", "updateWifi part");
                }
            }
            if (!z2) {
                return;
            }
            try {
                if (!this.f4953o.m16139d()) {
                    return;
                }
                this.f4912C = C1477bs.m15997b();
                return;
            } catch (Throwable th3) {
                C1514cx.m15728a(th3, "APS", "updateWifi");
                return;
            }
        }
        z = false;
        if (z) {
        }
        if (!z2) {
        }
    }

    /* renamed from: p */
    private boolean m16254p() {
        if (this.f4953o != null) {
            return this.f4953o.m16137f();
        }
        return false;
    }

    /* renamed from: q */
    private boolean m16253q() {
        return this.f4921L != null;
    }

    /* renamed from: r */
    private boolean m16252r() {
        try {
            if (m16253q()) {
                return this.f4921L.m15906d();
            }
            return false;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "collStarted");
            return false;
        }
    }

    /* renamed from: s */
    private void m16251s() {
        if (!m16253q()) {
            return;
        }
        boolean z = true;
        if (C1477bs.m16000a(this.f4960v, "coll")) {
            try {
                if (this.f4960v.getString("coll").equals("0")) {
                    z = false;
                }
            } catch (Throwable th) {
                C1514cx.m15728a(th, "APS", "start3rdCM");
            }
        }
        if (!z) {
            m16249u();
        } else if (m16252r()) {
        } else {
            try {
                this.f4921L.m15913b(C1514cx.f5418m * 1000);
                m16244z();
                m16250t();
                this.f4921L.m15931a();
            } catch (Throwable th2) {
                C1514cx.m15728a(th2, "APS", "start3rdCM");
            }
        }
    }

    /* renamed from: t */
    private void m16250t() {
        if (!m16253q()) {
            return;
        }
        if (m16253q() && this.f4921L.m15898g() > 0) {
            return;
        }
        try {
            if (!m16253q()) {
                return;
            }
            if (this.f4921L.m15900f()) {
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "collFileSwitch");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m16249u() {
        if (!m16252r()) {
            return;
        }
        C1514cx.f5418m = 20;
        try {
            this.f4921L.m15909c();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "stop3rdCM");
        }
    }

    /* renamed from: v */
    private void m16248v() {
        if (this.f4951m != null && !TextUtils.isEmpty(this.f4915F)) {
            SharedPreferences sharedPreferences = this.f4951m.getSharedPreferences("pref", 0);
            String str = null;
            try {
                str = C1544dr.m15602b(this.f4915F.getBytes("UTF-8"));
            } catch (Throwable th) {
                C1514cx.m15728a(th, "APS", "setSmac");
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            sharedPreferences.edit().putString("smac", str).commit();
        }
    }

    /* renamed from: w */
    private void m16247w() {
        C1514cx.f5410e = "";
        C1514cx.f5411f = "";
        C1514cx.f5413h = "";
    }

    /* renamed from: x */
    private void m16246x() {
        ArrayList<ScanResult> arrayList = this.f4956r;
        String str = null;
        try {
            if (C1477bs.m16000a(this.f4960v, "wait1stwifi")) {
                str = this.f4960v.getString("wait1stwifi");
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "wait1StWifi part");
        }
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals("1")) {
                return;
            }
            synchronized (this.f4946h) {
                arrayList.clear();
            }
            m16255o();
            for (int i = 20; i > 0 && arrayList.isEmpty(); i--) {
                try {
                    Thread.sleep(3000 / 20);
                } catch (Throwable th2) {
                    C1514cx.m15728a(th2, "APS", "wait1StWifi");
                }
            }
            synchronized (this.f4946h) {
            }
            if (!arrayList.isEmpty() || this.f4953o == null) {
                return;
            }
            arrayList.addAll(this.f4953o.m16146a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m16245y() {
        if (this.f4919J != null) {
            this.f4919J.cancel();
            this.f4919J = null;
        }
        if (this.f4918I != null) {
            this.f4918I.cancel();
            this.f4918I.purge();
            this.f4918I = null;
        }
    }

    /* renamed from: z */
    private void m16244z() {
        if (!m16253q()) {
            return;
        }
        try {
            this.f4921L.m15930a(768);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "setCollSize");
        }
    }

    /* renamed from: a */
    public AmapLoc m16303a(AmapLoc amapLoc, String... strArr) {
        return (strArr == null || strArr.length == 0) ? C1444aw.m16218a().m16217a(amapLoc) : strArr[0].equals("shake") ? C1444aw.m16218a().m16217a(amapLoc) : strArr[0].equals("fusion") ? C1444aw.m16218a().m16215b(amapLoc) : amapLoc;
    }

    /* renamed from: a */
    public synchronized AmapLoc m16289a(boolean z) {
        AmapLoc amapLoc;
        boolean z2;
        String str;
        boolean z3 = true;
        boolean z4 = false;
        synchronized (this) {
            if (f4909c.length() > 0) {
                f4909c.delete(0, f4909c.length());
            }
            if (!m16320E()) {
                amapLoc = new AmapLoc();
                amapLoc.m16538b(1);
                amapLoc.m16537b(f4909c.toString());
            } else {
                boolean z5 = C1477bs.m16000a(this.f4960v, "reversegeo") ? this.f4960v.getBoolean("reversegeo") : true;
                boolean z6 = C1477bs.m16000a(this.f4960v, "isOffset") ? this.f4960v.getBoolean("isOffset") : true;
                if (z6 != this.f4939ac || z5 != this.f4938ab) {
                    m16311N();
                }
                this.f4939ac = z6;
                this.f4938ab = z5;
                this.f4914E++;
                this.f4910A = C1477bs.m16013a(this.f4951m);
                if (z) {
                    amapLoc = m16318G();
                } else {
                    if (this.f4914E == 2) {
                        m16250t();
                        m16321D();
                        if (this.f4951m != null) {
                            SharedPreferences sharedPreferences = this.f4951m.getSharedPreferences("pref", 0);
                            m16284b(sharedPreferences);
                            m16279c(sharedPreferences);
                            m16305a(sharedPreferences);
                        }
                        m16316I();
                    }
                    if (this.f4914E == 1 && m16254p()) {
                        if (this.f4956r.isEmpty()) {
                            this.f4913D = C1477bs.m15997b();
                            List<ScanResult> m16146a = this.f4953o.m16146a();
                            synchronized (this.f4946h) {
                                if (this.f4956r != null && m16146a != null) {
                                    this.f4956r.addAll(m16146a);
                                }
                            }
                        }
                        m16246x();
                    }
                    if (!m16307a(this.f4962x) || !C1477bs.m16006a(this.f4961w)) {
                        this.f4954p.m16162f();
                        if (!z) {
                            m16262k();
                            this.f4963y = C1477bs.m15997b();
                        }
                        m16276d();
                        m16274e();
                        String m16282b = m16282b(false);
                        if (!TextUtils.isEmpty(m16282b)) {
                            StringBuilder m16277c = m16277c(false);
                            C1451ba m16174b = !this.f4910A ? this.f4954p.m16174b() : null;
                            boolean z7 = !(m16174b == null && this.f4929T == null) && (this.f4929T == null || !this.f4929T.m16186a(m16174b));
                            boolean m16258m = m16258m();
                            if (this.f4961w != null) {
                                int size = this.f4955q.size();
                                if (this.f4961w.m16518j() <= 299.0f || size <= 5) {
                                    z3 = false;
                                }
                                z2 = z3;
                            } else {
                                z2 = false;
                            }
                            if (this.f4961w != null && this.f4928S != null && !z2 && !z7 && ((z4 = C1459bf.m16116a().m16107b(this.f4928S, m16277c)) || (this.f4927R != 0 && C1477bs.m15997b() - this.f4927R < 3000))) {
                                if (this.f4954p.m16175a(this.f4910A)) {
                                    this.f4954p.m16158h();
                                }
                                if (C1477bs.m16006a(this.f4961w)) {
                                    this.f4961w.m16525f("mem");
                                    this.f4961w.m16546a(2);
                                    amapLoc = this.f4961w;
                                }
                            }
                            if (!z4) {
                                this.f4927R = C1477bs.m15997b();
                            } else {
                                this.f4927R = 0L;
                            }
                            if (this.f4925P == null || m16282b.equals(this.f4925P)) {
                                if (this.f4925P == null) {
                                    this.f4926Q = C1477bs.m16020a();
                                    this.f4925P = m16282b;
                                    str = m16282b;
                                } else {
                                    this.f4926Q = C1477bs.m16020a();
                                    str = m16282b;
                                }
                            } else if (C1477bs.m16020a() - this.f4926Q < 3000) {
                                str = this.f4925P;
                            } else {
                                this.f4926Q = C1477bs.m16020a();
                                this.f4925P = m16282b;
                                str = m16282b;
                            }
                            AmapLoc amapLoc2 = null;
                            String str2 = str + "&" + this.f4939ac + "&" + this.f4938ab;
                            if (!z2 && !m16258m) {
                                amapLoc2 = C1459bf.m16116a().m16113a(str2, m16277c);
                            }
                            if (!(m16258m || C1477bs.m16006a(amapLoc2)) || z2) {
                                this.f4961w = m16292a(m16272f(), false, false);
                                if (C1477bs.m16006a(this.f4961w)) {
                                    this.f4961w.m16525f("new");
                                    this.f4928S = m16277c.toString();
                                    this.f4929T = m16174b;
                                    this.f4962x = C1477bs.m15997b();
                                    m16317H();
                                }
                            } else if (m16258m) {
                                this.f4961w = m16292a(m16272f(), false, false);
                                if (C1477bs.m16006a(this.f4961w)) {
                                    this.f4928S = m16277c.toString();
                                    this.f4929T = m16174b;
                                    this.f4962x = C1477bs.m15997b();
                                    m16317H();
                                }
                            } else {
                                this.f4927R = 0L;
                                amapLoc2.m16546a(4);
                                this.f4961w = amapLoc2;
                                m16317H();
                            }
                            C1459bf.m16116a().m16112a(str2, m16277c, this.f4961w, this.f4951m, true);
                            C1463bi.m16090a().m16088a(this.f4951m, str, this.f4961w);
                            if (!C1477bs.m16006a(this.f4961w)) {
                                AmapLoc m16294a = m16294a(str, m16277c.toString());
                                if (C1477bs.m16006a(m16294a)) {
                                    this.f4928S = m16277c.toString();
                                    AmapLoc amapLoc3 = this.f4961w;
                                    this.f4961w = m16294a;
                                    this.f4961w.m16546a(8);
                                    this.f4961w.m16537b("离线定位，在线定位失败原因:" + amapLoc3.m16530d());
                                }
                            }
                            m16277c.delete(0, m16277c.length());
                            amapLoc = this.f4961w;
                        } else {
                            if (!this.f4944f) {
                                m16270g();
                            }
                            for (int i = 4; i > 0 && this.f4943e != 0; i--) {
                                SystemClock.sleep(500L);
                            }
                            if (this.f4943e == 0) {
                                this.f4961w = this.f4942d.m16237d();
                                if (this.f4961w != null) {
                                    amapLoc = this.f4961w;
                                }
                            }
                            amapLoc = new AmapLoc();
                            amapLoc.m16538b(this.f4948j);
                            amapLoc.m16537b(f4909c.toString());
                        }
                    } else {
                        this.f4961w.m16546a(2);
                        amapLoc = this.f4961w;
                    }
                }
            }
        }
        return amapLoc;
    }

    /* renamed from: a */
    public void m16310a() {
        if (!C1473bp.m16055a() || C1477bs.m15997b() - C1473bp.m16047c() >= C1473bp.m16050b() || this.f4961w == null) {
            return;
        }
        if (this.f4961w.m16541b() != 2 && this.f4961w.m16541b() != 4) {
            return;
        }
        try {
            m16282b(false);
            m16277c(true);
            m16292a(m16272f(), false, true);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APS", "fusionLocation");
        }
    }

    /* renamed from: a */
    public synchronized void m16306a(Context context) {
        if (context != null) {
            if (TextUtils.isEmpty(C1514cx.f5416k)) {
                C1514cx.f5416k = C1477bs.m15994b(context);
            }
            if (this.f4951m == null) {
                this.f4951m = context.getApplicationContext();
                this.f4941b = C1467bl.m16071a(this.f4951m);
                this.f4921L = C1486by.m15929a(this.f4951m);
                this.f4964z = C1477bs.m15997b();
                m16266i();
                m16264j();
                C1514cx.f5419n = true;
                this.f4917H = new C1472bo();
                this.f4954p.m16167d();
                C1459bf.m16116a().m16115a(this.f4951m);
                C1463bi.m16090a().m16089a(this.f4951m);
                this.f4947i = true;
            }
        }
    }

    /* renamed from: a */
    public void m16295a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("##")) {
            m16247w();
            return;
        }
        String[] split = str.split("##");
        if (split.length != 4) {
            m16247w();
            return;
        }
        C1514cx.f5410e = split[0];
        C1514cx.f5411f = split[1];
        C1514cx.f5413h = split[2];
        C1514cx.f5414i = split[3];
    }

    /* renamed from: a */
    public void m16290a(JSONObject jSONObject) {
        this.f4960v = jSONObject;
        if (C1477bs.m16000a(jSONObject, "collwifiscan")) {
            try {
                String string = jSONObject.getString("collwifiscan");
                if (TextUtils.isEmpty(string)) {
                    C1514cx.f5418m = 20;
                } else {
                    C1514cx.f5418m = Integer.parseInt(string) / 1000;
                }
                if (m16252r()) {
                    this.f4921L.m15913b(C1514cx.f5418m * 1000);
                }
            } catch (Throwable th) {
                C1514cx.m15728a(th, "APS", "setExtra");
            }
        }
        if (this.f4954p != null) {
            this.f4954p.m16176a(jSONObject);
        }
        if (this.f4953o != null) {
            this.f4953o.m16143a(jSONObject);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x01a9 A[Catch: all -> 0x0053, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000c, B:9:0x0018, B:10:0x0020, B:12:0x0032, B:14:0x005a, B:15:0x005d, B:16:0x0068, B:21:0x006e, B:23:0x0076, B:24:0x0089, B:25:0x009f, B:27:0x00a5, B:29:0x00ec, B:32:0x00f6, B:34:0x0102, B:36:0x0108, B:38:0x015a, B:41:0x0164, B:43:0x0170, B:45:0x0176, B:49:0x0181, B:51:0x0189, B:53:0x018f, B:54:0x0199, B:56:0x01a9, B:57:0x01f4, B:59:0x01fc, B:60:0x01be, B:62:0x01c4, B:64:0x01cf, B:65:0x01d7, B:67:0x01ec, B:71:0x003a, B:73:0x0040, B:74:0x0056, B:75:0x004d), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f4 A[Catch: all -> 0x0053, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000c, B:9:0x0018, B:10:0x0020, B:12:0x0032, B:14:0x005a, B:15:0x005d, B:16:0x0068, B:21:0x006e, B:23:0x0076, B:24:0x0089, B:25:0x009f, B:27:0x00a5, B:29:0x00ec, B:32:0x00f6, B:34:0x0102, B:36:0x0108, B:38:0x015a, B:41:0x0164, B:43:0x0170, B:45:0x0176, B:49:0x0181, B:51:0x0189, B:53:0x018f, B:54:0x0199, B:56:0x01a9, B:57:0x01f4, B:59:0x01fc, B:60:0x01be, B:62:0x01c4, B:64:0x01cf, B:65:0x01d7, B:67:0x01ec, B:71:0x003a, B:73:0x0040, B:74:0x0056, B:75:0x004d), top: B:3:0x0003 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String m16282b(boolean z) {
        String str;
        boolean z2 = false;
        synchronized (this) {
            if (this.f4910A) {
                this.f4954p.m16160g();
            } else {
                this.f4954p.m16155j();
            }
            str = "";
            if (m16254p()) {
                this.f4959u = this.f4953o.m16141b();
            } else {
                m16256n();
            }
            int m16170c = this.f4954p.m16170c();
            ArrayList<C1451ba> m16185a = this.f4954p.m16185a();
            ArrayList<ScanResult> arrayList = this.f4955q;
            if ((m16185a == null || m16185a.isEmpty()) && (arrayList == null || arrayList.isEmpty())) {
                f4909c.append("⊗ lstCgi & ⊗ wifis");
                this.f4948j = 12;
            } else {
                switch (m16170c) {
                    case 1:
                        if (!m16185a.isEmpty()) {
                            C1451ba c1451ba = m16185a.get(0);
                            StringBuilder sb = new StringBuilder();
                            sb.append(c1451ba.f5026a).append("#");
                            sb.append(c1451ba.f5027b).append("#");
                            sb.append(c1451ba.f5028c).append("#");
                            sb.append(c1451ba.f5029d).append("#");
                            sb.append(C3947a.f16908s).append("#");
                            sb.append((!arrayList.isEmpty() || m16304a(this.f4959u)) ? "cgiwifi" : "cgi");
                            str = sb.toString();
                            break;
                        }
                        break;
                    case 2:
                        if (!m16185a.isEmpty()) {
                            C1451ba c1451ba2 = m16185a.get(0);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(c1451ba2.f5026a).append("#");
                            sb2.append(c1451ba2.f5027b).append("#");
                            sb2.append(c1451ba2.f5032g).append("#");
                            sb2.append(c1451ba2.f5033h).append("#");
                            sb2.append(c1451ba2.f5034i).append("#");
                            sb2.append(C3947a.f16908s).append("#");
                            sb2.append((!arrayList.isEmpty() || m16304a(this.f4959u)) ? "cgiwifi" : "cgi");
                            str = sb2.toString();
                            break;
                        }
                        break;
                    case 9:
                        boolean z3 = !arrayList.isEmpty() || m16304a(this.f4959u);
                        if (!z) {
                            if (m16304a(this.f4959u) && arrayList.isEmpty()) {
                                this.f4948j = 2;
                                f4909c.append("⊗ around wifi(s) & has access wifi");
                            } else if (arrayList.size() == 1) {
                                this.f4948j = 2;
                                if (!m16304a(this.f4959u)) {
                                    f4909c.append("⊗ access wifi & around wifi 1");
                                } else if (this.f4959u.getBSSID().equals(arrayList.get(0).BSSID)) {
                                    f4909c.append("same access wifi & around wifi 1");
                                }
                            }
                            str = String.format(Locale.US, "#%s#", C3947a.f16908s);
                            if (z2) {
                                if (C3947a.f16908s.equals(C3947a.f16908s)) {
                                    str = "";
                                    this.f4948j = 2;
                                    f4909c.append("is network & no wifi");
                                    break;
                                }
                            } else {
                                str = str + "wifi";
                                break;
                            }
                        }
                        z2 = z3;
                        str = String.format(Locale.US, "#%s#", C3947a.f16908s);
                        if (z2) {
                        }
                        break;
                    default:
                        this.f4948j = 11;
                        f4909c.append("get cgi failure");
                        break;
                }
                if (!TextUtils.isEmpty(str)) {
                    if (!str.startsWith("#")) {
                        str = "#" + str;
                    }
                    str = C1477bs.m15974j() + str;
                }
            }
        }
        return str;
    }

    /* renamed from: b */
    public synchronized void m16287b() {
        this.f4947i = false;
        C1514cx.f5419n = false;
        m16249u();
        this.f4921L = null;
        this.f4922M = null;
        this.f4928S = null;
        m16317H();
        if (this.f4942d != null) {
            this.f4942d.m16243a();
            this.f4942d = null;
            this.f4944f = false;
            this.f4943e = -1;
        }
        m16245y();
        C1461bg.m16100a().m16098a(this.f4951m, 1);
        C1444aw.m16218a().m16216b();
        C1477bs.m15975i();
        if (this.f4951m != null) {
            this.f4951m.unregisterReceiver(this.f4958t);
        }
        this.f4958t = null;
        if (this.f4954p != null) {
            this.f4954p.m16156i();
        }
        C1459bf.m16116a().m16106c();
        C1463bi.m16090a().m16085c();
        C1449az.m16209a();
        m16315J();
        this.f4962x = 0L;
        this.f4926Q = 0L;
        m16256n();
        this.f4961w = null;
        this.f4951m = null;
        f4908ae = -1;
    }

    /* renamed from: b */
    public synchronized void m16285b(Context context) {
        try {
            if (f4908ae == -1) {
                f4908ae = 1;
                C1534dn.m15658a(this.f4951m, C1514cx.m15729a("2.4.1"));
                C1473bp.m16054a(context);
            }
        } finally {
        }
    }

    /* renamed from: c */
    public String m16281c() {
        return "2.4.1";
    }

    /* renamed from: c */
    public synchronized StringBuilder m16277c(boolean z) {
        StringBuilder sb;
        boolean z2 = false;
        synchronized (this) {
            C1452bb c1452bb = this.f4954p;
            if (this.f4910A) {
                c1452bb.m16160g();
            }
            sb = new StringBuilder((int) IMediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING);
            int m16170c = c1452bb.m16170c();
            ArrayList<C1451ba> m16185a = c1452bb.m16185a();
            switch (m16170c) {
                case 1:
                    for (int i = 1; i < m16185a.size(); i++) {
                        sb.append("#").append(m16185a.get(i).f5027b);
                        sb.append("|").append(m16185a.get(i).f5028c);
                        sb.append("|").append(m16185a.get(i).f5029d);
                    }
                    break;
            }
            if (((!z && TextUtils.isEmpty(this.f4915F)) || this.f4915F.equals("00:00:00:00:00:00")) && this.f4959u != null) {
                this.f4915F = this.f4959u.getMacAddress();
                m16248v();
                if (TextUtils.isEmpty(this.f4915F)) {
                    this.f4915F = "00:00:00:00:00:00";
                }
            }
            if (m16254p()) {
                String bssid = m16304a(this.f4959u) ? this.f4959u.getBSSID() : "";
                ArrayList<ScanResult> arrayList = this.f4955q;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2).BSSID;
                    String str2 = "nb";
                    if (bssid.equals(str)) {
                        str2 = "access";
                        z2 = true;
                    }
                    sb.append(String.format(Locale.US, "#%s,%s", str, str2));
                }
                if (!z2 && !TextUtils.isEmpty(bssid)) {
                    sb.append("#").append(bssid);
                    sb.append(",access");
                }
            } else {
                m16256n();
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
            }
        }
        return sb;
    }

    /* renamed from: d */
    public synchronized void m16276d() {
        ArrayList<ScanResult> arrayList = this.f4955q;
        ArrayList<ScanResult> arrayList2 = this.f4956r;
        arrayList.clear();
        synchronized (this.f4946h) {
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.addAll(arrayList2);
            }
        }
    }

    /* renamed from: e */
    public synchronized void m16274e() {
        boolean z;
        if (this.f4955q != null && !this.f4955q.isEmpty()) {
            if (C1477bs.m15997b() - this.f4913D > Util.MILLSECONDS_OF_HOUR) {
                m16256n();
            }
            boolean m15976h = C1477bs.m15976h();
            if (C1477bs.m16000a(this.f4960v, "nbssid")) {
                if (this.f4960v.getString("nbssid").equals("1")) {
                    m15976h = true;
                } else if (this.f4960v.getString("nbssid").equals("0")) {
                    m15976h = false;
                }
                z = m15976h;
            } else {
                z = m15976h;
            }
            Hashtable hashtable = new Hashtable();
            List list = this.f4955q;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ScanResult scanResult = (ScanResult) list.get(i);
                if (C1477bs.m16010a(scanResult) && (size <= 20 || m16309a(scanResult.level))) {
                    if (TextUtils.isEmpty(scanResult.SSID)) {
                        scanResult.SSID = "unkwn";
                    } else if (z) {
                        scanResult.SSID = scanResult.SSID.replace(AbstractC5756f.f23062a, ".");
                        if (scanResult.SSID.getBytes("UTF-8").length >= 32) {
                            scanResult.SSID = String.valueOf(i);
                        }
                    } else {
                        scanResult.SSID = String.valueOf(i);
                    }
                    hashtable.put(Integer.valueOf((scanResult.level * 30) + i), scanResult);
                }
            }
            TreeMap treeMap = new TreeMap(Collections.reverseOrder());
            treeMap.putAll(hashtable);
            list.clear();
            for (Object obj : treeMap.keySet()) {
                list.add(treeMap.get(obj));
            }
            hashtable.clear();
            treeMap.clear();
        }
    }

    /* renamed from: f */
    public synchronized String m16272f() {
        String str = null;
        synchronized (this) {
            if (this.f4954p.m16175a(this.f4910A)) {
                this.f4954p.m16158h();
            }
            StringBuilder m16296a = m16296a((Object) null);
            if (m16296a != null) {
                str = m16296a.toString();
            } else {
                f4909c.append("get parames is null");
            }
        }
        return str;
    }

    /* renamed from: g */
    public synchronized void m16270g() {
        if (this.f4914E >= 1 && !this.f4944f) {
            if (this.f4942d == null) {
                this.f4942d = new C1435at(this.f4951m.getApplicationContext());
                this.f4942d.m16241a(this.f4950l);
            }
            if (this.f4942d != null) {
                this.f4942d.m16239b();
            }
            this.f4944f = true;
        }
    }

    /* renamed from: h */
    public void m16268h() {
        if (!this.f4949k || m16252r()) {
            return;
        }
        m16251s();
    }
}
