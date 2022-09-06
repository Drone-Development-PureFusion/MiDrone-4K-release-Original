package p000a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.C0004c;
/* renamed from: a.d */
/* loaded from: classes.dex */
public class C0006d {

    /* renamed from: a */
    private static final String f14a = "user_agent";

    /* renamed from: b */
    private static final String f15b = "version";

    /* renamed from: c */
    private static final String f16c = "referer_app_link";

    /* renamed from: d */
    private static final String f17d = "app_name";

    /* renamed from: e */
    private static final String f18e = "package";

    /* renamed from: f */
    private static final String f19f = "1.0";

    /* renamed from: g */
    private static AbstractC0009e f20g;

    /* renamed from: h */
    private final C0004c f21h;

    /* renamed from: i */
    private final Bundle f22i;

    /* renamed from: j */
    private final Bundle f23j;

    /* renamed from: a.d$a */
    /* loaded from: classes.dex */
    public enum EnumC0008a {
        FAILED("failed", false),
        WEB("web", true),
        APP("app", true);
        

        /* renamed from: d */
        private String f29d;

        /* renamed from: e */
        private boolean f30e;

        EnumC0008a(String str, boolean z) {
            this.f29d = str;
            this.f30e = z;
        }

        /* renamed from: a */
        public String m21638a() {
            return this.f29d;
        }

        /* renamed from: b */
        public boolean m21637b() {
            return this.f30e;
        }
    }

    public C0006d(C0004c c0004c, Bundle bundle, Bundle bundle2) {
        if (c0004c == null) {
            throw new IllegalArgumentException("appLink must not be null.");
        }
        bundle = bundle == null ? new Bundle() : bundle;
        bundle2 = bundle2 == null ? new Bundle() : bundle2;
        this.f21h = c0004c;
        this.f22i = bundle;
        this.f23j = bundle2;
    }

    /* renamed from: a */
    public static EnumC0008a m21654a(Context context, C0004c c0004c) {
        return new C0006d(c0004c, null, null).m21655a(context);
    }

    /* renamed from: a */
    public static C0018l<EnumC0008a> m21652a(Context context, Uri uri) {
        return m21651a(context, uri, m21641c(context));
    }

    /* renamed from: a */
    public static C0018l<EnumC0008a> m21651a(final Context context, Uri uri, AbstractC0009e abstractC0009e) {
        return abstractC0009e.mo21567a(uri).m21597c(new AbstractC0016j<C0004c, EnumC0008a>() { // from class: a.d.1
            @Override // p000a.AbstractC0016j
            /* renamed from: a */
            public EnumC0008a mo21799then(C0018l<C0004c> c0018l) {
                return C0006d.m21654a(context, c0018l.m21590e());
            }
        }, C0018l.f50b);
    }

    /* renamed from: a */
    public static C0018l<EnumC0008a> m21650a(Context context, String str) {
        return m21649a(context, str, m21641c(context));
    }

    /* renamed from: a */
    public static C0018l<EnumC0008a> m21649a(Context context, String str, AbstractC0009e abstractC0009e) {
        return m21651a(context, Uri.parse(str), abstractC0009e);
    }

    /* renamed from: a */
    public static C0018l<EnumC0008a> m21648a(Context context, URL url) {
        return m21647a(context, url, m21641c(context));
    }

    /* renamed from: a */
    public static C0018l<EnumC0008a> m21647a(Context context, URL url, AbstractC0009e abstractC0009e) {
        return m21651a(context, Uri.parse(url.toString()), abstractC0009e);
    }

