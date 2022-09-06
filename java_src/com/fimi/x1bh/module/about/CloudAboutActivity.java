package com.fimi.x1bh.module.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p148e.p149a.C2125d;
import com.fimi.p154i.C2158a;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p187p.C2619a;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.x1bh.module.X1bhBaseActivity;
/* loaded from: classes.dex */
public class CloudAboutActivity extends X1bhBaseActivity {

    /* renamed from: l */
    private static final int f16566l = 1;

    /* renamed from: m */
    private static final int f16567m = 0;

    /* renamed from: n */
    private static final int f16568n = 1;

    /* renamed from: r */
    private static final int f16569r = 5000;

    /* renamed from: s */
    private static final int f16570s = 153;

    /* renamed from: a */
    private TextView f16571a;

    /* renamed from: b */
    private TextView f16572b;

    /* renamed from: c */
    private TextView f16573c;

    /* renamed from: d */
    private TextView f16574d;

    /* renamed from: e */
    private TextView f16575e;

    /* renamed from: f */
    private TextView f16576f;

    /* renamed from: g */
    private TextView f16577g;

    /* renamed from: h */
    private TextView f16578h;

    /* renamed from: i */
    private Button f16579i;

    /* renamed from: j */
    private Button f16580j;

    /* renamed from: k */
    private C3580b f16581k;

    /* renamed from: o */
    private int f16582o = 0;

    /* renamed from: p */
    private TextView f16583p;

    /* renamed from: q */
    private C2158a f16584q;

    /* renamed from: a */
    private String m6629a(int i) {
        return String.valueOf(i);
    }

    /* renamed from: a */
    private void m6630a() {
        this.f16571a = (TextView) findViewById(C2300R.C2302id.tv_camera);
        this.f16572b = (TextView) findViewById(C2300R.C2302id.tv_gimbal);
        this.f16573c = (TextView) findViewById(C2300R.C2302id.tv_servo);
        this.f16574d = (TextView) findViewById(C2300R.C2302id.tv_handle);
        this.f16575e = (TextView) findViewById(C2300R.C2302id.tv_camera_tip);
        this.f16576f = (TextView) findViewById(C2300R.C2302id.tv_gimbal_tip);
        this.f16577g = (TextView) findViewById(C2300R.C2302id.tv_servo_tip);
        this.f16578h = (TextView) findViewById(C2300R.C2302id.tv_handle_tip);
        this.f16583p = (TextView) findViewById(C2300R.C2302id.aboutVersion);
        C3658ar.m7612a(getAssets(), this.f16583p, this.f16571a, this.f16572b, this.f16573c, this.f16574d, this.f16575e, this.f16576f, this.f16577g, this.f16578h);
    }

    /* renamed from: b */
    private void m6628b() {
        this.f16583p.setText(getString(C2300R.C2303string.about_version, new Object[]{C3658ar.m7589d(this)}));
        m6627c();
        this.f16584q = new C2158a();
        this.f16584q.m13383b();
        getHandler().sendEmptyMessageDelayed(153, 5000L);
        this.f16579i = (Button) findViewById(C2300R.C2302id.scoreBtn);
        this.f16579i.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.x1bh.module.about.CloudAboutActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + CloudAboutActivity.this.getPackageName()));
                intent.addFlags(268435456);
                CloudAboutActivity.this.startActivity(intent);
            }
        });
        this.f16580j = (Button) findViewById(C2300R.C2302id.aboutBtn);
        this.f16580j.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.x1bh.module.about.CloudAboutActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CloudAboutActivity.this.finish();
            }
        });
    }

    /* renamed from: c */
    private void m6627c() {
        C2619a.m11493a();
        this.f16581k = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (this.f16581k != null && this.f16581k.m7955c() > 0) {
            this.f16572b.setText(m6629a(this.f16581k.m7955c()));
        } else if (this.f16582o == 1) {
            this.f16572b.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f16581k != null && this.f16581k.m7945h() > 0) {
            this.f16573c.setText(m6629a(this.f16581k.m7945h()));
        } else if (this.f16582o == 1) {
            this.f16573c.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f16581k != null && this.f16581k.m7933n() > 0) {
            this.f16571a.setText(m6629a(this.f16581k.m7933n()));
        } else if (this.f16582o == 1) {
            this.f16571a.setText(C2300R.C2303string.no_get_versin);
        }
        if (this.f16581k != null && this.f16581k.m7933n() > 0) {
            this.f16574d.setText(m6629a(this.f16581k.m7930p()));
        } else if (this.f16582o != 1) {
        } else {
            this.f16574d.setText(C2300R.C2303string.no_get_versin);
        }
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.p147d.AbstractC2119b
    /* renamed from: a */
    public void mo6481a(int i, C2104c c2104c) {
        super.mo6481a(i, c2104c);
        if (c2104c.m13702g() instanceof C2125d) {
            m6627c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_cloud_about);
        this.dpa.m12523b(this);
        m6630a();
        m6628b();
    }

    @Override // com.fimi.kernel.BaseActivity
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message.what == 153) {
            this.f16582o = 1;
            m6627c();
        }
    }
}
