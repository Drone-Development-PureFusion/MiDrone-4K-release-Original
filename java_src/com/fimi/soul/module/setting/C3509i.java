package com.fimi.soul.module.setting;

import android.content.Context;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.view.button.SwitchButton;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p185n.C2574l;
import com.fimi.soul.biz.p185n.C2582p;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.entity.Setting;
import com.fimi.soul.module.droneui.FlightActivity;
import com.fimi.soul.utils.C3658ar;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.setting.i */
/* loaded from: classes.dex */
public class C3509i extends BaseAdapter implements SwitchButton.AbstractC2291a {

    /* renamed from: b */
    public static EnumC3514d[] f13893b = {EnumC3514d.IMU_DETECTION, EnumC3514d.GIMBAL_TUNE_PARAMETER};

    /* renamed from: c */
    public static EnumC3514d[] f13894c = new EnumC3514d[0];

    /* renamed from: k */
    private static final String f13895k = "SettingAdapt";

    /* renamed from: a */
    public AbstractC3513c f13896a;

    /* renamed from: d */
    private Context f13897d;

    /* renamed from: e */
    private List<Setting> f13898e;

    /* renamed from: f */
    private C2657a f13899f;

    /* renamed from: g */
    private AbstractC3512b f13900g;

    /* renamed from: h */
    private C2574l f13901h;

    /* renamed from: i */
    private AbstractC3511a f13902i;

    /* renamed from: j */
    private List<Integer> f13903j = new ArrayList();

    /* renamed from: com.fimi.soul.module.setting.i$a */
    /* loaded from: classes.dex */
    public interface AbstractC3511a {
        /* renamed from: l */
        void mo8184l();
    }

    /* renamed from: com.fimi.soul.module.setting.i$b */
    /* loaded from: classes.dex */
    public interface AbstractC3512b {
        /* renamed from: a */
        void mo8183a(SwitchButton switchButton);
    }

    /* renamed from: com.fimi.soul.module.setting.i$c */
    /* loaded from: classes.dex */
    public interface AbstractC3513c {
        /* renamed from: b */
        void mo8182b(int i);
    }

    /* renamed from: com.fimi.soul.module.setting.i$d */
    /* loaded from: classes.dex */
    public enum EnumC3514d {
        FLIGHT,
        CONNECT_PLANE,
        FIMWARE_UPDATE,
        COMPASS_CALIBRATION,
        NEW_HAND_GUIDE,
        NEW_HAND_MODE,
        GPS_MODE,
        OPTICAL_FLOW_MODE,
        FORCED_ATTITUDE_MODE,
        SHOW_MORE_PAT,
        IMU_DETECTION,
        FRONTLIGHTSSETTING,
        REMOTE,
        CALIBRATION_REMOTE,
        SWITCH_REMOTE_MODE,
        RELAY_WIFI_CONFIGURE,
        PAIR_REMOTE,
        SWITCH_RIGHT_MODE,
        BATTERY,
        BATTERY_INFO,
        GIMBAL,
        GIMBAL_CALIBRATION,
        GIMBAL_TUNE_PARAMETER,
        CAMERA,
        CAMERA_SETTING,
        MAP,
        SATELLITE_MAP,
        ACCOUNT,
        FLIGHT_RECORD,
        FLIGHT_INFO,
        USER_FEEDBACK,
        XIAOMI_INSURENCE,
        CHECK_UPDATE,
        ABOUT,
        HISTORY_MESSAGE,
        XIAOMI_ACCOUNT,
        BOTTOM_EDGE_LABLE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.module.setting.i$e */
    /* loaded from: classes.dex */
    public class C3515e {

        /* renamed from: a */
        TextView f13942a;

        /* renamed from: b */
        ImageView f13943b;

        /* renamed from: c */
        TextView f13944c;

        /* renamed from: d */
        TextView f13945d;

        /* renamed from: e */
        TextView f13946e;

        /* renamed from: f */
        ImageView f13947f;

        /* renamed from: g */
        TextView f13948g;

        /* renamed from: h */
        ImageView f13949h;

        /* renamed from: i */
        RelativeLayout f13950i;

        /* renamed from: j */
        SwitchButton f13951j;

        /* renamed from: k */
        TextView f13952k;

        private C3515e() {
        }

