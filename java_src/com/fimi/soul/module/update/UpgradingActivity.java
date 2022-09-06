package com.fimi.soul.module.update;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.fimi.kernel.p157b.p160c.AbstractC2221d;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.progress.ProgressView;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.RelayEntity;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.biz.camera.p173c.C2416d;
import com.fimi.soul.biz.p168a.C2364c;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p179h.C2462a;
import com.fimi.soul.biz.update.AbstractC2651g;
import com.fimi.soul.biz.update.C2629a;
import com.fimi.soul.biz.update.C2638c;
import com.fimi.soul.biz.update.C2639d;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p199e.C2837o;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.module.update.C3588c;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.utils.C3658ar;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class UpgradingActivity extends BaseActivity implements AbstractC2388f<X11RespCmd>, C3588c.AbstractC3590a {

    /* renamed from: R */
    private static final String f14432R = "UpgradingActivity";

    /* renamed from: a */
    public static final String f14433a = "sp_upgrade_skip";

    /* renamed from: q */
    private static final int f14434q = 153;

    /* renamed from: r */
    private static final int f14435r = 257;

    /* renamed from: s */
    private static final int f14436s = 256;

    /* renamed from: t */
    private static final int f14437t = 136;

    /* renamed from: u */
    private static final int f14438u = 102;

    /* renamed from: v */
    private static final int f14439v = 50;

    /* renamed from: x */
    private static int f14440x = 1;

    /* renamed from: D */
    private C2638c f14444D;

    /* renamed from: F */
    private EnumC3577a f14446F;

    /* renamed from: G */
    private Boolean f14447G;

    /* renamed from: H */
    private boolean f14448H;

    /* renamed from: J */
    private boolean f14450J;

    /* renamed from: K */
    private TextView f14451K;

    /* renamed from: O */
    private C2277v f14455O;

    /* renamed from: Q */
    private boolean f14457Q;

    /* renamed from: T */
    private Toast f14459T;

    /* renamed from: b */
    List<FirmwareInfo> f14460b;

    /* renamed from: f */
    C2367d.AbstractC2369a f14464f;

    /* renamed from: h */
    C2364c.AbstractC2366a f14466h;

    /* renamed from: i */
    long f14467i;

    /* renamed from: j */
    private ProgressView f14468j;

    /* renamed from: k */
    private TextView f14469k;

    /* renamed from: l */
    private ImageView f14470l;

    /* renamed from: m */
    private C2657a f14471m;

    /* renamed from: n */
    private TextView f14472n;

    /* renamed from: o */
    private C2639d f14473o;

    /* renamed from: p */
    private TextView f14474p;

    /* renamed from: y */
    private boolean f14476y;

    /* renamed from: w */
    private final int f14475w = 32;

    /* renamed from: z */
    private int f14477z = 0;

    /* renamed from: A */
    private int f14441A = 1;

    /* renamed from: B */
    private int f14442B = 0;

    /* renamed from: c */
    C2629a f14461c = null;

    /* renamed from: C */
    private C2423d f14443C = null;

    /* renamed from: E */
    private String f14445E = null;

    /* renamed from: d */
    C3588c f14462d = null;

    /* renamed from: I */
    private StringBuffer f14449I = null;

    /* renamed from: e */
    C2367d f14463e = null;

    /* renamed from: g */
    C2364c f14465g = null;

    /* renamed from: L */
    private boolean f14452L = false;

    /* renamed from: M */
    private boolean f14453M = false;

    /* renamed from: N */
    private boolean f14454N = false;

    /* renamed from: P */
    private String f14456P = C2353b.f7920K;

    /* renamed from: S */
    private boolean f14458S = false;

    /* renamed from: com.fimi.soul.module.update.UpgradingActivity$a */
    /* loaded from: classes.dex */
    public enum EnumC3577a {
        OnlyAP,
        OnlyRC,
        RCAndAP,
        Others
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8022a(int i, int i2, int i3) {
        if (System.currentTimeMillis() - this.f14467i > 500 || i2 == i3 || i == 256) {
            this.f14467i = System.currentTimeMillis();
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            getHandler().sendMessageDelayed(message, 50L);
        }
    }

    /* renamed from: a */
    private void m8021a(FirmwareInfo firmwareInfo) {
        if (m8010b(firmwareInfo)) {
            this.f14461c.m11449a(new AbstractC2651g() { // from class: com.fimi.soul.module.update.UpgradingActivity.4
                @Override // com.fimi.soul.biz.update.AbstractC2651g
                /* renamed from: a */
                public void mo6430a(boolean z, long j, long j2, int i) {
                    if (z) {
                        UpgradingActivity.this.getHandler().sendEmptyMessageDelayed(102, 50L);
                    }
                }
            }, this, firmwareInfo);
        } else {
            this.f14473o.m11399a(firmwareInfo, this.f14441A);
        }
    }

    /* renamed from: a */
    private void m8016a(String str) {
        m8022a(153, (Integer.valueOf(str.substring(str.lastIndexOf("=") + 1, str.length()).trim()).intValue() / 2) + 50, 100);
    }

    /* renamed from: b */
    private void m8013b() {
        this.f14473o.m11390e();
        this.f14460b = C3579a.m7971a().m7963d();
        if (this.f14460b == null || this.f14460b.size() == 0) {
            finish();
            return;
        }
        this.f14474p.setText(getResources().getString(C2300R.C2303string.upgrading_firmware) + this.f14460b.get(this.f14441A - 1).getSysName());
        this.f14446F = m8015a(this.f14460b);
        this.f14442B = this.f14460b.size();
        this.f14477z = this.f14460b.size() * 100;
        this.f14468j.setMaxCount(this.f14477z);
        this.f14473o.m11401a(new AbstractC2651g() { // from class: com.fimi.soul.module.update.UpgradingActivity.1
            @Override // com.fimi.soul.biz.update.AbstractC2651g
            /* renamed from: a */
            public void mo6430a(boolean z, long j, long j2, int i) {
                if (i == -1) {
                    UpgradingActivity.this.m7986k();
                } else if (z) {
                    UpgradingActivity.this.m8022a(256, i, 0);
                } else {
                    UpgradingActivity.this.f14441A = i;
                    UpgradingActivity.this.m8022a(153, (int) j, (int) j2);
                }
            }
        });
        this.f14473o.m11404a(new C2639d.AbstractC2647b() { // from class: com.fimi.soul.module.update.UpgradingActivity.3
            @Override // com.fimi.soul.biz.update.C2639d.AbstractC2647b
            /* renamed from: a */
            public void mo7977a(int i) {
                Log.i(UpgradingActivity.f14432R, "onCameraPress: " + UpgradingActivity.this.f14450J + ",seq:" + UpgradingActivity.this.f14441A);
                if (!UpgradingActivity.this.f14450J) {
                    UpgradingActivity.this.m8005c(i);
                }
            }

            @Override // com.fimi.soul.biz.update.C2639d.AbstractC2647b
            /* renamed from: a */
            public void mo7976a(boolean z) {
                if (!z || UpgradingActivity.this.f14450J) {
                    return;
                }
                UpgradingActivity.this.m7996f();
                UpgradingActivity.this.f14450J = true;
            }
        });
        FirmwareInfo firmwareInfo = this.f14460b.get(0);
        if (!m8006c()) {
            return;
        }
        this.f14462d.m7884a();
        if (firmwareInfo.getSysId() == 4 || firmwareInfo.getSysId() == 13) {
            m8012b(firmwareInfo.getSysId());
        } else {
            m8021a(firmwareInfo);
        }
    }

    /* renamed from: b */
    private void m8012b(final int i) {
        this.f14445E = "firmware.zip";
        new Thread(new Runnable() { // from class: com.fimi.soul.module.update.UpgradingActivity.7
            @Override // java.lang.Runnable
            public void run() {
                C2654j.m11357c("request camera upgrade:" + i);
                if (i != 13) {
                    C2416d m12232v = UpgradingActivity.this.f14443C.m12232v();
                    C2638c unused = UpgradingActivity.this.f14444D;
                    m12232v.m12254h(C2638c.m11410b());
                    return;
                }
                C2654j.m11357c("request camera upgrade:xx");
                C2416d m12232v2 = UpgradingActivity.this.f14443C.m12232v();
                C2638c unused2 = UpgradingActivity.this.f14444D;
                m12232v2.m12254h(C2638c.m11409c());
            }
        }).start();
    }

    /* renamed from: b */
    private void m8011b(int i, int i2, int i3) {
        if (System.currentTimeMillis() - this.f14467i > 500 || i2 == i3 || i == 256) {
            this.f14467i = System.currentTimeMillis();
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            getHandler().sendMessage(message);
        }
    }

    /* renamed from: b */
    private boolean m8010b(FirmwareInfo firmwareInfo) {
        return firmwareInfo.getSysId() == 11 || firmwareInfo.getSysId() == 15 || firmwareInfo.getSysId() == 26 || firmwareInfo.getSysId() == 14 || firmwareInfo.getSysId() == 25;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8005c(int i) {
        if (this.f14450J) {
            return;
        }
        m8011b(257, (i / 2) + 50, 100);
    }

    /* renamed from: c */
    private void m8004c(FirmwareInfo firmwareInfo) {
        if (m8010b(firmwareInfo)) {
            this.f14461c.m11449a(new AbstractC2651g() { // from class: com.fimi.soul.module.update.UpgradingActivity.10
                @Override // com.fimi.soul.biz.update.AbstractC2651g
                /* renamed from: a */
                public void mo6430a(boolean z, long j, long j2, int i) {
                    if (z) {
                        UpgradingActivity.this.getHandler().sendEmptyMessageDelayed(102, 50L);
                    }
                }
            }, this, firmwareInfo);
        } else if (m8000d(firmwareInfo)) {
            this.f14473o.m11399a(firmwareInfo, this.f14441A);
        } else if (m8000d(firmwareInfo)) {
            this.f14473o.m11399a(firmwareInfo, this.f14441A);
        } else if (!this.f14471m.mo11216ac()) {
            getHandler().sendEmptyMessageDelayed(32, 50L);
        } else {
            this.f14473o.m11399a(firmwareInfo, this.f14441A);
        }
    }

    /* renamed from: c */
    private boolean m8006c() {
        if (this.f14473o.m11394c()) {
            m7986k();
            return false;
        }
        return true;
    }

    /* renamed from: d */
    private void m8001d() {
        this.f14462d.m7881b();
        this.f14462d.m7884a();
        try {
            this.f14461c.m11438e();
        } catch (Exception e) {
            C2654j.m11362b("e:closeFtpNetwork:" + e.getMessage().toString());
        }
        this.f14463e = C2367d.m12459a();
        this.f14464f = new C2367d.AbstractC2369a() { // from class: com.fimi.soul.module.update.UpgradingActivity.5
            @Override // com.fimi.soul.biz.p168a.C2367d.AbstractC2369a
            /* renamed from: a */
            public void mo7975a(RelayEntity relayEntity) {
                int firmupg_finished = relayEntity.getFirmupg_finished();
                if (firmupg_finished <= 0) {
                    return;
                }
                if (!UpgradingActivity.this.f14453M) {
                    UpgradingActivity.this.m8022a(153, firmupg_finished, 100);
                }
                if (firmupg_finished < 100) {
                    UpgradingActivity.this.f14462d.m7881b();
                } else if (UpgradingActivity.this.f14453M) {
                } else {
                    C2654j.m11353d(UpgradingActivity.this.f14460b.get(UpgradingActivity.this.f14442B - 1).getVersion());
                    UpgradingActivity.this.m8022a(256, 0, 0);
                    UpgradingActivity.this.f14453M = true;
                }
            }
        };
        this.f14463e.m12457a(this.f14464f);
        this.f14465g = C2364c.m12469a();
        this.f14466h = new C2364c.AbstractC2366a() { // from class: com.fimi.soul.module.update.UpgradingActivity.6
            @Override // com.fimi.soul.biz.p168a.C2364c.AbstractC2366a
            /* renamed from: a */
            public void mo7974a(RelayEntity relayEntity) {
                int firmupg_finished = relayEntity.getFirmupg_finished();
                if (firmupg_finished <= 0) {
                    return;
                }
                if (!UpgradingActivity.this.f14452L) {
                    UpgradingActivity.this.m8022a(153, firmupg_finished, 100);
                }
                if (firmupg_finished < 100) {
                    UpgradingActivity.this.f14462d.m7881b();
                } else if (UpgradingActivity.this.f14452L) {
                } else {
                    C2654j.m11353d(UpgradingActivity.this.f14460b.get(UpgradingActivity.this.f14442B - 1).getVersion());
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    UpgradingActivity.this.m8022a(256, 0, 0);
                    UpgradingActivity.this.f14452L = true;
                }
            }
        };
        this.f14465g.m12468a(this.f14466h);
    }

    /* renamed from: d */
    private boolean m8000d(FirmwareInfo firmwareInfo) {
        return firmwareInfo.getSysId() == 1;
    }

    /* renamed from: e */
    private void m7998e() {
        this.f14462d = new C3588c(0, this);
        this.f14449I = new StringBuffer();
        this.f14446F = EnumC3577a.Others;
        f14440x = 1;
        this.f14461c = new C2629a();
        this.f14444D = new C2638c();
        this.f14443C = (C2423d) C2379b.m12410a().m12394d();
        this.f14450J = false;
        this.f14443C.c(false);
        this.f14443C.a(this);
        this.f14443C.c(new AbstractC2221d() { // from class: com.fimi.soul.module.update.UpgradingActivity.8
            @Override // com.fimi.kernel.p157b.p160c.AbstractC2221d
            /* renamed from: a */
            public void mo6431a(String str) {
            }
        });
        this.f14443C.m12232v().m12275a(new AbstractC2651g() { // from class: com.fimi.soul.module.update.UpgradingActivity.9
            @Override // com.fimi.soul.biz.update.AbstractC2651g
            /* renamed from: a */
            public void mo6430a(boolean z, long j, long j2, int i) {
                C2654j.m11357c("uplaod file progress:" + ((100 * j) / j2) + "%");
                if (!UpgradingActivity.this.f14443C.m12232v().m12257g()) {
                    Log.i(UpgradingActivity.f14432R, "onProgress1: ");
                    if (UpgradingActivity.this.f14450J) {
                        return;
                    }
                    UpgradingActivity.this.m8022a(153, ((int) j) / 2, (int) j2);
                }
            }
        });
        C2654j.m11349f();
        this.f14471m = ((DroidPlannerApp) getApplication()).f7895a;
        this.f14473o = new C2639d(this, this.f14471m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7996f() {
        C2654j.m11357c(C2427e.f8278bb);
        this.f14450J = true;
        C2654j.m11350e(this.f14460b.get(0).getVersion());
        m7994g();
    }

    /* renamed from: g */
    private void m7994g() {
        this.f14460b.get(0).setIsUpgradeSuccess(true);
        if (this.f14442B < 2) {
            m7992h();
            return;
        }
        this.f14441A++;
        m8021a(this.f14460b.get(1));
    }

    /* renamed from: h */
    private void m7992h() {
        f14440x = 0;
        this.f14462d.m7878d();
        this.f14473o.m11384m();
        if (this.f14448H) {
            try {
                this.f14449I.deleteCharAt(this.f14449I.length() - 1);
            } catch (Exception e) {
            }
        }
        if (!this.f14454N) {
            if (this.f14446F == EnumC3577a.OnlyRC) {
                C2654j.m11362b("reset rc");
                this.f14473o.m11386k();
                m7990i();
            } else {
                m7990i();
            }
            this.f14454N = true;
        }
    }

    /* renamed from: i */
    private void m7990i() {
        m7981n();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f14440x = 0;
        m7982m();
    }

    /* renamed from: j */
    private void m7988j() {
        if (this.f14448H) {
            C2284z.m12695a(this, this.f14449I.toString() + getResources().getString(C2300R.C2303string.updatefail));
        } else {
            C2284z.m12697a(this, (int) C2300R.C2303string.upgrade_firmware_success);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m7986k() {
        this.f14448H = true;
        this.f14450J = true;
        this.f14443C.m12232v().m12270a(true);
        getHandler().sendEmptyMessageDelayed(32, 50L);
    }

    /* renamed from: l */
    private void m7984l() {
        this.f14449I.append(this.f14460b.get(this.f14441A - 1).getSysName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (!m8024a() || !this.f14471m.mo11217ab().mo10898a()) {
            this.f14458S = true;
            Log.i(f14432R, "continueUpgrade: ");
            m7982m();
            return;
        }
        this.f14441A++;
        if (!m8006c()) {
            return;
        }
        m8004c(this.f14460b.get(this.f14441A - 1));
    }

    /* renamed from: m */
    private void m7982m() {
        Intent intent = new Intent(this, UpgradeResultActivity.class);
        intent.putExtra(UpgradeResultActivity.f14407a, (Serializable) this.f14460b);
        startActivity(intent);
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: n */
    private void m7981n() {
        if (this.f14443C != null) {
            this.f14443C.c(true);
            this.f14443C.m12232v().m12270a(true);
            this.f14443C = null;
        }
        this.f14473o.m11390e();
        this.f14473o.m11385l();
        this.f14461c = null;
        this.f14462d.m7878d();
        m7980o();
        m7979p();
        getHandler().removeCallbacksAndMessages(null);
        System.gc();
    }

    /* renamed from: o */
    private void m7980o() {
        if (this.f14463e == null || this.f14464f == null) {
            return;
        }
        this.f14463e.m12453b(this.f14464f);
    }

    /* renamed from: p */
    private void m7979p() {
        if (this.f14465g == null || this.f14466h == null) {
            return;
        }
        this.f14465g.m12465b(this.f14466h);
    }

    /* renamed from: q */
    private void m7978q() {
        if (!this.f14476y) {
            this.f14476y = true;
            this.f14459T = Toast.makeText(getApplicationContext(), (int) C2300R.C2303string.upgrading_not_disconnect, 0);
            this.f14459T.show();
            getHandler().sendEmptyMessageDelayed(136, 2000L);
            return;
        }
        this.f14443C.m12232v().m12270a(true);
        new Thread(new Runnable() { // from class: com.fimi.soul.module.update.UpgradingActivity.2
            @Override // java.lang.Runnable
            public void run() {
                C2837o.f10459a.f9714d = (byte) 0;
                C2837o.f10459a.f9715e = (byte) 2;
                UpgradingActivity.this.f14471m.mo11217ab().mo10897a(C2837o.f10459a.mo11073b());
            }
        }).start();
        this.f14459T.cancel();
        startActivity(new Intent(this, FindNewFirmwareAvtivity.class));
        DroidPlannerApp.f7891f = false;
        finish();
    }

    /* renamed from: a */
    public EnumC3577a m8015a(List<FirmwareInfo> list) {
        EnumC3577a enumC3577a;
        EnumC3577a enumC3577a2 = EnumC3577a.Others;
        Iterator<FirmwareInfo> it2 = list.iterator();
        while (true) {
            enumC3577a = enumC3577a2;
            if (!it2.hasNext()) {
                break;
            }
            FirmwareInfo next = it2.next();
            if (next.getSysId() == 11) {
                EnumC3577a enumC3577a3 = EnumC3577a.OnlyAP;
                Iterator<FirmwareInfo> it3 = list.iterator();
                while (true) {
                    enumC3577a = enumC3577a3;
                    if (!it3.hasNext()) {
                        break;
                    }
                    enumC3577a3 = it3.next().getSysId() == 1 ? EnumC3577a.RCAndAP : enumC3577a;
                }
            } else {
                enumC3577a2 = next.getSysId() == 1 ? EnumC3577a.OnlyRC : enumC3577a;
            }
        }
        return enumC3577a;
    }

    /* renamed from: a */
    public void m8023a(int i) {
        this.f14441A = i;
    }

    @Override // com.fimi.soul.module.update.C3588c.AbstractC3590a
    /* renamed from: a */
    public void mo6452a(boolean z) {
        if (z) {
            m7986k();
        }
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        if (!z || !x11RespCmd.isNotification()) {
            return;
        }
        if (C2427e.f8223aZ.equals(x11RespCmd.getType())) {
            C2654j.m11357c(C2427e.f8223aZ);
            this.f14462d.m7881b();
        }
        if (C2427e.f8278bb.equals(x11RespCmd.getType())) {
            m7996f();
        }
        if (C2427e.f8280bd.equals(x11RespCmd.getType())) {
            C2654j.m11357c(C2427e.f8280bd);
        }
        if (C2427e.f8283bg.equals(x11RespCmd.getType())) {
            C2654j.m11357c(C2427e.f8283bg);
        }
        if (!x11RespCmd.getType().contains(C2427e.f8281be) || this.f14450J) {
            return;
        }
        String type = x11RespCmd.getType();
        C2654j.m11357c(type);
        m8016a(type);
    }

    /* renamed from: a */
    public boolean m8024a() {
        return this.f14442B > this.f14441A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DroidPlannerApp.f7891f = true;
        CameraValue.isUpdate = true;
        this.dpa.m12523b(this);
        this.f14455O = C2277v.m12784a(this);
        this.f14447G = Boolean.valueOf(this.f14455O.m12787a().getBoolean(this.f14456P, false));
        getWindow().setFlags(128, 128);
        setContentView(C2300R.layout.activity_upgrading);
        this.f14457Q = getIntent().getBooleanExtra("isForce", false);
        this.f14468j = (ProgressView) findViewById(C2300R.C2302id.progress_view);
        this.f14469k = (TextView) findViewById(C2300R.C2302id.tv_progress);
        C3658ar.m7598b(getAssets(), this.f14469k);
        this.f14470l = (ImageView) findViewById(C2300R.C2302id.img_anim);
        this.f14474p = (TextView) findViewById(C2300R.C2302id.upgrade_result);
        this.f14451K = (TextView) findViewById(C2300R.C2302id.upgrading_warning);
        C3658ar.m7612a(getAssets(), this.f14474p, this.f14451K);
        this.f14472n = (TextView) findViewById(C2300R.C2302id.tv_percent);
        C3658ar.m7598b(getAssets(), this.f14472n);
        this.f14441A = 1;
        m7998e();
        m8013b();
        C2462a.m12098a().m12092a(getLocalClassName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m7981n();
    }

    @Override // com.fimi.kernel.BaseActivity
    public void onHandleMessage(Message message) {
        if (message.what == 153) {
            this.f14462d.m7881b();
            this.f14474p.setText(getResources().getString(C2300R.C2303string.upgrading_firmware) + this.f14460b.get(this.f14441A - 1).getSysName());
            int i = ((message.arg1 * 100) / message.arg2) + ((this.f14441A - 1) * 100);
            this.f14469k.setText(((i * 100) / this.f14477z) + "");
            Log.i(f14432R, "onHandleMessage1: " + ((i * 100) / this.f14477z) + ",seq:" + this.f14441A);
            this.f14468j.setCurrentCount(i);
        }
        if (message.what == 257 && (this.f14441A <= 1 || !this.f14450J)) {
            this.f14462d.m7881b();
            this.f14474p.setText(getResources().getString(C2300R.C2303string.upgrading_firmware) + this.f14460b.get(this.f14441A - 1).getSysName());
            int i2 = ((message.arg1 * 100) / message.arg2) + ((this.f14441A - 1) * 100);
            this.f14469k.setText(((i2 * 100) / this.f14477z) + "");
            Log.i(f14432R, "onHandleMessage1: " + ((i2 * 100) / this.f14477z) + ",seq:" + this.f14441A);
            this.f14468j.setCurrentCount(i2);
        }
        if (message.what == 256) {
            this.f14473o.m11387f();
            this.f14460b.get(this.f14441A - 1).setIsUpgradeSuccess(true);
            this.f14473o.m11400a(this.f14460b.get(this.f14441A - 1));
            if (!m8006c()) {
                return;
            }
            if (m8024a()) {
                this.f14441A++;
                m8021a(this.f14460b.get(this.f14441A - 1));
            } else {
                m7992h();
            }
        }
        if (message.what == 136) {
            this.f14476y = false;
        }
        if (message.what == 102) {
            m8001d();
        }
        if (message.what != 32 || this.f14458S) {
            return;
        }
        m7984l();
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.f14457Q) {
                m7978q();
            }
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (f14440x == 0) {
            f14440x = 0;
            m7982m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f14470l.setBackgroundResource(C2300R.C2301drawable.update_anim);
        ((AnimationDrawable) this.f14470l.getBackground()).start();
    }
}
