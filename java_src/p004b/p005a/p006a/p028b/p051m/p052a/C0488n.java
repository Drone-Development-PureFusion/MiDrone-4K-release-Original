package p004b.p005a.p006a.p028b.p051m.p052a;

import java.io.File;
import p004b.p005a.p006a.p028b.p051m.C0496c;
import p004b.p005a.p006a.p028b.p051m.C0499f;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p057r.C0578l;
import p004b.p005a.p006a.p028b.p057r.C0581o;
/* renamed from: b.a.a.b.m.a.n */
/* loaded from: classes.dex */
public class C0488n extends C0527f {

    /* renamed from: a */
    static String f1086a = "http://logback.qos.ch/codes.html#renamingError";

    /* renamed from: a */
    void m20374a(File file) {
        if (!C0581o.m20088b(file) || C0581o.m20086c(file)) {
            return;
        }
        throw new C0499f("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
    }

    /* renamed from: a */
    public void m20372a(String str, String str2) {
        if (str.equals(str2)) {
            e("Source and target files are the same [" + str + "]. Skipping.");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new C0499f("File [" + str + "] does not exist.");
        }
        File file2 = new File(str2);
        m20374a(file2);
        d("Renaming file [" + file + "] to [" + file2 + "]");
        if (file.renameTo(file2)) {
            return;
        }
        e("Failed to rename file [" + file + "] as [" + file2 + "].");
        if (m20373a(file, file2)) {
            e("Detected different file systems for source [" + str + "] and target [" + str2 + "]. Attempting rename by copying.");
            m20371b(str, str2);
            return;
        }
        e("Please consider leaving the [file] option of " + C0496c.class.getSimpleName() + " empty.");
        e("See also " + f1086a);
    }

    /* renamed from: a */
    boolean m20373a(File file, File file2) {
        if (!C0578l.m20096d()) {
            return false;
        }
        try {
            return !C0484j.m20378a(file, file2.getParentFile());
        } catch (C0499f e) {
            c("Error while checking file store equality", e);
            return false;
        }
    }

    /* renamed from: b */
    public void m20371b(String str, String str2) {
        new C0581o(h_()).m20087b(str, str2);
        if (!new File(str).delete()) {
            e("Could not delete " + str);
        }
    }

    public String toString() {
        return "c.q.l.co.rolling.helper.RenameUtil";
    }
}
