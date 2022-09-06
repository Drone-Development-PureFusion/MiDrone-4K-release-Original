package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public enum UsbSerialProber {
    FTDI_SERIAL { // from class: com.hoho.android.usbserial.driver.UsbSerialProber.1
        @Override // com.hoho.android.usbserial.driver.UsbSerialProber
        public List<UsbSerialDriver> probe(UsbManager usbManager, UsbDevice usbDevice) {
            UsbDeviceConnection openDevice;
            if (UsbSerialProber.testIfSupported(usbDevice, FtdiSerialDriver.getSupportedDevices()) && (openDevice = usbManager.openDevice(usbDevice)) != null) {
                return Collections.singletonList(new FtdiSerialDriver(usbDevice, openDevice));
            }
            return Collections.emptyList();
        }
    },
    CDC_ACM_SERIAL { // from class: com.hoho.android.usbserial.driver.UsbSerialProber.2
        @Override // com.hoho.android.usbserial.driver.UsbSerialProber
        public List<UsbSerialDriver> probe(UsbManager usbManager, UsbDevice usbDevice) {
            UsbDeviceConnection openDevice;
            if (UsbSerialProber.testIfSupported(usbDevice, CdcAcmSerialDriver.getSupportedDevices()) && (openDevice = usbManager.openDevice(usbDevice)) != null) {
                return Collections.singletonList(new CdcAcmSerialDriver(usbDevice, openDevice));
            }
            return Collections.emptyList();
        }
    },
    SILAB_SERIAL { // from class: com.hoho.android.usbserial.driver.UsbSerialProber.3
        @Override // com.hoho.android.usbserial.driver.UsbSerialProber
        public List<UsbSerialDriver> probe(UsbManager usbManager, UsbDevice usbDevice) {
            UsbDeviceConnection openDevice;
            if (UsbSerialProber.testIfSupported(usbDevice, Cp2102SerialDriver.getSupportedDevices()) && (openDevice = usbManager.openDevice(usbDevice)) != null) {
                return Collections.singletonList(new Cp2102SerialDriver(usbDevice, openDevice));
            }
            return Collections.emptyList();
        }
    },
    PROLIFIC_SERIAL { // from class: com.hoho.android.usbserial.driver.UsbSerialProber.4
        @Override // com.hoho.android.usbserial.driver.UsbSerialProber
        public List<UsbSerialDriver> probe(UsbManager usbManager, UsbDevice usbDevice) {
            UsbDeviceConnection openDevice;
            if (UsbSerialProber.testIfSupported(usbDevice, ProlificSerialDriver.getSupportedDevices()) && (openDevice = usbManager.openDevice(usbDevice)) != null) {
                return Collections.singletonList(new ProlificSerialDriver(usbDevice, openDevice));
            }
            return Collections.emptyList();
        }
    };

    /* synthetic */ UsbSerialProber(UsbSerialProber usbSerialProber) {
        this();
    }

    @Deprecated
    public static UsbSerialDriver acquire(UsbManager usbManager) {
        return findFirstDevice(usbManager);
    }

    @Deprecated
    public static UsbSerialDriver acquire(UsbManager usbManager, UsbDevice usbDevice) {
        List<UsbSerialDriver> probeSingleDevice = probeSingleDevice(usbManager, usbDevice);
        if (!probeSingleDevice.isEmpty()) {
            return probeSingleDevice.get(0);
        }
        return null;
    }

    public static List<UsbSerialDriver> findAllDevices(UsbManager usbManager) {
        ArrayList arrayList = new ArrayList();
        for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
            arrayList.addAll(probeSingleDevice(usbManager, usbDevice));
        }
        return arrayList;
    }

    public static UsbSerialDriver findFirstDevice(UsbManager usbManager) {
        for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
            for (UsbSerialProber usbSerialProber : valuesCustom()) {
                List<UsbSerialDriver> probe = usbSerialProber.probe(usbManager, usbDevice);
                if (!probe.isEmpty()) {
                    return probe.get(0);
                }
            }
        }
        return null;
    }

    public static List<UsbSerialDriver> probeSingleDevice(UsbManager usbManager, UsbDevice usbDevice) {
        ArrayList arrayList = new ArrayList();
        for (UsbSerialProber usbSerialProber : valuesCustom()) {
            arrayList.addAll(usbSerialProber.probe(usbManager, usbDevice));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean testIfSupported(UsbDevice usbDevice, Map<Integer, int[]> map) {
        int[] iArr = map.get(Integer.valueOf(usbDevice.getVendorId()));
        if (iArr == null) {
            return false;
        }
        int productId = usbDevice.getProductId();
        for (int i : iArr) {
            if (productId == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static UsbSerialProber[] valuesCustom() {
        UsbSerialProber[] valuesCustom = values();
        int length = valuesCustom.length;
        UsbSerialProber[] usbSerialProberArr = new UsbSerialProber[length];
        System.arraycopy(valuesCustom, 0, usbSerialProberArr, 0, length);
        return usbSerialProberArr;
    }

    protected abstract List<UsbSerialDriver> probe(UsbManager usbManager, UsbDevice usbDevice);
}
