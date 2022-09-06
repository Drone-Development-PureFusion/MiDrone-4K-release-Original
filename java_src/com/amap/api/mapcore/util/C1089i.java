package com.amap.api.mapcore.util;

import android.content.Context;
import com.autonavi.amap.mapcore.MapCore;
import com.autonavi.amap.mapcore.MapTilsCacheAndResManager;
/* renamed from: com.amap.api.mapcore.util.i */
/* loaded from: classes.dex */
public class C1089i {

    /* renamed from: a */
    public boolean f3390a = true;

    /* renamed from: b */
    private C0802b f3391b;

    /* renamed from: c */
    private Context f3392c;

    /* renamed from: d */
    private MapCore f3393d;

    /* renamed from: com.amap.api.mapcore.util.i$a */
    /* loaded from: classes.dex */
    public enum EnumC1094a {
        NORAML,
        SATELLITE,
        BUS
    }

    /* renamed from: com.amap.api.mapcore.util.i$b */
    /* loaded from: classes.dex */
    public enum EnumC1095b {
        NORMAL,
        PREVIEW_CAR,
        PREVIEW_BUS,
        PREVIEW_FOOT,
        NAVI_CAR,
        NAVI_BUS,
        NAVI_FOOT
    }

    /* renamed from: com.amap.api.mapcore.util.i$c */
    /* loaded from: classes.dex */
    public enum EnumC1096c {
        DAY,
        NIGHT
    }

    public C1089i(C0802b c0802b, Context context) {
        this.f3391b = null;
        this.f3392c = null;
        this.f3393d = null;
        this.f3391b = c0802b;
        this.f3392c = context;
        this.f3393d = this.f3391b.mo17557a();
    }

    /* renamed from: a */
    private String m17648a(String str) {
        if (str.equals("icons_1_7_1444880368.data")) {
            this.f3390a = true;
            return "icons_4_6_1437480571.data";
        }
        this.f3390a = false;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17646a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        if (bArr != null) {
            this.f3393d.setInternaltexture(bArr, 6);
        }
        if (bArr2 != null) {
            this.f3393d.setInternaltexture(bArr2, 4);
        }
        if (bArr3 != null) {
            this.f3393d.setInternaltexture(bArr3, 5);
        }
        if (bArr4 != null) {
            this.f3393d.setInternaltexture(bArr4, 7);
        }
        if (bArr5 != null) {
            this.f3393d.setInternaltexture(bArr5, 18);
        }
    }

    /* renamed from: a */
    public void m17651a() {
        if (this.f3391b == null) {
            return;
        }
        MapTilsCacheAndResManager.RetStyleIconsFile retStyleIconsFile = new MapTilsCacheAndResManager.RetStyleIconsFile();
        byte[] styleData = MapTilsCacheAndResManager.getInstance(this.f3392c).getStyleData(m17645b(), retStyleIconsFile);
        if (styleData != null) {
            this.f3393d.setStyleData(styleData, 0, 1);
        }
        byte[] styleData2 = MapTilsCacheAndResManager.getInstance(this.f3392c).getStyleData("style_50_7_1445670996.data", retStyleIconsFile);
        if (styleData2 == null) {
            return;
        }
        this.f3393d.setStyleData(styleData2, 1, 1);
    }

