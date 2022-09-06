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
import android.widget.CheckBox;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.view.c */
/* loaded from: classes.dex */
public class DialogC3776c extends Dialog {

    /* renamed from: com.fimi.soul.view.c$a */
    /* loaded from: classes.dex */
    public static class C3777a {

        /* renamed from: a */
        private Context f15766a;

        /* renamed from: b */
        private String f15767b;

        /* renamed from: c */
        private String f15768c;

        /* renamed from: d */
        private String f15769d;

        /* renamed from: e */
        private String f15770e;

        /* renamed from: f */
        private String f15771f;

        /* renamed from: j */
        private DialogInterface.OnClickListener f15775j;

        /* renamed from: k */
        private DialogInterface.OnClickListener f15776k;

        /* renamed from: g */
        private int f15772g = -1;

        /* renamed from: h */
        private int f15773h = -1;

        /* renamed from: i */
        private int f15774i = -1;

        /* renamed from: l */
        private boolean f15777l = true;

        public C3777a(Context context) {
            this.f15766a = context;
        }

        /* renamed from: a */
        public C3777a m7128a(int i) {
            this.f15772g = i;
            return this;
        }

        /* renamed from: a */
        public C3777a m7126a(String str) {
            this.f15767b = str;
            return this;
        }

        /* renamed from: a */
        public C3777a m7125a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15769d = str;
            this.f15775j = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C3777a m7124a(boolean z) {
            this.f15777l = z;
            return this;
        }

