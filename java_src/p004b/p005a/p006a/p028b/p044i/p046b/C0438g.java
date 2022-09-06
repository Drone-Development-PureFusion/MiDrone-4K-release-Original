package p004b.p005a.p006a.p028b.p044i.p046b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* renamed from: b.a.a.b.i.b.g */
/* loaded from: classes.dex */
public class C0438g extends C0434c {

    /* renamed from: i */
    List<String> f961i;

    /* JADX INFO: Access modifiers changed from: protected */
    public C0438g(int i, Object obj) {
        super(i, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0438g(Object obj) {
        super(1, obj);
    }

    /* renamed from: a */
    public void m20512a(List<String> list) {
        this.f961i = list;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.p046b.C0434c, p004b.p005a.p006a.p028b.p044i.p046b.C0435d
    public boolean equals(Object obj) {
        if (super.equals(obj) && (obj instanceof C0438g)) {
            C0438g c0438g = (C0438g) obj;
            return this.f961i != null ? this.f961i.equals(c0438g.f961i) : c0438g.f961i == null;
        }
        return false;
    }

    /* renamed from: g */
    public List<String> m20511g() {
        return this.f961i;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.p046b.C0434c, p004b.p005a.p006a.p028b.p044i.p046b.C0435d
    public int hashCode() {
        return super.hashCode();
    }

    @Override // p004b.p005a.p006a.p028b.p044i.p046b.C0435d
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f961i == null) {
            stringBuffer.append("KeyWord(" + this.f945g + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f940b + ")");
        } else {
            stringBuffer.append("KeyWord(" + this.f945g + ", " + this.f940b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f961i + ")");
        }
        stringBuffer.append(f());
        return stringBuffer.toString();
    }
}
