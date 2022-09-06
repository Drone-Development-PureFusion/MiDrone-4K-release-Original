package com.fimi.x1bh.module.camerasetting;

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
import com.fimi.soul.entity.CameraValue;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.view.DialogC3800f;
import java.io.File;
/* renamed from: com.fimi.x1bh.module.camerasetting.a */
/* loaded from: classes.dex */
public class C3905a extends BaseAdapter implements AdapterView.OnItemClickListener, AbstractC2388f<X11RespCmd> {

    /* renamed from: b */
    private static final float f16616b = 0.064f;

    /* renamed from: a */
    ListView f16617a;

    /* renamed from: c */
    private Context f16618c;

    /* renamed from: e */
    private int f16620e;

    /* renamed from: f */
    private int f16621f;

    /* renamed from: g */
    private int f16622g;

    /* renamed from: h */
    private int f16623h;

    /* renamed from: i */
    private boolean f16624i;

    /* renamed from: j */
    private String f16625j;

    /* renamed from: k */
    private String f16626k;

    /* renamed from: p */
    private SharedPreferences f16631p;

    /* renamed from: q */
    private AbstractC3909a f16632q;

    /* renamed from: m */
    private boolean f16628m = false;

    /* renamed from: n */
    private boolean f16629n = false;

    /* renamed from: o */
    private boolean f16630o = true;

    /* renamed from: d */
    private C2423d f16619d = (C2423d) C2379b.m12410a().m12394d();

    /* renamed from: l */
    private X11DeviceInfo f16627l = this.f16619d.j().getX11DeviceInfo();

    /* renamed from: com.fimi.x1bh.module.camerasetting.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC3909a {
        /* renamed from: a */
        boolean m6578a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.x1bh.module.camerasetting.a$b */
    /* loaded from: classes.dex */
    public class C3910b {

        /* renamed from: a */
        TextView f16636a;

        /* renamed from: b */
        TextView f16637b;

        /* renamed from: c */
        ImageView f16638c;

        /* renamed from: d */
        RelativeLayout f16639d;

        /* renamed from: e */
        SwitchButton f16640e;

        private C3910b() {
        }

        /* renamed from: a */
        public View m6577a(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(C3905a.this.f16618c).inflate(C2300R.layout.item_setting, viewGroup, false);
            this.f16639d = (RelativeLayout) inflate.findViewById(C2300R.C2302id.rl);
            this.f16636a = (TextView) inflate.findViewById(C2300R.C2302id.setting_title_tv);
            this.f16638c = (ImageView) inflate.findViewById(C2300R.C2302id.setting_arrow);
            this.f16637b = (TextView) inflate.findViewById(C2300R.C2302id.settig_coontent_tv);
            this.f16640e = (SwitchButton) inflate.findViewById(C2300R.C2302id.switch_btn);
            C3658ar.m7612a(C3905a.this.f16618c.getAssets(), this.f16636a, this.f16637b);
            return inflate;
        }

