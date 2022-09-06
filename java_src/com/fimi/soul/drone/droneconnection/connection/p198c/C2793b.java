package com.fimi.soul.drone.droneconnection.connection.p198c;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.util.Log;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.drone.droneconnection.connection.AbstractC2777a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.fimi.soul.drone.droneconnection.connection.c.b */
/* loaded from: classes.dex */
public class C2793b extends AbstractC2777a {

    /* renamed from: j */
    private static final String f10344j = C2793b.class.getSimpleName();

    /* renamed from: k */
    private static final int f10345k = 1027;

    /* renamed from: i */
    protected int f10346i = 256000;

    /* renamed from: l */
    private AbstractC2795a f10347l;

    /* renamed from: com.fimi.soul.drone.droneconnection.connection.c.b$a */
    /* loaded from: classes.dex */
    static abstract class AbstractC2795a {

        /* renamed from: e */
        protected final int f10350e;

        /* renamed from: f */
        protected final Context f10351f;

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractC2795a(Context context, int i) {
            this.f10351f = context;
            this.f10350e = i;
        }

        /* renamed from: a */
        protected abstract int mo10983a(byte[] bArr);

        /* renamed from: a */
        protected abstract void mo10984a();

        /* renamed from: b */
        protected abstract void mo10982b();

        /* renamed from: b */
        protected abstract void mo10981b(byte[] bArr);
    }

    public C2793b(Context context) {
        super(context);
    }

    /* renamed from: a */
    private static boolean m10988a(Context context) {
        HashMap<String, UsbDevice> deviceList = ((UsbManager) context.getSystemService("usb")).getDeviceList();
        if (deviceList == null || deviceList.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, UsbDevice> entry : deviceList.entrySet()) {
            if (entry.getValue().getVendorId() == 1027) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2777a
    /* renamed from: a */
    protected int mo10986a(byte[] bArr) {
        if (this.f10347l == null) {
            throw new IOException("Uninitialized usb connection.");
        }
        return this.f10347l.mo10983a(bArr);
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2777a
    /* renamed from: a */
    protected void mo10989a() {
        if (this.f10347l != null) {
            this.f10347l.mo10982b();
        }
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2777a
    /* renamed from: b */
    protected void mo10985b() {
        if (this.f10347l != null) {
            try {
                this.f10347l.mo10984a();
                Log.d(f10344j, "Reusing previous usb connection.");
                return;
            } catch (IOException e) {
                Log.e(f10344j, "Previous usb connection is not usable.", e);
                this.f10347l = null;
            }
        }
        if (this.f10347l == null) {
            C2792a c2792a = new C2792a(this.f10290a, this.f10346i);
            c2792a.mo10984a();
            this.f10347l = c2792a;
            Log.d(f10344j, "Using open-source usb connection.");
        }
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: d */
    protected void mo10935d(final byte[] bArr) {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.drone.droneconnection.connection.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (C2793b.this.f10347l == null) {
                    return;
                }
                C2793b.this.f10347l.mo10981b(bArr);
            }
        });
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.AbstractC2799e
    /* renamed from: j */
    public int mo10926j() {
        return 1;
    }

    public String toString() {
        return this.f10347l == null ? f10344j : this.f10347l.toString();
    }
}
