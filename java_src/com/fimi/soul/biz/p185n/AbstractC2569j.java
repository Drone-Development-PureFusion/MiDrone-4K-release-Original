package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.SuggestBean;
import com.fimi.soul.utils.C3638ah;
import com.fimi.soul.utils.NetUtil;
import com.github.moduth.blockcanary.p215b.C3947a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.n.j */
/* loaded from: classes.dex */
public abstract class AbstractC2569j implements Handler.Callback {

    /* renamed from: b */
    public String f8852b;

    /* renamed from: c */
    public String f8853c;

    /* renamed from: d */
    public String f8854d;

    /* renamed from: g */
    private Context f8857g;

    /* renamed from: a */
    List<NameValuePair> f8851a = new ArrayList();

    /* renamed from: e */
    public PlaneMsg f8855e = null;

    /* renamed from: h */
    private Handler f8858h = new Handler(this);

    /* renamed from: f */
    public HashMap<Integer, AbstractC2538k> f8856f = new HashMap<>();

    /* renamed from: com.fimi.soul.biz.n.j$a */
    /* loaded from: classes.dex */
    class RunnableC2570a implements Runnable {

        /* renamed from: a */
        int f8859a;

        /* renamed from: b */
        Object f8860b;

        /* renamed from: c */
        AbstractC2538k f8861c;

        public RunnableC2570a(int i, Object obj, AbstractC2538k abstractC2538k) {
            this.f8859a = i;
            this.f8860b = obj;
            this.f8861c = abstractC2538k;
        }

        @Override // java.lang.Runnable
        public void run() {
            PlaneMsg planeMsg = null;
            try {
                planeMsg = AbstractC2569j.this.m11653b(this.f8860b);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Message obtainMessage = AbstractC2569j.this.f8858h.obtainMessage();
            obtainMessage.what = this.f8859a;
            obtainMessage.obj = planeMsg;
            AbstractC2569j.this.f8858h.sendMessage(obtainMessage);
        }
    }

    public AbstractC2569j(Context context) {
        this.f8857g = context;
    }

    /* renamed from: a */
    public String m11656a() {
        return this.f8854d;
    }

    /* renamed from: a */
    public void m11654a(Object obj) {
        Field[] declaredFields;
        for (Field field : obj.getClass().getDeclaredFields()) {
            String name = field.getName();
            String obj2 = field.getGenericType().toString();
            Method method = obj.getClass().getMethod("get" + (name.substring(0, 1).toUpperCase() + name.substring(1)), new Class[0]);
            if (obj2 == null || !"java.util.List<java.lang.String>".equals(obj2)) {
                String str = (String) method.invoke(obj, new Object[0]);
                if (str != null && str.length() > 0) {
                    this.f8851a.add(new BasicNameValuePair(field.getName(), str));
                }
            } else {
                List<String> list = (List) method.invoke(obj, new Object[0]);
                if (list != null && list.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str2 : list) {
                        stringBuffer.append(str2);
                        stringBuffer.append(";");
                    }
                    this.f8851a.add(new BasicNameValuePair("paramlist", stringBuffer.toString().substring(0, stringBuffer.length() - 1)));
                }
            }
        }
    }

    /* renamed from: b */
    public PlaneMsg m11653b(Object obj) {
        SuggestBean suggestBean = (SuggestBean) obj;
        this.f8851a.add(new BasicNameValuePair("userID", suggestBean.getUserID()));
        this.f8851a.add(new BasicNameValuePair(C3947a.f16893d, suggestBean.getModel()));
        this.f8851a.add(new BasicNameValuePair("content", suggestBean.getContent()));
        if (suggestBean.getContact() != null && !"".equals(suggestBean.getContact())) {
            this.f8851a.add(new BasicNameValuePair("contact", suggestBean.getContact()));
        }
        this.f8851a.add(new BasicNameValuePair("commandCode", suggestBean.getCommandCode()));
        List<String> list = suggestBean.getList();
        if (list != null && list.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : list) {
                stringBuffer.append(str);
                stringBuffer.append(";");
            }
            this.f8851a.add(new BasicNameValuePair("paramlist", stringBuffer.toString().substring(0, stringBuffer.length() - 1)));
        }
        String m7762b = NetUtil.m7762b(C2353b.f7951i, this.f8851a, this.f8857g);
        if (m7762b == null || m7762b.length() == 0) {
            Log.e("error:", "respMsg is null");
            return null;
        }
        Log.i("Response:[%s]", m7762b);
        try {
            new JSONObject(m7762b);
            this.f8855e = (PlaneMsg) C3638ah.m7703b(PlaneMsg.class, m7762b);
        } catch (Exception e) {
            Log.i("Exception:[%s]", e.getMessage());
        }
        this.f8851a = null;
        return this.f8855e;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f8856f.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return true;
        }
        return true;
    }
}
