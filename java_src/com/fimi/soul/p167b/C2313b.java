package com.fimi.soul.p167b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2259g;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.button.SwitchButton;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11DeviceInfo;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p203i.C2911f;
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.entity.DeviceType;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.view.DialogC3800f;
import java.io.File;
/* renamed from: com.fimi.soul.b.b */
/* loaded from: classes.dex */
public class C2313b extends BaseAdapter implements AdapterView.OnItemClickListener, AbstractC2388f<X11RespCmd> {

    /* renamed from: b */
    private static final float f7715b = 0.064f;

    /* renamed from: a */
    ListView f7716a;

    /* renamed from: c */
    private Context f7717c;

    /* renamed from: e */
    private int f7719e;

    /* renamed from: f */
    private int f7720f;

    /* renamed from: g */
    private int f7721g;

    /* renamed from: h */
    private int f7722h;

    /* renamed from: i */
    private boolean f7723i;

    /* renamed from: j */
    private String f7724j;

    /* renamed from: k */
    private String f7725k;

    /* renamed from: p */
    private boolean f7730p;

    /* renamed from: r */
    private C2657a f7732r;

    /* renamed from: s */
    private SharedPreferences f7733s;

    /* renamed from: t */
    private AbstractC2321a f7734t;

    /* renamed from: m */
    private boolean f7727m = true;

    /* renamed from: n */
    private boolean f7728n = false;

    /* renamed from: o */
    private boolean f7729o = false;

    /* renamed from: q */
    private boolean f7731q = true;

    /* renamed from: d */
    private C2423d f7718d = (C2423d) C2379b.m12410a().m12394d();

    /* renamed from: l */
    private X11DeviceInfo f7726l = this.f7718d.j().getX11DeviceInfo();

    /* renamed from: com.fimi.soul.b.b$a */
    /* loaded from: classes.dex */
    public interface AbstractC2321a {
        /* renamed from: a */
        boolean mo8374a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.b.b$b */
    /* loaded from: classes.dex */
    public class C2322b {

        /* renamed from: a */
        TextView f7742a;

        /* renamed from: b */
        TextView f7743b;

        /* renamed from: c */
        ImageView f7744c;

        /* renamed from: d */
        RelativeLayout f7745d;

        /* renamed from: e */
        SwitchButton f7746e;

        private C2322b() {
        }

        /* renamed from: a */
        public View m12576a(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(C2313b.this.f7717c).inflate(C2300R.layout.item_setting, viewGroup, false);
            this.f7745d = (RelativeLayout) inflate.findViewById(C2300R.C2302id.rl);
            this.f7742a = (TextView) inflate.findViewById(C2300R.C2302id.setting_title_tv);
            this.f7744c = (ImageView) inflate.findViewById(C2300R.C2302id.setting_arrow);
            this.f7743b = (TextView) inflate.findViewById(C2300R.C2302id.settig_coontent_tv);
            this.f7746e = (SwitchButton) inflate.findViewById(C2300R.C2302id.switch_btn);
            C3658ar.m7612a(C2313b.this.f7717c.getAssets(), this.f7742a, this.f7743b);
            return inflate;
        }

