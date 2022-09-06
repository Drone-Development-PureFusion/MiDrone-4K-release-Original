package com.fimi.soul.media.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.p001v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import cn.sharesdk.framework.ShareSDK;
import com.fimi.kernel.p157b.p159b.C2196b;
import com.fimi.kernel.p157b.p159b.C2205c;
import com.fimi.kernel.utils.C2275t;
import com.fimi.kernel.utils.C2277v;
import com.fimi.kernel.utils.C2284z;
import com.fimi.kernel.view.dialog.AbstractC2293a;
import com.fimi.kernel.view.progress.ProgressView;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11FileInfo;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
import com.fimi.soul.biz.p185n.C2583q;
import com.fimi.soul.entity.ShareInfo;
import com.fimi.soul.entity.WifiDistanceFile;
import com.fimi.soul.media.player.FermiPlayerActivity;
import com.fimi.soul.media.player.FimiMediaMeta;
import com.fimi.soul.module.login.C3384c;
import com.fimi.soul.p167b.C2331f;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.view.C3765b;
import com.fimi.soul.view.DialogC3800f;
import com.fimi.soul.view.HackyViewPager;
import com.fimi.soul.view.photodraweeview.AbstractC3867d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DroneImagePagerActivity extends BaseActivity implements View.OnClickListener, C2196b.AbstractC2202d, C2205c.AbstractC2209b, AbstractC2388f<X11RespCmd> {

    /* renamed from: a */
    public static final String f11146a = "image_index";

    /* renamed from: b */
    public static final String f11147b = "extra_type";

    /* renamed from: c */
    public static final String f11148c = "image_urls";

    /* renamed from: d */
    public static final String f11149d = "image_drone_media";

    /* renamed from: e */
    public static final String f11150e = "image_drone_local";

    /* renamed from: f */
    public static final String f11151f = "video_duration";

    /* renamed from: m */
    private static final String f11152m = "STATE_POSITION";

    /* renamed from: A */
    private ImageButton f11153A;

    /* renamed from: B */
    private ImageButton f11154B;

    /* renamed from: C */
    private DroneImagePagerAdapter f11155C;

    /* renamed from: D */
    private C2205c f11156D;

    /* renamed from: E */
    private C2196b f11157E;

    /* renamed from: F */
    private ProgressView f11158F;

    /* renamed from: G */
    private C2583q f11159G;

    /* renamed from: H */
    private Button f11160H;

    /* renamed from: I */
    private Button f11161I;

    /* renamed from: J */
    private TextView f11162J;

    /* renamed from: K */
    private TextView f11163K;

    /* renamed from: L */
    private TextView f11164L;

    /* renamed from: M */
    private int f11165M;

    /* renamed from: N */
    private List<WifiDistanceFile> f11166N;

    /* renamed from: i */
    C2277v f11169i;

    /* renamed from: n */
    private C2423d f11173n;

    /* renamed from: p */
    private HackyViewPager f11175p;

    /* renamed from: q */
    private int f11176q;

    /* renamed from: r */
    private TextView f11177r;

    /* renamed from: s */
    private View f11178s;

    /* renamed from: t */
    private View f11179t;

    /* renamed from: u */
    private View f11180u;

    /* renamed from: w */
    private ArrayList<String> f11182w;

    /* renamed from: x */
    private ArrayList<String> f11183x;

    /* renamed from: y */
    private ArrayList<String> f11184y;

    /* renamed from: z */
    private ImageButton f11185z;

    /* renamed from: o */
    private boolean f11174o = false;

    /* renamed from: v */
    private boolean f11181v = true;

    /* renamed from: g */
    public String f11167g = "";

    /* renamed from: h */
    public String f11168h = "";

    /* renamed from: j */
    String f11170j = C2353b.f7924O;

    /* renamed from: k */
    String f11171k = C2353b.f7925P;

    /* renamed from: l */
    boolean f11172l = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m10039a(int i) {
        if (this.f11182w == null || this.f11182w.size() <= 0) {
            return "";
        }
        String str = this.f11182w.get(i).toString();
        return str.contains("THUMB_") ? this.f11182w.get(i).substring(this.f11182w.get(i).lastIndexOf("/") + 1).replace("THUMB_", "") : str.contains("_THM") ? this.f11182w.get(i).substring(this.f11182w.get(i).lastIndexOf("/") + 1) : this.f11182w.get(i).substring(this.f11182w.get(i).lastIndexOf("/") + 1);
    }

    /* renamed from: a */
    private void m10040a() {
        this.f11177r = (TextView) this.f11179t.findViewById(C2300R.C2302id.tv_pageName);
        this.f11177r.setVisibility(0);
        C3658ar.m7612a(getAssets(), this.f11177r);
        this.f11176q = getIntent().getIntExtra("image_index", 0);
        this.f11175p = (HackyViewPager) findViewById(C2300R.C2302id.pager);
        if (this.f11174o) {
            this.f11155C = new DroneImagePagerAdapter(getSupportFragmentManager(), this.f11182w, this.f11183x);
        } else {
            this.f11155C = new DroneImagePagerAdapter(getSupportFragmentManager(), this.f11182w);
        }
        this.f11155C.m9996a(this.f11175p);
        this.f11155C.m9995a(new AbstractC3867d() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.7
            @Override // com.fimi.soul.view.photodraweeview.AbstractC3867d
            /* renamed from: a */
            public void mo6741a(View view, float f, float f2) {
                DroneImagePagerActivity.this.f11157E = DroneImagePagerActivity.this.f11156D.m13234a(DroneImagePagerActivity.this, DroneImagePagerActivity.this.m10015i());
                if (DroneImagePagerActivity.this.f11157E == null) {
                    DroneImagePagerActivity.this.f11181v = !DroneImagePagerActivity.this.f11181v;
                    DroneImagePagerActivity.this.m10026c(DroneImagePagerActivity.this.f11181v);
                    DroneImagePagerActivity.this.m10029b(DroneImagePagerActivity.this.f11181v);
                }
            }
        });
        this.f11175p.setAdapter(this.f11155C);
        this.f11175p.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.8
            @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                Log.v("mPager", "arg0=" + i);
                if (i2 == 0 && f == 0.0d && DroneImagePagerActivity.this.f11155C.m9997a(i) != null) {
                    DroneImagePagerActivity.this.f11155C.m9997a(i).m10048b();
                }
            }

            @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DroneImagePagerActivity.this.f11181v = true;
                String m10039a = DroneImagePagerActivity.this.m10039a(i);
                DroneImagePagerActivity.this.f11177r.setText(m10039a);
                DroneImagePagerActivity.this.m10031b();
                if (m10039a.endsWith(X11FileInfo.FILE_TYPE_MP4) || m10039a.endsWith(C3384c.f13187o)) {
                    DroneImagePagerActivity.this.f11154B.setVisibility(0);
                } else {
                    DroneImagePagerActivity.this.f11154B.setVisibility(8);
                }
                DroneImagePagerActivity.this.m10021f();
            }
        });
        this.f11175p.setCurrentItem(this.f11176q);
        this.f11177r.setText(m10039a(this.f11176q));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10031b() {
        View findViewById = this.f11178s.findViewById(C2300R.C2302id.ll_bottomDownload);
        View findViewById2 = this.f11178s.findViewById(C2300R.C2302id.ll_bottomShare);
        this.f11185z = (ImageButton) this.f11179t.findViewById(C2300R.C2302id.btn_back);
        this.f11153A = (ImageButton) this.f11178s.findViewById(C2300R.C2302id.btn_bottomDownload);
        ImageButton imageButton = (ImageButton) this.f11178s.findViewById(C2300R.C2302id.btn_bottomShare);
        ImageButton imageButton2 = (ImageButton) this.f11178s.findViewById(C2300R.C2302id.btn_bottomDelete);
        this.f11160H.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String m7478b = C3681j.m7478b(DroneImagePagerActivity.this.m10019g());
                if (DroneImagePagerActivity.this.f11157E == null || DroneImagePagerActivity.this.f11157E.m13262g() == C2196b.EnumC2198a.Completed) {
                    return;
                }
                File file = new File(m7478b.replace("file://", "").replace(X11FileInfo.FILE_TYPE_MP4, C3384c.f13187o));
                if (file.exists()) {
                    file.delete();
                }
                DroneImagePagerActivity.this.f11175p.setScrollble(true);
                DroneImagePagerActivity.this.f11156D.m13233a(DroneImagePagerActivity.this.f11157E);
                DroneImagePagerActivity.this.m10026c(false);
                DroneImagePagerActivity.this.m10033a(false);
                DroneImagePagerActivity.this.m10029b(false);
                DroneImagePagerActivity.this.m10031b();
            }
        });
        this.f11161I.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DroneImagePagerActivity.this.f11157E != null) {
                    DroneImagePagerActivity.this.f11157E.m13273c();
                    DroneImagePagerActivity.this.f11161I.setVisibility(8);
                    DroneImagePagerActivity.this.f11160H.setVisibility(0);
                }
            }
        });
        if (this.f11174o && !C2379b.m12395c(m10019g().replace(X11FileInfo.FILE_TYPE_MP4, C3384c.f13187o))) {
            findViewById2.setVisibility(8);
            findViewById.setVisibility(0);
            m10026c(true);
            m10029b(true);
            this.f11153A.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (DroneImagePagerActivity.this.f11169i.m12787a().getBoolean(DroneImagePagerActivity.this.f11170j, false)) {
                        DroneImagePagerActivity.this.m10025d();
                    } else {
                        DroneImagePagerActivity.this.m10028c();
                    }
                }
            });
            imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new DialogC3800f.C3801a(DroneImagePagerActivity.this).m7031a(DroneImagePagerActivity.this.getString(C2300R.C2303string.ensure_delete_file)).m7034a(DroneImagePagerActivity.this.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(DroneImagePagerActivity.this.getString(C2300R.C2303string.delete), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.12.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DroneImagePagerActivity.this.f11173n.m12232v().m12264c(((WifiDistanceFile) DroneImagePagerActivity.this.f11166N.get(DroneImagePagerActivity.this.f11175p.getCurrentItem())).getAbsolutePath());
                        }
                    }).m7030a(DroneImagePagerActivity.this.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.12.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).m7035a().show();
                }
            });
        } else if (!this.f11174o || !C2379b.m12395c(m10019g().replace(X11FileInfo.FILE_TYPE_MP4, C3384c.f13187o))) {
            String m10015i = m10015i();
            if (m10015i.endsWith(X11FileInfo.FILE_TYPE_MP4) || m10015i.endsWith(C3384c.f13187o)) {
                findViewById2.setVisibility(8);
            } else {
                findViewById2.setVisibility(0);
            }
            findViewById.setVisibility(8);
            m10029b(true);
            m10026c(true);
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C3658ar.m7601b(DroneImagePagerActivity.this)) {
                        DroneImagePagerActivity.this.m10023e();
                    } else {
                        C2284z.m12696a(DroneImagePagerActivity.this, (int) C2300R.C2303string.login_result_net, 1000);
                    }
                }
            });
            imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new DialogC3800f.C3801a(DroneImagePagerActivity.this).m7031a(DroneImagePagerActivity.this.getString(C2300R.C2303string.ensure_delete_file)).m7034a(DroneImagePagerActivity.this.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(DroneImagePagerActivity.this.getString(C2300R.C2303string.delete), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.3.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            File file = new File(DroneImagePagerActivity.this.m10015i().replace("file://", ""));
                            if (file.isFile() && file.exists()) {
                                file.delete();
                            }
                            Intent intent = new Intent();
                            intent.putExtra("del_file", DroneImagePagerActivity.this.m10015i());
                            DroneImagePagerActivity.this.setResult(1, intent);
                            DroneImagePagerActivity.this.finish();
                        }
                    }).m7030a(DroneImagePagerActivity.this.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).m7035a().show();
                }
            });
        } else {
            this.f11180u.setVisibility(8);
            if (m10019g().endsWith(X11FileInfo.FILE_TYPE_MP4)) {
                findViewById2.setVisibility(8);
            } else {
                findViewById2.setVisibility(0);
            }
            findViewById.setVisibility(8);
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C3658ar.m7601b(DroneImagePagerActivity.this)) {
                        DroneImagePagerActivity.this.m10023e();
                    } else {
                        C2284z.m12696a(DroneImagePagerActivity.this, (int) C2300R.C2303string.login_result_net, 1000);
                    }
                }
            });
            imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new DialogC3800f.C3801a(DroneImagePagerActivity.this).m7031a(DroneImagePagerActivity.this.getString(C2300R.C2303string.ensure_delete_file)).m7034a(DroneImagePagerActivity.this.getResources().getColor(C2300R.color.dialog_ensure_hot)).m7024b(DroneImagePagerActivity.this.getString(C2300R.C2303string.delete), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.14.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DroneImagePagerActivity.this.f11173n.m12232v().m12264c(((WifiDistanceFile) DroneImagePagerActivity.this.f11166N.get(DroneImagePagerActivity.this.f11175p.getCurrentItem())).getAbsolutePath());
                        }
                    }).m7030a(DroneImagePagerActivity.this.getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.14.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).m7035a().show();
                }
            });
        }
        this.f11185z.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DroneImagePagerActivity.this.f11172l = true;
                DroneImagePagerActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10028c() {
        this.f11178s.setVisibility(8);
        this.f11180u.setVisibility(0);
        this.f11162J.setText(String.format(getString(C2300R.C2303string.download_file_phone), m10019g()));
        this.f11163K.setText("0%");
        this.f11164L.setText("0.00 KB/s");
        this.f11158F.setMaxCount((float) this.f11166N.get(this.f11175p.getCurrentItem()).getSize());
        this.f11158F.setCurrentCount(0.0f);
        String m10015i = m10015i();
        this.f11156D.m13229a(m10015i, this.f11184y.get(this.f11175p.getCurrentItem()), this.f11166N.get(this.f11175p.getCurrentItem()).getSize(), false, m10015i.contains("_THM.MP4") ? C3681j.m7478b(m10015i.substring(m10015i.lastIndexOf(47) + 1)).replace(X11FileInfo.FILE_TYPE_MP4, C3384c.f13187o) : C3681j.m7478b(m10019g()).replace(X11FileInfo.FILE_TYPE_MP4, C3384c.f13187o));
        this.f11156D.m13231a((C2205c.AbstractC2209b) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10025d() {
        new C3765b().mo7131a((Context) this, getString(C2300R.C2303string.download_delete_file), getString(C2300R.C2303string.cancel), getString(C2300R.C2303string.delete), (Boolean) false, getString(C2300R.C2303string.remerber_me_choose), new AbstractC2293a() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.5
            @Override // com.fimi.kernel.view.dialog.AbstractC2293a
            /* renamed from: a */
            public void mo10000a(int i) {
            }

            @Override // com.fimi.kernel.view.dialog.AbstractC2293a
            /* renamed from: a */
            public void mo9999a(int i, Boolean bool) {
                if (i == -2) {
                    if (bool.booleanValue()) {
                        DroneImagePagerActivity.this.f11169i.m12787a().edit().putBoolean(DroneImagePagerActivity.this.f11170j, false).commit();
                        DroneImagePagerActivity.this.f11169i.m12787a().edit().putBoolean(DroneImagePagerActivity.this.f11171k, false).commit();
                    } else {
                        DroneImagePagerActivity.this.f11169i.m12787a().edit().putBoolean(DroneImagePagerActivity.this.f11170j, true).commit();
                        DroneImagePagerActivity.this.f11169i.m12787a().edit().putBoolean(DroneImagePagerActivity.this.f11171k, false).commit();
                    }
                } else if (i == -1) {
                    if (bool.booleanValue()) {
                        DroneImagePagerActivity.this.f11169i.m12787a().edit().putBoolean(DroneImagePagerActivity.this.f11170j, false).commit();
                        DroneImagePagerActivity.this.f11169i.m12787a().edit().putBoolean(DroneImagePagerActivity.this.f11171k, true).commit();
                    } else {
                        DroneImagePagerActivity.this.f11169i.m12787a().edit().putBoolean(DroneImagePagerActivity.this.f11170j, true).commit();
                        DroneImagePagerActivity.this.f11169i.m12787a().edit().putBoolean(DroneImagePagerActivity.this.f11171k, true).commit();
                    }
                }
                DroneImagePagerActivity.this.m10028c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m10023e() {
        ShareInfo shareInfo = new ShareInfo();
        if (this.f11174o) {
            shareInfo.setUrl(C2379b.m12393d(m10019g()));
        } else {
            shareInfo.setUrl(this.f11182w.get(this.f11175p.getCurrentItem()).replace("file://", ""));
        }
        this.f11159G.m11600a(new C2583q.AbstractC2592b() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.6
            @Override // com.fimi.soul.biz.p185n.C2583q.AbstractC2592b
            /* renamed from: a */
            public void mo9998a(int i) {
                DroneImagePagerActivity.this.f11175p.setDrawingCacheEnabled(false);
            }
        });
        this.f11159G.m11598a(shareInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m10021f() {
        m10033a(false);
        this.f11156D = C2205c.m13235a(getApplicationContext());
        this.f11156D.m13231a((C2205c.AbstractC2209b) this);
        this.f11157E = this.f11156D.m13234a(this, m10015i());
        if (this.f11157E != null && (this.f11157E.m13262g() == C2196b.EnumC2198a.Wait || this.f11157E.m13262g() == C2196b.EnumC2198a.Downloading)) {
            m10033a(true);
            this.f11161I.setVisibility(4);
            this.f11160H.setVisibility(0);
            long m13258i = this.f11157E.m13258i();
            long m13254k = this.f11157E.m13254k();
            this.f11158F.setMaxCount((float) m13258i);
            this.f11158F.setCurrentCount((float) m13254k);
            this.f11162J.setText(String.format(getString(C2300R.C2303string.download_file_phone), m10019g()));
            this.f11163K.setText((m13254k / (m13258i / 100)) + "%");
            this.f11164L.setText("0.00 KB/s");
            this.f11157E.m13289a((C2196b.AbstractC2202d) this);
        } else if (this.f11157E == null) {
        } else {
            if (this.f11157E.m13262g() != C2196b.EnumC2198a.Pause && this.f11157E.m13262g() != C2196b.EnumC2198a.Error) {
                return;
            }
            m10033a(true);
            this.f11161I.setVisibility(0);
            this.f11160H.setVisibility(8);
            long m13258i2 = this.f11157E.m13258i();
            long m13254k2 = this.f11157E.m13254k();
            this.f11158F.setMaxCount((float) m13258i2);
            this.f11158F.setCurrentCount((float) m13254k2);
            this.f11162J.setText(String.format(getString(C2300R.C2303string.download_file_phone), m10019g()));
            this.f11163K.setText((m13254k2 / (m13258i2 / 100)) + "%");
            this.f11164L.setText("");
            this.f11157E.m13289a((C2196b.AbstractC2202d) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public String m10019g() {
        return m10039a(this.f11175p.getCurrentItem());
    }

    /* renamed from: h */
    private String m10017h() {
        if (this.f11182w == null || this.f11182w.size() <= 0) {
            return "";
        }
        String str = this.f11182w.get(this.f11175p.getCurrentItem()).toString();
        return str.substring(str.lastIndexOf(47) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public String m10015i() {
        String str = this.f11182w.get(this.f11175p.getCurrentItem());
        return str.contains("&&") ? str.split("&&")[1] : str;
    }

    /* renamed from: j */
    private void m10013j() {
        for (int i = 0; i < this.f11182w.size(); i++) {
            String m10039a = m10039a(i);
            if (C2379b.m12399b(m10039a)) {
                String format = String.format("file://%s", C2379b.m12391e(m10039a));
                Log.d("Good", "Downloaded:" + format);
                this.f11182w.set(i, format);
            }
        }
    }

    @Override // com.fimi.kernel.p157b.p159b.C2196b.AbstractC2202d
    /* renamed from: a */
    public void mo10038a(C2196b.EnumC2198a enumC2198a, C2196b c2196b) {
        if (this.f11174o && !this.f11172l) {
            String m13260h = c2196b.m13260h();
            if (m13260h.contains("_THM.MP4") || m13260h.contains("_THM.mp4")) {
                if (!m13260h.equals(C3681j.m7478b(m10017h().replace(X11FileInfo.FILE_TYPE_MP4, C3384c.f13187o)))) {
                    return;
                }
            } else if (!m13260h.equals(C3681j.m7478b(m10019g().replace(X11FileInfo.FILE_TYPE_MP4, C3384c.f13187o)))) {
                return;
            }
            if (enumC2198a == C2196b.EnumC2198a.Completed) {
                m10033a(false);
                this.f11175p.setScrollble(true);
                m10031b();
                this.f11158F.setCurrentCount(0.0f);
                this.f11162J.setText("0%");
                if (this.f11169i.m12787a().getBoolean(this.f11171k, false)) {
                    this.f11173n.m12232v().m12264c(m10019g());
                }
                C2205c.m13235a((Context) this).m13233a(this.f11157E);
                return;
            }
            this.f11158F.setMaxCount((float) c2196b.m13258i());
            this.f11158F.setCurrentCount((float) c2196b.m13254k());
            long m13252l = c2196b.m13252l();
            if (m13252l >= 0 && m13252l < 102400) {
                this.f11164L.setText(C2275t.m12790b((float) (m13252l / FimiMediaMeta.AV_CH_SIDE_RIGHT), 2) + " KB/s");
            } else if (m13252l >= 102400 && m13252l < 1024000) {
                this.f11164L.setText(((int) (m13252l / FimiMediaMeta.AV_CH_SIDE_RIGHT)) + " KB/s");
            } else if (m13252l >= 1024000) {
                this.f11164L.setText(C2275t.m12790b(((float) m13252l) / 1048576.0f, 2) + " MB/s");
            }
            this.f11163K.setText((c2196b.m13254k() / (c2196b.m13258i() / 100)) + "%");
        }
    }

    @Override // com.fimi.kernel.p157b.p159b.C2205c.AbstractC2209b
    /* renamed from: a */
    public void mo8716a(List<C2196b> list, boolean z, C2196b c2196b) {
        if (c2196b != null) {
            this.f11157E = c2196b;
            if (isFinishing()) {
                return;
            }
            this.f11157E.m13289a((C2196b.AbstractC2202d) this);
        }
    }

    /* renamed from: a */
    protected void m10033a(boolean z) {
        if (z) {
            this.f11178s.setVisibility(8);
            this.f11180u.setVisibility(0);
            return;
        }
        this.f11178s.setVisibility(0);
        this.f11180u.setVisibility(4);
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        if (!z || !this.f11174o) {
            if (z || !this.f11174o) {
                return;
            }
            switch (x11RespCmd.getMsg_id()) {
                case C2427e.f8188R /* 1281 */:
                    C2284z.m12694a(this, getResources().getString(C2300R.C2303string.del_fail), C2284z.f7606b);
                    return;
                default:
                    return;
            }
        }
        switch (x11RespCmd.getMsg_id()) {
            case C2427e.f8188R /* 1281 */:
                if (this.f11183x.get(this.f11175p.getCurrentItem()) != null) {
                    File file = new File(this.f11183x.get(this.f11175p.getCurrentItem()).replace("file://", ""));
                    if (file.exists()) {
                        file.delete();
                    }
                }
                this.f11173n.a(true);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                if (this.f11166N.size() > this.f11175p.getCurrentItem()) {
                    bundle.putSerializable(C2353b.f7923N, this.f11166N.get(this.f11175p.getCurrentItem()));
                }
                intent.putExtras(bundle);
                setResult(2, intent);
                finish();
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    protected void m10029b(boolean z) {
        this.f11178s.setVisibility(z ? 0 : 8);
    }

    /* renamed from: c */
    protected void m10026c(boolean z) {
        this.f11179t.setVisibility(z ? 0 : 8);
    }

    @Override // com.fimi.soul.base.BaseFimiActivity, android.app.Activity
    public void finish() {
        overridePendingTransition(17432576, 17432577);
        super.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_image_pager);
        ShareSDK.initSDK(this);
        this.f11154B = (ImageButton) findViewById(C2300R.C2302id.playButton);
        getWindow().setFlags(128, 128);
        this.f11173n = (C2423d) C2379b.m12410a().m12394d();
        this.f11173n.a(this);
        findViewById(C2300R.C2302id.prll_tab_top).setBackgroundResource(C2300R.color.light_black_80);
        findViewById(C2300R.C2302id.ll_progressBottom).setBackgroundResource(C2300R.color.light_black_80);
        this.f11179t = findViewById(C2300R.C2302id.rl_tab_top);
        this.f11179t.setOnClickListener(this);
        this.f11178s = findViewById(C2300R.C2302id.ll_actionBottom);
        this.f11178s.setOnClickListener(this);
        this.f11178s.setBackgroundResource(C2300R.C2301drawable.title_bottom_share_bg);
        this.f11180u = findViewById(C2300R.C2302id.ll_progressBottom);
        this.f11162J = (TextView) findViewById(C2300R.C2302id.file_name_tv);
        this.f11163K = (TextView) findViewById(C2300R.C2302id.file_percent_tv);
        this.f11164L = (TextView) findViewById(C2300R.C2302id.down_speed);
        this.f11160H = (Button) findViewById(C2300R.C2302id.btn_cancel);
        this.f11161I = (Button) findViewById(C2300R.C2302id.btn_start);
        C3658ar.m7612a(getAssets(), this.f11160H, this.f11161I, this.f11162J, this.f11163K, this.f11164L);
        this.f11158F = (ProgressView) this.f11180u.findViewById(C2300R.C2302id.pv_progress);
        this.f11158F.setFrontColor(-42978);
        this.f11166N = C2331f.f7804a;
        this.f11182w = getIntent().getStringArrayListExtra("image_urls");
        this.f11183x = getIntent().getStringArrayListExtra(f11150e);
        this.f11174o = getIntent().getBooleanExtra(f11149d, false);
        this.f11184y = getIntent().getStringArrayListExtra(f11151f);
        if (getIntent().getIntExtra(f11147b, 1) == 2) {
            this.f11154B.setVisibility(0);
        } else {
            this.f11154B.setVisibility(8);
        }
        if (bundle != null) {
            this.f11176q = bundle.getInt(f11152m);
        }
        this.f11159G = new C2583q(this);
        m10040a();
        m10031b();
        m10021f();
        this.f11154B.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.media.gallery.DroneImagePagerActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DroneImagePagerActivity.this.f11168h = (String) DroneImagePagerActivity.this.f11182w.get(DroneImagePagerActivity.this.f11175p.getCurrentItem());
                if (DroneImagePagerActivity.this.f11183x != null) {
                    DroneImagePagerActivity.this.f11167g = (String) DroneImagePagerActivity.this.f11183x.get(DroneImagePagerActivity.this.f11175p.getCurrentItem());
                }
                Intent intent = new Intent(DroneImagePagerActivity.this, FermiPlayerActivity.class);
                if (DroneImagePagerActivity.this.f11168h != null) {
                    intent.putExtra("SP_KEY_PLAYER_ADDR_VideoDialogFragment", DroneImagePagerActivity.this.f11168h.split("&&")[0]);
                } else {
                    intent.putExtra("SP_KEY_PLAYER_ADDR_VideoDialogFragment", DroneImagePagerActivity.this.f11183x);
                }
                intent.putExtra(FermiPlayerActivity.SP_KEY_PLAYER_IS_REMOTE_ADDR, DroneImagePagerActivity.this.f11167g);
                intent.putExtra(FermiPlayerActivity.PLAY_NOW, true);
                intent.putExtra(FermiPlayerActivity.ONLINEFILE, DroneImagePagerActivity.this.f11174o);
                DroneImagePagerActivity.this.startActivity(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 121) {
            this.f11172l = true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f11157E == null || this.f11157E.m13262g() != C2196b.EnumC2198a.Pause) {
            this.f11161I.setVisibility(8);
            this.f11160H.setVisibility(0);
            return;
        }
        this.f11161I.setVisibility(0);
        this.f11160H.setVisibility(8);
        long m13258i = this.f11157E.m13258i();
        long m13254k = this.f11157E.m13254k();
        this.f11158F.setMaxCount((float) m13258i);
        this.f11158F.setCurrentCount((float) m13254k);
        this.f11162J.setText(String.format(getString(C2300R.C2303string.download_file_phone), m10019g()));
        this.f11163K.setText((m13254k / (m13258i / 100)) + "%");
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(f11152m, this.f11175p.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f11169i = C2277v.m12784a(this);
    }
}
