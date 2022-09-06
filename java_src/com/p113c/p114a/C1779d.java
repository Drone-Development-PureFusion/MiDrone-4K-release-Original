package com.p113c.p114a;

import android.view.animation.Interpolator;
import com.p113c.p114a.AbstractC1775a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.c.a.d */
/* loaded from: classes.dex */
public final class C1779d extends AbstractC1775a {

    /* renamed from: c */
    private ArrayList<AbstractC1775a> f6301c = new ArrayList<>();

    /* renamed from: d */
    private HashMap<AbstractC1775a, C1785e> f6302d = new HashMap<>();

    /* renamed from: e */
    private ArrayList<C1785e> f6303e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<C1785e> f6304f = new ArrayList<>();

    /* renamed from: g */
    private boolean f6305g = true;

    /* renamed from: h */
    private C1781a f6306h = null;

    /* renamed from: b */
    boolean f6300b = false;

    /* renamed from: i */
    private boolean f6307i = false;

    /* renamed from: j */
    private long f6308j = 0;

    /* renamed from: k */
    private C1819q f6309k = null;

    /* renamed from: l */
    private long f6310l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.c.a.d$a */
    /* loaded from: classes.dex */
    public class C1781a implements AbstractC1775a.AbstractC1776a {

        /* renamed from: b */
        private C1779d f6315b;

        C1781a(C1779d c1779d) {
            this.f6315b = c1779d;
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: a */
        public void mo14312a(AbstractC1775a abstractC1775a) {
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: b */
        public void mo14311b(AbstractC1775a abstractC1775a) {
            boolean z;
            abstractC1775a.m14671b(this);
            C1779d.this.f6301c.remove(abstractC1775a);
            ((C1785e) this.f6315b.f6302d.get(abstractC1775a)).f6330f = true;
            if (!C1779d.this.f6300b) {
                ArrayList arrayList = this.f6315b.f6304f;
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = true;
                        break;
                    } else if (!((C1785e) arrayList.get(i)).f6330f) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    return;
                }
                if (C1779d.this.f6284a != null) {
                    ArrayList arrayList2 = (ArrayList) C1779d.this.f6284a.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((AbstractC1775a.AbstractC1776a) arrayList2.get(i2)).mo14311b(this.f6315b);
                    }
                }
                this.f6315b.f6307i = false;
            }
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: c */
        public void mo14310c(AbstractC1775a abstractC1775a) {
            if (C1779d.this.f6300b || C1779d.this.f6301c.size() != 0 || C1779d.this.f6284a == null) {
                return;
            }
            int size = C1779d.this.f6284a.size();
            for (int i = 0; i < size; i++) {
                C1779d.this.f6284a.get(i).mo14310c(this.f6315b);
            }
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: d */
        public void mo14309d(AbstractC1775a abstractC1775a) {
        }
    }

    /* renamed from: com.c.a.d$b */
    /* loaded from: classes.dex */
    public class C1782b {

        /* renamed from: b */
        private C1785e f6317b;

        C1782b(AbstractC1775a abstractC1775a) {
            this.f6317b = (C1785e) C1779d.this.f6302d.get(abstractC1775a);
            if (this.f6317b == null) {
                this.f6317b = new C1785e(abstractC1775a);
                C1779d.this.f6302d.put(abstractC1775a, this.f6317b);
                C1779d.this.f6303e.add(this.f6317b);
            }
        }

        /* renamed from: a */
        public C1782b m14649a(long j) {
            C1819q m14499b = C1819q.m14499b(0.0f, 1.0f);
            m14499b.mo14503b(j);
            m14646c(m14499b);
            return this;
        }

        /* renamed from: a */
        public C1782b m14648a(AbstractC1775a abstractC1775a) {
            C1785e c1785e = (C1785e) C1779d.this.f6302d.get(abstractC1775a);
            if (c1785e == null) {
                c1785e = new C1785e(abstractC1775a);
                C1779d.this.f6302d.put(abstractC1775a, c1785e);
                C1779d.this.f6303e.add(c1785e);
            }
            c1785e.m14643a(new C1783c(this.f6317b, 0));
            return this;
        }

        /* renamed from: b */
        public C1782b m14647b(AbstractC1775a abstractC1775a) {
            C1785e c1785e = (C1785e) C1779d.this.f6302d.get(abstractC1775a);
            if (c1785e == null) {
                c1785e = new C1785e(abstractC1775a);
                C1779d.this.f6302d.put(abstractC1775a, c1785e);
                C1779d.this.f6303e.add(c1785e);
            }
            c1785e.m14643a(new C1783c(this.f6317b, 1));
            return this;
        }

