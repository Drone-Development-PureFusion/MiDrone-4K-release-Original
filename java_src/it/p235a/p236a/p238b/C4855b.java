package it.p235a.p236a.p238b;

import it.p235a.p236a.AbstractC4878t;
import java.util.ArrayList;
/* renamed from: it.a.a.b.b */
/* loaded from: classes.dex */
public class C4855b implements AbstractC4878t {

    /* renamed from: a */
    private ArrayList f20767a = new ArrayList();

    public C4855b() {
    }

    public C4855b(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof String) {
                m3027b((String) obj);
            }
        }
    }

    public C4855b(String[] strArr) {
        for (String str : strArr) {
            m3027b(str);
        }
    }

    @Override // it.p235a.p236a.AbstractC4878t
    /* renamed from: a */
    public boolean mo2979a(String str) {
        boolean contains;
        synchronized (this.f20767a) {
            contains = this.f20767a.contains(str);
        }
        return contains;
    }

    /* renamed from: b */
    public void m3027b(String str) {
        synchronized (this.f20767a) {
            this.f20767a.add(str.toLowerCase());
        }
    }

    /* renamed from: b */
    public String[] m3028b() {
        String[] strArr;
        synchronized (this.f20767a) {
            int size = this.f20767a.size();
            strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = (String) this.f20767a.get(i);
            }
        }
        return strArr;
    }

    /* renamed from: c */
    public void m3026c(String str) {
        synchronized (this.f20767a) {
            this.f20767a.remove(str.toLowerCase());
        }
    }
}
