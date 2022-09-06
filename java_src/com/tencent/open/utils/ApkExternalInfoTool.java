package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;
/* loaded from: classes2.dex */
public final class ApkExternalInfoTool {
    public static final String CHANNELID = "channelNo";

    /* renamed from: a */
    private static final ZipLong f18179a = new ZipLong(101010256);

    /* renamed from: b */
    private static final ZipShort f18180b = new ZipShort(38651);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ApkExternalInfo {

        /* renamed from: a */
        Properties f18181a;

        /* renamed from: b */
        byte[] f18182b;

        private ApkExternalInfo() {
            this.f18181a = new Properties();
        }

        /* renamed from: a */
        void m5370a(byte[] bArr) {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = ApkExternalInfoTool.f18180b.getBytes().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!ApkExternalInfoTool.f18180b.equals(new ZipShort(bArr2))) {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int value = new ZipShort(bArr3).getValue();
            if ((bArr.length - length) - 2 < value) {
                return;
            }
            byte[] bArr4 = new byte[value];
            wrap.get(bArr4);
            this.f18181a.load(new ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - value) - 2;
            if (length2 <= 0) {
                return;
            }
            this.f18182b = new byte[length2];
            wrap.get(this.f18182b);
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f18181a + ", otherData=" + Arrays.toString(this.f18182b) + "]";
        }
    }

    /* renamed from: a */
    private static byte[] m5371a(RandomAccessFile randomAccessFile) {
        boolean z = true;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = f18179a.getBytes();
        int read = randomAccessFile.read();
        while (true) {
            if (read == -1) {
                z = false;
                break;
            } else if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                break;
            } else {
                length--;
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            }
        }
        if (!z) {
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek(16 + length + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        int value = new ZipShort(bArr).getValue();
        if (value == 0) {
            return null;
        }
        byte[] bArr2 = new byte[value];
        randomAccessFile.read(bArr2);
        return bArr2;
    }

    public static String read(File file, String str) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String str2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] m5371a = m5371a(randomAccessFile);
                if (m5371a != null) {
                    ApkExternalInfo apkExternalInfo = new ApkExternalInfo();
                    apkExternalInfo.m5370a(m5371a);
                    str2 = apkExternalInfo.f18181a.getProperty(str);
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } else if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
        }
    }

    public static String readChannelId(File file) {
        return read(file, CHANNELID);
    }
}
