package com.google.zxing.client.result;

import com.google.zxing.Result;
/* loaded from: classes.dex */
final class GeoResultParser extends ResultParser {
    private GeoResultParser() {
    }

    public static GeoParsedResult parse(Result result) {
        String substring;
        String substring2;
        double parseDouble;
        double parseDouble2;
        String text = result.getText();
        if (text != null) {
            if (!text.startsWith("geo:") && !text.startsWith("GEO:")) {
                return null;
            }
            int indexOf = text.indexOf(63, 4);
            if (indexOf < 0) {
                substring2 = text.substring(4);
                substring = null;
            } else {
                substring = text.substring(indexOf + 1);
                substring2 = text.substring(4, indexOf);
            }
            int indexOf2 = substring2.indexOf(44);
            if (indexOf2 < 0) {
                return null;
            }
            int indexOf3 = substring2.indexOf(44, indexOf2 + 1);
            try {
                double parseDouble3 = Double.parseDouble(substring2.substring(0, indexOf2));
                if (parseDouble3 > 90.0d || parseDouble3 < -90.0d) {
                    return null;
                }
                if (indexOf3 < 0) {
                    parseDouble = Double.parseDouble(substring2.substring(indexOf2 + 1));
                    parseDouble2 = 0.0d;
                } else {
                    parseDouble = Double.parseDouble(substring2.substring(indexOf2 + 1, indexOf3));
                    parseDouble2 = Double.parseDouble(substring2.substring(indexOf3 + 1));
                }
                if (parseDouble <= 180.0d && parseDouble >= -180.0d && parseDouble2 >= 0.0d) {
                    return new GeoParsedResult(parseDouble3, parseDouble, parseDouble2, substring);
                }
                return null;
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
}
