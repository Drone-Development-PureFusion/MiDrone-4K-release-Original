package org.codehaus.jackson.org.objectweb.asm;

import android.support.p001v4.view.GravityCompat;
import android.support.p001v4.view.ViewCompat;
import com.fimi.soul.module.setting.newhand.C3530b;
import com.hoho.android.usbserial.driver.UsbId;
import com.p118d.p119a.p136c.C1947c;
import org.codehaus.jackson.smile.SmileConstants;
import p004b.p005a.p006a.p028b.p041h.C0409j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Frame {

    /* renamed from: a */
    static final int[] f22872a;

    /* renamed from: b */
    Label f22873b;

    /* renamed from: c */
    int[] f22874c;

    /* renamed from: d */
    int[] f22875d;

    /* renamed from: e */
    private int[] f22876e;

    /* renamed from: f */
    private int[] f22877f;

    /* renamed from: g */
    private int f22878g;

    /* renamed from: h */
    private int f22879h;

    /* renamed from: i */
    private int[] f22880i;

    static {
        int[] iArr = new int[202];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i) - 'E';
        }
        f22872a = iArr;
    }

    /* renamed from: a */
    private int m239a() {
        if (this.f22878g > 0) {
            int[] iArr = this.f22877f;
            int i = this.f22878g - 1;
            this.f22878g = i;
            return iArr[i];
        }
        Label label = this.f22873b;
        int i2 = label.f22901f - 1;
        label.f22901f = i2;
        return 50331648 | (-i2);
    }

    /* renamed from: a */
    private int m238a(int i) {
        if (this.f22876e == null || i >= this.f22876e.length) {
            return 33554432 | i;
        }
        int i2 = this.f22876e[i];
        if (i2 != 0) {
            return i2;
        }
        int i3 = 33554432 | i;
        this.f22876e[i] = i3;
        return i3;
    }

    /* renamed from: a */
    private int m234a(ClassWriter classWriter, int i) {
        int m243c;
        if (i == 16777222) {
            m243c = classWriter.m243c(classWriter.f22829F) | 24117248;
        } else if (((-1048576) & i) != 25165824) {
            return i;
        } else {
            m243c = classWriter.m243c(classWriter.f22828E[1048575 & i].f22891g) | 24117248;
        }
        for (int i2 = 0; i2 < this.f22879h; i2++) {
            int i3 = this.f22880i[i2];
            int i4 = (-268435456) & i3;
            int i5 = 251658240 & i3;
            if (i5 == 33554432) {
                i3 = this.f22874c[i3 & 8388607] + i4;
            } else if (i5 == 50331648) {
                i3 = this.f22875d[this.f22875d.length - (i3 & 8388607)] + i4;
            }
            if (i == i3) {
                return m243c;
            }
        }
        return i;
    }

    /* renamed from: a */
    private void m237a(int i, int i2) {
        if (this.f22876e == null) {
            this.f22876e = new int[10];
        }
        int length = this.f22876e.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.f22876e, 0, iArr, 0, length);
            this.f22876e = iArr;
        }
        this.f22876e[i] = i2;
    }

    /* renamed from: a */
    private void m235a(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            m227c((Type.getArgumentsAndReturnSizes(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            m227c(2);
        } else {
            m227c(1);
        }
    }

    /* renamed from: a */
    private void m231a(ClassWriter classWriter, String str) {
        int m228b = m228b(classWriter, str);
        if (m228b != 0) {
            m229b(m228b);
            if (m228b != 16777220 && m228b != 16777219) {
                return;
            }
            m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
        }
    }

    /* renamed from: a */
    private static boolean m233a(ClassWriter classWriter, int i, int[] iArr, int i2) {
        int i3;
        int i4 = iArr[i2];
        if (i4 == i) {
            return false;
        }
        if ((268435455 & i) != 16777221) {
            i3 = i;
        } else if (i4 == 16777221) {
            return false;
        } else {
            i3 = 16777221;
        }
        if (i4 == 0) {
            iArr[i2] = i3;
            return true;
        }
        if ((i4 & 267386880) == 24117248 || (i4 & (-268435456)) != 0) {
            if (i3 == 16777221) {
                return false;
            }
            i3 = ((-1048576) & i3) == ((-1048576) & i4) ? (i4 & 267386880) == 24117248 ? classWriter.m255a(i3 & 1048575, 1048575 & i4) | (i3 & (-268435456)) | 24117248 : classWriter.m243c("java/lang/Object") | 24117248 : ((i3 & 267386880) == 24117248 || (i3 & (-268435456)) != 0) ? classWriter.m243c("java/lang/Object") | 24117248 : ViewCompat.MEASURED_STATE_TOO_SMALL;
        } else if (i4 != 16777221) {
            i3 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        } else if ((i3 & 267386880) != 24117248 && (i3 & (-268435456)) == 0) {
            i3 = ViewCompat.MEASURED_STATE_TOO_SMALL;
        }
        if (i4 == i3) {
            return false;
        }
        iArr[i2] = i3;
        return true;
    }

    /* renamed from: b */
    private static int m228b(ClassWriter classWriter, String str) {
        int i = 16777217;
        int indexOf = str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0;
        switch (str.charAt(indexOf)) {
            case 'B':
            case UsbId.ARDUINO_UNO_R3 /* 67 */:
            case 'I':
            case 'S':
            case 'Z':
                return 16777217;
            case 'D':
                return 16777219;
            case 'F':
                return 16777218;
            case 'J':
                return 16777220;
            case 'L':
                return 24117248 | classWriter.m243c(str.substring(indexOf + 1, str.length() - 1));
            case 'V':
                return 0;
            default:
                int i2 = indexOf + 1;
                while (str.charAt(i2) == '[') {
                    i2++;
                }
                switch (str.charAt(i2)) {
                    case 'B':
                        i = 16777226;
                        break;
                    case UsbId.ARDUINO_UNO_R3 /* 67 */:
                        i = 16777227;
                        break;
                    case 'D':
                        i = 16777219;
                        break;
                    case 'F':
                        i = 16777218;
                        break;
                    case 'I':
                        break;
                    case 'J':
                        i = 16777220;
                        break;
                    case 'S':
                        i = 16777228;
                        break;
                    case 'Z':
                        i = 16777225;
                        break;
                    default:
                        i = classWriter.m243c(str.substring(i2 + 1, str.length() - 1)) | 24117248;
                        break;
                }
                return ((i2 - indexOf) << 28) | i;
        }
    }

    /* renamed from: b */
    private void m229b(int i) {
        if (this.f22877f == null) {
            this.f22877f = new int[10];
        }
        int length = this.f22877f.length;
        if (this.f22878g >= length) {
            int[] iArr = new int[Math.max(this.f22878g + 1, length * 2)];
            System.arraycopy(this.f22877f, 0, iArr, 0, length);
            this.f22877f = iArr;
        }
        int[] iArr2 = this.f22877f;
        int i2 = this.f22878g;
        this.f22878g = i2 + 1;
        iArr2[i2] = i;
        int i3 = this.f22873b.f22901f + this.f22878g;
        if (i3 > this.f22873b.f22902g) {
            this.f22873b.f22902g = i3;
        }
    }

    /* renamed from: c */
    private void m227c(int i) {
        if (this.f22878g >= i) {
            this.f22878g -= i;
            return;
        }
        this.f22873b.f22901f -= i - this.f22878g;
        this.f22878g = 0;
    }

    /* renamed from: d */
    private void m226d(int i) {
        if (this.f22880i == null) {
            this.f22880i = new int[2];
        }
        int length = this.f22880i.length;
        if (this.f22879h >= length) {
            int[] iArr = new int[Math.max(this.f22879h + 1, length * 2)];
            System.arraycopy(this.f22880i, 0, iArr, 0, length);
            this.f22880i = iArr;
        }
        int[] iArr2 = this.f22880i;
        int i2 = this.f22879h;
        this.f22879h = i2 + 1;
        iArr2[i2] = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m236a(int i, int i2, ClassWriter classWriter, Item item) {
        switch (i) {
            case 0:
            case Opcodes.INEG /* 116 */:
            case Opcodes.LNEG /* 117 */:
            case Opcodes.FNEG /* 118 */:
            case Opcodes.DNEG /* 119 */:
            case 145:
            case 146:
            case 147:
            case Opcodes.GOTO /* 167 */:
            case Opcodes.RETURN /* 177 */:
                return;
            case 1:
                m229b(16777221);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
            case 17:
            case 21:
                m229b(16777217);
                return;
            case 9:
            case 10:
            case 22:
                m229b(16777220);
                m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                return;
            case 11:
            case 12:
            case 13:
            case 23:
                m229b(16777218);
                return;
            case 14:
            case 15:
            case 24:
                m229b(16777219);
                m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                return;
            case 18:
                switch (item.f22888b) {
                    case 3:
                        m229b(16777217);
                        return;
                    case 4:
                        m229b(16777218);
                        return;
                    case 5:
                        m229b(16777220);
                        m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                        return;
                    case 6:
                        m229b(16777219);
                        m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                        return;
                    case 7:
                        m229b(24117248 | classWriter.m243c("java/lang/Class"));
                        return;
                    default:
                        m229b(24117248 | classWriter.m243c("java/lang/String"));
                        return;
                }
            case 19:
            case 20:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case C3530b.f14177n /* 42 */:
            case C3530b.f14178o /* 43 */:
            case C3530b.f14179p /* 44 */:
            case 45:
            case UsbId.ARDUINO_SERIAL_ADAPTER /* 59 */:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case UsbId.ARDUINO_UNO_R3 /* 67 */:
            case 68:
            case 69:
            case 70:
            case 71:
            case C0409j.f902s /* 72 */:
            case 73:
            case 74:
            case C1947c.f6941c /* 75 */:
            case 76:
            case 77:
            case 78:
            case SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING /* 196 */:
            case 197:
            default:
                m227c(i2);
                m231a(classWriter, item.f22891g);
                return;
            case 25:
                m229b(m238a(i2));
                return;
            case 46:
            case 51:
            case 52:
            case Opcodes.SALOAD /* 53 */:
                m227c(2);
                m229b(16777217);
                return;
            case 47:
            case Opcodes.D2L /* 143 */:
                m227c(2);
                m229b(16777220);
                m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                return;
            case 48:
                m227c(2);
                m229b(16777218);
                return;
            case 49:
            case 138:
                m227c(2);
                m229b(16777219);
                m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                return;
            case 50:
                m227c(1);
                m229b(m239a() - 268435456);
                return;
            case Opcodes.ISTORE /* 54 */:
            case 56:
            case Opcodes.ASTORE /* 58 */:
                m237a(i2, m239a());
                if (i2 <= 0) {
                    return;
                }
                int m238a = m238a(i2 - 1);
                if (m238a == 16777220 || m238a == 16777219) {
                    m237a(i2 - 1, ViewCompat.MEASURED_STATE_TOO_SMALL);
                    return;
                } else if ((251658240 & m238a) == 16777216) {
                    return;
                } else {
                    m237a(i2 - 1, m238a | GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                    return;
                }
            case Opcodes.LSTORE /* 55 */:
            case Opcodes.DSTORE /* 57 */:
                m227c(1);
                m237a(i2, m239a());
                m237a(i2 + 1, ViewCompat.MEASURED_STATE_TOO_SMALL);
                if (i2 <= 0) {
                    return;
                }
                int m238a2 = m238a(i2 - 1);
                if (m238a2 == 16777220 || m238a2 == 16777219) {
                    m237a(i2 - 1, ViewCompat.MEASURED_STATE_TOO_SMALL);
                    return;
                } else if ((251658240 & m238a2) == 16777216) {
                    return;
                } else {
                    m237a(i2 - 1, m238a2 | GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                    return;
                }
            case Opcodes.IASTORE /* 79 */:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
                m227c(3);
                return;
            case 80:
            case 82:
                m227c(4);
                return;
            case 87:
            case 153:
            case 154:
            case Opcodes.IFLT /* 155 */:
            case Opcodes.IFGE /* 156 */:
            case Opcodes.IFGT /* 157 */:
            case Opcodes.IFLE /* 158 */:
            case 170:
            case Opcodes.LOOKUPSWITCH /* 171 */:
            case Opcodes.IRETURN /* 172 */:
            case Opcodes.FRETURN /* 174 */:
            case 176:
            case Opcodes.ATHROW /* 191 */:
            case 194:
            case Opcodes.MONITOREXIT /* 195 */:
            case 198:
            case 199:
                m227c(1);
                return;
            case 88:
            case Opcodes.IF_ICMPEQ /* 159 */:
            case 160:
            case Opcodes.IF_ICMPLT /* 161 */:
            case Opcodes.IF_ICMPGE /* 162 */:
            case Opcodes.IF_ICMPGT /* 163 */:
            case Opcodes.IF_ICMPLE /* 164 */:
            case Opcodes.IF_ACMPEQ /* 165 */:
            case Opcodes.IF_ACMPNE /* 166 */:
            case Opcodes.LRETURN /* 173 */:
            case Opcodes.DRETURN /* 175 */:
                m227c(2);
                return;
            case 89:
                int m239a = m239a();
                m229b(m239a);
                m229b(m239a);
                return;
            case 90:
                int m239a2 = m239a();
                int m239a3 = m239a();
                m229b(m239a2);
                m229b(m239a3);
                m229b(m239a2);
                return;
            case 91:
                int m239a4 = m239a();
                int m239a5 = m239a();
                int m239a6 = m239a();
                m229b(m239a4);
                m229b(m239a6);
                m229b(m239a5);
                m229b(m239a4);
                return;
            case Opcodes.DUP2 /* 92 */:
                int m239a7 = m239a();
                int m239a8 = m239a();
                m229b(m239a8);
                m229b(m239a7);
                m229b(m239a8);
                m229b(m239a7);
                return;
            case Opcodes.DUP2_X1 /* 93 */:
                int m239a9 = m239a();
                int m239a10 = m239a();
                int m239a11 = m239a();
                m229b(m239a10);
                m229b(m239a9);
                m229b(m239a11);
                m229b(m239a10);
                m229b(m239a9);
                return;
            case Opcodes.DUP2_X2 /* 94 */:
                int m239a12 = m239a();
                int m239a13 = m239a();
                int m239a14 = m239a();
                int m239a15 = m239a();
                m229b(m239a13);
                m229b(m239a12);
                m229b(m239a15);
                m229b(m239a14);
                m229b(m239a13);
                m229b(m239a12);
                return;
            case Opcodes.SWAP /* 95 */:
                int m239a16 = m239a();
                int m239a17 = m239a();
                m229b(m239a16);
                m229b(m239a17);
                return;
            case 96:
            case 100:
            case 104:
            case 108:
            case 112:
            case 120:
            case 122:
            case Opcodes.IUSHR /* 124 */:
            case 126:
            case 128:
            case 130:
            case 136:
            case Opcodes.D2I /* 142 */:
            case 149:
            case 150:
                m227c(2);
                m229b(16777217);
                return;
            case Opcodes.LADD /* 97 */:
            case 101:
            case 105:
            case Opcodes.LDIV /* 109 */:
            case 113:
            case 127:
            case 129:
            case 131:
                m227c(4);
                m229b(16777220);
                m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                return;
            case 98:
            case 102:
            case 106:
            case 110:
            case 114:
            case 137:
            case 144:
                m227c(2);
                m229b(16777218);
                return;
            case 99:
            case 103:
            case Opcodes.DMUL /* 107 */:
            case Opcodes.DDIV /* 111 */:
            case Opcodes.DREM /* 115 */:
                m227c(4);
                m229b(16777219);
                m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                return;
            case Opcodes.LSHL /* 121 */:
            case Opcodes.LSHR /* 123 */:
            case 125:
                m227c(3);
                m229b(16777220);
                m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                return;
            case 132:
                m237a(i2, 16777217);
                return;
            case 133:
            case 140:
                m227c(1);
                m229b(16777220);
                m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                return;
            case 134:
                m227c(1);
                m229b(16777218);
                return;
            case 135:
            case Opcodes.F2D /* 141 */:
                m227c(1);
                m229b(16777219);
                m229b(ViewCompat.MEASURED_STATE_TOO_SMALL);
                return;
            case 139:
            case Opcodes.ARRAYLENGTH /* 190 */:
            case 193:
                m227c(1);
                m229b(16777217);
                return;
            case 148:
            case 151:
            case 152:
                m227c(4);
                m229b(16777217);
                return;
            case 168:
            case Opcodes.RET /* 169 */:
                throw new RuntimeException("JSR/RET are not supported with computeFrames option");
            case Opcodes.GETSTATIC /* 178 */:
                m231a(classWriter, item.f22893i);
                return;
            case Opcodes.PUTSTATIC /* 179 */:
                m235a(item.f22893i);
                return;
            case Opcodes.GETFIELD /* 180 */:
                m227c(1);
                m231a(classWriter, item.f22893i);
                return;
            case Opcodes.PUTFIELD /* 181 */:
                m235a(item.f22893i);
                m239a();
                return;
            case Opcodes.INVOKEVIRTUAL /* 182 */:
            case Opcodes.INVOKESPECIAL /* 183 */:
            case 184:
            case Opcodes.INVOKEINTERFACE /* 185 */:
                m235a(item.f22893i);
                if (i != 184) {
                    int m239a18 = m239a();
                    if (i == 183 && item.f22892h.charAt(0) == '<') {
                        m226d(m239a18);
                    }
                }
                m231a(classWriter, item.f22893i);
                return;
            case Opcodes.INVOKEDYNAMIC /* 186 */:
                m235a(item.f22892h);
                m231a(classWriter, item.f22892h);
                return;
            case Opcodes.NEW /* 187 */:
                m229b(25165824 | classWriter.m250a(item.f22891g, i2));
                return;
            case Opcodes.NEWARRAY /* 188 */:
                m239a();
                switch (i2) {
                    case 4:
                        m229b(285212681);
                        return;
                    case 5:
                        m229b(285212683);
                        return;
                    case 6:
                        m229b(285212674);
                        return;
                    case 7:
                        m229b(285212675);
                        return;
                    case 8:
                        m229b(285212682);
                        return;
                    case 9:
                        m229b(285212684);
                        return;
                    case 10:
                        m229b(285212673);
                        return;
                    default:
                        m229b(285212676);
                        return;
                }
            case Opcodes.ANEWARRAY /* 189 */:
                String str = item.f22891g;
                m239a();
                if (str.charAt(0) == '[') {
                    m231a(classWriter, new StringBuffer().append('[').append(str).toString());
                    return;
                } else {
                    m229b(classWriter.m243c(str) | 292552704);
                    return;
                }
            case 192:
                String str2 = item.f22891g;
                m239a();
                if (str2.charAt(0) == '[') {
                    m231a(classWriter, str2);
                    return;
                } else {
                    m229b(classWriter.m243c(str2) | 24117248);
                    return;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m232a(ClassWriter classWriter, int i, Type[] typeArr, int i2) {
        int i3 = 1;
        this.f22874c = new int[i2];
        this.f22875d = new int[0];
        if ((i & 8) != 0) {
            i3 = 0;
        } else if ((262144 & i) == 0) {
            this.f22874c[0] = 24117248 | classWriter.m243c(classWriter.f22829F);
        } else {
            this.f22874c[0] = 16777222;
        }
        for (Type type : typeArr) {
            int m228b = m228b(classWriter, type.getDescriptor());
            int i4 = i3 + 1;
            this.f22874c[i3] = m228b;
            if (m228b == 16777220 || m228b == 16777219) {
                i3 = i4 + 1;
                this.f22874c[i4] = 16777216;
            } else {
                i3 = i4;
            }
        }
        while (i3 < i2) {
            this.f22874c[i3] = 16777216;
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m230a(ClassWriter classWriter, Frame frame, int i) {
        boolean z;
        int i2;
        boolean z2 = false;
        int length = this.f22874c.length;
        int length2 = this.f22875d.length;
        if (frame.f22874c == null) {
            frame.f22874c = new int[length];
            z2 = true;
        }
        boolean z3 = z2;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.f22876e == null || i3 >= this.f22876e.length) {
                i2 = this.f22874c[i3];
            } else {
                i2 = this.f22876e[i3];
                if (i2 == 0) {
                    i2 = this.f22874c[i3];
                } else {
                    int i4 = (-268435456) & i2;
                    int i5 = 251658240 & i2;
                    if (i5 != 16777216) {
                        int i6 = i5 == 33554432 ? i4 + this.f22874c[8388607 & i2] : i4 + this.f22875d[length2 - (8388607 & i2)];
                        i2 = ((i2 & GravityCompat.RELATIVE_LAYOUT_DIRECTION) == 0 || !(i6 == 16777220 || i6 == 16777219)) ? i6 : ViewCompat.MEASURED_STATE_TOO_SMALL;
                    }
                }
            }
            if (this.f22880i != null) {
                i2 = m234a(classWriter, i2);
            }
            z3 |= m233a(classWriter, i2, frame.f22874c, i3);
        }
        if (i > 0) {
            int i7 = 0;
            boolean z4 = z3;
            while (i7 < length) {
                boolean m233a = m233a(classWriter, this.f22874c[i7], frame.f22874c, i7) | z4;
                i7++;
                z4 = m233a;
            }
            if (frame.f22875d == null) {
                frame.f22875d = new int[1];
                z4 = true;
            }
            return m233a(classWriter, i, frame.f22875d, 0) | z4;
        }
        int length3 = this.f22875d.length + this.f22873b.f22901f;
        if (frame.f22875d == null) {
            frame.f22875d = new int[this.f22878g + length3];
            z = true;
        } else {
            z = z3;
        }
        boolean z5 = z;
        for (int i8 = 0; i8 < length3; i8++) {
            int i9 = this.f22875d[i8];
            if (this.f22880i != null) {
                i9 = m234a(classWriter, i9);
            }
            z5 |= m233a(classWriter, i9, frame.f22875d, i8);
        }
        for (int i10 = 0; i10 < this.f22878g; i10++) {
            int i11 = this.f22877f[i10];
            int i12 = (-268435456) & i11;
            int i13 = 251658240 & i11;
            if (i13 != 16777216) {
                int i14 = i13 == 33554432 ? i12 + this.f22874c[8388607 & i11] : i12 + this.f22875d[length2 - (8388607 & i11)];
                i11 = ((i11 & GravityCompat.RELATIVE_LAYOUT_DIRECTION) == 0 || !(i14 == 16777220 || i14 == 16777219)) ? i14 : ViewCompat.MEASURED_STATE_TOO_SMALL;
            }
            if (this.f22880i != null) {
                i11 = m234a(classWriter, i11);
            }
            z5 |= m233a(classWriter, i11, frame.f22875d, length3 + i10);
        }
        return z5;
    }
}
