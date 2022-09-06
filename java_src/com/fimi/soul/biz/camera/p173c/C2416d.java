package com.fimi.soul.biz.camera.p173c;

import android.util.Log;
import com.fimi.kernel.utils.C2258f;
import com.fimi.kernel.utils.C2276u;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.BaseX11Cmd;
import com.fimi.soul.biz.camera.entity.X11FileInfo;
import com.fimi.soul.biz.camera.entity.X11FileSystem;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.update.AbstractC2651g;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.utils.C3681j;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
/* renamed from: com.fimi.soul.biz.camera.c.d */
/* loaded from: classes.dex */
public class C2416d extends AbstractC2404a {

    /* renamed from: c */
    private static final String f8151c = C3681j.m7465n();

    /* renamed from: a */
    private AbstractC2651g f8152a;

    /* renamed from: b */
    private boolean f8153b;

    /* renamed from: com.fimi.soul.biz.camera.c.d$a */
    /* loaded from: classes.dex */
    public enum EnumC2419a {
        Thumb,
        IDR,
        FullView
    }

    public C2416d(AbstractC2390c abstractC2390c) {
        super(abstractC2390c);
    }

    /* renamed from: a */
    private void m12276a(X11FileSystem x11FileSystem, X11RespCmd x11RespCmd) {
        X11FileInfo curDownloadFile = x11FileSystem.getCurDownloadFile();
        if (curDownloadFile != null) {
            curDownloadFile.setMd5(x11RespCmd.getMd5sum());
            curDownloadFile.setSize(x11RespCmd.getSize());
            a().m12369a(curDownloadFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m12255h() {
        X11FileInfo curUploadFile = a().m12337l().getCurUploadFile();
        Log.d("Good", "发送文件" + curUploadFile);
        if (curUploadFile != null) {
            File file = new File(curUploadFile.getLocalPath());
            long length = file.length();
            this.f8153b = false;
            if (!file.exists()) {
                return;
            }
            long j = 0;
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        Log.d("Good", "发送完毕,总长度为:" + j);
                        a().m12337l().setCurDownloadFile(null);
                        fileInputStream.close();
                        return;
                    } else if (!this.f8153b) {
                        a(bArr, 0, read);
                        j += read;
                        if (this.f8152a != null) {
                            this.f8152a.mo6430a(j >= length, j, length, 0);
                        }
                    }
                }
            } catch (Exception e) {
                Log.d("Good", e.toString());
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m12277a(X11FileInfo x11FileInfo) {
        a().m12337l().setCurDownloadFile(x11FileInfo);
        a(C2427e.f8192V, x11FileInfo.getName());
    }

    /* renamed from: a */
    public void m12275a(AbstractC2651g abstractC2651g) {
        this.f8152a = abstractC2651g;
    }

    /* renamed from: a */
    public void m12274a(String str) {
        a(C2427e.f8190T, str);
    }

    /* renamed from: a */
    public void m12273a(String str, int i) {
        BaseX11Cmd b = b(C2427e.f8194X, str, null);
        b.setSent_size(i);
        a(b);
    }

    /* renamed from: a */
    public void m12272a(String str, EnumC2419a enumC2419a) {
        new X11FileInfo();
        m12271a(str, null, C2258f.m13020a(new Date(), C2258f.f7530e), enumC2419a);
    }

    /* renamed from: a */
    public void m12271a(String str, String str2, String str3, EnumC2419a enumC2419a) {
        String str4 = null;
        switch (enumC2419a) {
            case Thumb:
                str4 = "thumb";
                break;
            case FullView:
                str4 = "fullview";
                break;
            case IDR:
                str4 = "idr";
                break;
        }
        X11FileInfo x11FileInfo = new X11FileInfo();
        x11FileInfo.setName(str);
        x11FileInfo.setCreateDate(str3);
        x11FileInfo.setAbsolutePath(str2);
        a(C2427e.f8185O, str2, str4);
        x11FileInfo.setName(C2379b.m12408a(x11FileInfo));
        x11FileInfo.setLocalPath(f8151c);
        x11FileInfo.setRemotePath(a().m12337l().getCurPath());
        a().m12337l().setCurDownloadFile(x11FileInfo);
    }

    /* renamed from: a */
    public void m12270a(boolean z) {
        this.f8153b = z;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.fimi.soul.biz.camera.p173c.AbstractC2404a, com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        super.mo6450a(z, x11RespCmd);
        if (z) {
            X11FileSystem m12337l = a().m12337l();
            switch (x11RespCmd.getMsg_id()) {
                case C2427e.f8185O /* 1025 */:
                    m12276a(m12337l, x11RespCmd);
                    return;
                case C2427e.f8189S /* 1282 */:
                default:
                    return;
                case C2427e.f8190T /* 1283 */:
                case C2427e.f8191U /* 1284 */:
                    m12337l.setCurPath(x11RespCmd.getPwd());
                    return;
                case C2427e.f8192V /* 1285 */:
                    m12276a(m12337l, x11RespCmd);
                    return;
                case C2427e.f8193W /* 1286 */:
                    C2654j.m11357c("CMD_PUT_FILE:1286");
                    Log.i("msg=", "进入");
                    C2281x.m12704a(new Runnable() { // from class: com.fimi.soul.biz.camera.c.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C2416d.this.m12255h();
                        }
                    });
                    return;
            }
        }
    }

    /* renamed from: b */
    public void m12269b() {
        a(C2427e.f8191U);
    }

    /* renamed from: b */
    public void m12268b(int i) {
        if (i == 0) {
            m12261e();
        } else if (i != 1) {
        } else {
            a(253);
        }
    }

    /* renamed from: b */
    public void m12267b(String str) {
        a(C2427e.f8189S, String.format("%s -D -S", str));
    }

    /* renamed from: b */
    public void m12266b(String str, int i) {
        a(1027, str, i + "");
    }

    /* renamed from: c */
    public void m12265c() {
        m12274a("..");
    }

    /* renamed from: c */
    public void m12264c(String str) {
        a(C2427e.f8188R, str);
    }

    /* renamed from: d */
    public void m12263d() {
        m12274a(C2427e.f8321cR);
    }

    /* renamed from: d */
    public void m12262d(String str) {
        a(8, str);
    }

    /* renamed from: e */
    public void m12261e() {
        a(254);
    }

    /* renamed from: e */
    public void m12260e(String str) {
        X11FileInfo x11FileInfo = new X11FileInfo();
        x11FileInfo.setRemotePath(a().m12337l().getCurPath());
        if (x11FileInfo.getLocalPath() == null) {
            x11FileInfo.setLocalPath(f8151c);
        }
        x11FileInfo.setName(str);
        m12277a(x11FileInfo);
    }

    /* renamed from: f */
    public void m12259f() {
        String curPath = a().m12337l().getCurPath();
        if (curPath == null) {
            curPath = "";
        }
        m12267b(curPath);
    }

    /* renamed from: f */
    public void m12258f(String str) {
        a(C2427e.f8194X, str);
    }

    /* renamed from: g */
    public void m12256g(String str) {
        a(C2427e.f8186P, str);
    }

    /* renamed from: g */
    public boolean m12257g() {
        return this.f8153b;
    }

    /* renamed from: h */
    public void m12254h(String str) {
        BaseX11Cmd b = b(C2427e.f8193W, C2427e.f8323cT + "" + str.substring(str.lastIndexOf("/") + 1), null);
        File file = new File(str);
        String m12789a = C2276u.m12789a(file);
        long length = file.length();
        b.setMd5sum(m12789a);
        b.setSize(length);
        X11FileInfo x11FileInfo = new X11FileInfo();
        x11FileInfo.setLocalPath(str);
        x11FileInfo.setName(file.getName());
        a().m12337l().setCurUploadFile(x11FileInfo);
        a(b);
    }
}
