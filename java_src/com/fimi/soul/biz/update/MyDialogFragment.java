package com.fimi.soul.biz.update;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p001v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class MyDialogFragment extends DialogFragment {

    /* renamed from: a */
    private String f9101a;

    /* renamed from: a */
    public void m11455a(String str) {
        this.f9101a = str;
    }

    @Override // android.support.p001v4.app.DialogFragment
    public boolean isCancelable() {
        return true;
    }

    @Override // android.support.p001v4.app.DialogFragment, android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.p001v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new AlertDialog.Builder(getActivity()).setMessage(this.f9101a).setPositiveButton(C2300R.C2303string.finish, new DialogInterface.OnClickListener() { // from class: com.fimi.soul.biz.update.MyDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        }).create();
    }

    @Override // android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.p001v4.app.DialogFragment, android.support.p001v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.support.p001v4.app.DialogFragment
    public void setShowsDialog(boolean z) {
        super.setShowsDialog(z);
    }
}
