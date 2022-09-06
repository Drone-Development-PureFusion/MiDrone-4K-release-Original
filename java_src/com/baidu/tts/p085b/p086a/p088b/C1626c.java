package com.baidu.tts.p085b.p086a.p088b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p085b.p086a.p088b.C1634f;
import com.baidu.tts.p096e.EnumC1707j;
import com.baidu.tts.p096e.EnumC1709l;
import com.baidu.tts.p099g.p101b.C1719b;
import com.baidu.tts.p108l.C1738b;
import com.fimi.soul.service.CameraSocketService;
/* renamed from: com.baidu.tts.b.a.b.c */
/* loaded from: classes.dex */
public class C1626c {

    /* renamed from: a */
    private C1738b f5726a;

    /* renamed from: b */
    private EnumC1707j f5727b;

    /* renamed from: a */
    private boolean m15236a(int i) {
        return m15233b(i) >= 2;
    }

    /* renamed from: b */
    private int m15233b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 2;
            case 13:
                return 3;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    private boolean m15234b() {
        EnumC1707j enumC1707j = null;
        try {
            enumC1707j = this.f5726a.m14791c();
        } catch (Exception e) {
        }
        if (this.f5727b == null) {
            if (enumC1707j == null) {
                this.f5727b = EnumC1707j.DEFAULT;
                return true;
            }
            this.f5727b = enumC1707j;
            return true;
        }
        if (enumC1707j != null && !this.f5727b.equals(enumC1707j)) {
            this.f5727b = enumC1707j;
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m15232c(int i) {
        switch (i) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public void m15235a(C1738b c1738b) {
        this.f5726a = c1738b;
    }

    /* renamed from: a */
    public boolean m15237a() {
        try {
            Context m14864h = C1719b.m14869a().m14864h();
            if (m14864h != null) {
                if (m15234b()) {
                    C1634f.C1636b m14796a = this.f5726a.m14796a();
                    if (this.f5727b.equals(EnumC1707j.HIGH_SPEED_SYNTHESIZE) || this.f5727b.equals(EnumC1707j.HIGH_SPEED_SYNTHESIZE_WIFI)) {
                        m14796a.m15180c(CameraSocketService.f14616b);
                    } else {
                        m14796a.m15180c(EnumC1709l.MIX_ONLINE_REQUEST_TIMEOUT.m14890b());
                    }
                }
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) m14864h.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    int type = activeNetworkInfo.getType();
                    int subtype = activeNetworkInfo.getSubtype();
                    switch (this.f5727b) {
                        case DEFAULT:
                        case HIGH_SPEED_SYNTHESIZE_WIFI:
                            if (m15232c(type) || type == 9) {
                                return true;
                            }
                        case HIGH_SPEED_NETWORK:
                        case HIGH_SPEED_SYNTHESIZE:
                            if (m15232c(type) || type == 9 || m15236a(subtype)) {
                                return true;
                            }
                    }
                }
            }
        } catch (Exception e) {
            LoggerProxy.m15091d("MixStrategy", e.toString());
        }
        return false;
    }
}
