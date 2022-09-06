package com.fimi.soul.module.flyplannermedia;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.entity.DeviceType;
import com.fimi.soul.utils.C3658ar;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class DroneMediaTabActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: p */
    private static final int f12867p = 0;

    /* renamed from: q */
    private static final int f12868q = 5000;

    /* renamed from: r */
    private static final String f12869r = "DroneMediaTabActivity";

    /* renamed from: a */
    private DroneOnlineFragment f12870a;

    /* renamed from: b */
    private DroneLocalFragment f12871b;

    /* renamed from: d */
    private RelativeLayout f12873d;

    /* renamed from: e */
    private RelativeLayout f12874e;

    /* renamed from: f */
    private ImageView f12875f;

    /* renamed from: g */
    private ImageView f12876g;

    /* renamed from: h */
    private TextView f12877h;

    /* renamed from: i */
    private TextView f12878i;

    /* renamed from: j */
    private View f12879j;

    /* renamed from: k */
    private View f12880k;

    /* renamed from: l */
    private View f12881l;

    /* renamed from: m */
    private View f12882m;

    /* renamed from: n */
    private ImageButton f12883n;

    /* renamed from: o */
    private TextView f12884o;

    /* renamed from: c */
    private boolean f12872c = false;

    /* renamed from: s */
    private HandlerC3316a f12885s = new HandlerC3316a(this);

    /* renamed from: com.fimi.soul.module.flyplannermedia.DroneMediaTabActivity$a */
    /* loaded from: classes.dex */
    private static final class HandlerC3316a extends Handler {

        /* renamed from: a */
        private final WeakReference<DroneMediaTabActivity> f12887a;

        public HandlerC3316a(DroneMediaTabActivity droneMediaTabActivity) {
            this.f12887a = new WeakReference<>(droneMediaTabActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                DroneMediaTabActivity.m8732b((C2423d) C2379b.m12410a().m12394d());
                sendEmptyMessageDelayed(0, 5000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m8732b(C2423d c2423d) {
        CameraValue.PAGE_CAMERA_MENU_ALBUM = 1;
        if ("menu_album".equals("") || !c2423d.e()) {
            return;
        }
        if (C2277v.m12784a(C2238c.m13131a()).m12742s() != DeviceType.DEVICE_4K && C2110f.m13670a().m13668b() != EnumC2091b.X1BH) {
            return;
        }
        c2423d.m12233u().m12298a("menu_album", C2427e.f8308cE);
    }

    /* renamed from: d */
    private void m8730d() {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        if (!this.f12872c) {
            this.f12877h.setTextColor(getResources().getColor(C2300R.color.drone_tab_gray_color));
            this.f12875f.setVisibility(4);
            this.f12878i.setTextColor(-1);
            this.f12876g.setVisibility(0);
            beginTransaction.replace(C2300R.C2302id.ll_content, this.f12871b);
            beginTransaction.addToBackStack(null);
            beginTransaction.commitAllowingStateLoss();
            return;
        }
        this.f12878i.setTextColor(getResources().getColor(C2300R.color.drone_tab_gray_color));
        this.f12876g.setVisibility(4);
        this.f12877h.setTextColor(-1);
        this.f12875f.setVisibility(0);
        beginTransaction.replace(C2300R.C2302id.ll_content, this.f12870a);
        beginTransaction.addToBackStack(null);
        beginTransaction.commitAllowingStateLoss();
    }

    /* renamed from: a */
    public View m8736a() {
        return this.f12880k;
    }

    /* renamed from: a */
    public void m8734a(boolean z) {
        this.f12882m.setVisibility(z ? 0 : 8);
    }

    /* renamed from: b */
    public View m8733b() {
        return this.f12881l;
    }

    /* renamed from: c */
    public void m8731c() {
        C2423d c2423d = (C2423d) C2379b.m12410a().m12394d();
        CameraValue.PAGE_CAMERA_MENU_ALBUM = 0;
        if ("menu_album".equals("") || !c2423d.e()) {
            return;
        }
        if (C2277v.m12784a(C2238c.m13131a()).m12742s() != DeviceType.DEVICE_4K && C2110f.m13670a().m13668b() != EnumC2091b.X1BH) {
            return;
        }
        c2423d.m12233u().m12298a("menu_album", "off");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 0 || intent == null) {
            return;
        }
        switch (i2) {
            case 1:
                this.f12871b.m8747a(intent);
                return;
            case 2:
                this.f12870a.m8727a(intent);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C2300R.C2302id.local_layout) {
            this.f12872c = false;
        }
        if (view.getId() == C2300R.C2302id.online_layout) {
            this.f12872c = true;
        }
        m8730d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(1001);
        this.f12870a = new DroneOnlineFragment();
        this.f12871b = new DroneLocalFragment();
        setContentView(C2300R.layout.activity_drone_media_tab);
        getWindow().setFlags(128, 128);
        this.f12879j = findViewById(C2300R.C2302id.rl_tab_top);
        this.f12879j.findViewById(C2300R.C2302id.ll_center_tab).setVisibility(0);
        this.f12883n = (ImageButton) this.f12879j.findViewById(C2300R.C2302id.btn_back);
        this.f12880k = findViewById(C2300R.C2302id.ll_actionBottom);
        this.f12880k.setVisibility(8);
        this.f12881l = findViewById(C2300R.C2302id.ll_actionTop);
        this.f12873d = (RelativeLayout) findViewById(C2300R.C2302id.online_layout);
        this.f12874e = (RelativeLayout) findViewById(C2300R.C2302id.local_layout);
        this.f12873d.setOnClickListener(this);
        this.f12874e.setOnClickListener(this);
        this.f12877h = (TextView) findViewById(C2300R.C2302id.tv_online);
        this.f12878i = (TextView) findViewById(C2300R.C2302id.tv_local);
        this.f12884o = (TextView) findViewById(C2300R.C2302id.vedio_empty_tv);
        if (C2110f.m13670a().m13668b() == EnumC2091b.DRONE) {
            this.f12884o.setText(C2300R.C2303string.use_angle_record_moments);
            this.f12877h.setText(C2300R.C2303string.media_aerial_image);
        } else {
            this.f12884o.setText(C2300R.C2303string.cloud_empty_media);
            this.f12877h.setText(C2300R.C2303string.cloud_online_media);
        }
        C3658ar.m7613a(C2238c.m13131a().getResources().getAssets(), (ViewGroup) getWindow().getDecorView());
        this.f12875f = (ImageView) findViewById(C2300R.C2302id.iv_onlineDot);
        this.f12876g = (ImageView) findViewById(C2300R.C2302id.iv_localDot);
        this.f12882m = findViewById(C2300R.C2302id.ll_empty);
        this.f12883n.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneMediaTabActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DroneMediaTabActivity.this.overridePendingTransition(17432576, 17432577);
                DroneMediaTabActivity.this.finish();
            }
        });
        this.f12872c = ((C2423d) C2379b.m12410a().m12394d()).e();
        m8730d();
        this.f12885s.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f12885s.removeCallbacksAndMessages(null);
        m8731c();
        if (this.f12870a != null) {
            this.f12870a.m8699p().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && (m8733b().getVisibility() == 0 || m8736a().getVisibility() == 0)) {
            if (this.f12872c) {
                this.f12870a.m8700o();
            } else {
                this.f12871b.m8739o();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
    }
}
