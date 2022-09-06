package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.bb */
/* loaded from: classes.dex */
public class C0831bb {

    /* renamed from: a */
    public ArrayList<OfflineMapProvince> f2323a = new ArrayList<>();

    /* renamed from: b */
    private C0842bm f2324b;

    /* renamed from: c */
    private Context f2325c;

    /* renamed from: d */
    private Handler f2326d;

    public C0831bb(Context context, Handler handler) {
        this.f2325c = context;
        this.f2326d = handler;
        this.f2324b = C0842bm.m18820a(context);
    }

    /* renamed from: a */
    private void m18878a(C0790aw c0790aw, OfflineMapCity offlineMapCity) {
        int m18723b = c0790aw.m19035c().m18723b();
        if (c0790aw.m19035c().equals(c0790aw.f2134a)) {
            m18867b(c0790aw.m19020x());
        } else {
            if (c0790aw.m19035c().equals(c0790aw.f2139f)) {
                C0856bu.m18754a("saveJSONObjectToFile  CITY " + c0790aw.getCity());
                m18868b(c0790aw);
                c0790aw.m19020x().m18835c();
            }
            if (m18880a(c0790aw.getcompleteCode(), c0790aw.m19035c().m18723b())) {
                m18876a(c0790aw.m19020x());
            }
        }
        offlineMapCity.setState(m18723b);
        offlineMapCity.setCompleteCode(c0790aw.getcompleteCode());
    }

