package com.p080b;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;
/* renamed from: com.b.bf */
/* loaded from: classes.dex */
public class C1459bf {

    /* renamed from: a */
    private static C1459bf f5069a = null;

    /* renamed from: b */
    private Hashtable<String, ArrayList<C1460a>> f5070b = new Hashtable<>();

    /* renamed from: c */
    private long f5071c = 0;

    /* renamed from: d */
    private boolean f5072d = false;

    /* renamed from: com.b.bf$a */
    /* loaded from: classes.dex */
    public class C1460a {

        /* renamed from: b */
        private AmapLoc f5074b = null;

        /* renamed from: c */
        private String f5075c = null;

        protected C1460a() {
        }

        /* renamed from: a */
        public AmapLoc m16104a() {
            return this.f5074b;
        }

        /* renamed from: a */
        public void m16103a(AmapLoc amapLoc) {
            this.f5074b = amapLoc;
        }

        /* renamed from: a */
        public void m16102a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f5075c = null;
            } else {
                this.f5075c = str.replace("##", "#");
            }
        }

        /* renamed from: b */
        public String m16101b() {
            return this.f5075c;
        }
    }

    private C1459bf() {
    }

    /* renamed from: a */
    private synchronized C1460a m16110a(StringBuilder sb, String str) {
        C1460a c1460a;
        boolean z;
        if (this.f5070b.isEmpty() || TextUtils.isEmpty(sb)) {
            c1460a = null;
        } else if (!this.f5070b.containsKey(str)) {
            c1460a = null;
        } else {
            Hashtable<String, String> hashtable = new Hashtable<>();
            Hashtable<String, String> hashtable2 = new Hashtable<>();
            Hashtable hashtable3 = new Hashtable();
            ArrayList<C1460a> arrayList = this.f5070b.get(str);
            int size = arrayList.size() - 1;
            while (true) {
                if (size < 0) {
                    c1460a = null;
                    break;
                }
                C1460a c1460a2 = arrayList.get(size);
                if (!TextUtils.isEmpty(c1460a2.m16101b())) {
                    if (!m16105c(c1460a2.m16101b(), sb)) {
                        z = false;
                    } else if (m16107b(c1460a2.m16101b(), sb)) {
                        c1460a = c1460a2;
                        break;
                    } else {
                        z = true;
                    }
                    m16111a(c1460a2.m16101b(), hashtable);
                    m16111a(sb.toString(), hashtable2);
                    hashtable3.clear();
                    for (String str2 : hashtable.keySet()) {
                        hashtable3.put(str2, "");
                    }
                    for (String str3 : hashtable2.keySet()) {
                        hashtable3.put(str3, "");
                    }
                    Set keySet = hashtable3.keySet();
                    double[] dArr = new double[keySet.size()];
                    double[] dArr2 = new double[keySet.size()];
                    Iterator it2 = keySet.iterator();
                    int i = 0;
                    while (it2 != null && it2.hasNext()) {
                        String str4 = (String) it2.next();
                        dArr[i] = hashtable.containsKey(str4) ? 1.0d : 0.0d;
                        dArr2[i] = hashtable2.containsKey(str4) ? 1.0d : 0.0d;
                        i++;
                    }
                    keySet.clear();
                    double[] m16109a = m16109a(dArr, dArr2);
                    if (m16109a[0] >= 0.800000011920929d) {
                        c1460a = c1460a2;
                        break;
                    } else if (m16109a[1] >= 0.618d) {
                        c1460a = c1460a2;
                        break;
                    } else if (z && m16109a[0] >= 0.618d) {
                        c1460a = c1460a2;
                        break;
                    }
                }
                size--;
            }
            hashtable.clear();
            hashtable2.clear();
            hashtable3.clear();
        }
        return c1460a;
    }

    /* renamed from: a */
    public static synchronized C1459bf m16116a() {
        C1459bf c1459bf;
        synchronized (C1459bf.class) {
            if (f5069a == null) {
                f5069a = new C1459bf();
            }
            c1459bf = f5069a;
        }
        return c1459bf;
    }

    /* renamed from: a */
    private void m16111a(String str, Hashtable<String, String> hashtable) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        for (String str2 : str.split("#")) {
            if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                hashtable.put(str2, "");
            }
        }
    }

    /* renamed from: a */
    private double[] m16109a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dArr.length; i3++) {
            d2 += dArr[i3] * dArr[i3];
            d3 += dArr2[i3] * dArr2[i3];
            d += dArr[i3] * dArr2[i3];
            if (dArr2[i3] == 1.0d) {
                i++;
                if (dArr[i3] == 1.0d) {
                    i2++;
                }
            }
        }
        dArr3[0] = d / (Math.sqrt(d3) * Math.sqrt(d2));
        dArr3[1] = (1.0d * i2) / i;
        dArr3[2] = i2;
        for (int i4 = 0; i4 < dArr3.length - 1; i4++) {
            if (dArr3[i4] > 1.0d) {
                dArr3[i4] = 1.0d;
            }
            dArr3[i4] = Double.parseDouble(C1477bs.m16003a(Double.valueOf(dArr3[i4]), "#.00"));
        }
        return dArr3;
    }

    /* renamed from: c */
    private boolean m16105c(String str, StringBuilder sb) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(sb)) {
            return false;
        }
        if (!str.contains(",access") || sb.indexOf(",access") == -1) {
            return false;
        }
        String[] split = str.split(",access");
        String substring = split[0].contains("#") ? split[0].substring(split[0].lastIndexOf("#") + 1) : split[0];
        if (!TextUtils.isEmpty(substring)) {
            return sb.toString().contains(substring + ",access");
        }
        return false;
    }

    /* renamed from: a */
    public synchronized AmapLoc m16113a(String str, StringBuilder sb) {
        C1460a c1460a;
        AmapLoc amapLoc;
        if (str.contains(GeocodeSearch.GPS)) {
            amapLoc = null;
        } else if (m16108b()) {
            m16106c();
            amapLoc = null;
        } else if (this.f5070b.isEmpty()) {
            amapLoc = null;
        } else {
            if (str.contains("cgiwifi")) {
                c1460a = m16110a(sb, str);
                if (c1460a != null) {
                }
            } else if (str.contains("wifi")) {
                c1460a = m16110a(sb, str);
                if (c1460a != null) {
                }
            } else if (str.contains("cgi")) {
                c1460a = this.f5070b.containsKey(str) ? this.f5070b.get(str).get(0) : null;
                if (c1460a != null) {
                }
            } else {
                c1460a = null;
            }
            if (c1460a == null || !C1477bs.m16006a(c1460a.m16104a())) {
                amapLoc = null;
            } else {
                c1460a.m16104a().m16525f("mem");
                if (TextUtils.isEmpty(C1514cx.f5412g)) {
                    C1514cx.f5412g = String.valueOf(c1460a.m16104a().m16555B());
                }
                amapLoc = c1460a.m16104a();
            }
        }
        return amapLoc;
    }

    /* renamed from: a */
    public void m16115a(Context context) {
        if (this.f5072d) {
            return;
        }
        C1477bs.m15997b();
        try {
            C1461bg.m16100a().m16099a(context);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Cache", "loadDB");
        }
        this.f5072d = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
        if (r0 < 8) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ec A[Catch: all -> 0x010c, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0002, B:9:0x000a, B:11:0x0016, B:13:0x0022, B:15:0x002e, B:17:0x0034, B:18:0x0037, B:20:0x0043, B:21:0x004b, B:23:0x0053, B:25:0x0059, B:27:0x0063, B:29:0x0071, B:31:0x007b, B:33:0x007d, B:38:0x0084, B:40:0x008c, B:42:0x0096, B:44:0x00a8, B:45:0x00b3, B:47:0x00bd, B:49:0x00cc, B:52:0x00e1, B:54:0x00ec, B:58:0x013f, B:59:0x013a, B:60:0x010f, B:63:0x011b, B:65:0x0123, B:67:0x012c, B:56:0x00f9), top: B:3:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f9 A[Catch: Throwable -> 0x0102, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0002, B:9:0x000a, B:11:0x0016, B:13:0x0022, B:15:0x002e, B:17:0x0034, B:18:0x0037, B:20:0x0043, B:21:0x004b, B:23:0x0053, B:25:0x0059, B:27:0x0063, B:29:0x0071, B:31:0x007b, B:33:0x007d, B:38:0x0084, B:40:0x008c, B:42:0x0096, B:44:0x00a8, B:45:0x00b3, B:47:0x00bd, B:49:0x00cc, B:52:0x00e1, B:54:0x00ec, B:58:0x013f, B:59:0x013a, B:60:0x010f, B:63:0x011b, B:65:0x0123, B:67:0x012c, B:56:0x00f9), top: B:3:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013f A[Catch: all -> 0x010c, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0002, B:9:0x000a, B:11:0x0016, B:13:0x0022, B:15:0x002e, B:17:0x0034, B:18:0x0037, B:20:0x0043, B:21:0x004b, B:23:0x0053, B:25:0x0059, B:27:0x0063, B:29:0x0071, B:31:0x007b, B:33:0x007d, B:38:0x0084, B:40:0x008c, B:42:0x0096, B:44:0x00a8, B:45:0x00b3, B:47:0x00bd, B:49:0x00cc, B:52:0x00e1, B:54:0x00ec, B:58:0x013f, B:59:0x013a, B:60:0x010f, B:63:0x011b, B:65:0x0123, B:67:0x012c, B:56:0x00f9), top: B:3:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013a A[Catch: all -> 0x010c, TryCatch #1 {, blocks: (B:4:0x0002, B:9:0x000a, B:11:0x0016, B:13:0x0022, B:15:0x002e, B:17:0x0034, B:18:0x0037, B:20:0x0043, B:21:0x004b, B:23:0x0053, B:25:0x0059, B:27:0x0063, B:29:0x0071, B:31:0x007b, B:33:0x007d, B:38:0x0084, B:40:0x008c, B:42:0x0096, B:44:0x00a8, B:45:0x00b3, B:47:0x00bd, B:49:0x00cc, B:52:0x00e1, B:54:0x00ec, B:58:0x013f, B:59:0x013a, B:60:0x010f, B:63:0x011b, B:65:0x0123, B:67:0x012c, B:56:0x00f9), top: B:3:0x0002 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m16112a(String str, StringBuilder sb, AmapLoc amapLoc, Context context, boolean z) {
        AmapLoc m16113a;
        int i = 0;
        synchronized (this) {
            if (m16114a(str, amapLoc) && !amapLoc.m16514l().equals("mem") && !amapLoc.m16514l().equals("file") && !amapLoc.m16512m().equals("-3")) {
                if (m16108b()) {
                    m16106c();
                }
                JSONObject m16551E = amapLoc.m16551E();
                if (C1477bs.m16000a(m16551E, "offpct")) {
                    m16551E.remove("offpct");
                    amapLoc.m16543a(m16551E);
                }
                if (!str.contains("wifi")) {
                    if (str.contains("cgi")) {
                        if (sb.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP) == -1) {
                            if (amapLoc.m16512m().equals("4")) {
                            }
                        }
                    }
                    m16113a = m16113a(str, sb);
                    if (C1477bs.m16006a(m16113a)) {
                    }
                    this.f5071c = C1477bs.m15997b();
                    C1460a c1460a = new C1460a();
                    c1460a.m16103a(amapLoc);
                    c1460a.m16102a(!TextUtils.isEmpty(sb) ? null : sb.toString());
                    if (!this.f5070b.containsKey(str)) {
                    }
                    if (z) {
                    }
                } else if (!TextUtils.isEmpty(sb)) {
                    if (amapLoc.m16518j() >= 300.0f) {
                        for (String str2 : sb.toString().split("#")) {
                            if (str2.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                                i++;
                            }
                        }
                    } else {
                        if (amapLoc.m16518j() <= 10.0f) {
                        }
                        if (str.contains("cgiwifi") && !TextUtils.isEmpty(amapLoc.m16553C())) {
                            String replace = str.replace("cgiwifi", "cgi");
                            AmapLoc m16552D = amapLoc.m16552D();
                            if (C1477bs.m16006a(m16552D)) {
                                m16112a(replace, new StringBuilder(), m16552D, context, true);
                            }
                        }
                    }
                    m16113a = m16113a(str, sb);
                    if (C1477bs.m16006a(m16113a) || !m16113a.m16550F().equals(amapLoc.m16532c(3))) {
                        this.f5071c = C1477bs.m15997b();
                        C1460a c1460a2 = new C1460a();
                        c1460a2.m16103a(amapLoc);
                        c1460a2.m16102a(!TextUtils.isEmpty(sb) ? null : sb.toString());
                        if (!this.f5070b.containsKey(str)) {
                            this.f5070b.get(str).add(c1460a2);
                        } else {
                            ArrayList<C1460a> arrayList = new ArrayList<>();
                            arrayList.add(c1460a2);
                            this.f5070b.put(str, arrayList);
                        }
                        if (z) {
                            C1461bg.m16100a().m16095a(str, amapLoc, sb, context);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m16114a(String str, AmapLoc amapLoc) {
        return !TextUtils.isEmpty(str) && C1477bs.m16006a(amapLoc) && !str.startsWith("#") && str.contains(C3947a.f16908s);
    }

    /* renamed from: b */
    public boolean m16108b() {
        long m15997b = C1477bs.m15997b() - this.f5071c;
        if (this.f5071c == 0) {
            return false;
        }
        return this.f5070b.size() > 360 || m15997b > 36000000;
    }

    /* renamed from: b */
    public boolean m16107b(String str, StringBuilder sb) {
        String[] split = str.split("#");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains(",nb") || split[i].contains(",access")) {
                arrayList.add(split[i]);
            }
        }
        String[] split2 = sb.toString().split("#");
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < split2.length; i4++) {
            if (split2[i4].contains(",nb") || split2[i4].contains(",access")) {
                i2++;
                if (arrayList.contains(split2[i4])) {
                    i3++;
                }
            }
        }
        return ((double) (i3 * 2)) >= ((double) (arrayList.size() + i2)) * 0.618d;
    }

    /* renamed from: c */
    public void m16106c() {
        this.f5071c = 0L;
        if (!this.f5070b.isEmpty()) {
            this.f5070b.clear();
        }
        this.f5072d = false;
    }
}
