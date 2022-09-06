package com.fimi.soul.view.myhorizontalseebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2427e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ProgressBar extends View {

    /* renamed from: a */
    private static final int f16323a = 10000;

    /* renamed from: b */
    private static final int f16324b = 200;

    /* renamed from: A */
    private boolean f16325A;

    /* renamed from: B */
    private Interpolator f16326B;

    /* renamed from: C */
    private RunnableC3853c f16327C;

    /* renamed from: D */
    private long f16328D;

    /* renamed from: E */
    private boolean f16329E;

    /* renamed from: F */
    private boolean f16330F;

    /* renamed from: G */
    private boolean f16331G;

    /* renamed from: H */
    private boolean f16332H;

    /* renamed from: I */
    private final ArrayList<C3851b> f16333I;

    /* renamed from: J */
    private RunnableC3850a f16334J;

    /* renamed from: c */
    int f16335c;

    /* renamed from: d */
    int f16336d;

    /* renamed from: e */
    int f16337e;

    /* renamed from: f */
    int f16338f;

    /* renamed from: g */
    Bitmap f16339g;

    /* renamed from: h */
    protected int f16340h;

    /* renamed from: i */
    protected int f16341i;

    /* renamed from: j */
    protected int f16342j;

    /* renamed from: k */
    protected int f16343k;

    /* renamed from: l */
    protected int f16344l;

    /* renamed from: m */
    protected int f16345m;

    /* renamed from: n */
    private int f16346n;

    /* renamed from: o */
    private int f16347o;

    /* renamed from: p */
    private int f16348p;

    /* renamed from: q */
    private int f16349q;

    /* renamed from: r */
    private int f16350r;

    /* renamed from: s */
    private boolean f16351s;

    /* renamed from: t */
    private boolean f16352t;

    /* renamed from: u */
    private Transformation f16353u;

    /* renamed from: v */
    private AlphaAnimation f16354v;

    /* renamed from: w */
    private boolean f16355w;

    /* renamed from: x */
    private Drawable f16356x;

    /* renamed from: y */
    private Drawable f16357y;

    /* renamed from: z */
    private Drawable f16358z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.fimi.soul.view.myhorizontalseebar.ProgressBar.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f16359a;

        /* renamed from: b */
        int f16360b;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f16359a = parcel.readInt();
            this.f16360b = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f16359a);
            parcel.writeInt(this.f16360b);
        }
    }

    /* renamed from: com.fimi.soul.view.myhorizontalseebar.ProgressBar$a */
    /* loaded from: classes.dex */
    private class RunnableC3850a implements Runnable {
        private RunnableC3850a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressBar.this.sendAccessibilityEvent(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.view.myhorizontalseebar.ProgressBar$b */
    /* loaded from: classes.dex */
    public static class C3851b implements AbstractC3857c<C3851b> {

        /* renamed from: f */
        private static final int f16362f = 24;

        /* renamed from: g */
        private static final AbstractC3856b<C3851b> f16363g = C3859e.m6776a(C3859e.m6773a(new AbstractC3858d<C3851b>() { // from class: com.fimi.soul.view.myhorizontalseebar.ProgressBar.b.1
            @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3858d
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo6778a(C3851b c3851b) {
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3858d
            /* renamed from: b */
            public C3851b mo6779a() {
                return new C3851b();
            }

            @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3858d
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public void mo6777b(C3851b c3851b) {
            }
        }, 24));

        /* renamed from: a */
        public int f16364a;

        /* renamed from: b */
        public int f16365b;

        /* renamed from: c */
        public boolean f16366c;

        /* renamed from: d */
        private C3851b f16367d;

        /* renamed from: e */
        private boolean f16368e;

        private C3851b() {
        }

        /* renamed from: a */
        public static C3851b m6796a(int i, int i2, boolean z) {
            C3851b mo6772a = f16363g.mo6772a();
            mo6772a.f16364a = i;
            mo6772a.f16365b = i2;
            mo6772a.f16366c = z;
            return mo6772a;
        }

        @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3857c
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo6782a(C3851b c3851b) {
            this.f16367d = c3851b;
        }

        @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3857c
        /* renamed from: a */
        public void mo6781a(boolean z) {
            this.f16368e = z;
        }

        @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3857c
        /* renamed from: b */
        public boolean mo6780b() {
            return this.f16368e;
        }

        /* renamed from: c */
        public void m6794c() {
            f16363g.mo6771a(this);
        }

        @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3857c
        /* renamed from: d */
        public C3851b mo6783a() {
            return this.f16367d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.view.myhorizontalseebar.ProgressBar$c */
    /* loaded from: classes.dex */
    public class RunnableC3853c implements Runnable {
        private RunnableC3853c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ProgressBar.this) {
                int size = ProgressBar.this.f16333I.size();
                for (int i = 0; i < size; i++) {
                    C3851b c3851b = (C3851b) ProgressBar.this.f16333I.get(i);
                    ProgressBar.this.m6813a(c3851b.f16364a, c3851b.f16365b, c3851b.f16366c, true);
                    c3851b.m6794c();
                }
                ProgressBar.this.f16333I.clear();
                ProgressBar.this.f16332H = false;
            }
        }
    }

    public ProgressBar(Context context) {
        this(context, null);
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842871);
    }

    public ProgressBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        boolean z = false;
        this.f16333I = new ArrayList<>();
        this.f16328D = Thread.currentThread().getId();
        m6817a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2300R.styleable.ProgressBar, i, i2);
        this.f16325A = true;
        Drawable drawable = obtainStyledAttributes.getDrawable(6);
        if (drawable != null) {
            setProgressDrawable(m6809a(drawable, false));
        }
        this.f16350r = obtainStyledAttributes.getInt(7, this.f16350r);
        this.f16335c = obtainStyledAttributes.getDimensionPixelSize(4, this.f16335c);
        this.f16336d = obtainStyledAttributes.getDimensionPixelSize(0, this.f16336d);
        this.f16337e = obtainStyledAttributes.getDimensionPixelSize(5, this.f16337e);
        this.f16338f = obtainStyledAttributes.getDimensionPixelSize(1, this.f16338f);
        this.f16349q = obtainStyledAttributes.getInt(8, this.f16349q);
        setMax(obtainStyledAttributes.getInt(2, this.f16348p));
        setProgress(obtainStyledAttributes.getInt(3, this.f16346n));
        setSecondaryProgress(obtainStyledAttributes.getInt(9, this.f16347o));
        Drawable drawable2 = obtainStyledAttributes.getDrawable(10);
        if (drawable2 != null) {
            setIndeterminateDrawable(m6810a(drawable2));
        }
        this.f16352t = obtainStyledAttributes.getBoolean(11, this.f16352t);
        this.f16325A = false;
        setIndeterminate((this.f16352t || obtainStyledAttributes.getBoolean(12, this.f16351s)) ? true : z);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private Drawable m6810a(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; i++) {
                Drawable m6809a = m6809a(animationDrawable.getFrame(i), true);
                m6809a.setLevel(10000);
                animationDrawable2.addFrame(m6809a, animationDrawable.getDuration(i));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    /* renamed from: a */
    private Drawable m6809a(Drawable drawable, boolean z) {
        if (!(drawable instanceof LayerDrawable)) {
            if (drawable instanceof StateListDrawable) {
                StateListDrawable stateListDrawable = (StateListDrawable) drawable;
                return new StateListDrawable();
            } else if (!(drawable instanceof BitmapDrawable)) {
                return drawable;
            } else {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (this.f16339g == null) {
                    this.f16339g = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i = 0; i < numberOfLayers; i++) {
            int id = layerDrawable.getId(i);
            drawableArr[i] = m6809a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable2.setId(i2, layerDrawable.getId(i2));
        }
        return layerDrawable2;
    }

    /* renamed from: a */
    private void m6817a() {
        this.f16348p = 100;
        this.f16346n = 0;
        this.f16347o = 0;
        this.f16351s = false;
        this.f16352t = false;
        this.f16350r = 4000;
        this.f16349q = 1;
        this.f16335c = 24;
        this.f16336d = 48;
        this.f16337e = 24;
        this.f16338f = 48;
    }

    /* renamed from: a */
    private void m6815a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i - (this.f16343k + this.f16342j);
        int i8 = i2 - (this.f16344l + this.f16345m);
        if (this.f16356x != null) {
            if (this.f16352t && !(this.f16356x instanceof AnimationDrawable)) {
                float intrinsicWidth = this.f16356x.getIntrinsicWidth() / this.f16356x.getIntrinsicHeight();
                float f = i7 / i8;
                if (intrinsicWidth != f) {
                    if (f > intrinsicWidth) {
                        int i9 = (int) (intrinsicWidth * i8);
                        i5 = (i7 - i9) / 2;
                        i3 = i5 + i9;
                        i4 = i8;
                        i6 = 0;
                    } else {
                        int i10 = (int) ((1.0f / intrinsicWidth) * i7);
                        int i11 = (i8 - i10) / 2;
                        int i12 = i11 + i10;
                        i3 = i7;
                        i4 = i12;
                        i6 = i11;
                        i5 = 0;
                    }
                    this.f16356x.setBounds(i5, i6, i3, i4);
                }
            }
            i5 = 0;
            i3 = i7;
            i4 = i8;
            i6 = 0;
            this.f16356x.setBounds(i5, i6, i3, i4);
        } else {
            i3 = i7;
            i4 = i8;
        }
        if (this.f16357y != null) {
            this.f16357y.setBounds(0, 0, i3, i4);
        }
    }

    /* renamed from: a */
    private synchronized void m6814a(int i, int i2, boolean z) {
        if (this.f16328D == Thread.currentThread().getId()) {
            m6813a(i, i2, z, true);
        } else {
            if (this.f16327C == null) {
                this.f16327C = new RunnableC3853c();
            }
            this.f16333I.add(C3851b.m6796a(i, i2, z));
            if (this.f16331G && !this.f16332H) {
                post(this.f16327C);
                this.f16332H = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m6813a(int i, int i2, boolean z, boolean z2) {
        float f = this.f16348p > 0 ? i2 / this.f16348p : 0.0f;
        Drawable drawable = this.f16358z;
        if (drawable != null) {
            Drawable drawable2 = null;
            if (drawable instanceof LayerDrawable) {
                drawable2 = ((LayerDrawable) drawable).findDrawableByLayerId(i);
            }
            int i3 = (int) (10000.0f * f);
            if (drawable2 != null) {
                drawable = drawable2;
            }
            drawable.setLevel(i3);
        } else {
            invalidate();
        }
        if (z2 && i == 16908301) {
            mo6788a(f, z);
        }
    }

    /* renamed from: b */
    private void m6805b() {
        int[] drawableState = getDrawableState();
        if (this.f16357y != null && this.f16357y.isStateful()) {
            this.f16357y.setState(drawableState);
        }
        if (this.f16356x == null || !this.f16356x.isStateful()) {
            return;
        }
        this.f16356x.setState(drawableState);
    }

    /* renamed from: c */
    private void m6803c() {
        if (this.f16334J == null) {
            this.f16334J = new RunnableC3850a();
        } else {
            removeCallbacks(this.f16334J);
        }
        postDelayed(this.f16334J, 200L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6788a(float f, boolean z) {
    }

    /* renamed from: a */
    public void mo6816a(int i) {
        Drawable drawable = this.f16358z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m6812a(int i, boolean z) {
        if (!this.f16351s) {
            int i2 = i < 0 ? 0 : i;
            if (i2 > this.f16348p) {
                i2 = this.f16348p;
            }
            if (i2 != this.f16346n) {
                this.f16346n = i2;
                m6814a(16908301, this.f16346n, z);
            }
        }
    }

    /* renamed from: a */
    public void m6811a(Context context, int i) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i));
    }

    /* renamed from: b */
    public final synchronized void m6804b(int i) {
        setProgress(this.f16346n + i);
    }

    /* renamed from: c */
    public final synchronized void m6802c(int i) {
        setSecondaryProgress(this.f16347o + i);
    }

    @ViewDebug.ExportedProperty(category = C2427e.f8281be)
    /* renamed from: d */
    public synchronized boolean m6801d() {
        return this.f16351s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m6805b();
    }

    /* renamed from: e */
    void m6800e() {
        if (getVisibility() != 0) {
            return;
        }
        if (this.f16356x instanceof Animatable) {
            this.f16329E = true;
            this.f16355w = false;
        } else {
            this.f16355w = true;
            if (this.f16326B == null) {
                this.f16326B = new LinearInterpolator();
            }
            if (this.f16353u == null) {
                this.f16353u = new Transformation();
            } else {
                this.f16353u.clear();
            }
            if (this.f16354v == null) {
                this.f16354v = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.f16354v.reset();
            }
            this.f16354v.setRepeatMode(this.f16349q);
            this.f16354v.setRepeatCount(-1);
            this.f16354v.setDuration(this.f16350r);
            this.f16354v.setInterpolator(this.f16326B);
            this.f16354v.setStartTime(-1L);
        }
        postInvalidate();
    }

    /* renamed from: f */
    void m6799f() {
        this.f16355w = false;
        if (this.f16356x instanceof Animatable) {
            ((Animatable) this.f16356x).stop();
            this.f16329E = false;
        }
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable getCurrentDrawable() {
        return this.f16358z;
    }

    Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public Drawable getIndeterminateDrawable() {
        return this.f16356x;
    }

    public Interpolator getInterpolator() {
        return this.f16326B;
    }

    @ViewDebug.ExportedProperty(category = C2427e.f8281be)
    public synchronized int getMax() {
        return this.f16348p;
    }

    @ViewDebug.ExportedProperty(category = C2427e.f8281be)
    public synchronized int getProgress() {
        return this.f16351s ? 0 : this.f16346n;
    }

    public Drawable getProgressDrawable() {
        return this.f16357y;
    }

    @ViewDebug.ExportedProperty(category = C2427e.f8281be)
    public synchronized int getSecondaryProgress() {
        return this.f16351s ? 0 : this.f16347o;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (!this.f16330F) {
            if (!verifyDrawable(drawable)) {
                super.invalidateDrawable(drawable);
                return;
            }
            Rect bounds = drawable.getBounds();
            int i = this.f16340h + this.f16342j;
            int i2 = this.f16341i + this.f16344l;
            invalidate(bounds.left + i, bounds.top + i2, i + bounds.right, bounds.bottom + i2);
        }
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f16357y != null) {
            this.f16357y.jumpToCurrentState();
        }
        if (this.f16356x != null) {
            this.f16356x.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f16351s) {
            m6800e();
        }
        if (this.f16333I != null) {
            synchronized (this) {
                int size = this.f16333I.size();
                for (int i = 0; i < size; i++) {
                    C3851b c3851b = this.f16333I.get(i);
                    m6813a(c3851b.f16364a, c3851b.f16365b, c3851b.f16366c, true);
                    c3851b.m6794c();
                }
                this.f16333I.clear();
            }
        }
        this.f16331G = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.f16351s) {
            m6799f();
        }
        if (this.f16327C != null) {
            removeCallbacks(this.f16327C);
        }
        if (this.f16327C != null && this.f16332H) {
            removeCallbacks(this.f16327C);
        }
        if (this.f16334J != null) {
            removeCallbacks(this.f16334J);
        }
        super.onDetachedFromWindow();
        this.f16331G = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f16358z;
        if (drawable != null) {
            canvas.save();
            canvas.translate(this.f16342j, this.f16344l);
            long drawingTime = getDrawingTime();
            if (this.f16355w) {
                this.f16354v.getTransformation(drawingTime, this.f16353u);
                float alpha = this.f16353u.getAlpha();
                this.f16330F = true;
                drawable.setLevel((int) (alpha * 10000.0f));
                this.f16330F = false;
                postInvalidateOnAnimation();
            }
            drawable.draw(canvas);
            canvas.restore();
            if (this.f16329E && (drawable instanceof Animatable)) {
                ((Animatable) drawable).start();
                this.f16329E = false;
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ProgressBar.class.getName());
        accessibilityEvent.setItemCount(this.f16348p);
        accessibilityEvent.setCurrentItemIndex(this.f16346n);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ProgressBar.class.getName());
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        synchronized (this) {
            Drawable drawable = this.f16358z;
            if (drawable != null) {
                i3 = Math.max(this.f16335c, Math.min(this.f16336d, drawable.getIntrinsicWidth()));
                i4 = Math.max(this.f16337e, Math.min(this.f16338f, drawable.getIntrinsicHeight()));
            } else {
                i3 = 0;
            }
            m6805b();
            setMeasuredDimension(resolveSizeAndState(i3 + this.f16342j + this.f16343k, i, 0), resolveSizeAndState(i4 + this.f16344l + this.f16345m, i2, 0));
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.f16359a);
        setSecondaryProgress(savedState.f16360b);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f16359a = this.f16346n;
        savedState.f16360b = this.f16347o;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m6815a(i, i2);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f16351s) {
            if (i == 8 || i == 4) {
                m6799f();
            } else {
                m6800e();
            }
        }
    }

    @Override // android.view.View
    public void postInvalidate() {
        if (!this.f16325A) {
            super.postInvalidate();
        }
    }

    public synchronized void setIndeterminate(boolean z) {
        if ((!this.f16352t || !this.f16351s) && z != this.f16351s) {
            this.f16351s = z;
            if (z) {
                this.f16358z = this.f16356x;
                m6800e();
            } else {
                this.f16358z = this.f16357y;
                m6799f();
            }
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (this.f16351s) {
            this.f16358z = drawable;
            postInvalidate();
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f16326B = interpolator;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.f16348p) {
            this.f16348p = i;
            postInvalidate();
            if (this.f16346n > i) {
                this.f16346n = i;
            }
            m6814a(16908301, this.f16346n, false);
        }
    }

    public synchronized void setProgress(int i) {
        m6812a(i, false);
    }

    public void setProgressDrawable(Drawable drawable) {
        boolean z;
        if (this.f16357y == null || drawable == this.f16357y) {
            z = false;
        } else {
            this.f16357y.setCallback(null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            int minimumHeight = drawable.getMinimumHeight();
            if (this.f16338f < minimumHeight) {
                this.f16338f = minimumHeight;
                requestLayout();
            }
        }
        this.f16357y = drawable;
        if (!this.f16351s) {
            this.f16358z = drawable;
            postInvalidate();
        }
        if (z) {
            m6815a(getWidth(), getHeight());
            m6805b();
            m6813a(16908301, this.f16346n, false, false);
            m6813a(16908303, this.f16347o, false, false);
        }
    }

    public synchronized void setSecondaryProgress(int i) {
        int i2 = 0;
        synchronized (this) {
            if (!this.f16351s) {
                if (i >= 0) {
                    i2 = i;
                }
                if (i2 > this.f16348p) {
                    i2 = this.f16348p;
                }
                if (i2 != this.f16347o) {
                    this.f16347o = i2;
                    m6814a(16908303, this.f16347o, false);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (!this.f16351s) {
                return;
            }
            if (i == 8 || i == 4) {
                m6799f();
            } else {
                m6800e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f16357y || drawable == this.f16356x || super.verifyDrawable(drawable);
    }
}
