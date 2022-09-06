package com.fimi.soul.view.titlebar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.app.FragmentActivity;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.fimi.kernel.utils.C2269n;
import com.fimi.kernel.utils.C2271p;
import com.fimi.kernel.view.dialog.SampleDialogFragment;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseFimiActivity;
import com.fimi.soul.entity.FmMenuItem;
import com.fimi.soul.p167b.C2329e;
import java.util.List;
import p244m.framework.p247ui.widget.asyncview.AsyncImageView;
/* loaded from: classes.dex */
public class FmTitleBar extends LinearLayout {

    /* renamed from: k */
    public LayoutInflater f16486k;

    /* renamed from: l */
    public int f16487l;

    /* renamed from: s */
    private Activity f16494s;

    /* renamed from: v */
    private PopupWindow f16497v;

    /* renamed from: a */
    protected LinearLayout f16476a = null;

    /* renamed from: b */
    protected LinearLayout f16477b = null;

    /* renamed from: c */
    protected Button f16478c = null;

    /* renamed from: d */
    protected Button f16479d = null;

    /* renamed from: e */
    protected ImageView f16480e = null;

    /* renamed from: f */
    protected ImageView f16481f = null;

    /* renamed from: g */
    protected SimpleDraweeView f16482g = null;

    /* renamed from: h */
    protected ImageView f16483h = null;

    /* renamed from: t */
    private LinearLayout.LayoutParams f16495t = null;

    /* renamed from: u */
    private LinearLayout.LayoutParams f16496u = null;

    /* renamed from: i */
    protected LinearLayout f16484i = null;

    /* renamed from: j */
    public int f16485j = 1;

    /* renamed from: m */
    public LinearLayout.LayoutParams f16488m = null;

    /* renamed from: n */
    public LinearLayout.LayoutParams f16489n = null;

    /* renamed from: o */
    public LinearLayout.LayoutParams f16490o = null;

    /* renamed from: p */
    public LinearLayout.LayoutParams f16491p = null;

    /* renamed from: q */
    public LinearLayout.LayoutParams f16492q = null;

    /* renamed from: r */
    SampleDialogFragment f16493r = null;

    public FmTitleBar(Context context) {
        super(context);
        m6700a(context);
    }