        /* renamed from: a */
        public void m12575a(boolean z) {
            this.f7745d.setClickable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.b.b$c */
    /* loaded from: classes.dex */
    public enum EnumC2323c {
        RECORD_TITLE,
        INDEX_RECORD_1080P_60,
        INDEX_RECORD_1080P_30,
        INDEX_RECORD_720P,
        VOLUME_RECORD_TITLE,
        VOLUME_RECORD_CONTENT,
        IMAGE_TITLE,
        INDEX_PHOTO_4V3_16M,
        INDEX_PHOTO_16V9_12M,
        INDEX_PHOTO_4V3_8M,
        GRID_TITLE,
        GRID_CONTENT,
        BRIGHTNESS_AUTO_CONTENT,
        TFCARD_TITLE,
        TFCARD_CONTENT,
        BOTTOM_ITEM
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.b.b$d */
    /* loaded from: classes.dex */
    public enum EnumC2324d {
        STANDARD_TITLE,
        INDEX_STANDARD_PAL,
        INDEX_STANDARD_NTSC,
        RECORD_TITLE,
        INDEX_RECORD_2160P_30P_4K,
        INDEX_RECORD_1440P_60P_4K,
        INDEX_RECORD_1080P_100P_4K,
        INDEX_RECORD_1080P_60P_4K,
        INDEX_RECORD_1080P_30P_4K,
        IMAGE_TITLE,
        INDEX_PHOTO_4V3_12M_4K,
        INDEX_PHOTO_16V9_8M_4K,
        IMAGE_FORMAT_TITLE,
        IMAGE_JPG,
        IMAGE_RAW,
        GRID_TITLE,
        GRID_CONTENT,
        BRIGHTNESS_AUTO_CONTENT,
        TFCARD_TITLE,
        TFCARD_CONTENT,
        RESERT,
        RESERT_CAMERA,
        BOTTOM_ITEM
    }

    public C2313b(Context context, C2657a c2657a) {
        this.f7723i = false;
        this.f7730p = false;
        this.f7732r = c2657a;
        this.f7717c = context;
        this.f7723i = C2379b.m12410a().m12397c();
        this.f7733s = C2277v.m12784a(context).m12787a();
        this.f7730p = c2657a.m11294g().m10304i();
        m12609a();
        m12582g();
    }

    /* renamed from: a */
    private void m12607a(C2322b c2322b) {
        if (this.f7728n) {
            c2322b.f7746e.m12667a(true, false);
        } else {
            c2322b.f7746e.m12667a(false, false);
        }
        c2322b.f7746e.setVisibility(0);
        c2322b.f7743b.setVisibility(0);
        c2322b.f7743b.setText(C2300R.C2303string.vedio_recording_audio);
        c2322b.f7746e.setOnSwitchListener(new SwitchButton.AbstractC2291a() { // from class: com.fimi.soul.b.b.1
            @Override // com.fimi.kernel.view.button.SwitchButton.AbstractC2291a
            /* renamed from: a */
            public void mo6579a(View view, boolean z) {
                SwitchButton switchButton = (SwitchButton) view.findViewById(C2300R.C2302id.switch_btn);
                if (!C2313b.this.m12580h()) {
                    C2284z.m12694a(C2313b.this.f7717c, C2313b.this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                    if (C2313b.this.f7728n) {
                        switchButton.m12667a(true, false);
                    } else {
                        switchButton.m12667a(false, false);
                    }
                } else if (!C2313b.this.m12580h()) {
                    C2284z.m12694a(C2313b.this.f7717c, C2313b.this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                    if (C2313b.this.f7728n) {
                        switchButton.m12667a(true, false);
                    } else {
                        switchButton.m12667a(false, false);
                    }
                } else {
                    if (C2313b.this.f7728n) {
                        C2313b.this.f7728n = false;
                        switchButton.m12667a(false, true);
                        C2313b.this.f7725k = C2427e.f8315cL;
                    } else {
                        C2313b.this.f7728n = true;
                        switchButton.m12667a(true, true);
                        C2313b.this.f7725k = C2427e.f8316cM;
                    }
                    C2313b.this.f7724j = C2427e.f8270bT;
                    if (!C2313b.this.f7727m) {
                        return;
                    }
                    C2313b.this.f7718d.m12233u().m12287f();
                }
            }
        });
    }

    /* renamed from: a */
    private void m12606a(C2322b c2322b, ViewGroup.LayoutParams layoutParams) {
        c2322b.f7742a.setVisibility(8);
        c2322b.f7746e.setVisibility(8);
        c2322b.f7745d.setBackgroundResource(0);
        c2322b.f7743b.setTextColor(this.f7717c.getResources().getColor(C2300R.color.white));
        c2322b.f7743b.setAlpha(1.0f);
        c2322b.f7744c.setVisibility(8);
        c2322b.f7746e.setOnSwitchListener(null);
        layoutParams.height = (int) this.f7717c.getResources().getDimension(C2300R.dimen.setting_adapt_height);
        c2322b.f7745d.setLayoutParams(layoutParams);
        c2322b.m12575a(false);
    }

    /* renamed from: a */
    private void m12605a(C2322b c2322b, String str) {
        c2322b.f7742a.setVisibility(0);
        c2322b.f7743b.setVisibility(0);
        c2322b.f7742a.setText(str);
        c2322b.f7743b.setVisibility(4);
        c2322b.f7745d.setBackgroundResource(C2300R.color.list_nomal);
        c2322b.m12575a(true);
    }

    /* renamed from: a */
    private void m12604a(C2322b c2322b, String str, boolean z) {
        c2322b.f7743b.setVisibility(0);
        c2322b.f7743b.setText(str);
        if (z) {
            c2322b.f7743b.setTextColor(this.f7717c.getResources().getColor(C2300R.color.option_choose));
            c2322b.f7744c.setVisibility(0);
        } else {
            c2322b.f7743b.setTextColor(this.f7717c.getResources().getColor(C2300R.color.white_90));
            c2322b.f7744c.setVisibility(4);
        }
        c2322b.m12575a(false);
    }

    /* renamed from: b */
    private void m12597b(C2322b c2322b) {
        this.f7729o = C2238c.m13123e().m12749l();
        if (this.f7729o) {
            c2322b.f7746e.m12667a(true, false);
        } else {
            c2322b.f7746e.m12667a(false, false);
        }
        c2322b.f7746e.setVisibility(0);
        c2322b.f7743b.setVisibility(0);
        c2322b.f7743b.setText(C2300R.C2303string.grid_line_set);
        c2322b.f7746e.setOnSwitchListener(new SwitchButton.AbstractC2291a() { // from class: com.fimi.soul.b.b.2
            @Override // com.fimi.kernel.view.button.SwitchButton.AbstractC2291a
            /* renamed from: a */
            public void mo6579a(View view, boolean z) {
                SwitchButton switchButton = (SwitchButton) view.findViewById(C2300R.C2302id.switch_btn);
                if (z) {
                    C2238c.m13123e().m12764e(true);
                    C2313b.this.f7732r.mo11220a(C2678d.EnumC2679a.Show9Grid);
                    C2313b.this.f7729o = true;
                    switchButton.setSwitchState(true);
                    return;
                }
                C2238c.m13123e().m12764e(false);
                C2313b.this.f7732r.mo11220a(C2678d.EnumC2679a.hide9Grid);
                C2313b.this.f7729o = false;
                switchButton.setSwitchState(false);
            }
        });
    }

    /* renamed from: b */
    private void m12596b(C2322b c2322b, ViewGroup.LayoutParams layoutParams) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f7717c).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.height = displayMetrics.heightPixels * 0;
        c2322b.f7745d.setLayoutParams(layoutParams);
        c2322b.f7745d.setBackgroundResource(C2300R.color.list_nomal);
    }

    /* renamed from: b */
    private void m12595b(C2322b c2322b, String str, boolean z) {
        c2322b.f7743b.setVisibility(0);
        c2322b.f7746e.setVisibility(0);
        c2322b.f7743b.setText(str);
        c2322b.f7746e.setSwitchState(z);
    }

    /* renamed from: c */
    private void m12590c(C2322b c2322b) {
        if (this.f7730p) {
            c2322b.f7746e.m12667a(true, false);
        } else {
            c2322b.f7746e.m12667a(false, false);
        }
        c2322b.f7746e.setVisibility(0);
        c2322b.f7743b.setVisibility(0);
        c2322b.f7743b.setText(C2300R.C2303string.auto_chage_brightness);
        this.f7716a.setTag(c2322b.f7746e);
        c2322b.f7746e.setClickable(false);
        c2322b.f7746e.setOnSwitchListener(new SwitchButton.AbstractC2291a() { // from class: com.fimi.soul.b.b.3
            @Override // com.fimi.kernel.view.button.SwitchButton.AbstractC2291a
            /* renamed from: a */
            public void mo6579a(View view, boolean z) {
                SwitchButton switchButton = (SwitchButton) view.findViewById(C2300R.C2302id.switch_btn);
                if (C2313b.this.f7734t.mo8374a()) {
                    C2284z.m12696a(C2313b.this.f7717c, (int) C2300R.C2303string.front_lights_setting_app_enable_tip3, 3000);
                    switchButton.setSwitchState(C2313b.this.f7730p);
                } else if (!C2313b.this.f7732r.mo11216ac()) {
                    C2284z.m12694a(C2313b.this.f7717c, C2313b.this.f7717c.getString(C2300R.C2303string.front_lights_setting_no_connect), C2284z.f7606b);
                    switchButton.setSwitchState(C2313b.this.f7730p);
                } else if (!C2313b.this.m12586e()) {
                    switchButton.setSwitchState(false);
                } else if (z) {
                    C2313b.this.m12600a(true);
                } else {
                    C2313b.this.m12600a(false);
                }
            }
        });
    }

    /* renamed from: g */
    private void m12582g() {
        String videoResolution = this.f7718d.j().getVideoResolution();
        String photoSize = this.f7718d.j().getPhotoSize();
        String image_format = this.f7718d.j().getImage_format();
        if (videoResolution == null) {
            return;
        }
        if (videoResolution != null) {
            videoResolution = videoResolution.trim();
        }
        if (photoSize != null) {
            photoSize = photoSize.trim();
        }
        if (this.f7727m) {
            if ("1920x1080 30P 16:9".contains(videoResolution)) {
                this.f7720f = EnumC2323c.INDEX_RECORD_1080P_30.ordinal();
            }
            if ("1920x1080 60P 16:9".contains(videoResolution)) {
                this.f7720f = EnumC2323c.INDEX_RECORD_1080P_60.ordinal();
            }
            if (C2427e.f8338cj.contains(videoResolution)) {
                this.f7720f = EnumC2323c.INDEX_RECORD_720P.ordinal();
            }
            if (photoSize != null) {
                if (C2427e.f8340cl.contains(photoSize)) {
                    this.f7719e = EnumC2323c.INDEX_PHOTO_16V9_12M.ordinal();
                }
                if (C2427e.f8339ck.contains(photoSize)) {
                    this.f7719e = EnumC2323c.INDEX_PHOTO_4V3_16M.ordinal();
                }
                if (C2427e.f8341cm.contains(photoSize)) {
                    this.f7719e = EnumC2323c.INDEX_PHOTO_4V3_8M.ordinal();
                }
            }
        } else {
            if (C2427e.f8306cC.equals(this.f7718d.j().getSystemType())) {
                this.f7731q = false;
                this.f7722h = EnumC2324d.INDEX_STANDARD_PAL.ordinal();
            } else {
                this.f7731q = true;
                this.f7722h = EnumC2324d.INDEX_STANDARD_NTSC.ordinal();
            }
            if (C2427e.f8342cn.contains(videoResolution) || C2427e.f8347cs.contains(videoResolution)) {
                this.f7720f = EnumC2324d.INDEX_RECORD_2160P_30P_4K.ordinal();
            }
            if (C2427e.f8343co.contains(videoResolution) || C2427e.f8348ct.contains(videoResolution)) {
                this.f7720f = EnumC2324d.INDEX_RECORD_1440P_60P_4K.ordinal();
            }
            if ("1920x1080 30P 16:9".contains(videoResolution) || C2427e.f8351cw.contains(videoResolution)) {
                this.f7720f = EnumC2324d.INDEX_RECORD_1080P_30P_4K.ordinal();
            }
            if ("1920x1080 60P 16:9".contains(videoResolution) || C2427e.f8350cv.contains(videoResolution)) {
                this.f7720f = EnumC2324d.INDEX_RECORD_1080P_60P_4K.ordinal();
            }
            if ("1920x1080 100P 16:9".contains(videoResolution) || "1920x1080 100P 16:9".contains(videoResolution)) {
                this.f7720f = EnumC2324d.INDEX_RECORD_1080P_100P_4K.ordinal();
            }
            if (photoSize != null) {
                if (C2427e.f8352cx.contains(photoSize)) {
                    this.f7719e = EnumC2324d.INDEX_PHOTO_4V3_12M_4K.ordinal();
                }
                if (C2427e.f8353cy.contains(photoSize)) {
                    this.f7719e = EnumC2324d.INDEX_PHOTO_16V9_8M_4K.ordinal();
                }
            }
            if (image_format != null && !"".equals(image_format)) {
                if (C2427e.f8354cz.equals(image_format)) {
                    this.f7721g = EnumC2324d.IMAGE_JPG.ordinal();
                }
                if (C2427e.f8304cA.equals(image_format)) {
                    this.f7721g = EnumC2324d.IMAGE_RAW.ordinal();
                }
            }
        }
        if (C2427e.f8315cL.equals(this.f7718d.j().getVideoMode())) {
            this.f7728n = false;
        } else {
            this.f7728n = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m12580h() {
        return this.f7718d.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m12578i() {
        this.f7718d.m12233u().m12287f();
        this.f7724j = C2427e.f8274bX;
        this.f7725k = C2427e.f8307cD;
        C2238c.m13123e().m12764e(false);
        m12600a(false);
    }

    /* renamed from: a */
    public void m12609a() {
        if (C2277v.m12784a(this.f7717c).m12742s() == DeviceType.DEVICE_4K) {
            this.f7727m = false;
        } else {
            this.f7727m = true;
        }
        this.f7718d.m12233u().m12296b();
    }

    /* renamed from: a */
    public void m12608a(AbstractC2321a abstractC2321a) {
        this.f7734t = abstractC2321a;
    }

    /* renamed from: a */
    public void m12600a(boolean z) {
        C2911f m11294g = this.f7732r.m11294g();
        this.f7732r.mo11217ab().mo10897a(m11294g.m10316a(z, m11294g));
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        switch (x11RespCmd.getMsg_id()) {
            case 2:
                if (!z) {
                    if (x11RespCmd.getType() != null) {
                        C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.setting_false), C2284z.f7607c);
                    }
                    C2238c.m13127b().mo12676c();
                    return;
                } else if (C2427e.f8252bB.equals(x11RespCmd.getType()) || "menu_album".equals(x11RespCmd.getType())) {
                    return;
                } else {
                    C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_success), C2284z.f7607c);
                    this.f7718d.m12233u().m12296b();
                    return;
                }
            case 3:
                C2238c.m13127b().mo12676c();
                m12582g();
                notifyDataSetChanged();
                return;
            case 4:
                if (z) {
                    C2259g.m12987b(new File(C3681j.m7465n()));
                    C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.format_success), C2284z.f7607c);
                    this.f7718d.m12233u().m12290d(C2427e.f8324cU);
                    this.f7718d.a(true);
                } else {
                    C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.format_fail), C2284z.f7607c);
                }
                C2238c.m13127b().mo12676c();
                return;
            case 11:
                this.f7718d.m12233u().m12296b();
                return;
            case 257:
                if (z) {
                    return;
                }
                C2238c.m13127b().mo12676c();
                return;
            case C2427e.f8177G /* 260 */:
                CameraValue.isCameraParameterChange = true;
                this.f7718d.m12233u().m12298a(this.f7724j, this.f7725k);
                C2238c.m13127b().mo12687a();
                if (this.f7726l.getChip() != null) {
                    return;
                }
                this.f7718d.m12233u().m12291d();
                return;
            case C2427e.f8232ai /* 10066329 */:
                C2238c.m13127b().mo12676c();
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public void m12598b() {
        if (this.f7718d != null) {
            this.f7718d.a(this);
            if (!C2367d.m12459a().m12436m() || this.f7718d.e()) {
                return;
            }
            C2238c.m13127b().mo12687a();
            this.f7718d.m12231w().m12240b();
        }
    }

