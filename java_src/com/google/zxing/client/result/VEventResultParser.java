package com.google.zxing.client.result;

import com.google.zxing.Result;
/* loaded from: classes.dex */
final class VEventResultParser extends ResultParser {
    private VEventResultParser() {
    }

    public static CalendarParsedResult parse(Result result) {
        String text = result.getText();
        if (text != null && text.indexOf("BEGIN:VEVENT") >= 0) {
            try {
                return new CalendarParsedResult(VCardResultParser.matchSingleVCardPrefixedField("SUMMARY", text, true), VCardResultParser.matchSingleVCardPrefixedField("DTSTART", text, true), VCardResultParser.matchSingleVCardPrefixedField("DTEND", text, true), VCardResultParser.matchSingleVCardPrefixedField("LOCATION", text, true), null, VCardResultParser.matchSingleVCardPrefixedField("DESCRIPTION", text, true));
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
        return null;
    }
}