    /* renamed from: a */
    public void m17647a(boolean z) {
        if (this.f3391b == null) {
            return;
        }
        final byte[] bArr = null;
        MapTilsCacheAndResManager.RetStyleIconsFile retStyleIconsFile = new MapTilsCacheAndResManager.RetStyleIconsFile();
        String m17643c = m17643c();
        String m17648a = m17648a(m17643c);
        final byte[] iconsData = MapTilsCacheAndResManager.getInstance(this.f3392c).getIconsData(m17643c, retStyleIconsFile);
        if (this.f3390a) {
            bArr = MapTilsCacheAndResManager.getInstance(this.f3392c).getIconsData(m17648a, new MapTilsCacheAndResManager.RetStyleIconsFile());
        }
        final byte[] iconsData2 = MapTilsCacheAndResManager.getInstance(this.f3392c).getIconsData("icons_50_7_1444880375.data", retStyleIconsFile);
        if (!z) {
            this.f3391b.m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.i.1
                @Override // java.lang.Runnable
                public void run() {
                    if (iconsData != null) {
                        C1089i.this.f3393d.setInternaltexture(iconsData, 0);
                    }
                    if (iconsData2 != null) {
                        C1089i.this.f3393d.setInternaltexture(iconsData2, 31);
                    }
                    if (!C1089i.this.f3390a || bArr == null) {
                        return;
                    }
                    C1089i.this.f3393d.setInternaltexture(bArr, 20);
                }
            });
            return;
        }
        if (iconsData != null) {
            this.f3393d.setInternaltexture(iconsData, 0);
        }
        if (iconsData2 != null) {
            this.f3393d.setInternaltexture(iconsData2, 31);
        }
        if (!this.f3390a || bArr == null) {
            return;
        }
        this.f3393d.setInternaltexture(bArr, 20);
    }

    /* renamed from: b */
    public String m17645b() {
        if (this.f3391b == null) {
            return "";
        }
        EnumC1096c m18894v = this.f3391b.m18894v();
        EnumC1094a m18892w = this.f3391b.m18892w();
        EnumC1095b m18890x = this.f3391b.m18890x();
        return EnumC1096c.DAY == m18894v ? EnumC1094a.NORAML == m18892w ? EnumC1095b.NAVI_CAR == m18890x ? "style_4_7_1445391691.data" : EnumC1095b.PREVIEW_BUS == m18890x ? "style_6_7_1445325996.data" : EnumC1095b.PREVIEW_CAR == m18890x ? "style_8_7_1445391734.data" : EnumC1095b.NAVI_BUS == m18890x ? "style_9_7_1445327958.data" : "style_1_7_1445219169.data" : EnumC1094a.SATELLITE == m18892w ? EnumC1095b.NAVI_CAR == m18890x ? "style_4_7_1445391691.data" : EnumC1095b.PREVIEW_BUS == m18890x ? "style_6_7_1445325996.data" : "style_3_7_1445827513.data" : EnumC1094a.BUS == m18892w ? EnumC1095b.NAVI_CAR == m18890x ? "style_4_7_1445391691.data" : EnumC1095b.PREVIEW_BUS == m18890x ? "style_6_7_1445325996.data" : "style_6_7_1445325996.data" : "" : EnumC1096c.NIGHT == m18894v ? EnumC1094a.NORAML == m18892w ? EnumC1095b.NAVI_CAR == m18890x ? "style_5_7_1445391719.data" : EnumC1095b.PREVIEW_BUS == m18890x ? "style_6_7_1445325996.data" : "style_1_7_1445219169.data" : EnumC1094a.SATELLITE == m18892w ? EnumC1095b.NAVI_CAR == m18890x ? "style_5_7_1445391719.data" : EnumC1095b.PREVIEW_BUS == m18890x ? "style_6_7_1445325996.data" : "style_3_7_1445827513.data" : EnumC1094a.BUS == m18892w ? EnumC1095b.NAVI_CAR == m18890x ? "style_5_7_1445391719.data" : EnumC1095b.PREVIEW_BUS == m18890x ? "style_6_7_1445325996.data" : "style_6_7_1445325996.data" : "" : "";
    }

    /* renamed from: b */
    public void m17644b(boolean z) {
        byte[] otherResData;
        byte[] otherResData2;
        byte[] otherResData3;
        byte[] otherResData4;
        byte[] otherResData5;
        if (this.f3391b.m18894v() != EnumC1096c.NIGHT) {
            otherResData = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("tgl_l.data");
            otherResData2 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("trl_l.data");
            otherResData3 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("tyl_l.data");
            otherResData4 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("tbl_l.data");
            otherResData5 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("tnl_l.data");
        } else {
            otherResData = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("tgl_n.data");
            otherResData2 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("trl_n.data");
            otherResData3 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("tyl_n.data");
            otherResData4 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("tbl_n.data");
            otherResData5 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("tnl_n.data");
        }
        if (z) {
            m17646a(otherResData, otherResData2, otherResData3, otherResData4, otherResData5);
            return;
        }
        final byte[] bArr = otherResData;
        final byte[] bArr2 = otherResData2;
        final byte[] bArr3 = otherResData3;
        final byte[] bArr4 = otherResData4;
        final byte[] bArr5 = otherResData5;
        this.f3391b.m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.i.2
            @Override // java.lang.Runnable
            public void run() {
                C1089i.this.m17646a(bArr, bArr2, bArr3, bArr4, bArr5);
            }
        });
    }

    /* renamed from: c */
    public String m17643c() {
        if (this.f3391b == null) {
            return "";
        }
        EnumC1096c m18894v = this.f3391b.m18894v();
        EnumC1094a m18892w = this.f3391b.m18892w();
        return EnumC1096c.DAY == m18894v ? EnumC1094a.BUS == m18892w ? "icons_3_7_1444880372.data" : "icons_1_7_1444880368.data" : EnumC1096c.NIGHT == m18894v ? EnumC1094a.BUS == m18892w ? "icons_3_7_1444880372.data" : "icons_2_7_1445580283.data" : "";
    }

    /* renamed from: c */
    public void m17642c(boolean z) {
        final byte[] otherResData;
        final byte[] otherResData2;
        if (this.f3391b.m18894v() != EnumC1096c.NIGHT) {
            otherResData = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("bktile.data");
            otherResData2 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("3d_sky_day.dat");
        } else {
            otherResData = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("bktile_n.data");
            otherResData2 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("3d_sky_night.dat");
        }
        if (!z) {
            this.f3391b.m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.i.3
                @Override // java.lang.Runnable
                public void run() {
                    C1089i.this.f3393d.setInternaltexture(otherResData, 1);
                    C1089i.this.f3393d.setInternaltexture(otherResData2, 41);
                }
            });
            return;
        }
        this.f3393d.setInternaltexture(otherResData, 1);
        this.f3393d.setInternaltexture(otherResData2, 41);
    }

    /* renamed from: d */
    public void m17641d(boolean z) {
    }

    /* renamed from: e */
    public void m17640e(boolean z) {
        final byte[] otherResData = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("roadarrow.data");
        final byte[] otherResData2 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("lineround.data");
        final byte[] otherResData3 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("dash.data");
        final byte[] otherResData4 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("dash_tq.data");
        final byte[] otherResData5 = MapTilsCacheAndResManager.getInstance(this.f3392c).getOtherResData("dash_cd.data");
        if (!z) {
            this.f3391b.m18936a(new Runnable() { // from class: com.amap.api.mapcore.util.i.4
                @Override // java.lang.Runnable
                public void run() {
                    C1089i.this.f3393d.setInternaltexture(otherResData, 2);
                    C1089i.this.f3393d.setInternaltexture(otherResData2, 3);
                    C1089i.this.f3393d.setInternaltexture(otherResData3, 8);
                    C1089i.this.f3393d.setInternaltexture(otherResData4, 9);
                    C1089i.this.f3393d.setInternaltexture(otherResData5, 10);
                }
            });
            return;
        }
        this.f3393d.setInternaltexture(otherResData, 2);
        this.f3393d.setInternaltexture(otherResData2, 3);
        this.f3393d.setInternaltexture(otherResData3, 8);
        this.f3393d.setInternaltexture(otherResData4, 9);
        this.f3393d.setInternaltexture(otherResData5, 10);
    }
}
