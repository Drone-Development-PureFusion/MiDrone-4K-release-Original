package com.fimi.soul.module.flyplannermedia;

import java.io.File;
import java.util.Comparator;
/* renamed from: com.fimi.soul.module.flyplannermedia.b */
/* loaded from: classes.dex */
public class C3329b implements Comparator<File> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(File file, File file2) {
        if (file == null || file2 == null || file.lastModified() == file2.lastModified()) {
            return 0;
        }
        return file.lastModified() > file2.lastModified() ? -1 : 1;
    }
}
