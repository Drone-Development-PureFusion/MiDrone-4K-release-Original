package com.fimi.soul.biz.camera.p173c;

import android.util.Log;
import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.entity.BaseX11Cmd;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.utils.C3637ag;
/* renamed from: com.fimi.soul.biz.camera.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC2404a implements AbstractC2388f<X11RespCmd> {

    /* renamed from: a */
    private AbstractC2390c f8111a;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC2404a(AbstractC2390c abstractC2390c) {
        this.f8111a = abstractC2390c;
    }

    /* renamed from: a */
    public AbstractC2390c m12324a() {
        return this.f8111a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m12323a(int i) {
        m12322a(i, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m12322a(int i, String str) {
        m12321a(i, str, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m12321a(int i, String str, String str2) {
        BaseX11Cmd baseX11Cmd = new BaseX11Cmd();
        baseX11Cmd.setMsg_id(i);
        baseX11Cmd.setParam(str);
        baseX11Cmd.setType(str2);
        baseX11Cmd.setToken(m12324a().m12344f());
        m12320a(baseX11Cmd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m12320a(BaseX11Cmd baseX11Cmd) {
        String str = C3637ag.m7710a(baseX11Cmd) + "\n";
        Log.i("moweiru", "send cmd: " + str);
        m12324a().mo12362a(str.getBytes());
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m12319a(byte[] bArr, int i, int i2) {
        m12324a().mo12361a(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public BaseX11Cmd m12318b(int i, String str, String str2) {
        BaseX11Cmd baseX11Cmd = new BaseX11Cmd();
        baseX11Cmd.setMsg_id(i);
        baseX11Cmd.setParam(str);
        baseX11Cmd.setType(str2);
        baseX11Cmd.setToken(m12324a().m12344f());
        return baseX11Cmd;
    }
}
