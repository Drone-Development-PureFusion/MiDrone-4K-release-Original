package com.fimi.soul.biz.update;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.fimi.kernel.AbstractC2180b;
import com.fimi.kernel.C2238c;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.utils.C3681j;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* renamed from: com.fimi.soul.biz.update.b */
/* loaded from: classes.dex */
public abstract class AbstractC2636b extends AbstractC2180b {

    /* renamed from: a */
    protected static final int f9125a = 9898;

    /* renamed from: b */
    public static boolean f9126b = false;

    /* renamed from: c */
    public static boolean f9127c = false;

    /* renamed from: d */
    public static final int f9128d = -1;

    /* renamed from: e */
    public static final int f9129e = -2;

    /* renamed from: f */
    private AbstractC2651g f9130f;

    /* renamed from: g */
    private long f9131g;

    /* renamed from: h */
    private UpdateVersonBean f9132h;

    /* renamed from: i */
    private UpdateVersonBean f9133i;

    /* renamed from: j */
    private Gson f9134j = new Gson();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11426a(int i, int i2, int i3) {
        Message message = new Message();
        message.what = f9125a;
        message.arg1 = i;
        message.arg2 = i2;
        Bundle bundle = new Bundle();
        bundle.putInt("arg3", i3);
        message.setData(bundle);
        a().sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.kernel.AbstractC2180b
    /* renamed from: a */
    public void mo9399a(Message message) {
        boolean z = true;
        if (message.what == f9125a) {
            if (message.arg1 != 1) {
                z = false;
            }
            this.f9130f.mo6430a(z, message.arg2, this.f9131g, message.getData().getInt("arg3"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m11423a(UpdateVersonBean updateVersonBean) {
        this.f9133i = updateVersonBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m11422a(final UpdateVersonBean updateVersonBean, final String str, AbstractC2651g abstractC2651g) {
        this.f9130f = abstractC2651g;
        Log.d("moweiru", "downloadFile");
        a(new Runnable() { // from class: com.fimi.soul.biz.update.b.1
            /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
                r8.f9137c.m11426a(1, 0, r2.getSysid());
             */
            /* JADX WARN: Removed duplicated region for block: B:83:0x00eb A[Catch: Exception -> 0x00f2, TRY_LEAVE, TryCatch #10 {Exception -> 0x00f2, blocks: (B:89:0x00e6, B:83:0x00eb), top: B:88:0x00e6 }] */
            /* JADX WARN: Removed duplicated region for block: B:88:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                InputStream inputStream;
                FileOutputStream fileOutputStream;
                FileOutputStream fileOutputStream2;
                FileOutputStream fileOutputStream3 = null;
                fileOutputStream3 = null;
                InputStream inputStream2 = null;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(updateVersonBean.getUrl()).openConnection();
                    httpURLConnection.setConnectTimeout(50000);
                    httpURLConnection.setReadTimeout(100000);
                    httpURLConnection.setRequestMethod("GET");
                    File file = new File(str);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            fileOutputStream2 = new FileOutputStream(file);
                            try {
                                AbstractC2636b.this.f9131g = httpURLConnection.getContentLength();
                                byte[] bArr = new byte[2048];
                                int i = 0;
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else if (AbstractC2636b.f9127c) {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                return;
                                            }
                                        }
                                        if (fileOutputStream2 == null) {
                                            return;
                                        }
                                        fileOutputStream2.flush();
                                        fileOutputStream2.close();
                                        return;
                                    } else if (AbstractC2636b.f9126b) {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                                return;
                                            }
                                        }
                                        if (fileOutputStream2 == null) {
                                            return;
                                        }
                                        fileOutputStream2.flush();
                                        fileOutputStream2.close();
                                        return;
                                    } else {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i += read;
                                        AbstractC2636b.this.m11426a(0, i, updateVersonBean.getSysid());
                                    }
                                }
                            } catch (Exception e3) {
                                fileOutputStream = fileOutputStream2;
                                inputStream2 = inputStream;
                                try {
                                    if (!AbstractC2636b.f9126b) {
                                        AbstractC2636b.this.m11426a(1, -2, updateVersonBean.getSysid());
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                            return;
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        return;
                                    }
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    return;
                                } catch (Throwable th) {
                                    inputStream = inputStream2;
                                    fileOutputStream3 = fileOutputStream;
                                    th = th;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (fileOutputStream3 != null) {
                                        fileOutputStream3.flush();
                                        fileOutputStream3.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream3 = fileOutputStream2;
                                if (inputStream != null) {
                                }
                                if (fileOutputStream3 != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e6) {
                            fileOutputStream = null;
                            inputStream2 = inputStream;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } else {
                        fileOutputStream2 = null;
                        inputStream = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            return;
                        }
                    }
                    if (fileOutputStream2 == null) {
                        return;
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (Exception e8) {
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            }
        });
    }

    /* renamed from: b */
    protected void m11421b(UpdateVersonBean updateVersonBean) {
        this.f9132h = updateVersonBean;
    }

    /* renamed from: c */
    protected void m11420c(UpdateVersonBean updateVersonBean) {
        if (updateVersonBean != null) {
            this.f9132h = updateVersonBean;
            C2238c.m13125c().mo13117a(getClass().toString(), updateVersonBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public String m11419d(UpdateVersonBean updateVersonBean) {
        String str = "";
        int sysid = updateVersonBean.getSysid();
        if (sysid == 0) {
            str = C3587b.f14535D;
        } else if (sysid == 3) {
            str = C3587b.f14538G;
        } else if (sysid == 1) {
            str = C3587b.f14536E;
        } else if (sysid == 2) {
            str = C3587b.f14537F;
        } else if (sysid == 10) {
            str = C3587b.f14539H;
        } else if (sysid == 9) {
            str = C3587b.f14541J;
        } else if (sysid == 6) {
            str = C3587b.f14540I;
        } else if (sysid == 4) {
            str = "firmware.zip";
        } else if (sysid == 11) {
            str = C2654j.m11367a(updateVersonBean.getFileEncode());
        } else if (sysid == 15) {
            str = C2654j.m11366a(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion() + "");
        } else if (sysid == 26) {
            str = C2654j.m11361b(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion() + "");
        } else if (sysid == 14) {
            str = C2654j.m11356c(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion() + "");
        } else if (sysid == 25) {
            str = C2654j.m11352d(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion() + "");
        } else if (sysid == 17) {
            str = C3587b.f14554W;
        } else if (sysid == 16) {
            str = C3587b.f14555X;
        } else if (sysid == 12) {
            str = C3587b.f14556Y;
        } else if (sysid == 13) {
            str = C3587b.f14557Z;
        } else if (sysid == 18) {
            str = C3587b.f14548Q;
        } else if (sysid == 19) {
            str = C3587b.f14549R;
        } else if (sysid == 20) {
            str = C3587b.f14550S;
        } else if (sysid == 253) {
            str = C3587b.f14552U;
        } else if (sysid == 5) {
            str = C3587b.f14551T;
        } else if (sysid == 23) {
            str = C3587b.f14559aa;
        } else if (sysid == 24) {
            str = C3587b.f14553V;
        } else if (sysid == 27) {
            str = C3587b.f14533B;
        }
        return C3681j.m7457v() + str;
    }

    /* renamed from: g */
    protected Gson m11418g() {
        return this.f9134j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public UpdateVersonBean m11417h() {
        return this.f9133i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public UpdateVersonBean m11416i() {
        return this.f9132h;
    }

    /* renamed from: j */
    public UpdateVersonBean m11415j() {
        if (this.f9132h == null) {
            this.f9132h = (UpdateVersonBean) C2238c.m13125c().mo13118a(getClass().toString(), UpdateVersonBean.class);
        }
        if (this.f9132h == null) {
            this.f9132h = new UpdateVersonBean();
        }
        return this.f9132h;
    }
}
