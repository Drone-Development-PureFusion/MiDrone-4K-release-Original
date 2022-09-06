package com.mining.app.zxing.view;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
/* renamed from: com.mining.app.zxing.view.a */
/* loaded from: classes.dex */
public final class C4124a implements ResultPointCallback {

    /* renamed from: a */
    private final ViewfinderView f17259a;

    public C4124a(ViewfinderView viewfinderView) {
        this.f17259a = viewfinderView;
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.f17259a.m6145a(resultPoint);
    }
}
