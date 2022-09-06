package com.fimi.soul.view.sliding;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FmFragmentPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a */
    private ArrayList<Fragment> f16432a;

    public FmFragmentPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
        super(fragmentManager);
        this.f16432a = null;
        this.f16432a = arrayList;
    }

    @Override // android.support.p001v4.view.PagerAdapter
    public int getCount() {
        return this.f16432a.size();
    }

    @Override // android.support.v13.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return i < this.f16432a.size() ? this.f16432a.get(i) : this.f16432a.get(0);
    }
}
