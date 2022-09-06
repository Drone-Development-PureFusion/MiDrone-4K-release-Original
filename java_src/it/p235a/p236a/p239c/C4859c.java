package it.p235a.p236a.p239c;

import it.p235a.p236a.AbstractC4876r;
import it.p235a.p236a.C4872n;
import it.p235a.p236a.C4875q;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;
/* renamed from: it.a.a.c.c */
/* loaded from: classes.dex */
public class C4859c implements AbstractC4876r {

    /* renamed from: a */
    private static final DateFormat f20771a = new SimpleDateFormat("yyyyMMddhhmmss.SSS Z");

    /* renamed from: b */
    private static final DateFormat f20772b = new SimpleDateFormat("yyyyMMddhhmmss Z");

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0109 -> B:58:0x010a). Please submit an issue!!! */
    /* renamed from: a */
    private C4872n m3024a(String str) {
        int i;
        Date date;
        long j;
        long j2 = 0;
        Date date2 = null;
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreElements()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim.length() > 0) {
                arrayList.add(trim);
            }
        }
        if (arrayList.size() == 0) {
            throw new C4875q();
        }
        String str2 = (String) arrayList.remove(arrayList.size() - 1);
        Properties properties = new Properties();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str3 = (String) it2.next();
            int indexOf = str3.indexOf(61);
            if (indexOf == -1) {
                throw new C4875q();
            }
            String trim2 = str3.substring(0, indexOf).trim();
            String trim3 = str3.substring(indexOf + 1, str3.length()).trim();
            if (trim2.length() == 0 || trim3.length() == 0) {
                throw new C4875q();
            }
            properties.setProperty(trim2, trim3);
        }
        String property = properties.getProperty("type");
        if (property == null) {
            throw new C4875q();
        }
        if ("file".equalsIgnoreCase(property)) {
            i = 0;
        } else if (!"dir".equalsIgnoreCase(property)) {
            if ("cdir".equalsIgnoreCase(property) || "pdir".equalsIgnoreCase(property)) {
            }
            return null;
        } else {
            i = 1;
        }
        String property2 = properties.getProperty("modify");
        if (property2 != null) {
            String stringBuffer = new StringBuffer().append(property2).append(" +0000").toString();
            try {
                synchronized (f20771a) {
                    try {
                        date = f20771a.parse(stringBuffer);
                        try {
                        } catch (Throwable th) {
                            date2 = date;
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw th;
            } catch (ParseException e) {
                try {
                    try {
                        synchronized (f20772b) {
                            date = f20772b.parse(stringBuffer);
                            try {
                            } catch (Throwable th3) {
                                date2 = date;
                                th = th3;
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (ParseException e2) {
                    date = date2;
                }
            }
        } else {
            date = null;
        }
        String property3 = properties.getProperty("size");
        if (property3 != null) {
            try {
                j = Long.parseLong(property3);
            } catch (NumberFormatException e3) {
                j = 0;
            }
            if (j >= 0) {
                j2 = j;
            }
        }
        C4872n c4872n = new C4872n();
        c4872n.m2992a(i);
        c4872n.m2989a(date);
        c4872n.m2991a(j2);
        c4872n.m2990a(str2);
        return c4872n;
    }

    @Override // it.p235a.p236a.AbstractC4876r
    /* renamed from: a */
    public C4872n[] mo2983a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            C4872n m3024a = m3024a(str);
            if (m3024a != null) {
                arrayList.add(m3024a);
            }
        }
        int size = arrayList.size();
        C4872n[] c4872nArr = new C4872n[size];
        for (int i = 0; i < size; i++) {
            c4872nArr[i] = (C4872n) arrayList.get(i);
        }
        return c4872nArr;
    }
}
