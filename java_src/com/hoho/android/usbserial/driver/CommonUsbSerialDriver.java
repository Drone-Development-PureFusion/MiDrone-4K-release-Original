package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
/* loaded from: classes.dex */
abstract class CommonUsbSerialDriver implements UsbSerialDriver {
    public static final int DEFAULT_READ_BUFFER_SIZE = 16384;
    public static final int DEFAULT_WRITE_BUFFER_SIZE = 16384;
    protected final UsbDeviceConnection mConnection;
    protected final UsbDevice mDevice;
    protected final Object mReadBufferLock = new Object();
    protected final Object mWriteBufferLock = new Object();
    protected byte[] mReadBuffer = new byte[16384];
    protected byte[] mWriteBuffer = new byte[16384];

    public CommonUsbSerialDriver(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        this.mDevice = usbDevice;
        this.mConnection = usbDeviceConnection;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract void close();

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract boolean getCD();

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract boolean getCTS();

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract boolean getDSR();

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract boolean getDTR();

    public final UsbDevice getDevice() {
        return this.mDevice;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract boolean getRI();

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract boolean getRTS();

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract void open();

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean purgeHwBuffers(boolean z, boolean z2) {
        return !z && !z2;
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract int read(byte[] bArr, int i);

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract void setDTR(boolean z);

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract void setParameters(int i, int i2, int i3, int i4);

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract void setRTS(boolean z);

    public final void setReadBufferSize(int i) {
        synchronized (this.mReadBufferLock) {
            if (i == this.mReadBuffer.length) {
                return;
            }
            this.mReadBuffer = new byte[i];
        }
    }

    public final void setWriteBufferSize(int i) {
        synchronized (this.mWriteBufferLock) {
            if (i == this.mWriteBuffer.length) {
                return;
            }
            this.mWriteBuffer = new byte[i];
        }
    }

    @Override // com.hoho.android.usbserial.driver.UsbSerialDriver
    public abstract int write(byte[] bArr, int i);
}
