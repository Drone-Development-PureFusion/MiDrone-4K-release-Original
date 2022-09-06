package com.fimi.soul.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3673c;
import com.fimi.soul.utils.C3681j;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Stack;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* loaded from: classes.dex */
public class CameraSocketService extends Service {

    /* renamed from: a */
    public static final int f14615a = 26112;

    /* renamed from: b */
    public static final int f14616b = 1200;

    /* renamed from: c */
    public static final int f14617c = 32;

    /* renamed from: d */
    public static final int f14618d = 1001;

    /* renamed from: e */
    public static final int f14619e = 2001;

    /* renamed from: f */
    public static final int f14620f = 0;

    /* renamed from: g */
    public static final int f14621g = 1;

    /* renamed from: h */
    public static final int f14622h = 2;

    /* renamed from: i */
    public static final int f14623i = 3;

    /* renamed from: j */
    public static final int f14624j = 4;

    /* renamed from: k */
    public static final int f14625k = 5;

    /* renamed from: l */
    public static final int f14626l = 7;

    /* renamed from: m */
    public static final int f14627m = 8;

    /* renamed from: n */
    public static final String f14628n = "/uDiskFile.txt";

    /* renamed from: s */
    private static final int f14629s = 3000;

    /* renamed from: y */
    private static Stack<Thread> f14630y = new Stack<>();

    /* renamed from: G */
    private WifiManager.MulticastLock f14637G;

    /* renamed from: p */
    private MulticastSocket f14646p;

    /* renamed from: r */
    private InetAddress f14648r;

    /* renamed from: q */
    private String f14647q = "224.0.0.1";

    /* renamed from: t */
    private String f14649t = null;

    /* renamed from: u */
    private boolean f14650u = false;

    /* renamed from: v */
    private boolean f14651v = false;

    /* renamed from: w */
    private boolean f14652w = false;

    /* renamed from: x */
    private String f14653x = null;

    /* renamed from: z */
    private Socket f14654z = null;

    /* renamed from: A */
    private DataInputStream f14631A = null;

    /* renamed from: B */
    private DataOutputStream f14632B = null;

    /* renamed from: C */
    private ServerSocket f14633C = null;

    /* renamed from: D */
    private Handler f14634D = new Handler();

    /* renamed from: E */
    private EnumC3596b f14635E = EnumC3596b.CAMERA;

    /* renamed from: F */
    private AbstractC3602h f14636F = null;

    /* renamed from: o */
    public BinderC3597c f14645o = new BinderC3597c();