        /* renamed from: a */
        public View m8181a(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(C3509i.this.f13897d).inflate(C2300R.layout.adapt_setting, viewGroup, false);
            this.f13950i = (RelativeLayout) inflate.findViewById(C2300R.C2302id.rl);
            this.f13942a = (TextView) inflate.findViewById(C2300R.C2302id.setting_title_tv);
            this.f13943b = (ImageView) inflate.findViewById(C2300R.C2302id.general_setting_iv);
            this.f13944c = (TextView) inflate.findViewById(C2300R.C2302id.settig_coontent_tv);
            this.f13947f = (ImageView) inflate.findViewById(C2300R.C2302id.setting_more_iv);
            this.f13945d = (TextView) inflate.findViewById(C2300R.C2302id.switch_manul_tv);
            this.f13946e = (TextView) inflate.findViewById(C2300R.C2302id.switch_manul_child_tv);
            this.f13948g = (TextView) inflate.findViewById(C2300R.C2302id.setting_delcare);
            this.f13949h = (ImageView) inflate.findViewById(C2300R.C2302id.setting_point);
            this.f13951j = (SwitchButton) inflate.findViewById(C2300R.C2302id.switch_btn);
            this.f13952k = (TextView) inflate.findViewById(C2300R.C2302id.btn_set_model);
            C3658ar.m7612a(C3509i.this.f13897d.getAssets(), this.f13942a, this.f13944c, this.f13948g, this.f13945d, this.f13946e, this.f13952k);
            return inflate;
        }
    }

    public C3509i(Context context, C2657a c2657a) {
        this.f13897d = context;
        this.f13899f = c2657a;
        this.f13901h = C2574l.m11638a(context);
    }

