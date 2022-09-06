package com.fimi.soul.module.customerfeedback;

import android.net.Uri;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class PictureDetailAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a */
    private LinkedList<Object> f11525a;

    /* renamed from: b */
    private MyViewPager f11526b;

    /* renamed from: c */
    private HashMap<Integer, DetailPictureFragment> f11527c = new HashMap<>();

    public PictureDetailAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public PictureDetailAdapter(FragmentManager fragmentManager, LinkedList<Object> linkedList, MyViewPager myViewPager) {
        super(fragmentManager);
        this.f11525a = linkedList;
        this.f11526b = myViewPager;
    }

    /* renamed from: a */
    public DetailPictureFragment m9705a(int i) {
        return this.f11527c.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m9704a(LinkedList<Object> linkedList) {
        this.f11525a = linkedList;
        Log.e("good", linkedList.toString());
        notifyDataSetChanged();
    }

    @Override // android.support.p001v4.view.PagerAdapter
    public int getCount() {
        if (this.f11525a == null) {
            return 0;
        }
        return this.f11525a.size() - 1;
    }

    @Override // android.support.p001v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (i < this.f11525a.size() - 1) {
            Object obj = this.f11525a.get(i);
            if (obj instanceof Uri) {
                this.f11527c.put(Integer.valueOf(i), DetailPictureFragment.m9722a((Uri) obj));
            }
        }
        return this.f11527c.get(Integer.valueOf(i));
    }

    @Override // android.support.p001v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        if (obj == null || ((DetailPictureFragment) obj).m9724a() != this.f11526b.getCurrentItem()) {
            return super.getItemPosition(obj);
        }
        return -2;
    }
}
