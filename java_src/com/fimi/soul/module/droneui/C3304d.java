package com.fimi.soul.module.droneui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import com.fimi.soul.C2300R;
/* renamed from: com.fimi.soul.module.droneui.d */
/* loaded from: classes.dex */
public class C3304d {
    /* renamed from: a */
    public static ProgressDialog m8784a(Context context, int i) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.onWindowFocusChanged(false);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(1);
        progressDialog.setTitle(context.getResources().getString(C2300R.C2303string.updatetitle));
        progressDialog.setMax(i);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        if (!((Activity) context).isFinishing()) {
            progressDialog.show();
        }
        return progressDialog;
    }

    /* renamed from: a */
    public static ProgressDialog m8783a(Context context, int i, int i2) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.onWindowFocusChanged(false);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(1);
        progressDialog.setTitle(context.getResources().getString(C2300R.C2303string.updatetitle));
        progressDialog.setMax(i2);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        if (!((Activity) context).isFinishing()) {
            progressDialog.show();
        }
        return progressDialog;
    }
}
