package com.fimi.soul.module.setting;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.AbstractC2228e;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.p168a.C2355b;
import com.fimi.soul.entity.APConfig;
import com.fimi.soul.module.setting.AbstractC3477a;
/* renamed from: com.fimi.soul.module.setting.c */
/* loaded from: classes.dex */
public class C3481c extends AbstractC3477a {

    /* renamed from: a */
    private EditText f13732a;

    /* renamed from: b */
    private EditText f13733b;

    /* renamed from: c */
    private Button f13734c;

    /* renamed from: d */
    private TextView f13735d;

    /* renamed from: e */
    private TextView f13736e;

    /* renamed from: f */
    private TextView f13737f;

    /* renamed from: g */
    private C2355b f13738g = new C2355b();

    /* renamed from: h */
    private APConfig f13739h;

    /* renamed from: i */
    private String f13740i;

    public C3481c(Context context) {
        super(context);
    }

    /* renamed from: g */
    private void m8317g() {
        this.f13736e = c(f().getString(C2300R.C2303string.version_info), "");
        this.f13735d = c(f().getString(C2300R.C2303string.ip_addr), "");
        this.f13737f = c(f().getString(C2300R.C2303string.country_code), "");
        this.f13732a = b(f().getString(C2300R.C2303string.SSID), "");
        this.f13733b = b(f().getString(C2300R.C2303string.relay_password), "");
        this.f13734c = a("出厂设置", "恢复", new View.OnClickListener() { // from class: com.fimi.soul.module.setting.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C2238c.m13127b().mo12687a();
                C3481c.this.f13738g.m12486e(new AbstractC2228e<Boolean>() { // from class: com.fimi.soul.module.setting.c.1.1
                    @Override // com.fimi.kernel.p157b.AbstractC2228e
                    /* renamed from: a  reason: avoid collision after fix types in other method */
                    public void mo8307a(Boolean bool) {
                        C2238c.m13127b().mo12676c();
                        if (bool.booleanValue()) {
                            C2238c.m13127b().mo12682a("操作成功，中继重启");
                        } else {
                            C2238c.m13127b().mo12682a("操作失败");
                        }
                    }

                    @Override // com.fimi.kernel.p157b.AbstractC2228e
                    /* renamed from: b  reason: avoid collision after fix types in other method */
                    public void mo8305b(Boolean bool) {
                        C2238c.m13127b().mo12676c();
                        C2238c.m13127b().mo12682a("操作失败");
                    }
                });
            }
        });
        AbstractC3477a.C3478a a = a(f().getString(C2300R.C2303string.save), f().getString(C2300R.C2303string.reboot));
        a.m8332a().setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.setting.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C3481c.this.m8315h();
            }
        });
        a.m8330b().setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.setting.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C2238c.m13127b().mo12687a();
                C3481c.this.f13738g.m12487d(new AbstractC2228e<Boolean>() { // from class: com.fimi.soul.module.setting.c.3.1
                    @Override // com.fimi.kernel.p157b.AbstractC2228e
                    /* renamed from: a  reason: avoid collision after fix types in other method */
                    public void mo8307a(Boolean bool) {
                        C2238c.m13127b().mo12676c();
                        C2238c.m13127b().mo12682a("开始重启");
                    }

                    @Override // com.fimi.kernel.p157b.AbstractC2228e
                    /* renamed from: b  reason: avoid collision after fix types in other method */
                    public void mo8305b(Boolean bool) {
                        C2238c.m13127b().mo12676c();
                        C2238c.m13127b().mo12682a("重置失败，请检查是否连接遥控器");
                    }
                });
            }
        });
        this.f13738g.m12496b(new AbstractC2228e<APConfig>() { // from class: com.fimi.soul.module.setting.c.4
            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo8307a(APConfig aPConfig) {
                if (aPConfig != null) {
                    C3481c.this.f13739h = aPConfig;
                    C3481c.this.f13732a.setText(aPConfig.getSsid());
                    C3481c.this.f13733b.setText(aPConfig.getApPwd());
                    C3481c.this.f13735d.setText(aPConfig.getIpAddr());
                    C3481c.this.f13736e.setText(aPConfig.getVersion());
                    C3481c.this.f13737f.setText(aPConfig.getCountryCode());
                }
            }

            @Override // com.fimi.kernel.p157b.AbstractC2228e
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public void mo8305b(APConfig aPConfig) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m8315h() {
        if (this.f13739h != null) {
            this.f13739h.setIpAddr(this.f13735d.getText().toString());
            this.f13739h.setApPwd(this.f13733b.getText().toString());
            this.f13739h.setSsid(this.f13732a.getText().toString());
            C2238c.m13127b().mo12687a();
            this.f13738g.m12502a(this.f13739h, new AbstractC2228e<Boolean>() { // from class: com.fimi.soul.module.setting.c.5
                @Override // com.fimi.kernel.p157b.AbstractC2228e
                /* renamed from: a  reason: avoid collision after fix types in other method */
                public void mo8307a(Boolean bool) {
                    C2238c.m13127b().mo12676c();
                    C2238c.m13127b().mo12682a("设置成功");
                }

                @Override // com.fimi.kernel.p157b.AbstractC2228e
                /* renamed from: b  reason: avoid collision after fix types in other method */
                public void mo8305b(Boolean bool) {
                    C2238c.m13127b().mo12676c();
                    C2238c.m13127b().mo12682a("设置失败，请检查中继网络");
                }
            });
        }
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
    }

    @Override // com.fimi.soul.module.setting.AbstractC3477a
    /* renamed from: c */
    public View mo8322c() {
        m8317g();
        return b();
    }
}
