package com.fimi.soul.biz.camera.p173c;

import android.util.Log;
import com.fimi.kernel.utils.C2269n;
import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11DeviceInfo;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.entity.X11SystemConfig;
import com.fimi.soul.biz.camera.entity.X11SystemConfigOption;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3583e;
import com.google.gson.internal.LinkedTreeMap;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* renamed from: com.fimi.soul.biz.camera.c.c */
/* loaded from: classes.dex */
public class C2410c extends AbstractC2404a {

    /* renamed from: b */
    long f8125b;

    /* renamed from: c */
    private String f8126c;

    /* renamed from: f */
    private String f8129f;

    /* renamed from: g */
    private String f8130g;

    /* renamed from: d */
    private EnumC2414c f8127d = EnumC2414c.Max;

    /* renamed from: e */
    private EnumC2412a f8128e = EnumC2412a.Total;

    /* renamed from: a */
    int f8124a = 0;

    /* renamed from: com.fimi.soul.biz.camera.c.c$a */
    /* loaded from: classes.dex */
    public enum EnumC2412a {
        Total,
        Photo,
        Video
    }

    /* renamed from: com.fimi.soul.biz.camera.c.c$b */
    /* loaded from: classes.dex */
    public enum EnumC2413b {
        PowerStandby,
        PowerOff
    }

    /* renamed from: com.fimi.soul.biz.camera.c.c$c */
    /* loaded from: classes.dex */
    public enum EnumC2414c {
        Max,
        Current,
        Status
    }

    /* renamed from: com.fimi.soul.biz.camera.c.c$d */
    /* loaded from: classes.dex */
    public enum EnumC2415d {
        Jump,
        Fast,
        Normal,
        Slow
    }

    public C2410c(AbstractC2390c abstractC2390c) {
        super(abstractC2390c);
    }

    /* renamed from: a */
    private void m12297a(Map<String, String> map, X11SystemConfig x11SystemConfig) {
        x11SystemConfig.setAe_bias(map.get("ae_bias"));
        x11SystemConfig.setSaturation(map.get(C2427e.f8276bZ));
        x11SystemConfig.setContrast(map.get(C2427e.f8329ca));
        x11SystemConfig.setSharpness(map.get(C2427e.f8330cb));
        x11SystemConfig.setAwb(map.get(C2427e.f8331cc));
        x11SystemConfig.setSystemType(map.get(C2427e.f8273bW));
        x11SystemConfig.setCameraTimeLock(map.get(C2427e.f8252bB));
        x11SystemConfig.setVideoStandard(map.get(C2427e.f8255bE));
        x11SystemConfig.setAppStatus(map.get(C2427e.f8256bF));
        x11SystemConfig.setStreamOutType(map.get(C2427e.f8257bG));
        x11SystemConfig.setSaveLowResolution(m12286f(map.get(C2427e.f8258bH)));
        x11SystemConfig.setVideoResolution(map.get(C2427e.f8259bI));
        x11SystemConfig.setVideoQuality(map.get(C2427e.f8261bK));
        x11SystemConfig.setTimelapseVideo(m12286f(map.get(C2427e.f8262bL)));
        x11SystemConfig.setCaptureMode(map.get(C2427e.f8263bM));
        x11SystemConfig.setPhotoSize(map.get(C2427e.f8264bN));
        x11SystemConfig.setPhotoStamp(map.get(C2427e.f8265bO));
        x11SystemConfig.setPhotoQuality(map.get(C2427e.f8266bP));
        x11SystemConfig.setTimelapsePhoto(m12286f(map.get(C2427e.f8267bQ)));
        x11SystemConfig.setVideoStamp(map.get(C2427e.f8260bJ));
        x11SystemConfig.setVideoSrt(map.get(C2427e.f8268bR));
        x11SystemConfig.setVideoLoopBack(map.get(C2427e.f8269bS));
        x11SystemConfig.setVideoMode(map.get(C2427e.f8270bT));
        x11SystemConfig.setSDState(map.get(C2427e.f8271bU));
        x11SystemConfig.setImage_format(map.get(C2427e.f8272bV));
        x11SystemConfig.setRavl(Integer.parseInt(map.get(C2427e.f8253bC)));
        x11SystemConfig.setCur_time(Long.parseLong(map.get(C2427e.f8254bD)));
    }

    /* renamed from: f */
    private boolean m12286f(String str) {
        return C2427e.f8308cE.equals(str);
    }

