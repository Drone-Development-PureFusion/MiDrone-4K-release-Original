package com.github.moduth.blockcanary.p216ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tts.loopj.RequestParams;
import com.github.moduth.blockcanary.C3939R;
import com.github.moduth.blockcanary.C3965j;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.github.moduth.blockcanary.p215b.C3948b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* renamed from: com.github.moduth.blockcanary.ui.DisplayBlockActivity */
/* loaded from: classes.dex */
public class DisplayBlockActivity extends Activity {

    /* renamed from: a */
    public static final String f17003a = "BlockStartTime";

    /* renamed from: b */
    private static final String f17004b = "DisplayBlockActivity";

    /* renamed from: c */
    private static final String f17005c = "show_latest";

    /* renamed from: d */
    private List<C3947a> f17006d = new ArrayList();

    /* renamed from: e */
    private String f17007e;

    /* renamed from: f */
    private ListView f17008f;

    /* renamed from: g */
    private TextView f17009g;

    /* renamed from: h */
    private Button f17010h;

    /* renamed from: i */
    private int f17011i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.moduth.blockcanary.ui.DisplayBlockActivity$a */
    /* loaded from: classes.dex */
    public class C3981a extends BaseAdapter {
        C3981a() {
        }

        @Override // android.widget.Adapter
        /* renamed from: a */
        public C3947a getItem(int i) {
            return (C3947a) DisplayBlockActivity.this.f17006d.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DisplayBlockActivity.this.f17006d.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(DisplayBlockActivity.this).inflate(C3939R.layout.block_canary_block_row, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(C3939R.C3941id.__leak_canary_row_text);
            TextView textView2 = (TextView) view.findViewById(C3939R.C3941id.__leak_canary_row_time);
            C3947a item = getItem(i);
            textView.setText(((i == 0 && DisplayBlockActivity.this.f17006d.size() == DisplayBlockActivity.this.f17011i) ? "MAX. " : (DisplayBlockActivity.this.f17006d.size() - i) + ". ") + item.m6394f() + " " + DisplayBlockActivity.this.getString(C3939R.C3942string.block_canary_class_has_blocked, new Object[]{Long.valueOf(item.f16920I)}));
            textView2.setText(DateUtils.formatDateTime(DisplayBlockActivity.this, item.f16927P.lastModified(), 17));
            return view;
        }
    }

    /* renamed from: com.github.moduth.blockcanary.ui.DisplayBlockActivity$b */
    /* loaded from: classes.dex */
    static class RunnableC3982b implements Runnable {

        /* renamed from: a */
        static final List<RunnableC3982b> f17023a = new ArrayList();

        /* renamed from: b */
        static final Executor f17024b = Executors.newSingleThreadExecutor();

        /* renamed from: c */
        private DisplayBlockActivity f17025c;

        /* renamed from: d */
        private final Handler f17026d = new Handler(Looper.getMainLooper());

        RunnableC3982b(DisplayBlockActivity displayBlockActivity) {
            this.f17025c = displayBlockActivity;
        }

        /* renamed from: a */
        static void m6323a() {
            for (RunnableC3982b runnableC3982b : f17023a) {
                runnableC3982b.f17025c = null;
            }
            f17023a.clear();
        }

        /* renamed from: a */
        static void m6321a(DisplayBlockActivity displayBlockActivity) {
            RunnableC3982b runnableC3982b = new RunnableC3982b(displayBlockActivity);
            f17023a.add(runnableC3982b);
            f17024b.execute(runnableC3982b);
        }

