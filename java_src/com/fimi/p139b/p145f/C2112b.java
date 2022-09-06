package com.fimi.p139b.p145f;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.regex.Pattern;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.b.f.b */
/* loaded from: classes.dex */
public class C2112b {

    /* renamed from: a */
    private static boolean f7061a = false;

    /* renamed from: a */
    private static byte m13662a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /* renamed from: a */
    public static String m13664a() {
        StringBuffer stringBuffer = new StringBuffer();
        DecimalFormat decimalFormat = new DecimalFormat("00");
        Calendar calendar = Calendar.getInstance();
        String format = decimalFormat.format(calendar.get(1));
        String format2 = decimalFormat.format(calendar.get(2) + 1);
        String format3 = decimalFormat.format(calendar.get(5));
        String format4 = decimalFormat.format(calendar.get(11));
        String format5 = decimalFormat.format(calendar.get(12));
        String format6 = decimalFormat.format(calendar.get(13));
        stringBuffer.append(format.substring(2, format.length())).append(format2).append(format3).append(format4).append(format5).append(format6).append(decimalFormat.format(calendar.get(7) - 1));
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m13663a(byte b) {
        StringBuilder sb = new StringBuilder("");
        String hexString = Integer.toHexString(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        if (hexString.length() < 2) {
            sb.append(0);
        }
        sb.append(hexString);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m13660a(File file) {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[256];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            }
            messageDigest.update(bArr, 0, read);
        }
        fileInputStream.close();
        StringBuilder sb = new StringBuilder();
        byte[] digest = messageDigest.digest();
        for (byte b : digest) {
            sb.append(new Formatter().format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m13658a(String str, String str2, String str3, String str4, String str5, String str6) {
        return m13646d(str + str2 + str3 + str4 + str5 + str6);
    }

    /* renamed from: a */
    public static String m13657a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            sb.append(" ");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m13661a(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 2) {
            hexString = "0" + hexString;
            length = hexString.length();
        }
        return m13649c(hexString);
    }

    /* renamed from: a */
    public static byte[] m13659a(String str) {
        if (str == null || str.equals("")) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (m13662a(charArray[i2 + 1]) | (m13662a(charArray[i2]) << 4));
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m13656a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= 0 || bArr2.length <= 0) {
            throw new IllegalArgumentException("字节数组参数错误");
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: b */
    public static byte m13652b(String str) {
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (m13662a(charArray[i2 + 1]) | (m13662a(charArray[i2]) << 4));
        }
        return bArr[0];
    }

    /* renamed from: b */
    public static int m13654b(byte b) {
        return b & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    /* renamed from: b */
    public static int m13651b(byte[] bArr) {
        return Integer.valueOf(m13657a(bArr), 16).intValue();
    }

    /* renamed from: b */
    public static String m13655b() {
        String hexString = Integer.toHexString((int) (Math.random() * 100.0d));
        int length = hexString.length();
        while (length < 2) {
            hexString = "0" + hexString;
            length = hexString.length();
        }
        return hexString;
    }

    /* renamed from: b */
    public static byte[] m13653b(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 4) {
            hexString = "0" + hexString;
            length = hexString.length();
        }
        return m13649c(hexString);
    }

    /* renamed from: c */
    public static ArrayList<String> m13648c(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) < 3) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        while (i < length - 1) {
            int i2 = (bArr[i] << 8) | bArr[i + 1];
            byte[] bArr2 = new byte[i2 - 1];
            System.arraycopy(bArr, i + 2, bArr2, 0, i2 - 1);
            arrayList.add(new String(bArr2));
            i += i2 + 2;
        }
        return arrayList;
    }

    /* renamed from: c */
    public static byte[] m13650c(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 8) {
            hexString = "0" + hexString;
            length = hexString.length();
        }
        return m13649c(hexString);
    }

