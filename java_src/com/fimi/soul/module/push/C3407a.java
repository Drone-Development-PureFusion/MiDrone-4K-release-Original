package com.fimi.soul.module.push;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fimi.soul.C2300R;
import com.fimi.soul.entity.HistoryPushMessage;
import com.fimi.soul.utils.C3658ar;
import java.util.List;
/* renamed from: com.fimi.soul.module.push.a */
/* loaded from: classes.dex */
public class C3407a extends BaseAdapter {

    /* renamed from: a */
    private Context f13325a;

    /* renamed from: b */
    private List<HistoryPushMessage> f13326b;

    /* renamed from: com.fimi.soul.module.push.a$a */
    /* loaded from: classes.dex */
    private class C3409a {

        /* renamed from: a */
        TextView f13327a;

        /* renamed from: b */
        TextView f13328b;

        /* renamed from: c */
        TextView f13329c;

        /* renamed from: d */
        RelativeLayout f13330d;

        /* renamed from: e */
        ImageView f13331e;

        private C3409a() {
        }

        /* renamed from: a */
        public View m8487a(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(C3407a.this.f13325a).inflate(C2300R.layout.adapt_history_push_message, viewGroup, false);
            this.f13327a = (TextView) inflate.findViewById(C2300R.C2302id.title_tv);
            this.f13328b = (TextView) inflate.findViewById(C2300R.C2302id.message_tv);
            this.f13329c = (TextView) inflate.findViewById(C2300R.C2302id.time_tv);
            this.f13331e = (ImageView) inflate.findViewById(C2300R.C2302id.setting_more_iv);
            this.f13330d = (RelativeLayout) inflate.findViewById(C2300R.C2302id.rl);
            C3658ar.m7612a(C3407a.this.f13325a.getAssets(), this.f13327a, this.f13328b, this.f13329c);
            return inflate;
        }
    }

    public C3407a(Context context, List<HistoryPushMessage> list) {
        this.f13325a = context;
        this.f13326b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13326b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3409a c3409a;
        if (view == null) {
            C3409a c3409a2 = new C3409a();
            view = c3409a2.m8487a(viewGroup);
            view.setTag(c3409a2);
            c3409a = c3409a2;
        } else {
            c3409a = (C3409a) view.getTag();
        }
        view.getLayoutParams().height = (int) this.f13325a.getResources().getDimension(C2300R.dimen.setting_adapt_switch);
        c3409a.f13330d.setLayoutParams(view.getLayoutParams());
        c3409a.f13331e.setVisibility(0);
        c3409a.f13327a.setText(this.f13326b.get(i).getTitle());
        c3409a.f13328b.setText(this.f13326b.get(i).getPayload());
        c3409a.f13329c.setText(this.f13326b.get(i).getTime());
        return view;
    }
}
