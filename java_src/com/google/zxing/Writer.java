package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Hashtable;
/* loaded from: classes.dex */
public interface Writer {
    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2);

    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Hashtable hashtable);
}
