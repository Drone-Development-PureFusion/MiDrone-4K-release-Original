package com.google.zxing.client.result.optional;

import com.google.zxing.Result;
/* loaded from: classes.dex */
final class NDEFSmartPosterResultParser extends AbstractNDEFResultParser {
    NDEFSmartPosterResultParser() {
    }

    public static NDEFSmartPosterParsedResult parse(Result result) {
        NDEFRecord readRecord;
        byte[] rawBytes = result.getRawBytes();
        if (rawBytes != null && (readRecord = NDEFRecord.readRecord(rawBytes, 0)) != null && readRecord.isMessageBegin() && readRecord.isMessageEnd() && readRecord.getType().equals(NDEFRecord.SMART_POSTER_WELL_KNOWN_TYPE)) {
            byte[] payload = readRecord.getPayload();
            byte b = -1;
            String str = null;
            String str2 = null;
            NDEFRecord nDEFRecord = null;
            int i = 0;
            int i2 = 0;
            while (i2 < payload.length && (nDEFRecord = NDEFRecord.readRecord(payload, i2)) != null) {
                if (i == 0 && !nDEFRecord.isMessageBegin()) {
                    return null;
                }
                String type = nDEFRecord.getType();
                if (NDEFRecord.TEXT_WELL_KNOWN_TYPE.equals(type)) {
                    str2 = NDEFTextResultParser.decodeTextPayload(nDEFRecord.getPayload())[1];
                } else if (NDEFRecord.URI_WELL_KNOWN_TYPE.equals(type)) {
                    str = NDEFURIResultParser.decodeURIPayload(nDEFRecord.getPayload());
                } else if ("act".equals(type)) {
                    b = nDEFRecord.getPayload()[0];
                }
                i++;
                i2 += nDEFRecord.getTotalRecordLength();
            }
            if (i == 0) {
                return null;
            }
            if (nDEFRecord != null && !nDEFRecord.isMessageEnd()) {
                return null;
            }
            return new NDEFSmartPosterParsedResult(b, str, str2);
        }
        return null;
    }
}
