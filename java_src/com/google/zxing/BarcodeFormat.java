package com.google.zxing;

import java.util.Hashtable;
/* loaded from: classes.dex */
public final class BarcodeFormat {
    private final String name;
    private static final Hashtable VALUES = new Hashtable();
    public static final BarcodeFormat QR_CODE = new BarcodeFormat("QR_CODE");
    public static final BarcodeFormat DATA_MATRIX = new BarcodeFormat("DATA_MATRIX");
    public static final BarcodeFormat UPC_E = new BarcodeFormat("UPC_E");
    public static final BarcodeFormat UPC_A = new BarcodeFormat("UPC_A");
    public static final BarcodeFormat EAN_8 = new BarcodeFormat("EAN_8");
    public static final BarcodeFormat EAN_13 = new BarcodeFormat("EAN_13");
    public static final BarcodeFormat UPC_EAN_EXTENSION = new BarcodeFormat("UPC_EAN_EXTENSION");
    public static final BarcodeFormat CODE_128 = new BarcodeFormat("CODE_128");
    public static final BarcodeFormat CODE_39 = new BarcodeFormat("CODE_39");
    public static final BarcodeFormat CODE_93 = new BarcodeFormat("CODE_93");
    public static final BarcodeFormat CODABAR = new BarcodeFormat("CODABAR");
    public static final BarcodeFormat ITF = new BarcodeFormat("ITF");
    public static final BarcodeFormat RSS14 = new BarcodeFormat("RSS14");
    public static final BarcodeFormat PDF417 = new BarcodeFormat("PDF417");
    public static final BarcodeFormat RSS_EXPANDED = new BarcodeFormat("RSS_EXPANDED");

    private BarcodeFormat(String str) {
        this.name = str;
        VALUES.put(str, this);
    }

    public static BarcodeFormat valueOf(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
        BarcodeFormat barcodeFormat = (BarcodeFormat) VALUES.get(str);
        if (barcodeFormat != null) {
            return barcodeFormat;
        }
        throw new IllegalArgumentException();
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
