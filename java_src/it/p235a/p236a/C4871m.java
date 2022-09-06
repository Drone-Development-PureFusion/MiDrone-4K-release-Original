package it.p235a.p236a;
/* renamed from: it.a.a.m */
/* loaded from: classes.dex */
public class C4871m extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private int f20832a;

    /* renamed from: b */
    private String f20833b;

    public C4871m(int i) {
        this.f20832a = i;
    }

    public C4871m(int i, String str) {
        this.f20832a = i;
        this.f20833b = str;
    }

    public C4871m(C4877s c4877s) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] m2980c = c4877s.m2980c();
        for (int i = 0; i < m2980c.length; i++) {
            if (i > 0) {
                stringBuffer.append(System.getProperty("line.separator"));
            }
            stringBuffer.append(m2980c[i]);
        }
        this.f20832a = c4877s.m2982a();
        this.f20833b = stringBuffer.toString();
    }

    /* renamed from: a */
    public int m2994a() {
        return this.f20832a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f20833b;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return new StringBuffer().append(getClass().getName()).append(" [code=").append(this.f20832a).append(", message= ").append(this.f20833b).append("]").toString();
    }
}
