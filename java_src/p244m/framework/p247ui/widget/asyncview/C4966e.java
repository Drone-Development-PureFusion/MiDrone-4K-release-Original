package p244m.framework.p247ui.widget.asyncview;

import android.graphics.Bitmap;
/* renamed from: m.framework.ui.widget.asyncview.e */
/* loaded from: classes2.dex */
public class C4966e implements AbstractC4965d {

    /* renamed from: a */
    public static final C4966e f21330a = new C4966e();

    private C4966e() {
    }

    @Override // p244m.framework.p247ui.widget.asyncview.AbstractC4965d
    /* renamed from: a */
    public Bitmap mo2441a(AbstractC4956a abstractC4956a, Bitmap bitmap, String str) {
        if (str == null || str.trim().length() <= 0 || !str.equals(abstractC4956a.getUrl())) {
            return null;
        }
        return bitmap;
    }
}