        @Override // java.lang.Runnable
        public void run() {
            final ArrayList arrayList = new ArrayList();
            File[] m6391c = C3948b.m6391c();
            if (m6391c != null) {
                for (File file : m6391c) {
                    try {
                        arrayList.add(C3947a.m6402a(file));
                    } catch (Exception e) {
                        file.delete();
                        Log.e(DisplayBlockActivity.f17004b, "Could not read block log file, deleted :" + file, e);
                    }
                }
                Collections.sort(arrayList, new Comparator<C3947a>() { // from class: com.github.moduth.blockcanary.ui.DisplayBlockActivity.b.1
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(C3947a c3947a, C3947a c3947a2) {
                        return Long.valueOf(c3947a2.f16927P.lastModified()).compareTo(Long.valueOf(c3947a.f16927P.lastModified()));
                    }
                });
            }
            this.f17026d.post(new Runnable() { // from class: com.github.moduth.blockcanary.ui.DisplayBlockActivity.b.2
                @Override // java.lang.Runnable
                public void run() {
                    RunnableC3982b.f17023a.remove(RunnableC3982b.this);
                    if (RunnableC3982b.this.f17025c != null) {
                        RunnableC3982b.this.f17025c.f17006d = arrayList;
                        RunnableC3982b.this.f17025c.m6340a();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static PendingIntent m6339a(Context context) {
        return m6338a(context, (String) null);
    }

    /* renamed from: a */
    public static PendingIntent m6338a(Context context, String str) {
        Intent intent = new Intent(context, DisplayBlockActivity.class);
        intent.putExtra(f17005c, str);
        intent.setFlags(335544320);
        return PendingIntent.getActivity(context, 1, intent, 134217728);
    }

    /* renamed from: a */
    static String m6332a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6340a() {
        C3947a m6327b = m6327b(this.f17007e);
        if (m6327b == null) {
            this.f17007e = null;
        }
        this.f17008f.setVisibility(0);
        this.f17009g.setVisibility(8);
        if (m6327b != null) {
            m6326c(m6327b);
        } else {
            m6331b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6337a(C3947a c3947a) {
        String c3947a2 = c3947a.toString();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", c3947a2);
        startActivity(Intent.createChooser(intent, getString(C3939R.C3942string.block_canary_share_with)));
    }

    /* renamed from: b */
    private C3947a m6327b(String str) {
        if (this.f17006d == null) {
            return null;
        }
        for (C3947a c3947a : this.f17006d) {
            if (c3947a.f16922K.equals(str)) {
                return c3947a;
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m6331b() {
        ListAdapter adapter = this.f17008f.getAdapter();
        if (adapter instanceof C3981a) {
            ((C3981a) adapter).notifyDataSetChanged();
        } else {
            this.f17008f.setAdapter((ListAdapter) new C3981a());
            this.f17008f.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.github.moduth.blockcanary.ui.DisplayBlockActivity.3
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    DisplayBlockActivity.this.f17007e = ((C3947a) DisplayBlockActivity.this.f17006d.get(i)).f16922K;
                    DisplayBlockActivity.this.m6340a();
                }
            });
            if (Build.VERSION.SDK_INT >= 11) {
                invalidateOptionsMenu();
                ActionBar actionBar = getActionBar();
                if (actionBar != null) {
                    actionBar.setDisplayHomeAsUpEnabled(false);
                }
            }
            setTitle(getString(C3939R.C3942string.block_canary_block_list_title, new Object[]{getPackageName()}));
            this.f17010h.setText(C3939R.C3942string.block_canary_delete_all);
            this.f17010h.setOnClickListener(new View.OnClickListener() { // from class: com.github.moduth.blockcanary.ui.DisplayBlockActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C3965j.m6356b();
                    DisplayBlockActivity.this.f17006d = Collections.emptyList();
                    DisplayBlockActivity.this.m6340a();
                }
            });
        }
        this.f17010h.setVisibility(this.f17006d.isEmpty() ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6330b(C3947a c3947a) {
        File file = c3947a.f16927P;
        if (Build.VERSION.SDK_INT >= 9) {
            file.setReadable(true, false);
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(RequestParams.APPLICATION_OCTET_STREAM);
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        startActivity(Intent.createChooser(intent, getString(C3939R.C3942string.block_canary_share_with)));
    }

    /* renamed from: c */
    private void m6326c(final C3947a c3947a) {
        final C3987a c3987a;
        ListAdapter adapter = this.f17008f.getAdapter();
        if (adapter instanceof C3987a) {
            c3987a = (C3987a) adapter;
        } else {
            c3987a = new C3987a();
            this.f17008f.setAdapter((ListAdapter) c3987a);
            this.f17008f.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.github.moduth.blockcanary.ui.DisplayBlockActivity.5
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    c3987a.m6318a(i);
                }
            });
            if (Build.VERSION.SDK_INT >= 11) {
                invalidateOptionsMenu();
                ActionBar actionBar = getActionBar();
                if (actionBar != null) {
                    actionBar.setDisplayHomeAsUpEnabled(true);
                }
            }
            this.f17010h.setVisibility(0);
            this.f17010h.setText(C3939R.C3942string.block_canary_delete);
            this.f17010h.setOnClickListener(new View.OnClickListener() { // from class: com.github.moduth.blockcanary.ui.DisplayBlockActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c3947a != null) {
                        c3947a.f16927P.delete();
                        DisplayBlockActivity.this.f17007e = null;
                        DisplayBlockActivity.this.f17006d.remove(c3947a);
                        DisplayBlockActivity.this.m6340a();
                    }
                }
            });
        }
        c3987a.m6316a(c3947a);
        setTitle(getString(C3939R.C3942string.block_canary_class_has_blocked, new Object[]{Long.valueOf(c3947a.f16920I)}));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f17007e == null) {
            super.onBackPressed();
            return;
        }
        this.f17007e = null;
        m6340a();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f17007e = bundle.getString(f17003a);
        } else {
            Intent intent = getIntent();
            if (intent.hasExtra(f17005c)) {
                this.f17007e = intent.getStringExtra(f17005c);
            }
        }
        setContentView(C3939R.layout.block_canary_display_leak);
        this.f17008f = (ListView) findViewById(C3939R.C3941id.__leak_canary_display_leak_list);
        this.f17009g = (TextView) findViewById(C3939R.C3941id.__leak_canary_display_leak_failure);
        this.f17010h = (Button) findViewById(C3939R.C3941id.__leak_canary_action);
        this.f17011i = getResources().getInteger(C3939R.integer.block_canary_max_stored_count);
        m6340a();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        final C3947a m6327b = m6327b(this.f17007e);
        if (m6327b != null) {
            menu.add(C3939R.C3942string.block_canary_share_leak).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.github.moduth.blockcanary.ui.DisplayBlockActivity.1
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    DisplayBlockActivity.this.m6337a(m6327b);
                    return true;
                }
            });
            menu.add(C3939R.C3942string.block_canary_share_stack_dump).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.github.moduth.blockcanary.ui.DisplayBlockActivity.2
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem menuItem) {
                    DisplayBlockActivity.this.m6330b(m6327b);
                    return true;
                }
            });
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        RunnableC3982b.m6323a();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.f17007e = null;
            m6340a();
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        RunnableC3982b.m6321a(this);
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        return this.f17006d;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(f17003a, this.f17007e);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (i != C3939R.style.block_canary_BlockCanary_Base) {
            return;
        }
        super.setTheme(i);
    }
}
