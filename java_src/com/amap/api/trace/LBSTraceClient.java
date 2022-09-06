package com.amap.api.trace;

import android.content.Context;
import com.amap.api.mapcore.util.C0945eh;
import com.amap.api.mapcore.util.C0971ev;
import com.amap.api.mapcore.util.C1032gj;
import java.util.List;
/* loaded from: classes.dex */
public class LBSTraceClient implements LBSTraceBase {
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;

    /* renamed from: a */
    private LBSTraceBase f4515a;

    public LBSTraceClient(Context context) {
        if (context != null) {
            try {
                this.f4515a = (LBSTraceBase) C1032gj.m17904a(context.getApplicationContext(), C0945eh.m18310e(), "com.amap.api.wrapper.LBSTraceClientWrapper", C0971ev.class, new Class[]{Context.class}, new Object[]{context.getApplicationContext()});
            } catch (Throwable th) {
                this.f4515a = new C0971ev(context.getApplicationContext());
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
        if (this.f4515a != null) {
            this.f4515a.queryProcessedTrace(i, list, i2, traceListener);
        }
    }
}
