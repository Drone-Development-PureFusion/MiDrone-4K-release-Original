package com.google.zxing.client.result;

import com.fimi.soul.module.setting.newhand.C3530b;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Hashtable;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
final class ExpandedProductResultParser extends ResultParser {
    private ExpandedProductResultParser() {
    }

    private static String findAIvalue(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.charAt(i) != '(') {
            return "ERROR";
        }
        String substring = str.substring(i + 1);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            switch (charAt) {
                case ')':
                    return stringBuffer.toString();
                case C3530b.f14177n /* 42 */:
                case C3530b.f14178o /* 43 */:
                case C3530b.f14179p /* 44 */:
                case '-':
                case '.':
                case '/':
                default:
                    return "ERROR";
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case Opcodes.SALOAD /* 53 */:
                case Opcodes.ISTORE /* 54 */:
                case Opcodes.LSTORE /* 55 */:
                case '8':
                case Opcodes.DSTORE /* 57 */:
                    stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    private static String findValue(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt != '(') {
                stringBuffer.append(charAt);
            } else if (!"ERROR".equals(findAIvalue(i2, substring))) {
                break;
            } else {
                stringBuffer.append(C0359h.f722s);
            }
        }
        return stringBuffer.toString();
    }

    public static ExpandedProductParsedResult parse(Result result) {
        String text;
        if (BarcodeFormat.RSS_EXPANDED.equals(result.getBarcodeFormat()) && (text = result.getText()) != null) {
            String str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str2 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str3 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str4 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str5 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str6 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str7 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str8 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str9 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str10 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str11 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str12 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            String str13 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            Hashtable hashtable = new Hashtable();
            int i = 0;
            while (i < text.length()) {
                String findAIvalue = findAIvalue(i, text);
                if ("ERROR".equals(findAIvalue)) {
                    return null;
                }
                int length = findAIvalue.length() + 2 + i;
                String findValue = findValue(length, text);
                int length2 = length + findValue.length();
                if ("00".equals(findAIvalue)) {
                    str2 = findValue;
                } else if ("01".equals(findAIvalue)) {
                    str = findValue;
                } else if ("10".equals(findAIvalue)) {
                    str3 = findValue;
                } else if ("11".equals(findAIvalue)) {
                    str4 = findValue;
                } else if ("13".equals(findAIvalue)) {
                    str5 = findValue;
                } else if (com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE.equals(findAIvalue)) {
                    str6 = findValue;
                } else if ("17".equals(findAIvalue)) {
                    str7 = findValue;
                } else if ("3100".equals(findAIvalue) || "3101".equals(findAIvalue) || "3102".equals(findAIvalue) || "3103".equals(findAIvalue) || "3104".equals(findAIvalue) || "3105".equals(findAIvalue) || "3106".equals(findAIvalue) || "3107".equals(findAIvalue) || "3108".equals(findAIvalue) || "3109".equals(findAIvalue)) {
                    str9 = ExpandedProductParsedResult.KILOGRAM;
                    str10 = findAIvalue.substring(3);
                    str8 = findValue;
                } else if ("3200".equals(findAIvalue) || "3201".equals(findAIvalue) || "3202".equals(findAIvalue) || "3203".equals(findAIvalue) || "3204".equals(findAIvalue) || "3205".equals(findAIvalue) || "3206".equals(findAIvalue) || "3207".equals(findAIvalue) || "3208".equals(findAIvalue) || "3209".equals(findAIvalue)) {
                    str9 = ExpandedProductParsedResult.POUND;
                    str10 = findAIvalue.substring(3);
                    str8 = findValue;
                } else if ("3920".equals(findAIvalue) || "3921".equals(findAIvalue) || "3922".equals(findAIvalue) || "3923".equals(findAIvalue)) {
                    str12 = findAIvalue.substring(3);
                    str11 = findValue;
                } else if (!"3930".equals(findAIvalue) && !"3931".equals(findAIvalue) && !"3932".equals(findAIvalue) && !"3933".equals(findAIvalue)) {
                    hashtable.put(findAIvalue, findValue);
                } else if (findValue.length() < 4) {
                    return null;
                } else {
                    str11 = findValue.substring(3);
                    str13 = findValue.substring(0, 3);
                    str12 = findAIvalue.substring(3);
                }
                i = length2;
            }
            return new ExpandedProductParsedResult(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, hashtable);
        }
        return null;
    }
}
