package it.sephiroth.android.library.p240a;

import android.os.Build;
import android.util.Log;
import android.view.View;
import it.sephiroth.android.library.p240a.p242b.C4890a;
import it.sephiroth.android.library.p240a.p243c.C4891a;
/* renamed from: it.sephiroth.android.library.a.b */
/* loaded from: classes2.dex */
public class C4887b {

    /* renamed from: a */
    private static final String f20859a = "ViewHelper";

    /* renamed from: it.sephiroth.android.library.a.b$a */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC4888a {

        /* renamed from: a */
        protected View f20860a;

        protected AbstractC4888a(View view) {
            this.f20860a = view;
        }

        /* renamed from: a */
        public abstract void mo2934a(int i);

        /* renamed from: a */
        public abstract void mo2933a(Runnable runnable);

        /* renamed from: a */
        public abstract boolean mo2935a();
    }

    /* renamed from: it.sephiroth.android.library.a.b$b */
    /* loaded from: classes2.dex */
    public static class C4889b extends AbstractC4888a {
        public C4889b(View view) {
            super(view);
        }

        @Override // it.sephiroth.android.library.p240a.C4887b.AbstractC4888a
        /* renamed from: a */
        public void mo2934a(int i) {
            Log.d(C4887b.f20859a, "setScrollX: " + i);
            this.f20860a.scrollTo(i, this.f20860a.getScrollY());
        }

        @Override // it.sephiroth.android.library.p240a.C4887b.AbstractC4888a
        /* renamed from: a */
        public void mo2933a(Runnable runnable) {
            this.f20860a.post(runnable);
        }

        @Override // it.sephiroth.android.library.p240a.C4887b.AbstractC4888a
        /* renamed from: a */
        public boolean mo2935a() {
            return false;
        }
    }

    /* renamed from: a */
    public static final AbstractC4888a m2936a(View view) {
        int i = Build.VERSION.SDK_INT;
        return i >= 16 ? new C4891a(view) : i >= 14 ? new C4890a(view) : new C4889b(view);
    }
}
