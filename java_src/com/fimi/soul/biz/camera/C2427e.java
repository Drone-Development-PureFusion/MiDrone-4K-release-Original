package com.fimi.soul.biz.camera;

import com.fimi.p139b.C2110f;
import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.soul.biz.p177f.C2441a;
/* renamed from: com.fimi.soul.biz.camera.e */
/* loaded from: classes.dex */
public class C2427e {

    /* renamed from: A */
    public static final int f8171A = 14;

    /* renamed from: B */
    public static final int f8172B = 15;

    /* renamed from: C */
    public static final int f8173C = 16;

    /* renamed from: D */
    public static final int f8174D = 257;

    /* renamed from: E */
    public static final int f8175E = 258;

    /* renamed from: F */
    public static final int f8176F = 259;

    /* renamed from: G */
    public static final int f8177G = 260;

    /* renamed from: H */
    public static final int f8178H = 261;

    /* renamed from: I */
    public static final int f8179I = 513;

    /* renamed from: J */
    public static final int f8180J = 514;

    /* renamed from: K */
    public static final int f8181K = 515;

    /* renamed from: L */
    public static final int f8182L = 516;

    /* renamed from: M */
    public static final int f8183M = 769;

    /* renamed from: N */
    public static final int f8184N = 770;

    /* renamed from: O */
    public static final int f8185O = 1025;

    /* renamed from: P */
    public static final int f8186P = 1026;

    /* renamed from: Q */
    public static final int f8187Q = 1027;

    /* renamed from: R */
    public static final int f8188R = 1281;

    /* renamed from: S */
    public static final int f8189S = 1282;

    /* renamed from: T */
    public static final int f8190T = 1283;

    /* renamed from: U */
    public static final int f8191U = 1284;

    /* renamed from: V */
    public static final int f8192V = 1285;

    /* renamed from: W */
    public static final int f8193W = 1286;

    /* renamed from: X */
    public static final int f8194X = 1287;

    /* renamed from: Y */
    public static final int f8195Y = 1537;

    /* renamed from: Z */
    public static final int f8196Z = 1538;

    /* renamed from: aA */
    public static final String f8198aA = "camera_connect_to_pc";

    /* renamed from: aB */
    public static final String f8199aB = "log_updated";

    /* renamed from: aC */
    public static final String f8200aC = "power_mode_change";

    /* renamed from: aD */
    public static final String f8201aD = "vf_start";

    /* renamed from: aE */
    public static final String f8202aE = "vf_stop";

    /* renamed from: aF */
    public static final String f8203aF = "auto_file_delete";

    /* renamed from: aG */
    public static final String f8204aG = "STORAGE_RUNOUT";

    /* renamed from: aH */
    public static final String f8205aH = "STORAGE_IO_ERROR";

    /* renamed from: aI */
    public static final String f8206aI = "LOW_SPEED_CARD";

    /* renamed from: aJ */
    public static final String f8207aJ = "MUXER_INDEX_LIMIT";

    /* renamed from: aK */
    public static final String f8208aK = "MUXER_FILE_SIZE_LIMIT";

    /* renamed from: aL */
    public static final String f8209aL = "CARD_REMOVED";

    /* renamed from: aM */
    public static final String f8210aM = "CARD_INSERT";

    /* renamed from: aN */
    public static final String f8211aN = "NOTIFY_CANNOT_ISSUE_PIV";

    /* renamed from: aO */
    public static final String f8212aO = "TAKE_PHOTO_FINISH";

    /* renamed from: aP */
    public static final String f8213aP = "CARD_FILE_SYS_ERROR";

    /* renamed from: aQ */
    public static final String f8214aQ = "CARD_PARAM_ERR";

    /* renamed from: aR */
    public static final String f8215aR = "CARD_NO_PROPOSE";

    /* renamed from: aS */
    public static final String f8216aS = "CARD_NO_PROPOSE_AND_PARAM_ERR";

    /* renamed from: aT */
    public static final String f8217aT = "CARD_WRITE_LOW";

    /* renamed from: aU */
    public static final String f8218aU = "CARD_WRITE_LOW_AND_PARAM_ERR";

    /* renamed from: aV */
    public static final String f8219aV = "CARD_SETROOT_ERROR";

    /* renamed from: aW */
    public static final String f8220aW = "STORAGE_WILL_RUNOUT";

    /* renamed from: aX */
    public static final String f8221aX = "get_file_complete";

    /* renamed from: aY */
    public static final String f8222aY = "get_file_downing";

