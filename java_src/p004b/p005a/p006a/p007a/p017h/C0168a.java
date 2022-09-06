package p004b.p005a.p006a.p007a.p017h;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.p318d.AbstractC5744c;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
@Deprecated
/* renamed from: b.a.a.a.h.a */
/* loaded from: classes.dex */
public class C0168a {
    /* renamed from: a */
    public static String m21396a(String str) {
        return AbstractC5744c.f23019c.equals(str) ? "" : str;
    }

    /* renamed from: a */
    public static Level m21398a(C0146d c0146d) {
        if (c0146d == null) {
            throw new IllegalArgumentException("Unexpected level [null]");
        }
        switch (c0146d.f208v) {
            case Integer.MIN_VALUE:
                return Level.ALL;
            case 5000:
                return Level.FINEST;
            case 10000:
                return Level.FINE;
            case 20000:
                return Level.INFO;
            case 30000:
                return Level.WARNING;
            case C0146d.f188b /* 40000 */:
                return Level.SEVERE;
            case Integer.MAX_VALUE:
                return Level.OFF;
            default:
                throw new IllegalArgumentException("Unexpected level [" + c0146d + "]");
        }
    }

    /* renamed from: a */
    public static Logger m21397a(C0148e c0148e) {
        return m21394b(c0148e.mo88d());
    }

    /* renamed from: a */
    public static final boolean m21395a(Logger logger) {
        return logger != null && !logger.getName().equals("");
    }

    /* renamed from: b */
    public static Logger m21394b(String str) {
        return Logger.getLogger(m21396a(str));
    }

    /* renamed from: b */
    public static final boolean m21393b(Logger logger) {
        if (logger == null) {
            return false;
        }
        return logger.getName().equals("");
    }
}
