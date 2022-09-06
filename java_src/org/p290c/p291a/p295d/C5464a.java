package org.p290c.p291a.p295d;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.p290c.p312f.C5670g;
import org.p290c.p312f.p313a.AbstractC5645h;
/* renamed from: org.c.a.d.a */
/* loaded from: classes2.dex */
public class C5464a extends C5670g {
    public C5464a(Class<?> cls, AbstractC5645h abstractC5645h) {
        super(abstractC5645h, cls, m998a(cls.getClasses()));
    }

    /* renamed from: a */
    private static Class<?>[] m998a(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class<?> cls : clsArr) {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add(cls);
            }
        }
        return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }
}
