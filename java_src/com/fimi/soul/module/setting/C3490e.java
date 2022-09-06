package com.fimi.soul.module.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p185n.AbstractC2564g;
import com.fimi.soul.biz.p185n.C2602v;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.utils.C3696t;
import com.fimi.soul.view.ImageLoadingView;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.List;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.module.setting.e */
/* loaded from: classes.dex */
public class C3490e extends BaseAdapter implements AbstractC2564g, C2602v.AbstractC2606b {

    /* renamed from: a */
    Context f13757a;

    /* renamed from: b */
    List<C3495f> f13758b;

    /* renamed from: c */
    C2602v f13759c;

    /* renamed from: d */
    ListView f13760d;

    /* renamed from: e */
    boolean f13761e = false;

    /* renamed from: f */
    boolean f13762f = false;

    /* renamed from: g */
    C3494c f13763g;

    /* renamed from: h */
    private long f13764h;

    /* renamed from: i */
    private EnumC3492a f13765i;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.module.setting.e$a */
    /* loaded from: classes.dex */
    public enum EnumC3492a {
        HeadView,
        BodyView
    }

    /* renamed from: com.fimi.soul.module.setting.e$b */
    /* loaded from: classes.dex */
    class C3493b {

        /* renamed from: a */
        TextView f13771a;

        C3493b() {
        }
    }

    /* renamed from: com.fimi.soul.module.setting.e$c */
    /* loaded from: classes.dex */
    class C3494c {

        /* renamed from: a */
        TextView f13773a;

        /* renamed from: b */
        TextView f13774b;

        /* renamed from: c */
        TextView f13775c;

        /* renamed from: d */
        ImageLoadingView f13776d;

        /* renamed from: e */
        ImageView f13777e;

        /* renamed from: f */
        ImageView f13778f;

        /* renamed from: g */
        ImageView f13779g;

        /* renamed from: h */
        RelativeLayout f13780h;

        C3494c() {
        }
    }

    public C3490e(Context context, List<C3495f> list, ListView listView) {
        this.f13757a = context;
        this.f13758b = list;
        this.f13760d = listView;
        this.f13759c = C2602v.m11566a(this.f13757a);
        this.f13759c.m11565a((AbstractC2564g) this);
        this.f13759c.m11564a((C2602v.AbstractC2606b) this);
    }

    /* renamed from: a */
    private void m8290a(String str, int i) {
        if (this.f13758b == null || this.f13758b.size() <= 0) {
            return;
        }
        if (str.endsWith(C3495f.f13782a)) {
            if (i != 100) {
                return;
            }
            if (!(str.endsWith(C3495f.f13782a) && (str.contains(new StringBuilder().append(C3681j.m7463p()).append("/").append(C3681j.m7461r()).toString()) || str.contains(new StringBuilder().append(C3681j.m7463p()).append("/").append(C3681j.m7462q()).toString())))) {
                return;
            }
            m8292a(new File(str));
            return;
        }
        for (C3495f c3495f : this.f13758b) {
            if (c3495f.m8241v().equals(str)) {
                if (i == 100) {
                    c3495f.m8277a(2);
                    c3495f.m8260e(c3495f.m8242u().replace(".", "&synced."));
                    notifyDataSetChanged();
                    if (c3495f.m8259f() > 1) {
                        m8293a(c3495f);
                    }
                } else if (i > 0) {
                    c3495f.m8277a(1);
                } else {
                    c3495f.m8277a(0);
                }
                c3495f.m8271b(i);
            }
        }
    }

    /* renamed from: a */
    public void m8298a(int i) {
        C3495f c3495f = this.f13758b.get(i);
        if (c3495f != null) {
            this.f13758b.get(i).m8273a(!c3495f.m8243t());
        }
        notifyDataSetChanged();
    }

