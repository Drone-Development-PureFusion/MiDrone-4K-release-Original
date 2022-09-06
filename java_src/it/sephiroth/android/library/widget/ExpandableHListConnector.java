package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes2.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {

    /* renamed from: a */
    private ExpandableListAdapter f21081a;

    /* renamed from: c */
    private int f21083c;

    /* renamed from: d */
    private int f21084d = Integer.MAX_VALUE;

    /* renamed from: e */
    private final DataSetObserver f21085e = new C4920a();

    /* renamed from: b */
    private ArrayList<GroupMetadata> f21082b = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: it.sephiroth.android.library.widget.ExpandableHListConnector.GroupMetadata.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.m2769a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };

        /* renamed from: a */
        static final int f21086a = -1;

        /* renamed from: b */
        int f21087b;

        /* renamed from: c */
        int f21088c;

        /* renamed from: d */
        int f21089d;

        /* renamed from: e */
        long f21090e;

        private GroupMetadata() {
        }

        /* renamed from: a */
        static GroupMetadata m2769a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.f21087b = i;
            groupMetadata.f21088c = i2;
            groupMetadata.f21089d = i3;
            groupMetadata.f21090e = j;
            return groupMetadata;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.f21089d - groupMetadata.f21089d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f21087b);
            parcel.writeInt(this.f21088c);
            parcel.writeInt(this.f21089d);
            parcel.writeLong(this.f21090e);
        }
    }

    /* renamed from: it.sephiroth.android.library.widget.ExpandableHListConnector$a */
    /* loaded from: classes2.dex */
    protected class C4920a extends DataSetObserver {
        protected C4920a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ExpandableHListConnector.this.m2776a(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.m2776a(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* renamed from: it.sephiroth.android.library.widget.ExpandableHListConnector$b */
    /* loaded from: classes2.dex */
    public static class C4921b {

        /* renamed from: d */
        private static final int f21092d = 5;

        /* renamed from: e */
        private static ArrayList<C4921b> f21093e = new ArrayList<>(5);

        /* renamed from: a */
        public C4934b f21094a;

        /* renamed from: b */
        public GroupMetadata f21095b;

        /* renamed from: c */
        public int f21096c;

        private C4921b() {
        }

        /* renamed from: a */
        static C4921b m2764a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            C4921b m2761d = m2761d();
            m2761d.f21094a = C4934b.m2651a(i2, i3, i4, i);
            m2761d.f21095b = groupMetadata;
            m2761d.f21096c = i5;
            return m2761d;
        }

        /* renamed from: c */
        private void m2762c() {
            if (this.f21094a != null) {
                this.f21094a.m2649b();
                this.f21094a = null;
            }
            this.f21095b = null;
            this.f21096c = 0;
        }

        /* renamed from: d */
        private static C4921b m2761d() {
            C4921b c4921b;
            synchronized (f21093e) {
                if (f21093e.size() > 0) {
                    c4921b = f21093e.remove(0);
                    c4921b.m2762c();
                } else {
                    c4921b = new C4921b();
                }
            }
            return c4921b;
        }

        /* renamed from: a */
        public void m2765a() {
            m2762c();
            synchronized (f21093e) {
                if (f21093e.size() < 5) {
                    f21093e.add(this);
                }
            }
        }

        /* renamed from: b */
        public boolean m2763b() {
            return this.f21095b != null;
        }
    }

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        m2781a(expandableListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2776a(boolean z, boolean z2) {
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.f21082b;
        int size = arrayList.size();
        this.f21083c = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int m2782a = m2782a(groupMetadata.f21090e, groupMetadata.f21089d);
                if (m2782a != groupMetadata.f21089d) {
                    if (m2782a == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.f21089d = m2782a;
                    if (!z4) {
                        z3 = true;
                        i2--;
                        z4 = z3;
                    }
                }
                z3 = z4;
                i2--;
                z4 = z3;
            }
            if (z4) {
                Collections.sort(arrayList);
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i);
            int childrenCount = (groupMetadata2.f21088c == -1 || z) ? this.f21081a.getChildrenCount(groupMetadata2.f21089d) : groupMetadata2.f21088c - groupMetadata2.f21087b;
            this.f21083c += childrenCount;
            int i5 = i4 + (groupMetadata2.f21089d - i3);
            i3 = groupMetadata2.f21089d;
            groupMetadata2.f21087b = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.f21088c = i6;
            i++;
            i4 = i6;
        }
    }

    /* renamed from: a */
    int m2782a(long j, int i) {
        int groupCount = this.f21081a.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter m2784a = m2784a();
        if (m2784a == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (m2784a.getGroupId(i3) == j) {
                return i3;
            }
            boolean z2 = min == groupCount + (-1);
            boolean z3 = i2 == 0;
            if (z2 && z3) {
                break;
            } else if (z3 || (z && !z2)) {
                min++;
                z = false;
                i3 = min;
            } else if (z2 || (!z && !z3)) {
                i2--;
                z = true;
                i3 = i2;
            }
        }
        return -1;
    }

    /* renamed from: a */
    ExpandableListAdapter m2784a() {
        return this.f21081a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C4921b m2783a(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.f21082b;
        int size = arrayList.size();
        int i5 = size - 1;
        if (size == 0) {
            return C4921b.m2764a(i, 2, i, -1, null, 0);
        }
        int i6 = i5;
        int i7 = 0;
        while (i7 <= i6) {
            i4 = ((i6 - i7) / 2) + i7;
            GroupMetadata groupMetadata = arrayList.get(i4);
            if (i > groupMetadata.f21088c) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.f21087b) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.f21087b) {
                return C4921b.m2764a(i, 2, groupMetadata.f21089d, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.f21088c) {
                    return C4921b.m2764a(i, 1, groupMetadata.f21089d, i - (groupMetadata.f21087b + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.f21088c) + groupMetadata2.f21089d;
            i2 = i7;
        } else if (i6 >= i4) {
            throw new RuntimeException("Unknown state");
        } else {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.f21089d - (groupMetadata3.f21087b - i);
        }
        return C4921b.m2764a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C4921b m2778a(C4934b c4934b) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.f21082b;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return C4921b.m2764a(c4934b.f21228c, c4934b.f21231f, c4934b.f21228c, c4934b.f21229d, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (c4934b.f21228c > groupMetadata.f21089d) {
                i4 = i + 1;
            } else if (c4934b.f21228c < groupMetadata.f21089d) {
                i3 = i - 1;
            } else if (c4934b.f21228c == groupMetadata.f21089d) {
                if (c4934b.f21231f == 2) {
                    return C4921b.m2764a(groupMetadata.f21087b, c4934b.f21231f, c4934b.f21228c, c4934b.f21229d, groupMetadata, i);
                }
                if (c4934b.f21231f != 1) {
                    return null;
                }
                return C4921b.m2764a(groupMetadata.f21087b + c4934b.f21229d + 1, c4934b.f21231f, c4934b.f21228c, c4934b.f21229d, groupMetadata, i);
            }
        }
        if (c4934b.f21231f != 2) {
            return null;
        }
        if (i4 > i) {
            GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
            return C4921b.m2764a((c4934b.f21228c - groupMetadata2.f21089d) + groupMetadata2.f21088c, c4934b.f21231f, c4934b.f21228c, c4934b.f21229d, null, i4);
        } else if (i3 >= i) {
            return null;
        } else {
            int i5 = i3 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i5);
            return C4921b.m2764a(groupMetadata3.f21087b - (groupMetadata3.f21089d - c4934b.f21228c), c4934b.f21231f, c4934b.f21228c, c4934b.f21229d, null, i5);
        }
    }

    /* renamed from: a */
    public void m2781a(ExpandableListAdapter expandableListAdapter) {
        if (this.f21081a != null) {
            this.f21081a.unregisterDataSetObserver(this.f21085e);
        }
        this.f21081a = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.f21085e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2777a(ArrayList<GroupMetadata> arrayList) {
        if (arrayList == null || this.f21081a == null) {
            return;
        }
        int groupCount = this.f21081a.getGroupCount();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f21089d >= groupCount) {
                return;
            }
        }
        this.f21082b = arrayList;
        m2776a(true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m2780a(C4921b c4921b) {
        if (c4921b.f21095b == null) {
            return false;
        }
        this.f21082b.remove(c4921b.f21095b);
        m2776a(false, false);
        notifyDataSetChanged();
        this.f21081a.onGroupCollapsed(c4921b.f21095b.f21089d);
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.f21081a.areAllItemsEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayList<GroupMetadata> m2775b() {
        return this.f21082b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m2774b(int i) {
        C4934b m2651a = C4934b.m2651a(2, i, -1, -1);
        C4921b m2778a = m2778a(m2651a);
        m2651a.m2649b();
        if (m2778a == null) {
            return false;
        }
        boolean m2780a = m2780a(m2778a);
        m2778a.m2765a();
        return m2780a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m2773b(C4921b c4921b) {
        if (c4921b.f21094a.f21228c < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.f21084d != 0 && c4921b.f21095b == null) {
            if (this.f21082b.size() >= this.f21084d) {
                GroupMetadata groupMetadata = this.f21082b.get(0);
                int indexOf = this.f21082b.indexOf(groupMetadata);
                m2774b(groupMetadata.f21089d);
                if (c4921b.f21096c > indexOf) {
                    c4921b.f21096c--;
                }
            }
            GroupMetadata m2769a = GroupMetadata.m2769a(-1, -1, c4921b.f21094a.f21228c, this.f21081a.getGroupId(c4921b.f21094a.f21228c));
            this.f21082b.add(c4921b.f21096c, m2769a);
            m2776a(false, false);
            notifyDataSetChanged();
            this.f21081a.onGroupExpanded(m2769a.f21089d);
            return true;
        }
        return false;
    }

    /* renamed from: c */
    boolean m2772c(int i) {
        C4934b m2651a = C4934b.m2651a(2, i, -1, -1);
        C4921b m2778a = m2778a(m2651a);
        m2651a.m2649b();
        boolean m2773b = m2773b(m2778a);
        m2778a.m2765a();
        return m2773b;
    }

    /* renamed from: d */
    public boolean m2771d(int i) {
        for (int size = this.f21082b.size() - 1; size >= 0; size--) {
            if (this.f21082b.get(size).f21089d == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public void m2770e(int i) {
        this.f21084d = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f21081a.getGroupCount() + this.f21083c;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter m2784a = m2784a();
        if (m2784a instanceof Filterable) {
            return ((Filterable) m2784a).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        C4921b m2783a = m2783a(i);
        if (m2783a.f21094a.f21231f == 2) {
            child = this.f21081a.getGroup(m2783a.f21094a.f21228c);
        } else if (m2783a.f21094a.f21231f != 1) {
            throw new RuntimeException("Flat list position is of unknown type");
        } else {
            child = this.f21081a.getChild(m2783a.f21094a.f21228c, m2783a.f21094a.f21229d);
        }
        m2783a.m2765a();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        C4921b m2783a = m2783a(i);
        long groupId = this.f21081a.getGroupId(m2783a.f21094a.f21228c);
        if (m2783a.f21094a.f21231f == 2) {
            combinedChildId = this.f21081a.getCombinedGroupId(groupId);
        } else if (m2783a.f21094a.f21231f != 1) {
            throw new RuntimeException("Flat list position is of unknown type");
        } else {
            combinedChildId = this.f21081a.getCombinedChildId(groupId, this.f21081a.getChildId(m2783a.f21094a.f21228c, m2783a.f21094a.f21229d));
        }
        m2783a.m2765a();
        return combinedChildId;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        C4921b m2783a = m2783a(i);
        C4934b c4934b = m2783a.f21094a;
        if (this.f21081a instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.f21081a;
            i2 = c4934b.f21231f == 2 ? heterogeneousExpandableList.getGroupType(c4934b.f21228c) : heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(c4934b.f21228c, c4934b.f21229d);
        } else {
            i2 = c4934b.f21231f == 2 ? 0 : 1;
        }
        m2783a.m2765a();
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        boolean z = true;
        C4921b m2783a = m2783a(i);
        if (m2783a.f21094a.f21231f == 2) {
            childView = this.f21081a.getGroupView(m2783a.f21094a.f21228c, m2783a.m2763b(), view, viewGroup);
        } else if (m2783a.f21094a.f21231f != 1) {
            throw new RuntimeException("Flat list position is of unknown type");
        } else {
            if (m2783a.f21095b.f21088c != i) {
                z = false;
            }
            childView = this.f21081a.getChildView(m2783a.f21094a.f21228c, m2783a.f21094a.f21229d, z, view, viewGroup);
        }
        m2783a.m2765a();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.f21081a instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.f21081a;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.f21081a.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter m2784a = m2784a();
        if (m2784a != null) {
            return m2784a.isEmpty();
        }
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        boolean z = true;
        C4921b m2783a = m2783a(i);
        C4934b c4934b = m2783a.f21094a;
        if (c4934b.f21231f == 1) {
            z = this.f21081a.isChildSelectable(c4934b.f21228c, c4934b.f21229d);
        }
        m2783a.m2765a();
        return z;
    }
}
