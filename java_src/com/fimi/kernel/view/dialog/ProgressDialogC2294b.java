package com.fimi.kernel.view.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.fimi.kernel.C2168R;
/* renamed from: com.fimi.kernel.view.dialog.b */
/* loaded from: classes.dex */
public class ProgressDialogC2294b extends ProgressDialog {

    /* renamed from: a */
    private String f7649a;

    public ProgressDialogC2294b(Context context) {
        super(context);
    }

    public ProgressDialogC2294b(Context context, int i) {
        super(context, i);
    }

    /* renamed from: a */
    public void m12653a(String str) {
        this.f7649a = str;
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2168R.layout.dialog_easyprogress);
        TextView textView = (TextView) findViewById(C2168R.C2170id.pb_easyMessage);
        if (this.f7649a != null) {
            textView.setText(this.f7649a);
        }
    }
}
