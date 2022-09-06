package com.fimi.soul.module.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class PrivacyAgreementView extends LinearLayout {

    /* renamed from: a */
    TextView f13085a;

    /* renamed from: b */
    TextView f13086b;

    /* renamed from: c */
    CheckBox f13087c;

    /* renamed from: d */
    private AlertDialog f13088d;

    /* renamed from: e */
    private AbstractC3360a f13089e;

    /* renamed from: com.fimi.soul.module.login.PrivacyAgreementView$a */
    /* loaded from: classes.dex */
    public interface AbstractC3360a {
        /* renamed from: a */
        void mo8585a();

        /* renamed from: b */
        void mo8584b();
    }

    public PrivacyAgreementView(Context context) {
        super(context);
    }

    public PrivacyAgreementView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrivacyAgreementView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8592a() {
        if (this.f13088d == null || !this.f13088d.isShowing()) {
            return;
        }
        this.f13088d.dismiss();
        this.f13088d = null;
    }

    /* renamed from: a */
    public static void m8591a(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, UserProtocolWebViewActivity.class);
        intent.putExtra("web_url", str);
        intent.putExtra("web_title", str2);
        activity.startActivity(intent);
        activity.overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: a */
    private void m8590a(Context context) {
        this.f13085a.setHighlightColor(0);
        this.f13085a.setText(m8587b(context));
        this.f13085a.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* renamed from: a */
    public static void m8589a(Context context, AbstractC3360a abstractC3360a) {
        PrivacyAgreementView privacyAgreementView = (PrivacyAgreementView) LayoutInflater.from(context).inflate(C2300R.layout.popup_view_privacy_agreement_auth, (ViewGroup) null);
        AlertDialog create = new AlertDialog.Builder(context, C2300R.style.PrivacyDialog).create();
        create.show();
        privacyAgreementView.setListener(abstractC3360a);
        create.getWindow().setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), context.getResources().getDimensionPixelOffset(C2300R.dimen.size_24dp)));
        create.getWindow().setGravity(80);
        create.getWindow().getDecorView().setPadding(0, 0, 0, context.getResources().getDimensionPixelOffset(C2300R.dimen.size_44dp));
        create.setCanceledOnTouchOutside(false);
        privacyAgreementView.setDialog(create);
        create.setContentView(privacyAgreementView);
    }

    /* renamed from: b */
    private SpannableString m8587b(final Context context) {
        String string = context.getString(C2300R.C2303string.register_select_service_login);
        String string2 = context.getString(C2300R.C2303string.register_select_service2_login);
        String string3 = context.getString(C2300R.C2303string.register_select_service3);
        String string4 = context.getString(C2300R.C2303string.register_select_service4_login);
        String string5 = context.getString(C2300R.C2303string.register_select_service6);
        SpannableString spannableString = new SpannableString(string + string2 + string3 + string4 + string5);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(C2300R.color.libperson_ecurity_label)), 0, string.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(C2300R.color.libperson_ecurity_label)), string.length() + string2.length(), string.length() + string2.length() + string3.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(C2300R.color.libperson_ecurity_label)), string.length() + string2.length() + string3.length() + string4.length(), string5.length() + string.length() + string2.length() + string3.length() + string4.length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.fimi.soul.module.login.PrivacyAgreementView.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                PrivacyAgreementView.m8591a((Activity) context, C3378a.m8557b(context), context.getString(C2300R.C2303string.person_setting_user_agreement));
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(PrivacyAgreementView.this.getResources().getColor(C2300R.color.libperson_ecurity));
                textPaint.setUnderlineText(false);
            }
        }, string.length(), string.length() + string2.length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.fimi.soul.module.login.PrivacyAgreementView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                PrivacyAgreementView.m8591a((Activity) context, C3378a.m8559a(context), PrivacyAgreementView.this.getContext().getString(C2300R.C2303string.person_setting_user_privacy));
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(PrivacyAgreementView.this.getResources().getColor(C2300R.color.libperson_ecurity));
                textPaint.setUnderlineText(false);
            }
        }, string.length() + string2.length() + string3.length(), string.length() + string2.length() + string3.length() + string4.length(), 33);
        return spannableString;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f13085a = (TextView) findViewById(C2300R.C2302id.privacy_tv);
        this.f13086b = (TextView) findViewById(C2300R.C2302id.privacy_desc);
        this.f13087c = (CheckBox) findViewById(C2300R.C2302id.ck_protocol);
        findViewById(C2300R.C2302id.btn_not_agreement).setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.login.PrivacyAgreementView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PrivacyAgreementView.this.f13089e != null) {
                    PrivacyAgreementView.this.f13089e.mo8585a();
                }
            }
        });
        findViewById(C2300R.C2302id.btn_agreement).setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.login.PrivacyAgreementView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PrivacyAgreementView.this.f13087c.isChecked()) {
                    Toast.makeText(PrivacyAgreementView.this.getContext(), (int) C2300R.C2303string.login_ck_agree, 1).show();
                    return;
                }
                PrivacyAgreementView.this.m8592a();
                if (PrivacyAgreementView.this.f13089e == null) {
                    return;
                }
                PrivacyAgreementView.this.f13089e.mo8584b();
            }
        });
        m8590a(getContext());
        this.f13086b.setText(getResources().getString(C2300R.C2303string.privacy_content_desc));
    }

    public void setDialog(AlertDialog alertDialog) {
        this.f13088d = alertDialog;
        this.f13088d.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.fimi.soul.module.login.PrivacyAgreementView.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        });
        this.f13088d.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.fimi.soul.module.login.PrivacyAgreementView.6
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    Toast.makeText(PrivacyAgreementView.this.getContext(), (int) C2300R.C2303string.privacy_cancle_toast_str, 1).show();
                    return true;
                }
                return false;
            }
        });
    }

    public void setListener(AbstractC3360a abstractC3360a) {
        this.f13089e = abstractC3360a;
    }
}
