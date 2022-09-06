package com.fimi.soul.module.login;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class TitleView extends FrameLayout {

    /* renamed from: b */
    private TextView f13101b = (TextView) findViewById(C2300R.C2302id.tv_title);

    /* renamed from: a */
    private ImageView f13100a = (ImageView) findViewById(C2300R.C2302id.iv_return);

    /* renamed from: c */
    private TextView f13102c = (TextView) findViewById(C2300R.C2302id.tv_right);

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(C2300R.layout.sub_login_title, this);
        this.f13100a.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.login.TitleView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((Activity) TitleView.this.getContext()).finish();
            }
        });
        C3386d.m8538b(context.getAssets(), this.f13102c, this.f13101b);
    }

    public void setIvLeftListener(View.OnClickListener onClickListener) {
        this.f13100a.setOnClickListener(onClickListener);
    }

    public void setRightTvIsVisible(boolean z) {
        this.f13102c.setVisibility(z ? 0 : 4);
    }

    public void setTvRightListener(View.OnClickListener onClickListener) {
        this.f13102c.setOnClickListener(onClickListener);
    }

    public void setTvRightText(String str) {
        this.f13102c.setText(str);
    }

    public void setTvRightVisible(int i) {
        this.f13102c.setVisibility(i);
    }

    public void setTvTitle(String str) {
        this.f13101b.setText(str);
    }
}
