package com.fimi.soul.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
/* renamed from: com.fimi.soul.utils.an */
/* loaded from: classes.dex */
public class DialogC3650an extends Dialog {

    /* renamed from: a */
    Dialog f14819a;

    /* renamed from: c */
    private AbstractC3652a f14821c;

    /* renamed from: d */
    private Context f14822d;

    /* renamed from: e */
    private int f14823e;

    /* renamed from: f */
    private TextView f14824f;

    /* renamed from: g */
    private TextView f14825g;

    /* renamed from: h */
    private ImageView f14826h;

    /* renamed from: i */
    private Handler f14827i = new Handler();

    /* renamed from: b */
    Runnable f14820b = new Runnable() { // from class: com.fimi.soul.utils.an.1
        @Override // java.lang.Runnable
        public void run() {
            DialogC3650an.m7667a(DialogC3650an.this);
            if (DialogC3650an.this.f14823e >= 0) {
                DialogC3650an.this.f14827i.postDelayed(this, 1000L);
            } else if (DialogC3650an.this.f14821c == null) {
            } else {
                DialogC3650an.this.f14821c.mo7661a();
            }
        }
    };

    /* renamed from: com.fimi.soul.utils.an$a */
    /* loaded from: classes.dex */
    public interface AbstractC3652a {
        /* renamed from: a */
        void mo7661a();
    }

    public DialogC3650an(Context context, AbstractC3652a abstractC3652a, int i) {
        super(context, C2300R.style.Dialog_Fullscreen);
        this.f14822d = context;
        this.f14821c = abstractC3652a;
        this.f14823e = i;
        this.f14827i.post(this.f14820b);
    }

    /* renamed from: a */
    static /* synthetic */ int m7667a(DialogC3650an dialogC3650an) {
        int i = dialogC3650an.f14823e;
        dialogC3650an.f14823e = i - 1;
        return i;
    }

    /* renamed from: a */
    public void m7668a(int i) {
        if (this.f14826h != null) {
            this.f14826h.setImageResource(i);
        }
    }

    /* renamed from: a */
    public void m7666a(String str) {
        if (this.f14824f != null) {
            this.f14824f.setText(str);
        }
    }

    /* renamed from: b */
    public void m7664b(String str) {
        if (this.f14824f != null) {
            this.f14825g.setText(str);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        setContentView(C2300R.layout.lostcontroldialog);
        this.f14826h = (ImageView) findViewById(C2300R.C2302id.erroric);
        this.f14824f = (TextView) findViewById(C2300R.C2302id.title);
        this.f14825g = (TextView) findViewById(C2300R.C2302id.desmessage);
        this.f14824f.getPaint().setFakeBoldText(true);
        C3658ar.m7612a(this.f14822d.getAssets(), this.f14824f, this.f14825g);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && this.f14821c != null) {
            this.f14821c.mo7661a();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
