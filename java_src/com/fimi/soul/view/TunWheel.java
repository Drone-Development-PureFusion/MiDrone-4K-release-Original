package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* loaded from: classes.dex */
public class TunWheel extends View {

    /* renamed from: e */
    private static final int f15547e = 5;

    /* renamed from: h */
    private static final int f15548h = 7;

    /* renamed from: j */
    private static final int f15549j = 8;

    /* renamed from: k */
    private static final int f15550k = 5;

    /* renamed from: l */
    private static int f15551l = 20;

    /* renamed from: a */
    int f15552a;

    /* renamed from: b */
    Context f15553b;

    /* renamed from: d */
    private int f15555d;

    /* renamed from: m */
    private AbstractC3737a f15559m;

    /* renamed from: o */
    private Bitmap f15561o;

    /* renamed from: f */
    private int f15556f = 0;

    /* renamed from: g */
    private int f15557g = 5;

    /* renamed from: i */
    private int f15558i = 0;

    /* renamed from: n */
    private Boolean f15560n = true;

    /* renamed from: c */
    private float f15554c = getContext().getResources().getDisplayMetrics().density;

    /* renamed from: com.fimi.soul.view.TunWheel$a */
    /* loaded from: classes.dex */
    public interface AbstractC3737a {
        /* renamed from: a */
        void m7228a(float f);
    }

