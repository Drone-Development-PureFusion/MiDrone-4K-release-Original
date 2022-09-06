package com.tencent.p227mm.sdk.contact;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p227mm.sdk.platformtools.LVBuffer;
import com.tencent.p227mm.sdk.platformtools.Log;
import com.tencent.p227mm.sdk.platformtools.Util;
import com.tencent.p227mm.sdk.storage.MAutoDBItem;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.p248a.p249a.p261f.p264c.C5122l;
/* renamed from: com.tencent.mm.sdk.contact.RContact */
/* loaded from: classes.dex */
public class RContact extends MAutoDBItem {
    public static final String[] COLUMNS;
    public static final String COL_ALIAS = "alias";
    public static final String COL_CONREMARK = "conRemark";
    public static final String COL_CONREMARK_PYFULL = "conRemarkPYFull";
    public static final String COL_CONREMARK_PYSHORT = "conRemarkPYShort";
    public static final String COL_DOMAINLIST = "domainList";
    public static final int COL_ID_INVALID_VALUE = -1;
    public static final String COL_NICKNAME = "nickname";
    public static final String COL_PYINITIAL = "pyInitial";
    public static final String COL_QUANPIN = "quanPin";
    public static final String COL_SHOWHEAD = "showHead";
    public static final String COL_TYPE = "type";
    public static final String COL_USERNAME = "username";
    public static final String COL_VERIFY_FLAG = "verifyFlag";
    public static final String COL_WEIBOFLAG = "weiboFlag";
    public static final String COL_WEIBONICKNAME = "weiboNickname";
    public static final int DEL_CONTACT_MSG = -1;
    public static final String FAVOUR_CONTACT_SHOW_HEAD_CHAR = "$";
    public static final int FAVOUR_CONTACT_SHOW_HEAD_CODE = 32;
    public static final int MM_CONTACTFLAG_ALL = 127;
    public static final int MM_CONTACTFLAG_BLACKLISTCONTACT = 8;
    public static final int MM_CONTACTFLAG_CHATCONTACT = 2;
    public static final int MM_CONTACTFLAG_CHATROOMCONTACT = 4;
    public static final int MM_CONTACTFLAG_CONTACT = 1;
    public static final int MM_CONTACTFLAG_DOMAINCONTACT = 16;
    public static final int MM_CONTACTFLAG_FAVOURCONTACT = 64;
    public static final int MM_CONTACTFLAG_HIDECONTACT = 32;
    public static final int MM_CONTACTFLAG_NULL = 0;
    public static final int MM_CONTACTIMGFLAG_HAS_HEADIMG = 3;
    public static final int MM_CONTACTIMGFLAG_HAS_NO_HEADIMG = 4;
    public static final int MM_CONTACTIMGFLAG_LOCAL_EXIST = 153;
    public static final int MM_CONTACTIMGFLAG_MODIFY = 2;
    public static final int MM_CONTACTIMGFLAG_NOTMODIFY = 1;
    public static final int MM_CONTACT_BOTTLE = 5;
    public static final int MM_CONTACT_CHATROOM = 2;
    public static final int MM_CONTACT_EMAIL = 3;
    public static final int MM_CONTACT_QQ = 4;
    public static final int MM_CONTACT_QQMICROBLOG = 1;
    public static final int MM_CONTACT_WEIXIN = 0;
    public static final int MM_SEX_FEMALE = 2;
    public static final int MM_SEX_MALE = 1;
    public static final int MM_SEX_UNKNOWN = 0;
    public static final int NOT_IN_CHAT_LIST = 0;

    /* renamed from: p */
    protected static Field[] f17760p;

    /* renamed from: A */
    private String f17761A;

    /* renamed from: B */
    private int f17762B;

    /* renamed from: C */
    private int f17763C;

    /* renamed from: D */
    private String f17764D;

    /* renamed from: E */
    private String f17765E;

    /* renamed from: F */
    private String f17766F;

    /* renamed from: G */
    private String f17767G;

