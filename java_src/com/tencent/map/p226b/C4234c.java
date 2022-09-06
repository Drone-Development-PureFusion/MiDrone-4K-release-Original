package com.tencent.map.p226b;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* renamed from: com.tencent.map.b.c */
/* loaded from: classes.dex */
public final class C4234c {

    /* renamed from: a */
    private static C4234c f17571a;

    /* renamed from: b */
    private long f17572b = 0;

    /* renamed from: c */
    private List<C4235a> f17573c = new ArrayList();

    /* renamed from: d */
    private List<C4236b> f17574d = new ArrayList();

    /* renamed from: e */
    private String f17575e;

    /* renamed from: com.tencent.map.b.c$a */
    /* loaded from: classes.dex */
    static class C4235a {

        /* renamed from: a */
        public int f17576a;

        /* renamed from: b */
        public int f17577b;

        /* renamed from: c */
        public int f17578c;

        /* renamed from: d */
        public int f17579d;

        private C4235a() {
            this.f17576a = -1;
            this.f17577b = -1;
            this.f17578c = -1;
            this.f17579d = -1;
        }

        /* synthetic */ C4235a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.map.b.c$b */
    /* loaded from: classes.dex */
    public static class C4236b {

        /* renamed from: a */
        public String f17580a;

        private C4236b() {
            this.f17580a = null;
        }

        /* synthetic */ C4236b(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public static C4234c m5804a() {
        if (f17571a == null) {
            f17571a = new C4234c();
        }
        return f17571a;
    }

    /* renamed from: a */
    private static boolean m5801a(StringBuffer stringBuffer) {
        try {
            return new JSONObject(stringBuffer.toString()).getJSONObject("location").getDouble("accuracy") < 5000.0d;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m5800a(List<ScanResult> list) {
        int i;
        if (list == null) {
            return false;
        }
        if (this.f17574d != null) {
            i = 0;
            for (int i2 = 0; i2 < this.f17574d.size(); i2++) {
                String str = this.f17574d.get(i2).f17580a;
                int i3 = 0;
                while (true) {
                    if (str != null && i3 < list.size()) {
                        if (str.equals(list.get(i3).BSSID)) {
                            i++;
                            break;
                        }
                        i3++;
                    }
                }
            }
        } else {
            i = 0;
        }
        int size = list.size();
        if (size >= 6 && i >= (size / 2) + 1) {
            return true;
        }
        if (size < 6 && i >= 2) {
            return true;
        }
        return this.f17574d.size() <= 2 && list.size() <= 2 && Math.abs(System.currentTimeMillis() - this.f17572b) <= 30000;
    }

    /* renamed from: a */
    public final void m5803a(int i, int i2, int i3, int i4, List<ScanResult> list) {
        this.f17572b = System.currentTimeMillis();
        this.f17575e = null;
        this.f17573c.clear();
        C4235a c4235a = new C4235a((byte) 0);
        c4235a.f17576a = i;
        c4235a.f17577b = i2;
        c4235a.f17578c = i3;
        c4235a.f17579d = i4;
        this.f17573c.add(c4235a);
        if (list != null) {
            this.f17574d.clear();
            for (int i5 = 0; i5 < list.size(); i5++) {
                C4236b c4236b = new C4236b((byte) 0);
                c4236b.f17580a = list.get(i5).BSSID;
                int i6 = list.get(i5).level;
                this.f17574d.add(c4236b);
            }
        }
    }

    /* renamed from: a */
    public final void m5802a(String str) {
        this.f17575e = str;
    }

    /* renamed from: b */
    public final String m5798b(int i, int i2, int i3, int i4, List<ScanResult> list) {
        if (this.f17575e == null || this.f17575e.length() < 10) {
            return null;
        }
        String str = this.f17575e;
        if (str == null || list == null) {
            str = null;
        } else {
            long abs = Math.abs(System.currentTimeMillis() - this.f17572b);
            if ((abs > 30000 && list.size() > 2) || ((abs > 45000 && list.size() <= 2) || !m5801a(new StringBuffer(str)))) {
                str = null;
            }
        }
        this.f17575e = str;
        if (this.f17575e == null) {
            return null;
        }
        if (this.f17573c != null && this.f17573c.size() > 0) {
            C4235a c4235a = this.f17573c.get(0);
            if (c4235a.f17576a != i || c4235a.f17577b != i2 || c4235a.f17578c != i3 || c4235a.f17579d != i4) {
                return null;
            }
            if ((this.f17574d == null || this.f17574d.size() == 0) && (list == null || list.size() == 0)) {
                return this.f17575e;
            }
            if (m5800a(list)) {
                return this.f17575e;
            }
        }
        if (!m5800a(list)) {
            return null;
        }
        return this.f17575e;
    }

    /* renamed from: b */
    public final void m5799b() {
        this.f17575e = null;
    }
}
