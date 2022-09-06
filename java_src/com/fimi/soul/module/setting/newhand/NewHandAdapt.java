package com.fimi.soul.module.setting.newhand;

import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.app.FragmentStatePagerAdapter;
import android.support.p001v4.app.FragmentTransaction;
import android.support.p001v4.view.ViewPager;
import java.util.List;
/* loaded from: classes.dex */
public class NewHandAdapt extends FragmentStatePagerAdapter {

    /* renamed from: a */
    private List<Fragment> f14029a;

    /* renamed from: b */
    private Fragment f14030b;

    /* renamed from: c */
    private FragmentManager f14031c;

    /* renamed from: d */
    private FragmentTransaction f14032d;

    /* renamed from: e */
    private ViewPager f14033e;

    /* renamed from: f */
    private int f14034f;

    public NewHandAdapt(FragmentManager fragmentManager, List<Fragment> list, ViewPager viewPager) {
        super(fragmentManager);
        this.f14029a = list;
        this.f14033e = viewPager;
        this.f14031c = fragmentManager;
    }

    @Override // android.support.p001v4.view.PagerAdapter
    public int getCount() {
        return this.f14029a.size();
    }

    @Override // android.support.p001v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.f14029a.get(i);
    }
}
