package com.fimi.soul.module.setting.newhand;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.SeekBar;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.button.SwitchButton;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2574l;
import com.fimi.soul.biz.p188q.C2624a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.entity.FlyModeLog;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.Setting;
import com.fimi.soul.module.setting.C3509i;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.view.DialogC3800f;
import java.io.File;
import java.util.List;
/* renamed from: com.fimi.soul.module.setting.newhand.c */
/* loaded from: classes.dex */
public class C3531c extends AbstractC3544d {

    /* renamed from: C */
    private static final int f14190C = 3000;

    /* renamed from: D */
    private static final int f14191D = 1;

    /* renamed from: a */
    public static final int f14192a = 9;

    /* renamed from: b */
    public static final byte f14193b = 0;

    /* renamed from: c */
    public static final byte f14194c = 1;

    /* renamed from: d */
    public static final byte f14195d = 2;

    /* renamed from: e */
    public static final byte f14196e = 3;

    /* renamed from: f */
    public static final byte f14197f = 85;

    /* renamed from: g */
    public static final byte f14198g = -86;

    /* renamed from: h */
    public static final byte f14199h = 0;

    /* renamed from: i */
    public static final byte f14200i = 1;

    /* renamed from: j */
    public static final int f14201j = 60;

    /* renamed from: l */
    private static final int f14202l = 2;

    /* renamed from: m */
    private static final int f14203m = 3;

    /* renamed from: n */
    private static final int f14204n = 4;

    /* renamed from: o */
    private static final int f14205o = 5;

    /* renamed from: p */
    private static final int f14206p = 6;

    /* renamed from: q */
    private static final int f14207q = 7;

    /* renamed from: r */
    private static final int f14208r = 8;

    /* renamed from: s */
    private static final int f14209s = 9;

    /* renamed from: t */
    private static final int f14210t = 10;

    /* renamed from: u */
    private static final int f14211u = 11;

    /* renamed from: v */
    private static final String f14212v = "0";

    /* renamed from: w */
    private static final String f14213w = "1";

    /* renamed from: x */
    private static final String f14214x = "2";

    /* renamed from: A */
    private Context f14215A;

    /* renamed from: B */
    private C2624a f14216B;

    /* renamed from: k */
    C2657a f14218k;

    /* renamed from: y */
    private int f14219y = 0;

    /* renamed from: z */
    private int f14220z = 0;

