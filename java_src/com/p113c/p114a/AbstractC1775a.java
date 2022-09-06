package com.p113c.p114a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
/* renamed from: com.c.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1775a implements Cloneable {

    /* renamed from: a */
    ArrayList<AbstractC1776a> f6284a = null;

    /* renamed from: com.c.a.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC1776a {
        /* renamed from: a */
        void mo14312a(AbstractC1775a abstractC1775a);

        /* renamed from: b */
        void mo14311b(AbstractC1775a abstractC1775a);

        /* renamed from: c */
        void mo14310c(AbstractC1775a abstractC1775a);

        /* renamed from: d */
        void mo14309d(AbstractC1775a abstractC1775a);
    }

    /* renamed from: a */
    public void mo14521a() {
    }

    /* renamed from: a */
    public abstract void mo14518a(long j);

    /* renamed from: a */
    public abstract void mo14517a(Interpolator interpolator);

    /* renamed from: a */
    public void m14672a(AbstractC1776a abstractC1776a) {
        if (this.f6284a == null) {
            this.f6284a = new ArrayList<>();
        }
        this.f6284a.add(abstractC1776a);
    }

    /* renamed from: a */
    public void mo14608a(Object obj) {
    }

    /* renamed from: b */
    public abstract AbstractC1775a mo14503b(long j);

    /* renamed from: b */
    public void mo14505b() {
    }

    /* renamed from: b */
    public void m14671b(AbstractC1776a abstractC1776a) {
        if (this.f6284a == null) {
            return;
        }
        this.f6284a.remove(abstractC1776a);
        if (this.f6284a.size() != 0) {
            return;
        }
        this.f6284a = null;
    }

    /* renamed from: c */
    public void mo14496c() {
    }

    /* renamed from: d */
    public abstract long mo14493d();

    /* renamed from: e */
    public abstract long mo14491e();

    /* renamed from: f */
    public abstract boolean mo14489f();

    /* renamed from: g */
    public boolean mo14487g() {
        return mo14489f();
    }

    /* renamed from: h */
    public ArrayList<AbstractC1776a> m14670h() {
        return this.f6284a;
    }

    /* renamed from: i */
    public void m14669i() {
        if (this.f6284a != null) {
            this.f6284a.clear();
            this.f6284a = null;
        }
    }

    @Override // 
    /* renamed from: j */
    public AbstractC1775a clone() {
        try {
            AbstractC1775a abstractC1775a = (AbstractC1775a) super.clone();
            if (this.f6284a != null) {
                ArrayList<AbstractC1776a> arrayList = this.f6284a;
                abstractC1775a.f6284a = new ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    abstractC1775a.f6284a.add(arrayList.get(i));
                }
            }
            return abstractC1775a;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: k */
    public void mo14598k() {
    }

    /* renamed from: l */
    public void mo14597l() {
    }
}
