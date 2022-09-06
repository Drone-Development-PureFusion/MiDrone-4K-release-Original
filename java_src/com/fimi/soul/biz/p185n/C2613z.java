package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p182k.C2526s;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p183l.AbstractC2542o;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.Relation;
import com.fimi.soul.entity.User;
import com.xiaomi.account.openauth.XMAuthericationException;
import java.io.File;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.n.z */
/* loaded from: classes.dex */
public class C2613z implements Handler.Callback {

    /* renamed from: a */
    private static C2613z f9040a = null;

    /* renamed from: b */
    private static final int f9041b = 0;

    /* renamed from: c */
    private static final int f9042c = 1;

    /* renamed from: d */
    private static final int f9043d = 2;

    /* renamed from: e */
    private static final int f9044e = 3;

    /* renamed from: f */
    private static final int f9045f = 4;

    /* renamed from: g */
    private static final int f9046g = 5;

    /* renamed from: h */
    private static final int f9047h = 6;

    /* renamed from: i */
    private static final int f9048i = 7;

    /* renamed from: j */
    private static final int f9049j = 8;

    /* renamed from: k */
    private static final int f9050k = 10;

    /* renamed from: l */
    private static final int f9051l = 11;

    /* renamed from: m */
    private static final int f9052m = 12;

    /* renamed from: n */
    private static final int f9053n = 13;

    /* renamed from: o */
    private static final int f9054o = 14;

    /* renamed from: p */
    private static final int f9055p = 15;

    /* renamed from: q */
    private static final int f9056q = 16;

    /* renamed from: r */
    private static final int f9057r = 17;

    /* renamed from: s */
    private static final int f9058s = 18;

    /* renamed from: t */
    private static final int f9059t = 19;

    /* renamed from: u */
    private AbstractC2542o f9060u;

    /* renamed from: v */
    private C2562f f9061v;

    /* renamed from: w */
    private Handler f9062w;

    /* renamed from: x */
    private HashMap<Integer, AbstractC2538k> f9063x = new HashMap<>();

    /* renamed from: y */
    private Context f9064y;

    /* renamed from: com.fimi.soul.biz.n.z$a */
    /* loaded from: classes.dex */
    class RunnableC2615a implements Runnable {

        /* renamed from: b */
        private int f9067b;

        /* renamed from: c */
        private User f9068c;

        /* renamed from: d */
        private int f9069d;

        /* renamed from: e */
        private String f9070e;

        /* renamed from: f */
        private String f9071f;

        /* renamed from: g */
        private long f9072g;

        /* renamed from: h */
        private long f9073h;

        /* renamed from: i */
        private String f9074i;

        /* renamed from: j */
        private String f9075j;

        public RunnableC2615a(int i, int i2, User user) {
            this.f9067b = i;
            this.f9068c = user;
            this.f9069d = i2;
        }

        public RunnableC2615a(int i, int i2, User user, String str) {
            this.f9067b = i;
            this.f9068c = user;
            this.f9069d = i2;
            this.f9070e = str;
        }

        public RunnableC2615a(int i, String str) {
            this.f9067b = i;
            this.f9075j = str;
        }

        public RunnableC2615a(int i, String str, int i2) {
            this.f9067b = i;
            this.f9075j = str;
            this.f9074i = String.valueOf(i2);
        }

        public RunnableC2615a(int i, String str, long j, long j2, String str2) {
            this.f9067b = i;
            this.f9071f = str;
            this.f9072g = j;
            this.f9074i = str2;
            this.f9073h = j2;
        }

