package com.fimi.soul.receiver;

import android.content.Context;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p181j.C2496e;
import com.fimi.soul.receiver.NetworkStateReceiver;
import com.fimi.soul.service.QueryDynamicFlyZoneSetvice;
/* loaded from: classes.dex */
public class SpeekSignReceiver extends NetworkStateReceiver {
    @Override // com.fimi.soul.receiver.NetworkStateReceiver
    /* renamed from: a */
    public void mo7774a(NetworkStateReceiver.EnumC3591a enumC3591a, final Context context) {
        if (enumC3591a == NetworkStateReceiver.EnumC3591a.Wifi || enumC3591a == NetworkStateReceiver.EnumC3591a.Mobile) {
            C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.receiver.SpeekSignReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    C2244b m13105a = C2244b.m13105a(context);
                    if (!m13105a.m13094d()) {
                        m13105a.m13106a();
                    }
                }
            });
            C2496e.m11922a().m11920a(C2496e.EnumC2497a.IDEL);
            QueryDynamicFlyZoneSetvice.m7809a(context);
        }
    }
}
