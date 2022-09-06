package p244m.framework.p245a;

import java.io.InputStream;
import org.apache.http.entity.InputStreamEntity;
/* renamed from: m.framework.a.c */
/* loaded from: classes2.dex */
public abstract class AbstractC4940c {
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract InputStream mo2564a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public abstract long mo2562b();

    /* renamed from: c */
    public InputStreamEntity m2580c() {
        return new InputStreamEntity(mo2564a(), mo2562b());
    }
}
