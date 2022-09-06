package org.codehaus.jackson.impl;

import com.fimi.soul.module.setting.newhand.C3530b;
import java.io.InputStream;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.p316io.IOContext;
import org.codehaus.jackson.smile.SmileConstants;
import org.codehaus.jackson.sym.BytesToNameCanonicalizer;
import org.codehaus.jackson.sym.Name;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.CharTypes;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public final class Utf8StreamParser extends StreamBasedParserBase {
    static final byte BYTE_LF = 10;
    protected ObjectCodec _objectCodec;
    private int _quad1;
    protected final BytesToNameCanonicalizer _symbols;
    private static final int[] sInputCodesUtf8 = CharTypes.getInputCodeUtf8();
    private static final int[] sInputCodesLatin1 = CharTypes.getInputCodeLatin1();
    protected int[] _quadBuffer = new int[16];
    protected boolean _tokenIncomplete = false;

    public Utf8StreamParser(IOContext iOContext, int i, InputStream inputStream, ObjectCodec objectCodec, BytesToNameCanonicalizer bytesToNameCanonicalizer, byte[] bArr, int i2, int i3, boolean z) {
        super(iOContext, i, inputStream, bArr, i2, i3, z);
        this._objectCodec = objectCodec;
        this._symbols = bytesToNameCanonicalizer;
        if (!JsonParser.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i)) {
            _throwInternal();
        }
    }

    private final int _decodeBase64Escape(Base64Variant base64Variant, int i, int i2) {
        if (i != 92) {
            throw reportInvalidChar(base64Variant, i, i2);
        }
        char _decodeEscaped = _decodeEscaped();
        if (_decodeEscaped <= ' ' && i2 == 0) {
            return -1;
        }
        int decodeBase64Char = base64Variant.decodeBase64Char((int) _decodeEscaped);
        if (decodeBase64Char >= 0) {
            return decodeBase64Char;
        }
        throw reportInvalidChar(base64Variant, _decodeEscaped, i2);
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

    private final void _finishString2(char[] cArr, int i) {
        int i2;
        int[] iArr = sInputCodesUtf8;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i3 = this._inputPtr;
            if (i3 >= this._inputEnd) {
                loadMoreGuaranteed();
                i3 = this._inputPtr;
            }
            if (i >= cArr.length) {
                cArr = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int min = Math.min(this._inputEnd, (cArr.length - i) + i3);
            while (true) {
                if (i3 < min) {
                    int i4 = i3 + 1;
                    int i5 = bArr[i3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                    if (iArr[i5] != 0) {
                        this._inputPtr = i4;
                        if (i5 == 34) {
                            this._textBuffer.setCurrentLength(i);
                            return;
                        }
                        switch (iArr[i5]) {
                            case 1:
                                i5 = _decodeEscaped();
                                break;
                            case 2:
                                i5 = _decodeUtf8_2(i5);
                                break;
                            case 3:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    i5 = _decodeUtf8_3(i5);
                                    break;
                                } else {
                                    i5 = _decodeUtf8_3fast(i5);
                                    break;
                                }
                            case 4:
                                int _decodeUtf8_4 = _decodeUtf8_4(i5);
                                int i6 = i + 1;
                                cArr[i] = (char) (55296 | (_decodeUtf8_4 >> 10));
                                if (i6 >= cArr.length) {
                                    cArr = this._textBuffer.finishCurrentSegment();
                                    i6 = 0;
                                }
                                i = i6;
                                i5 = (_decodeUtf8_4 & 1023) | 56320;
                                break;
                            default:
                                if (i5 >= 32) {
                                    _reportInvalidChar(i5);
                                    break;
                                } else {
                                    _throwUnquotedSpace(i5, "string value");
                                    break;
                                }
                        }
                        if (i >= cArr.length) {
                            cArr = this._textBuffer.finishCurrentSegment();
                            i2 = 0;
                        } else {
                            i2 = i;
                        }
                        i = i2 + 1;
                        cArr[i2] = (char) i5;
                    } else {
                        cArr[i] = (char) i5;
                        i3 = i4;
                        i++;
                    }
                } else {
                    this._inputPtr = i3;
                }
            }
        }
    }

    private final JsonToken _nextAfterName() {
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        this._currToken = jsonToken;
        return jsonToken;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final JsonToken _nextTokenNotInObject(int i) {
        if (i == 34) {
            this._tokenIncomplete = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this._currToken = jsonToken;
            return jsonToken;
        }
        switch (i) {
            case 45:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case Opcodes.SALOAD /* 53 */:
            case Opcodes.ISTORE /* 54 */:
            case Opcodes.LSTORE /* 55 */:
            case 56:
            case Opcodes.DSTORE /* 57 */:
                JsonToken parseNumberText = parseNumberText(i);
                this._currToken = parseNumberText;
                return parseNumberText;
            case 91:
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                JsonToken jsonToken2 = JsonToken.START_ARRAY;
                this._currToken = jsonToken2;
                return jsonToken2;
            case Opcodes.DUP2_X1 /* 93 */:
            case 125:
                _reportUnexpectedChar(i, "expected a value");
                break;
            case 102:
                _matchToken(JsonToken.VALUE_FALSE);
                JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
                this._currToken = jsonToken3;
                return jsonToken3;
            case 110:
                _matchToken(JsonToken.VALUE_NULL);
                JsonToken jsonToken4 = JsonToken.VALUE_NULL;
                this._currToken = jsonToken4;
                return jsonToken4;
            case Opcodes.INEG /* 116 */:
                break;
            case Opcodes.LSHR /* 123 */:
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                JsonToken jsonToken5 = JsonToken.START_OBJECT;
                this._currToken = jsonToken5;
                return jsonToken5;
            default:
                JsonToken _handleUnexpectedValue = _handleUnexpectedValue(i);
                this._currToken = _handleUnexpectedValue;
                return _handleUnexpectedValue;
        }
        _matchToken(JsonToken.VALUE_TRUE);
        JsonToken jsonToken6 = JsonToken.VALUE_TRUE;
        this._currToken = jsonToken6;
        return jsonToken6;
    }

    private final JsonToken _parseFloatText(char[] cArr, int i, int i2, boolean z, int i3) {
        int i4;
        char[] cArr2;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11 = 0;
        boolean z3 = false;
        if (i2 == 46) {
            int i12 = i + 1;
            cArr[i] = (char) i2;
            while (true) {
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    z3 = true;
                    break;
                }
                byte[] bArr = this._inputBuffer;
                int i13 = this._inputPtr;
                this._inputPtr = i13 + 1;
                i2 = bArr[i13] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                if (i2 < 48 || i2 > 57) {
                    break;
                }
                i11++;
                if (i12 >= cArr.length) {
                    cArr = this._textBuffer.finishCurrentSegment();
                    i12 = 0;
                }
                int i14 = i12;
                i12 = i14 + 1;
                cArr[i14] = (char) i2;
            }
            if (i11 == 0) {
                reportUnexpectedNumberChar(i2, "Decimal point not followed by a digit");
            }
            i4 = i11;
            i5 = i12;
            cArr2 = cArr;
        } else {
            i4 = 0;
            cArr2 = cArr;
            i5 = i;
        }
        if (i2 == 101 || i2 == 69) {
            if (i5 >= cArr2.length) {
                cArr2 = this._textBuffer.finishCurrentSegment();
                i5 = 0;
            }
            int i15 = i5 + 1;
            cArr2[i5] = (char) i2;
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i16 = this._inputPtr;
            this._inputPtr = i16 + 1;
            int i17 = bArr2[i16] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i17 == 45 || i17 == 43) {
                if (i15 >= cArr2.length) {
                    cArr2 = this._textBuffer.finishCurrentSegment();
                    i6 = 0;
                } else {
                    i6 = i15;
                }
                int i18 = i6 + 1;
                cArr2[i6] = (char) i17;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i19 = this._inputPtr;
                this._inputPtr = i19 + 1;
                i17 = bArr3[i19] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                i7 = i18;
                i8 = 0;
            } else {
                i7 = i15;
                i8 = 0;
            }
            while (i17 <= 57 && i17 >= 48) {
                i8++;
                if (i7 >= cArr2.length) {
                    cArr2 = this._textBuffer.finishCurrentSegment();
                    i7 = 0;
                }
                int i20 = i7 + 1;
                cArr2[i7] = (char) i17;
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    i10 = i8;
                    z2 = true;
                    i9 = i20;
                    break;
                }
                byte[] bArr4 = this._inputBuffer;
                int i21 = this._inputPtr;
                this._inputPtr = i21 + 1;
                i17 = bArr4[i21] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                i7 = i20;
            }
            z2 = z3;
            int i22 = i8;
            i9 = i7;
            i10 = i22;
            if (i10 == 0) {
                reportUnexpectedNumberChar(i17, "Exponent indicator not followed by a digit");
            }
        } else {
            z2 = z3;
            i9 = i5;
            i10 = 0;
        }
        if (!z2) {
            this._inputPtr--;
        }
        this._textBuffer.setCurrentLength(i9);
        return resetFloat(z, i3, i4, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:
        if (r3 == 46) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
        if (r3 == 101) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
        if (r3 != 69) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
        r6._inputPtr--;
        r6._textBuffer.setCurrentLength(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return resetInt(r9, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        return _parseFloatText(r1, r2, r3, r9, r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JsonToken _parserNumber2(char[] cArr, int i, boolean z, int i2) {
        int i3 = i2;
        int i4 = i;
        char[] cArr2 = cArr;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                this._textBuffer.setCurrentLength(i4);
                return resetInt(z, i3);
            }
            byte[] bArr = this._inputBuffer;
            int i5 = this._inputPtr;
            this._inputPtr = i5 + 1;
            int i6 = bArr[i5] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i6 > 57 || i6 < 48) {
                break;
            }
            if (i4 >= cArr2.length) {
                cArr2 = this._textBuffer.finishCurrentSegment();
                i4 = 0;
            }
            int i7 = i4;
            i4 = i7 + 1;
            cArr2[i7] = (char) i6;
            i3++;
        }
    }

    private final void _skipCComment() {
        int[] inputCodeComment = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in a comment");
                return;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            int i3 = inputCodeComment[i2];
            if (i3 != 0) {
                switch (i3) {
                    case 10:
                        _skipLF();
                        continue;
                    case 13:
                        _skipCR();
                        continue;
                    case C3530b.f14177n /* 42 */:
                        if (this._inputBuffer[this._inputPtr] == 47) {
                            this._inputPtr++;
                            return;
                        }
                        continue;
                    default:
                        _reportInvalidChar(i2);
                        continue;
                }
            }
        }
    }

    private final void _skipComment() {
        if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(" in a comment");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (i2 == 47) {
            _skipCppComment();
        } else if (i2 == 42) {
            _skipCComment();
        } else {
            _reportUnexpectedChar(i2, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void _skipCppComment() {
        int[] inputCodeComment = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                int i3 = inputCodeComment[i2];
                if (i3 != 0) {
                    switch (i3) {
                        case 10:
                            _skipLF();
                            return;
                        case 13:
                            _skipCR();
                            return;
                        case C3530b.f14177n /* 42 */:
                            break;
                        default:
                            _reportInvalidChar(i2);
                            continue;
                    }
                }
            } else {
                return;
            }
        }
    }

    private final void _skipUtf8_2(int i) {
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
    }

    private final void _skipUtf8_3(int i) {
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
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte b2 = bArr2[i3];
        if ((b2 & 192) != 128) {
            _reportInvalidOther(b2 & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
    }

    private final void _skipUtf8_4(int i) {
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
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        if ((b & 192) != 128) {
            _reportInvalidOther(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte b2 = bArr2[i3];
        if ((b2 & 192) != 128) {
            _reportInvalidOther(b2 & SmileConstants.BYTE_MARKER_END_OF_CONTENT, this._inputPtr);
        }
    }

    private final int _skipWS() {
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    _skipComment();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        _skipLF();
                    } else if (i2 == 13) {
                        _skipCR();
                    } else if (i2 != 9) {
                        _throwInvalidSpace(i2);
                    }
                }
            } else {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.getTypeDesc() + " entries");
            }
        }
    }

    private final int _skipWSOrEnd() {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _handleEOF();
                return -1;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i2 > 32) {
                if (i2 != 47) {
                    return i2;
                }
                _skipComment();
            } else if (i2 != 32) {
                if (i2 == 10) {
                    _skipLF();
                } else if (i2 == 13) {
                    _skipCR();
                } else if (i2 != 9) {
                    _throwInvalidSpace(i2);
                }
            }
        }
    }

    private final int _verifyNoLeadingZeroes() {
        if (this._inputPtr < this._inputEnd || loadMore()) {
            int i = this._inputBuffer[this._inputPtr] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i < 48 || i > 57) {
                return 48;
            }
            if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
                reportInvalidNumber("Leading zeroes not allowed");
            }
            this._inputPtr++;
            if (i != 48) {
                return i;
            }
            do {
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    return i;
                }
                i = this._inputBuffer[this._inputPtr] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                if (i < 48 || i > 57) {
                    return 48;
                }
                this._inputPtr++;
            } while (i == 48);
            return i;
        }
        return 48;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Name addName(int[] iArr, int i, int i2) {
        int i3;
        char[] cArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = ((i << 2) - 4) + i2;
        if (i2 < 4) {
            i3 = iArr[i - 1];
            iArr[i - 1] = i3 << ((4 - i2) << 3);
        } else {
            i3 = 0;
        }
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i10 = 0;
        int i11 = 0;
        while (i11 < i9) {
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
                if (i13 + i8 > i9) {
                    _reportInvalidEOF(" in field name");
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
        if (i2 < 4) {
            iArr[i - 1] = i3;
        }
        return this._symbols.addName(str, iArr, i);
    }

    private final Name findName(int i, int i2) {
        Name findName = this._symbols.findName(i);
        if (findName != null) {
            return findName;
        }
        this._quadBuffer[0] = i;
        return addName(this._quadBuffer, 1, i2);
    }

    private final Name findName(int i, int i2, int i3) {
        Name findName = this._symbols.findName(i, i2);
        if (findName != null) {
            return findName;
        }
        this._quadBuffer[0] = i;
        this._quadBuffer[1] = i2;
        return addName(this._quadBuffer, 2, i3);
    }

    private final Name findName(int[] iArr, int i, int i2, int i3) {
        if (i >= iArr.length) {
            iArr = growArrayBy(iArr, iArr.length);
            this._quadBuffer = iArr;
        }
        int i4 = i + 1;
        iArr[i] = i2;
        Name findName = this._symbols.findName(iArr, i4);
        return findName == null ? addName(iArr, i4, i3) : findName;
    }

    public static int[] growArrayBy(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        int[] iArr2 = new int[length + i];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    private int nextByte() {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    private final Name parseFieldName(int i, int i2, int i3) {
        return parseEscapedFieldName(this._quadBuffer, 0, i, i2, i3);
    }

    private final Name parseFieldName(int i, int i2, int i3, int i4) {
        this._quadBuffer[0] = i;
        return parseEscapedFieldName(this._quadBuffer, 1, i2, i3, i4);
    }

    @Override // org.codehaus.jackson.impl.JsonParserBase
    protected byte[] _decodeBase64(Base64Variant base64Variant) {
        ByteArrayBuilder _getByteArrayBuilder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i2 > 32) {
                int decodeBase64Char = base64Variant.decodeBase64Char(i2);
                if (decodeBase64Char < 0) {
                    if (i2 == 34) {
                        return _getByteArrayBuilder.toByteArray();
                    }
                    decodeBase64Char = _decodeBase64Escape(base64Variant, i2, 0);
                    if (decodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr2 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int i4 = bArr2[i3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                int decodeBase64Char2 = base64Variant.decodeBase64Char(i4);
                if (decodeBase64Char2 < 0) {
                    decodeBase64Char2 = _decodeBase64Escape(base64Variant, i4, 1);
                }
                int i5 = decodeBase64Char2 | (decodeBase64Char << 6);
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i6 = this._inputPtr;
                this._inputPtr = i6 + 1;
                int i7 = bArr3[i6] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                int decodeBase64Char3 = base64Variant.decodeBase64Char(i7);
                if (decodeBase64Char3 < 0) {
                    if (decodeBase64Char3 != -2) {
                        if (i7 == 34 && !base64Variant.usesPadding()) {
                            _getByteArrayBuilder.append(i5 >> 4);
                            return _getByteArrayBuilder.toByteArray();
                        }
                        decodeBase64Char3 = _decodeBase64Escape(base64Variant, i7, 2);
                    }
                    if (decodeBase64Char3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        byte[] bArr4 = this._inputBuffer;
                        int i8 = this._inputPtr;
                        this._inputPtr = i8 + 1;
                        int i9 = bArr4[i8] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                        if (!base64Variant.usesPaddingChar(i9)) {
                            throw reportInvalidChar(base64Variant, i9, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        _getByteArrayBuilder.append(i5 >> 4);
                    }
                }
                int i10 = (i5 << 6) | decodeBase64Char3;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr5 = this._inputBuffer;
                int i11 = this._inputPtr;
                this._inputPtr = i11 + 1;
                int i12 = bArr5[i11] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                int decodeBase64Char4 = base64Variant.decodeBase64Char(i12);
                if (decodeBase64Char4 < 0) {
                    if (decodeBase64Char4 != -2) {
                        if (i12 == 34 && !base64Variant.usesPadding()) {
                            _getByteArrayBuilder.appendTwoBytes(i10 >> 2);
                            return _getByteArrayBuilder.toByteArray();
                        }
                        decodeBase64Char4 = _decodeBase64Escape(base64Variant, i12, 3);
                    }
                    if (decodeBase64Char4 == -2) {
                        _getByteArrayBuilder.appendTwoBytes(i10 >> 2);
                    }
                }
                _getByteArrayBuilder.appendThreeBytes(decodeBase64Char4 | (i10 << 6));
            }
        }
    }

    protected int _decodeCharForError(int i) {
        char c;
        if (i < 0) {
            if ((i & 224) == 192) {
                i &= 31;
                c = 1;
            } else if ((i & 240) == 224) {
                i &= 15;
                c = 2;
            } else if ((i & 248) == 240) {
                i &= 7;
                c = 3;
            } else {
                _reportInvalidInitial(i & 255);
                c = 1;
            }
            int nextByte = nextByte();
            if ((nextByte & 192) != 128) {
                _reportInvalidOther(nextByte & 255);
            }
            int i2 = (i << 6) | (nextByte & 63);
            if (c <= 1) {
                return i2;
            }
            int nextByte2 = nextByte();
            if ((nextByte2 & 192) != 128) {
                _reportInvalidOther(nextByte2 & 255);
            }
            int i3 = (i2 << 6) | (nextByte2 & 63);
            if (c <= 2) {
                return i3;
            }
            int nextByte3 = nextByte();
            if ((nextByte3 & 192) != 128) {
                _reportInvalidOther(nextByte3 & 255);
            }
            return (i3 << 6) | (nextByte3 & 63);
        }
        return i;
    }

    protected final char _decodeEscaped() {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(" in character escape sequence");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        switch (b) {
            case 34:
            case 47:
            case Opcodes.DUP2 /* 92 */:
                return (char) b;
            case 98:
                return '\b';
            case 102:
                return '\f';
            case 110:
                return '\n';
            case 114:
                return C5122l.f21761a;
            case Opcodes.INEG /* 116 */:
                return '\t';
            case Opcodes.LNEG /* 117 */:
                int i2 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this._inputPtr >= this._inputEnd && !loadMore()) {
                        _reportInvalidEOF(" in character escape sequence");
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i4 = this._inputPtr;
                    this._inputPtr = i4 + 1;
                    byte b2 = bArr2[i4];
                    int charToHex = CharTypes.charToHex(b2);
                    if (charToHex < 0) {
                        _reportUnexpectedChar(b2, "expected a hex-digit for character escape sequence");
                    }
                    i2 = (i2 << 4) | charToHex;
                }
                return (char) i2;
            default:
                return _handleUnrecognizedCharacterEscape((char) _decodeCharForError(b));
        }
    }

    @Override // org.codehaus.jackson.impl.JsonParserBase
    protected void _finishString() {
        int i = this._inputPtr;
        if (i >= this._inputEnd) {
            loadMoreGuaranteed();
            i = this._inputPtr;
        }
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = sInputCodesUtf8;
        int min = Math.min(this._inputEnd, emptyAndGetCurrentSegment.length + i);
        byte[] bArr = this._inputBuffer;
        int i2 = i;
        int i3 = 0;
        while (true) {
            if (i2 >= min) {
                break;
            }
            int i4 = bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (iArr[i4] == 0) {
                emptyAndGetCurrentSegment[i3] = (char) i4;
                i3++;
                i2++;
            } else if (i4 == 34) {
                this._inputPtr = i2 + 1;
                this._textBuffer.setCurrentLength(i3);
                return;
            }
        }
        this._inputPtr = i2;
        _finishString2(emptyAndGetCurrentSegment, i3);
    }

    protected final String _getText2(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (jsonToken) {
            case FIELD_NAME:
                return this._parsingContext.getCurrentName();
            case VALUE_STRING:
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                return this._textBuffer.contentsAsString();
            default:
                return jsonToken.asString();
        }
    }

    protected JsonToken _handleApostropheValue() {
        int i;
        int i2;
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = sInputCodesUtf8;
        byte[] bArr = this._inputBuffer;
        int i3 = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            if (i3 >= emptyAndGetCurrentSegment.length) {
                emptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i3 = 0;
            }
            int i4 = this._inputEnd;
            int length = this._inputPtr + (emptyAndGetCurrentSegment.length - i3);
            if (length >= i4) {
                length = i4;
            }
            while (this._inputPtr < length) {
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int i6 = bArr[i5] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                if (i6 != 39 && iArr[i6] == 0) {
                    emptyAndGetCurrentSegment[i3] = (char) i6;
                    i3++;
                } else if (i6 == 39) {
                    this._textBuffer.setCurrentLength(i3);
                    return JsonToken.VALUE_STRING;
                } else {
                    switch (iArr[i6]) {
                        case 1:
                            if (i6 != 34) {
                                i = _decodeEscaped();
                                break;
                            }
                            i = i6;
                            break;
                        case 2:
                            i = _decodeUtf8_2(i6);
                            break;
                        case 3:
                            if (this._inputEnd - this._inputPtr < 2) {
                                i = _decodeUtf8_3(i6);
                                break;
                            } else {
                                i = _decodeUtf8_3fast(i6);
                                break;
                            }
                        case 4:
                            int _decodeUtf8_4 = _decodeUtf8_4(i6);
                            int i7 = i3 + 1;
                            emptyAndGetCurrentSegment[i3] = (char) (55296 | (_decodeUtf8_4 >> 10));
                            if (i7 >= emptyAndGetCurrentSegment.length) {
                                emptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                                i3 = 0;
                            } else {
                                i3 = i7;
                            }
                            i = 56320 | (_decodeUtf8_4 & 1023);
                            break;
                        default:
                            if (i6 < 32) {
                                _throwUnquotedSpace(i6, "string value");
                            }
                            _reportInvalidChar(i6);
                            i = i6;
                            break;
                    }
                    if (i3 >= emptyAndGetCurrentSegment.length) {
                        emptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                        i2 = 0;
                    } else {
                        i2 = i3;
                    }
                    i3 = i2 + 1;
                    emptyAndGetCurrentSegment[i2] = (char) i;
                }
            }
        }
    }

    protected JsonToken _handleInvalidNumberStart(int i, boolean z) {
        double d = Double.NEGATIVE_INFINITY;
        if (i == 73) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOFInValue();
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            i = bArr[i2];
            if (i == 78) {
                String str = z ? "-INF" : "+INF";
                if (_matchToken(str, 3)) {
                    if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                        if (!z) {
                            d = Double.POSITIVE_INFINITY;
                        }
                        return resetAsNaN(str, d);
                    }
                    _reportError("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                }
            } else if (i == 110) {
                String str2 = z ? "-Infinity" : "+Infinity";
                if (_matchToken(str2, 3)) {
                    if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                        if (!z) {
                            d = Double.POSITIVE_INFINITY;
                        }
                        return resetAsNaN(str2, d);
                    }
                    _reportError("Non-standard token '" + str2 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                }
            }
        }
        reportUnexpectedNumberChar(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    protected JsonToken _handleUnexpectedValue(int i) {
        switch (i) {
            case 39:
                if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
                    return _handleApostropheValue();
                }
                break;
            case C3530b.f14178o /* 43 */:
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    _reportInvalidEOFInValue();
                }
                byte[] bArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                return _handleInvalidNumberStart(bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT, false);
            case 78:
                if (_matchToken("NaN", 1)) {
                    if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                        return resetAsNaN("NaN", Double.NaN);
                    }
                    _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                }
                byte[] bArr2 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                _reportUnexpectedChar(bArr2[i3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT, "expected 'NaN' or a valid value");
                break;
        }
        _reportUnexpectedChar(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    protected final Name _handleUnusualFieldName(int i) {
        int[] iArr;
        int i2;
        int i3;
        int i4;
        if (i != 39 || !isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
                _reportUnexpectedChar(i, "was expecting double-quote to start field name");
            }
            int[] inputCodeUtf8JsNames = CharTypes.getInputCodeUtf8JsNames();
            if (inputCodeUtf8JsNames[i] != 0) {
                _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = i;
            int i8 = 0;
            int[] iArr2 = this._quadBuffer;
            while (true) {
                if (i5 < 4) {
                    int i9 = i5 + 1;
                    i3 = i7 | (i6 << 8);
                    i4 = i8;
                    iArr = iArr2;
                    i2 = i9;
                } else {
                    if (i8 >= iArr2.length) {
                        iArr2 = growArrayBy(iArr2, iArr2.length);
                        this._quadBuffer = iArr2;
                    }
                    int i10 = i8 + 1;
                    iArr2[i8] = i6;
                    iArr = iArr2;
                    i2 = 1;
                    i3 = i7;
                    i4 = i10;
                }
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    _reportInvalidEOF(" in field name");
                }
                int i11 = this._inputBuffer[this._inputPtr] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                if (inputCodeUtf8JsNames[i11] != 0) {
                    break;
                }
                this._inputPtr++;
                i6 = i3;
                i5 = i2;
                iArr2 = iArr;
                i8 = i4;
                i7 = i11;
            }
            if (i2 > 0) {
                if (i4 >= iArr.length) {
                    iArr = growArrayBy(iArr, iArr.length);
                    this._quadBuffer = iArr;
                }
                iArr[i4] = i3;
                i4++;
            }
            Name findName = this._symbols.findName(iArr, i4);
            return findName == null ? addName(iArr, i4, i2) : findName;
        }
        return _parseApostropheFieldName();
    }

    protected void _matchToken(JsonToken jsonToken) {
        byte[] asByteArray = jsonToken.asByteArray();
        int length = asByteArray.length;
        for (int i = 1; i < length; i++) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            if (asByteArray[i] != this._inputBuffer[this._inputPtr]) {
                _reportInvalidToken(jsonToken.asString().substring(0, i), "'null', 'true' or 'false'");
            }
            this._inputPtr++;
        }
    }

    protected final boolean _matchToken(String str, int i) {
        int length = str.length();
        do {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in a value");
            }
            if (this._inputBuffer[this._inputPtr] != str.charAt(i)) {
                _reportInvalidToken(str.substring(0, i), "'null', 'true', 'false' or NaN");
            }
            this._inputPtr++;
            i++;
        } while (i < length);
        if ((this._inputPtr < this._inputEnd || loadMore()) && Character.isJavaIdentifierPart((char) _decodeCharForError(this._inputBuffer[this._inputPtr] & SmileConstants.BYTE_MARKER_END_OF_CONTENT))) {
            this._inputPtr++;
            _reportInvalidToken(str.substring(0, i), "'null', 'true', 'false' or NaN");
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final Name _parseApostropheFieldName() {
        int[] iArr;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int[] iArr3;
        int i13;
        int i14;
        int i15;
        int[] iArr4;
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(": was expecting closing ''' for name");
        }
        byte[] bArr = this._inputBuffer;
        int i16 = this._inputPtr;
        this._inputPtr = i16 + 1;
        int i17 = bArr[i16] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (i17 == 39) {
            return BytesToNameCanonicalizer.getEmptyName();
        }
        int[] iArr5 = this._quadBuffer;
        int[] iArr6 = sInputCodesLatin1;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (i17 != 39) {
            if (i17 != 34 && iArr6[i17] != 0) {
                if (i17 != 92) {
                    _throwUnquotedSpace(i17, "name");
                } else {
                    i17 = _decodeEscaped();
                }
                if (i17 > 127) {
                    if (i18 >= 4) {
                        if (i20 >= iArr5.length) {
                            iArr5 = growArrayBy(iArr5, iArr5.length);
                            this._quadBuffer = iArr5;
                        }
                        int i21 = i20 + 1;
                        iArr5[i20] = i19;
                        i10 = 0;
                        i3 = i21;
                        i9 = 0;
                    } else {
                        int i22 = i18;
                        i9 = i19;
                        i3 = i20;
                        i10 = i22;
                    }
                    if (i17 < 2048) {
                        int i23 = i10 + 1;
                        i14 = (i9 << 8) | (i17 >> 6) | 192;
                        iArr4 = iArr5;
                        i15 = i23;
                    } else {
                        int i24 = (i9 << 8) | (i17 >> 12) | 224;
                        int i25 = i10 + 1;
                        if (i25 >= 4) {
                            if (i3 >= iArr5.length) {
                                iArr5 = growArrayBy(iArr5, iArr5.length);
                                this._quadBuffer = iArr5;
                            }
                            iArr5[i3] = i24;
                            i12 = i3 + 1;
                            iArr3 = iArr5;
                            i13 = 0;
                            i11 = 0;
                        } else {
                            i11 = i24;
                            i12 = i3;
                            iArr3 = iArr5;
                            i13 = i25;
                        }
                        i14 = (i11 << 8) | ((i17 >> 6) & 63) | 128;
                        i15 = i13 + 1;
                        int i26 = i12;
                        iArr4 = iArr3;
                        i3 = i26;
                    }
                    i2 = i14;
                    i4 = i15;
                    iArr5 = iArr4;
                    i5 = (i17 & 63) | 128;
                    if (i4 >= 4) {
                        int i27 = i4 + 1;
                        i7 = i5 | (i2 << 8);
                        i8 = i3;
                        iArr2 = iArr5;
                        i6 = i27;
                    } else {
                        if (i3 >= iArr5.length) {
                            iArr5 = growArrayBy(iArr5, iArr5.length);
                            this._quadBuffer = iArr5;
                        }
                        int i28 = i3 + 1;
                        iArr5[i3] = i2;
                        iArr2 = iArr5;
                        i6 = 1;
                        i7 = i5;
                        i8 = i28;
                    }
                    if (this._inputPtr >= this._inputEnd && !loadMore()) {
                        _reportInvalidEOF(" in field name");
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i29 = this._inputPtr;
                    this._inputPtr = i29 + 1;
                    i17 = bArr2[i29] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                    int i30 = i6;
                    iArr5 = iArr2;
                    i19 = i7;
                    i20 = i8;
                    i18 = i30;
                }
            }
            i2 = i19;
            i3 = i20;
            i4 = i18;
            i5 = i17;
            if (i4 >= 4) {
            }
            if (this._inputPtr >= this._inputEnd) {
                _reportInvalidEOF(" in field name");
            }
            byte[] bArr22 = this._inputBuffer;
            int i292 = this._inputPtr;
            this._inputPtr = i292 + 1;
            i17 = bArr22[i292] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            int i302 = i6;
            iArr5 = iArr2;
            i19 = i7;
            i20 = i8;
            i18 = i302;
        }
        if (i18 > 0) {
            if (i20 >= iArr5.length) {
                iArr5 = growArrayBy(iArr5, iArr5.length);
                this._quadBuffer = iArr5;
            }
            iArr5[i20] = i19;
            iArr = iArr5;
            i = i20 + 1;
        } else {
            iArr = iArr5;
            i = i20;
        }
        Name findName = this._symbols.findName(iArr, i);
        return findName == null ? addName(iArr, i, i18) : findName;
    }

    protected final Name _parseFieldName(int i) {
        if (i != 34) {
            return _handleUnusualFieldName(i);
        }
        if (this._inputPtr + 9 > this._inputEnd) {
            return slowParseFieldName();
        }
        byte[] bArr = this._inputBuffer;
        int[] iArr = sInputCodesLatin1;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        int i3 = bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (iArr[i3] != 0) {
            return i3 == 34 ? BytesToNameCanonicalizer.getEmptyName() : parseFieldName(0, i3, 0);
        }
        int i4 = this._inputPtr;
        this._inputPtr = i4 + 1;
        int i5 = bArr[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (iArr[i5] != 0) {
            return i5 == 34 ? findName(i3, 1) : parseFieldName(i3, i5, 1);
        }
        int i6 = (i3 << 8) | i5;
        int i7 = this._inputPtr;
        this._inputPtr = i7 + 1;
        int i8 = bArr[i7] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (iArr[i8] != 0) {
            return i8 == 34 ? findName(i6, 2) : parseFieldName(i6, i8, 2);
        }
        int i9 = (i6 << 8) | i8;
        int i10 = this._inputPtr;
        this._inputPtr = i10 + 1;
        int i11 = bArr[i10] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (iArr[i11] != 0) {
            return i11 == 34 ? findName(i9, 3) : parseFieldName(i9, i11, 3);
        }
        int i12 = (i9 << 8) | i11;
        int i13 = this._inputPtr;
        this._inputPtr = i13 + 1;
        int i14 = bArr[i13] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (iArr[i14] != 0) {
            return i14 == 34 ? findName(i12, 4) : parseFieldName(i12, i14, 4);
        }
        this._quad1 = i12;
        return parseMediumFieldName(i14, iArr);
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

    protected void _reportInvalidToken(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                break;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char _decodeCharForError = (char) _decodeCharForError(bArr[i]);
            if (!Character.isJavaIdentifierPart(_decodeCharForError)) {
                break;
            }
            this._inputPtr++;
            sb.append(_decodeCharForError);
        }
        _reportError("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
    }

    protected final void _skipCR() {
        if ((this._inputPtr < this._inputEnd || loadMore()) && this._inputBuffer[this._inputPtr] == 10) {
            this._inputPtr++;
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    protected final void _skipLF() {
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    protected void _skipString() {
        this._tokenIncomplete = false;
        int[] iArr = sInputCodesUtf8;
        byte[] bArr = this._inputBuffer;
        while (true) {
            int i = this._inputPtr;
            int i2 = this._inputEnd;
            if (i >= i2) {
                loadMoreGuaranteed();
                i = this._inputPtr;
                i2 = this._inputEnd;
            }
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    int i4 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                    if (iArr[i4] != 0) {
                        this._inputPtr = i3;
                        if (i4 == 34) {
                            return;
                        }
                        switch (iArr[i4]) {
                            case 1:
                                _decodeEscaped();
                                continue;
                            case 2:
                                _skipUtf8_2(i4);
                                continue;
                            case 3:
                                _skipUtf8_3(i4);
                                continue;
                            case 4:
                                _skipUtf8_4(i4);
                                continue;
                            default:
                                if (i4 < 32) {
                                    _throwUnquotedSpace(i4, "string value");
                                    break;
                                } else {
                                    _reportInvalidChar(i4);
                                    continue;
                                }
                        }
                    } else {
                        i = i3;
                    }
                } else {
                    this._inputPtr = i;
                }
            }
        }
    }

    @Override // org.codehaus.jackson.impl.JsonParserBase, org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this._symbols.release();
    }

    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) {
        if (this._currToken != JsonToken.VALUE_STRING && (this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT || this._binaryValue == null)) {
            _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this._tokenIncomplete) {
            try {
                this._binaryValue = _decodeBase64(base64Variant);
                this._tokenIncomplete = false;
            } catch (IllegalArgumentException e) {
                throw _constructError("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e.getMessage());
            }
        }
        return this._binaryValue;
    }

    @Override // org.codehaus.jackson.JsonParser
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public String getText() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        }
        return _getText2(jsonToken);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public char[] getTextCharacters() {
        if (this._currToken != null) {
            switch (this._currToken) {
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
                case VALUE_STRING:
                    if (this._tokenIncomplete) {
                        this._tokenIncomplete = false;
                        _finishString();
                        break;
                    }
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    break;
                default:
                    return this._currToken.asCharArray();
            }
            return this._textBuffer.getTextBuffer();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public int getTextLength() {
        if (this._currToken != null) {
            switch (this._currToken) {
                case FIELD_NAME:
                    return this._parsingContext.getCurrentName().length();
                case VALUE_STRING:
                    if (this._tokenIncomplete) {
                        this._tokenIncomplete = false;
                        _finishString();
                        break;
                    }
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    break;
                default:
                    return this._currToken.asCharArray().length;
            }
            return this._textBuffer.size();
        }
        return 0;
    }

    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public int getTextOffset() {
        if (this._currToken != null) {
            switch (this._currToken) {
                case FIELD_NAME:
                default:
                    return 0;
                case VALUE_STRING:
                    if (this._tokenIncomplete) {
                        this._tokenIncomplete = false;
                        _finishString();
                        break;
                    }
                    break;
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                    break;
            }
            return this._textBuffer.getTextOffset();
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
    public JsonToken nextToken() {
        JsonToken parseNumberText;
        if (this._currToken == JsonToken.FIELD_NAME) {
            return _nextAfterName();
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int _skipWSOrEnd = _skipWSOrEnd();
        if (_skipWSOrEnd < 0) {
            close();
            this._currToken = null;
            return null;
        }
        this._tokenInputTotal = (this._currInputProcessed + this._inputPtr) - 1;
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = (this._inputPtr - this._currInputRowStart) - 1;
        this._binaryValue = null;
        if (_skipWSOrEnd == 93) {
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(_skipWSOrEnd, C0359h.f726w);
            }
            this._parsingContext = this._parsingContext.mo22000getParent();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            this._currToken = jsonToken;
            return jsonToken;
        } else if (_skipWSOrEnd == 125) {
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(_skipWSOrEnd, ']');
            }
            this._parsingContext = this._parsingContext.mo22000getParent();
            JsonToken jsonToken2 = JsonToken.END_OBJECT;
            this._currToken = jsonToken2;
            return jsonToken2;
        } else {
            if (this._parsingContext.expectComma()) {
                if (_skipWSOrEnd != 44) {
                    _reportUnexpectedChar(_skipWSOrEnd, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
                }
                _skipWSOrEnd = _skipWS();
            }
            if (!this._parsingContext.inObject()) {
                return _nextTokenNotInObject(_skipWSOrEnd);
            }
            this._parsingContext.setCurrentName(_parseFieldName(_skipWSOrEnd).getName());
            this._currToken = JsonToken.FIELD_NAME;
            int _skipWS = _skipWS();
            if (_skipWS != 58) {
                _reportUnexpectedChar(_skipWS, "was expecting a colon to separate field name and value");
            }
            int _skipWS2 = _skipWS();
            if (_skipWS2 == 34) {
                this._tokenIncomplete = true;
                this._nextToken = JsonToken.VALUE_STRING;
                return this._currToken;
            }
            switch (_skipWS2) {
                case 45:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case Opcodes.SALOAD /* 53 */:
                case Opcodes.ISTORE /* 54 */:
                case Opcodes.LSTORE /* 55 */:
                case 56:
                case Opcodes.DSTORE /* 57 */:
                    parseNumberText = parseNumberText(_skipWS2);
                    break;
                case 91:
                    parseNumberText = JsonToken.START_ARRAY;
                    break;
                case Opcodes.DUP2_X1 /* 93 */:
                case 125:
                    _reportUnexpectedChar(_skipWS2, "expected a value");
                    _matchToken(JsonToken.VALUE_TRUE);
                    parseNumberText = JsonToken.VALUE_TRUE;
                    break;
                case 102:
                    _matchToken(JsonToken.VALUE_FALSE);
                    parseNumberText = JsonToken.VALUE_FALSE;
                    break;
                case 110:
                    _matchToken(JsonToken.VALUE_NULL);
                    parseNumberText = JsonToken.VALUE_NULL;
                    break;
                case Opcodes.INEG /* 116 */:
                    _matchToken(JsonToken.VALUE_TRUE);
                    parseNumberText = JsonToken.VALUE_TRUE;
                    break;
                case Opcodes.LSHR /* 123 */:
                    parseNumberText = JsonToken.START_OBJECT;
                    break;
                default:
                    parseNumberText = _handleUnexpectedValue(_skipWS2);
                    break;
            }
            this._nextToken = parseNumberText;
            return this._currToken;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Name parseEscapedFieldName(int[] iArr, int i, int i2, int i3, int i4) {
        int i5;
        int[] iArr2;
        int i6;
        int[] iArr3;
        int i7;
        int i8;
        int[] iArr4;
        int i9;
        int i10;
        int i11;
        int[] iArr5;
        int[] iArr6 = sInputCodesLatin1;
        while (true) {
            if (iArr6[i3] != 0) {
                if (i3 == 34) {
                    break;
                }
                if (i3 != 92) {
                    _throwUnquotedSpace(i3, "name");
                } else {
                    i3 = _decodeEscaped();
                }
                if (i3 > 127) {
                    if (i4 >= 4) {
                        if (i >= iArr.length) {
                            iArr = growArrayBy(iArr, iArr.length);
                            this._quadBuffer = iArr;
                        }
                        i6 = i + 1;
                        iArr[i] = i2;
                        i4 = 0;
                        i2 = 0;
                        iArr3 = iArr;
                    } else {
                        i6 = i;
                        iArr3 = iArr;
                    }
                    if (i3 < 2048) {
                        i10 = (i3 >> 6) | 192 | (i2 << 8);
                        iArr5 = iArr3;
                        i11 = i4 + 1;
                    } else {
                        int i12 = (i3 >> 12) | 224 | (i2 << 8);
                        int i13 = i4 + 1;
                        if (i13 >= 4) {
                            if (i6 >= iArr3.length) {
                                iArr3 = growArrayBy(iArr3, iArr3.length);
                                this._quadBuffer = iArr3;
                            }
                            iArr3[i6] = i12;
                            i8 = i6 + 1;
                            iArr4 = iArr3;
                            i9 = 0;
                            i7 = 0;
                        } else {
                            i7 = i12;
                            i8 = i6;
                            iArr4 = iArr3;
                            i9 = i13;
                        }
                        i10 = (i7 << 8) | ((i3 >> 6) & 63) | 128;
                        i11 = i9 + 1;
                        int i14 = i8;
                        iArr5 = iArr4;
                        i6 = i14;
                    }
                    i2 = (i3 & 63) | 128;
                    i4 = i11;
                    i = i6;
                    iArr2 = iArr5;
                    i5 = i10;
                    if (i4 >= 4) {
                        i4++;
                        i2 |= i5 << 8;
                        iArr = iArr2;
                    } else {
                        if (i >= iArr2.length) {
                            iArr2 = growArrayBy(iArr2, iArr2.length);
                            this._quadBuffer = iArr2;
                        }
                        iArr2[i] = i5;
                        i4 = 1;
                        i++;
                        iArr = iArr2;
                    }
                    if (this._inputPtr >= this._inputEnd && !loadMore()) {
                        _reportInvalidEOF(" in field name");
                    }
                    byte[] bArr = this._inputBuffer;
                    int i15 = this._inputPtr;
                    this._inputPtr = i15 + 1;
                    i3 = bArr[i15] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                }
            }
            i5 = i2;
            iArr2 = iArr;
            i2 = i3;
            if (i4 >= 4) {
            }
            if (this._inputPtr >= this._inputEnd) {
                _reportInvalidEOF(" in field name");
            }
            byte[] bArr2 = this._inputBuffer;
            int i152 = this._inputPtr;
            this._inputPtr = i152 + 1;
            i3 = bArr2[i152] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        }
        if (i4 > 0) {
            if (i >= iArr.length) {
                iArr = growArrayBy(iArr, iArr.length);
                this._quadBuffer = iArr;
            }
            iArr[i] = i2;
            i++;
        }
        Name findName = this._symbols.findName(iArr, i);
        return findName == null ? addName(iArr, i, i4) : findName;
    }

    protected Name parseLongFieldName(int i) {
        int[] iArr = sInputCodesLatin1;
        int i2 = 2;
        int i3 = i;
        while (this._inputEnd - this._inputPtr >= 4) {
            byte[] bArr = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            int i5 = bArr[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (iArr[i5] != 0) {
                return i5 == 34 ? findName(this._quadBuffer, i2, i3, 1) : parseEscapedFieldName(this._quadBuffer, i2, i3, i5, 1);
            }
            int i6 = (i3 << 8) | i5;
            byte[] bArr2 = this._inputBuffer;
            int i7 = this._inputPtr;
            this._inputPtr = i7 + 1;
            int i8 = bArr2[i7] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (iArr[i8] != 0) {
                return i8 == 34 ? findName(this._quadBuffer, i2, i6, 2) : parseEscapedFieldName(this._quadBuffer, i2, i6, i8, 2);
            }
            int i9 = (i6 << 8) | i8;
            byte[] bArr3 = this._inputBuffer;
            int i10 = this._inputPtr;
            this._inputPtr = i10 + 1;
            int i11 = bArr3[i10] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (iArr[i11] != 0) {
                return i11 == 34 ? findName(this._quadBuffer, i2, i9, 3) : parseEscapedFieldName(this._quadBuffer, i2, i9, i11, 3);
            }
            int i12 = (i9 << 8) | i11;
            byte[] bArr4 = this._inputBuffer;
            int i13 = this._inputPtr;
            this._inputPtr = i13 + 1;
            i3 = bArr4[i13] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (iArr[i3] != 0) {
                return i3 == 34 ? findName(this._quadBuffer, i2, i12, 4) : parseEscapedFieldName(this._quadBuffer, i2, i12, i3, 4);
            }
            if (i2 >= this._quadBuffer.length) {
                this._quadBuffer = growArrayBy(this._quadBuffer, i2);
            }
            this._quadBuffer[i2] = i12;
            i2++;
        }
        return parseEscapedFieldName(this._quadBuffer, i2, 0, i3, 0);
    }

    protected final Name parseMediumFieldName(int i, int[] iArr) {
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        int i3 = bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (iArr[i3] != 0) {
            return i3 == 34 ? findName(this._quad1, i, 1) : parseFieldName(this._quad1, i, i3, 1);
        }
        int i4 = i3 | (i << 8);
        byte[] bArr2 = this._inputBuffer;
        int i5 = this._inputPtr;
        this._inputPtr = i5 + 1;
        int i6 = bArr2[i5] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (iArr[i6] != 0) {
            return i6 == 34 ? findName(this._quad1, i4, 2) : parseFieldName(this._quad1, i4, i6, 2);
        }
        int i7 = (i4 << 8) | i6;
        byte[] bArr3 = this._inputBuffer;
        int i8 = this._inputPtr;
        this._inputPtr = i8 + 1;
        int i9 = bArr3[i8] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (iArr[i9] != 0) {
            return i9 == 34 ? findName(this._quad1, i7, 3) : parseFieldName(this._quad1, i7, i9, 3);
        }
        int i10 = (i7 << 8) | i9;
        byte[] bArr4 = this._inputBuffer;
        int i11 = this._inputPtr;
        this._inputPtr = i11 + 1;
        int i12 = bArr4[i11] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (iArr[i12] != 0) {
            return i12 == 34 ? findName(this._quad1, i10, 4) : parseFieldName(this._quad1, i10, i12, 4);
        }
        this._quadBuffer[0] = this._quad1;
        this._quadBuffer[1] = i10;
        return parseLongFieldName(i12);
    }

    protected final JsonToken parseNumberText(int i) {
        int i2;
        int i3;
        int i4 = 1;
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        boolean z = i == 45;
        if (z) {
            emptyAndGetCurrentSegment[0] = '-';
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i5 = this._inputPtr;
            this._inputPtr = i5 + 1;
            i3 = bArr[i5] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i3 < 48 || i3 > 57) {
                return _handleInvalidNumberStart(i3, true);
            }
            i2 = 1;
        } else {
            i2 = 0;
            i3 = i;
        }
        if (i3 == 48) {
            i3 = _verifyNoLeadingZeroes();
        }
        int i6 = i2 + 1;
        emptyAndGetCurrentSegment[i2] = (char) i3;
        int length = this._inputPtr + emptyAndGetCurrentSegment.length;
        if (length > this._inputEnd) {
            length = this._inputEnd;
        }
        while (this._inputPtr < length) {
            byte[] bArr2 = this._inputBuffer;
            int i7 = this._inputPtr;
            this._inputPtr = i7 + 1;
            int i8 = bArr2[i7] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i8 < 48 || i8 > 57) {
                if (i8 == 46 || i8 == 101 || i8 == 69) {
                    return _parseFloatText(emptyAndGetCurrentSegment, i6, i8, z, i4);
                }
                this._inputPtr--;
                this._textBuffer.setCurrentLength(i6);
                return resetInt(z, i4);
            }
            i4++;
            emptyAndGetCurrentSegment[i6] = (char) i8;
            i6++;
        }
        return _parserNumber2(emptyAndGetCurrentSegment, i6, z, i4);
    }

    protected IllegalArgumentException reportInvalidChar(Base64Variant base64Variant, int i, int i2) {
        return reportInvalidChar(base64Variant, i, i2, null);
    }

    protected IllegalArgumentException reportInvalidChar(Base64Variant base64Variant, int i, int i2, String str) {
        String str2 = i <= 32 ? "Illegal white space character (code 0x" + Integer.toHexString(i) + ") as character #" + (i2 + 1) + " of 4-char base64 unit: can only used between units" : base64Variant.usesPaddingChar(i) ? "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character" : (!Character.isDefined(i) || Character.isISOControl(i)) ? "Illegal character (code 0x" + Integer.toHexString(i) + ") in base64 content" : "Illegal character '" + ((char) i) + "' (code 0x" + Integer.toHexString(i) + ") in base64 content";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }

    @Override // org.codehaus.jackson.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
    }

    protected Name slowParseFieldName() {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(": was expecting closing '\"' for name");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        return i2 == 34 ? BytesToNameCanonicalizer.getEmptyName() : parseEscapedFieldName(this._quadBuffer, 0, 0, i2, 0);
    }
}
