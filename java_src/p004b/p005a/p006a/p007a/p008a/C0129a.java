package p004b.p005a.p006a.p007a.p008a;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.LocatorImpl;
import org.xmlpull.v1.XmlPullParser;
import p004b.p005a.p006a.p028b.p035g.p037b.C0328d;
import p004b.p005a.p006a.p028b.p035g.p037b.C0329e;
import p004b.p005a.p006a.p028b.p035g.p039d.C0346m;
import p004b.p005a.p006a.p058c.p059a.p060a.p061a.p062a.resXmlResourceParserC0594a;
/* renamed from: b.a.a.a.a.a */
/* loaded from: classes.dex */
public class C0129a extends C0329e {

    /* renamed from: b */
    private int[] f124b = new int[2];

    /* renamed from: c */
    private C0130a f125c = new C0130a(new String[0]);

    /* renamed from: d */
    private String f126d = null;

    /* renamed from: e */
    private Map<String, String> f127e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.a.a.a.a.a$a */
    /* loaded from: classes.dex */
    public static class C0130a {

        /* renamed from: a */
        private final String[] f128a;

        /* renamed from: b */
        private int f129b = 0;

        public C0130a(String... strArr) {
            this.f128a = strArr == null ? new String[0] : strArr;
        }

        /* renamed from: a */
        public int m21534a() {
            return this.f128a.length;
        }

        /* renamed from: a */
        public boolean m21533a(String str) {
            if (this.f129b == this.f128a.length) {
                return true;
            }
            if (str.equals(this.f128a[this.f129b])) {
                this.f129b++;
            }
            return false;
        }

        /* renamed from: b */
        public int m21532b() {
            return this.f129b;
        }

        /* renamed from: b */
        public boolean m21531b(String str) {
            if (this.f129b <= 0 || !str.equals(this.f128a[this.f129b - 1])) {
                return this.f129b == this.f128a.length;
            }
            this.f129b--;
            return false;
        }

        /* renamed from: c */
        public void m21530c() {
            this.f129b = 0;
        }

        /* renamed from: d */
        public boolean m21529d() {
            return this.f129b == this.f128a.length;
        }
    }

    /* renamed from: a */
    private void m21540a(XmlPullParser xmlPullParser) {
        super.startDocument();
        super.setDocumentLocator(new LocatorImpl());
    }

    /* renamed from: b */
    private void m21538b(XmlPullParser xmlPullParser) {
        if (this.f125c.m21529d()) {
            super.characters(xmlPullParser.getTextCharacters(this.f124b), this.f124b[0], this.f124b[1]);
        }
    }

    /* renamed from: c */
    private void m21537c(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        if (this.f125c.m21531b(name)) {
            endElement(xmlPullParser.getNamespace(), name, name);
        }
    }

    /* renamed from: d */
    private void m21536d(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        if (this.f125c.m21533a(name)) {
            AttributesImpl attributesImpl = new AttributesImpl();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= xmlPullParser.getAttributeCount()) {
                    break;
                }
                attributesImpl.addAttribute(xmlPullParser.getAttributeNamespace(i2), xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeType(i2), xmlPullParser.getAttributeValue(i2));
                i = i2 + 1;
            }
            startElement(xmlPullParser.getNamespace(), name, name, attributesImpl);
        }
        m21535e(xmlPullParser);
    }

    /* renamed from: e */
    private void m21535e(XmlPullParser xmlPullParser) {
        String str;
        if (this.f126d == null || this.f127e != null || !xmlPullParser.getName().equals(this.f126d)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeNamespace = xmlPullParser.getAttributeNamespace(i);
            if (attributeNamespace.length() > 0) {
                int lastIndexOf = attributeNamespace.lastIndexOf("/");
                if (lastIndexOf > -1 && lastIndexOf + 1 < attributeNamespace.length()) {
                    attributeNamespace = attributeNamespace.substring(lastIndexOf + 1);
                }
                str = attributeNamespace + ":";
            } else {
                str = "";
            }
            hashMap.put(str + xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
        }
        this.f127e = hashMap;
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p037b.C0329e
    /* renamed from: a */
    public List<C0328d> mo20926a(InputSource inputSource) {
        InputStream byteStream = inputSource.getByteStream();
        if (byteStream == null) {
            throw new IllegalArgumentException("Input source must specify an input stream");
        }
        try {
            XmlPullParser resxmlresourceparserc0594a = new resXmlResourceParserC0594a(byteStream);
            this.f127e = null;
            while (true) {
                int next = resxmlresourceparserc0594a.next();
                if (next <= -1) {
                    break;
                } else if (next == 0) {
                    this.f125c.m21530c();
                    m21540a(resxmlresourceparserc0594a);
                } else if (1 == next) {
                    this.f125c.m21530c();
                    endDocument();
                    break;
                } else if (2 == next) {
                    m21536d(resxmlresourceparserc0594a);
                } else if (3 == next) {
                    m21537c(resxmlresourceparserc0594a);
                } else if (4 == next) {
                    m21538b(resxmlresourceparserc0594a);
                }
            }
            return d();
        } catch (Exception e) {
            a(e.getMessage(), e);
            throw new C0346m("Can't parse Android XML resource", e);
        }
    }

    /* renamed from: a */
    public Map<String, String> m21542a() {
        return this.f127e;
    }

    /* renamed from: a */
    public void m21541a(String str) {
        this.f126d = str;
    }

    /* renamed from: a */
    public void m21539a(String... strArr) {
        this.f125c = new C0130a(strArr);
    }
}
