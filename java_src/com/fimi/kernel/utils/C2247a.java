package com.fimi.kernel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p004b.p005a.p006a.p028b.p041h.p043b.AbstractC0383e;
/* renamed from: com.fimi.kernel.utils.a */
/* loaded from: classes.dex */
public class C2247a {

    /* renamed from: a */
    private static int f7504a = 128;

    /* renamed from: b */
    private static String f7505b = "AES";

    /* renamed from: a */
    public static boolean m13086a(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        byte[] m13085a;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        boolean z = true;
        try {
            try {
                File file = new File(str2);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[(int) file.length()];
                    fileInputStream.read(bArr);
                    m13085a = m13085a(str, bArr);
                    fileOutputStream = new FileOutputStream(str3);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileOutputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (IOException e2) {
                    e = e2;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(m13085a);
                if (fileInputStream != null && fileOutputStream != null) {
                    try {
                        fileInputStream.close();
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    if (fileInputStream2 != null && fileOutputStream != null) {
                        try {
                            fileInputStream2.close();
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileInputStream != null && fileOutputStream2 != null) {
                        try {
                            fileInputStream.close();
                            fileOutputStream2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileInputStream != null && fileOutputStream2 != null) {
                    try {
                        fileInputStream.close();
                        fileOutputStream2.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        z = false;
                    }
                }
                z = false;
                return z;
            } catch (Exception e10) {
                e = e10;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileInputStream != null && fileOutputStream2 != null) {
                    try {
                        fileInputStream.close();
                        fileOutputStream2.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        z = false;
                    }
                }
                z = false;
                return z;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                if (fileInputStream != null) {
                    fileInputStream.close();
                    fileOutputStream2.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e12) {
            e = e12;
            fileOutputStream = null;
        } catch (IOException e13) {
            e = e13;
            fileInputStream = null;
        } catch (Exception e14) {
            e = e14;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
        return z;
    }

    /* renamed from: a */
    public static byte[] m13085a(String str, byte[] bArr) {
        return m13083a(m13084a(str.getBytes()), bArr);
    }

    /* renamed from: a */
    private static byte[] m13084a(byte[] bArr) {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(f7505b);
        SecureRandom secureRandom = SecureRandom.getInstance(AbstractC0383e.f796d, "Crypto");
        secureRandom.setSeed(bArr);
        keyGenerator.init(f7504a, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }

    /* renamed from: a */
    private static byte[] m13083a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f7505b);
        Cipher cipher = Cipher.getInstance(f7505b);
        cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }

    /* renamed from: b */
    public static boolean m13082b(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        byte[] m13081b;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        boolean z = true;
        try {
            try {
                File file = new File(str2);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[(int) file.length()];
                    fileInputStream.read(bArr);
                    m13081b = m13081b(str, bArr);
                    fileOutputStream = new FileOutputStream(str3);
                } catch (FileNotFoundException e) {
                    e = e;
                    fileOutputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (IOException e2) {
                    e = e2;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(m13081b);
                if (fileInputStream != null && fileOutputStream != null) {
                    try {
                        fileInputStream.close();
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    if (fileInputStream2 != null && fileOutputStream != null) {
                        try {
                            fileInputStream2.close();
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileInputStream != null && fileOutputStream2 != null) {
                        try {
                            fileInputStream.close();
                            fileOutputStream2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileInputStream != null && fileOutputStream2 != null) {
                    try {
                        fileInputStream.close();
                        fileOutputStream2.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        z = false;
                    }
                }
                z = false;
                return z;
            } catch (Exception e10) {
                e = e10;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileInputStream != null && fileOutputStream2 != null) {
                    try {
                        fileInputStream.close();
                        fileOutputStream2.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        z = false;
                    }
                }
                z = false;
                return z;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                if (fileInputStream != null) {
                    fileInputStream.close();
                    fileOutputStream2.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e12) {
            e = e12;
            fileOutputStream = null;
        } catch (IOException e13) {
            e = e13;
            fileInputStream = null;
        } catch (Exception e14) {
            e = e14;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
        return z;
    }

    /* renamed from: b */
    public static byte[] m13081b(String str, byte[] bArr) {
        return m13080b(m13084a(str.getBytes()), bArr);
    }

    /* renamed from: b */
    private static byte[] m13080b(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f7505b);
        Cipher cipher = Cipher.getInstance(f7505b);
        cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }
}