    /* renamed from: aZ */
    public static final String f8223aZ = "put_file_complete";

    /* renamed from: aa */
    public static final int f8224aa = 1539;

    /* renamed from: ab */
    public static final int f8225ab = 17;

    /* renamed from: ac */
    public static final int f8226ac = 18;

    /* renamed from: ad */
    public static final int f8227ad = 19;

    /* renamed from: ae */
    public static final int f8228ae = 1793;

    /* renamed from: af */
    public static final int f8229af = 2;

    /* renamed from: ag */
    public static final int f8230ag = 254;

    /* renamed from: ah */
    public static final int f8231ah = 253;

    /* renamed from: ai */
    public static final int f8232ai = 10066329;

    /* renamed from: aj */
    public static final int f8233aj = 7829367;

    /* renamed from: ak */
    public static final int f8234ak = 8947848;

    /* renamed from: al */
    public static final int f8235al = 25725064;

    /* renamed from: am */
    public static final int f8236am = 10066328;

    /* renamed from: an */
    public static final String f8237an = "disconnet_HDMI";

    /* renamed from: ao */
    public static final String f8238ao = "disconnet_shutdown";

    /* renamed from: ap */
    public static final String f8239ap = "start_video_record";

    /* renamed from: aq */
    public static final String f8240aq = "video_record_complete";

    /* renamed from: ar */
    public static final String f8241ar = "photo_taken";

    /* renamed from: as */
    public static final String f8242as = "continue_capture_start";

    /* renamed from: at */
    public static final String f8243at = "continue_capture_stop";

    /* renamed from: au */
    public static final String f8244au = "continue_burst_start";

    /* renamed from: av */
    public static final String f8245av = "continue_burst_complete";

    /* renamed from: aw */
    public static final String f8246aw = "low_storage_warning";

    /* renamed from: ax */
    public static final String f8247ax = "low_batter_warning";

    /* renamed from: ay */
    public static final String f8248ay = "timelapse_video_status";

    /* renamed from: az */
    public static final String f8249az = "timelapse_photo_status";

    /* renamed from: bA */
    public static final int f8251bA = -26;

    /* renamed from: bB */
    public static final String f8252bB = "camera_clock";

    /* renamed from: bC */
    public static final String f8253bC = "ravl";

    /* renamed from: bD */
    public static final String f8254bD = "cur_time";

    /* renamed from: bE */
    public static final String f8255bE = "video_standard";

    /* renamed from: bF */
    public static final String f8256bF = "app_status";

    /* renamed from: bG */
    public static final String f8257bG = "stream_out_type";

    /* renamed from: bH */
    public static final String f8258bH = "save_low_resolution_clip";

    /* renamed from: bI */
    public static final String f8259bI = "video_resolution";

    /* renamed from: bJ */
    public static final String f8260bJ = "video_stamp";

    /* renamed from: bK */
    public static final String f8261bK = "video_quality";

    /* renamed from: bL */
    public static final String f8262bL = "timelapse_video";

    /* renamed from: bM */
    public static final String f8263bM = "capture_mode";

    /* renamed from: bN */
    public static final String f8264bN = "photo_size";

    /* renamed from: bO */
    public static final String f8265bO = "photo_stamp";

    /* renamed from: bP */
    public static final String f8266bP = "photo_quality";

    /* renamed from: bQ */
    public static final String f8267bQ = "timelapse_photo";

    /* renamed from: bR */
    public static final String f8268bR = "video_srt";

    /* renamed from: bS */
    public static final String f8269bS = "video_loop_back";

    /* renamed from: bT */
    public static final String f8270bT = "video_mode";

    /* renamed from: bU */
    public static final String f8271bU = "sd_status";

    /* renamed from: bV */
    public static final String f8272bV = "photo_format";

    /* renamed from: bW */
    public static final String f8273bW = "system_type";

    /* renamed from: bX */
    public static final String f8274bX = "default_system";

    /* renamed from: bY */
    public static final String f8275bY = "ae_bias";

    /* renamed from: bZ */
    public static final String f8276bZ = "saturation";

    /* renamed from: ba */
    public static final String f8277ba = "put_file_fail";

    /* renamed from: bb */
    public static final String f8278bb = "fw_upgrade_complete";

    /* renamed from: bc */
    public static final String f8279bc = "firmware_unzip_complete";

    /* renamed from: bd */
    public static final String f8280bd = "fw_unzip_finish";

    /* renamed from: be */
    public static final String f8281be = "progress";

