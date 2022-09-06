package com.github.moduth.blockcanary.p216ui;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.github.moduth.blockcanary.C3939R;
import com.github.moduth.blockcanary.C3953c;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.github.moduth.blockcanary.p215b.C3952d;
import com.github.moduth.blockcanary.p216ui.DisplayLeakConnectorView;
import java.util.Arrays;
/* renamed from: com.github.moduth.blockcanary.ui.a */
/* loaded from: classes.dex */
final class C3987a extends BaseAdapter {

    /* renamed from: a */
    private static final int f17043a = 0;

    /* renamed from: b */
    private static final int f17044b = 1;

    /* renamed from: f */
    private static final int f17045f = 1;

    /* renamed from: g */
    private static final int f17046g = 2;

    /* renamed from: h */
    private static final int f17047h = 3;

    /* renamed from: i */
    private static final int f17048i = 4;

    /* renamed from: c */
    private boolean[] f17049c = new boolean[0];

    /* renamed from: d */
    private String f17050d = null;

    /* renamed from: e */
    private C3947a f17051e;

    /* renamed from: a */
    private static <T extends View> T m6317a(View view, int i) {
        return (T) view.findViewById(i);
    }

    /* renamed from: a */
    private String m6319a() {
        if (this.f17050d == null) {
            String mo6361j = C3953c.m6380b().mo6361j();
            if (mo6361j != null) {
                this.f17050d = mo6361j;
            } else {
                this.f17050d = C3952d.m6387a();
            }
        }
        return this.f17050d;
    }

    /* renamed from: a */
    private String m6315a(String str, int i, boolean z) {
        int indexOf;
        String replaceAll = str.replaceAll(C3947a.f16890a, "<br>");
        switch (i) {
            case 1:
                if (z) {
                    replaceAll = replaceAll.substring(replaceAll.indexOf(C3947a.f16897h));
                }
                return String.format("<font color='#c48a47'>%s</font> ", replaceAll);
            case 2:
                if (z) {
                    replaceAll = replaceAll.substring(0, replaceAll.indexOf(C3947a.f16902m));
                }
                return String.format("<font color='#f3cf83'>%s</font> ", replaceAll);
            case 3:
                if (z) {
                    str = str.substring(0, str.indexOf(C3947a.f16899j));
                }
                return String.format("<font color='#998bb5'>%s</font> ", str.replace("cpurate = ", "<br>cpurate<br/>")).replaceAll("]", "]<br>");
            default:
                if (z && (indexOf = replaceAll.indexOf(m6319a())) > 0) {
                    replaceAll = replaceAll.substring(indexOf);
                }
                return String.format("<font color='#ffffff'>%s</font> ", replaceAll);
        }
    }

    /* renamed from: c */
    private DisplayLeakConnectorView.EnumC3986a m6313c(int i) {
        return i == 1 ? DisplayLeakConnectorView.EnumC3986a.START : i == getCount() + (-1) ? DisplayLeakConnectorView.EnumC3986a.END : DisplayLeakConnectorView.EnumC3986a.NODE;
    }

    /* renamed from: a */
    public void m6318a(int i) {
        this.f17049c[i] = !this.f17049c[i];
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m6316a(C3947a c3947a) {
        if (this.f17051e == null || !c3947a.f16922K.equals(this.f17051e.f16922K)) {
            this.f17051e = c3947a;
            this.f17049c = new boolean[this.f17051e.f16926O.size() + 4];
            Arrays.fill(this.f17049c, true);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public String getItem(int i) {
        if (getItemViewType(i) == 0) {
            return null;
        }
        switch (i) {
            case 1:
                return this.f17051e.m6397c();
            case 2:
                return this.f17051e.m6395e();
            case 3:
                return this.f17051e.m6396d();
            default:
                return this.f17051e.f16926O.get(i - 4);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f17051e == null) {
            return 0;
        }
        return this.f17051e.f16926O.size() + 4;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = false;
        Context context = viewGroup.getContext();
        if (getItemViewType(i) == 0) {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(C3939R.layout.block_canary_ref_top_row, viewGroup, false);
            }
            ((TextView) m6317a(view, C3939R.C3941id.__leak_canary_row_text)).setText(context.getPackageName());
        } else {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(C3939R.layout.block_canary_ref_row, viewGroup, false);
            }
            TextView textView = (TextView) m6317a(view, C3939R.C3941id.__leak_canary_row_text);
            if (i == 5) {
                z = true;
            }
            String m6315a = m6315a(getItem(i), i, this.f17049c[i]);
            textView.setText(Html.fromHtml((!z || this.f17049c[i]) ? m6315a : m6315a + " <font color='#919191'>blocked</font>"));
            ((DisplayLeakConnectorView) m6317a(view, C3939R.C3941id.__leak_canary_row_connector)).setType(m6313c(i));
            ((MoreDetailsView) m6317a(view, C3939R.C3941id.__leak_canary_row_more)).setFolding(this.f17049c[i]);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
