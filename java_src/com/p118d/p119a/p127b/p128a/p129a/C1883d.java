package com.p118d.p119a.p127b.p128a.p129a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.d.a.b.a.a.d */
/* loaded from: classes.dex */
public class C1883d<E> extends AbstractQueue<E> implements AbstractBlockingQueueC1880a<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;

    /* renamed from: a */
    transient C1888d<E> f6638a;

    /* renamed from: b */
    transient C1888d<E> f6639b;

    /* renamed from: c */
    final ReentrantLock f6640c;

    /* renamed from: d */
    private transient int f6641d;

    /* renamed from: e */
    private final int f6642e;

    /* renamed from: f */
    private final Condition f6643f;

    /* renamed from: g */
    private final Condition f6644g;

    /* renamed from: com.d.a.b.a.a.d$a */
    /* loaded from: classes.dex */
    private abstract class AbstractC1885a implements Iterator<E> {

        /* renamed from: a */
        C1888d<E> f6645a;

        /* renamed from: b */
        E f6646b;

        /* renamed from: d */
        private C1888d<E> f6648d;

        AbstractC1885a() {
            ReentrantLock reentrantLock = C1883d.this.f6640c;
            reentrantLock.lock();
            try {
                this.f6645a = mo14157a();
                this.f6646b = this.f6645a == null ? null : this.f6645a.f6651a;
            } finally {
                reentrantLock.unlock();
            }
        }

        /* renamed from: b */
        private C1888d<E> m14158b(C1888d<E> c1888d) {
            while (true) {
                C1888d<E> mo14156a = mo14156a(c1888d);
                if (mo14156a == null) {
                    return null;
                }
                if (mo14156a.f6651a != null) {
                    return mo14156a;
                }
                if (mo14156a == c1888d) {
                    return mo14157a();
                }
                c1888d = mo14156a;
            }
        }

        /* renamed from: a */
        abstract C1888d<E> mo14157a();

        /* renamed from: a */
        abstract C1888d<E> mo14156a(C1888d<E> c1888d);

        /* renamed from: b */
        void m14159b() {
            ReentrantLock reentrantLock = C1883d.this.f6640c;
            reentrantLock.lock();
            try {
                this.f6645a = m14158b(this.f6645a);
                this.f6646b = this.f6645a == null ? null : this.f6645a.f6651a;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6645a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f6645a == null) {
                throw new NoSuchElementException();
            }
            this.f6648d = this.f6645a;
            E e = this.f6646b;
            m14159b();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            C1888d<E> c1888d = this.f6648d;
            if (c1888d == null) {
                throw new IllegalStateException();
            }
            this.f6648d = null;
            ReentrantLock reentrantLock = C1883d.this.f6640c;
            reentrantLock.lock();
            try {
                if (c1888d.f6651a != null) {
                    C1883d.this.m14187a((C1888d) c1888d);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* renamed from: com.d.a.b.a.a.d$b */
    /* loaded from: classes.dex */
    private class C1886b extends C1883d<E>.AbstractC1885a {
        private C1886b() {
            super();
        }

        @Override // com.p118d.p119a.p127b.p128a.p129a.C1883d.AbstractC1885a
        /* renamed from: a */
        C1888d<E> mo14157a() {
            return C1883d.this.f6639b;
        }

        @Override // com.p118d.p119a.p127b.p128a.p129a.C1883d.AbstractC1885a
        /* renamed from: a */
        C1888d<E> mo14156a(C1888d<E> c1888d) {
            return c1888d.f6652b;
        }
    }

    /* renamed from: com.d.a.b.a.a.d$c */
    /* loaded from: classes.dex */
    private class C1887c extends C1883d<E>.AbstractC1885a {
        private C1887c() {
            super();
        }

        @Override // com.p118d.p119a.p127b.p128a.p129a.C1883d.AbstractC1885a
        /* renamed from: a */
        C1888d<E> mo14157a() {
            return C1883d.this.f6638a;
        }

        @Override // com.p118d.p119a.p127b.p128a.p129a.C1883d.AbstractC1885a
        /* renamed from: a */
        C1888d<E> mo14156a(C1888d<E> c1888d) {
            return c1888d.f6653c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.d.a.b.a.a.d$d */
    /* loaded from: classes.dex */
    public static final class C1888d<E> {

        /* renamed from: a */
        E f6651a;

        /* renamed from: b */
        C1888d<E> f6652b;

        /* renamed from: c */
        C1888d<E> f6653c;

        C1888d(E e) {
            this.f6651a = e;
        }
    }

    public C1883d() {
        this(Integer.MAX_VALUE);
    }

    public C1883d(int i) {
        this.f6640c = new ReentrantLock();
        this.f6643f = this.f6640c.newCondition();
        this.f6644g = this.f6640c.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.f6642e = i;
    }

    public C1883d(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            for (E e : collection) {
                if (e == null) {
                    throw new NullPointerException();
                }
                if (!m14178c((C1888d) new C1888d<>(e))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: b */
    private boolean m14182b(C1888d<E> c1888d) {
        if (this.f6641d >= this.f6642e) {
            return false;
        }
        C1888d<E> c1888d2 = this.f6638a;
        c1888d.f6653c = c1888d2;
        this.f6638a = c1888d;
        if (this.f6639b == null) {
            this.f6639b = c1888d;
        } else {
            c1888d2.f6652b = c1888d;
        }
        this.f6641d++;
        this.f6643f.signal();
        return true;
    }

    /* renamed from: c */
    private boolean m14178c(C1888d<E> c1888d) {
        if (this.f6641d >= this.f6642e) {
            return false;
        }
        C1888d<E> c1888d2 = this.f6639b;
        c1888d.f6652b = c1888d2;
        this.f6639b = c1888d;
        if (this.f6638a == null) {
            this.f6638a = c1888d;
        } else {
            c1888d2.f6653c = c1888d;
        }
        this.f6641d++;
        this.f6643f.signal();
        return true;
    }

    /* renamed from: m */
    private E m14161m() {
        C1888d<E> c1888d = this.f6638a;
        if (c1888d == null) {
            return null;
        }
        C1888d<E> c1888d2 = c1888d.f6653c;
        E e = c1888d.f6651a;
        c1888d.f6651a = null;
        c1888d.f6653c = c1888d;
        this.f6638a = c1888d2;
        if (c1888d2 == null) {
            this.f6639b = null;
        } else {
            c1888d2.f6652b = null;
        }
        this.f6641d--;
        this.f6644g.signal();
        return e;
    }

    /* renamed from: n */
    private E m14160n() {
        C1888d<E> c1888d = this.f6639b;
        if (c1888d == null) {
            return null;
        }
        C1888d<E> c1888d2 = c1888d.f6652b;
        E e = c1888d.f6651a;
        c1888d.f6651a = null;
        c1888d.f6652b = c1888d;
        this.f6639b = c1888d2;
        if (c1888d2 == null) {
            this.f6638a = null;
        } else {
            c1888d2.f6653c = null;
        }
        this.f6641d--;
        this.f6644g.signal();
        return e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f6641d = 0;
        this.f6638a = null;
        this.f6639b = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            }
            add(readObject);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (C1888d<E> c1888d = this.f6638a; c1888d != null; c1888d = c1888d.f6653c) {
                objectOutputStream.writeObject(c1888d.f6651a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a
    /* renamed from: a */
    public E mo14189a() {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        while (true) {
            try {
                E m14161m = m14161m();
                if (m14161m != null) {
                    return m14161m;
                }
                this.f6643f.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a
    /* renamed from: a */
    public E mo14188a(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                long j2 = nanos;
                E m14161m = m14161m();
                if (m14161m != null) {
                    return m14161m;
                }
                if (j2 <= 0) {
                    return null;
                }
                nanos = this.f6643f.awaitNanos(j2);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* renamed from: a */
    void m14187a(C1888d<E> c1888d) {
        C1888d<E> c1888d2 = c1888d.f6652b;
        C1888d<E> c1888d3 = c1888d.f6653c;
        if (c1888d2 == null) {
            m14161m();
        } else if (c1888d3 == null) {
            m14160n();
        } else {
            c1888d2.f6653c = c1888d3;
            c1888d3.f6652b = c1888d2;
            c1888d.f6651a = null;
            this.f6641d--;
            this.f6644g.signal();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: a */
    public void mo14186a(E e) {
        if (!mo14177c((C1883d<E>) e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a
    /* renamed from: a */
    public boolean mo14185a(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1888d<E> c1888d = new C1888d<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lockInterruptibly();
        while (!m14182b((C1888d) c1888d)) {
            try {
                if (nanos <= 0) {
                    return false;
                }
                nanos = this.f6644g.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.concurrent.BlockingQueue
    public boolean add(E e) {
        mo14181b((C1883d<E>) e);
        return true;
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a
    /* renamed from: b */
    public E mo14184b() {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        while (true) {
            try {
                E m14160n = m14160n();
                if (m14160n != null) {
                    return m14160n;
                }
                this.f6643f.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a
    /* renamed from: b */
    public E mo14183b(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                long j2 = nanos;
                E m14160n = m14160n();
                if (m14160n != null) {
                    return m14160n;
                }
                if (j2 <= 0) {
                    return null;
                }
                nanos = this.f6643f.awaitNanos(j2);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: b */
    public void mo14181b(E e) {
        if (!mo14175d(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a
    /* renamed from: b */
    public boolean mo14180b(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1888d<E> c1888d = new C1888d<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lockInterruptibly();
        while (!m14178c((C1888d) c1888d)) {
            try {
                if (nanos <= 0) {
                    return false;
                }
                nanos = this.f6644g.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return true;
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: c */
    public E mo14179c() {
        E mo14174e = mo14174e();
        if (mo14174e == null) {
            throw new NoSuchElementException();
        }
        return mo14174e;
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: c */
    public boolean mo14177c(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1888d<E> c1888d = new C1888d<>(e);
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            return m14182b((C1888d) c1888d);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            C1888d<E> c1888d = this.f6638a;
            while (c1888d != null) {
                c1888d.f6651a = null;
                C1888d<E> c1888d2 = c1888d.f6653c;
                c1888d.f6652b = null;
                c1888d.f6653c = null;
                c1888d = c1888d2;
            }
            this.f6639b = null;
            this.f6638a = null;
            this.f6641d = 0;
            this.f6644g.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            for (C1888d<E> c1888d = this.f6638a; c1888d != null; c1888d = c1888d.f6653c) {
                if (obj.equals(c1888d.f6651a)) {
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: d */
    public E mo14176d() {
        E mo14172f = mo14172f();
        if (mo14172f == null) {
            throw new NoSuchElementException();
        }
        return mo14172f;
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: d */
    public boolean mo14175d(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1888d<E> c1888d = new C1888d<>(e);
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            return m14178c((C1888d) c1888d);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            int min = Math.min(i, this.f6641d);
            for (int i2 = 0; i2 < min; i2++) {
                collection.add((E) this.f6638a.f6651a);
                m14161m();
            }
            return min;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: e */
    public E mo14174e() {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            return m14161m();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a
    /* renamed from: e */
    public void mo14173e(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1888d<E> c1888d = new C1888d<>(e);
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        while (!m14182b((C1888d) c1888d)) {
            try {
                this.f6644g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    public E element() {
        return mo14170g();
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: f */
    public E mo14172f() {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            return m14160n();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a
    /* renamed from: f */
    public void mo14171f(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        C1888d<E> c1888d = new C1888d<>(e);
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        while (!m14178c((C1888d) c1888d)) {
            try {
                this.f6644g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: g */
    public E mo14170g() {
        E mo14166i = mo14166i();
        if (mo14166i == null) {
            throw new NoSuchElementException();
        }
        return mo14166i;
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: g */
    public boolean mo14169g(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            for (C1888d<E> c1888d = this.f6638a; c1888d != null; c1888d = c1888d.f6653c) {
                if (obj.equals(c1888d.f6651a)) {
                    m14187a((C1888d) c1888d);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: h */
    public E mo14168h() {
        E mo14164j = mo14164j();
        if (mo14164j == null) {
            throw new NoSuchElementException();
        }
        return mo14164j;
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: h */
    public boolean mo14167h(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            for (C1888d<E> c1888d = this.f6639b; c1888d != null; c1888d = c1888d.f6652b) {
                if (obj.equals(c1888d.f6651a)) {
                    m14187a((C1888d) c1888d);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: i */
    public E mo14166i() {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            return this.f6638a == null ? null : this.f6638a.f6651a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: i */
    public void mo14165i(E e) {
        mo14186a((C1883d<E>) e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    public Iterator<E> iterator() {
        return new C1887c();
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: j */
    public E mo14164j() {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            return this.f6639b == null ? null : this.f6639b.f6651a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: k */
    public E mo14163k() {
        return mo14179c();
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    /* renamed from: l */
    public Iterator<E> mo14162l() {
        return new C1886b();
    }

    public boolean offer(E e) {
        return mo14175d(e);
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return mo14180b(e, j, timeUnit);
    }

    @Override // java.util.Queue, com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    public E peek() {
        return mo14166i();
    }

    @Override // java.util.Queue, com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    public E poll() {
        return mo14174e();
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) {
        return mo14188a(j, timeUnit);
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, java.util.concurrent.BlockingQueue
    public void put(E e) {
        mo14171f(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            return this.f6642e - this.f6641d;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    public E remove() {
        return mo14179c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        return mo14169g(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, com.p118d.p119a.p127b.p128a.p129a.AbstractC1881b
    public int size() {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            return this.f6641d;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.p118d.p119a.p127b.p128a.p129a.AbstractBlockingQueueC1880a, java.util.concurrent.BlockingQueue
    public E take() {
        return mo14189a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.f6641d];
            int i = 0;
            C1888d<E> c1888d = this.f6638a;
            while (c1888d != null) {
                int i2 = i + 1;
                objArr[i] = c1888d.f6651a;
                c1888d = c1888d.f6653c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            if (tArr.length < this.f6641d) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f6641d);
            }
            int i = 0;
            C1888d<E> c1888d = this.f6638a;
            while (c1888d != null) {
                tArr[i] = c1888d.f6651a;
                c1888d = c1888d.f6653c;
                i++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String sb;
        ReentrantLock reentrantLock = this.f6640c;
        reentrantLock.lock();
        try {
            C1888d<E> c1888d = this.f6638a;
            if (c1888d == null) {
                sb = "[]";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('[');
                while (true) {
                    C1888d<E> c1888d2 = c1888d;
                    Object obj = c1888d2.f6651a;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    sb2.append(obj);
                    c1888d = c1888d2.f6653c;
                    if (c1888d == null) {
                        break;
                    }
                    sb2.append(C0359h.f727x).append(C5122l.f21763c);
                }
                sb = sb2.append(']').toString();
            }
            return sb;
        } finally {
            reentrantLock.unlock();
        }
    }
}