    /* renamed from: c */
    public static byte[] m13649c(String str) {
        String replace = str.replace(" ", "");
        System.out.println(replace);
        byte[] bArr = new byte[replace.length() / 2];
        int i = 0;
        while (i < replace.length()) {
            byte b = replace.substring(i, i + 1).getBytes()[0];
            int i2 = b > 96 ? ((b - 97) + 10) * 16 : b > 64 ? ((b - 65) + 10) * 16 : (b - 48) * 16;
            int i3 = i + 1;
            byte b2 = replace.substring(i3, i3 + 1).getBytes()[0];
            bArr[i3 / 2] = (byte) ((b2 > 96 ? (b2 - 97) + 10 : b2 > 64 ? (b2 - 65) + 10 : b2 - 48) + i2);
            i = i3 + 1;
        }
        return bArr;
    }

    /* renamed from: d */
    public static String m13646d(String str) {
        byte b;
        if (str.length() > 0) {
            b = 0;
            for (int i = 0; i < str.length() / 2; i++) {
                b = (byte) (b ^ m13652b(str.substring(i * 2, (i * 2) + 2)));
            }
        } else {
            b = 0;
        }
        return m13657a(new byte[]{b});
    }

    /* renamed from: d */
    public static byte[] m13647d(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        if (length < 2) {
            hexString = "0" + hexString;
            length = hexString.length();
        }
        while (length < 8) {
            hexString = hexString + "0";
            length = hexString.length();
        }
        return m13649c(hexString);
    }

    /* renamed from: e */
    public static byte m13645e(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 2) {
            hexString = "0" + hexString;
            length = hexString.length();
        }
        return m13652b(hexString);
    }

    /* renamed from: e */
    public static String m13644e(String str) {
        String hexString = Integer.toHexString(str.length() / 2);
        int length = hexString.length();
        while (length < 4) {
            hexString = "0" + hexString;
            length = hexString.length();
        }
        return hexString;
    }

    /* renamed from: f */
    public static int m13642f(String str) {
        return Integer.valueOf(str, 16).intValue();
    }

    /* renamed from: f */
    public static String m13643f(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 2) {
            hexString = "0" + hexString;
            length = hexString.length();
        }
        return hexString;
    }

    /* renamed from: g */
    public static String m13641g(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 4) {
            hexString = "0" + hexString;
            length = hexString.length();
        }
        return hexString;
    }

    /* renamed from: g */
    public static String m13640g(String str) {
        String m13657a;
        if (str == null || str.length() <= 0) {
            return "";
        }
        String str2 = m13644e(m13657a) + m13657a((str + "\u0000").getBytes());
        System.out.println("resultLength==" + str2);
        return str2;
    }

    /* renamed from: h */
    public static String m13639h(int i) {
        StringBuilder sb = new StringBuilder();
        if (i / 16 == 0) {
            return m13637i(i);
        }
        sb.append(m13639h(i / 16)).append(m13637i(i % 16));
        return sb.toString();
    }

    /* renamed from: h */
    public static String m13638h(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        if (str.length() % 8 != 0) {
            int length = 8 - (str.length() % 8);
            for (int i = 0; i < length; i++) {
                str = str + "0";
            }
            System.out.println("choiceItem = " + str);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2 += 4) {
            int i3 = 0;
            for (int i4 = 0; i4 < 4; i4++) {
                i3 += Integer.parseInt(str.substring(i2 + i4, (i2 + i4) + 1)) << ((4 - i4) - 1);
            }
            stringBuffer.append(Integer.toHexString(i3));
        }
        System.out.println("tmp.toString() = " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    /* renamed from: i */
    private static String m13637i(int i) {
        switch (i) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return "" + i;
        }
    }

    /* renamed from: i */
    public static String m13636i(String str) {
        if (str == null || str.length() % 2 != 0) {
            return null;
        }
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            String str3 = "0000" + Integer.toBinaryString(Integer.parseInt(str.substring(i, i + 1), 16));
            str2 = str2 + str3.substring(str3.length() - 4);
        }
        return str2;
    }

    /* renamed from: j */
    public static String m13635j(String str) {
        String str2 = "";
        if (str != null) {
            str2 = Pattern.compile("\t|\r|\n").matcher(str).replaceAll("");
        }
        return str2.trim();
    }

    /* renamed from: k */
    public static String m13634k(String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : str.getBytes()) {
            sb.append(m13639h(b));
        }
        return sb.toString();
    }
}
