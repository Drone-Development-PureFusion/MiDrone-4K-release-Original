package com.fimi.kernel.p156a;
/* renamed from: com.fimi.kernel.a.g */
/* loaded from: classes.dex */
public class C2179g {

    /* renamed from: a */
    public String f7320a;

    /* renamed from: b */
    public String f7321b;

    /* renamed from: c */
    public String f7322c;

    /* renamed from: d */
    public String f7323d;

    /* renamed from: e */
    public int f7324e;

    /* renamed from: f */
    public String f7325f;

    public C2179g(String str) {
        if (str == null) {
            return;
        }
        String[] split = str.split("[\\s]+");
        if (split.length != 9) {
            return;
        }
        this.f7323d = split[0];
        this.f7320a = split[1];
        this.f7322c = split[2];
        this.f7324e = Integer.parseInt(split[4]);
        this.f7321b = split[8];
        if (!m13334a()) {
            return;
        }
        this.f7325f = this.f7320a;
    }

    /* renamed from: a */
    public boolean m13334a() {
        return "zygote".equals(this.f7321b);
    }

    /* renamed from: b */
    public boolean m13333b() {
        return this.f7322c.equals(this.f7325f) && this.f7323d.startsWith("app_");
    }

    public String toString() {
        return "PsRow ( " + super.toString() + ";pid = " + this.f7320a + ";cmd = " + this.f7321b + ";ppid = " + this.f7322c + ";user = " + this.f7323d + ";mem = " + this.f7324e + " )";
    }
}