        /* renamed from: a */
        public DialogC3776c m7129a() {
            final DialogC3776c dialogC3776c = new DialogC3776c(this.f15766a, C2300R.style.DropDialog1);
            View inflate = ((LayoutInflater) this.f15766a.getSystemService("layout_inflater")).inflate(C2300R.layout.dialog_double_button, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.left_btn);
            Button button2 = (Button) inflate.findViewById(C2300R.C2302id.right_btn);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            TextView textView2 = (TextView) inflate.findViewById(C2300R.C2302id.content_tv);
            C3658ar.m7612a(this.f15766a.getAssets(), button2, button, textView, textView2);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextColor(-872415232);
            if (this.f15769d != null) {
                button2.setText(this.f15769d);
            }
            if (this.f15770e != null) {
                button.setText(this.f15770e);
            }
            if (this.f15768c != null) {
                textView.setText(this.f15768c);
            }
            if (this.f15772g != -1) {
                button2.setTextColor(this.f15772g);
            }
            if (this.f15773h != -1) {
                button.setTextColor(this.f15773h);
            }
            if (this.f15771f != null) {
                textView2.setVisibility(0);
                textView2.setText(this.f15771f);
            } else {
                textView2.setVisibility(8);
            }
            if (this.f15774i != -1) {
                textView.setMaxEms(this.f15774i);
            }
            if (this.f15775j != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.c.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3777a.this.f15775j.onClick(dialogC3776c, -1);
                        dialogC3776c.dismiss();
                    }
                });
            }
            if (this.f15776k != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.c.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3777a.this.f15776k.onClick(dialogC3776c, -2);
                        dialogC3776c.dismiss();
                    }
                });
            }
            if (this.f15777l) {
                dialogC3776c.setCanceledOnTouchOutside(true);
            } else {
                dialogC3776c.setCanceledOnTouchOutside(false);
            }
            dialogC3776c.setContentView(inflate);
            Window window = dialogC3776c.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) this.f15766a.getResources().getDimension(C2300R.dimen.double_dialog_width);
            window.setAttributes(attributes);
            dialogC3776c.getWindow().getDecorView().setBackgroundColor(0);
            return dialogC3776c;
        }

        /* renamed from: b */
        public C3777a m7123b(int i) {
            this.f15773h = i;
            return this;
        }

        /* renamed from: b */
        public C3777a m7121b(String str) {
            this.f15768c = str;
            return this;
        }

        /* renamed from: b */
        public C3777a m7120b(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15770e = str;
            this.f15776k = onClickListener;
            return this;
        }

        /* renamed from: c */
        public C3777a m7119c(int i) {
            this.f15774i = i;
            return this;
        }

        /* renamed from: c */
        public C3777a m7118c(String str) {
            this.f15771f = str;
            return this;
        }
    }

    /* renamed from: com.fimi.soul.view.c$b */
    /* loaded from: classes.dex */
    public static class C3780b {

        /* renamed from: a */
        private Context f15782a;

        /* renamed from: b */
        private String f15783b;

        /* renamed from: c */
        private String f15784c;

        /* renamed from: d */
        private String f15785d;

        /* renamed from: e */
        private String f15786e;

        /* renamed from: h */
        private boolean f15789h;

        /* renamed from: i */
        private DialogInterface.OnClickListener f15790i;

        /* renamed from: j */
        private DialogInterface.OnClickListener f15791j;

        /* renamed from: f */
        private int f15787f = -1;

        /* renamed from: g */
        private int f15788g = -1;

        /* renamed from: k */
        private boolean f15792k = false;

        public C3780b(Context context) {
            this.f15782a = context;
        }

        /* renamed from: a */
        public C3780b m7116a(int i) {
            this.f15787f = i;
            return this;
        }

        /* renamed from: a */
        public C3780b m7114a(String str) {
            this.f15783b = str;
            return this;
        }

        /* renamed from: a */
        public C3780b m7113a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15784c = str;
            this.f15790i = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C3780b m7112a(boolean z) {
            this.f15789h = z;
            return this;
        }

        /* renamed from: a */
        public DialogC3776c m7117a() {
            final DialogC3776c dialogC3776c = new DialogC3776c(this.f15782a, C2300R.style.DropDialog1);
            View inflate = ((LayoutInflater) this.f15782a.getSystemService("layout_inflater")).inflate(C2300R.layout.dialog_double_checkbox_button, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.left_btn);
            Button button2 = (Button) inflate.findViewById(C2300R.C2302id.right_btn);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.check_tv);
            textView.setText(this.f15786e);
            CheckBox checkBox = (CheckBox) inflate.findViewById(C2300R.C2302id.checkbox);
            checkBox.setChecked(this.f15789h);
            TextView textView2 = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            if (this.f15783b != null) {
                textView2.setText(this.f15783b);
            }
            if (this.f15785d != null) {
                button.setText(this.f15785d);
            }
            if (this.f15784c != null) {
                button2.setText(this.f15784c);
            }
            if (this.f15786e != null) {
                textView.setText(this.f15786e);
            }
            if (this.f15789h) {
                checkBox.setChecked(this.f15789h);
            } else {
                checkBox.setChecked(this.f15789h);
            }
            C3658ar.m7612a(this.f15782a.getAssets(), button2, button, textView, textView2);
            textView2.setTextColor(-872415232);
            textView2.getPaint().setFakeBoldText(true);
            if (this.f15790i != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.c.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3780b.this.f15790i.onClick(dialogC3776c, -1);
                    }
                });
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.c.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3780b.this.f15791j.onClick(dialogC3776c, -2);
                    }
                });
            }
            dialogC3776c.setContentView(inflate);
            Window window = dialogC3776c.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) this.f15782a.getResources().getDimension(C2300R.dimen.double_choose_dialog_width);
            window.setAttributes(attributes);
            dialogC3776c.getWindow().getDecorView().setBackgroundColor(0);
            return dialogC3776c;
        }

        /* renamed from: b */
        public C3780b m7111b(int i) {
            this.f15788g = i;
            return this;
        }

        /* renamed from: b */
        public C3780b m7109b(String str) {
            this.f15786e = str;
            return this;
        }

        /* renamed from: b */
        public C3780b m7108b(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15785d = str;
            this.f15791j = onClickListener;
            return this;
        }
    }

    /* renamed from: com.fimi.soul.view.c$c */
    /* loaded from: classes.dex */
    public static class C3783c {

        /* renamed from: a */
        private Context f15797a;

        /* renamed from: b */
        private String f15798b;

        /* renamed from: c */
        private String f15799c;

        /* renamed from: d */
        private String f15800d;

        /* renamed from: e */
        private String f15801e;

        /* renamed from: f */
        private String f15802f;

        /* renamed from: j */
        private DialogInterface.OnClickListener f15806j;

        /* renamed from: k */
        private DialogInterface.OnClickListener f15807k;

        /* renamed from: g */
        private int f15803g = -1;

        /* renamed from: h */
        private int f15804h = -1;

        /* renamed from: i */
        private int f15805i = -1;

        /* renamed from: l */
        private boolean f15808l = true;

        public C3783c(Context context) {
            this.f15797a = context;
        }

        /* renamed from: a */
        public C3783c m7106a(int i) {
            this.f15803g = i;
            return this;
        }

        /* renamed from: a */
        public C3783c m7104a(String str) {
            this.f15798b = str;
            return this;
        }

        /* renamed from: a */
        public C3783c m7103a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15800d = str;
            this.f15806j = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C3783c m7102a(boolean z) {
            this.f15808l = z;
            return this;
        }

        /* renamed from: a */
        public DialogC3776c m7107a() {
            final DialogC3776c dialogC3776c = new DialogC3776c(this.f15797a, C2300R.style.DropDialog1);
            View inflate = ((LayoutInflater) this.f15797a.getSystemService("layout_inflater")).inflate(C2300R.layout.dialog_double_button_insurance, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.left_btn);
            Button button2 = (Button) inflate.findViewById(C2300R.C2302id.right_btn);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            TextView textView2 = (TextView) inflate.findViewById(C2300R.C2302id.content_tv);
            C3658ar.m7612a(this.f15797a.getAssets(), button2, button, textView, textView2);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextColor(-872415232);
            if (this.f15800d != null) {
                button2.setText(this.f15800d);
            }
            if (this.f15801e != null) {
                button.setText(this.f15801e);
            }
            if (this.f15798b != null) {
                textView.setText(this.f15798b);
            }
            if (this.f15799c != null) {
                textView2.setText(this.f15799c);
            }
            if (this.f15803g != -1) {
                button2.setTextColor(this.f15803g);
            }
            if (this.f15804h != -1) {
                button.setTextColor(this.f15804h);
            }
            if (this.f15805i != -1) {
                textView.setMaxEms(this.f15805i);
            }
            if (this.f15806j != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.c.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3783c.this.f15806j.onClick(dialogC3776c, -1);
                        dialogC3776c.dismiss();
                    }
                });
            }
            if (this.f15807k != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.c.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3783c.this.f15807k.onClick(dialogC3776c, -2);
                        dialogC3776c.dismiss();
                    }
                });
            }
            if (this.f15808l) {
                dialogC3776c.setCanceledOnTouchOutside(true);
            } else {
                dialogC3776c.setCanceledOnTouchOutside(false);
            }
            dialogC3776c.setContentView(inflate);
            Window window = dialogC3776c.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) this.f15797a.getResources().getDimension(C2300R.dimen.double_dialog_width);
            window.setAttributes(attributes);
            dialogC3776c.getWindow().getDecorView().setBackgroundColor(0);
            return dialogC3776c;
        }

        /* renamed from: b */
        public C3783c m7101b(int i) {
            this.f15804h = i;
            return this;
        }

        /* renamed from: b */
        public C3783c m7099b(String str) {
            this.f15799c = str;
            return this;
        }

        /* renamed from: b */
        public C3783c m7098b(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15801e = str;
            this.f15807k = onClickListener;
            return this;
        }

        /* renamed from: c */
        public C3783c m7097c(int i) {
            this.f15805i = i;
            return this;
        }

        /* renamed from: c */
        public C3783c m7096c(String str) {
            this.f15802f = str;
            return this;
        }
    }

    /* renamed from: com.fimi.soul.view.c$d */
    /* loaded from: classes.dex */
    public static class C3786d {

        /* renamed from: a */
        private Context f15813a;

        /* renamed from: b */
        private String f15814b;

        /* renamed from: c */
        private String f15815c;

        /* renamed from: d */
        private String f15816d;

        /* renamed from: g */
        private DialogInterface.OnClickListener f15819g;

        /* renamed from: e */
        private int f15817e = -1;

        /* renamed from: f */
        private int f15818f = -1;

        /* renamed from: h */
        private boolean f15820h = false;

        public C3786d(Context context) {
            this.f15813a = context;
        }

        /* renamed from: a */
        public C3786d m7094a(int i) {
            this.f15818f = i;
            return this;
        }

        /* renamed from: a */
        public C3786d m7093a(Context context) {
            this.f15813a = context;
            return this;
        }

        /* renamed from: a */
        public C3786d m7091a(String str) {
            this.f15814b = str;
            return this;
        }

        /* renamed from: a */
        public C3786d m7090a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f15816d = str;
            this.f15819g = onClickListener;
            return this;
        }

        /* renamed from: a */
        public DialogC3776c m7095a() {
            final DialogC3776c dialogC3776c = new DialogC3776c(this.f15813a, C2300R.style.DropDialog1);
            View inflate = ((LayoutInflater) this.f15813a.getSystemService("layout_inflater")).inflate(C2300R.layout.dialog_pop, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C2300R.C2302id.msg_child_tv);
            Button button = (Button) inflate.findViewById(C2300R.C2302id.dialog_btn);
            TextView textView2 = (TextView) inflate.findViewById(C2300R.C2302id.msg_tv);
            if (this.f15814b != null) {
                textView2.setText(this.f15814b);
            }
            if (this.f15816d != null) {
                button.setText(this.f15816d);
            }
            if (this.f15818f != -1) {
                textView2.setMaxEms(this.f15818f);
            }
            if (this.f15815c != null) {
                textView.setVisibility(0);
                textView.setText(this.f15815c);
            } else {
                textView.setVisibility(8);
            }
            if (this.f15819g != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.c.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3786d.this.f15819g.onClick(dialogC3776c, -1);
                        dialogC3776c.dismiss();
                    }
                });
            }
            C3658ar.m7612a(this.f15813a.getAssets(), textView2, button, textView);
            textView2.getPaint().setFakeBoldText(true);
            if (this.f15815c != null) {
                textView.getPaint().setFakeBoldText(true);
            }
            dialogC3776c.setContentView(inflate);
            Window window = dialogC3776c.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = (int) this.f15813a.getResources().getDimension(C2300R.dimen.single_dialog_height);
            attributes.width = (int) this.f15813a.getResources().getDimension(C2300R.dimen.single_dialog_width);
            window.setAttributes(attributes);
            dialogC3776c.getWindow().getDecorView().setBackgroundColor(0);
            return dialogC3776c;
        }

        /* renamed from: b */
        public C3786d m7089b(String str) {
            this.f15815c = str;
            return this;
        }
    }

    public DialogC3776c(Context context) {
        super(context);
        requestWindowFeature(1);
    }

    public DialogC3776c(Context context, int i) {
        super(context, i);
        requestWindowFeature(1);
    }
}
