package com.mining.app.zxing.p222b;

import android.content.Intent;
import android.net.Uri;
import com.google.zxing.BarcodeFormat;
import com.mining.app.zxing.p222b.C4118g;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
/* renamed from: com.mining.app.zxing.b.b */
/* loaded from: classes.dex */
final class C4111b {

    /* renamed from: e */
    private static final Pattern f17196e = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* renamed from: a */
    static final Vector<BarcodeFormat> f17192a = new Vector<>(5);

    /* renamed from: b */
    static final Vector<BarcodeFormat> f17193b = new Vector<>(1);

    /* renamed from: c */
    static final Vector<BarcodeFormat> f17194c = new Vector<>(1);

    /* renamed from: d */
    static final Vector<BarcodeFormat> f17195d = new Vector<>(1);

    static {
        f17192a.add(BarcodeFormat.UPC_A);
        f17192a.add(BarcodeFormat.UPC_E);
        f17192a.add(BarcodeFormat.EAN_13);
        f17192a.add(BarcodeFormat.EAN_8);
        f17192a.add(BarcodeFormat.RSS14);
        f17193b.add(BarcodeFormat.CODE_128);
        f17194c.add(BarcodeFormat.QR_CODE);
        f17195d.add(BarcodeFormat.DATA_MATRIX);
    }

    private C4111b() {
    }

    /* renamed from: a */
    static Vector<BarcodeFormat> m6155a(Intent intent) {
        List list = null;
        String stringExtra = intent.getStringExtra(C4118g.C4120b.f17216c);
        if (stringExtra != null) {
            list = Arrays.asList(f17196e.split(stringExtra));
        }
        return m6153a(list, intent.getStringExtra(C4118g.C4120b.f17215b));
    }

    /* renamed from: a */
    static Vector<BarcodeFormat> m6154a(Uri uri) {
        List<String> queryParameters = uri.getQueryParameters(C4118g.C4120b.f17216c);
        if (queryParameters != null && queryParameters.size() == 1 && queryParameters.get(0) != null) {
            queryParameters = Arrays.asList(f17196e.split(queryParameters.get(0)));
        }
        return m6153a(queryParameters, uri.getQueryParameter(C4118g.C4120b.f17215b));
    }

    /* renamed from: a */
    private static Vector<BarcodeFormat> m6153a(Iterable<String> iterable, String str) {
        if (iterable != null) {
            Vector<BarcodeFormat> vector = new Vector<>();
            try {
                for (String str2 : iterable) {
                    vector.add(BarcodeFormat.valueOf(str2));
                }
                return vector;
            } catch (IllegalArgumentException e) {
            }
        }
        if (str != null) {
            if (C4118g.C4120b.f17218e.equals(str)) {
                return f17192a;
            }
            if (C4118g.C4120b.f17220g.equals(str)) {
                return f17194c;
            }
            if (C4118g.C4120b.f17221h.equals(str)) {
                return f17195d;
            }
            if (C4118g.C4120b.f17219f.equals(str)) {
                return f17193b;
            }
        }
        return null;
    }
}
