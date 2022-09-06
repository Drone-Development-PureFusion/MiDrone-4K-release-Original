package com.mining.app.zxing.p222b;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import com.fimi.soul.C2300R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.mining.app.zxing.activity.MipcaActivityCapture;
import com.mining.app.zxing.p221a.C4103c;
import com.mining.app.zxing.view.C4124a;
import java.util.Vector;
/* renamed from: com.mining.app.zxing.b.a */
/* loaded from: classes.dex */
public final class HandlerC4109a extends Handler {

    /* renamed from: a */
    private static final String f17184a = HandlerC4109a.class.getSimpleName();

    /* renamed from: b */
    private final MipcaActivityCapture f17185b;

    /* renamed from: c */
    private final C4113d f17186c;

    /* renamed from: d */
    private EnumC4110a f17187d = EnumC4110a.SUCCESS;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mining.app.zxing.b.a$a */
    /* loaded from: classes.dex */
    public enum EnumC4110a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public HandlerC4109a(MipcaActivityCapture mipcaActivityCapture, Vector<BarcodeFormat> vector, String str) {
        this.f17185b = mipcaActivityCapture;
        this.f17186c = new C4113d(mipcaActivityCapture, vector, str, new C4124a(mipcaActivityCapture.m6162a()));
        this.f17186c.start();
        C4103c.m6188a().m6179c();
        m6156b();
    }

    /* renamed from: b */
    private void m6156b() {
        if (this.f17187d == EnumC4110a.SUCCESS) {
            this.f17187d = EnumC4110a.PREVIEW;
            C4103c.m6188a().m6185a(this.f17186c.m6151a(), C2300R.C2302id.decode);
            C4103c.m6188a().m6180b(this, C2300R.C2302id.auto_focus);
            this.f17185b.m6158c();
        }
    }

    /* renamed from: a */
    public void m6157a() {
        this.f17187d = EnumC4110a.DONE;
        C4103c.m6188a().m6178d();
        Message.obtain(this.f17186c.m6151a(), (int) C2300R.C2302id.quit).sendToTarget();
        try {
            this.f17186c.join();
        } catch (InterruptedException e) {
        }
        removeMessages(C2300R.C2302id.decode_succeeded);
        removeMessages(C2300R.C2302id.decode_failed);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case C2300R.C2302id.auto_focus /* 2131492868 */:
                if (this.f17187d != EnumC4110a.PREVIEW) {
                    return;
                }
                C4103c.m6188a().m6180b(this, C2300R.C2302id.auto_focus);
                return;
            case C2300R.C2302id.decode /* 2131492869 */:
            case C2300R.C2302id.encode_failed /* 2131492872 */:
            case C2300R.C2302id.encode_succeeded /* 2131492873 */:
            case C2300R.C2302id.quit /* 2131492875 */:
            default:
                return;
            case C2300R.C2302id.decode_failed /* 2131492870 */:
                this.f17187d = EnumC4110a.PREVIEW;
                C4103c.m6188a().m6185a(this.f17186c.m6151a(), C2300R.C2302id.decode);
                return;
            case C2300R.C2302id.decode_succeeded /* 2131492871 */:
                Log.d(f17184a, "Got decode succeeded message");
                this.f17187d = EnumC4110a.SUCCESS;
                Bundle data = message.getData();
                this.f17185b.m6160a((Result) message.obj, data == null ? null : (Bitmap) data.getParcelable(C4113d.f17200a));
                return;
            case C2300R.C2302id.launch_product_query /* 2131492874 */:
                Log.d(f17184a, "Got product query message");
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String) message.obj));
                intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
                this.f17185b.startActivity(intent);
                return;
            case C2300R.C2302id.restart_preview /* 2131492876 */:
                Log.d(f17184a, "Got restart preview message");
                m6156b();
                return;
            case C2300R.C2302id.return_scan_result /* 2131492877 */:
                Log.d(f17184a, "Got return scan result message");
                this.f17185b.setResult(-1, (Intent) message.obj);
                this.f17185b.finish();
                return;
        }
    }
}
