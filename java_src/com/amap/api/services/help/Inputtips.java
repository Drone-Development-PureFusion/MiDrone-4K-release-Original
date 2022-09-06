package com.amap.api.services.help;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C1233d;
import com.amap.api.services.core.C1237h;
import com.amap.api.services.core.C1238i;
import com.amap.api.services.core.C1241l;
import com.amap.api.services.core.HandlerC1246p;
import java.util.List;
/* loaded from: classes.dex */
public final class Inputtips {

    /* renamed from: a */
    private Context f4285a;

    /* renamed from: b */
    private InputtipsListener f4286b;

    /* renamed from: c */
    private Handler f4287c = HandlerC1246p.m16952a();

    /* loaded from: classes.dex */
    public interface InputtipsListener {
        void onGetInputtips(List<Tip> list, int i);
    }

    public Inputtips(Context context, InputtipsListener inputtipsListener) {
        this.f4285a = context.getApplicationContext();
        this.f4286b = inputtipsListener;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.amap.api.services.help.Inputtips$1] */
    public void requestInputtips(final String str, final String str2) {
        if (str == null || str.equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        C1241l.m16960a(this.f4285a);
        new Thread() { // from class: com.amap.api.services.help.Inputtips.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                C1237h c1237h = new C1237h(Inputtips.this.f4285a, new C1238i(str, str2));
                Message obtainMessage = HandlerC1246p.m16952a().obtainMessage();
                obtainMessage.obj = Inputtips.this.f4286b;
                obtainMessage.arg1 = 5;
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("result", c1237h.g());
                    obtainMessage.setData(bundle);
                    obtainMessage.what = 0;
                } catch (AMapException e) {
                    C1233d.m17031a(e, "Inputtips", "requestInputtips");
                    obtainMessage.what = e.getErrorCode();
                } finally {
                    Inputtips.this.f4287c.sendMessage(obtainMessage);
                }
            }
        }.start();
    }
}
