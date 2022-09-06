package it.p235a.p236a;
/* renamed from: it.a.a.s */
/* loaded from: classes.dex */
public class C4877s {

    /* renamed from: a */
    private int f20846a;

    /* renamed from: b */
    private String[] f20847b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4877s(int i, String[] strArr) {
        this.f20846a = 0;
        this.f20846a = i;
        this.f20847b = strArr;
    }

    /* renamed from: a */
    public int m2982a() {
        return this.f20846a;
    }

    /* renamed from: b */
    public boolean m2981b() {
        int i = this.f20846a - 200;
        return i >= 0 && i < 100;
    }

    /* renamed from: c */
    public String[] m2980c() {
        return this.f20847b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(" [code=");
        stringBuffer.append(this.f20846a);
        stringBuffer.append(", message=");
        for (int i = 0; i < this.f20847b.length; i++) {
            if (i > 0) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(this.f20847b[i]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
