package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.open.C4315a;
import com.tencent.open.p228a.C4331f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.tencent.open.web.security.b */
/* loaded from: classes2.dex */
public class C4366b extends C4315a {

    /* renamed from: b */
    private static final String f18239b = C4331f.f18119d + ".SecureJs";

    @Override // com.tencent.open.C4315a
    /* renamed from: a */
    public void mo5342a(String str, String str2, List<String> list, C4315a.C4316a c4316a) {
        C4331f.m5442c(f18239b, "-->getResult, objectName: " + str + " | methodName: " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        C4315a.C4317b c4317b = this.f18063a.get(str);
        if (c4317b != null) {
            C4331f.m5445b(f18239b, "-->handler != null");
            c4317b.call(str2, list, c4316a);
            return;
        }
        C4331f.m5445b(f18239b, "-->handler == null");
        if (c4316a == null) {
            return;
        }
        c4316a.mo5341a();
    }

    @Override // com.tencent.open.C4315a
    /* renamed from: a */
    public boolean mo5343a(WebView webView, String str) {
        C4331f.m5445b(f18239b, "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() < 7) {
                return false;
            }
            String str2 = (String) arrayList.get(2);
            String str3 = (String) arrayList.get(3);
            String str4 = (String) arrayList.get(4);
            String str5 = (String) arrayList.get(5);
            C4331f.m5442c(f18239b, "-->canHandleUrl, objectName: " + str2 + " | methodName: " + str3 + " | snStr: " + str4);
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return false;
            }
            try {
                mo5342a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new C4367c(webView, Long.parseLong(str4), str, str5));
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