    @Override // com.fimi.soul.biz.p185n.AbstractC2564g
    /* renamed from: a */
    public void mo8297a(int i, String str) {
        if (!str.endsWith(C3495f.f13782a) && i > 0) {
            ImageLoadingView imageLoadingView = (ImageLoadingView) this.f13760d.findViewWithTag("log_" + str);
            if (imageLoadingView != null) {
                imageLoadingView.m7275a();
                imageLoadingView.setSweepAngle(i);
            }
            TextView textView = (TextView) this.f13760d.findViewWithTag("percent_" + str);
            ImageView imageView = (ImageView) this.f13760d.findViewWithTag("load_" + str);
            if (textView != null) {
                if (i >= 100 || i <= 0) {
                    textView.setText(String.format("%s", this.f13757a.getString(C2300R.C2303string.fly_finish_over)));
                    if (imageView != null) {
                        imageView.setImageResource(C2300R.C2301drawable.icon_upload_ok);
                    }
                    m8292a(new File(str));
                } else {
                    textView.setText(String.format("%s | %s%s", this.f13757a.getString(C2300R.C2303string.fly_uploading), Integer.valueOf(i), "%"));
                    imageView.setImageResource(C2300R.C2301drawable.icon_download_pause);
                }
            }
        }
        m8290a(str, i);
    }

    @Override // com.fimi.soul.biz.p185n.C2602v.AbstractC2606b
    /* renamed from: a */
    public void mo8296a(PlaneMsg planeMsg, String str) {
        if (planeMsg != null && !planeMsg.isSuccess()) {
            if (!str.endsWith(C3495f.f13782a)) {
                ImageLoadingView imageLoadingView = (ImageLoadingView) this.f13760d.findViewWithTag("log_" + str);
                TextView textView = (TextView) this.f13760d.findViewWithTag("percent_" + str);
                ImageView imageView = (ImageView) this.f13760d.findViewWithTag("load_" + str);
                if (imageView != null) {
                    imageView.setImageResource(C2300R.C2301drawable.icon_download_continue);
                }
                if (textView != null) {
                    textView.setText(this.f13757a.getString(C2300R.C2303string.fly_upload_fail));
                }
            }
            this.f13759c.m11548d(new File(str));
        }
        if (str.endsWith(C3495f.f13782a) || this.f13758b == null || this.f13758b.size() <= 0) {
            return;
        }
        for (C3495f c3495f : this.f13758b) {
            if (c3495f != null && c3495f.m8241v().equals(str)) {
                c3495f.m8277a(0);
                return;
            }
        }
    }

    /* renamed from: a */
    public void m8293a(C3495f c3495f) {
        if (!c3495f.m8242u().contains(".fc")) {
            return;
        }
        List<C3495f> m8278a = c3495f.m8278a();
        for (int i = 0; i < m8278a.size(); i++) {
            C3495f c3495f2 = m8278a.get(i);
            if (!c3495f2.m8242u().contains("&synced.")) {
                this.f13759c.m11559a(new File(c3495f2.m8241v()));
            }
        }
        List<C3495f> m8272b = c3495f.m8272b();
        for (int i2 = 0; i2 < m8272b.size(); i2++) {
            C3495f c3495f3 = m8272b.get(i2);
            if (!c3495f3.m8242u().contains("&synced.")) {
                this.f13759c.m11559a(new File(c3495f3.m8241v()));
            }
        }
        List<C3495f> m8266c = c3495f.m8266c();
        for (int i3 = 0; i3 < m8266c.size(); i3++) {
            C3495f c3495f4 = m8266c.get(i3);
            if (!c3495f4.m8242u().contains("&synced.")) {
                this.f13759c.m11559a(new File(c3495f4.m8241v()));
            }
        }
    }

