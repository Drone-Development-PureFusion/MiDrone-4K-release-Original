package p004b.p005a.p006a.p007a.p027p;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.p318d.p322d.AbstractC5751c;
/* renamed from: b.a.a.a.p.f */
/* loaded from: classes.dex */
public final class C0263f implements AbstractC5751c {

    /* renamed from: c */
    private static final int f461c = 1;

    /* renamed from: d */
    private static final int f462d = 2;

    /* renamed from: a */
    final InheritableThreadLocal<Map<String, String>> f463a = new InheritableThreadLocal<>();

    /* renamed from: b */
    final ThreadLocal<Integer> f464b = new ThreadLocal<>();

    /* renamed from: a */
    private Integer m21110a(int i) {
        Integer num = this.f464b.get();
        this.f464b.set(Integer.valueOf(i));
        return num;
    }

    /* renamed from: a */
    private boolean m21109a(Integer num) {
        return num == null || num.intValue() == 2;
    }

    /* renamed from: b */
    private Map<String, String> m21107b(Map<String, String> map) {
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap());
        if (map != null) {
            synchronized (map) {
                synchronizedMap.putAll(map);
            }
        }
        this.f463a.set(synchronizedMap);
        return synchronizedMap;
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: a */
    public void mo28a() {
        this.f464b.set(1);
        this.f463a.remove();
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: a */
    public void mo27a(String str) {
        Map<String, String> map;
        if (str == null || (map = this.f463a.get()) == null) {
            return;
        }
        if (m21109a(m21110a(1))) {
            m21107b(map).remove(str);
        } else {
            map.remove(str);
        }
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: a */
    public void mo26a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        Map<String, String> map = this.f463a.get();
        if (m21109a(m21110a(1)) || map == null) {
            m21107b(map).put(str, str2);
        } else {
            map.put(str, str2);
        }
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: a */
    public void mo25a(Map map) {
        this.f464b.set(1);
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap());
        synchronizedMap.putAll(map);
        this.f463a.set(synchronizedMap);
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: b */
    public String mo24b(String str) {
        Map<String, String> m21108b = m21108b();
        if (m21108b == null || str == null) {
            return null;
        }
        return m21108b.get(str);
    }

    /* renamed from: b */
    public Map<String, String> m21108b() {
        this.f464b.set(2);
        return this.f463a.get();
    }

    /* renamed from: c */
    public Set<String> m21106c() {
        Map<String, String> m21108b = m21108b();
        if (m21108b != null) {
            return m21108b.keySet();
        }
        return null;
    }

    @Override // org.p318d.p322d.AbstractC5751c
    /* renamed from: d */
    public Map mo23d() {
        this.f464b.set(2);
        Map<String, String> map = this.f463a.get();
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }
}
