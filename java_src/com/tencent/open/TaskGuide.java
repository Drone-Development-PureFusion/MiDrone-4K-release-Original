package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.p223a.C4188a;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.p227mm.sdk.message.RMsgInfoDB;
import com.tencent.tauth.AuthActivity;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import it.p235a.p236a.AbstractC4863e;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TaskGuide extends BaseApi {

    /* renamed from: k */
    private static Drawable f17984k;

    /* renamed from: l */
    private static Drawable f17985l;

    /* renamed from: m */
    private static Drawable f17986m;

    /* renamed from: F */
    private Context f18005F;

    /* renamed from: I */
    private long f18008I;

    /* renamed from: J */
    private int f18009J;

    /* renamed from: K */
    private int f18010K;

    /* renamed from: c */
    IUiListener f18014c;

    /* renamed from: f */
    private WindowManager f18017f;

    /* renamed from: h */
    private C4310h f18019h;

    /* renamed from: n */
    private static int f17987n = 75;

    /* renamed from: o */
    private static int f17988o = 284;

    /* renamed from: p */
    private static int f17989p = 75;

    /* renamed from: q */
    private static int f17990q = 30;

    /* renamed from: r */
    private static int f17991r = 29;

    /* renamed from: s */
    private static int f17992s = 5;

    /* renamed from: t */
    private static int f17993t = 74;

    /* renamed from: u */
    private static int f17994u = 0;

    /* renamed from: v */
    private static int f17995v = 6;

    /* renamed from: w */
    private static int f17996w = 153;

    /* renamed from: x */
    private static int f17997x = 30;

    /* renamed from: y */
    private static int f17998y = 6;

    /* renamed from: z */
    private static int f17999z = 3;

    /* renamed from: b */
    static long f17983b = 5000;

    /* renamed from: L */
    private static int f17982L = 3000;

    /* renamed from: d */
    private WindowManager.LayoutParams f18015d = null;

    /* renamed from: e */
    private ViewGroup f18016e = null;

    /* renamed from: g */
    private Handler f18018g = new Handler(Looper.getMainLooper());

    /* renamed from: i */
    private EnumC4314k f18020i = EnumC4314k.INIT;

    /* renamed from: j */
    private EnumC4314k f18021j = EnumC4314k.INIT;

    /* renamed from: A */
    private int f18000A = 0;

    /* renamed from: B */
    private int f18001B = 0;

    /* renamed from: C */
    private float f18002C = 0.0f;

    /* renamed from: D */
    private Interpolator f18003D = new AccelerateInterpolator();

    /* renamed from: E */
    private boolean f18004E = false;

    /* renamed from: a */
    boolean f18013a = false;

    /* renamed from: G */
    private boolean f18006G = false;

    /* renamed from: H */
    private boolean f18007H = false;

    /* renamed from: M */
    private Runnable f18011M = null;

    /* renamed from: N */
    private Runnable f18012N = null;

    /* renamed from: com.tencent.open.TaskGuide$a */
    /* loaded from: classes2.dex */
    private abstract class AbstractC4302a implements IRequestListener {
        private AbstractC4302a() {
        }

        /* renamed from: a */
        protected abstract void mo5501a(Exception exc);

        @Override // com.tencent.tauth.IRequestListener
        public void onConnectTimeoutException(ConnectTimeoutException connectTimeoutException) {
            mo5501a(connectTimeoutException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            mo5501a(httpStatusException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            mo5501a(iOException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            mo5501a(jSONException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            mo5501a(malformedURLException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            mo5501a(networkUnavailableException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            mo5501a(socketTimeoutException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            mo5501a(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.TaskGuide$b */
    /* loaded from: classes2.dex */
    public class RunnableC4303b implements Runnable {
        private RunnableC4303b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TaskGuide.this.m5515l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.open.TaskGuide$c */
    /* loaded from: classes2.dex */
    public class RunnableC4304c implements Runnable {

        /* renamed from: a */
        boolean f18030a;

        /* renamed from: b */
        float f18031b = 0.0f;

        public RunnableC4304c(boolean z) {
            this.f18030a = false;
            this.f18030a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = true;
            SystemClock.currentThreadTimeMillis();
            this.f18031b = (float) (this.f18031b + 0.1d);
            float f = this.f18031b;
            if (f > 1.0f) {
                f = 1.0f;
            }
            boolean z2 = f >= 1.0f;
            int interpolation = (int) (TaskGuide.this.f18003D.getInterpolation(f) * TaskGuide.this.f18009J);
            if (this.f18030a) {
                TaskGuide.this.f18015d.y = TaskGuide.this.f18010K + interpolation;
            } else {
                TaskGuide.this.f18015d.y = TaskGuide.this.f18010K - interpolation;
            }
            C4331f.m5445b("TAG", "mWinParams.y = " + TaskGuide.this.f18015d.y + "deltaDistence = " + interpolation);
            if (TaskGuide.this.f18004E) {
                TaskGuide.this.f18017f.updateViewLayout(TaskGuide.this.f18016e, TaskGuide.this.f18015d);
                z = z2;
            }
            if (z) {
                TaskGuide.this.m5521i();
            } else {
                TaskGuide.this.f18018g.postDelayed(TaskGuide.this.f18011M, 5L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.TaskGuide$d */
    /* loaded from: classes2.dex */
    public class C4305d extends AbstractC4302a {

        /* renamed from: b */
        int f18033b;

        public C4305d(int i) {
            super();
            this.f18033b = -1;
            this.f18033b = i;
        }

        @Override // com.tencent.open.TaskGuide.AbstractC4302a
        /* renamed from: a */
        protected void mo5501a(final Exception exc) {
            if (exc != null) {
                exc.printStackTrace();
            }
            TaskGuide.this.f18014c.onError(new UiError(101, "error ", "金券领取时出现异常"));
            if (TaskGuide.this.f18018g != null) {
                TaskGuide.this.f18018g.post(new Runnable() { // from class: com.tencent.open.TaskGuide.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EnumC4314k enumC4314k = EnumC4314k.INIT;
                        if ((C4305d.this.f18033b == 0 ? TaskGuide.this.f18020i : TaskGuide.this.f18021j) == EnumC4314k.WAITTING_BACK_REWARD) {
                            TaskGuide.this.m5559a(C4305d.this.f18033b, EnumC4314k.NORAML);
                            TaskGuide.this.m5548a("领取失败 :" + exc.getClass().getName());
                        }
                        TaskGuide.this.m5544b(C4305d.this.f18033b);
                        TaskGuide.this.m5534d(2000);
                    }
                });
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            int i;
            String str = null;
            try {
                i = jSONObject.getInt(XiaomiOAuthConstants.EXTRA_CODE_2);
                str = jSONObject.getString(RMsgInfoDB.TABLE);
            } catch (JSONException e) {
                TaskGuide.this.m5559a(this.f18033b, EnumC4314k.NORAML);
                TaskGuide.this.m5548a(str);
                e.printStackTrace();
            }
            if (i == 0) {
                TaskGuide.this.m5559a(this.f18033b, EnumC4314k.REWARD_SUCCESS);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("result", "金券领取成功");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                TaskGuide.this.f18014c.onComplete(jSONObject2);
                TaskGuide.this.m5544b(this.f18033b);
                TaskGuide.this.m5534d(2000);
            }
            TaskGuide.this.m5559a(this.f18033b, EnumC4314k.NORAML);
            TaskGuide.this.m5548a(str);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("result", "金券领取失败");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            TaskGuide.this.f18014c.onComplete(jSONObject3);
            TaskGuide.this.m5544b(this.f18033b);
            TaskGuide.this.m5534d(2000);
            TaskGuide.this.m5559a(this.f18033b, EnumC4314k.NORAML);
            TaskGuide.this.m5548a(str);
            e.printStackTrace();
            TaskGuide.this.m5544b(this.f18033b);
            TaskGuide.this.m5534d(2000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.TaskGuide$e */
    /* loaded from: classes2.dex */
    public class C4307e extends RelativeLayout {

        /* renamed from: a */
        int f18037a = 0;

        public C4307e(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            int y = (int) motionEvent.getY();
            C4331f.m5445b("XXXX", "onInterceptTouchEvent-- action = " + motionEvent.getAction() + "currentY = " + y);
            TaskGuide.this.m5534d(3000);
            switch (motionEvent.getAction()) {
                case 0:
                    this.f18037a = y;
                    return false;
                case 1:
                    if (this.f18037a - y > ViewConfiguration.getTouchSlop() * 2) {
                        TaskGuide.this.m5515l();
                        return true;
                    }
                    break;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            int y = (int) motionEvent.getY();
            C4331f.m5445b("XXXX", " onTouchEvent-----startY = " + this.f18037a + "currentY = " + y);
            switch (motionEvent.getAction()) {
                case 0:
                    this.f18037a = y;
                    return false;
                case 1:
                    if (this.f18037a - y <= ViewConfiguration.getTouchSlop() * 2) {
                        return false;
                    }
                    TaskGuide.this.m5515l();
                    return false;
                case 2:
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.open.TaskGuide$f */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC4308f implements View.OnClickListener {

        /* renamed from: a */
        int f18039a;

        public View$OnClickListenerC4308f(int i) {
            this.f18039a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Button button = (Button) view;
            if (TaskGuide.this.m5538c(this.f18039a) == EnumC4314k.NORAML) {
                TaskGuide.this.m5530e(this.f18039a);
                TaskGuide.this.m5544b(this.f18039a);
            }
            TaskGuide.this.m5523h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.TaskGuide$g */
    /* loaded from: classes2.dex */
    public static class C4309g {

        /* renamed from: a */
        int f18041a;

        /* renamed from: b */
        String f18042b;

        /* renamed from: c */
        String f18043c;

        /* renamed from: d */
        long f18044d;

        /* renamed from: e */
        int f18045e;

        public C4309g(int i, String str, String str2, long j, int i2) {
            this.f18041a = i;
            this.f18042b = str;
            this.f18043c = str2;
            this.f18044d = j;
            this.f18045e = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.TaskGuide$h */
    /* loaded from: classes2.dex */
    public static class C4310h {

        /* renamed from: a */
        String f18046a;

        /* renamed from: b */
        String f18047b;

        /* renamed from: c */
        C4309g[] f18048c;

        private C4310h() {
        }

        /* renamed from: a */
        static C4310h m5504a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C4310h c4310h = new C4310h();
            JSONObject jSONObject2 = jSONObject.getJSONObject("task_info");
            c4310h.f18046a = jSONObject2.getString("task_id");
            c4310h.f18047b = jSONObject2.getString("task_desc");
            JSONArray jSONArray = jSONObject2.getJSONArray("step_info");
            int length = jSONArray.length();
            if (length > 0) {
                c4310h.f18048c = new C4309g[length];
            }
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                c4310h.f18048c[i] = new C4309g(jSONObject3.getInt("step_no"), jSONObject3.getString("step_desc"), jSONObject3.getString("step_gift"), jSONObject3.getLong("end_time"), jSONObject3.getInt("status"));
            }
            return c4310h;
        }

        /* renamed from: a */
        public boolean m5505a() {
            return !TextUtils.isEmpty(this.f18046a) && this.f18048c != null && this.f18048c.length > 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.TaskGuide$i */
    /* loaded from: classes2.dex */
    public class C4311i extends LinearLayout {

        /* renamed from: b */
        private TextView f18050b;

        /* renamed from: c */
        private Button f18051c;

        /* renamed from: d */
        private C4309g f18052d;

        public C4311i(Context context, C4309g c4309g) {
            super(context);
            this.f18052d = c4309g;
            setOrientation(0);
            m5503a();
        }

        /* renamed from: a */
        private void m5503a() {
            this.f18050b = new TextView(TaskGuide.this.f18005F);
            this.f18050b.setTextColor(Color.rgb(255, 255, 255));
            this.f18050b.setTextSize(15.0f);
            this.f18050b.setShadowLayer(1.0f, 1.0f, 1.0f, Color.rgb(242, (int) AbstractC4863e.f20813v, 199));
            this.f18050b.setGravity(3);
            this.f18050b.setEllipsize(TextUtils.TruncateAt.END);
            this.f18050b.setIncludeFontPadding(false);
            this.f18050b.setSingleLine(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.leftMargin = TaskGuide.this.m5560a(4);
            addView(this.f18050b, layoutParams);
            this.f18051c = new Button(TaskGuide.this.f18005F);
            this.f18051c.setPadding(0, 0, 0, 0);
            this.f18051c.setTextSize(16.0f);
            this.f18051c.setTextColor(Color.rgb(255, 255, 255));
            this.f18051c.setShadowLayer(1.0f, 1.0f, 1.0f, Color.rgb(242, (int) AbstractC4863e.f20813v, 199));
            this.f18051c.setIncludeFontPadding(false);
            this.f18051c.setOnClickListener(new View$OnClickListenerC4308f(this.f18052d.f18041a));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(TaskGuide.this.m5560a(TaskGuide.f17989p), TaskGuide.this.m5560a(TaskGuide.f17990q));
            layoutParams2.leftMargin = TaskGuide.this.m5560a(2);
            layoutParams2.rightMargin = TaskGuide.this.m5560a(8);
            addView(this.f18051c, layoutParams2);
        }

        /* renamed from: a */
        public void m5502a(EnumC4314k enumC4314k) {
            if (!TextUtils.isEmpty(this.f18052d.f18042b)) {
                this.f18050b.setText(this.f18052d.f18042b);
            }
            switch (enumC4314k) {
                case INIT:
                    this.f18051c.setEnabled(false);
                    return;
                case NORAML:
                    if (this.f18052d.f18045e == 1) {
                        this.f18051c.setText(this.f18052d.f18043c);
                        this.f18051c.setBackgroundDrawable(null);
                        this.f18051c.setTextColor(Color.rgb(255, 246, 0));
                        this.f18051c.setEnabled(false);
                        return;
                    } else if (this.f18052d.f18045e != 2) {
                        return;
                    } else {
                        this.f18051c.setText("领取奖励");
                        this.f18051c.setTextColor(Color.rgb(255, 255, 255));
                        this.f18051c.setBackgroundDrawable(TaskGuide.this.m5527f());
                        this.f18051c.setEnabled(true);
                        return;
                    }
                case WAITTING_BACK_REWARD:
                    this.f18051c.setText("领取中...");
                    this.f18051c.setEnabled(false);
                    return;
                case REWARD_SUCCESS:
                    this.f18051c.setText("已领取");
                    this.f18051c.setBackgroundDrawable(TaskGuide.this.m5525g());
                    this.f18051c.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.TaskGuide$j */
    /* loaded from: classes2.dex */
    public class C4312j extends AbstractC4302a {
        private C4312j() {
            super();
        }

        @Override // com.tencent.open.TaskGuide.AbstractC4302a
        /* renamed from: a */
        protected void mo5501a(Exception exc) {
            if (exc != null) {
                exc.printStackTrace();
            }
            if (exc == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", "暂无任务");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                TaskGuide.this.f18014c.onComplete(jSONObject);
            } else {
                TaskGuide.this.f18014c.onError(new UiError(100, "error ", "获取任务失败"));
            }
            TaskGuide.this.f18018g.post(new Runnable() { // from class: com.tencent.open.TaskGuide.j.1
                @Override // java.lang.Runnable
                public void run() {
                    TaskGuide.this.m5559a(2, EnumC4314k.INIT);
                }
            });
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            try {
                TaskGuide.this.f18019h = C4310h.m5504a(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (TaskGuide.this.f18019h == null || !TaskGuide.this.f18019h.m5505a()) {
                mo5501a(null);
                return;
            }
            TaskGuide.this.showWindow();
            TaskGuide.this.m5559a(2, EnumC4314k.NORAML);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", "获取成功");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            TaskGuide.this.f18014c.onComplete(jSONObject2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.TaskGuide$k */
    /* loaded from: classes2.dex */
    public enum EnumC4314k {
        INIT,
        WAITTING_BACK_TASKINFO,
        WAITTING_BACK_REWARD,
        NORAML,
        REWARD_SUCCESS,
        REWARD_FAIL
    }

    public TaskGuide(Context context, QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
        this.f18005F = context;
        this.f18017f = (WindowManager) context.getSystemService("window");
        m5539c();
    }

    public TaskGuide(Context context, QQToken qQToken) {
        super(qQToken);
        this.f18005F = context;
        this.f18017f = (WindowManager) context.getSystemService("window");
        m5539c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m5560a(int i) {
        return (int) (i * this.f18002C);
    }

    /* renamed from: a */
    private Drawable m5547a(String str, Context context) {
        Drawable drawable;
        IOException e;
        try {
            InputStream open = context.getApplicationContext().getAssets().open(str);
            if (open == null) {
                drawable = null;
            } else if (str.endsWith(".9.png")) {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                if (decodeStream != null) {
                    byte[] ninePatchChunk = decodeStream.getNinePatchChunk();
                    NinePatch.isNinePatchChunk(ninePatchChunk);
                    drawable = new NinePatchDrawable(decodeStream, ninePatchChunk, new Rect(), null);
                } else {
                    drawable = null;
                }
            } else {
                drawable = Drawable.createFromStream(open, str);
                try {
                    open.close();
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    return drawable;
                }
            }
        } catch (IOException e3) {
            drawable = null;
            e = e3;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public WindowManager.LayoutParams m5558a(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 49;
        this.f18017f.getDefaultDisplay().getWidth();
        this.f18017f.getDefaultDisplay().getHeight();
        layoutParams.width = m5560a(f17988o);
        layoutParams.height = m5560a(f17987n);
        layoutParams.windowAnimations = 16973826;
        layoutParams.format = 1;
        layoutParams.flags |= 520;
        layoutParams.type = 2;
        this.f18015d = layoutParams;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5559a(int i, EnumC4314k enumC4314k) {
        if (i == 0) {
            this.f18020i = enumC4314k;
        } else if (i == 1) {
            this.f18021j = enumC4314k;
        } else {
            this.f18020i = enumC4314k;
            this.f18021j = enumC4314k;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5548a(final String str) {
        this.f18018g.post(new Runnable() { // from class: com.tencent.open.TaskGuide.3
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(TaskGuide.this.f18005F, "失败：" + str, 1).show();
            }
        });
    }

    /* renamed from: a */
    private void m5546a(boolean z) {
        this.f18008I = SystemClock.currentThreadTimeMillis();
        if (z) {
            this.f18006G = true;
        } else {
            this.f18007H = true;
        }
        this.f18009J = this.f18015d.height;
        this.f18010K = this.f18015d.y;
        this.f18015d.flags |= 16;
        this.f18017f.updateViewLayout(this.f18016e, this.f18015d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public ViewGroup m5543b(Context context) {
        C4307e c4307e = new C4307e(context);
        C4309g[] c4309gArr = this.f18019h.f18048c;
        if (c4309gArr.length == 1) {
            C4311i c4311i = new C4311i(context, c4309gArr[0]);
            c4311i.setId(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(15);
            c4307e.addView(c4311i, layoutParams);
        } else {
            C4311i c4311i2 = new C4311i(context, c4309gArr[0]);
            c4311i2.setId(1);
            C4311i c4311i3 = new C4311i(context, c4309gArr[1]);
            c4311i3.setId(2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(14);
            layoutParams2.setMargins(0, m5560a(6), 0, 0);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(14);
            layoutParams3.setMargins(0, m5560a(4), 0, 0);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            c4307e.addView(c4311i2, layoutParams2);
            c4307e.addView(c4311i3, layoutParams3);
        }
        c4307e.setBackgroundDrawable(m5531e());
        return c4307e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5544b(final int i) {
        if (this.f18018g != null) {
            this.f18018g.post(new Runnable() { // from class: com.tencent.open.TaskGuide.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TaskGuide.this.f18004E) {
                        if (i == 0) {
                            ((C4311i) TaskGuide.this.f18016e.findViewById(1)).m5502a(TaskGuide.this.f18020i);
                        } else if (i == 1) {
                            ((C4311i) TaskGuide.this.f18016e.findViewById(2)).m5502a(TaskGuide.this.f18021j);
                        } else if (i != 2) {
                        } else {
                            ((C4311i) TaskGuide.this.f18016e.findViewById(1)).m5502a(TaskGuide.this.f18020i);
                            if (TaskGuide.this.f18016e.getChildCount() <= 1) {
                                return;
                            }
                            ((C4311i) TaskGuide.this.f18016e.findViewById(2)).m5502a(TaskGuide.this.f18021j);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public EnumC4314k m5538c(int i) {
        return i == 0 ? this.f18020i : i == 1 ? this.f18021j : EnumC4314k.INIT;
    }

    /* renamed from: c */
    private void m5539c() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f18017f.getDefaultDisplay().getMetrics(displayMetrics);
        this.f18000A = displayMetrics.widthPixels;
        this.f18001B = displayMetrics.heightPixels;
        this.f18002C = displayMetrics.density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5535d() {
        if (this.f18015d != null) {
            this.f18015d.y = -this.f18015d.height;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5534d(int i) {
        m5523h();
        this.f18012N = new RunnableC4303b();
        this.f18018g.postDelayed(this.f18012N, i);
    }

    /* renamed from: e */
    private Drawable m5531e() {
        if (f17984k == null) {
            f17984k = m5547a("background.9.png", this.f18005F);
        }
        return f17984k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5530e(int i) {
        Bundle composeCGIParams = composeCGIParams();
        composeCGIParams.putString(AuthActivity.ACTION_KEY, "get_gift");
        composeCGIParams.putString("task_id", this.f18019h.f18046a);
        composeCGIParams.putString("step_no", new Integer(i).toString());
        composeCGIParams.putString("appid", this.mToken.getAppId());
        HttpUtils.requestAsync(this.mToken, this.f18005F, "http://appact.qzone.qq.com/appstore_activity_task_pcpush_sdk", composeCGIParams, "GET", new C4305d(i));
        m5559a(i, EnumC4314k.WAITTING_BACK_REWARD);
        C4188a.m5956a(this.f18005F, this.mToken, "TaskApi", "getGift");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public Drawable m5527f() {
        if (f17985l == null) {
            f17985l = m5547a("button_green.9.png", this.f18005F);
        }
        return f17985l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public Drawable m5525g() {
        if (f17986m == null) {
            f17986m = m5547a("button_red.9.png", this.f18005F);
        }
        return f17986m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5523h() {
        this.f18018g.removeCallbacks(this.f18012N);
        if (!m5519j()) {
            this.f18018g.removeCallbacks(this.f18011M);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m5521i() {
        if (this.f18006G) {
            m5534d(3000);
        } else {
            removeWindow();
        }
        if (this.f18006G) {
            this.f18015d.flags &= -17;
            this.f18017f.updateViewLayout(this.f18016e, this.f18015d);
        }
        this.f18006G = false;
        this.f18007H = false;
    }

    /* renamed from: j */
    private boolean m5519j() {
        return this.f18006G || this.f18007H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m5517k() {
        if (!m5519j()) {
            this.f18018g.removeCallbacks(this.f18012N);
            this.f18018g.removeCallbacks(this.f18011M);
            this.f18011M = new RunnableC4304c(true);
            m5546a(true);
            this.f18018g.post(this.f18011M);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5515l() {
        if (!m5519j()) {
            this.f18018g.removeCallbacks(this.f18012N);
            this.f18018g.removeCallbacks(this.f18011M);
            this.f18011M = new RunnableC4304c(false);
            m5546a(false);
            this.f18018g.post(this.f18011M);
        }
    }

    public void removeWindow() {
        if (this.f18004E) {
            this.f18017f.removeView(this.f18016e);
            this.f18004E = false;
        }
    }

    public void showTaskGuideWindow(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Bundle composeCGIParams;
        this.f18005F = activity;
        this.f18014c = iUiListener;
        if (this.f18020i == EnumC4314k.WAITTING_BACK_TASKINFO || this.f18021j == EnumC4314k.WAITTING_BACK_TASKINFO || this.f18004E) {
            return;
        }
        this.f18019h = null;
        if (bundle != null) {
            composeCGIParams = new Bundle(bundle);
            composeCGIParams.putAll(composeCGIParams());
        } else {
            composeCGIParams = composeCGIParams();
        }
        C4312j c4312j = new C4312j();
        composeCGIParams.putString(AuthActivity.ACTION_KEY, "task_list");
        composeCGIParams.putString("auth", "mobile");
        composeCGIParams.putString("appid", this.mToken.getAppId());
        HttpUtils.requestAsync(this.mToken, this.f18005F, "http://appact.qzone.qq.com/appstore_activity_task_pcpush_sdk", composeCGIParams, "GET", c4312j);
        m5559a(2, EnumC4314k.WAITTING_BACK_TASKINFO);
    }

    @SuppressLint({"ResourceAsColor"})
    public void showWindow() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TaskGuide.2
            @Override // java.lang.Runnable
            public void run() {
                TaskGuide.this.f18016e = TaskGuide.this.m5543b(TaskGuide.this.f18005F);
                TaskGuide.this.f18015d = TaskGuide.this.m5558a(TaskGuide.this.f18005F);
                TaskGuide.this.m5535d();
                WindowManager windowManager = (WindowManager) TaskGuide.this.f18005F.getSystemService("window");
                if (((Activity) TaskGuide.this.f18005F).isFinishing()) {
                    return;
                }
                if (!TaskGuide.this.f18004E) {
                    windowManager.addView(TaskGuide.this.f18016e, TaskGuide.this.f18015d);
                }
                TaskGuide.this.f18004E = true;
                TaskGuide.this.m5544b(2);
                TaskGuide.this.m5517k();
            }
        });
        C4188a.m5956a(this.f18005F, this.mToken, "TaskApi", "showTaskWindow");
    }
}
