package com.fimi.soul.biz.p182k;

import com.xiaomi.infra.galaxy.fds.android.auth.GalaxyFDSCredential;
import com.xiaomi.infra.galaxy.fds.android.util.Args;
/* renamed from: com.fimi.soul.biz.k.d */
/* loaded from: classes.dex */
public class C2510d {

    /* renamed from: a */
    public static final int f8664a = 50000;

    /* renamed from: b */
    public static final int f8665b = 3;

    /* renamed from: c */
    public static final int f8666c = 4096;

    /* renamed from: d */
    public static final int f8667d = 50000;

    /* renamed from: e */
    private static final String f8668e = "http://";

    /* renamed from: f */
    private static final String f8669f = "https://";

    /* renamed from: g */
    private static final String f8670g = "files";

    /* renamed from: h */
    private static final String f8671h = "cdn";

    /* renamed from: i */
    private static final String f8672i = ".fds.api.xiaomi.com";

    /* renamed from: j */
    private static final String f8673j = ".fds-ssl.api.xiaomi.com";

    /* renamed from: q */
    private GalaxyFDSCredential f8680q;

    /* renamed from: k */
    private int f8674k = 50000;

    /* renamed from: l */
    private int f8675l = 50000;

    /* renamed from: m */
    private int f8676m = 0;

    /* renamed from: n */
    private int f8677n = 0;

    /* renamed from: o */
    private int f8678o = 3;

    /* renamed from: p */
    private int f8679p = 4096;

    /* renamed from: r */
    private String f8681r = "";

    /* renamed from: s */
    private boolean f8682s = true;

    /* renamed from: t */
    private boolean f8683t = false;

    /* renamed from: u */
    private boolean f8684u = true;

    /* renamed from: v */
    private boolean f8685v = false;

    /* renamed from: w */
    private String f8686w = "";

    /* renamed from: a */
    public int m11881a() {
        return this.f8678o;
    }

    /* renamed from: a */
    public String m11875a(boolean z, String str) {
        return str.isEmpty() ? z ? f8671h : "files" : z ? str + "-cdn" : str + "-files";
    }

    /* renamed from: a */
    public String m11874a(boolean z, boolean z2) {
        return (!z || !z2) ? f8672i : f8673j;
    }

    /* renamed from: a */
    public void m11880a(int i) {
        Args.notNegative(i, "max retry times");
        this.f8678o = i;
    }

    /* renamed from: a */
    public void m11879a(int i, int i2) {
        this.f8676m = i;
        this.f8677n = i2;
    }

    /* renamed from: a */
    public void m11878a(GalaxyFDSCredential galaxyFDSCredential) {
        Args.notNull(galaxyFDSCredential, "credential");
        this.f8680q = galaxyFDSCredential;
    }

    @Deprecated
    /* renamed from: a */
    public void m11877a(String str) {
    }

    /* renamed from: a */
    public void m11876a(boolean z) {
        this.f8682s = z;
    }

    /* renamed from: b */
    public int m11873b() {
        return this.f8674k;
    }

    /* renamed from: b */
    public C2510d m11872b(int i) {
        m11880a(i);
        return this;
    }

    /* renamed from: b */
    public C2510d m11871b(int i, int i2) {
        m11879a(i, i2);
        return this;
    }

    /* renamed from: b */
    public C2510d m11870b(GalaxyFDSCredential galaxyFDSCredential) {
        m11878a(galaxyFDSCredential);
        return this;
    }

    @Deprecated
    /* renamed from: b */
    public C2510d m11869b(String str) {
        return this;
    }

    /* renamed from: b */
    public C2510d m11868b(boolean z) {
        m11876a(z);
        return this;
    }

    /* renamed from: c */
    public int m11867c() {
        return this.f8675l;
    }

    /* renamed from: c */
    public void m11866c(int i) {
        this.f8674k = i;
    }

    @Deprecated
    /* renamed from: c */
    public void m11865c(String str) {
    }

    /* renamed from: c */
    public void m11864c(boolean z) {
        this.f8683t = z;
    }

    /* renamed from: d */
    public C2510d m11862d(int i) {
        m11866c(i);
        return this;
    }

    @Deprecated
    /* renamed from: d */
    public C2510d m11861d(String str) {
        return this;
    }

    /* renamed from: d */
    public C2510d m11860d(boolean z) {
        m11864c(z);
        return this;
    }

    /* renamed from: d */
    public int[] m11863d() {
        return new int[]{this.f8676m, this.f8677n};
    }

    /* renamed from: e */
    public int m11859e() {
        return this.f8679p;
    }

    /* renamed from: e */
    public void m11858e(int i) {
        this.f8675l = i;
    }

    /* renamed from: e */
    public void m11857e(String str) {
        this.f8681r = str;
    }

    /* renamed from: e */
    public void m11856e(boolean z) {
        this.f8684u = z;
    }

    /* renamed from: f */
    public C2510d m11854f(int i) {
        m11858e(i);
        return this;
    }

    /* renamed from: f */
    public C2510d m11853f(String str) {
        m11857e(str);
        return this;
    }

    /* renamed from: f */
    public C2510d m11852f(boolean z) {
        m11856e(z);
        return this;
    }

    /* renamed from: f */
    public GalaxyFDSCredential m11855f() {
        return this.f8680q;
    }

    @Deprecated
    /* renamed from: g */
    public String m11851g() {
        return m11836o();
    }

    /* renamed from: g */
    public void m11850g(int i) {
        Args.positive(i, "upload part size");
        this.f8679p = i;
    }

    /* renamed from: g */
    void m11849g(String str) {
        this.f8686w = str;
    }

    /* renamed from: g */
    void m11848g(boolean z) {
        this.f8685v = z;
    }

    /* renamed from: h */
    public C2510d m11846h(int i) {
        m11850g(i);
        return this;
    }

    /* renamed from: h */
    C2510d m11845h(String str) {
        m11849g(str);
        return this;
    }

    /* renamed from: h */
    C2510d m11844h(boolean z) {
        m11848g(z);
        return this;
    }

    @Deprecated
    /* renamed from: h */
    public String m11847h() {
        return m11835p();
    }

    /* renamed from: i */
    public String m11843i() {
        return this.f8681r;
    }

    /* renamed from: i */
    String m11842i(boolean z) {
        if (this.f8685v) {
            return this.f8686w;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8682s ? f8669f : f8668e);
        sb.append(m11875a(z, this.f8681r));
        sb.append(m11874a(z, this.f8682s));
        return sb.toString();
    }

    /* renamed from: j */
    public boolean m11841j() {
        return this.f8682s;
    }

    /* renamed from: k */
    public boolean m11840k() {
        return this.f8683t;
    }

    /* renamed from: l */
    public boolean m11839l() {
        return this.f8684u;
    }

    /* renamed from: m */
    boolean m11838m() {
        return this.f8685v;
    }

    /* renamed from: n */
    String m11837n() {
        return this.f8686w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public String m11836o() {
        return m11842i(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public String m11835p() {
        return m11842i(true);
    }

    /* renamed from: q */
    String m11834q() {
        return m11842i(this.f8684u);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public String m11833r() {
        return m11842i(this.f8683t);
    }
}
