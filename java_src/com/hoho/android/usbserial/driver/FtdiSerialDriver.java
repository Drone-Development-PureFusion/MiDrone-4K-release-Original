package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.util.Log;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class FtdiSerialDriver extends CommonUsbSerialDriver {
    private static final boolean ENABLE_ASYNC_READS = false;
    public static final int FTDI_DEVICE_IN_REQTYPE = 192;
    public static final int FTDI_DEVICE_OUT_REQTYPE = 64;
    private static final int MODEM_STATUS_HEADER_LENGTH = 2;
    private static final int SIO_MODEM_CTRL_REQUEST = 1;
    private static final int SIO_RESET_PURGE_RX = 1;
    private static final int SIO_RESET_PURGE_TX = 2;
    private static final int SIO_RESET_REQUEST = 0;
    private static final int SIO_RESET_SIO = 0;
    private static final int SIO_SET_BAUD_RATE_REQUEST = 3;
    private static final int SIO_SET_DATA_REQUEST = 4;
    private static final int SIO_SET_FLOW_CTRL_REQUEST = 2;
    public static final int USB_ENDPOINT_IN = 128;
    public static final int USB_ENDPOINT_OUT = 0;
    public static final int USB_READ_TIMEOUT_MILLIS = 5000;
    public static final int USB_RECIP_DEVICE = 0;
    public static final int USB_RECIP_ENDPOINT = 2;
    public static final int USB_RECIP_INTERFACE = 1;
    public static final int USB_RECIP_OTHER = 3;
    public static final int USB_TYPE_CLASS = 0;
    public static final int USB_TYPE_RESERVED = 0;
    public static final int USB_TYPE_STANDARD = 0;
    public static final int USB_TYPE_VENDOR = 0;
    public static final int USB_WRITE_TIMEOUT_MILLIS = 5000;
    private final String TAG = FtdiSerialDriver.class.getSimpleName();
    private int mInterface = 0;
    private int mMaxPacketSize = 64;
    private DeviceType mType = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum DeviceType {
        TYPE_BM,
        TYPE_AM,
        TYPE_2232C,
        TYPE_R,
        TYPE_2232H,
        TYPE_4232H;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DeviceType[] valuesCustom() {
            DeviceType[] valuesCustom = values();
            int length = valuesCustom.length;
            DeviceType[] deviceTypeArr = new DeviceType[length];
            System.arraycopy(valuesCustom, 0, deviceTypeArr, 0, length);
            return deviceTypeArr;
        }
    }

    public FtdiSerialDriver(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        super(usbDevice, usbDeviceConnection);
    }

    private long[] convertBaudrate(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 24000000 / i;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int[] iArr = {0, 3, 2, 4, 1, 5, 6, 7};
        int i11 = 0;
        while (true) {
            if (i11 >= 2) {
                i2 = i9;
                i3 = i8;
                break;
            }
            i3 = i7 + i11;
            if (i3 <= 8) {
                i3 = 8;
            } else if (this.mType != DeviceType.TYPE_AM && i3 < 12) {
                i3 = 12;
            } else if (i7 < 16) {
                i3 = 16;
            } else if (this.mType != DeviceType.TYPE_AM && i3 > 131071) {
                i3 = 131071;
            }
            i2 = (24000000 + (i3 / 2)) / i3;
            int i12 = i2 < i ? i - i2 : i2 - i;
            if (i11 != 0 && i12 >= i10) {
                i6 = i10;
                i5 = i8;
                i4 = i9;
            } else if (i12 == 0) {
                break;
            } else {
                i4 = i2;
                int i13 = i12;
                i5 = i3;
                i6 = i13;
            }
            i11++;
            i8 = i5;
            i9 = i4;
            i10 = i6;
        }
        long j = (iArr[i3 & 7] << 14) | (i3 >> 3);
        if (j == 1) {
            j = 0;
        } else if (j == 16385) {
            j = 1;
        }
        return new long[]{i2, (this.mType == DeviceType.TYPE_2232C || this.mType == DeviceType.TYPE_2232H || this.mType == DeviceType.TYPE_4232H) ? ((j >> 8) & 65535 & 65280) | 0 : (j >> 16) & 65535, 65535 & j};
    }

    private final int filterStatusBytes(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = (i / i2) + 1;
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i4 == i3 + (-1) ? (i % i2) - 2 : i2 - 2;
            if (i5 > 0) {
                System.arraycopy(bArr, (i4 * i2) + 2, bArr2, (i2 - 2) * i4, i5);
            }
            i4++;
        }
        return i - (i3 * 2);
    }

    public static Map<Integer, int[]> getSupportedDevices() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1027, new int[]{UsbId.FTDI_FT232R, UsbId.FTDI_FT231X});
        return linkedHashMap;
    }

    private int setBaudRate(int i) {
        long[] convertBaudrate = convertBaudrate(i);
        long j = convertBaudrate[0];
        long j2 = convertBaudrate[1];
        int controlTransfer = this.mConnection.controlTransfer(64, 3, (int) convertBaudrate[2], (int) j2, null, 0, 5000);
        if (controlTransfer != 0) {
            throw new IOException("Setting baudrate failed: result=" + controlTransfer);
        }
        return (int) j;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public void close() {
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
        return false;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean getRI() {
        return false;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean getRTS() {
        return false;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public void open() {
        for (int i = 0; i < this.mDevice.getInterfaceCount(); i++) {
            try {
                if (!this.mConnection.claimInterface(this.mDevice.getInterface(i), true)) {
                    throw new IOException("Error claiming interface " + i);
                }
                Log.d(this.TAG, "claimInterface " + i + " SUCCESS");
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
        reset();
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public boolean purgeHwBuffers(boolean z, boolean z2) {
        int controlTransfer;
        int controlTransfer2;
        if (!z || (controlTransfer2 = this.mConnection.controlTransfer(64, 0, 1, 0, null, 0, 5000)) == 0) {
            if (z2 && (controlTransfer = this.mConnection.controlTransfer(64, 0, 2, 0, null, 0, 5000)) != 0) {
                throw new IOException("Flushing RX failed: result=" + controlTransfer);
            }
            return true;
        }
        throw new IOException("Flushing RX failed: result=" + controlTransfer2);
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public int read(byte[] bArr, int i) {
        int filterStatusBytes;
        UsbEndpoint endpoint = this.mDevice.getInterface(0).getEndpoint(0);
        synchronized (this.mReadBufferLock) {
            int bulkTransfer = this.mConnection.bulkTransfer(endpoint, this.mReadBuffer, Math.min(bArr.length, this.mReadBuffer.length), i);
            if (bulkTransfer < 2) {
                throw new IOException("Expected at least 2 bytes");
            }
            filterStatusBytes = filterStatusBytes(this.mReadBuffer, bArr, bulkTransfer, endpoint.getMaxPacketSize());
        }
        return filterStatusBytes;
    }

    public void reset() {
        int controlTransfer = this.mConnection.controlTransfer(64, 0, 0, 0, null, 0, 5000);
        if (controlTransfer != 0) {
            throw new IOException("Reset failed: result=" + controlTransfer);
        }
        this.mType = DeviceType.TYPE_R;
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public void setDTR(boolean z) {
    }

    @Override // com.hoho.android.usbserial.driver.CommonUsbSerialDriver, com.hoho.android.usbserial.driver.UsbSerialDriver
    public void setParameters(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        setBaudRate(i);
        switch (i4) {
            case 0:
                i5 = i2 | 0;
                break;
            case 1:
                i5 = i2 | 256;
                break;
            case 2:
                i5 = i2 | 512;
                break;
            case 3:
                i5 = i2 | 768;
                break;
            case 4:
                i5 = i2 | 1024;
                break;
            default:
                throw new IllegalArgumentException("Unknown parity value: " + i4);
        }
        switch (i3) {
            case 1:
                i6 = i5 | 0;
                break;
            case 2:
                i6 = i5 | 4096;
                break;
            case 3:
                i6 = i5 | 2048;
                break;
            default:
                throw new IllegalArgumentException("Unknown stopBits value: " + i3);
        }
        int controlTransfer = this.mConnection.controlTransfer(64, 4, i6, 0, null, 0, 5000);
        if (controlTransfer != 0) {
            throw new IOException("Setting parameters failed: result=" + controlTransfer);
        }
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
        UsbEndpoint endpoint = this.mDevice.getInterface(0).getEndpoint(1);
        while (i2 < bArr.length) {
            synchronized (this.mWriteBufferLock) {
                min = Math.min(bArr.length - i2, this.mWriteBuffer.length);
                if (i2 == 0) {
                    bArr2 = bArr;
                } else {
                    System.arraycopy(bArr, i2, this.mWriteBuffer, 0, min);
                    bArr2 = this.mWriteBuffer;
                }
                bulkTransfer = this.mConnection.bulkTransfer(endpoint, bArr2, min, i);
            }
            if (bulkTransfer <= 0) {
                throw new IOException("Error writing " + min + " bytes at offset " + i2 + " length=" + bArr.length);
            }
            Log.d(this.TAG, "Wrote amtWritten=" + bulkTransfer + " attempted=" + min);
            i2 += bulkTransfer;
        }
        return i2;
    }
}
