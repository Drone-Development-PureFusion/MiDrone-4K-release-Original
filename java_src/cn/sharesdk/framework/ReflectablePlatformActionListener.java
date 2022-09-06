package cn.sharesdk.framework;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ReflectablePlatformActionListener implements PlatformActionListener {

    /* renamed from: a */
    private int f1429a;

    /* renamed from: b */
    private Handler.Callback f1430b;

    /* renamed from: c */
    private int f1431c;

    /* renamed from: d */
    private Handler.Callback f1432d;

    /* renamed from: e */
    private int f1433e;

    /* renamed from: f */
    private Handler.Callback f1434f;

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i) {
        if (this.f1434f != null) {
            Message message = new Message();
            message.what = this.f1433e;
            message.obj = new Object[]{platform, Integer.valueOf(i)};
            UIHandler.sendMessage(message, this.f1434f);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if (this.f1430b != null) {
            Message message = new Message();
            message.what = this.f1429a;
            message.obj = new Object[]{platform, Integer.valueOf(i), hashMap};
            UIHandler.sendMessage(message, this.f1430b);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i, Throwable th) {
        if (this.f1432d != null) {
            Message message = new Message();
            message.what = this.f1431c;
            message.obj = new Object[]{platform, Integer.valueOf(i), th};
            UIHandler.sendMessage(message, this.f1432d);
        }
    }

    public void setOnCancelCallback(int i, Handler.Callback callback) {
        this.f1433e = i;
        this.f1434f = callback;
    }

    public void setOnCompleteCallback(int i, Handler.Callback callback) {
        this.f1429a = i;
        this.f1430b = callback;
    }

    public void setOnErrorCallback(int i, Handler.Callback callback) {
        this.f1431c = i;
        this.f1432d = callback;
    }
}
