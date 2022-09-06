package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.amap.api.services.core.C1211bk;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.services.core.bg */
/* loaded from: classes.dex */
abstract class AbstractC1207bg {

    /* renamed from: a */
    private C1211bk f4089a;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1207bg(Context context) {
        try {
            this.f4089a = m17160a(context, mo17163a());
        } catch (Throwable th) {
            C1190ay.m17177a(th, "LogProcessor", "LogUpDateProcessor");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static AbstractC1207bg m17161a(Context context, int i) {
        switch (i) {
            case 0:
                return new C1198bb(context);
            case 1:
                return new C1201bd(context);
            case 2:
                return new C1193az(context);
            default:
                return null;
        }
    }

    /* renamed from: a */
    private C1211bk m17160a(Context context, String str) {
        try {
            File file = new File(context.getFilesDir().getAbsolutePath() + C1204bf.f4079a + str);
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            return C1211bk.m17119a(file, 1, 1, 20480L);
        } catch (IOException e) {
            C1190ay.m17177a(e, "LogProcessor", "initDiskLru");
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            C1190ay.m17177a(th, "LogProcessor", "initDiskLru");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private String m17157a(List<C1177am> list, Context context) {
        boolean z;
        C1177am next;
        StringBuilder sb = new StringBuilder();
        sb.append("{\"pinfo\":\"").append(m17151c(context)).append("\",\"els\":[");
        boolean z2 = true;
        Iterator<C1177am> it2 = list.iterator();
        while (true) {
            z = z2;
            if (!it2.hasNext()) {
                break;
            }
            String m17150c = m17150c(it2.next().m17218b());
            if (m17150c != null && !"".equals(m17150c)) {
                String str = m17150c + "||" + next.m17214d();
                if (z) {
                    z = false;
                } else {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append("{\"log\":\"").append(str).append("\"}");
            }
            z2 = z;
        }
        if (z) {
            return null;
        }
        sb.append("]}");
        return sb.toString();
    }

    /* renamed from: a */
    private void m17159a(C1175ak c1175ak, int i) {
        try {
            m17156a(c1175ak.m17233a(2, i), c1175ak, i);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "LogProcessor", "processDeleteFail");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m17156a(List<C1177am> list, C1175ak c1175ak, int i) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (C1177am c1177am : list) {
            if (m17158a(c1177am.m17218b())) {
                c1175ak.m17230a(c1177am.m17218b(), i);
            } else {
                c1177am.m17220a(2);
                c1175ak.m17232a(c1177am, c1177am.m17221a());
            }
        }
    }

    /* renamed from: a */
    private boolean m17158a(String str) {
        if (this.f4089a == null) {
            return false;
        }
        try {
            return this.f4089a.m17110c(str);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private int m17153b(String str) {
        int i = 0;
        Log.i("yiyi.qi", str);
        try {
            byte[] m17055a = C1224bs.m17051a(false).m17055a(new C1208bh(C1169ae.m17245b(str.getBytes())));
            if (m17055a != null) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(m17055a));
                    if (jSONObject.has(XiaomiOAuthConstants.EXTRA_CODE_2)) {
                        i = jSONObject.getInt(XiaomiOAuthConstants.EXTRA_CODE_2);
                    }
                } catch (JSONException e) {
                    C1190ay.m17177a(e, "LogProcessor", "processUpdate");
                    e.printStackTrace();
                }
            }
        } catch (C1258v e2) {
            C1190ay.m17177a(e2, "LogProcessor", "processUpdate");
            e2.printStackTrace();
        }
        return i;
    }

    /* renamed from: c */
    private String m17151c(Context context) {
        try {
            String m16916a = C1261y.m16916a(context);
            if (!"".equals(m16916a)) {
                return C1261y.m16910b(context, m16916a.getBytes("UTF-8"));
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            C1190ay.m17177a(e, "LogProcessor", "getPublicInfo");
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            C1190ay.m17177a(th, "LogProcessor", "getPublicInfo");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private String m17150c(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Throwable th;
        String str2 = null;
        InputStream inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                if (this.f4089a == null) {
                    if (0 != 0) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e) {
                            C1190ay.m17177a(e, "LogProcessor", "readLog1");
                            e.printStackTrace();
                        }
                    }
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                            e = e2;
                            C1190ay.m17177a(e, "LogProcessor", "readLog2");
                            e.printStackTrace();
                            return str2;
                        }
                    }
                } else {
                    C1211bk.C1214b m17117a = this.f4089a.m17117a(str);
                    if (m17117a == null) {
                        if (0 != 0) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e3) {
                                C1190ay.m17177a(e3, "LogProcessor", "readLog1");
                                e3.printStackTrace();
                            }
                        }
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (IOException e4) {
                                e = e4;
                                C1190ay.m17177a(e, "LogProcessor", "readLog2");
                                e.printStackTrace();
                                return str2;
                            }
                        }
                    } else {
                        inputStream = m17117a.m17091a(0);
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                                str2 = byteArrayOutputStream.toString("utf-8");
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e5) {
                                        C1190ay.m17177a(e5, "LogProcessor", "readLog1");
                                        e5.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e6) {
                                        e = e6;
                                        C1190ay.m17177a(e, "LogProcessor", "readLog2");
                                        e.printStackTrace();
                                        return str2;
                                    }
                                }
                            } catch (IOException e7) {
                                e = e7;
                                C1190ay.m17177a(e, "LogProcessor", "readLog");
                                e.printStackTrace();
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e8) {
                                        C1190ay.m17177a(e8, "LogProcessor", "readLog1");
                                        e8.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e9) {
                                        e = e9;
                                        C1190ay.m17177a(e, "LogProcessor", "readLog2");
                                        e.printStackTrace();
                                        return str2;
                                    }
                                }
                                return str2;
                            } catch (Throwable th2) {
                                th = th2;
                                C1190ay.m17177a(th, "LogProcessor", "readLog");
                                th.printStackTrace();
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e10) {
                                        C1190ay.m17177a(e10, "LogProcessor", "readLog1");
                                        e10.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e11) {
                                        e = e11;
                                        C1190ay.m17177a(e, "LogProcessor", "readLog2");
                                        e.printStackTrace();
                                        return str2;
                                    }
                                }
                                return str2;
                            }
                        } catch (IOException e12) {
                            e = e12;
                            byteArrayOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = null;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e13) {
            e = e13;
            byteArrayOutputStream = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            inputStream = null;
        }
        return str2;
    }

    /* renamed from: a */
    protected abstract String mo17163a();

    /* renamed from: a */
    protected abstract boolean mo17162a(Context context);

    /* renamed from: b */
    protected abstract int mo17155b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m17154b(Context context) {
        try {
            if (!mo17162a(context)) {
                return;
            }
            synchronized (Looper.getMainLooper()) {
                C1175ak c1175ak = new C1175ak(context);
                m17159a(c1175ak, mo17155b());
                List<C1177am> m17233a = c1175ak.m17233a(0, mo17155b());
                if (m17233a == null || m17233a.size() == 0) {
                    return;
                }
                String m17157a = m17157a(m17233a, context);
                if (m17157a == null) {
                    return;
                }
                if (m17153b(m17157a) == 1) {
                    m17156a(m17233a, c1175ak, mo17155b());
                }
            }
        } catch (Throwable th) {
            C1190ay.m17177a(th, "LogProcessor", "processUpdateLog");
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m17152c() {
        if (this.f4089a == null || this.f4089a.m17126a()) {
            return;
        }
        try {
            this.f4089a.close();
        } catch (IOException e) {
            C1190ay.m17177a(e, "LogProcessor", "closeDiskLru");
            e.printStackTrace();
        } catch (Throwable th) {
            C1190ay.m17177a(th, "LogProcessor", "closeDiskLru");
            th.printStackTrace();
        }
    }
}
