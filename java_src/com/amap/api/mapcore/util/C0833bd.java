package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
/* renamed from: com.amap.api.mapcore.util.bd */
/* loaded from: classes.dex */
public class C0833bd {

    /* renamed from: a */
    private Context f2334a;

    public C0833bd(Context context) {
        this.f2334a = context;
    }

    /* renamed from: a */
    private boolean m18852a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String m18357a = C0945eh.m18357a(context);
        try {
            File file = new File(m18357a + "vmap/" + str);
            if (file.exists() && !C0856bu.m18749b(file)) {
                C0856bu.m18754a("deleteDownload delete some thing wrong!");
                return false;
            }
            try {
                C0856bu.m18748b(m18357a + "vmap/");
                C0856bu.m18747b(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private boolean m18851b(C0790aw c0790aw) {
        if (c0790aw != null) {
            boolean m18852a = m18852a(c0790aw.getPinyin(), this.f2334a);
            if (m18852a) {
                c0790aw.m19029i();
                return m18852a;
            }
            c0790aw.m19030h();
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public void m18853a(C0790aw c0790aw) {
        m18851b(c0790aw);
    }
}
