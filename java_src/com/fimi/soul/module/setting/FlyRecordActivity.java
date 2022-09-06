package com.fimi.soul.module.setting;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.FlightTimeInfo;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.FlyLogTools;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class FlyRecordActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: a */
    TextView f13524a;

    /* renamed from: b */
    TextView f13525b;

    /* renamed from: c */
    TextView f13526c;

    /* renamed from: d */
    TextView f13527d;

    /* renamed from: e */
    TextView f13528e;

    /* renamed from: f */
    TextView f13529f;

    /* renamed from: g */
    TextView f13530g;

    /* renamed from: h */
    DroidPlannerApp f13531h;

    /* renamed from: i */
    C2657a f13532i;

    /* renamed from: j */
    ImageView f13533j;

    /* renamed from: k */
    FlyLogTools f13534k;

    /* renamed from: l */
    private final int f13535l = 16;

    /* renamed from: m */
    private Handler f13536m = new Handler() { // from class: com.fimi.soul.module.setting.FlyRecordActivity.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Bundle data = message.getData();
            long j = data.getLong("fly_distance");
            long j2 = data.getLong("flyTime");
            int i = data.getInt("fly_count");
            switch (message.what) {
                case 16:
                    FlyRecordActivity.this.m8448a(i, j2, j);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: com.fimi.soul.module.setting.FlyRecordActivity$a */
    /* loaded from: classes.dex */
    private class C3446a implements AbstractC2538k {
        private C3446a() {
        }

        @Override // com.fimi.soul.biz.p183l.AbstractC2538k
        /* renamed from: a */
        public void mo6501a(PlaneMsg planeMsg, File file) {
            if (!planeMsg.isSuccess()) {
                C2284z.m12695a(FlyRecordActivity.this, FlyRecordActivity.this.getString(C2300R.C2303string.ask_exception));
                return;
            }
            C2238c.m13125c();
            FlightTimeInfo flightTimeInfo = (FlightTimeInfo) planeMsg.getData();
            Message message = new Message();
            Bundle bundle = new Bundle();
            long totalFlyTime = flightTimeInfo.getTotalFlyTime();
            int flyCount = flightTimeInfo.getFlyCount();
            long totalDistance = flightTimeInfo.getTotalDistance();
            bundle.putLong("flyTime", totalFlyTime);
            bundle.putInt("fly_count", flyCount);
            bundle.putLong("fly_distance", totalDistance);
            message.what = 16;
            message.setData(bundle);
            FlyRecordActivity.this.f13536m.sendMessage(message);
        }
    }

    /* renamed from: a */
    void m8448a(int i, long j, long j2) {
        this.f13526c.setText(String.format("%d", Integer.valueOf(i)));
        if (j > 0) {
            j /= 60;
        }
        this.f13525b.setText(String.format("%d", Long.valueOf(j)));
        this.f13524a.setText(String.format("%s", new DecimalFormat("######0.00").format(j2 / 1000.0d).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ".")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.back_btn /* 2131493144 */:
                finish();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.fly_record_layout);
        this.f13527d = (TextView) findViewById(C2300R.C2302id.fly_log_title);
        this.f13524a = (TextView) findViewById(C2300R.C2302id.fly_Killometers);
        this.f13525b = (TextView) findViewById(C2300R.C2302id.fly_long);
        this.f13526c = (TextView) findViewById(C2300R.C2302id.fly_times);
        this.f13528e = (TextView) findViewById(C2300R.C2302id.killo_v);
        this.f13529f = (TextView) findViewById(C2300R.C2302id.fly_min_v);
        this.f13530g = (TextView) findViewById(C2300R.C2302id.fly_count_v);
        this.f13533j = (ImageView) findViewById(C2300R.C2302id.back_btn);
        this.f13533j.setOnClickListener(this);
        C3658ar.m7598b(getAssets(), this.f13524a, this.f13525b, this.f13526c);
        C3658ar.m7612a(getAssets(), this.f13528e, this.f13529f, this.f13530g, this.f13527d);
        getWindow().addFlags(128);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13531h = (DroidPlannerApp) getApplication();
        this.f13532i = this.f13531h.f7895a;
        this.f13534k.m7773a(new FlyLogTools.AbstractC3620a() { // from class: com.fimi.soul.module.setting.FlyRecordActivity.1
            @Override // com.fimi.soul.utils.FlyLogTools.AbstractC3620a
            /* renamed from: a */
            public void mo7772a() {
                FlyRecordActivity.this.f13534k.m7775a(new C3446a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f13534k = FlyLogTools.m7776a(this);
    }
}