    /* renamed from: c */
    public void m12591c() {
        SwitchButton switchButton = (SwitchButton) this.f7716a.getTag();
        if (this.f7734t.mo8374a()) {
            C2284z.m12696a(this.f7717c, (int) C2300R.C2303string.front_lights_setting_app_enable_tip3, 3000);
        } else if (!this.f7732r.mo11216ac()) {
            C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.front_lights_setting_no_connect), C2284z.f7606b);
        } else if (switchButton.getToggleOn()) {
            m12600a(false);
        } else {
            m12600a(true);
        }
    }

    /* renamed from: d */
    public void m12588d() {
        SwitchButton switchButton = (SwitchButton) this.f7716a.getTag();
        if (this.f7732r.m11294g().m10303j()) {
            this.f7730p = this.f7732r.m11294g().m10304i();
        } else {
            C2284z.m12696a(this.f7717c, (int) C2300R.C2303string.setting_false, 3000);
        }
        if (switchButton != null) {
            switchButton.setSwitchState(this.f7730p);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m12586e() {
        boolean z;
        if (!this.f7732r.mo11216ac()) {
            C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.front_lights_setting_no_connect), C2284z.f7606b);
            return false;
        }
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        if (c3580b != null && c3580b.m7959a() > 0) {
            if (c3580b.m7959a() >= (this.f7727m ? 1902 : 1067)) {
                z = true;
                if (!z) {
                    return z;
                }
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.fc_update_tip), C2284z.f7606b);
                return z;
            }
        }
        z = false;
        if (!z) {
        }
    }

    /* renamed from: f */
    public boolean m12584f() {
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        boolean z = c3580b != null && c3580b.m7935m() > 0 && c3580b.m7935m() >= 1063;
        if (!z) {
            C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.camera_menu_update_tip), C2284z.f7606b);
        }
        return z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7727m ? EnumC2323c.values().length : EnumC2324d.values().length;
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
        C2322b c2322b;
        boolean z = true;
        if (view == null) {
            c2322b = new C2322b();
            view = c2322b.m12576a(viewGroup);
            view.setTag(c2322b);
            this.f7716a = (ListView) viewGroup;
        } else {
            c2322b = (C2322b) view.getTag();
        }
        m12606a(c2322b, view.getLayoutParams());
        if (this.f7727m) {
            if (i == EnumC2323c.RECORD_TITLE.ordinal()) {
                m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.record_title));
            } else if (i == EnumC2323c.INDEX_RECORD_1080P_30.ordinal()) {
                String string = this.f7717c.getString(C2300R.C2303string.option_video_1080_30f);
                if (this.f7720f != EnumC2323c.INDEX_RECORD_1080P_30.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string, z);
            } else if (i == EnumC2323c.INDEX_RECORD_1080P_60.ordinal()) {
                String string2 = this.f7717c.getString(C2300R.C2303string.option_video_1080p_60);
                if (this.f7720f != EnumC2323c.INDEX_RECORD_1080P_60.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string2, z);
            } else if (i == EnumC2323c.INDEX_RECORD_720P.ordinal()) {
                if (this.f7720f != EnumC2323c.INDEX_RECORD_720P.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, "1280x720", z);
            } else if (i == EnumC2323c.IMAGE_TITLE.ordinal()) {
                m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.photo));
            } else if (i == EnumC2323c.INDEX_PHOTO_4V3_16M.ordinal()) {
                String string3 = this.f7717c.getString(C2300R.C2303string.option_photo_16M);
                if (this.f7719e != EnumC2323c.INDEX_PHOTO_4V3_16M.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string3, z);
            } else if (i == EnumC2323c.INDEX_PHOTO_16V9_12M.ordinal()) {
                String string4 = this.f7717c.getString(C2300R.C2303string.option_photo_12M);
                if (this.f7719e != EnumC2323c.INDEX_PHOTO_16V9_12M.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string4, z);
            } else if (i == EnumC2323c.INDEX_PHOTO_4V3_8M.ordinal()) {
                String string5 = this.f7717c.getString(C2300R.C2303string.option_photo_8M);
                if (this.f7719e != EnumC2323c.INDEX_PHOTO_4V3_8M.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string5, z);
            } else if (i == EnumC2323c.TFCARD_TITLE.ordinal()) {
                m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.sdcard_operation));
            } else if (i == EnumC2323c.TFCARD_CONTENT.ordinal()) {
                c2322b.f7743b.setVisibility(0);
                c2322b.f7743b.setText(this.f7717c.getString(C2300R.C2303string.camera_sd_format));
                c2322b.f7743b.setTextColor(this.f7717c.getResources().getColor(C2300R.color.white_90));
            } else if (i == EnumC2323c.VOLUME_RECORD_TITLE.ordinal()) {
                m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.audio_title));
            } else if (i == EnumC2323c.VOLUME_RECORD_CONTENT.ordinal()) {
                m12607a(c2322b);
            } else if (i == EnumC2323c.BOTTOM_ITEM.ordinal()) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = (int) this.f7717c.getResources().getDimension(C2300R.dimen.setting_adapt_bottom);
                c2322b.f7745d.setLayoutParams(layoutParams);
                c2322b.f7745d.setBackgroundResource(C2300R.color.list_nomal);
                c2322b.f7742a.setVisibility(8);
                c2322b.f7746e.setVisibility(8);
                c2322b.f7744c.setVisibility(8);
                c2322b.f7743b.setVisibility(8);
                c2322b.m12575a(false);
            } else if (i == EnumC2323c.GRID_TITLE.ordinal()) {
                m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.grid_lines_others));
            } else if (i == EnumC2323c.GRID_CONTENT.ordinal()) {
                m12597b(c2322b);
                c2322b.f7746e.setTag(Integer.valueOf(EnumC2323c.GRID_CONTENT.ordinal()));
            } else if (i == EnumC2323c.BRIGHTNESS_AUTO_CONTENT.ordinal()) {
                m12590c(c2322b);
                c2322b.f7746e.setTag(Integer.valueOf(EnumC2323c.BRIGHTNESS_AUTO_CONTENT.ordinal()));
            }
        } else if (i == EnumC2324d.STANDARD_TITLE.ordinal()) {
            m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.media_setting_standard));
        } else if (i == EnumC2324d.INDEX_STANDARD_PAL.ordinal()) {
            String string6 = this.f7717c.getString(C2300R.C2303string.media_setting_standard_pal);
            if (this.f7722h != EnumC2324d.INDEX_STANDARD_PAL.ordinal()) {
                z = false;
            }
            m12604a(c2322b, string6, z);
        } else if (i == EnumC2324d.INDEX_STANDARD_NTSC.ordinal()) {
            String string7 = this.f7717c.getString(C2300R.C2303string.media_setting_standard_ntsc);
            if (this.f7722h != EnumC2324d.INDEX_STANDARD_NTSC.ordinal()) {
                z = false;
            }
            m12604a(c2322b, string7, z);
        } else if (i == EnumC2324d.RECORD_TITLE.ordinal()) {
            m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.record_title));
        } else if (i == EnumC2324d.INDEX_RECORD_1440P_60P_4K.ordinal()) {
            if (this.f7731q) {
                String string8 = this.f7717c.getString(C2300R.C2303string.option_video_1440p_60_4k);
                if (this.f7720f != EnumC2324d.INDEX_RECORD_1440P_60P_4K.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string8, z);
            } else {
                String string9 = this.f7717c.getString(C2300R.C2303string.option_video_1440p_50_pal_4k);
                if (this.f7720f != EnumC2324d.INDEX_RECORD_1440P_60P_4K.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string9, z);
            }
        } else if (i == EnumC2324d.INDEX_RECORD_1080P_30P_4K.ordinal()) {
            if (this.f7731q) {
                String string10 = this.f7717c.getString(C2300R.C2303string.option_video_1080p_30_4k);
                if (this.f7720f != EnumC2324d.INDEX_RECORD_1080P_30P_4K.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string10, z);
            } else {
                String string11 = this.f7717c.getString(C2300R.C2303string.option_video_1080p_25_pal_4k);
                if (this.f7720f != EnumC2324d.INDEX_RECORD_1080P_30P_4K.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string11, z);
            }
        } else if (i == EnumC2324d.INDEX_RECORD_1080P_60P_4K.ordinal()) {
            if (this.f7731q) {
                String string12 = this.f7717c.getString(C2300R.C2303string.option_video_1080p_60_4k);
                if (this.f7720f != EnumC2324d.INDEX_RECORD_1080P_60P_4K.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string12, z);
            } else {
                String string13 = this.f7717c.getString(C2300R.C2303string.option_video_1080p_50_pal_4k);
                if (this.f7720f != EnumC2324d.INDEX_RECORD_1080P_60P_4K.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string13, z);
            }
        } else if (i == EnumC2324d.INDEX_RECORD_1080P_100P_4K.ordinal()) {
            if (this.f7731q) {
                String string14 = this.f7717c.getString(C2300R.C2303string.option_video_1080p_100_4k);
                if (this.f7720f != EnumC2324d.INDEX_RECORD_1080P_100P_4K.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string14, z);
            } else {
                String string15 = this.f7717c.getString(C2300R.C2303string.option_video_1080p_100_pal_4k);
                if (this.f7720f != EnumC2324d.INDEX_RECORD_1080P_100P_4K.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string15, z);
            }
        } else if (i == EnumC2324d.INDEX_RECORD_2160P_30P_4K.ordinal()) {
            if (this.f7731q) {
                String string16 = this.f7717c.getString(C2300R.C2303string.option_video_2160p_30_4k);
                if (this.f7720f != EnumC2324d.INDEX_RECORD_2160P_30P_4K.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string16, z);
            } else {
                String string17 = this.f7717c.getString(C2300R.C2303string.option_video_2160p_25_pal_4k);
                if (this.f7720f != EnumC2324d.INDEX_RECORD_2160P_30P_4K.ordinal()) {
                    z = false;
                }
                m12604a(c2322b, string17, z);
            }
        } else if (i == EnumC2324d.IMAGE_TITLE.ordinal()) {
            m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.photo));
        } else if (i == EnumC2324d.INDEX_PHOTO_4V3_12M_4K.ordinal()) {
            String string18 = this.f7717c.getString(C2300R.C2303string.option_photo_12M_4k);
            if (this.f7719e != EnumC2324d.INDEX_PHOTO_4V3_12M_4K.ordinal()) {
                z = false;
            }
            m12604a(c2322b, string18, z);
        } else if (i == EnumC2324d.INDEX_PHOTO_16V9_8M_4K.ordinal()) {
            String string19 = this.f7717c.getString(C2300R.C2303string.option_photo_8M_4k);
            if (this.f7719e != EnumC2324d.INDEX_PHOTO_16V9_8M_4K.ordinal()) {
                z = false;
            }
            m12604a(c2322b, string19, z);
        } else if (i == EnumC2324d.TFCARD_TITLE.ordinal()) {
            m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.sdcard_operation));
        } else if (i == EnumC2324d.TFCARD_CONTENT.ordinal()) {
            c2322b.f7743b.setVisibility(0);
            c2322b.f7743b.setText(this.f7717c.getString(C2300R.C2303string.camera_sd_format));
            c2322b.f7743b.setTextColor(this.f7717c.getResources().getColor(C2300R.color.white_90));
        } else if (i == EnumC2324d.IMAGE_FORMAT_TITLE.ordinal()) {
            m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.image_format));
        } else if (i == EnumC2324d.IMAGE_JPG.ordinal()) {
            String string20 = this.f7717c.getString(C2300R.C2303string.image_jpg);
            if (this.f7721g != EnumC2324d.IMAGE_JPG.ordinal()) {
                z = false;
            }
            m12604a(c2322b, string20, z);
        } else if (i == EnumC2324d.IMAGE_RAW.ordinal()) {
            String string21 = this.f7717c.getString(C2300R.C2303string.image_raw);
            if (this.f7721g != EnumC2324d.IMAGE_RAW.ordinal()) {
                z = false;
            }
            m12604a(c2322b, string21, z);
        } else if (i == EnumC2324d.GRID_TITLE.ordinal()) {
            m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.grid_lines_others));
        } else if (i == EnumC2324d.GRID_CONTENT.ordinal()) {
            m12597b(c2322b);
            c2322b.f7746e.setTag(Integer.valueOf(EnumC2324d.GRID_CONTENT.ordinal()));
        } else if (i == EnumC2324d.BRIGHTNESS_AUTO_CONTENT.ordinal()) {
            m12590c(c2322b);
            c2322b.f7746e.setTag(Integer.valueOf(EnumC2324d.BRIGHTNESS_AUTO_CONTENT.ordinal()));
        } else if (i == EnumC2324d.RESERT.ordinal()) {
            m12605a(c2322b, this.f7717c.getString(C2300R.C2303string.camera_setting_resert));
        } else if (i == EnumC2324d.RESERT_CAMERA.ordinal()) {
            c2322b.f7743b.setVisibility(0);
            c2322b.f7743b.setText(this.f7717c.getString(C2300R.C2303string.camera_setting_resert_camera_setting));
            c2322b.f7743b.setTextColor(this.f7717c.getResources().getColor(C2300R.color.white_90));
        } else if (i == EnumC2324d.BOTTOM_ITEM.ordinal()) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            layoutParams2.height = (int) this.f7717c.getResources().getDimension(C2300R.dimen.setting_adapt_bottom);
            c2322b.f7745d.setLayoutParams(layoutParams2);
            c2322b.f7745d.setBackgroundResource(C2300R.color.list_nomal);
            c2322b.f7742a.setVisibility(8);
            c2322b.f7746e.setVisibility(8);
            c2322b.f7744c.setVisibility(8);
            c2322b.f7743b.setVisibility(8);
            c2322b.m12575a(false);
        }
        return view;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f7727m) {
            if (i != EnumC2323c.TFCARD_CONTENT.ordinal() && i != EnumC2323c.GRID_CONTENT.ordinal() && i != EnumC2323c.BRIGHTNESS_AUTO_CONTENT.ordinal()) {
                this.f7718d.m12233u().m12287f();
            }
        } else if (i != EnumC2324d.TFCARD_CONTENT.ordinal() && i != EnumC2324d.GRID_CONTENT.ordinal() && i != EnumC2324d.BRIGHTNESS_AUTO_CONTENT.ordinal() && i != EnumC2324d.RESERT_CAMERA.ordinal()) {
            if ((i == EnumC2324d.INDEX_STANDARD_PAL.ordinal() || i == EnumC2324d.INDEX_STANDARD_NTSC.ordinal()) && !m12584f()) {
                return;
            }
            this.f7718d.m12233u().m12287f();
        }
        if (i == EnumC2323c.INDEX_RECORD_1080P_30.ordinal() && this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8259bI;
                this.f7725k = "1920x1080 30P 16:9";
            }
        }
        if (i == EnumC2323c.INDEX_RECORD_1080P_60.ordinal() && this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8259bI;
                this.f7725k = "1920x1080 60P 16:9";
            }
        }
        if (i == EnumC2323c.INDEX_RECORD_720P.ordinal() && this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8259bI;
                this.f7725k = C2427e.f8338cj;
            }
        }
        if (i == EnumC2323c.INDEX_PHOTO_4V3_16M.ordinal() && this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8264bN;
                this.f7725k = C2427e.f8339ck;
            }
        }
        if (i == EnumC2323c.INDEX_PHOTO_4V3_8M.ordinal() && this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8264bN;
                this.f7725k = C2427e.f8341cm;
            }
        }
        if (i == EnumC2323c.INDEX_PHOTO_16V9_12M.ordinal() && this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8264bN;
                this.f7725k = C2427e.f8340cl;
            }
        }
        if (i == EnumC2324d.INDEX_RECORD_2160P_30P_4K.ordinal() && !this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f7724j = C2427e.f8259bI;
            if (this.f7731q) {
                this.f7725k = C2427e.f8342cn;
            } else {
                this.f7725k = C2427e.f8347cs;
            }
        }
        if (i == EnumC2324d.INDEX_RECORD_1440P_60P_4K.ordinal() && !this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f7724j = C2427e.f8259bI;
            if (this.f7731q) {
                this.f7725k = C2427e.f8343co;
            } else {
                this.f7725k = C2427e.f8348ct;
            }
        }
        if (i == EnumC2324d.INDEX_RECORD_1080P_30P_4K.ordinal() && !this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f7724j = C2427e.f8259bI;
            if (this.f7731q) {
                this.f7725k = "1920x1080 30P 16:9";
            } else {
                this.f7725k = C2427e.f8351cw;
            }
        }
        if (i == EnumC2324d.INDEX_RECORD_1080P_60P_4K.ordinal() && !this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f7724j = C2427e.f8259bI;
            if (this.f7731q) {
                this.f7725k = "1920x1080 60P 16:9";
            } else {
                this.f7725k = C2427e.f8350cv;
            }
        }
        if (i == EnumC2324d.INDEX_RECORD_1080P_100P_4K.ordinal() && !this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f7724j = C2427e.f8259bI;
            if (this.f7731q) {
                this.f7725k = "1920x1080 100P 16:9";
            } else {
                this.f7725k = "1920x1080 100P 16:9";
            }
        }
        if (i == EnumC2324d.IMAGE_JPG.ordinal() && !this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8272bV;
                this.f7725k = C2427e.f8354cz;
            }
        }
        if (i == EnumC2324d.IMAGE_RAW.ordinal() && !this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8272bV;
                this.f7725k = C2427e.f8304cA;
            }
        }
        if (i == EnumC2324d.GRID_CONTENT.ordinal() && !this.f7727m) {
            SwitchButton switchButton = (SwitchButton) view.findViewById(C2300R.C2302id.switch_btn);
            if (C2238c.m13123e().m12749l()) {
                switchButton.m12667a(false, true);
                this.f7732r.mo11220a(C2678d.EnumC2679a.hide9Grid);
                C2238c.m13123e().m12764e(false);
            } else {
                switchButton.m12667a(true, true);
                this.f7732r.mo11220a(C2678d.EnumC2679a.Show9Grid);
                C2238c.m13123e().m12764e(true);
            }
        }
        if (i == EnumC2324d.GRID_CONTENT.ordinal() && this.f7727m) {
            SwitchButton switchButton2 = (SwitchButton) view.findViewById(C2300R.C2302id.switch_btn);
            if (C2238c.m13123e().m12749l()) {
                switchButton2.m12667a(false, true);
                this.f7732r.mo11220a(C2678d.EnumC2679a.hide9Grid);
                C2238c.m13123e().m12764e(false);
            } else {
                switchButton2.m12667a(true, true);
                this.f7732r.mo11220a(C2678d.EnumC2679a.Show9Grid);
                C2238c.m13123e().m12764e(true);
            }
        }
        if (i == EnumC2324d.INDEX_PHOTO_16V9_8M_4K.ordinal() && !this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8264bN;
                this.f7725k = C2427e.f8353cy;
            }
        }
        if (i == EnumC2324d.INDEX_PHOTO_4V3_12M_4K.ordinal() && !this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8264bN;
                this.f7725k = C2427e.f8352cx;
            }
        }
        if ((this.f7727m && i == EnumC2323c.TFCARD_CONTENT.ordinal()) || (i == EnumC2324d.TFCARD_CONTENT.ordinal() && !this.f7727m)) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.no_connect_camera), C2284z.f7606b);
                return;
            } else if (this.f7718d.i()) {
                new DialogC3800f.C3801a(this.f7717c).m7031a(this.f7717c.getString(C2300R.C2303string.you_ensure_format_tf)).m7034a(this.f7717c.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(this.f7717c.getString(C2300R.C2303string.format), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.b.b.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        C2313b.this.f7718d.m12233u().m12293c();
                        C2238c.m13127b().mo12687a();
                    }
                }).m7030a(this.f7717c.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.b.b.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }).m7035a().show();
            } else {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.format_fail_camera_no_tf_card), C2284z.f7606b);
            }
        }
        if (i == EnumC2323c.VOLUME_RECORD_CONTENT.ordinal() && this.f7727m) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f7724j = C2427e.f8270bT;
            if (this.f7728n) {
                this.f7728n = false;
                this.f7725k = C2427e.f8315cL;
            } else {
                this.f7728n = true;
                this.f7725k = C2427e.f8316cM;
            }
        }
        if (!this.f7727m && i == EnumC2324d.INDEX_STANDARD_NTSC.ordinal()) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8273bW;
                this.f7725k = C2427e.f8305cB;
            }
        }
        if (!this.f7727m && i == EnumC2324d.INDEX_STANDARD_PAL.ordinal()) {
            if (!m12580h()) {
                C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f7724j = C2427e.f8273bW;
                this.f7725k = C2427e.f8306cC;
            }
        }
        if (i == EnumC2324d.BRIGHTNESS_AUTO_CONTENT.ordinal() && !this.f7727m && m12586e()) {
            m12591c();
        }
        if (i == EnumC2323c.BRIGHTNESS_AUTO_CONTENT.ordinal() && this.f7727m && m12586e()) {
            m12591c();
        }
        if (i != EnumC2324d.RESERT_CAMERA.ordinal() || this.f7727m) {
            return;
        }
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        if (c3580b == null || c3580b.m7935m() <= 0 || c3580b.m7935m() >= 1066) {
            new DialogC3800f.C3801a(this.f7717c).m7031a(this.f7717c.getString(C2300R.C2303string.camera_setting_resert_camera_setting_dialog)).m7034a(this.f7717c.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(this.f7717c.getString(C2300R.C2303string.ensure), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.b.b.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    C2313b.this.m12578i();
                }
            }).m7030a(this.f7717c.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.b.b.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).m7035a().show();
        } else {
            C2284z.m12694a(this.f7717c, this.f7717c.getString(C2300R.C2303string.camera_menu_update_tip), C2284z.f7606b);
        }
    }
}