    /* renamed from: bf */
    public static final String f8282bf = "FM_LS_END";

    /* renamed from: bg */
    public static final String f8283bg = "fw_unzipping";

    /* renamed from: bh */
    public static final int f8284bh = -1;

    /* renamed from: bi */
    public static final int f8285bi = -3;

    /* renamed from: bj */
    public static final int f8286bj = -4;

    /* renamed from: bk */
    public static final int f8287bk = -5;

    /* renamed from: bl */
    public static final int f8288bl = -7;

    /* renamed from: bm */
    public static final int f8289bm = -8;

    /* renamed from: bn */
    public static final int f8290bn = -9;

    /* renamed from: bo */
    public static final int f8291bo = -13;

    /* renamed from: bp */
    public static final int f8292bp = -14;

    /* renamed from: bq */
    public static final int f8293bq = -16;

    /* renamed from: br */
    public static final int f8294br = -17;

    /* renamed from: bs */
    public static final int f8295bs = -18;

    /* renamed from: bt */
    public static final int f8296bt = -19;

    /* renamed from: bu */
    public static final int f8297bu = -20;

    /* renamed from: bv */
    public static final int f8298bv = -21;

    /* renamed from: bw */
    public static final int f8299bw = -22;

    /* renamed from: bx */
    public static final int f8300bx = -23;

    /* renamed from: by */
    public static final int f8301by = -24;

    /* renamed from: bz */
    public static final int f8302bz = -25;

    /* renamed from: cA */
    public static final String f8304cA = "JPG+DNG";

    /* renamed from: cB */
    public static final String f8305cB = "NTSC";

    /* renamed from: cC */
    public static final String f8306cC = "PAL";

    /* renamed from: cD */
    public static final String f8307cD = "yes";

    /* renamed from: cE */
    public static final String f8308cE = "on";

    /* renamed from: cH */
    public static final String f8311cH = "photo";

    /* renamed from: cJ */
    public static final String f8313cJ = "burst quality cont.";

    /* renamed from: cK */
    public static final String f8314cK = "precise quality";

    /* renamed from: cL */
    public static final String f8315cL = "video_only";

    /* renamed from: cM */
    public static final String f8316cM = "video_av";

    /* renamed from: cN */
    public static final String f8317cN = "/tmp/SD0/DCIM/MEDIA";

    /* renamed from: cP */
    public static final String f8319cP = "/tmp/SD0";

    /* renamed from: ca */
    public static final String f8329ca = "contrast";

    /* renamed from: cb */
    public static final String f8330cb = "sharpness";

    /* renamed from: cc */
    public static final String f8331cc = "awb";

    /* renamed from: cd */
    public static final String f8332cd = "default_setting";

    /* renamed from: ce */
    public static final String f8333ce = "sync";

    /* renamed from: cf */
    public static final String f8334cf = "EVBIAS";

    /* renamed from: cg */
    public static final String f8335cg = "ae_bias";

    /* renamed from: ch */
    public static final String f8336ch = "1920x1080 30P 16:9";

    /* renamed from: ci */
    public static final String f8337ci = "1920x1080 60P 16:9";

    /* renamed from: cj */
    public static final String f8338cj = "1280x720 120P 16:9";

    /* renamed from: ck */
    public static final String f8339ck = "16M (4608x3456 4:3)";

    /* renamed from: cl */
    public static final String f8340cl = "12M (4608x2592 16:9)";

    /* renamed from: cm */
    public static final String f8341cm = "8M (3264x2448 4:3)";

    /* renamed from: cn */
    public static final String f8342cn = "3840x2160 30P 16:9";

    /* renamed from: co */
    public static final String f8343co = "2560x1440 60P 16:9";

    /* renamed from: cp */
    public static final String f8344cp = "1920x1080 100P 16:9";

    /* renamed from: cq */
    public static final String f8345cq = "1920x1080 60P 16:9";

    /* renamed from: cr */
    public static final String f8346cr = "1920x1080 30P 16:9";

    /* renamed from: cs */
    public static final String f8347cs = "3840x2160 25P 16:9";

    /* renamed from: ct */
    public static final String f8348ct = "2560x1440 50P 16:9";

    /* renamed from: cu */
    public static final String f8349cu = "1920x1080 100P 16:9";

    /* renamed from: cv */
    public static final String f8350cv = "1920x1080 50P 16:9";

    /* renamed from: cw */
    public static final String f8351cw = "1920x1080 25P 16:9";

