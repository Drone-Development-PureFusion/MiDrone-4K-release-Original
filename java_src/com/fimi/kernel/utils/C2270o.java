package com.fimi.kernel.utils;

import android.util.SparseArray;
import android.view.View;
/* renamed from: com.fimi.kernel.utils.o */
/* loaded from: classes.dex */
public class C2270o {
    /* renamed from: a */
    public static <T extends View> T m12874a(View view, int i) {
        SparseArray sparseArray;
        SparseArray sparseArray2 = (SparseArray) view.getTag();
        if (sparseArray2 == null) {
            SparseArray sparseArray3 = new SparseArray();
            view.setTag(sparseArray3);
            sparseArray = sparseArray3;
        } else {
            sparseArray = sparseArray2;
        }
        T t = (T) sparseArray.get(i);
        if (t == null) {
            T t2 = (T) view.findViewById(i);
            sparseArray.put(i, t2);
            return t2;
        }
        return t;
    }
}