    /* renamed from: E */
    private Handler f14217E = new Handler() { // from class: com.fimi.soul.module.setting.newhand.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (1 == message.what) {
                C3531c.this.m8119i();
            }
            switch (message.what) {
                case 2:
                    C3531c.this.m8130b((byte) 0);
                    return;
                case 3:
                    C3531c.this.m8130b((byte) 1);
                    return;
                case 4:
                    C3531c.this.mo8116a(2, 1);
                    return;
                case 5:
                    C3531c.this.mo8116a(2, 0);
                    return;
                case 6:
                    C3531c.this.mo8116a(4, 1);
                    return;
                case 7:
                    C3531c.this.mo8116a(4, 0);
                    return;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return;
            }
        }
    };

    public C3531c(C2657a c2657a, Context context) {
        this.f14218k = c2657a;
        this.f14215A = context;
        this.f14216B = C2624a.m11460a(context);
    }

    /* renamed from: a */
    private C2770c m8136a(byte b) {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 9;
        c2770c.f10263c = 135;
        c2770c.f10264d.m11055b(f14197f);
        c2770c.f10264d.m11055b(b);
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11054b(0);
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public FlyModeLog m8131a(String str) {
        int m7959a = ((C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class)).m7959a();
        int m7949f = ((C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class)).m7949f();
        FlyModeLog flyModeLog = new FlyModeLog();
        flyModeLog.setUserID(C2353b.m12507c(this.f14215A).getUserID());
        flyModeLog.setFcVersion(m7959a + "");
        flyModeLog.setOpenType(str);
        flyModeLog.setApplyTime(C3658ar.m7602b(System.currentTimeMillis()));
        flyModeLog.setX2Version(m7949f + "");
        flyModeLog.setAppType("0");
        return flyModeLog;
    }

    /* renamed from: b */
    private C2770c m8129b(int i, int i2) {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 9;
        c2770c.f10263c = 135;
        c2770c.f10264d.m11055b(f14197f);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 3);
        c2770c.f10264d.m11055b((byte) i);
        c2770c.f10264d.m11054b((int) ((byte) i2));
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8130b(byte b) {
        this.f14218k.mo11217ab().mo10897a(m8136a(b));
    }

    /* renamed from: c */
    private C2770c m8127c(int i) {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 9;
        c2770c.f10263c = 135;
        c2770c.f10264d.m11055b(f14197f);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 2);
        c2770c.f10264d.m11055b((byte) 7);
        c2770c.f10264d.m11055b((byte) (i & 255));
        c2770c.f10264d.m11055b((byte) ((i >> 8) & 255));
        c2770c.f10264d.m11055b((byte) ((i >> 16) & 255));
        c2770c.f10264d.m11055b((byte) ((i >> 24) & 255));
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* renamed from: d */
    private C2770c m8125d(int i) {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 9;
        c2770c.f10263c = 135;
        c2770c.f10264d.m11055b(f14197f);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 2);
        c2770c.f10264d.m11055b((byte) 3);
        c2770c.f10264d.m11055b((byte) (i & 255));
        c2770c.f10264d.m11055b((byte) ((i >> 8) & 255));
        c2770c.f10264d.m11055b((byte) ((i >> 16) & 255));
        c2770c.f10264d.m11055b((byte) ((i >> 24) & 255));
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* renamed from: e */
    private C2770c m8123e() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 9;
        c2770c.f10263c = 135;
        c2770c.f10264d.m11055b(f14198g);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11054b(0);
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* renamed from: f */
    private C2770c m8122f() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 9;
        c2770c.f10263c = 135;
        c2770c.f10264d.m11055b(f14198g);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 3);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11054b(0);
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* renamed from: g */
    private C2770c m8121g() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 9;
        c2770c.f10263c = 135;
        c2770c.f10264d.m11055b(f14198g);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 2);
        c2770c.f10264d.m11055b((byte) 7);
        c2770c.f10264d.m11054b(0);
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* renamed from: h */
    private C2770c m8120h() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 9;
        c2770c.f10263c = 135;
        c2770c.f10264d.m11055b(f14198g);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 2);
        c2770c.f10264d.m11055b((byte) 3);
        c2770c.f10264d.m11054b(0);
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m8119i() {
        if (C2238c.m13127b().mo12680b() == null || !C2238c.m13127b().mo12680b().isShowing()) {
            return;
        }
        C2238c.m13127b().mo12676c();
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: a */
    public void mo8118a() {
        this.f14218k.mo11217ab().mo10897a(m8121g());
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: a */
    public void mo8117a(int i) {
        this.f14218k.mo11217ab().mo10897a(m8127c(i));
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: a */
    public void mo8116a(int i, int i2) {
        this.f14218k.mo11217ab().mo10897a(m8129b(i, i2));
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: a */
    public void mo8115a(int i, final AbstractC3545e abstractC3545e) {
        this.f14219y = i;
        if (!this.f14218k.mo11216ac()) {
            C2284z.m12696a(this.f14215A, (int) C2300R.C2303string.set_new_hand_fail, C2284z.f7606b);
        } else if (this.f14218k.m11320al()) {
            C2284z.m12694a(this.f14215A, this.f14215A.getString(C2300R.C2303string.not_set_flight_distance_in_sky), C2284z.f7606b);
        } else if (i == 10000) {
            mo8117a(500);
            abstractC3545e.mo8106a(500);
        } else {
            final FlyModeLog m8131a = m8131a("2");
            new DialogC3800f.C3801a(this.f14215A).m7031a(this.f14215A.getString(C2300R.C2303string.setting_dialog_warm_hint)).m7025b(this.f14215A.getString(C2300R.C2303string.more_distance_cue)).m7034a(this.f14215A.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(this.f14215A.getString(C2300R.C2303string.setting_dialog_agree), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    C3531c.this.mo8117a(10000);
                    abstractC3545e.mo8106a(10000);
                    C3531c.this.f14216B.m11458a(m8131a);
                }
            }).m7030a(this.f14215A.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.c.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).m7035a().show();
        }
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: a */
    public void mo8114a(SwitchButton switchButton, Setting setting) {
        if (!this.f14218k.mo11216ac()) {
            C2284z.m12696a(this.f14215A, (int) C2300R.C2303string.set_new_hand_fail, C2284z.f7606b);
        } else if (this.f14218k.m11320al()) {
            C2284z.m12694a(this.f14215A, this.f14215A.getString(C2300R.C2303string.not_set_newhand_in_sky), C2284z.f7606b);
        } else if (setting.getIsOPen().booleanValue()) {
            switchButton.m12667a(false, true);
            m8130b((byte) 1);
        } else {
            switchButton.m12667a(true, true);
            m8130b((byte) 0);
        }
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: a */
    public void mo8113a(List<Setting> list, C3509i c3509i) {
        if (list.get(c3509i.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).getIsOPen().booleanValue()) {
            return;
        }
        if (!this.f14218k.mo11216ac()) {
            C2284z.m12696a(this.f14215A, (int) C2300R.C2303string.set_new_hand_fail, C2284z.f7606b);
        } else if (this.f14218k.m11320al()) {
            C2284z.m12694a(this.f14215A, this.f14215A.getString(C2300R.C2303string.not_set_attitude_in_sky), C2284z.f7606b);
        } else if (list.get(c3509i.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).getIsOPen().booleanValue()) {
            mo8116a(4, 0);
        } else {
            new DialogC3800f.C3801a(this.f14215A).m7031a(this.f14215A.getString(C2300R.C2303string.setting_dialog_warm_hint)).m7025b(this.f14215A.getString(C2300R.C2303string.force_attiyude_mode_delcare)).m7034a(this.f14215A.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(this.f14215A.getString(C2300R.C2303string.setting_dialog_agree), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.c.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    final FlyModeLog m8131a = C3531c.this.m8131a("1");
                    int m12748m = C2238c.m13123e().m12748m();
                    if (m12748m >= 2) {
                        C3531c.this.mo8116a(4, 1);
                        C3531c.this.f14216B.m11458a(m8131a);
                        return;
                    }
                    C2238c.m13123e().m12774c(m12748m + 1);
                    DialogC3800f.C3817e c3817e = new DialogC3800f.C3817e(C3531c.this.f14215A);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(C3531c.this.f14215A.getString(C2300R.C2303string.setting_dialog_button_force_attitude));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(C3531c.this.f14215A.getResources().getColor(C2300R.color.setting_dialog_force_attitude)), 5, 8, 33);
                    c3817e.m6967a(C2300R.C2301drawable.img_right_pulley).m6964a(spannableStringBuilder).m6962a(C3531c.this.f14215A.getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.c.9.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface2, int i2) {
                            C3531c.this.mo8116a(4, 1);
                            C3531c.this.f14216B.m11458a(m8131a);
                        }
                    }).m6968a().show();
                }
            }).m7030a(this.f14215A.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.c.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).m7035a().show();
        }
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: a */
    public void mo8112a(List<Setting> list, C3509i c3509i, final C2574l c2574l) {
        if (!list.get(c3509i.m8188a(C3509i.EnumC3514d.NEW_HAND_MODE)).getIsOPen().booleanValue() && !list.get(c3509i.m8188a(C3509i.EnumC3514d.FORCED_ATTITUDE_MODE)).getIsOPen().booleanValue()) {
            if (!this.f14218k.mo11216ac()) {
                C2284z.m12696a(this.f14215A, (int) C2300R.C2303string.set_new_hand_fail, C2284z.f7606b);
            } else if (this.f14218k.m11320al()) {
                C2284z.m12694a(this.f14215A, this.f14215A.getString(C2300R.C2303string.not_set_optical_flow_in_sky), C2284z.f7606b);
            } else if (list.get(c3509i.m8188a(C3509i.EnumC3514d.OPTICAL_FLOW_MODE)).getIsOPen().booleanValue()) {
                mo8116a(2, 0);
            } else {
                final FlyModeLog m8131a = m8131a("0");
                new DialogC3800f.C3801a(this.f14215A).m7031a(this.f14215A.getString(C2300R.C2303string.setting_dialog_warm_hint)).m7025b(this.f14215A.getString(C2300R.C2303string.assist_the_location_mode_to_open_please_be_careful_to_fly)).m7034a(this.f14215A.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(this.f14215A.getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.c.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C3531c.this.mo8116a(2, 1);
                        C3531c.this.f14216B.m11458a(m8131a);
                        c2574l.m11636a(C2353b.m12507c(C3531c.this.f14215A), C2574l.f8877b, new AbstractC2538k() { // from class: com.fimi.soul.module.setting.newhand.c.2.1
                            @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                            /* renamed from: a */
                            public void mo6501a(PlaneMsg planeMsg, File file) {
                                if (planeMsg.isSuccess()) {
                                }
                            }
                        });
                    }
                }).m7030a(this.f14215A.getString(C2300R.C2303string.refuse), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.c.10
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).m7035a().show();
            }
        }
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: b */
    public void mo8111b() {
        this.f14218k.mo11217ab().mo10897a(m8120h());
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: b */
    public void mo8110b(int i) {
        this.f14218k.mo11217ab().mo10897a(m8125d(i));
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: b */
    public void mo8109b(int i, AbstractC3545e abstractC3545e) {
        this.f14220z = i;
        if (!this.f14218k.mo11216ac()) {
            C2284z.m12696a(this.f14215A, (int) C2300R.C2303string.set_new_hand_fail, C2284z.f7606b);
        } else if (this.f14218k.m11320al()) {
            C2284z.m12694a(this.f14215A, this.f14215A.getString(C2300R.C2303string.not_set_flight_speed_in_sky), C2284z.f7606b);
        } else {
            new DialogC3800f.C3804b(this.f14215A).m7003c(this.f14215A.getString(C2300R.C2303string.flight_speed_limit)).m7017a(3).m7010b(C2367d.m12459a().m12438k() ? 16 : 18).m7002d(this.f14215A.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7013a(this.f14215A.getString(C2300R.C2303string.speed_unit_m)).m7008b(this.f14215A.getString(C2300R.C2303string.dialog_speed_unit)).m7011a(true).m7005c(Integer.parseInt(C2238c.m13123e().m12753i())).m7012a(this.f14215A.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.c.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).m7007b(this.f14215A.getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.newhand.c.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    C3531c.this.mo8110b(C3531c.this.f14220z);
                }
            }).m7016a(new SeekBar.OnSeekBarChangeListener() { // from class: com.fimi.soul.module.setting.newhand.c.5
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                    C3531c.this.f14220z = i2 + 3;
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            }).m7018a().show();
        }
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: c */
    public void mo8108c() {
        this.f14218k.mo11217ab().mo10897a(m8122f());
    }

    @Override // com.fimi.soul.module.setting.newhand.AbstractC3544d
    /* renamed from: d */
    public void mo8107d() {
        this.f14218k.mo11217ab().mo10897a(m8123e());
    }
}
