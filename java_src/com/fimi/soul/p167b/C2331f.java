package com.fimi.soul.p167b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.fimi.kernel.p157b.p159b.C2196b;
import com.fimi.kernel.p157b.p159b.C2205c;
import com.fimi.kernel.utils.C2271p;
import com.fimi.kernel.utils.C2274s;
import com.fimi.kernel.utils.C2281x;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.entity.WifiDistanceFile;
import com.fimi.soul.media.gallery.DroneImagePagerActivity;
import com.fimi.soul.media.player.FermiPlayerUtils;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3663at;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.utils.C3710y;
import com.fimi.soul.view.MediaImageLoadingView;
import com.fimi.soul.view.MyGridView;
import com.fimi.soul.view.StrokeDigitalView;
import com.fimi.soul.view.StrokeTextView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* renamed from: com.fimi.soul.b.f */
/* loaded from: classes.dex */
public class C2331f extends BaseAdapter implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public static List<WifiDistanceFile> f7804a;

    /* renamed from: d */
    private int f7807d;

    /* renamed from: e */
    private int f7808e;

    /* renamed from: h */
    private Context f7811h;

    /* renamed from: l */
    private AbstractC2336b f7815l;

    /* renamed from: o */
    private C2657a f7818o;

    /* renamed from: p */
    private C2423d f7819p;

    /* renamed from: q */
    private float f7820q;

    /* renamed from: s */
    private MyGridView f7822s;

    /* renamed from: u */
    private HashMap f7824u;

    /* renamed from: f */
    private boolean f7809f = true;

    /* renamed from: g */
    private boolean f7810g = false;

    /* renamed from: k */
    private EnumC2335a f7814k = EnumC2335a.Normal;

    /* renamed from: m */
    private int f7816m = 0;

    /* renamed from: n */
    private boolean f7817n = false;

    /* renamed from: b */
    ExecutorService f7805b = Executors.newFixedThreadPool(3);

    /* renamed from: v */
    private HashMap<Integer, C2338d> f7825v = new HashMap<>();

    /* renamed from: c */
    Object f7806c = new Object();

    /* renamed from: w */
    private Boolean f7826w = true;

    /* renamed from: x */
    private int f7827x = 0;

    /* renamed from: y */
    private int f7828y = 0;

    /* renamed from: i */
    private List<C2339e> f7812i = new ArrayList();

    /* renamed from: j */
    private List<WifiDistanceFile> f7813j = new ArrayList();

    /* renamed from: r */
    private Set<AsyncTaskC2337c> f7821r = new HashSet();

    /* renamed from: t */
    private C3663at f7823t = C3663at.m7561a();

    /* renamed from: com.fimi.soul.b.f$a */
    /* loaded from: classes.dex */
    public enum EnumC2335a {
        Normal,
        Choose
    }

    /* renamed from: com.fimi.soul.b.f$b */
    /* loaded from: classes.dex */
    public interface AbstractC2336b {
        /* renamed from: a */
        void mo8748a(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.b.f$c */
    /* loaded from: classes.dex */
    public class AsyncTaskC2337c extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: a */
        String f7836a = null;

        /* renamed from: c */
        private String f7838c;

        /* renamed from: d */
        private String f7839d;

        AsyncTaskC2337c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            this.f7839d = strArr[0];
            this.f7838c = strArr[1];
            Bitmap bitmap = null;
            if (!"".equalsIgnoreCase(this.f7839d) && !new File(this.f7838c).exists()) {
                File file = new File(C3681j.m7465n());
                if (file != null && !file.exists()) {
                    file.mkdirs();
                }
                if (FermiPlayerUtils.createRemoteVideoThumbnail(this.f7839d, this.f7838c)) {
                    bitmap = BitmapFactory.decodeFile(this.f7838c);
                }
            } else if (C3710y.m7386c(this.f7838c, C2331f.this.f7811h)) {
                bitmap = ThumbnailUtils.createVideoThumbnail(this.f7838c, 1);
                try {
                    this.f7836a = FermiPlayerUtils.getVideoDurationString(C2331f.this.f7811h, this.f7838c, "mm:ss");
                    if (C2331f.this.m12551b()) {
                        C2331f.this.f7824u.put("getdur_online" + this.f7838c, this.f7836a);
                    } else {
                        C2331f.this.f7824u.put("getdur_local" + this.f7838c, this.f7836a);
                    }
                } catch (Exception e) {
                }
            } else {
                try {
                    bitmap = C2274s.m12827a(C2331f.this.f7811h, this.f7838c, 160);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (bitmap != null) {
                C2331f.this.m12555a(this.f7838c, bitmap);
            }
            return bitmap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        @TargetApi(16)
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            String str = C2331f.this.m12551b() ? "getdur_online" + this.f7838c : "getdur_local" + this.f7838c;
            ImageView imageView = (ImageView) C2331f.this.f7822s.findViewWithTag(this.f7838c);
            TextView textView = (TextView) C2331f.this.f7822s.findViewWithTag(str);
            if (textView != null && this.f7836a != null) {
                textView.setVisibility(0);
                textView.setText((String) C2331f.this.f7824u.get(str));
            } else if (!C2331f.this.m12551b() && textView != null) {
                textView.setVisibility(8);
            }
            Bitmap m12556a = C2331f.this.m12556a(this.f7838c);
            if (m12556a != null && imageView != null) {
                C2331f.this.m12566a(imageView, this.f7838c, m12556a);
            }
            C2331f.this.f7821r.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.fimi.soul.b.f$d */
    /* loaded from: classes.dex */
    public class C2338d {

        /* renamed from: a */
        View f7840a;

        /* renamed from: b */
        SimpleDraweeView f7841b;

        /* renamed from: c */
        ImageView f7842c;

        /* renamed from: d */
        ImageView f7843d;

        /* renamed from: e */
        MediaImageLoadingView f7844e;

        /* renamed from: f */
        StrokeDigitalView f7845f;

        /* renamed from: g */
        ImageView f7846g;

        /* renamed from: h */
        TextView f7847h;

        /* renamed from: i */
        ImageView f7848i;

        /* renamed from: j */
        StrokeTextView f7849j;

        /* renamed from: k */
        WifiDistanceFile f7850k;

        /* renamed from: l */
        int f7851l;

        /* renamed from: m */
        ImageView f7852m;

        protected C2338d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.fimi.soul.b.f$e */
    /* loaded from: classes.dex */
    public class C2339e {

        /* renamed from: a */
        WifiDistanceFile f7854a;

        /* renamed from: b */
        boolean f7855b = false;

        public C2339e(WifiDistanceFile wifiDistanceFile) {
            this.f7854a = wifiDistanceFile;
        }
    }

    public C2331f(Context context, MyGridView myGridView) {
        this.f7824u = null;
        this.f7811h = context;
        this.f7824u = DroidPlannerApp.m12522c();
        this.f7822s = myGridView;
        this.f7820q = C2271p.m12860b(context) < ((float) C2271p.m12871a(context)) ? C2271p.m12860b(context) : C2271p.m12871a(context);
    }

    /* renamed from: a */
    private C2338d m12569a(View view) {
        C2338d c2338d = new C2338d();
        c2338d.f7842c = (ImageView) view.findViewById(C2300R.C2302id.iv_flleType);
        c2338d.f7841b = (SimpleDraweeView) view.findViewById(C2300R.C2302id.iv_thumbnail);
        c2338d.f7843d = (ImageView) view.findViewById(C2300R.C2302id.iv_downloadStatus);
        c2338d.f7844e = (MediaImageLoadingView) view.findViewById(C2300R.C2302id.iv_downloadprogress);
        c2338d.f7852m = (ImageView) view.findViewById(C2300R.C2302id.iv_downloading_mask);
        c2338d.f7845f = (StrokeDigitalView) view.findViewById(C2300R.C2302id.tv_duration);
        c2338d.f7840a = view.findViewById(C2300R.C2302id.v_blackMask);
        c2338d.f7846g = (ImageView) view.findViewById(C2300R.C2302id.iv_selected);
        c2338d.f7847h = (TextView) view.findViewById(C2300R.C2302id.tv_progress);
        c2338d.f7848i = (ImageView) view.findViewById(C2300R.C2302id.mask_iv);
        c2338d.f7849j = (StrokeTextView) view.findViewById(C2300R.C2302id.tv_is_down);
        C3658ar.m7612a(this.f7811h.getAssets(), c2338d.f7847h);
        return c2338d;
    }

    /* renamed from: a */
    private void m12571a(int i, int i2) {
        String path;
        String str;
        for (int i3 = i; i3 < i + i2; i3++) {
            try {
                WifiDistanceFile wifiDistanceFile = this.f7813j.get(i3);
                if (wifiDistanceFile.getDownloadTaskInfo() == null) {
                    if (m12551b() && wifiDistanceFile.getType() == 2) {
                        String name = wifiDistanceFile.getName();
                        String remoteThmUrl = wifiDistanceFile.getRemoteThmUrl();
                        path = C3681j.m7480a(name, wifiDistanceFile.getDateString());
                        str = remoteThmUrl;
                    } else if (wifiDistanceFile.getType() == 1) {
                        path = wifiDistanceFile.getLocalThumbnailPath();
                        str = "";
                    } else {
                        path = wifiDistanceFile.getPath();
                        str = "";
                    }
                    if (path != null) {
                        String replace = path.replace("file://", "");
                        String str2 = "getdur" + replace;
                        Bitmap m12556a = m12556a(replace);
                        String str3 = (String) this.f7824u.get(str2);
                        if (m12556a == null) {
                            AsyncTaskC2337c asyncTaskC2337c = new AsyncTaskC2337c();
                            this.f7821r.add(asyncTaskC2337c);
                            asyncTaskC2337c.executeOnExecutor(this.f7805b, str, replace);
                        } else {
                            ImageView imageView = (ImageView) this.f7822s.findViewWithTag(replace);
                            TextView textView = (TextView) this.f7822s.findViewWithTag(str2);
                            if (!m12551b() && wifiDistanceFile.getType() == 2) {
                                if (textView != null && str3 != null) {
                                    textView.setVisibility(0);
                                    textView.setText((String) this.f7824u.get(str2));
                                } else if (textView != null) {
                                    textView.setVisibility(8);
                                }
                            }
                            if (imageView != null && m12556a != null) {
                                m12566a(imageView, replace, m12556a);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    /* renamed from: a */
    public void m12566a(ImageView imageView, String str, Bitmap bitmap) {
        if (bitmap == null) {
            imageView.setBackgroundResource(C2300R.C2301drawable.friends_sends_pictures_no);
            return;
        }
        imageView.setBackground(C2274s.m12826a(bitmap));
        imageView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    /* renamed from: a */
    public void m12565a(C2196b.EnumC2198a enumC2198a, C2338d c2338d) {
        ImageView imageView = c2338d.f7843d;
        String localDownloadCachePath = c2338d.f7850k.getLocalDownloadCachePath();
        switch (enumC2198a) {
            case Wait:
                c2338d.f7847h.setVisibility(0);
                imageView.setImageResource(C2300R.C2301drawable.download_icon);
                return;
            case Pause:
                c2338d.f7847h.setText(C2300R.C2303string.pasued);
                c2338d.f7847h.setVisibility(0);
                imageView.setImageResource(C2300R.C2301drawable.download_icon);
                return;
            case Error:
                c2338d.f7847h.setText(C2300R.C2303string.down_media_false);
                imageView.setImageResource(C2300R.C2301drawable.continue_icon);
                c2338d.f7844e.m7269b();
                return;
            case Downloading:
                imageView.setImageResource(C2300R.C2301drawable.pause_icon);
                c2338d.f7844e.m7270a();
                Bitmap m12556a = m12556a(localDownloadCachePath);
                if (m12556a != null) {
                    c2338d.f7852m.setVisibility(0);
                    c2338d.f7841b.setBackground(C2274s.m12826a(m12556a));
                } else {
                    c2338d.f7852m.setVisibility(8);
                    c2338d.f7841b.setBackgroundResource(C2300R.C2301drawable.friends_sends_pictures_no);
                }
                imageView.setVisibility(0);
                return;
            case Completed:
                c2338d.f7844e.setVisibility(8);
                c2338d.f7847h.setVisibility(8);
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
                c2338d.f7852m.setVisibility(8);
                return;
            default:
                return;
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private void m12562a(C2338d c2338d, int i, C2196b c2196b) {
        String str;
        String path;
        if (m12551b() && c2338d.f7850k.getType() == 2) {
            String name = c2338d.f7850k.getName();
            String remoteThmUrl = c2338d.f7850k.getRemoteThmUrl();
            String m7480a = C3681j.m7480a(name, c2338d.f7850k.getDateString());
            c2338d.f7850k.setLocalThumbnailPath(m7480a);
            str = remoteThmUrl;
            path = m7480a;
        } else if (!m12551b() && c2196b != null && c2196b.m13262g() != C2196b.EnumC2198a.Completed) {
            str = "";
            path = c2338d.f7850k.getLocalDownloadCachePath();
        } else if (c2338d.f7850k.getType() == 1) {
            str = "";
            path = c2338d.f7850k.getLocalThumbnailPath();
        } else {
            str = "";
            path = c2338d.f7850k.getPath();
        }
        if (path == null) {
            return;
        }
        String replace = path.replace("file://", "");
        String str2 = m12551b() ? "getdur_online" + replace : "getdur_local" + replace;
        if (!m12551b() && c2338d.f7850k.getType() == 2) {
            c2338d.f7845f.setTag(str2);
            String str3 = (String) this.f7824u.get(str2);
            if (str3 != null) {
                c2338d.f7845f.setVisibility(0);
                c2338d.f7845f.setText(str3);
            } else if (c2338d.f7850k.getDurationString() != null) {
                c2338d.f7845f.setVisibility(0);
                c2338d.f7845f.setText(c2338d.f7850k.getDurationString());
            } else {
                c2338d.f7845f.setVisibility(8);
            }
        }
        c2338d.f7841b.setTag(replace);
        c2338d.f7845f.setTag(str2);
        Bitmap m12556a = m12556a(replace);
        if (c2196b == null || c2196b.m13262g() == C2196b.EnumC2198a.Completed) {
            c2338d.f7852m.setVisibility(8);
        } else {
            c2338d.f7852m.setVisibility(0);
        }
        m12566a(c2338d.f7841b, replace, m12556a);
        if (i >= 12 || m12556a != null) {
            return;
        }
        m12554a(replace, c2338d.f7841b);
        AsyncTaskC2337c asyncTaskC2337c = new AsyncTaskC2337c();
        this.f7821r.add(asyncTaskC2337c);
        asyncTaskC2337c.executeOnExecutor(this.f7805b, str, replace);
    }

    @TargetApi(16)
    /* renamed from: a */
    private void m12554a(String str, ImageView imageView) {
        Bitmap m12556a = m12556a(str);
        imageView.setBackground(null);
        if (m12556a != null) {
            imageView.setBackground(C2274s.m12826a(m12556a));
        } else {
            imageView.setBackgroundResource(C2300R.C2301drawable.friends_sends_pictures_no);
        }
    }

    /* renamed from: a */
    public Bitmap m12556a(String str) {
        if (str == null) {
            return null;
        }
        return this.f7823t.mo7560a(str);
    }

    /* renamed from: a */
    public void m12573a() {
        this.f7810g = true;
    }

    /* renamed from: a */
    public void m12572a(int i) {
        this.f7812i.remove(i);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m12570a(int i, C2338d c2338d) {
        boolean z = false;
        if (this.f7814k != EnumC2335a.Choose) {
            return;
        }
        if (i >= 0 && i < this.f7812i.size()) {
            C2339e c2339e = this.f7812i.get(i);
            Log.d("Good", "total " + this.f7812i.size() + " index " + i);
            if (c2339e.f7855b) {
                this.f7816m--;
                c2338d.f7846g.setVisibility(8);
                c2338d.f7848i.setVisibility(8);
            } else {
                this.f7816m++;
                c2338d.f7846g.setVisibility(0);
                c2338d.f7848i.setVisibility(0);
            }
            if (!c2339e.f7855b) {
                z = true;
            }
            c2339e.f7855b = z;
        }
        if (this.f7815l == null) {
            return;
        }
        this.f7815l.mo8748a(this.f7816m);
    }

    /* renamed from: a */
    public void m12568a(AbsListView absListView, int i) {
        if (i != 0) {
            m12536j();
            this.f7826w = false;
            return;
        }
        m12571a(this.f7807d, this.f7808e);
        this.f7826w = true;
        this.f7827x = this.f7807d;
        this.f7828y = this.f7808e;
    }

    /* renamed from: a */
    public void m12567a(AbsListView absListView, int i, int i2, int i3) {
        this.f7807d = i;
        this.f7808e = i2;
        if (this.f7809f && i2 > 0) {
            m12571a(i, i2);
            this.f7809f = false;
        }
        if (!this.f7826w.booleanValue() || this.f7827x + this.f7828y >= this.f7807d + this.f7808e) {
            return;
        }
        this.f7827x = this.f7807d;
        this.f7828y = this.f7808e;
        m12571a(this.f7807d, this.f7808e);
    }

    /* renamed from: a */
    public void m12564a(EnumC2335a enumC2335a) {
        this.f7814k = enumC2335a;
    }

    /* renamed from: a */
    public void m12563a(AbstractC2336b abstractC2336b) {
        this.f7815l = abstractC2336b;
    }

    /* renamed from: a */
    public void m12558a(C2657a c2657a) {
        this.f7818o = c2657a;
    }

    /* renamed from: a */
    public void m12557a(WifiDistanceFile wifiDistanceFile) {
        if (!this.f7813j.contains(wifiDistanceFile)) {
            this.f7813j.add(wifiDistanceFile);
            this.f7812i.add(new C2339e(wifiDistanceFile));
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m12555a(String str, Bitmap bitmap) {
        if (m12556a(str) == null) {
            this.f7823t.mo7558a(str, bitmap);
        }
    }

    /* renamed from: a */
    public void m12553a(List<WifiDistanceFile> list) {
        ArrayList arrayList = new ArrayList();
        for (WifiDistanceFile wifiDistanceFile : list) {
            arrayList.add(new C2339e(wifiDistanceFile));
        }
        this.f7812i = arrayList;
        this.f7813j = list;
    }

    /* renamed from: a */
    public void m12552a(boolean z) {
        this.f7817n = z;
    }

    /* renamed from: b */
    public void m12549b(WifiDistanceFile wifiDistanceFile) {
        if (this.f7813j.contains(wifiDistanceFile)) {
            int indexOf = this.f7813j.indexOf(wifiDistanceFile);
            this.f7813j.remove(indexOf);
            this.f7812i.remove(indexOf);
        }
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public void m12548b(String str) {
        Iterator<C2339e> it2 = this.f7812i.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            C2339e next = it2.next();
            if (next.f7854a.getPath().equals(str)) {
                this.f7812i.remove(next);
                break;
            }
        }
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public boolean m12551b() {
        return this.f7817n;
    }

    /* renamed from: c */
    public List<WifiDistanceFile> m12547c() {
        ArrayList arrayList = new ArrayList();
        for (C2339e c2339e : this.f7812i) {
            if (c2339e.f7855b) {
                arrayList.add(c2339e.f7854a);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public void m12545c(WifiDistanceFile wifiDistanceFile) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f7813j.size()) {
                if (wifiDistanceFile.getName().equals(this.f7813j.get(i2).getName())) {
                    this.f7813j.remove(i2);
                    this.f7812i.remove(i2);
                    notifyDataSetChanged();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    public List<WifiDistanceFile> m12544d() {
        return this.f7813j;
    }

    /* renamed from: e */
    public EnumC2335a m12542e() {
        return this.f7814k;
    }

    /* renamed from: f */
    public void m12540f() {
        for (C2339e c2339e : this.f7812i) {
            c2339e.f7855b = true;
        }
        this.f7816m = this.f7812i.size();
        if (this.f7815l != null) {
            this.f7815l.mo8748a(this.f7816m);
        }
        notifyDataSetChanged();
    }

    /* renamed from: g */
    public void m12539g() {
        for (C2339e c2339e : this.f7812i) {
            c2339e.f7855b = false;
        }
        this.f7816m = 0;
        if (this.f7815l != null) {
            this.f7815l.mo8748a(this.f7816m);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7812i != null) {
            return this.f7812i.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7812i.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @TargetApi(16)
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2338d c2338d;
        this.f7822s = (MyGridView) viewGroup;
        C2339e c2339e = this.f7812i.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f7811h).inflate(C2300R.layout.item_thumbnail_info, (ViewGroup) null);
            c2338d = m12569a(view);
            c2338d.f7850k = c2339e.f7854a;
            view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) (((this.f7820q - C2271p.m12870a(this.f7811h, 50.0f)) - (4.0f * C2271p.m12870a(this.f7811h, 5.0f))) / 3.0f)));
            view.setTag(c2338d);
        } else {
            c2338d = (C2338d) view.getTag();
        }
        c2338d.f7851l = i;
        final C2196b downloadTaskInfo = c2339e.f7854a.getDownloadTaskInfo();
        if (!this.f7810g) {
            this.f7825v.put(Integer.valueOf(i), c2338d);
        }
        if (!this.f7817n) {
            if (downloadTaskInfo != null) {
                downloadTaskInfo.m13280a(Integer.valueOf(i));
                downloadTaskInfo.m13289a(new C2196b.AbstractC2202d() { // from class: com.fimi.soul.b.f.1
                    @Override // com.fimi.kernel.p157b.p159b.C2196b.AbstractC2202d
                    /* renamed from: a */
                    public void mo10038a(C2196b.EnumC2198a enumC2198a, C2196b c2196b) {
                        if (c2196b.m13256j() != null) {
                            int intValue = ((Integer) c2196b.m13256j()).intValue();
                            C2338d c2338d2 = (C2338d) C2331f.this.f7825v.get(Integer.valueOf(intValue));
                            if (c2338d2.f7851l != intValue) {
                                return;
                            }
                            C2205c m13235a = C2205c.m13235a(C2331f.this.f7811h);
                            if (enumC2198a == C2196b.EnumC2198a.Error) {
                                if (c2196b == null) {
                                    return;
                                }
                                m13235a.m13226c();
                                C2331f.this.m12565a(enumC2198a, c2338d2);
                                return;
                            }
                            long m13254k = c2196b.m13254k() / (c2196b.m13258i() / 100);
                            String replace = c2338d2.f7847h.getText().toString().substring(3).replace("%", "");
                            if (!C3658ar.m7583e(replace) || replace.equals("")) {
                                c2338d2.f7847h.setText(String.format(C2331f.this.f7811h.getString(C2300R.C2303string.downing_media), m13254k + "%"));
                                c2338d2.f7844e.setVisibility(0);
                                c2338d2.f7844e.setSweepAngle((float) m13254k);
                                C2331f.this.m12565a(enumC2198a, c2338d2);
                                return;
                            }
                            long parseLong = Long.parseLong(replace);
                            if (c2196b.m13262g() != C2196b.EnumC2198a.Completed) {
                                if (parseLong == m13254k) {
                                    return;
                                }
                                if (c2196b.m13294a() != null) {
                                    c2338d2.f7845f.setVisibility(0);
                                    c2338d2.f7845f.setText(c2196b.m13294a());
                                }
                                c2338d2.f7847h.setVisibility(0);
                                c2338d2.f7847h.setText(String.format(C2331f.this.f7811h.getString(C2300R.C2303string.downing_media), m13254k + "%"));
                                c2338d2.f7844e.setVisibility(0);
                                c2338d2.f7844e.setSweepAngle((float) m13254k);
                                C2331f.this.m12565a(enumC2198a, c2338d2);
                                return;
                            }
                            C2331f.this.m12565a(c2196b.m13262g(), c2338d2);
                            if (c2196b.m13248n() != null) {
                                String replace2 = c2196b.m13260h().replace("file://", "");
                                C2331f.this.m12555a(replace2, c2196b.m13248n());
                                C2331f.this.m12566a(c2338d2.f7841b, replace2, c2196b.m13248n());
                                if (c2196b.m13294a() != null) {
                                    C2331f.this.f7824u.put("getdur_local" + replace2, c2196b.m13294a());
                                    c2338d2.f7845f.setVisibility(0);
                                    c2338d2.f7845f.setText(c2196b.m13294a());
                                }
                            }
                            m13235a.m13233a(c2196b);
                            m13235a.m13236a();
                        }
                    }
                });
            }
        } else if (!C2379b.m12395c(c2339e.f7854a.getName())) {
            c2338d.f7849j.setVisibility(0);
            c2338d.f7849j.setText(this.f7811h.getString(C2300R.C2303string.no_down));
        } else {
            c2338d.f7849j.setVisibility(8);
        }
        if (c2339e.f7855b) {
            c2338d.f7846g.setVisibility(0);
            c2338d.f7848i.setVisibility(0);
        } else {
            c2338d.f7846g.setVisibility(8);
            c2338d.f7848i.setVisibility(8);
        }
        c2338d.f7850k = c2339e.f7854a;
        c2338d.f7842c.setVisibility(8);
        c2338d.f7845f.setVisibility(4);
        c2338d.f7843d.setVisibility(4);
        c2338d.f7844e.setVisibility(4);
        c2338d.f7841b.setBackgroundResource(C2300R.C2301drawable.friends_sends_pictures_no);
        c2338d.f7841b.invalidate();
        c2338d.f7841b.setTag(null);
        c2338d.f7847h.setVisibility(4);
        if (downloadTaskInfo != null) {
            c2338d.f7843d.setVisibility(0);
            c2338d.f7844e.setVisibility(0);
            long m13254k = downloadTaskInfo.m13254k() / (downloadTaskInfo.m13258i() / 100);
            c2338d.f7847h.setVisibility(0);
            c2338d.f7844e.setSweepAngle((float) m13254k);
            c2338d.f7847h.setText(String.format(this.f7811h.getString(C2300R.C2303string.downing_media), m13254k + "%"));
            if (m13254k == 100) {
                downloadTaskInfo.m13264f();
            }
            String localDownloadCachePath = c2338d.f7850k.getLocalDownloadCachePath();
            switch (downloadTaskInfo.m13262g()) {
                case Wait:
                case Downloading:
                    Bitmap m12556a = m12556a(localDownloadCachePath);
                    if (m12556a != null) {
                        c2338d.f7852m.setVisibility(0);
                        c2338d.f7841b.setBackground(C2274s.m12826a(m12556a));
                    } else {
                        c2338d.f7852m.setVisibility(8);
                        c2338d.f7841b.setBackgroundResource(C2300R.C2301drawable.friends_sends_pictures_no);
                    }
                    c2338d.f7843d.setImageResource(C2300R.C2301drawable.pause_icon);
                    c2338d.f7844e.m7270a();
                    break;
                case Pause:
                    c2338d.f7847h.setText(C2300R.C2303string.pasued);
                    c2338d.f7843d.setImageResource(C2300R.C2301drawable.download_icon);
                    c2338d.f7844e.m7270a();
                    break;
                case Error:
                    Bitmap m12556a2 = m12556a(localDownloadCachePath);
                    if (m12556a2 != null) {
                        c2338d.f7852m.setVisibility(0);
                        c2338d.f7841b.setBackground(C2274s.m12826a(m12556a2));
                    } else {
                        c2338d.f7852m.setVisibility(8);
                        c2338d.f7841b.setBackgroundResource(C2300R.C2301drawable.friends_sends_pictures_no);
                    }
                    c2338d.f7847h.setText(C2300R.C2303string.down_media_false);
                    c2338d.f7843d.setImageResource(C2300R.C2301drawable.continue_icon);
                    c2338d.f7844e.m7269b();
                    break;
                case Completed:
                    c2338d.f7843d.setVisibility(8);
                    c2338d.f7844e.setVisibility(8);
                    c2338d.f7847h.setVisibility(8);
                    c2339e.f7854a.setDownloadTaskInfo(null);
                    m12562a(c2338d, i, downloadTaskInfo);
                    C2281x.m12704a(new Runnable() { // from class: com.fimi.soul.b.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            C2205c.m13235a(C2331f.this.f7811h).m13233a(downloadTaskInfo);
                        }
                    });
                    break;
            }
        }
        if (c2338d.f7850k.getType() == 2) {
            c2338d.f7842c.setVisibility(0);
            if (c2338d.f7850k.getDurationString() != null) {
                c2338d.f7845f.setVisibility(0);
                c2338d.f7845f.setText(c2338d.f7850k.getDurationString());
            } else {
                c2338d.f7845f.setVisibility(8);
            }
        }
        if (this.f7810g) {
            this.f7810g = false;
        } else {
            m12562a(c2338d, i, downloadTaskInfo);
        }
        return view;
    }

    /* renamed from: h */
    public void m12538h() {
        this.f7813j.clear();
        this.f7812i.clear();
        notifyDataSetChanged();
    }

    /* renamed from: i */
    protected C2423d m12537i() {
        if (this.f7819p == null) {
            this.f7819p = (C2423d) C2379b.m12410a().m12394d();
        }
        return this.f7819p;
    }

    /* renamed from: j */
    public void m12536j() {
        if (this.f7821r != null) {
            for (AsyncTaskC2337c asyncTaskC2337c : this.f7821r) {
                asyncTaskC2337c.cancel(false);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f7817n && !m12537i().e()) {
            C2284z.m12696a(this.f7811h, (int) C2300R.C2303string.no_connect_camera, C2284z.f7606b);
            return;
        }
        f7804a = new ArrayList();
        C2338d c2338d = (C2338d) view.getTag();
        if (this.f7814k == EnumC2335a.Choose) {
            m12570a(i, c2338d);
            return;
        }
        C2339e c2339e = this.f7812i.get(i);
        C2196b downloadTaskInfo = c2339e.f7854a.getDownloadTaskInfo();
        if (downloadTaskInfo != null && downloadTaskInfo.m13262g() != C2196b.EnumC2198a.Completed) {
            switch (downloadTaskInfo.m13262g()) {
                case Wait:
                    downloadTaskInfo.m13267e();
                    c2338d.f7847h.setText(this.f7811h.getResources().getString(C2300R.C2303string.pasued));
                    c2338d.f7843d.setImageResource(C2300R.C2301drawable.download_icon);
                    c2338d.f7844e.m7270a();
                    return;
                case Pause:
                case Error:
                    long m13254k = downloadTaskInfo.m13254k() / (downloadTaskInfo.m13258i() / 100);
                    Log.d("Good", "执行点击事件" + downloadTaskInfo.m13262g());
                    if (C2205c.m13235a(this.f7811h).m13228b() < 3) {
                        downloadTaskInfo.m13273c();
                    } else {
                        downloadTaskInfo.m13270d();
                    }
                    c2338d.f7843d.setImageResource(C2300R.C2301drawable.pause_icon);
                    c2338d.f7844e.m7270a();
                    c2338d.f7847h.setText(String.format(this.f7811h.getString(C2300R.C2303string.downing_media), m13254k + "%"));
                    return;
                case Downloading:
                    Log.d("Good", "执行点击事件->停止");
                    downloadTaskInfo.m13267e();
                    c2338d.f7847h.setText(this.f7811h.getResources().getString(C2300R.C2303string.pasued));
                    c2338d.f7843d.setImageResource(C2300R.C2301drawable.download_icon);
                    c2338d.f7844e.m7270a();
                    C2205c.m13235a(this.f7811h).m13226c();
                    return;
                default:
                    return;
            }
        }
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Intent intent = new Intent(this.f7811h, DroneImagePagerActivity.class);
            int i2 = 0;
            int i3 = i;
            while (i2 < this.f7812i.size()) {
                C2339e c2339e2 = this.f7812i.get(i2);
                if (this.f7817n) {
                    if (c2339e2.f7854a.getType() == 2) {
                        arrayList.add(c2339e2.f7854a.getRemoteThmUrl() + "&&" + c2339e2.f7854a.getRemoteUrl());
                        arrayList3.add(c2339e2.f7854a.getDurationString());
                    } else {
                        arrayList.add(c2339e2.f7854a.getRemoteUrl());
                        arrayList3.add("");
                    }
                    arrayList2.add(c2339e2.f7854a.getLocalThumbnailPath());
                    f7804a.add(this.f7812i.get(i2).f7854a);
                    intent.putExtra(DroneImagePagerActivity.f11149d, true);
                } else {
                    C2196b downloadTaskInfo2 = c2339e2.f7854a.getDownloadTaskInfo();
                    if (downloadTaskInfo2 != null && downloadTaskInfo2.m13262g() == C2196b.EnumC2198a.Completed) {
                        arrayList.add(c2339e2.f7854a.getLocalThumbnailPath());
                        arrayList2.add(c2339e2.f7854a.getPath());
                    }
                    if (downloadTaskInfo2 == null) {
                        arrayList.add(c2339e2.f7854a.getLocalThumbnailPath());
                        arrayList2.add(c2339e2.f7854a.getPath());
                    }
                    intent.putExtra(DroneImagePagerActivity.f11149d, false);
                }
                i2++;
                i3 = c2339e.f7854a == c2339e2.f7854a ? arrayList.size() - 1 : i3;
            }
            intent.putExtra("image_urls", arrayList);
            intent.putExtra(DroneImagePagerActivity.f11150e, arrayList2);
            intent.putExtra("image_index", i3);
            intent.putExtra(DroneImagePagerActivity.f11147b, c2339e.f7854a.getType());
            intent.putExtra(DroneImagePagerActivity.f11151f, arrayList3);
            ((Activity) this.f7811h).startActivityForResult(intent, 0);
            ((Activity) this.f7811h).overridePendingTransition(17432576, 17432577);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }
}
