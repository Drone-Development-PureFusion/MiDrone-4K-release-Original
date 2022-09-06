package org.codehaus.jackson.impl;

import java.io.Reader;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.p316io.IOContext;
/* loaded from: classes2.dex */
public abstract class ReaderBasedNumericParser extends ReaderBasedParserBase {
    public ReaderBasedNumericParser(IOContext iOContext, int i, Reader reader) {
        super(iOContext, i, reader);
    }

    private final char _verifyNoLeadingZeroes() {
        if (this._inputPtr < this._inputEnd || loadMore()) {
            char c = this._inputBuffer[this._inputPtr];
            if (c < '0' || c > '9') {
                return '0';
            }
            if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
                reportInvalidNumber("Leading zeroes not allowed");
            }
            this._inputPtr++;
            if (c != '0') {
                return c;
            }
            do {
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    return c;
                }
                c = this._inputBuffer[this._inputPtr];
                if (c < '0' || c > '9') {
                    return '0';
                }
                this._inputPtr++;
            } while (c == '0');
            return c;
        }
        return '0';
    }

    private final JsonToken parseNumberText2(boolean z) {
        int i;
        char nextChar;
        boolean z2;
        int i2;
        int i3;
        char c;
        char[] cArr;
        int i4;
        char c2;
        char[] cArr2;
        int i5;
        boolean z3;
        char nextChar2;
        int i6;
        char nextChar3;
        char c3;
        int i7;
        int i8;
        int i9;
        boolean z4;
        boolean z5;
        int i10;
        int i11 = 0;
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        if (z) {
            emptyAndGetCurrentSegment[0] = '-';
            i = 1;
        } else {
            i = 0;
        }
        if (this._inputPtr < this._inputEnd) {
            char[] cArr3 = this._inputBuffer;
            int i12 = this._inputPtr;
            this._inputPtr = i12 + 1;
            nextChar = cArr3[i12];
        } else {
            nextChar = getNextChar("No digit following minus sign");
        }
        if (nextChar == '0') {
            nextChar = _verifyNoLeadingZeroes();
        }
        int i13 = 0;
        char c4 = nextChar;
        char[] cArr4 = emptyAndGetCurrentSegment;
        char c5 = c4;
        while (c5 >= '0' && c5 <= '9') {
            i13++;
            if (i >= cArr4.length) {
                cArr4 = this._textBuffer.finishCurrentSegment();
                i = 0;
            }
            int i14 = i + 1;
            cArr4[i] = c5;
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                z2 = true;
                c = 0;
                i2 = i13;
                cArr = cArr4;
                i3 = i14;
                break;
            }
            char[] cArr5 = this._inputBuffer;
            int i15 = this._inputPtr;
            this._inputPtr = i15 + 1;
            c5 = cArr5[i15];
            i = i14;
        }
        z2 = false;
        i2 = i13;
        i3 = i;
        c = c5;
        cArr = cArr4;
        if (i2 == 0) {
            reportInvalidNumber("Missing integer part (next char " + _getCharDesc(c) + ")");
        }
        if (c == '.') {
            int i16 = i3 + 1;
            cArr[i3] = c;
            char[] cArr6 = cArr;
            int i17 = i16;
            char c6 = c;
            int i18 = 0;
            while (true) {
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    c2 = c6;
                    z5 = true;
                    break;
                }
                char[] cArr7 = this._inputBuffer;
                int i19 = this._inputPtr;
                this._inputPtr = i19 + 1;
                c6 = cArr7[i19];
                if (c6 < '0') {
                    c2 = c6;
                    z5 = z2;
                    break;
                } else if (c6 > '9') {
                    c2 = c6;
                    z5 = z2;
                    break;
                } else {
                    i18++;
                    if (i17 >= cArr6.length) {
                        cArr6 = this._textBuffer.finishCurrentSegment();
                        i10 = 0;
                    } else {
                        i10 = i17;
                    }
                    i17 = i10 + 1;
                    cArr6[i10] = c6;
                }
            }
            if (i18 == 0) {
                reportUnexpectedNumberChar(c2, "Decimal point not followed by a digit");
            }
            i4 = i18;
            i5 = i17;
            boolean z6 = z5;
            cArr2 = cArr6;
            z3 = z6;
        } else {
            i4 = 0;
            c2 = c;
            cArr2 = cArr;
            i5 = i3;
            z3 = z2;
        }
        if (c2 == 'e' || c2 == 'E') {
            if (i5 >= cArr2.length) {
                cArr2 = this._textBuffer.finishCurrentSegment();
                i5 = 0;
            }
            int i20 = i5 + 1;
            cArr2[i5] = c2;
            if (this._inputPtr < this._inputEnd) {
                char[] cArr8 = this._inputBuffer;
                int i21 = this._inputPtr;
                this._inputPtr = i21 + 1;
                nextChar2 = cArr8[i21];
            } else {
                nextChar2 = getNextChar("expected a digit for number exponent");
            }
            if (nextChar2 == '-' || nextChar2 == '+') {
                if (i20 >= cArr2.length) {
                    cArr2 = this._textBuffer.finishCurrentSegment();
                    i6 = 0;
                } else {
                    i6 = i20;
                }
                int i22 = i6 + 1;
                cArr2[i6] = nextChar2;
                if (this._inputPtr < this._inputEnd) {
                    char[] cArr9 = this._inputBuffer;
                    int i23 = this._inputPtr;
                    this._inputPtr = i23 + 1;
                    nextChar3 = cArr9[i23];
                } else {
                    nextChar3 = getNextChar("expected a digit for number exponent");
                }
                c3 = nextChar3;
                i7 = i22;
                i8 = 0;
            } else {
                c3 = nextChar2;
                i7 = i20;
                i8 = 0;
            }
            while (c3 <= '9' && c3 >= '0') {
                i8++;
                if (i7 >= cArr2.length) {
                    cArr2 = this._textBuffer.finishCurrentSegment();
                    i7 = 0;
                }
                int i24 = i7 + 1;
                cArr2[i7] = c3;
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    i11 = i8;
                    z4 = true;
                    i9 = i24;
                    break;
                }
                char[] cArr10 = this._inputBuffer;
                int i25 = this._inputPtr;
                this._inputPtr = i25 + 1;
                c3 = cArr10[i25];
                i7 = i24;
            }
            i11 = i8;
            i9 = i7;
            z4 = z3;
            if (i11 == 0) {
                reportUnexpectedNumberChar(c3, "Exponent indicator not followed by a digit");
            }
        } else {
            i9 = i5;
            z4 = z3;
        }
        if (!z4) {
            this._inputPtr--;
        }
        this._textBuffer.setCurrentLength(i9);
        return reset(z, i2, i4, i11);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    protected org.codehaus.jackson.JsonToken _handleInvalidNumberStart(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:227)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:222)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:167)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:366)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r14v0 ??, r14v1 ??, r14v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    protected final org.codehaus.jackson.JsonToken parseNumberText(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r14v0 ??, r14v1 ??, r14v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r14v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:227)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:222)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:167)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:366)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
}
