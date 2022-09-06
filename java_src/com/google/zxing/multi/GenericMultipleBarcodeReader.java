package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Hashtable;
import java.util.Vector;
/* loaded from: classes.dex */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Hashtable hashtable, Vector vector, int i, int i2) {
        boolean z;
        float f;
        float f2;
        float f3;
        float f4;
        try {
            Result decode = this.delegate.decode(binaryBitmap, hashtable);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= vector.size()) {
                    z = false;
                    break;
                } else if (((Result) vector.elementAt(i4)).getText().equals(decode.getText())) {
                    z = true;
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
            if (z) {
                return;
            }
            vector.addElement(translateResultPoints(decode, i, i2));
            ResultPoint[] resultPoints = decode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f5 = width;
            float f6 = height;
            float f7 = 0.0f;
            float f8 = 0.0f;
            int i5 = 0;
            while (true) {
                f = f8;
                f2 = f7;
                f3 = f6;
                f4 = f5;
                if (i5 >= resultPoints.length) {
                    break;
                }
                ResultPoint resultPoint = resultPoints[i5];
                f7 = resultPoint.getX();
                float y = resultPoint.getY();
                f5 = f7 < f4 ? f7 : f4;
                f6 = y < f3 ? y : f3;
                if (f7 <= f2) {
                    f7 = f2;
                }
                f8 = y > f ? y : f;
                i5++;
            }
            if (f4 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f4, height), hashtable, vector, i, i2);
            }
            if (f3 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(0, 0, width, (int) f3), hashtable, vector, i, i2);
            }
            if (f2 < width - 100) {
                doDecodeMultiple(binaryBitmap.crop((int) f2, 0, width - ((int) f2), height), hashtable, vector, i + ((int) f2), i2);
            }
            if (f >= height - 100) {
                return;
            }
            doDecodeMultiple(binaryBitmap.crop(0, (int) f, width, height - ((int) f)), hashtable, vector, i, i2 + ((int) f));
        } catch (ReaderException e) {
        }
    }

    private static Result translateResultPoints(Result result, int i, int i2) {
        ResultPoint[] resultPoints = result.getResultPoints();
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            ResultPoint resultPoint = resultPoints[i3];
            resultPointArr[i3] = new ResultPoint(resultPoint.getX() + i, resultPoint.getY() + i2);
        }
        return new Result(result.getText(), result.getRawBytes(), resultPointArr, result.getBarcodeFormat());
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Hashtable hashtable) {
        Vector vector = new Vector();
        doDecodeMultiple(binaryBitmap, hashtable, vector, 0, 0);
        if (vector.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int size = vector.size();
        Result[] resultArr = new Result[size];
        for (int i = 0; i < size; i++) {
            resultArr[i] = (Result) vector.elementAt(i);
        }
        return resultArr;
    }
}
