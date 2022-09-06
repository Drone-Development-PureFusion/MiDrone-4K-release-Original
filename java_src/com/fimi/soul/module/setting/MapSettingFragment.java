package com.fimi.soul.module.setting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.button.SwitchButton;
import com.fimi.kernel.view.percent.PercentRelativeLayout;
import com.fimi.p139b.AbstractC2089b;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2574l;
import com.fimi.soul.biz.p185n.C2582p;
import com.fimi.soul.biz.p185n.C2613z;
import com.fimi.soul.biz.p186o.C2616a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.p195a.C2729br;
import com.fimi.soul.drone.p193d.p194a.p195a.C2760r;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.drone.p203i.C2908c;
import com.fimi.soul.drone.p203i.C2911f;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.entity.DeviceType;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.Setting;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.calibcompass.C3074a;
import com.fimi.soul.module.calibcompass.CaliCompassActivity;
import com.fimi.soul.module.droneui.BatteryInfoActivity;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.module.droneui.IMU4KActivity;
import com.fimi.soul.module.droneui.MoreInfoSettingAcitivity;
import com.fimi.soul.module.insurance.ReceiveInsuranceActivity;
import com.fimi.soul.module.login.LoginActivity;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.module.paircode.PairCodeActivity;
import com.fimi.soul.module.push.HistoryMessageActivity;
import com.fimi.soul.module.remote.RemoteCalibration;
import com.fimi.soul.module.remote.RemoteModelActivity;
import com.fimi.soul.module.setting.C3509i;
import com.fimi.soul.module.setting.GimalCalibration.GimalCalibrationActivity;
import com.fimi.soul.module.setting.gimaltuneparameter.GimalTuneParameterActivity;
import com.fimi.soul.module.setting.newhand.AbstractC3544d;
import com.fimi.soul.module.setting.newhand.C3531c;
import com.fimi.soul.module.setting.newhand.GpsSettingActivity;
import com.fimi.soul.module.setting.newhand.NewHandActivity;
import com.fimi.soul.module.social.WebViewActivity;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.FindNewFirmwareAvtivity;
import com.fimi.soul.module.update.FindOnlineFirmwareAvtivity;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.p167b.C2313b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3800f;
import com.fimi.soul.view.DialogC3830i;
import com.fimi.soul.view.marknumberprogress.AbstractC3845b;
import com.fimi.soul.view.marknumberprogress.C3843a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.p248a.p249a.p282o.C5356f;
/* loaded from: classes.dex */
public class MapSettingFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener, C2678d.AbstractC2680b, C3509i.AbstractC3511a, C3509i.AbstractC3512b, C3509i.AbstractC3513c {

    /* renamed from: A */
    private static final int f13593A = 2;

    /* renamed from: B */
    private static final int f13594B = 1;

    /* renamed from: C */
    private static final int f13595C = 3;

    /* renamed from: D */
    private static final int f13596D = 5;

    /* renamed from: S */
    private static final int f13597S = 6;

    /* renamed from: T */
    private static final int f13598T = 7;

    /* renamed from: U */
    private static final int f13599U = 5000;

    /* renamed from: V */
    private static final String f13600V = "MapSettingFragment";

    /* renamed from: z */
    private static final int f13601z = 0;

    /* renamed from: E */
    private C2574l f13602E;

    /* renamed from: F */
    private boolean f13603F;

    /* renamed from: P */
    private C3843a f13613P;

    /* renamed from: c */
    List<UpdateVersonBean> f13620c;

    /* renamed from: d */
    AbstractC3544d f13621d;

    /* renamed from: f */
    private ListView f13623f;

    /* renamed from: g */
    private C3509i f13624g;

    /* renamed from: h */
    private C2313b f13625h;

    /* renamed from: j */
    private Setting f13627j;

    /* renamed from: k */
    private Context f13628k;

    /* renamed from: l */
    private AbstractC3465a f13629l;

    /* renamed from: m */
    private Button f13630m;

    /* renamed from: n */
    private TextView f13631n;

    /* renamed from: o */
    private C2657a f13632o;

    /* renamed from: p */
    private C3057d f13633p;

    /* renamed from: q */
    private PercentRelativeLayout f13634q;

    /* renamed from: r */
    private C2277v f13635r;

    /* renamed from: s */
    private C2423d f13636s;

    /* renamed from: t */
    private C2613z f13637t;

