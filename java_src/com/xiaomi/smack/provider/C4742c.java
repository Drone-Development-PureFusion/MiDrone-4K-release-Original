package com.xiaomi.smack.provider;

import com.xiaomi.smack.packet.AbstractC4733e;
import com.xiaomi.smack.packet.C4729b;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* renamed from: com.xiaomi.smack.provider.c */
/* loaded from: classes2.dex */
public class C4742c {

    /* renamed from: a */
    private static C4742c f19503a;

    /* renamed from: b */
    private Map<String, Object> f19504b = new ConcurrentHashMap();

    /* renamed from: c */
    private Map<String, Object> f19505c = new ConcurrentHashMap();

    private C4742c() {
        m3853b();
    }

    /* renamed from: a */
    public static synchronized C4742c m3856a() {
        C4742c c4742c;
        synchronized (C4742c.class) {
            if (f19503a == null) {
                f19503a = new C4742c();
            }
            c4742c = f19503a;
        }
        return c4742c;
    }

    /* renamed from: b */
    private String m3852b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(str).append("/>");
        if (str != null) {
            sb.append("<").append(str2).append("/>");
        }
        return sb.toString();
    }

    /* renamed from: c */
    private ClassLoader[] m3851c() {
        ClassLoader[] classLoaderArr = {C4742c.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (ClassLoader classLoader : classLoaderArr) {
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    /* renamed from: a */
    public Object m3855a(String str, String str2) {
        return this.f19504b.get(m3852b(str, str2));
    }

    /* renamed from: a */
    public void m3854a(String str, String str2, Object obj) {
        if ((obj instanceof AbstractC4741b) || (obj instanceof Class)) {
            this.f19504b.put(m3852b(str, str2), obj);
            return;
        }
        throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
    }

    /* renamed from: b */
    protected void m3853b() {
        try {
            for (ClassLoader classLoader : m3851c()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    InputStream openStream = resources.nextElement().openStream();
                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                    newPullParser.setInput(openStream, "UTF-8");
                    int eventType = newPullParser.getEventType();
                    do {
                        if (eventType == 2) {
                            if (newPullParser.getName().equals("iqProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText2 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText3 = newPullParser.nextText();
                                String m3852b = m3852b(nextText, nextText2);
                                if (!this.f19505c.containsKey(m3852b)) {
                                    try {
                                        Class<?> cls = Class.forName(nextText3);
                                        if (AbstractC4740a.class.isAssignableFrom(cls)) {
                                            this.f19505c.put(m3852b, cls.newInstance());
                                        } else if (C4729b.class.isAssignableFrom(cls)) {
                                            this.f19505c.put(m3852b, cls);
                                        }
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (newPullParser.getName().equals("extensionProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText4 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText5 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText6 = newPullParser.nextText();
                                String m3852b2 = m3852b(nextText4, nextText5);
                                if (!this.f19504b.containsKey(m3852b2)) {
                                    try {
                                        Class<?> cls2 = Class.forName(nextText6);
                                        if (AbstractC4741b.class.isAssignableFrom(cls2)) {
                                            this.f19504b.put(m3852b2, cls2.newInstance());
                                        } else if (AbstractC4733e.class.isAssignableFrom(cls2)) {
                                            this.f19504b.put(m3852b2, cls2);
                                        }
                                    } catch (ClassNotFoundException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        }
                        eventType = newPullParser.next();
                    } while (eventType != 1);
                    try {
                        openStream.close();
                    } catch (Exception e3) {
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
