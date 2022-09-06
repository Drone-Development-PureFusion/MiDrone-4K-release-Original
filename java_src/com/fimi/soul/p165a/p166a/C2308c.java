package com.fimi.soul.p165a.p166a;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.WindowManager;
/* renamed from: com.fimi.soul.a.a.c */
/* loaded from: classes.dex */
public class C2308c {

    /* renamed from: a */
    public int f7703a;

    /* renamed from: b */
    private Activity f7704b;

    public C2308c(Activity activity) {
        this.f7704b = activity;
    }

    /* renamed from: c */
    private void m12614c() {
        this.f7704b.setRequestedOrientation(this.f7703a);
    }

    /* renamed from: d */
    private void m12613d() {
        int rotation = ((WindowManager) this.f7704b.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = this.f7704b.getResources().getConfiguration().orientation;
        if (!(((rotation == 0 || rotation == 2) && i == 2) || ((rotation == 1 || rotation == 3) && i == 1))) {
            switch (rotation) {
                case 0:
                    this.f7703a = 1;
                    break;
                case 1:
                    this.f7703a = 0;
                    break;
                case 2:
                    this.f7703a = 9;
                    break;
                case 3:
                    this.f7703a = 8;
                    break;
            }
        } else {
            switch (rotation) {
                case 0:
                    this.f7703a = 0;
                    break;
                case 1:
                    this.f7703a = 9;
                    break;
                case 2:
                    this.f7703a = 8;
                    break;
                case 3:
                    this.f7703a = 1;
                    break;
            }
        }
        m12614c();
    }

    /* renamed from: e */
    private boolean m12612e() {
        return PreferenceManager.getDefaultSharedPreferences(this.f7704b.getApplicationContext()).getBoolean("pref_lock_screen_orientation", false);
    }

    /* renamed from: a */
    public void m12616a() {
        if (m12612e()) {
            m12613d();
        }
    }

    /* renamed from: b */
    public void m12615b() {
        if (this.f7703a != -1) {
            this.f7703a = -1;
            m12614c();
        }
    }
}
