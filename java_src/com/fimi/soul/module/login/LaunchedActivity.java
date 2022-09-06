package com.fimi.soul.module.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.amap.api.location.AMapLocation;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2281x;
import com.fimi.p139b.AbstractC2089b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2571k;
import com.fimi.soul.biz.p185n.C2613z;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.service.InitAppService;
import com.fimi.soul.utils.C3630aa;
import com.fimi.soul.utils.C3658ar;
import java.io.File;
/* loaded from: classes.dex */
public class LaunchedActivity extends com.fimi.soul.base.BaseActivity implements Handler.Callback {

    /* renamed from: d */
    private static final int f12984d = 2;

    /* renamed from: e */
    private static final int f12985e = 3;

    /* renamed from: b */
    C2277v f12987b;

    /* renamed from: f */
    private Context f12989f;

    /* renamed from: g */
    private C2613z f12990g;

    /* renamed from: h */
    private Handler f12991h;

    /* renamed from: j */
    private TextView f12993j;

    /* renamed from: k */
    private TextView f12994k;

    /* renamed from: c */
    private final int f12988c = 500;

    /* renamed from: i */
    private boolean f12992i = false;

    /* renamed from: a */
    boolean f12986a = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8651a(boolean z) {
        this.f12992i = z;
        Message message = new Message();
        message.obj = Boolean.valueOf(this.f12992i);
        message.what = 2;
        this.f12991h.sendMessageDelayed(message, 500L);
    }

    /* renamed from: b */
    private void m8649b(boolean z) {
        if (this.f12986a) {
            return;
        }
        C3658ar.m7572j(this);
        this.f12986a = true;
        this.f12991h.removeMessages(2);
        this.f12991h.removeMessages(3);
        Intent intent = new Intent(this, LoginActivity.class);
        if (z) {
            intent.putExtra(AbstractC2089b.f6992j, 4);
        } else if (C2238c.m13123e().m12746o() == 0) {
            intent.putExtra(AbstractC2089b.f6992j, 2);
        } else {
            intent.putExtra(AbstractC2089b.f6992j, 3);
        }
        intent.putExtra("islaunchexit", true);
        Bundle bundleExtra = getIntent().getBundleExtra("launchBundle");
        if (bundleExtra != null) {
            Bundle bundle = new Bundle();
            bundle.putString("redirectURL", bundleExtra.getString("redirectURL"));
            bundle.putBoolean("islaunch", true);
            intent.putExtra("launchBundle", bundle);
        }
        startActivity(intent);
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        m8649b(((Boolean) message.obj).booleanValue());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot()) {
            finish();
            return;
        }
        setContentView(C2300R.layout.activity_launch);
        C3630aa.m7737d();
        this.f12987b = C2277v.m12784a(this);
        this.f12987b.m12787a().edit().putBoolean(C2353b.f7920K, false).commit();
        this.f12991h = new Handler(this);
        this.mTintManager.m12733a(true, (Activity) this);
        this.f12989f = this;
        InitAppService.m7829a(this);
        Message message = new Message();
        message.obj = Boolean.valueOf(!this.f12987b.m12787a().contains("isfirstloading"));
        message.what = 3;
        this.f12991h.sendMessageDelayed(message, 2000L);
        this.f12993j = (TextView) findViewById(C2300R.C2302id.launch_center_tv);
        this.f12994k = (TextView) findViewById(C2300R.C2302id.launch_bottom_tv);
        C3658ar.m7612a(getAssets(), this.f12993j, this.f12994k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f12986a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f12986a = false;
        C2281x.m12704a(new Runnable() { // from class: com.fimi.soul.module.login.LaunchedActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (C2241c.m13122a().mo13108d("USER_PROTOCOL")) {
                    C2571k.m11651a(LaunchedActivity.this.f12989f).m11648a(new C2571k.AbstractC2573a() { // from class: com.fimi.soul.module.login.LaunchedActivity.1.1
                        @Override // com.fimi.soul.biz.p185n.C2571k.AbstractC2573a
                        /* renamed from: a */
                        public void mo8600a(AMapLocation aMapLocation) {
                        }
                    });
                    if (C2241c.m13113b()) {
                        LaunchedActivity.this.speakTTs.m13106a();
                    }
                }
                LaunchedActivity.this.f12990g = C2613z.m11525a(LaunchedActivity.this.f12989f);
                if (!LaunchedActivity.this.f12987b.m12787a().contains("isfirstloading")) {
                    LaunchedActivity.this.m8651a(true);
                } else if (C3658ar.m7601b(LaunchedActivity.this)) {
                    LaunchedActivity.this.f12990g.m11524a(LaunchedActivity.this.f12989f, new AbstractC2538k() { // from class: com.fimi.soul.module.login.LaunchedActivity.1.2
                        @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                        /* renamed from: a */
                        public void mo6501a(PlaneMsg planeMsg, File file) {
                            LaunchedActivity.this.m8651a(false);
                        }
                    });
                } else {
                    C2353b.m12508b(LaunchedActivity.this.f12989f);
                    LaunchedActivity.this.m8651a(false);
                }
            }
        });
    }
}
