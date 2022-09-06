package com.google.zxing.client.result.optional;

import com.google.zxing.Result;
import com.google.zxing.client.result.TextParsedResult;
/* loaded from: classes.dex */
final class NDEFTextResultParser extends AbstractNDEFResultParser {
    NDEFTextResultParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] decodeTextPayload(byte[] bArr) {
        byte b = bArr[0];
        boolean z = (b & 128) != 0;
        int i = b & 31;
        return new String[]{bytesToString(bArr, 1, i, "US-ASCII"), bytesToString(bArr, i + 1, (bArr.length - i) - 1, z ? "UTF-16" : "UTF8")};
    }

    public static TextParsedResult parse(Result result) {
        NDEFRecord readRecord;
        byte[] rawBytes = result.getRawBytes();
        if (rawBytes != null && (readRecord = NDEFRecord.readRecord(rawBytes, 0)) != null && readRecord.isMessageBegin() && readRecord.isMessageEnd() && readRecord.getType().equals(NDEFRecord.TEXT_WELL_KNOWN_TYPE)) {
            String[] decodeTextPayload = decodeTextPayload(readRecord.getPayload());
            return new TextParsedResult(decodeTextPayload[0], decodeTextPayload[1]);
        }
        return null;
    }
}
