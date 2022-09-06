package com.fimi.x1bh.module.arrowkey;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p148e.p149a.C2124c;
import com.fimi.p148e.p150b.C2131a;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
import com.fimi.x1bh.module.X1bhBaseActivity;
import com.fimi.x1bh.module.arrowkey.C3900b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ArrowKeyActivity extends X1bhBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, C3900b.AbstractC3902a {

    /* renamed from: h */
    private static final int f16587h = 1;

    /* renamed from: j */
    private static final String f16588j = "ArrowKeyActivity";

    /* renamed from: b */
    private Button f16590b;

    /* renamed from: c */
    private TextView f16591c;

    /* renamed from: d */
    private ListView f16592d;

    /* renamed from: e */
    private C3900b f16593e;

    /* renamed from: f */
    private List<C3899a> f16594f;

    /* renamed from: g */
    private C2124c f16595g;

    /* renamed from: i */
    private boolean f16596i = false;

    /* renamed from: a */
    Handler f16589a = new Handler() { // from class: com.fimi.x1bh.module.arrowkey.ArrowKeyActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = true;
            super.handleMessage(message);
            if (message.what != 3) {
                if (message.what != 1) {
                    return;
                }
                ArrowKeyActivity.this.m6626a();
                Log.d(ArrowKeyActivity.f16588j, "handleMessage: isGetSuccess:" + ArrowKeyActivity.this.f16596i);
                if (ArrowKeyActivity.this.f16596i) {
                    return;
                }
                ArrowKeyActivity.this.f16589a.sendEmptyMessageDelayed(1, 400L);
                return;
            }
            ArrowKeyActivity.this.f16596i = true;
            ArrowKeyActivity.this.f16595g = (C2124c) message.obj;
            Log.d(ArrowKeyActivity.f16588j, "handleMessage: s:" + ArrowKeyActivity.this.f16595g.toString());
            switch (ArrowKeyActivity.this.f16595g.m13567q()) {
                case 1:
                case 2:
                case 3:
                case 4:
                default:
                    Log.d(ArrowKeyActivity.f16588j, "handleMessage: bit1:" + (ArrowKeyActivity.this.f16595g.m13573n() == 1) + ",bit2:" + (ArrowKeyActivity.this.f16595g.m13575m() == 1));
                    ((C3899a) ArrowKeyActivity.this.f16594f.get(C3900b.EnumC3903b.VERTIAL_OPERATION.ordinal())).m6613a(ArrowKeyActivity.this.f16595g.m13573n() == 1);
                    C3899a c3899a = (C3899a) ArrowKeyActivity.this.f16594f.get(C3900b.EnumC3903b.HORZONTAL_OPERATION.ordinal());
                    if (ArrowKeyActivity.this.f16595g.m13575m() != 1) {
                        z = false;
                    }
                    c3899a.m6613a(z);
                    ArrowKeyActivity.this.f16593e.notifyDataSetChanged();
                    return;
            }
        }
    };

    /* renamed from: b */
    private void m6621b() {
        this.f16590b = (Button) findViewById(C2300R.C2302id.black_btn);
        this.f16591c = (TextView) findViewById(C2300R.C2302id.tv_settingTitle);
        this.f16592d = (ListView) findViewById(C2300R.C2302id.setting_lv);
        this.f16590b.setOnClickListener(this);
        this.f16591c.setText(C2300R.C2303string.cloud_setting_arrow_key_set);
        C3658ar.m7612a(getAssets(), this.f16591c);
    }

    /* renamed from: c */
    private void m6619c() {
        C3900b.EnumC3903b[] values;
        this.f16593e = new C3900b(this);
        this.f16593e.m6610a(this);
        this.f16594f = new ArrayList();
        for (C3900b.EnumC3903b enumC3903b : C3900b.EnumC3903b.values()) {
            C3899a c3899a = new C3899a();
            c3899a.m6613a(false);
            c3899a.m6614a(enumC3903b);
            this.f16594f.add(c3899a);
        }
        this.f16593e.m6606a(this.f16594f);
        this.f16592d.setAdapter((ListAdapter) this.f16593e);
        this.f16592d.setOnItemClickListener(this);
    }

    /* renamed from: a */
    public void m6626a() {
        C2131a c2131a = new C2131a();
        c2131a.c(2);
        c2131a.d(1);
        c2131a.a(0);
        c2131a.b(25);
        c2131a.m13534h((byte) 1);
        a(c2131a.mo13473g().m13703f());
    }

    /* renamed from: a */
    public void m6625a(byte b, byte b2) {
        if (this.f16595g == null) {
            return;
        }
        C2131a c2131a = new C2131a();
        c2131a.c(2);
        c2131a.d(1);
        c2131a.a(0);
        c2131a.b(25);
        c2131a.m13534h((byte) 2);
        c2131a.m13532i(this.f16595g.m13567q());
        c2131a.m13530j(this.f16595g.m13565r());
        c2131a.m13528k(this.f16595g.m13564s());
        c2131a.m13526l(this.f16595g.m13563t());
        c2131a.m13524m(this.f16595g.m13562u());
        c2131a.m13522n(this.f16595g.m13561v());
        c2131a.m13520o(this.f16595g.m13560w());
        c2131a.m13518p(this.f16595g.m13559x());
        c2131a.m13538e(b);
        c2131a.m13537f(b2);
        c2131a.m13516q(c2131a.m13533i());
        a(c2131a.mo13473g().m13703f());
    }

    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.p147d.AbstractC2119b
    /* renamed from: a */
    public void mo6481a(int i, C2104c c2104c) {
        AbstractC2103b m13702g = c2104c.m13702g();
        if (i != 65) {
            Log.d(f16588j, "onDataCallBack: cmd:" + i);
        }
        switch (i) {
            case 25:
                C2124c c2124c = (C2124c) m13702g;
                c2124c.m13569p();
                this.f16589a.obtainMessage(3, c2124c).sendToTarget();
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.x1bh.module.arrowkey.C3900b.AbstractC3902a
    /* renamed from: a */
    public void mo6605a(C3900b.EnumC3903b enumC3903b) {
        byte b = 0;
        if (C3900b.EnumC3903b.HORZONTAL_OPERATION == enumC3903b) {
            byte b2 = this.f16594f.get(C3900b.EnumC3903b.VERTIAL_OPERATION.ordinal()).m6611c() ? (byte) 1 : (byte) 0;
            if (!this.f16594f.get(C3900b.EnumC3903b.HORZONTAL_OPERATION.ordinal()).m6611c()) {
                b = 1;
            }
            m6625a(b, b2);
        } else if (C3900b.EnumC3903b.VERTIAL_OPERATION != enumC3903b) {
        } else {
            byte b3 = this.f16594f.get(C3900b.EnumC3903b.HORZONTAL_OPERATION.ordinal()).m6611c() ? (byte) 1 : (byte) 0;
            if (!this.f16594f.get(C3900b.EnumC3903b.VERTIAL_OPERATION.ordinal()).m6611c()) {
                b = 1;
            }
            m6625a(b3, b);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C2300R.C2302id.black_btn) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.x1bh.module.X1bhBaseActivity, com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_arrow_key);
        Log.d(f16588j, "onCreate: ");
        m6621b();
        m6619c();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        byte b = 0;
        C3900b.EnumC3903b m6612b = this.f16594f.get(i).m6612b();
        if (m6612b == C3900b.EnumC3903b.HORZONTAL_OPERATION) {
            byte b2 = this.f16594f.get(C3900b.EnumC3903b.VERTIAL_OPERATION.ordinal()).m6611c() ? (byte) 1 : (byte) 0;
            if (!this.f16594f.get(C3900b.EnumC3903b.HORZONTAL_OPERATION.ordinal()).m6611c()) {
                b = 1;
            }
            m6625a(b, b2);
        } else if (m6612b != C3900b.EnumC3903b.VERTIAL_OPERATION) {
        } else {
            byte b3 = this.f16594f.get(C3900b.EnumC3903b.HORZONTAL_OPERATION.ordinal()).m6611c() ? (byte) 1 : (byte) 0;
            if (!this.f16594f.get(C3900b.EnumC3903b.VERTIAL_OPERATION.ordinal()).m6611c()) {
                b = 1;
            }
            m6625a(b3, b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d(f16588j, "onResume: ");
        this.f16589a.sendEmptyMessage(1);
        this.f16596i = false;
    }
}
