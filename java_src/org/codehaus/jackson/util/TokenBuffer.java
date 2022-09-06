package org.codehaus.jackson.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.impl.JsonParserMinimalBase;
import org.codehaus.jackson.impl.JsonReadContext;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.p316io.SerializedString;
/* loaded from: classes2.dex */
public class TokenBuffer extends JsonGenerator {
    protected static final int DEFAULT_PARSER_FEATURES = JsonParser.Feature.collectDefaults();
    protected boolean _closed;
    protected Segment _first;
    protected Segment _last;
    protected ObjectCodec _objectCodec;
    protected int _generatorFeatures = DEFAULT_PARSER_FEATURES;
    protected JsonWriteContext _writeContext = JsonWriteContext.createRootContext();
    protected int _appendOffset = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class Parser extends JsonParserMinimalBase {
        protected transient ByteArrayBuilder _byteBuilder;
        protected boolean _closed;
        protected ObjectCodec _codec;
        protected Segment _segment;
        protected JsonLocation _location = null;
        protected int _segmentPtr = -1;
        protected JsonReadContext _parsingContext = JsonReadContext.createRootContext(-1, -1);

        public Parser(Segment segment, ObjectCodec objectCodec) {
            super(0);
            this._segment = segment;
            this._codec = objectCodec;
        }

        protected final void _checkIsNumber() {
            if (this._currToken == null || !this._currToken.isNumeric()) {
                throw _constructError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
            }
        }

        protected final Object _currentObject() {
            return this._segment.get(this._segmentPtr);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
            if (r4 >= 0) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
            _reportInvalidBase64(r13, r0, 0, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
            if (r1 < r3) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
            _reportBase64EOF();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
            r0 = r1 + 1;
            r1 = r11.charAt(r1);
            r5 = r13.decodeBase64Char(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
            if (r5 >= 0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
            _reportInvalidBase64(r13, r1, 1, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
            r1 = (r4 << 6) | r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
            if (r0 < r3) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
            if (r13.usesPadding() != false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
            _reportBase64EOF();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
            r12.append(r1 >> 4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0013, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
            r4 = r0 + 1;
            r0 = r11.charAt(r0);
            r5 = r13.decodeBase64Char(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
            if (r5 >= 0) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0094, code lost:
            r1 = (r1 << 6) | r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:
            if (r4 < r3) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x009e, code lost:
            if (r13.usesPadding() != false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
            _reportBase64EOF();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00a0, code lost:
            r12.appendTwoBytes(r1 >> 2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
            r0 = r4 + 1;
            r4 = r11.charAt(r4);
            r5 = r13.decodeBase64Char(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00b4, code lost:
            if (r5 >= 0) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c2, code lost:
            r12.appendThreeBytes((r1 << 6) | r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00b6, code lost:
            if (r5 == (-2)) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
            _reportInvalidBase64(r13, r4, 3, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
            r12.appendTwoBytes(r1 >> 2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0056, code lost:
            if (r5 == (-2)) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0058, code lost:
            _reportInvalidBase64(r13, r0, 2, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x005c, code lost:
            if (r4 < r3) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x005e, code lost:
            _reportBase64EOF();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0061, code lost:
            r0 = r4 + 1;
            r4 = r11.charAt(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x006b, code lost:
            if (r13.usesPaddingChar(r4) != false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x006d, code lost:
            _reportInvalidBase64(r13, r4, 3, "expected padding character '" + r13.getPaddingChar() + "'");
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x008d, code lost:
            r12.append(r1 >> 4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
            r4 = r13.decodeBase64Char(r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void _decodeBase64(String str, ByteArrayBuilder byteArrayBuilder, Base64Variant base64Variant) {
            int length = str.length();
            int i = 0;
            while (i < length) {
                while (true) {
                    int i2 = i + 1;
                    char charAt = str.charAt(i);
                    if (i2 >= length) {
                        return;
                    }
                    if (charAt > ' ') {
                        break;
                    }
                    i = i2;
                }
            }
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase
        protected void _handleEOF() {
            _throwInternal();
        }

        protected void _reportBase64EOF() {
            throw _constructError("Unexpected end-of-String in base64 content");
        }

        protected void _reportInvalidBase64(Base64Variant base64Variant, char c, int i, String str) {
            String str2 = c <= ' ' ? "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units" : base64Variant.usesPaddingChar(c) ? "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character" : (!Character.isDefined(c) || Character.isISOControl(c)) ? "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content" : "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
            if (str != null) {
                str2 = str2 + ": " + str;
            }
            throw _constructError(str2);
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this._closed) {
                this._closed = true;
            }
        }

        @Override // org.codehaus.jackson.JsonParser
        public BigInteger getBigIntegerValue() {
            Number numberValue = getNumberValue();
            if (numberValue instanceof BigInteger) {
                return (BigInteger) numberValue;
            }
            switch (getNumberType()) {
                case BIG_DECIMAL:
                    return ((BigDecimal) numberValue).toBigInteger();
                default:
                    return BigInteger.valueOf(numberValue.longValue());
            }
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
        public byte[] getBinaryValue(Base64Variant base64Variant) {
            if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object _currentObject = _currentObject();
                if (_currentObject instanceof byte[]) {
                    return (byte[]) _currentObject;
                }
            }
            if (this._currToken != JsonToken.VALUE_STRING) {
                throw _constructError("Current token (" + this._currToken + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
            }
            String text = getText();
            if (text == null) {
                return null;
            }
            ByteArrayBuilder byteArrayBuilder = this._byteBuilder;
            if (byteArrayBuilder == null) {
                byteArrayBuilder = new ByteArrayBuilder(100);
                this._byteBuilder = byteArrayBuilder;
            }
            _decodeBase64(text, byteArrayBuilder, base64Variant);
            return byteArrayBuilder.toByteArray();
        }

        @Override // org.codehaus.jackson.JsonParser
        public ObjectCodec getCodec() {
            return this._codec;
        }

        @Override // org.codehaus.jackson.JsonParser
        public JsonLocation getCurrentLocation() {
            return this._location == null ? JsonLocation.f22804NA : this._location;
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
        public String getCurrentName() {
            return this._parsingContext.getCurrentName();
        }

        @Override // org.codehaus.jackson.JsonParser
        public BigDecimal getDecimalValue() {
            Number numberValue = getNumberValue();
            if (numberValue instanceof BigDecimal) {
                return (BigDecimal) numberValue;
            }
            switch (getNumberType()) {
                case INT:
                case LONG:
                    return BigDecimal.valueOf(numberValue.longValue());
                case BIG_INTEGER:
                    return new BigDecimal((BigInteger) numberValue);
                case BIG_DECIMAL:
                case FLOAT:
                default:
                    return BigDecimal.valueOf(numberValue.doubleValue());
            }
        }

        @Override // org.codehaus.jackson.JsonParser
        public double getDoubleValue() {
            return getNumberValue().doubleValue();
        }

        @Override // org.codehaus.jackson.JsonParser
        public Object getEmbeddedObject() {
            if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
                return _currentObject();
            }
            return null;
        }

        @Override // org.codehaus.jackson.JsonParser
        public float getFloatValue() {
            return getNumberValue().floatValue();
        }

        @Override // org.codehaus.jackson.JsonParser
        public int getIntValue() {
            return this._currToken == JsonToken.VALUE_NUMBER_INT ? ((Number) _currentObject()).intValue() : getNumberValue().intValue();
        }

        @Override // org.codehaus.jackson.JsonParser
        public long getLongValue() {
            return getNumberValue().longValue();
        }

        @Override // org.codehaus.jackson.JsonParser
        public JsonParser.NumberType getNumberType() {
            Number numberValue = getNumberValue();
            if (numberValue instanceof Integer) {
                return JsonParser.NumberType.INT;
            }
            if (numberValue instanceof Long) {
                return JsonParser.NumberType.LONG;
            }
            if (numberValue instanceof Double) {
                return JsonParser.NumberType.DOUBLE;
            }
            if (numberValue instanceof BigDecimal) {
                return JsonParser.NumberType.BIG_DECIMAL;
            }
            if (numberValue instanceof Float) {
                return JsonParser.NumberType.FLOAT;
            }
            if (!(numberValue instanceof BigInteger)) {
                return null;
            }
            return JsonParser.NumberType.BIG_INTEGER;
        }

        @Override // org.codehaus.jackson.JsonParser
        public final Number getNumberValue() {
            _checkIsNumber();
            return (Number) _currentObject();
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
        /* renamed from: getParsingContext */
        public JsonStreamContext mo21880getParsingContext() {
            return this._parsingContext;
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
        public String getText() {
            if (this._currToken == JsonToken.VALUE_STRING || this._currToken == JsonToken.FIELD_NAME) {
                Object _currentObject = _currentObject();
                if (_currentObject instanceof String) {
                    return (String) _currentObject;
                }
                return _currentObject == null ? null : _currentObject.toString();
            } else if (this._currToken == null) {
                return null;
            } else {
                switch (this._currToken) {
                    case VALUE_NUMBER_INT:
                    case VALUE_NUMBER_FLOAT:
                        Object _currentObject2 = _currentObject();
                        if (_currentObject2 == null) {
                            return null;
                        }
                        return _currentObject2.toString();
                    default:
                        return this._currToken.asString();
                }
            }
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
        public char[] getTextCharacters() {
            String text = getText();
            if (text == null) {
                return null;
            }
            return text.toCharArray();
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
        public int getTextLength() {
            String text = getText();
            if (text == null) {
                return 0;
            }
            return text.length();
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
        public int getTextOffset() {
            return 0;
        }

        @Override // org.codehaus.jackson.JsonParser
        public JsonLocation getTokenLocation() {
            return getCurrentLocation();
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
        public boolean hasTextCharacters() {
            return false;
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
        public boolean isClosed() {
            return this._closed;
        }

        @Override // org.codehaus.jackson.impl.JsonParserMinimalBase, org.codehaus.jackson.JsonParser
        public JsonToken nextToken() {
            if (this._closed || this._segment == null) {
                return null;
            }
            int i = this._segmentPtr + 1;
            this._segmentPtr = i;
            if (i >= 16) {
                this._segmentPtr = 0;
                this._segment = this._segment.next();
                if (this._segment == null) {
                    return null;
                }
            }
            this._currToken = this._segment.type(this._segmentPtr);
            if (this._currToken == JsonToken.FIELD_NAME) {
                Object _currentObject = _currentObject();
                this._parsingContext.setCurrentName(_currentObject instanceof String ? (String) _currentObject : _currentObject.toString());
            } else if (this._currToken == JsonToken.START_OBJECT) {
                this._parsingContext = this._parsingContext.createChildObjectContext(-1, -1);
            } else if (this._currToken == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(-1, -1);
            } else if (this._currToken == JsonToken.END_OBJECT || this._currToken == JsonToken.END_ARRAY) {
                this._parsingContext = this._parsingContext.mo22000getParent();
                if (this._parsingContext == null) {
                    this._parsingContext = JsonReadContext.createRootContext(-1, -1);
                }
            }
            return this._currToken;
        }

        public JsonToken peekNextToken() {
            Segment segment;
            if (this._closed) {
                return null;
            }
            Segment segment2 = this._segment;
            int i = this._segmentPtr + 1;
            if (i >= 16) {
                segment = segment2 == null ? null : segment2.next();
                i = 0;
            } else {
                segment = segment2;
            }
            if (segment == null) {
                return null;
            }
            return segment.type(i);
        }

        @Override // org.codehaus.jackson.JsonParser
        public void setCodec(ObjectCodec objectCodec) {
            this._codec = objectCodec;
        }

        public void setLocation(JsonLocation jsonLocation) {
            this._location = jsonLocation;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class Segment {
        public static final int TOKENS_PER_SEGMENT = 16;
        private static final JsonToken[] TOKEN_TYPES_BY_INDEX = new JsonToken[16];
        protected Segment _next;
        protected long _tokenTypes;
        protected final Object[] _tokens = new Object[16];

        static {
            JsonToken[] values;
            System.arraycopy(JsonToken.values(), 1, TOKEN_TYPES_BY_INDEX, 1, Math.min(15, values.length - 1));
        }

        public Segment append(int i, JsonToken jsonToken) {
            if (i < 16) {
                set(i, jsonToken);
                return null;
            }
            this._next = new Segment();
            this._next.set(0, jsonToken);
            return this._next;
        }

        public Segment append(int i, JsonToken jsonToken, Object obj) {
            if (i < 16) {
                set(i, jsonToken, obj);
                return null;
            }
            this._next = new Segment();
            this._next.set(0, jsonToken, obj);
            return this._next;
        }

        public Object get(int i) {
            return this._tokens[i];
        }

        public Segment next() {
            return this._next;
        }

        public void set(int i, JsonToken jsonToken) {
            long ordinal = jsonToken.ordinal();
            if (i > 0) {
                ordinal <<= i << 2;
            }
            this._tokenTypes = ordinal | this._tokenTypes;
        }

        public void set(int i, JsonToken jsonToken, Object obj) {
            this._tokens[i] = obj;
            long ordinal = jsonToken.ordinal();
            if (i > 0) {
                ordinal <<= i << 2;
            }
            this._tokenTypes = ordinal | this._tokenTypes;
        }

        public JsonToken type(int i) {
            long j = this._tokenTypes;
            if (i > 0) {
                j >>= i << 2;
            }
            return TOKEN_TYPES_BY_INDEX[((int) j) & 15];
        }
    }

    public TokenBuffer(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
        Segment segment = new Segment();
        this._last = segment;
        this._first = segment;
    }

    protected final void _append(JsonToken jsonToken) {
        Segment append = this._last.append(this._appendOffset, jsonToken);
        if (append == null) {
            this._appendOffset++;
            return;
        }
        this._last = append;
        this._appendOffset = 1;
    }

    protected final void _append(JsonToken jsonToken, Object obj) {
        Segment append = this._last.append(this._appendOffset, jsonToken, obj);
        if (append == null) {
            this._appendOffset++;
            return;
        }
        this._last = append;
        this._appendOffset = 1;
    }

    protected void _reportUnsupportedOperation() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    public JsonParser asParser() {
        return asParser(this._objectCodec);
    }

    public JsonParser asParser(JsonParser jsonParser) {
        Parser parser = new Parser(this._first, jsonParser.getCodec());
        parser.setLocation(jsonParser.getTokenLocation());
        return parser;
    }

    public JsonParser asParser(ObjectCodec objectCodec) {
        return new Parser(this._first, objectCodec);
    }

    @Override // org.codehaus.jackson.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._closed = true;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void copyCurrentEvent(JsonParser jsonParser) {
        switch (jsonParser.getCurrentToken()) {
            case START_OBJECT:
                writeStartObject();
                return;
            case END_OBJECT:
                writeEndObject();
                return;
            case START_ARRAY:
                writeStartArray();
                return;
            case END_ARRAY:
                writeEndArray();
                return;
            case FIELD_NAME:
                writeFieldName(jsonParser.getCurrentName());
                return;
            case VALUE_STRING:
                if (jsonParser.hasTextCharacters()) {
                    writeString(jsonParser.getTextCharacters(), jsonParser.getTextOffset(), jsonParser.getTextLength());
                    return;
                } else {
                    writeString(jsonParser.getText());
                    return;
                }
            case VALUE_NUMBER_INT:
                switch (jsonParser.getNumberType()) {
                    case INT:
                        writeNumber(jsonParser.getIntValue());
                        return;
                    case BIG_INTEGER:
                        writeNumber(jsonParser.getBigIntegerValue());
                        return;
                    default:
                        writeNumber(jsonParser.getLongValue());
                        return;
                }
            case VALUE_NUMBER_FLOAT:
                switch (jsonParser.getNumberType()) {
                    case BIG_DECIMAL:
                        writeNumber(jsonParser.getDecimalValue());
                        return;
                    case FLOAT:
                        writeNumber(jsonParser.getFloatValue());
                        return;
                    default:
                        writeNumber(jsonParser.getDoubleValue());
                        return;
                }
            case VALUE_TRUE:
                writeBoolean(true);
                return;
            case VALUE_FALSE:
                writeBoolean(false);
                return;
            case VALUE_NULL:
                writeNull();
                return;
            case VALUE_EMBEDDED_OBJECT:
                writeObject(jsonParser.getEmbeddedObject());
                return;
            default:
                throw new RuntimeException("Internal error: should never end up through this code path");
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void copyCurrentStructure(JsonParser jsonParser) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.FIELD_NAME) {
            writeFieldName(jsonParser.getCurrentName());
            currentToken = jsonParser.nextToken();
        }
        switch (currentToken) {
            case START_OBJECT:
                writeStartObject();
                while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                    copyCurrentStructure(jsonParser);
                }
                writeEndObject();
                return;
            case END_OBJECT:
            default:
                copyCurrentEvent(jsonParser);
                return;
            case START_ARRAY:
                writeStartArray();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    copyCurrentStructure(jsonParser);
                }
                writeEndArray();
                return;
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public JsonGenerator disable(JsonGenerator.Feature feature) {
        this._generatorFeatures &= feature.getMask() ^ (-1);
        return this;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public JsonGenerator enable(JsonGenerator.Feature feature) {
        this._generatorFeatures |= feature.getMask();
        return this;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void flush() {
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    /* renamed from: getOutputContext  reason: collision with other method in class */
    public final JsonWriteContext mo22013getOutputContext() {
        return this._writeContext;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public boolean isClosed() {
        return this._closed;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public boolean isEnabled(JsonGenerator.Feature feature) {
        return (this._generatorFeatures & feature.getMask()) != 0;
    }

    public void serialize(JsonGenerator jsonGenerator) {
        Segment segment = this._first;
        int i = -1;
        while (true) {
            int i2 = i;
            Segment segment2 = segment;
            int i3 = i2 + 1;
            if (i3 >= 16) {
                Segment next = segment2.next();
                if (next == null) {
                    return;
                }
                i = 0;
                segment = next;
            } else {
                segment = segment2;
                i = i3;
            }
            JsonToken type = segment.type(i);
            if (type != null) {
                switch (type) {
                    case START_OBJECT:
                        jsonGenerator.writeStartObject();
                        break;
                    case END_OBJECT:
                        jsonGenerator.writeEndObject();
                        break;
                    case START_ARRAY:
                        jsonGenerator.writeStartArray();
                        break;
                    case END_ARRAY:
                        jsonGenerator.writeEndArray();
                        break;
                    case FIELD_NAME:
                        Object obj = segment.get(i);
                        if (!(obj instanceof SerializableString)) {
                            jsonGenerator.writeFieldName((String) obj);
                            break;
                        } else {
                            jsonGenerator.writeFieldName((SerializableString) obj);
                            break;
                        }
                    case VALUE_STRING:
                        Object obj2 = segment.get(i);
                        if (!(obj2 instanceof SerializableString)) {
                            jsonGenerator.writeString((String) obj2);
                            break;
                        } else {
                            jsonGenerator.writeString((SerializableString) obj2);
                            break;
                        }
                    case VALUE_NUMBER_INT:
                        Number number = (Number) segment.get(i);
                        if (!(number instanceof BigInteger)) {
                            if (!(number instanceof Long)) {
                                jsonGenerator.writeNumber(number.intValue());
                                break;
                            } else {
                                jsonGenerator.writeNumber(number.longValue());
                                break;
                            }
                        } else {
                            jsonGenerator.writeNumber((BigInteger) number);
                            break;
                        }
                    case VALUE_NUMBER_FLOAT:
                        Object obj3 = segment.get(i);
                        if (obj3 instanceof BigDecimal) {
                            jsonGenerator.writeNumber((BigDecimal) obj3);
                            break;
                        } else if (obj3 instanceof Float) {
                            jsonGenerator.writeNumber(((Float) obj3).floatValue());
                            break;
                        } else if (obj3 instanceof Double) {
                            jsonGenerator.writeNumber(((Double) obj3).doubleValue());
                            break;
                        } else if (obj3 == null) {
                            jsonGenerator.writeNull();
                            break;
                        } else if (!(obj3 instanceof String)) {
                            throw new JsonGenerationException("Unrecognized value type for VALUE_NUMBER_FLOAT: " + obj3.getClass().getName() + ", can not serialize");
                        } else {
                            jsonGenerator.writeNumber((String) obj3);
                            break;
                        }
                    case VALUE_TRUE:
                        jsonGenerator.writeBoolean(true);
                        break;
                    case VALUE_FALSE:
                        jsonGenerator.writeBoolean(false);
                        break;
                    case VALUE_NULL:
                        jsonGenerator.writeNull();
                        break;
                    case VALUE_EMBEDDED_OBJECT:
                        jsonGenerator.writeObject(segment.get(i));
                        break;
                    default:
                        throw new RuntimeException("Internal error: should never end up through this code path");
                }
            } else {
                return;
            }
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public JsonGenerator setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TokenBuffer: ");
        JsonParser asParser = asParser();
        int i = 0;
        while (true) {
            try {
                JsonToken nextToken = asParser.nextToken();
                if (nextToken == null) {
                    break;
                }
                if (i < 100) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(nextToken.toString());
                }
                i++;
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        if (i >= 100) {
            sb.append(" ... (truncated ").append(i - 100).append(" entries)");
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public JsonGenerator useDefaultPrettyPrinter() {
        return this;
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        writeObject(bArr2);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeBoolean(boolean z) {
        _append(z ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeEndArray() {
        _append(JsonToken.END_ARRAY);
        JsonWriteContext mo22000getParent = this._writeContext.mo22000getParent();
        if (mo22000getParent != null) {
            this._writeContext = mo22000getParent;
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeEndObject() {
        _append(JsonToken.END_OBJECT);
        JsonWriteContext mo22000getParent = this._writeContext.mo22000getParent();
        if (mo22000getParent != null) {
            this._writeContext = mo22000getParent;
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeFieldName(String str) {
        _append(JsonToken.FIELD_NAME, str);
        this._writeContext.writeFieldName(str);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeFieldName(SerializableString serializableString) {
        _append(JsonToken.FIELD_NAME, serializableString);
        this._writeContext.writeFieldName(serializableString.getValue());
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeFieldName(SerializedString serializedString) {
        _append(JsonToken.FIELD_NAME, serializedString);
        this._writeContext.writeFieldName(serializedString.getValue());
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNull() {
        _append(JsonToken.VALUE_NULL);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(double d) {
        _append(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(d));
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(float f) {
        _append(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(f));
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(int i) {
        _append(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(i));
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(long j) {
        _append(JsonToken.VALUE_NUMBER_INT, Long.valueOf(j));
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(String str) {
        _append(JsonToken.VALUE_NUMBER_FLOAT, str);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            writeNull();
        } else {
            _append(JsonToken.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeNumber(BigInteger bigInteger) {
        if (bigInteger == null) {
            writeNull();
        } else {
            _append(JsonToken.VALUE_NUMBER_INT, bigInteger);
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeObject(Object obj) {
        _append(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRaw(char c) {
        _reportUnsupportedOperation();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRaw(String str) {
        _reportUnsupportedOperation();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRaw(String str, int i, int i2) {
        _reportUnsupportedOperation();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i2) {
        _reportUnsupportedOperation();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i2) {
        _reportUnsupportedOperation();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRawValue(String str) {
        _reportUnsupportedOperation();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRawValue(String str, int i, int i2) {
        _reportUnsupportedOperation();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeRawValue(char[] cArr, int i, int i2) {
        _reportUnsupportedOperation();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeStartArray() {
        _append(JsonToken.START_ARRAY);
        this._writeContext = this._writeContext.createChildArrayContext();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public final void writeStartObject() {
        _append(JsonToken.START_OBJECT);
        this._writeContext = this._writeContext.createChildObjectContext();
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeString(String str) {
        if (str == null) {
            writeNull();
        } else {
            _append(JsonToken.VALUE_STRING, str);
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeString(SerializableString serializableString) {
        if (serializableString == null) {
            writeNull();
        } else {
            _append(JsonToken.VALUE_STRING, serializableString);
        }
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeString(char[] cArr, int i, int i2) {
        writeString(new String(cArr, i, i2));
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeTree(JsonNode jsonNode) {
        _append(JsonToken.VALUE_EMBEDDED_OBJECT, jsonNode);
    }

    @Override // org.codehaus.jackson.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i, int i2) {
        _reportUnsupportedOperation();
    }
}
