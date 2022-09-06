package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.p228a.C4331f;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* renamed from: com.tencent.open.a */
/* loaded from: classes2.dex */
public class C4315a {

    /* renamed from: b */
    private static final String f18062b = C4331f.f18119d + ".JsBridge";

    /* renamed from: a */
    protected HashMap<String, C4317b> f18063a = new HashMap<>();

    /* renamed from: com.tencent.open.a$a */
    /* loaded from: classes2.dex */
    public static class C4316a {

        /* renamed from: a */
        protected WeakReference<WebView> f18064a;

        /* renamed from: b */
        protected long f18065b;

        /* renamed from: c */
        protected String f18066c;

        public C4316a(WebView webView, long j, String str) {
            this.f18064a = new WeakReference<>(webView);
            this.f18065b = j;
            this.f18066c = str;
        }

        /* renamed from: a */
        public void mo5341a() {
            WebView webView = this.f18064a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f18065b + ",{'r':1,'result':'no such method'})");
        }

        /* renamed from: a */
        public void mo5340a(Object obj) {
            WebView webView = this.f18064a.get();
            if (webView == null) {
                return;
            }
            String str = "'undefined'";
            if (obj instanceof String) {
                str = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
            } else if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                str = obj.toString();
            } else if (obj instanceof Boolean) {
                str = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f18065b + ",{'r':0,'result':" + str + "});");
        }

        /* renamed from: a */
        public void mo5339a(String str) {
            WebView webView = this.f18064a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    /* renamed from: com.tencent.open.a$b */
    /* loaded from: classes2.dex */
    public static class C4317b {
        public void call(String str, List<String> list, C4316a c4316a) {
            Object invoke;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            Method method = null;
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method2 = declaredMethods[i];
                if (method2.getName().equals(str) && method2.getParameterTypes().length == list.size()) {
                    method = method2;
                    break;
                }
                try {
                    i++;
                } catch (Exception e) {
                    C4331f.m5444b(C4315a.f18062b, "-->handler call mehtod ex. targetMethod: " + ((Object) null), e);
                    if (c4316a == null) {
                        return;
                    }
                    c4316a.mo5341a();
                    return;
                }
            }
            if (method == null) {
                if (c4316a == null) {
                    return;
                }
                c4316a.mo5341a();
                return;
            }
            switch (list.size()) {
                case 0:
                    invoke = method.invoke(this, new Object[0]);
                    break;
                case 1:
                    invoke = method.invoke(this, list.get(0));
                    break;
                case 2:
                    invoke = method.invoke(this, list.get(0), list.get(1));
                    break;
                case 3:
                    invoke = method.invoke(this, list.get(0), list.get(1), list.get(2));
                    break;
                case 4:
                    invoke = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3));
                    break;
                case 5:
                    invoke = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
                    break;
                default:
                    invoke = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
                    break;
            }
            Class<?> returnType = method.getReturnType();
            C4331f.m5445b(C4315a.f18062b, "-->call, result: " + invoke + " | ReturnType: " + returnType.getName());
            if ("void".equals(returnType.getName()) || returnType == Void.class) {
                if (c4316a == null) {
                    return;
                }
                c4316a.mo5340a((Object) null);
            } else if (c4316a == null || !customCallback()) {
            } else {
                c4316a.mo5339a(invoke != null ? invoke.toString() : null);
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    /* renamed from: a */
    public void m5498a(C4317b c4317b, String str) {
        this.f18063a.put(str, c4317b);
    }

    /* renamed from: a */
    public void mo5342a(String str, String str2, List<String> list, C4316a c4316a) {
        C4331f.m5445b(f18062b, "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        C4317b c4317b = this.f18063a.get(str);
        if (c4317b != null) {
            C4331f.m5445b(f18062b, "call----");
            c4317b.call(str2, list, c4316a);
            return;
        }
        C4331f.m5445b(f18062b, "not call----objName NOT FIND");
        if (c4316a == null) {
            return;
        }
        c4316a.mo5341a();
    }

    /* renamed from: a */
    public boolean mo5343a(WebView webView, String str) {
        C4331f.m5445b(f18062b, "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() < 6) {
                return false;
            }
            List<String> subList = arrayList.subList(4, arrayList.size() - 1);
            C4316a c4316a = new C4316a(webView, 4L, str);
            webView.getUrl();
            mo5342a((String) arrayList.get(2), (String) arrayList.get(3), subList, c4316a);
            return true;
        }
        return false;
    }
}
