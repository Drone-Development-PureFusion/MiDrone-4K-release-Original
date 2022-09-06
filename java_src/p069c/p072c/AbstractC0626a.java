package p069c.p072c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;
import p069c.p071b.AbstractC0618i;
import p069c.p071b.AbstractC0621l;
import p069c.p071b.C0610b;
import p069c.p071b.C0624n;
/* renamed from: c.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC0626a implements AbstractC0621l {

    /* renamed from: a */
    public static final String f1413a = "suite";

    /* renamed from: b */
    static int f1414b;

    /* renamed from: c */
    static boolean f1415c = true;

    /* renamed from: e */
    private static Properties f1416e;

    /* renamed from: d */
    boolean f1417d = true;

    static {
        f1414b = 500;
        f1414b = m19826a("maxmessage", f1414b);
    }

    /* renamed from: a */
    public static int m19826a(String str, int i) {
        String m19810h = m19810h(str);
        if (m19810h == null) {
            return i;
        }
        try {
            return Integer.parseInt(m19810h);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    /* renamed from: a */
    public static String m19824a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return m19809i(stringWriter.toString());
    }

    /* renamed from: a */
    protected static Properties m19828a() {
        if (f1416e == null) {
            f1416e = new Properties();
            f1416e.put("loading", "true");
            f1416e.put("filterstack", "true");
            m19812g();
        }
        return f1416e;
    }

    /* renamed from: a */
    public static void m19825a(String str, String str2) {
        m19828a().put(str, str2);
    }

    /* renamed from: a */
    protected static void m19823a(Properties properties) {
        f1416e = properties;
    }

    /* renamed from: b */
    public static void m19820b() {
        FileOutputStream fileOutputStream = new FileOutputStream(m19813f());
        try {
            m19828a().store(fileOutputStream, "");
        } finally {
            fileOutputStream.close();
        }
    }

    /* renamed from: e */
    public static String m19814e(String str) {
        return (f1414b == -1 || str.length() <= f1414b) ? str : str.substring(0, f1414b) + "...";
    }

    /* renamed from: e */
    protected static boolean m19815e() {
        return !m19810h("filterstack").equals("true") || !f1415c;
    }

    /* renamed from: f */
    private static File m19813f() {
        return new File(System.getProperty("user.home"), "junit.properties");
    }

    /* renamed from: g */
    private static void m19812g() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(m19813f());
        } catch (IOException e) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            m19823a(new Properties(m19828a()));
            m19828a().load(fileInputStream);
            if (fileInputStream == null) {
                return;
            }
            try {
                fileInputStream.close();
            } catch (IOException e2) {
            }
        } catch (IOException e3) {
            if (fileInputStream == null) {
                return;
            }
            try {
                fileInputStream.close();
            } catch (IOException e4) {
            }
        } catch (Throwable th2) {
            fileInputStream2 = fileInputStream;
            th = th2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    /* renamed from: h */
    public static String m19810h(String str) {
        return m19828a().getProperty(str);
    }

    /* renamed from: i */
    public static String m19809i(String str) {
        if (m19815e()) {
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return stringWriter.toString();
                }
                if (!m19808j(readLine)) {
                    printWriter.println(readLine);
                }
            } catch (Exception e) {
                return str;
            }
        }
    }

    /* renamed from: j */
    static boolean m19808j(String str) {
        for (String str2 : new String[]{"junit.framework.TestCase", "junit.framework.TestResult", "junit.framework.TestSuite", "junit.framework.Assert.", "junit.swingui.TestRunner", "junit.awtui.TestRunner", "junit.textui.TestRunner", "java.lang.reflect.Method.invoke("}) {
            if (str.indexOf(str2) > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public String m19827a(long j) {
        return NumberFormat.getInstance().format(j / 1000.0d);
    }

    /* renamed from: a */
    protected String m19821a(String[] strArr) {
        String str = null;
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i].equals("-noloading")) {
                m19822a(false);
            } else if (strArr[i].equals("-nofilterstack")) {
                f1415c = false;
            } else if (strArr[i].equals("-c")) {
                if (strArr.length > i + 1) {
                    str = m19816d(strArr[i + 1]);
                } else {
                    System.out.println("Missing Test class name");
                }
                i++;
            } else {
                str = strArr[i];
            }
            str = str;
            i++;
        }
        return str;
    }

    /* renamed from: a */
    public abstract void mo19787a(int i, AbstractC0618i abstractC0618i, Throwable th);

    @Override // p069c.p071b.AbstractC0621l
    /* renamed from: a */
    public synchronized void mo836a(AbstractC0618i abstractC0618i) {
        mo19781b(abstractC0618i.toString());
    }

    @Override // p069c.p071b.AbstractC0621l
    /* renamed from: a */
    public synchronized void mo835a(AbstractC0618i abstractC0618i, C0610b c0610b) {
        mo19787a(2, abstractC0618i, c0610b);
    }

    @Override // p069c.p071b.AbstractC0621l
    /* renamed from: a */
    public synchronized void mo834a(AbstractC0618i abstractC0618i, Throwable th) {
        mo19787a(1, abstractC0618i, th);
    }

    /* renamed from: a */
    public abstract void mo19783a(String str);

    /* renamed from: a */
    public void m19822a(boolean z) {
        this.f1417d = z;
    }

    @Override // p069c.p071b.AbstractC0621l
    /* renamed from: b */
    public synchronized void mo833b(AbstractC0618i abstractC0618i) {
        mo19783a(abstractC0618i.toString());
    }

    /* renamed from: b */
    public abstract void mo19781b(String str);

    /* renamed from: c */
    public AbstractC0618i m19818c(String str) {
        if (str.length() <= 0) {
            m19819c();
            return null;
        }
        try {
            Class<?> m19811g = m19811g(str);
            try {
                Method method = m19811g.getMethod(f1413a, new Class[0]);
                if (!Modifier.isStatic(method.getModifiers())) {
                    mo19773f("Suite() method must be static");
                    return null;
                }
                try {
                    AbstractC0618i abstractC0618i = (AbstractC0618i) method.invoke(null, new Object[0]);
                    if (abstractC0618i == null) {
                        return abstractC0618i;
                    }
                    m19819c();
                    return abstractC0618i;
                } catch (IllegalAccessException e) {
                    mo19773f("Failed to invoke suite():" + e.toString());
                    return null;
                } catch (InvocationTargetException e2) {
                    mo19773f("Failed to invoke suite():" + e2.getTargetException().toString());
                    return null;
                }
            } catch (Exception e3) {
                m19819c();
                return new C0624n(m19811g);
            }
        } catch (ClassNotFoundException e4) {
            String message = e4.getMessage();
            if (message != null) {
                str = message;
            }
            mo19773f("Class not found \"" + str + "\"");
            return null;
        } catch (Exception e5) {
            mo19773f("Error: " + e5.toString());
            return null;
        }
    }

    /* renamed from: c */
    protected void m19819c() {
    }

    /* renamed from: d */
    public String m19816d(String str) {
        return str.startsWith("Default package for") ? str.substring(str.lastIndexOf(".") + 1) : str;
    }

    /* renamed from: d */
    protected boolean m19817d() {
        return m19810h("loading").equals("true") && this.f1417d;
    }

    /* renamed from: f */
    protected abstract void mo19773f(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public Class<?> m19811g(String str) {
        return Class.forName(str);
    }
}
