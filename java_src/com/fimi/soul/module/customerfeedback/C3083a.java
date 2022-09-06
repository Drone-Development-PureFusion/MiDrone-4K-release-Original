package com.fimi.soul.module.customerfeedback;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.fimi.kernel.utils.C2281x;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* renamed from: com.fimi.soul.module.customerfeedback.a */
/* loaded from: classes.dex */
public class C3083a {

    /* renamed from: c */
    private static C3083a f11538c;

    /* renamed from: b */
    private int f11540b = 3;

    /* renamed from: a */
    private LinkedHashSet<Uri> f11539a = new LinkedHashSet<>();

    private C3083a() {
    }

    /* renamed from: a */
    public static C3083a m9700a() {
        if (f11538c == null) {
            synchronized (C3083a.class) {
                if (f11538c == null) {
                    f11538c = new C3083a();
                }
            }
        }
        return f11538c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9695b(Uri uri) {
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        if (imagePipeline.isInBitmapMemoryCache(uri)) {
            imagePipeline.evictFromMemoryCache(uri);
        }
    }

    /* renamed from: c */
    private void m9694c() {
        Iterator<Uri> it2 = this.f11539a.iterator();
        while (it2.hasNext()) {
            m9695b(it2.next());
            if (this.f11539a.size() < this.f11540b) {
                return;
            }
        }
    }

    /* renamed from: a */
    public void m9699a(Uri uri) {
        this.f11539a.add(uri);
        if (this.f11539a.size() <= this.f11540b || this.f11539a.size() % this.f11540b != 0) {
            return;
        }
        m9694c();
    }

    /* renamed from: b */
    public void m9696b() {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.module.customerfeedback.a.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = C3083a.this.f11539a.iterator();
                while (it2.hasNext()) {
                    C3083a.this.m9695b((Uri) it2.next());
                }
            }
        });
    }
}
