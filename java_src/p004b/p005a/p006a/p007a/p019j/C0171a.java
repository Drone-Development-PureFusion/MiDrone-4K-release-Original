package p004b.p005a.p006a.p007a.p019j;

import java.io.Serializable;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p007a.p025n.C0239l;
import p004b.p005a.p006a.p007a.p025n.C0240m;
import p004b.p005a.p006a.p028b.p054o.AbstractC0536o;
/* renamed from: b.a.a.a.j.a */
/* loaded from: classes.dex */
public class C0171a implements AbstractC0536o<AbstractC0231d> {
    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0536o
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Serializable mo20212a(AbstractC0231d abstractC0231d) {
        if (abstractC0231d == null) {
            return null;
        }
        if (abstractC0231d instanceof C0239l) {
            return C0240m.m21221a(abstractC0231d);
        }
        if (!(abstractC0231d instanceof C0240m)) {
            throw new IllegalArgumentException("Unsupported type " + abstractC0231d.getClass().getName());
        }
        return (C0240m) abstractC0231d;
    }
}
