package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Log;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.fimi.kernel.C2172a;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class Cp2102SerialDriver extends CommonUsbSerialDriver {
    private static final int BAUD_RATE_GEN_FREQ = 3686400;
    private static final int CONTROL_WRITE_DTR = 256;
    private static final int CONTROL_WRITE_RTS = 512;
    private static final int DEFAULT_BAUD_RATE = 9600;
    private static final int FLUSH_READ_CODE = 10;
    private static final int FLUSH_WRITE_CODE = 5;
    private static final int MCR_ALL = 3;
    private static final int MCR_DTR = 1;
    private static final int MCR_RTS = 2;
    private static final int REQTYPE_HOST_TO_DEVICE = 65;
    private static final int SILABSER_FLUSH_REQUEST_CODE = 18;
    private static final int SILABSER_IFC_ENABLE_REQUEST_CODE = 0;
    private static final int SILABSER_SET_BAUDDIV_REQUEST_CODE = 1;
    private static final int SILABSER_SET_BAUDRATE = 30;
    private static final int SILABSER_SET_LINE_CTL_REQUEST_CODE = 3;
    private static final int SILABSER_SET_MHS_REQUEST_CODE = 7;
    private static final String TAG = Cp2102SerialDriver.class.getSimpleName();
    private static final int UART_DISABLE = 0;
    private static final int UART_ENABLE = 1;
    private static final int USB_WRITE_TIMEOUT_MILLIS = 5000;
    private UsbEndpoint mReadEndpoint;
    private UsbEndpoint mWriteEndpoint;

    public Cp2102SerialDriver(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        super(usbDevice, usbDeviceConnection);
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Integer.valueOf((int) UsbId.VENDOR_SILAB), new int[]{60000});
        return linkedHashMap;
    }

    private void setBaudRate(int i) {
        if (this.mConnection.controlTransfer(65, 30, 0, 0, new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)}, 4, 5000) < 0) {
            throw new IOException("Error setting baud rate.");
        }
    }

    private int setConfigSingle(int i, int i2) {
        return this.mConnection.controlTransfer(65, i, i2, 0, null, 0, 5000);
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public void close() {
        setConfigSingle(0, 0);
        this.mConnection.close();
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean getCD() {
        return false;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean getCTS() {
        return false;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean getDSR() {
        return false;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean getDTR() {
        return true;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean getRI() {
        return false;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean getRTS() {
        return true;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public void open() {
        for (int i = 0; i < this.mDevice.getInterfaceCount(); i++) {
            try {
                if (this.mConnection.claimInterface(this.mDevice.getInterface(i), true)) {
                    Log.d(TAG, "claimInterface " + i + " SUCCESS");
                } else {
                    Log.d(TAG, "claimInterface " + i + " FAIL");
                }
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
        UsbInterface usbInterface = this.mDevice.getInterface(this.mDevice.getInterfaceCount() - 1);
        for (int i2 = 0; i2 < usbInterface.getEndpointCount(); i2++) {
            UsbEndpoint endpoint = usbInterface.getEndpoint(i2);
            if (endpoint.getType() == 2) {
                if (endpoint.getDirection() == 128) {
                    this.mReadEndpoint = endpoint;
                } else {
                    this.mWriteEndpoint = endpoint;
                }
            }
        }
        setConfigSingle(0, 1);
        setConfigSingle(7, 771);
        setConfigSingle(1, BitmapCounterProvider.MAX_BITMAP_COUNT);
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean purgeHwBuffers(boolean z, boolean z2) {
        int i = 0;
        int i2 = z ? 10 : 0;
        if (z2) {
            i = 5;
        }
        int i3 = i | i2;
        if (i3 != 0) {
            setConfigSingle(18, i3);
            return true;
        }
        return true;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public int read(byte[] bArr, int i) {
        synchronized (this.mReadBufferLock) {
            int bulkTransfer = this.mConnection.bulkTransfer(this.mReadEndpoint, this.mReadBuffer, Math.min(bArr.length, this.mReadBuffer.length), i);
            if (bulkTransfer < 0) {
                return 0;
            }
            System.arraycopy(this.mReadBuffer, 0, bArr, 0, bulkTransfer);
            return bulkTransfer;
        }
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public void setDTR(boolean z) {
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public void setParameters(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 2048;
        int i7 = 0;
        setBaudRate(i);
        switch (i2) {
            case 5:
                i6 = C2172a.f7290f;
                break;
            case 6:
                i6 = 1536;
                break;
            case 7:
                i6 = 1792;
                break;
        }
        setConfigSingle(3, i6);
        switch (i4) {
            case 1:
                i5 = 16;
                break;
            case 2:
                i5 = 32;
                break;
            default:
                i5 = 0;
                break;
        }
        setConfigSingle(3, i5);
        switch (i3) {
            case 2:
                i7 = 2;
                break;
        }
        setConfigSingle(3, i7);
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public void setRTS(boolean z) {
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public int write(byte[] bArr, int i) {
        int min;
        byte[] bArr2;
        int bulkTransfer;
        int i2 = 0;
        while (i2 < bArr.length) {
            synchronized (this.mWriteBufferLock) {
                min = Math.min(bArr.length - i2, this.mWriteBuffer.length);
                if (i2 == 0) {
                    bArr2 = bArr;
                } else {
                    System.arraycopy(bArr, i2, this.mWriteBuffer, 0, min);
                    bArr2 = this.mWriteBuffer;
                }
                bulkTransfer = this.mConnection.bulkTransfer(this.mWriteEndpoint, bArr2, min, i);
            }
            if (bulkTransfer <= 0) {
                throw new IOException("Error writing " + min + " bytes at offset " + i2 + " length=" + bArr.length);
            }
            Log.d(TAG, "Wrote amt=" + bulkTransfer + " attempted=" + min);
            i2 += bulkTransfer;
        }
        return i2;
    }
}
