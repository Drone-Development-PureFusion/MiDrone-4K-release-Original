package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p183l.AbstractC2532e;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.AbstractC2569j;
import com.fimi.soul.entity.FdsMsg;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.SuggestBean;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.fimi.soul.biz.n.t */
/* loaded from: classes.dex */
public class C2597t extends AbstractC2569j {

    /* renamed from: g */
    public ArrayList<Bitmap> f8975g = new ArrayList<>();

    /* renamed from: h */
    private Context f8976h;

    public C2597t(Context context) {
        super(context);
        this.f8976h = context;
    }

    /* renamed from: a */
    public PlaneMsg m11577a(final SuggestBean suggestBean, final AbstractC2538k abstractC2538k) {
        this.f8856f.put(1, abstractC2538k);
        C2562f m11683a = C2562f.m11683a(this.f8976h);
        if (this.f8975g == null || this.f8975g.size() <= 0 || "0".equals(suggestBean.getUserID())) {
            C2281x.m12702b(new AbstractC2569j.RunnableC2570a(1, suggestBean, abstractC2538k));
        } else {
            final int size = this.f8975g.size();
            Iterator<Bitmap> it2 = this.f8975g.iterator();
            while (it2.hasNext()) {
                Bitmap next = it2.next();
                m11683a.m11682a(next, new AbstractC2532e() { // from class: com.fimi.soul.biz.n.t.1
                    @Override // com.fimi.soul.biz.p183l.AbstractC2532e
                    /* renamed from: a */
                    public void mo9725a(long j, long j2, String str) {
                    }

                    @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                    /* renamed from: a */
                    public void mo6501a(PlaneMsg planeMsg, File file) {
                        if (!planeMsg.isSuccess()) {
                            Log.i("suguest fds :", "false");
                            return;
                        }
                        suggestBean.getList().add(((FdsMsg) planeMsg.getData()).getUrl());
                        if (suggestBean.getList().size() != size) {
                            return;
                        }
                        C2281x.m12702b(new AbstractC2569j.RunnableC2570a(1, suggestBean, abstractC2538k));
                    }
                });
                if (next != null && next.isRecycled()) {
                    next.recycle();
                }
            }
        }
        return this.f8855e;
    }

    /* renamed from: a */
    public void m11578a(Bitmap bitmap) {
        this.f8975g.add(bitmap);
    }

    /* renamed from: b */
    public PlaneMsg m11575b(SuggestBean suggestBean, AbstractC2538k abstractC2538k) {
        this.f8856f.put(1, abstractC2538k);
        C2281x.m12702b(new AbstractC2569j.RunnableC2570a(1, suggestBean, abstractC2538k));
        return this.f8855e;
    }

    /* renamed from: b */
    public ArrayList<Bitmap> m11576b() {
        return this.f8975g;
    }
}