    /* renamed from: a */
    private Object m21645a(Object obj) {
        int i = 0;
        if (obj instanceof Bundle) {
            return m21646a((Bundle) obj);
        }
        if (obj instanceof CharSequence) {
            return obj.toString();
        }
        if (obj instanceof List) {
            JSONArray jSONArray = new JSONArray();
            for (Object obj2 : (List) obj) {
                jSONArray.put(m21645a(obj2));
            }
            return jSONArray;
        } else if (obj instanceof SparseArray) {
            JSONArray jSONArray2 = new JSONArray();
            SparseArray sparseArray = (SparseArray) obj;
            while (i < sparseArray.size()) {
                jSONArray2.put(sparseArray.keyAt(i), m21645a(sparseArray.valueAt(i)));
                i++;
            }
            return jSONArray2;
        } else if (obj instanceof Character) {
            return obj.toString();
        } else {
            if (obj instanceof Boolean) {
                return obj;
            }
            if (obj instanceof Number) {
                return ((obj instanceof Double) || (obj instanceof Float)) ? Double.valueOf(((Number) obj).doubleValue()) : Long.valueOf(((Number) obj).longValue());
            } else if (obj instanceof boolean[]) {
                JSONArray jSONArray3 = new JSONArray();
                boolean[] zArr = (boolean[]) obj;
                int length = zArr.length;
                while (i < length) {
                    jSONArray3.put(m21645a(Boolean.valueOf(zArr[i])));
                    i++;
                }
                return jSONArray3;
            } else if (obj instanceof char[]) {
                JSONArray jSONArray4 = new JSONArray();
                char[] cArr = (char[]) obj;
                int length2 = cArr.length;
                while (i < length2) {
                    jSONArray4.put(m21645a(Character.valueOf(cArr[i])));
                    i++;
                }
                return jSONArray4;
            } else if (obj instanceof CharSequence[]) {
                JSONArray jSONArray5 = new JSONArray();
                CharSequence[] charSequenceArr = (CharSequence[]) obj;
                int length3 = charSequenceArr.length;
                while (i < length3) {
                    jSONArray5.put(m21645a(charSequenceArr[i]));
                    i++;
                }
                return jSONArray5;
            } else if (obj instanceof double[]) {
                JSONArray jSONArray6 = new JSONArray();
                double[] dArr = (double[]) obj;
                int length4 = dArr.length;
                while (i < length4) {
                    jSONArray6.put(m21645a(Double.valueOf(dArr[i])));
                    i++;
                }
                return jSONArray6;
            } else if (obj instanceof float[]) {
                JSONArray jSONArray7 = new JSONArray();
                float[] fArr = (float[]) obj;
                int length5 = fArr.length;
                while (i < length5) {
                    jSONArray7.put(m21645a(Float.valueOf(fArr[i])));
                    i++;
                }
                return jSONArray7;
            } else if (obj instanceof int[]) {
                JSONArray jSONArray8 = new JSONArray();
                int[] iArr = (int[]) obj;
                int length6 = iArr.length;
                while (i < length6) {
                    jSONArray8.put(m21645a(Integer.valueOf(iArr[i])));
                    i++;
                }
                return jSONArray8;
            } else if (obj instanceof long[]) {
                JSONArray jSONArray9 = new JSONArray();
                long[] jArr = (long[]) obj;
                int length7 = jArr.length;
                while (i < length7) {
                    jSONArray9.put(m21645a(Long.valueOf(jArr[i])));
                    i++;
                }
                return jSONArray9;
            } else if (obj instanceof short[]) {
                JSONArray jSONArray10 = new JSONArray();
                short[] sArr = (short[]) obj;
                int length8 = sArr.length;
                while (i < length8) {
                    jSONArray10.put(m21645a(Short.valueOf(sArr[i])));
                    i++;
                }
                return jSONArray10;
            } else if (!(obj instanceof String[])) {
                return null;
            } else {
                JSONArray jSONArray11 = new JSONArray();
                String[] strArr = (String[]) obj;
                int length9 = strArr.length;
                while (i < length9) {
                    jSONArray11.put(m21645a(strArr[i]));
                    i++;
                }
                return jSONArray11;
            }
        }
    }

