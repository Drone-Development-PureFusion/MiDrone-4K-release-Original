package com.tencent.p227mm.algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.tencent.mm.algorithm.MD5 */
/* loaded from: classes.dex */
public final class MD5 {
    private MD5() {
    }

    public static String getMD5(File file) {
        return getMD5(file, 102400);
    }

    public static String getMD5(File file, int i) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (file == null || i <= 0 || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            fileInputStream2 = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            String md5 = getMD5(fileInputStream, (int) (((long) i) <= file.length() ? i : file.length()));
            fileInputStream.close();
            try {
                fileInputStream.close();
                return md5;
            } catch (IOException e2) {
                return md5;
            }
        } catch (Exception e3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    public static String getMD5(File file, int i, int i2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (file == null || !file.exists() || i < 0 || i2 <= 0) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String md5 = getMD5(fileInputStream, 102400, i, i2);
                fileInputStream.close();
                try {
                    fileInputStream.close();
                    return md5;
                } catch (IOException e) {
                    return md5;
                }
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static final String getMD5(FileInputStream fileInputStream, int i) {
        if (fileInputStream == null || i <= 0) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder(32);
            byte[] bArr = new byte[i];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            for (byte b : messageDigest.digest()) {
                sb.append(Integer.toString((b & SmileConstants.BYTE_MARKER_END_OF_CONTENT) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static final String getMD5(FileInputStream fileInputStream, int i, int i2, int i3) {
        if (fileInputStream == null || i <= 0 || i2 < 0 || i3 <= 0) {
            return null;
        }
        try {
            if (fileInputStream.skip(i2) < i2) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder(32);
            byte[] bArr = new byte[i];
            int i4 = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1 || i4 >= i3) {
                    break;
                } else if (i4 + read <= i3) {
                    messageDigest.update(bArr, 0, read);
                    i4 += read;
                } else {
                    messageDigest.update(bArr, 0, i3 - i4);
                    i4 = i3;
                }
            }
            for (byte b : messageDigest.digest()) {
                sb.append(Integer.toString((b & SmileConstants.BYTE_MARKER_END_OF_CONTENT) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getMD5(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        return getMD5(file, 102400);
    }

    public static String getMD5(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        return getMD5(file, i, i2);
    }

    public static final String getMessageDigest(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    public static final byte[] getRawDigest(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e) {
            return null;
        }
    }
}
