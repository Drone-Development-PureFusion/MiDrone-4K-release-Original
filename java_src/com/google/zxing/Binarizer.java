package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes.dex */
public abstract class Binarizer {
    private final LuminanceSource source;

    /* JADX INFO: Access modifiers changed from: protected */
    public Binarizer(LuminanceSource luminanceSource) {
        if (luminanceSource == null) {
            throw new IllegalArgumentException("Source must be non-null.");
        }
        this.source = luminanceSource;
    }

    public abstract Binarizer createBinarizer(LuminanceSource luminanceSource);

    public abstract BitMatrix getBlackMatrix();

    public abstract BitArray getBlackRow(int i, BitArray bitArray);

    public LuminanceSource getLuminanceSource() {
        return this.source;
    }
}
