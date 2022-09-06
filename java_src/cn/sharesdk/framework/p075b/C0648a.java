package cn.sharesdk.framework.p075b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.p075b.p076a.C0651c;
import cn.sharesdk.framework.p075b.p076a.C0653e;
import cn.sharesdk.framework.p075b.p077b.AbstractC0657c;
import cn.sharesdk.framework.p075b.p077b.C0656b;
import cn.sharesdk.framework.p075b.p077b.C0660f;
import cn.sharesdk.framework.utils.C0683d;
import com.facebook.common.util.UriUtil;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.tencent.open.SocialConstants;
import com.tencent.p227mm.sdk.platformtools.Util;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
/* renamed from: cn.sharesdk.framework.b.a */
/* loaded from: classes.dex */
public class C0648a {

    /* renamed from: a */
    private static C0648a f1480a;

    /* renamed from: b */
    private C0663c f1481b;

    /* renamed from: c */
    private DeviceHelper f1482c;

    /* renamed from: d */
    private C0653e f1483d;

    /* renamed from: e */
    private boolean f1484e;

    private C0648a(Context context, String str) {
        this.f1481b = new C0663c(context, str);
        this.f1483d = C0653e.m19677a(context);
        this.f1482c = DeviceHelper.getInstance(context);
    }

    /* renamed from: a */
    public static C0648a m19708a(Context context, String str) {
        if (f1480a == null) {
            f1480a = new C0648a(context, str);
        }
        return f1480a;
    }

