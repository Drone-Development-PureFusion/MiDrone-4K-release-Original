package com.fimi.soul.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.fimi.kernel.view.dialog.AbstractC2293a;
import com.fimi.kernel.view.dialog.AbstractC2295c;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.view.b */
/* loaded from: classes.dex */
public class C3765b implements AbstractC2295c {

    /* renamed from: c */
    private AlertDialogC3771b f15730c;

    /* renamed from: d */
    private AlertDialogC3774c f15731d;

    /* renamed from: e */
    private AlertDialogC3768a f15732e;

    /* renamed from: com.fimi.soul.view.b$a */
    /* loaded from: classes.dex */
    class AlertDialogC3768a extends AlertDialog {

        /* renamed from: a */
        Context f15737a;

        /* renamed from: b */
        String f15738b;

        /* renamed from: c */
        AbstractC2293a f15739c;

        /* renamed from: d */
        int f15740d;

        /* renamed from: e */
        String f15741e;

        /* renamed from: f */
        String f15742f;

        /* renamed from: g */
        Boolean f15743g;

        /* renamed from: h */
        String f15744h;

        protected AlertDialogC3768a(Context context, String str, String str2, String str3, Boolean bool, String str4, AbstractC2293a abstractC2293a) {
            super(context);
            this.f15737a = context;
            this.f15738b = str;
            this.f15739c = abstractC2293a;
            this.f15741e = str2;
            this.f15742f = str3;
            this.f15743g = bool;
            this.f15744h = str4;
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(C2300R.layout.dialog_double_checkbox_button);
            Button button = (Button) findViewById(C2300R.C2302id.left_btn);
            Button button2 = (Button) findViewById(C2300R.C2302id.right_btn);
            TextView textView = (TextView) findViewById(C2300R.C2302id.check_tv);
            textView.setText(this.f15744h);
            final CheckBox checkBox = (CheckBox) findViewById(C2300R.C2302id.checkbox);
            checkBox.setChecked(this.f15743g.booleanValue());
            TextView textView2 = (TextView) findViewById(C2300R.C2302id.msg_tv);
            textView2.setText(this.f15738b);
            button.setText(this.f15741e);
            button2.setText(this.f15742f);
            C3658ar.m7612a(this.f15737a.getAssets(), button2, button, textView, textView2);
            textView2.setTextColor(-872415232);
            textView2.getPaint().setFakeBoldText(true);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlertDialogC3768a.this.f15739c != null) {
                        AlertDialogC3768a.this.f15739c.mo9999a(-2, Boolean.valueOf(checkBox.isChecked()));
                        AlertDialogC3768a.this.dismiss();
                    }
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlertDialogC3768a.this.f15739c != null) {
                        AlertDialogC3768a.this.f15739c.mo9999a(-1, Boolean.valueOf(checkBox.isChecked()));
                        AlertDialogC3768a.this.dismiss();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.view.b$b */
    /* loaded from: classes.dex */
    public class AlertDialogC3771b extends AlertDialog {

        /* renamed from: a */
        Context f15750a;

        /* renamed from: b */
        String f15751b;

        /* renamed from: c */
        String f15752c;

        /* renamed from: d */
        AbstractC2293a f15753d;

        /* renamed from: e */
        int f15754e;

        /* renamed from: f */
        String f15755f;

        /* renamed from: g */
        String f15756g;

        protected AlertDialogC3771b(Context context, String str, String str2, int i, String str3, String str4, AbstractC2293a abstractC2293a) {
            super(context);
            this.f15750a = context;
            this.f15751b = str;
            this.f15752c = str2;
            this.f15753d = abstractC2293a;
            this.f15755f = str3;
            this.f15754e = i;
            this.f15756g = str4;
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(C2300R.layout.dialog_double_button);
            Button button = (Button) findViewById(C2300R.C2302id.left_btn);
            Button button2 = (Button) findViewById(C2300R.C2302id.right_btn);
            TextView textView = (TextView) findViewById(C2300R.C2302id.msg_tv);
            TextView textView2 = (TextView) findViewById(C2300R.C2302id.content_tv);
            if (this.f15752c == null) {
                textView2.setVisibility(8);
            }
            textView2.setText(this.f15752c);
            textView.setText(this.f15751b);
            button2.setTextColor(this.f15754e);
            button.setText(this.f15755f);
            button2.setText(this.f15756g);
            C3658ar.m7612a(this.f15750a.getAssets(), button2, button, textView, textView2);
            textView.setTextColor(-872415232);
            textView.getPaint().setFakeBoldText(true);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlertDialogC3771b.this.f15753d != null) {
                        AlertDialogC3771b.this.dismiss();
                        AlertDialogC3771b.this.f15753d.mo10000a(-2);
                    }
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.b.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlertDialogC3771b.this.f15753d != null) {
                        AlertDialogC3771b.this.dismiss();
                        AlertDialogC3771b.this.f15753d.mo10000a(-1);
                    }
                }
            });
        }
    }

    /* renamed from: com.fimi.soul.view.b$c */
    /* loaded from: classes.dex */
    class AlertDialogC3774c extends AlertDialog {

        /* renamed from: a */
        Context f15760a;

        /* renamed from: b */
        String f15761b;

        /* renamed from: c */
        String f15762c;

        /* renamed from: d */
        AbstractC2293a f15763d;

        protected AlertDialogC3774c(Context context, String str, String str2, AbstractC2293a abstractC2293a) {
            super(context);
            this.f15760a = context;
            this.f15761b = str;
            this.f15762c = str2;
            this.f15763d = abstractC2293a;
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(C2300R.layout.dialog_pop);
            TextView textView = (TextView) findViewById(C2300R.C2302id.msg_child_tv);
            Button button = (Button) findViewById(C2300R.C2302id.dialog_btn);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.b.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlertDialogC3774c.this.dismiss();
                    AlertDialogC3774c.this.f15763d.mo10000a(-1);
                }
            });
            TextView textView2 = (TextView) findViewById(C2300R.C2302id.msg_tv);
            textView2.setText(this.f15761b);
            textView.setText(this.f15762c);
            C3658ar.m7612a(this.f15760a.getAssets(), textView2, button, textView);
            textView2.setTextColor(-872415232);
            textView2.getPaint().setFakeBoldText(true);
            textView.getPaint().setFakeBoldText(true);
        }
    }

    @Override // com.fimi.kernel.view.dialog.AbstractC2295c
    /* renamed from: a */
    public Dialog mo7135a(Context context, int i, String str, String str2, AbstractC2293a abstractC2293a) {
        return mo7132a(context, str, str2, abstractC2293a);
    }

    @Override // com.fimi.kernel.view.dialog.AbstractC2295c
    /* renamed from: a */
    public Dialog mo7134a(Context context, String str, int i, String str2, String str3, AbstractC2293a abstractC2293a) {
        return m7133a(context, str, (String) null, i, str2, str3, abstractC2293a);
    }

    /* renamed from: a */
    public Dialog m7133a(Context context, String str, String str2, int i, String str3, String str4, AbstractC2293a abstractC2293a) {
        if (this.f15730c == null) {
            this.f15730c = new AlertDialogC3771b(context, str, str2, i, str3, str4, abstractC2293a);
        }
        if (!this.f15730c.isShowing()) {
            this.f15730c.show();
        }
        return this.f15730c;
    }

    @Override // com.fimi.kernel.view.dialog.AbstractC2295c
    /* renamed from: a */
    public Dialog mo7132a(Context context, String str, String str2, final AbstractC2293a abstractC2293a) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(context.getString(C2300R.C2303string.confirm), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.view.b.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (abstractC2293a != null) {
                    abstractC2293a.mo10000a(-1);
                }
            }
        });
        if (abstractC2293a != null) {
            negativeButton.setPositiveButton(context.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.view.b.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (abstractC2293a != null) {
                        abstractC2293a.mo10000a(-2);
                    }
                }
            });
        }
        return negativeButton.show();
    }

    @Override // com.fimi.kernel.view.dialog.AbstractC2295c
    /* renamed from: a */
    public Dialog mo7131a(Context context, String str, String str2, String str3, Boolean bool, String str4, AbstractC2293a abstractC2293a) {
        if (this.f15732e == null) {
            this.f15732e = new AlertDialogC3768a(context, str, str2, str3, bool, str4, abstractC2293a);
        }
        if (!this.f15732e.isShowing()) {
            this.f15732e.show();
        }
        return this.f15732e;
    }

    @Override // com.fimi.kernel.view.dialog.AbstractC2295c
    /* renamed from: b */
    public Dialog mo7130b(Context context, String str, String str2, AbstractC2293a abstractC2293a) {
        if (this.f15731d == null) {
            this.f15731d = new AlertDialogC3774c(context, str, str2, abstractC2293a);
        }
        if (!this.f15731d.isShowing()) {
            this.f15731d.show();
        }
        return this.f15731d;
    }
}