    /* renamed from: H */
    private int f17768H;

    /* renamed from: I */
    private int f17769I;

    /* renamed from: J */
    private String f17770J;

    /* renamed from: K */
    private String f17771K;

    /* renamed from: L */
    private String f17772L;
    public long contactId;
    public String field_alias;
    public String field_conRemark;
    public String field_conRemarkPYFull;
    public String field_conRemarkPYShort;
    public String field_domainList;
    public byte[] field_lvbuff;
    public String field_nickname;
    public String field_pyInitial;
    public String field_quanPin;
    public int field_showHead;
    public int field_type;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public String field_weiboNickname;

    /* renamed from: h */
    private int f17773h;

    /* renamed from: q */
    private int f17774q;

    /* renamed from: r */
    private int f17775r;

    /* renamed from: s */
    private String f17776s;

    /* renamed from: u */
    private long f17777u;

    /* renamed from: v */
    private String f17778v;

    /* renamed from: w */
    private String f17779w;

    /* renamed from: x */
    private int f17780x;

    /* renamed from: y */
    private int f17781y;

    /* renamed from: z */
    private String f17782z;

    /* renamed from: M */
    private static Map<String, String> f17758M = new HashMap();

    /* renamed from: N */
    private static Map<String, String> f17759N = new HashMap();

    static {
        Field[] validFields = MAutoDBItem.getValidFields(RContact.class);
        f17760p = validFields;
        COLUMNS = MAutoDBItem.getFullColumns(validFields);
    }

    public RContact() {
        reset();
    }

    public RContact(String str) {
        this();
        this.field_username = str == null ? "" : str;
    }

    /* renamed from: a */
    private byte[] m5661a() {
        try {
            LVBuffer lVBuffer = new LVBuffer();
            lVBuffer.initBuild();
            lVBuffer.putInt(this.f17774q);
            lVBuffer.putInt(this.f17775r);
            lVBuffer.putString(this.f17776s);
            lVBuffer.putLong(this.f17777u);
            lVBuffer.putInt(this.f17773h);
            lVBuffer.putString(this.f17778v);
            lVBuffer.putString(this.f17779w);
            lVBuffer.putInt(this.f17780x);
            lVBuffer.putInt(this.f17781y);
            lVBuffer.putString(this.f17782z);
            lVBuffer.putString(this.f17761A);
            lVBuffer.putInt(this.f17762B);
            lVBuffer.putInt(this.f17763C);
            lVBuffer.putString(this.f17764D);
            lVBuffer.putString(this.f17765E);
            lVBuffer.putString(this.f17766F);
            lVBuffer.putString(this.f17767G);
            lVBuffer.putInt(this.f17768H);
            lVBuffer.putInt(this.f17769I);
            lVBuffer.putString(this.f17770J);
            lVBuffer.putInt(this.field_verifyFlag);
            lVBuffer.putString(this.f17771K);
            lVBuffer.putString(this.f17772L);
            return lVBuffer.buildFinish();
        } catch (Exception e) {
            Log.m5647e("MicroMsg.Contact", "get value failed");
            e.printStackTrace();
            return null;
        }
    }

    public static String formatDisplayNick(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase().endsWith("@t.qq.com") ? "@" + str.replace("@t.qq.com", "") : str.toLowerCase().endsWith("@qqim") ? str.replace("@qqim", "") : str;
    }

    public static int getBlackListContactBit() {
        return 8;
    }

    public static int getContactBit() {
        return 1;
    }

    public static int getDomainContactBit() {
        return 16;
    }

    public static int getHiddenContactBit() {
        return 32;
    }

