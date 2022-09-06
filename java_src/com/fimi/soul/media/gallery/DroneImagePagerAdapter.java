package com.fimi.soul.media.gallery;

import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.app.FragmentStatePagerAdapter;
import android.support.p001v4.view.ViewPager;
import com.fimi.soul.view.photodraweeview.AbstractC3867d;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
/* loaded from: classes.dex */
public class DroneImagePagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a */
    Map<Integer, DroneImageDetailFragment> f11206a = new Hashtable();

    /* renamed from: b */
    private ArrayList<String> f11207b;

    /* renamed from: c */
    private ArrayList<String> f11208c;

    /* renamed from: d */
    private DroneImageDetailFragment f11209d;

    /* renamed from: e */
    private AbstractC3867d f11210e;

    /* renamed from: f */
    private ViewPager f11211f;

    public DroneImagePagerAdapter(FragmentManager fragmentManager, ArrayList<String> arrayList) {
        super(fragmentManager);
        this.f11207b = arrayList;
    }

    public DroneImagePagerAdapter(FragmentManager fragmentManager, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        super(fragmentManager);
        this.f11207b = arrayList;
        this.f11208c = arrayList2;
    }

    /* renamed from: a */
    public DroneImageDetailFragment m9997a(int i) {
        return this.f11206a.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m9996a(ViewPager viewPager) {
        this.f11211f = viewPager;
    }

    /* renamed from: a */
    public void m9995a(AbstractC3867d abstractC3867d) {
        this.f11210e = abstractC3867d;
    }

    /* renamed from: a */
    public void m9994a(ArrayList<String> arrayList) {
        this.f11207b = arrayList;
    }

    @Override // android.support.p001v4.view.PagerAdapter
    public int getCount() {
        if (this.f11207b == null) {
            return 0;
        }
        return this.f11207b.size();
    }

    @Override // android.support.p001v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        this.f11209d = new DroneImageDetailFragment();
        this.f11209d.m10046b(this.f11207b.get(i));
        this.f11209d.m10052a(i);
        if (this.f11210e != null) {
            this.f11209d.m10050a(this.f11210e);
        }
        if (this.f11208c != null && this.f11208c.size() > 0) {
            this.f11209d.m10044c(this.f11208c.get(i));
        }
        this.f11206a.put(Integer.valueOf(i), this.f11209d);
        return this.f11209d;
    }

    @Override // android.support.p001v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        if (obj == null || ((DroneImageDetailFragment) obj).m10053a() != this.f11211f.getCurrentItem()) {
            return super.getItemPosition(obj);
        }
        return -2;
    }
}
