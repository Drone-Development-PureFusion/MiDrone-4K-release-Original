package p000a;

import java.util.ArrayList;
import java.util.List;
/* renamed from: a.a */
/* loaded from: classes.dex */
public class C0000a extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private Throwable[] f0a;

    public C0000a(String str, Throwable[] thArr) {
        super(str, (thArr == null || thArr.length <= 0) ? null : thArr[0]);
        this.f0a = (thArr == null || thArr.length <= 0) ? null : thArr;
    }

    @Deprecated
    public C0000a(List<Exception> list) {
        this("There were multiple errors.", (Throwable[]) list.toArray(new Exception[list.size()]));
    }

    @Deprecated
    /* renamed from: a */
    public List<Exception> m21670a() {
        Throwable[] thArr;
        ArrayList arrayList = new ArrayList();
        if (this.f0a == null) {
            return arrayList;
        }
        for (Throwable th : this.f0a) {
            if (th instanceof Exception) {
                arrayList.add((Exception) th);
            } else {
                arrayList.add(new Exception(th));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public Throwable[] m21669b() {
        return this.f0a;
    }
}
