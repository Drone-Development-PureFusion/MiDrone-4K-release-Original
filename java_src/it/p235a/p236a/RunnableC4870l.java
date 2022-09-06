package it.p235a.p236a;

import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
/* renamed from: it.a.a.l */
/* loaded from: classes.dex */
class RunnableC4870l implements AbstractC4867i, Runnable {

    /* renamed from: a */
    private ServerSocket f20828a;

    /* renamed from: b */
    private Socket f20829b;

    /* renamed from: c */
    private IOException f20830c;

    /* renamed from: d */
    private Thread f20831d;

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RunnableC4870l() {
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        boolean z4 = false;
        this.f20828a = null;
        String property = System.getProperty(AbstractC4874p.f20842a);
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (stringTokenizer.countTokens() == 2) {
                String nextToken = stringTokenizer.nextToken();
                String nextToken2 = stringTokenizer.nextToken();
                try {
                    i4 = Integer.parseInt(nextToken);
                } catch (NumberFormatException e) {
                    i4 = 0;
                }
                try {
                    i3 = Integer.parseInt(nextToken2);
                } catch (NumberFormatException e2) {
                    i3 = 0;
                }
                if (i4 > 0 && i3 > 0 && i3 >= i4) {
                    z3 = true;
                    z = true;
                    if (!z3) {
                        System.err.println(new StringBuffer().append("WARNING: invalid value \"").append(property).append("\" for the ").append(AbstractC4874p.f20842a).append(" system property. The value should ").append("be in the start-stop form, with ").append("start > 0, stop > 0 and start <= stop.").toString());
                    }
                    int i5 = i3;
                    i2 = i4;
                    i = i5;
                }
            }
            z3 = false;
            i3 = 0;
            i4 = 0;
            z = false;
            if (!z3) {
            }
            int i52 = i3;
            i2 = i4;
            i = i52;
        } else {
            i = 0;
            i2 = 0;
            z = false;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            while (i2 <= i) {
                arrayList.add(new Integer(i2));
                i2++;
            }
            while (!z4) {
                int size = arrayList.size();
                if (size <= 0) {
                    break;
                }
                int intValue = ((Integer) arrayList.remove((int) Math.floor(Math.random() * size))).intValue();
                try {
                    this.f20828a = new ServerSocket();
                    this.f20828a.setReceiveBufferSize(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
                    this.f20828a.bind(new InetSocketAddress(intValue));
                    z2 = true;
                } catch (IOException e3) {
                    z2 = z4;
                }
                z4 = z2;
            }
            if (!z4) {
                throw new C4868j(new StringBuffer().append("Cannot open the ServerSocket. No available port found in range ").append(property).toString());
            }
        } else {
            try {
                this.f20828a = new ServerSocket();
                this.f20828a.setReceiveBufferSize(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
                this.f20828a.bind(new InetSocketAddress(0));
            } catch (IOException e4) {
                throw new C4868j("Cannot open the ServerSocket", e4);
            }
        }
        this.f20831d = new Thread(this);
        this.f20831d.start();
    }

    @Override // it.p235a.p236a.AbstractC4867i
    /* renamed from: a */
    public Socket mo2997a() {
        if (this.f20829b == null && this.f20830c == null) {
            try {
                this.f20831d.join();
            } catch (Exception e) {
            }
        }
        if (this.f20830c != null) {
            throw new C4868j("Cannot receive the incoming connection", this.f20830c);
        }
        if (this.f20829b != null) {
            return this.f20829b;
        }
        throw new C4868j("No socket available");
    }

    @Override // it.p235a.p236a.AbstractC4867i
    /* renamed from: b */
    public void mo2996b() {
        if (this.f20828a != null) {
            try {
                this.f20828a.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: c */
    public int m2995c() {
        return this.f20828a.getLocalPort();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2 = 30000;
        String property = System.getProperty(AbstractC4874p.f20844c);
        if (property != null) {
            boolean z = false;
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                i = -1;
            }
            if (i >= 0) {
                z = true;
                i2 = i;
            }
            if (!z) {
                System.err.println(new StringBuffer().append("WARNING: invalid value \"").append(property).append("\" for the ").append(AbstractC4874p.f20844c).append(" system property. The value should ").append("be an integer greater or equal to 0.").toString());
            }
        }
        try {
            try {
                this.f20828a.setSoTimeout(i2);
                this.f20829b = this.f20828a.accept();
                this.f20829b.setSendBufferSize(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            } catch (IOException e2) {
                this.f20830c = e2;
                try {
                    this.f20828a.close();
                } catch (IOException e3) {
                }
            }
        } finally {
            try {
                this.f20828a.close();
            } catch (IOException e4) {
            }
        }
    }
}
