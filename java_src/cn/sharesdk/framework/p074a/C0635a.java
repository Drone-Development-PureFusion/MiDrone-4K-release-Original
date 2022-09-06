package cn.sharesdk.framework.p074a;

import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.network.HTTPPart;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.RawNetworkCallback;
import java.util.ArrayList;
/* renamed from: cn.sharesdk.framework.a.a */
/* loaded from: classes.dex */
public class C0635a extends NetworkHelper {

    /* renamed from: a */
    private static C0635a f1451a = null;

    private C0635a() {
    }

    /* renamed from: a */
    public static C0635a m19742a() {
        if (f1451a == null) {
            f1451a = new C0635a();
        }
        return f1451a;
    }

    /* renamed from: a */
    private void m19741a(String str, int i) {
        if (TextUtils.isEmpty(str) || i <= 0) {
            return;
        }
        ShareSDK.logApiEvent(str, i);
    }

    /* renamed from: a */
    public String m19739a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, String str2, int i) {
        return m19737a(str, arrayList, kVPair, (ArrayList<KVPair<String>>) null, str2, i);
    }

    /* renamed from: a */
    public String m19738a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i) {
        m19741a(str2, i);
        return super.httpPost(str, arrayList, kVPair, arrayList2, networkTimeOut);
    }

    /* renamed from: a */
    public String m19737a(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, String str2, int i) {
        return m19738a(str, arrayList, kVPair, arrayList2, null, str2, i);
    }

    /* renamed from: a */
    public String m19736a(String str, ArrayList<KVPair<String>> arrayList, String str2, int i) {
        return m19735a(str, arrayList, (ArrayList<KVPair<String>>) null, (NetworkHelper.NetworkTimeOut) null, str2, i);
    }

    /* renamed from: a */
    public String m19735a(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i) {
        m19741a(str2, i);
        return super.httpGet(str, arrayList, arrayList2, networkTimeOut);
    }

    /* renamed from: a */
    public void m19740a(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, String str2, int i) {
        m19741a(str2, i);
        super.rawPost(str, arrayList, hTTPPart, rawNetworkCallback, (NetworkHelper.NetworkTimeOut) null);
    }

    /* renamed from: b */
    public String m19734b(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i) {
        m19741a(str2, i);
        return super.httpPut(str, arrayList, kVPair, arrayList2, networkTimeOut);
    }

    /* renamed from: b */
    public String m19733b(String str, ArrayList<KVPair<String>> arrayList, String str2, int i) {
        return m19739a(str, arrayList, null, str2, i);
    }

    /* renamed from: b */
    public String m19732b(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkHelper.NetworkTimeOut networkTimeOut, String str2, int i) {
        m19741a(str2, i);
        return super.jsonPost(str, arrayList, arrayList2, networkTimeOut);
    }
}
