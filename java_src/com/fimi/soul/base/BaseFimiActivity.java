package com.fimi.soul.base;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.fimi.kernel.utils.C2278w;
import com.fimi.soul.view.titlebar.FmBottomBar;
import com.fimi.soul.view.titlebar.FmTitleBar;
/* loaded from: classes.dex */
public abstract class BaseFimiActivity extends com.fimi.kernel.BaseActivity {
    public LayoutInflater mInflater;
    protected C2278w mTintManager;
    public Application abApplication = null;
    public RelativeLayout ab_base = null;
    private FmTitleBar mAbTitleBar = null;
    private FmBottomBar mAbBottomBar = null;
    protected RelativeLayout contentLayout = null;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    public FmBottomBar getBottomBar() {
        return this.mAbBottomBar;
    }

    public FmTitleBar getTitleBar() {
        this.mAbTitleBar.setVisibility(0);
        return this.mAbTitleBar;
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mAbTitleBar.m6694b();
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.mInflater = LayoutInflater.from(this);
        this.mTintManager = new C2278w(this);
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(true);
        }
        this.mTintManager.m12734a(true);
        this.mAbTitleBar = new FmTitleBar(this);
        this.ab_base = new RelativeLayout(this);
        this.ab_base.setBackgroundColor(Color.rgb(255, 255, 255));
        this.contentLayout = new RelativeLayout(this);
        this.contentLayout.setPadding(0, 0, 0, 0);
        this.mAbBottomBar = new FmBottomBar(this);
        this.ab_base.addView(this.mAbTitleBar, new LinearLayout.LayoutParams(-1, -2));
        this.mAbTitleBar.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        this.ab_base.addView(this.mAbBottomBar, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, this.mAbTitleBar.getId());
        layoutParams2.addRule(2, this.mAbBottomBar.getId());
        this.ab_base.addView(this.contentLayout, layoutParams2);
        this.abApplication = getApplication();
        setContentView(this.ab_base, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mAbTitleBar.m6694b();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mAbTitleBar.m6694b();
    }

    public void setAbContentView(int i) {
        setAbContentView(this.mInflater.inflate(i, (ViewGroup) null));
    }

    public void setAbContentView(View view) {
        this.contentLayout.removeAllViews();
        this.contentLayout.addView(view, new LinearLayout.LayoutParams(-1, -1));
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    public void setStatusBarTintResource(int i) {
        this.mTintManager.m12722d(i);
    }

    public void setTitleBarOverlay(boolean z) {
        this.ab_base.removeAllViews();
        if (!z) {
            this.ab_base.addView(this.mAbTitleBar, new LinearLayout.LayoutParams(-1, -2));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12, -1);
            this.ab_base.addView(this.mAbBottomBar, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, this.mAbTitleBar.getId());
            layoutParams2.addRule(2, this.mAbBottomBar.getId());
            this.ab_base.addView(this.contentLayout, layoutParams2);
            return;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(2, this.mAbBottomBar.getId());
        this.ab_base.addView(this.contentLayout, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(10, -1);
        this.ab_base.addView(this.mAbTitleBar, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(12, -1);
        this.ab_base.addView(this.mAbBottomBar, layoutParams5);
    }

    @Override // android.app.Activity
    public void setTitleColor(int i) {
        super.setTitleColor(i);
    }

    @TargetApi(19)
    protected void setTranslucentStatus(boolean z) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }
}
