package it.p235a.p236a;

import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import com.fimi.soul.biz.camera.C2427e;
import java.net.InetSocketAddress;
import java.net.Socket;
/* renamed from: it.a.a.h */
/* loaded from: classes.dex */
public abstract class AbstractC4866h {

    /* renamed from: a */
    protected int f20823a;

    /* renamed from: b */
    protected int f20824b;

    /* renamed from: c */
    protected int f20825c;

    /* renamed from: d */
    private boolean f20826d;

    /* renamed from: e */
    private Socket f20827e;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC4866h() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC4866h(boolean z) {
        this.f20823a = 10;
        this.f20824b = 10;
        this.f20825c = 10;
        String property = System.getProperty(AbstractC4874p.f20845d);
        if ("true".equalsIgnoreCase(property) || C2427e.f8307cD.equalsIgnoreCase(property) || "1".equals(property)) {
            this.f20826d = true;
        } else if ("false".equalsIgnoreCase(property) || "no".equalsIgnoreCase(property) || "0".equals(property)) {
            this.f20826d = false;
        } else {
            this.f20826d = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Socket m3010a(String str, int i) {
        try {
            this.f20827e = new Socket();
            this.f20827e.setKeepAlive(true);
            this.f20827e.setSoTimeout(this.f20824b * 1000);
            this.f20827e.setSoLinger(true, this.f20825c);
            this.f20827e.connect(new InetSocketAddress(str, i), this.f20823a * 1000);
            return this.f20827e;
        } finally {
            this.f20827e = null;
        }
    }

    /* renamed from: a */
    public void m3011a(int i) {
        this.f20823a = i;
    }

    /* renamed from: a */
    public void m3009a(boolean z) {
        this.f20826d = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m3012a() {
        return this.f20826d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public Socket m3006b(String str, int i) {
        Socket socket = new Socket();
        socket.setSoTimeout(this.f20824b * 1000);
        socket.setSoLinger(true, this.f20825c);
        socket.setReceiveBufferSize(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        socket.setSendBufferSize(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        socket.connect(new InetSocketAddress(str, i), this.f20823a * 1000);
        return socket;
    }

    /* renamed from: b */
    public void m3008b() {
        if (this.f20827e != null) {
            try {
                this.f20827e.close();
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: b */
    public void m3007b(int i) {
        this.f20824b = i;
    }

    /* renamed from: c */
    public abstract Socket mo3004c(String str, int i);

    /* renamed from: c */
    public void m3005c(int i) {
        this.f20825c = i;
    }

    /* renamed from: d */
    public abstract Socket mo3003d(String str, int i);
}
