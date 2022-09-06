package it.sephiroth.android.library.p240a.p241a;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import it.sephiroth.android.library.widget.AbsHListView;
/* renamed from: it.sephiroth.android.library.a.a.b */
/* loaded from: classes2.dex */
public class C4886b implements AbstractActionMode$CallbackC4885a {

    /* renamed from: a */
    private AbstractActionMode$CallbackC4885a f20857a;

    /* renamed from: b */
    private AbsHListView f20858b;

    public C4886b(AbsHListView absHListView) {
        this.f20858b = absHListView;
    }

    @Override // it.sephiroth.android.library.p240a.p241a.AbstractActionMode$CallbackC4885a
    @TargetApi(11)
    /* renamed from: a */
    public void mo2938a(ActionMode actionMode, int i, long j, boolean z) {
        this.f20857a.mo2938a(actionMode, i, j, z);
        if (this.f20858b.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    /* renamed from: a */
    public void m2937a(AbstractActionMode$CallbackC4885a abstractActionMode$CallbackC4885a) {
        this.f20857a = abstractActionMode$CallbackC4885a;
    }

    /* renamed from: a */
    public boolean m2939a() {
        return this.f20857a != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f20857a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (this.f20857a.onCreateActionMode(actionMode, menu)) {
            this.f20858b.setLongClickable(false);
            return true;
        }
        return false;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f20857a.onDestroyActionMode(actionMode);
        this.f20858b.f20964u = null;
        this.f20858b.m2922a();
        this.f20858b.f21056aK = true;
        this.f20858b.A();
        this.f20858b.requestLayout();
        this.f20858b.setLongClickable(true);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f20857a.onPrepareActionMode(actionMode, menu);
    }
}
