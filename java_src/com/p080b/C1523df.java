package com.p080b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* renamed from: com.b.df */
/* loaded from: classes.dex */
public final class C1523df {

    /* renamed from: b */
    private String f5455b;

    /* renamed from: c */
    private String f5456c;

    /* renamed from: a */
    private boolean f5454a = false;

    /* renamed from: d */
    private boolean f5457d = false;

    /* renamed from: e */
    private double f5458e = 0.0d;

    /* renamed from: f */
    private double f5459f = 0.0d;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1523df(List list, String str, String str2, String str3) {
        this.f5455b = "";
        this.f5456c = "";
        this.f5455b = str;
        this.f5456c = str3;
        m15705d();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(5:5|(2:8|6)|9|10|(7:12|(5:14|(4:17|(2:19|20)(1:22)|21|15)|23|24|(1:26)(2:28|(1:36)))|37|38|(2:44|(3:56|57|(1:59)))|61|62))|64|(0)|37|38|(4:40|42|44|(8:46|48|50|52|54|56|57|(0)))|61|62) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0120  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m15705d() {
        boolean z;
        String[] split;
        boolean z2 = false;
        String str = this.f5456c;
        if (str != null && str.length() > 8) {
            int i = 0;
            for (int i2 = 1; i2 < str.length() - 3; i2++) {
                i ^= str.charAt(i2);
            }
            if (Integer.toHexString(i).equalsIgnoreCase(str.substring(str.length() - 2, str.length()))) {
                z = true;
                if (z) {
                    String substring = this.f5456c.substring(0, this.f5456c.length() - 3);
                    int i3 = 0;
                    for (int i4 = 0; i4 < substring.length(); i4++) {
                        if (substring.charAt(i4) == ',') {
                            i3++;
                        }
                    }
                    String[] split2 = substring.split(Constants.ACCEPT_TIME_SEPARATOR_SP, i3 + 1);
                    if (split2.length < 6) {
                        return;
                    }
                    if (!split2[2].equals("") && !split2[split2.length - 3].equals("") && !split2[split2.length - 2].equals("") && !split2[split2.length - 1].equals("")) {
                        Integer.valueOf(split2[2]).intValue();
                        this.f5458e = Double.valueOf(split2[split2.length - 3]).doubleValue();
                        this.f5459f = Double.valueOf(split2[split2.length - 2]).doubleValue();
                        this.f5457d = true;
                    }
                }
                if (this.f5455b != null && this.f5455b.length() >= 0 && this.f5455b.contains("GPGGA")) {
                    split = this.f5455b.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split.length == 15 && split[2] != null && split[2].length() > 0 && split[4] != null && split[4].length() > 0 && Integer.parseInt(split[7]) >= 5) {
                        if (Double.parseDouble(split[8]) <= 2.7d) {
                            z2 = true;
                        }
                    }
                }
                this.f5454a = this.f5457d & z2;
            }
        }
        z = false;
        if (z) {
        }
        if (this.f5455b != null) {
            split = this.f5455b.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length == 15) {
                if (Double.parseDouble(split[8]) <= 2.7d) {
                }
            }
        }
        this.f5454a = this.f5457d & z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean m15708a() {
        return this.f5454a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final double m15707b() {
        return this.f5458e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final double m15706c() {
        return this.f5459f;
    }
}
