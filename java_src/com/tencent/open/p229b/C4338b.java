package com.tencent.open.p229b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
/* renamed from: com.tencent.open.b.b */
/* loaded from: classes2.dex */
public class C4338b implements Serializable {

    /* renamed from: a */
    public final HashMap<String, String> f18130a = new HashMap<>();

    public C4338b(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f18130a.put(str, bundle.getString(str));
            }
        }
    }
}
