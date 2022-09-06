package com.fimi.soul.module.flyplannermedia;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2387e;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
/* loaded from: classes.dex */
public class DroneMediaTestActivity extends BaseActivity implements AbstractC2388f<X11RespCmd> {

    /* renamed from: a */
    C2423d f12888a;

    /* renamed from: b */
    long f12889b = 0;

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        Log.d("Good", x11RespCmd.getErrorMsg());
        switch (x11RespCmd.getMsg_id()) {
            case 257:
                this.f12888a.m12232v().m12263d();
                return;
            case C2427e.f8190T /* 1283 */:
                getViewManager().mo12682a("切换目录成功！");
                this.f12888a.m12232v().m12259f();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Button button = new Button(this);
        button.setText("获取IDR");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.flyplannermedia.DroneMediaTestActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d("Good", "开始获取IDR");
                DroneMediaTestActivity.this.f12889b = System.currentTimeMillis();
                if (DroneMediaTestActivity.this.f12888a.l().getCurDirFileList() != null) {
                }
            }
        });
        setContentView(button);
        this.f12888a = (C2423d) C2379b.m12410a().m12394d();
        this.f12888a.a(new AbstractC2387e() { // from class: com.fimi.soul.module.flyplannermedia.DroneMediaTestActivity.2
            @Override // com.fimi.soul.biz.camera.p172b.AbstractC2387e
            /* renamed from: a */
            public void mo8717a(String str, String str2) {
                String str3 = "花费:" + (System.currentTimeMillis() - DroneMediaTestActivity.this.f12889b) + "毫秒";
                Log.d("Good", str3);
                DroneMediaTestActivity.this.getViewManager().mo12682a(str3);
            }
        });
        if (!this.f12888a.e()) {
            this.f12888a.m12231w().m12240b();
        }
        this.f12888a.a(this);
        this.f12888a.c(new AbstractC2221d() { // from class: com.fimi.soul.module.flyplannermedia.DroneMediaTestActivity.3
            @Override // com.fimi.kernel.p157b.p160c.AbstractC2221d
            /* renamed from: a */
            public void mo6431a(String str) {
                Log.d("Good", str + "");
            }
        });
    }
}
