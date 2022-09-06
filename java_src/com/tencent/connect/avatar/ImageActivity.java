package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.p001v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tencent.open.p229b.C4340d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.Util;
import com.tencent.p227mm.sdk.contact.RContact;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageActivity extends Activity {

    /* renamed from: a */
    RelativeLayout f17423a;

    /* renamed from: b */
    private QQToken f17424b;

    /* renamed from: c */
    private String f17425c;

    /* renamed from: d */
    private Handler f17426d;

    /* renamed from: e */
    private C4210c f17427e;

    /* renamed from: f */
    private Button f17428f;

    /* renamed from: g */
    private Button f17429g;

    /* renamed from: h */
    private C4209b f17430h;

    /* renamed from: i */
    private TextView f17431i;

    /* renamed from: j */
    private ProgressBar f17432j;

    /* renamed from: r */
    private String f17440r;

    /* renamed from: s */
    private Bitmap f17441s;

    /* renamed from: k */
    private int f17433k = 0;

    /* renamed from: l */
    private boolean f17434l = false;

    /* renamed from: m */
    private long f17435m = 0;

    /* renamed from: n */
    private int f17436n = 0;

    /* renamed from: o */
    private final int f17437o = 640;

    /* renamed from: p */
    private final int f17438p = 640;

    /* renamed from: q */
    private Rect f17439q = new Rect();

    /* renamed from: t */
    private final View.OnClickListener f17442t = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.f17432j.setVisibility(0);
            ImageActivity.this.f17429g.setEnabled(false);
            ImageActivity.this.f17429g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f17428f.setEnabled(false);
            ImageActivity.this.f17428f.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageActivity.this.m5882c();
                }
            }).start();
            if (ImageActivity.this.f17434l) {
                ImageActivity.this.m5889a("10657", 0L);
                return;
            }
            ImageActivity.this.m5889a("10655", System.currentTimeMillis() - ImageActivity.this.f17435m);
            if (!ImageActivity.this.f17427e.f17463b) {
                return;
            }
            ImageActivity.this.m5889a("10654", 0L);
        }
    };

    /* renamed from: u */
    private final View.OnClickListener f17443u = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.m5889a("10656", System.currentTimeMillis() - ImageActivity.this.f17435m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.m5879d();
        }
    };

    /* renamed from: v */
    private final IUiListener f17444v = new IUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.5
        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            int i;
            ImageActivity.this.f17429g.setEnabled(true);
            ImageActivity.this.f17429g.setTextColor(-1);
            ImageActivity.this.f17428f.setEnabled(true);
            ImageActivity.this.f17428f.setTextColor(-1);
            ImageActivity.this.f17432j.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i = jSONObject.getInt("ret");
            } catch (JSONException e) {
                e.printStackTrace();
                i = -1;
            }
            if (i != 0) {
                ImageActivity.this.m5890a("设置出错了，请重新登录再尝试下呢：）", 1);
                C4340d.m5413a().m5411a(ImageActivity.this.f17424b.getOpenId(), ImageActivity.this.f17424b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", Constants.VIA_ACT_TYPE_NINETEEN, "1");
                return;
            }
            ImageActivity.this.m5890a("设置成功", 0);
            ImageActivity.this.m5889a("10658", 0L);
            C4340d.m5413a().m5411a(ImageActivity.this.f17424b.getOpenId(), ImageActivity.this.f17424b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", "3", "0");
            ImageActivity imageActivity = ImageActivity.this;
            if (ImageActivity.this.f17425c != null && !"".equals(ImageActivity.this.f17425c)) {
                Intent intent = new Intent();
                intent.setClassName(imageActivity, ImageActivity.this.f17425c);
                if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                    imageActivity.startActivity(intent);
                }
            }
            ImageActivity.this.m5899a(0, jSONObject.toString(), null, null);
            ImageActivity.this.m5879d();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.f17429g.setEnabled(true);
            ImageActivity.this.f17429g.setTextColor(-1);
            ImageActivity.this.f17428f.setEnabled(true);
            ImageActivity.this.f17428f.setTextColor(-1);
            ImageActivity.this.f17428f.setText("重试");
            ImageActivity.this.f17432j.setVisibility(8);
            ImageActivity.this.f17434l = true;
            ImageActivity.this.m5890a(uiError.errorMessage, 1);
            ImageActivity.this.m5889a("10660", 0L);
        }
    };

    /* renamed from: w */
    private final IUiListener f17445w = new IUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.6
        /* renamed from: a */
        private void m5864a(int i) {
            if (ImageActivity.this.f17433k < 2) {
                ImageActivity.this.m5876e();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i = -1;
            try {
                i = jSONObject.getInt("ret");
                if (i == 0) {
                    final String string = jSONObject.getString(RContact.COL_NICKNAME);
                    ImageActivity.this.f17426d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageActivity.this.m5880c(string);
                        }
                    });
                    ImageActivity.this.m5889a("10659", 0L);
                } else {
                    ImageActivity.this.m5889a("10661", 0L);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i != 0) {
                m5864a(i);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            m5864a(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class QQAvatarImp extends BaseApi {
        public QQAvatarImp(QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Bundle composeCGIParams = composeCGIParams();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            composeCGIParams.putByteArray(SocialConstants.PARAM_AVATAR_URI, byteArray);
            HttpUtils.requestAsync(this.mToken, Global.getContext(), "user/set_user_face", composeCGIParams, "POST", tempRequestListener);
            C4340d.m5413a().m5411a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.connect.avatar.ImageActivity$a */
    /* loaded from: classes.dex */
    public class C4207a extends View {
        public C4207a(Context context) {
            super(context);
        }

        /* renamed from: a */
        public void m5863a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable m5884b = ImageActivity.this.m5884b("com.tencent.plus.blue_normal.png");
            Drawable m5884b2 = ImageActivity.this.m5884b("com.tencent.plus.blue_down.png");
            Drawable m5884b3 = ImageActivity.this.m5884b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, m5884b2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, m5884b);
            stateListDrawable.addState(View.ENABLED_STATE_SET, m5884b);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, m5884b);
            stateListDrawable.addState(View.EMPTY_STATE_SET, m5884b3);
            button.setBackgroundDrawable(stateListDrawable);
        }

        /* renamed from: b */
        public void m5862b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable m5884b = ImageActivity.this.m5884b("com.tencent.plus.gray_normal.png");
            Drawable m5884b2 = ImageActivity.this.m5884b("com.tencent.plus.gray_down.png");
            Drawable m5884b3 = ImageActivity.this.m5884b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, m5884b2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, m5884b);
            stateListDrawable.addState(View.ENABLED_STATE_SET, m5884b);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, m5884b);
            stateListDrawable.addState(View.EMPTY_STATE_SET, m5884b3);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    /* renamed from: a */
    private Bitmap m5891a(String str) {
        int i = 1;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        BitmapFactory.decodeStream(openInputStream, null, options);
        openInputStream.close();
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        while (i2 * i3 > 4194304) {
            i2 /= 2;
            i3 /= 2;
            i *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
    }

    /* renamed from: a */
    private View m5900a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        this.f17423a = new RelativeLayout(this);
        this.f17423a.setLayoutParams(layoutParams);
        this.f17423a.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams3);
        this.f17423a.addView(relativeLayout);
        this.f17427e = new C4210c(this);
        this.f17427e.setLayoutParams(layoutParams2);
        this.f17427e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout.addView(this.f17427e);
        this.f17430h = new C4209b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f17430h.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.f17430h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, C4208a.m5858a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f17423a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(C4208a.m5858a(this, 24.0f), C4208a.m5858a(this, 24.0f)));
        imageView.setImageDrawable(m5884b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f17431i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = C4208a.m5858a(this, 7.0f);
        this.f17431i.setLayoutParams(layoutParams6);
        this.f17431i.setEllipsize(TextUtils.TruncateAt.END);
        this.f17431i.setSingleLine();
        this.f17431i.setTextColor(-1);
        this.f17431i.setTextSize(24.0f);
        this.f17431i.setVisibility(8);
        linearLayout.addView(this.f17431i);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, C4208a.m5858a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout2.setLayoutParams(layoutParams7);
        relativeLayout2.setBackgroundDrawable(m5884b("com.tencent.plus.bar.png"));
        int m5858a = C4208a.m5858a(this, 10.0f);
        relativeLayout2.setPadding(m5858a, m5858a, m5858a, 0);
        this.f17423a.addView(relativeLayout2);
        C4207a c4207a = new C4207a(this);
        int m5858a2 = C4208a.m5858a(this, 14.0f);
        int m5858a3 = C4208a.m5858a(this, 7.0f);
        this.f17429g = new Button(this);
        this.f17429g.setLayoutParams(new RelativeLayout.LayoutParams(C4208a.m5858a(this, 78.0f), C4208a.m5858a(this, 45.0f)));
        this.f17429g.setText("取消");
        this.f17429g.setTextColor(-1);
        this.f17429g.setTextSize(18.0f);
        this.f17429g.setPadding(m5858a2, m5858a3, m5858a2, m5858a3);
        c4207a.m5862b(this.f17429g);
        relativeLayout2.addView(this.f17429g);
        this.f17428f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(C4208a.m5858a(this, 78.0f), C4208a.m5858a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f17428f.setLayoutParams(layoutParams8);
        this.f17428f.setTextColor(-1);
        this.f17428f.setTextSize(18.0f);
        this.f17428f.setPadding(m5858a2, m5858a3, m5858a2, m5858a3);
        this.f17428f.setText("选取");
        c4207a.m5863a(this.f17428f);
        relativeLayout2.addView(this.f17428f);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, C4208a.m5858a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout2.addView(textView);
        this.f17432j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f17432j.setLayoutParams(layoutParams10);
        this.f17432j.setVisibility(8);
        this.f17423a.addView(this.f17432j);
        return this.f17423a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5899a(int i, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_ERROR_CODE, i);
        intent.putExtra(Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    /* renamed from: a */
    private void m5898a(Bitmap bitmap) {
        new QQAvatarImp(this.f17424b).setAvator(bitmap, this.f17444v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5890a(final String str, final int i) {
        this.f17426d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.m5883b(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Drawable m5884b(String str) {
        Drawable drawable;
        IOException e;
        try {
            InputStream open = getAssets().open(str);
            drawable = Drawable.createFromStream(open, str);
            try {
                open.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return drawable;
            }
        } catch (IOException e3) {
            drawable = null;
            e = e3;
        }
        return drawable;
    }

    /* renamed from: b */
    private void m5888b() {
        try {
            this.f17441s = m5891a(this.f17440r);
        } catch (IOException e) {
            e.printStackTrace();
            m5883b(Constants.MSG_IMAGE_ERROR, 1);
            m5899a(-5, null, Constants.MSG_IMAGE_ERROR, e.getMessage());
            m5879d();
        }
        if (this.f17441s == null) {
            throw new IOException("cannot read picture: '" + this.f17440r + "'!");
        }
        this.f17427e.setImageBitmap(this.f17441s);
        this.f17428f.setOnClickListener(this.f17442t);
        this.f17429g.setOnClickListener(this.f17443u);
        this.f17423a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.connect.avatar.ImageActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ImageActivity.this.f17423a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ImageActivity.this.f17439q = ImageActivity.this.f17430h.m5857a();
                ImageActivity.this.f17427e.m5853a(ImageActivity.this.f17439q);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5883b(String str, int i) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(C4208a.m5858a(this, 16.0f), C4208a.m5858a(this, 16.0f)));
        if (i == 0) {
            imageView.setImageDrawable(m5884b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(m5884b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5882c() {
        Matrix imageMatrix = this.f17427e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = 640.0f / this.f17439q.width();
        int i = (int) ((this.f17439q.left - f) / f3);
        int i2 = (int) ((this.f17439q.top - f2) / f3);
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(width, width);
        int i3 = (int) (650.0f / f3);
        Bitmap createBitmap = Bitmap.createBitmap(this.f17441s, i, i2, Math.min(this.f17441s.getWidth() - i, i3), Math.min(this.f17441s.getHeight() - i2, i3), matrix, true);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, 640, 640);
        createBitmap.recycle();
        m5898a(createBitmap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5880c(String str) {
        String m5877d = m5877d(str);
        if (!"".equals(m5877d)) {
            this.f17431i.setText(m5877d);
            this.f17431i.setVisibility(0);
        }
    }

    /* renamed from: d */
    private String m5877d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5879d() {
        finish();
        if (this.f17436n != 0) {
            overridePendingTransition(0, this.f17436n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5876e() {
        this.f17433k++;
        new UserInfo(this, this.f17424b).getUserInfo(this.f17445w);
    }

    /* renamed from: a */
    public void m5889a(String str, long j) {
        Util.reportBernoulli(this, str, j, this.f17424b.getAppId());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        m5879d();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setRequestedOrientation(1);
        setContentView(m5900a());
        this.f17426d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(Constants.KEY_PARAMS);
        this.f17440r = bundleExtra.getString(SocialConstants.PARAM_AVATAR_URI);
        this.f17425c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.f17436n = bundleExtra.getInt("exitAnim");
        this.f17424b = new QQToken(string);
        this.f17424b.setAccessToken(string2, ((j - System.currentTimeMillis()) / 1000) + "");
        this.f17424b.setOpenId(string3);
        m5888b();
        m5876e();
        this.f17435m = System.currentTimeMillis();
        m5889a("10653", 0L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f17427e.setImageBitmap(null);
        if (this.f17441s == null || this.f17441s.isRecycled()) {
            return;
        }
        this.f17441s.recycle();
    }
}
