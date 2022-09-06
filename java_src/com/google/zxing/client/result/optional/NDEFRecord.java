package com.google.zxing.client.result.optional;

import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
final class NDEFRecord {
    public static final String ACTION_WELL_KNOWN_TYPE = "act";
    public static final String SMART_POSTER_WELL_KNOWN_TYPE = "Sp";
    private static final int SUPPORTED_HEADER = 17;
    private static final int SUPPORTED_HEADER_MASK = 63;
    public static final String TEXT_WELL_KNOWN_TYPE = "T";
    public static final String URI_WELL_KNOWN_TYPE = "U";
    private final int header;
    private final byte[] payload;
    private final int totalRecordLength;
    private final String type;

    private NDEFRecord(int i, String str, byte[] bArr, int i2) {
        this.header = i;
        this.type = str;
        this.payload = bArr;
        this.totalRecordLength = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NDEFRecord readRecord(byte[] bArr, int i) {
        int i2 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
        if (((i2 ^ 17) & 63) != 0) {
            return null;
        }
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        String bytesToString = AbstractNDEFResultParser.bytesToString(bArr, i + 3, i3, "US-ASCII");
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i + 3 + i3, bArr2, 0, i4);
        return new NDEFRecord(i2, bytesToString, bArr2, i3 + 3 + i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getPayload() {
        return this.payload;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTotalRecordLength() {
        return this.totalRecordLength;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMessageBegin() {
        return (this.header & 128) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMessageEnd() {
        return (this.header & 64) != 0;
    }
}
