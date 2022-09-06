package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import android.util.Xml;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
/* renamed from: cn.sharesdk.framework.utils.f */
/* loaded from: classes.dex */
public class C0688f {

    /* renamed from: cn.sharesdk.framework.utils.f$a */
    /* loaded from: classes.dex */
    private static class C0689a extends DefaultHandler {

        /* renamed from: a */
        private HashMap<String, Object> f1627a = new HashMap<>();

        /* renamed from: b */
        private HashMap<String, Object> f1628b;

        /* renamed from: a */
        public HashMap<String, Object> m19503a() {
            return this.f1627a;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            String trim = String.valueOf(cArr, i, i2).trim();
            if (!TextUtils.isEmpty(trim) && this.f1628b != null) {
                this.f1628b.put("value", trim);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            this.f1628b = null;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (this.f1628b != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                this.f1628b.put(str2, hashMap);
                this.f1628b = hashMap;
            } else {
                this.f1628b = new HashMap<>();
                this.f1627a.put(str2, this.f1628b);
            }
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                this.f1628b.put(attributes.getLocalName(i), attributes.getValue(i));
            }
        }
    }

    /* renamed from: a */
    public HashMap<String, Object> m19504a(String str) {
        C0689a c0689a = new C0689a();
        Xml.parse(str, c0689a);
        return c0689a.m19503a();
    }
}
