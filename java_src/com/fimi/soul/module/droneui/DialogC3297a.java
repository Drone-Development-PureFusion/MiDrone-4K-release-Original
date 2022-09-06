package com.fimi.soul.module.droneui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.module.droneui.a */
/* loaded from: classes.dex */
public class DialogC3297a extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    Runnable f12806a = new Runnable() { // from class: com.fimi.soul.module.droneui.a.1
        @Override // java.lang.Runnable
        public void run() {
            DialogC3297a.m8794a(DialogC3297a.this);
            if (DialogC3297a.this.f12814i >= 0 || DialogC3297a.this.f12813h == null) {
                DialogC3297a.this.f12807b.postDelayed(DialogC3297a.this.f12806a, 1000L);
            } else {
                DialogC3297a.this.f12813h.mo8077d();
            }
        }
    };

    /* renamed from: b */
    final Handler f12807b = new Handler() { // from class: com.fimi.soul.module.droneui.a.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    };

    /* renamed from: c */
    private String f12808c;

    /* renamed from: d */
    private String f12809d;

    /* renamed from: e */
    private int f12810e;

    /* renamed from: f */
    private boolean f12811f;

    /* renamed from: g */
    private Context f12812g;

    /* renamed from: h */
    private AbstractC3300a f12813h;

    /* renamed from: i */
    private int f12814i;

    /* renamed from: com.fimi.soul.module.droneui.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC3300a {
        /* renamed from: a */
        void mo8080a();

        /* renamed from: b */
        void mo8079b();

        /* renamed from: c */
        void mo8078c();

        /* renamed from: d */
        void mo8077d();
    }

    public DialogC3297a(Context context, String str, String str2, int i, int i2, boolean z, AbstractC3300a abstractC3300a) {
        super(context, C2300R.style.Dialog_Fullscreen);
        this.f12808c = null;
        this.f12809d = null;
        this.f12810e = 0;
        this.f12811f = false;
        this.f12814i = 0;
        this.f12812g = context;
        this.f12808c = str;
        this.f12809d = str2;
        this.f12810e = i;
        this.f12811f = z;
        this.f12813h = abstractC3300a;
        this.f12814i = i2;
        this.f12807b.postDelayed(this.f12806a, 1000L);
    }

    /* renamed from: a */
    static /* synthetic */ int m8794a(DialogC3297a dialogC3297a) {
        int i = dialogC3297a.f12814i;
        dialogC3297a.f12814i = i - 1;
        return i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.command_one /* 2131492981 */:
                if (this.f12813h == null) {
                    return;
                }
                this.f12813h.mo8079b();
                return;
            case C2300R.C2302id.command_two /* 2131492982 */:
                if (this.f12813h == null) {
                    return;
                }
                this.f12813h.mo8078c();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_fault);
        TextView textView = (TextView) findViewById(C2300R.C2302id.fault_title);
        TextView textView2 = (TextView) findViewById(C2300R.C2302id.fault_describe);
        ImageView imageView = (ImageView) findViewById(C2300R.C2302id.error_icon);
        C3658ar.m7612a(this.f12812g.getAssets(), textView);
        C3658ar.m7612a(this.f12812g.getAssets(), textView2);
        textView.setText(this.f12808c);
        textView2.setText(this.f12809d);
        if (this.f12810e != 0) {
            imageView.setImageBitmap(BitmapFactory.decodeResource(this.f12812g.getResources(), this.f12810e));
        }
        findViewById(C2300R.C2302id.command_one).setVisibility(this.f12811f ? 0 : 8);
        View findViewById = findViewById(C2300R.C2302id.command_two);
        if (!this.f12811f) {
            i = 8;
        }
        findViewById.setVisibility(i);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f12813h != null) {
            this.f12813h.mo8080a();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
