package cn.sharesdk.framework.utils;
/* renamed from: cn.sharesdk.framework.utils.e */
/* loaded from: classes.dex */
public abstract class AbstractC0685e implements Escaper {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn.sharesdk.framework.utils.e$a */
    /* loaded from: classes.dex */
    public static final class C0687a extends ThreadLocal<char[]> {
        private C0687a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    /* renamed from: a */
    private static final char[] m19508a(char[] cArr, int i, int i2) {
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }

    /* renamed from: b */
    protected static final int m19507b(CharSequence charSequence, int i, int i2) {
        if (i < i2) {
            char charAt = charSequence.charAt(i);
            int i3 = i + 1;
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                throw new IllegalArgumentException("Unexpected low surrogate character '" + charAt + "' with value " + ((int) charAt) + " at index " + (i3 - 1));
            }
            if (i3 == i2) {
                return -charAt;
            }
            char charAt2 = charSequence.charAt(i3);
            if (!Character.isLowSurrogate(charAt2)) {
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + ((int) charAt2) + " at index " + i3);
            }
            return Character.toCodePoint(charAt, charAt2);
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    /* renamed from: a */
    protected int mo19510a(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int m19507b = m19507b(charSequence, i, i2);
            if (m19507b < 0 || mo19511a(m19507b) != null) {
                break;
            }
            i += Character.isSupplementaryCodePoint(m19507b) ? 2 : 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final String m19509a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        char[] cArr = new C0687a().get();
        int i3 = 0;
        while (i < length) {
            int m19507b = m19507b(str, i, length);
            if (m19507b < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] mo19511a = mo19511a(m19507b);
            if (mo19511a != null) {
                int i4 = i - i2;
                int length2 = i3 + i4 + mo19511a.length;
                if (cArr.length < length2) {
                    cArr = m19508a(cArr, i3, length2 + (length - i) + 32);
                }
                if (i4 > 0) {
                    str.getChars(i2, i, cArr, i3);
                    i3 += i4;
                }
                if (mo19511a.length > 0) {
                    System.arraycopy(mo19511a, 0, cArr, i3, mo19511a.length);
                    i3 += mo19511a.length;
                }
            }
            int i5 = (Character.isSupplementaryCodePoint(m19507b) ? 2 : 1) + i;
            i = mo19510a(str, i5, length);
            i2 = i5;
        }
        int i6 = length - i2;
        if (i6 > 0) {
            int i7 = i6 + i3;
            if (cArr.length < i7) {
                cArr = m19508a(cArr, i3, i7);
            }
            str.getChars(i2, length, cArr, i3);
            i3 = i7;
        }
        return new String(cArr, 0, i3);
    }

    /* renamed from: a */
    protected abstract char[] mo19511a(int i);

    @Override // cn.sharesdk.framework.utils.Escaper
    public Appendable escape(final Appendable appendable) {
        C0682c.m19514a(appendable);
        return new Appendable() { // from class: cn.sharesdk.framework.utils.e.1

            /* renamed from: a */
            int f1623a = -1;

            /* renamed from: b */
            char[] f1624b = new char[2];

            /* renamed from: a */
            private void m19506a(char[] cArr, int i) {
                for (int i2 = 0; i2 < i; i2++) {
                    appendable.append(cArr[i2]);
                }
            }

            @Override // java.lang.Appendable
            public Appendable append(char c) {
                if (this.f1623a != -1) {
                    if (!Character.isLowSurrogate(c)) {
                        throw new IllegalArgumentException("Expected low surrogate character but got '" + c + "' with value " + ((int) c));
                    }
                    char[] mo19511a = AbstractC0685e.this.mo19511a(Character.toCodePoint((char) this.f1623a, c));
                    if (mo19511a != null) {
                        m19506a(mo19511a, mo19511a.length);
                    } else {
                        appendable.append((char) this.f1623a);
                        appendable.append(c);
                    }
                    this.f1623a = -1;
                } else if (Character.isHighSurrogate(c)) {
                    this.f1623a = c;
                } else if (Character.isLowSurrogate(c)) {
                    throw new IllegalArgumentException("Unexpected low surrogate character '" + c + "' with value " + ((int) c));
                } else {
                    char[] mo19511a2 = AbstractC0685e.this.mo19511a(c);
                    if (mo19511a2 != null) {
                        m19506a(mo19511a2, mo19511a2.length);
                    } else {
                        appendable.append(c);
                    }
                }
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence) {
                return append(charSequence, 0, charSequence.length());
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence, int i, int i2) {
                int i3;
                if (i < i2) {
                    if (this.f1623a != -1) {
                        char charAt = charSequence.charAt(i);
                        i3 = i + 1;
                        if (!Character.isLowSurrogate(charAt)) {
                            throw new IllegalArgumentException("Expected low surrogate character but got " + charAt);
                        }
                        char[] mo19511a = AbstractC0685e.this.mo19511a(Character.toCodePoint((char) this.f1623a, charAt));
                        if (mo19511a != null) {
                            m19506a(mo19511a, mo19511a.length);
                            i++;
                        } else {
                            appendable.append((char) this.f1623a);
                        }
                        this.f1623a = -1;
                    } else {
                        i3 = i;
                    }
                    while (true) {
                        int mo19510a = AbstractC0685e.this.mo19510a(charSequence, i3, i2);
                        if (mo19510a > i) {
                            appendable.append(charSequence, i, mo19510a);
                        }
                        if (mo19510a == i2) {
                            break;
                        }
                        int m19507b = AbstractC0685e.m19507b(charSequence, mo19510a, i2);
                        if (m19507b < 0) {
                            this.f1623a = -m19507b;
                            break;
                        }
                        char[] mo19511a2 = AbstractC0685e.this.mo19511a(m19507b);
                        if (mo19511a2 != null) {
                            m19506a(mo19511a2, mo19511a2.length);
                        } else {
                            m19506a(this.f1624b, Character.toChars(m19507b, this.f1624b, 0));
                        }
                        i = mo19510a + (Character.isSupplementaryCodePoint(m19507b) ? 2 : 1);
                        i3 = i;
                    }
                }
                return this;
            }
        };
    }

    @Override // cn.sharesdk.framework.utils.Escaper
    public String escape(String str) {
        int length = str.length();
        int mo19510a = mo19510a(str, 0, length);
        return mo19510a == length ? str : m19509a(str, mo19510a);
    }
}
