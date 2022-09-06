package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.tencent.connect.common.Constants;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* loaded from: classes.dex */
final class FieldParser {
    private static final Object VARIABLE_LENGTH = new Object();
    private static final Object[][] TWO_DIGIT_DATA_LENGTH = {new Object[]{"00", new Integer(18)}, new Object[]{"01", new Integer(14)}, new Object[]{"02", new Integer(14)}, new Object[]{"10", VARIABLE_LENGTH, new Integer(20)}, new Object[]{"11", new Integer(6)}, new Object[]{"12", new Integer(6)}, new Object[]{"13", new Integer(6)}, new Object[]{Constants.VIA_REPORT_TYPE_WPA_STATE, new Integer(6)}, new Object[]{"17", new Integer(6)}, new Object[]{"20", new Integer(2)}, new Object[]{Constants.VIA_REPORT_TYPE_QQFAVORITES, VARIABLE_LENGTH, new Integer(20)}, new Object[]{Constants.VIA_REPORT_TYPE_DATALINE, VARIABLE_LENGTH, new Integer(29)}, new Object[]{C0413a.f924d, VARIABLE_LENGTH, new Integer(8)}, new Object[]{C0413a.f931k, VARIABLE_LENGTH, new Integer(8)}, new Object[]{"90", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"91", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"92", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"93", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"94", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"95", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"96", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"97", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"98", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"99", VARIABLE_LENGTH, new Integer(30)}};
    private static final Object[][] THREE_DIGIT_DATA_LENGTH = {new Object[]{"240", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"241", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"242", VARIABLE_LENGTH, new Integer(6)}, new Object[]{"250", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"251", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"253", VARIABLE_LENGTH, new Integer(17)}, new Object[]{"254", VARIABLE_LENGTH, new Integer(20)}, new Object[]{"400", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"401", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"402", new Integer(17)}, new Object[]{"403", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"410", new Integer(13)}, new Object[]{"411", new Integer(13)}, new Object[]{"412", new Integer(13)}, new Object[]{"413", new Integer(13)}, new Object[]{"414", new Integer(13)}, new Object[]{"420", VARIABLE_LENGTH, new Integer(20)}, new Object[]{"421", VARIABLE_LENGTH, new Integer(15)}, new Object[]{"422", new Integer(3)}, new Object[]{"423", VARIABLE_LENGTH, new Integer(15)}, new Object[]{"424", new Integer(3)}, new Object[]{"425", new Integer(3)}, new Object[]{"426", new Integer(3)}};
    private static final Object[][] THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH = {new Object[]{"310", new Integer(6)}, new Object[]{"311", new Integer(6)}, new Object[]{"312", new Integer(6)}, new Object[]{"313", new Integer(6)}, new Object[]{"314", new Integer(6)}, new Object[]{"315", new Integer(6)}, new Object[]{"316", new Integer(6)}, new Object[]{"320", new Integer(6)}, new Object[]{"321", new Integer(6)}, new Object[]{"322", new Integer(6)}, new Object[]{"323", new Integer(6)}, new Object[]{"324", new Integer(6)}, new Object[]{"325", new Integer(6)}, new Object[]{"326", new Integer(6)}, new Object[]{"327", new Integer(6)}, new Object[]{"328", new Integer(6)}, new Object[]{"329", new Integer(6)}, new Object[]{"330", new Integer(6)}, new Object[]{"331", new Integer(6)}, new Object[]{"332", new Integer(6)}, new Object[]{"333", new Integer(6)}, new Object[]{"334", new Integer(6)}, new Object[]{"335", new Integer(6)}, new Object[]{"336", new Integer(6)}, new Object[]{"340", new Integer(6)}, new Object[]{"341", new Integer(6)}, new Object[]{"342", new Integer(6)}, new Object[]{"343", new Integer(6)}, new Object[]{"344", new Integer(6)}, new Object[]{"345", new Integer(6)}, new Object[]{"346", new Integer(6)}, new Object[]{"347", new Integer(6)}, new Object[]{"348", new Integer(6)}, new Object[]{"349", new Integer(6)}, new Object[]{"350", new Integer(6)}, new Object[]{"351", new Integer(6)}, new Object[]{"352", new Integer(6)}, new Object[]{"353", new Integer(6)}, new Object[]{"354", new Integer(6)}, new Object[]{"355", new Integer(6)}, new Object[]{"356", new Integer(6)}, new Object[]{"357", new Integer(6)}, new Object[]{"360", new Integer(6)}, new Object[]{"361", new Integer(6)}, new Object[]{"362", new Integer(6)}, new Object[]{"363", new Integer(6)}, new Object[]{"364", new Integer(6)}, new Object[]{"365", new Integer(6)}, new Object[]{"366", new Integer(6)}, new Object[]{"367", new Integer(6)}, new Object[]{"368", new Integer(6)}, new Object[]{"369", new Integer(6)}, new Object[]{"390", VARIABLE_LENGTH, new Integer(15)}, new Object[]{"391", VARIABLE_LENGTH, new Integer(18)}, new Object[]{"392", VARIABLE_LENGTH, new Integer(15)}, new Object[]{"393", VARIABLE_LENGTH, new Integer(18)}, new Object[]{"703", VARIABLE_LENGTH, new Integer(30)}};
    private static final Object[][] FOUR_DIGIT_DATA_LENGTH = {new Object[]{"7001", new Integer(13)}, new Object[]{"7002", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"7003", new Integer(10)}, new Object[]{"8001", new Integer(14)}, new Object[]{"8002", VARIABLE_LENGTH, new Integer(20)}, new Object[]{"8003", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"8004", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"8005", new Integer(6)}, new Object[]{"8006", new Integer(18)}, new Object[]{"8007", VARIABLE_LENGTH, new Integer(30)}, new Object[]{"8008", VARIABLE_LENGTH, new Integer(12)}, new Object[]{"8018", new Integer(18)}, new Object[]{"8020", VARIABLE_LENGTH, new Integer(25)}, new Object[]{"8100", new Integer(6)}, new Object[]{"8101", new Integer(10)}, new Object[]{"8102", new Integer(2)}, new Object[]{"8110", VARIABLE_LENGTH, new Integer(30)}};