    public TunWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15553b = context;
        if (this.f15554c == 1.5d) {
            this.f15552a = (int) (180.0f * this.f15554c);
        } else if (this.f15554c == 2.0f) {
            this.f15552a = (int) (this.f15554c * 220.0f);
        } else if (this.f15554c == 3.0f) {
            this.f15552a = (int) (this.f15554c * 220.0f);
        }
        setBackgroundDrawable(getResources().getDrawable(C2300R.C2301drawable.speedbg));
        this.f15561o = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.speedbg);
        if (this.f15561o == null || this.f15561o.isRecycled()) {
            return;
        }
        this.f15561o.recycle();
    }

    /* renamed from: a */
    private void m7233a() {
        if (this.f15559m != null) {
            this.f15559m.m7228a(this.f15556f);
        }
    }

    /* renamed from: a */
    private void m7230a(Canvas canvas) {
        canvas.save();
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(11.0f * this.f15554c);
        float desiredWidth = Layout.getDesiredWidth("0", textPaint);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(C2300R.color.black));
        canvas.drawRect(4.0f * this.f15554c, ((getHeight() / 2) - desiredWidth) - (this.f15554c * 4.0f), getWidth() - (this.f15554c * 1.0f), (this.f15554c * 2.0f) + (getHeight() / 2) + desiredWidth, paint);
        Paint paint2 = new Paint();
        paint2.setColor(getResources().getColor(C2300R.color.linetun));
        paint2.setStyle(Paint.Style.STROKE);
        if (this.f15560n.booleanValue()) {
            canvas.drawRect(4.0f * this.f15554c, ((getHeight() / 2) - desiredWidth) - (this.f15554c * 4.0f), getWidth() - (this.f15554c * 1.0f), (this.f15554c * 2.0f) + (getHeight() / 2) + desiredWidth, paint2);
        } else {
            canvas.drawRect((this.f15554c * 4.0f) - this.f15554c, ((getHeight() / 2) - desiredWidth) - (this.f15554c * 4.0f), (getWidth() - (this.f15554c * 1.0f)) - this.f15554c, (this.f15554c * 2.0f) + (getHeight() / 2) + desiredWidth, paint2);
        }
        textPaint.setColor(getResources().getColor(C2300R.color.red));
        float desiredWidth2 = Layout.getDesiredWidth("0", textPaint);
        if (this.f15556f >= 100 && this.f15556f < 1000) {
            canvas.drawText(String.valueOf(this.f15556f / 10.0d), f15551l + (3.0f * this.f15554c), (desiredWidth2 / 2.0f) + (getHeight() / 2), textPaint);
        } else if (this.f15556f >= 1000) {
            canvas.drawText(String.valueOf(this.f15556f / 10.0d), f15551l, (desiredWidth2 / 2.0f) + (getHeight() / 2), textPaint);
        } else if (this.f15556f < 0 && this.f15556f > -100) {
            canvas.drawText(String.valueOf(this.f15556f / 10.0d), f15551l + (this.f15554c * 4.0f), (desiredWidth2 / 2.0f) + (getHeight() / 2), textPaint);
        } else if (this.f15556f < -100 && this.f15556f > -999) {
            canvas.drawText(String.valueOf(this.f15556f / 10.0d), f15551l + (this.f15554c * 2.0f), (desiredWidth2 / 2.0f) + (getHeight() / 2), textPaint);
        } else if (this.f15556f <= -1000) {
            canvas.drawText(String.valueOf(this.f15556f / 10.0d), f15551l - this.f15554c, (desiredWidth2 / 2.0f) + (getHeight() / 2), textPaint);
        } else {
            canvas.drawText(String.valueOf(this.f15556f / 10.0d), f15551l + (6.0f * this.f15554c), (desiredWidth2 / 2.0f) + (getHeight() / 2), textPaint);
        }
        canvas.restore();
    }

    /* renamed from: b */
    private void m7229b(Canvas canvas) {
        canvas.save();
        Paint paint = new Paint();
        paint.setStrokeWidth(2.0f);
        paint.setColor(getResources().getColor(C2300R.color.linetun));
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(7.0f * this.f15554c);
        textPaint.setColor(getResources().getColor(C2300R.color.linetun));
        int i = this.f15555d;
        float desiredWidth = Layout.getDesiredWidth("0", textPaint);
        f15551l = (int) (7.0f * this.f15554c);
        TextPaint textPaint2 = new TextPaint(1);
        textPaint2.setTextSize(11.0f * this.f15554c);
        textPaint2.setColor(getResources().getColor(C2300R.color.linetun));
        if (this.f15560n.booleanValue()) {
            canvas.drawLine((getPaddingLeft() + f15551l) - this.f15554c, (10.0f * this.f15554c) + getPaddingTop(), (getPaddingLeft() + f15551l) - this.f15554c, getHeight() - (10.0f * this.f15554c), paint);
            int i2 = 0;
            float f = 0.0f;
            int i3 = 0;
            while (i2 <= i - (20.0f * this.f15554c)) {
                float f2 = ((i / 2) + this.f15558i) - ((this.f15557g * i3) * this.f15554c);
                if ((this.f15556f + i3) % 5 == 0) {
                    canvas.drawLine(f15551l + getPaddingLeft(), f2, (this.f15554c * 8.0f) + f15551l, f2, paint);
                    canvas.drawText(String.valueOf((this.f15556f + i3) / 10.0d), f15551l + (this.f15554c * 8.0f) + (3.0f * this.f15554c), f2 + (desiredWidth / 2.0f), textPaint);
                } else {
                    canvas.drawLine(f15551l + getPaddingLeft(), f2, (this.f15554c * 5.0f) + f15551l, f2, paint);
                }
                float f3 = (i / 2) + this.f15558i + (this.f15557g * i3 * this.f15554c);
                if (i2 != i - (20.0f * this.f15554c)) {
                    if ((this.f15556f - i3) % 5 == 0) {
                        canvas.drawLine(f15551l + getPaddingLeft(), f3, (this.f15554c * 8.0f) + f15551l, f3, paint);
                        if (f3 < i - (23.0f * this.f15554c)) {
                            canvas.drawText(String.valueOf((this.f15556f - i3) / 10.0d), f15551l + (this.f15554c * 8.0f) + (3.0f * this.f15554c), (desiredWidth / 2.0f) + f3, textPaint);
                        }
                    } else {
                        canvas.drawLine(f15551l + getPaddingLeft(), f3, (this.f15554c * 5.0f) + f15551l, f3, paint);
                    }
                }
                i3++;
                f = f3;
                i2 = (int) (i2 + (this.f15557g * 2 * this.f15554c));
            }
            canvas.drawLine(f15551l + getPaddingLeft(), f - this.f15558i, 2.0f * (f15551l + (this.f15554c * 8.0f)), f - this.f15558i, paint);
            canvas.drawText(C0413a.f922b, f15551l + (this.f15554c * 8.0f), (((desiredWidth / 2.0f) + f) - (4.0f * this.f15554c)) - this.f15558i, textPaint2);
        } else {
            canvas.drawLine((2.0f * this.f15554c) + (getWidth() - f15551l), (10.0f * this.f15554c) + getPaddingTop(), (2.0f * this.f15554c) + (getWidth() - f15551l), getHeight() - (10.0f * this.f15554c), paint);
            int i4 = 0;
            float f4 = 0.0f;
            int i5 = 0;
            while (i4 <= i - (20.0f * this.f15554c)) {
                float f5 = ((i / 2) + this.f15558i) - ((this.f15557g * i5) * this.f15554c);
                if ((this.f15556f + i5) % 5 == 0) {
                    canvas.drawLine(this.f15554c + (getWidth() - f15551l), f5, this.f15554c + ((getWidth() - f15551l) - (this.f15554c * 8.0f)), f5, paint);
                    if (this.f15556f + i5 >= 100 && this.f15556f + i5 < 1000) {
                        canvas.drawText(String.valueOf((this.f15556f + i5) / 10.0d), f15551l + (5.0f * this.f15554c), f5 + (desiredWidth / 2.0f), textPaint);
                    } else if (this.f15556f + i5 >= 1000) {
                        canvas.drawText(String.valueOf((this.f15556f + i5) / 10.0d), f15551l + this.f15554c, f5 + (desiredWidth / 2.0f), textPaint);
                    } else if (this.f15556f + i5 < 0 && this.f15556f + i5 > -100) {
                        canvas.drawText(String.valueOf((this.f15556f + i5) / 10.0d), f15551l + (7.0f * this.f15554c), f5 + (desiredWidth / 2.0f), textPaint);
                    } else if (this.f15556f + i5 < -100 && this.f15556f + i5 > -999) {
                        canvas.drawText(String.valueOf((this.f15556f + i5) / 10.0d), f15551l + (3.0f * this.f15554c), f5 + (desiredWidth / 2.0f), textPaint);
                    } else if (this.f15556f + i5 <= -1000) {
                        canvas.drawText(String.valueOf((this.f15556f + i5) / 10.0d), f15551l - (2.0f * this.f15554c), f5 + (desiredWidth / 2.0f), textPaint);
                    } else {
                        canvas.drawText(String.valueOf((this.f15556f + i5) / 10.0d), (f15551l * 2) + (2.0f * this.f15554c), f5 + (desiredWidth / 2.0f), textPaint);
                    }
                } else {
                    canvas.drawLine(this.f15554c + (getWidth() - f15551l), f5, this.f15554c + ((getWidth() - f15551l) - (this.f15554c * 5.0f)), f5, paint);
                }
                float f6 = (i / 2) + this.f15558i + (this.f15557g * i5 * this.f15554c);
                if (i4 != i - (20.0f * this.f15554c)) {
                    if ((this.f15556f - i5) % 5 == 0) {
                        canvas.drawLine(this.f15554c + (getWidth() - f15551l), f6, this.f15554c + ((getWidth() - f15551l) - (this.f15554c * 8.0f)), f6, paint);
                        if (f6 < i - (23.0f * this.f15554c)) {
                            if (this.f15556f - i5 >= 100 && this.f15556f - i5 < 1000) {
                                canvas.drawText(String.valueOf((this.f15556f - i5) / 10.0d), f15551l + (5.0f * this.f15554c), (desiredWidth / 2.0f) + f6, textPaint);
                            } else if (this.f15556f - i5 >= 1000) {
                                canvas.drawText(String.valueOf((this.f15556f - i5) / 10.0d), f15551l + this.f15554c, (desiredWidth / 2.0f) + f6, textPaint);
                            } else if (this.f15556f - i5 < 0 && this.f15556f - i5 > -100) {
                                canvas.drawText(String.valueOf((this.f15556f - i5) / 10.0d), f15551l + (this.f15554c * 7.0f), (desiredWidth / 2.0f) + f6, textPaint);
                            } else if (this.f15556f - i5 <= -100 && this.f15556f - i5 > -999) {
                                canvas.drawText(String.valueOf((this.f15556f - i5) / 10.0d), f15551l + (3.0f * this.f15554c), (desiredWidth / 2.0f) + f6, textPaint);
                            } else if (this.f15556f - i5 <= -1000) {
                                canvas.drawText(String.valueOf((this.f15556f - i5) / 10.0d), f15551l - (2.0f * this.f15554c), (desiredWidth / 2.0f) + f6, textPaint);
                            } else {
                                canvas.drawText(String.valueOf((this.f15556f - i5) / 10.0d), (f15551l * 2) + (2.0f * this.f15554c), (desiredWidth / 2.0f) + f6, textPaint);
                            }
                        }
                    } else {
                        canvas.drawLine(this.f15554c + (getWidth() - f15551l), f6, this.f15554c + ((getWidth() - f15551l) - (this.f15554c * 5.0f)), f6, paint);
                    }
                }
                i5++;
                i4 = (int) (i4 + (this.f15557g * 2 * this.f15554c));
                f4 = f6;
            }
            canvas.drawLine(this.f15554c + (getWidth() / 4), f4 - this.f15558i, this.f15554c + (getWidth() - f15551l), f4 - this.f15558i, paint);
            canvas.drawText("m/s", (8.0f * this.f15554c) + this.f15554c, (((desiredWidth / 2.0f) + f4) - (4.0f * this.f15554c)) - this.f15558i, textPaint2);
        }
        canvas.restore();
    }

    /* renamed from: a */
    public void m7232a(float f) {
        this.f15556f = (int) (10.0f * f);
        m7233a();
        postInvalidate();
    }

    /* renamed from: a */
    public void m7231a(int i, int i2) {
        this.f15556f = i;
        this.f15558i = (int) ((i2 * this.f15554c) / 2.0f);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m7229b(canvas);
        m7230a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f15555d = getHeight();
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f15561o.getWidth(), this.f15552a);
    }

    public void setDirection(Boolean bool) {
        this.f15560n = bool;
    }
}
