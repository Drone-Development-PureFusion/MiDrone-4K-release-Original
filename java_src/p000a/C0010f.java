package p000a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.Map;
/* renamed from: a.f */
/* loaded from: classes.dex */
public final class C0010f {

    /* renamed from: a */
    static final String f31a = "al_applink_data";

    /* renamed from: b */
    static final String f32b = "extras";

    /* renamed from: c */
    static final String f33c = "target_url";

    /* renamed from: a */
    public static Uri m21636a(Context context, Intent intent) {
        String string;
        Bundle m21635a = m21635a(intent);
        if (m21635a == null || (string = m21635a.getString(f33c)) == null) {
            return null;
        }
        C0017k.m21624a(context, C0017k.f45e, intent, (Map<String, String>) null);
        return Uri.parse(string);
    }

    /* renamed from: a */
    public static Bundle m21635a(Intent intent) {
        return intent.getBundleExtra(f31a);
    }

    /* renamed from: b */
    public static Bundle m21634b(Intent intent) {
        Bundle m21635a = m21635a(intent);
        if (m21635a == null) {
            return null;
        }
        return m21635a.getBundle(f32b);
    }

    /* renamed from: c */
    public static Uri m21633c(Intent intent) {
        String string;
        Bundle m21635a = m21635a(intent);
        return (m21635a == null || (string = m21635a.getString(f33c)) == null) ? intent.getData() : Uri.parse(string);
    }
}
