package com.xiaomi.channel.commonutils.file;

import java.io.File;
import java.io.FileFilter;
/* renamed from: com.xiaomi.channel.commonutils.file.b */
/* loaded from: classes2.dex */
final class C4475b implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
