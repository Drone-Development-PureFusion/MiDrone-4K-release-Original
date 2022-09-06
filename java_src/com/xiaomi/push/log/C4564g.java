package com.xiaomi.push.log;

import android.util.Log;
import com.xiaomi.channel.commonutils.file.C4476c;
import com.xiaomi.channel.commonutils.misc.C4488h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.log.g */
/* loaded from: classes2.dex */
public class C4564g extends C4488h.AbstractC4490b {

    /* renamed from: a */
    final /* synthetic */ C4563f f18752a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4564g(C4563f c4563f) {
        this.f18752a = c4563f;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C4488h.AbstractC4490b
    /* renamed from: b */
    public void mo3817b() {
        List list;
        String str;
        String str2;
        list = C4563f.f18749f;
        if (list.isEmpty()) {
            return;
        }
        try {
            if (!C4476c.m5049d()) {
                str2 = this.f18752a.f18750d;
                Log.w(str2, "SDCard is unavailable.");
            } else {
                this.f18752a.m4709b();
            }
        } catch (Exception e) {
            str = this.f18752a.f18750d;
            Log.e(str, "", e);
        }
    }
}