    /* renamed from: e */
    private Observer f13622e = new Observer() { // from class: com.fimi.soul.module.setting.MapSettingFragment.1
        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            if (MapSettingFragment.this.f13624g != null) {
                MapSettingFragment.this.f13624g.m8185a(MapSettingFragment.this.f13626i);
            }
        }
    };

    /* renamed from: i */
    private List<Setting> f13626i = new ArrayList();

    /* renamed from: a */
    public boolean f13618a = false;

    /* renamed from: b */
    List<FirmwareInfo> f13619b = null;

    /* renamed from: u */
    private boolean f13638u = false;

    /* renamed from: v */
    private int f13639v = 0;

    /* renamed from: w */
    private int f13640w = 0;

    /* renamed from: x */
    private int f13641x = 0;

    /* renamed from: y */
    private boolean f13642y = false;

    /* renamed from: G */
    private boolean f13604G = false;

    /* renamed from: H */
    private long f13605H = 0;

    /* renamed from: I */
    private boolean f13606I = true;

    /* renamed from: J */
    private boolean f13607J = false;

    /* renamed from: K */
    private boolean f13608K = false;

    /* renamed from: L */
    private boolean f13609L = false;

    /* renamed from: M */
    private boolean f13610M = false;

    /* renamed from: N */
    private String f13611N = C2353b.f7920K;

    /* renamed from: O */
    private String f13612O = RemoteModelActivity.f13406a;

    /* renamed from: Q */
    private int f13614Q = 60;

    /* renamed from: R */
    private C2313b.AbstractC2321a f13615R = new C2313b.AbstractC2321a() { // from class: com.fimi.soul.module.setting.MapSettingFragment.4
        @Override // com.fimi.soul.p167b.C2313b.AbstractC2321a
        /* renamed from: a */
        public boolean mo8374a() {
            return false;
        }
    };

    /* renamed from: W */
    private int f13616W = -1;

    /* renamed from: X */
    private Handler f13617X = new Handler() { // from class: com.fimi.soul.module.setting.MapSettingFragment.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    MapSettingFragment.this.f13621d.mo8118a();
                    return;
                case 1:
                    if (MapSettingFragment.this.f13609L) {
                        return;
                    }
                    MapSettingFragment.this.f13621d.mo8107d();
                    return;
                case 2:
                    MapSettingFragment.this.f13621d.mo8111b();
                    return;
                case 3:
                    C3489d.m8302a(MapSettingFragment.this.f13632o).m8304a();
                    return;
                case 4:
                default:
                    return;
                case 5:
                    if (MapSettingFragment.this.f13610M) {
                        return;
                    }
                    MapSettingFragment.this.f13621d.mo8108c();
                    return;
                case 6:
                    Log.d(MapSettingFragment.f13600V, "handleMessage: TIME");
                    MapSettingFragment.this.m8412a((C2423d) C2379b.m12410a().m12394d());
                    sendEmptyMessageDelayed(6, 5000L);
                    return;
                case 7:
                    MapSettingFragment.this.m8375u();
                    return;
            }
        }
    };

    /* renamed from: com.fimi.soul.module.setting.MapSettingFragment$a */
    /* loaded from: classes.dex */
    public interface AbstractC3465a {
        /* renamed from: c */
        void mo8373c();
    }

    /* renamed from: a */
    private void m8413a(View view) {
        this.f13634q = (PercentRelativeLayout) view.findViewById(C2300R.C2302id.heardView);
        this.f13630m = (Button) this.f13634q.findViewById(C2300R.C2302id.black_btn);
        this.f13623f = (ListView) view.findViewById(C2300R.C2302id.setting_lv);
        this.f13631n = (TextView) this.f13634q.findViewById(C2300R.C2302id.tv_settingTitle);
        this.f13635r = C2277v.m12784a(getActivity());
        this.f13636s = (C2423d) C2379b.m12410a().m12394d();
        this.f13630m.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8412a(C2423d c2423d) {
        CameraValue.PAGE_CAMERA_MENU_ALBUM = 2;
        if ("menu_album".equals("") || !c2423d.e() || C2277v.m12784a(this.f13628k).m12742s() != DeviceType.DEVICE_4K) {
            return;
        }
        c2423d.m12233u().m12298a("menu_album", C2427e.f8308cE);
    }

    /* renamed from: a */
    private void m8411a(C2657a c2657a) {
        C2729br c2729br = new C2729br();
        c2729br.f9966d = C2760r.f10172a;
        c2729br.f9967e = (byte) 1;
        c2729br.f9968f = (byte) 0;
        c2657a.mo11217ab().mo10897a(c2729br.mo11073b());
        m8390h();
    }

    /* renamed from: o */
    private void m8381o() {
        this.f13637t = C2613z.m11525a(this.f13628k);
        this.f13602E = C2574l.m11638a(this.f13628k);
        if (!C3658ar.m7601b(this.f13628k) || !this.f13632o.mo11216ac()) {
            return;
        }
        this.f13602E.m11636a(C2353b.m12507c(this.f13628k), C2574l.f8876a, new AbstractC2538k() { // from class: com.fimi.soul.module.setting.MapSettingFragment.5
            @Override // com.fimi.soul.biz.p183l.AbstractC2538k
            /* renamed from: a */
            public void mo6501a(PlaneMsg planeMsg, File file) {
                if (planeMsg.isSuccess()) {
                }
            }
        });
    }

    /* renamed from: p */
    private boolean m8380p() {
        return this.f13620c != null && this.f13620c.size() > 0;
    }

    /* renamed from: q */
    private void m8379q() {
        if (this.f13618a) {
            this.f13631n.setText(C2300R.C2303string.camera_setting);
            if (this.f13625h == null) {
                this.f13625h = new C2313b(getActivity(), this.f13632o);
                this.f13625h.m12608a(this.f13615R);
            }
            this.f13625h.m12609a();
            this.f13625h.m12598b();
            this.f13623f.setAdapter((ListAdapter) this.f13625h);
            this.f13623f.setOnItemClickListener(this.f13625h);
        } else if (this.f13624g != null && this.f13626i.size() > 0) {
            this.f13623f.setAdapter((ListAdapter) this.f13624g);
            this.f13623f.setOverScrollMode(2);
            this.f13623f.setOnItemClickListener(this);
            if (this.f13616W != C2277v.m12784a(getActivity()).m12742s()) {
                m8415a();
            }
            m8378r();
            this.f13623f.setSelectionFromTop(this.f13639v, this.f13640w);
            this.f13631n.setText(C2300R.C2303string.setting);
        } else {
            this.f13631n.setText(C2300R.C2303string.setting);
            this.f13624g = new C3509i(this.f13628k, this.f13632o);
            this.f13624g.m8190a((C3509i.AbstractC3512b) this);
            this.f13624g.m8189a((C3509i.AbstractC3513c) this);
            this.f13624g.m8191a((C3509i.AbstractC3511a) this);
            this.f13623f.setAdapter((ListAdapter) this.f13624g);
            this.f13623f.setOverScrollMode(2);
            this.f13623f.setOnItemClickListener(this);
            m8415a();
            m8378r();
            this.f13623f.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.fimi.soul.module.setting.MapSettingFragment.6
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    int i2 = 0;
                    if (MapSettingFragment.this.f13618a) {
                        return;
                    }
                    if (i == 0) {
                        MapSettingFragment.this.f13639v = MapSettingFragment.this.f13623f.getFirstVisiblePosition();
                    }
                    if (MapSettingFragment.this.f13626i == null) {
                        return;
                    }
                    View childAt = MapSettingFragment.this.f13623f.getChildAt(0);
                    MapSettingFragment mapSettingFragment = MapSettingFragment.this;
                    if (childAt != null) {
                        i2 = childAt.getTop();
                    }
                    mapSettingFragment.f13640w = i2;
                }
            });
        }
    }

    /* renamed from: r */
    private void m8378r() {
        this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).setIsOPen(Boolean.valueOf(this.f13606I));
        this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).setIsOPen(Boolean.valueOf(this.f13608K));
        this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).setIsOPen(Boolean.valueOf(this.f13607J));
        this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).setIsOPen(false);
        this.f13619b = C3579a.m7971a().m7963d();
        if (this.f13635r.m12787a().contains("isfirstloading")) {
            this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.XIAOMI_ACCOUNT)).setIsOPen(true);
            this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.XIAOMI_ACCOUNT)).setContent(C2353b.m12507c(this.f13628k).getXiaomiID());
        } else {
            this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.XIAOMI_ACCOUNT)).setIsOPen(false);
        }
        if (this.f13635r.m12787a().getInt(RemoteModelActivity.f13406a, 0) == 0) {
            this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_REMOTE_MODE)).setContent(getResources().getString(C2300R.C2303string.modelcannal));
        } else {
            this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_REMOTE_MODE)).setContent(getResources().getString(C2300R.C2303string.modelcannaljp));
        }
        if (!this.f13632o.mo11217ab().mo10898a() || !this.f13632o.mo11216ac()) {
            this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.CONNECT_PLANE)).setIsOPen(true);
        }
        this.f13620c = C3579a.m7971a().m7962e();
        m8377s();
        this.f13624g.m8185a(this.f13626i);
    }

    /* renamed from: s */
    private void m8377s() {
        this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FIMWARE_UPDATE)).setIsOPen(true);
        if (m8380p() || (this.f13619b != null && this.f13619b.size() > 0)) {
            this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FIMWARE_UPDATE)).setDisplayTv(true);
        } else {
            this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FIMWARE_UPDATE)).setDisplayTv(false);
        }
    }

    /* renamed from: t */
    private void m8376t() {
        final DialogC3830i.C3831a c3831a = new DialogC3830i.C3831a(getActivity(), this.f13632o);
        final String m12432q = C2367d.m12459a().m12432q();
        final String m12433p = C2367d.m12459a().m12433p();
        if (m12432q != null) {
            c3831a.m6918c(m12432q);
        }
        if (m12433p != null) {
            c3831a.m6917d(m12433p);
        }
        c3831a.m6924a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.MapSettingFragment.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }, getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.MapSettingFragment.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (C5356f.m1297a(c3831a.m6926a())) {
                    c3831a.m6921b(MapSettingFragment.this.getString(C2300R.C2303string.relay_error_ssid));
                } else if (C5356f.m1297a(c3831a.m6923b())) {
                    c3831a.m6921b(MapSettingFragment.this.getString(C2300R.C2303string.relay_error_pas));
                } else if (c3831a.m6923b().length() < 8) {
                    c3831a.m6921b(MapSettingFragment.this.getString(C2300R.C2303string.relay_error_pas));
                } else if (m12432q != null && m12432q.equals(c3831a.m6926a()) && m12433p != null && m12433p.equals(c3831a.m6923b())) {
                    dialogInterface.dismiss();
                } else {
                    C2616a m11502a = C2616a.m11502a();
                    m11502a.m11500a(c3831a.m6926a());
                    m11502a.m11497b(c3831a.m6923b());
                    m11502a.m11499b();
                }
            }
        });
        c3831a.m6920c().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m8375u() {
        boolean m12438k = C2367d.m12459a().m12438k();
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        int m7959a = c3580b != null ? c3580b.m7959a() : 0;
        if (m12438k || m7959a >= C3489d.f13754g) {
            C3489d.m8302a(this.f13632o).m8304a();
        }
    }

    /* renamed from: a */
    public void m8415a() {
        this.f13626i.clear();
        if (C2277v.m12784a(getActivity()).m12742s() == DeviceType.DEVICE_4K) {
            m8401c();
        } else if (C2277v.m12784a(getActivity()).m12742s() == DeviceType.DEVICE_1080P) {
            m8404b();
        }
        this.f13616W = C2277v.m12784a(getActivity()).m12742s();
    }

    /* renamed from: a */
    public void m8414a(int i) {
        C2911f m11294g = this.f13632o.m11294g();
        this.f13632o.mo11217ab().mo10897a(m11294g.m10318a(i, m11294g));
    }

    @Override // com.fimi.soul.module.setting.C3509i.AbstractC3512b
    /* renamed from: a */
    public void mo8183a(SwitchButton switchButton) {
        if (this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).getIsOPen().booleanValue()) {
            this.f13617X.sendEmptyMessageDelayed(7, 1000L);
        }
        this.f13621d.mo8114a(switchButton, this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)));
        this.f13624g.notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m8407a(String str) {
        this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.CHECK_UPDATE)).setIsOPen(false);
        this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.CHECK_UPDATE)).setContent(str);
        this.f13624g.m8185a(this.f13626i);
        this.f13619b = C3579a.m7971a().m7963d();
    }

    /* renamed from: a */
    public void m8406a(boolean z) {
        byte b = z ? (byte) 2 : (byte) 1;
        C2729br c2729br = new C2729br();
        c2729br.f9966d = (byte) 116;
        c2729br.f9967e = (byte) 1;
        c2729br.f9968f = b;
        this.f13632o.mo11217ab().mo10897a(c2729br.mo11073b());
    }

    /* renamed from: a */
    public void m8405a(boolean z, String str) {
        if (this.f13613P == null) {
            this.f13613P = new C3843a(getActivity(), new AbstractC3845b() { // from class: com.fimi.soul.module.setting.MapSettingFragment.9
                @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
                /* renamed from: a */
                public void mo6857a(int i) {
                }

                @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
                /* renamed from: a */
                public void mo6856a(int i, int i2) {
                    MapSettingFragment.this.f13614Q = i;
                    if (!MapSettingFragment.this.f13632o.mo11217ab().mo10898a() || !MapSettingFragment.this.f13632o.mo11216ac()) {
                        return;
                    }
                    MapSettingFragment.this.m8414a(i);
                }

                @Override // com.fimi.soul.view.marknumberprogress.AbstractC3845b
                /* renamed from: b */
                public void mo6855b(int i, int i2) {
                }
            });
        }
        this.f13613P.m6860a(this.f13614Q, z, str);
    }

    /* renamed from: b */
    public void m8404b() {
        C3509i.EnumC3514d[] values;
        boolean z;
        for (C3509i.EnumC3514d enumC3514d : C3509i.EnumC3514d.values()) {
            int i = 0;
            while (true) {
                if (i >= C3509i.f13893b.length) {
                    z = true;
                    break;
                } else if (enumC3514d == C3509i.f13893b[i]) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                this.f13627j = new Setting();
                this.f13627j.addObserver(this.f13622e);
                this.f13627j.setIsOPen(true);
                this.f13627j.setSettingAdaptState(enumC3514d);
                this.f13626i.add(this.f13627j);
            }
        }
    }

    @Override // com.fimi.soul.module.setting.C3509i.AbstractC3513c
    /* renamed from: b */
    public void mo8182b(int i) {
        if (i == 4) {
            this.f13621d.mo8113a(this.f13626i, this.f13624g);
        } else if (i != 2) {
        } else {
            this.f13621d.mo8112a(this.f13626i, this.f13624g, this.f13602E);
        }
    }

    /* renamed from: c */
    public void m8401c() {
        C3509i.EnumC3514d[] values;
        boolean z;
        for (C3509i.EnumC3514d enumC3514d : C3509i.EnumC3514d.values()) {
            int i = 0;
            while (true) {
                if (i >= C3509i.f13894c.length) {
                    z = true;
                    break;
                } else if (enumC3514d == C3509i.f13894c[i]) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                this.f13627j = new Setting();
                this.f13627j.addObserver(this.f13622e);
                this.f13627j.setIsOPen(true);
                this.f13627j.setSettingAdaptState(enumC3514d);
                this.f13626i.add(this.f13627j);
            }
        }
    }

    /* renamed from: d */
    public boolean m8398d() {
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        boolean z = c3580b != null && c3580b.m7959a() > 0 && c3580b.m7959a() >= (C2277v.m12784a(getActivity()).m12742s() == DeviceType.DEVICE_4K ? 1067 : C2277v.m12784a(getActivity()).m12742s() == DeviceType.DEVICE_1080P ? 1902 : 0);
        if (!z) {
            C2284z.m12694a(this.f13628k, this.f13628k.getString(C2300R.C2303string.fc_update_tip), C2284z.f7606b);
        }
        return z;
    }

    /* renamed from: e */
    public void m8396e() {
        if (!this.f13632o.mo11217ab().mo10898a() || !this.f13632o.mo11216ac()) {
            C2284z.m12696a(getActivity(), (int) C2300R.C2303string.front_lights_setting_no_connect, 3000);
            return;
        }
        switch (m8394f()) {
            case 0:
                m8405a(false, getString(C2300R.C2303string.front_lights_setting_app_enable_tip));
                return;
            case 1:
                m8405a(true, "");
                return;
            case 2:
                m8405a(false, getString(C2300R.C2303string.front_lights_setting_app_enable_tip2));
                return;
            default:
                return;
        }
    }

    /* renamed from: f */
    public int m8394f() {
        String content = this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).getContent();
        if (this.f13632o.m11312at().m10700g().isEnforcementAtti()) {
            return 2;
        }
        return (content == null || !content.equals(getString(C2300R.C2303string.ev_control))) ? 0 : 1;
    }

    /* renamed from: g */
    public boolean m8392g() {
        String content = this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).getContent();
        return content != null && content.equals(getString(C2300R.C2303string.ev_control));
    }

    /* renamed from: h */
    public void m8390h() {
        this.f13632o.mo11217ab().mo10897a(new C2911f().m10307f());
    }

    /* renamed from: i */
    public void m8388i() {
        this.f13614Q = (int) ((this.f13632o.m11294g().m10312c() * 100.0f) / 1024.0f);
    }

    /* renamed from: j */
    public void m8386j() {
        if (this.f13621d == null) {
            this.f13621d = new C3531c(this.f13632o, this.f13628k);
        }
        this.f13621d.mo8107d();
    }

    /* renamed from: k */
    public void m8384k() {
        this.f13617X.sendEmptyMessage(6);
    }

    @Override // com.fimi.soul.module.setting.C3509i.AbstractC3511a
    /* renamed from: l */
    public void mo8184l() {
    }

    /* renamed from: m */
    public boolean m8383m() {
        if (this.f13618a) {
            this.f13618a = false;
            this.f13636s.m12233u().m12289e();
            m8379q();
            return false;
        }
        this.f13617X.removeCallbacksAndMessages(null);
        m8382n();
        this.f13629l.mo8373c();
        return true;
    }

    /* renamed from: n */
    public void m8382n() {
        CameraValue.PAGE_CAMERA_MENU_ALBUM = 0;
        if (!"menu_album".equals("")) {
            C2423d c2423d = (C2423d) C2379b.m12410a().m12394d();
            if (!c2423d.e() || C2277v.m12784a(this.f13628k).m12742s() != DeviceType.DEVICE_4K) {
                return;
            }
            c2423d.m12233u().m12298a("menu_album", "off");
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 100:
                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).setContent(intent.getStringExtra("content"));
                this.f13624g.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f13628k = activity;
        this.f13629l = (AbstractC3465a) activity;
        this.f13632o = ((DroidPlannerApp) activity.getApplication()).f7895a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.black_btn /* 2131493817 */:
                if (this.f13618a) {
                    this.f13618a = false;
                    ((C2423d) C2379b.m12410a().m12394d()).m12233u().m12289e();
                    m8379q();
                    return;
                }
                this.f13617X.removeCallbacksAndMessages(null);
                m8382n();
                this.f13629l.mo8373c();
                return;
            default:
                return;
        }
    }

    @Override // android.support.p001v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.activity_general_setting, viewGroup, false);
        m8413a(inflate);
        m8381o();
        return inflate;
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (c2657a.mo11217ab().mo10898a() && c2657a.mo11216ac()) {
            switch (enumC2679a) {
                case Remotecontrol:
                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.CONNECT_PLANE)).setIsOPen(false);
                    break;
                case NEW_HAND_OPERATE:
                    if (c2657a.m11310av().m10573d() == 51) {
                        if (C2238c.m13127b().mo12680b() != null && C2238c.m13127b().mo12680b().isShowing()) {
                            C2238c.m13127b().mo12676c();
                        }
                        if (c2657a.m11310av().m10571f() == 1) {
                            if (c2657a.m11310av().m10568i() == 0) {
                                C2284z.m12697a(this.f13628k, (int) C2300R.C2303string.set_model_success);
                                this.f13617X.sendEmptyMessageDelayed(1, 1000L);
                                this.f13617X.sendEmptyMessageDelayed(1, 2000L);
                                this.f13609L = false;
                            } else {
                                C2284z.m12697a(this.f13628k, (int) C2300R.C2303string.set_model_fail);
                            }
                            if (c2657a.m11310av().m10572e() == 0) {
                                this.f13606I = true;
                                this.f13607J = false;
                                this.f13608K = false;
                                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).setIsOPen(true);
                                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).setIsOPen(false);
                                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).setIsOPen(false);
                                this.f13621d.mo8107d();
                            } else {
                                this.f13606I = false;
                                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).setIsOPen(false);
                            }
                        }
                        if (c2657a.m11310av().m10571f() == 3) {
                            if (c2657a.m11310av().m10568i() == 0) {
                                C2284z.m12697a(this.f13628k, (int) C2300R.C2303string.set_model_success);
                                this.f13617X.sendEmptyMessageDelayed(5, 1000L);
                                this.f13617X.sendEmptyMessageDelayed(5, 2000L);
                                this.f13610M = false;
                            } else {
                                C2284z.m12697a(this.f13628k, (int) C2300R.C2303string.set_model_fail);
                            }
                            if (c2657a.m11310av().m10570g() == 2) {
                                if (c2657a.m11310av().m10569h() == 1) {
                                    this.f13606I = false;
                                    this.f13607J = false;
                                    this.f13608K = true;
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).setIsOPen(false);
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).setIsOPen(true);
                                } else {
                                    this.f13608K = false;
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).setIsOPen(false);
                                }
                            }
                            if (c2657a.m11310av().m10570g() == 4) {
                                if (c2657a.m11310av().m10569h() == 1) {
                                    this.f13606I = false;
                                    this.f13607J = true;
                                    this.f13608K = false;
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).setIsOPen(false);
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).setIsOPen(true);
                                    this.f13604G = true;
                                    m8406a(true);
                                    m8411a(c2657a);
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).setContent(this.f13628k.getString(C2300R.C2303string.gps_atti));
                                } else {
                                    this.f13607J = false;
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).setIsOPen(false);
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).setIsOPen(false);
                                }
                            }
                        }
                    }
                    if (c2657a.m11310av().m10573d() == 34) {
                        this.f13609L = true;
                        this.f13610M = true;
                        if (c2657a.m11310av().m10571f() == 1 || c2657a.m11310av().m10571f() == 3) {
                            if (c2657a.m11310av().m10571f() == 1) {
                                if (c2657a.m11310av().m10572e() == 0) {
                                    this.f13606I = true;
                                    this.f13607J = false;
                                    this.f13608K = false;
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).setIsOPen(true);
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).setIsOPen(false);
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).setIsOPen(false);
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).setIsOPen(false);
                                    this.f13604G = false;
                                    m8406a(false);
                                    m8411a(c2657a);
                                } else {
                                    this.f13606I = false;
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).setIsOPen(false);
                                }
                            }
                            if ((c2657a.m11310av().m10569h() & 1) == 1) {
                                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).setIsOPen(false);
                                this.f13607J = false;
                            }
                            if ((c2657a.m11310av().m10569h() & 2) == 2) {
                                this.f13606I = false;
                                this.f13607J = false;
                                this.f13608K = true;
                                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).setIsOPen(false);
                                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).setIsOPen(true);
                            } else {
                                this.f13608K = false;
                                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).setIsOPen(false);
                            }
                            if ((c2657a.m11310av().m10569h() & 4) == 4) {
                                if (!this.f13606I) {
                                    this.f13604G = true;
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).setContent(this.f13628k.getString(C2300R.C2303string.gps_atti));
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).setIsOPen(true);
                                    this.f13606I = false;
                                    this.f13607J = true;
                                    this.f13608K = false;
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).setIsOPen(true);
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).setIsOPen(false);
                                    break;
                                }
                            } else if (System.currentTimeMillis() - this.f13605H < 1000) {
                                return;
                            } else {
                                this.f13605H = System.currentTimeMillis();
                                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).setIsOPen(false);
                                this.f13604G = false;
                                m8406a(false);
                                m8411a(c2657a);
                                break;
                            }
                        }
                    }
                    break;
                case backControl:
                    C2908c mo11229R = c2657a.mo11229R();
                    if (mo11229R != null && mo11229R.m10343b() == 115) {
                        if (this.f13604G) {
                            return;
                        }
                        if (mo11229R.m10342c() == 2) {
                            switch (mo11229R.f10926d) {
                                case 1:
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).setContent(getString(C2300R.C2303string.ev_control));
                                    break;
                                case 2:
                                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).setContent(getString(C2300R.C2303string.light_control));
                                    break;
                            }
                        }
                    }
                    this.f13624g.notifyDataSetChanged();
                    break;
                case BRIGHTNESS:
                    m8388i();
                    if (this.f13625h != null) {
                        this.f13625h.m12588d();
                        break;
                    }
                    break;
            }
        } else {
            this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.CONNECT_PLANE)).setIsOPen(true);
            switch (enumC2679a) {
                case CLEANALLOBJ:
                    m8377s();
                    this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.CONNECT_PLANE)).setIsOPen(true);
                    break;
            }
        }
        if (enumC2679a == C2678d.EnumC2679a.backControl && c2657a.mo11229R().m10343b() == 114) {
            C3074a.m9756a().m9754a("98");
            if (c2657a.mo11229R().m10341d() == 2) {
                this.f13635r.m12787a().edit().putInt(RemoteModelActivity.f13406a, 1).commit();
                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_REMOTE_MODE)).setContent(getResources().getString(C2300R.C2303string.modelcannaljp));
            } else if (c2657a.mo11229R().m10341d() == 1) {
                this.f13635r.m12787a().edit().putInt(RemoteModelActivity.f13406a, 0).commit();
                this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_REMOTE_MODE)).setContent(getResources().getString(C2300R.C2303string.modelcannal));
            }
            if (this.f13624g != null) {
                this.f13624g.m8192a(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_REMOTE_MODE), this.f13623f.getChildAt(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_REMOTE_MODE)));
            }
        }
        switch (enumC2679a) {
            case Remotecontrol:
            case CLEANALLOBJ:
                if (!c2657a.mo11216ac()) {
                    this.f13642y = true;
                    return;
                } else if (!this.f13642y) {
                    return;
                } else {
                    this.f13642y = false;
                    this.f13621d.mo8107d();
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C3509i.EnumC3514d settingAdaptState = this.f13626i.get(i).getSettingAdaptState();
        if (settingAdaptState == C3509i.EnumC3514d.CONNECT_PLANE) {
            if (!this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.CONNECT_PLANE)).getIsOPen().booleanValue()) {
                return;
            }
            this.f13617X.removeCallbacksAndMessages(null);
            m8382n();
            this.f13635r.m12787a().edit().putBoolean(C2353b.f7920K, false).commit();
            Intent intent = new Intent(this.f13628k, LoginActivity.class);
            C2423d c2423d = (C2423d) C2379b.m12410a().m12394d();
            c2423d.n();
            c2423d.a(-1);
            intent.putExtra(AbstractC2089b.f6992j, 2);
            startActivityForResult(intent, 0);
        }
        if (settingAdaptState == C3509i.EnumC3514d.FIMWARE_UPDATE) {
            if (!this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FIMWARE_UPDATE)).getIsOPen().booleanValue()) {
                return;
            }
            if (m8380p()) {
                C2241c.m13122a().mo13115a(UpdateVersonBean.SP_NEED_DOWN_FIRMWWARES, (List) this.f13620c);
                Intent intent2 = new Intent(this.f13628k, FindOnlineFirmwareAvtivity.class);
                CameraValue.isFindFirmware = true;
                startActivity(intent2);
            } else if (this.f13619b == null || this.f13619b.size() <= 0) {
                C2284z.m12697a(this.f13628k, (int) C2300R.C2303string.version_tip);
            } else {
                Intent intent3 = new Intent(this.f13628k, FindNewFirmwareAvtivity.class);
                CameraValue.isFindFirmware = true;
                startActivity(intent3);
            }
        }
        if (settingAdaptState == C3509i.EnumC3514d.COMPASS_CALIBRATION) {
            Intent intent4 = new Intent(getActivity(), CaliCompassActivity.class);
            intent4.putExtra(C2353b.f7926Q, true);
            startActivity(intent4);
        }
        if (settingAdaptState == C3509i.EnumC3514d.GIMBAL_CALIBRATION) {
            startActivity(new Intent(this.f13628k, GimalCalibrationActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.GIMBAL_TUNE_PARAMETER) {
            startActivity(new Intent(this.f13628k, GimalTuneParameterActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.NEW_HAND_GUIDE) {
            this.f13635r.m12787a().edit().putBoolean(C2353b.f7920K, true).commit();
            startActivity(new Intent(this.f13628k, NewHandActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.NEW_HAND_MODE) {
            SwitchButton switchButton = (SwitchButton) view.findViewById(C2300R.C2302id.switch_btn);
            if (this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).getIsOPen().booleanValue()) {
                this.f13617X.sendEmptyMessageDelayed(7, 1000L);
            }
            this.f13621d.mo8114a(switchButton, this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)));
            this.f13624g.notifyDataSetChanged();
        }
        if (settingAdaptState == C3509i.EnumC3514d.GPS_MODE) {
            if (this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).getIsOPen().booleanValue()) {
                return;
            }
            Intent intent5 = new Intent(this.f13628k, GpsSettingActivity.class);
            intent5.putExtra(GpsSettingActivity.f13966b, this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).getIsOPen());
            intent5.putExtra(GpsSettingActivity.f13967c, this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).getIsOPen());
            intent5.putExtra(GpsSettingActivity.f13968d, this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).getIsOPen());
            this.f13628k.startActivity(intent5);
        }
        if (settingAdaptState == C3509i.EnumC3514d.SATELLITE_MAP) {
            SwitchButton switchButton2 = (SwitchButton) view.findViewById(C2300R.C2302id.switch_btn);
            if (C2582p.m11612a(this.f13628k).m11604e()) {
                switchButton2.m12667a(false, true);
                C2582p.m11612a(this.f13628k).m11601f(false);
                PreferenceManager.getDefaultSharedPreferences(this.f13628k).edit().putInt(C2854c.f10631s, 1).commit();
            } else {
                switchButton2.m12667a(true, true);
                C2582p.m11612a(this.f13628k).m11601f(true);
                PreferenceManager.getDefaultSharedPreferences(this.f13628k).edit().putInt(C2854c.f10631s, 2).commit();
            }
        }
        if (settingAdaptState == C3509i.EnumC3514d.SHOW_MORE_PAT) {
            startActivity(new Intent(this.f13628k, MoreInfoSettingAcitivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.CALIBRATION_REMOTE) {
            startActivity(new Intent(this.f13628k, RemoteCalibration.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.SWITCH_REMOTE_MODE) {
            if (this.f13632o.mo11216ac()) {
                C2284z.m12694a(this.f13628k, this.f13628k.getString(C2300R.C2303string.close_plane_switch_rocket), C2284z.f7606b);
                return;
            }
            startActivity(new Intent(this.f13628k, RemoteModelActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.CAMERA_SETTING) {
            this.f13618a = true;
            m8379q();
        }
        if (settingAdaptState == C3509i.EnumC3514d.HISTORY_MESSAGE) {
            startActivity(new Intent(this.f13628k, HistoryMessageActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.XIAOMI_ACCOUNT) {
            if (this.f13635r.m12787a().contains("isfirstloading")) {
                new DialogC3800f.C3801a(this.f13628k).m7031a(this.f13628k.getString(C2300R.C2303string.log_out)).m7023c(17).m7034a(getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(this.f13628k.getString(C2300R.C2303string.exit), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.MapSettingFragment.8
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        C2353b.m12513a(MapSettingFragment.this.f13628k);
                        ((Setting) MapSettingFragment.this.f13626i.get(MapSettingFragment.this.f13624g.m8188a(C3509i.EnumC3514d.XIAOMI_ACCOUNT))).setIsOPen(false);
                        MapSettingFragment.this.f13624g.m8185a(MapSettingFragment.this.f13626i);
                        MapSettingFragment.this.f13637t.m11513b(C2353b.m12507c(MapSettingFragment.this.f13628k), new AbstractC2538k() { // from class: com.fimi.soul.module.setting.MapSettingFragment.8.1
                            @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                            /* renamed from: a */
                            public void mo6501a(PlaneMsg planeMsg, File file) {
                            }
                        });
                        MapSettingFragment.this.f13635r.m12787a().edit().putBoolean(C2353b.f7920K, false).commit();
                        Intent intent6 = new Intent(MapSettingFragment.this.f13628k, LoginActivity.class);
                        intent6.putExtra(AbstractC2089b.f6992j, 4);
                        MapSettingFragment.this.startActivity(intent6);
                        ((FlightActivity) MapSettingFragment.this.f13628k).finish();
                        ((FlightActivity) MapSettingFragment.this.f13628k).overridePendingTransition(17432576, 17432577);
                    }
                }).m7030a(this.f13628k.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.MapSettingFragment.7
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }).m7035a().show();
            } else {
                this.f13635r.m12787a().edit().putBoolean(C2353b.f7920K, true).commit();
                Intent intent6 = new Intent(this.f13628k, LoginActivity.class);
                intent6.putExtra(AbstractC2089b.f6992j, 4);
                startActivity(intent6);
            }
        }
        if (settingAdaptState == C3509i.EnumC3514d.USER_FEEDBACK) {
            startActivity(new Intent(this.f13628k, UserFeedBackActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.CHECK_UPDATE) {
            C2284z.m12694a(this.f13628k, this.f13628k.getString(C2300R.C2303string.checking_update), C2284z.f7606b);
        }
        if (settingAdaptState == C3509i.EnumC3514d.ABOUT) {
            startActivity(new Intent(this.f13628k, AboutActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.BATTERY_INFO) {
            startActivity(new Intent(this.f13628k, BatteryInfoActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.OPTICAL_FLOW_MODE) {
            this.f13621d.mo8112a(this.f13626i, this.f13624g, this.f13602E);
        }
        if (settingAdaptState == C3509i.EnumC3514d.FORCED_ATTITUDE_MODE) {
            this.f13621d.mo8113a(this.f13626i, this.f13624g);
        }
        if (settingAdaptState == C3509i.EnumC3514d.FLIGHT_RECORD) {
            startActivity(new Intent(this.f13628k, FlyRecordActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.FLIGHT_INFO) {
            startActivity(new Intent(this.f13628k, FlyLogsActivity.class));
        } else if (settingAdaptState == C3509i.EnumC3514d.IMU_DETECTION && C2277v.m12784a(getActivity()).m12742s() == DeviceType.DEVICE_4K) {
            startActivity(new Intent(this.f13628k, IMU4KActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.PAIR_REMOTE) {
            startActivity(new Intent(this.f13628k, PairCodeActivity.class));
        }
        if (settingAdaptState == C3509i.EnumC3514d.XIAOMI_INSURENCE) {
            Intent intent7 = new Intent(this.f13628k, WebViewActivity.class);
            intent7.putExtra("url", ReceiveInsuranceActivity.f12938a);
            intent7.putExtra("title", getString(C2300R.C2303string.xiaomi_insurance));
            startActivity(intent7);
        }
        if (settingAdaptState == C3509i.EnumC3514d.SWITCH_RIGHT_MODE) {
            Intent intent8 = new Intent(this.f13628k, RightRollerSetActivity.class);
            intent8.putExtra("GPS_ATTI", this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).getIsOPen());
            intent8.putExtra("curModel", this.f13626i.get(this.f13624g.m8188a(C3509i.EnumC3514d.SWITCH_RIGHT_MODE)).getContent());
            getActivity().startActivityForResult(intent8, 100);
        }
        if (settingAdaptState == C3509i.EnumC3514d.RELAY_WIFI_CONFIGURE) {
            if (!this.f13632o.mo11217ab().mo10898a()) {
                C2284z.m12696a(getActivity(), (int) C2300R.C2303string.connectdefault, 3000);
            } else if (this.f13632o.m11320al()) {
                C2284z.m12696a(getActivity(), (int) C2300R.C2303string.relay_error_in_sky_tip, 3000);
                return;
            } else {
                m8376t();
            }
        }
        if (settingAdaptState != C3509i.EnumC3514d.FRONTLIGHTSSETTING || !m8398d()) {
            return;
        }
        m8396e();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onResume() {
        super.onResume();
        ((FlightActivity) this.f13628k).m8870j();
        ((FlightActivity) this.f13628k).m8868k();
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        m8379q();
        this.f13632o.mo11219a(this);
        this.f13633p = C3057d.m9823a(this.f13632o);
        this.f13633p.m9810g();
        this.f13603F = C2367d.m12459a().m12438k();
        if (this.f13621d == null) {
            this.f13621d = new C3531c(this.f13632o, this.f13628k);
        }
        this.f13609L = false;
        this.f13621d.mo8107d();
        this.f13617X.sendEmptyMessageDelayed(1, 500L);
        this.f13617X.sendEmptyMessageDelayed(1, 1000L);
        this.f13611N = C2353b.f7920K;
        this.f13612O = RemoteModelActivity.f13406a;
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f13632o.mo11214b(this);
    }
}
