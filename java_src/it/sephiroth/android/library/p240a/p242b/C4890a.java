package it.sephiroth.android.library.p240a.p242b;

import android.annotation.TargetApi;
import android.view.View;
import it.sephiroth.android.library.p240a.C4887b;
/* renamed from: it.sephiroth.android.library.a.b.a */
/* loaded from: classes2.dex */
public class C4890a extends C4887b.C4889b {
    public C4890a(View view) {
        super(view);
    }

    @Override // it.sephiroth.android.library.p240a.C4887b.C4889b, it.sephiroth.android.library.p240a.C4887b.AbstractC4888a
    @TargetApi(14)
    public void a(int i) {
        this.f20860a.setScrollX(i);
    }

    @Override // it.sephiroth.android.library.p240a.C4887b.C4889b, it.sephiroth.android.library.p240a.C4887b.AbstractC4888a
    @TargetApi(11)
    public boolean a() {
        return this.f20860a.isHardwareAccelerated();
    }
}
