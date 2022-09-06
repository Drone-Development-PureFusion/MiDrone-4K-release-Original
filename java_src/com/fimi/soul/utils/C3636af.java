package com.fimi.soul.utils;

import android.content.Intent;
/* renamed from: com.fimi.soul.utils.af */
/* loaded from: classes.dex */
public class C3636af {
    /* renamed from: a */
    public static Intent m7712a() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        return intent;
    }

    /* renamed from: a */
    public static Intent m7711a(String str) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(str);
        intent.addCategory("android.intent.category.OPENABLE");
        return intent;
    }
}