    public static boolean isContact(int i) {
        return (i & 1) != 0;
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static void setHardCodeAliasMaps(Map<String, String> map) {
        f17759N = map;
    }

    public static void setHardCodeNickMaps(Map<String, String> map) {
        f17758M = map;
    }

    public int calculateShowHead() {
        char c = C5122l.f21763c;
        if (this.field_conRemarkPYShort != null && !this.field_conRemarkPYShort.equals("")) {
            c = this.field_conRemarkPYShort.charAt(0);
        } else if (this.field_conRemarkPYFull != null && !this.field_conRemarkPYFull.equals("")) {
            c = this.field_conRemarkPYFull.charAt(0);
        } else if (this.field_pyInitial != null && !this.field_pyInitial.equals("")) {
            c = this.field_pyInitial.charAt(0);
        } else if (this.field_quanPin != null && !this.field_quanPin.equals("")) {
            c = this.field_quanPin.charAt(0);
        } else if (this.field_nickname != null && !this.field_nickname.equals("") && isLetter(this.field_nickname.charAt(0))) {
            c = this.field_nickname.charAt(0);
        } else if (this.field_username != null && !this.field_username.equals("") && isLetter(this.field_username.charAt(0))) {
            c = this.field_username.charAt(0);
        }
        return (c < 'a' || c > 'z') ? (c < 'A' || c > 'Z') ? Opcodes.LSHR : c : (char) (c - ' ');
    }

    @Override // com.tencent.p227mm.sdk.storage.MAutoDBItem, com.tencent.p227mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        super.convertFrom(cursor);
        this.contactId = (int) cursor.getLong(cursor.getColumnCount() - 1);
        byte[] bArr = this.field_lvbuff;
        try {
            LVBuffer lVBuffer = new LVBuffer();
            int initParse = lVBuffer.initParse(bArr);
            if (initParse != 0) {
                Log.m5647e("MicroMsg.Contact", "parse LVBuffer error:" + initParse);
            } else {
                this.f17774q = lVBuffer.getInt();
                this.f17775r = lVBuffer.getInt();
                this.f17776s = lVBuffer.getString();
                this.f17777u = lVBuffer.getLong();
                this.f17773h = lVBuffer.getInt();
                this.f17778v = lVBuffer.getString();
                this.f17779w = lVBuffer.getString();
                this.f17780x = lVBuffer.getInt();
                this.f17781y = lVBuffer.getInt();
                this.f17782z = lVBuffer.getString();
                this.f17761A = lVBuffer.getString();
                this.f17762B = lVBuffer.getInt();
                this.f17763C = lVBuffer.getInt();
                this.f17764D = lVBuffer.getString();
                this.f17765E = lVBuffer.getString();
                this.f17766F = lVBuffer.getString();
                this.f17767G = lVBuffer.getString();
                this.f17768H = lVBuffer.getInt();
                this.f17769I = lVBuffer.getInt();
                this.f17770J = lVBuffer.getString();
                this.field_verifyFlag = lVBuffer.getInt();
                this.f17771K = lVBuffer.getString();
                if (!lVBuffer.checkGetFinish()) {
                    this.f17772L = lVBuffer.getString();
                }
            }
        } catch (Exception e) {
            Log.m5647e("MicroMsg.Contact", "get value failed");
            e.printStackTrace();
        }
    }

