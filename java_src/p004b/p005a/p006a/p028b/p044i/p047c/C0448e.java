package p004b.p005a.p006a.p028b.p044i.p047c;
/* renamed from: b.a.a.b.i.c.e */
/* loaded from: classes.dex */
public class C0448e implements AbstractC0446c {
    @Override // p004b.p005a.p006a.p028b.p044i.p047c.AbstractC0446c
    /* renamed from: a */
    public void mo20494a(String str, StringBuffer stringBuffer, char c, int i) {
        if (str.indexOf(c) >= 0) {
            stringBuffer.append(c);
            return;
        }
        stringBuffer.append("\\");
        stringBuffer.append(c);
    }
}
