package p004b.p005a.p006a.p028b.p035g.p036a;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p036a.C0303e;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p044i.p047c.C0447d;
import p004b.p005a.p006a.p028b.p057r.C0585s;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.s */
/* loaded from: classes.dex */
public class C0321s extends AbstractC0301c {

    /* renamed from: a */
    static final String f605a = "resource";

    /* renamed from: b */
    static String f606b = "In <property> element, either the \"file\" attribute alone, or the \"resource\" element alone, or both the \"name\" and \"value\" attributes must be set.";

    /* renamed from: a */
    public void m20947a(C0344k c0344k) {
    }

    /* renamed from: a */
    void m20946a(C0344k c0344k, InputStream inputStream, C0303e.EnumC0305a enumC0305a) {
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        C0303e.m20965a(c0344k, properties, enumC0305a);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        if ("substitutionProperty".equals(str)) {
            e("[substitutionProperty] element has been deprecated. Please use the [property] element instead.");
        }
        String value = attributes.getValue("name");
        String value2 = attributes.getValue("value");
        C0303e.EnumC0305a m20964a = C0303e.m20964a(attributes.getValue("scope"));
        if (m20945a(attributes)) {
            String m20870f = c0344k.m20870f(attributes.getValue("file"));
            try {
                m20946a(c0344k, new FileInputStream(m20870f), m20964a);
            } catch (FileNotFoundException e) {
                c("Could not find properties file [" + m20870f + "].");
            } catch (IOException e2) {
                a("Could not read properties file [" + m20870f + "].", e2);
            }
        } else if (!m20944b(attributes)) {
            if (m20943c(attributes)) {
                C0303e.m20966a(c0344k, value, c0344k.m20870f(C0447d.m20495b(value2).trim()), m20964a);
            } else {
                c(f606b);
            }
        } else {
            String m20870f2 = c0344k.m20870f(attributes.getValue(f605a));
            URL m20079a = C0585s.m20079a(m20870f2);
            if (m20079a == null) {
                c("Could not find resource [" + m20870f2 + "].");
                return;
            }
            try {
                m20946a(c0344k, m20079a.openStream(), m20964a);
            } catch (IOException e3) {
                a("Could not read resource file [" + m20870f2 + "].", e3);
            }
        }
    }

    /* renamed from: a */
    boolean m20945a(Attributes attributes) {
        return !C0589u.m20054e(attributes.getValue("file")) && C0589u.m20054e(attributes.getValue("name")) && C0589u.m20054e(attributes.getValue("value")) && C0589u.m20054e(attributes.getValue(f605a));
    }

    /* renamed from: b */
    boolean m20944b(Attributes attributes) {
        return !C0589u.m20054e(attributes.getValue(f605a)) && C0589u.m20054e(attributes.getValue("name")) && C0589u.m20054e(attributes.getValue("value")) && C0589u.m20054e(attributes.getValue("file"));
    }

    /* renamed from: c */
    boolean m20943c(Attributes attributes) {
        return !C0589u.m20054e(attributes.getValue("name")) && !C0589u.m20054e(attributes.getValue("value")) && C0589u.m20054e(attributes.getValue("file")) && C0589u.m20054e(attributes.getValue(f605a));
    }
}
