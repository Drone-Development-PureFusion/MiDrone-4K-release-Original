package p004b.p005a.p006a.p028b.p056q;

import java.util.Iterator;
import java.util.Stack;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p054o.AbstractC0537p;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.q.b */
/* loaded from: classes.dex */
public class C0558b {

    /* renamed from: a */
    final C0555a f1234a;

    /* renamed from: b */
    final AbstractC0537p f1235b;

    /* renamed from: c */
    final AbstractC0537p f1236c;

    public C0558b(C0555a c0555a, AbstractC0537p abstractC0537p) {
        this(c0555a, abstractC0537p, null);
    }

    public C0558b(C0555a c0555a, AbstractC0537p abstractC0537p, AbstractC0537p abstractC0537p2) {
        this.f1234a = c0555a;
        this.f1235b = abstractC0537p;
        this.f1236c = abstractC0537p2;
    }

    /* renamed from: a */
    private static C0555a m20144a(String str) {
        return new C0560c(new C0564e(str).m20127a()).m20139a();
    }

    /* renamed from: a */
    private String m20149a(C0555a c0555a) {
        return (String) ((C0555a) c0555a.f1227b).f1227b;
    }

    /* renamed from: a */
    public static String m20143a(String str, AbstractC0537p abstractC0537p, AbstractC0537p abstractC0537p2) {
        return new C0558b(m20144a(str), abstractC0537p, abstractC0537p2).m20150a();
    }

    /* renamed from: a */
    private String m20142a(Stack<C0555a> stack) {
        StringBuilder sb = new StringBuilder("Circular variable reference detected while parsing input [");
        Iterator<C0555a> it2 = stack.iterator();
        while (it2.hasNext()) {
            C0555a next = it2.next();
            sb.append("${").append(m20149a(next)).append("}");
            if (stack.lastElement() != next) {
                sb.append(" --> ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    private void m20147a(C0555a c0555a, StringBuilder sb) {
        sb.append((String) c0555a.f1227b);
    }

    /* renamed from: a */
    private void m20146a(C0555a c0555a, StringBuilder sb, Stack<C0555a> stack) {
        while (c0555a != null) {
            switch (c0555a.f1226a) {
                case LITERAL:
                    m20147a(c0555a, sb);
                    break;
                case VARIABLE:
                    m20141b(c0555a, sb, stack);
                    break;
            }
            c0555a = c0555a.f1229d;
        }
    }

    /* renamed from: a */
    private boolean m20148a(C0555a c0555a, C0555a c0555a2) {
        if (c0555a.f1226a == null || c0555a.f1226a.equals(c0555a2.f1226a)) {
            if (c0555a.f1227b != null && !c0555a.f1227b.equals(c0555a2.f1227b)) {
                return false;
            }
            return c0555a.f1228c == null || c0555a.f1228c.equals(c0555a2.f1228c);
        }
        return false;
    }

    /* renamed from: a */
    private boolean m20145a(C0555a c0555a, Stack<C0555a> stack) {
        Iterator<C0555a> it2 = stack.iterator();
        while (it2.hasNext()) {
            if (m20148a(c0555a, it2.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private String m20140b(String str) {
        String mo20211a;
        String mo20211a2 = this.f1235b.mo20211a(str);
        if (mo20211a2 != null) {
            return mo20211a2;
        }
        if (this.f1236c != null && (mo20211a = this.f1236c.mo20211a(str)) != null) {
            return mo20211a;
        }
        String m20060a = C0589u.m20060a(str, (String) null);
        if (m20060a != null) {
            return m20060a;
        }
        String m20067a = C0589u.m20067a(str);
        if (m20067a != null) {
            return m20067a;
        }
        return null;
    }

    /* renamed from: b */
    private void m20141b(C0555a c0555a, StringBuilder sb, Stack<C0555a> stack) {
        if (m20145a(c0555a, stack)) {
            stack.push(c0555a);
            throw new IllegalArgumentException(m20142a(stack));
        }
        stack.push(c0555a);
        StringBuilder sb2 = new StringBuilder();
        m20146a((C0555a) c0555a.f1227b, sb2, stack);
        String sb3 = sb2.toString();
        String m20140b = m20140b(sb3);
        if (m20140b != null) {
            m20146a(m20144a(m20140b), sb, stack);
            stack.pop();
        } else if (c0555a.f1228c == null) {
            sb.append(sb3 + C0359h.f702ae);
            stack.pop();
        } else {
            StringBuilder sb4 = new StringBuilder();
            m20146a((C0555a) c0555a.f1228c, sb4, stack);
            stack.pop();
            sb.append(sb4.toString());
        }
    }

    /* renamed from: a */
    public String m20150a() {
        StringBuilder sb = new StringBuilder();
        m20146a(this.f1234a, sb, new Stack<>());
        return sb.toString();
    }
}
