package org.codehaus.jackson.smile;

import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.impl.StreamBasedParserBase;
import org.codehaus.jackson.p316io.IOContext;
import org.codehaus.jackson.sym.BytesToNameCanonicalizer;
import org.codehaus.jackson.sym.Name;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public class SmileParser extends StreamBasedParserBase {
    private static final int[] NO_INTS = new int[0];
    private static final String[] NO_STRINGS = new String[0];
    protected static final ThreadLocal<SoftReference<SmileBufferRecycler<String>>> _smileRecyclerRef = new ThreadLocal<>();
    protected boolean _got32BitFloat;
    protected boolean _mayContainRawBinary;
    protected ObjectCodec _objectCodec;
    protected int _quad1;
    protected int _quad2;
    protected final BytesToNameCanonicalizer _symbols;
    protected int _typeByte;
    protected boolean _tokenIncomplete = false;
    protected int[] _quadBuffer = NO_INTS;
    protected String[] _seenNames = NO_STRINGS;
    protected int _seenNameCount = 0;
    protected String[] _seenStringValues = null;
    protected int _seenStringValueCount = -1;
    protected final SmileBufferRecycler<String> _smileBufferRecycler = _smileBufferRecycler();

    /* loaded from: classes2.dex */
    public enum Feature {
        REQUIRE_HEADER(true);
        
        final boolean _defaultState;
        final int _mask = 1 << ordinal();

        Feature(boolean z) {
            this._defaultState = z;
        }

        public static int collectDefaults() {
            Feature[] values;
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public int getMask() {
            return this._mask;
        }
    }

    public SmileParser(IOContext iOContext, int i, int i2, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, InputStream inputStream, byte[] bArr, int i3, int i4, boolean z) {
        super(iOContext, i, inputStream, bArr, i3, i4, z);
        this._objectCodec = objectCodec;
        this._symbols = bytesToNameCanonicalizer;
        this._tokenInputRow = -1;
        this._tokenInputCol = -1;
    }

    private final String _addDecodedToSymbols(int i, String str) {
        if (i < 5) {
            return this._symbols.addName(str, this._quad1, 0).getName();
        }
        if (i < 9) {
            return this._symbols.addName(str, this._quad1, this._quad2).getName();
        }
        return this._symbols.addName(str, this._quadBuffer, (i + 3) >> 2).getName();
    }

    private final void _addSeenStringValue() {
        _finishToken();
        if (this._seenStringValueCount >= this._seenStringValues.length) {
            _expandSeenStringValues();
            return;
        }
        String[] strArr = this._seenStringValues;
        int i = this._seenStringValueCount;
        this._seenStringValueCount = i + 1;
        strArr[i] = this._textBuffer.contentsAsString();
    }

    private final void _decodeLongAscii() {
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            int i2 = this._inputPtr;
            int i3 = this._inputEnd - i2;
            if (i >= emptyAndGetCurrentSegment.length) {
                emptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int min = Math.min(i3, emptyAndGetCurrentSegment.length - i);
            while (true) {
                int i4 = i;
                int i5 = i2;
                i2 = i5 + 1;
                byte b = this._inputBuffer[i5];
                if (b == -4) {
                    this._inputPtr = i2;
                    this._textBuffer.setCurrentLength(i4);
                    return;
                }
                i = i4 + 1;
                emptyAndGetCurrentSegment[i4] = (char) b;
                min--;
                if (min <= 0) {
                    break;
                }
            }
            this._inputPtr = i2;
        }
    }

    private final void _decodeLongUnicode() {
        int i;
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = SmileConstants.sUtf8UnitLengths;
        byte[] bArr = this._inputBuffer;
        int i2 = 0;
        while (true) {
            int i3 = this._inputPtr;
            if (i3 >= this._inputEnd) {
                loadMoreGuaranteed();
                i3 = this._inputPtr;
            }
            if (i2 >= emptyAndGetCurrentSegment.length) {
                emptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i2 = 0;
            }
            int i4 = this._inputEnd;
            int length = (emptyAndGetCurrentSegment.length - i2) + i3;
            if (length >= i4) {
                length = i4;
            }
            while (true) {
                if (i3 < length) {
                    int i5 = i3 + 1;
                    int i6 = bArr[i3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                    if (iArr[i6] != 0) {
                        this._inputPtr = i5;
                        if (i6 == 252) {
                            this._textBuffer.setCurrentLength(i2);
                            return;
                        }
                        switch (iArr[i6]) {
                            case 1:
                                i6 = _decodeUtf8_2(i6);
                                break;
                            case 2:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    i6 = _decodeUtf8_3(i6);
                                    break;
                                } else {
                                    i6 = _decodeUtf8_3fast(i6);
                                    break;
                                }
                            case 3:
                            default:
                                _reportInvalidChar(i6);
                                break;
                            case 4:
                                int _decodeUtf8_4 = _decodeUtf8_4(i6);
                                int i7 = i2 + 1;
                                emptyAndGetCurrentSegment[i2] = (char) (55296 | (_decodeUtf8_4 >> 10));
                                if (i7 >= emptyAndGetCurrentSegment.length) {
                                    emptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                                    i2 = 0;
                                } else {
                                    i2 = i7;
                                }
                                i6 = 56320 | (_decodeUtf8_4 & 1023);
                                break;
                        }
                        if (i2 >= emptyAndGetCurrentSegment.length) {
                            emptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                            i = 0;
                        } else {
                            i = i2;
                        }
                        i2 = i + 1;
                        emptyAndGetCurrentSegment[i] = (char) i6;
                    } else {
                        emptyAndGetCurrentSegment[i2] = (char) i6;
                        i3 = i5;
                        i2++;
                    }
                } else {
                    this._inputPtr = i3;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Name _decodeLongUnicodeName(int[] iArr, int i, int i2) {
        int i3;
        char[] cArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i & 3;
        if (i9 < 4) {
            i3 = iArr[i2 - 1];
            iArr[i2 - 1] = i3 << ((4 - i9) << 3);
        } else {
            i3 = 0;
        }
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i10 = 0;
        int i11 = 0;
        while (i11 < i) {
            int i12 = (iArr[i11 >> 2] >> ((3 - (i11 & 3)) << 3)) & 255;
            int i13 = i11 + 1;
            if (i12 > 127) {
                if ((i12 & 224) == 192) {
                    i7 = i12 & 31;
                    i8 = 1;
                } else if ((i12 & 240) == 224) {
                    i7 = i12 & 15;
                    i8 = 2;
                } else if ((i12 & 248) == 240) {
                    i7 = i12 & 7;
                    i8 = 3;
                } else {
                    _reportInvalidInitial(i12);
                    i7 = 1;
                    i8 = 1;
                }
                if (i13 + i8 > i) {
                    _reportInvalidEOF(" in long field name");
                }
                int i14 = iArr[i13 >> 2] >> ((3 - (i13 & 3)) << 3);
                i13++;
                if ((i14 & 192) != 128) {
                    _reportInvalidOther(i14);
                }
                i12 = (i7 << 6) | (i14 & 63);
                if (i8 > 1) {
                    int i15 = iArr[i13 >> 2] >> ((3 - (i13 & 3)) << 3);
                    i13++;
                    if ((i15 & 192) != 128) {
                        _reportInvalidOther(i15);
                    }
                    i12 = (i12 << 6) | (i15 & 63);
                    if (i8 > 2) {
                        int i16 = iArr[i13 >> 2] >> ((3 - (i13 & 3)) << 3);
                        i13++;
                        if ((i16 & 192) != 128) {
                            _reportInvalidOther(i16 & 255);
                        }
                        i12 = (i12 << 6) | (i16 & 63);
                    }
                }
                if (i8 > 2) {
                    int i17 = i12 - 65536;
                    if (i10 >= emptyAndGetCurrentSegment.length) {
                        emptyAndGetCurrentSegment = this._textBuffer.expandCurrentSegment();
                    }
                    emptyAndGetCurrentSegment[i10] = (char) (55296 + (i17 >> 10));
                    int i18 = (i17 & 1023) | 56320;
                    i5 = i13;
                    i6 = i10 + 1;
                    cArr = emptyAndGetCurrentSegment;
                    i4 = i18;
                    if (i6 < cArr.length) {
                        cArr = this._textBuffer.expandCurrentSegment();
                    }
                    i10 = i6 + 1;
                    cArr[i6] = (char) i4;
                    i11 = i5;
                    emptyAndGetCurrentSegment = cArr;
                }
            }
            cArr = emptyAndGetCurrentSegment;
            i4 = i12;
            i5 = i13;
            i6 = i10;
            if (i6 < cArr.length) {
            }
            i10 = i6 + 1;
            cArr[i6] = (char) i4;
            i11 = i5;
            emptyAndGetCurrentSegment = cArr;
        }
        String str = new String(emptyAndGetCurrentSegment, 0, i10);
        if (i9 < 4) {
            iArr[i2 - 1] = i3;
        }
        return this._symbols.addName(str, iArr, i2);
    }

    private final String _decodeShortAsciiName(int i) {
        int i2;
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        byte[] bArr = this._inputBuffer;
        int i3 = this._inputPtr;
        int i4 = (i3 + i) - 3;
        int i5 = 0;
        while (i3 < i4) {
            int i6 = i5 + 1;
            int i7 = i3 + 1;
            emptyAndGetCurrentSegment[i5] = (char) bArr[i3];
            int i8 = i6 + 1;
            int i9 = i7 + 1;
            emptyAndGetCurrentSegment[i6] = (char) bArr[i7];
            int i10 = i8 + 1;
            int i11 = i9 + 1;
            emptyAndGetCurrentSegment[i8] = (char) bArr[i9];
            i3 = i11 + 1;
            emptyAndGetCurrentSegment[i10] = (char) bArr[i11];
            i5 = i10 + 1;
        }
        int i12 = i & 3;
        if (i12 > 0) {
            int i13 = i5 + 1;
            i2 = i3 + 1;
            emptyAndGetCurrentSegment[i5] = (char) bArr[i3];
            if (i12 > 1) {
                int i14 = i13 + 1;
                i3 = i2 + 1;
                emptyAndGetCurrentSegment[i13] = (char) bArr[i2];
                if (i12 > 2) {
                    int i15 = i14 + 1;
                    i2 = i3 + 1;
                    emptyAndGetCurrentSegment[i14] = (char) bArr[i3];
                }
            }
            this._inputPtr = i2;
            this._textBuffer.setCurrentLength(i);
            return this._textBuffer.contentsAsString();
        }
        i2 = i3;
        this._inputPtr = i2;
        this._textBuffer.setCurrentLength(i);
        return this._textBuffer.contentsAsString();
    }

    private final String _decodeShortUnicodeName(int i) {
        int i2;
        int i3 = 0;
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i4 = this._inputPtr;
        this._inputPtr += i;
        int[] iArr = SmileConstants.sUtf8UnitLengths;
        byte[] bArr = this._inputBuffer;
        int i5 = i4 + i;
        while (i4 < i5) {
            int i6 = i4 + 1;
            int i7 = bArr[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            int i8 = iArr[i7];
            if (i8 != 0) {
                switch (i8) {
                    case 1:
                        i4 = i6 + 1;
                        i7 = ((i7 & 31) << 6) | (bArr[i6] & 63);
                        i2 = i3;
                        continue;
                        i3 = i2 + 1;
                        emptyAndGetCurrentSegment[i2] = (char) i7;
                    case 2:
                        int i9 = i6 + 1;
                        i4 = i9 + 1;
                        i7 = ((i7 & 15) << 12) | ((bArr[i6] & 63) << 6) | (bArr[i9] & 63);
                        i2 = i3;
                        continue;
                        i3 = i2 + 1;
                        emptyAndGetCurrentSegment[i2] = (char) i7;
                    case 3:
                        int i10 = i6 + 1;
                        int i11 = ((i7 & 7) << 18) | ((bArr[i6] & 63) << 12);
                        int i12 = i10 + 1;
                        int i13 = i11 | ((bArr[i10] & 63) << 6);
                        i4 = i12 + 1;
                        int i14 = (i13 | (bArr[i12] & 63)) - 65536;
                        i2 = i3 + 1;
                        emptyAndGetCurrentSegment[i3] = (char) (55296 | (i14 >> 10));
                        i7 = (i14 & 1023) | 56320;
                        continue;
                        i3 = i2 + 1;
                        emptyAndGetCurrentSegment[i2] = (char) i7;
                    default:
                        _reportError("Invalid byte " + Integer.toHexString(i7) + " in short Unicode text block");
                        break;
                }
            }
            i4 = i6;
            i2 = i3;
            i3 = i2 + 1;
            emptyAndGetCurrentSegment[i2] = (char) i7;
        }
        this._textBuffer.setCurrentLength(i3);
        return this._textBuffer.contentsAsString();
    }

    private final int _decodeUtf8_2(int i) {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
        return (b & 63) | ((i & 31) << 6);
    }

    private final int _decodeUtf8_3(int i) {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        int i2 = i & 15;
        byte[] bArr = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
        int i4 = (i2 << 6) | (b & 63);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i5 = this._inputPtr;
        this._inputPtr = i5 + 1;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            _reportInvalidOther(b2 & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
        return (i4 << 6) | (b2 & 63);
    }

    private final int _decodeUtf8_3fast(int i) {
        int i2 = i & 15;
        byte[] bArr = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
        int i4 = (i2 << 6) | (b & 63);
        byte[] bArr2 = this._inputBuffer;
        int i5 = this._inputPtr;
        this._inputPtr = i5 + 1;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            _reportInvalidOther(b2 & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
        return (i4 << 6) | (b2 & 63);
    }

    private final int _decodeUtf8_4(int i) {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
        int i3 = (b & 63) | ((i & 7) << 6);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i4 = this._inputPtr;
        this._inputPtr = i4 + 1;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != 128) {
            _reportInvalidOther(b2 & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
        int i5 = (i3 << 6) | (b2 & 63);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i6 = this._inputPtr;
        this._inputPtr = i6 + 1;
        byte b3 = bArr3[i6];
        if ((b3 & 192) != 128) {
            _reportInvalidOther(b3 & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
        return ((i5 << 6) | (b3 & 63)) - 65536;
    }

    private final String[] _expandSeenNames(String[] strArr) {
        int i = 1024;
        int length = strArr.length;
        if (length == 0) {
            String[] allocSeenNamesBuffer = this._smileBufferRecycler.allocSeenNamesBuffer();
            return allocSeenNamesBuffer == null ? new String[64] : allocSeenNamesBuffer;
        } else if (length == 1024) {
            this._seenNameCount = 0;
            return strArr;
        } else {
            if (length == 64) {
                i = 256;
            }
            String[] strArr2 = new String[i];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            return strArr2;
        }
    }

    private final void _expandSeenStringValues() {
        String[] strArr;
        int i = 1024;
        String[] strArr2 = this._seenStringValues;
        int length = strArr2.length;
        if (length == 0) {
            strArr = this._smileBufferRecycler.allocSeenStringValuesBuffer();
            if (strArr == null) {
                strArr = new String[64];
            }
        } else if (length == 1024) {
            this._seenStringValueCount = 0;
            strArr = strArr2;
        } else {
            if (length == 64) {
                i = 256;
            }
            strArr = new String[i];
            System.arraycopy(strArr2, 0, strArr, 0, strArr2.length);
        }
        this._seenStringValues = strArr;
        String[] strArr3 = this._seenStringValues;
        int i2 = this._seenStringValueCount;
        this._seenStringValueCount = i2 + 1;
        strArr3[i2] = this._textBuffer.contentsAsString();
    }

    private final Name _findDecodedFromSymbols(int i) {
        if (this._inputEnd - this._inputPtr < i) {
            _loadToHaveAtLeast(i);
        }
        if (i < 5) {
            int i2 = this._inputPtr;
            byte[] bArr = this._inputBuffer;
            int i3 = bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            int i4 = i - 1;
            if (i4 > 0) {
                int i5 = i2 + 1;
                i3 = (i3 << 8) + (bArr[i5] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                int i6 = i4 - 1;
                if (i6 > 0) {
                    int i7 = i5 + 1;
                    i3 = (i3 << 8) + (bArr[i7] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                    if (i6 - 1 > 0) {
                        i3 = (i3 << 8) + (bArr[i7 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                    }
                }
            }
            this._quad1 = i3;
            return this._symbols.findName(i3);
        } else if (i >= 9) {
            return _findDecodedMedium(i);
        } else {
            int i8 = this._inputPtr;
            byte[] bArr2 = this._inputBuffer;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            int i12 = ((((((bArr2[i8] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) + (bArr2[i9] & SmileConstants.BYTE_MARKER_END_OF_CONTENT)) << 8) + (bArr2[i10] & SmileConstants.BYTE_MARKER_END_OF_CONTENT)) << 8) + (bArr2[i11] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            int i13 = i11 + 1;
            int i14 = bArr2[i13] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            int i15 = i - 5;
            if (i15 > 0) {
                int i16 = i13 + 1;
                i14 = (i14 << 8) + (bArr2[i16] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                int i17 = i15 - 1;
                if (i17 > 0) {
                    int i18 = i16 + 1;
                    i14 = (i14 << 8) + (bArr2[i18] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                    if (i17 - 1 > 0) {
                        i14 = (i14 << 8) + (bArr2[i18 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                    }
                }
            }
            this._quad1 = i12;
            this._quad2 = i14;
            return this._symbols.findName(i12, i14);
        }
    }

    private final Name _findDecodedMedium(int i) {
        int i2;
        int i3;
        int i4 = (i + 3) >> 2;
        if (i4 > this._quadBuffer.length) {
            this._quadBuffer = _growArrayTo(this._quadBuffer, i4);
        }
        int i5 = 0;
        int i6 = this._inputPtr;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = (((((bArr[i6] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i7] & SmileConstants.BYTE_MARKER_END_OF_CONTENT)) << 8) | (bArr[i8] & SmileConstants.BYTE_MARKER_END_OF_CONTENT)) << 8;
            i6 = i9 + 1;
            int i11 = i10 | (bArr[i9] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            i2 = i5 + 1;
            this._quadBuffer[i5] = i11;
            i -= 4;
            if (i <= 3) {
                break;
            }
            i5 = i2;
        }
        if (i > 0) {
            int i12 = bArr[i6] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            int i13 = i - 1;
            if (i13 > 0) {
                int i14 = i6 + 1;
                i3 = (bArr[i14] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) + (i12 << 8);
                if (i13 - 1 > 0) {
                    i3 = (i3 << 8) + (bArr[i14 + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                }
            } else {
                i3 = i12;
            }
            this._quadBuffer[i2] = i3;
            i2++;
        }
        return this._symbols.findName(this._quadBuffer, i2);
    }

    private final void _finishBigDecimal() {
        this._numberBigDecimal = new BigDecimal(new BigInteger(_read7BitBinaryWithLength()), SmileUtil.zigzagDecode(_readUnsignedVInt()));
        this._numTypesValid = 16;
    }

    private final void _finishBigInteger() {
        this._numberBigInt = new BigInteger(_read7BitBinaryWithLength());
        this._numTypesValid = 4;
    }

    private final void _finishDouble() {
        long _fourBytesToInt = (_fourBytesToInt() << 28) + _fourBytesToInt();
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        long j = (_fourBytesToInt << 7) + bArr[i];
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        this._numberDouble = Double.longBitsToDouble((j << 7) + bArr2[i2]);
        this._numTypesValid = 8;
    }

    private final void _finishFloat() {
        int _fourBytesToInt = _fourBytesToInt();
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        this._numberDouble = Float.intBitsToFloat((_fourBytesToInt << 7) + bArr[i]);
        this._numTypesValid = 8;
    }

    private final void _finishInt() {
        int i;
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        int i3 = bArr[i2];
        if (i3 < 0) {
            i = i3 & 63;
        } else {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            byte b = bArr2[i4];
            if (b >= 0) {
                i3 = (i3 << 7) + b;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                b = bArr3[i5];
                if (b >= 0) {
                    i3 = (i3 << 7) + b;
                    if (this._inputPtr >= this._inputEnd) {
                        loadMoreGuaranteed();
                    }
                    byte[] bArr4 = this._inputBuffer;
                    int i6 = this._inputPtr;
                    this._inputPtr = i6 + 1;
                    b = bArr4[i6];
                    if (b >= 0) {
                        i3 = (i3 << 7) + b;
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        byte[] bArr5 = this._inputBuffer;
                        int i7 = this._inputPtr;
                        this._inputPtr = i7 + 1;
                        b = bArr5[i7];
                        if (b >= 0) {
                            _reportError("Corrupt input; 32-bit VInt extends beyond 5 data bytes");
                        }
                    }
                }
            }
            i = (b & 63) + (i3 << 6);
        }
        this._numberInt = SmileUtil.zigzagDecode(i);
        this._numTypesValid = 1;
    }

    private final void _finishLong() {
        long _fourBytesToInt = _fourBytesToInt();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            byte b = bArr[i];
            if (b < 0) {
                this._numberLong = SmileUtil.zigzagDecode((_fourBytesToInt << 6) + (b & 63));
                this._numTypesValid = 2;
                return;
            }
            _fourBytesToInt = (_fourBytesToInt << 7) + b;
        }
    }

    private final void _finishRawBinary() {
        int _readUnsignedVInt = _readUnsignedVInt();
        this._binaryValue = new byte[_readUnsignedVInt];
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        int i = 0;
        while (true) {
            int min = Math.min(_readUnsignedVInt, this._inputEnd - this._inputPtr);
            System.arraycopy(this._inputBuffer, this._inputPtr, this._binaryValue, i, min);
            this._inputPtr += min;
            i += min;
            _readUnsignedVInt -= min;
            if (_readUnsignedVInt <= 0) {
                return;
            }
            loadMoreGuaranteed();
        }
    }

    private final int _fourBytesToInt() {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        int i3 = (b << 7) + bArr2[i2];
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i4 = this._inputPtr;
        this._inputPtr = i4 + 1;
        int i5 = (i3 << 7) + bArr3[i4];
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr4 = this._inputBuffer;
        int i6 = this._inputPtr;
        this._inputPtr = i6 + 1;
        return (i5 << 7) + bArr4[i6];
    }

    private static int[] _growArrayTo(int[] iArr, int i) {
        int[] iArr2 = new int[i + 4];
        if (iArr != null) {
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        }
        return iArr2;
    }

    private final void _handleLongFieldName() {
        int i;
        int i2;
        byte[] bArr = this._inputBuffer;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = this._inputPtr;
            this._inputPtr = i5 + 1;
            byte b = bArr[i5];
            if (-4 == b) {
                i = i3;
                i2 = 0;
                break;
            }
            int i6 = b & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            int i7 = this._inputPtr;
            this._inputPtr = i7 + 1;
            byte b2 = bArr[i7];
            if (-4 == b2) {
                i = i6;
                i2 = 1;
                break;
            }
            int i8 = (i6 << 8) | (b2 & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            int i9 = this._inputPtr;
            this._inputPtr = i9 + 1;
            byte b3 = bArr[i9];
            if (-4 == b3) {
                i = i8;
                i2 = 2;
                break;
            }
            int i10 = (i8 << 8) | (b3 & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            int i11 = this._inputPtr;
            this._inputPtr = i11 + 1;
            byte b4 = bArr[i11];
            if (-4 == b4) {
                i = i10;
                i2 = 3;
                break;
            }
            i3 = (i10 << 8) | (b4 & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            if (i4 >= this._quadBuffer.length) {
                this._quadBuffer = _growArrayTo(this._quadBuffer, this._quadBuffer.length + 256);
            }
            this._quadBuffer[i4] = i3;
            i4++;
        }
        int i12 = i4 << 2;
        if (i2 > 0) {
            if (i4 >= this._quadBuffer.length) {
                this._quadBuffer = _growArrayTo(this._quadBuffer, this._quadBuffer.length + 256);
            }
            this._quadBuffer[i4] = i;
            i12 += i2;
            i4++;
        }
        Name findName = this._symbols.findName(this._quadBuffer, i4);
        String name = findName != null ? findName.getName() : _decodeLongUnicodeName(this._quadBuffer, i12, i4).getName();
        if (this._seenNames != null) {
            if (this._seenNameCount >= this._seenNames.length) {
                this._seenNames = _expandSeenNames(this._seenNames);
            }
            String[] strArr = this._seenNames;
            int i13 = this._seenNameCount;
            this._seenNameCount = i13 + 1;
            strArr[i13] = name;
        }
        this._parsingContext.setCurrentName(name);
    }

    private final JsonToken _handleSharedString(int i) {
        if (i >= this._seenStringValueCount) {
            _reportInvalidSharedStringValue(i);
        }
        this._textBuffer.resetWithString(this._seenStringValues[i]);
        JsonToken jsonToken = JsonToken.VALUE_STRING;
        this._currToken = jsonToken;
        return jsonToken;
    }

    private final byte[] _read7BitBinaryWithLength() {
        int _readUnsignedVInt = _readUnsignedVInt();
        byte[] bArr = new byte[_readUnsignedVInt];
        int i = 0;
        int i2 = _readUnsignedVInt - 7;
        while (i <= i2) {
            if (this._inputEnd - this._inputPtr < 8) {
                _loadToHaveAtLeast(8);
            }
            byte[] bArr2 = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            byte[] bArr3 = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            int i5 = (bArr2[i3] << 25) + (bArr3[i4] << 18);
            byte[] bArr4 = this._inputBuffer;
            int i6 = this._inputPtr;
            this._inputPtr = i6 + 1;
            int i7 = i5 + (bArr4[i6] << 11);
            byte[] bArr5 = this._inputBuffer;
            int i8 = this._inputPtr;
            this._inputPtr = i8 + 1;
            int i9 = i7 + (bArr5[i8] << 4);
            byte[] bArr6 = this._inputBuffer;
            int i10 = this._inputPtr;
            this._inputPtr = i10 + 1;
            byte b = bArr6[i10];
            int i11 = i9 + (b >> 3);
            byte[] bArr7 = this._inputBuffer;
            int i12 = this._inputPtr;
            this._inputPtr = i12 + 1;
            int i13 = ((b & 7) << 21) + (bArr7[i12] << 14);
            byte[] bArr8 = this._inputBuffer;
            int i14 = this._inputPtr;
            this._inputPtr = i14 + 1;
            int i15 = i13 + (bArr8[i14] << 7);
            byte[] bArr9 = this._inputBuffer;
            int i16 = this._inputPtr;
            this._inputPtr = i16 + 1;
            int i17 = i15 + bArr9[i16];
            int i18 = i + 1;
            bArr[i] = (byte) (i11 >> 24);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i11 >> 16);
            int i20 = i19 + 1;
            bArr[i19] = (byte) (i11 >> 8);
            int i21 = i20 + 1;
            bArr[i20] = (byte) i11;
            int i22 = i21 + 1;
            bArr[i21] = (byte) (i17 >> 16);
            int i23 = i22 + 1;
            bArr[i22] = (byte) (i17 >> 8);
            i = i23 + 1;
            bArr[i23] = (byte) i17;
        }
        int length = bArr.length - i;
        if (length > 0) {
            if (this._inputEnd - this._inputPtr < length + 1) {
                _loadToHaveAtLeast(length + 1);
            }
            byte[] bArr10 = this._inputBuffer;
            int i24 = this._inputPtr;
            this._inputPtr = i24 + 1;
            int i25 = bArr10[i24];
            int i26 = 1;
            while (i26 < length) {
                byte[] bArr11 = this._inputBuffer;
                int i27 = this._inputPtr;
                this._inputPtr = i27 + 1;
                i25 = (i25 << 7) + bArr11[i27];
                bArr[i] = (byte) (i25 >> (7 - i26));
                i26++;
                i++;
            }
            int i28 = i25 << length;
            byte[] bArr12 = this._inputBuffer;
            int i29 = this._inputPtr;
            this._inputPtr = i29 + 1;
            bArr[i] = (byte) (i28 + bArr12[i29]);
        }
        return bArr;
    }

    private final int _readUnsignedVInt() {
        int i = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte b = bArr[i2];
            if (b < 0) {
                return (i << 6) + (b & 63);
            }
            i = (i << 7) + b;
        }
    }

    protected static final SmileBufferRecycler<String> _smileBufferRecycler() {
        SoftReference<SmileBufferRecycler<String>> softReference = _smileRecyclerRef.get();
        SmileBufferRecycler<String> smileBufferRecycler = softReference == null ? null : softReference.get();
        if (smileBufferRecycler == null) {
            SmileBufferRecycler<String> smileBufferRecycler2 = new SmileBufferRecycler<>();
            _smileRecyclerRef.set(new SoftReference<>(smileBufferRecycler2));
            return smileBufferRecycler2;
        }
        return smileBufferRecycler;
    }

    @Override // org.codehaus.jackson.impl.JsonParserBase
    protected byte[] _decodeBase64(Base64Variant base64Variant) {
        _throwInternal();
        return null;
    }

    protected final void _decodeShortAsciiValue(int i) {
        if (this._inputEnd - this._inputPtr < i) {
            _loadToHaveAtLeast(i);
        }
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i2 = 0;
        byte[] bArr = this._inputBuffer;
        int i3 = this._inputPtr;
        int i4 = i3 + i;
        while (i3 < i4) {
            emptyAndGetCurrentSegment[i2] = (char) bArr[i3];
            i3++;
            i2++;
        }
        this._inputPtr = i3;
        this._textBuffer.setCurrentLength(i);
    }

    protected final void _decodeShortUnicodeValue(int i) {
        int i2;
        if (this._inputEnd - this._inputPtr < i) {
            _loadToHaveAtLeast(i);
        }
        int i3 = 0;
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i4 = this._inputPtr;
        this._inputPtr += i;
        int[] iArr = SmileConstants.sUtf8UnitLengths;
        byte[] bArr = this._inputBuffer;
        int i5 = i4 + i;
        while (i4 < i5) {
            int i6 = i4 + 1;
            int i7 = bArr[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            int i8 = iArr[i7];
            if (i8 != 0) {
                switch (i8) {
                    case 1:
                        i4 = i6 + 1;
                        i7 = ((i7 & 31) << 6) | (bArr[i6] & 63);
                        i2 = i3;
                        continue;
                        i3 = i2 + 1;
                        emptyAndGetCurrentSegment[i2] = (char) i7;
                    case 2:
                        int i9 = i6 + 1;
                        i4 = i9 + 1;
                        i7 = ((i7 & 15) << 12) | ((bArr[i6] & 63) << 6) | (bArr[i9] & 63);
                        i2 = i3;
                        continue;
                        i3 = i2 + 1;
                        emptyAndGetCurrentSegment[i2] = (char) i7;
                    case 3:
                        int i10 = i6 + 1;
                        int i11 = ((i7 & 7) << 18) | ((bArr[i6] & 63) << 12);
                        int i12 = i10 + 1;
                        int i13 = i11 | ((bArr[i10] & 63) << 6);
                        i4 = i12 + 1;
                        int i14 = (i13 | (bArr[i12] & 63)) - 65536;
                        i2 = i3 + 1;
                        emptyAndGetCurrentSegment[i3] = (char) (55296 | (i14 >> 10));
                        i7 = (i14 & 1023) | 56320;
                        continue;
                        i3 = i2 + 1;
                        emptyAndGetCurrentSegment[i2] = (char) i7;
                    default:
                        _reportError("Invalid byte " + Integer.toHexString(i7) + " in short Unicode text block");
                        break;
                }
            }
            i4 = i6;
            i2 = i3;
            i3 = i2 + 1;
            emptyAndGetCurrentSegment[i2] = (char) i7;
        }
        this._textBuffer.setCurrentLength(i3);
    }

    protected final void _finishNumberToken(int i) {
        int i2 = i & 31;
        int i3 = i2 >> 2;
        if (i3 != 1) {
            if (i3 == 2) {
                switch (i2 & 3) {
                    case 0:
                        _finishFloat();
                        return;
                    case 1:
                        _finishDouble();
                        return;
                    case 2:
                        _finishBigDecimal();
                        return;
                }
            }
            _throwInternal();
            return;
        }
        int i4 = i2 & 3;
        if (i4 == 0) {
            _finishInt();
        } else if (i4 == 1) {
            _finishLong();
        } else if (i4 == 2) {
            _finishBigInteger();
        } else {
            _throwInternal();
        }
    }

    @Override // org.codehaus.jackson.impl.JsonParserBase
    protected void _finishString() {
        _throwInternal();
    }

    protected void _finishToken() {
        this._tokenIncomplete = false;
        int i = this._typeByte;
        int i2 = (i >> 5) & 7;
        if (i2 == 1) {
            _finishNumberToken(i);
        } else if (i2 <= 3) {
            _decodeShortAsciiValue((i & 63) + 1);
        } else if (i2 <= 5) {
            _decodeShortUnicodeValue((i & 63) + 2);
        } else {
            if (i2 == 7) {
                switch ((i & 31) >> 2) {
                    case 0:
                        _decodeLongAscii();
                        return;
                    case 1:
                        _decodeLongUnicode();
                        return;
                    case 2:
                        this._binaryValue = _read7BitBinaryWithLength();
                        return;
                    case 7:
                        _finishRawBinary();
                        return;
                }
            }
            _throwInternal();
        }
    }

    protected final JsonToken _handleFieldName() {
        String _addDecodedToSymbols;
        String _addDecodedToSymbols2;
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        this._typeByte = b;
        switch ((b >> 6) & 3) {
            case 0:
                switch (b) {
                    case 32:
                        this._parsingContext.setCurrentName("");
                        return JsonToken.FIELD_NAME;
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        byte[] bArr2 = this._inputBuffer;
                        int i2 = this._inputPtr;
                        this._inputPtr = i2 + 1;
                        int i3 = ((b & 3) << 8) + (bArr2[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                        if (i3 >= this._seenNameCount) {
                            _reportInvalidSharedName(i3);
                        }
                        this._parsingContext.setCurrentName(this._seenNames[i3]);
                        return JsonToken.FIELD_NAME;
                    case 52:
                        _handleLongFieldName();
                        return JsonToken.FIELD_NAME;
                }
            case 1:
                int i4 = b & 63;
                if (i4 >= this._seenNameCount) {
                    _reportInvalidSharedName(i4);
                }
                this._parsingContext.setCurrentName(this._seenNames[i4]);
                return JsonToken.FIELD_NAME;
            case 2:
                int i5 = (b & 63) + 1;
                Name _findDecodedFromSymbols = _findDecodedFromSymbols(i5);
                if (_findDecodedFromSymbols != null) {
                    _addDecodedToSymbols2 = _findDecodedFromSymbols.getName();
                    this._inputPtr = i5 + this._inputPtr;
                } else {
                    _addDecodedToSymbols2 = _addDecodedToSymbols(i5, _decodeShortAsciiName(i5));
                }
                if (this._seenNames != null) {
                    if (this._seenNameCount >= this._seenNames.length) {
                        this._seenNames = _expandSeenNames(this._seenNames);
                    }
                    String[] strArr = this._seenNames;
                    int i6 = this._seenNameCount;
                    this._seenNameCount = i6 + 1;
                    strArr[i6] = _addDecodedToSymbols2;
                }
                this._parsingContext.setCurrentName(_addDecodedToSymbols2);
                return JsonToken.FIELD_NAME;
            case 3:
                int i7 = b & 63;
                if (i7 <= 55) {
                    int i8 = i7 + 2;
                    Name _findDecodedFromSymbols2 = _findDecodedFromSymbols(i8);
                    if (_findDecodedFromSymbols2 != null) {
                        _addDecodedToSymbols = _findDecodedFromSymbols2.getName();
                        this._inputPtr = i8 + this._inputPtr;
                    } else {
                        _addDecodedToSymbols = _addDecodedToSymbols(i8, _decodeShortUnicodeName(i8));
                    }
                    if (this._seenNames != null) {
                        if (this._seenNameCount >= this._seenNames.length) {
                            this._seenNames = _expandSeenNames(this._seenNames);
                        }
                        String[] strArr2 = this._seenNames;
                        int i9 = this._seenNameCount;
                        this._seenNameCount = i9 + 1;
                        strArr2[i9] = _addDecodedToSymbols;
                    }
                    this._parsingContext.setCurrentName(_addDecodedToSymbols);
                    return JsonToken.FIELD_NAME;
                } else if (i7 == 59) {
                    if (!this._parsingContext.inObject()) {
                        _reportMismatchedEndMarker(125, ']');
                    }
                    this._parsingContext = this._parsingContext.mo22000getParent();
                    return JsonToken.END_OBJECT;
                }
                break;
        }
        _reportError("Invalid type marker byte 0x" + Integer.toHexString(b) + " for expected field name (or END_OBJECT marker)");
        return null;
    }

    @Override // org.codehaus.jackson.impl.JsonNumericParserBase
    protected void _parseNumericValue(int i) {
        if (this._tokenIncomplete) {
            int i2 = this._typeByte;
            if (((i2 >> 5) & 7) != 1) {
                _reportError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
            }
            this._tokenIncomplete = false;
            _finishNumberToken(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.codehaus.jackson.impl.StreamBasedParserBase, org.codehaus.jackson.impl.JsonParserBase
    public void _releaseBuffers() {
        super._releaseBuffers();
        String[] strArr = this._seenNames;
        if (strArr != null && strArr.length > 0) {
            this._seenNames = null;
            Arrays.fill(strArr, 0, this._seenNameCount, (Object) null);
            this._smileBufferRecycler.releaseSeenNamesBuffer(strArr);
        }
        String[] strArr2 = this._seenStringValues;
        if (strArr2 == null || strArr2.length <= 0) {
            return;
        }
        this._seenStringValues = null;
        Arrays.fill(strArr2, 0, this._seenStringValueCount, (Object) null);
        this._smileBufferRecycler.releaseSeenStringValuesBuffer(strArr2);
    }

    protected void _reportInvalidChar(int i) {
        if (i < 32) {
            _throwInvalidSpace(i);
        }
        _reportInvalidInitial(i);
    }

    protected void _reportInvalidInitial(int i) {
        _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    protected void _reportInvalidOther(int i) {
        _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    protected void _reportInvalidOther(int i, int i2) {
        this._inputPtr = i2;
        _reportInvalidOther(i);
    }

    protected void _reportInvalidSharedName(int i) {
        if (this._seenNames == null) {
            _reportError("Encountered shared name reference, even though document header explicitly declared no shared name references are included");
        }
        _reportError("Invalid shared name reference " + i + "; only got " + this._seenNameCount + " names in buffer (invalid content)");
    }

    protected void _reportInvalidSharedStringValue(int i) {
        if (this._seenStringValues == null) {
            _reportError("Encountered shared text value reference, even though document header did not declared shared text value references may be included");
        }
        _reportError("Invalid shared text value reference " + i + "; only got " + this._seenStringValueCount + " names in buffer (invalid content)");
    }

    protected void _skip7BitBinary() {
        int _readUnsignedVInt = _readUnsignedVInt();
        int i = _readUnsignedVInt / 7;
        int i2 = i * 8;
        int i3 = _readUnsignedVInt - (i * 7);
        if (i3 > 0) {
            i2 += i3 + 1;
        }
        _skipBytes(i2);
    }

    protected void _skipBytes(int i) {
        while (true) {
            int min = Math.min(i, this._inputEnd - this._inputPtr);
            this._inputPtr += min;
            i -= min;
            if (i <= 0) {
                return;
            }
            loadMoreGuaranteed();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void _skipIncomplete() {
        int i;
        this._tokenIncomplete = false;
        int i2 = this._typeByte;
        switch ((i2 >> 5) & 7) {
            case 1:
                int i3 = i2 & 31;
                switch (i3 >> 2) {
                    case 1:
                        switch (i3 & 3) {
                            case 0:
                                while (true) {
                                    i = this._inputEnd;
                                    byte[] bArr = this._inputBuffer;
                                    while (this._inputPtr < i) {
                                        int i4 = this._inputPtr;
                                        this._inputPtr = i4 + 1;
                                        if (bArr[i4] < 0) {
                                            return;
                                        }
                                    }
                                    loadMoreGuaranteed();
                                }
                            case 1:
                                _skipBytes(4);
                                while (true) {
                                    i = this._inputEnd;
                                    byte[] bArr2 = this._inputBuffer;
                                    while (this._inputPtr < i) {
                                    }
                                    loadMoreGuaranteed();
                                }
                                break;
                            case 2:
                                _skip7BitBinary();
                                return;
                        }
                        break;
                    case 2:
                        switch (i3 & 3) {
                            case 0:
                                _skipBytes(5);
                                return;
                            case 1:
                                _skipBytes(10);
                                return;
                            case 2:
                                _readUnsignedVInt();
                                _skip7BitBinary();
                                return;
                        }
                }
            case 2:
            case 3:
                _skipBytes((i2 & 63) + 1);
                return;
            case 4:
            case 5:
                _skipBytes((i2 & 63) + 2);
                return;
            case 7:
                switch ((i2 & 31) >> 2) {
                    case 0:
                    case 1:
                        while (true) {
                            int i5 = this._inputEnd;
                            byte[] bArr3 = this._inputBuffer;
                            while (this._inputPtr < i5) {
                                int i6 = this._inputPtr;
                                this._inputPtr = i6 + 1;
                                if (bArr3[i6] == -4) {
                                    return;
                                }
                            }
                            loadMoreGuaranteed();
                        }
                    case 2:
                        _skip7BitBinary();
                        return;
                    case 7:
                        _skipBytes(_readUnsignedVInt());
                        return;
                }
                break;
        }
        _throwInternal();
    }

    @Override // org.codehaus.jackson.impl.JsonParserBase, org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this._symbols.release();
    }

    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) {
        if (this._tokenIncomplete) {
            _finishToken();
        }
        if (this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT) {
            _reportError("Current token (" + this._currToken + ") not VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        return this._binaryValue;
    }

    @Override // org.codehaus.jackson.JsonParser
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // org.codehaus.jackson.impl.JsonParserBase, org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public String getCurrentName() {
        return this._parsingContext.getCurrentName();
    }

    @Override // org.codehaus.jackson.impl.JsonNumericParserBase, org.codehaus.jackson.JsonParser
    public JsonParser.NumberType getNumberType() {
        return this._got32BitFloat ? JsonParser.NumberType.FLOAT : super.getNumberType();
    }

    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public String getText() {
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            int i = this._typeByte;
            int i2 = (i >> 5) & 7;
            if (i2 == 2 || i2 == 3) {
                _decodeShortAsciiValue((i & 63) + 1);
                return this._textBuffer.contentsAsString();
            } else if (i2 == 4 || i2 == 5) {
                _decodeShortUnicodeValue((i & 63) + 2);
                return this._textBuffer.contentsAsString();
            } else {
                _finishToken();
            }
        }
        if (this._currToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.contentsAsString();
        }
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return null;
        }
        return jsonToken == JsonToken.FIELD_NAME ? this._parsingContext.getCurrentName() : jsonToken.isNumeric() ? getNumberValue().toString() : this._currToken.asString();
    }

    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public char[] getTextCharacters() {
        if (this._currToken != null) {
            if (this._tokenIncomplete) {
                _finishToken();
            }
            switch (this._currToken) {
                case VALUE_STRING:
                    return this._textBuffer.getTextBuffer();
                case FIELD_NAME:
                    if (!this._nameCopied) {
                        String currentName = this._parsingContext.getCurrentName();
                        int length = currentName.length();
                        if (this._nameCopyBuffer == null) {
                            this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(length);
                        } else if (this._nameCopyBuffer.length < length) {
                            this._nameCopyBuffer = new char[length];
                        }
                        currentName.getChars(0, length, this._nameCopyBuffer, 0);
                        this._nameCopied = true;
                    }
                    return this._nameCopyBuffer;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    return getNumberValue().toString().toCharArray();
                default:
                    return this._currToken.asCharArray();
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public int getTextLength() {
        if (this._currToken != null) {
            if (this._tokenIncomplete) {
                _finishToken();
            }
            switch (this._currToken) {
                case VALUE_STRING:
                    return this._textBuffer.size();
                case FIELD_NAME:
                    return this._parsingContext.getCurrentName().length();
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    return getNumberValue().toString().length();
                default:
                    return this._currToken.asCharArray().length;
            }
        }
        return 0;
    }

    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public int getTextOffset() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleSignature(boolean z, boolean z2) {
        int i;
        boolean z3 = false;
        if (z) {
            this._inputPtr++;
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        if (this._inputBuffer[this._inputPtr] != 41) {
            if (!z2) {
                return false;
            }
            _reportError("Malformed content: signature not valid, starts with 0x3a but followed by 0x" + Integer.toHexString(this._inputBuffer[this._inputPtr]) + ", not 0x29");
            return false;
        }
        int i2 = this._inputPtr + 1;
        this._inputPtr = i2;
        if (i2 >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        if (this._inputBuffer[this._inputPtr] != 10) {
            if (!z2) {
                return false;
            }
            _reportError("Malformed content: signature not valid, starts with 0x3a, 0x29, but followed by 0x" + Integer.toHexString(this._inputBuffer[this._inputPtr]) + ", not 0xA");
            return false;
        }
        int i3 = this._inputPtr + 1;
        this._inputPtr = i3;
        if (i3 >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i4 = this._inputPtr;
        this._inputPtr = i4 + 1;
        byte b = bArr[i4];
        if (((b >> 4) & 15) != 0) {
            _reportError("Header version number bits (0x" + Integer.toHexString(i) + ") indicate unrecognized version; only 0x0 handled by parser");
        }
        if ((b & 1) == 0) {
            this._seenNames = null;
            this._seenNameCount = -1;
        }
        if ((b & 2) != 0) {
            this._seenStringValues = NO_STRINGS;
            this._seenStringValueCount = 0;
        }
        if ((b & 4) != 0) {
            z3 = true;
        }
        this._mayContainRawBinary = z3;
        return true;
    }

    public boolean mayContainRawBinary() {
        return this._mayContainRawBinary;
    }

    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public JsonToken nextToken() {
        boolean z = true;
        if (this._tokenIncomplete) {
            _skipIncomplete();
        }
        this._tokenInputTotal = (this._currInputProcessed + this._inputPtr) - 1;
        this._binaryValue = null;
        if (this._parsingContext.inObject() && this._currToken != JsonToken.FIELD_NAME) {
            JsonToken _handleFieldName = _handleFieldName();
            this._currToken = _handleFieldName;
            return _handleFieldName;
        } else if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _handleEOF();
            close();
            this._currToken = null;
            return null;
        } else {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            byte b = bArr[i];
            this._typeByte = b;
            switch ((b >> 5) & 7) {
                case 0:
                    if (b == 0) {
                        _reportError("Invalid token byte 0x00");
                    }
                    return _handleSharedString(b - 1);
                case 1:
                    int i2 = b & 31;
                    if (i2 < 4) {
                        switch (i2) {
                            case 0:
                                this._textBuffer.resetWithEmpty();
                                JsonToken jsonToken = JsonToken.VALUE_STRING;
                                this._currToken = jsonToken;
                                return jsonToken;
                            case 1:
                                JsonToken jsonToken2 = JsonToken.VALUE_NULL;
                                this._currToken = jsonToken2;
                                return jsonToken2;
                            case 2:
                                JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
                                this._currToken = jsonToken3;
                                return jsonToken3;
                            default:
                                JsonToken jsonToken4 = JsonToken.VALUE_TRUE;
                                this._currToken = jsonToken4;
                                return jsonToken4;
                        }
                    } else if (i2 < 8) {
                        if ((i2 & 3) <= 2) {
                            this._tokenIncomplete = true;
                            this._numTypesValid = 0;
                            JsonToken jsonToken5 = JsonToken.VALUE_NUMBER_INT;
                            this._currToken = jsonToken5;
                            return jsonToken5;
                        }
                    } else if (i2 < 12) {
                        int i3 = i2 & 3;
                        if (i3 <= 2) {
                            this._tokenIncomplete = true;
                            this._numTypesValid = 0;
                            if (i3 != 0) {
                                z = false;
                            }
                            this._got32BitFloat = z;
                            JsonToken jsonToken6 = JsonToken.VALUE_NUMBER_FLOAT;
                            this._currToken = jsonToken6;
                            return jsonToken6;
                        }
                    } else if (i2 == 26 && handleSignature(false, false)) {
                        if (this._currToken == null) {
                            return nextToken();
                        }
                        this._currToken = null;
                        return null;
                    } else {
                        _reportError("Unrecognized token byte 0x3A (malformed segment header?");
                        break;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    this._currToken = JsonToken.VALUE_STRING;
                    if (this._seenStringValueCount >= 0) {
                        _addSeenStringValue();
                    } else {
                        this._tokenIncomplete = true;
                    }
                    return this._currToken;
                case 6:
                    this._numberInt = SmileUtil.zigzagDecode(b & 31);
                    this._numTypesValid = 1;
                    JsonToken jsonToken7 = JsonToken.VALUE_NUMBER_INT;
                    this._currToken = jsonToken7;
                    return jsonToken7;
                case 7:
                    switch (b & 31) {
                        case 0:
                        case 4:
                            this._tokenIncomplete = true;
                            JsonToken jsonToken8 = JsonToken.VALUE_STRING;
                            this._currToken = jsonToken8;
                            return jsonToken8;
                        case 8:
                            this._tokenIncomplete = true;
                            JsonToken jsonToken9 = JsonToken.VALUE_EMBEDDED_OBJECT;
                            this._currToken = jsonToken9;
                            return jsonToken9;
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                            if (this._inputPtr >= this._inputEnd) {
                                loadMoreGuaranteed();
                            }
                            byte[] bArr2 = this._inputBuffer;
                            int i4 = this._inputPtr;
                            this._inputPtr = i4 + 1;
                            return _handleSharedString(((b & 3) << 8) + (bArr2[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
                        case 24:
                            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                            JsonToken jsonToken10 = JsonToken.START_ARRAY;
                            this._currToken = jsonToken10;
                            return jsonToken10;
                        case 25:
                            if (!this._parsingContext.inArray()) {
                                _reportMismatchedEndMarker(93, C0359h.f726w);
                            }
                            this._parsingContext = this._parsingContext.mo22000getParent();
                            JsonToken jsonToken11 = JsonToken.END_ARRAY;
                            this._currToken = jsonToken11;
                            return jsonToken11;
                        case 26:
                            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                            JsonToken jsonToken12 = JsonToken.START_OBJECT;
                            this._currToken = jsonToken12;
                            return jsonToken12;
                        case 27:
                            _reportError("Invalid type marker byte 0xFB in value mode (would be END_OBJECT in key mode)");
                            this._tokenIncomplete = true;
                            JsonToken jsonToken13 = JsonToken.VALUE_EMBEDDED_OBJECT;
                            this._currToken = jsonToken13;
                            return jsonToken13;
                        case 29:
                            this._tokenIncomplete = true;
                            JsonToken jsonToken132 = JsonToken.VALUE_EMBEDDED_OBJECT;
                            this._currToken = jsonToken132;
                            return jsonToken132;
                        case 31:
                            this._currToken = null;
                            return null;
                    }
            }
            _reportError("Invalid type marker byte 0x" + Integer.toHexString(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT) + " for expected value token");
            return null;
        }
    }

    @Override // org.codehaus.jackson.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
    }
}
