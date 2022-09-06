package p004b.p005a.p006a.p007a.p010c;

import p004b.p005a.p006a.p007a.p010c.p011a.AbstractC0142b;
import p004b.p005a.p006a.p007a.p010c.p011a.EnumC0141a;
import p004b.p005a.p006a.p007a.p010c.p011a.EnumC0145e;
/* renamed from: b.a.a.a.c.a */
/* loaded from: classes.dex */
public class C0140a {
    /* renamed from: a */
    public static String m21498a(AbstractC0142b abstractC0142b) {
        StringBuilder sb = new StringBuilder("INSERT INTO ");
        sb.append(abstractC0142b.mo21492a(EnumC0145e.LOGGING_EVENT_PROPERTY)).append(" (");
        sb.append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(", ");
        sb.append(abstractC0142b.mo21490b(EnumC0141a.MAPPED_KEY)).append(", ");
        sb.append(abstractC0142b.mo21490b(EnumC0141a.MAPPED_VALUE)).append(") ");
        sb.append("VALUES (?, ?, ?)");
        return sb.toString();
    }

    /* renamed from: b */
    public static String m21497b(AbstractC0142b abstractC0142b) {
        StringBuilder sb = new StringBuilder("INSERT INTO ");
        sb.append(abstractC0142b.mo21492a(EnumC0145e.LOGGING_EVENT_EXCEPTION)).append(" (").append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.I)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.TRACE_LINE)).append(") ").append("VALUES (?, ?, ?)");
        return sb.toString();
    }

    /* renamed from: c */
    public static String m21496c(AbstractC0142b abstractC0142b) {
        StringBuilder sb = new StringBuilder("INSERT INTO ");
        sb.append(abstractC0142b.mo21492a(EnumC0145e.LOGGING_EVENT)).append(" (").append(abstractC0142b.mo21490b(EnumC0141a.TIMESTMP)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.FORMATTED_MESSAGE)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.LOGGER_NAME)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.LEVEL_STRING)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.THREAD_NAME)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.REFERENCE_FLAG)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.ARG0)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.ARG1)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.ARG2)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.ARG3)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.CALLER_FILENAME)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.CALLER_CLASS)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.CALLER_METHOD)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.CALLER_LINE)).append(") ").append("VALUES (?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        return sb.toString();
    }

    /* renamed from: d */
    public static String m21495d(AbstractC0142b abstractC0142b) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(abstractC0142b.mo21492a(EnumC0145e.LOGGING_EVENT)).append(" (").append(abstractC0142b.mo21490b(EnumC0141a.TIMESTMP)).append(" BIGINT NOT NULL, ").append(abstractC0142b.mo21490b(EnumC0141a.FORMATTED_MESSAGE)).append(" TEXT NOT NULL, ").append(abstractC0142b.mo21490b(EnumC0141a.LOGGER_NAME)).append(" VARCHAR(254) NOT NULL, ").append(abstractC0142b.mo21490b(EnumC0141a.LEVEL_STRING)).append(" VARCHAR(254) NOT NULL, ").append(abstractC0142b.mo21490b(EnumC0141a.THREAD_NAME)).append(" VARCHAR(254), ").append(abstractC0142b.mo21490b(EnumC0141a.REFERENCE_FLAG)).append(" SMALLINT, ").append(abstractC0142b.mo21490b(EnumC0141a.ARG0)).append(" VARCHAR(254), ").append(abstractC0142b.mo21490b(EnumC0141a.ARG1)).append(" VARCHAR(254), ").append(abstractC0142b.mo21490b(EnumC0141a.ARG2)).append(" VARCHAR(254), ").append(abstractC0142b.mo21490b(EnumC0141a.ARG3)).append(" VARCHAR(254), ").append(abstractC0142b.mo21490b(EnumC0141a.CALLER_FILENAME)).append(" VARCHAR(254), ").append(abstractC0142b.mo21490b(EnumC0141a.CALLER_CLASS)).append(" VARCHAR(254), ").append(abstractC0142b.mo21490b(EnumC0141a.CALLER_METHOD)).append(" VARCHAR(254), ").append(abstractC0142b.mo21490b(EnumC0141a.CALLER_LINE)).append(" CHAR(4), ").append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT").append(")");
        return sb.toString();
    }

    /* renamed from: e */
    public static String m21494e(AbstractC0142b abstractC0142b) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(abstractC0142b.mo21492a(EnumC0145e.LOGGING_EVENT_PROPERTY)).append(" (").append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(" BIGINT NOT NULL, ").append(abstractC0142b.mo21490b(EnumC0141a.MAPPED_KEY)).append(" VARCHAR(254) NOT NULL, ").append(abstractC0142b.mo21490b(EnumC0141a.MAPPED_VALUE)).append(" VARCHAR(254) NOT NULL, ").append("PRIMARY KEY (").append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.MAPPED_KEY)).append("), ").append("FOREIGN KEY (").append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(") ").append("REFERENCES ").append(abstractC0142b.mo21492a(EnumC0145e.LOGGING_EVENT)).append(" (").append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(") ").append(")");
        return sb.toString();
    }

    /* renamed from: f */
    public static String m21493f(AbstractC0142b abstractC0142b) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(abstractC0142b.mo21492a(EnumC0145e.LOGGING_EVENT_EXCEPTION)).append(" (").append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(" BIGINT NOT NULL, ").append(abstractC0142b.mo21490b(EnumC0141a.I)).append(" SMALLINT NOT NULL, ").append(abstractC0142b.mo21490b(EnumC0141a.TRACE_LINE)).append(" VARCHAR(254) NOT NULL, ").append("PRIMARY KEY (").append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(", ").append(abstractC0142b.mo21490b(EnumC0141a.I)).append("), ").append("FOREIGN KEY (").append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(") ").append("REFERENCES ").append(abstractC0142b.mo21492a(EnumC0145e.LOGGING_EVENT)).append(" (").append(abstractC0142b.mo21490b(EnumC0141a.EVENT_ID)).append(") ").append(")");
        return sb.toString();
    }
}
