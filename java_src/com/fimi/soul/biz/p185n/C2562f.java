package com.fimi.soul.biz.p185n;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p182k.C2512f;
import com.fimi.soul.biz.p182k.C2513g;
import com.fimi.soul.biz.p182k.C2515h;
import com.fimi.soul.biz.p183l.AbstractC2532e;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.entity.FdsMsg;
import com.fimi.soul.entity.PlaneMsg;
import com.xiaomi.infra.galaxy.fds.android.model.ObjectMetadata;
import com.xiaomi.infra.galaxy.fds.android.model.ProgressListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: com.fimi.soul.biz.n.f */
/* loaded from: classes.dex */
public class C2562f implements Handler.Callback, C2513g.AbstractC2514a {

    /* renamed from: a */
    private static C2562f f8815a = null;

    /* renamed from: b */
    private static final int f8816b = 0;

    /* renamed from: c */
    private static final int f8817c = 1;

    /* renamed from: d */
    private static final int f8818d = 2;

    /* renamed from: e */
    private static final int f8819e = 3;

    /* renamed from: f */
    private static final int f8820f = 4;

    /* renamed from: g */
    private static final int f8821g = 5;

    /* renamed from: i */
    private C2513g f8823i;

    /* renamed from: j */
    private Handler f8824j;

    /* renamed from: l */
    private Context f8826l;

    /* renamed from: h */
    private List<C2515h> f8822h = new CopyOnWriteArrayList();

    /* renamed from: k */
    private HashMap<Integer, AbstractC2538k> f8825k = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.biz.n.f$a */
    /* loaded from: classes.dex */
    public class RunnableC2563a extends ProgressListener implements Runnable {

        /* renamed from: a */
        ObjectMetadata f8827a;

        /* renamed from: b */
        int f8828b;

        /* renamed from: d */
        private InputStream f8830d;

        /* renamed from: e */
        private File f8831e;

        public RunnableC2563a(int i, InputStream inputStream, File file, ObjectMetadata objectMetadata) {
            this.f8828b = i;
            this.f8830d = inputStream;
            this.f8831e = file;
            this.f8827a = objectMetadata;
        }

        @Override // com.xiaomi.infra.galaxy.fds.android.model.ProgressListener
        public void onProgress(long j, long j2) {
            FdsMsg fdsMsg = new FdsMsg();
            fdsMsg.setTotal(j2);
            fdsMsg.setTransferred(j);
            if (this.f8831e != null) {
                fdsMsg.setFilePath(this.f8831e.getAbsolutePath());
            }
            Message obtainMessage = C2562f.this.f8824j.obtainMessage();
            obtainMessage.what = this.f8828b;
            obtainMessage.obj = fdsMsg;
            Bundle bundle = new Bundle();
            if (this.f8831e != null) {
                bundle.putString("file_path", this.f8831e.getAbsolutePath());
            }
            obtainMessage.setData(bundle);
            C2562f.this.f8824j.sendMessageDelayed(obtainMessage, 200L);
        }

        @Override // java.lang.Runnable
        public void run() {
            PlaneMsg planeMsg;
            Message obtainMessage = C2562f.this.f8824j.obtainMessage();
            if (this.f8828b == 0) {
                planeMsg = C2562f.this.f8823i.m11822a(this.f8831e);
            } else if (this.f8828b == 1) {
                planeMsg = C2562f.this.f8823i.m11820a(this.f8830d, this.f8827a);
            } else if (this.f8828b == 2) {
                planeMsg = C2562f.this.f8823i.m11824a();
            } else if (this.f8828b == 3) {
                planeMsg = C2562f.this.f8823i.m11819a(this.f8830d, this.f8827a, this);
            } else if (this.f8828b == 4) {
                planeMsg = C2562f.this.f8823i.m11817b(this.f8831e, this);
            } else {
                if (this.f8828b == 5 && C2562f.this.f8822h != null && C2562f.this.f8822h.size() > 0) {
                    for (C2515h c2515h : C2562f.this.f8822h) {
                        if (c2515h.f8711j.getName().equals(this.f8831e.getName())) {
                            FdsMsg fdsMsg = new FdsMsg();
                            PlaneMsg planeMsg2 = new PlaneMsg();
                            C2512f m11804e = c2515h.m11804e();
                            if (m11804e != null) {
                                fdsMsg.setBucketName(C2353b.f7956n);
                                fdsMsg.setObjectName(m11804e.m11827c());
                                fdsMsg.setUrl(m11804e.m11825d());
                                planeMsg2.setSuccess(true);
                                planeMsg2.setData(fdsMsg);
                                planeMsg2.setFile(this.f8831e);
                                planeMsg = planeMsg2;
                            } else {
                                planeMsg2.setSuccess(false);
                                planeMsg = planeMsg2;
                            }
                        }
                    }
                }
                planeMsg = null;
            }
            obtainMessage.what = this.f8828b;
            obtainMessage.obj = planeMsg;
            C2562f.this.f8824j.sendMessage(obtainMessage);
        }
    }

