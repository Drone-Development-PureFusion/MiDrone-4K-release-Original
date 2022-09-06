package com.p113c.p114a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* renamed from: com.c.a.b */
/* loaded from: classes.dex */
public class C1777b {

    /* renamed from: b */
    private static final int f6286b = 0;

    /* renamed from: d */
    private static final int f6288d = 0;

    /* renamed from: f */
    private static final int f6290f = 0;

    /* renamed from: g */
    private static final int f6291g = 1;

    /* renamed from: h */
    private static final int f6292h = 2;

    /* renamed from: i */
    private static final int f6293i = 3;

    /* renamed from: j */
    private static final int f6294j = 4;

    /* renamed from: k */
    private static final int f6295k = 5;

    /* renamed from: l */
    private static final int f6296l = 6;

    /* renamed from: m */
    private static final int f6297m = 7;

    /* renamed from: n */
    private static final int f6298n = 0;

    /* renamed from: o */
    private static final int f6299o = 0;

    /* renamed from: a */
    private static final int[] f6285a = {16843490};

    /* renamed from: c */
    private static final int[] f6287c = {16843489};

    /* renamed from: e */
    private static final int[] f6289e = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};

    /* renamed from: a */
    public static AbstractC1775a m14668a(Context context, int i) {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = context.getResources().getAnimation(i);
                    return m14665a(context, (XmlPullParser) xmlResourceParser);
                } catch (XmlPullParserException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (IOException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* renamed from: a */
    private static AbstractC1775a m14665a(Context context, XmlPullParser xmlPullParser) {
        return m14664a(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    /* renamed from: a */
    private static AbstractC1775a m14664a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, C1779d c1779d, int i) {
        ArrayList arrayList;
        int i2 = 0;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList2 = null;
        AbstractC1775a abstractC1775a = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        abstractC1775a = m14667a(context, attributeSet);
                    } else if (name.equals("animator")) {
                        abstractC1775a = m14666a(context, attributeSet, null);
                    } else if (!name.equals("set")) {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    } else {
                        abstractC1775a = new C1779d();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6285a);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        m14664a(context, xmlPullParser, attributeSet, (C1779d) abstractC1775a, typedValue.type == 16 ? typedValue.data : 0);
                        obtainStyledAttributes.recycle();
                    }
                    if (c1779d != null) {
                        arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList.add(abstractC1775a);
                    } else {
                        arrayList = arrayList2;
                    }
                    arrayList2 = arrayList;
                }
            }
        }
        if (c1779d != null && arrayList2 != null) {
            AbstractC1775a[] abstractC1775aArr = new AbstractC1775a[arrayList2.size()];
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                abstractC1775aArr[i2] = (AbstractC1775a) it2.next();
                i2++;
            }
            if (i == 0) {
                c1779d.m14658a(abstractC1775aArr);
            } else {
                c1779d.m14656b(abstractC1775aArr);
            }
        }
        return abstractC1775a;
    }

    /* renamed from: a */
    private static C1796l m14667a(Context context, AttributeSet attributeSet) {
        C1796l c1796l = new C1796l();
        m14666a(context, attributeSet, c1796l);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6287c);
        c1796l.m14600a(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return c1796l;
    }

    /* renamed from: a */
    private static C1819q m14666a(Context context, AttributeSet attributeSet, C1819q c1819q) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6289e);
        long j = obtainStyledAttributes.getInt(1, 0);
        long j2 = obtainStyledAttributes.getInt(2, 0);
        int i = obtainStyledAttributes.getInt(7, 0);
        if (c1819q == null) {
            c1819q = new C1819q();
        }
        boolean z = i == 0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean z2 = peekValue != null;
        int i2 = z2 ? peekValue.type : 0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean z3 = peekValue2 != null;
        int i3 = z3 ? peekValue2.type : 0;
        if ((z2 && i2 >= 28 && i2 <= 31) || (z3 && i3 >= 28 && i3 <= 31)) {
            z = false;
            c1819q.m14516a((AbstractC1818p) new C1786e());
        }
        if (z) {
            if (z2) {
                float dimension = i2 == 5 ? obtainStyledAttributes.getDimension(5, 0.0f) : obtainStyledAttributes.getFloat(5, 0.0f);
                if (z3) {
                    c1819q.mo14509a(dimension, i3 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
                } else {
                    c1819q.mo14509a(dimension);
                }
            } else {
                c1819q.mo14509a(i3 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
            }
        } else if (z2) {
            int dimension2 = i2 == 5 ? (int) obtainStyledAttributes.getDimension(5, 0.0f) : (i2 < 28 || i2 > 31) ? obtainStyledAttributes.getInt(5, 0) : obtainStyledAttributes.getColor(5, 0);
            if (z3) {
                c1819q.mo14508a(dimension2, i3 == 5 ? (int) obtainStyledAttributes.getDimension(6, 0.0f) : (i3 < 28 || i3 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0));
            } else {
                c1819q.mo14508a(dimension2);
            }
        } else if (z3) {
            c1819q.mo14508a(i3 == 5 ? (int) obtainStyledAttributes.getDimension(6, 0.0f) : (i3 < 28 || i3 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0));
        }
        c1819q.mo14503b(j);
        c1819q.mo14518a(j2);
        if (obtainStyledAttributes.hasValue(3)) {
            c1819q.m14519a(obtainStyledAttributes.getInt(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            c1819q.m14504b(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            c1819q.mo14517a(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
        return c1819q;
    }
}
