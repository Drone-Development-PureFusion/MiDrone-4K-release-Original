package com.p080b;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
/* renamed from: com.b.au */
/* loaded from: classes.dex */
public class C1439au {

    /* renamed from: a */
    private ArrayList<C1440a> f4990a = new ArrayList<>();

    /* renamed from: b */
    private ArrayList<C1442c> f4991b = new ArrayList<>();

    /* renamed from: c */
    private short[][] f4992c = (short[][]) Array.newInstance(Short.TYPE, 128, 128);

    /* renamed from: d */
    private C1441b f4993d = new C1441b();

    /* renamed from: com.b.au$a */
    /* loaded from: classes.dex */
    class C1440a implements Comparable<C1440a> {

        /* renamed from: b */
        private ArrayList<C1442c> f4995b = new ArrayList<>();

        /* renamed from: c */
        private ArrayList<C1442c> f4996c = new ArrayList<>();

        /* renamed from: d */
        private double f4997d;

        /* renamed from: e */
        private String f4998e;

        public C1440a() {
            this.f4997d = 0.0d;
            this.f4998e = "";
            this.f4997d = 0.0d;
            this.f4998e = "";
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C1440a c1440a) {
            double d = c1440a.f4997d - this.f4997d;
            if (d > 0.0d) {
                return 1;
            }
            return d == 0.0d ? 0 : -1;
        }

        /* renamed from: a */
        public void m16231a() {
            double size = this.f4996c.size();
            double d = 0.0d;
            Iterator<C1442c> it2 = this.f4995b.iterator();
            while (true) {
                double d2 = d;
                if (!it2.hasNext()) {
                    this.f4997d = (d2 * 3.0d) + size;
                    this.f4997d += ((d2 * 3.0d) + 0.1d) * (size + 0.1d);
                    return;
                }
                d = (it2.next().f5005e > 1 ? 0.6d : 1.0d) + d2;
            }
        }

        /* renamed from: a */
        public void m16228a(C1442c c1442c) {
            if (c1442c.f5005e == 0) {
                this.f4996c.add(c1442c);
            } else if (c1442c.f5005e > 0) {
                this.f4995b.add(c1442c);
            }
            if ("0".equals(this.f4998e)) {
                this.f4998e = c1442c.f5004d;
            }
        }

        /* renamed from: b */
        public C1442c m16227b() {
            double d = 0.0d;
            int i = this.f4995b.isEmpty() ? 0 : 3;
            if (this.f4996c.isEmpty()) {
                Iterator<C1442c> it2 = this.f4995b.iterator();
                if (!it2.hasNext()) {
                    return null;
                }
                C1442c next = it2.next();
                if (next.f5005e == 1) {
                    return new C1442c(next.f5001a, next.f5002b, next.f5003c, this.f4998e, this.f4997d, 1);
                }
                int i2 = 0 < next.f5003c ? next.f5003c : 0;
                double d2 = 0.0d + 1.0d;
                return new C1442c((0.0d + next.f5001a) / d2, (0.0d + next.f5002b) / d2, i2 > 5000 ? 5000 : i2, this.f4998e, this.f4997d, 2);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<C1442c> it3 = this.f4996c.iterator();
            double d3 = 0.0d;
            double d4 = 0.0d;
            while (it3.hasNext()) {
                C1442c next2 = it3.next();
                arrayList.add(Integer.valueOf(next2.f5003c));
                d3 += next2.f5001a;
                d4 = 1.0d + d4;
                d = next2.f5002b + d;
            }
            Collections.sort(arrayList);
            int intValue = arrayList.size() == 1 ? ((Integer) arrayList.get(0)).intValue() : ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
            return new C1442c(d3 / d4, d / d4, this.f4996c.size() == 1 ? 500 : intValue > 500 ? 300 : intValue < 30 ? 30 : intValue, this.f4998e, this.f4997d, i);
        }
    }

    /* renamed from: com.b.au$b */
    /* loaded from: classes.dex */
    private class C1441b {

