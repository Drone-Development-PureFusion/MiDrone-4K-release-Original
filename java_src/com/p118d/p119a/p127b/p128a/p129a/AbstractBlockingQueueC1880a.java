package com.p118d.p119a.p127b.p128a.p129a;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/* renamed from: com.d.a.b.a.a.a */
/* loaded from: classes.dex */
public interface AbstractBlockingQueueC1880a<E> extends AbstractC1881b<E>, BlockingQueue<E> {
    /* renamed from: a */
    E mo14189a();

    /* renamed from: a */
    E mo14188a(long j, TimeUnit timeUnit);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: a */
    void mo14186a(E e);

    /* renamed from: a */
    boolean mo14185a(E e, long j, TimeUnit timeUnit);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.Queue, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean add(E e);

    /* renamed from: b */
    E mo14184b();

    /* renamed from: b */
    E mo14183b(long j, TimeUnit timeUnit);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: b */
    void mo14181b(E e);

    /* renamed from: b */
    boolean mo14180b(E e, long j, TimeUnit timeUnit);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: c */
    boolean mo14177c(E e);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean contains(Object obj);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: d */
    boolean mo14175d(E e);

    /* renamed from: e */
    void mo14173e(E e);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.Queue
    E element();

    /* renamed from: f */
    void mo14171f(E e);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: g */
    boolean mo14169g(Object obj);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: h */
    boolean mo14167h(Object obj);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: i */
    void mo14165i(E e);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(E e);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e, long j, TimeUnit timeUnit);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.Queue
    E peek();

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.Queue
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j, TimeUnit timeUnit);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.Queue
    E remove();

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean remove(Object obj);

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.Collection
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take();
}
