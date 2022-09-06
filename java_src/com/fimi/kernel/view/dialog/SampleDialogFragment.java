package com.fimi.kernel.view.dialog;

import android.animation.Animator;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.fimi.kernel.utils.C2278w;
/* loaded from: classes.dex */
public class SampleDialogFragment extends DialogFragment {

    /* renamed from: a */
    protected C2278w f7641a;

    /* renamed from: b */
    private int f7642b;

    /* renamed from: c */
    private int f7643c;

    /* renamed from: d */
    private View f7644d;

    /* renamed from: e */
    private DialogInterface.OnCancelListener f7645e = null;

    /* renamed from: f */
    private DialogInterface.OnDismissListener f7646f = null;

    /* renamed from: g */
    private int f7647g;

    /* renamed from: h */
    private int f7648h;

    /* renamed from: a */
    public static SampleDialogFragment m12662a(int i, int i2) {
        return m12661a(i, i2, 17);
    }

    /* renamed from: a */
    public static SampleDialogFragment m12661a(int i, int i2, int i3) {
        SampleDialogFragment sampleDialogFragment = new SampleDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("style", i);
        bundle.putInt("theme", i2);
        bundle.putInt("gravity", i3);
        sampleDialogFragment.setArguments(bundle);
        return sampleDialogFragment;
    }

    /* renamed from: a */
    public static SampleDialogFragment m12660a(int i, int i2, int i3, int i4) {
        SampleDialogFragment sampleDialogFragment = new SampleDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("style", i);
        bundle.putInt("theme", i2);
        bundle.putInt("gravity", i3);
        bundle.putInt("color", i4);
        sampleDialogFragment.setArguments(bundle);
        return sampleDialogFragment;
    }

    /* renamed from: a */
    public View m12664a() {
        return this.f7644d;
    }

    /* renamed from: a */
    public void m12663a(int i) {
        this.f7641a.m12724c(i);
    }

    /* renamed from: a */
    public void m12659a(DialogInterface.OnCancelListener onCancelListener) {
        this.f7645e = onCancelListener;
    }

    /* renamed from: a */
    public void m12658a(DialogInterface.OnDismissListener onDismissListener) {
        this.f7646f = onDismissListener;
    }

    /* renamed from: a */
    public void m12657a(View view) {
        this.f7644d = view;
    }

    /* renamed from: a */
    protected void m12656a(boolean z) {
        Window window = getActivity().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    /* renamed from: b */
    public DialogInterface.OnCancelListener m12655b() {
        return this.f7645e;
    }

    /* renamed from: c */
    public DialogInterface.OnDismissListener m12654c() {
        return this.f7646f;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Window window = getDialog().getWindow();
        window.getAttributes().gravity = this.f7647g;
        window.setLayout(-1, -2);
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#88838B8B")));
        super.onActivityCreated(bundle);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f7645e != null) {
            this.f7645e.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dismiss();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7643c = getArguments().getInt("style");
        this.f7642b = getArguments().getInt("theme");
        this.f7647g = getArguments().getInt("gravity");
        this.f7648h = getArguments().getInt("color");
        setStyle(this.f7643c, this.f7642b);
        this.f7641a = new C2278w(getActivity());
        if (Build.VERSION.SDK_INT >= 19) {
            m12656a(true);
        }
        this.f7641a.m12734a(true);
        m12663a(this.f7648h);
    }

    @Override // android.app.Fragment
    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return super.onCreateAnimator(i, z, i2);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f7644d;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dismiss();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f7646f != null) {
            this.f7646f.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }
}
