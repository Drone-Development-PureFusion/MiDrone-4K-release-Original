package org.p318d.p320b;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.p318d.p322d.AbstractC5751c;
/* renamed from: org.d.b.a */
/* loaded from: classes2.dex */
public class C5728a implements AbstractC5751c {

    /* renamed from: a */
    private InheritableThreadLocal<Map<String, String>> f22989a = new InheritableThreadLocal<Map<String, String>>() { // from class: org.d.b.a.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.InheritableThreadLocal
        /* renamed from: a */
        public Map<String, String> childValue(Map<String, String> map) {
            if (map == null) {
                return null;
            }
            return new HashMap(map);
        }
    };

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: a */
    public void mo28a() {
        Map<String, String> map = this.f22989a.get();
        if (map != null) {
            map.clear();
            this.f22989a.remove();
        }
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: a */
    public void mo27a(String str) {
        Map<String, String> map = this.f22989a.get();
        if (map != null) {
            map.remove(str);
        }
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: a */
    public void mo26a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        Map<String, String> map = this.f22989a.get();
        if (map == null) {
            map = new HashMap<>();
            this.f22989a.set(map);
        }
        map.put(str, str2);
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: a */
    public void mo25a(Map<String, String> map) {
        this.f22989a.set(new HashMap(map));
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: b */
    public String mo24b(String str) {
        Map<String, String> map = this.f22989a.get();
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    /* renamed from: b */
    public Set<String> m166b() {
        Map<String, String> map = this.f22989a.get();
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: d */
    public Map<String, String> mo23d() {
        Map<String, String> map = this.f22989a.get();
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }
}