    /* renamed from: a */
    private String m19706a(Bitmap bitmap, EnumC0654b enumC0654b) {
        File createTempFile = File.createTempFile("bm_tmp", ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return m19700a(createTempFile.getAbsolutePath(), enumC0654b);
    }

    /* renamed from: a */
    private String m19700a(String str, EnumC0654b enumC0654b) {
        int ceil;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        String networkType = this.f1482c.getNetworkType();
        if ("none".equals(networkType) || TextUtils.isEmpty(networkType)) {
            return null;
        }
        Bitmap.CompressFormat bmpFormat = BitmapHelper.getBmpFormat(str);
        float f = 200.0f;
        if (enumC0654b == EnumC0654b.BEFORE_SHARE) {
            f = 600.0f;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (i >= i2 && i2 > f) {
            ceil = (int) Math.ceil(options.outHeight / f);
        } else if (i >= i2 || i <= f) {
            return m19692c(str);
        } else {
            ceil = (int) Math.ceil(options.outWidth / f);
        }
        if (ceil <= 0) {
            ceil = 1;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = ceil;
        options2.inPurgeable = true;
        options2.inInputShareable = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options2);
        decodeFile.getHeight();
        decodeFile.getWidth();
        File createTempFile = File.createTempFile("bm_tmp2", "." + bmpFormat.name().toLowerCase());
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        decodeFile.compress(bmpFormat, 80, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return m19692c(createTempFile.getAbsolutePath());
    }

    /* renamed from: a */
    private String m19699a(String str, String str2, int i, String str3) {
        HashMap<String, Object> m19641a;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Pattern compile = Pattern.compile(str2);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            if (group != null && group.length() > 0) {
                arrayList.add(group);
            }
        }
        if (arrayList.size() == 0 || (m19641a = this.f1481b.m19641a(str, arrayList, i, str3)) == null || m19641a.size() <= 0 || !m19641a.containsKey("data")) {
            return str;
        }
        HashMap hashMap = new HashMap();
        Iterator it2 = ((ArrayList) m19641a.get("data")).iterator();
        while (it2.hasNext()) {
            HashMap hashMap2 = (HashMap) it2.next();
            hashMap.put(String.valueOf(hashMap2.get(SocialConstants.PARAM_SOURCE)), String.valueOf(hashMap2.get("surl")));
        }
        Matcher matcher2 = compile.matcher(str);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (matcher2.find()) {
            sb.append(str.substring(i2, matcher2.start()));
            sb.append((String) hashMap.get(matcher2.group()));
            i2 = matcher2.end();
        }
        sb.append(str.substring(i2, str.length()));
        String sb2 = sb.toString();
        C0683d.m19513a().m5966i("> SERVER_SHORT_LINK_URL content after replace link ===  %s", sb2);
        return sb2;
    }

    /* renamed from: a */
    private void m19705a(C0656b c0656b) {
        boolean m19666c = this.f1483d.m19666c();
        String str = c0656b.f1504c;
        if (m19666c && !TextUtils.isEmpty(str)) {
            c0656b.f1504c = Data.Base64AES(str, c0656b.f1507f.substring(0, 16));
            return;
        }
        c0656b.f1505d = null;
        c0656b.f1504c = null;
    }

    /* renamed from: a */
    private void m19703a(C0660f c0660f) {
        int m19662e = this.f1483d.m19662e();
        boolean m19666c = this.f1483d.m19666c();
        C0660f.C0661a c0661a = c0660f.f1528d;
        if (m19662e == 1 || (m19662e == 0 && this.f1484e)) {
            int size = (c0661a == null || c0661a.f1535e == null) ? 0 : c0661a.f1535e.size();
            for (int i = 0; i < size; i++) {
                String m19700a = m19700a(c0661a.f1535e.get(i), EnumC0654b.FINISH_SHARE);
                if (!TextUtils.isEmpty(m19700a)) {
                    c0661a.f1534d.add(m19700a);
                }
            }
            int size2 = (c0661a == null || c0661a.f1536f == null) ? 0 : c0661a.f1536f.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String m19706a = m19706a(c0661a.f1536f.get(i2), EnumC0654b.FINISH_SHARE);
                if (!TextUtils.isEmpty(m19706a)) {
                    c0661a.f1534d.add(m19706a);
                }
            }
        } else {
            c0660f.f1528d = null;
        }
        if (!m19666c) {
            c0660f.f1529n = null;
        }
    }

    /* renamed from: a */
    private boolean m19698a(String str, boolean z) {
        return this.f1481b.m19640a(str, z);
    }

    /* renamed from: c */
    private String m19692c(String str) {
        HashMap<String, Object> m19636b = this.f1481b.m19636b(str);
        if (m19636b == null || m19636b.size() <= 0 || !m19636b.containsKey("status") || ResHelper.parseInt(String.valueOf(m19636b.get("status"))) != 200 || !m19636b.containsKey("url")) {
            return null;
        }
        return (String) m19636b.get("url");
    }

    /* renamed from: d */
    private String m19690d(String str) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = byteArrayInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
            gZIPOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public String m19707a(Bitmap bitmap) {
        if (!this.f1483d.m19658g()) {
            return null;
        }
        try {
            return m19706a(bitmap, EnumC0654b.BEFORE_SHARE);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return null;
        }
    }

    /* renamed from: a */
    public String m19702a(String str) {
        if (!this.f1483d.m19658g()) {
            return null;
        }
        try {
            return m19700a(str, EnumC0654b.BEFORE_SHARE);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return null;
        }
    }

    /* renamed from: a */
    public String m19701a(String str, int i, boolean z, String str2) {
        String m19699a;
        try {
            if (!this.f1483d.m19658g() || !this.f1483d.m19664d()) {
                return str;
            }
            String networkType = this.f1482c.getNetworkType();
            if ("none".equals(networkType) || TextUtils.isEmpty(networkType)) {
                return str;
            }
            if (z && (m19699a = m19699a(str, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", i, str2)) != null && !m19699a.equals(str)) {
                return m19699a;
            }
            String m19699a2 = m19699a(str, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", i, str2);
            return m19699a2 != null ? !m19699a2.equals(str) ? m19699a2 : str : str;
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return str;
        }
    }

    /* renamed from: a */
    public void m19709a() {
        try {
            String networkType = this.f1482c.getNetworkType();
            if ("none".equals(networkType) || TextUtils.isEmpty(networkType)) {
                return;
            }
            long longValue = this.f1483d.m19656h().longValue();
            long currentTimeMillis = System.currentTimeMillis();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(longValue);
            int i = calendar.get(5);
            calendar.setTimeInMillis(currentTimeMillis);
            int i2 = calendar.get(5);
            if (currentTimeMillis - longValue < Util.MILLSECONDS_OF_DAY && i == i2) {
                return;
            }
            HashMap<String, Object> m19644a = this.f1481b.m19644a();
            this.f1483d.m19671a(m19644a.containsKey(UriUtil.LOCAL_RESOURCE_SCHEME) ? "true".equals(String.valueOf(m19644a.get(UriUtil.LOCAL_RESOURCE_SCHEME))) : true);
            if (m19644a == null || m19644a.size() <= 0) {
                return;
            }
            this.f1483d.m19669b(System.currentTimeMillis());
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
    }

    /* renamed from: a */
    public void m19704a(AbstractC0657c abstractC0657c) {
        try {
            if (!this.f1483d.m19658g()) {
                return;
            }
            if (abstractC0657c instanceof C0656b) {
                m19705a((C0656b) abstractC0657c);
            } else if (abstractC0657c instanceof C0660f) {
                m19703a((C0660f) abstractC0657c);
            }
            if (!this.f1483d.m19670b()) {
                abstractC0657c.f1514m = null;
            }
            long m19679a = this.f1483d.m19679a();
            if (m19679a == 0) {
                m19679a = this.f1481b.m19637b();
            }
            abstractC0657c.f1506e = System.currentTimeMillis() - m19679a;
            this.f1481b.m19643a(abstractC0657c);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
    }

    /* renamed from: a */
    public void m19697a(HashMap<String, Object> hashMap) {
        try {
            this.f1481b.m19635b(hashMap);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
    }

    /* renamed from: a */
    public void m19696a(boolean z) {
        this.f1484e = z;
    }

    /* renamed from: b */
    public HashMap<String, Object> m19694b(String str) {
        try {
            return this.f1481b.m19633c(str);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return new HashMap<>();
        }
    }

    /* renamed from: b */
    public void m19695b() {
        HashMap hashMap;
        HashMap hashMap2;
        try {
            String networkType = this.f1482c.getNetworkType();
            if ("none".equals(networkType) || TextUtils.isEmpty(networkType) || !this.f1483d.m19658g()) {
                return;
            }
            this.f1483d.m19678a(System.currentTimeMillis());
            HashMap<String, Object> m19634c = this.f1481b.m19634c();
            if (m19634c.containsKey("status") && ResHelper.parseInt(String.valueOf(m19634c.get("status"))) == -200) {
                C0683d.m19513a().m5972d((String) m19634c.get(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2), new Object[0]);
                return;
            }
            if (m19634c.containsKey("timestamp")) {
                this.f1483d.m19674a("service_time", Long.valueOf(System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(m19634c.get("timestamp")))));
            }
            if (m19634c.containsKey("switchs") && (hashMap2 = (HashMap) m19634c.get("switchs")) != null) {
                String valueOf = String.valueOf(hashMap2.get("device"));
                String valueOf2 = String.valueOf(hashMap2.get("share"));
                String valueOf3 = String.valueOf(hashMap2.get("auth"));
                String valueOf4 = String.valueOf(hashMap2.get("backflow"));
                this.f1483d.m19668b(valueOf);
                this.f1483d.m19663d(valueOf2);
                this.f1483d.m19665c(valueOf3);
                this.f1483d.m19676a(valueOf4);
            }
            if (!m19634c.containsKey("serpaths") || (hashMap = (HashMap) m19634c.get("serpaths")) == null) {
                return;
            }
            String valueOf5 = String.valueOf(hashMap.get("defhost"));
            String valueOf6 = String.valueOf(hashMap.get("defport"));
            if (!TextUtils.isEmpty(valueOf5) && !TextUtils.isEmpty(valueOf6)) {
                this.f1481b.m19642a("http://" + valueOf5 + ":" + valueOf6);
            }
            HashMap<String, String> hashMap3 = new HashMap<>();
            if (!hashMap.containsKey("assigns")) {
                return;
            }
            HashMap hashMap4 = (HashMap) hashMap.get("assigns");
            if (hashMap4 == null || hashMap4.size() == 0) {
                this.f1481b.m19638a((HashMap<String, String>) null);
                return;
            }
            for (String str : hashMap4.keySet()) {
                HashMap hashMap5 = (HashMap) hashMap4.get(str);
                String valueOf7 = String.valueOf(hashMap5.get("host"));
                String valueOf8 = String.valueOf(hashMap5.get("port"));
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf7) && !TextUtils.isEmpty(valueOf8)) {
                    hashMap3.put(str, "http://" + valueOf7 + ":" + valueOf8);
                }
            }
            this.f1481b.m19638a(hashMap3);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
    }

    /* renamed from: c */
    public void m19693c() {
        try {
            String networkType = this.f1482c.getNetworkType();
            if ("none".equals(networkType) || TextUtils.isEmpty(networkType) || !this.f1483d.m19658g()) {
                return;
            }
            ArrayList<C0651c> m19630e = this.f1481b.m19630e();
            for (int i = 0; i < m19630e.size(); i++) {
                C0651c c0651c = m19630e.get(i);
                if (c0651c.f1489b.size() == 1 ? m19698a(c0651c.f1488a, false) : m19698a(m19690d(c0651c.f1488a), true)) {
                    this.f1481b.m19639a(c0651c.f1489b);
                }
            }
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
    }

    /* renamed from: d */
    public HashMap<String, Object> m19691d() {
        try {
            return this.f1481b.m19629f();
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return new HashMap<>();
        }
    }

    /* renamed from: e */
    public HashMap<String, Object> m19689e() {
        if (this.f1483d.m19658g() || !this.f1483d.m19654i()) {
            try {
                HashMap<String, Object> m19632d = this.f1481b.m19632d();
                this.f1483d.m19667b(true);
                return m19632d;
            } catch (Throwable th) {
                this.f1483d.m19667b(false);
                C0683d.m19513a().m5971d(th);
                return new HashMap<>();
            }
        }
        return new HashMap<>();
    }
}
