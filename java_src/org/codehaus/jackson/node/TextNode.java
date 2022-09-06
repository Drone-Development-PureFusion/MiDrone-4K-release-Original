package org.codehaus.jackson.node;

import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.p316io.NumberInput;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.CharTypes;
/* loaded from: classes2.dex */
public final class TextNode extends ValueNode {
    static final TextNode EMPTY_STRING_NODE = new TextNode("");
    static final int INT_SPACE = 32;
    final String _value;

    public TextNode(String str) {
        this._value = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void appendQuoted(StringBuilder sb, String str) {
        sb.append('\"');
        CharTypes.appendQuoted(sb, str);
        sb.append('\"');
    }

    public static TextNode valueOf(String str) {
        if (str == null) {
            return null;
        }
        return str.length() == 0 ? EMPTY_STRING_NODE : new TextNode(str);
    }

    protected void _reportBase64EOF() {
        throw new JsonParseException("Unexpected end-of-String when base64 content", JsonLocation.f22804NA);
    }

    protected void _reportInvalidBase64(Base64Variant base64Variant, char c, int i) {
        _reportInvalidBase64(base64Variant, c, i, null);
    }

    protected void _reportInvalidBase64(Base64Variant base64Variant, char c, int i, String str) {
        String str2 = c <= ' ' ? "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units" : base64Variant.usesPaddingChar(c) ? "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character" : (!Character.isDefined(c) || Character.isISOControl(c)) ? "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content" : "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new JsonParseException(str2, JsonLocation.f22804NA);
    }

    @Override // org.codehaus.jackson.node.ValueNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public JsonToken asToken() {
        return JsonToken.VALUE_STRING;
    }

    @Override // org.codehaus.jackson.JsonNode
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return ((TextNode) obj)._value.equals(this._value);
        }
        return false;
    }

    @Override // org.codehaus.jackson.JsonNode
    public byte[] getBinaryValue() {
        return getBinaryValue(Base64Variants.getDefaultVariant());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (r6 >= 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        _reportInvalidBase64(r12, r0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r1 < r5) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        r0 = r1 + 1;
        r1 = r4.charAt(r1);
        r7 = r12.decodeBase64Char(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        if (r7 >= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        _reportInvalidBase64(r12, r1, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        r1 = (r6 << 6) | r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r0 < r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r12.usesPadding() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        r3.append(r1 >> 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
        r6 = r0 + 1;
        r0 = r4.charAt(r0);
        r7 = r12.decodeBase64Char(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
        if (r7 >= 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
        r1 = (r1 << 6) | r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
        if (r6 < r5) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
        if (r12.usesPadding() != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b3, code lost:
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
        r3.appendTwoBytes(r1 >> 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b6, code lost:
        r0 = r6 + 1;
        r6 = r4.charAt(r6);
        r7 = r12.decodeBase64Char(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c0, code lost:
        if (r7 >= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ce, code lost:
        r3.appendThreeBytes((r1 << 6) | r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c2, code lost:
        if (r7 == (-2)) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c4, code lost:
        _reportInvalidBase64(r12, r6, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c7, code lost:
        r3.appendTwoBytes(r1 >> 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0062, code lost:
        if (r7 == (-2)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0064, code lost:
        _reportInvalidBase64(r12, r0, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0068, code lost:
        if (r6 < r5) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x006a, code lost:
        _reportBase64EOF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x006d, code lost:
        r0 = r6 + 1;
        r6 = r4.charAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0077, code lost:
        if (r12.usesPaddingChar(r6) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0079, code lost:
        _reportInvalidBase64(r12, r6, 3, "expected padding character '" + r12.getPaddingChar() + "'");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
        r3.append(r1 >> 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        r6 = r12.decodeBase64Char(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getBinaryValue(Base64Variant base64Variant) {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder(100);
        String str = this._value;
        int length = str.length();
        int i = 0;
        loop0: while (true) {
            if (i >= length) {
                break;
            }
            while (true) {
                int i2 = i + 1;
                char charAt = str.charAt(i);
                if (i2 >= length) {
                    break loop0;
                } else if (charAt > ' ') {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        return byteArrayBuilder.toByteArray();
    }

    @Override // org.codehaus.jackson.JsonNode
    public String getTextValue() {
        return this._value;
    }

    @Override // org.codehaus.jackson.JsonNode
    public boolean getValueAsBoolean(boolean z) {
        if (this._value == null || !"true".equals(this._value.trim())) {
            return z;
        }
        return true;
    }

    @Override // org.codehaus.jackson.JsonNode
    public double getValueAsDouble(double d) {
        return NumberInput.parseAsDouble(this._value, d);
    }

    @Override // org.codehaus.jackson.JsonNode
    public int getValueAsInt(int i) {
        return NumberInput.parseAsInt(this._value, i);
    }

    @Override // org.codehaus.jackson.JsonNode
    public long getValueAsLong(long j) {
        return NumberInput.parseAsLong(this._value, j);
    }

    @Override // org.codehaus.jackson.JsonNode
    public String getValueAsText() {
        return this._value;
    }

    public int hashCode() {
        return this._value.hashCode();
    }

    @Override // org.codehaus.jackson.JsonNode
    public boolean isTextual() {
        return true;
    }

    @Override // org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.map.JsonSerializable
    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this._value == null) {
            jsonGenerator.writeNull();
        } else {
            jsonGenerator.writeString(this._value);
        }
    }

    @Override // org.codehaus.jackson.node.ValueNode, org.codehaus.jackson.JsonNode
    public String toString() {
        int length = this._value.length();
        StringBuilder sb = new StringBuilder((length >> 4) + length + 2);
        appendQuoted(sb, this._value);
        return sb.toString();
    }
}
