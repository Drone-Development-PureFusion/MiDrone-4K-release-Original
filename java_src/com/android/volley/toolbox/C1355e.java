package com.android.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.AbstractC1317b;
import com.android.volley.AbstractC1333n;
import com.android.volley.C1329j;
import com.android.volley.C1341p;
/* renamed from: com.android.volley.toolbox.e */
/* loaded from: classes.dex */
public class C1355e extends AbstractC1333n<Object> {

    /* renamed from: a */
    private final AbstractC1317b f4645a;

    /* renamed from: b */
    private final Runnable f4646b;

    public C1355e(AbstractC1317b abstractC1317b, Runnable runnable) {
        super(0, null, null);
        this.f4645a = abstractC1317b;
        this.f4646b = runnable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: a */
    public C1341p<Object> mo13155a(C1329j c1329j) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: b */
    public void mo13154b(Object obj) {
    }

    @Override // com.android.volley.AbstractC1333n
    /* renamed from: m */
    public boolean mo16661m() {
        this.f4645a.mo16582b();
        if (this.f4646b != null) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.f4646b);
            return true;
        }
        return true;
    }

    @Override // com.android.volley.AbstractC1333n
    /* renamed from: x */
    public AbstractC1333n.EnumC1336b mo16591x() {
        return AbstractC1333n.EnumC1336b.IMMEDIATE;
    }
}
