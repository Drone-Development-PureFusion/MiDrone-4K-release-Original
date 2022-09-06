package com.mob.tools.gui;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
public abstract class PullToRequestGridAdapter extends PullToRequestBaseListAdapter {
    private boolean fling;
    private OnListStopScrollListener osListener;
    private boolean pullUpReady;
    private ScrollableGridView gridView = onNewGridView(getContext());
    private PullToRequestBaseAdapter adapter = new PullToRequestBaseAdapter(this);

    public PullToRequestGridAdapter(PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        this.gridView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.mob.tools.gui.PullToRequestGridAdapter.1
            private int firstVisibleItem;
            private int visibleItemCount;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.firstVisibleItem = i;
                this.visibleItemCount = i2;
                View childAt = absListView.getChildAt(i2 - 1);
                PullToRequestGridAdapter.this.pullUpReady = i + i2 == i3 && childAt != null && childAt.getBottom() <= absListView.getBottom();
                PullToRequestGridAdapter.this.onScroll(PullToRequestGridAdapter.this.gridView, i, i2, i3);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                PullToRequestGridAdapter.this.fling = i == 2;
                if (i == 0) {
                    if (PullToRequestGridAdapter.this.osListener != null) {
                        PullToRequestGridAdapter.this.osListener.onListStopScrolling(this.firstVisibleItem, this.visibleItemCount);
                    } else if (PullToRequestGridAdapter.this.adapter == null) {
                    } else {
                        PullToRequestGridAdapter.this.adapter.notifyDataSetChanged();
                    }
                }
            }
        });
        this.gridView.setAdapter((ListAdapter) this.adapter);
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public Scrollable getBodyView() {
        return this.gridView;
    }

    public GridView getGridView() {
        return this.gridView;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public boolean isFling() {
        return this.fling;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public boolean isPullDownReady() {
        return this.gridView.isReadyToPull();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public boolean isPullUpReady() {
        return this.pullUpReady;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.adapter.notifyDataSetChanged();
    }

    protected ScrollableGridView onNewGridView(Context context) {
        return new ScrollableGridView(context);
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public void onScroll(Scrollable scrollable, int i, int i2, int i3) {
    }

    public void setColumnWidth(int i) {
        this.gridView.setColumnWidth(i);
    }

    public void setHorizontalSpacing(int i) {
        this.gridView.setHorizontalSpacing(i);
    }

    public void setNumColumns(int i) {
        this.gridView.setNumColumns(i);
    }

    public void setStretchMode(int i) {
        this.gridView.setStretchMode(i);
    }

    public void setVerticalSpacing(int i) {
        this.gridView.setVerticalSpacing(i);
    }
}
