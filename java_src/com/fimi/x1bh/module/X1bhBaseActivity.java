package com.fimi.x1bh.module;

import android.os.Bundle;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p147d.AbstractC2118a;
import com.fimi.p147d.AbstractC2119b;
import com.fimi.p151f.C2139b;
import com.fimi.p151f.C2145d;
import com.fimi.soul.base.BaseActivity;
/* loaded from: classes.dex */
public class X1bhBaseActivity extends BaseActivity implements AbstractC2118a, AbstractC2119b {
    @Override // com.fimi.p147d.AbstractC2119b
    /* renamed from: a */
    public void mo6481a(int i, C2104c c2104c) {
    }

    @Override // com.fimi.p147d.AbstractC2118a
    /* renamed from: a */
    public void mo6477a(String str) {
    }

    /* renamed from: a */
    public void m6631a(byte[] bArr) {
        C2145d.m13447b().m13448a(bArr, bArr.length);
    }

    @Override // com.fimi.p147d.AbstractC2118a
    /* renamed from: b */
    public void mo6446b(String str) {
    }

    @Override // com.fimi.p147d.AbstractC2118a
    /* renamed from: c */
    public void mo6556c(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2139b.m13466b().m13468a(this);
        C2145d.m13447b().m13451a(this);
        C2145d.m13447b().m13444d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C2139b.m13466b().m13465b(this);
        C2145d.m13447b().m13446b(this);
    }
}