    public FmTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6700a(context);
    }

    /* renamed from: a */
    public static SampleDialogFragment m6697a(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        SampleDialogFragment m12660a = SampleDialogFragment.m12660a(1, C2300R.style.MyDialog, i5, i6);
        m12660a.m12657a(view);
        FragmentTransaction beginTransaction = ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(i, i2, i3, i4);
        m12660a.show(beginTransaction, "showDialog");
        m12660a.setCancelable(true);
        return m12660a;
    }

    /* renamed from: a */
    public void m6704a() {
        this.f16484i.removeAllViews();
    }

    /* renamed from: a */
    public void m6703a(int i) {
        this.f16484i.setVisibility(0);
        this.f16484i.addView(this.f16486k.inflate(i, (ViewGroup) null), this.f16488m);
    }

    /* renamed from: a */
    public void m6702a(int i, int i2) {
        C2271p.m12866a(this.f16484i);
        C2271p.m12866a(this.f16480e);
        int measuredWidth = this.f16480e.getMeasuredWidth();
        int measuredWidth2 = this.f16484i.getMeasuredWidth();
        this.f16495t.rightMargin = 0;
        this.f16495t.leftMargin = 0;
        if (i != 1 && i != 17) {
            if (i == 3 && i2 == 5) {
                this.f16476a.setGravity(3);
                this.f16484i.setHorizontalGravity(5);
            } else if (i == 5 && i2 == 5) {
                this.f16476a.setGravity(5);
                this.f16484i.setHorizontalGravity(5);
            } else if (i != 3 || i2 != 3) {
            } else {
                this.f16476a.setGravity(3);
                this.f16484i.setHorizontalGravity(3);
            }
        } else if (measuredWidth == 0 && measuredWidth2 == 0) {
            this.f16476a.setGravity(1);
        } else {
            if (i2 == 5) {
                if (measuredWidth2 != 0) {
                    this.f16478c.setPadding((measuredWidth2 / 3) * 2, 0, 0, 0);
                }
                this.f16478c.setGravity(17);
                this.f16484i.setHorizontalGravity(5);
            }
            if (i2 != 17 && i2 != 1) {
                return;
            }
            this.f16476a.setGravity(1);
            this.f16484i.setHorizontalGravity(3);
            this.f16478c.setGravity(17);
            int i3 = measuredWidth - measuredWidth2;
            if (i3 > 0) {
                this.f16495t.rightMargin = i3;
                return;
            }
            this.f16495t.leftMargin = Math.abs(i3);
        }
    }

    /* renamed from: a */
    public void m6701a(int i, int i2, int i3, int i4) {
        this.f16495t.setMargins(i, i2, i3, i4);
    }

    /* renamed from: a */
    public void m6700a(Context context) {
        this.f16494s = (Activity) context;
        setOrientation(1);
        setId(this.f16485j);
        this.f16486k = LayoutInflater.from(context);
        this.f16489n = new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(C2300R.dimen.activity_headtop_margin));
        this.f16488m = new LinearLayout.LayoutParams(-1, -1);
        this.f16490o = new LinearLayout.LayoutParams(-1, -2);
        this.f16491p = new LinearLayout.LayoutParams(-2, -1);
        this.f16492q = new LinearLayout.LayoutParams(-2, -2);
        this.f16492q.gravity = 16;
        this.f16495t = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        this.f16495t.gravity = 16;
        this.f16496u = new LinearLayout.LayoutParams(-2, -2);
        this.f16496u.gravity = 16;
        if (Build.VERSION.SDK_INT >= 19) {
            addView(new View(context), this.f16489n);
        }
        this.f16477b = new LinearLayout(context);
        this.f16477b.setOrientation(0);
        this.f16476a = new LinearLayout(context);
        this.f16476a.setOrientation(1);
        this.f16476a.setGravity(16);
        this.f16476a.setPadding(0, 0, 0, 0);
        this.f16478c = new Button(context);
        this.f16478c.setTextColor(Color.rgb(255, 255, 255));
        this.f16478c.setTextSize(16.0f);
        this.f16478c.setPadding(5, 0, 5, 0);
        this.f16478c.setGravity(16);
        this.f16478c.setBackgroundDrawable(null);
        this.f16478c.setSingleLine();
        this.f16476a.addView(this.f16478c, new LinearLayout.LayoutParams(-2, -2, 1.0f));
        this.f16479d = new Button(context);
        this.f16479d.setTextColor(Color.rgb(255, 255, 255));
        this.f16479d.setTextSize(15.0f);
        this.f16479d.setPadding(6, 0, 5, 0);
        this.f16479d.setGravity(16);
        this.f16479d.setBackgroundDrawable(null);
        this.f16479d.setSingleLine();
        this.f16476a.addView(this.f16479d, new LinearLayout.LayoutParams(-2, 0));
        this.f16480e = new ImageView(context);
        this.f16480e.setVisibility(8);
        this.f16483h = new ImageView(context);
        this.f16483h.setVisibility(8);
        this.f16481f = new ImageView(context);
        this.f16481f.setVisibility(8);
        this.f16482g = new SimpleDraweeView(context);
        this.f16482g.setHierarchy(new GenericDraweeHierarchyBuilder(getResources()).setPlaceholderImage(getResources().getDrawable(C2300R.C2301drawable.defaultavatar)).setFailureImage(getResources().getDrawable(C2300R.C2301drawable.defaultavatar)).setRoundingParams(RoundingParams.asCircle()).build());
        this.f16482g.setVisibility(8);
        this.f16477b.addView(this.f16480e, this.f16492q);
        this.f16477b.addView(this.f16482g, this.f16492q);
        this.f16477b.addView(this.f16483h, this.f16492q);
        this.f16477b.addView(this.f16481f, this.f16492q);
        this.f16477b.addView(this.f16476a, this.f16495t);
        this.f16484i = new LinearLayout(context);
        this.f16484i.setOrientation(0);
        this.f16484i.setGravity(5);
        this.f16484i.setPadding(0, 0, 0, 0);
        this.f16484i.setHorizontalGravity(5);
        this.f16484i.setGravity(16);
        this.f16484i.setVisibility(8);
        this.f16477b.addView(this.f16484i, this.f16496u);
        addView(this.f16477b, this.f16490o);
    }

    /* renamed from: a */
    public void m6699a(Bitmap bitmap, int i, int i2) {
        this.f16492q.leftMargin = 10;
        this.f16480e.setVisibility(0);
        this.f16480e.setImageBitmap(bitmap);
        this.f16480e.getLayoutParams().height = i;
        this.f16480e.getLayoutParams().width = i2;
    }

    /* renamed from: a */
    public void m6698a(View view) {
        this.f16488m.rightMargin = 20;
        this.f16484i.setVisibility(0);
        this.f16484i.addView(view, this.f16488m);
    }

    /* renamed from: a */
    public void m6696a(View view, View view2, boolean z) {
        C2271p.m12866a(view2);
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = (getMeasuredHeight() - view.getMeasuredHeight()) / 2;
        if (view2.getMeasuredWidth() > view.getMeasuredWidth()) {
            measuredWidth = view2.getMeasuredWidth();
        }
        if (z) {
            this.f16497v = new PopupWindow(view2, measuredWidth + 10, -2, true);
        } else {
            this.f16497v = new PopupWindow(view2, -1, -2, true);
        }
        this.f16497v.setFocusable(true);
        this.f16497v.setOutsideTouchable(true);
        this.f16497v.setBackgroundDrawable(new ColorDrawable(AsyncImageView.f21295a));
        this.f16497v.showAsDropDown(view, 0, measuredHeight + 2);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m6695a(List<FmMenuItem> list, final AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = this.f16486k.inflate(C2300R.layout.list_pop, (ViewGroup) null);
        this.f16493r = m6697a(inflate, C2300R.anim.push_up_in, C2300R.anim.push_up_out, C2300R.anim.push_up_in, C2300R.anim.push_up_out, 48, this.f16487l);
        ListView listView = (ListView) inflate.findViewById(C2300R.C2302id.pop_list);
        inflate.findViewById(C2300R.C2302id.title_bar).setBackgroundColor(this.f16487l);
        inflate.findViewById(C2300R.C2302id.close).setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.titlebar.FmTitleBar.1
            @Override // android.view.View.OnClickListener
            @SuppressLint({"NewApi"})
            public void onClick(View view) {
                FmTitleBar.this.f16493r.dismiss();
            }
        });
        listView.setAdapter((ListAdapter) new C2329e(this.f16494s, list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.fimi.soul.view.titlebar.FmTitleBar.2
            @Override // android.widget.AdapterView.OnItemClickListener
            @SuppressLint({"NewApi"})
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                FmTitleBar.this.f16493r.dismiss();
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
        });
    }

    /* renamed from: b */
    public SimpleDraweeView m6693b(int i, int i2) {
        this.f16492q.leftMargin = 15;
        this.f16492q.topMargin = 5;
        this.f16482g.setVisibility(0);
        this.f16482g.getLayoutParams().height = i2;
        this.f16482g.getLayoutParams().width = i;
        return this.f16482g;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m6694b() {
        if (this.f16493r == null || !this.f16493r.isVisible()) {
            return;
        }
        this.f16493r.dismiss();
    }

    /* renamed from: b */
    public void m6692b(Bitmap bitmap, int i, int i2) {
        this.f16492q.leftMargin = 15;
        this.f16492q.topMargin = 5;
        this.f16482g.setVisibility(0);
        this.f16482g.setImageBitmap(bitmap);
        this.f16482g.getLayoutParams().height = i;
        this.f16482g.getLayoutParams().width = i2;
    }

    /* renamed from: b */
    public void m6691b(View view) {
        this.f16492q.leftMargin = 10;
        this.f16477b.addView(view, this.f16492q);
    }

    /* renamed from: c */
    public void m6690c() {
        if (this.f16497v != null) {
            this.f16497v.dismiss();
        }
    }

    public ImageView getLogoView() {
        return this.f16480e;
    }

    public ImageView getLogoView2() {
        return this.f16481f;
    }

    public LinearLayout getRightLayout() {
        return this.f16484i;
    }

    public Button getTitleSmallTextButton() {
        return this.f16479d;
    }

    public Button getTitleTextButton() {
        return this.f16478c;
    }

    public LinearLayout getTitleTextLayout() {
        return this.f16476a;
    }

    public void setChildViewFillParent(boolean z) {
        if (z) {
            this.f16495t = new LinearLayout.LayoutParams(-2, -2, 1.0f);
            this.f16495t.gravity = 16;
            this.f16476a.setLayoutParams(this.f16495t);
            this.f16496u = new LinearLayout.LayoutParams(-2, -2);
            this.f16496u.gravity = 16;
            this.f16484i.setLayoutParams(this.f16496u);
            return;
        }
        this.f16495t = new LinearLayout.LayoutParams(-2, -2);
        this.f16495t.gravity = 16;
        this.f16476a.setLayoutParams(this.f16495t);
        this.f16496u = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        this.f16496u.gravity = 16;
        this.f16484i.setLayoutParams(this.f16496u);
    }

    public void setLogo(int i) {
        this.f16480e.setVisibility(0);
        this.f16480e.setBackgroundResource(i);
    }

    public void setLogo(Drawable drawable) {
        this.f16480e.setVisibility(0);
        this.f16480e.setBackgroundDrawable(drawable);
    }

    public void setLogo2(int i) {
        this.f16481f.setVisibility(0);
        this.f16481f.setBackgroundResource(i);
    }

    public void setLogo2(Drawable drawable) {
        this.f16481f.setVisibility(0);
        this.f16481f.setBackgroundDrawable(drawable);
    }

    public void setLogo2OnClickListener(View.OnClickListener onClickListener) {
        this.f16481f.setOnClickListener(onClickListener);
    }

    public void setLogo3(int i) {
        this.f16482g.setVisibility(0);
        this.f16482g.setBackgroundResource(i);
    }

    public void setLogo3(Drawable drawable) {
        this.f16482g.setVisibility(0);
        this.f16482g.setBackgroundDrawable(drawable);
    }

    public void setLogo3OnClickListener(View.OnClickListener onClickListener) {
        this.f16482g.setOnClickListener(onClickListener);
    }

    public void setLogoLine(int i) {
        this.f16483h.setVisibility(0);
        this.f16483h.setBackgroundResource(i);
    }

    public void setLogoLine(Drawable drawable) {
        this.f16483h.setVisibility(0);
        this.f16483h.setBackgroundDrawable(drawable);
    }

    public void setLogoOnClickListener(View.OnClickListener onClickListener) {
        this.f16480e.setOnClickListener(onClickListener);
    }

    public void setTitleBarBackground(int i) {
        setBackgroundResource(i);
    }

    public void setTitleBarBackgroundColor(int i) {
        this.f16487l = i;
        setBackgroundColor(i);
        ((BaseFimiActivity) this.f16494s).setStatusBarTintResource(i);
    }

    public void setTitleBarBackgroundDrawable(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setTitleBarLeftBackground(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f16478c.setCompoundDrawables(drawable, null, null, null);
    }

    public void setTitleColor(int i) {
        this.f16478c.setTextColor(i);
    }

    public void setTitleSmallText(int i) {
        this.f16479d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f16479d.setText(i);
    }

    public void setTitleSmallText(String str) {
        if (C2269n.m12889b(str)) {
            this.f16479d.setLayoutParams(new LinearLayout.LayoutParams(-2, 0));
            this.f16479d.setText("");
            return;
        }
        this.f16479d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f16479d.setText(str);
    }

    public void setTitleText(int i) {
        this.f16478c.setText(i);
    }

    public void setTitleText(String str) {
        this.f16478c.setText(str);
    }

    public void setTitleTextBackgroundDrawable(Drawable drawable) {
        this.f16478c.setBackgroundDrawable(drawable);
    }

    public void setTitleTextBackgroundResource(int i) {
        this.f16478c.setBackgroundResource(i);
    }

    public void setTitleTextBold(boolean z) {
        TextPaint paint = this.f16478c.getPaint();
        if (z) {
            paint.setFakeBoldText(true);
        } else {
            paint.setFakeBoldText(false);
        }
    }

    public void setTitleTextDropDown(final View view) {
        if (view == null) {
            return;
        }
        setTitleTextOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.titlebar.FmTitleBar.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FmTitleBar.this.m6696a((View) FmTitleBar.this.f16478c, view, true);
            }
        });
    }

    public void setTitleTextOnClickListener(View.OnClickListener onClickListener) {
        this.f16478c.setOnClickListener(onClickListener);
    }

    public void setTitleTextSize(int i) {
        this.f16478c.setTextSize(i);
    }
}
