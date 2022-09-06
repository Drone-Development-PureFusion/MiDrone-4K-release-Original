package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3678g;
/* loaded from: classes.dex */
public class RemotesimulatorView extends View {

    /* renamed from: a */
    private Bitmap f15471a;

    /* renamed from: b */
    private Bitmap f15472b;

    /* renamed from: c */
    private Bitmap f15473c;

    /* renamed from: d */
    private float f15474d;

    /* renamed from: e */
    private float f15475e;

    /* renamed from: f */
    private float f15476f;

    /* renamed from: g */
    private float f15477g;

    /* renamed from: h */
    private float f15478h;

    /* renamed from: i */
    private float f15479i;

    /* renamed from: j */
    private float f15480j;

    /* renamed from: k */
    private int f15481k;

    /* renamed from: l */
    private RectF f15482l;

    /* renamed from: m */
    private int f15483m;

    /* renamed from: n */
    private int f15484n;

    /* renamed from: o */
    private float f15485o;

    /* renamed from: p */
    private float f15486p;

    /* renamed from: q */
    private int f15487q;

    /* renamed from: r */
    private Context f15488r;

    /* renamed from: s */
    private int[] f15489s;

    /* renamed from: t */
    private Paint f15490t;

    /* renamed from: u */
    private int f15491u;

    /* renamed from: v */
    private int f15492v;

    public RemotesimulatorView(Context context) {
        super(context);
        this.f15481k = 512;
        this.f15487q = 8;
        this.f15489s = new int[]{Color.parseColor("#00FE5400"), Color.parseColor("#FE5400")};
    }

