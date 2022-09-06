package com.fimi.soul.module.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public abstract class BaseActivity extends Activity {

    /* renamed from: a */
    Bundle f12944a;

    /* renamed from: b */
    protected Context f12945b;

    /* renamed from: c */
    protected int f12946c;

    /* renamed from: d */
    protected int f12947d;

    /* renamed from: a */
    public static boolean m8673a(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    /* renamed from: a */
    public Bundle m8674a() {
        return this.f12944a;
    }

    /* renamed from: a */
    protected void m8672a(Intent intent) {
        intent.setFlags(268468224);
        startActivity(intent);
        overridePendingTransition(17432576, 17432577);
        finish();
    }

    /* renamed from: a */
    protected void m8671a(Bundle bundle) {
    }

    /* renamed from: a */
    protected void m8670a(Class<?> cls) {
        startService(new Intent(this, cls));
    }

    /* renamed from: a */
    protected void m8669a(Class<?> cls, int i) {
        startActivityForResult(new Intent(this, cls), i);
    }

    /* renamed from: a */
    protected void m8668a(Class<?> cls, int i, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, i);
    }

    /* renamed from: a */
    protected void m8667a(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: a */
    protected void m8666a(Class<?> cls, String str, boolean z) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(str, z);
        startActivity(intent);
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: b */
    protected abstract void mo8564b();

    /* renamed from: b */
    protected void m8665b(Class<?> cls) {
        startActivity(new Intent(this, cls));
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: b */
    protected void m8664b(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        overridePendingTransition(17432576, 17432577);
        finish();
    }

    /* renamed from: c */
    public abstract void mo8563c();

    /* renamed from: c */
    protected void m8663c(Class<?> cls) {
        startActivity(new Intent(this, cls));
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    /* renamed from: c */
    protected void m8662c(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setFlags(268468224);
        startActivity(intent);
        overridePendingTransition(17432576, 17432577);
        finish();
    }

    /* renamed from: d */
    public abstract void mo8562d();

    /* renamed from: d */
    protected void m8661d(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(268468224);
        startActivity(intent);
        overridePendingTransition(17432576, 17432577);
        finish();
    }

    /* renamed from: e */
    protected abstract int mo8561e();

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12945b = this;
        this.f12944a = bundle;
        mo8564b();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            m8671a(extras);
        }
        if (mo8561e() != 0) {
            setContentView(mo8561e());
            this.f12947d = (getResources().getDisplayMetrics().heightPixels * 18) / 1920;
            mo8563c();
            mo8562d();
            return;
        }
        throw new IllegalArgumentException("You must return a right contentView layout resource Id");
    }
}
