package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.Vector;
/* loaded from: classes.dex */
final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BitArray buildBitArray(Vector vector) {
        int size = (vector.size() << 1) - 1;
        BitArray bitArray = new BitArray((((ExpandedPair) vector.lastElement()).getRightChar() == null ? size - 1 : size) * 12);
        int value = ((ExpandedPair) vector.elementAt(0)).getRightChar().getValue();
        int i = 11;
        int i2 = 0;
        while (i >= 0) {
            if (((1 << i) & value) != 0) {
                bitArray.set(i2);
            }
            i--;
            i2++;
        }
        int i3 = i2;
        for (int i4 = 1; i4 < vector.size(); i4++) {
            ExpandedPair expandedPair = (ExpandedPair) vector.elementAt(i4);
            int value2 = expandedPair.getLeftChar().getValue();
            int i5 = 11;
            while (i5 >= 0) {
                if (((1 << i5) & value2) != 0) {
                    bitArray.set(i3);
                }
                i5--;
                i3++;
            }
            if (expandedPair.getRightChar() != null) {
                int value3 = expandedPair.getRightChar().getValue();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & value3) != 0) {
                        bitArray.set(i3);
                    }
                    i3++;
                }
            }
        }
        return bitArray;
    }
}
