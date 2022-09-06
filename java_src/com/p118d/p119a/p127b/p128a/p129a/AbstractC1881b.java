package com.p118d.p119a.p127b.p128a.p129a;

import java.util.Iterator;
import java.util.Queue;
/* renamed from: com.d.a.b.a.a.b */
/* loaded from: classes.dex */
public interface AbstractC1881b<E> extends Queue<E> {
    /* renamed from: a */
    void mo14186a(E e);

    @Override // java.util.Queue, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean add(E e);

    /* renamed from: b */
    void mo14181b(E e);

    /* renamed from: c */
    E mo14179c();

    /* renamed from: c */
    boolean mo14177c(E e);

    @Override // java.util.Collection, java.util.concurrent.BlockingQueue
    boolean contains(Object obj);

    /* renamed from: d */
    E mo14176d();

    /* renamed from: d */
    boolean mo14175d(E e);

    /* renamed from: e */
    E mo14174e();

    @Override // java.util.Queue
    E element();

    /* renamed from: f */
    E mo14172f();

    /* renamed from: g */
    E mo14170g();

    /* renamed from: g */
    boolean mo14169g(Object obj);

    /* renamed from: h */
    E mo14168h();

    /* renamed from: h */
    boolean mo14167h(Object obj);

    /* renamed from: i */
    E mo14166i();

    /* renamed from: i */
    void mo14165i(E e);

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    /* renamed from: j */
    E mo14164j();

    /* renamed from: k */
    E mo14163k();

    /* renamed from: l */
    Iterator<E> mo14162l();

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(E e);

    @Override // java.util.Queue
    E peek();

    @Override // java.util.Queue
    E poll();

    @Override // java.util.Queue
    E remove();

    @Override // java.util.Collection, java.util.concurrent.BlockingQueue
    boolean remove(Object obj);

    @Override // java.util.Collection
    int size();
}
