package com.fimi.soul.module.setting.newhand;

import android.os.Bundle;
import android.support.p001v4.view.ViewPager;
import android.util.Log;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NewHandActivity extends BaseActivity {

    /* renamed from: a */
    private NewHandAdapt f14023a;

    /* renamed from: b */
    private ViewPager f14024b;

    /* renamed from: c */
    private int f14025c;

    /* renamed from: d */
    private int f14026d;

    /* renamed from: e */
    private int f14027e;

    /* renamed from: a */
    public ViewPager m8145a() {
        if (this.f14024b == null) {
            this.f14024b = (ViewPager) findViewById(C2300R.C2302id.view_pager);
        }
        return this.f14024b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.activity_new_hand);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NewHandStartPagerFragment());
        arrayList.add(new NewHandOneFragment());
        arrayList.add(new NewHandTwoFragment());
        arrayList.add(new NewHandThreeFragment());
        arrayList.add(new NewHandFourFragment());
        arrayList.add(new NewHandFiveFragment());
        arrayList.add(new NewHandSixFragment());
        arrayList.add(new NewHandSevenFragment());
        this.f14023a = new NewHandAdapt(getSupportFragmentManager(), arrayList, m8145a());
        m8145a().setAdapter(this.f14023a);
        m8145a().setCurrentItem(0);
        m8145a().setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fimi.soul.module.setting.newhand.NewHandActivity.1
            @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                Log.i("zhej", "pager:" + i);
            }

            @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.p001v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }
        });
    }
}
