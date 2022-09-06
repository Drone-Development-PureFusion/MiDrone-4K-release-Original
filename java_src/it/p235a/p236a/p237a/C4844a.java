package it.p235a.p236a.p237a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: it.a.a.a.a */
/* loaded from: classes2.dex */
public class C4844a {

    /* renamed from: a */
    static String f20687a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    /* renamed from: b */
    static char f20688b = SignatureVisitor.INSTANCEOF;

    C4844a() {
    }

    /* renamed from: a */
    public static String m3142a(String str) {
        try {
            return new String(m3140a(str.getBytes()), "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII is not supported!", e);
        }
    }

    /* renamed from: a */
    public static String m3141a(String str, String str2) {
        try {
            try {
                return new String(m3140a(str.getBytes(str2)), "ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("ASCII is not supported!", e);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(new StringBuffer().append("Unsupported charset: ").append(str2).toString(), e2);
        }
    }

    /* renamed from: a */
    public static void m3146a(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    m3144a(fileInputStream2, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th) {
                        }
                    }
                    if (fileInputStream2 == null) {
                        return;
                    }
                    try {
                        fileInputStream2.close();
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
            }
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
        }
    }

    /* renamed from: a */
    public static void m3145a(File file, File file2, int i) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    m3143a(fileInputStream2, fileOutputStream, i);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th) {
                        }
                    }
                    if (fileInputStream2 == null) {
                        return;
                    }
                    try {
                        fileInputStream2.close();
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
            }
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
        }
    }

    /* renamed from: a */
    public static void m3144a(InputStream inputStream, OutputStream outputStream) {
        m3143a(inputStream, outputStream, 0);
    }

    /* renamed from: a */
    public static void m3143a(InputStream inputStream, OutputStream outputStream, int i) {
        C4846c c4846c = new C4846c(outputStream, i);
        m3133c(inputStream, c4846c);
        c4846c.m3131a();
    }

    /* renamed from: a */
    public static byte[] m3140a(byte[] bArr) {
        return m3139a(bArr, 0);
    }

    /* renamed from: a */
    public static byte[] m3139a(byte[] bArr, int i) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                m3143a(byteArrayInputStream, byteArrayOutputStream, i);
                return byteArrayOutputStream.toByteArray();
            } finally {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Unexpected I/O error", e);
        }
    }

    /* renamed from: b */
    public static String m3136b(String str) {
        try {
            return new String(m3134b(str.getBytes("ASCII")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII is not supported!", e);
        }
    }

    /* renamed from: b */
    public static String m3135b(String str, String str2) {
        try {
            try {
                return new String(m3134b(str.getBytes("ASCII")), str2);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(new StringBuffer().append("Unsupported charset: ").append(str2).toString(), e);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII is not supported!", e2);
        }
    }

    /* renamed from: b */
    public static void m3138b(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    m3137b(fileInputStream2, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th) {
                        }
                    }
                    if (fileInputStream2 == null) {
                        return;
                    }
                    try {
                        fileInputStream2.close();
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
            }
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
        }
    }

    /* renamed from: b */
    public static void m3137b(InputStream inputStream, OutputStream outputStream) {
        m3133c(new C4845b(inputStream), outputStream);
    }

    /* renamed from: b */
    public static byte[] m3134b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                m3137b(byteArrayInputStream, byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } finally {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Unexpected I/O error", e);
        }
    }

    /* renamed from: c */
    private static void m3133c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
