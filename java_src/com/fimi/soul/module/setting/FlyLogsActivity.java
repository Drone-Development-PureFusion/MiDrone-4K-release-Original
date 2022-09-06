package com.fimi.soul.module.setting;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.BaseActivity;
import com.fimi.soul.biz.p178g.HandlerC2458i;
import com.fimi.soul.media.player.FimiMediaMeta;
import com.fimi.soul.module.droneTrack.PlayBackDroneTrackActivity;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.view.DialogC3800f;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes.dex */
public class FlyLogsActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: p */
    public static final int f13496p = 10;

    /* renamed from: a */
    ImageView f13497a;

    /* renamed from: b */
    TextView f13498b;

    /* renamed from: c */
    TextView f13499c;

    /* renamed from: d */
    TextView f13500d;

    /* renamed from: e */
    TextView f13501e;

    /* renamed from: f */
    Button f13502f;

    /* renamed from: g */
    Button f13503g;

    /* renamed from: h */
    ListView f13504h;

    /* renamed from: k */
    RelativeLayout f13507k;

    /* renamed from: l */
    RelativeLayout f13508l;

    /* renamed from: m */
    LinearLayout f13509m;

    /* renamed from: n */
    ImageButton f13510n;

    /* renamed from: o */
    ImageButton f13511o;

    /* renamed from: q */
    private C3490e f13512q;

    /* renamed from: s */
    private ArrayList<C3495f> f13514s;

    /* renamed from: i */
    ArrayList<C3495f> f13505i = new ArrayList<>();

    /* renamed from: j */
    List<C3495f> f13506j = new ArrayList();

    /* renamed from: r */
    private Handler f13513r = new HandlerC2458i(this);

    /* renamed from: t */
    private HashMap<String, List<C3495f>> f13515t = new HashMap<>();

    /* renamed from: com.fimi.soul.module.setting.FlyLogsActivity$a */
    /* loaded from: classes.dex */
    class C3443a implements Comparator<C3495f> {
        C3443a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C3495f c3495f, C3495f c3495f2) {
            if (c3495f2.m8238y() > c3495f.m8238y()) {
                return 1;
            }
            return c3495f.m8238y() == c3495f2.m8238y() ? 0 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8456a(ArrayList<C3495f> arrayList) {
        Object obj;
        Object obj2 = null;
        int i = 0;
        while (i < arrayList.size()) {
            C3495f c3495f = arrayList.get(i);
            String[] split = c3495f.m8242u().split(" ");
            String str = " ";
            if (split.length > 0) {
                str = split[0];
            }
            if (!str.equals(obj2)) {
                C3495f c3495f2 = new C3495f();
                c3495f2.m8260e(str);
                c3495f2.m8277a(0);
                c3495f2.m8258f(c3495f.m8241v());
                c3495f2.m8271b(0);
                c3495f2.m8267b(true);
                arrayList.add(i, c3495f2);
                obj = str;
            } else {
                obj = obj2;
            }
            i++;
            obj2 = obj;
        }
    }

    /* renamed from: d */
    private void m8450d() {
        this.f13512q = new C3490e(this, this.f13505i, this.f13504h);
        this.f13504h.setAdapter((ListAdapter) this.f13512q);
        this.f13504h.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.fimi.soul.module.setting.FlyLogsActivity.2
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                C3495f c3495f = (C3495f) adapterView.getItemAtPosition(i);
                if (c3495f == null || !c3495f.m8280A()) {
                    FlyLogsActivity.this.f13512q.m8288a(true);
                    FlyLogsActivity.this.f13507k.setVisibility(0);
                    FlyLogsActivity.this.f13508l.setVisibility(4);
                    FlyLogsActivity.this.f13509m.setVisibility(0);
                    return false;
                }
                return true;
            }
        });
        this.f13504h.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.fimi.soul.module.setting.FlyLogsActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            @SuppressLint({"StringFormatMatches"})
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C3495f c3495f = (C3495f) adapterView.getItemAtPosition(i);
                if (c3495f == null || !c3495f.m8280A()) {
                    if (!FlyLogsActivity.this.f13512q.m8299a()) {
                        if (c3495f.m8242u().contains(".sf") || c3495f.m8242u().contains(".fc")) {
                            return;
                        }
                        Intent intent = new Intent(FlyLogsActivity.this, PlayBackDroneTrackActivity.class);
                        C3495f c3495f2 = (C3495f) FlyLogsActivity.this.f13512q.getItem(i);
                        if (c3495f2 == null || c3495f2.m8241v() == null) {
                            return;
                        }
                        intent.putExtra("path", c3495f2.m8241v());
                        FlyLogsActivity.this.startActivity(intent);
                        return;
                    }
                    C3495f c3495f3 = (C3495f) FlyLogsActivity.this.f13512q.getItem(i);
                    if (!c3495f3.f13789h) {
                        FlyLogsActivity.this.f13506j.add(c3495f3);
                    } else {
                        int size = FlyLogsActivity.this.f13506j.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            } else if (c3495f3.m8241v().equals(FlyLogsActivity.this.f13506j.get(size).m8241v())) {
                                FlyLogsActivity.this.f13506j.remove(size);
                                break;
                            } else {
                                size--;
                            }
                        }
                    }
                    FlyLogsActivity.this.f13512q.m8298a(i);
                    FlyLogsActivity.this.f13499c.setText(String.format(FlyLogsActivity.this.getResources().getString(C2300R.C2303string.has_select_num, Integer.valueOf(FlyLogsActivity.this.f13506j.size())), new Object[0]));
                    if (FlyLogsActivity.this.f13512q.getCount() == FlyLogsActivity.this.f13506j.size()) {
                        FlyLogsActivity.this.f13502f.setText(C2300R.C2303string.undo_select_all);
                    } else {
                        FlyLogsActivity.this.f13502f.setText(C2300R.C2303string.select_all);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public C3490e m8460a() {
        return this.f13512q;
    }

    /* renamed from: a */
    ArrayList<C3495f> m8457a(String str, ArrayList<C3495f> arrayList) {
        File[] listFiles;
        FileInputStream fileInputStream;
        long size;
        File file = (str == null || "".equals(str)) ? new File(C3681j.m7465n()) : new File(str);
        if (file != null && file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    m8457a(file2.getAbsolutePath(), arrayList);
                } else {
                    C3495f c3495f = new C3495f();
                    c3495f.m8260e(file2.getName());
                    c3495f.m8277a(0);
                    c3495f.m8258f(file2.getAbsolutePath());
                    c3495f.m8271b(0);
                    try {
                        fileInputStream = new FileInputStream(new File(c3495f.m8241v()));
                        size = fileInputStream.getChannel().size() / FimiMediaMeta.AV_CH_SIDE_RIGHT;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (size > 0) {
                        c3495f.m8276a(new File(c3495f.m8241v()).length());
                        if (file2.getName().contains(".fc")) {
                            c3495f.m8275a(file2.getName().replace("&synced", "").replace(".fc", ""));
                            if (c3495f.m8259f() > 1) {
                                size += c3495f.m8261e() / FimiMediaMeta.AV_CH_SIDE_RIGHT;
                            }
                        }
                        if (size > FimiMediaMeta.AV_CH_SIDE_RIGHT) {
                            c3495f.m8256g(String.format("%s %s", new DecimalFormat("######0.00").format(size / 1024.0d).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "."), "M"));
                        } else {
                            c3495f.m8256g(String.format("%d %s", Integer.valueOf((int) size), "K"));
                        }
                        fileInputStream.close();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                        String replace = file2.getName().replace(".txt", "").replace("&synced", "").replace(".sf", "").replace(".fc", "").replace(".pb", "");
                        String[] split = replace.split(" ");
                        if (split != null && split.length > 0) {
                            String replace2 = split[1].replace('-', C0359h.f671A);
                            if (!replace2.contains(":") && replace2.length() > 4) {
                                replace2 = replace2.substring(0, 2) + ":" + replace2.substring(2, 4) + ":" + replace2.substring(4, replace2.length());
                            }
                            replace = split[0] + " " + replace2;
                        }
                        c3495f.m8270b(simpleDateFormat.parse(replace).getTime());
                        arrayList.add(c3495f);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public ArrayList<C3495f> m8455b() {
        return this.f13514s;
    }

    /* renamed from: c */
    public ArrayList<C3495f> m8452c() {
        return this.f13505i;
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"StringFormatMatches"})
    public void onClick(View view) {
        switch (view.getId()) {
            case C2300R.C2302id.back_btn /* 2131493144 */:
                finish();
                return;
            case C2300R.C2302id.unall_btn /* 2131493481 */:
                this.f13507k.setVisibility(8);
                this.f13508l.setVisibility(0);
                this.f13509m.setVisibility(8);
                this.f13512q.m8288a(false);
                this.f13512q.m8282c(false);
                this.f13512q.notifyDataSetChanged();
                this.f13506j.clear();
                return;
            case C2300R.C2302id.all_btn /* 2131493483 */:
                if (this.f13512q.m8287b()) {
                    this.f13506j.clear();
                    this.f13512q.m8282c(false);
                    this.f13502f.setText(C2300R.C2303string.select_all);
                } else {
                    this.f13502f.setText(C2300R.C2303string.undo_select_all);
                    this.f13512q.m8282c(true);
                    this.f13506j.clear();
                    if (this.f13505i != null && this.f13505i.size() > 0) {
                        Iterator<C3495f> it2 = this.f13505i.iterator();
                        while (it2.hasNext()) {
                            this.f13506j.add(it2.next());
                        }
                    }
                }
                this.f13499c.setText(String.format(getResources().getString(C2300R.C2303string.has_select_num, Integer.valueOf(this.f13506j.size())), new Object[0]));
                return;
            case C2300R.C2302id.del_btn /* 2131493486 */:
                if (this.f13506j == null || this.f13506j.size() <= 0) {
                    Toast.makeText(this, getString(C2300R.C2303string.make_sure_selected), 1).show();
                    return;
                } else {
                    new DialogC3800f.C3801a(this).m7031a(getString(C2300R.C2303string.ensure_delete_selected)).m7023c(17).m7024b(getString(C2300R.C2303string.delete), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.FlyLogsActivity.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (FlyLogsActivity.this.f13506j != null && FlyLogsActivity.this.f13506j.size() > 0) {
                                for (int size = FlyLogsActivity.this.f13506j.size() - 1; size >= 0; size--) {
                                    File file = new File(FlyLogsActivity.this.f13506j.get(size).m8241v());
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    File parentFile = file.getParentFile();
                                    if (parentFile != null && parentFile.isDirectory() && parentFile.listFiles().length == 0) {
                                        C3495f c3495f = new C3495f();
                                        c3495f.m8260e(file.getName().split(" ")[0]);
                                        c3495f.m8277a(0);
                                        c3495f.m8258f(file.getPath());
                                        c3495f.m8271b(0);
                                        c3495f.m8267b(true);
                                        FlyLogsActivity.this.f13506j.add(c3495f);
                                    }
                                }
                                FlyLogsActivity.this.f13512q.m8285b(FlyLogsActivity.this.f13506j);
                            }
                            FlyLogsActivity.this.f13512q.m8288a(false);
                            FlyLogsActivity.this.f13508l.setVisibility(0);
                            FlyLogsActivity.this.f13509m.setVisibility(8);
                            FlyLogsActivity.this.f13507k.setVisibility(8);
                            FlyLogsActivity.this.f13512q.m8282c(false);
                            FlyLogsActivity.this.f13506j.clear();
                        }
                    }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.FlyLogsActivity.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            FlyLogsActivity.this.f13507k.setVisibility(0);
                            FlyLogsActivity.this.f13509m.setVisibility(0);
                            FlyLogsActivity.this.f13508l.setVisibility(4);
                        }
                    }).m7034a(getResources().getColor(C2300R.color.dialog_ensure_hot)).m7035a().show();
                    return;
                }
            case C2300R.C2302id.upload_btn /* 2131493488 */:
                if (this.f13506j == null || this.f13506j.size() <= 0) {
                    Toast.makeText(this, getString(C2300R.C2303string.make_sure_upload_selected), 1).show();
                    return;
                } else {
                    new DialogC3800f.C3801a(this).m7031a(getString(C2300R.C2303string.ensure_upload_selected)).m7023c(17).m7024b(getString(C2300R.C2303string.fly_upload_all_file), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.FlyLogsActivity.7
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (FlyLogsActivity.this.f13506j != null && FlyLogsActivity.this.f13506j.size() > 0) {
                                for (C3495f c3495f : FlyLogsActivity.this.f13506j) {
                                    if (c3495f.m8240w() == 0) {
                                        FlyLogsActivity.this.f13512q.m8286b(c3495f);
                                    }
                                }
                            }
                            FlyLogsActivity.this.f13512q.m8288a(false);
                            FlyLogsActivity.this.f13508l.setVisibility(0);
                            FlyLogsActivity.this.f13509m.setVisibility(8);
                            FlyLogsActivity.this.f13507k.setVisibility(8);
                            FlyLogsActivity.this.f13512q.m8282c(false);
                            FlyLogsActivity.this.f13506j.clear();
                        }
                    }).m7030a(getString(C2300R.C2303string.cancel), new DialogInterface.OnClickListener() { // from class: com.fimi.soul.module.setting.FlyLogsActivity.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            FlyLogsActivity.this.f13507k.setVisibility(0);
                            FlyLogsActivity.this.f13509m.setVisibility(0);
                            FlyLogsActivity.this.f13508l.setVisibility(4);
                        }
                    }).m7034a(getResources().getColor(C2300R.color.dialog_ensure_hot)).m7035a().show();
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.soul.base.BaseFimiActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2300R.layout.fly_logs_layout);
        this.f13497a = (ImageView) findViewById(C2300R.C2302id.back_btn);
        this.f13497a.setOnClickListener(this);
        this.f13498b = (TextView) findViewById(C2300R.C2302id.fly_log_title);
        this.f13504h = (ListView) findViewById(C2300R.C2302id.log_list);
        this.f13504h.setOverScrollMode(2);
        this.f13499c = (TextView) findViewById(C2300R.C2302id.del_title);
        this.f13502f = (Button) findViewById(C2300R.C2302id.all_btn);
        this.f13503g = (Button) findViewById(C2300R.C2302id.unall_btn);
        this.f13502f.setOnClickListener(this);
        this.f13503g.setOnClickListener(this);
        this.f13510n = (ImageButton) findViewById(C2300R.C2302id.del_btn);
        this.f13510n.setOnClickListener(this);
        this.f13511o = (ImageButton) findViewById(C2300R.C2302id.upload_btn);
        this.f13511o.setOnClickListener(this);
        this.f13501e = (TextView) findViewById(C2300R.C2302id.upload_des);
        this.f13500d = (TextView) findViewById(C2300R.C2302id.del_des);
        this.f13507k = (RelativeLayout) findViewById(C2300R.C2302id.del_layout);
        this.f13508l = (RelativeLayout) findViewById(C2300R.C2302id.title_layout);
        this.f13509m = (LinearLayout) findViewById(C2300R.C2302id.bottom_layout);
        C3658ar.m7614a(getAssets(), getWindow().getDecorView());
        C3658ar.m7612a(getAssets(), this.f13498b, this.f13499c, this.f13500d, this.f13501e);
        getWindow().addFlags(128);
        m8450d();
        this.f13514s = (ArrayList) this.f13505i.clone();
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.module.setting.FlyLogsActivity.1
            @Override // java.lang.Runnable
            public void run() {
                FlyLogsActivity.this.f13514s = FlyLogsActivity.this.m8457a(C3681j.m7466m(), FlyLogsActivity.this.f13514s);
                Collections.sort(FlyLogsActivity.this.f13514s, new C3443a());
                FlyLogsActivity.this.m8456a(FlyLogsActivity.this.f13514s);
                FlyLogsActivity.this.f13513r.sendEmptyMessage(10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, com.fimi.kernel.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.base.BaseActivity, android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
