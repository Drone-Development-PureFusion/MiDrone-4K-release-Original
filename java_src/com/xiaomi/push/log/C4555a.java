package com.xiaomi.push.log;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import com.xiaomi.channel.commonutils.file.C4474a;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C4627at;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: com.xiaomi.push.log.a */
/* loaded from: classes2.dex */
class C4555a {

    /* renamed from: b */
    private static String f18713b = "/MiPushLog";

    /* renamed from: c */
    private String f18715c;

    /* renamed from: d */
    private String f18716d;

    /* renamed from: e */
    private boolean f18717e;

    /* renamed from: f */
    private int f18718f;
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: a */
    private final SimpleDateFormat f18714a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: g */
    private int f18719g = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;

    /* renamed from: h */
    private ArrayList<File> f18720h = new ArrayList<>();

    /* renamed from: a */
    private void m4729a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        int i;
        boolean z;
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z2 = false;
        while (read != -1 && !z2) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (i2 < read && matcher.find(i2)) {
                i = matcher.start();
                String substring = str.substring(i, this.f18715c.length() + i);
                if (this.f18717e) {
                    if (substring.compareTo(this.f18716d) > 0) {
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.f18715c) >= 0) {
                    this.f18717e = true;
                    i3 = i;
                }
                int indexOf = str.indexOf(10, i);
                i2 = indexOf != -1 ? i + indexOf : i + this.f18715c.length();
            }
            i = read;
            z = z2;
            if (this.f18717e) {
                int i4 = i - i3;
                this.f18718f += i4;
                if (z) {
                    bufferedWriter.write(cArr, i3, i4);
                    return;
                }
                bufferedWriter.write(cArr, i3, i4);
                if (this.f18718f > this.f18719g) {
                    return;
                }
            }
            z2 = z;
            read = bufferedReader.read(cArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private void m4726b(File file) {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader = null;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("model :").append(Build.MODEL);
                    sb.append("; os :").append(Build.VERSION.INCREMENTAL);
                    sb.append("; uid :").append(C4627at.m4329e());
                    sb.append("; lng :").append(Locale.getDefault().toString());
                    sb.append("; sdk :").append(26);
                    sb.append("; andver :").append(Build.VERSION.SDK_INT);
                    String str = "\n";
                    sb.append(str);
                    bufferedWriter.write(sb.toString());
                    this.f18718f = 0;
                    Iterator<File> it2 = this.f18720h.iterator();
                    BufferedReader bufferedReader2 = str;
                    while (true) {
                        try {
                            bufferedReader2 = bufferedReader;
                            if (!it2.hasNext()) {
                                C4474a.m5056a(bufferedWriter);
                                C4474a.m5057a(bufferedReader2);
                                return;
                            }
                            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it2.next())));
                            m4729a(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader2;
                        } catch (FileNotFoundException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            AbstractC4478b.m5037c("LOG: filter error = " + e.getMessage());
                            C4474a.m5056a(bufferedWriter);
                            C4474a.m5057a(bufferedReader);
                            return;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            AbstractC4478b.m5037c("LOG: filter error = " + e.getMessage());
                            C4474a.m5056a(bufferedWriter);
                            C4474a.m5057a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            C4474a.m5056a(bufferedWriter);
                            C4474a.m5057a(bufferedReader);
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            bufferedWriter = null;
        } catch (IOException e6) {
            e = e6;
            bufferedWriter = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
        }
    }

    /* renamed from: a */
    C4555a m4728a(File file) {
        if (file.exists()) {
            this.f18720h.add(file);
        }
        return this;
    }

    /* renamed from: a */
    C4555a m4727a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f18715c = this.f18714a.format(date2);
            this.f18716d = this.f18714a.format(date);
        } else {
            this.f18715c = this.f18714a.format(date);
            this.f18716d = this.f18714a.format(date2);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public File m4730a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = context.getFilesDir();
            m4728a(new File(file2, "xmsf.log.1"));
            m4728a(new File(file2, "xmsf.log"));
        } else {
            file2 = new File(context.getExternalFilesDir(null) + f18713b);
            m4728a(new File(file2, "log0.txt"));
            m4728a(new File(file2, "log1.txt"));
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File file3 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
        if (file3.exists()) {
            return null;
        }
        m4727a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file4 = new File(file, "log.txt");
        m4726b(file4);
        AbstractC4478b.m5037c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file4.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            C4474a.m5060a(file3, file4);
            AbstractC4478b.m5037c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file4.delete();
            if (file3.exists()) {
                return file3;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4731a(int i) {
        if (i != 0) {
            this.f18719g = i;
        }
    }
}
