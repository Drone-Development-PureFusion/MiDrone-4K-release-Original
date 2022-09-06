package com.fimi.soul.module.login;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.fimi.soul.C2300R;
/* renamed from: com.fimi.soul.module.login.e */
/* loaded from: classes.dex */
public class DialogC3387e extends Dialog {

    /* renamed from: a */
    private TextView f13204a;

    /* renamed from: c */
    private boolean f13206c;

    /* renamed from: b */
    private int f13205b = 0;

    /* renamed from: d */
    private Handler f13207d = new Handler() { // from class: com.fimi.soul.module.login.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                if (DialogC3387e.this.f13205b == 0) {
                    DialogC3387e.this.f13205b = 1;
                    DialogC3387e.this.f13204a.setText(C2300R.C2303string.network_loading1);
                } else if (DialogC3387e.this.f13205b == 1) {
                    DialogC3387e.this.f13205b = 2;
                    DialogC3387e.this.f13204a.setText(C2300R.C2303string.network_loading2);
                } else {
                    DialogC3387e.this.f13205b = 0;
                    DialogC3387e.this.f13204a.setText(C2300R.C2303string.network_loading3);
                }
                DialogC3387e.this.f13207d.sendEmptyMessageDelayed(0, 500L);
            }
        }
    };

    public DialogC3387e(Context context, int i, boolean z) {
        super(context, i);
        this.f13206c = z;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.f13206c) {
            this.f13207d.removeMessages(0);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.fimisdk_dialog_network_loading);
        this.f13204a = (TextView) findViewById(C2300R.C2302id.tv_load);
        if (!this.f13206c) {
            this.f13204a.setVisibility(8);
            return;
        }
        this.f13204a.setVisibility(0);
        this.f13207d.sendEmptyMessage(0);
    }
}
