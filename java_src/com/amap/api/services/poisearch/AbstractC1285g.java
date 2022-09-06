package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.services.core.AbstractC1254r;
/* renamed from: com.amap.api.services.poisearch.g */
/* loaded from: classes.dex */
abstract class AbstractC1285g<T, V> extends AbstractC1254r<T, V> {
    public AbstractC1285g(Context context, T t) {
        super(context, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m16821a(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }
}
