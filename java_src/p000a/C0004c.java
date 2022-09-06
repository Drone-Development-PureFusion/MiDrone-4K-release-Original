package p000a;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
/* renamed from: a.c */
/* loaded from: classes.dex */
public class C0004c {

    /* renamed from: a */
    private Uri f7a;

    /* renamed from: b */
    private List<C0005a> f8b;

    /* renamed from: c */
    private Uri f9c;

    /* renamed from: a.c$a */
    /* loaded from: classes.dex */
    public static class C0005a {

        /* renamed from: a */
        private final Uri f10a;

        /* renamed from: b */
        private final String f11b;

        /* renamed from: c */
        private final String f12c;

        /* renamed from: d */
        private final String f13d;

        public C0005a(String str, String str2, Uri uri, String str3) {
            this.f11b = str;
            this.f12c = str2;
            this.f10a = uri;
            this.f13d = str3;
        }

        /* renamed from: a */
        public Uri m21661a() {
            return this.f10a;
        }

        /* renamed from: b */
        public String m21660b() {
            return this.f13d;
        }

        /* renamed from: c */
        public String m21659c() {
            return this.f12c;
        }

        /* renamed from: d */
        public String m21658d() {
            return this.f11b;
        }
    }

    public C0004c(Uri uri, List<C0005a> list, Uri uri2) {
        this.f7a = uri;
        this.f8b = list == null ? Collections.emptyList() : list;
        this.f9c = uri2;
    }

    /* renamed from: a */
    public Uri m21664a() {
        return this.f7a;
    }

    /* renamed from: b */
    public List<C0005a> m21663b() {
        return Collections.unmodifiableList(this.f8b);
    }

    /* renamed from: c */
    public Uri m21662c() {
        return this.f9c;
    }
}
