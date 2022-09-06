package cn.sharesdk.sina.weibo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import cn.sharesdk.framework.authorize.AbstractC0641d;
import cn.sharesdk.framework.authorize.C0640c;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
/* renamed from: cn.sharesdk.sina.weibo.c */
/* loaded from: classes.dex */
public class ServiceConnectionC0695c extends AbstractC0641d implements ServiceConnection {

    /* renamed from: d */
    private String f1645d;

    /* renamed from: e */
    private String f1646e;

    /* renamed from: f */
    private String[] f1647f;

    public ServiceConnectionC0695c(C0640c c0640c) {
        super(c0640c);
    }

    /* renamed from: a */
    private boolean m19464a(String str, String str2) {
        boolean z = true;
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtra("appKey", this.f1645d);
        intent.putExtra("redirectUri", this.f1646e);
        if (this.f1647f != null && this.f1647f.length > 0) {
            intent.putExtra("scope", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, this.f1647f));
        }
        if (!m19462b(intent)) {
            return false;
        }
        try {
            this.f1466a.startActivityForResult(intent, this.f1467b);
        } catch (Throwable th) {
            z = false;
        }
        this.f1466a.getContext().getApplicationContext().unbindService(this);
        return z;
    }

    /* renamed from: b */
    private boolean m19462b(Intent intent) {
        ResolveInfo resolveActivity = this.f1466a.getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            Signature[] signatureArr = this.f1466a.getContext().getPackageManager().getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            for (Signature signature : signatureArr) {
                if ("30820295308201fea00302010202044b4ef1bf300d06092a864886f70d010105050030818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c74643020170d3130303131343130323831355a180f32303630303130323130323831355a30818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c746430819f300d06092a864886f70d010101050003818d00308189028181009d367115bc206c86c237bb56c8e9033111889b5691f051b28d1aa8e42b66b7413657635b44786ea7e85d451a12a82a331fced99c48717922170b7fc9bc1040753c0d38b4cf2b22094b1df7c55705b0989441e75913a1a8bd2bc591aa729a1013c277c01c98cbec7da5ad7778b2fad62b85ac29ca28ced588638c98d6b7df5a130203010001300d06092a864886f70d0101050500038181000ad4b4c4dec800bd8fd2991adfd70676fce8ba9692ae50475f60ec468d1b758a665e961a3aedbece9fd4d7ce9295cd83f5f19dc441a065689d9820faedbb7c4a4c4635f5ba1293f6da4b72ed32fb8795f736a20c95cda776402099054fccefb4a1a558664ab8d637288feceba9508aa907fc1fe2b1ae5a0dec954ed831c0bea4".equals(signature.toCharsString())) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: c */
    private void m19461c(Intent intent) {
        if (this.f1468c == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2);
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("error_type");
        }
        if (stringExtra == null) {
            this.f1468c.onComplete(intent.getExtras());
        } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
            this.f1468c.onCancel();
        } else {
            String stringExtra2 = intent.getStringExtra(XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2);
            if (stringExtra2 != null) {
                stringExtra = stringExtra + ": " + stringExtra2;
            }
            this.f1468c.onFailed(new Throwable(stringExtra));
        }
    }

    /* renamed from: d */
    private void m19460d(Intent intent) {
        if (intent == null) {
            if (this.f1468c == null) {
                return;
            }
            this.f1468c.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2);
        Throwable th = new Throwable(stringExtra + " (" + intent.getIntExtra("error_code", -1) + ")");
        if (this.f1468c == null) {
            return;
        }
        this.f1468c.onFailed(th);
    }

    @Override // cn.sharesdk.framework.authorize.AbstractC0641d
    /* renamed from: a */
    public void mo19466a() {
        Intent intent = new Intent();
        intent.setClassName("com.sina.weibo", "com.sina.weibo.business.RemoteSSOService");
        if (!this.f1466a.getContext().getApplicationContext().bindService(intent, this, 1)) {
            this.f1466a.finish();
            if (this.f1468c == null) {
                return;
            }
            this.f1468c.onFailed(new Throwable());
        }
    }

    @Override // cn.sharesdk.framework.authorize.AbstractC0641d
    /* renamed from: a */
    public void mo19465a(int i, int i2, Intent intent) {
        this.f1466a.finish();
        if (i == this.f1467b) {
            switch (i2) {
                case -1:
                    m19461c(intent);
                    return;
                case 0:
                    m19460d(intent);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void m19463a(String str, String str2, String[] strArr) {
        this.f1645d = str;
        this.f1646e = str2;
        this.f1647f = strArr;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            Class<?> cls = Class.forName("com.sina.sso.RemoteSSO$Stub");
            Method method = cls.getMethod("asInterface", IBinder.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, iBinder);
            Method method2 = cls.getMethod("getPackageName", new Class[0]);
            method2.setAccessible(true);
            String valueOf = String.valueOf(method2.invoke(invoke, new Object[0]));
            Method method3 = cls.getMethod("getActivityName", new Class[0]);
            method3.setAccessible(true);
            if (m19464a(valueOf, String.valueOf(method3.invoke(invoke, new Object[0])))) {
                return;
            }
            this.f1466a.finish();
            if (this.f1468c == null) {
                return;
            }
            this.f1468c.onFailed(new Throwable());
        } catch (Throwable th) {
            this.f1466a.finish();
            if (this.f1468c == null) {
                return;
            }
            this.f1468c.onFailed(th);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f1466a.finish();
        if (this.f1468c != null) {
            this.f1468c.onFailed(new Throwable());
        }
    }
}
