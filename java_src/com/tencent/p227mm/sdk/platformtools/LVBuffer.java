package com.tencent.p227mm.sdk.platformtools;

import java.nio.ByteBuffer;
/* renamed from: com.tencent.mm.sdk.platformtools.LVBuffer */
/* loaded from: classes.dex */
public class LVBuffer {
    public static final int LENGTH_ALLOC_PER_NEW = 4096;
    public static final int MAX_STRING_LENGTH = 2048;

    /* renamed from: ap */
    private ByteBuffer f17817ap;

    /* renamed from: aq */
    private boolean f17818aq;

    /* renamed from: a */
    private int m5651a(int i) {
        if (this.f17817ap.limit() - this.f17817ap.position() <= i) {
            ByteBuffer allocate = ByteBuffer.allocate(this.f17817ap.limit() + 4096);
            allocate.put(this.f17817ap.array(), 0, this.f17817ap.position());
            this.f17817ap = allocate;
        }
        return 0;
    }

    public byte[] buildFinish() {
        if (!this.f17818aq) {
            throw new Exception("Buffer For Parse");
        }
        m5651a(1);
        this.f17817ap.put((byte) 125);
        byte[] bArr = new byte[this.f17817ap.position()];
        System.arraycopy(this.f17817ap.array(), 0, bArr, 0, bArr.length);
        return bArr;
    }

    public boolean checkGetFinish() {
        return this.f17817ap.limit() - this.f17817ap.position() <= 1;
    }

    public int getInt() {
        if (this.f17818aq) {
            throw new Exception("Buffer For Build");
        }
        return this.f17817ap.getInt();
    }

    public long getLong() {
        if (this.f17818aq) {
            throw new Exception("Buffer For Build");
        }
        return this.f17817ap.getLong();
    }

    public String getString() {
        if (this.f17818aq) {
            throw new Exception("Buffer For Build");
        }
        int i = this.f17817ap.getShort();
        if (i > 2048) {
            this.f17817ap = null;
            throw new Exception("Buffer String Length Error");
        } else if (i == 0) {
            return "";
        } else {
            byte[] bArr = new byte[i];
            this.f17817ap.get(bArr, 0, i);
            return new String(bArr);
        }
    }

    public int initBuild() {
        this.f17817ap = ByteBuffer.allocate(4096);
        this.f17817ap.put((byte) 123);
        this.f17818aq = true;
        return 0;
    }

    public int initParse(byte[] bArr) {
        int i = (bArr == null || bArr.length == 0) ? -1 : bArr[0] != 123 ? -2 : bArr[bArr.length + (-1)] != 125 ? -3 : 0;
        if (i != 0) {
            this.f17817ap = null;
            throw new Exception("Parse Buffer Check Failed :" + i);
        }
        this.f17817ap = ByteBuffer.wrap(bArr);
        this.f17817ap.position(1);
        this.f17818aq = false;
        return 0;
    }

    public int putInt(int i) {
        if (!this.f17818aq) {
            throw new Exception("Buffer For Parse");
        }
        m5651a(4);
        this.f17817ap.putInt(i);
        return 0;
    }

    public int putLong(long j) {
        if (!this.f17818aq) {
            throw new Exception("Buffer For Parse");
        }
        m5651a(8);
        this.f17817ap.putLong(j);
        return 0;
    }

    public int putString(String str) {
        if (!this.f17818aq) {
            throw new Exception("Buffer For Parse");
        }
        byte[] bArr = null;
        if (str != null) {
            bArr = str.getBytes();
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr.length > 2048) {
            throw new Exception("Buffer String Length Error");
        }
        m5651a(bArr.length + 2);
        this.f17817ap.putShort((short) bArr.length);
        if (bArr.length > 0) {
            this.f17817ap.put(bArr);
        }
        return 0;
    }
}