        public RunnableC2615a(int i, String str, String str2) {
            this.f9067b = i;
            this.f9071f = str;
            this.f9074i = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message obtainMessage = C2613z.this.f9062w.obtainMessage();
            PlaneMsg planeMsg = null;
            if (this.f9067b == 0) {
                planeMsg = C2613z.this.f9060u.a(C2613z.this.f9064y);
            } else if (this.f9067b == 1) {
                planeMsg = C2613z.this.f9060u.mo11757a(this.f9068c, C2613z.this.f9064y);
            } else if (this.f9067b == 3) {
                try {
                    planeMsg = C2613z.this.f9060u.mo11754b(C2613z.this.f9064y);
                } catch (XMAuthericationException e) {
                    e.printStackTrace();
                }
            } else if (this.f9067b == 4) {
                planeMsg = C2613z.this.f9060u.mo11753b(this.f9068c, C2613z.this.f9064y);
            } else if (this.f9067b == 5) {
                planeMsg = C2613z.this.f9060u.mo11749c(this.f9068c, C2613z.this.f9064y);
            } else if (this.f9067b == 6) {
                planeMsg = C2613z.this.f9060u.mo11752b(this.f9068c.getUserID(), this.f9069d, C2613z.this.f9064y);
            } else if (this.f9067b == 16) {
                planeMsg = C2613z.this.f9060u.mo11748c(this.f9068c.getUserID(), this.f9069d, C2613z.this.f9064y);
            } else if (this.f9067b == 8) {
                planeMsg = C2613z.this.f9060u.mo11756a(this.f9068c.getNickName(), this.f9069d, C2613z.this.f9064y);
            } else if (this.f9067b == 7) {
                Relation relation = new Relation();
                relation.setUserID(this.f9068c.getUserID());
                relation.setRelationID(this.f9068c.getCountry());
                planeMsg = C2613z.this.f9060u.mo11759a(relation, C2613z.this.f9064y);
            } else if (this.f9067b == 10) {
                planeMsg = C2613z.this.f9060u.mo11745d(this.f9068c, C2613z.this.f9064y);
            } else if (this.f9067b == 11) {
                planeMsg = C2613z.this.f9060u.mo11744e(this.f9068c, C2613z.this.f9064y);
            } else if (this.f9067b == 12) {
                planeMsg = C2613z.this.f9060u.mo11758a(this.f9068c, this.f9069d, this.f9070e, C2613z.this.f9064y);
            } else if (this.f9067b == 13) {
                planeMsg = C2613z.this.f9060u.mo11743f(this.f9068c, C2613z.this.f9064y);
            } else if (this.f9067b == 14) {
                planeMsg = C2613z.this.f9060u.mo11751b(this.f9068c.getUserID(), this.f9068c.getDevice(), C2613z.this.f9064y);
            } else if (this.f9067b == 15) {
                planeMsg = C2613z.this.f9060u.mo11742g(this.f9068c, C2613z.this.f9064y);
            } else if (this.f9067b == 17) {
                planeMsg = C2613z.this.f9060u.mo11746c(this.f9071f, this.f9074i, C2613z.this.f9064y);
            } else if (this.f9067b == 18) {
                planeMsg = C2613z.this.f9060u.mo11747c(this.f9075j, C2613z.this.f9064y);
            } else if (this.f9067b == 19) {
                planeMsg = C2613z.this.f9060u.mo11750c(C2613z.this.f9064y);
            }
            obtainMessage.what = this.f9067b;
            obtainMessage.obj = planeMsg;
            C2613z.this.f9062w.sendMessage(obtainMessage);
        }
    }

    public C2613z(Context context) {
        this.f9064y = null;
        this.f9060u = new C2526s(context);
        this.f9061v = C2562f.m11683a(context);
        this.f9062w = new Handler(context.getMainLooper(), this);
        this.f9064y = context;
    }

    /* renamed from: a */
    public static C2613z m11525a(Context context) {
        if (f9040a == null) {
            f9040a = new C2613z(context.getApplicationContext());
        }
        return f9040a;
    }

    /* renamed from: a */
    public void m11524a(Context context, AbstractC2538k abstractC2538k) {
        this.f9061v.m11679a(new AbstractC2538k() { // from class: com.fimi.soul.biz.n.z.1
            @Override // com.fimi.soul.biz.p183l.AbstractC2538k
            /* renamed from: a */
            public void mo6501a(PlaneMsg planeMsg, File file) {
                C2353b.m12509a("Create fds server" + planeMsg.isSuccess(), C2613z.class);
            }
        });
        this.f9063x.put(3, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(3, 0, (User) null));
    }

