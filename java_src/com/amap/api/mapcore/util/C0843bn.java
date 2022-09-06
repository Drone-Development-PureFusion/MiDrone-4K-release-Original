package com.amap.api.mapcore.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* renamed from: com.amap.api.mapcore.util.bn */
/* loaded from: classes.dex */
class C0843bn {

    /* renamed from: a */
    RandomAccessFile f2366a;

    public C0843bn() {
        this("", 0L);
    }

    public C0843bn(String str, long j) {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                C1007fo.m18012b(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        this.f2366a = new RandomAccessFile(str, "rw");
        this.f2366a.seek(j);
    }

    /* renamed from: a */
    public synchronized int m18806a(byte[] bArr) {
        this.f2366a.write(bArr);
        return bArr.length;
    }

    /* renamed from: a */
    public void m18807a() {
        if (this.f2366a != null) {
            try {
                this.f2366a.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f2366a = null;
        }
    }
}