    /* renamed from: a */
    void m8292a(File file) {
        if (file.exists()) {
            file.renameTo(new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("/") + 1) + file.getName().replace(".", "&synced.")));
        }
    }

    /* renamed from: a */
    public void m8291a(String str) {
        String replace = str.replace("&synced", "").replace(".fc", "");
        File file = new File(C3681j.m7463p() + "/" + C3681j.m7462q() + "/" + replace);
        File file2 = new File(C3681j.m7463p() + "/" + C3681j.m7461r() + "/" + replace);
        C3696t c3696t = new C3696t();
        if (file2 != null) {
            c3696t.m7430a(file2);
        }
        if (file != null) {
            c3696t.m7430a(file);
        }
    }

    /* renamed from: a */
    public void m8289a(List<C3495f> list) {
        if (list != null) {
            this.f13758b = list;
            m8283c();
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void m8288a(boolean z) {
        this.f13761e = z;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public boolean m8299a() {
        return this.f13761e;
    }

    /* renamed from: b */
    public void m8286b(C3495f c3495f) {
        if (c3495f != null) {
            if (!c3495f.m8242u().endsWith(".sf") && !c3495f.m8242u().endsWith(".txt") && !c3495f.m8242u().endsWith(".fc") && !c3495f.m8242u().endsWith(".pb")) {
                return;
            }
            this.f13759c.m11559a(new File(c3495f.m8241v()));
            c3495f.m8264c(true);
            notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public void m8285b(List<C3495f> list) {
        synchronized (this.f13758b) {
            if (list != null) {
                if (list.size() > 0) {
                    for (C3495f c3495f : list) {
                        int size = this.f13758b.size() - 1;
                        while (true) {
                            if (size >= 0) {
                                C3495f c3495f2 = this.f13758b.get(size);
                                if (c3495f.m8242u().equals(c3495f2.m8242u())) {
                                    if (c3495f2.m8259f() > 1) {
                                        m8291a(c3495f2.m8242u());
                                    }
                                    this.f13758b.remove(c3495f2);
                                } else {
                                    size--;
                                }
                            }
                        }
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public void m8284b(boolean z) {
        this.f13762f = z;
    }

    /* renamed from: b */
    public boolean m8287b() {
        return this.f13762f;
    }

    /* renamed from: c */
    public void m8283c() {
        if (this.f13758b == null || this.f13758b.size() <= 0) {
            return;
        }
        for (C3495f c3495f : this.f13758b) {
            if (c3495f.m8259f() > 1 && c3495f.m8242u().contains("&synced")) {
                m8293a(c3495f);
            }
        }
    }

    /* renamed from: c */
    public void m8282c(boolean z) {
        this.f13762f = z;
        for (C3495f c3495f : this.f13758b) {
            c3495f.m8273a(z);
        }
        notifyDataSetChanged();
    }

    /* renamed from: d */
    public void m8281d() {
        if (this.f13759c != null) {
            this.f13759c.m11565a((AbstractC2564g) null);
            this.f13759c.m11553c();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f13758b != null) {
            return this.f13758b.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f13758b != null) {
            return this.f13758b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        C3495f c3495f;
        return (this.f13758b == null || i >= this.f13758b.size() || this.f13758b.size() <= 0 || (c3495f = this.f13758b.get(i)) == null || !c3495f.m8280A()) ? EnumC3492a.BodyView.ordinal() : EnumC3492a.HeadView.ordinal();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3493b c3493b;
        String[] split;
        String replaceAll;
        String[] split2;
        if (getItemViewType(i) == EnumC3492a.BodyView.ordinal()) {
            if (view == null) {
                this.f13763g = new C3494c();
                view = LinearLayout.inflate(this.f13757a, C2300R.layout.fly_logs_item, null);
                this.f13763g.f13773a = (TextView) view.findViewById(C2300R.C2302id.log_name);
                this.f13763g.f13774b = (TextView) view.findViewById(C2300R.C2302id.log_size);
                this.f13763g.f13775c = (TextView) view.findViewById(C2300R.C2302id.upload_status);
                this.f13763g.f13776d = (ImageLoadingView) view.findViewById(C2300R.C2302id.upload_icon);
                this.f13763g.f13777e = (ImageView) view.findViewById(C2300R.C2302id.upload_v);
                this.f13763g.f13780h = (RelativeLayout) view.findViewById(C2300R.C2302id.upload_layout);
                this.f13763g.f13778f = (ImageView) view.findViewById(C2300R.C2302id.select_icon);
                this.f13763g.f13779g = (ImageView) view.findViewById(C2300R.C2302id.head_arrow);
                view.setTag(this.f13763g);
                C3658ar.m7612a(this.f13757a.getAssets(), this.f13763g.f13773a, this.f13763g.f13774b, this.f13763g.f13775c);
            } else {
                this.f13763g = (C3494c) view.getTag();
            }
            final C3495f c3495f = this.f13758b.get(i);
            this.f13763g.f13776d.setTag("log_" + c3495f.m8241v());
            this.f13763g.f13775c.setTag("percent_" + c3495f.m8241v());
            this.f13763g.f13777e.setTag("load_" + c3495f.m8241v());
            if (this.f13761e) {
                this.f13763g.f13780h.setVisibility(8);
                if (c3495f.m8240w() == 0 || c3495f.m8240w() == 2) {
                    this.f13763g.f13778f.setVisibility(0);
                } else {
                    this.f13763g.f13778f.setVisibility(4);
                }
                this.f13763g.f13775c.setVisibility(8);
                this.f13763g.f13779g.setVisibility(8);
            } else {
                this.f13763g.f13780h.setVisibility(0);
                this.f13763g.f13778f.setVisibility(8);
                this.f13763g.f13775c.setVisibility(0);
                this.f13763g.f13779g.setVisibility(0);
            }
            if (c3495f != null) {
                this.f13763g.f13778f.setSelected(c3495f.f13789h);
                this.f13763g.f13776d.setPaintColor(this.f13757a.getResources().getColor(C2300R.color.gray));
                String m8242u = c3495f.m8242u();
                if (m8242u.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) && m8242u.contains(" ") && (split2 = m8242u.split(" ")) != null && split2.length > 0) {
                    m8242u = this.f13757a.getResources().getConfiguration().locale.getCountry().equals("CN") ? split2[1].replace('-', C0359h.f671A) : split2[1].replace('-', C0359h.f671A);
                    if (!m8242u.contains(":") && m8242u.length() > 4) {
                        m8242u = m8242u.substring(0, 2) + ":" + m8242u.substring(2, 4) + ":" + m8242u.substring(4, m8242u.length());
                    }
                }
                if (m8242u.contains(".sf") || m8242u.contains(".fc")) {
                    replaceAll = m8242u.replaceAll(".sf", "").replaceAll(".fc", "");
                    this.f13763g.f13774b.setText(this.f13757a.getString(C2300R.C2303string.black_box));
                    if (!this.f13761e) {
                        this.f13763g.f13779g.setVisibility(8);
                    }
                } else {
                    replaceAll = m8242u.replaceAll(".txt", "").replaceAll(".pb", "");
                    this.f13763g.f13774b.setText(this.f13757a.getString(C2300R.C2303string.video_log));
                    if (!this.f13761e) {
                        this.f13763g.f13779g.setVisibility(0);
                    }
                }
                if (!replaceAll.contains("&synced")) {
                    this.f13763g.f13777e.setImageResource(C2300R.C2301drawable.icon_upload_start);
                    this.f13763g.f13773a.setText(String.format("%s", replaceAll));
                    if (c3495f.m8240w() == 0) {
                        c3495f.m8277a(0);
                        this.f13763g.f13776d.setSweepAngle(0.0f);
                        if (!c3495f.f13790i) {
                            this.f13763g.f13775c.setText(c3495f.m8239x());
                        } else {
                            this.f13763g.f13775c.setText(this.f13757a.getResources().getString(C2300R.C2303string.wait_upload));
                            String m8239x = c3495f.m8239x();
                            if (m8239x == null || Double.valueOf(m8239x.split(" ")[0]).doubleValue() > 0.0d) {
                            }
                        }
                    } else if (c3495f.m8240w() == 1) {
                        c3495f.m8277a(1);
                        this.f13763g.f13777e.setImageResource(C2300R.C2301drawable.icon_download_pause);
                        this.f13763g.f13776d.m7275a();
                        this.f13763g.f13776d.setSweepAngle(c3495f.m8237z());
                        this.f13763g.f13775c.setText(String.format("%s | %s%s", this.f13757a.getString(C2300R.C2303string.fly_uploading), Integer.valueOf(c3495f.m8237z()), "%"));
                    } else if (c3495f.m8240w() == 3) {
                        c3495f.m8277a(3);
                        this.f13763g.f13777e.setImageResource(C2300R.C2301drawable.icon_download_pause);
                        this.f13763g.f13776d.m7275a();
                        this.f13763g.f13776d.setSweepAngle(c3495f.m8237z());
                        this.f13763g.f13775c.setText(String.format("%s | %s%s", this.f13757a.getString(C2300R.C2303string.fly_upload_pause), Integer.valueOf(c3495f.m8237z()), "%"));
                    }
                } else {
                    this.f13763g.f13776d.m7275a();
                    this.f13763g.f13776d.setSweepAngle(100.0f);
                    this.f13763g.f13777e.setImageResource(C2300R.C2301drawable.icon_upload_ok);
                    this.f13763g.f13775c.setText(this.f13757a.getResources().getString(C2300R.C2303string.fly_finish_over));
                    this.f13763g.f13773a.setText(replaceAll.replaceAll("&synced", ""));
                    c3495f.m8277a(2);
                }
            }
            this.f13763g.f13776d.setTag(C2300R.C2302id.tag_first, c3495f);
            this.f13763g.f13776d.setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.module.setting.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (System.currentTimeMillis() - C3490e.this.f13764h < 1000) {
                        return;
                    }
                    C3490e.this.f13764h = System.currentTimeMillis();
                    ImageView imageView = (ImageView) C3490e.this.f13760d.findViewWithTag("load_" + c3495f.m8241v());
                    if (C3490e.this.f13759c == null || c3495f.m8240w() == 2) {
                        return;
                    }
                    TextView textView = (TextView) C3490e.this.f13760d.findViewWithTag("percent_" + c3495f.m8241v());
                    if (c3495f.m8240w() == 1) {
                        C3490e.this.f13759c.m11555b(new File(c3495f.m8241v()));
                        c3495f.m8277a(3);
                        textView.setText(String.format("%s | %s%s", C3490e.this.f13757a.getString(C2300R.C2303string.fly_upload_pause), Integer.valueOf(c3495f.m8237z()), "%"));
                        imageView.setImageResource(C2300R.C2301drawable.icon_upload_start);
                        if (C3490e.this.f13758b == null) {
                            return;
                        }
                        for (C3495f c3495f2 : C3490e.this.f13758b) {
                            if (c3495f2.m8241v().equals(c3495f.m8241v())) {
                                c3495f2.m8277a(3);
                                return;
                            }
                        }
                    } else if (c3495f.m8240w() != 3) {
                        if (c3495f.m8240w() != 0) {
                            return;
                        }
                        textView.setText(C3490e.this.f13757a.getResources().getString(C2300R.C2303string.wait_upload));
                        String m8239x2 = c3495f.m8239x();
                        if (m8239x2 == null || Double.valueOf(m8239x2.split(" ")[0]).doubleValue() <= 0.0d) {
                            ((TextView) C3490e.this.f13760d.findViewWithTag("percent_" + c3495f.m8241v())).setText(C2300R.C2303string.inabvility);
                            return;
                        }
                        C3490e.this.f13759c.m11559a(new File(c3495f.m8241v()));
                        c3495f.m8264c(true);
                    } else {
                        textView.setText(String.format("%s | %s%s", C3490e.this.f13757a.getString(C2300R.C2303string.fly_uploading), Integer.valueOf(c3495f.m8237z()), "%"));
                        C3490e.this.f13759c.m11551c(new File(c3495f.m8241v()));
                        c3495f.m8277a(1);
                        imageView.setImageResource(C2300R.C2301drawable.icon_download_pause);
                        if (C3490e.this.f13758b == null) {
                            return;
                        }
                        for (C3495f c3495f3 : C3490e.this.f13758b) {
                            if (c3495f3.m8241v().equals(c3495f.m8241v())) {
                                c3495f3.m8277a(1);
                                return;
                            }
                        }
                    }
                }
            });
        } else {
            if (view == null) {
                view = LayoutInflater.from(this.f13757a).inflate(C2300R.layout.drone_log_item_title, (ViewGroup) null);
                c3493b = new C3493b();
                c3493b.f13771a = (TextView) view.findViewById(C2300R.C2302id.headview);
                view.setTag(c3493b);
                C3658ar.m7612a(this.f13757a.getAssets(), c3493b.f13771a);
            } else {
                c3493b = (C3493b) view.getTag();
            }
            String m8242u2 = this.f13758b.get(i).m8242u();
            if (m8242u2 != null) {
                if (m8242u2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER).length >= 2) {
                    c3493b.f13771a.setText(split[0] + this.f13757a.getString(C2300R.C2303string.year) + split[1] + this.f13757a.getString(C2300R.C2303string.month) + split[2] + this.f13757a.getString(C2300R.C2303string.day));
                }
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
