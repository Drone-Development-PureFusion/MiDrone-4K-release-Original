package com.p080b;

import android.content.Context;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.p080b.C1439au;
import com.p080b.C1457be;
import com.tencent.p227mm.sdk.platformtools.PhoneUtil;
import com.tencent.p227mm.sdk.platformtools.Util;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;
/* renamed from: com.b.az */
/* loaded from: classes.dex */
public class C1449az {

    /* renamed from: c */
    private static volatile String f5018c = null;

    /* renamed from: d */
    private static Hashtable<String, Long> f5019d = new Hashtable<>();

    /* renamed from: e */
    private static C1465bj f5020e = new C1465bj();

    /* renamed from: f */
    private static Hashtable<String, String> f5021f = new Hashtable<>();

    /* renamed from: g */
    private static TelephonyManager f5022g = null;

    /* renamed from: a */
    public static final int[] f5016a = {0, 0};

    /* renamed from: b */
    static int f5017b = 213891;

    private C1449az() {
    }

    /* renamed from: a */
    static int m16207a(int i) {
        int[] iArr = new int[32];
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            iArr[i3] = (i >> (i3 * 8)) & 255;
            iArr[i3] = ((iArr[i3] << 4) & 240) + ((iArr[i3] >> 4) & 15);
            i2 += (iArr[i3] & 255) << ((3 - i3) * 8);
        }
        return f5017b + i2;
    }

    /* renamed from: a */
    private static int m16205a(int i, C1457be c1457be, String str, int[] iArr, int i2, int i3, String str2, int i4) {
        int i5 = i4 + 1;
        if (i5 > 25) {
            return -1;
        }
        int i6 = (((((i2 + i3) / 2) - i) / 16) * 16) + i;
        int m16199a = m16199a(c1457be, str, iArr, i6, str2);
        if (i2 == i6 && i6 == i3) {
            if (m16199a != 0) {
                i2 = -1;
            }
            return i2;
        } else if (m16199a == Integer.MAX_VALUE) {
            return -1;
        } else {
            return m16199a == 0 ? i6 : m16199a < 0 ? m16205a(i, c1457be, str, iArr, i2, i6, str2, i5) : m16205a(i, c1457be, str, iArr, i6 + 16, i3, str2, i5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static int m16199a(C1457be c1457be, String str, int[] iArr, int i, String str2) {
        try {
            c1457be.m16124a(i);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Off", "cmpItem");
        }
        if (str2.equals(PhoneUtil.CELL_GSM)) {
            int i2 = iArr[0];
            int i3 = iArr[1];
            int m16121d = c1457be.m16121d();
            int m16120e = c1457be.m16120e();
            if (i2 < m16121d) {
                return -1;
            }
            if (i2 > m16121d) {
                return 1;
            }
            if (i3 < m16120e) {
                return -1;
            }
            return i3 > m16120e ? 1 : 0;
        } else if (str2.equals(PhoneUtil.CELL_CDMA)) {
            int[] iArr2 = {iArr[0], iArr[1], iArr[2]};
            int[] iArr3 = new int[3];
            for (int i4 = 0; i4 < 3; i4++) {
                iArr3[i4] = c1457be.m16121d();
                if (iArr2[i4] < iArr3[i4]) {
                    return -1;
                }
                if (iArr2[i4] > iArr3[i4]) {
                    return 1;
                }
            }
            return 0;
        } else {
            if (str2.equals("wifi")) {
                byte[] m15992b = C1477bs.m15992b(str);
                int[] iArr4 = new int[6];
                for (int i5 = 0; i5 < 6; i5++) {
                    iArr4[i5] = m15992b[i5] < 0 ? m15992b[i5] + 256 : m15992b[i5];
                }
                int[] iArr5 = new int[6];
                for (int i6 = 0; i6 < 6; i6++) {
                    iArr5[i6] = c1457be.m16119f();
                    if (iArr4[i6] < iArr5[i6]) {
                        return -1;
                    }
                    if (iArr4[i6] > iArr5[i6]) {
                        return 1;
                    }
                }
                return 0;
            }
            return Integer.MAX_VALUE;
        }
    }

    /* renamed from: a */
    private static int m16198a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("cgi")) {
            return 9;
        }
        String[] split = str.split("#");
        if (split.length == 7) {
            return 1;
        }
        return split.length == 8 ? 2 : 9;
    }

    /* renamed from: a */
    private static AmapLoc m16192a(Hashtable<String, String> hashtable, Hashtable<String, String> hashtable2, int i, int i2) {
        ArrayList<C1439au.C1442c> arrayList;
        AmapLoc amapLoc;
        C1439au c1439au = new C1439au();
        try {
            if (!hashtable.isEmpty()) {
                for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                    String value = entry.getValue();
                    boolean z = value.contains("access");
                    if (value.contains("|")) {
                        c1439au.m16234a(z ? 1 : 2, value.substring(0, value.lastIndexOf("|")));
                    }
                }
            }
            if (!hashtable2.isEmpty()) {
                for (Map.Entry<String, String> entry2 : hashtable2.entrySet()) {
                    String value2 = entry2.getValue();
                    if (value2.contains("|")) {
                        c1439au.m16234a(0, value2.substring(0, value2.lastIndexOf("|")));
                    }
                }
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Off", "calLoc part3");
        }
        try {
            arrayList = c1439au.m16235a(i2, i);
        } catch (Throwable th2) {
            C1514cx.m15728a(th2, "Off", "calLoc part4");
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            amapLoc = null;
        } else {
            C1439au.C1442c c1442c = arrayList.get(0);
            amapLoc = 0 == 0 ? new AmapLoc() : null;
            amapLoc.m16531c(C3947a.f16908s);
            amapLoc.m16540b(c1442c.f5001a);
            amapLoc.m16548a(c1442c.f5002b);
            amapLoc.m16547a(c1442c.f5003c);
            amapLoc.m16515k(c1442c.f5004d);
            amapLoc.m16489x("0");
            amapLoc.m16545a(C1477bs.m16020a());
            arrayList.clear();
        }
        if (C1477bs.m16006a(amapLoc)) {
            amapLoc.m16525f("file");
            return amapLoc;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AmapLoc m16191a(double[] dArr, String str, String str2, String str3, int i, Context context, int[] iArr) {
        C1457be c1457be;
        int i2;
        double[] m16206a;
        double[] m16206a2;
        C1457be c1457be2;
        if (!TextUtils.isEmpty(str2) && !str2.contains(GeocodeSearch.GPS)) {
            int m16198a = m16198a(str2);
            String m16204a = m16204a(m16198a, str2);
            Hashtable hashtable = new Hashtable();
            m16203a(m16198a, str2, str3, hashtable);
            Hashtable hashtable2 = new Hashtable();
            m16194a(str3, hashtable2);
            StringBuilder m16188c = m16188c();
            String[] m16208a = dArr == null ? m16208a(0.0d, 0.0d, str) : m16208a(dArr[0], dArr[1], str);
            int length = m16208a.length / 2;
            if (1 > i || i > 3) {
                i = 1;
            }
            C1514cx.f5420o = hashtable.size();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i5 < m16208a.length && C1514cx.f5419n) {
                if ((i5 >= length || (i4 <= 0 && !hashtable.isEmpty())) && ((i5 < length || (i3 <= 0 && !hashtable2.isEmpty())) && i5 >= length && i4 <= 0)) {
                }
                if (i == 1) {
                    if (i5 != 0) {
                    }
                    String sb = m16188c.toString();
                    if (i5 >= length) {
                        switch (m16198a) {
                            case 1:
                                iArr[0] = 0;
                                iArr[1] = 0;
                            case 2:
                                String str4 = sb + m16204a + File.separator;
                                String str5 = m16208a[i5].startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? str4 + m16208a[i5].substring(0, 4) + Constants.ACCEPT_TIME_SEPARATOR_SP : str4 + m16208a[i5].substring(0, 3) + Constants.ACCEPT_TIME_SEPARATOR_SP;
                                int indexOf = m16208a[i5].indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP) + 1;
                                if (m16208a[i5].substring(indexOf, indexOf + 1).startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                                    sb = str5 + m16208a[i5].substring(indexOf, indexOf + 4);
                                    break;
                                } else {
                                    sb = str5 + m16208a[i5].substring(indexOf, indexOf + 3);
                                    break;
                                }
                            default:
                                iArr[0] = 0;
                                iArr[1] = 0;
                                break;
                        }
                        String str6 = (sb + File.separator) + m16208a[i5];
                        if (!str6.equals(f5018c)) {
                            C1465bj c1465bj = f5020e;
                            C1457be b = c1465bj.b(str6);
                            boolean z = false;
                            File file = new File(str6);
                            if (b != null) {
                                z = true;
                                c1457be = b;
                            } else if (file.getParentFile().exists() && !file.isDirectory() && file.exists()) {
                                C1457be.C1458a c1458a = new C1457be.C1458a();
                                try {
                                    c1457be2 = new C1457be(file, c1458a);
                                } catch (FileNotFoundException e) {
                                    C1514cx.m15728a(e, "Off", "search part1");
                                } catch (Throwable th) {
                                    C1514cx.m15728a(th, "Off", "search part2");
                                    c1458a.f5067a = false;
                                    try {
                                        c1457be2 = new C1457be(file, c1458a);
                                    } catch (Throwable th2) {
                                        c1457be2 = null;
                                        C1514cx.m15728a(th2, "Off", "search part3");
                                    }
                                }
                                c1457be = c1457be2;
                            }
                            int i6 = 0;
                            if (c1457be != null) {
                                try {
                                    c1457be.m16124a(0L);
                                    long m16122c = c1457be.m16122c();
                                    if (i5 < length) {
                                        i6 = c1457be.m16121d();
                                    }
                                    try {
                                        long m16118g = c1457be.m16118g();
                                        int i7 = 8;
                                        if (i5 < length) {
                                            i7 = (i6 * 4) + 2 + 8;
                                        }
                                        if (m16122c + 7776000000L < C1477bs.m16020a()) {
                                            if (c1457be != null) {
                                                if (z) {
                                                    try {
                                                        c1465bj.c(str6);
                                                    } catch (Throwable th3) {
                                                        C1514cx.m15728a(th3, "Off", "search part6");
                                                    }
                                                } else {
                                                    c1457be.m16123b();
                                                }
                                            }
                                            file.delete();
                                            f5019d.remove(m16208a[i5]);
                                        } else if (m16118g <= 8 || (m16118g - i7) % 16 != 0) {
                                            if (c1457be != null) {
                                                try {
                                                    c1457be.m16123b();
                                                } catch (Throwable th4) {
                                                    C1514cx.m15728a(th4, "Off", "search part7");
                                                }
                                            }
                                            file.delete();
                                            f5019d.remove(m16208a[i5]);
                                        } else {
                                            boolean z2 = i5 < length && !hashtable.isEmpty() && i4 < C1514cx.f5420o;
                                            boolean z3 = i5 >= length && !hashtable2.isEmpty() && i3 < 15;
                                            if (z2) {
                                                try {
                                                    i2 = i4;
                                                    for (Map.Entry entry : hashtable.entrySet()) {
                                                        try {
                                                            if (m16206a(i7, c1457be, ((String) entry.getKey()).toString(), 0) != null) {
                                                                i2++;
                                                                hashtable.put(((String) entry.getKey()).toString(), ((m16206a[0] + "|" + m16206a[1]) + "|" + m16206a[2] + "|") + ((String) hashtable.get(((String) entry.getKey()).toString())));
                                                                if (i2 >= C1514cx.f5420o) {
                                                                }
                                                            }
                                                            i2 = i2;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            C1514cx.m15728a(th, "Off", "search part8");
                                                            i4 = i2;
                                                            if (c1457be != null) {
                                                            }
                                                            i5++;
                                                            i4 = i4;
                                                            i3 = i3;
                                                        }
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    i2 = i4;
                                                }
                                            } else {
                                                i2 = i4;
                                            }
                                            if (z3) {
                                                Iterator it2 = hashtable2.entrySet().iterator();
                                                while (it2 != null && it2.hasNext()) {
                                                    Map.Entry entry2 = (Map.Entry) it2.next();
                                                    if (m16206a(i7, c1457be, ((String) entry2.getKey()).toString(), 1) != null) {
                                                        i3++;
                                                        hashtable2.put(((String) entry2.getKey()).toString(), ((m16206a2[0] + "|" + m16206a2[1]) + "|" + m16206a2[2] + "|") + ((String) hashtable2.get(((String) entry2.getKey()).toString())));
                                                        if (i3 >= 15) {
                                                        }
                                                    }
                                                    i3 = i3;
                                                }
                                            }
                                            i4 = i2;
                                            if (c1457be != null) {
                                                if (!c1457be.m16125a()) {
                                                    try {
                                                        c1457be.m16123b();
                                                    } catch (Throwable th7) {
                                                        C1514cx.m15728a(th7, "Off", "search part9");
                                                    }
                                                } else if (!z) {
                                                    c1465bj.b(str6, c1457be);
                                                }
                                            }
                                        }
                                    } catch (Throwable th8) {
                                        C1514cx.m15728a(th8, "Off", "search part5");
                                        if (z) {
                                            c1465bj.c(str6);
                                        }
                                    }
                                } catch (Throwable th9) {
                                    C1514cx.m15728a(th9, "Off", "search part4");
                                    if (z) {
                                        c1465bj.c(str6);
                                    }
                                }
                            }
                        }
                    }
                    i5++;
                    i4 = i4;
                    i3 = i3;
                } else {
                    if (i == 2) {
                        if (i5 > 8 && i5 < 25) {
                            i5++;
                            i4 = i4;
                            i3 = i3;
                        } else if (i5 > 33) {
                        }
                    }
                    String sb2 = m16188c.toString();
                    if (i5 >= length) {
                    }
                    i5++;
                    i4 = i4;
                    i3 = i3;
                }
            }
            m16188c.delete(0, m16188c.length());
            AmapLoc m16192a = m16192a(hashtable, hashtable2, iArr[0], iArr[1]);
            if (C1477bs.m16006a(m16192a)) {
                return m16192a;
            }
            return null;
        }
        return null;
    }

    /* renamed from: a */
    private static String m16204a(int i, String str) {
        String[] split = str.split("#");
        switch (i) {
            case 1:
                return split[1] + "_" + split[2];
            case 2:
                return split[3];
            default:
                return null;
        }
    }

    /* renamed from: a */
    private static String m16197a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        StringBuilder m16188c = m16188c();
        switch (i) {
            case 1:
                m16188c.append(m16204a(m16198a(str), str)).append(File.separator);
                if (str2.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    m16188c.append(str2.substring(0, 4));
                } else {
                    m16188c.append(str2.substring(0, 3));
                }
                m16188c.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int indexOf = str2.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP) + 1;
                if (str2.substring(indexOf, indexOf + 1).startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    m16188c.append(str2.substring(indexOf, indexOf + 4));
                } else {
                    m16188c.append(str2.substring(indexOf, indexOf + 3));
                }
                m16188c.append(File.separator).append(str2);
                break;
            case 2:
                m16188c.append("wifi").append(File.separator);
                m16188c.append(str2.substring(0, 3)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int indexOf2 = str2.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP) + 1;
                m16188c.append(str2.substring(indexOf2, indexOf2 + 3));
                m16188c.append(File.separator).append(str2);
                break;
            default:
                return null;
        }
        return m16188c.toString();
    }

    /* renamed from: a */
    public static ArrayList<String> m16193a(String str, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2 = null;
        if (f5021f.isEmpty()) {
            return null;
        }
        int m16198a = m16198a(str);
        String[] split = str.split("#");
        switch (m16198a) {
            case 1:
            case 2:
                for (String str2 : f5021f.keySet()) {
                    if (f5021f.get(str2).contains(Constants.ACCEPT_TIME_SEPARATOR_SP + split[3] + Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        arrayList = arrayList2 == null ? new ArrayList<>() : arrayList2;
                        arrayList.add(str2);
                        if (z) {
                            return arrayList;
                        }
                    } else {
                        arrayList = arrayList2;
                    }
                    arrayList2 = arrayList;
                }
                return arrayList2;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static void m16209a() {
        f5020e.a();
        f5019d.clear();
        f5021f.clear();
        f5016a[0] = 0;
        f5016a[1] = 0;
    }

    /* renamed from: a */
    private static void m16203a(int i, String str, String str2, Hashtable<String, String> hashtable) {
        String[] split = str.split("#");
        switch (i) {
            case 1:
                hashtable.put(split[3] + "|" + split[4], "access");
                if (TextUtils.isEmpty(str2) || 0 < str2.split("#").length) {
                }
                return;
            case 2:
                hashtable.put(split[3] + "|" + split[4] + "|" + split[5], "access");
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private static void m16194a(String str, Hashtable<String, String> hashtable) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArr = new String[2];
        for (String str2 : str.split("#")) {
            if (str2.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                hashtable.put(split2[0], split2[1]);
            }
        }
    }

    /* renamed from: a */
    private static boolean m16202a(Context context, String str, int i, boolean z, boolean z2) {
        boolean z3 = z ? i < 25 : i == 1;
        if (str.contains("cgi") || !z3) {
            if ((!str.contains("wifi") && !z3) || f5016a[1] > 2000) {
                return false;
            }
            NetworkInfo m15988c = C1477bs.m15988c(context);
            if (C1467bl.m16068a(m15988c) == -1) {
                return false;
            }
            if (m15988c.getType() != 1 && z2) {
                return false;
            }
            if (m15988c.getType() != 1 && !z2 && f5022g == null) {
                f5022g = (TelephonyManager) C1477bs.m16012a(context, "phone");
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m16201a(Context context, String str, String str2, int i, int i2, boolean z, boolean z2) {
        if (!m16202a(context, str, i, false, z)) {
            return false;
        }
        if (i2 == 0) {
            return m16200a(context, str, str2, i, z2);
        }
        int i3 = i2 == 1 ? 8 : 24;
        String[] m16208a = m16208a(0.0d, 0.0d, str2);
        for (int i4 = 1; i4 < i3; i4++) {
            m16200a(context, str, m16208a[i4], i, z2);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x023f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x021f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0289 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0284 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x027f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x026e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0269 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0264 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0249 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0244 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean m16200a(Context context, String str, String str2, int i, boolean z) {
        InputStream inputStream;
        GZIPInputStream gZIPInputStream;
        boolean z2;
        Throwable th;
        UnknownHostException e;
        SocketTimeoutException e2;
        SocketException e3;
        EOFException e4;
        String str3;
        String str4;
        GZIPInputStream gZIPInputStream2;
        GZIPInputStream gZIPInputStream3;
        int i2;
        boolean z3;
        String[] strArr = new String[2];
        if (!m16195a(str, str2, i, strArr)) {
            return false;
        }
        if (f5019d.containsKey(strArr[1])) {
            if (C1477bs.m16020a() - f5019d.get(strArr[1]).longValue() < Util.MILLSECONDS_OF_DAY) {
                return false;
            }
            f5019d.remove(strArr[1]);
        }
        GZIPInputStream gZIPInputStream4 = null;
        GZIPInputStream gZIPInputStream5 = null;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                C1477bs.m15997b();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("v", String.valueOf(1.0f));
                httpURLConnection = C1467bl.m16071a(context).m16070a(context, "https://offline.aps.amap.com/LoadOfflineData/getData", hashMap, strArr[0].getBytes("UTF-8"));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (EOFException e5) {
            inputStream = null;
            gZIPInputStream = null;
            z2 = false;
            e4 = e5;
        } catch (SocketException e6) {
            inputStream = null;
            gZIPInputStream = null;
            z2 = false;
            e3 = e6;
        } catch (SocketTimeoutException e7) {
            inputStream = null;
            gZIPInputStream = null;
            z2 = false;
            e2 = e7;
        } catch (UnknownHostException e8) {
            z2 = false;
            e = e8;
        } catch (Throwable th3) {
            inputStream = null;
            gZIPInputStream = null;
            z2 = false;
            th = th3;
        }
        if (httpURLConnection == null) {
            if (0 != 0) {
                try {
                    gZIPInputStream5.close();
                } catch (Throwable th4) {
                    C1514cx.m15728a(th4, "Off", "c 2 part7");
                }
            }
            if (0 != 0) {
                try {
                    gZIPInputStream4.close();
                } catch (Throwable th5) {
                    C1514cx.m15728a(th5, "Off", "c 2 part8");
                }
            }
            if (httpURLConnection == null) {
                return false;
            }
            try {
                httpURLConnection.disconnect();
                return false;
            } catch (Throwable th6) {
                C1514cx.m15728a(th6, "Off", "c 2 part9");
                return false;
            }
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            Iterator<Map.Entry<String, List<String>>> it2 = httpURLConnection.getHeaderFields().entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i2 = 0;
                    break;
                }
                Map.Entry<String, List<String>> next = it2.next();
                if (XiaomiOAuthConstants.EXTRA_CODE_2.equals(next.getKey())) {
                    i2 = Integer.parseInt(next.getValue().get(0));
                    break;
                }
            }
            if (i2 == 260) {
                f5018c = strArr[1];
                boolean z4 = true;
                inputStream = httpURLConnection.getInputStream();
                try {
                    gZIPInputStream = new GZIPInputStream(inputStream);
                    try {
                        File file = new File(strArr[1]);
                        if (file.exists() && !file.delete()) {
                            z4 = false;
                        }
                        if (!z4 || !C1514cx.f5419n) {
                            z2 = false;
                        } else {
                            File parentFile = file.getParentFile();
                            if (!parentFile.exists()) {
                                parentFile.mkdirs();
                            }
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 2048);
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int read = gZIPInputStream.read(bArr, 0, 2048);
                                if (read == -1) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            z2 = true;
                            try {
                                f5019d.put(strArr[1], Long.valueOf(C1477bs.m16020a()));
                                String m16014a = C1477bs.m16014a(0L, "yyyyMMdd");
                                if (m16014a.equals(String.valueOf(f5016a[0]))) {
                                    f5016a[1] = f5016a[1] + 1;
                                } else {
                                    try {
                                        f5016a[0] = Integer.parseInt(m16014a);
                                    } catch (Throwable th7) {
                                        f5016a[0] = 0;
                                        f5016a[1] = 0;
                                        C1514cx.m15728a(th7, "Off", "c 2 part1");
                                    }
                                    f5016a[1] = 1;
                                }
                            } catch (EOFException e9) {
                                e4 = e9;
                                C1514cx.m15728a(e4, "Off", "c 2 part5");
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable th8) {
                                        C1514cx.m15728a(th8, "Off", "c 2 part7");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th9) {
                                        C1514cx.m15728a(th9, "Off", "c 2 part8");
                                    }
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th10) {
                                        th = th10;
                                        str3 = "Off";
                                        str4 = "c 2 part9";
                                        C1514cx.m15728a(th, str3, str4);
                                        if (!TextUtils.isEmpty(f5018c)) {
                                        }
                                        return z2;
                                    }
                                }
                                if (!TextUtils.isEmpty(f5018c)) {
                                }
                                return z2;
                            } catch (SocketException e10) {
                                e3 = e10;
                                C1514cx.m15728a(e3, "Off", "c 2 part3");
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable th11) {
                                        C1514cx.m15728a(th11, "Off", "c 2 part7");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th12) {
                                        C1514cx.m15728a(th12, "Off", "c 2 part8");
                                    }
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th13) {
                                        th = th13;
                                        str3 = "Off";
                                        str4 = "c 2 part9";
                                        C1514cx.m15728a(th, str3, str4);
                                        if (!TextUtils.isEmpty(f5018c)) {
                                        }
                                        return z2;
                                    }
                                }
                                if (!TextUtils.isEmpty(f5018c)) {
                                }
                                return z2;
                            } catch (SocketTimeoutException e11) {
                                e2 = e11;
                                C1514cx.m15728a(e2, "Off", "c 2 part4");
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable th14) {
                                        C1514cx.m15728a(th14, "Off", "c 2 part7");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th15) {
                                        C1514cx.m15728a(th15, "Off", "c 2 part8");
                                    }
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th16) {
                                        th = th16;
                                        str3 = "Off";
                                        str4 = "c 2 part9";
                                        C1514cx.m15728a(th, str3, str4);
                                        if (!TextUtils.isEmpty(f5018c)) {
                                        }
                                        return z2;
                                    }
                                }
                                if (!TextUtils.isEmpty(f5018c)) {
                                }
                                return z2;
                            } catch (UnknownHostException e12) {
                                e = e12;
                                gZIPInputStream5 = gZIPInputStream;
                                gZIPInputStream4 = inputStream;
                                try {
                                    C1514cx.m15728a(e, "Off", "c 2 part2");
                                    if (gZIPInputStream5 != null) {
                                        try {
                                            gZIPInputStream5.close();
                                        } catch (Throwable th17) {
                                            C1514cx.m15728a(th17, "Off", "c 2 part7");
                                        }
                                    }
                                    if (gZIPInputStream4 != null) {
                                        try {
                                            gZIPInputStream4.close();
                                        } catch (Throwable th18) {
                                            C1514cx.m15728a(th18, "Off", "c 2 part8");
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable th19) {
                                            th = th19;
                                            str3 = "Off";
                                            str4 = "c 2 part9";
                                            C1514cx.m15728a(th, str3, str4);
                                            if (!TextUtils.isEmpty(f5018c)) {
                                            }
                                            return z2;
                                        }
                                    }
                                    if (!TextUtils.isEmpty(f5018c)) {
                                    }
                                    return z2;
                                } catch (Throwable th20) {
                                    th = th20;
                                    inputStream = gZIPInputStream4;
                                    gZIPInputStream4 = gZIPInputStream5;
                                    if (gZIPInputStream4 != null) {
                                        try {
                                            gZIPInputStream4.close();
                                        } catch (Throwable th21) {
                                            C1514cx.m15728a(th21, "Off", "c 2 part7");
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th22) {
                                            C1514cx.m15728a(th22, "Off", "c 2 part8");
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable th23) {
                                            C1514cx.m15728a(th23, "Off", "c 2 part9");
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th24) {
                                th = th24;
                                C1514cx.m15728a(th, "Off", "c 2 part6");
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable th25) {
                                        C1514cx.m15728a(th25, "Off", "c 2 part7");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th26) {
                                        C1514cx.m15728a(th26, "Off", "c 2 part8");
                                    }
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Throwable th27) {
                                        th = th27;
                                        str3 = "Off";
                                        str4 = "c 2 part9";
                                        C1514cx.m15728a(th, str3, str4);
                                        if (!TextUtils.isEmpty(f5018c)) {
                                        }
                                        return z2;
                                    }
                                }
                                if (!TextUtils.isEmpty(f5018c)) {
                                }
                                return z2;
                            }
                        }
                        gZIPInputStream2 = gZIPInputStream;
                        gZIPInputStream3 = inputStream;
                        z3 = z2;
                    } catch (EOFException e13) {
                        z2 = false;
                        e4 = e13;
                    } catch (SocketException e14) {
                        z2 = false;
                        e3 = e14;
                    } catch (SocketTimeoutException e15) {
                        z2 = false;
                        e2 = e15;
                    } catch (UnknownHostException e16) {
                        gZIPInputStream5 = gZIPInputStream;
                        gZIPInputStream4 = inputStream;
                        z2 = false;
                        e = e16;
                    } catch (Throwable th28) {
                        z2 = false;
                        th = th28;
                    }
                } catch (EOFException e17) {
                    gZIPInputStream = null;
                    z2 = false;
                    e4 = e17;
                } catch (SocketException e18) {
                    gZIPInputStream = null;
                    z2 = false;
                    e3 = e18;
                } catch (SocketTimeoutException e19) {
                    gZIPInputStream = null;
                    z2 = false;
                    e2 = e19;
                } catch (UnknownHostException e20) {
                    gZIPInputStream4 = inputStream;
                    z2 = false;
                    e = e20;
                } catch (Throwable th29) {
                    th = th29;
                    gZIPInputStream4 = null;
                    if (gZIPInputStream4 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } else {
                if (C1514cx.f5419n) {
                    f5019d.put(strArr[1], Long.valueOf(C1477bs.m16020a()));
                }
                gZIPInputStream3 = null;
                z3 = false;
                gZIPInputStream2 = null;
            }
            if (z) {
                try {
                    m16189b(strArr[1]);
                } catch (EOFException e21) {
                    inputStream = gZIPInputStream3;
                    GZIPInputStream gZIPInputStream6 = gZIPInputStream2;
                    e4 = e21;
                    z2 = z3;
                    gZIPInputStream = gZIPInputStream6;
                    C1514cx.m15728a(e4, "Off", "c 2 part5");
                    if (gZIPInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (!TextUtils.isEmpty(f5018c)) {
                    }
                    return z2;
                } catch (SocketException e22) {
                    inputStream = gZIPInputStream3;
                    GZIPInputStream gZIPInputStream7 = gZIPInputStream2;
                    e3 = e22;
                    z2 = z3;
                    gZIPInputStream = gZIPInputStream7;
                    C1514cx.m15728a(e3, "Off", "c 2 part3");
                    if (gZIPInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (!TextUtils.isEmpty(f5018c)) {
                    }
                    return z2;
                } catch (SocketTimeoutException e23) {
                    inputStream = gZIPInputStream3;
                    GZIPInputStream gZIPInputStream8 = gZIPInputStream2;
                    e2 = e23;
                    z2 = z3;
                    gZIPInputStream = gZIPInputStream8;
                    C1514cx.m15728a(e2, "Off", "c 2 part4");
                    if (gZIPInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (!TextUtils.isEmpty(f5018c)) {
                    }
                    return z2;
                } catch (UnknownHostException e24) {
                    z2 = z3;
                    gZIPInputStream4 = gZIPInputStream3;
                    gZIPInputStream5 = gZIPInputStream2;
                    e = e24;
                    C1514cx.m15728a(e, "Off", "c 2 part2");
                    if (gZIPInputStream5 != null) {
                    }
                    if (gZIPInputStream4 != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (!TextUtils.isEmpty(f5018c)) {
                    }
                    return z2;
                } catch (Throwable th30) {
                    th = th30;
                    gZIPInputStream4 = gZIPInputStream2;
                    inputStream = gZIPInputStream3;
                    if (gZIPInputStream4 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            }
            z2 = z3;
        } else {
            if (responseCode == 404) {
            }
            z2 = false;
            gZIPInputStream2 = null;
            gZIPInputStream3 = null;
        }
        if (gZIPInputStream2 != null) {
            try {
                gZIPInputStream2.close();
            } catch (Throwable th31) {
                C1514cx.m15728a(th31, "Off", "c 2 part7");
            }
        }
        if (gZIPInputStream3 != null) {
            try {
                gZIPInputStream3.close();
            } catch (Throwable th32) {
                C1514cx.m15728a(th32, "Off", "c 2 part8");
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th33) {
                th = th33;
                str3 = "Off";
                str4 = "c 2 part9";
                C1514cx.m15728a(th, str3, str4);
                if (!TextUtils.isEmpty(f5018c)) {
                }
                return z2;
            }
        }
        if (!TextUtils.isEmpty(f5018c)) {
            f5018c = null;
        }
        return z2;
    }

    /* renamed from: a */
    public static boolean m16196a(String str, String str2, int i, int i2) {
        int i3 = 0;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (i2 == 0) {
            String m16197a = m16197a(str, str2, i);
            if (m16197a != null) {
                File file = new File(m16197a);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
                if (f5021f.containsKey(m16197a)) {
                    f5021f.remove(m16197a);
                }
                if (f5019d.containsKey(m16197a)) {
                    f5019d.remove(m16197a);
                }
            }
            return true;
        } else if (i2 != 1 && i2 != 2) {
            return false;
        } else {
            String[] m16208a = m16208a(0.0d, 0.0d, str2);
            int i4 = i2 == 1 ? 9 : i2 == 2 ? 25 : 0;
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                i3 = 25;
            }
            Hashtable<String, String> hashtable = f5021f;
            Hashtable<String, Long> hashtable2 = f5019d;
            while (i3 < i4) {
                String m16197a2 = m16197a(str, m16208a[i3], i);
                if (m16197a2 != null) {
                    File file2 = new File(m16197a2);
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                    if (hashtable.containsKey(m16197a2)) {
                        hashtable.remove(m16197a2);
                    }
                    if (hashtable2.containsKey(m16197a2)) {
                        hashtable2.remove(m16197a2);
                    }
                }
                i3++;
            }
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String] */
    /* renamed from: a */
    private static boolean m16195a(String str, String str2, int i, String[] strArr) {
        String str3;
        ?? isFile;
        RandomAccessFile randomAccessFile;
        String str4;
        String str5;
        long j = 0;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (strArr == null || strArr.length != 2) {
            return false;
        }
        StringBuilder m16188c = m16188c();
        switch (i) {
            case 1:
                str3 = m16204a(m16198a(str), str);
                m16188c.append(str3).append(File.separator);
                if (str2.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    m16188c.append(str2.substring(0, 4));
                } else {
                    m16188c.append(str2.substring(0, 3));
                }
                m16188c.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int indexOf = str2.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP) + 1;
                if (str2.substring(indexOf, indexOf + 1).startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    m16188c.append(str2.substring(indexOf, indexOf + 4));
                } else {
                    m16188c.append(str2.substring(indexOf, indexOf + 3));
                }
                m16188c.append(File.separator).append(str2);
                break;
            case 2:
                str3 = "wifi";
                m16188c.append(str3).append(File.separator);
                m16188c.append(str2.substring(0, 3)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int indexOf2 = str2.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP) + 1;
                m16188c.append(str2.substring(indexOf2, indexOf2 + 3));
                m16188c.append(File.separator).append(str2);
                break;
            default:
                return false;
        }
        strArr[1] = m16188c.toString();
        m16188c.delete(0, m16188c.length());
        File file = new File(strArr[1]);
        if (file.exists() && (isFile = file.isFile()) != 0) {
            RandomAccessFile randomAccessFile2 = null;
            randomAccessFile2 = null;
            randomAccessFile2 = null;
            randomAccessFile2 = null;
            try {
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, "r");
                        try {
                            randomAccessFile.seek(0L);
                            j = randomAccessFile.readLong();
                            isFile = randomAccessFile;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    isFile = randomAccessFile;
                                } catch (Throwable th) {
                                    th = th;
                                    str4 = "Off";
                                    str5 = "getRequestParams part3";
                                    C1514cx.m15728a(th, str4, str5);
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("v", String.valueOf(1.0f));
                                    jSONObject.put("geohash", str2);
                                    jSONObject.put("t", String.valueOf(j));
                                    jSONObject.put("type", str3);
                                    jSONObject.put(C3947a.f16895f, C1514cx.f5407b);
                                    jSONObject.put("imsi", C1514cx.f5408c);
                                    jSONObject.put("src", C1514cx.f5410e);
                                    jSONObject.put("license", C1514cx.f5411f);
                                    strArr[0] = jSONObject.toString();
                                    return true;
                                }
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            ?? r7 = "Off";
                            C1514cx.m15728a(e, r7, "getRequestParams part1");
                            isFile = randomAccessFile;
                            randomAccessFile2 = r7;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    isFile = randomAccessFile;
                                    randomAccessFile2 = r7;
                                } catch (Throwable th2) {
                                    th = th2;
                                    str4 = "Off";
                                    str5 = "getRequestParams part3";
                                    C1514cx.m15728a(th, str4, str5);
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("v", String.valueOf(1.0f));
                                    jSONObject2.put("geohash", str2);
                                    jSONObject2.put("t", String.valueOf(j));
                                    jSONObject2.put("type", str3);
                                    jSONObject2.put(C3947a.f16895f, C1514cx.f5407b);
                                    jSONObject2.put("imsi", C1514cx.f5408c);
                                    jSONObject2.put("src", C1514cx.f5410e);
                                    jSONObject2.put("license", C1514cx.f5411f);
                                    strArr[0] = jSONObject2.toString();
                                    return true;
                                }
                            }
                            JSONObject jSONObject22 = new JSONObject();
                            jSONObject22.put("v", String.valueOf(1.0f));
                            jSONObject22.put("geohash", str2);
                            jSONObject22.put("t", String.valueOf(j));
                            jSONObject22.put("type", str3);
                            jSONObject22.put(C3947a.f16895f, C1514cx.f5407b);
                            jSONObject22.put("imsi", C1514cx.f5408c);
                            jSONObject22.put("src", C1514cx.f5410e);
                            jSONObject22.put("license", C1514cx.f5411f);
                            strArr[0] = jSONObject22.toString();
                            return true;
                        } catch (Throwable th3) {
                            th = th3;
                            randomAccessFile2 = randomAccessFile;
                            C1514cx.m15728a(th, "Off", "getRequestParams part2");
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (Throwable th4) {
                                    th = th4;
                                    str4 = "Off";
                                    str5 = "getRequestParams part3";
                                    C1514cx.m15728a(th, str4, str5);
                                    JSONObject jSONObject222 = new JSONObject();
                                    jSONObject222.put("v", String.valueOf(1.0f));
                                    jSONObject222.put("geohash", str2);
                                    jSONObject222.put("t", String.valueOf(j));
                                    jSONObject222.put("type", str3);
                                    jSONObject222.put(C3947a.f16895f, C1514cx.f5407b);
                                    jSONObject222.put("imsi", C1514cx.f5408c);
                                    jSONObject222.put("src", C1514cx.f5410e);
                                    jSONObject222.put("license", C1514cx.f5411f);
                                    strArr[0] = jSONObject222.toString();
                                    return true;
                                }
                            }
                            JSONObject jSONObject2222 = new JSONObject();
                            jSONObject2222.put("v", String.valueOf(1.0f));
                            jSONObject2222.put("geohash", str2);
                            jSONObject2222.put("t", String.valueOf(j));
                            jSONObject2222.put("type", str3);
                            jSONObject2222.put(C3947a.f16895f, C1514cx.f5407b);
                            jSONObject2222.put("imsi", C1514cx.f5408c);
                            jSONObject2222.put("src", C1514cx.f5410e);
                            jSONObject2222.put("license", C1514cx.f5411f);
                            strArr[0] = jSONObject2222.toString();
                            return true;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        randomAccessFile2 = isFile;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable th6) {
                                C1514cx.m15728a(th6, "Off", "getRequestParams part3");
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
        JSONObject jSONObject22222 = new JSONObject();
        try {
            jSONObject22222.put("v", String.valueOf(1.0f));
            jSONObject22222.put("geohash", str2);
            jSONObject22222.put("t", String.valueOf(j));
            jSONObject22222.put("type", str3);
            jSONObject22222.put(C3947a.f16895f, C1514cx.f5407b);
            jSONObject22222.put("imsi", C1514cx.f5408c);
            jSONObject22222.put("src", C1514cx.f5410e);
            jSONObject22222.put("license", C1514cx.f5411f);
        } catch (Throwable th9) {
            C1514cx.m15728a(th9, "Off", "getRequestParams part4");
        }
        strArr[0] = jSONObject22222.toString();
        return true;
    }

    /* renamed from: a */
    private static double[] m16206a(int i, C1457be c1457be, String str, int i2) {
        String str2;
        int[] iArr;
        Throwable th;
        double[] dArr;
        int m16205a;
        if (i2 == 0) {
            String[] split = str.split("\\|");
            iArr = new int[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                iArr[i3] = Integer.parseInt(split[i3]);
            }
            str2 = split.length == 2 ? PhoneUtil.CELL_GSM : PhoneUtil.CELL_CDMA;
        } else {
            str2 = "wifi";
            iArr = null;
        }
        try {
            if (c1457be.m16118g() > i) {
                c1457be.m16124a(i);
                if (m16205a(i, c1457be, str, iArr, i, ((int) c1457be.m16118g()) - 16, str2, 0) != -1) {
                    c1457be.m16124a(m16205a + 6);
                    dArr = new double[3];
                    try {
                        dArr[0] = m16207a(c1457be.m16120e()) / 1000000.0d;
                        dArr[1] = m16207a(c1457be.m16120e()) / 1000000.0d;
                        dArr[2] = c1457be.m16121d();
                        if (!C1477bs.m16019a(dArr[1])) {
                            return null;
                        }
                        if (C1477bs.m15996b(dArr[0])) {
                            return dArr;
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        C1514cx.m15728a(th, "Off", "binS");
                        return dArr;
                    }
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            dArr = null;
        }
    }

    /* renamed from: a */
    public static String[] m16208a(double d, double d2, String str) {
        String m16213a;
        String[] strArr = new String[50];
        if (!TextUtils.isEmpty(str)) {
            m16213a = str;
        } else {
            m16213a = C1448ay.m16213a(d, d2);
            str = C1448ay.m16213a(d, d2);
        }
        strArr[0] = m16213a;
        strArr[25] = str;
        String[] m16211a = C1448ay.m16211a(m16213a);
        for (int i = 1; i < 25; i++) {
            strArr[i] = m16211a[i - 1];
        }
        String[] m16211a2 = C1448ay.m16211a(str);
        for (int i2 = 26; i2 < 50; i2++) {
            strArr[i2] = m16211a2[i2 - 26];
        }
        return strArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m16189b(String str) {
        RandomAccessFile isFile;
        RandomAccessFile randomAccessFile;
        String str2;
        String str3;
        if (!f5021f.containsKey(str) || TextUtils.isEmpty(f5021f.get(str))) {
            File file = new File(str);
            if (!file.exists() || (isFile = file.isFile()) == 0) {
                return;
            }
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, "r");
                } catch (Throwable th) {
                    th = th;
                    if (isFile != 0) {
                        try {
                            isFile.close();
                        } catch (Throwable th2) {
                            C1514cx.m15728a(th2, "Off", "loadFcFea part3");
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e) {
                e = e;
                randomAccessFile = null;
            } catch (Throwable th3) {
                th = th3;
                isFile = 0;
                if (isFile != 0) {
                }
                throw th;
            }
            try {
                randomAccessFile.seek(8L);
                int readUnsignedShort = randomAccessFile.readUnsignedShort();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < readUnsignedShort; i++) {
                    int readInt = randomAccessFile.readInt();
                    if (sb.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP + readInt) == -1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(readInt);
                    }
                    if (i == readUnsignedShort - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                f5021f.put(str, sb.toString());
                sb.delete(0, sb.length());
                if (randomAccessFile == null) {
                    return;
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable th4) {
                    th = th4;
                    str2 = "Off";
                    str3 = "loadFcFea part3";
                    C1514cx.m15728a(th, str2, str3);
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                C1514cx.m15728a(e, "Off", "loadFcFea part1");
                if (randomAccessFile == null) {
                    return;
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable th5) {
                    th = th5;
                    str2 = "Off";
                    str3 = "loadFcFea part3";
                    C1514cx.m15728a(th, str2, str3);
                }
            } catch (Throwable th6) {
                th = th6;
                C1514cx.m15728a(th, "Off", "loadFcFea part2");
                if (randomAccessFile == null) {
                    return;
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th = th7;
                    str2 = "Off";
                    str3 = "loadFcFea part3";
                    C1514cx.m15728a(th, str2, str3);
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m16190b() {
        return !f5021f.isEmpty();
    }

    /* renamed from: c */
    private static StringBuilder m16188c() {
        StringBuilder sb = new StringBuilder();
        sb.append(C1477bs.m15981e());
        sb.append("offline").append(File.separator);
        sb.append(C1477bs.m15974j()).append(File.separator).append("s").append(File.separator);
        return sb;
    }
}
