package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* loaded from: classes.dex */
public final class Version {
    private static final Version[] VERSIONS = buildVersions();
    private final int dataRegionSizeColumns;
    private final int dataRegionSizeRows;
    private final ECBlocks ecBlocks;
    private final int symbolSizeColumns;
    private final int symbolSizeRows;
    private final int totalCodewords;
    private final int versionNumber;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.zxing.datamatrix.decoder.Version$1 */
    /* loaded from: classes.dex */
    public static class C40781 {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ECB {
        private final int count;
        private final int dataCodewords;

        private ECB(int i, int i2) {
            this.count = i;
            this.dataCodewords = i2;
        }

        ECB(int i, int i2, C40781 c40781) {
            this(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getCount() {
            return this.count;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getDataCodewords() {
            return this.dataCodewords;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ECBlocks {
        private final ECB[] ecBlocks;
        private final int ecCodewords;

        private ECBlocks(int i, ECB ecb) {
            this.ecCodewords = i;
            this.ecBlocks = new ECB[]{ecb};
        }

        ECBlocks(int i, ECB ecb, C40781 c40781) {
            this(i, ecb);
        }

        private ECBlocks(int i, ECB ecb, ECB ecb2) {
            this.ecCodewords = i;
            this.ecBlocks = new ECB[]{ecb, ecb2};
        }

        ECBlocks(int i, ECB ecb, ECB ecb2, C40781 c40781) {
            this(i, ecb, ecb2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ECB[] getECBlocks() {
            return this.ecBlocks;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getECCodewords() {
            return this.ecCodewords;
        }
    }

    private Version(int i, int i2, int i3, int i4, int i5, ECBlocks eCBlocks) {
        ECB[] eCBlocks2;
        this.versionNumber = i;
        this.symbolSizeRows = i2;
        this.symbolSizeColumns = i3;
        this.dataRegionSizeRows = i4;
        this.dataRegionSizeColumns = i5;
        this.ecBlocks = eCBlocks;
        int eCCodewords = eCBlocks.getECCodewords();
        int i6 = 0;
        for (ECB ecb : eCBlocks.getECBlocks()) {
            i6 += (ecb.getDataCodewords() + eCCodewords) * ecb.getCount();
        }
        this.totalCodewords = i6;
    }

    private static Version[] buildVersions() {
        return new Version[]{new Version(1, 10, 10, 8, 8, new ECBlocks(5, new ECB(1, 3, null), (C40781) null)), new Version(2, 12, 12, 10, 10, new ECBlocks(7, new ECB(1, 5, null), (C40781) null)), new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(1, 8, null), (C40781) null)), new Version(4, 16, 16, 14, 14, new ECBlocks(12, new ECB(1, 12, null), (C40781) null)), new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(1, 18, null), (C40781) null)), new Version(6, 20, 20, 18, 18, new ECBlocks(18, new ECB(1, 22, null), (C40781) null)), new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(1, 30, null), (C40781) null)), new Version(8, 24, 24, 22, 22, new ECBlocks(24, new ECB(1, 36, null), (C40781) null)), new Version(9, 26, 26, 24, 24, new ECBlocks(28, new ECB(1, 44, null), (C40781) null)), new Version(10, 32, 32, 14, 14, new ECBlocks(36, new ECB(1, 62, null), (C40781) null)), new Version(11, 36, 36, 16, 16, new ECBlocks(42, new ECB(1, 86, null), (C40781) null)), new Version(12, 40, 40, 18, 18, new ECBlocks(48, new ECB(1, 114, null), (C40781) null)), new Version(13, 44, 44, 20, 20, new ECBlocks(56, new ECB(1, 144, null), (C40781) null)), new Version(14, 48, 48, 22, 22, new ECBlocks(68, new ECB(1, Opcodes.FRETURN, null), (C40781) null)), new Version(15, 52, 52, 24, 24, new ECBlocks(42, new ECB(2, 102, null), (C40781) null)), new Version(16, 64, 64, 14, 14, new ECBlocks(56, new ECB(2, 140, null), (C40781) null)), new Version(17, 72, 72, 16, 16, new ECBlocks(36, new ECB(4, 92, null), (C40781) null)), new Version(18, 80, 80, 18, 18, new ECBlocks(48, new ECB(4, 114, null), (C40781) null)), new Version(19, 88, 88, 20, 20, new ECBlocks(56, new ECB(4, 144, null), (C40781) null)), new Version(20, 96, 96, 22, 22, new ECBlocks(68, new ECB(4, Opcodes.FRETURN, null), (C40781) null)), new Version(21, 104, 104, 24, 24, new ECBlocks(56, new ECB(6, 136, null), (C40781) null)), new Version(22, 120, 120, 18, 18, new ECBlocks(68, new ECB(6, Opcodes.DRETURN, null), (C40781) null)), new Version(23, 132, 132, 20, 20, new ECBlocks(62, new ECB(8, Opcodes.IF_ICMPGT, null), (C40781) null)), new Version(24, 144, 144, 22, 22, new ECBlocks(62, new ECB(8, Opcodes.IFGE, null), new ECB(2, Opcodes.IFLT, null), null)), new Version(25, 8, 18, 6, 16, new ECBlocks(7, new ECB(1, 5, null), (C40781) null)), new Version(26, 8, 32, 6, 14, new ECBlocks(11, new ECB(1, 10, null), (C40781) null)), new Version(27, 12, 26, 10, 24, new ECBlocks(14, new ECB(1, 16, null), (C40781) null)), new Version(28, 12, 36, 10, 16, new ECBlocks(18, new ECB(1, 22, null), (C40781) null)), new Version(29, 16, 36, 10, 16, new ECBlocks(24, new ECB(1, 32, null), (C40781) null)), new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(1, 49, null), (C40781) null))};
    }

    public static Version getVersionForDimensions(int i, int i2) {
        if ((i & 1) == 0 && (i2 & 1) == 0) {
            int length = VERSIONS.length;
            for (int i3 = 0; i3 < length; i3++) {
                Version version = VERSIONS[i3];
                if (version.symbolSizeRows == i && version.symbolSizeColumns == i2) {
                    return version;
                }
            }
            throw FormatException.getFormatInstance();
        }
        throw FormatException.getFormatInstance();
    }

    public int getDataRegionSizeColumns() {
        return this.dataRegionSizeColumns;
    }

    public int getDataRegionSizeRows() {
        return this.dataRegionSizeRows;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECBlocks getECBlocks() {
        return this.ecBlocks;
    }

    public int getSymbolSizeColumns() {
        return this.symbolSizeColumns;
    }

    public int getSymbolSizeRows() {
        return this.symbolSizeRows;
    }

    public int getTotalCodewords() {
        return this.totalCodewords;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public String toString() {
        return String.valueOf(this.versionNumber);
    }
}
