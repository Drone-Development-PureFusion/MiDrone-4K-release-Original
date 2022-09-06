package com.fimi.soul.media.gallery;

import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.app.FragmentStatePagerAdapter;
import android.support.p001v4.view.ViewPager;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.view.HackyViewPager;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ImagePagerActivity extends BaseActivity {

    /* renamed from: a */
    public static final String f11264a = "image_index";

    /* renamed from: b */
    public static final String f11265b = "image_urls";

    /* renamed from: c */
    public static final String f11266c = "image_native";

    /* renamed from: d */
    private static final String f11267d = "STATE_POSITION";

    /* renamed from: e */
    private HackyViewPager f11268e;

    /* renamed from: f */
    private int f11269f;

    /* renamed from: g */
    private TextView f11270g;

    /* renamed from: com.fimi.soul.media.gallery.ImagePagerActivity$a */
    /* loaded from: classes.dex */
    private class C2977a extends FragmentStatePagerAdapter {

        /* renamed from: a */
        public ArrayList<String> f11272a;

        /* renamed from: b */
        public boolean f11273b;

        public C2977a(FragmentManager fragmentManager, ArrayList<String> arrayList, boolean z) {
            super(fragmentManager);
            this.f11272a = arrayList;
            this.f11273b = z;
        }

        @Override // android.support.p001v4.view.PagerAdapter
        public int getCount() {
            if (this.f11272a == null) {
                return 0;
            }
            return this.f11272a.size();
        }

        @Override // android.support.p001v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return ImageDetailFragment.m9941a(this.f11272a.get(i), this.f11273b);
        }
    }

    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.image_detail_pager);
        this.f11269f = getIntent().getIntExtra("image_index", 0);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("image_urls");
        boolean booleanExtra = getIntent().getBooleanExtra(f11266c, false);
        this.f11268e = (HackyViewPager) findViewById(C2300R.C2302id.pager);
        this.f11268e.setAdapter(new C2977a(getSupportFragmentManager(), stringArrayListExtra, booleanExtra));
        this.f11270g = (TextView) findViewById(C2300R.C2302id.indicator);
        if (this.f11268e.getAdapter().getCount() == 1) {
            this.f11270g.setVisibility(4);
        }
        this.f11270g.setText(getString(C2300R.C2303string.viewpager_indicator, new Object[]{1, Integer.valueOf(this.f11268e.getAdapter().getCount())}));
        this.f11268e.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fimi.soul.media.gallery.ImagePagerActivity.1
            @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                ImagePagerActivity.this.f11270g.setText(ImagePagerActivity.this.getString(C2300R.C2303string.viewpager_indicator, new Object[]{Integer.valueOf(i + 1), Integer.valueOf(ImagePagerActivity.this.f11268e.getAdapter().getCount())}));
            }
        });
        if (bundle != null) {
            this.f11269f = bundle.getInt(f11267d);
        }
        this.f11268e.setCurrentItem(this.f11269f);
    }

    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(f11267d, this.f11268e.getCurrentItem());
    }
}