        /* renamed from: c */
        public C1782b m14646c(AbstractC1775a abstractC1775a) {
            C1785e c1785e = (C1785e) C1779d.this.f6302d.get(abstractC1775a);
            if (c1785e == null) {
                c1785e = new C1785e(abstractC1775a);
                C1779d.this.f6302d.put(abstractC1775a, c1785e);
                C1779d.this.f6303e.add(c1785e);
            }
            this.f6317b.m14643a(new C1783c(c1785e, 1));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.c.a.d$c */
    /* loaded from: classes.dex */
    public static class C1783c {

        /* renamed from: a */
        static final int f6318a = 0;

        /* renamed from: b */
        static final int f6319b = 1;

        /* renamed from: c */
        public C1785e f6320c;

        /* renamed from: d */
        public int f6321d;

        public C1783c(C1785e c1785e, int i) {
            this.f6320c = c1785e;
            this.f6321d = i;
        }
    }

    /* renamed from: com.c.a.d$d */
    /* loaded from: classes.dex */
    private static class C1784d implements AbstractC1775a.AbstractC1776a {

        /* renamed from: a */
        private C1779d f6322a;

        /* renamed from: b */
        private C1785e f6323b;

        /* renamed from: c */
        private int f6324c;

        public C1784d(C1779d c1779d, C1785e c1785e, int i) {
            this.f6322a = c1779d;
            this.f6323b = c1785e;
            this.f6324c = i;
        }

        /* renamed from: e */
        private void m14645e(AbstractC1775a abstractC1775a) {
            C1783c c1783c;
            if (this.f6322a.f6300b) {
                return;
            }
            int size = this.f6323b.f6327c.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    c1783c = null;
                    break;
                }
                c1783c = this.f6323b.f6327c.get(i);
                if (c1783c.f6321d == this.f6324c && c1783c.f6320c.f6325a == abstractC1775a) {
                    abstractC1775a.m14671b(this);
                    break;
                }
                i++;
            }
            this.f6323b.f6327c.remove(c1783c);
            if (this.f6323b.f6327c.size() != 0) {
                return;
            }
            this.f6323b.f6325a.mo14521a();
            this.f6322a.f6301c.add(this.f6323b.f6325a);
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: a */
        public void mo14312a(AbstractC1775a abstractC1775a) {
            if (this.f6324c == 0) {
                m14645e(abstractC1775a);
            }
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: b */
        public void mo14311b(AbstractC1775a abstractC1775a) {
            if (this.f6324c == 1) {
                m14645e(abstractC1775a);
            }
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: c */
        public void mo14310c(AbstractC1775a abstractC1775a) {
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: d */
        public void mo14309d(AbstractC1775a abstractC1775a) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.c.a.d$e */
    /* loaded from: classes.dex */
    public static class C1785e implements Cloneable {

        /* renamed from: a */
        public AbstractC1775a f6325a;

        /* renamed from: b */
        public ArrayList<C1783c> f6326b = null;

        /* renamed from: c */
        public ArrayList<C1783c> f6327c = null;

        /* renamed from: d */
        public ArrayList<C1785e> f6328d = null;

        /* renamed from: e */
        public ArrayList<C1785e> f6329e = null;

        /* renamed from: f */
        public boolean f6330f = false;

        public C1785e(AbstractC1775a abstractC1775a) {
            this.f6325a = abstractC1775a;
        }

        /* renamed from: a */
        public C1785e clone() {
            try {
                C1785e c1785e = (C1785e) super.clone();
                c1785e.f6325a = this.f6325a.clone();
                return c1785e;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        /* renamed from: a */
        public void m14643a(C1783c c1783c) {
            if (this.f6326b == null) {
                this.f6326b = new ArrayList<>();
                this.f6328d = new ArrayList<>();
            }
            this.f6326b.add(c1783c);
            if (!this.f6328d.contains(c1783c.f6320c)) {
                this.f6328d.add(c1783c.f6320c);
            }
            C1785e c1785e = c1783c.f6320c;
            if (c1785e.f6329e == null) {
                c1785e.f6329e = new ArrayList<>();
            }
            c1785e.f6329e.add(this);
        }
    }

    /* renamed from: o */
    private void m14650o() {
        if (!this.f6305g) {
            int size = this.f6303e.size();
            for (int i = 0; i < size; i++) {
                C1785e c1785e = this.f6303e.get(i);
                if (c1785e.f6326b != null && c1785e.f6326b.size() > 0) {
                    int size2 = c1785e.f6326b.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        C1783c c1783c = c1785e.f6326b.get(i2);
                        if (c1785e.f6328d == null) {
                            c1785e.f6328d = new ArrayList<>();
                        }
                        if (!c1785e.f6328d.contains(c1783c.f6320c)) {
                            c1785e.f6328d.add(c1783c.f6320c);
                        }
                    }
                }
                c1785e.f6330f = false;
            }
            return;
        }
        this.f6304f.clear();
        ArrayList arrayList = new ArrayList();
        int size3 = this.f6303e.size();
        for (int i3 = 0; i3 < size3; i3++) {
            C1785e c1785e2 = this.f6303e.get(i3);
            if (c1785e2.f6326b == null || c1785e2.f6326b.size() == 0) {
                arrayList.add(c1785e2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        while (arrayList.size() > 0) {
            int size4 = arrayList.size();
            for (int i4 = 0; i4 < size4; i4++) {
                C1785e c1785e3 = (C1785e) arrayList.get(i4);
                this.f6304f.add(c1785e3);
                if (c1785e3.f6329e != null) {
                    int size5 = c1785e3.f6329e.size();
                    for (int i5 = 0; i5 < size5; i5++) {
                        C1785e c1785e4 = c1785e3.f6329e.get(i5);
                        c1785e4.f6328d.remove(c1785e3);
                        if (c1785e4.f6328d.size() == 0) {
                            arrayList2.add(c1785e4);
                        }
                    }
                }
            }
            arrayList.clear();
            arrayList.addAll(arrayList2);
            arrayList2.clear();
        }
        this.f6305g = false;
        if (this.f6304f.size() == this.f6303e.size()) {
            return;
        }
        throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
    }

    /* renamed from: a */
    public C1782b m14663a(AbstractC1775a abstractC1775a) {
        if (abstractC1775a != null) {
            this.f6305g = true;
            return new C1782b(abstractC1775a);
        }
        return null;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: a */
    public void mo14521a() {
        this.f6300b = false;
        this.f6307i = true;
        m14650o();
        int size = this.f6304f.size();
        for (int i = 0; i < size; i++) {
            C1785e c1785e = this.f6304f.get(i);
            ArrayList<AbstractC1775a.AbstractC1776a> m14670h = c1785e.f6325a.m14670h();
            if (m14670h != null && m14670h.size() > 0) {
                Iterator it2 = new ArrayList(m14670h).iterator();
                while (it2.hasNext()) {
                    AbstractC1775a.AbstractC1776a abstractC1776a = (AbstractC1775a.AbstractC1776a) it2.next();
                    if ((abstractC1776a instanceof C1784d) || (abstractC1776a instanceof C1781a)) {
                        c1785e.f6325a.m14671b(abstractC1776a);
                    }
                }
            }
        }
        final ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            C1785e c1785e2 = this.f6304f.get(i2);
            if (this.f6306h == null) {
                this.f6306h = new C1781a(this);
            }
            if (c1785e2.f6326b == null || c1785e2.f6326b.size() == 0) {
                arrayList.add(c1785e2);
            } else {
                int size2 = c1785e2.f6326b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    C1783c c1783c = c1785e2.f6326b.get(i3);
                    c1783c.f6320c.f6325a.m14672a((AbstractC1775a.AbstractC1776a) new C1784d(this, c1785e2, c1783c.f6321d));
                }
                c1785e2.f6327c = (ArrayList) c1785e2.f6326b.clone();
            }
            c1785e2.f6325a.m14672a((AbstractC1775a.AbstractC1776a) this.f6306h);
        }
        if (this.f6308j <= 0) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                C1785e c1785e3 = (C1785e) it3.next();
                c1785e3.f6325a.mo14521a();
                this.f6301c.add(c1785e3.f6325a);
            }
        } else {
            this.f6309k = C1819q.m14499b(0.0f, 1.0f);
            this.f6309k.mo14503b(this.f6308j);
            this.f6309k.a((AbstractC1775a.AbstractC1776a) new AbstractC1778c() { // from class: com.c.a.d.1

                /* renamed from: a */
                boolean f6311a = false;

                @Override // com.p113c.p114a.AbstractC1778c, com.p113c.p114a.AbstractC1775a.AbstractC1776a
                /* renamed from: b */
                public void mo14311b(AbstractC1775a abstractC1775a) {
                    if (!this.f6311a) {
                        int size3 = arrayList.size();
                        for (int i4 = 0; i4 < size3; i4++) {
                            C1785e c1785e4 = (C1785e) arrayList.get(i4);
                            c1785e4.f6325a.mo14521a();
                            C1779d.this.f6301c.add(c1785e4.f6325a);
                        }
                    }
                }

                @Override // com.p113c.p114a.AbstractC1778c, com.p113c.p114a.AbstractC1775a.AbstractC1776a
                /* renamed from: c */
                public void mo14310c(AbstractC1775a abstractC1775a) {
                    this.f6311a = true;
                }
            });
            this.f6309k.mo14521a();
        }
        if (this.f6284a != null) {
            ArrayList arrayList2 = (ArrayList) this.f6284a.clone();
            int size3 = arrayList2.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ((AbstractC1775a.AbstractC1776a) arrayList2.get(i4)).mo14312a(this);
            }
        }
        if (this.f6303e.size() == 0 && this.f6308j == 0) {
            this.f6307i = false;
            if (this.f6284a == null) {
                return;
            }
            ArrayList arrayList3 = (ArrayList) this.f6284a.clone();
            int size4 = arrayList3.size();
            for (int i5 = 0; i5 < size4; i5++) {
                ((AbstractC1775a.AbstractC1776a) arrayList3.get(i5)).mo14311b(this);
            }
        }
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: a */
    public void mo14518a(long j) {
        this.f6308j = j;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: a */
    public void mo14517a(Interpolator interpolator) {
        Iterator<C1785e> it2 = this.f6303e.iterator();
        while (it2.hasNext()) {
            it2.next().f6325a.mo14517a(interpolator);
        }
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: a */
    public void mo14608a(Object obj) {
        Iterator<C1785e> it2 = this.f6303e.iterator();
        while (it2.hasNext()) {
            AbstractC1775a abstractC1775a = it2.next().f6325a;
            if (abstractC1775a instanceof C1779d) {
                ((C1779d) abstractC1775a).mo14608a(obj);
            } else if (abstractC1775a instanceof C1796l) {
                ((C1796l) abstractC1775a).mo14608a(obj);
            }
        }
    }

    /* renamed from: a */
    public void m14660a(Collection<AbstractC1775a> collection) {
        C1782b c1782b;
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.f6305g = true;
        C1782b c1782b2 = null;
        for (AbstractC1775a abstractC1775a : collection) {
            if (c1782b2 == null) {
                c1782b = m14663a(abstractC1775a);
            } else {
                c1782b2.m14648a(abstractC1775a);
                c1782b = c1782b2;
            }
            c1782b2 = c1782b;
        }
    }

    /* renamed from: a */
    public void m14659a(List<AbstractC1775a> list) {
        int i = 0;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f6305g = true;
        if (list.size() == 1) {
            m14663a(list.get(0));
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 >= list.size() - 1) {
                return;
            }
            m14663a(list.get(i2)).m14647b(list.get(i2 + 1));
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public void m14658a(AbstractC1775a... abstractC1775aArr) {
        if (abstractC1775aArr != null) {
            this.f6305g = true;
            C1782b m14663a = m14663a(abstractC1775aArr[0]);
            for (int i = 1; i < abstractC1775aArr.length; i++) {
                m14663a.m14648a(abstractC1775aArr[i]);
            }
        }
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: b */
    public void mo14505b() {
        ArrayList arrayList;
        this.f6300b = true;
        if (mo14487g()) {
            if (this.f6284a != null) {
                ArrayList arrayList2 = (ArrayList) this.f6284a.clone();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((AbstractC1775a.AbstractC1776a) it2.next()).mo14310c(this);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (this.f6309k != null && this.f6309k.mo14489f()) {
                this.f6309k.mo14505b();
            } else if (this.f6304f.size() > 0) {
                Iterator<C1785e> it3 = this.f6304f.iterator();
                while (it3.hasNext()) {
                    it3.next().f6325a.mo14505b();
                }
            }
            if (arrayList != null) {
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    ((AbstractC1775a.AbstractC1776a) it4.next()).mo14311b(this);
                }
            }
            this.f6307i = false;
        }
    }

    /* renamed from: b */
    public void m14656b(AbstractC1775a... abstractC1775aArr) {
        if (abstractC1775aArr != null) {
            this.f6305g = true;
            if (abstractC1775aArr.length == 1) {
                m14663a(abstractC1775aArr[0]);
                return;
            }
            for (int i = 0; i < abstractC1775aArr.length - 1; i++) {
                m14663a(abstractC1775aArr[i]).m14647b(abstractC1775aArr[i + 1]);
            }
        }
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: c */
    public C1779d mo14503b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        Iterator<C1785e> it2 = this.f6303e.iterator();
        while (it2.hasNext()) {
            it2.next().f6325a.mo14503b(j);
        }
        this.f6310l = j;
        return this;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: c */
    public void mo14496c() {
        this.f6300b = true;
        if (mo14487g()) {
            if (this.f6304f.size() != this.f6303e.size()) {
                m14650o();
                Iterator<C1785e> it2 = this.f6304f.iterator();
                while (it2.hasNext()) {
                    C1785e next = it2.next();
                    if (this.f6306h == null) {
                        this.f6306h = new C1781a(this);
                    }
                    next.f6325a.m14672a((AbstractC1775a.AbstractC1776a) this.f6306h);
                }
            }
            if (this.f6309k != null) {
                this.f6309k.mo14505b();
            }
            if (this.f6304f.size() > 0) {
                Iterator<C1785e> it3 = this.f6304f.iterator();
                while (it3.hasNext()) {
                    it3.next().f6325a.mo14496c();
                }
            }
            if (this.f6284a != null) {
                Iterator it4 = ((ArrayList) this.f6284a.clone()).iterator();
                while (it4.hasNext()) {
                    ((AbstractC1775a.AbstractC1776a) it4.next()).mo14311b(this);
                }
            }
            this.f6307i = false;
        }
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: d */
    public long mo14493d() {
        return this.f6308j;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: e */
    public long mo14491e() {
        return this.f6310l;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: f */
    public boolean mo14489f() {
        Iterator<C1785e> it2 = this.f6303e.iterator();
        while (it2.hasNext()) {
            if (it2.next().f6325a.mo14489f()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: g */
    public boolean mo14487g() {
        return this.f6307i;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: k */
    public void mo14598k() {
        Iterator<C1785e> it2 = this.f6303e.iterator();
        while (it2.hasNext()) {
            it2.next().f6325a.mo14598k();
        }
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: l */
    public void mo14597l() {
        Iterator<C1785e> it2 = this.f6303e.iterator();
        while (it2.hasNext()) {
            it2.next().f6325a.mo14597l();
        }
    }

    /* renamed from: m */
    public ArrayList<AbstractC1775a> m14652m() {
        ArrayList<AbstractC1775a> arrayList = new ArrayList<>();
        Iterator<C1785e> it2 = this.f6303e.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().f6325a);
        }
        return arrayList;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: n */
    public C1779d mo14485j() {
        C1779d c1779d = (C1779d) super.clone();
        c1779d.f6305g = true;
        c1779d.f6300b = false;
        c1779d.f6307i = false;
        c1779d.f6301c = new ArrayList<>();
        c1779d.f6302d = new HashMap<>();
        c1779d.f6303e = new ArrayList<>();
        c1779d.f6304f = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<C1785e> it2 = this.f6303e.iterator();
        while (it2.hasNext()) {
            C1785e next = it2.next();
            C1785e clone = next.clone();
            hashMap.put(next, clone);
            c1779d.f6303e.add(clone);
            c1779d.f6302d.put(clone.f6325a, clone);
            clone.f6326b = null;
            clone.f6327c = null;
            clone.f6329e = null;
            clone.f6328d = null;
            ArrayList<AbstractC1775a.AbstractC1776a> m14670h = clone.f6325a.m14670h();
            if (m14670h != null) {
                Iterator<AbstractC1775a.AbstractC1776a> it3 = m14670h.iterator();
                ArrayList arrayList = null;
                while (it3.hasNext()) {
                    AbstractC1775a.AbstractC1776a next2 = it3.next();
                    if (next2 instanceof C1781a) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        m14670h.remove((AbstractC1775a.AbstractC1776a) it4.next());
                    }
                }
            }
        }
        Iterator<C1785e> it5 = this.f6303e.iterator();
        while (it5.hasNext()) {
            C1785e next3 = it5.next();
            C1785e c1785e = (C1785e) hashMap.get(next3);
            if (next3.f6326b != null) {
                Iterator<C1783c> it6 = next3.f6326b.iterator();
                while (it6.hasNext()) {
                    C1783c next4 = it6.next();
                    c1785e.m14643a(new C1783c((C1785e) hashMap.get(next4.f6320c), next4.f6321d));
                }
            }
        }
        return c1779d;
    }
}
