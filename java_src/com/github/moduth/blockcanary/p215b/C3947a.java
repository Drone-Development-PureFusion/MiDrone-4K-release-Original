package com.github.moduth.blockcanary.p215b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.github.moduth.blockcanary.C3953c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.github.moduth.blockcanary.b.a */
/* loaded from: classes.dex */
public final class C3947a {

    /* renamed from: Q */
    private static final String f16887Q = "Block";

    /* renamed from: V */
    private static final SimpleDateFormat f16888V = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");

    /* renamed from: W */
    private static final String f16889W = "empty_imei";

    /* renamed from: a */
    public static final String f16890a = "\r\n";

    /* renamed from: b */
    public static final String f16891b = " = ";

    /* renamed from: c */
    public static final String f16892c = "qualifier";

    /* renamed from: d */
    public static final String f16893d = "model";

    /* renamed from: e */
    public static final String f16894e = "apilevel";

    /* renamed from: f */
    public static final String f16895f = "imei";

    /* renamed from: g */
    public static final String f16896g = "uid";

    /* renamed from: h */
    public static final String f16897h = "cpuCore";

    /* renamed from: i */
    public static final String f16898i = "cpubusy";

    /* renamed from: j */
    public static final String f16899j = "cpurate";

    /* renamed from: k */
    public static final String f16900k = "timecost";

    /* renamed from: l */
    public static final String f16901l = "threadtimecost";

    /* renamed from: m */
    public static final String f16902m = "timestart";

    /* renamed from: n */
    public static final String f16903n = "timeend";

    /* renamed from: o */
    public static final String f16904o = "stack";

    /* renamed from: p */
    public static final String f16905p = "processName";

    /* renamed from: q */
    public static final String f16906q = "versionName";

    /* renamed from: r */
    public static final String f16907r = "versionCode";

    /* renamed from: s */
    public static final String f16908s = "network";

    /* renamed from: t */
    public static final String f16909t = "totalMemory";

    /* renamed from: u */
    public static final String f16910u = "freeMemory";

    /* renamed from: v */
    public static final String f16911v = "newInstance: ";

    /* renamed from: A */
    public String f16912A;

    /* renamed from: B */
    public int f16913B;

    /* renamed from: C */
    public String f16914C;

    /* renamed from: E */
    public int f16916E;

    /* renamed from: F */
    public String f16917F;

    /* renamed from: G */
    public String f16918G;

    /* renamed from: H */
    public String f16919H;

    /* renamed from: I */
    public long f16920I;

    /* renamed from: J */
    public long f16921J;

    /* renamed from: K */
    public String f16922K;

    /* renamed from: L */
    public String f16923L;

    /* renamed from: M */
    public boolean f16924M;

    /* renamed from: N */
    public String f16925N;

    /* renamed from: P */
    public File f16927P;

    /* renamed from: w */
    public String f16932w;

    /* renamed from: x */
    public String f16933x;

    /* renamed from: y */
    public String f16934y = "";

    /* renamed from: z */
    public String f16935z = "";

    /* renamed from: D */
    public String f16915D = "";

    /* renamed from: O */
    public ArrayList<String> f16926O = new ArrayList<>();

    /* renamed from: R */
    private StringBuilder f16928R = new StringBuilder();

    /* renamed from: S */
    private StringBuilder f16929S = new StringBuilder();

    /* renamed from: T */
    private StringBuilder f16930T = new StringBuilder();

    /* renamed from: U */
    private StringBuilder f16931U = new StringBuilder();

    private C3947a() {
    }