    /* renamed from: a */
    public void m11523a(AbstractC2538k abstractC2538k) {
        this.f9063x.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(0, 0, (User) null));
    }

    /* renamed from: a */
    public void m11521a(User user, int i, AbstractC2538k abstractC2538k) {
        this.f9063x.put(11, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(11, 0, user));
    }

    /* renamed from: a */
    public void m11520a(User user, int i, String str, AbstractC2538k abstractC2538k) {
        this.f9063x.put(12, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(12, i, user, str));
    }

    /* renamed from: a */
    public void m11519a(User user, AbstractC2538k abstractC2538k) {
        this.f9063x.put(15, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(15, 0, user));
    }

    /* renamed from: a */
    public void m11518a(String str, int i, AbstractC2538k abstractC2538k) {
        this.f9063x.put(6, abstractC2538k);
        User user = new User();
        user.setUserID(str);
        C2281x.m12702b(new RunnableC2615a(6, i, user));
    }

    /* renamed from: a */
    public void m11517a(String str, AbstractC2538k abstractC2538k) {
        this.f9063x.put(14, abstractC2538k);
        User user = new User();
        user.setUserID(C2353b.m12507c(this.f9064y).getUserID());
        user.setDevice(str);
        C2281x.m12702b(new RunnableC2615a(14, 0, user));
    }

    /* renamed from: a */
    public void m11516a(String str, String str2, AbstractC2538k abstractC2538k) {
        this.f9063x.put(10, abstractC2538k);
        User user = new User();
        user.setUserID(str);
        user.setCountry(str2);
        C2281x.m12702b(new RunnableC2615a(10, 0, user));
    }

    /* renamed from: b */
    public void m11515b(AbstractC2538k abstractC2538k) {
        this.f9063x.put(19, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(19, null));
    }

    /* renamed from: b */
    public void m11513b(User user, AbstractC2538k abstractC2538k) {
        this.f9063x.put(13, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(13, 0, user));
    }

    /* renamed from: b */
    public void m11512b(String str, int i, AbstractC2538k abstractC2538k) {
        this.f9063x.put(16, abstractC2538k);
        User user = new User();
        user.setUserID(str);
        C2281x.m12702b(new RunnableC2615a(16, i, user));
    }

    /* renamed from: b */
    public void m11511b(String str, AbstractC2538k abstractC2538k) {
        this.f9063x.put(18, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(18, str));
    }

    /* renamed from: b */
    public void m11510b(String str, String str2, AbstractC2538k abstractC2538k) {
        this.f9063x.put(7, abstractC2538k);
        User user = new User();
        user.setUserID(str);
        user.setCountry(str2);
        C2281x.m12702b(new RunnableC2615a(7, 0, user));
    }

    /* renamed from: c */
    public void m11508c(User user, AbstractC2538k abstractC2538k) {
        this.f9063x.put(4, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(4, 0, user));
    }

    /* renamed from: c */
    public void m11507c(String str, int i, AbstractC2538k abstractC2538k) {
        this.f9063x.put(8, abstractC2538k);
        User user = new User();
        user.setNickName(str);
        C2281x.m12702b(new RunnableC2615a(8, i, user));
    }

    /* renamed from: c */
    public void m11506c(String str, String str2, AbstractC2538k abstractC2538k) {
        this.f9063x.put(2, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(2, 0, new User()));
    }

    /* renamed from: d */
    public void m11505d(User user, AbstractC2538k abstractC2538k) {
        this.f9063x.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(1, 0, user));
    }

    /* renamed from: d */
    public void m11504d(String str, String str2, AbstractC2538k abstractC2538k) {
        this.f9063x.put(17, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(17, str, str2));
    }

    /* renamed from: e */
    public void m11503e(User user, AbstractC2538k abstractC2538k) {
        this.f9063x.put(5, abstractC2538k);
        C2281x.m12702b(new RunnableC2615a(5, 0, user));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null) {
            this.f9063x.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, null);
            return false;
        }
        return false;
    }
}