    /* renamed from: a */
    private void m8187a(C3515e c3515e, ViewGroup.LayoutParams layoutParams) {
        c3515e.f13950i.setBackgroundResource(C2300R.C2301drawable.list_setting_selector);
        c3515e.f13942a.setVisibility(4);
        c3515e.f13947f.setVisibility(4);
        c3515e.f13943b.setVisibility(4);
        c3515e.f13951j.setVisibility(4);
        c3515e.f13949h.setVisibility(8);
        c3515e.f13948g.setVisibility(4);
        c3515e.f13945d.setVisibility(4);
        c3515e.f13946e.setVisibility(4);
        c3515e.f13944c.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_content));
        c3515e.f13945d.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_content));
        c3515e.f13946e.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_content_child));
        c3515e.f13948g.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_declare));
        c3515e.f13943b.setAlpha(1.0f);
        c3515e.f13951j.setAlpha(1.0f);
        c3515e.f13947f.setAlpha(1.0f);
        layoutParams.height = (int) this.f13897d.getResources().getDimension(C2300R.dimen.setting_adapt_height);
        c3515e.f13950i.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public int m8188a(EnumC3514d enumC3514d) {
        for (int i = 0; i < this.f13898e.size(); i++) {
            if (enumC3514d == this.f13898e.get(i).getSettingAdaptState()) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public void m8192a(int i, View view) {
        if (view != null && (view.getTag() instanceof C3515e)) {
            ((C3515e) view.getTag()).f13948g.setText(this.f13898e.get(i).getContent());
        }
    }

    @Override // com.fimi.kernel.view.button.SwitchButton.AbstractC2291a
    /* renamed from: a */
    public void mo6579a(View view, boolean z) {
        if (((Integer) view.getTag()).intValue() == m8188a(EnumC3514d.SATELLITE_MAP)) {
            if (C2582p.m11612a(this.f13897d).m11604e()) {
                C2582p.m11612a(this.f13897d).m11601f(false);
                PreferenceManager.getDefaultSharedPreferences(this.f13897d).edit().putInt(C2854c.f10631s, 1).commit();
            } else {
                C2582p.m11612a(this.f13897d).m11601f(true);
                PreferenceManager.getDefaultSharedPreferences(this.f13897d).edit().putInt(C2854c.f10631s, 2).commit();
            }
        }
        if (((Integer) view.getTag()).intValue() == m8188a(EnumC3514d.SHOW_MORE_PAT)) {
            if (C2238c.m13123e().m12771d()) {
                C2238c.m13123e().m12780a(false);
            } else {
                C2238c.m13123e().m12780a(true);
            }
            ((FlightActivity) this.f13897d).m8870j();
        }
        if (((Integer) view.getTag()).intValue() == m8188a(EnumC3514d.NEW_HAND_MODE)) {
            this.f13900g.mo8183a((SwitchButton) view.findViewWithTag(view.getTag()));
        }
        if (((Integer) view.getTag()).intValue() == m8188a(EnumC3514d.FORCED_ATTITUDE_MODE)) {
            SwitchButton switchButton = (SwitchButton) view.findViewWithTag(view.getTag());
            if (this.f13898e.get(m8188a(EnumC3514d.FORCED_ATTITUDE_MODE)).getIsOPen().booleanValue()) {
                switchButton.m12667a(true, false);
            } else {
                switchButton.m12667a(false, false);
            }
            if (this.f13898e.get(m8188a(EnumC3514d.NEW_HAND_MODE)).getIsOPen().booleanValue()) {
                return;
            }
            this.f13896a.mo8182b(4);
            notifyDataSetChanged();
        }
        if (((Integer) view.getTag()).intValue() == m8188a(EnumC3514d.OPTICAL_FLOW_MODE)) {
            SwitchButton switchButton2 = (SwitchButton) view.findViewWithTag(view.getTag());
            if (this.f13898e.get(m8188a(EnumC3514d.OPTICAL_FLOW_MODE)).getIsOPen().booleanValue()) {
                switchButton2.m12667a(true, false);
            } else {
                switchButton2.m12667a(false, false);
            }
            this.f13896a.mo8182b(2);
        }
    }

    /* renamed from: a */
    public void m8191a(AbstractC3511a abstractC3511a) {
        this.f13902i = abstractC3511a;
    }

    /* renamed from: a */
    public void m8190a(AbstractC3512b abstractC3512b) {
        this.f13900g = abstractC3512b;
    }

    /* renamed from: a */
    public void m8189a(AbstractC3513c abstractC3513c) {
        this.f13896a = abstractC3513c;
    }

    /* renamed from: a */
    public void m8185a(List<Setting> list) {
        this.f13898e = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f13898e == null) {
            return 0;
        }
        return this.f13898e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3515e c3515e;
        if (view == null) {
            C3515e c3515e2 = new C3515e();
            view = c3515e2.m8181a(viewGroup);
            view.setTag(c3515e2);
            c3515e = c3515e2;
        } else {
            c3515e = (C3515e) view.getTag();
        }
        if (this.f13898e != null) {
            m8187a(c3515e, view.getLayoutParams());
            EnumC3514d settingAdaptState = this.f13898e.get(i).getSettingAdaptState();
            if (settingAdaptState == EnumC3514d.FLIGHT) {
                c3515e.f13942a.setVisibility(0);
                c3515e.f13942a.setText(C2300R.C2303string.flight);
                c3515e.f13947f.setVisibility(4);
                c3515e.f13944c.setVisibility(4);
                c3515e.f13943b.setVisibility(4);
                c3515e.f13952k.setVisibility(4);
                c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
            }
            if (settingAdaptState == EnumC3514d.CONNECT_PLANE) {
                if (!this.f13898e.get(m8188a(EnumC3514d.CONNECT_PLANE)).getIsOPen().booleanValue()) {
                    c3515e.f13944c.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
                    c3515e.f13943b.setAlpha(0.3f);
                    c3515e.f13947f.setAlpha(0.3f);
                }
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13952k.setVisibility(4);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.connect_aircraft);
                c3515e.f13944c.setText(C2300R.C2303string.connect_plane);
            }
            if (settingAdaptState == EnumC3514d.FIMWARE_UPDATE) {
                if (!this.f13898e.get(m8188a(EnumC3514d.FIMWARE_UPDATE)).getIsOPen().booleanValue()) {
                    c3515e.f13944c.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
                    c3515e.f13943b.setAlpha(0.3f);
                    c3515e.f13947f.setAlpha(0.3f);
                }
                if (this.f13898e.get(m8188a(EnumC3514d.FIMWARE_UPDATE)).getIsOPen().booleanValue()) {
                    if (this.f13898e.get(m8188a(EnumC3514d.FIMWARE_UPDATE)).isDisplayTv()) {
                        c3515e.f13948g.setVisibility(0);
                        c3515e.f13948g.setText(this.f13897d.getResources().getString(C2300R.C2303string.new_firmware_upgrade));
                        c3515e.f13949h.setVisibility(0);
                    } else {
                        c3515e.f13949h.setVisibility(4);
                        c3515e.f13948g.setVisibility(4);
                    }
                }
                c3515e.f13952k.setVisibility(4);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.firmware_upgrade);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13944c.setText(C2300R.C2303string.refreshupdate);
            }
            if (settingAdaptState == EnumC3514d.COMPASS_CALIBRATION) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.compass_calibration);
                c3515e.f13944c.setText(C2300R.C2303string.compass_calibration);
            }
            if (settingAdaptState == EnumC3514d.NEW_HAND_GUIDE) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.new_hand_guide);
                c3515e.f13944c.setText(C2300R.C2303string.new_hand_guide);
            }
            if (settingAdaptState == EnumC3514d.NEW_HAND_MODE) {
                c3515e.f13944c.setVisibility(4);
                c3515e.f13945d.setVisibility(0);
                c3515e.f13946e.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13945d.setText(C2300R.C2303string.new_hand_mode);
                c3515e.f13946e.setText(C2300R.C2303string.newhand_mode_child);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.control_mode);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13951j.setVisibility(0);
                if (this.f13898e.get(m8188a(EnumC3514d.NEW_HAND_MODE)).getIsOPen().booleanValue()) {
                    c3515e.f13951j.m12667a(true, false);
                } else {
                    c3515e.f13951j.m12667a(false, false);
                }
                c3515e.f13951j.setAlpha(1.0f);
                c3515e.f13951j.setTag(Integer.valueOf(m8188a(EnumC3514d.NEW_HAND_MODE)));
                c3515e.f13951j.setOnSwitchListener(this);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = (int) this.f13897d.getResources().getDimension(C2300R.dimen.setting_adapt_switch);
                c3515e.f13950i.setLayoutParams(layoutParams);
                c3515e.f13947f.setVisibility(4);
            }
            if (settingAdaptState == EnumC3514d.GPS_MODE) {
                if (this.f13898e.get(m8188a(EnumC3514d.NEW_HAND_MODE)).getIsOPen().booleanValue()) {
                    c3515e.f13945d.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13946e.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
                    c3515e.f13947f.setAlpha(0.3f);
                    c3515e.f13943b.setAlpha(0.3f);
                }
                c3515e.f13944c.setVisibility(4);
                c3515e.f13945d.setVisibility(0);
                c3515e.f13946e.setVisibility(0);
                c3515e.f13945d.setText(C2300R.C2303string.gps_mode);
                c3515e.f13946e.setText(C2300R.C2303string.need_to_unlock_the_newhand_mode);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_gps);
                c3515e.f13943b.setVisibility(0);
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.height = (int) this.f13897d.getResources().getDimension(C2300R.dimen.setting_adapt_switch);
                c3515e.f13950i.setLayoutParams(layoutParams2);
            }
            if (settingAdaptState == EnumC3514d.OPTICAL_FLOW_MODE) {
                if (this.f13898e.get(m8188a(EnumC3514d.NEW_HAND_MODE)).getIsOPen().booleanValue() || this.f13898e.get(m8188a(EnumC3514d.FORCED_ATTITUDE_MODE)).getIsOPen().booleanValue()) {
                    c3515e.f13943b.setAlpha(0.3f);
                    c3515e.f13947f.setAlpha(0.3f);
                    c3515e.f13945d.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13946e.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
                    c3515e.f13951j.setAlpha(0.3f);
                } else {
                    c3515e.f13943b.setAlpha(1.0f);
                    c3515e.f13947f.setAlpha(1.0f);
                    c3515e.f13951j.setAlpha(1.0f);
                }
                c3515e.f13951j.setTag(Integer.valueOf(m8188a(EnumC3514d.OPTICAL_FLOW_MODE)));
                c3515e.f13951j.setOnSwitchListener(this);
                c3515e.f13944c.setVisibility(4);
                c3515e.f13945d.setVisibility(0);
                c3515e.f13946e.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13945d.setText(C2300R.C2303string.optical_flow_mode);
                c3515e.f13946e.setText(C2300R.C2303string.need_to_unlock_the_newhand_mode);
                c3515e.f13951j.setVisibility(0);
                if (this.f13898e.get(m8188a(EnumC3514d.OPTICAL_FLOW_MODE)).getIsOPen().booleanValue()) {
                    c3515e.f13951j.m12667a(true, false);
                } else {
                    c3515e.f13951j.m12667a(false, false);
                }
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_location_mode);
                ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                layoutParams3.height = (int) this.f13897d.getResources().getDimension(C2300R.dimen.setting_adapt_switch);
                c3515e.f13950i.setLayoutParams(layoutParams3);
            }
            if (settingAdaptState == EnumC3514d.FORCED_ATTITUDE_MODE) {
                if (this.f13898e.get(m8188a(EnumC3514d.NEW_HAND_MODE)).getIsOPen().booleanValue()) {
                    c3515e.f13943b.setAlpha(0.3f);
                    c3515e.f13947f.setAlpha(0.3f);
                    c3515e.f13945d.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13946e.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
                    c3515e.f13951j.setAlpha(0.3f);
                } else {
                    c3515e.f13943b.setAlpha(1.0f);
                    c3515e.f13947f.setAlpha(1.0f);
                    c3515e.f13951j.setAlpha(1.0f);
                }
                c3515e.f13945d.setVisibility(0);
                c3515e.f13944c.setVisibility(4);
                c3515e.f13946e.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13945d.setText(C2300R.C2303string.forced_attitude_mode);
                c3515e.f13946e.setText(C2300R.C2303string.need_to_unlock_the_newhand_mode);
                c3515e.f13951j.setVisibility(0);
                if (this.f13898e.get(m8188a(EnumC3514d.FORCED_ATTITUDE_MODE)).getIsOPen().booleanValue()) {
                    c3515e.f13951j.m12667a(true, false);
                } else {
                    c3515e.f13951j.m12667a(false, false);
                }
                c3515e.f13951j.setTag(Integer.valueOf(m8188a(EnumC3514d.FORCED_ATTITUDE_MODE)));
                c3515e.f13951j.setOnSwitchListener(this);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_posture_mode);
                ViewGroup.LayoutParams layoutParams4 = view.getLayoutParams();
                layoutParams4.height = (int) this.f13897d.getResources().getDimension(C2300R.dimen.setting_adapt_switch);
                c3515e.f13950i.setLayoutParams(layoutParams4);
            }
            if (settingAdaptState == EnumC3514d.SHOW_MORE_PAT) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.flight_parameter);
                c3515e.f13944c.setText(C2300R.C2303string.show_more_patter);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13947f.setVisibility(0);
            } else if (settingAdaptState == EnumC3514d.IMU_DETECTION) {
                c3515e.f13952k.setVisibility(4);
                if (!this.f13898e.get(m8188a(EnumC3514d.IMU_DETECTION)).getIsOPen().booleanValue()) {
                    c3515e.f13944c.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
                    c3515e.f13943b.setAlpha(0.3f);
                    c3515e.f13947f.setAlpha(0.3f);
                }
                c3515e.f13943b.setVisibility(0);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_imu);
                c3515e.f13946e.setVisibility(0);
                c3515e.f13945d.setVisibility(4);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13944c.setText(this.f13897d.getString(C2300R.C2303string.title_imu));
                c3515e.f13946e.setText("");
            }
            if (settingAdaptState == EnumC3514d.REMOTE) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(0);
                c3515e.f13942a.setText(C2300R.C2303string.remotecontrol);
                c3515e.f13947f.setVisibility(4);
                c3515e.f13944c.setVisibility(4);
                c3515e.f13943b.setVisibility(4);
                c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
            }
            if (settingAdaptState == EnumC3514d.CALIBRATION_REMOTE) {
                c3515e.f13952k.setVisibility(4);
                if (!this.f13898e.get(m8188a(EnumC3514d.CALIBRATION_REMOTE)).getIsOPen().booleanValue()) {
                    c3515e.f13944c.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
                    c3515e.f13943b.setAlpha(0.3f);
                    c3515e.f13947f.setAlpha(0.3f);
                }
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.the_remote_control_of_calibration);
                c3515e.f13944c.setText(C2300R.C2303string.calibration_remote);
            }
            if (settingAdaptState == EnumC3514d.SWITCH_REMOTE_MODE) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.switch_the_remote_control);
                c3515e.f13944c.setText(C2300R.C2303string.switch_remote_mode);
                c3515e.f13948g.setVisibility(0);
                c3515e.f13948g.setText(this.f13898e.get(m8188a(EnumC3514d.SWITCH_REMOTE_MODE)).getContent());
            }
            if (settingAdaptState == EnumC3514d.BATTERY) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(0);
                c3515e.f13942a.setText(C2300R.C2303string.battery);
                c3515e.f13947f.setVisibility(4);
                c3515e.f13944c.setVisibility(4);
                c3515e.f13943b.setVisibility(4);
                c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
            }
            if (settingAdaptState == EnumC3514d.SWITCH_RIGHT_MODE) {
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13944c.setText(C2300R.C2303string.right_scroll_mode);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_right_pulley_mode);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13951j.setVisibility(8);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13948g.setText(this.f13898e.get(m8188a(EnumC3514d.SWITCH_RIGHT_MODE)).getContent());
                c3515e.f13948g.setVisibility(0);
            }
            if (settingAdaptState == EnumC3514d.BATTERY_INFO) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_battery_parameters);
                c3515e.f13944c.setText(C2300R.C2303string.battery_info);
            }
            if (settingAdaptState == EnumC3514d.GIMBAL) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(0);
                c3515e.f13942a.setText(C2300R.C2303string.gimbal);
                c3515e.f13947f.setVisibility(4);
                c3515e.f13944c.setVisibility(4);
                c3515e.f13943b.setVisibility(4);
                c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
            }
            if (settingAdaptState == EnumC3514d.GIMBAL_CALIBRATION) {
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.gimbal_calibration);
                c3515e.f13944c.setText(C2300R.C2303string.gimbal_calibration);
            }
            if (settingAdaptState == EnumC3514d.GIMBAL_TUNE_PARAMETER) {
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_setup_adjust);
                c3515e.f13944c.setText(C2300R.C2303string.gimbal_tune_parameter);
            }
            if (settingAdaptState == EnumC3514d.MAP) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(0);
                c3515e.f13942a.setText(C2300R.C2303string.map);
                c3515e.f13947f.setVisibility(4);
                c3515e.f13944c.setVisibility(4);
                c3515e.f13943b.setVisibility(4);
                c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
            }
            if (settingAdaptState == EnumC3514d.SATELLITE_MAP) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.satellite_map);
                c3515e.f13944c.setText(C2300R.C2303string.sattlite_map);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13951j.setVisibility(0);
                if (C2582p.m11612a(this.f13897d).m11604e()) {
                    c3515e.f13951j.m12667a(true, false);
                } else {
                    c3515e.f13951j.m12667a(false, false);
                }
                c3515e.f13951j.setOnSwitchListener(this);
                c3515e.f13951j.setTag(Integer.valueOf(m8188a(EnumC3514d.SATELLITE_MAP)));
                c3515e.f13947f.setVisibility(4);
            }
            if (settingAdaptState == EnumC3514d.CAMERA) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(0);
                c3515e.f13942a.setText(C2300R.C2303string.camera);
                c3515e.f13947f.setVisibility(4);
                c3515e.f13944c.setVisibility(4);
                c3515e.f13943b.setVisibility(4);
                c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
            }
            if (settingAdaptState == EnumC3514d.CAMERA_SETTING) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.camera_settings);
                c3515e.f13944c.setText(C2300R.C2303string.camera_setting);
            }
            if (settingAdaptState == EnumC3514d.ACCOUNT) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(0);
                c3515e.f13942a.setText(C2300R.C2303string.account);
                c3515e.f13947f.setVisibility(4);
                c3515e.f13944c.setVisibility(4);
                c3515e.f13943b.setVisibility(4);
                c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
            }
            if (settingAdaptState == EnumC3514d.FLIGHT_RECORD) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_fly_record);
                c3515e.f13944c.setText(C2300R.C2303string.flight_record);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13947f.setVisibility(0);
            }
            if (settingAdaptState == EnumC3514d.FLIGHT_INFO) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_fly_log);
                c3515e.f13944c.setText(C2300R.C2303string.fly_logs);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13947f.setVisibility(0);
            }
            if (settingAdaptState == EnumC3514d.XIAOMI_INSURENCE) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_mi_insurance);
                c3515e.f13944c.setText(C2300R.C2303string.xiaomi_insurance);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13947f.setVisibility(0);
            }
            if (settingAdaptState == EnumC3514d.XIAOMI_ACCOUNT) {
                c3515e.f13952k.setVisibility(4);
                if (this.f13898e.get(m8188a(EnumC3514d.XIAOMI_ACCOUNT)).getIsOPen().booleanValue()) {
                    c3515e.f13948g.setText(this.f13898e.get(m8188a(EnumC3514d.XIAOMI_ACCOUNT)).getContent());
                    c3515e.f13947f.setVisibility(4);
                } else {
                    c3515e.f13948g.setText(C2300R.C2303string.exited);
                    c3515e.f13947f.setVisibility(0);
                }
                c3515e.f13944c.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.mi_id);
                c3515e.f13944c.setText(C2300R.C2303string.xiaomi_account);
                c3515e.f13948g.setVisibility(0);
            }
            if (settingAdaptState == EnumC3514d.USER_FEEDBACK) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_feedback);
                c3515e.f13944c.setText(C2300R.C2303string.user_feedback);
            }
            if (settingAdaptState == EnumC3514d.CHECK_UPDATE) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13947f.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.check_update);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13944c.setText(C2300R.C2303string.checkupdate);
                c3515e.f13944c.setVisibility(0);
                if (!this.f13898e.get(m8188a(EnumC3514d.CHECK_UPDATE)).getIsOPen().booleanValue()) {
                    c3515e.f13949h.setVisibility(0);
                    c3515e.f13948g.setVisibility(0);
                    c3515e.f13948g.setText(this.f13897d.getString(C2300R.C2303string.have_update) + this.f13898e.get(m8188a(EnumC3514d.CHECK_UPDATE)).getContent());
                }
            }
            if (settingAdaptState == EnumC3514d.ABOUT) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.about_icon);
                c3515e.f13944c.setText(C2300R.C2303string.about);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13947f.setVisibility(0);
            }
            if (settingAdaptState == EnumC3514d.HISTORY_MESSAGE) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_message);
                c3515e.f13944c.setText(C2300R.C2303string.setting_history_message);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13947f.setVisibility(0);
            }
            if (settingAdaptState == EnumC3514d.BOTTOM_EDGE_LABLE) {
                c3515e.f13952k.setVisibility(4);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13947f.setVisibility(4);
                c3515e.f13943b.setVisibility(4);
                c3515e.f13951j.setVisibility(4);
                c3515e.f13949h.setVisibility(4);
                c3515e.f13948g.setVisibility(4);
                c3515e.f13945d.setVisibility(4);
                c3515e.f13946e.setVisibility(4);
                c3515e.f13944c.setVisibility(4);
                ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
                layoutParams5.height = (int) this.f13897d.getResources().getDimension(C2300R.dimen.setting_adapt_bottom);
                c3515e.f13950i.setLayoutParams(layoutParams5);
                c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
            }
            if (settingAdaptState == EnumC3514d.PAIR_REMOTE) {
                c3515e.f13952k.setVisibility(4);
                if (!this.f13898e.get(m8188a(EnumC3514d.CALIBRATION_REMOTE)).getIsOPen().booleanValue()) {
                    c3515e.f13944c.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
                    c3515e.f13943b.setAlpha(0.3f);
                    c3515e.f13947f.setAlpha(0.3f);
                }
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.icon_match_code);
                c3515e.f13944c.setText(C2300R.C2303string.pair_setting_item);
            }
            if (settingAdaptState == EnumC3514d.RELAY_WIFI_CONFIGURE) {
                c3515e.f13952k.setVisibility(4);
                if (!this.f13898e.get(m8188a(EnumC3514d.CALIBRATION_REMOTE)).getIsOPen().booleanValue()) {
                    c3515e.f13944c.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
                    c3515e.f13943b.setAlpha(0.3f);
                    c3515e.f13947f.setAlpha(0.3f);
                }
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.setting_wifi_configure_icon);
                c3515e.f13944c.setText(C2300R.C2303string.relay_wifi_dialog);
            }
            if (settingAdaptState == EnumC3514d.FRONTLIGHTSSETTING) {
                if (!this.f13898e.get(m8188a(EnumC3514d.FRONTLIGHTSSETTING)).getIsOPen().booleanValue()) {
                    c3515e.f13944c.setTextColor(this.f13897d.getResources().getColor(C2300R.color.setting_ash));
                    c3515e.f13950i.setBackgroundResource(C2300R.color.list_nomal);
                    c3515e.f13943b.setAlpha(0.3f);
                    c3515e.f13947f.setAlpha(0.3f);
                }
                c3515e.f13947f.setVisibility(0);
                c3515e.f13944c.setVisibility(0);
                c3515e.f13942a.setVisibility(4);
                c3515e.f13943b.setVisibility(0);
                c3515e.f13952k.setVisibility(4);
                c3515e.f13943b.setBackgroundResource(C2300R.C2301drawable.white_brightness_icon);
                c3515e.f13944c.setText(C2300R.C2303string.front_lights_setting);
            }
        }
        return view;
    }
}
