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
import android.widget.RadioButton;
import android.widget.TextView;
import com.fimi.kernel.utils.C2271p;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p180i.C2477h;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.view.e */
/* loaded from: classes.dex */
public class DialogC3796e extends Dialog {

    /* renamed from: com.fimi.soul.view.e$a */
    /* loaded from: classes.dex */
    public static class C3797a {

        /* renamed from: a */
        C2277v f15889a;

        /* renamed from: b */
        private Context f15890b;

        /* renamed from: c */
        private String f15891c;

        /* renamed from: d */
        private String f15892d;

        /* renamed from: e */
        private DialogInterface.OnClickListener f15893e;

        /* renamed from: f */
        private C2477h f15894f;

        /* renamed from: g */
        private String f15895g = C2854c.f10577bC;

        /* renamed from: h */
        private String f15896h = C2854c.f10578bD;

        /* renamed from: i */
        private String f15897i = C2854c.f10579bE;

        /* renamed from: j */
        private String f15898j = C2854c.f10580bF;

        /* renamed from: k */
        private boolean f15899k;

        /* renamed from: l */
        private boolean f15900l;

        public C3797a(Context context) {
            this.f15890b = context;
            this.f15894f = C2477h.m12020a(context);
        }

        /* renamed from: a */
        public C3797a m7048a(DialogInterface.OnClickListener onClickListener) {
            this.f15893e = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C3797a m7045a(String str) {
            this.f15891c = str;
            return this;
        }

        /* renamed from: a */
        public C3797a m7044a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15893e = onClickListener;
            this.f15892d = str;
            return this;
        }

        /* renamed from: a */
        public C3797a m7043a(boolean z) {
            this.f15899k = z;
            return this;
        }

        /* renamed from: a */
        public DialogC3796e m7049a() {
            this.f15889a = C2277v.m12784a(this.f15890b);
            this.f15895g = C2854c.f10577bC;
            this.f15897i = C2854c.f10579bE;
            this.f15896h = C2854c.f10578bD;
            this.f15898j = C2854c.f10580bF;
            final DialogC3796e dialogC3796e = new DialogC3796e(this.f15890b, C2300R.style.DropDialog1);
            View inflate = ((LayoutInflater) this.f15890b.getSystemService("layout_inflater")).inflate(C2300R.layout.flyactiontipdialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.action_tip);
            TextView textView2 = (TextView) inflate.findViewById(C2300R.C2302id.title);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.single_btn);
            final RadioButton radioButton = (RadioButton) inflate.findViewById(C2300R.C2302id.remeber_tip);
            if (!this.f15899k) {
                radioButton.setVisibility(8);
            } else {
                radioButton.setVisibility(0);
            }
            DialogC3796e.m7050a(radioButton, 127);
            radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!C3797a.this.f15900l) {
                        radioButton.setChecked(true);
                        C3797a.this.f15900l = true;
                        if (C3797a.this.f15894f.m12022a().get() == 1) {
                            C3797a.this.f15889a.m12787a().edit().putBoolean(C3797a.this.f15895g, true).commit();
                            return;
                        } else if (C3797a.this.f15894f.m12022a().get() == 2) {
                            C3797a.this.f15889a.m12787a().edit().putBoolean(C3797a.this.f15896h, true).commit();
                            return;
                        } else if (C3797a.this.f15894f.m12022a().get() == 3) {
                            C3797a.this.f15889a.m12787a().edit().putBoolean(C3797a.this.f15897i, true).commit();
                            return;
                        } else if (C3797a.this.f15894f.m12022a().get() != 4) {
                            return;
                        } else {
                            C3797a.this.f15889a.m12787a().edit().putBoolean(C3797a.this.f15898j, true).commit();
                            return;
                        }
                    }
                    radioButton.setChecked(false);
                    C3797a.this.f15900l = false;
                    if (C3797a.this.f15894f.m12022a().get() == 1) {
                        C3797a.this.f15889a.m12787a().edit().putBoolean(C3797a.this.f15895g, false).commit();
                    } else if (C3797a.this.f15894f.m12022a().get() == 2) {
                        C3797a.this.f15889a.m12787a().edit().putBoolean(C3797a.this.f15896h, false).commit();
                    } else if (C3797a.this.f15894f.m12022a().get() == 3) {
                        C3797a.this.f15889a.m12787a().edit().putBoolean(C3797a.this.f15897i, false).commit();
                    } else if (C3797a.this.f15894f.m12022a().get() != 4) {
                    } else {
                        C3797a.this.f15889a.m12787a().edit().putBoolean(C3797a.this.f15898j, false).commit();
                    }
                }
            });
            if (this.f15892d != null) {
                button.setText(this.f15892d);
            }
            if (this.f15891c != null) {
                textView.setText(this.f15891c);
            }
            if (this.f15893e != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.e.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        dialogC3796e.dismiss();
                        C3797a.this.f15893e.onClick(dialogC3796e, -2);
                    }
                });
            }
            C3658ar.m7612a(this.f15890b.getAssets(), textView, button, radioButton, textView2);
            dialogC3796e.setContentView(inflate);
            Window window = dialogC3796e.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((C2271p.m12860b(this.f15890b) > ((float) C2271p.m12871a(this.f15890b)) ? C2271p.m12860b(this.f15890b) : C2271p.m12871a(this.f15890b)) * 1032.0f) / 1920.0f);
            window.setAttributes(attributes);
            dialogC3796e.getWindow().getDecorView().setBackgroundColor(0);
            return dialogC3796e;
        }

        /* renamed from: b */
        public C3797a m7041b(String str) {
            this.f15892d = str;
            return this;
        }
    }

    public DialogC3796e(Context context) {
        super(context);
    }

    public DialogC3796e(Context context, int i) {
        super(context, i);
    }

    public DialogC3796e(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    /* renamed from: a */
    public static void m7050a(RadioButton radioButton, int i) {
        radioButton.setTextColor(radioButton.getTextColors().withAlpha(i));
    }
}
