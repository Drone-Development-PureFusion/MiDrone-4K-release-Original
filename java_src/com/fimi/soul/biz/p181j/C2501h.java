package com.fimi.soul.biz.p181j;

import com.fimi.soul.entity.DynamicDYZ_Entity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: com.fimi.soul.biz.j.h */
/* loaded from: classes.dex */
public class C2501h {

    /* renamed from: a */
    private static List<DynamicDYZ_Entity> f8638a;

    /* renamed from: b */
    private static List<DynamicDYZ_Entity> f8639b;

    /* renamed from: c */
    private static C2501h f8640c;

    private C2501h() {
        f8639b = new CopyOnWriteArrayList();
        f8638a = new CopyOnWriteArrayList();
    }

    /* renamed from: a */
    public static C2501h m11907a() {
        if (f8640c == null) {
            synchronized (C2501h.class) {
                if (f8640c == null) {
                    f8640c = new C2501h();
                }
            }
        }
        return f8640c;
    }

    /* renamed from: a */
    public void m11906a(DynamicDYZ_Entity dynamicDYZ_Entity) {
        if (!f8638a.contains(dynamicDYZ_Entity)) {
            f8638a.add(dynamicDYZ_Entity);
        }
    }

    /* renamed from: a */
    public void m11905a(List<DynamicDYZ_Entity> list) {
        f8639b.clear();
        f8639b.addAll(list);
    }

    /* renamed from: b */
    public void m11904b() {
        if (f8638a != null) {
            f8638a.clear();
        }
    }

    /* renamed from: b */
    public void m11903b(DynamicDYZ_Entity dynamicDYZ_Entity) {
        if (f8638a.contains(dynamicDYZ_Entity)) {
            f8638a.remove(dynamicDYZ_Entity);
        }
    }

    /* renamed from: b */
    public void m11902b(List<DynamicDYZ_Entity> list) {
        m11897f();
        f8638a.addAll(list);
    }

    /* renamed from: c */
    public List<DynamicDYZ_Entity> m11901c() {
        return f8638a;
    }

    /* renamed from: c */
    public void m11900c(DynamicDYZ_Entity dynamicDYZ_Entity) {
        if (!f8639b.contains(dynamicDYZ_Entity)) {
            f8639b.add(dynamicDYZ_Entity);
        }
    }

    /* renamed from: d */
    public List<DynamicDYZ_Entity> m11899d() {
        return f8639b;
    }

    /* renamed from: e */
    public void m11898e() {
        if (f8639b != null) {
            f8639b.clear();
        }
    }

    /* renamed from: f */
    public void m11897f() {
        f8638a.clear();
    }
}
