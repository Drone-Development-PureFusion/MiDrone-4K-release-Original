package org.codehaus.jackson.org.objectweb.asm;
/* loaded from: classes2.dex */
final class Item {

    /* renamed from: a */
    int f22887a;

    /* renamed from: b */
    int f22888b;

    /* renamed from: c */
    int f22889c;

    /* renamed from: d */
    long f22890d;

    /* renamed from: g */
    String f22891g;

    /* renamed from: h */
    String f22892h;

    /* renamed from: i */
    String f22893i;

    /* renamed from: j */
    int f22894j;

    /* renamed from: k */
    Item f22895k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item(int i) {
        this.f22887a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item(int i, Item item) {
        this.f22887a = i;
        this.f22888b = item.f22888b;
        this.f22889c = item.f22889c;
        this.f22890d = item.f22890d;
        this.f22891g = item.f22891g;
        this.f22892h = item.f22892h;
        this.f22893i = item.f22893i;
        this.f22894j = item.f22894j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m225a(double d) {
        this.f22888b = 6;
        this.f22890d = Double.doubleToRawLongBits(d);
        this.f22894j = Integer.MAX_VALUE & (this.f22888b + ((int) d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m224a(float f) {
        this.f22888b = 4;
        this.f22889c = Float.floatToRawIntBits(f);
        this.f22894j = Integer.MAX_VALUE & (this.f22888b + ((int) f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m223a(int i) {
        this.f22888b = 3;
        this.f22889c = i;
        this.f22894j = Integer.MAX_VALUE & (this.f22888b + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m222a(int i, String str, String str2, String str3) {
        this.f22888b = i;
        this.f22891g = str;
        this.f22892h = str2;
        this.f22893i = str3;
        switch (i) {
            case 1:
            case 7:
            case 8:
            case 13:
                this.f22894j = (str.hashCode() + i) & Integer.MAX_VALUE;
                return;
            case 12:
                this.f22894j = ((str.hashCode() * str2.hashCode()) + i) & Integer.MAX_VALUE;
                return;
            default:
                this.f22894j = ((str.hashCode() * str2.hashCode() * str3.hashCode()) + i) & Integer.MAX_VALUE;
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m221a(long j) {
        this.f22888b = 5;
        this.f22890d = j;
        this.f22894j = Integer.MAX_VALUE & (this.f22888b + ((int) j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m220a(Item item) {
        switch (this.f22888b) {
            case 1:
            case 7:
            case 8:
            case 13:
                return item.f22891g.equals(this.f22891g);
            case 2:
            case 9:
            case 10:
            case 11:
            default:
                return item.f22891g.equals(this.f22891g) && item.f22892h.equals(this.f22892h) && item.f22893i.equals(this.f22893i);
            case 3:
            case 4:
                return item.f22889c == this.f22889c;
            case 5:
            case 6:
            case 15:
                return item.f22890d == this.f22890d;
            case 12:
                return item.f22891g.equals(this.f22891g) && item.f22892h.equals(this.f22892h);
            case 14:
                return item.f22889c == this.f22889c && item.f22891g.equals(this.f22891g);
        }
    }
}
