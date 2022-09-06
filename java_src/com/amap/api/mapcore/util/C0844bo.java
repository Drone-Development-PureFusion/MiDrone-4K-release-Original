package com.amap.api.mapcore.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* renamed from: com.amap.api.mapcore.util.bo */
/* loaded from: classes.dex */
public class C0844bo {

    /* renamed from: com.amap.api.mapcore.util.bo$a */
    /* loaded from: classes.dex */
    public interface AbstractC0845a {
        /* renamed from: a */
        void mo18803a(String str, String str2);

        /* renamed from: a */
        void mo18802a(String str, String str2, float f);

        /* renamed from: a */
        void mo18801a(String str, String str2, int i);

        /* renamed from: b */
        void mo18800b(String str, String str2);
    }

    /* renamed from: a */
    private float m18805a(long j, long j2) {
        return (((float) j) / ((float) j2)) * 100.0f;
    }

    /* renamed from: a */
    public long m18804a(File file, File file2, long j, long j2, AbstractC0845a abstractC0845a) {
        long j3;
        if (j == 0) {
            System.err.println("sizeOfDirectory is the total Size,  must be a positive number");
            if (abstractC0845a != null) {
                abstractC0845a.mo18801a("", "", -1);
            }
            return 0L;
        }
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        try {
        } catch (Exception e) {
            e = e;
        }
        try {
            if (file.isDirectory()) {
                if (!file2.exists() && !file2.mkdirs()) {
                    throw new IOException("Cannot create dir " + file2.getAbsolutePath());
                }
                String[] list = file.list();
                if (list == null) {
                    return j;
                }
                long j4 = j;
                for (int i = 0; i < list.length; i++) {
                    j4 = m18804a(new File(file, list[i]), new File(file2, list[i]), j4, j2, abstractC0845a);
                }
                return j4;
            }
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("Cannot create dir " + parentFile.getAbsolutePath());
            }
            if (abstractC0845a != null && j <= 0) {
                abstractC0845a.mo18803a(absolutePath, absolutePath2);
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                j3 = j;
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                j = j3 + read;
                if (abstractC0845a != null) {
                    abstractC0845a.mo18802a(absolutePath, absolutePath2, m18805a(j, j2));
                }
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            if (abstractC0845a == null || j3 < j2 - 1) {
                return j3;
            }
            abstractC0845a.mo18800b(absolutePath, absolutePath2);
            return j3;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (abstractC0845a == null) {
                return j;
            }
            abstractC0845a.mo18801a(absolutePath, absolutePath2, -1);
            return j;
        }
    }
}