    /* renamed from: a */
    public void m12304a(EnumC2412a enumC2412a) {
        String str;
        this.f8128e = enumC2412a;
        switch (enumC2412a) {
            case Total:
                str = "total";
                break;
            case Photo:
                str = C2427e.f8311cH;
                break;
            case Video:
                str = "video";
                break;
            default:
                str = null;
                break;
        }
        a(6, (String) null, str);
    }

    /* renamed from: a */
    public void m12303a(EnumC2413b enumC2413b) {
        String str = null;
        switch (enumC2413b) {
            case PowerStandby:
                str = "cam_stb";
                break;
            case PowerOff:
                str = "cam_off";
                break;
        }
        a(12, str);
    }

    /* renamed from: a */
    public void m12302a(EnumC2414c enumC2414c) {
        String str;
        this.f8127d = enumC2414c;
        switch (enumC2414c) {
            case Max:
                str = "max";
                break;
            case Current:
                str = "current";
                break;
            case Status:
                str = "status";
                break;
            default:
                str = null;
                break;
        }
        a(15, (String) null, str);
    }

    /* renamed from: a */
    public void m12301a(EnumC2415d enumC2415d, int i) {
        String str = null;
        switch (enumC2415d) {
            case Jump:
                str = "jump";
                break;
            case Fast:
                str = "fast";
                break;
            case Normal:
                str = "normal";
                break;
            case Slow:
                str = "slow";
                break;
        }
        a(14, i + "", str);
    }

    /* renamed from: a */
    public void m12300a(String str) {
        a(1, (String) null, str);
    }

