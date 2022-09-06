package com.mining.app.zxing.p222b;

import android.app.Activity;
import android.content.DialogInterface;
/* renamed from: com.mining.app.zxing.b.e */
/* loaded from: classes.dex */
public final class DialogInterface$OnCancelListenerC4114e implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, Runnable {

    /* renamed from: a */
    private final Activity f17205a;

    public DialogInterface$OnCancelListenerC4114e(Activity activity) {
        this.f17205a = activity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17205a.finish();
    }
}
