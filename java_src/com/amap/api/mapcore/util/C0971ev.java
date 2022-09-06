package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* renamed from: com.amap.api.mapcore.util.ev */
/* loaded from: classes.dex */
public class C0971ev implements LBSTraceBase {

    /* renamed from: a */
    private Context f3031a;

    /* renamed from: c */
    private TraceListener f3033c;

    /* renamed from: d */
    private CoordinateConverter f3034d;

    /* renamed from: b */
    private HandlerC0973b f3032b = new HandlerC0973b(this);

    /* renamed from: e */
    private ExecutorService f3035e = Executors.newFixedThreadPool((Runtime.getRuntime().availableProcessors() * 2) + 3);

    /* renamed from: com.amap.api.mapcore.util.ev$a */
    /* loaded from: classes.dex */
    class RunnableC0972a implements Runnable {

        /* renamed from: b */
        private List<TraceLocation> f3037b = new ArrayList();

        /* renamed from: c */
        private int f3038c;

        /* renamed from: d */
        private int f3039d;

        /* renamed from: e */
        private List<TraceLocation> f3040e;

        public RunnableC0972a(int i, List<TraceLocation> list, int i2) {
            this.f3038c = i2;
            this.f3039d = i;
            this.f3040e = list;
        }

        /* renamed from: a */
        private int m18181a() {
            if (this.f3040e == null || this.f3040e.size() == 0) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (TraceLocation traceLocation : this.f3040e) {
                if (traceLocation != null) {
                    if (traceLocation.getSpeed() < 0.01d) {
                        arrayList.add(traceLocation);
                    } else {
                        arrayList.clear();
                        i = m18179a(arrayList) + i;
                    }
                }
            }
            return i;
        }

        /* renamed from: a */
        private int m18179a(List<TraceLocation> list) {
            int size = list.size();
            if (size <= 1) {
                return 0;
            }
            TraceLocation traceLocation = list.get(0);
            TraceLocation traceLocation2 = list.get(size - 1);
            if (traceLocation == null || traceLocation2 == null) {
                return 0;
            }
            return (traceLocation == null || traceLocation2 == null) ? 0 : (int) ((traceLocation2.getTime() - traceLocation.getTime()) / 1000);
        }

        /* renamed from: a */
        private void m18180a(String str) {
            Message obtainMessage = C0971ev.this.f3032b.obtainMessage();
            obtainMessage.obj = str;
            obtainMessage.what = 102;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.f3039d);
            obtainMessage.setData(bundle);
            C0971ev.this.f3032b.sendMessage(obtainMessage);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int m18181a = m18181a();
                ArrayList arrayList = new ArrayList();
                if (this.f3040e == null || this.f3040e.size() == 0) {
                    m18180a("轨迹点太少或距离太近,轨迹纠偏失败");
                    return;
                }
                for (TraceLocation traceLocation : this.f3040e) {
                    TraceLocation copy = traceLocation.copy();
                    if (copy != null && copy.getLatitude() > 0.0d && copy.getLongitude() > 0.0d) {
                        this.f3037b.add(copy);
                    }
                }
                this.f3037b = C0974ew.m18176a(this.f3037b, 1.0f);
                int i = 0;
                int i2 = 0;
                while (this.f3037b.size() > 0) {
                    Message obtainMessage = C0971ev.this.f3032b.obtainMessage();
                    ArrayList arrayList2 = new ArrayList();
                    int size = this.f3037b.size();
                    int size2 = size > 503 ? 500 : (size > 503 || size <= 500) ? this.f3037b.size() : 3;
                    for (int i3 = 0; i3 < size2; i3++) {
                        TraceLocation remove = this.f3037b.remove(0);
                        if (remove != null) {
                            if (this.f3038c != 1) {
                                if (this.f3038c == 3) {
                                    C0971ev.this.f3034d.from(CoordinateConverter.CoordType.BAIDU);
                                } else if (this.f3038c == 2) {
                                    C0971ev.this.f3034d.from(CoordinateConverter.CoordType.GPS);
                                }
                                C0971ev.this.f3034d.coord(new LatLng(remove.getLatitude(), remove.getLongitude()));
                                LatLng convert = C0971ev.this.f3034d.convert();
                                if (convert != null) {
                                    remove.setLatitude(convert.latitude);
                                    remove.setLongitude(convert.longitude);
                                }
                            }
                            arrayList2.add(remove);
                        }
                    }
                    if (arrayList2.size() >= 2 && arrayList2.size() <= 500) {
                        C0970eu c0970eu = new C0970eu(C0971ev.this.f3031a, arrayList2, this.f3038c);
                        new ArrayList();
                        try {
                            List<LatLng> d = c0970eu.d();
                            arrayList.addAll(d);
                            obtainMessage.obj = d;
                            obtainMessage.what = 100;
                            obtainMessage.arg1 = i;
                            Bundle bundle = new Bundle();
                            bundle.putInt("lineID", this.f3039d);
                            obtainMessage.setData(bundle);
                            int i4 = i + 1;
                            int i5 = i2 + 1;
                            C0971ev.this.f3032b.sendMessage(obtainMessage);
                            try {
                                Thread.sleep(50L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            i2 = i5;
                            i = i4;
                        } catch (C0966eq e2) {
                            m18180a(e2.m18199a());
                            return;
                        }
                    }
                }
                if (i2 <= 0) {
                    m18180a("轨迹点太少或距离太近,轨迹纠偏失败");
                    return;
                }
                int m18189a = C0969et.m18189a(arrayList);
                Message obtainMessage2 = C0971ev.this.f3032b.obtainMessage();
                obtainMessage2.obj = arrayList;
                obtainMessage2.what = 101;
                obtainMessage2.arg1 = m18189a;
                obtainMessage2.arg2 = m18181a;
                Bundle bundle2 = new Bundle();
                bundle2.putInt("lineID", this.f3039d);
                obtainMessage2.setData(bundle2);
                C0971ev.this.f3032b.sendMessage(obtainMessage2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.ev$b */
    /* loaded from: classes.dex */
    public static class HandlerC0973b extends Handler {

        /* renamed from: a */
        WeakReference<C0971ev> f3041a;

        /* renamed from: b */
        C0971ev f3042b;

        public HandlerC0973b(C0971ev c0971ev) {
            m18178a(c0971ev);
        }

        /* renamed from: a */
        private void m18178a(C0971ev c0971ev) {
            this.f3041a = new WeakReference<>(c0971ev);
            this.f3042b = this.f3041a.get();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data;
            try {
                if (this.f3042b != null && this.f3042b.f3033c != null && (data = message.getData()) != null) {
                    int i = data.getInt("lineID");
                    switch (message.what) {
                        case 100:
                            this.f3042b.f3033c.onTraceProcessing(i, message.arg1, (List) message.obj);
                            break;
                        case 101:
                            this.f3042b.f3033c.onFinished(i, (List) message.obj, message.arg1, message.arg2);
                            break;
                        case 102:
                            this.f3042b.f3033c.onRequestFailed(i, (String) message.obj);
                            break;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public C0971ev(Context context) {
        this.f3031a = context.getApplicationContext();
        this.f3034d = new CoordinateConverter(this.f3031a);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
        this.f3033c = traceListener;
        this.f3035e.execute(new RunnableC0972a(i, list, i2));
    }
}
