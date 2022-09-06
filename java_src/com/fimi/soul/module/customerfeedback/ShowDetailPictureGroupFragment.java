package com.fimi.soul.module.customerfeedback;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fimi.soul.C2300R;
import com.fimi.soul.view.photodraweeview.AbstractC3867d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ShowDetailPictureGroupFragment extends Fragment implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    private MyViewPager f11528a;

    /* renamed from: b */
    private AbstractC3867d f11529b;

    /* renamed from: c */
    private PictureDetailAdapter f11530c;

    /* renamed from: d */
    private LinkedList<Object> f11531d;

    /* renamed from: a */
    public void m9703a(int i) {
        this.f11528a.setCurrentItem(i);
    }

    /* renamed from: a */
    public void m9702a(AbstractC3867d abstractC3867d) {
        this.f11529b = abstractC3867d;
    }

    /* renamed from: a */
    public void m9701a(LinkedList<Object> linkedList) {
        this.f11531d = linkedList;
        if (this.f11530c != null) {
            this.f11530c.m9704a(this.f11531d);
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(C2300R.layout.showdetail_feedback_fragment, (ViewGroup) null);
        this.f11528a = (MyViewPager) inflate.findViewById(C2300R.C2302id.viewpager);
        this.f11528a.setOnPageChangeListener(this);
        this.f11530c = new PictureDetailAdapter(getFragmentManager(), this.f11531d, this.f11528a);
        this.f11528a.setAdapter(this.f11530c);
        return inflate;
    }

    @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        DetailPictureFragment m9705a;
        Uri uri;
        if (f != 0.0f || i2 != 0 || (m9705a = this.f11530c.m9705a(i)) == null || i >= this.f11531d.size()) {
            return;
        }
        Object obj = this.f11531d.get(i);
        if (!(obj instanceof Uri) || (uri = (Uri) obj) == null) {
            return;
        }
        if (uri.equals(m9705a.m9716c()) && m9705a.m9715d()) {
            return;
        }
        m9705a.m9718b(uri);
        m9705a.m9720a(this.f11529b);
        m9705a.m9719b();
    }

    @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }
}
