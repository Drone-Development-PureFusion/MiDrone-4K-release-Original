package com.fimi.soul.module.login;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/* renamed from: com.fimi.soul.module.login.d */
/* loaded from: classes.dex */
public class C3386d {

    /* renamed from: a */
    private static Typeface f13202a = null;

    /* renamed from: b */
    private static Typeface f13203b = null;

    /* renamed from: a */
    public static Typeface m8542a(AssetManager assetManager) {
        if (f13202a == null) {
            f13202a = Typeface.createFromAsset(assetManager, "lanting.TTF");
        }
        return f13202a;
    }

    /* renamed from: a */
    public static void m8541a(AssetManager assetManager, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getClass().equals(TextView.class)) {
                    m8538b(assetManager, childAt);
                }
                m8541a(assetManager, childAt);
            }
        }
    }

    /* renamed from: a */
    public static void m8540a(AssetManager assetManager, View... viewArr) {
        if (f13203b == null) {
            f13203b = Typeface.createFromAsset(assetManager, "DIN_Alternate_Bold.TTF");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < viewArr.length) {
                View view = viewArr[i2];
                if (view instanceof Button) {
                    ((Button) view).setTypeface(f13203b);
                } else if (view instanceof TextView) {
                    ((TextView) view).setTypeface(f13203b);
                } else if (view instanceof EditText) {
                    ((EditText) view).setTypeface(f13203b);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public static Typeface m8539b(AssetManager assetManager) {
        if (f13203b == null) {
            f13203b = Typeface.createFromAsset(assetManager, "DIN_Alternate_Bold.TTF");
        }
        return f13203b;
    }

    /* renamed from: b */
    public static void m8538b(AssetManager assetManager, View... viewArr) {
        if (f13202a == null) {
            f13202a = Typeface.createFromAsset(assetManager, "lanting.TTF");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < viewArr.length) {
                View view = viewArr[i2];
                if (view instanceof Button) {
                    ((Button) view).setTypeface(f13202a);
                } else if (view instanceof TextView) {
                    ((TextView) view).setTypeface(f13202a);
                } else if (view instanceof EditText) {
                    ((EditText) view).setTypeface(f13202a);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    public static void m8537c(AssetManager assetManager, View... viewArr) {
        if (f13202a == null) {
            f13202a = Typeface.createFromAsset(assetManager, "MILanTing_Bold.ttf");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < viewArr.length) {
                View view = viewArr[i2];
                if (view instanceof Button) {
                    ((Button) view).setTypeface(f13202a);
                } else if (view instanceof TextView) {
                    ((TextView) view).setTypeface(f13202a);
                } else if (view instanceof EditText) {
                    ((EditText) view).setTypeface(f13202a);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