    /* renamed from: H */
    private BroadcastReceiver f14638H = new BroadcastReceiver() { // from class: com.fimi.soul.service.CameraSocketService.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || !C3658ar.m7601b(context)) {
                return;
            }
            CameraSocketService.this.f14651v = false;
        }
    };

    /* renamed from: I */
    private final byte[] f14639I = {0, 102, 0, 0, -47, 7, 2, 0, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: J */
    private final byte[] f14640J = new byte[65];

    /* renamed from: K */
    private final byte[] f14641K = {0, 102, 1, 0, -47, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: L */
    private final byte[] f14642L = {0, 102, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: M */
    private final byte[] f14643M = {0, 102, 1, 0, 32, 0, 32, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: N */
    private final byte[] f14644N = {0, 102, 0, 0, -47, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: com.fimi.soul.service.CameraSocketService$a */
    /* loaded from: classes.dex */
    public class RunnableC3595a implements Runnable {
        public RunnableC3595a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    C2353b.m12509a("AcceptRunnable", CameraSocketService.class);
                    Socket accept = CameraSocketService.this.f14633C.accept();
                    if (CameraSocketService.this.f14631A != null) {
                        CameraSocketService.this.f14631A.close();
                        CameraSocketService.this.f14631A = null;
                    }
                    if (CameraSocketService.this.f14632B != null) {
                        CameraSocketService.this.f14632B.close();
                        CameraSocketService.this.f14632B = null;
                    }
                    if (CameraSocketService.this.f14654z != null) {
                        CameraSocketService.this.f14654z.close();
                        CameraSocketService.this.f14654z = null;
                    }
                    CameraSocketService.this.f14652w = true;
                    Thread thread = new Thread(new RunnableC3598d(accept));
                    thread.start();
                    CameraSocketService.f14630y.add(thread);
                    CameraSocketService.this.f14653x = accept.getInetAddress().getHostAddress();
                    C2353b.m12509a("initClientSocket=Connected=ServerIp=" + CameraSocketService.this.f14653x, CameraSocketService.class);
                    while (true) {
                        if (CameraSocketService.this.f14654z != null || CameraSocketService.this.f14653x == null) {
                            break;
                        }
                        try {
                            try {
                                try {
                                    Thread.sleep(500L);
                                    CameraSocketService.this.f14654z = new Socket(CameraSocketService.this.f14653x, (int) C3673c.f14893b);
                                    C2353b.m12509a("create Server Socket=" + CameraSocketService.this.f14654z, CameraSocketService.class);
                                } catch (UnknownHostException e) {
                                    e.printStackTrace();
                                }
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (InterruptedException e3) {
                            e3.printStackTrace();
                        }
                        if (CameraSocketService.this.f14654z != null) {
                            CameraSocketService.this.f14631A = new DataInputStream(CameraSocketService.this.f14654z.getInputStream());
                            CameraSocketService.this.f14632B = new DataOutputStream(CameraSocketService.this.f14654z.getOutputStream());
                            CameraSocketService.this.f14651v = true;
                            Thread thread2 = new Thread(new RunnableC3600f());
                            thread2.start();
                            CameraSocketService.f14630y.add(thread2);
                            CameraSocketService.this.m7875a(0, CameraSocketService.this.f14651v, CameraSocketService.this.f14653x);
                            break;
                        }
                    }
                    if (CameraSocketService.this.f14654z != null) {
                        CameraSocketService.this.m7865a(CameraSocketService.this.f14654z);
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.fimi.soul.service.CameraSocketService$b */
    /* loaded from: classes.dex */
    public enum EnumC3596b {
        U_DISK,
        CAMERA
    }

    /* renamed from: com.fimi.soul.service.CameraSocketService$c */
    /* loaded from: classes.dex */
    public class BinderC3597c extends Binder {
        public BinderC3597c() {
        }

        /* renamed from: a */
        public CameraSocketService m7840a() {
            return CameraSocketService.this;
        }
    }

    /* renamed from: com.fimi.soul.service.CameraSocketService$d */
    /* loaded from: classes.dex */
    public class RunnableC3598d implements Runnable {

        /* renamed from: b */
        private DataInputStream f14666b;

        public RunnableC3598d(Socket socket) {
            this.f14666b = null;
            try {
                this.f14666b = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[4096];
            while (true) {
                try {
                    int read = this.f14666b.read(bArr);
                    if (read == -1) {
                        return;
                    }
                    String str = new String(bArr, 0, read, "UTF-8");
                    if (str != null) {
                        CameraSocketService.this.m7875a(3, true, str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    /* renamed from: com.fimi.soul.service.CameraSocketService$e */
    /* loaded from: classes.dex */
    public class RunnableC3599e implements Runnable {
        public RunnableC3599e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3673c.m7502a(CameraSocketService.this.f14642L);
            byte[] bArr = new byte[28];
            byte[] bytes = C3658ar.m7581f(CameraSocketService.this).getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bArr[i] = bytes[i];
            }
            bArr[20] = 5;
            bArr[21] = -26;
            bArr[22] = 0;
            bArr[23] = 0;
            bArr[24] = 1;
            bArr[25] = 0;
            bArr[26] = 0;
            bArr[27] = 0;
            C3673c.m7502a(bArr);
            try {
                Thread.sleep(3000L);
                if (CameraSocketService.this.m7852g()) {
                    return;
                }
                CameraSocketService.this.m7875a(7, CameraSocketService.this.f14651v, "refuse connect");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.fimi.soul.service.CameraSocketService$f */
    /* loaded from: classes.dex */
    public class RunnableC3600f implements Runnable {
        public RunnableC3600f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (CameraSocketService.this.f14651v) {
                try {
                    Thread.sleep(AbstractC0517a.f1169e);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!CameraSocketService.this.f14650u) {
                    CameraSocketService.this.f14651v = false;
                    C3673c.m7507a(CameraSocketService.this.f14632B, CameraSocketService.this.f14643M);
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (!CameraSocketService.this.f14651v) {
                        CameraSocketService.this.m7875a(7, true, "HEARTBEATBROADCAST disConnect....");
                        CameraSocketService.this.m7856e();
                    }
                }
            }
        }
    }

    /* renamed from: com.fimi.soul.service.CameraSocketService$g */
    /* loaded from: classes.dex */
    public class RunnableC3601g implements Runnable {
        public RunnableC3601g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 1024);
            while (true) {
                try {
                    CameraSocketService.this.f14637G.acquire();
                    CameraSocketService.this.f14646p.receive(datagramPacket);
                    CameraSocketService.this.m7875a(-1, true, new String(bArr, 0, datagramPacket.getLength()) + datagramPacket.getAddress().getHostAddress());
                    CameraSocketService.this.f14637G.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.fimi.soul.service.CameraSocketService$h */
    /* loaded from: classes.dex */
    public interface AbstractC3602h {
        /* renamed from: a */
        void m7839a(int i, boolean z, String str);
    }

    /* renamed from: a */
    private void m7867a(DataInputStream dataInputStream) {
        boolean z = false;
        byte[] bArr = new byte[68];
        try {
            if (dataInputStream.read(bArr) == -1) {
                return;
            }
            long m7500b = C3673c.m7500b(bArr, 64);
            if (m7500b <= 0) {
                return;
            }
            File file = new File(C3681j.m7469j());
            if (!file.exists()) {
                file.mkdir();
            }
            String str = C3681j.m7467l() + this.f14649t;
            if (f14628n.equalsIgnoreCase(this.f14649t)) {
                str = C3681j.m7469j() + this.f14649t;
            } else {
                z = true;
            }
            try {
                C3673c.m7507a(this.f14632B, this.f14641K);
                this.f14650u = true;
                C3673c.m7504a(str, m7500b, dataInputStream, this, z);
                this.f14650u = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006d, code lost:
        r9.f14651v = false;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m7865a(Socket socket) {
        int i = 0;
        byte[] bArr = new byte[1024];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                try {
                    if (this.f14631A == null || this.f14631A.read(bArr) == -1) {
                        break;
                    }
                    this.f14651v = true;
                    if (26112 == C3673c.m7501a(bArr, 0)) {
                        i = C3673c.m7501a(bArr, 2);
                        i3 = C3673c.m7501a(bArr, 4);
                        i2 = C3673c.m7501a(bArr, 6);
                        C2353b.m12509a("mCurMsgType =" + i3, getClass());
                    }
                    if (i3 == 1200) {
                        m7867a(this.f14631A);
                    } else if (i3 == 2001) {
                        continue;
                    } else if (i3 == 1001) {
                        if (i != 1) {
                            m7875a(2, false, null);
                        } else if (i2 == 7) {
                            break;
                        } else if (i2 == 2) {
                            m7875a(2, true, this.f14649t);
                            this.f14649t = null;
                        }
                    } else if (i3 == 32) {
                        m7875a(i3, true, "connected");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (socket == null) {
                        return;
                    }
                    try {
                        socket.close();
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            } catch (Throwable th) {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* renamed from: i */
    private void m7848i() {
        try {
            this.f14646p = new MulticastSocket((int) C3673c.f14892a);
            this.f14648r = InetAddress.getByName(this.f14647q);
            this.f14646p.joinGroup(this.f14648r);
            Thread thread = new Thread(new RunnableC3601g());
            thread.start();
            f14630y.add(thread);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    private void m7846j() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f14638H, intentFilter);
    }

    /* renamed from: k */
    private void m7844k() {
        if (!this.f14652w) {
            try {
                this.f14633C = new ServerSocket(C3673c.f14893b);
                new Thread(new RunnableC3595a()).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        C2353b.m12509a("startSocketServer " + this.f14652w, CameraSocketService.class);
    }

    /* renamed from: l */
    private void m7842l() {
        C3673c.m7507a(this.f14632B, this.f14644N);
    }

    /* renamed from: a */
    public void m7876a() {
        if (!this.f14651v) {
            m7875a(7, this.f14651v, "disConnect..");
            return;
        }
        this.f14649t = f14628n;
        C3673c.m7507a(this.f14632B, this.f14639I);
        this.f14640J[0] = 0;
        C3673c.m7507a(this.f14632B, this.f14640J);
        this.f14635E = EnumC3596b.U_DISK;
    }

    /* renamed from: a */
    public void m7875a(final int i, final boolean z, final String str) {
        this.f14634D.post(new Runnable() { // from class: com.fimi.soul.service.CameraSocketService.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameraSocketService.this.f14636F != null) {
                    CameraSocketService.this.f14636F.m7839a(i, z, str);
                }
            }
        });
    }

    /* renamed from: a */
    public void m7874a(AbstractC3602h abstractC3602h) {
        this.f14636F = abstractC3602h;
        this.f14636F.m7839a(8, m7852g(), "chanager state");
    }

    /* renamed from: a */
    public void m7866a(String str, String str2) {
        if (this.f14635E == EnumC3596b.CAMERA) {
            m7875a(5, this.f14651v, "error mode..");
        } else if (!this.f14651v) {
            m7875a(7, this.f14651v, "disConnect..");
        } else {
            this.f14649t = str;
            C3673c.m7507a(this.f14632B, this.f14639I);
            byte[] bArr = new byte[65];
            bArr[0] = 2;
            byte[] bytes = str2.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                if (i + 1 < bArr.length) {
                    bArr[i + 1] = bytes[i];
                }
            }
            C3673c.m7507a(this.f14632B, bArr);
        }
    }

    /* renamed from: b */
    public void m7864b() {
        if (this.f14651v && this.f14635E != EnumC3596b.CAMERA) {
            C3673c.m7507a(this.f14632B, this.f14639I);
            this.f14640J[0] = 1;
            C3673c.m7507a(this.f14632B, this.f14640J);
            this.f14635E = EnumC3596b.CAMERA;
        }
        if (!this.f14651v) {
            m7875a(7, this.f14651v, "disConnect..");
        } else if (this.f14635E != EnumC3596b.CAMERA) {
        } else {
            m7875a(0, this.f14651v, "Connected..");
        }
    }

    /* renamed from: c */
    public EnumC3596b m7860c() {
        return this.f14635E;
    }

    /* renamed from: d */
    public void m7858d() {
        C2353b.m12509a("stopSocketServer", CameraSocketService.class);
        if (this.f14652w && this.f14633C != null) {
            try {
                this.f14652w = false;
                if (this.f14654z != null && !this.f14654z.isClosed()) {
                    this.f14654z.close();
                    this.f14654z = null;
                }
                if (this.f14632B != null) {
                    this.f14632B.close();
                    this.f14632B = null;
                }
                this.f14633C.close();
                this.f14633C = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int size = f14630y.size();
        for (int i = 0; i < size; i++) {
            if (f14630y.get(i) != null && !f14630y.get(i).isInterrupted()) {
                f14630y.get(i).interrupt();
            }
        }
        f14630y.clear();
        if (m7852g()) {
            m7842l();
        }
    }

    /* renamed from: e */
    public void m7856e() {
        Thread thread = new Thread(new RunnableC3599e());
        thread.start();
        f14630y.add(thread);
    }

    /* renamed from: f */
    public String m7854f() {
        return this.f14653x;
    }

    /* renamed from: g */
    public boolean m7852g() {
        return this.f14651v;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f14645o;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C2353b.m12509a("onCreate", CameraSocketService.class);
        this.f14637G = ((WifiManager) getSystemService("wifi")).createMulticastLock("multicastLock");
        m7844k();
        m7848i();
        m7846j();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m7858d();
        unregisterReceiver(this.f14638H);
    }
}