        /* renamed from: b */
        private ArrayList<ArrayList<Integer>> f5000b;

        public C1441b() {
            this.f5000b = null;
            this.f5000b = new ArrayList<>();
        }

        /* renamed from: a */
        private void m16224a(int i, int i2) {
            int i3;
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(i));
            arrayList.add(Integer.valueOf(i2));
            C1439au.this.f4992c[i][i2] = -1;
            C1439au.this.f4992c[i2][i] = -1;
            ArrayList arrayList2 = new ArrayList();
            for (int i4 = 0; i4 < C1439au.this.f4991b.size(); i4++) {
                if (C1439au.this.f4992c[i][i4] != 0 && C1439au.this.f4992c[i2][i4] != 0) {
                    arrayList2.add(Integer.valueOf(i4));
                }
            }
            while (!arrayList2.isEmpty()) {
                int intValue = ((Integer) arrayList2.get(0)).intValue();
                arrayList2.remove(0);
                Iterator<Integer> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Integer next = it2.next();
                    C1439au.this.f4992c[intValue][next.intValue()] = -1;
                    C1439au.this.f4992c[next.intValue()][intValue] = -1;
                }
                arrayList.add(Integer.valueOf(intValue));
                int i5 = 0;
                while (i5 < arrayList2.size()) {
                    if (C1439au.this.f4992c[intValue][((Integer) arrayList2.get(i5)).intValue()] == 0) {
                        arrayList2.remove(i5);
                        i3 = i5;
                    } else {
                        i3 = i5 + 1;
                    }
                    i5 = i3;
                }
            }
            this.f5000b.add(arrayList);
        }

