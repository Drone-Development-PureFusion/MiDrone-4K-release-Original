package com.fimi.soul.view;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.utils.C2271p;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p177f.C2441a;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.view.a */
/* loaded from: classes.dex */
public class DialogC3758a extends Dialog {

    /* renamed from: com.fimi.soul.view.a$a */
    /* loaded from: classes.dex */
    public static class C3759a {

        /* renamed from: a */
        private DialogC3758a f15710a;

        /* renamed from: b */
        private Context f15711b;

        /* renamed from: c */
        private String f15712c;

        /* renamed from: d */
        private String f15713d;

        /* renamed from: e */
        private DialogInterface.OnClickListener f15714e;

        public C3759a(Context context) {
            this.f15711b = context;
            this.f15710a = new DialogC3758a(this.f15711b, C2300R.style.DropDialog1);
        }

        /* renamed from: a */
        public C3759a m7155a(DialogInterface.OnClickListener onClickListener) {
            this.f15714e = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C3759a m7153a(String str) {
            this.f15712c = str;
            return this;
        }

        /* renamed from: a */
        public C3759a m7152a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15714e = onClickListener;
            this.f15713d = str;
            return this;
        }

        /* renamed from: a */
        public DialogC3758a m7156a() {
            View inflate = ((LayoutInflater) this.f15711b.getSystemService("layout_inflater")).inflate(C2300R.layout.horizon_single_button_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.single_btn);
            if (this.f15713d != null) {
                button.setText(this.f15713d);
            }
            if (this.f15712c != null) {
                textView.setText(this.f15712c);
            }
            if (this.f15714e != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3759a.this.f15710a.dismiss();
                        C3759a.this.f15714e.onClick(C3759a.this.f15710a, -2);
                    }
                });
            }
            C3658ar.m7612a(this.f15711b.getAssets(), textView, button);
            this.f15710a.setContentView(inflate);
            Window window = this.f15710a.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((C2271p.m12860b(this.f15711b) > ((float) C2271p.m12871a(this.f15711b)) ? C2271p.m12860b(this.f15711b) : C2271p.m12871a(this.f15711b)) * 1032.0f) / 1920.0f);
            window.setAttributes(attributes);
            this.f15710a.getWindow().getDecorView().setBackgroundColor(0);
            return this.f15710a;
        }

        /* renamed from: b */
        public C3759a m7149b(String str) {
            this.f15713d = str;
            return this;
        }

        /* renamed from: b */
        public DialogC3758a m7151b() {
            return this.f15710a;
        }
    }

    /* renamed from: com.fimi.soul.view.a$b */
    /* loaded from: classes.dex */
    public static class C3761b {

        /* renamed from: a */
        private Context f15716a;

        /* renamed from: b */
        private String f15717b;

        /* renamed from: c */
        private String f15718c;

        /* renamed from: e */
        private DialogInterface.OnClickListener f15720e;

        /* renamed from: f */
        private Button f15721f;

        /* renamed from: g */
        private Button f15722g;

        /* renamed from: h */
        private TextView f15723h;

        /* renamed from: i */
        private ImageView f15724i;

        /* renamed from: d */
        private int f15719d = 0;

        /* renamed from: j */
        private C2441a f15725j = C2441a.m12168a();

        public C3761b(Context context) {
            this.f15716a = context;
        }

        /* renamed from: a */
        public C3761b m7147a(int i) {
            this.f15719d = i;
            return this;
        }

        /* renamed from: a */
        public C3761b m7143a(String str) {
            this.f15717b = str;
            return this;
        }

        /* renamed from: a */
        public C3761b m7142a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15720e = onClickListener;
            this.f15718c = str;
            return this;
        }

        @TargetApi(16)
        /* renamed from: a */
        public DialogC3758a m7148a() {
            final DialogC3758a dialogC3758a = new DialogC3758a(this.f15716a, C2300R.style.DropDialog1);
            View inflate = ((LayoutInflater) this.f15716a.getSystemService("layout_inflater")).inflate(C2300R.layout.connect_type_dialog, (ViewGroup) null);
            this.f15723h = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            this.f15724i = (ImageView) inflate.findViewById(C2300R.C2302id.imageview);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.single_btn);
            this.f15721f = (Button) inflate.findViewById(C2300R.C2302id.usb_type);
            this.f15721f.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C3761b.this.m7145a(C3761b.this.f15722g, 102, C2300R.color.black);
                    C3761b.this.m7146a(C3761b.this.f15722g, C2300R.C2301drawable.connect_type_wifi_bg);
                    C3761b.this.m7145a(C3761b.this.f15721f, 255, C2300R.color.dronehomeline);
                    C3761b.this.m7146a(C3761b.this.f15721f, C2300R.C2301drawable.connect_type_usb_on_bg);
                    C3761b.this.f15723h.setText(C2300R.C2303string.usb_network_share);
                    C3761b.this.f15724i.setImageResource(C2300R.C2301drawable.bg_dialog_usb_android);
                    C3761b.this.f15725j.m12167a(1);
                }
            });
            this.f15722g = (Button) inflate.findViewById(C2300R.C2302id.wifi_type);
            this.f15722g.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C3761b.this.m7145a(C3761b.this.f15721f, 102, C2300R.color.black);
                    C3761b.this.m7146a(C3761b.this.f15721f, C2300R.C2301drawable.connect_type_usb_bg);
                    C3761b.this.m7145a(C3761b.this.f15722g, 255, C2300R.color.dronehomeline);
                    C3761b.this.m7146a(C3761b.this.f15722g, C2300R.C2301drawable.connect_type_wifi_on_bg);
                    C3761b.this.f15723h.setText(C2300R.C2303string.usb_wifi_network_share);
                    C3761b.this.f15724i.setImageResource(C2300R.C2301drawable.bg_dialog_usb_android_wifi);
                    C3761b.this.f15725j.m12167a(2);
                }
            });
            if (this.f15725j.m12166b() == 1) {
                m7145a(this.f15721f, 255, C2300R.color.dronehomeline);
                m7146a(this.f15721f, C2300R.C2301drawable.connect_type_usb_on_bg);
                m7145a(this.f15722g, 102, C2300R.color.black);
                m7146a(this.f15722g, C2300R.C2301drawable.connect_type_wifi_bg);
                this.f15723h.setText(C2300R.C2303string.usb_network_share);
                this.f15724i.setImageResource(C2300R.C2301drawable.bg_dialog_usb_android);
            } else {
                m7145a(this.f15722g, 255, C2300R.color.dronehomeline);
                m7146a(this.f15722g, C2300R.C2301drawable.connect_type_wifi_on_bg);
                m7145a(this.f15721f, 102, C2300R.color.black);
                m7146a(this.f15721f, C2300R.C2301drawable.connect_type_usb_bg);
                this.f15723h.setText(C2300R.C2303string.usb_wifi_network_share);
                this.f15724i.setImageResource(C2300R.C2301drawable.bg_dialog_usb_android_wifi);
            }
            if (this.f15719d != 0) {
                this.f15724i.setBackground(this.f15716a.getResources().getDrawable(this.f15719d));
            }
            if (this.f15717b != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f15717b);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f15716a.getResources().getColor(C2300R.color.setting_dialog_force_attitude)), 5, 8, 33);
                this.f15723h.setText(spannableStringBuilder);
            }
            if (this.f15718c != null) {
                button.setText(this.f15718c);
            }
            if (this.f15720e != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.a.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialogC3758a.dismiss();
                        C3761b.this.f15720e.onClick(dialogC3758a, -2);
                    }
                });
            }
            C3658ar.m7612a(this.f15716a.getAssets(), this.f15723h, button, this.f15721f, this.f15722g);
            dialogC3758a.setContentView(inflate);
            Window window = dialogC3758a.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((C2271p.m12860b(this.f15716a) > ((float) C2271p.m12871a(this.f15716a)) ? C2271p.m12860b(this.f15716a) : C2271p.m12871a(this.f15716a)) * 1032.0f) / 1920.0f);
            window.setAttributes(attributes);
            dialogC3758a.getWindow().getDecorView().setBackgroundColor(0);
            return dialogC3758a;
        }

        /* renamed from: a */
        public void m7146a(Button button, int i) {
            if (button != null) {
                button.setBackgroundResource(i);
            }
        }

        /* renamed from: a */
        public void m7145a(Button button, int i, int i2) {
            button.setTextColor(this.f15716a.getResources().getColor(i2));
            button.setTextColor(button.getTextColors().withAlpha(i));
        }

        /* renamed from: b */
        public C3761b m7140b(String str) {
            this.f15718c = str;
            return this;
        }
    }

    public DialogC3758a(Context context) {
        super(context);
    }

    public DialogC3758a(Context context, int i) {
        super(context, i);
    }

    public DialogC3758a(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}
