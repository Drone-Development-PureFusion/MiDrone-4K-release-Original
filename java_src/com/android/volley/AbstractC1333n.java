package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.AbstractC1317b;
import com.android.volley.C1341p;
import com.android.volley.C1385v;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
/* renamed from: com.android.volley.n */
/* loaded from: classes.dex */
public abstract class AbstractC1333n<T> implements Comparable<AbstractC1333n<T>> {

    /* renamed from: a */
    private static final String f4570a = "UTF-8";

    /* renamed from: q */
    private static long f4571q;

    /* renamed from: b */
    private final C1385v.C1386a f4572b;

    /* renamed from: c */
    private final int f4573c;

    /* renamed from: d */
    private final String f4574d;

    /* renamed from: e */
    private String f4575e;

    /* renamed from: f */
    private String f4576f;

    /* renamed from: g */
    private final int f4577g;

    /* renamed from: h */
    private C1341p.AbstractC1342a f4578h;

    /* renamed from: i */
    private Integer f4579i;

    /* renamed from: j */
    private C1337o f4580j;

    /* renamed from: k */
    private boolean f4581k;

    /* renamed from: l */
    private boolean f4582l;

    /* renamed from: m */
    private boolean f4583m;

    /* renamed from: n */
    private AbstractC1345r f4584n;

    /* renamed from: o */
    private AbstractC1317b.C1318a f4585o;

    /* renamed from: p */
    private Object f4586p;

    /* renamed from: com.android.volley.n$a */
    /* loaded from: classes.dex */
    public interface AbstractC1335a {

        /* renamed from: a */
        public static final int f4590a = -1;

        /* renamed from: b */
        public static final int f4591b = 0;

        /* renamed from: c */
        public static final int f4592c = 1;

        /* renamed from: d */
        public static final int f4593d = 2;

        /* renamed from: e */
        public static final int f4594e = 3;

        /* renamed from: f */
        public static final int f4595f = 4;

        /* renamed from: g */
        public static final int f4596g = 5;

        /* renamed from: h */
        public static final int f4597h = 6;

        /* renamed from: i */
        public static final int f4598i = 7;
    }

    /* renamed from: com.android.volley.n$b */
    /* loaded from: classes.dex */
    public enum EnumC1336b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public AbstractC1333n(int i, String str, C1341p.AbstractC1342a abstractC1342a) {
        this.f4572b = C1385v.C1386a.f4719a ? new C1385v.C1386a() : null;
        this.f4581k = true;
        this.f4582l = false;
        this.f4583m = false;
        this.f4585o = null;
        this.f4573c = i;
        this.f4574d = str;
        this.f4576f = m16733a(i, str);
        this.f4578h = abstractC1342a;
        m16729a((AbstractC1345r) new C1321d());
        this.f4577g = m16716d(str);
    }

    @Deprecated
    public AbstractC1333n(String str, C1341p.AbstractC1342a abstractC1342a) {
        this(-1, str, abstractC1342a);
    }

    /* renamed from: a */
    private static String m16733a(int i, String str) {
        StringBuilder append = new StringBuilder().append("Request:").append(i).append(":").append(str).append(":").append(System.currentTimeMillis()).append(":");
        long j = f4571q;
        f4571q = 1 + j;
        return C1325f.m16742a(append.append(j).toString());
    }

