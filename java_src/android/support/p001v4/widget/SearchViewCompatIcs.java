package android.support.p001v4.widget;

import android.content.Context;
import android.view.View;
import android.widget.SearchView;
/* renamed from: android.support.v4.widget.SearchViewCompatIcs */
/* loaded from: classes.dex */
class SearchViewCompatIcs {

    /* renamed from: android.support.v4.widget.SearchViewCompatIcs$MySearchView */
    /* loaded from: classes.dex */
    public static class MySearchView extends SearchView {
        public MySearchView(Context context) {
            super(context);
        }

        @Override // android.widget.SearchView, android.view.CollapsibleActionView
        public void onActionViewCollapsed() {
            setQuery("", false);
            super.onActionViewCollapsed();
        }
    }

    SearchViewCompatIcs() {
    }

    public static View newSearchView(Context context) {
        return new MySearchView(context);
    }

    public static void setImeOptions(View view, int i) {
        ((SearchView) view).setImeOptions(i);
    }

    public static void setInputType(View view, int i) {
        ((SearchView) view).setInputType(i);
    }
}