        /* renamed from: a */
        public void m16225a() {
            int size = C1439au.this.f4991b.size();
            for (int i = 0; i < size; i++) {
                for (int i2 = 0; i2 < size; i2++) {
                    if (C1439au.this.f4992c[i][i2] > 0) {
                        m16224a(i, i2);
                    }
                }
            }
            for (int i3 = 0; i3 < size; i3++) {
                boolean z = true;
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    } else if (C1439au.this.f4992c[i3][i4] > 0) {
                        throw new Exception("non visited edge");
                    } else {
                        if (C1439au.this.f4992c[i3][i4] < 0) {
                            z = false;
                            break;
                        }
                        i4++;
                    }
                }
                if (z) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(Integer.valueOf(i3));
                    this.f5000b.add(arrayList);
                }
            }
        }
    }

    /* renamed from: com.b.au$c */
    /* loaded from: classes.dex */
    public class C1442c {

        /* renamed from: a */
        public double f5001a;

        /* renamed from: b */
        public double f5002b;

        /* renamed from: c */
        public int f5003c;

        /* renamed from: d */
        public String f5004d;

        /* renamed from: e */
        public int f5005e;

        public C1442c(double d, double d2) {
            this.f5001a = 0.0d;
            this.f5002b = 0.0d;
            this.f5003c = 0;
            this.f5004d = "0";
            this.f5005e = -1;
            this.f5001a = d;
            this.f5002b = d2;
        }

        public C1442c(double d, double d2, int i, int i2) {
            this.f5001a = 0.0d;
            this.f5002b = 0.0d;
            this.f5003c = 0;
            this.f5004d = "0";
            this.f5005e = -1;
            this.f5001a = d;
            this.f5002b = d2;
            this.f5003c = i;
            this.f5005e = i2;
        }

        public C1442c(double d, double d2, int i, String str, double d3, int i2) {
            this.f5001a = 0.0d;
            this.f5002b = 0.0d;
            this.f5003c = 0;
            this.f5004d = "0";
            this.f5005e = -1;
            this.f5001a = d;
            this.f5002b = d2;
            this.f5004d = str;
            this.f5003c = i;
            this.f5005e = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m16222a(C1442c c1442c) {
            boolean z = false;
            double m16220b = m16220b(c1442c);
            if (m16220b < 500.0d) {
                return true;
            }
            if ((this.f5005e > 0 && c1442c.f5005e == 0) || (this.f5005e == 0 && c1442c.f5005e > 0)) {
                return (this.f5005e == 1 || c1442c.f5005e == 1) ? m16220b < 3000.0d && (m16220b < ((double) this.f5003c) * 1.5d || m16220b < ((double) c1442c.f5003c) * 1.5d) : m16220b < 5000.0d;
            } else if (this.f5005e > 0 || c1442c.f5005e > 0) {
                if (m16220b < 5000.0d || m16220b < this.f5003c || m16220b < c1442c.f5003c) {
                    z = true;
                }
                return z;
            } else {
                if (m16220b < this.f5003c || m16220b < c1442c.f5003c || m16220b < 500.0d) {
                    z = true;
                }
                return z;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public double m16220b(C1442c c1442c) {
            double d = 6356725.0d + ((21412.0d * (90.0d - this.f5001a)) / 90.0d);
            double cos = Math.cos((this.f5001a * 3.1415926535898d) / 180.0d) * d * (((c1442c.f5002b - this.f5002b) * 3.1415926535898d) / 180.0d);
            double d2 = d * (((c1442c.f5001a - this.f5001a) * 3.1415926535898d) / 180.0d);
            return Math.sqrt((d2 * d2) + (cos * cos));
        }
    }

    /* renamed from: a */
    public ArrayList<C1442c> m16235a(double d, double d2) {
        this.f4993d.m16225a();
        ArrayList<C1442c> arrayList = new ArrayList<>();
        Iterator it2 = this.f4993d.f5000b.iterator();
        while (it2.hasNext()) {
            C1440a c1440a = new C1440a();
            Iterator it3 = ((ArrayList) it2.next()).iterator();
            while (it3.hasNext()) {
                c1440a.m16228a(this.f4991b.get(((Integer) it3.next()).intValue()));
            }
            c1440a.m16231a();
            this.f4990a.add(c1440a);
        }
        if (this.f4990a.isEmpty()) {
            return null;
        }
        Collections.sort(this.f4990a);
        if (d != 0.0d && d2 != 0.0d) {
            C1442c c1442c = new C1442c(d2, d);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f4990a.size()) {
                    break;
                }
                C1442c m16227b = this.f4990a.get(i2).m16227b();
                double m16220b = c1442c.m16220b(m16227b);
                if (m16227b.f5005e > 0) {
                    if (m16220b < 7000.0d && m16220b > 2.0d) {
                        this.f4990a.get(i2).f4997d *= 5.0d;
                    }
                } else if (m16220b < 10000.0d && m16220b > 2.0d) {
                    this.f4990a.get(i2).f4997d *= 5.0d;
                }
                i = i2 + 1;
            }
            Collections.sort(this.f4990a);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.f4990a.size() && arrayList.size() < 5) {
                arrayList.add(this.f4990a.get(i4).m16227b());
                i3 = i4 + 1;
            }
            return arrayList;
        }
    }

    /* renamed from: a */
    public void m16234a(int i, String str) {
        int size = this.f4991b.size();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "\\|");
        if (stringTokenizer.countTokens() < 3) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreElements()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        this.f4991b.add(new C1442c(Double.parseDouble((String) arrayList.get(0)), Double.parseDouble((String) arrayList.get(1)), Double.valueOf(Double.parseDouble((String) arrayList.get(2))).intValue(), i));
        if (this.f4991b.size() > 128) {
            throw new Exception("Atomic Pos Larger Than MAXN 512!");
        }
        for (int i2 = 0; i2 < size; i2++) {
            for (int i3 = size; i3 < this.f4991b.size(); i3++) {
                if (this.f4991b.get(i2).m16222a(this.f4991b.get(i3))) {
                    this.f4992c[i2][i3] = 1;
                    this.f4992c[i3][i2] = 1;
                }
            }
        }
        arrayList.clear();
    }
}
