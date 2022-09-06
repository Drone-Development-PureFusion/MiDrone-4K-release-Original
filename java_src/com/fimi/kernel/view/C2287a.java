package com.fimi.kernel.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import com.fimi.kernel.C2168R;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.C2242d;
import com.fimi.kernel.view.dialog.ProgressDialogC2294b;
import java.util.Calendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.fimi.kernel.view.a */
/* loaded from: classes.dex */
public class C2287a implements AbstractC2288b {

    /* renamed from: a */
    private ProgressDialogC2294b f7614a;

    /* renamed from: b */
    private ProgressDialog f7615b;

    /* renamed from: d */
    private Activity m12688d() {
        return C2238c.m13124d();
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: a */
    public void mo12687a() {
        mo12678b("");
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: a */
    public void mo12686a(int i) {
        Toast.makeText(m12688d(), m12688d().getResources().getString(i), 0).show();
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: a */
    public void mo12685a(int i, int i2) {
        if (this.f7615b != null) {
            this.f7615b.setMax(i2);
            this.f7615b.setProgress(i);
        }
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: a */
    public void mo12684a(DatePickerDialog.OnDateSetListener onDateSetListener, Calendar calendar) {
        new DatePickerDialog(m12688d(), onDateSetListener, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: a */
    public void mo12683a(TimePickerDialog.OnTimeSetListener onTimeSetListener, Calendar calendar) {
        new TimePickerDialog(m12688d(), onTimeSetListener, calendar.get(11), calendar.get(12), true).show();
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: a */
    public void mo12682a(String str) {
        Toast.makeText(m12688d(), str, 0).show();
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: a */
    public void mo12681a(String str, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(m12688d()).setTitle(mo12675c(C2168R.C2171string.message)).setMessage(str).setPositiveButton(mo12675c(C2168R.C2171string.confirm), onClickListener).show();
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: b */
    public Dialog mo12680b() {
        if (this.f7615b != null) {
            return this.f7615b;
        }
        if (this.f7614a == null) {
            return null;
        }
        return this.f7614a;
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: b */
    public void mo12679b(int i) {
        if (this.f7615b != null) {
            this.f7615b.setMax(100);
            this.f7615b.setProgress(i);
        }
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: b */
    public void mo12678b(String str) {
        if (m12688d() == null) {
            return;
        }
        this.f7614a = new ProgressDialogC2294b(m12688d());
        this.f7614a.setProgressStyle(0);
        this.f7614a.m12653a(str);
        this.f7614a.setTitle(str);
        this.f7614a.show();
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: b */
    public void mo12677b(String str, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(m12688d()).setTitle(mo12675c(C2168R.C2171string.message)).setMessage(str).setPositiveButton(mo12675c(C2168R.C2171string.confirm), onClickListener).setNegativeButton(mo12675c(C2168R.C2171string.cancel), onClickListener).show();
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: c */
    public CharSequence mo12675c(int i) {
        return m12688d().getResources().getText(i);
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: c */
    public void mo12676c() {
        if (this.f7615b != null) {
            this.f7615b.dismiss();
        }
        if (this.f7614a != null) {
            this.f7614a.dismiss();
        }
    }

    @Override // com.fimi.kernel.view.AbstractC2288b
    /* renamed from: c */
    public void mo12674c(String str) {
        this.f7615b = new ProgressDialog(m12688d());
        this.f7615b.setProgressStyle(1);
        this.f7615b.setMessage(str);
        this.f7615b.setMax(C2242d.f7474a);
        this.f7615b.setCancelable(false);
        this.f7615b.show();
    }
}
