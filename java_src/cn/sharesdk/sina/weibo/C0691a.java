package cn.sharesdk.sina.weibo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.C0683d;
import com.fimi.soul.media.player.FimiMediaMeta;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.UIHandler;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.UUID;
import p004b.p005a.p006a.p028b.p051m.C0501h;
/* renamed from: cn.sharesdk.sina.weibo.a */
/* loaded from: classes.dex */
public class C0691a extends FakeActivity implements Handler.Callback {

    /* renamed from: a */
    private long f1635a = 2097152;

    /* renamed from: b */
    private boolean f1636b;

    /* renamed from: c */
    private String f1637c;

    /* renamed from: d */
    private Platform.ShareParams f1638d;

    /* renamed from: e */
    private AuthorizeListener f1639e;

    /* renamed from: a */
    private Bitmap m19485a(Bitmap bitmap, double d) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double sqrt = Math.sqrt(d);
        return Bitmap.createScaledBitmap(bitmap, (int) (width / sqrt), (int) (height / sqrt), true);
    }

    /* renamed from: a */
    private String m19486a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (int i = 0; i < packageInfo.signatures.length; i++) {
                byte[] byteArray = packageInfo.signatures[i].toByteArray();
                if (byteArray != null) {
                    return Data.MD5(byteArray);
                }
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m19490a() {
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_command_type", 1);
        bundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(this.f1638d.getText())) {
            bundle.putParcelable("_weibo_message_text", m19475e());
            bundle.putString("_weibo_message_text_extra", "");
        }
        if (!TextUtils.isEmpty(this.f1638d.getUrl())) {
            this.f1635a = FimiMediaMeta.AV_CH_TOP_BACK_LEFT;
            WebpageObject m19474f = m19474f();
            if (m19474f.checkArgs()) {
                bundle.putParcelable("_weibo_message_media", m19474f);
                String str = "";
                if (!TextUtils.isEmpty(m19474f.defaultText)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("extra_key_defaulttext", m19474f.defaultText);
                    str = new Hashon().fromHashMap(hashMap);
                }
                bundle.putString("_weibo_message_media_extra", str);
            }
        } else if (this.f1638d.getImageData() != null || !TextUtils.isEmpty(this.f1638d.getImagePath())) {
            this.f1635a = 2097152L;
            ImageObject m19473g = m19473g();
            if (m19473g.checkArgs()) {
                bundle.putParcelable("_weibo_message_image", m19473g);
                bundle.putString("_weibo_message_image_extra", "");
            }
        }
        try {
            m19488a(this.activity, C0699e.m19432a(this.activity).m19433a(), this.f1637c, bundle);
        } catch (Throwable th) {
            try {
                m19488a(this.activity, "com.sina.weibog3", this.f1637c, bundle);
            } catch (Throwable th2) {
                if (this.f1639e == null) {
                    return;
                }
                this.f1639e.onError(new Throwable(th2));
            }
        }
    }

    /* renamed from: a */
    private void m19489a(int i, String str) {
        switch (i) {
            case 0:
                if (this.f1639e != null) {
                    this.f1639e.onComplete(null);
                    break;
                }
                break;
            case 1:
                if (this.f1639e != null) {
                    this.f1639e.onCancel();
                    break;
                }
                break;
            case 2:
                if (this.f1639e != null) {
                    this.f1639e.onError(new Throwable(str));
                    break;
                }
                break;
        }
        finish();
    }

    /* renamed from: a */
    private boolean m19488a(Activity activity, String str, String str2, Bundle bundle) {
        if (activity == null || TextUtils.isEmpty("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY") || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0683d.m19513a().m5969e("launchWeiboActivity fail, invalid arguments", new Object[0]);
            return false;
        }
        String packageName = activity.getPackageName();
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
        intent.putExtra("_weibo_sdkVersion", "0031405000");
        intent.putExtra("_weibo_appPackage", packageName);
        intent.putExtra("_weibo_appKey", str2);
        intent.putExtra("_weibo_flag", 538116905);
        intent.putExtra("_weibo_sign", m19486a(activity, packageName));
        intent.putExtra("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            C0683d.m19513a().m5972d("launchWeiboActivity intent=" + intent + ", extra=" + intent.getExtras(), new Object[0]);
            activity.startActivityForResult(intent, 765);
            return true;
        } catch (ActivityNotFoundException e) {
            C0683d.m19513a().m5969e(e.getMessage(), new Object[0]);
            return false;
        }
    }

    /* renamed from: a */
    private byte[] m19487a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        }
        if (!bitmap.isRecycled()) {
            return m19479b(context, bitmap);
        }
        throw new RuntimeException("checkArgs fail, thumbData is recycled");
    }

    /* renamed from: b */
    private void m19480b() {
        UIHandler.sendEmptyMessageDelayed(1, 200L, this);
    }

    /* renamed from: b */
    private byte[] m19479b(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        }
        if (bitmap.isRecycled()) {
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > this.f1635a) {
            bitmap = m19485a(bitmap, length / this.f1635a);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
            byteArrayOutputStream2.flush();
            byteArrayOutputStream2.close();
            byteArray = byteArrayOutputStream2.toByteArray();
            length = byteArray.length;
        }
        return byteArray;
    }

    /* renamed from: b */
    private byte[] m19478b(Context context, String str) {
        if (!new File(str).exists()) {
            throw new FileNotFoundException();
        }
        return m19479b(context, BitmapHelper.getBitmap(str));
    }

    /* renamed from: c */
    private boolean m19477c() {
        Intent intent = new Intent();
        intent.setAction("com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER");
        String packageName = this.activity.getPackageName();
        intent.putExtra("_weibo_sdkVersion", "0031405000");
        intent.putExtra("_weibo_appPackage", packageName);
        intent.putExtra("_weibo_appKey", this.f1637c);
        intent.putExtra("_weibo_flag", 538116905);
        intent.putExtra("_weibo_sign", m19486a(this.activity, packageName));
        C0683d.m19513a().m5972d("intent=" + intent + ", extra=" + intent.getExtras(), new Object[0]);
        this.activity.sendBroadcast(intent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
        return true;
    }

    /* renamed from: d */
    private String m19476d() {
        return UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    /* renamed from: e */
    private TextObject m19475e() {
        TextObject textObject = new TextObject();
        textObject.text = this.f1638d.getText();
        return textObject;
    }

    /* renamed from: f */
    private WebpageObject m19474f() {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = m19476d();
        webpageObject.title = this.f1638d.getTitle();
        webpageObject.description = this.f1638d.getText();
        webpageObject.actionUrl = this.f1638d.getUrl();
        webpageObject.defaultText = this.f1638d.getText();
        try {
            if (this.f1638d.getImageData() != null) {
                webpageObject.thumbData = m19487a(this.activity, this.f1638d.getImageData());
            } else if (!TextUtils.isEmpty(this.f1638d.getImagePath())) {
                webpageObject.thumbData = m19478b(this.activity, this.f1638d.getImagePath());
            }
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            webpageObject.setThumbImage(null);
        }
        return webpageObject;
    }

    /* renamed from: g */
    private ImageObject m19473g() {
        ImageObject imageObject = new ImageObject();
        try {
            if (this.f1638d.getImageData() != null) {
                imageObject.imageData = m19487a(this.activity, this.f1638d.getImageData());
            } else if (!TextUtils.isEmpty(this.f1638d.getImagePath())) {
                DeviceHelper deviceHelper = DeviceHelper.getInstance(this.activity);
                if (deviceHelper.getSdcardState() && this.f1638d.getImagePath().startsWith(deviceHelper.getSdcardPath())) {
                    File file = new File(this.f1638d.getImagePath());
                    if (file.exists() && file.length() != 0 && file.length() < C0501h.f1123b) {
                        imageObject.imagePath = this.f1638d.getImagePath();
                    }
                }
                imageObject.imageData = m19478b(this.activity, this.f1638d.getImagePath());
            }
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
        return imageObject;
    }

    /* renamed from: a */
    public void m19484a(Platform.ShareParams shareParams) {
        this.f1638d = shareParams;
    }

    /* renamed from: a */
    public void m19483a(AuthorizeListener authorizeListener) {
        this.f1639e = authorizeListener;
    }

    /* renamed from: a */
    public void m19481a(String str) {
        this.f1637c = str;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            if (!this.f1636b && this.f1639e != null) {
                this.f1639e.onCancel();
            }
            finish();
            return false;
        }
        return false;
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        C0683d.m19513a().m5972d("sina activity requestCode = %s, resultCode = %s", Integer.valueOf(i), Integer.valueOf(i));
        m19480b();
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        try {
            Intent intent = new Intent();
            intent.setAction("com.sina.weibo.action.browser.share");
            startActivity(intent);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
        if (m19477c()) {
            UIHandler.sendEmptyMessageDelayed(1, 700L, new Handler.Callback() { // from class: cn.sharesdk.sina.weibo.a.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    C0691a.this.m19490a();
                    return true;
                }
            });
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onNewIntent(Intent intent) {
        this.f1636b = true;
        Bundle extras = intent.getExtras();
        C0683d.m19513a().m5966i("onNewIntent ==>>", extras.toString());
        String stringExtra = intent.getStringExtra("_weibo_appPackage");
        String stringExtra2 = intent.getStringExtra("_weibo_transaction");
        if (TextUtils.isEmpty(stringExtra)) {
            C0683d.m19513a().m5969e("handleWeiboResponse faild appPackage is null", new Object[0]);
            return;
        }
        C0683d.m19513a().m5972d("handleWeiboResponse getCallingPackage : " + this.activity.getCallingPackage(), new Object[0]);
        if (TextUtils.isEmpty(stringExtra2)) {
            C0683d.m19513a().m5969e("handleWeiboResponse faild intent _weibo_transaction is null", new Object[0]);
        } else if (C0699e.m19431a(this.activity, stringExtra) || stringExtra.equals(this.activity.getPackageName())) {
            m19489a(extras.getInt("_weibo_resp_errcode"), extras.getString("_weibo_resp_errstr"));
        } else {
            C0683d.m19513a().m5969e("handleWeiboResponse faild appPackage validateSign faild", new Object[0]);
        }
    }
}
