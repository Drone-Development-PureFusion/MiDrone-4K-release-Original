package com.p080b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.fence.Fence;
import com.amap.api.location.AMapLocation;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* renamed from: com.b.dg */
/* loaded from: classes.dex */
public class C1524dg {

    /* renamed from: a */
    Context f5460a;

    /* renamed from: b */
    private Hashtable<PendingIntent, ArrayList<Fence>> f5461b = new Hashtable<>();

    public C1524dg(Context context) {
        this.f5460a = context;
    }

    /* renamed from: a */
    private void m15702a(PendingIntent pendingIntent, Fence fence, int i) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("fenceid", fence.f1954b);
        bundle.putInt("event", i);
        intent.putExtras(bundle);
        try {
            pendingIntent.send(this.f5460a, 0, intent);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "FenceManager", "fcIntent");
        }
    }

    /* renamed from: a */
    private boolean m15700a(PendingIntent pendingIntent, List<String> list) {
        boolean z;
        boolean z2 = false;
        if (!m15695b() && list != null && !list.isEmpty() && this.f5461b.containsKey(pendingIntent)) {
            Iterator<Fence> it2 = this.f5461b.get(pendingIntent).iterator();
            while (it2 != null && it2.hasNext()) {
                Fence next = it2.next();
                if (list.contains(next.f1954b) || m15699a(next)) {
                    it2.remove();
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
        }
        return z2;
    }

    /* renamed from: a */
    private boolean m15699a(Fence fence) {
        return fence.m19123b() != -1 && fence.m19123b() <= C1477bs.m15997b();
    }

    /* renamed from: a */
    private boolean m15696a(List<String> list) {
        boolean z;
        if (!m15695b() && list != null && !list.isEmpty()) {
            Iterator<Map.Entry<PendingIntent, ArrayList<Fence>>> it2 = this.f5461b.entrySet().iterator();
            boolean z2 = false;
            while (it2 != null && it2.hasNext()) {
                Map.Entry<PendingIntent, ArrayList<Fence>> next = it2.next();
                Iterator<Fence> it3 = next.getValue().iterator();
                while (it3 != null && it3.hasNext()) {
                    Fence next2 = it3.next();
                    if (list.contains(next2.f1954b) || m15699a(next2)) {
                        it3.remove();
                        z = true;
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
                if (next.getValue().isEmpty()) {
                    it2.remove();
                }
            }
            return z2;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m15695b() {
        return this.f5461b.isEmpty();
    }

    /* renamed from: a */
    public void m15704a() {
        this.f5461b.clear();
    }

    /* renamed from: a */
    public void m15697a(AMapLocation aMapLocation) {
        if (m15695b()) {
            return;
        }
        Iterator<Map.Entry<PendingIntent, ArrayList<Fence>>> it2 = this.f5461b.entrySet().iterator();
        while (it2 != null && it2.hasNext()) {
            Map.Entry<PendingIntent, ArrayList<Fence>> next = it2.next();
            Iterator<Fence> it3 = next.getValue().iterator();
            while (it3.hasNext()) {
                Fence next2 = it3.next();
                if (!m15699a(next2)) {
                    float m15998a = C1477bs.m15998a(new double[]{next2.f1956d, next2.f1955c, aMapLocation.getLatitude(), aMapLocation.getLongitude()});
                    float accuracy = aMapLocation.getAccuracy();
                    float f = accuracy >= 500.0f ? m15998a - (next2.f1957e + 500.0f) : m15998a - (accuracy + next2.f1957e);
                    boolean z = false;
                    if (f > 0.0f) {
                        if (next2.f1959g != 0) {
                            z = true;
                        }
                        next2.f1959g = 0;
                    } else {
                        if (next2.f1959g != 1) {
                            z = true;
                        }
                        next2.f1959g = 1;
                    }
                    if (z) {
                        switch (next2.f1959g) {
                            case 0:
                                next2.f1960h = -1L;
                                if ((next2.m19125a() & 2) != 2) {
                                    break;
                                } else {
                                    m15702a(next.getKey(), next2, 2);
                                    break;
                                }
                            case 1:
                                next2.f1960h = C1477bs.m15997b();
                                if ((next2.m19125a() & 1) != 1) {
                                    break;
                                } else {
                                    m15702a(next.getKey(), next2, 1);
                                    break;
                                }
                        }
                    } else if ((next2.m19125a() & 4) == 4 && next2.f1960h > 0 && C1477bs.m15997b() - next2.f1960h > next2.m19122c()) {
                        next2.f1960h = C1477bs.m15997b();
                        m15702a(next.getKey(), next2, 4);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m15703a(PendingIntent pendingIntent) {
        if (pendingIntent == null || !this.f5461b.containsKey(pendingIntent)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Fence> it2 = this.f5461b.get(pendingIntent).iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().f1954b);
        }
        return m15696a(arrayList);
    }

    /* renamed from: a */
    public boolean m15701a(PendingIntent pendingIntent, String str) {
        if (pendingIntent == null || !this.f5461b.containsKey(pendingIntent) || TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return m15700a(pendingIntent, arrayList);
    }

    /* renamed from: a */
    public boolean m15698a(Fence fence, PendingIntent pendingIntent) {
        if (pendingIntent == null || fence == null) {
            return false;
        }
        if (!TextUtils.isEmpty(fence.f1954b) && fence.f1957e >= 100.0f && fence.f1957e <= 1000.0f) {
            if ((m15695b() || this.f5461b.containsKey(pendingIntent)) && fence.m19125a() != 0 && fence.m19125a() <= 7) {
                Iterator<Map.Entry<PendingIntent, ArrayList<Fence>>> it2 = this.f5461b.entrySet().iterator();
                int i = 0;
                while (it2 != null && it2.hasNext()) {
                    i = it2.next().getValue().size() + i;
                }
                if (i > 20) {
                    return false;
                }
                fence.f1959g = -1;
                if (!m15695b()) {
                    ArrayList<Fence> arrayList = this.f5461b.get(pendingIntent);
                    Fence fence2 = null;
                    Iterator<Fence> it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        Fence next = it3.next();
                        if (!next.f1954b.equals(fence.f1954b)) {
                            next = fence2;
                        }
                        fence2 = next;
                    }
                    if (fence2 != null) {
                        arrayList.remove(fence2);
                    }
                    arrayList.add(fence);
                    this.f5461b.put(pendingIntent, arrayList);
                } else {
                    ArrayList<Fence> arrayList2 = new ArrayList<>();
                    arrayList2.add(fence);
                    this.f5461b.put(pendingIntent, arrayList2);
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
