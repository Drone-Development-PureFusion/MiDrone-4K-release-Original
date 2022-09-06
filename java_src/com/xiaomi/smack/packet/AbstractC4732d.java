package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.smack.util.C4746d;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: com.xiaomi.smack.packet.d */
/* loaded from: classes.dex */
public abstract class AbstractC4732d {

    /* renamed from: f */
    private String f19443f;

    /* renamed from: g */
    private String f19444g;

    /* renamed from: h */
    private String f19445h;

    /* renamed from: i */
    private String f19446i;

    /* renamed from: j */
    private String f19447j;

    /* renamed from: k */
    private String f19448k;

    /* renamed from: l */
    private List<C4728a> f19449l;

    /* renamed from: m */
    private final Map<String, Object> f19450m;

    /* renamed from: n */
    private C4738h f19451n;

    /* renamed from: a */
    protected static final String f19438a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: c */
    private static String f19440c = null;

    /* renamed from: b */
    public static final DateFormat f19439b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    /* renamed from: d */
    private static String f19441d = C4746d.m3839a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: e */
    private static long f19442e = 0;

    static {
        f19439b.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public AbstractC4732d() {
        this.f19443f = f19440c;
        this.f19444g = null;
        this.f19445h = null;
        this.f19446i = null;
        this.f19447j = null;
        this.f19448k = null;
        this.f19449l = new CopyOnWriteArrayList();
        this.f19450m = new HashMap();
        this.f19451n = null;
    }

    public AbstractC4732d(Bundle bundle) {
        this.f19443f = f19440c;
        this.f19444g = null;
        this.f19445h = null;
        this.f19446i = null;
        this.f19447j = null;
        this.f19448k = null;
        this.f19449l = new CopyOnWriteArrayList();
        this.f19450m = new HashMap();
        this.f19451n = null;
        this.f19445h = bundle.getString("ext_to");
        this.f19446i = bundle.getString("ext_from");
        this.f19447j = bundle.getString("ext_chid");
        this.f19444g = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f19449l = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C4728a m3923a = C4728a.m3923a((Bundle) parcelable);
                if (m3923a != null) {
                    this.f19449l.add(m3923a);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f19451n = new C4738h(bundle2);
        }
    }

    /* renamed from: j */
    public static synchronized String m3887j() {
        String sb;
        synchronized (AbstractC4732d.class) {
            StringBuilder append = new StringBuilder().append(f19441d);
            long j = f19442e;
            f19442e = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    /* renamed from: u */
    public static String m3869u() {
        return f19438a;
    }

    /* renamed from: a */
    public void m3890a(C4728a c4728a) {
        this.f19449l.add(c4728a);
    }

    /* renamed from: a */
    public void m3889a(C4738h c4738h) {
        this.f19451n = c4738h;
    }

    /* renamed from: b */
    public Bundle mo3863b() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f19443f)) {
            bundle.putString("ext_ns", this.f19443f);
        }
        if (!TextUtils.isEmpty(this.f19446i)) {
            bundle.putString("ext_from", this.f19446i);
        }
        if (!TextUtils.isEmpty(this.f19445h)) {
            bundle.putString("ext_to", this.f19445h);
        }
        if (!TextUtils.isEmpty(this.f19444g)) {
            bundle.putString("ext_pkt_id", this.f19444g);
        }
        if (!TextUtils.isEmpty(this.f19447j)) {
            bundle.putString("ext_chid", this.f19447j);
        }
        if (this.f19451n != null) {
            bundle.putBundle("ext_ERROR", this.f19451n.m3861a());
        }
        if (this.f19449l != null) {
            Bundle[] bundleArr = new Bundle[this.f19449l.size()];
            int i = 0;
            Iterator<C4728a> it2 = this.f19449l.iterator();
            while (true) {
                int i2 = i;
                if (!it2.hasNext()) {
                    break;
                }
                Bundle m3916e = it2.next().m3916e();
                if (m3916e != null) {
                    i = i2 + 1;
                    bundleArr[i2] = m3916e;
                } else {
                    i = i2;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: b */
    public C4728a m3888b(String str, String str2) {
        for (C4728a c4728a : this.f19449l) {
            if (str2 == null || str2.equals(c4728a.m3919b())) {
                if (str.equals(c4728a.m3924a())) {
                    return c4728a;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public abstract String mo3862c();

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC4732d abstractC4732d = (AbstractC4732d) obj;
        if (this.f19451n != null) {
            if (!this.f19451n.equals(abstractC4732d.f19451n)) {
                return false;
            }
        } else if (abstractC4732d.f19451n != null) {
            return false;
        }
        if (this.f19446i != null) {
            if (!this.f19446i.equals(abstractC4732d.f19446i)) {
                return false;
            }
        } else if (abstractC4732d.f19446i != null) {
            return false;
        }
        if (!this.f19449l.equals(abstractC4732d.f19449l)) {
            return false;
        }
        if (this.f19444g != null) {
            if (!this.f19444g.equals(abstractC4732d.f19444g)) {
                return false;
            }
        } else if (abstractC4732d.f19444g != null) {
            return false;
        }
        if (this.f19447j != null) {
            if (!this.f19447j.equals(abstractC4732d.f19447j)) {
                return false;
            }
        } else if (abstractC4732d.f19447j != null) {
            return false;
        }
        if (this.f19450m != null) {
            if (!this.f19450m.equals(abstractC4732d.f19450m)) {
                return false;
            }
        } else if (abstractC4732d.f19450m != null) {
            return false;
        }
        if (this.f19445h != null) {
            if (!this.f19445h.equals(abstractC4732d.f19445h)) {
                return false;
            }
        } else if (abstractC4732d.f19445h != null) {
            return false;
        }
        if (this.f19443f == null ? abstractC4732d.f19443f != null : !this.f19443f.equals(abstractC4732d.f19443f)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.f19447j != null ? this.f19447j.hashCode() : 0) + (((this.f19446i != null ? this.f19446i.hashCode() : 0) + (((this.f19445h != null ? this.f19445h.hashCode() : 0) + (((this.f19444g != null ? this.f19444g.hashCode() : 0) + ((this.f19443f != null ? this.f19443f.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31) + this.f19449l.hashCode()) * 31) + this.f19450m.hashCode()) * 31;
        if (this.f19451n != null) {
            i = this.f19451n.hashCode();
        }
        return hashCode + i;
    }

    /* renamed from: k */
    public String m3886k() {
        if ("ID_NOT_AVAILABLE".equals(this.f19444g)) {
            return null;
        }
        if (this.f19444g == null) {
            this.f19444g = m3887j();
        }
        return this.f19444g;
    }

    /* renamed from: k */
    public void m3885k(String str) {
        this.f19444g = str;
    }

    /* renamed from: l */
    public String m3884l() {
        return this.f19447j;
    }

    /* renamed from: l */
    public void m3883l(String str) {
        this.f19447j = str;
    }

    /* renamed from: m */
    public String m3882m() {
        return this.f19445h;
    }

    /* renamed from: m */
    public void m3881m(String str) {
        this.f19445h = str;
    }

    /* renamed from: n */
    public String m3880n() {
        return this.f19446i;
    }

    /* renamed from: n */
    public void m3879n(String str) {
        this.f19446i = str;
    }

    /* renamed from: o */
    public String m3878o() {
        return this.f19448k;
    }

    /* renamed from: o */
    public void m3877o(String str) {
        this.f19448k = str;
    }

    /* renamed from: p */
    public C4728a m3875p(String str) {
        return m3888b(str, null);
    }

    /* renamed from: p */
    public C4738h m3876p() {
        return this.f19451n;
    }

    /* renamed from: q */
    public synchronized Object m3873q(String str) {
        return this.f19450m == null ? null : this.f19450m.get(str);
    }

    /* renamed from: q */
    public synchronized Collection<C4728a> m3874q() {
        return this.f19449l == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(this.f19449l));
    }

    /* renamed from: r */
    public synchronized Collection<String> m3872r() {
        return this.f19450m == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(this.f19450m.keySet()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String m3871s() {
        StringBuilder sb;
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        sb = new StringBuilder();
        for (C4728a c4728a : m3874q()) {
            sb.append(c4728a.mo3868d());
        }
        if (this.f19450m != null && !this.f19450m.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (String str : m3872r()) {
                Object m3873q = m3873q(str);
                sb.append("<property>");
                sb.append("<name>").append(C4746d.m3838a(str)).append("</name>");
                sb.append("<value type=\"");
                if (m3873q instanceof Integer) {
                    sb.append("integer\">").append(m3873q).append("</value>");
                } else if (m3873q instanceof Long) {
                    sb.append("long\">").append(m3873q).append("</value>");
                } else if (m3873q instanceof Float) {
                    sb.append("float\">").append(m3873q).append("</value>");
                } else if (m3873q instanceof Double) {
                    sb.append("double\">").append(m3873q).append("</value>");
                } else if (m3873q instanceof Boolean) {
                    sb.append("boolean\">").append(m3873q).append("</value>");
                } else if (m3873q instanceof String) {
                    sb.append("string\">");
                    sb.append(C4746d.m3838a((String) m3873q));
                    sb.append("</value>");
                } else {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        } catch (Exception e) {
                            e = e;
                            objectOutputStream2 = null;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Throwable th) {
                            th = th;
                            objectOutputStream = null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        objectOutputStream2 = null;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream = null;
                        byteArrayOutputStream = null;
                    }
                    try {
                        objectOutputStream.writeObject(m3873q);
                        sb.append("java-object\">");
                        sb.append(C4746d.m3836a(byteArrayOutputStream.toByteArray())).append("</value>");
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        objectOutputStream2 = objectOutputStream;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        try {
                            e.printStackTrace();
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception e6) {
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e7) {
                                }
                            }
                            sb.append("</property>");
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception e8) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e9) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (objectOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                }
                sb.append("</property>");
            }
            sb.append("</properties>");
        }
        return sb.toString();
    }

    /* renamed from: t */
    public String m3870t() {
        return this.f19443f;
    }
}
