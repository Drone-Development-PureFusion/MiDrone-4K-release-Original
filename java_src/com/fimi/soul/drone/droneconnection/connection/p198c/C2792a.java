package com.fimi.soul.drone.droneconnection.connection.p198c;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.util.Log;
import com.fimi.soul.drone.droneconnection.connection.p198c.C2793b;
import com.hoho.android.usbserial.driver.CdcAcmSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialProber;
import java.io.IOException;
import java.lang.reflect.Array;
/* renamed from: com.fimi.soul.drone.droneconnection.connection.c.a */
/* loaded from: classes.dex */
class C2792a extends C2793b.AbstractC2795a {

    /* renamed from: g */
    private static final String f10337g = C2792a.class.getSimpleName();

    /* renamed from: h */
    private static UsbSerialDriver f10338h = null;

    /* renamed from: a */
    protected Context f10339a;

    /* renamed from: d */
    UsbDeviceConnection f10342d;

    /* renamed from: i */
    private UsbDevice f10343i = null;

    /* renamed from: b */
    UsbInterface[] f10340b = null;

    /* renamed from: c */
    UsbEndpoint[][] f10341c = (UsbEndpoint[][]) Array.newInstance(UsbEndpoint.class, 20, 20);

    /* JADX INFO: Access modifiers changed from: protected */
    public C2792a(Context context, int i) {
        super(context, i);
        this.f10339a = context;
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.p198c.C2793b.AbstractC2795a
    /* renamed from: a */
    protected int mo10983a(byte[] bArr) {
        try {
            int read = f10338h.read(bArr, 200);
            if (read != 0) {
                return read;
            }
            return -1;
        } catch (NullPointerException e) {
            String str = "Error Reading: " + e.getMessage() + "\nAssuming inaccessible USB device.  Closing connection.";
            Log.e(f10337g, str, e);
            throw new IOException(str, e);
        }
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.p198c.C2793b.AbstractC2795a
    /* renamed from: a */
    protected void mo10984a() {
        UsbManager usbManager = (UsbManager) this.f10351f.getSystemService("usb");
        f10338h = UsbSerialProber.findFirstDevice(usbManager);
        if (f10338h != null) {
            m10990a(f10338h);
            return;
        }
        if (usbManager != null) {
            for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
                this.f10343i = usbDevice;
                if (this.f10343i.getVendorId() == 1155 && this.f10343i.getProductId() == 22336) {
                    break;
                }
            }
        }
        if (this.f10343i != null && this.f10343i.getVendorId() == 1155 && this.f10343i.getProductId() == 22336) {
            this.f10340b = new UsbInterface[this.f10343i.getInterfaceCount()];
            for (int i = 0; i < this.f10343i.getInterfaceCount(); i++) {
                this.f10340b[i] = this.f10343i.getInterface(i);
                for (int i2 = 0; i2 < this.f10340b[i].getEndpointCount(); i2++) {
                    this.f10341c[i][i2] = this.f10340b[i].getEndpoint(i2);
                }
            }
            this.f10342d = usbManager.openDevice(this.f10343i);
        }
        if (this.f10342d != null) {
            f10338h = new CdcAcmSerialDriver(this.f10343i, this.f10342d);
        }
        if (f10338h == null) {
            return;
        }
        m10990a(f10338h);
    }

    /* renamed from: a */
    public void m10990a(UsbSerialDriver usbSerialDriver) {
        try {
            usbSerialDriver.open();
            usbSerialDriver.setParameters(this.f10350e, 8, 1, 0);
        } catch (IOException e) {
            if (usbSerialDriver != null) {
                usbSerialDriver.close();
            }
            throw new IOException();
        }
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.p198c.C2793b.AbstractC2795a
    /* renamed from: b */
    protected void mo10982b() {
        if (f10338h != null) {
            try {
                f10338h.close();
            } catch (IOException e) {
            }
            f10338h = null;
        }
    }

    @Override // com.fimi.soul.drone.droneconnection.connection.p198c.C2793b.AbstractC2795a
    /* renamed from: b */
    protected void mo10981b(byte[] bArr) {
        if (f10338h != null) {
            try {
                f10338h.write(bArr, 500);
            } catch (IOException e) {
                Log.e("USB", "Error Sending: " + e.getMessage(), e);
            }
        }
    }

    public String toString() {
        return f10337g;
    }
}