    /* renamed from: a */
    public static C3947a m6404a() {
        C3947a c3947a = new C3947a();
        Context mo6365e = C3953c.m6380b().mo6365e();
        if (c3947a.f16915D == null || c3947a.f16915D.length() == 0) {
            try {
                PackageInfo packageInfo = mo6365e.getPackageManager().getPackageInfo(mo6365e.getPackageName(), 0);
                c3947a.f16916E = packageInfo.versionCode;
                c3947a.f16915D = packageInfo.versionName;
            } catch (Throwable th) {
                Log.e(f16887Q, f16911v, th);
            }
        }
        if (c3947a.f16935z == null || c3947a.f16935z.length() == 0) {
            try {
                c3947a.f16935z = ((TelephonyManager) mo6365e.getSystemService("phone")).getDeviceId();
            } catch (Exception e) {
                Log.e(f16887Q, f16911v, e);
                c3947a.f16935z = f16889W;
            }
        }
        c3947a.f16932w = C3953c.m6380b().mo6364f();
        c3947a.f16934y = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
        c3947a.f16933x = Build.MODEL;
        c3947a.f16912A = C3953c.m6380b().mo6363g();
        c3947a.f16913B = C3950c.m6390a();
        c3947a.f16914C = C3952d.m6387a();
        c3947a.f16917F = C3953c.m6380b().mo6362h();
        c3947a.f16918G = String.valueOf(C3950c.m6389b());
        c3947a.f16919H = String.valueOf(C3950c.m6388c());
        return c3947a;
    }

