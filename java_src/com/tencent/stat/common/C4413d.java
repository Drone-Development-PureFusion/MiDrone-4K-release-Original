package com.tencent.stat.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.tencent.stat.common.d */
/* loaded from: classes2.dex */
public class C4413d {
    /* renamed from: a */
    public static File m5227a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                m5227a(file.getParentFile().getAbsolutePath());
            }
            file.mkdir();
        }
        return file;
    }

    /* renamed from: a */
    public static List<String> m5228a(File file) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine.trim());
        }
    }
}
