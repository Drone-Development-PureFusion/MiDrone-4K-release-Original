package p004b.p005a.p006a.p028b.p033e;
/* renamed from: b.a.a.b.e.d */
/* loaded from: classes.dex */
public class C0291d {

    /* renamed from: a */
    private static final String f520a = "<![CDATA[";

    /* renamed from: c */
    private static final String f522c = "]]&gt;";

    /* renamed from: d */
    private static final String f523d = "]]>]]&gt;<![CDATA[";

    /* renamed from: b */
    private static final String f521b = "]]>";

    /* renamed from: e */
    private static final int f524e = f521b.length();

    /* renamed from: a */
    public static String m21021a(String str) {
        return (str == null || str.length() == 0) ? str : (str.indexOf("<") == -1 && str.indexOf(">") == -1) ? str : m21020a(new StringBuffer(str));
    }

    /* renamed from: a */
    public static String m21020a(StringBuffer stringBuffer) {
        for (int i = 0; i < stringBuffer.length(); i++) {
            char charAt = stringBuffer.charAt(i);
            if (charAt == '<') {
                stringBuffer.replace(i, i + 1, "&lt;");
            } else if (charAt == '>') {
                stringBuffer.replace(i, i + 1, "&gt;");
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static void m21019a(StringBuilder sb, String str) {
        if (str == null) {
            return;
        }
        int indexOf = str.indexOf(f521b);
        if (indexOf < 0) {
            sb.append(str);
            return;
        }
        int i = 0;
        while (indexOf > -1) {
            sb.append(str.substring(i, indexOf));
            sb.append(f523d);
            i = f524e + indexOf;
            if (i >= str.length()) {
                return;
            }
            indexOf = str.indexOf(f521b, i);
        }
        sb.append(str.substring(i));
    }
}