    /* renamed from: a */
    public static C3947a m6402a(File file) {
        BufferedReader bufferedReader;
        C3947a c3947a = new C3947a();
        c3947a.f16927P = file;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            try {
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    if (readLine.startsWith(f16892c)) {
                        c3947a.f16932w = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16893d)) {
                        c3947a.f16933x = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16894e)) {
                        c3947a.f16934y = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16895f)) {
                        c3947a.f16935z = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16896g)) {
                        c3947a.f16912A = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16897h)) {
                        c3947a.f16913B = Integer.valueOf(readLine.split(f16891b)[1]).intValue();
                    } else if (readLine.startsWith(f16905p)) {
                        c3947a.f16914C = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16906q)) {
                        c3947a.f16915D = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16907r)) {
                        c3947a.f16916E = Integer.valueOf(readLine.split(f16891b)[1]).intValue();
                    } else if (readLine.startsWith(f16908s)) {
                        c3947a.f16917F = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16909t)) {
                        c3947a.f16919H = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16910u)) {
                        c3947a.f16918G = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16898i)) {
                        c3947a.f16924M = Boolean.valueOf(readLine.split(f16891b)[1]).booleanValue();
                    } else if (readLine.startsWith(f16899j)) {
                        String[] split = readLine.split(f16891b);
                        if (split.length > 1) {
                            StringBuilder sb = new StringBuilder(split[1]);
                            sb.append(readLine.split(f16891b)[1]).append(f16890a);
                            for (String readLine2 = bufferedReader.readLine(); readLine2 != null && !readLine2.equals(""); readLine2 = bufferedReader.readLine()) {
                                sb.append(readLine2).append(f16890a);
                            }
                            c3947a.f16925N = sb.toString();
                        }
                    } else if (readLine.startsWith(f16902m)) {
                        c3947a.f16922K = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16903n)) {
                        c3947a.f16923L = readLine.split(f16891b)[1];
                    } else if (readLine.startsWith(f16900k)) {
                        c3947a.f16920I = Long.valueOf(readLine.split(f16891b)[1]).longValue();
                    } else if (readLine.startsWith(f16901l)) {
                        c3947a.f16921J = Long.valueOf(readLine.split(f16891b)[1]).longValue();
                    } else if (readLine.startsWith(f16904o)) {
                        StringBuilder sb2 = new StringBuilder(readLine.split(f16891b)[1]);
                        for (String readLine3 = bufferedReader.readLine(); readLine3 != null; readLine3 = bufferedReader.readLine()) {
                            if (!readLine3.equals("")) {
                                sb2.append(readLine3).append(f16890a);
                            } else if (sb2.length() > 0) {
                                c3947a.f16926O.add(sb2.toString());
                                sb2 = new StringBuilder();
                            }
                        }
                    }
                }
                bufferedReader.close();
                BufferedReader bufferedReader2 = null;
                if (0 != 0) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e) {
                        Log.e(f16887Q, f16911v, e);
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    Log.e(f16887Q, f16911v, th);
                    c3947a.m6398b();
                    return c3947a;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e2) {
                            Log.e(f16887Q, f16911v, e2);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        c3947a.m6398b();
        return c3947a;
    }

    /* renamed from: a */
    public C3947a m6403a(long j, long j2, long j3, long j4) {
        this.f16920I = j2 - j;
        this.f16921J = j4 - j3;
        this.f16922K = f16888V.format(Long.valueOf(j));
        this.f16923L = f16888V.format(Long.valueOf(j2));
        return this;
    }

    /* renamed from: a */
    public C3947a m6401a(String str) {
        this.f16925N = str;
        return this;
    }

    /* renamed from: a */
    public C3947a m6400a(ArrayList<String> arrayList) {
        this.f16926O = arrayList;
        return this;
    }

    /* renamed from: a */
    public C3947a m6399a(boolean z) {
        this.f16924M = z;
        return this;
    }

    /* renamed from: b */
    public C3947a m6398b() {
        this.f16928R.append(f16892c).append(f16891b).append(this.f16932w).append(f16890a);
        this.f16928R.append(f16906q).append(f16891b).append(this.f16915D).append(f16890a);
        this.f16928R.append(f16907r).append(f16891b).append(this.f16916E).append(f16890a);
        this.f16928R.append(f16895f).append(f16891b).append(this.f16935z).append(f16890a);
        this.f16928R.append(f16896g).append(f16891b).append(this.f16912A).append(f16890a);
        this.f16928R.append(f16908s).append(f16891b).append(this.f16917F).append(f16890a);
        this.f16928R.append(f16893d).append(f16891b).append(Build.MODEL).append(f16890a);
        this.f16928R.append(f16894e).append(f16891b).append(this.f16934y).append(f16890a);
        this.f16928R.append(f16897h).append(f16891b).append(this.f16913B).append(f16890a);
        this.f16928R.append(f16905p).append(f16891b).append(this.f16914C).append(f16890a);
        this.f16928R.append(f16910u).append(f16891b).append(this.f16918G).append(f16890a);
        this.f16928R.append(f16909t).append(f16891b).append(this.f16919H).append(f16890a);
        this.f16930T.append(f16900k).append(f16891b).append(this.f16920I).append(f16890a);
        this.f16930T.append(f16901l).append(f16891b).append(this.f16921J).append(f16890a);
        this.f16930T.append(f16902m).append(f16891b).append(this.f16922K).append(f16890a);
        this.f16930T.append(f16903n).append(f16891b).append(this.f16923L).append(f16890a);
        this.f16929S.append(f16898i).append(f16891b).append(this.f16924M).append(f16890a);
        this.f16929S.append(f16899j).append(f16891b).append(this.f16925N).append(f16890a);
        if (this.f16926O != null && !this.f16926O.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it2 = this.f16926O.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next());
                sb.append(f16890a);
            }
            this.f16931U.append(f16904o).append(f16891b).append(sb.toString()).append(f16890a);
        }
        return this;
    }

    /* renamed from: c */
    public String m6397c() {
        return this.f16928R.toString();
    }

    /* renamed from: d */
    public String m6396d() {
        return this.f16929S.toString();
    }

    /* renamed from: e */
    public String m6395e() {
        return this.f16930T.toString();
    }

    /* renamed from: f */
    public String m6394f() {
        Iterator<String> it2 = this.f16926O.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            if (Character.isLetter(next.charAt(0))) {
                String[] split = next.split(f16890a);
                for (String str : split) {
                    if (!str.startsWith("com.android") && !str.startsWith("java") && !str.startsWith("android")) {
                        return str.substring(str.indexOf(40) + 1, str.indexOf(41));
                    }
                }
                continue;
            }
        }
        return "";
    }

    public String toString() {
        return String.valueOf(this.f16928R) + ((Object) this.f16930T) + ((Object) this.f16929S) + ((Object) this.f16931U);
    }
}
