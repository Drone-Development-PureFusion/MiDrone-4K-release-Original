package com.p113c.p116c;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.p113c.p114a.AbstractC1775a;
import java.lang.ref.WeakReference;
/* renamed from: com.c.c.d */
/* loaded from: classes.dex */
class C1841d extends AbstractC1835b {

    /* renamed from: a */
    private static final long f6492a = -1;

    /* renamed from: b */
    private final WeakReference<ViewPropertyAnimator> f6493b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1841d(View view) {
        this.f6493b = new WeakReference<>(view.animate());
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public long mo14352a() {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        return viewPropertyAnimator != null ? viewPropertyAnimator.getDuration() : f6492a;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14351a(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14347a(long j) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14346a(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14345a(final AbstractC1775a.AbstractC1776a abstractC1776a) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            if (abstractC1776a == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new Animator.AnimatorListener() { // from class: com.c.c.d.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        abstractC1776a.mo14310c(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        abstractC1776a.mo14311b(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        abstractC1776a.mo14309d(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        abstractC1776a.mo14312a(null);
                    }
                });
            }
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: b */
    public long mo14341b() {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        return viewPropertyAnimator != null ? viewPropertyAnimator.getStartDelay() : f6492a;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: b */
    public AbstractC1835b mo14340b(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: b */
    public AbstractC1835b mo14338b(long j) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: c */
    public AbstractC1835b mo14335c(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: c */
    public void mo14336c() {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: d */
    public AbstractC1835b mo14331d(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: d */
    public void mo14332d() {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: e */
    public AbstractC1835b mo14328e(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: f */
    public AbstractC1835b mo14327f(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: g */
    public AbstractC1835b mo14326g(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: h */
    public AbstractC1835b mo14325h(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: i */
    public AbstractC1835b mo14324i(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: j */
    public AbstractC1835b mo14323j(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: k */
    public AbstractC1835b mo14322k(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: l */
    public AbstractC1835b mo14321l(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: m */
    public AbstractC1835b mo14320m(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: n */
    public AbstractC1835b mo14319n(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: o */
    public AbstractC1835b mo14318o(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: p */
    public AbstractC1835b mo14317p(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: q */
    public AbstractC1835b mo14316q(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: r */
    public AbstractC1835b mo14315r(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: s */
    public AbstractC1835b mo14314s(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f);
        }
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: t */
    public AbstractC1835b mo14313t(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6493b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f);
        }
        return this;
    }
}