        /* renamed from: a */
        public void m6576a(boolean z) {
            this.f16639d.setClickable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.x1bh.module.camerasetting.a$c */
    /* loaded from: classes.dex */
    public enum EnumC3911c {
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
        TFCARD_TITLE,
        TFCARD_CONTENT,
        BOTTOM_ITEM
    }

    public C3905a(Context context) {
        this.f16624i = false;
        this.f16618c = context;
        this.f16624i = C2379b.m12410a().m12397c();
        this.f16631p = C2277v.m12784a(context).m12787a();
        m6599a();
        m6582d();
    }

    /* renamed from: a */
    private void m6597a(C3910b c3910b) {
        if (this.f16628m) {
            c3910b.f16640e.m12667a(true, false);
        } else {
            c3910b.f16640e.m12667a(false, false);
        }
        c3910b.f16640e.setVisibility(0);
        c3910b.f16637b.setVisibility(0);
        c3910b.f16637b.setText(C2300R.C2303string.vedio_recording_audio);
        c3910b.f16640e.setOnSwitchListener(new SwitchButton.AbstractC2291a() { // from class: com.fimi.x1bh.module.camerasetting.a.1
            @Override // com.fimi.kernel.view.button.SwitchButton.AbstractC2291a
            /* renamed from: a */
            public void mo6579a(View view, boolean z) {
                SwitchButton switchButton = (SwitchButton) view.findViewById(C2300R.C2302id.switch_btn);
                if (!C3905a.this.m6580e()) {
                    C2284z.m12694a(C3905a.this.f16618c, C3905a.this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                    if (C3905a.this.f16628m) {
                        switchButton.m12667a(true, false);
                    } else {
                        switchButton.m12667a(false, false);
                    }
                } else if (!C3905a.this.m6580e()) {
                    C2284z.m12694a(C3905a.this.f16618c, C3905a.this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                    if (C3905a.this.f16628m) {
                        switchButton.m12667a(true, false);
                    } else {
                        switchButton.m12667a(false, false);
                    }
                } else {
                    if (C3905a.this.f16628m) {
                        C3905a.this.f16628m = false;
                        switchButton.m12667a(false, true);
                        C3905a.this.f16626k = C2427e.f8315cL;
                    } else {
                        C3905a.this.f16628m = true;
                        switchButton.m12667a(true, true);
                        C3905a.this.f16626k = C2427e.f8316cM;
                    }
                    C3905a.this.f16625j = C2427e.f8270bT;
                }
            }
        });
    }

    /* renamed from: a */
    private void m6596a(C3910b c3910b, ViewGroup.LayoutParams layoutParams) {
        c3910b.f16636a.setVisibility(8);
        c3910b.f16640e.setVisibility(8);
        c3910b.f16639d.setBackgroundResource(0);
        c3910b.f16637b.setTextColor(this.f16618c.getResources().getColor(C2300R.color.white));
        c3910b.f16637b.setAlpha(1.0f);
        c3910b.f16638c.setVisibility(8);
        c3910b.f16640e.setOnSwitchListener(null);
        layoutParams.height = (int) this.f16618c.getResources().getDimension(C2300R.dimen.setting_adapt_height);
        c3910b.f16639d.setLayoutParams(layoutParams);
        c3910b.m6576a(false);
    }

    /* renamed from: a */
    private void m6595a(C3910b c3910b, String str) {
        c3910b.f16636a.setVisibility(0);
        c3910b.f16637b.setVisibility(0);
        c3910b.f16636a.setText(str);
        c3910b.f16637b.setVisibility(4);
        c3910b.f16639d.setBackgroundResource(C2300R.color.list_nomal);
        c3910b.m6576a(true);
    }

    /* renamed from: a */
    private void m6594a(C3910b c3910b, String str, boolean z) {
        c3910b.f16637b.setVisibility(0);
        c3910b.f16637b.setText(str);
        if (z) {
            c3910b.f16637b.setTextColor(this.f16618c.getResources().getColor(C2300R.color.option_choose));
            c3910b.f16638c.setVisibility(0);
        } else {
            c3910b.f16637b.setTextColor(this.f16618c.getResources().getColor(C2300R.color.white_90));
            c3910b.f16638c.setVisibility(4);
        }
        c3910b.m6576a(false);
    }

    /* renamed from: b */
    private void m6588b(C3910b c3910b, ViewGroup.LayoutParams layoutParams) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f16618c).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.height = displayMetrics.heightPixels * 0;
        c3910b.f16639d.setLayoutParams(layoutParams);
        c3910b.f16639d.setBackgroundResource(C2300R.color.list_nomal);
    }

    /* renamed from: b */
    private void m6587b(C3910b c3910b, String str, boolean z) {
        c3910b.f16637b.setVisibility(0);
        c3910b.f16640e.setVisibility(0);
        c3910b.f16637b.setText(str);
        c3910b.f16640e.setSwitchState(z);
    }

    /* renamed from: d */
    private void m6582d() {
        String videoResolution = this.f16619d.j().getVideoResolution();
        String photoSize = this.f16619d.j().getPhotoSize();
        String image_format = this.f16619d.j().getImage_format();
        if (videoResolution == null) {
            return;
        }
        if (videoResolution != null) {
            videoResolution = videoResolution.trim();
        }
        if (photoSize != null) {
            photoSize = photoSize.trim();
        }
        if (C2427e.f8306cC.equals(this.f16619d.j().getSystemType())) {
            this.f16630o = false;
            this.f16623h = EnumC3911c.INDEX_STANDARD_PAL.ordinal();
        } else {
            this.f16630o = true;
            this.f16623h = EnumC3911c.INDEX_STANDARD_NTSC.ordinal();
        }
        if (C2427e.f8342cn.contains(videoResolution) || C2427e.f8347cs.contains(videoResolution)) {
            this.f16621f = EnumC3911c.INDEX_RECORD_2160P_30P_4K.ordinal();
        }
        if (C2427e.f8343co.contains(videoResolution) || C2427e.f8348ct.contains(videoResolution)) {
            this.f16621f = EnumC3911c.INDEX_RECORD_1440P_60P_4K.ordinal();
        }
        if ("1920x1080 30P 16:9".contains(videoResolution) || C2427e.f8351cw.contains(videoResolution)) {
            this.f16621f = EnumC3911c.INDEX_RECORD_1080P_30P_4K.ordinal();
        }
        if ("1920x1080 60P 16:9".contains(videoResolution) || C2427e.f8350cv.contains(videoResolution)) {
            this.f16621f = EnumC3911c.INDEX_RECORD_1080P_60P_4K.ordinal();
        }
        if ("1920x1080 100P 16:9".contains(videoResolution) || "1920x1080 100P 16:9".contains(videoResolution)) {
            this.f16621f = EnumC3911c.INDEX_RECORD_1080P_100P_4K.ordinal();
        }
        if (photoSize != null) {
            if (C2427e.f8352cx.contains(photoSize)) {
                this.f16620e = EnumC3911c.INDEX_PHOTO_4V3_12M_4K.ordinal();
            }
            if (C2427e.f8353cy.contains(photoSize)) {
                this.f16620e = EnumC3911c.INDEX_PHOTO_16V9_8M_4K.ordinal();
            }
        }
        if (image_format != null && !"".equals(image_format)) {
            if (C2427e.f8354cz.equals(image_format)) {
                this.f16622g = EnumC3911c.IMAGE_JPG.ordinal();
            }
            if (C2427e.f8304cA.equals(image_format)) {
                this.f16622g = EnumC3911c.IMAGE_RAW.ordinal();
            }
        }
        if (C2427e.f8315cL.equals(this.f16619d.j().getVideoMode())) {
            this.f16628m = false;
        } else {
            this.f16628m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m6580e() {
        return this.f16619d.e();
    }

    /* renamed from: a */
    public void m6599a() {
        this.f16619d.m12233u().m12296b();
    }

    /* renamed from: a */
    public void m6598a(AbstractC3909a abstractC3909a) {
        this.f16632q = abstractC3909a;
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        switch (x11RespCmd.getMsg_id()) {
            case 2:
                if (!z) {
                    if (x11RespCmd.getType() != null) {
                        C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.setting_false), C2284z.f7607c);
                    }
                    C2238c.m13127b().mo12676c();
                    return;
                } else if (C2427e.f8252bB.equals(x11RespCmd.getType()) || "menu_album".equals(x11RespCmd.getType())) {
                    return;
                } else {
                    C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_success), C2284z.f7607c);
                    this.f16619d.m12233u().m12296b();
                    return;
                }
            case 3:
                C2238c.m13127b().mo12676c();
                m6582d();
                notifyDataSetChanged();
                return;
            case 4:
                if (z) {
                    C2259g.m12987b(new File(C3681j.m7465n()));
                    C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.format_success), C2284z.f7607c);
                    this.f16619d.m12233u().m12290d(C2427e.f8324cU);
                    this.f16619d.a(true);
                } else {
                    C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.format_fail), C2284z.f7607c);
                }
                C2238c.m13127b().mo12676c();
                return;
            case 11:
                this.f16619d.m12233u().m12296b();
                return;
            case 257:
                if (z) {
                    return;
                }
                C2238c.m13127b().mo12676c();
                return;
            case C2427e.f8177G /* 260 */:
                CameraValue.isCameraParameterChange = true;
                this.f16619d.m12233u().m12298a(this.f16625j, this.f16626k);
                C2238c.m13127b().mo12687a();
                if (this.f16627l.getChip() != null) {
                    return;
                }
                this.f16619d.m12233u().m12291d();
                return;
            case C2427e.f8232ai /* 10066329 */:
                C2238c.m13127b().mo12676c();
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public void m6589b() {
        if (this.f16619d != null) {
            this.f16619d.a(this);
            if (!C2367d.m12459a().m12436m() || this.f16619d.e()) {
                return;
            }
            C2238c.m13127b().mo12687a();
            this.f16619d.m12231w().m12240b();
        }
    }

    /* renamed from: c */
    public boolean m6584c() {
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        boolean z = c3580b != null && c3580b.m7935m() > 0 && c3580b.m7935m() >= 1063;
        if (!z) {
            C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.camera_menu_update_tip), C2284z.f7606b);
        }
        return z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return EnumC3911c.values().length;
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
        C3910b c3910b;
        boolean z = true;
        if (view == null) {
            c3910b = new C3910b();
            view = c3910b.m6577a(viewGroup);
            view.setTag(c3910b);
            this.f16617a = (ListView) viewGroup;
        } else {
            c3910b = (C3910b) view.getTag();
        }
        m6596a(c3910b, view.getLayoutParams());
        if (i == EnumC3911c.STANDARD_TITLE.ordinal()) {
            m6595a(c3910b, this.f16618c.getString(C2300R.C2303string.media_setting_standard));
        } else if (i == EnumC3911c.INDEX_STANDARD_PAL.ordinal()) {
            String string = this.f16618c.getString(C2300R.C2303string.media_setting_standard_pal);
            if (this.f16623h != EnumC3911c.INDEX_STANDARD_PAL.ordinal()) {
                z = false;
            }
            m6594a(c3910b, string, z);
        } else if (i == EnumC3911c.INDEX_STANDARD_NTSC.ordinal()) {
            String string2 = this.f16618c.getString(C2300R.C2303string.media_setting_standard_ntsc);
            if (this.f16623h != EnumC3911c.INDEX_STANDARD_NTSC.ordinal()) {
                z = false;
            }
            m6594a(c3910b, string2, z);
        } else if (i == EnumC3911c.RECORD_TITLE.ordinal()) {
            m6595a(c3910b, this.f16618c.getString(C2300R.C2303string.record_title));
        } else if (i == EnumC3911c.INDEX_RECORD_1440P_60P_4K.ordinal()) {
            if (this.f16630o) {
                String string3 = this.f16618c.getString(C2300R.C2303string.option_video_1440p_60_4k);
                if (this.f16621f != EnumC3911c.INDEX_RECORD_1440P_60P_4K.ordinal()) {
                    z = false;
                }
                m6594a(c3910b, string3, z);
            } else {
                String string4 = this.f16618c.getString(C2300R.C2303string.option_video_1440p_50_pal_4k);
                if (this.f16621f != EnumC3911c.INDEX_RECORD_1440P_60P_4K.ordinal()) {
                    z = false;
                }
                m6594a(c3910b, string4, z);
            }
        } else if (i == EnumC3911c.INDEX_RECORD_1080P_30P_4K.ordinal()) {
            if (this.f16630o) {
                String string5 = this.f16618c.getString(C2300R.C2303string.option_video_1080p_30_4k);
                if (this.f16621f != EnumC3911c.INDEX_RECORD_1080P_30P_4K.ordinal()) {
                    z = false;
                }
                m6594a(c3910b, string5, z);
            } else {
                String string6 = this.f16618c.getString(C2300R.C2303string.option_video_1080p_25_pal_4k);
                if (this.f16621f != EnumC3911c.INDEX_RECORD_1080P_30P_4K.ordinal()) {
                    z = false;
                }
                m6594a(c3910b, string6, z);
            }
        } else if (i == EnumC3911c.INDEX_RECORD_1080P_60P_4K.ordinal()) {
            if (this.f16630o) {
                String string7 = this.f16618c.getString(C2300R.C2303string.option_video_1080p_60_4k);
                if (this.f16621f != EnumC3911c.INDEX_RECORD_1080P_60P_4K.ordinal()) {
                    z = false;
                }
                m6594a(c3910b, string7, z);
            } else {
                String string8 = this.f16618c.getString(C2300R.C2303string.option_video_1080p_50_pal_4k);
                if (this.f16621f != EnumC3911c.INDEX_RECORD_1080P_60P_4K.ordinal()) {
                    z = false;
                }
                m6594a(c3910b, string8, z);
            }
        } else if (i == EnumC3911c.INDEX_RECORD_1080P_100P_4K.ordinal()) {
            if (this.f16630o) {
                String string9 = this.f16618c.getString(C2300R.C2303string.option_video_1080p_100_4k);
                if (this.f16621f != EnumC3911c.INDEX_RECORD_1080P_100P_4K.ordinal()) {
                    z = false;
                }
                m6594a(c3910b, string9, z);
            } else {
                String string10 = this.f16618c.getString(C2300R.C2303string.option_video_1080p_100_pal_4k);
                if (this.f16621f != EnumC3911c.INDEX_RECORD_1080P_100P_4K.ordinal()) {
                    z = false;
                }
                m6594a(c3910b, string10, z);
            }
        } else if (i == EnumC3911c.INDEX_RECORD_2160P_30P_4K.ordinal()) {
            if (this.f16630o) {
                String string11 = this.f16618c.getString(C2300R.C2303string.option_video_2160p_30_4k);
                if (this.f16621f != EnumC3911c.INDEX_RECORD_2160P_30P_4K.ordinal()) {
                    z = false;
                }
                m6594a(c3910b, string11, z);
            } else {
                String string12 = this.f16618c.getString(C2300R.C2303string.option_video_2160p_25_pal_4k);
                if (this.f16621f != EnumC3911c.INDEX_RECORD_2160P_30P_4K.ordinal()) {
                    z = false;
                }
                m6594a(c3910b, string12, z);
            }
        } else if (i == EnumC3911c.IMAGE_TITLE.ordinal()) {
            m6595a(c3910b, this.f16618c.getString(C2300R.C2303string.photo));
        } else if (i == EnumC3911c.INDEX_PHOTO_4V3_12M_4K.ordinal()) {
            String string13 = this.f16618c.getString(C2300R.C2303string.option_photo_12M_4k);
            if (this.f16620e != EnumC3911c.INDEX_PHOTO_4V3_12M_4K.ordinal()) {
                z = false;
            }
            m6594a(c3910b, string13, z);
        } else if (i == EnumC3911c.INDEX_PHOTO_16V9_8M_4K.ordinal()) {
            String string14 = this.f16618c.getString(C2300R.C2303string.option_photo_8M_4k);
            if (this.f16620e != EnumC3911c.INDEX_PHOTO_16V9_8M_4K.ordinal()) {
                z = false;
            }
            m6594a(c3910b, string14, z);
        } else if (i == EnumC3911c.IMAGE_FORMAT_TITLE.ordinal()) {
            m6595a(c3910b, this.f16618c.getString(C2300R.C2303string.image_format));
        } else if (i == EnumC3911c.IMAGE_JPG.ordinal()) {
            String string15 = this.f16618c.getString(C2300R.C2303string.image_jpg);
            if (this.f16622g != EnumC3911c.IMAGE_JPG.ordinal()) {
                z = false;
            }
            m6594a(c3910b, string15, z);
        } else if (i == EnumC3911c.IMAGE_RAW.ordinal()) {
            String string16 = this.f16618c.getString(C2300R.C2303string.image_raw);
            if (this.f16622g != EnumC3911c.IMAGE_RAW.ordinal()) {
                z = false;
            }
            m6594a(c3910b, string16, z);
        } else if (i == EnumC3911c.TFCARD_TITLE.ordinal()) {
            m6595a(c3910b, this.f16618c.getString(C2300R.C2303string.sdcard_operation));
        } else if (i == EnumC3911c.TFCARD_CONTENT.ordinal()) {
            c3910b.f16637b.setVisibility(0);
            c3910b.f16637b.setText(this.f16618c.getString(C2300R.C2303string.camera_sd_format));
            c3910b.f16637b.setTextColor(this.f16618c.getResources().getColor(C2300R.color.white_90));
        } else if (i == EnumC3911c.BOTTOM_ITEM.ordinal()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = (int) this.f16618c.getResources().getDimension(C2300R.dimen.setting_adapt_bottom);
            c3910b.f16639d.setLayoutParams(layoutParams);
            c3910b.f16639d.setBackgroundResource(C2300R.color.list_nomal);
            c3910b.f16636a.setVisibility(8);
            c3910b.f16640e.setVisibility(8);
            c3910b.f16638c.setVisibility(8);
            c3910b.f16637b.setVisibility(8);
            c3910b.m6576a(false);
        }
        return view;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != EnumC3911c.TFCARD_CONTENT.ordinal()) {
            this.f16619d.m12233u().m12287f();
        }
        if (i == EnumC3911c.INDEX_RECORD_2160P_30P_4K.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f16625j = C2427e.f8259bI;
            if (this.f16630o) {
                this.f16626k = C2427e.f8342cn;
            } else {
                this.f16626k = C2427e.f8347cs;
            }
        }
        if (i == EnumC3911c.INDEX_RECORD_1440P_60P_4K.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f16625j = C2427e.f8259bI;
            if (this.f16630o) {
                this.f16626k = C2427e.f8343co;
            } else {
                this.f16626k = C2427e.f8348ct;
            }
        }
        if (i == EnumC3911c.INDEX_RECORD_1080P_30P_4K.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f16625j = C2427e.f8259bI;
            if (this.f16630o) {
                this.f16626k = "1920x1080 30P 16:9";
            } else {
                this.f16626k = C2427e.f8351cw;
            }
        }
        if (i == EnumC3911c.INDEX_RECORD_1080P_60P_4K.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f16625j = C2427e.f8259bI;
            if (this.f16630o) {
                this.f16626k = "1920x1080 60P 16:9";
            } else {
                this.f16626k = C2427e.f8350cv;
            }
        }
        if (i == EnumC3911c.INDEX_RECORD_1080P_100P_4K.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            }
            this.f16625j = C2427e.f8259bI;
            if (this.f16630o) {
                this.f16626k = "1920x1080 100P 16:9";
            } else {
                this.f16626k = "1920x1080 100P 16:9";
            }
        }
        if (i == EnumC3911c.IMAGE_JPG.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f16625j = C2427e.f8272bV;
                this.f16626k = C2427e.f8354cz;
            }
        }
        if (i == EnumC3911c.IMAGE_RAW.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f16625j = C2427e.f8272bV;
                this.f16626k = C2427e.f8304cA;
            }
        }
        if (i == EnumC3911c.INDEX_PHOTO_16V9_8M_4K.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f16625j = C2427e.f8264bN;
                this.f16626k = C2427e.f8353cy;
            }
        }
        if (i == EnumC3911c.INDEX_PHOTO_4V3_12M_4K.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f16625j = C2427e.f8264bN;
                this.f16626k = C2427e.f8352cx;
            }
        }
        if (i == EnumC3911c.INDEX_STANDARD_NTSC.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f16625j = C2427e.f8273bW;
                this.f16626k = C2427e.f8305cB;
            }
        }
        if (i == EnumC3911c.INDEX_STANDARD_PAL.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.set_fail_no_connect_camera), C2284z.f7606b);
                return;
            } else {
                this.f16625j = C2427e.f8273bW;
                this.f16626k = C2427e.f8306cC;
            }
        }
        if (i == EnumC3911c.TFCARD_CONTENT.ordinal()) {
            if (!m6580e()) {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.no_connect_camera), C2284z.f7606b);
            } else if (this.f16619d.i()) {
                new DialogC3800f.C3801a(this.f16618c).m7031a(this.f16618c.getString(C2300R.C2303string.you_ensure_format_tf)).m7034a(this.f16618c.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(this.f16618c.getString(C2300R.C2303string.format), new DialogInterface.OnClickListener() { // from class: com.fimi.x1bh.module.camerasetting.a.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        C3905a.this.f16619d.m12233u().m12293c();
                        C2238c.m13127b().mo12687a();
                    }
                }).m7030a(this.f16618c.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.x1bh.module.camerasetting.a.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }).m7035a().show();
            } else {
                C2284z.m12694a(this.f16618c, this.f16618c.getString(C2300R.C2303string.format_fail_camera_no_tf_card), C2284z.f7606b);
            }
        }
    }
}
