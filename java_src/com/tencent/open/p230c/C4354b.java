package com.tencent.open.p230c;

import android.content.Context;
import android.webkit.WebView;
import java.lang.reflect.Method;
/* renamed from: com.tencent.open.c.b */
/* loaded from: classes2.dex */
public class C4354b extends WebView {
    public C4354b(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            Method method = getSettings().getClass().getMethod("removeJavascriptInterface", String.class);
            if (method == null) {
                return;
            }
            method.invoke(this, "searchBoxJavaBridge_");
        } catch (Exception e) {
        }
    }
}
