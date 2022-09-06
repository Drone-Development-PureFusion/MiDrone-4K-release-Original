package com.fimi.soul.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.kernel.utils.C2271p;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p177f.C2441a;
import com.fimi.soul.biz.p186o.C2616a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.utils.C3658ar;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.view.i */
/* loaded from: classes.dex */
public class DialogC3830i extends Dialog {

    /* renamed from: com.fimi.soul.view.i$a */
    /* loaded from: classes.dex */
    public static class C3831a implements AbstractC2221d, C2678d.AbstractC2680b {

        /* renamed from: a */
        DialogC3830i f16024a;

        /* renamed from: b */
        private Context f16025b;

        /* renamed from: c */
        private String f16026c;

        /* renamed from: d */
        private String f16027d;

        /* renamed from: e */
        private DialogInterface.OnClickListener f16028e;

        /* renamed from: f */
        private DialogInterface.OnClickListener f16029f;

        /* renamed from: g */
        private EditText f16030g;

        /* renamed from: h */
        private EditText f16031h;

        /* renamed from: i */
        private TextView f16032i;

        /* renamed from: j */
        private String f16033j;

        /* renamed from: k */
        private String f16034k;

        /* renamed from: l */
        private C2657a f16035l;

        public C3831a(Context context, C2657a c2657a) {
            this.f16025b = context;
            this.f16035l = c2657a;
            c2657a.mo11219a(this);
            C2367d.m12459a().m12434o().m13177b(this);
        }

        /* renamed from: a */
        public C3831a m6924a(String str, DialogInterface.OnClickListener onClickListener, String str2, DialogInterface.OnClickListener onClickListener2) {
            this.f16026c = str;
            this.f16027d = str2;
            this.f16028e = onClickListener;
            this.f16029f = onClickListener2;
            return this;
        }

        /* renamed from: a */
        public String m6926a() {
            if (this.f16030g != null) {
                return this.f16030g.getText().toString();
            }
            return null;
        }

        @Override // com.fimi.kernel.p157b.p160c.AbstractC2221d
        /* renamed from: a */
        public void mo6431a(String str) {
            try {
                if (!str.contains("command")) {
                    return;
                }
                if (!"0".equals(((JSONObject) new JSONObject(str).get("command")).getString("result"))) {
                    if (this.f16024a == null || this.f16032i == null) {
                        return;
                    }
                    this.f16032i.setText(C2300R.C2303string.relay_modify_error);
                } else if (this.f16024a == null || !this.f16024a.isShowing() || this.f16025b == null) {
                } else {
                    this.f16024a.dismiss();
                    if (C2441a.m12168a().m12166b() == 2) {
                        C2284z.m12696a(this.f16025b, (int) C2300R.C2303string.relay_modify_sucess, 3000);
                    }
                    C2616a m11502a = C2616a.m11502a();
                    String m11496c = m11502a.m11496c();
                    String m11495d = m11502a.m11495d();
                    if (m11496c != null) {
                        C2367d.m12459a().m12445e(m11496c);
                    }
                    if (m11495d == null) {
                        return;
                    }
                    C2367d.m12459a().m12447d(m11495d);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: b */
        public String m6923b() {
            if (this.f16031h != null) {
                return this.f16031h.getText().toString();
            }
            return null;
        }

        /* renamed from: b */
        public void m6921b(String str) {
            if (this.f16032i != null) {
                this.f16032i.setText(str);
            }
        }

        /* renamed from: c */
        public C3831a m6918c(String str) {
            this.f16033j = str;
            return this;
        }

        /* renamed from: c */
        public DialogC3830i m6920c() {
            this.f16024a = new DialogC3830i(this.f16025b, C2300R.style.DropDialog1);
            View inflate = ((LayoutInflater) this.f16025b.getSystemService("layout_inflater")).inflate(C2300R.layout.relay_wifi_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.wifi_name);
            TextView textView2 = (TextView) inflate.findViewById(C2300R.C2302id.wifi_password);
            TextView textView3 = (TextView) inflate.findViewById(C2300R.C2302id.dialog_title);
            this.f16030g = (EditText) inflate.findViewById(C2300R.C2302id.ssid_name);
            this.f16030g.clearFocus();
            if (this.f16033j != null) {
                this.f16030g.setText(this.f16033j);
            }
            this.f16031h = (EditText) inflate.findViewById(C2300R.C2302id.key_pas);
            this.f16031h.clearFocus();
            if (this.f16034k != null) {
                this.f16031h.setText(this.f16034k);
            }
            this.f16032i = (TextView) inflate.findViewById(C2300R.C2302id.pas_tip);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.left_btn);
            Button button2 = (Button) inflate.findViewById(C2300R.C2302id.right_btn);
            if (this.f16026c != null) {
                button.setText(this.f16026c);
            }
            if (this.f16027d != null) {
                button2.setText(this.f16027d);
            }
            if (this.f16028e != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.i.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3831a.this.f16028e.onClick(C3831a.this.f16024a, -2);
                    }
                });
            }
            if (this.f16029f != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.i.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3831a.this.f16029f.onClick(C3831a.this.f16024a, -1);
                    }
                });
            }
            C3658ar.m7612a(this.f16025b.getAssets(), textView3, this.f16030g, this.f16031h, button, button2, this.f16032i, textView, textView2);
            this.f16024a.setContentView(inflate);
            Window window = this.f16024a.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((C2271p.m12860b(this.f16025b) > ((float) C2271p.m12871a(this.f16025b)) ? C2271p.m12860b(this.f16025b) : C2271p.m12871a(this.f16025b)) * 1032.0f) / 1920.0f);
            window.setAttributes(attributes);
            this.f16024a.getWindow().getDecorView().setBackgroundColor(0);
            this.f16024a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.fimi.soul.view.i.a.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (C3831a.this.f16035l != null) {
                        C3831a.this.f16035l.mo11214b(C3831a.this);
                    }
                }
            });
            return this.f16024a;
        }

        /* renamed from: d */
        public C3831a m6917d(String str) {
            this.f16034k = str;
            return this;
        }

        @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
        public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
            if (enumC2679a != C2678d.EnumC2679a.CLEANALLOBJ || this.f16024a == null || !this.f16024a.isShowing() || c2657a == null) {
                return;
            }
            m6921b(c2657a.f9270d.getString(C2300R.C2303string.connectdefault));
        }
    }

    public DialogC3830i(Context context) {
        super(context);
    }

    public DialogC3830i(Context context, int i) {
        super(context, i);
    }

    public DialogC3830i(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}
