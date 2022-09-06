package com.baidu.tts.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class MD5 {

    /* renamed from: a */
    private static volatile MD5 f6282a = null;

    /* renamed from: b */
    private char[] f6283b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private MD5() {
    }

    /* renamed from: a */
    private String m14676a(byte[] bArr) {
        return m14675a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private String m14675a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i + i2;
        while (i < i3) {
            m14677a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m14677a(byte b, StringBuffer stringBuffer) {
        char c = this.f6283b[(b & 240) >> 4];
        char c2 = this.f6283b[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    public static MD5 getInstance() {
        if (f6282a == null) {
            synchronized (MD5.class) {
                if (f6282a == null) {
                    f6282a = new MD5();
                }
            }
        }
        return f6282a;
    }

    public String getBigFileMd5(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        String str = null;
        if (file != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str = m14676a(messageDigest.digest());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream = null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        }
        return str;
    }

    public String getBigFileMd5(String str) {
        return getBigFileMd5(new File(str));
    }

    public String getFileMd5(String str) {
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        FileInputStream fileInputStream2;
        FileChannel fileChannel2 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            File file = new File(str);
            fileInputStream = new FileInputStream(file);
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    messageDigest.update(fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                    String m14676a = m14676a(messageDigest.digest());
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return m14676a;
                } catch (Exception e2) {
                    fileInputStream2 = fileInputStream;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return null;
                } catch (Throwable th) {
                    fileChannel2 = fileChannel;
                    th = th;
                    if (fileChannel2 != null) {
                        try {
                            fileChannel2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileChannel = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            fileChannel = null;
            fileInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public String getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            char[] cArr = new char[length * 2];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i + 1;
                cArr[i] = this.f6283b[(digest[i2] >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = this.f6283b[digest[i2] & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }
}
