package com.fimi.kernel.p157b.p159b;

import android.os.Message;
import com.fimi.kernel.AbstractC2180b;
import com.fimi.kernel.p157b.AbstractC2182a;
import com.fimi.kernel.p157b.AbstractC2228e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: com.fimi.kernel.b.b.e */
/* loaded from: classes.dex */
public class C2211e extends AbstractC2180b implements AbstractC2182a {

    /* renamed from: a */
    private volatile int f7413a = 0;

    /* renamed from: b */
    private Map<Integer, AbstractC2228e> f7414b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized int m13210b() {
        this.f7413a++;
        return this.f7413a;
    }

    @Override // com.fimi.kernel.AbstractC2180b
    /* renamed from: a */
    protected void mo9399a(Message message) {
        AbstractC2228e abstractC2228e = this.f7414b.get(Integer.valueOf(message.what));
        if (abstractC2228e != null) {
            if (message.arg1 == 1) {
                abstractC2228e.mo8307a(message.obj);
            } else {
                abstractC2228e.mo8305b(message.obj);
            }
            this.f7414b.remove(abstractC2228e);
        }
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: a */
    public void mo13150a(final String str, final AbstractC2228e<String> abstractC2228e) {
        a(new Runnable() { // from class: com.fimi.kernel.b.b.e.1
            /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int m13210b;
                InputStreamReader inputStreamReader;
                InputStreamReader inputStreamReader2;
                HttpURLConnection httpURLConnection = null;
                do {
                    m13210b = C2211e.this.m13210b();
                } while (C2211e.this.f7414b.containsKey(Integer.valueOf(m13210b)));
                C2211e.this.f7414b.put(Integer.valueOf(m13210b), abstractC2228e);
                Message message = new Message();
                message.what = m13210b;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        inputStreamReader = new InputStreamReader(httpURLConnection2.getInputStream());
                        try {
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            }
                            message.obj = stringBuffer.toString();
                            message.arg1 = 1;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e2) {
                            httpURLConnection = httpURLConnection2;
                            e = e2;
                            inputStreamReader2 = inputStreamReader;
                            try {
                                message.arg1 = 0;
                                message.obj = e.toString();
                                e.printStackTrace();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (inputStreamReader2 != null) {
                                    try {
                                        inputStreamReader2.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                C2211e.this.a().sendMessage(message);
                            } catch (Throwable th) {
                                th = th;
                                inputStreamReader = inputStreamReader2;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            httpURLConnection = httpURLConnection2;
                            th = th2;
                            if (httpURLConnection != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        inputStreamReader2 = null;
                        httpURLConnection = httpURLConnection2;
                        e = e5;
                    } catch (Throwable th3) {
                        inputStreamReader = null;
                        httpURLConnection = httpURLConnection2;
                        th = th3;
                    }
                } catch (Exception e6) {
                    e = e6;
                    inputStreamReader2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                }
                C2211e.this.a().sendMessage(message);
            }
        });
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: a */
    public <T> void mo13149a(String str, AbstractC2228e<T> abstractC2228e, Class<?> cls) {
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: a */
    public void mo13148a(String str, Map<String, String> map, AbstractC2228e<String> abstractC2228e) {
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: a */
    public <T> void mo13147a(String str, Map<String, String> map, AbstractC2228e<T> abstractC2228e, Class<?> cls) {
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: a */
    public void mo13146a(String str, JSONObject jSONObject, AbstractC2228e<JSONObject> abstractC2228e) {
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: b */
    public void mo13145b(String str, AbstractC2228e<String> abstractC2228e) {
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: b */
    public <T> void mo13144b(String str, AbstractC2228e<T> abstractC2228e, Class<?> cls) {
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: b */
    public void mo13143b(String str, JSONObject jSONObject, AbstractC2228e<JSONObject> abstractC2228e) {
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: c */
    public void mo13142c(String str, AbstractC2228e<JSONObject> abstractC2228e) {
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: d */
    public void mo13141d(String str, AbstractC2228e<JSONObject> abstractC2228e) {
    }
}