    public C2562f(Context context) {
        this.f8826l = null;
        this.f8823i = new C2513g(context);
        this.f8824j = new Handler(context.getMainLooper(), this);
        this.f8826l = context;
        this.f8823i.m11823a(this);
    }

    /* renamed from: a */
    public static C2562f m11683a(Context context) {
        if (f8815a == null) {
            f8815a = new C2562f(context);
        }
        return f8815a;
    }

    /* renamed from: a */
    public void m11684a() {
        if (this.f8822h == null || this.f8822h.size() <= 0) {
            return;
        }
        for (C2515h c2515h : this.f8822h) {
            c2515h.m11805d();
        }
        this.f8822h.clear();
    }

    /* renamed from: a */
    public void m11682a(Bitmap bitmap, AbstractC2532e abstractC2532e) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(byteArrayOutputStream.toByteArray().length);
        m11674a((InputStream) byteArrayInputStream, objectMetadata, abstractC2532e);
    }

    /* renamed from: a */
    public void m11681a(Bitmap bitmap, AbstractC2538k abstractC2538k) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(byteArrayOutputStream.toByteArray().length);
        m11673a(byteArrayInputStream, objectMetadata, abstractC2538k);
    }

    @Override // com.fimi.soul.biz.p182k.C2513g.AbstractC2514a
    /* renamed from: a */
    public void mo11680a(C2515h c2515h) {
        this.f8822h.add(c2515h);
    }

    /* renamed from: a */
    public void m11679a(AbstractC2538k abstractC2538k) {
        this.f8825k.put(2, abstractC2538k);
        C2281x.m12702b(new RunnableC2563a(2, null, null, null));
    }

    /* renamed from: a */
    public void m11677a(File file) {
        if (this.f8822h == null || this.f8822h.size() <= 0) {
            return;
        }
        for (C2515h c2515h : this.f8822h) {
            if (c2515h.f8711j.getName().equals(file.getName())) {
                c2515h.m11806c();
                return;
            }
        }
    }

    /* renamed from: a */
    public void m11676a(File file, AbstractC2532e abstractC2532e) {
        this.f8825k.put(4, abstractC2532e);
        C2281x.m12702b(new RunnableC2563a(4, null, file, null));
    }

    /* renamed from: a */
    public void m11675a(File file, AbstractC2538k abstractC2538k) {
        this.f8825k.put(0, abstractC2538k);
        C2281x.m12702b(new RunnableC2563a(0, null, file, null));
    }

    /* renamed from: a */
    public void m11674a(InputStream inputStream, ObjectMetadata objectMetadata, AbstractC2532e abstractC2532e) {
        this.f8825k.put(3, abstractC2532e);
        C2281x.m12702b(new RunnableC2563a(3, inputStream, null, objectMetadata));
    }

    /* renamed from: a */
    public void m11673a(InputStream inputStream, ObjectMetadata objectMetadata, AbstractC2538k abstractC2538k) {
        this.f8825k.put(1, abstractC2538k);
        C2281x.m12702b(new RunnableC2563a(1, inputStream, null, objectMetadata));
    }

    /* renamed from: b */
    public void m11671b(File file) {
        if (this.f8822h == null || this.f8822h.size() <= 0) {
            return;
        }
        for (C2515h c2515h : this.f8822h) {
            if (c2515h.f8711j.getName().equals(file.getName())) {
                c2515h.m11805d();
                this.f8822h.remove(c2515h);
                return;
            }
        }
    }

    /* renamed from: b */
    public void m11670b(File file, AbstractC2538k abstractC2538k) {
        this.f8825k.put(5, abstractC2538k);
        C2281x.m12702b(new RunnableC2563a(5, null, file, null));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.obj != null && (message.obj instanceof PlaneMsg)) {
            this.f8825k.get(Integer.valueOf(message.what)).mo6501a((PlaneMsg) message.obj, ((PlaneMsg) message.obj).getFile());
            return false;
        } else if (message.obj == null || !(message.obj instanceof FdsMsg)) {
            return false;
        } else {
            ((AbstractC2532e) this.f8825k.get(Integer.valueOf(message.what))).mo9725a(((FdsMsg) message.obj).getTransferred(), ((FdsMsg) message.obj).getTotal(), ((FdsMsg) message.obj).getFilePath());
            return false;
        }
    }
}