    private FieldParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String parseFieldsInGeneralPurpose(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() < 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring = str.substring(0, 2);
        for (int i = 0; i < TWO_DIGIT_DATA_LENGTH.length; i++) {
            if (TWO_DIGIT_DATA_LENGTH[i][0].equals(substring)) {
                return TWO_DIGIT_DATA_LENGTH[i][1] == VARIABLE_LENGTH ? processVariableAI(2, ((Integer) TWO_DIGIT_DATA_LENGTH[i][2]).intValue(), str) : processFixedAI(2, ((Integer) TWO_DIGIT_DATA_LENGTH[i][1]).intValue(), str);
            }
        }
        if (str.length() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring2 = str.substring(0, 3);
        for (int i2 = 0; i2 < THREE_DIGIT_DATA_LENGTH.length; i2++) {
            if (THREE_DIGIT_DATA_LENGTH[i2][0].equals(substring2)) {
                return THREE_DIGIT_DATA_LENGTH[i2][1] == VARIABLE_LENGTH ? processVariableAI(3, ((Integer) THREE_DIGIT_DATA_LENGTH[i2][2]).intValue(), str) : processFixedAI(3, ((Integer) THREE_DIGIT_DATA_LENGTH[i2][1]).intValue(), str);
            }
        }
        for (int i3 = 0; i3 < THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH.length; i3++) {
            if (THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH[i3][0].equals(substring2)) {
                return THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH[i3][1] == VARIABLE_LENGTH ? processVariableAI(4, ((Integer) THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH[i3][2]).intValue(), str) : processFixedAI(4, ((Integer) THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH[i3][1]).intValue(), str);
            }
        }
        if (str.length() < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring3 = str.substring(0, 4);
        for (int i4 = 0; i4 < FOUR_DIGIT_DATA_LENGTH.length; i4++) {
            if (FOUR_DIGIT_DATA_LENGTH[i4][0].equals(substring3)) {
                return FOUR_DIGIT_DATA_LENGTH[i4][1] == VARIABLE_LENGTH ? processVariableAI(4, ((Integer) FOUR_DIGIT_DATA_LENGTH[i4][2]).intValue(), str) : processFixedAI(4, ((Integer) FOUR_DIGIT_DATA_LENGTH[i4][1]).intValue(), str);
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static String processFixedAI(int i, int i2, String str) {
        if (str.length() < i) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring = str.substring(0, i);
        if (str.length() < i + i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        return new StringBuffer().append(C0359h.f722s).append(substring).append(C0359h.f723t).append(str.substring(i, i + i2)).append(parseFieldsInGeneralPurpose(str.substring(i + i2))).toString();
    }

    private static String processVariableAI(int i, int i2, String str) {
        String substring = str.substring(0, i);
        int length = str.length() < i + i2 ? str.length() : i + i2;
        return new StringBuffer().append(C0359h.f722s).append(substring).append(C0359h.f723t).append(str.substring(i, length)).append(parseFieldsInGeneralPurpose(str.substring(length))).toString();
    }
}
