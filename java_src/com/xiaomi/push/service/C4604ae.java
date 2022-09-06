package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.file.C4474a;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.network.Host;
import com.xiaomi.push.protobuf.C4565a;
import com.xiaomi.stats.C4758f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* renamed from: com.xiaomi.push.service.ae */
/* loaded from: classes2.dex */
public class C4604ae {

    /* renamed from: a */
    private static final Pattern f18938a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    /* renamed from: b */
    private static long f18939b = 0;

    /* renamed from: c */
    private static ThreadPoolExecutor f18940c = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    public static void m4408a() {
        C4565a.C4566a m4330d;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f18940c.getActiveCount() <= 0 || currentTimeMillis - f18939b >= 1800000) && C4758f.m3796a().m3789c() && (m4330d = C4627at.m4340a().m4330d()) != null && m4330d.m4690m() > 0) {
            f18939b = currentTimeMillis;
            m4406a(m4330d.m4691l(), true);
        }
    }

    /* renamed from: a */
    public static void m4406a(List<String> list, boolean z) {
        f18940c.execute(new RunnableC4605af(list, z));
    }

    /* renamed from: b */
    public static void m4405b() {
        String m4403c = m4403c("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(m4403c)) {
            AbstractC4478b.m5041a("dump tcp for uid = " + Process.myUid());
            AbstractC4478b.m5041a(m4403c);
        }
        String m4403c2 = m4403c("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(m4403c2)) {
            AbstractC4478b.m5041a("dump tcp6 for uid = " + Process.myUid());
            AbstractC4478b.m5041a(m4403c2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m4404b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            AbstractC4478b.m5041a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(Host.m4753b(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            AbstractC4478b.m5041a("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            AbstractC4478b.m5036d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    /* renamed from: c */
    private static String m4403c(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        } catch (Exception e) {
            bufferedReader = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append("\n");
                sb.append(readLine);
            }
            str2 = sb.toString();
            C4474a.m5057a(bufferedReader);
        } catch (Exception e2) {
            C4474a.m5057a(bufferedReader);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            C4474a.m5057a(bufferedReader);
            throw th;
        }
        return str2;
    }
}