    /* renamed from: a */
    private void m18877a(C0790aw c0790aw, OfflineMapProvince offlineMapProvince) {
        C0837bh c0837bh;
        int m18723b = c0790aw.m19035c().m18723b();
        if (m18723b == 6) {
            offlineMapProvince.setState(m18723b);
            offlineMapProvince.setCompleteCode(0);
            m18867b(new C0837bh(offlineMapProvince, this.f2325c));
            try {
                C0856bu.m18747b(offlineMapProvince.getProvinceCode(), this.f2325c);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (!m18869b(m18723b) || !m18874a(offlineMapProvince)) {
        } else {
            if (c0790aw.getPinyin().equals(offlineMapProvince.getPinyin())) {
                offlineMapProvince.setState(m18723b);
                offlineMapProvince.setCompleteCode(c0790aw.getcompleteCode());
                offlineMapProvince.setVersion(c0790aw.getVersion());
                offlineMapProvince.setUrl(c0790aw.getUrl());
                c0837bh = new C0837bh(offlineMapProvince, this.f2325c);
                c0837bh.m18839a(c0790aw.m19043a());
                c0837bh.d(c0790aw.getCode());
            } else {
                offlineMapProvince.setState(m18723b);
                offlineMapProvince.setCompleteCode(100);
                c0837bh = new C0837bh(offlineMapProvince, this.f2325c);
            }
            c0837bh.m18835c();
            m18876a(c0837bh);
            C0856bu.m18754a("saveJSONObjectToFile  province " + c0837bh.d());
        }
    }

    /* renamed from: a */
    private void m18876a(C0837bh c0837bh) {
        if (this.f2324b == null || c0837bh == null) {
            return;
        }
        this.f2324b.m18819a(c0837bh);
    }

    /* renamed from: a */
    private void m18875a(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
        offlineMapCity.setSize(offlineMapCity2.getSize());
        offlineMapCity.setCode(offlineMapCity2.getCode());
        offlineMapCity.setPinyin(offlineMapCity2.getPinyin());
        offlineMapCity.setJianpin(offlineMapCity2.getJianpin());
    }

    /* renamed from: a */
    private void m18873a(OfflineMapProvince offlineMapProvince, OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
        offlineMapProvince.setSize(offlineMapProvince2.getSize());
        offlineMapProvince.setPinyin(offlineMapProvince2.getPinyin());
        offlineMapProvince.setJianpin(offlineMapProvince2.getJianpin());
    }

    /* renamed from: a */
    private boolean m18880a(int i, int i2) {
        return i2 != 1 || i <= 2 || i >= 98;
    }

    /* renamed from: a */
    private boolean m18874a(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator<OfflineMapCity> it2 = offlineMapProvince.getCityList().iterator();
        while (it2.hasNext()) {
            if (it2.next().getState() != 4) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m18868b(C0790aw c0790aw) {
        File[] listFiles = new File(C0945eh.m18318b(this.f2325c)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isFile() && file.exists() && file.getName().contains(c0790aw.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                file.delete();
            }
        }
    }

    /* renamed from: b */
    private void m18867b(C0837bh c0837bh) {
        if (this.f2324b != null) {
            this.f2324b.m18811b(c0837bh);
        }
    }

    /* renamed from: b */
    private boolean m18869b(int i) {
        return i == 4;
    }

    /* renamed from: a */
    public OfflineMapCity m18872a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Iterator<OfflineMapProvince> it2 = this.f2323a.iterator();
        while (it2.hasNext()) {
            Iterator<OfflineMapCity> it3 = it2.next().getCityList().iterator();
            while (it3.hasNext()) {
                OfflineMapCity next = it3.next();
                if (next.getCode().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public ArrayList<OfflineMapProvince> m18882a() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        Iterator<OfflineMapProvince> it2 = this.f2323a.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m18879a(C0790aw c0790aw) {
        String pinyin = c0790aw.getPinyin();
        synchronized (this.f2323a) {
            Iterator<OfflineMapProvince> it2 = this.f2323a.iterator();
            loop0: while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                OfflineMapProvince next = it2.next();
                for (OfflineMapCity offlineMapCity : next.getCityList()) {
                    if (offlineMapCity.getPinyin().trim().equals(pinyin.trim())) {
                        m18878a(c0790aw, offlineMapCity);
                        m18877a(c0790aw, next);
                        break loop0;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m18871a(List<OfflineMapProvince> list) {
        OfflineMapProvince offlineMapProvince;
        OfflineMapCity offlineMapCity;
        if (this.f2323a.size() <= 0) {
            for (OfflineMapProvince offlineMapProvince2 : list) {
                this.f2323a.add(offlineMapProvince2);
            }
            return;
        }
        for (int i = 0; i < this.f2323a.size(); i++) {
            OfflineMapProvince offlineMapProvince3 = this.f2323a.get(i);
            Iterator<OfflineMapProvince> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    offlineMapProvince = null;
                    break;
                }
                offlineMapProvince = it2.next();
                if (offlineMapProvince3.getProvinceCode().equals(offlineMapProvince.getProvinceCode())) {
                    break;
                }
            }
            if (offlineMapProvince != null) {
                m18873a(offlineMapProvince3, offlineMapProvince);
                ArrayList<OfflineMapCity> cityList = offlineMapProvince3.getCityList();
                ArrayList<OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                for (int i2 = 0; i2 < cityList.size(); i2++) {
                    OfflineMapCity offlineMapCity2 = cityList.get(i2);
                    Iterator<OfflineMapCity> it3 = cityList2.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            offlineMapCity = null;
                            break;
                        }
                        offlineMapCity = it3.next();
                        if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                            break;
                        }
                    }
                    if (offlineMapCity != null) {
                        m18875a(offlineMapCity2, offlineMapCity);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m18881a(int i) {
        return i == 0 || i == 2 || i == 3 || i == 1 || i == 102 || i == 101 || i == 103 || i == -1;
    }

    /* renamed from: b */
    public OfflineMapCity m18866b(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Iterator<OfflineMapProvince> it2 = this.f2323a.iterator();
        while (it2.hasNext()) {
            Iterator<OfflineMapCity> it3 = it2.next().getCityList().iterator();
            while (it3.hasNext()) {
                OfflineMapCity next = it3.next();
                if (next.getCity().trim().equalsIgnoreCase(str.trim())) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public ArrayList<OfflineMapCity> m18870b() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        Iterator<OfflineMapProvince> it2 = this.f2323a.iterator();
        while (it2.hasNext()) {
            Iterator<OfflineMapCity> it3 = it2.next().getCityList().iterator();
            while (it3.hasNext()) {
                arrayList.add(it3.next());
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public OfflineMapProvince m18864c(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Iterator<OfflineMapProvince> it2 = this.f2323a.iterator();
        while (it2.hasNext()) {
            OfflineMapProvince next = it2.next();
            if (next.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: c */
    public ArrayList<OfflineMapCity> m18865c() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f2323a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it2 = this.f2323a.iterator();
            while (it2.hasNext()) {
                for (OfflineMapCity offlineMapCity : it2.next().getCityList()) {
                    if (offlineMapCity.getState() == 4 || offlineMapCity.getState() == 7) {
                        arrayList.add(offlineMapCity);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public ArrayList<OfflineMapProvince> m18863d() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f2323a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it2 = this.f2323a.iterator();
            while (it2.hasNext()) {
                OfflineMapProvince next = it2.next();
                if (next.getState() == 4 || next.getState() == 7) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public ArrayList<OfflineMapCity> m18862e() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f2323a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it2 = this.f2323a.iterator();
            while (it2.hasNext()) {
                for (OfflineMapCity offlineMapCity : it2.next().getCityList()) {
                    if (m18881a(offlineMapCity.getState())) {
                        arrayList.add(offlineMapCity);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public ArrayList<OfflineMapProvince> m18861f() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f2323a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it2 = this.f2323a.iterator();
            while (it2.hasNext()) {
                OfflineMapProvince next = it2.next();
                if (m18881a(next.getState())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    public void m18860g() {
        m18859h();
        this.f2326d = null;
        this.f2324b = null;
        this.f2325c = null;
    }

    /* renamed from: h */
    public void m18859h() {
        this.f2323a.clear();
    }

    /* renamed from: i */
    public int m18858i() {
        if (this.f2323a != null) {
            return this.f2323a.size();
        }
        return 0;
    }
}
