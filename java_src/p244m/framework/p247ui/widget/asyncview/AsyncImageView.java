package p244m.framework.p247ui.widget.asyncview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.fimi.kernel.C2172a;
import java.util.Random;
import p244m.framework.p246b.C4953e;
import p244m.framework.p246b.C4955f;
/* renamed from: m.framework.ui.widget.asyncview.AsyncImageView */
/* loaded from: classes2.dex */
public class AsyncImageView extends ImageView implements Handler.Callback, AbstractC4956a, AbstractC4957b {

    /* renamed from: a */
    public static final int f21295a = 17170445;

    /* renamed from: b */
    private static Bitmap f21296b = null;

    /* renamed from: c */
    private static final int f21297c = 1;

    /* renamed from: d */
    private static final Random f21298d = new Random();

    /* renamed from: e */
    private static String f21299e;

    /* renamed from: f */
    private String f21300f;

    /* renamed from: g */
    private int f21301g;

    /* renamed from: h */
    private AbstractC4965d f21302h;

    public AsyncImageView(Context context) {
        super(context);
        m2476a(context);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2476a(context);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2476a(context);
    }

    /* renamed from: a */
    private Bitmap m2477a(int i) {
        switch (i) {
            case f21295a /* 17170445 */:
                if (f21296b == null) {
                    f21296b = BitmapFactory.decodeResource(getResources(), f21295a);
                }
                return f21296b;
            default:
                return BitmapFactory.decodeResource(getResources(), i);
        }
    }

    /* renamed from: a */
    private void m2476a(Context context) {
        C4953e.m2500a();
        if (TextUtils.isEmpty(f21299e)) {
            f21299e = C4955f.m2486a(getContext(), C2172a.f7286b);
        }
        C4958c.m2471a(f21299e);
        setOnImageGotListener(C4966e.f21330a);
    }

    /* renamed from: a */
    public void m2475a(String str) {
        mo2474a(str, 0);
    }

    @Override // p244m.framework.p247ui.widget.asyncview.AbstractC4956a
    /* renamed from: a */
    public void mo2474a(String str, int i) {
        this.f21300f = str;
        this.f21301g = i;
        if (C4955f.m2482a(str)) {
            setImageResource(i);
            return;
        }
        Bitmap m2467b = C4958c.m2467b(str);
        if (m2467b != null && !m2467b.isRecycled()) {
            setImageBitmap(m2467b);
            return;
        }
        if (i > 0) {
            setImageBitmap(m2477a(i));
        }
        C4958c.m2470a(str, this);
    }

    @Override // p244m.framework.p247ui.widget.asyncview.AbstractC4957b
    /* renamed from: a */
    public void mo2473a(String str, Bitmap bitmap) {
        if (this.f21302h != null) {
            bitmap = this.f21302h.mo2441a(this, bitmap, str);
        }
        Message message = new Message();
        message.what = 1;
        message.obj = new Object[]{str, bitmap};
        C4953e.m2496a(message, f21298d.nextInt(300), this);
    }

    @Override // p244m.framework.p247ui.widget.asyncview.AbstractC4956a
    public String getUrl() {
        return this.f21300f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            Object obj = ((Object[]) message.obj)[0];
            Object obj2 = ((Object[]) message.obj)[1];
            if (obj2 == null || obj == null || !obj.equals(this.f21300f)) {
                setImageResource(this.f21301g);
            } else {
                setImageBitmap((Bitmap) obj2);
            }
        }
        return false;
    }

    public void setOnImageGotListener(AbstractC4965d abstractC4965d) {
        this.f21302h = abstractC4965d;
    }
}
