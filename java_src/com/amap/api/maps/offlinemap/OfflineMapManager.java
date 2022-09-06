package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.mapcore.util.C0790aw;
import com.amap.api.mapcore.util.C0794ax;
import com.amap.api.mapcore.util.C0831bb;
import com.amap.api.mapcore.util.C0945eh;
import com.amap.api.mapcore.util.C1007fo;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class OfflineMapManager {

    /* renamed from: a */
    C0831bb f3832a;

    /* renamed from: b */
    C0794ax f3833b;

    /* renamed from: c */
    private Context f3834c;

    /* renamed from: d */
    private OfflineMapDownloadListener f3835d;

    /* renamed from: e */
    private Handler f3836e;

    /* renamed from: f */
    private Handler f3837f;

    /* loaded from: classes.dex */
    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, String str);

        void onDownload(int i, int i2, String str);

        void onRemove(boolean z, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        this.f3835d = offlineMapDownloadListener;
        this.f3834c = context.getApplicationContext();
        this.f3836e = new Handler(this.f3834c.getMainLooper());
        this.f3837f = new Handler(this.f3834c.getMainLooper());
        m17365a(context);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.f3835d = offlineMapDownloadListener;
        this.f3834c = context.getApplicationContext();
        this.f3836e = new Handler(this.f3834c.getMainLooper());
        this.f3837f = new Handler(this.f3834c.getMainLooper());
        m17365a(context);
    }

    /* renamed from: a */
    private void m17366a() {
        if (!C0945eh.m18312c(this.f3834c)) {
            throw new AMapException("http连接失败 - ConnectionException");
        }
    }

    /* renamed from: a */
    private void m17365a(Context context) {
        this.f3834c = context.getApplicationContext();
        C0794ax.f2156b = false;
        this.f3833b = C0794ax.m19016a(this.f3834c);
        this.f3833b.m19013a(new C0794ax.AbstractC0798a() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1
            @Override // com.amap.api.mapcore.util.C0794ax.AbstractC0798a
            /* renamed from: a */
            public void mo17360a() {
            }

            @Override // com.amap.api.mapcore.util.C0794ax.AbstractC0798a
            /* renamed from: a */
            public void mo17359a(final C0790aw c0790aw) {
                if (OfflineMapManager.this.f3835d == null || c0790aw == null) {
                    return;
                }
                OfflineMapManager.this.f3836e.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OfflineMapManager.this.f3835d.onDownload(c0790aw.m19035c().m18723b(), c0790aw.getcompleteCode(), c0790aw.getCity());
                    }
                });
            }

            @Override // com.amap.api.mapcore.util.C0794ax.AbstractC0798a
            /* renamed from: b */
            public void mo17358b(final C0790aw c0790aw) {
                if (OfflineMapManager.this.f3835d == null || c0790aw == null) {
                    return;
                }
                OfflineMapManager.this.f3836e.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c0790aw.m19035c().equals(c0790aw.f2140g) || c0790aw.m19035c().equals(c0790aw.f2134a)) {
                            OfflineMapManager.this.f3835d.onCheckUpdate(true, c0790aw.getCity());
                        } else {
                            OfflineMapManager.this.f3835d.onCheckUpdate(false, c0790aw.getCity());
                        }
                    }
                });
            }

            @Override // com.amap.api.mapcore.util.C0794ax.AbstractC0798a
            /* renamed from: c */
            public void mo17357c(final C0790aw c0790aw) {
                if (OfflineMapManager.this.f3835d == null || c0790aw == null) {
                    return;
                }
                OfflineMapManager.this.f3836e.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c0790aw.m19035c().equals(c0790aw.f2134a)) {
                            OfflineMapManager.this.f3835d.onRemove(true, c0790aw.getCity(), "");
                        } else {
                            OfflineMapManager.this.f3835d.onRemove(false, c0790aw.getCity(), "");
                        }
                    }
                });
            }
        });
        this.f3833b.m19017a();
        this.f3832a = this.f3833b.f2161f;
    }

    /* renamed from: a */
    private void m17363a(String str, String str2) {
        this.f3833b.m19008a(str);
    }

    /* renamed from: b */
    private void m17362b() {
        this.f3835d = null;
    }

    public void destroy() {
        if (this.f3833b != null) {
            this.f3833b.m18993e();
        }
        m17362b();
        if (this.f3836e != null) {
            this.f3836e.removeCallbacksAndMessages(null);
        }
        this.f3836e = null;
        if (this.f3837f != null) {
            this.f3837f.removeCallbacksAndMessages(null);
        }
        this.f3837f = null;
    }

    public void downloadByCityCode(String str) {
        this.f3833b.m18990e(str);
    }

    public void downloadByCityName(String str) {
        this.f3833b.m18994d(str);
    }

    public void downloadByProvinceName(String str) {
        try {
            m17366a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            Iterator<OfflineMapCity> it2 = itemByProvinceName.getCityList().iterator();
            while (it2.hasNext()) {
                final String city = it2.next().getCity();
                this.f3837f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            OfflineMapManager.this.f3833b.m18994d(city);
                        } catch (AMapException e) {
                            C1007fo.m18012b(e, "OfflineMapManager", "downloadByProvinceName");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            if (th instanceof AMapException) {
                throw ((AMapException) th);
            }
            C1007fo.m18012b(th, "OfflineMapManager", "downloadByProvinceName");
        }
    }

    public ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.f3832a.m18865c();
    }

    public ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.f3832a.m18863d();
    }

    public ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.f3832a.m18862e();
    }

    public ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.f3832a.m18861f();
    }

    public OfflineMapCity getItemByCityCode(String str) {
        return this.f3832a.m18872a(str);
    }

    public OfflineMapCity getItemByCityName(String str) {
        return this.f3832a.m18866b(str);
    }

    public OfflineMapProvince getItemByProvinceName(String str) {
        return this.f3832a.m18864c(str);
    }

    public ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.f3832a.m18870b();
    }

    public ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.f3832a.m18882a();
    }

    public void pause() {
        this.f3833b.m18997d();
    }

    public void remove(String str) {
        if (this.f3833b.m19002b(str)) {
            this.f3833b.m18998c(str);
            return;
        }
        OfflineMapProvince m18864c = this.f3832a.m18864c(str);
        if (m18864c == null || m18864c.getCityList() == null) {
            if (this.f3835d == null) {
                return;
            }
            this.f3835d.onRemove(false, str, "没有该城市");
            return;
        }
        Iterator<OfflineMapCity> it2 = m18864c.getCityList().iterator();
        while (it2.hasNext()) {
            final String city = it2.next().getCity();
            this.f3837f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.3
                @Override // java.lang.Runnable
                public void run() {
                    OfflineMapManager.this.f3833b.m18998c(city);
                }
            });
        }
    }

    public void restart() {
    }

    public void stop() {
        this.f3833b.m19001c();
    }

    public void updateOfflineCityByCode(String str) {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        m17363a(itemByCityCode.getCity(), "cityname");
    }

    public void updateOfflineCityByName(String str) {
        m17363a(str, "cityname");
    }

    public void updateOfflineMapProvinceByName(String str) {
        m17363a(str, "cityname");
    }
}
