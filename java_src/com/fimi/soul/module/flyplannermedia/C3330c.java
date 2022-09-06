package com.fimi.soul.module.flyplannermedia;

import com.fimi.soul.entity.WifiDistanceFile;
import java.util.Comparator;
/* renamed from: com.fimi.soul.module.flyplannermedia.c */
/* loaded from: classes.dex */
public class C3330c implements Comparator<WifiDistanceFile> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(WifiDistanceFile wifiDistanceFile, WifiDistanceFile wifiDistanceFile2) {
        return -wifiDistanceFile.getName().compareTo(wifiDistanceFile2.getName());
    }
}
