package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.p232a.C4405i;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.j */
/* loaded from: classes2.dex */
public class RunnableC4432j implements Runnable {

    /* renamed from: a */
    private Context f18482a;

    /* renamed from: b */
    private Map<String, Integer> f18483b;

    public RunnableC4432j(Context context, Map<String, Integer> map) {
        this.f18482a = null;
        this.f18483b = null;
        this.f18482a = context;
        if (map != null) {
            this.f18483b = map;
        }
    }

    /* renamed from: a */
    private NetworkMonitor m5140a(String str, int i) {
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        StatLogger statLogger4;
        NetworkMonitor networkMonitor = new NetworkMonitor();
        Socket socket = new Socket();
        int i2 = 0;
        try {
            try {
                networkMonitor.setDomain(str);
                networkMonitor.setPort(i);
                long currentTimeMillis = System.currentTimeMillis();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
                socket.connect(inetSocketAddress, 30000);
                networkMonitor.setMillisecondsConsume(System.currentTimeMillis() - currentTimeMillis);
                networkMonitor.setRemoteIp(inetSocketAddress.getAddress().getHostAddress());
                if (socket != null) {
                    socket.close();
                }
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable th) {
                        statLogger4 = StatService.f18354i;
                        statLogger4.m5236e(th);
                    }
                }
            } catch (IOException e) {
                i2 = -1;
                statLogger2 = StatService.f18354i;
                statLogger2.m5237e((Exception) e);
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable th2) {
                        statLogger3 = StatService.f18354i;
                        statLogger3.m5236e(th2);
                    }
                }
            }
            networkMonitor.setStatusCode(i2);
            return networkMonitor;
        } catch (Throwable th3) {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Throwable th4) {
                    statLogger = StatService.f18354i;
                    statLogger.m5236e(th4);
                }
            }
            throw th3;
        }
    }

    /* renamed from: a */
    private Map<String, Integer> m5141a() {
        String str;
        StatLogger statLogger;
        HashMap hashMap = new HashMap();
        String m5292a = StatConfig.m5292a("__MTA_TEST_SPEED__", (String) null);
        if (m5292a != null && m5292a.trim().length() != 0) {
            for (String str2 : m5292a.split(";")) {
                String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 2 && (str = split[0]) != null && str.trim().length() != 0) {
                    try {
                        hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                    } catch (NumberFormatException e) {
                        statLogger = StatService.f18354i;
                        statLogger.m5237e((Exception) e);
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        StatLogger statLogger4;
        try {
            if (!C4420k.m5180h(this.f18482a)) {
                return;
            }
            if (this.f18483b == null) {
                this.f18483b = m5141a();
            }
            if (this.f18483b == null || this.f18483b.size() == 0) {
                statLogger2 = StatService.f18354i;
                statLogger2.m5233w("empty domain list.");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : this.f18483b.entrySet()) {
                String key = entry.getKey();
                if (key == null || key.length() == 0) {
                    statLogger3 = StatService.f18354i;
                    statLogger3.m5233w("empty domain name.");
                } else if (entry.getValue() == null) {
                    statLogger4 = StatService.f18354i;
                    statLogger4.m5233w("port is null for " + key);
                } else {
                    jSONArray.put(m5140a(entry.getKey(), entry.getValue().intValue()).toJSONObject());
                }
            }
            if (jSONArray.length() == 0) {
                return;
            }
            C4405i c4405i = new C4405i(this.f18482a, StatService.m5270a(this.f18482a, false));
            c4405i.m5243a(jSONArray.toString());
            if (StatService.m5265c(this.f18482a) == null) {
                return;
            }
            StatService.m5265c(this.f18482a).post(new RunnableC4433k(c4405i));
        } catch (Throwable th) {
            statLogger = StatService.f18354i;
            statLogger.m5236e(th);
        }
    }
}
