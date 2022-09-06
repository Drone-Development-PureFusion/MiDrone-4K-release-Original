package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class MessageHandleService extends IntentService {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<C4518a> f18606a = new ConcurrentLinkedQueue<>();

    /* renamed from: com.xiaomi.mipush.sdk.MessageHandleService$a */
    /* loaded from: classes.dex */
    public static class C4518a {

        /* renamed from: a */
        private PushMessageReceiver f18607a;

        /* renamed from: b */
        private Intent f18608b;

        public C4518a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f18607a = pushMessageReceiver;
            this.f18608b = intent;
        }

        /* renamed from: a */
        public PushMessageReceiver m4923a() {
            return this.f18607a;
        }

        /* renamed from: b */
        public Intent m4922b() {
            return this.f18608b;
        }
    }

    public MessageHandleService() {
        super("MessageHandleThread");
    }

    public static void addJob(C4518a c4518a) {
        if (c4518a != null) {
            f18606a.add(c4518a);
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        C4518a poll;
        if (intent == null || (poll = f18606a.poll()) == null) {
            return;
        }
        try {
            PushMessageReceiver m4923a = poll.m4923a();
            Intent m4922b = poll.m4922b();
            switch (m4922b.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1)) {
                case 1:
                    PushMessageHandler.AbstractC4519a m4827a = C4543s.m4830a(this).m4827a(m4922b);
                    if (m4827a == null) {
                        return;
                    }
                    if (!(m4827a instanceof MiPushMessage)) {
                        if (!(m4827a instanceof MiPushCommandMessage)) {
                            return;
                        }
                        MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) m4827a;
                        m4923a.onCommandResult(this, miPushCommandMessage);
                        if (!TextUtils.equals(miPushCommandMessage.getCommand(), MiPushClient.COMMAND_REGISTER)) {
                            return;
                        }
                        m4923a.onReceiveRegisterResult(this, miPushCommandMessage);
                        return;
                    }
                    MiPushMessage miPushMessage = (MiPushMessage) m4827a;
                    if (!miPushMessage.isArrivedMessage()) {
                        m4923a.onReceiveMessage(this, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        m4923a.onReceivePassThroughMessage(this, miPushMessage);
                        return;
                    } else if (miPushMessage.isNotified()) {
                        m4923a.onNotificationMessageClicked(this, miPushMessage);
                        return;
                    } else {
                        m4923a.onNotificationMessageArrived(this, miPushMessage);
                        return;
                    }
                case 2:
                default:
                    return;
                case 3:
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) m4922b.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    m4923a.onCommandResult(this, miPushCommandMessage2);
                    if (!TextUtils.equals(miPushCommandMessage2.getCommand(), MiPushClient.COMMAND_REGISTER)) {
                        return;
                    }
                    m4923a.onReceiveRegisterResult(this, miPushCommandMessage2);
                    return;
                case 4:
                    return;
            }
        } catch (RuntimeException e) {
            AbstractC4478b.m5039a(e);
        }
    }
}
