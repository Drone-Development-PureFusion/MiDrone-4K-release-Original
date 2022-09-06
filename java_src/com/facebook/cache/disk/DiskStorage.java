package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.WriterCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public interface DiskStorage {

    /* loaded from: classes.dex */
    public static class DiskDumpInfo {
        public List<DiskDumpInfoEntry> entries = new ArrayList();
        public Map<String, Integer> typeCounts = new HashMap();
    }

    /* loaded from: classes.dex */
    public static class DiskDumpInfoEntry {
        public final String firstBits;
        public final String path;
        public final float size;
        public final String type;

        /* JADX INFO: Access modifiers changed from: protected */
        public DiskDumpInfoEntry(String str, String str2, float f, String str3) {
            this.path = str;
            this.type = str2;
            this.size = f;
            this.firstBits = str3;
        }
    }

    /* loaded from: classes.dex */
    public interface Entry {
        /* renamed from: getResource */
        BinaryResource mo21755getResource();

        long getSize();

        long getTimestamp();
    }

    void clearAll();

    /* renamed from: commit */
    BinaryResource mo21751commit(String str, BinaryResource binaryResource, Object obj);

    boolean contains(String str, Object obj);

    /* renamed from: createTemporary */
    BinaryResource mo21752createTemporary(String str, Object obj);

    DiskDumpInfo getDumpInfo();

    /* renamed from: getEntries */
    Collection<Entry> mo21753getEntries();

    /* renamed from: getResource */
    BinaryResource mo21754getResource(String str, Object obj);

    boolean isEnabled();

    void purgeUnexpectedResources();

    long remove(Entry entry);

    long remove(String str);

    boolean touch(String str, Object obj);

    void updateResource(String str, BinaryResource binaryResource, WriterCallback writerCallback, Object obj);
}