    /* renamed from: a */
    private JSONObject m21646a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            jSONObject.put(str, m21645a(bundle.get(str)));
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m21656a(AbstractC0009e abstractC0009e) {
        f20g = abstractC0009e;
    }

    /* renamed from: a */
    private void m21653a(Context context, Intent intent, EnumC0008a enumC0008a, JSONException jSONException) {
        HashMap hashMap = new HashMap();
        if (jSONException != null) {
            hashMap.put(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2, jSONException.getLocalizedMessage());
        }
        hashMap.put("success", enumC0008a.m21637b() ? "1" : "0");
        hashMap.put("type", enumC0008a.m21638a());
        C0017k.m21624a(context, C0017k.f44d, intent, hashMap);
    }

    /* renamed from: b */
    private Bundle m21643b(Context context) {
        String string;
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        if (context != null) {
            String packageName = context.getPackageName();
            if (packageName != null) {
                bundle2.putString(f18e, packageName);
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && (string = context.getString(applicationInfo.labelRes)) != null) {
                bundle2.putString("app_name", string);
            }
        }
        bundle.putAll(m21644b());
        bundle.putString("target_url", m21657a().m21664a().toString());
        bundle.putString("version", "1.0");
        bundle.putString(f14a, "Bolts Android 1.1.4");
        bundle.putBundle(f16c, bundle2);
        bundle.putBundle("extras", m21642c());
        return bundle;
    }

    /* renamed from: c */
    private static AbstractC0009e m21641c(Context context) {
        return m21640d() != null ? m21640d() : new C0031m(context);
    }

    /* renamed from: d */
    public static AbstractC0009e m21640d() {
        return f20g;
    }

    /* renamed from: a */
    public C0004c m21657a() {
        return this.f21h;
    }

    /* renamed from: a */
    public EnumC0008a m21655a(Context context) {
        Intent intent;
        Intent intent2;
        EnumC0008a enumC0008a;
        PackageManager packageManager = context.getPackageManager();
        Bundle m21643b = m21643b(context);
        Iterator<C0004c.C0005a> it2 = m21657a().m21663b().iterator();
        while (true) {
            if (!it2.hasNext()) {
                intent = null;
                break;
            }
            C0004c.C0005a next = it2.next();
            Intent intent3 = new Intent("android.intent.action.VIEW");
            if (next.m21661a() != null) {
                intent3.setData(next.m21661a());
            } else {
                intent3.setData(this.f21h.m21664a());
            }
            intent3.setPackage(next.m21658d());
            if (next.m21659c() != null) {
                intent3.setClassName(next.m21658d(), next.m21659c());
            }
            intent3.putExtra("al_applink_data", m21643b);
            if (packageManager.resolveActivity(intent3, 65536) != null) {
                intent = intent3;
                break;
            }
        }
        EnumC0008a enumC0008a2 = EnumC0008a.FAILED;
        if (intent != null) {
            intent2 = intent;
            enumC0008a = EnumC0008a.APP;
        } else {
            Uri m21662c = m21657a().m21662c();
            if (m21662c != null) {
                try {
                    intent2 = new Intent("android.intent.action.VIEW", m21662c.buildUpon().appendQueryParameter("al_applink_data", m21646a(m21643b).toString()).build());
                    enumC0008a = EnumC0008a.WEB;
                } catch (JSONException e) {
                    m21653a(context, intent, EnumC0008a.FAILED, e);
                    throw new RuntimeException(e);
                }
            } else {
                enumC0008a = enumC0008a2;
                intent2 = null;
            }
        }
        m21653a(context, intent2, enumC0008a, null);
        if (intent2 != null) {
            context.startActivity(intent2);
        }
        return enumC0008a;
    }

    /* renamed from: b */
    public Bundle m21644b() {
        return this.f23j;
    }

    /* renamed from: c */
    public Bundle m21642c() {
        return this.f22i;
    }
}
