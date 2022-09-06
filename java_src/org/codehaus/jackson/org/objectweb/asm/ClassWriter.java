package org.codehaus.jackson.org.objectweb.asm;

import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import com.xiaomi.infra.galaxy.fds.android.util.Consts;
import it.p235a.p236a.AbstractC4863e;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public class ClassWriter implements ClassVisitor {
    public static final int COMPUTE_FRAMES = 2;
    public static final int COMPUTE_MAXS = 1;

    /* renamed from: a */
    static final byte[] f22824a;

    /* renamed from: A */
    MethodWriter f22825A;

    /* renamed from: B */
    MethodWriter f22826B;

    /* renamed from: D */
    private short f22827D;

    /* renamed from: E */
    Item[] f22828E;

    /* renamed from: F */
    String f22829F;

    /* renamed from: G */
    private final boolean f22830G;

    /* renamed from: H */
    private final boolean f22831H;

    /* renamed from: I */
    boolean f22832I;

    /* renamed from: J */
    ClassReader f22833J;

    /* renamed from: b */
    int f22834b;

    /* renamed from: c */
    int f22835c;

    /* renamed from: d */
    final ByteVector f22836d;

    /* renamed from: e */
    Item[] f22837e;

    /* renamed from: f */
    int f22838f;

    /* renamed from: g */
    final Item f22839g;

    /* renamed from: h */
    final Item f22840h;

    /* renamed from: i */
    final Item f22841i;

    /* renamed from: j */
    private int f22842j;

    /* renamed from: k */
    private int f22843k;

    /* renamed from: l */
    private int f22844l;

    /* renamed from: m */
    private int f22845m;

    /* renamed from: n */
    private int f22846n;

    /* renamed from: o */
    private int[] f22847o;

    /* renamed from: p */
    private int f22848p;

    /* renamed from: q */
    private ByteVector f22849q;

    /* renamed from: r */
    private int f22850r;

    /* renamed from: s */
    private int f22851s;

    /* renamed from: t */
    private AnnotationWriter f22852t;

    /* renamed from: u */
    private AnnotationWriter f22853u;

    /* renamed from: v */
    private Attribute f22854v;

    /* renamed from: w */
    private int f22855w;

    /* renamed from: x */
    private ByteVector f22856x;

    /* renamed from: y */
    FieldWriter f22857y;

    /* renamed from: z */
    FieldWriter f22858z;

    static {
        byte[] bArr = new byte[AbstractC4863e.f20780A];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ("AAAAAAAAAAAAAAAABCKLLDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAAAAAAAAAAAAAAAAAAIIIIIIIIIIIIIIIIDNOAAAAAAGGGGGGGHHFBFAAFFAAQPIIJJIIIIIIIIIIIIIIIIII".charAt(i) - 'A');
        }
        f22824a = bArr;
    }

    public ClassWriter(int i) {
        boolean z = true;
        this.f22835c = 1;
        this.f22836d = new ByteVector();
        this.f22837e = new Item[256];
        this.f22838f = (int) (0.75d * this.f22837e.length);
        this.f22839g = new Item();
        this.f22840h = new Item();
        this.f22841i = new Item();
        this.f22831H = (i & 1) != 0;
        this.f22830G = (i & 2) == 0 ? false : z;
    }

    public ClassWriter(ClassReader classReader, int i) {
        this(i);
        classReader.m261a(this);
        this.f22833J = classReader;
    }

    /* renamed from: a */
    private Item m246a(Item item) {
        Item item2 = this.f22837e[item.f22894j % this.f22837e.length];
        while (item2 != null && (item2.f22888b != item.f22888b || !item.m220a(item2))) {
            item2 = item2.f22895k;
        }
        return item2;
    }

    /* renamed from: a */
    private void m254a(int i, int i2, int i3) {
        this.f22836d.m267b(i, i2).putShort(i3);
    }

    /* renamed from: b */
    private Item m245b(String str) {
        this.f22840h.m222a(8, str, null, null);
        Item m246a = m246a(this.f22840h);
        if (m246a == null) {
            this.f22836d.m267b(8, newUTF8(str));
            int i = this.f22835c;
            this.f22835c = i + 1;
            Item item = new Item(i, this.f22840h);
            m244b(item);
            return item;
        }
        return m246a;
    }

    /* renamed from: b */
    private void m244b(Item item) {
        if (this.f22835c > this.f22838f) {
            int length = this.f22837e.length;
            int i = (length * 2) + 1;
            Item[] itemArr = new Item[i];
            for (int i2 = length - 1; i2 >= 0; i2--) {
                Item item2 = this.f22837e[i2];
                while (item2 != null) {
                    int length2 = item2.f22894j % itemArr.length;
                    Item item3 = item2.f22895k;
                    item2.f22895k = itemArr[length2];
                    itemArr[length2] = item2;
                    item2 = item3;
                }
            }
            this.f22837e = itemArr;
            this.f22838f = (int) (i * 0.75d);
        }
        int length3 = item.f22894j % this.f22837e.length;
        item.f22895k = this.f22837e[length3];
        this.f22837e[length3] = item;
    }

    /* renamed from: c */
    private Item m242c(Item item) {
        this.f22827D = (short) (this.f22827D + 1);
        Item item2 = new Item(this.f22827D, this.f22839g);
        m244b(item2);
        if (this.f22828E == null) {
            this.f22828E = new Item[16];
        }
        if (this.f22827D == this.f22828E.length) {
            Item[] itemArr = new Item[this.f22828E.length * 2];
            System.arraycopy(this.f22828E, 0, itemArr, 0, this.f22828E.length);
            this.f22828E = itemArr;
        }
        this.f22828E[this.f22827D] = item2;
        return item2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m255a(int i, int i2) {
        this.f22840h.f22888b = 15;
        this.f22840h.f22890d = i | (i2 << 32);
        this.f22840h.f22894j = Integer.MAX_VALUE & (i + 15 + i2);
        Item m246a = m246a(this.f22840h);
        if (m246a == null) {
            String str = this.f22828E[i].f22891g;
            String str2 = this.f22828E[i2].f22891g;
            this.f22840h.f22889c = m243c(getCommonSuperClass(str, str2));
            m246a = new Item(0, this.f22840h);
            m244b(m246a);
        }
        return m246a.f22889c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m250a(String str, int i) {
        this.f22839g.f22888b = 14;
        this.f22839g.f22889c = i;
        this.f22839g.f22891g = str;
        this.f22839g.f22894j = Integer.MAX_VALUE & (str.hashCode() + 14 + i);
        Item m246a = m246a(this.f22839g);
        if (m246a == null) {
            m246a = m242c(this.f22839g);
        }
        return m246a.f22887a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m258a(double d) {
        this.f22839g.m225a(d);
        Item m246a = m246a(this.f22839g);
        if (m246a == null) {
            this.f22836d.putByte(6).putLong(this.f22839g.f22890d);
            Item item = new Item(this.f22835c, this.f22839g);
            m244b(item);
            this.f22835c += 2;
            return item;
        }
        return m246a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m257a(float f) {
        this.f22839g.m224a(f);
        Item m246a = m246a(this.f22839g);
        if (m246a == null) {
            this.f22836d.putByte(4).putInt(this.f22839g.f22889c);
            int i = this.f22835c;
            this.f22835c = i + 1;
            Item item = new Item(i, this.f22839g);
            m244b(item);
            return item;
        }
        return m246a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m256a(int i) {
        this.f22839g.m223a(i);
        Item m246a = m246a(this.f22839g);
        if (m246a == null) {
            this.f22836d.putByte(3).putInt(i);
            int i2 = this.f22835c;
            this.f22835c = i2 + 1;
            Item item = new Item(i2, this.f22839g);
            m244b(item);
            return item;
        }
        return m246a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m253a(long j) {
        this.f22839g.m221a(j);
        Item m246a = m246a(this.f22839g);
        if (m246a == null) {
            this.f22836d.putByte(5).putLong(j);
            Item item = new Item(this.f22835c, this.f22839g);
            m244b(item);
            this.f22835c += 2;
            return item;
        }
        return m246a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m252a(Object obj) {
        if (obj instanceof Integer) {
            return m256a(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return m256a(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return m256a((int) ((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return m256a(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return m256a(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return m257a(((Float) obj).floatValue());
        } else {
            if (obj instanceof Long) {
                return m253a(((Long) obj).longValue());
            }
            if (obj instanceof Double) {
                return m258a(((Double) obj).doubleValue());
            }
            if (obj instanceof String) {
                return m245b((String) obj);
            }
            if (!(obj instanceof Type)) {
                throw new IllegalArgumentException(new StringBuffer().append("value ").append(obj).toString());
            }
            Type type = (Type) obj;
            return m251a(type.getSort() == 10 ? type.getInternalName() : type.getDescriptor());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m251a(String str) {
        this.f22840h.m222a(7, str, null, null);
        Item m246a = m246a(this.f22840h);
        if (m246a == null) {
            this.f22836d.m267b(7, newUTF8(str));
            int i = this.f22835c;
            this.f22835c = i + 1;
            Item item = new Item(i, this.f22840h);
            m244b(item);
            return item;
        }
        return m246a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m249a(String str, String str2) {
        this.f22840h.m222a(12, str, str2, null);
        Item m246a = m246a(this.f22840h);
        if (m246a == null) {
            m254a(12, newUTF8(str), newUTF8(str2));
            int i = this.f22835c;
            this.f22835c = i + 1;
            Item item = new Item(i, this.f22840h);
            m244b(item);
            return item;
        }
        return m246a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m248a(String str, String str2, String str3) {
        this.f22841i.m222a(9, str, str2, str3);
        Item m246a = m246a(this.f22841i);
        if (m246a == null) {
            m254a(9, newClass(str), newNameType(str2, str3));
            int i = this.f22835c;
            this.f22835c = i + 1;
            Item item = new Item(i, this.f22841i);
            m244b(item);
            return item;
        }
        return m246a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m247a(String str, String str2, String str3, boolean z) {
        int i = z ? 11 : 10;
        this.f22841i.m222a(i, str, str2, str3);
        Item m246a = m246a(this.f22841i);
        if (m246a == null) {
            m254a(i, newClass(str), newNameType(str2, str3));
            int i2 = this.f22835c;
            this.f22835c = i2 + 1;
            Item item = new Item(i2, this.f22841i);
            m244b(item);
            return item;
        }
        return m246a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m243c(String str) {
        this.f22839g.m222a(13, str, null, null);
        Item m246a = m246a(this.f22839g);
        if (m246a == null) {
            m246a = m242c(this.f22839g);
        }
        return m246a.f22887a;
    }

    protected String getCommonSuperClass(String str, String str2) {
        try {
            Class<?> cls = Class.forName(str.replace('/', C0359h.f677G));
            Class<?> cls2 = Class.forName(str2.replace('/', C0359h.f677G));
            if (cls.isAssignableFrom(cls2)) {
                return str;
            }
            if (cls2.isAssignableFrom(cls)) {
                return str2;
            }
            if (cls.isInterface() || cls2.isInterface()) {
                return "java/lang/Object";
            }
            do {
                cls = cls.getSuperclass();
            } while (!cls.isAssignableFrom(cls2));
            return cls.getName().replace(C0359h.f677G, '/');
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    public int newClass(String str) {
        return m251a(str).f22887a;
    }

    public int newConst(Object obj) {
        return m252a(obj).f22887a;
    }

    public int newField(String str, String str2, String str3) {
        return m248a(str, str2, str3).f22887a;
    }

    public int newMethod(String str, String str2, String str3, boolean z) {
        return m247a(str, str2, str3, z).f22887a;
    }

    public int newNameType(String str, String str2) {
        return m249a(str, str2).f22887a;
    }

    public int newUTF8(String str) {
        this.f22839g.m222a(1, str, null, null);
        Item m246a = m246a(this.f22839g);
        if (m246a == null) {
            this.f22836d.putByte(1).putUTF8(str);
            int i = this.f22835c;
            this.f22835c = i + 1;
            m246a = new Item(i, this.f22839g);
            m244b(m246a);
        }
        return m246a.f22887a;
    }

    public byte[] toByteArray() {
        int i;
        int i2 = (this.f22846n * 2) + 24;
        FieldWriter fieldWriter = this.f22857y;
        int i3 = 0;
        while (fieldWriter != null) {
            i2 += fieldWriter.m241a();
            fieldWriter = fieldWriter.f22862a;
            i3++;
        }
        MethodWriter methodWriter = this.f22825A;
        int i4 = 0;
        while (methodWriter != null) {
            i2 += methodWriter.m211a();
            methodWriter = methodWriter.f22927a;
            i4++;
        }
        if (this.f22844l != 0) {
            i = 1;
            i2 += 8;
            newUTF8(Consts.SIGNATURE);
        } else {
            i = 0;
        }
        if (this.f22848p != 0) {
            i++;
            i2 += 8;
            newUTF8("SourceFile");
        }
        if (this.f22849q != null) {
            i++;
            i2 += this.f22849q.f22818b + 4;
            newUTF8("SourceDebugExtension");
        }
        if (this.f22850r != 0) {
            i++;
            i2 += 10;
            newUTF8("EnclosingMethod");
        }
        if ((this.f22842j & 131072) != 0) {
            i++;
            i2 += 6;
            newUTF8("Deprecated");
        }
        if ((this.f22842j & 4096) != 0 && ((this.f22834b & 65535) < 49 || (this.f22842j & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0)) {
            i++;
            i2 += 6;
            newUTF8("Synthetic");
        }
        if (this.f22856x != null) {
            i++;
            i2 += this.f22856x.f22818b + 8;
            newUTF8("InnerClasses");
        }
        if (this.f22852t != null) {
            i++;
            i2 += this.f22852t.m275a() + 8;
            newUTF8("RuntimeVisibleAnnotations");
        }
        if (this.f22853u != null) {
            i++;
            i2 += this.f22853u.m275a() + 8;
            newUTF8("RuntimeInvisibleAnnotations");
        }
        int i5 = i2;
        if (this.f22854v != null) {
            int m272a = i + this.f22854v.m272a();
            i5 += this.f22854v.m271a(this, null, 0, -1, -1);
            i = m272a;
        }
        ByteVector byteVector = new ByteVector(this.f22836d.f22818b + i5);
        byteVector.putInt(-889275714).putInt(this.f22834b);
        byteVector.putShort(this.f22835c).putByteArray(this.f22836d.f22817a, 0, this.f22836d.f22818b);
        byteVector.putShort(((393216 | ((this.f22842j & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) / 64)) ^ (-1)) & this.f22842j).putShort(this.f22843k).putShort(this.f22845m);
        byteVector.putShort(this.f22846n);
        for (int i6 = 0; i6 < this.f22846n; i6++) {
            byteVector.putShort(this.f22847o[i6]);
        }
        byteVector.putShort(i3);
        for (FieldWriter fieldWriter2 = this.f22857y; fieldWriter2 != null; fieldWriter2 = fieldWriter2.f22862a) {
            fieldWriter2.m240a(byteVector);
        }
        byteVector.putShort(i4);
        for (MethodWriter methodWriter2 = this.f22825A; methodWriter2 != null; methodWriter2 = methodWriter2.f22927a) {
            methodWriter2.m206a(byteVector);
        }
        byteVector.putShort(i);
        if (this.f22844l != 0) {
            byteVector.putShort(newUTF8(Consts.SIGNATURE)).putInt(2).putShort(this.f22844l);
        }
        if (this.f22848p != 0) {
            byteVector.putShort(newUTF8("SourceFile")).putInt(2).putShort(this.f22848p);
        }
        if (this.f22849q != null) {
            int i7 = this.f22849q.f22818b - 2;
            byteVector.putShort(newUTF8("SourceDebugExtension")).putInt(i7);
            byteVector.putByteArray(this.f22849q.f22817a, 2, i7);
        }
        if (this.f22850r != 0) {
            byteVector.putShort(newUTF8("EnclosingMethod")).putInt(4);
            byteVector.putShort(this.f22850r).putShort(this.f22851s);
        }
        if ((this.f22842j & 131072) != 0) {
            byteVector.putShort(newUTF8("Deprecated")).putInt(0);
        }
        if ((this.f22842j & 4096) != 0 && ((this.f22834b & 65535) < 49 || (this.f22842j & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0)) {
            byteVector.putShort(newUTF8("Synthetic")).putInt(0);
        }
        if (this.f22856x != null) {
            byteVector.putShort(newUTF8("InnerClasses"));
            byteVector.putInt(this.f22856x.f22818b + 2).putShort(this.f22855w);
            byteVector.putByteArray(this.f22856x.f22817a, 0, this.f22856x.f22818b);
        }
        if (this.f22852t != null) {
            byteVector.putShort(newUTF8("RuntimeVisibleAnnotations"));
            this.f22852t.m274a(byteVector);
        }
        if (this.f22853u != null) {
            byteVector.putShort(newUTF8("RuntimeInvisibleAnnotations"));
            this.f22853u.m274a(byteVector);
        }
        if (this.f22854v != null) {
            this.f22854v.m270a(this, null, 0, -1, -1, byteVector);
        }
        if (this.f22832I) {
            ClassWriter classWriter = new ClassWriter(2);
            new ClassReader(byteVector.f22817a).accept(classWriter, 4);
            return classWriter.toByteArray();
        }
        return byteVector.f22817a;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.f22834b = i;
        this.f22842j = i2;
        this.f22843k = newClass(str);
        this.f22829F = str;
        if (str2 != null) {
            this.f22844l = newUTF8(str2);
        }
        this.f22845m = str3 == null ? 0 : newClass(str3);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.f22846n = strArr.length;
        this.f22847o = new int[this.f22846n];
        for (int i3 = 0; i3 < this.f22846n; i3++) {
            this.f22847o[i3] = newClass(strArr[i3]);
        }
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, 2);
        if (z) {
            annotationWriter.f22813g = this.f22852t;
            this.f22852t = annotationWriter;
        } else {
            annotationWriter.f22813g = this.f22853u;
            this.f22853u = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visitAttribute(Attribute attribute) {
        attribute.f22815a = this.f22854v;
        this.f22854v = attribute;
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visitEnd() {
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        return new FieldWriter(this, i, str, str2, str3, obj);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visitInnerClass(String str, String str2, String str3, int i) {
        int i2 = 0;
        if (this.f22856x == null) {
            this.f22856x = new ByteVector();
        }
        this.f22855w++;
        this.f22856x.putShort(str == null ? 0 : newClass(str));
        this.f22856x.putShort(str2 == null ? 0 : newClass(str2));
        ByteVector byteVector = this.f22856x;
        if (str3 != null) {
            i2 = newUTF8(str3);
        }
        byteVector.putShort(i2);
        this.f22856x.putShort(i);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        return new MethodWriter(this, i, str, str2, str3, strArr, this.f22831H, this.f22830G);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visitOuterClass(String str, String str2, String str3) {
        this.f22850r = newClass(str);
        if (str2 == null || str3 == null) {
            return;
        }
        this.f22851s = newNameType(str2, str3);
    }

    @Override // org.codehaus.jackson.org.objectweb.asm.ClassVisitor
    public void visitSource(String str, String str2) {
        if (str != null) {
            this.f22848p = newUTF8(str);
        }
        if (str2 != null) {
            this.f22849q = new ByteVector().putUTF8(str2);
        }
    }
}
