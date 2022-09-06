package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Hashtable;
import java.util.Vector;
/* loaded from: classes.dex */
public final class MultiFormatUPCEANReader extends OneDReader {
    private final Vector readers;

    public MultiFormatUPCEANReader(Hashtable hashtable) {
        Vector vector = hashtable == null ? null : (Vector) hashtable.get(DecodeHintType.POSSIBLE_FORMATS);
        this.readers = new Vector();
        if (vector != null) {
            if (vector.contains(BarcodeFormat.EAN_13)) {
                this.readers.addElement(new EAN13Reader());
            } else if (vector.contains(BarcodeFormat.UPC_A)) {
                this.readers.addElement(new UPCAReader());
            }
            if (vector.contains(BarcodeFormat.EAN_8)) {
                this.readers.addElement(new EAN8Reader());
            }
            if (vector.contains(BarcodeFormat.UPC_E)) {
                this.readers.addElement(new UPCEReader());
            }
        }
        if (this.readers.isEmpty()) {
            this.readers.addElement(new EAN13Reader());
            this.readers.addElement(new EAN8Reader());
            this.readers.addElement(new UPCEReader());
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Hashtable hashtable) {
        int[] findStartGuardPattern = UPCEANReader.findStartGuardPattern(bitArray);
        int size = this.readers.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                Result decodeRow = ((UPCEANReader) this.readers.elementAt(i2)).decodeRow(i, bitArray, findStartGuardPattern, hashtable);
                boolean z = BarcodeFormat.EAN_13.equals(decodeRow.getBarcodeFormat()) && decodeRow.getText().charAt(0) == '0';
                Vector vector = hashtable == null ? null : (Vector) hashtable.get(DecodeHintType.POSSIBLE_FORMATS);
                return (!z || !(vector == null || vector.contains(BarcodeFormat.UPC_A))) ? decodeRow : new Result(decodeRow.getText().substring(1), null, decodeRow.getResultPoints(), BarcodeFormat.UPC_A);
            } catch (ReaderException e) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        int size = this.readers.size();
        for (int i = 0; i < size; i++) {
            ((Reader) this.readers.elementAt(i)).reset();
        }
    }
}
