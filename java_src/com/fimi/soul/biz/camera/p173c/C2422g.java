package com.fimi.soul.biz.camera.p173c;

import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11ApWifiConfig;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
/* renamed from: com.fimi.soul.biz.camera.c.g */
/* loaded from: classes.dex */
public class C2422g extends AbstractC2404a {

    /* renamed from: a */
    private X11ApWifiConfig f8161a = null;

    public C2422g(AbstractC2390c abstractC2390c) {
        super(abstractC2390c);
    }

    /* renamed from: a */
    public void m12238a(X11ApWifiConfig x11ApWifiConfig) {
        String format = String.format("AP_SSID=%s\\nLOCAL_IP=%s\\nESSID=%s\\nAP_CHANNEL=%d", x11ApWifiConfig.getApSSID(), x11ApWifiConfig.getApIP(), x11ApWifiConfig.getApESSID(), Integer.valueOf(x11ApWifiConfig.getApChannel()));
        this.f8161a = x11ApWifiConfig;
        a(C2427e.f8196Z, format);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.fimi.soul.biz.camera.p173c.AbstractC2404a, com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        super.mo6450a(z, x11RespCmd);
        switch (x11RespCmd.getMsg_id()) {
            case C2427e.f8196Z /* 1538 */:
                a().m12370a(this.f8161a);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public void m12236b() {
        a(C2427e.f8195Y);
    }

    /* renamed from: b */
    public void m12235b(X11ApWifiConfig x11ApWifiConfig) {
        a(C2427e.f8224aa);
    }
}