    public RemotesimulatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15481k = 512;
        this.f15487q = 8;
        this.f15489s = new int[]{Color.parseColor("#00FE5400"), Color.parseColor("#FE5400")};
        this.f15488r = context;
        this.f15471a = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.img_playback_rc_bg);
        this.f15472b = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.img_playback_rc_scale);
        this.f15473c = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.img_palyback_rc_focus);
        this.f15487q = C3678g.m7487a(context, this.f15487q);
        this.f15474d = this.f15487q;
        this.f15477g = (this.f15474d + (this.f15472b.getWidth() / 2)) - (this.f15473c.getWidth() / 2);
        this.f15475e = (this.f15471a.getHeight() / 2) - (this.f15472b.getWidth() / 2);
        this.f15476f = (this.f15471a.getWidth() - this.f15472b.getWidth()) - this.f15474d;
        this.f15479i = (this.f15471a.getHeight() / 2) - (this.f15473c.getWidth() / 2);
        this.f15478h = ((this.f15471a.getWidth() - (this.f15472b.getWidth() / 2)) - this.f15474d) - (this.f15473c.getWidth() / 2);
        this.f15490t = new Paint();
        this.f15490t.setAntiAlias(true);
        this.f15490t.setColor(-1);
    }

    public RemotesimulatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15481k = 512;
        this.f15487q = 8;
        this.f15489s = new int[]{Color.parseColor("#00FE5400"), Color.parseColor("#FE5400")};
    }

    /* renamed from: a */
    public static double m7260a(float f, float f2, int i, int i2) {
        int abs = Math.abs((int) (f - i));
        int abs2 = Math.abs((int) (f2 - i2));
        return Math.round((float) ((Math.acos(abs2 / Math.sqrt((abs * abs) + (abs2 * abs2))) / 3.141592653589793d) * 180.0d));
    }

    /* renamed from: a */
    private void m7258a(Bitmap... bitmapArr) {
        for (Bitmap bitmap : bitmapArr) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    /* renamed from: a */
    public void m7259a(int i, int i2, int i3, int i4) {
        int sqrt;
        int sqrt2;
        double d = 0.0d;
        if (i2 <= this.f15481k && i4 >= this.f15481k) {
            sqrt = (int) Math.sqrt(Math.pow(i4 - this.f15481k, 2.0d) + Math.pow(this.f15481k - i2, 2.0d));
            if (sqrt != 0) {
                d = m7260a(0.0f, 0.0f, i4 - this.f15481k, this.f15481k - i2);
            }
        } else if (i2 <= this.f15481k && i4 < this.f15481k) {
            sqrt = (int) Math.sqrt(Math.pow(this.f15481k - i4, 2.0d) + Math.pow(this.f15481k - i2, 2.0d));
            if (sqrt != 0) {
                d = 360.0d - m7260a(0.0f, 0.0f, this.f15481k - i4, this.f15481k - i2);
            }
        } else if (i2 <= this.f15481k || i4 < this.f15481k) {
            sqrt = (int) Math.sqrt(Math.pow(this.f15481k - i4, 2.0d) + Math.pow(i2 - this.f15481k, 2.0d));
            if (sqrt != 0) {
                d = 180.0d + m7260a(0.0f, 0.0f, this.f15481k - i4, i2 - this.f15481k);
            }
        } else {
            sqrt = (int) Math.sqrt(Math.pow(i4 - this.f15481k, 2.0d) + Math.pow(i2 - this.f15481k, 2.0d));
            if (sqrt != 0) {
                d = 180.0d - m7260a(0.0f, 0.0f, i4 - this.f15481k, i2 - this.f15481k);
            }
        }
        if (sqrt > this.f15481k) {
            sqrt = this.f15481k;
        }
        this.f15483m = sqrt;
        this.f15485o = (float) d;
        double d2 = 0.0d;
        if (i3 <= this.f15481k && i >= this.f15481k) {
            sqrt2 = (int) Math.sqrt(Math.pow(i - this.f15481k, 2.0d) + Math.pow(this.f15481k - i3, 2.0d));
            if (sqrt2 != 0) {
                d2 = -m7260a(0.0f, 0.0f, i - this.f15481k, this.f15481k - i3);
            }
        } else if (i3 <= this.f15481k && i < this.f15481k) {
            sqrt2 = (int) Math.sqrt(Math.pow(this.f15481k - i, 2.0d) + Math.pow(this.f15481k - i3, 2.0d));
            if (sqrt2 != 0) {
                d2 = m7260a(0.0f, 0.0f, this.f15481k - i, this.f15481k - i3);
            }
        } else if (i3 <= this.f15481k || i < this.f15481k) {
            sqrt2 = (int) Math.sqrt(Math.pow(this.f15481k - i, 2.0d) + Math.pow(i3 - this.f15481k, 2.0d));
            if (sqrt2 != 0) {
                d2 = 180.0d + m7260a(0.0f, 0.0f, this.f15481k - i, i3 - this.f15481k);
            }
        } else {
            sqrt2 = (int) Math.sqrt(Math.pow(i - this.f15481k, 2.0d) + Math.pow(i3 - this.f15481k, 2.0d));
            if (sqrt2 != 0) {
                d2 = 180.0d + m7260a(0.0f, 0.0f, i - this.f15481k, i3 - this.f15481k);
            }
        }
        if (sqrt2 > this.f15481k) {
            sqrt2 = this.f15481k;
        }
        this.f15484n = sqrt2;
        this.f15486p = (float) d2;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f15480j = (float) ((getHeight() * 0.06111d) / this.f15481k);
        this.f15491u = (int) (getHeight() * 0.74074d);
        this.f15492v = (int) (getWidth() * 0.73229d);
        canvas.drawBitmap(this.f15471a, this.f15492v, this.f15491u, this.f15490t);
        canvas.drawBitmap(this.f15472b, this.f15474d + this.f15492v, this.f15475e + this.f15491u, this.f15490t);
        canvas.drawBitmap(this.f15472b, this.f15476f + this.f15492v, this.f15475e + this.f15491u, this.f15490t);
        this.f15490t.setColor(Color.parseColor("#FE5400"));
        this.f15490t.setShader(new LinearGradient(this.f15477g + this.f15492v, (this.f15471a.getHeight() / 2) + this.f15491u, this.f15477g + this.f15473c.getWidth() + this.f15492v, ((this.f15471a.getHeight() / 2) - (this.f15483m * this.f15480j)) + this.f15491u, this.f15489s, (float[]) null, Shader.TileMode.MIRROR));
        this.f15482l = new RectF(this.f15477g + this.f15492v, ((this.f15471a.getHeight() / 2) - (this.f15483m * this.f15480j)) + this.f15491u, this.f15477g + this.f15473c.getWidth() + this.f15492v, (this.f15471a.getHeight() / 2) + this.f15491u);
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f15485o, this.f15477g + (this.f15473c.getWidth() / 2) + this.f15492v, this.f15479i + (this.f15473c.getWidth() / 2) + this.f15491u);
        canvas.setMatrix(matrix);
        canvas.drawRoundRect(this.f15482l, this.f15473c.getWidth() / 2, this.f15473c.getWidth() / 2, this.f15490t);
        matrix.setRotate(0.0f);
        canvas.setMatrix(matrix);
        this.f15490t.setShader(new LinearGradient(this.f15478h + this.f15492v, (this.f15471a.getHeight() / 2) + this.f15491u, this.f15478h + this.f15473c.getWidth() + this.f15492v, ((this.f15471a.getHeight() / 2) - (this.f15484n * this.f15480j)) + this.f15491u, this.f15489s, (float[]) null, Shader.TileMode.MIRROR));
        this.f15482l = new RectF(this.f15478h + this.f15492v, ((this.f15471a.getHeight() / 2) - (this.f15484n * this.f15480j)) + this.f15491u, this.f15478h + this.f15473c.getWidth() + this.f15492v, (this.f15471a.getHeight() / 2) + this.f15491u);
        matrix.postRotate(this.f15486p, this.f15478h + (this.f15473c.getWidth() / 2) + this.f15492v, this.f15479i + (this.f15473c.getWidth() / 2) + this.f15491u);
        canvas.setMatrix(matrix);
        canvas.drawRoundRect(this.f15482l, this.f15473c.getWidth() / 2, this.f15473c.getWidth() / 2, this.f15490t);
        matrix.setRotate(0.0f);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(this.f15473c, this.f15477g + this.f15492v, this.f15479i + this.f15491u, this.f15490t);
        canvas.drawBitmap(this.f15473c, this.f15478h + this.f15492v, this.f15479i + this.f15491u, this.f15490t);
    }
}
