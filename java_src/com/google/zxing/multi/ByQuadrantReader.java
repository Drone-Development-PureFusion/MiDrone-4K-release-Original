package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class ByQuadrantReader implements Reader {
    private final Reader delegate;

    public ByQuadrantReader(Reader reader) {
        this.delegate = reader;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Hashtable hashtable) {
        int width = binaryBitmap.getWidth() / 2;
        int height = binaryBitmap.getHeight() / 2;
        try {
            return this.delegate.decode(binaryBitmap.crop(0, 0, width, height), hashtable);
        } catch (NotFoundException e) {
            try {
                return this.delegate.decode(binaryBitmap.crop(width, 0, width, height), hashtable);
            } catch (NotFoundException e2) {
                try {
                    return this.delegate.decode(binaryBitmap.crop(0, height, width, height), hashtable);
                } catch (NotFoundException e3) {
                    try {
                        return this.delegate.decode(binaryBitmap.crop(width, height, width, height), hashtable);
                    } catch (NotFoundException e4) {
                        return this.delegate.decode(binaryBitmap.crop(width / 2, height / 2, width, height), hashtable);
                    }
                }
            }
        }
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        this.delegate.reset();
    }
}