    /* renamed from: cx */
    public static final String f8352cx = "12M (4000x3000 4:3)";

    /* renamed from: cy */
    public static final String f8353cy = "8M (3840x2160 16:9)";

    /* renamed from: cz */
    public static final String f8354cz = "JPG";

    /* renamed from: d */
    public static final int f8355d = 8787;

    /* renamed from: e */
    public static final int f8356e = 7878;

    /* renamed from: f */
    public static final int f8357f = 8080;

    /* renamed from: g */
    public static final int f8358g = 8080;

    /* renamed from: h */
    public static String f8359h = null;

    /* renamed from: i */
    public static String f8360i = null;

    /* renamed from: j */
    public static final String f8361j = "a71";

    /* renamed from: k */
    public static final String f8362k = "A12";

    /* renamed from: l */
    public static final int f8363l = 65;

    /* renamed from: m */
    public static final int f8364m = 66;

    /* renamed from: n */
    public static final int f8365n = 1;

    /* renamed from: o */
    public static final int f8366o = 2;

    /* renamed from: p */
    public static final int f8367p = 3;

    /* renamed from: q */
    public static final int f8368q = 4;

    /* renamed from: r */
    public static final int f8369r = 5;

    /* renamed from: s */
    public static final int f8370s = 6;

    /* renamed from: t */
    public static final int f8371t = 7;

    /* renamed from: u */
    public static final int f8372u = 8;

    /* renamed from: v */
    public static final int f8373v = 9;

    /* renamed from: w */
    public static final int f8374w = 10;

    /* renamed from: x */
    public static final int f8375x = 11;

    /* renamed from: y */
    public static final int f8376y = 12;

    /* renamed from: z */
    public static final int f8377z = 13;

    /* renamed from: a */
    public static String f8197a = "192.168.42.200";

    /* renamed from: b */
    public static String f8250b = "192.168.42.100";

    /* renamed from: c */
    public static String f8303c = "192.168.42.150";

    /* renamed from: cO */
    public static final String f8318cO = "/tmp/fuse_d/DCIM/100MEDIA";

    /* renamed from: cR */
    public static String f8321cR = f8318cO;

    /* renamed from: cQ */
    public static final String f8320cQ = "/tmp/fuse_d";

    /* renamed from: cS */
    public static String f8322cS = f8320cQ;

    /* renamed from: cT */
    public static String f8323cT = "/tmp/fuse_d/";

    /* renamed from: cU */
    public static String f8324cU = "free";

    /* renamed from: cV */
    public static String f8325cV = "total";

    /* renamed from: cI */
    public static final String f8312cI = "vf";

    /* renamed from: cW */
    public static String f8326cW = f8312cI;

    /* renamed from: cF */
    public static final String f8309cF = "idle";

    /* renamed from: cX */
    public static String f8327cX = f8309cF;

    /* renamed from: cG */
    public static final String f8310cG = "record";

    /* renamed from: cY */
    public static String f8328cY = f8310cG;

    /* renamed from: com.fimi.soul.biz.camera.e$a */
    /* loaded from: classes.dex */
    public enum EnumC2428a {
        StartRecord,
        TakePhote,
        StopRecord
    }

    /* renamed from: a */
    public static String m12221a() {
        if (C2441a.m12168a().m12166b() == 1) {
            f8197a = "192.168.42.200";
        } else if (C2110f.m13670a().m13668b() == EnumC2091b.X1BH) {
            f8197a = "192.168.42.1";
        } else {
            f8197a = "192.168.100.10";
        }
        return f8197a;
    }

    /* renamed from: b */
    public static String m12220b() {
        if (C2441a.m12168a().m12166b() == 1) {
            f8250b = "192.168.42.100";
        } else {
            f8250b = "192.168.100.1";
        }
        return f8250b;
    }

    /* renamed from: c */
    public static String m12219c() {
        if (C2441a.m12168a().m12166b() == 1) {
            f8303c = "192.168.42.150";
        } else {
            f8303c = "192.168.100.2";
        }
        return f8303c;
    }

    /* renamed from: d */
    public static String m12218d() {
        String format = String.format("rtsp://%s/live", m12221a());
        f8359h = format;
        return format;
    }

    /* renamed from: e */
    public static String m12217e() {
        return String.format("http://%s/mjpeg/list.lst", m12221a());
    }

    /* renamed from: f */
    private static String m12216f() {
        return C2379b.m12410a().m12401b() ? "192.168.40.1" : "192.168.42.200";
    }
}
