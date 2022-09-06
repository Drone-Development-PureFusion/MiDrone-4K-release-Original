package p244m.framework.p246b;

import android.os.Handler;
import android.os.Message;
/* renamed from: m.framework.b.e */
/* loaded from: classes2.dex */
public class C4953e {

    /* renamed from: a */
    private static Handler f21293a;

    /* renamed from: a */
    public static void m2500a() {
        if (f21293a == null) {
            f21293a = new Handler(new Handler.Callback() { // from class: m.framework.b.e.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    C4953e.m2492b(message);
                    return false;
                }
            });
        }
    }

    /* renamed from: a */
    public static boolean m2499a(int i, long j, Handler.Callback callback) {
        return f21293a.sendMessageAtTime(m2493b(i, callback), j);
    }

    /* renamed from: a */
    public static boolean m2498a(int i, Handler.Callback callback) {
        return f21293a.sendMessage(m2493b(i, callback));
    }

    /* renamed from: a */
    public static boolean m2496a(Message message, long j, Handler.Callback callback) {
        return f21293a.sendMessageDelayed(m2489c(message, callback), j);
    }

    /* renamed from: a */
    public static boolean m2495a(Message message, Handler.Callback callback) {
        return f21293a.sendMessage(m2489c(message, callback));
    }

    /* renamed from: b */
    private static Message m2493b(int i, Handler.Callback callback) {
        Message message = new Message();
        message.what = i;
        return m2489c(message, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m2492b(Message message) {
        Object[] objArr = (Object[]) message.obj;
        Message message2 = (Message) objArr[0];
        Handler.Callback callback = (Handler.Callback) objArr[1];
        if (callback != null) {
            callback.handleMessage(message2);
        }
    }

    /* renamed from: b */
    public static boolean m2494b(int i, long j, Handler.Callback callback) {
        return f21293a.sendMessageDelayed(m2493b(i, callback), j);
    }

    /* renamed from: b */
    public static boolean m2491b(Message message, long j, Handler.Callback callback) {
        return f21293a.sendMessageAtTime(m2489c(message, callback), j);
    }

    /* renamed from: b */
    public static boolean m2490b(Message message, Handler.Callback callback) {
        return f21293a.sendMessageAtFrontOfQueue(m2489c(message, callback));
    }

    /* renamed from: c */
    private static Message m2489c(Message message, Handler.Callback callback) {
        Message message2 = new Message();
        message2.obj = new Object[]{message, callback};
        return message2;
    }
}
