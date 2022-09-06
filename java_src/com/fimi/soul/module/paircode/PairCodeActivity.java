package com.fimi.soul.module.paircode;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.p195a.C2687ac;
import com.fimi.soul.drone.p203i.C2884ao;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3800f;
/* loaded from: classes.dex */
public class PairCodeActivity extends BaseActivity implements View.OnClickListener, C2678d.AbstractC2680b {

    /* renamed from: a */
    public boolean f13241a = false;

    /* renamed from: b */
    private FragmentManager f13242b;

    /* renamed from: c */
    private PairResultFragment f13243c;

    /* renamed from: d */
    private PairErrorFragment f13244d;

    /* renamed from: e */
    private PairFragment f13245e;

    /* renamed from: f */
    private TextView f13246f;

    /* renamed from: g */
    private ImageView f13247g;

    /* renamed from: h */
    private AbstractC3401a f13248h;

    /* renamed from: b */
    private void m8500b() {
        DialogC3800f.C3801a c3801a = new DialogC3800f.C3801a(this);
        c3801a.m7031a(getString(C2300R.C2303string.exit_dialog_msg));
        c3801a.m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.paircode.PairCodeActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        c3801a.m7024b(getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.paircode.PairCodeActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PairCodeActivity.this.m8499c();
            }
        });
        c3801a.m7035a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8499c() {
        C2687ac c2687ac = new C2687ac();
        c2687ac.m11186a((byte) 9);
        c2687ac.m11184a(C2367d.m12459a().m12438k());
        this.drone.mo11217ab().mo10897a(c2687ac.mo11073b());
    }

    /* renamed from: a */
    public void m8504a() {
        this.f13242b.beginTransaction().replace(C2300R.C2302id.pair_context, this.f13245e).commit();
    }

    /* renamed from: a */
    public void m8502a(AbstractC3401a abstractC3401a) {
        this.f13248h = abstractC3401a;
    }

    /* renamed from: a */
    public void m8501a(boolean z) {
        this.f13241a = z;
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f13243c == null || !this.f13241a || !this.drone.mo11217ab().mo10898a()) {
            super.onBackPressed();
        } else {
            m8500b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.pair_back_btn /* 2131493752 */:
                if (this.f13243c == null || !this.f13241a || !this.drone.mo11217ab().mo10898a()) {
                    finish();
                    return;
                } else {
                    m8500b();
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.paircode_layout);
        this.f13246f = (TextView) findViewById(C2300R.C2302id.pair_title);
        this.f13247g = (ImageView) findViewById(C2300R.C2302id.pair_back_btn);
        this.f13247g.setOnClickListener(this);
        C3658ar.m7612a(getAssets(), this.f13246f, this.f13247g);
        this.f13242b = getFragmentManager();
        this.f13243c = new PairResultFragment();
        this.f13245e = new PairFragment();
        this.f13244d = new PairErrorFragment();
        this.f13242b.beginTransaction().replace(C2300R.C2302id.pair_context, this.f13245e).commit();
        getWindow().addFlags(128);
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        super.onDroneEvent(enumC2679a, c2657a);
        switch (enumC2679a) {
            case PAIR_CODE:
                C2884ao m11298e = c2657a.m11298e();
                byte m10515c = m11298e.m10515c();
                if (m11298e.m10513d() != 9) {
                    this.f13242b.beginTransaction().replace(C2300R.C2302id.pair_context, this.f13243c).commit();
                } else if (m10515c == 2) {
                    finish();
                } else if (m10515c == 3) {
                    C2284z.m12695a(this, getString(C2300R.C2303string.pair_fail));
                    this.f13241a = false;
                    finish();
                    return;
                }
                if (this.f13248h == null) {
                    return;
                }
                this.f13248h.mo8491a(m10515c, m11298e.m10511e());
                return;
            case CLEANALLOBJ:
                if (this.f13241a) {
                    this.f13242b.beginTransaction().replace(C2300R.C2302id.pair_context, this.f13244d).commit();
                    this.f13241a = false;
                    return;
                } else if (this.f13248h == null) {
                    return;
                } else {
                    this.f13248h.mo8492a(2);
                    this.f13241a = false;
                    return;
                }
            case CONNECTSUCESS:
                if (this.f13248h == null) {
                    return;
                }
                this.f13248h.mo8492a(16);
                return;
            default:
                return;
        }
    }
}