    @Override // com.tencent.p227mm.sdk.storage.MAutoDBItem, com.tencent.p227mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        this.field_lvbuff = m5661a();
        return super.convertTo();
    }

    @Override // com.tencent.p227mm.sdk.storage.MAutoDBItem
    public Field[] fields() {
        return f17760p;
    }

    public String getAlias() {
        String str = f17759N.get(this.field_username);
        return str == null ? this.field_alias : str;
    }

    public int getChatroomNotify() {
        return this.f17762B;
    }

    public String getCity() {
        return this.f17766F;
    }

    public String getConQQMBlog() {
        return this.f17761A;
    }

    public String getConRemark() {
        return this.field_conRemark;
    }

    public String getConRemarkPYFull() {
        return this.field_conRemarkPYFull;
    }

    public String getConRemarkPYShort() {
        return this.field_conRemarkPYShort;
    }

    public String getConSMBlog() {
        return this.f17782z;
    }

    public int getConType() {
        return this.f17781y;
    }

    public int getContactID() {
        return (int) this.contactId;
    }

    public String getDisplayNick() {
        String str = f17758M.get(this.field_username);
        return str != null ? str : (this.field_nickname == null || this.field_nickname.length() <= 0) ? getDisplayUser() : this.field_nickname;
    }

    public String getDisplayRemark() {
        return (this.field_conRemark == null || this.field_conRemark.trim().equals("")) ? getDisplayNick() : this.field_conRemark;
    }

    public String getDisplayUser() {
        String alias = getAlias();
        if (!Util.isNullOrNil(alias)) {
            return alias;
        }
        String formatDisplayNick = formatDisplayNick(this.field_username);
        return (formatDisplayNick == null || formatDisplayNick.length() == 0) ? this.field_username : formatDisplayNick;
    }

    public String getDistance() {
        return this.f17767G;
    }

    public String getDomainList() {
        return this.field_domainList;
    }

    public String getEmail() {
        return this.f17778v;
    }

    public long getFaceBookId() {
        return this.f17777u;
    }

    public String getFaceBookUsername() {
        return this.f17776s;
    }

    public int getFromType() {
        return this.f17768H;
    }

    public int getImgFlag() {
        return this.f17774q;
    }

    public String getMobile() {
        return this.f17779w;
    }

    public String getNickname() {
        return this.field_nickname;
    }

    public int getPersonalCard() {
        return this.f17763C;
    }

    public String getProvince() {
        return this.f17765E;
    }

    public String getPyInitial() {
        return (this.field_pyInitial == null || this.field_pyInitial.length() < 0) ? getQuanPin() : this.field_pyInitial;
    }

    public String getQuanPin() {
        return (this.field_quanPin == null || this.field_quanPin.length() < 0) ? getNickname() : this.field_quanPin;
    }

    public String getRegionCode() {
        return this.f17772L;
    }

    public int getSex() {
        return this.f17775r;
    }

    public int getShowFlag() {
        return this.f17780x;
    }

    public int getShowHead() {
        return this.field_showHead;
    }

    public String getSignature() {
        return this.f17764D;
    }

    public int getSource() {
        return this.f17769I;
    }

    public int getType() {
        return this.field_type;
    }

    public int getUin() {
        return this.f17773h;
    }

    public String getUsername() {
        return this.field_username;
    }

    public int getVerifyFlag() {
        return this.field_verifyFlag;
    }

    public String getVerifyInfo() {
        return this.f17771K;
    }

    public String getWeibo() {
        return this.f17770J;
    }

    public int getWeiboFlag() {
        return this.field_weiboFlag;
    }

    public String getWeiboNickName() {
        return this.field_weiboNickname;
    }

    public boolean isBlackListContact() {
        return (this.field_type & 8) != 0;
    }

    public boolean isChatContact() {
        return (this.field_type & 2) != 0;
    }

    public boolean isChatRoomContact() {
        return (this.field_type & 4) != 0;
    }

    public boolean isContact() {
        return isContact(this.field_type);
    }

    public boolean isDomainContact() {
        return (this.field_type & 16) != 0;
    }

    public boolean isFavourContact() {
        return (this.field_type & 64) != 0;
    }

    public boolean isHidden() {
        return (this.field_type & 32) != 0;
    }

    public boolean isImgLocalExist() {
        return 153 == this.f17774q;
    }

    public void reset() {
        this.field_username = "";
        this.field_nickname = "";
        this.field_pyInitial = "";
        this.field_quanPin = "";
        this.field_alias = "";
        this.field_conRemark = "";
        this.field_conRemarkPYShort = "";
        this.field_conRemarkPYFull = "";
        this.field_domainList = "";
        this.field_weiboFlag = 0;
        this.field_weiboNickname = "";
        this.field_showHead = 0;
        this.field_type = 0;
        this.field_verifyFlag = 0;
        this.f17775r = 0;
        this.f17767G = "";
        this.f17768H = 0;
        this.f17773h = 0;
        this.f17778v = "";
        this.f17779w = "";
        this.f17780x = 0;
        this.f17781y = 0;
        this.f17782z = "";
        this.f17761A = "";
        this.f17762B = 1;
        this.f17774q = 0;
        this.f17763C = 0;
        this.f17764D = "";
        this.f17765E = "";
        this.f17766F = "";
        this.f17769I = 0;
        this.f17771K = "";
        this.f17770J = "";
        this.f17777u = 0L;
        this.f17776s = "";
        this.f17772L = "";
    }

    public void setAlias(String str) {
        this.field_alias = str;
    }

    public void setBlackList() {
        this.field_type |= 8;
    }

    public void setChatContact() {
        this.field_type |= 2;
    }

    public void setChatroomContact() {
        this.field_type |= 4;
    }

    public void setChatroomNotify(int i) {
        this.f17762B = i;
    }

    public void setCity(String str) {
        this.f17766F = str;
    }

    public void setConQQMBlog(String str) {
        this.f17761A = str;
    }

    public void setConRemark(String str) {
        this.field_conRemark = str;
    }

    public void setConRemarkPYFull(String str) {
        this.field_conRemarkPYFull = str;
    }

    public void setConRemarkPYShort(String str) {
        this.field_conRemarkPYShort = str;
    }

    public void setConSMBlog(String str) {
        this.f17782z = str;
    }

    public void setConType(int i) {
        this.f17781y = i;
    }

    public void setContact() {
        this.field_type |= 1;
    }

    public void setDistance(String str) {
        this.f17767G = str;
    }

    public void setDomainList(String str) {
        this.field_domainList = str;
    }

    public void setEmail(String str) {
        this.f17778v = str;
    }

    public void setFaceBookId(long j) {
        this.f17777u = j;
    }

    public void setFaceBookUsername(String str) {
        this.f17776s = str;
    }

    public void setFavour() {
        this.field_type |= 64;
    }

    public void setFromType(int i) {
        this.f17768H = i;
    }

    public void setHidden() {
        this.field_type |= 32;
    }

    public void setImgFlag(int i) {
        this.f17774q = i;
    }

    public void setMobile(String str) {
        this.f17779w = str;
    }

    public void setNickname(String str) {
        this.field_nickname = str;
    }

    public void setNullContact() {
        this.field_type = 0;
    }

    public void setPersonalCard(int i) {
        this.f17763C = i;
    }

    public void setProvince(String str) {
        this.f17765E = str;
    }

    public void setPyInitial(String str) {
        this.field_pyInitial = str;
    }

    public void setQuanPin(String str) {
        this.field_quanPin = str;
    }

    public void setRegionCode(String str) {
        this.f17772L = str;
    }

    public void setSex(int i) {
        this.f17775r = i;
    }

    public void setShowFlag(int i) {
        this.f17780x = i;
    }

    public void setShowHead(int i) {
        this.field_showHead = i;
    }

    public void setSignature(String str) {
        this.f17764D = str;
    }

    public void setSource(int i) {
        this.f17769I = i;
    }

    public void setType(int i) {
        this.field_type = i;
    }

    public void setUin(int i) {
        this.f17773h = i;
    }

    public void setUsername(String str) {
        this.field_username = str;
    }

    public void setVerifyFlag(int i) {
        this.field_verifyFlag = i;
    }

    public void setVerifyInfo(String str) {
        this.f17771K = str;
    }

    public void setWeibo(String str) {
        this.f17770J = str;
    }

    public void setWeiboFlag(int i) {
        this.field_weiboFlag = i;
    }

    public void setWeiboNickName(String str) {
        this.field_weiboNickname = str;
    }

    public void unSetBlackList() {
        this.field_type &= -9;
    }

    public void unSetChatContact() {
        this.field_type &= -3;
    }

    public void unSetContact() {
        this.field_type &= -2;
    }

    public void unSetFavour() {
        this.field_type &= -65;
    }

    public void unSetHidden() {
        this.field_type &= -33;
    }
}
