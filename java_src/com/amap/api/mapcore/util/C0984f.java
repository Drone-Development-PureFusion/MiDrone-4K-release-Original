package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.mapcore.util.C0977ez;
import com.amap.api.maps.MapsInitializer;
/* renamed from: com.amap.api.mapcore.util.f */
/* loaded from: classes.dex */
public class C0984f extends Thread {

    /* renamed from: a */
    private Context f3087a;

    /* renamed from: b */
    private AbstractC1115l f3088b;

    public C0984f(Context context, AbstractC1115l abstractC1115l) {
        this.f3087a = context;
        this.f3088b = abstractC1115l;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (!MapsInitializer.getNetWorkEnable()) {
                return;
            }
            C0996fh m18310e = C0945eh.m18310e();
            C0977ez.C0978a m18164a = C0977ez.m18164a(this.f3087a, C0945eh.m18310e(), "002;11K;001", null);
            if (C0977ez.f3050a != 1) {
                Message obtainMessage = this.f3088b.getMainHandler().obtainMessage();
                obtainMessage.what = 2;
                if (m18164a.f3052a != null) {
                    obtainMessage.obj = m18164a.f3052a;
                }
                this.f3088b.getMainHandler().sendMessage(obtainMessage);
            }
            if (m18164a != null) {
                if (m18164a.f3067p != null) {
                    C0945eh.m18310e().m18072a(m18164a.f3067p.f3074a);
                }
                if (m18164a.f3069r != null) {
                    new C0994fg(this.f3087a, "3dmap", m18164a.f3069r.f3080a, m18164a.f3069r.f3081b).m18078a();
                }
            }
            if (m18164a != null && m18164a.f3068q != null) {
                C0977ez.C0978a.C0982d c0982d = m18164a.f3068q;
                if (c0982d != null) {
                    String str = c0982d.f3083b;
                    String str2 = c0982d.f3082a;
                    String str3 = c0982d.f3084c;
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                        new C1030gh(this.f3087a, null, C0945eh.m18310e()).m17919a();
                    } else {
                        new C1030gh(this.f3087a, new C1031gi(str2, str, str3), C0945eh.m18310e()).m17919a();
                    }
                } else {
                    new C1030gh(this.f3087a, null, C0945eh.m18310e()).m17919a();
                }
            }
            C1022g.f3204f = m18310e;
            C1007fo.m18017a(this.f3087a, m18310e);
            interrupt();
            this.f3088b.setRunLowFrame(false);
        } catch (Throwable th) {
            interrupt();
            C1007fo.m18012b(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
        }
    }
}