    /* renamed from: a */
    private byte[] m16725a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append(SignatureVisitor.INSTANCEOF);
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    /* renamed from: d */
    private static int m16716d(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    /* renamed from: A */
    public void m16737A() {
        this.f4583m = true;
    }

    /* renamed from: B */
    public boolean m16736B() {
        return this.f4583m;
    }

    /* renamed from: a */
    public int m16735a() {
        return this.f4573c;
    }

    /* renamed from: a */
    public int m16731a(AbstractC1333n<T> abstractC1333n) {
        EnumC1336b mo16591x = mo16591x();
        EnumC1336b mo16591x2 = abstractC1333n.mo16591x();
        return mo16591x == mo16591x2 ? this.f4579i.intValue() - abstractC1333n.f4579i.intValue() : mo16591x2.ordinal() - mo16591x.ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final AbstractC1333n<?> m16734a(int i) {
        this.f4579i = Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public AbstractC1333n<?> m16732a(AbstractC1317b.C1318a c1318a) {
        this.f4585o = c1318a;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public AbstractC1333n<?> m16730a(C1337o c1337o) {
        this.f4580j = c1337o;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public AbstractC1333n<?> m16729a(AbstractC1345r abstractC1345r) {
        this.f4584n = abstractC1345r;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public AbstractC1333n<?> m16727a(Object obj) {
        this.f4586p = obj;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final AbstractC1333n<?> m16724a(boolean z) {
        this.f4581k = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C1341p<T> mo13155a(C1329j c1329j);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public C1384u m16728a(C1384u c1384u) {
        return c1384u;
    }

    /* renamed from: a */
    public void m16726a(String str) {
        if (C1385v.C1386a.f4719a) {
            this.f4572b.m16558a(str, Thread.currentThread().getId());
        }
    }

    /* renamed from: b */
    public Object m16723b() {
        return this.f4586p;
    }

    /* renamed from: b */
    public void m16721b(C1384u c1384u) {
        if (this.f4578h != null) {
            this.f4578h.mo7531a(c1384u);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo13154b(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m16720b(final String str) {
        if (this.f4580j != null) {
            this.f4580j.m16695b(this);
            mo16575e();
        }
        if (C1385v.C1386a.f4719a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.android.volley.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC1333n.this.f4572b.m16558a(str, id);
                        AbstractC1333n.this.f4572b.m16559a(toString());
                    }
                });
                return;
            }
            this.f4572b.m16558a(str, id);
            this.f4572b.m16559a(toString());
        }
    }

    /* renamed from: c */
    public C1341p.AbstractC1342a m16719c() {
        return this.f4578h;
    }

    /* renamed from: c */
    public void m16718c(String str) {
        this.f4575e = str;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        return m16731a((AbstractC1333n) ((AbstractC1333n) obj));
    }

    /* renamed from: d */
    public int m16717d() {
        return this.f4577g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public void mo16575e() {
        this.f4578h = null;
    }

    /* renamed from: f */
    public final int m16715f() {
        if (this.f4579i == null) {
            throw new IllegalStateException("getSequence called before setSequence");
        }
        return this.f4579i.intValue();
    }

    /* renamed from: g */
    public String m16714g() {
        return this.f4575e != null ? this.f4575e : this.f4574d;
    }

    /* renamed from: h */
    public String m16713h() {
        return this.f4574d;
    }

    /* renamed from: i */
    public String m16712i() {
        return this.f4576f;
    }

    /* renamed from: j */
    public String m16711j() {
        return this.f4573c + ":" + this.f4574d;
    }

    /* renamed from: k */
    public AbstractC1317b.C1318a m16710k() {
        return this.f4585o;
    }

    /* renamed from: l */
    public void m16709l() {
        this.f4582l = true;
    }

    /* renamed from: m */
    public boolean mo16661m() {
        return this.f4582l;
    }

    /* renamed from: n */
    public Map<String, String> m16708n() {
        return Collections.emptyMap();
    }

    @Deprecated
    /* renamed from: o */
    protected Map<String, String> m16707o() {
        return mo13139s();
    }

    @Deprecated
    /* renamed from: p */
    protected String m16706p() {
        return m16705t();
    }

    @Deprecated
    /* renamed from: q */
    public String mo16590q() {
        return mo16588u();
    }

    @Deprecated
    /* renamed from: r */
    public byte[] mo16589r() {
        Map<String, String> m16707o = m16707o();
        if (m16707o == null || m16707o.size() <= 0) {
            return null;
        }
        return m16725a(m16707o, m16706p());
    }

    /* renamed from: s */
    protected Map<String, String> mo13139s() {
        return null;
    }

    /* renamed from: t */
    protected String m16705t() {
        return "UTF-8";
    }

    public String toString() {
        return (this.f4582l ? "[X] " : "[ ] ") + m16714g() + " " + ("0x" + Integer.toHexString(m16717d())) + " " + mo16591x() + " " + this.f4579i;
    }

    /* renamed from: u */
    public String mo16588u() {
        return "application/x-www-form-urlencoded; charset=" + m16705t();
    }

    /* renamed from: v */
    public byte[] mo16587v() {
        Map<String, String> mo13139s = mo13139s();
        if (mo13139s == null || mo13139s.size() <= 0) {
            return null;
        }
        return m16725a(mo13139s, m16705t());
    }

    /* renamed from: w */
    public final boolean m16704w() {
        return this.f4581k;
    }

    /* renamed from: x */
    public EnumC1336b mo16591x() {
        return EnumC1336b.NORMAL;
    }

    /* renamed from: y */
    public final int m16703y() {
        return this.f4584n.mo16683a();
    }

    /* renamed from: z */
    public AbstractC1345r m16702z() {
        return this.f4584n;
    }
}
