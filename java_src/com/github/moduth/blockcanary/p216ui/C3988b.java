package com.github.moduth.blockcanary.p216ui;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
/* renamed from: com.github.moduth.blockcanary.ui.b */
/* loaded from: classes.dex */
final class C3988b {

    /* renamed from: a */
    static final int f17052a = -4539718;

    /* renamed from: b */
    static final int f17053b = -8083771;

    /* renamed from: c */
    static final int f17054c = -5155506;

    /* renamed from: d */
    static final PorterDuffXfermode f17055d = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    private C3988b() {
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static float m6312a(float f, Resources resources) {
        return resources.getDisplayMetrics().density * f;
    }
}