    /* renamed from: a */
    public void m12298a(String str, String str2) {
        this.f8129f = str;
        this.f8130g = str2;
        a(2, str2, str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.fimi.soul.biz.camera.p173c.AbstractC2404a, com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        super.mo6450a(z, x11RespCmd);
        if (z) {
            X11SystemConfig m12339j = a().m12339j();
            switch (x11RespCmd.getMsg_id()) {
                case 2:
                    if (C2427e.f8263bM.equals(this.f8129f)) {
                        m12339j.setCaptureMode(this.f8130g);
                    }
                    long cur_time = m12339j.getCur_time();
                    if ((m12339j.getRavl() == 0 && Math.abs(cur_time - this.f8125b) <= 5000) || this.f8124a >= 3) {
                        return;
                    }
                    m12279m();
                    this.f8124a++;
                    return;
                case 3:
                    if (x11RespCmd.getParam() == null) {
                        return;
                    }
                    try {
                        Map<String, String> hashMap = new HashMap<>();
                        for (LinkedTreeMap linkedTreeMap : (List) x11RespCmd.getParam()) {
                            for (String str : linkedTreeMap.keySet()) {
                                hashMap.put(str, linkedTreeMap.get(str));
                            }
                        }
                        m12297a(hashMap, m12339j);
                        if (C2427e.f8310cG.contains(m12339j.getAppStatus())) {
                            a().m12381a(AbstractC2390c.EnumC2400a.Recoding);
                        }
                        if (C2427e.f8311cH.contains(m12339j.getAppStatus())) {
                            a().m12381a(AbstractC2390c.EnumC2400a.ContinueCapturing);
                        }
                        if (C2427e.f8309cF.contains(m12339j.getAppStatus())) {
                            a().m12381a(AbstractC2390c.EnumC2400a.IDLE);
                        }
                        if (!C2427e.f8312cI.contains(m12339j.getAppStatus())) {
                            return;
                        }
                        a().m12381a(AbstractC2390c.EnumC2400a.Normal);
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 5:
                    try {
                        long parseLong = Long.parseLong(x11RespCmd.getParam().toString());
                        if (C2427e.f8324cU.equals(this.f8126c)) {
                            m12339j.setFreeKBSpace(parseLong);
                        }
                        if (!C2427e.f8325cV.equals(this.f8126c)) {
                            return;
                        }
                        m12339j.setTotalKBSpace(parseLong);
                        m12290d(C2427e.f8324cU);
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                case 6:
                    int parseInt = Integer.parseInt(x11RespCmd.getParam().toString());
                    switch (this.f8128e) {
                        case Total:
                            m12339j.setTotalFileNumbers(parseInt);
                            return;
                        case Photo:
                            m12339j.setPhotoFileNumbers(parseInt);
                            return;
                        case Video:
                            m12339j.setVideoFileNumbers(parseInt);
                            return;
                        default:
                            return;
                    }
                case 9:
                    if (x11RespCmd.getParam() == null) {
                        return;
                    }
                    String obj = x11RespCmd.getParam().toString();
                    X11SystemConfigOption x11SystemConfigOption = new X11SystemConfigOption();
                    x11SystemConfigOption.setType(obj);
                    x11SystemConfigOption.setPermission(x11RespCmd.getPermission());
                    x11SystemConfigOption.setOptions(x11RespCmd.getOptions());
                    m12339j.getSystemConfigOptions().put(obj, x11SystemConfigOption);
                    return;
                case 11:
                    X11DeviceInfo x11DeviceInfo = m12339j.getX11DeviceInfo();
                    x11DeviceInfo.setBrand(x11RespCmd.getBrand());
                    x11DeviceInfo.setApiVersion(x11RespCmd.getApi_ver());
                    x11DeviceInfo.setModel(x11RespCmd.getModel());
                    x11DeviceInfo.setFirmwareVersion(x11RespCmd.getFw_ver());
                    x11DeviceInfo.setAppType(x11RespCmd.getApp_type());
                    x11DeviceInfo.setLogo(x11RespCmd.getLogo());
                    x11DeviceInfo.setChip(x11RespCmd.getChip());
                    x11DeviceInfo.setHttp(x11RespCmd.getHttp());
                    m12281k();
                    return;
                case 13:
                    m12339j.setBatteryLevel(Integer.parseInt(x11RespCmd.getParam().toString()));
                    m12339j.setPowerSourceType(x11RespCmd.getType());
                    return;
                case 15:
                    int parseInt2 = Integer.parseInt(x11RespCmd.getParam().toString());
                    switch (this.f8127d) {
                        case Max:
                            m12339j.setMaxZoomInfo(parseInt2);
                            return;
                        case Current:
                            m12339j.setCurrentZoomInfo(parseInt2);
                            return;
                        default:
                            return;
                    }
                case 18:
                    C3579a.m7971a().m7969a(13, C2269n.m12875n(x11RespCmd.getParam().toString()));
                    C3579a.m7971a().m7968a(new C3583e("", 13, C2269n.m12875n(x11RespCmd.getParam().toString())));
                    Log.d("moweiru", "resp.getParam().toString():" + x11RespCmd.getParam().toString());
                    m12339j.setDvVersion(C2269n.m12875n(x11RespCmd.getParam().toString()) + "");
                    m12289e();
                    return;
                case 19:
                    String[] split = x11RespCmd.getParam().toString().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int parseInt3 = Integer.parseInt(split[0]);
                    int parseInt4 = Integer.parseInt(split[1]);
                    m12339j.setRemainVideoRecordMinutes(parseInt3);
                    m12339j.setRemainPhotoTakeNumbers(parseInt4);
                    return;
                case C2427e.f8176F /* 259 */:
                    this.f8124a = 0;
                    m12279m();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: b */
    public void m12296b() {
        a(3);
    }

    /* renamed from: b */
    public void m12295b(int i) {
        a(16, i + "");
    }

    /* renamed from: b */
    public void m12294b(String str) {
        a(9, str);
    }

    /* renamed from: c */
    public void m12293c() {
        a(4, "D:");
    }

    /* renamed from: c */
    public void m12292c(String str) {
        a(4, str);
    }

    /* renamed from: d */
    public void m12291d() {
        a(11);
    }

    /* renamed from: d */
    public void m12290d(String str) {
        this.f8126c = str;
        a(5, (String) null, str);
    }

    /* renamed from: e */
    public void m12289e() {
        a(C2427e.f8176F, "none_force");
    }

    /* renamed from: e */
    public void m12288e(String str) {
        a(C2427e.f8178H, str, "TCP");
    }

    /* renamed from: f */
    public void m12287f() {
        a(C2427e.f8177G);
    }

    /* renamed from: g */
    public void m12285g() {
        a(2, "live", "dv_mode");
    }

    /* renamed from: h */
    public void m12284h() {
        a(2, C2427e.f8310cG, "dv_mode");
    }

    /* renamed from: i */
    public void m12283i() {
    }

    /* renamed from: j */
    public void m12282j() {
        a(17);
    }

    /* renamed from: k */
    public void m12281k() {
        a(18);
    }

    /* renamed from: l */
    public void m12280l() {
        a(19);
    }

    /* renamed from: m */
    public void m12279m() {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.f8125b = new Date().getTime();
        m12298a(C2427e.f8252bB, format);
    }
}
