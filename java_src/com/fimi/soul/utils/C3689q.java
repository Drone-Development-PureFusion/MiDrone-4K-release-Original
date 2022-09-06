package com.fimi.soul.utils;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* renamed from: com.fimi.soul.utils.q */
/* loaded from: classes.dex */
public class C3689q extends Thread {

    /* renamed from: a */
    File[] f15100a;

    /* renamed from: b */
    private String f15101b;

    public C3689q(File[] fileArr, String str) {
        this.f15100a = fileArr;
        this.f15101b = str;
    }

    /* renamed from: a */
    public void m7439a() {
        start();
    }

    /* renamed from: a */
    public void m7438a(File file, String str) {
        int i = 0;
        try {
            if (!file.exists()) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    return;
                }
                i += read;
                System.out.println(i);
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        File[] fileArr;
        for (File file : this.f15100a) {
            if (file != null) {
                Log.i("istep", " wwwww " + file.exists());
                m7438a(file, this.f15101b + "/" + file.getName());
            }
        }
    }
}
