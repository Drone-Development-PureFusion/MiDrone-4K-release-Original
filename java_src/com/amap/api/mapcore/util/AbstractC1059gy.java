package com.amap.api.mapcore.util;

import android.content.Context;
import com.tencent.stat.DeviceInfo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.amap.api.mapcore.util.gy */
/* loaded from: classes.dex */
public abstract class AbstractC1059gy extends AbstractC1075hd {

    /* renamed from: a */
    protected Context f3310a;

    /* renamed from: b */
    protected C0996fh f3311b;

    public AbstractC1059gy(Context context, C0996fh c0996fh) {
        if (context != null) {
            this.f3310a = context.getApplicationContext();
        }
        this.f3311b = c0996fh;
    }

    /* renamed from: m */
    private byte[] m17759m() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(C0999fi.m18047a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                C1002fl.m18028a(th2, "BinaryRequest", "getBinaryHead");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C1002fl.m18028a(th3, "BinaryRequest", "getBinaryHead");
                }
                return null;
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C1002fl.m18028a(th4, "BinaryRequest", "getBinaryHead");
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: n */
    private byte[] m17758n() {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] mo17765d = mo17765d();
            if (mo17765d == null || mo17765d.length == 0) {
                byteArrayOutputStream.write(new byte[]{0});
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(m17766a(mo17765d));
                byteArrayOutputStream.write(mo17765d);
                byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    byteArrayOutputStream = byteArrayOutputStream;
                } catch (Throwable th) {
                    C1002fl.m18028a(th, "BinaryRequest", "getRequestRawData");
                    byteArrayOutputStream = th;
                }
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                C1002fl.m18028a(th2, "BinaryRequest", "getRequestRawData");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C1002fl.m18028a(th3, "BinaryRequest", "getRequestRawData");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C1002fl.m18028a(th4, "BinaryRequest", "getRequestRawData");
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: o */
    private byte[] m17757o() {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] mo17764e = mo17764e();
            if (mo17764e == null || mo17764e.length == 0) {
                byteArrayOutputStream.write(new byte[]{0});
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] m18144a = C0986fb.m18144a(this.f3310a, mo17764e);
                byteArrayOutputStream.write(m17766a(m18144a));
                byteArrayOutputStream.write(m18144a);
                byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    byteArrayOutputStream = byteArrayOutputStream;
                } catch (Throwable th) {
                    C1002fl.m18028a(th, "BinaryRequest", "getRequestEncryptData");
                    byteArrayOutputStream = th;
                }
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                C1002fl.m18028a(th2, "BinaryRequest", "getRequestEncryptData");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C1002fl.m18028a(th3, "BinaryRequest", "getRequestEncryptData");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C1002fl.m18028a(th4, "BinaryRequest", "getRequestEncryptData");
                }
            }
        }
    }

    /* renamed from: a */
    protected byte[] m17766a(byte[] bArr) {
        int length = bArr.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: b */
    public Map<String, String> mo17699b() {
        String m18166f = C0976ey.m18166f(this.f3310a);
        String m18151a = C0986fb.m18151a();
        String m18146a = C0986fb.m18146a(this.f3310a, m18151a, "key=" + m18166f);
        HashMap hashMap = new HashMap();
        hashMap.put(DeviceInfo.TAG_TIMESTAMPS, m18151a);
        hashMap.put("key", m18166f);
        hashMap.put("scode", m18146a);
        return hashMap;
    }

    /* renamed from: d */
    public abstract byte[] mo17765d();

    /* renamed from: e */
    public abstract byte[] mo17764e();

    /* renamed from: f */
    protected String mo17763f() {
        return "2.1";
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: g */
    public final byte[] mo17696g() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(m17759m());
            byteArrayOutputStream.write(m17761i());
            byteArrayOutputStream.write(m17758n());
            byteArrayOutputStream.write(m17757o());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                C1002fl.m18028a(th2, "BinaryRequest", "getEntityBytes");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C1002fl.m18028a(th3, "BinaryRequest", "getEntityBytes");
                }
                return null;
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C1002fl.m18028a(th4, "BinaryRequest", "getEntityBytes");
                }
            }
        }
    }

    /* renamed from: h */
    public boolean m17762h() {
        return true;
    }

    /* renamed from: i */
    public byte[] m17761i() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (m17762h()) {
                byte[] m18145a = C0986fb.m18145a(this.f3310a, false);
                byteArrayOutputStream.write(m17766a(m18145a));
                byteArrayOutputStream.write(m18145a);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] m18047a = C0999fi.m18047a(mo17763f());
            if (m18047a == null || m18047a.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(m17766a(m18047a));
                byteArrayOutputStream.write(m18047a);
            }
            byte[] m18047a2 = C0999fi.m18047a(m17760j());
            if (m18047a2 == null || m18047a2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(m17766a(m18047a2));
                byteArrayOutputStream.write(m18047a2);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                return byteArray;
            } catch (Throwable th) {
                return byteArray;
            }
        } catch (Throwable th2) {
            try {
                C1002fl.m18028a(th2, "BinaryRequest", "getPublicData");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    C1002fl.m18028a(th3, "BinaryRequest", "getRequestEncryptData");
                }
                return new byte[]{0};
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    C1002fl.m18028a(th4, "BinaryRequest", "getRequestEncryptData");
                }
            }
        }
    }

    /* renamed from: j */
    public String m17760j() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.f3311b.m18068c(), this.f3311b.m18074a());
    }
}
