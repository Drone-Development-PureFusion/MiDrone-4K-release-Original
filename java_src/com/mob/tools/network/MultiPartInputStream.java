package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class MultiPartInputStream extends InputStream {
    private int curIs;
    private ArrayList<InputStream> isList = new ArrayList<>();

    private boolean isEmpty() {
        return this.isList == null || this.isList.size() <= 0;
    }

    public void addInputStream(InputStream inputStream) {
        this.isList.add(inputStream);
    }

    @Override // java.io.InputStream
    public int available() {
        if (isEmpty()) {
            return 0;
        }
        return this.isList.get(this.curIs).available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterator<InputStream> it2 = this.isList.iterator();
        while (it2.hasNext()) {
            it2.next().close();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (isEmpty()) {
            return -1;
        }
        int read = this.isList.get(this.curIs).read();
        while (read < 0) {
            this.curIs++;
            if (this.curIs >= this.isList.size()) {
                return read;
            }
            read = this.isList.get(this.curIs).read();
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (isEmpty()) {
            return -1;
        }
        int read = this.isList.get(this.curIs).read(bArr, i, i2);
        while (read < 0) {
            this.curIs++;
            if (this.curIs >= this.isList.size()) {
                return read;
            }
            read = this.isList.get(this.curIs).read(bArr, i, i2);
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        throw new IOException();
    }
}
