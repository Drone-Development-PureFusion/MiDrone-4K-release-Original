package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.fimi.soul.utils.p211a.C3628c;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.string.C4507d;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.service.AbstractC4618am;
import com.xiaomi.push.service.C4600ac;
import com.xiaomi.push.service.C4609ah;
import com.xiaomi.push.service.C4610ai;
import com.xiaomi.xmpush.thrift.C4764aa;
import com.xiaomi.xmpush.thrift.C4766ab;
import com.xiaomi.xmpush.thrift.C4768ac;
import com.xiaomi.xmpush.thrift.C4770ad;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.C4776ag;
import com.xiaomi.xmpush.thrift.C4782aj;
import com.xiaomi.xmpush.thrift.C4786al;
import com.xiaomi.xmpush.thrift.C4790an;
import com.xiaomi.xmpush.thrift.C4794ap;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.C4821q;
import com.xiaomi.xmpush.thrift.C4823r;
import com.xiaomi.xmpush.thrift.C4832w;
import com.xiaomi.xmpush.thrift.C4834x;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import com.xiaomi.xmpush.thrift.EnumC4818o;
import com.xiaomi.xmpush.thrift.EnumC4827t;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;
import org.p248a.p283b.AbstractC5358a;
import org.p248a.p283b.C5389f;
/* renamed from: com.xiaomi.mipush.sdk.s */
/* loaded from: classes.dex */
public class C4543s {

    /* renamed from: c */
    private static Queue<String> f18661c;

    /* renamed from: b */
    private Context f18663b;

    /* renamed from: a */
    private static C4543s f18660a = null;

    /* renamed from: d */
    private static Object f18662d = new Object();

    private C4543s(Context context) {
        this.f18663b = context.getApplicationContext();
        if (this.f18663b == null) {
            this.f18663b = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent m4828a(Context context, String str, Map<String, String> map) {
        Intent intent;
        String str2;
        Intent intent2;
        URISyntaxException e;
        if (map == null || !map.containsKey("notify_effect")) {
            return null;
        }
        String str3 = map.get("notify_effect");
        if (AbstractC4618am.f18984a.equals(str3)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                AbstractC4478b.m5036d("Cause: " + e2.getMessage());
                intent = null;
            }
        } else {
            if (AbstractC4618am.f18985b.equals(str3)) {
                if (map.containsKey("intent_uri")) {
                    String str4 = map.get("intent_uri");
                    if (str4 != null) {
                        try {
                            intent = Intent.parseUri(str4, 1);
                        } catch (URISyntaxException e3) {
                            e = e3;
                            intent = null;
                        }
                        try {
                            intent.setPackage(str);
                        } catch (URISyntaxException e4) {
                            e = e4;
                            AbstractC4478b.m5036d("Cause: " + e.getMessage());
                            if (intent == null) {
                            }
                        }
                    } else {
                        intent = null;
                    }
                } else if (map.containsKey("class_name")) {
                    Intent intent3 = new Intent();
                    intent3.setComponent(new ComponentName(str, map.get("class_name")));
                    try {
                        if (map.containsKey("intent_flag")) {
                            intent3.setFlags(Integer.parseInt(map.get("intent_flag")));
                        }
                    } catch (NumberFormatException e5) {
                        AbstractC4478b.m5036d("Cause by intent_flag: " + e5.getMessage());
                    }
                    intent = intent3;
                }
            } else if (AbstractC4618am.f18986c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                String trim = str2.trim();
                String str5 = (trim.startsWith("http://") || trim.startsWith("https://")) ? trim : "http://" + trim;
                try {
                    String protocol = new URL(str5).getProtocol();
                    if (UriUtil.HTTP_SCHEME.equals(protocol) || UriUtil.HTTPS_SCHEME.equals(protocol)) {
                        intent = new Intent("android.intent.action.VIEW");
                        try {
                            intent.setData(Uri.parse(str5));
                        } catch (MalformedURLException e6) {
                            intent2 = intent;
                            e = e6;
                            AbstractC4478b.m5036d("Cause: " + e.getMessage());
                            intent = intent2;
                            if (intent == null) {
                            }
                        }
                    } else {
                        intent = null;
                    }
                } catch (MalformedURLException e7) {
                    e = e7;
                    intent2 = null;
                }
            }
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        intent.addFlags(268435456);
        try {
            if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                return null;
            }
            return intent;
        } catch (Exception e8) {
            AbstractC4478b.m5036d("Cause: " + e8.getMessage());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:286:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x06cc  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private PushMessageHandler.AbstractC4519a m4825a(C4766ab c4766ab, boolean z, byte[] bArr) {
        int i;
        List<String> list;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        MiPushCommandMessage miPushCommandMessage = null;
        try {
            AbstractC5358a m4838a = C4541q.m4838a(this.f18663b, c4766ab);
            if (m4838a != null) {
                AbstractC4478b.m5037c("receive a message." + m4838a);
                EnumC4763a m3751a = c4766ab.m3751a();
                AbstractC4478b.m5041a("processing a message, action=" + m3751a);
                switch (C4544t.f18664a[m3751a.ordinal()]) {
                    case 1:
                        if (C4520a.m4909a(this.f18663b).m4892l() && !z) {
                            AbstractC4478b.m5041a("receive a message in pause state. drop it");
                            break;
                        } else {
                            C4782aj c4782aj = (C4782aj) m4838a;
                            C4821q m3580l = c4782aj.m3580l();
                            if (m3580l != null) {
                                if (z) {
                                    if (C4600ac.m4414b(c4766ab)) {
                                        MiPushClient.reportIgnoreRegMessageClicked(this.f18663b, m3580l.m3320b(), c4766ab.m3727m(), c4766ab.f19629f, m3580l.m3316d());
                                    } else {
                                        MiPushClient.reportMessageClicked(this.f18663b, m3580l.m3320b(), c4766ab.m3727m(), m3580l.m3316d());
                                    }
                                }
                                if (!z) {
                                    if (!TextUtils.isEmpty(c4782aj.m3582j()) && MiPushClient.aliasSetTime(this.f18663b, c4782aj.m3582j()) < 0) {
                                        MiPushClient.addAlias(this.f18663b, c4782aj.m3582j());
                                    } else if (!TextUtils.isEmpty(c4782aj.m3584h()) && MiPushClient.topicSubscribedTime(this.f18663b, c4782aj.m3584h()) < 0) {
                                        MiPushClient.addTopic(this.f18663b, c4782aj.m3584h());
                                    }
                                }
                                String str = (c4766ab.f19631h == null || c4766ab.f19631h.m3271s() == null) ? null : c4766ab.f19631h.f20460j.get("jobkey");
                                String m3320b = TextUtils.isEmpty(str) ? m3580l.m3320b() : str;
                                if (z || !m4829a(this.f18663b, m3320b)) {
                                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(c4782aj, c4766ab.m3727m(), z);
                                    if (generateMessage.getPassThrough() == 0 && !z && C4600ac.m4418a(generateMessage.getExtra())) {
                                        C4600ac.m4429a(this.f18663b, c4766ab, bArr);
                                        break;
                                    } else {
                                        AbstractC4478b.m5041a("receive a message, msgid=" + m3580l.m3320b() + ", jobkey=" + m3320b);
                                        if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                                            Map<String, String> extra = generateMessage.getExtra();
                                            String str2 = extra.get("notify_effect");
                                            if (!C4600ac.m4414b(c4766ab)) {
                                                Intent m4828a = m4828a(this.f18663b, this.f18663b.getPackageName(), extra);
                                                if (m4828a != null) {
                                                    if (!str2.equals(AbstractC4618am.f18986c)) {
                                                        m4828a.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                                    }
                                                    this.f18663b.startActivity(m4828a);
                                                    break;
                                                }
                                            } else {
                                                Intent m4828a2 = m4828a(this.f18663b, c4766ab.f19629f, extra);
                                                if (m4828a2 != null) {
                                                    String m3314f = m3580l.m3314f();
                                                    if (!TextUtils.isEmpty(m3314f)) {
                                                        m4828a2.putExtra(C3628c.C3629a.f14771d, m3314f);
                                                    }
                                                    this.f18663b.startActivity(m4828a2);
                                                    break;
                                                } else {
                                                    AbstractC4478b.m5041a("Getting Intent fail from ignore reg message. ");
                                                    break;
                                                }
                                            }
                                        } else {
                                            miPushCommandMessage = generateMessage;
                                        }
                                    }
                                } else {
                                    AbstractC4478b.m5041a("drop a duplicate message, key=" + m3320b);
                                }
                                if (c4766ab.m3727m() == null && !z) {
                                    m4823a(c4782aj, c4766ab);
                                    break;
                                }
                            } else {
                                AbstractC4478b.m5036d("receive an empty message without push content, drop it");
                                break;
                            }
                        }
                        break;
                    case 2:
                        C4776ag c4776ag = (C4776ag) m4838a;
                        if (c4776ag.f19803f == 0) {
                            C4520a.m4909a(this.f18663b).m4902b(c4776ag.f19805h, c4776ag.f19806i);
                        }
                        if (!TextUtils.isEmpty(c4776ag.f19805h)) {
                            arrayList3 = new ArrayList();
                            arrayList3.add(c4776ag.f19805h);
                        } else {
                            arrayList3 = null;
                        }
                        miPushCommandMessage = PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_REGISTER, arrayList3, c4776ag.f19803f, c4776ag.f19804g, null);
                        C4545u.m4818a(this.f18663b).m4796e();
                        break;
                    case 3:
                        if (((C4790an) m4838a).f20036f == 0) {
                            C4520a.m4909a(this.f18663b).m4896h();
                            MiPushClient.clearExtras(this.f18663b);
                        }
                        PushMessageHandler.m4921a();
                        break;
                    case 4:
                        C4786al c4786al = (C4786al) m4838a;
                        if (c4786al.f19965f == 0) {
                            MiPushClient.addTopic(this.f18663b, c4786al.m3544h());
                        }
                        if (!TextUtils.isEmpty(c4786al.m3544h())) {
                            arrayList2 = new ArrayList();
                            arrayList2.add(c4786al.m3544h());
                        } else {
                            arrayList2 = null;
                        }
                        miPushCommandMessage = PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_SUBSCRIBE_TOPIC, arrayList2, c4786al.f19965f, c4786al.f19966g, c4786al.m3541k());
                        break;
                    case 5:
                        C4794ap c4794ap = (C4794ap) m4838a;
                        if (c4794ap.f20096f == 0) {
                            MiPushClient.removeTopic(this.f18663b, c4794ap.m3479h());
                        }
                        if (!TextUtils.isEmpty(c4794ap.m3479h())) {
                            arrayList = new ArrayList();
                            arrayList.add(c4794ap.m3479h());
                        } else {
                            arrayList = null;
                        }
                        miPushCommandMessage = PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC, arrayList, c4794ap.f20096f, c4794ap.f20097g, c4794ap.m3476k());
                        break;
                    case 6:
                        C4764aa c4764aa = (C4764aa) m4838a;
                        String m3763e = c4764aa.m3763e();
                        List<String> m3757k = c4764aa.m3757k();
                        if (c4764aa.f19593g == 0) {
                            if (TextUtils.equals(m3763e, MiPushClient.COMMAND_SET_ACCEPT_TIME) && m3757k != null && m3757k.size() > 1) {
                                MiPushClient.addAcceptTime(this.f18663b, m3757k.get(0), m3757k.get(1));
                                if (!"00:00".equals(m3757k.get(0)) || !"00:00".equals(m3757k.get(1))) {
                                    C4520a.m4909a(this.f18663b).m4904a(false);
                                } else {
                                    C4520a.m4909a(this.f18663b).m4904a(true);
                                }
                                list = m4822a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m3757k);
                            } else if (TextUtils.equals(m3763e, MiPushClient.COMMAND_SET_ALIAS) && m3757k != null && m3757k.size() > 0) {
                                MiPushClient.addAlias(this.f18663b, m3757k.get(0));
                                list = m3757k;
                            } else if (TextUtils.equals(m3763e, MiPushClient.COMMAND_UNSET_ALIAS) && m3757k != null && m3757k.size() > 0) {
                                MiPushClient.removeAlias(this.f18663b, m3757k.get(0));
                                list = m3757k;
                            } else if (TextUtils.equals(m3763e, MiPushClient.COMMAND_SET_ACCOUNT) && m3757k != null && m3757k.size() > 0) {
                                MiPushClient.addAccount(this.f18663b, m3757k.get(0));
                                list = m3757k;
                            } else if (TextUtils.equals(m3763e, MiPushClient.COMMAND_UNSET_ACCOUNT) && m3757k != null && m3757k.size() > 0) {
                                MiPushClient.removeAccount(this.f18663b, m3757k.get(0));
                            }
                            miPushCommandMessage = PushMessageHelper.generateCommandMessage(m3763e, list, c4764aa.f19593g, c4764aa.f19594h, c4764aa.m3755m());
                            break;
                        }
                        list = m3757k;
                        miPushCommandMessage = PushMessageHelper.generateCommandMessage(m3763e, list, c4764aa.f19593g, c4764aa.f19594h, c4764aa.m3755m());
                        break;
                    case 7:
                        if (m4838a instanceof C4834x) {
                            C4834x c4834x = (C4834x) m4838a;
                            String m3192c = c4834x.m3192c();
                            if (!EnumC4818o.DisablePushMessage.f20376N.equalsIgnoreCase(c4834x.f20615e)) {
                                if (EnumC4818o.EnablePushMessage.f20376N.equalsIgnoreCase(c4834x.f20615e)) {
                                    if (c4834x.f20617g != 0) {
                                        if (!"enable_syncing".equals(C4540p.m4845a(this.f18663b).m4846a())) {
                                            C4540p.m4845a(this.f18663b).m4841d(m3192c);
                                            break;
                                        } else {
                                            synchronized (C4540p.class) {
                                                if (C4540p.m4845a(this.f18663b).m4840e(m3192c)) {
                                                    if (C4540p.m4845a(this.f18663b).m4842c(m3192c) < 10) {
                                                        C4540p.m4845a(this.f18663b).m4843b(m3192c);
                                                        C4545u.m4818a(this.f18663b).m4802a(false, m3192c);
                                                    } else {
                                                        C4540p.m4845a(this.f18663b).m4841d(m3192c);
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                    } else {
                                        synchronized (C4540p.class) {
                                            if (C4540p.m4845a(this.f18663b).m4840e(m3192c)) {
                                                C4540p.m4845a(this.f18663b).m4841d(m3192c);
                                                if ("enable_syncing".equals(C4540p.m4845a(this.f18663b).m4846a())) {
                                                    C4540p.m4845a(this.f18663b).m4839f("enable_synced");
                                                    C4540p.m4845a(this.f18663b).m4841d(m3192c);
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            } else if (c4834x.f20617g != 0) {
                                if (!"disable_syncing".equals(C4540p.m4845a(this.f18663b).m4846a())) {
                                    C4540p.m4845a(this.f18663b).m4841d(m3192c);
                                    break;
                                } else {
                                    synchronized (C4540p.class) {
                                        if (C4540p.m4845a(this.f18663b).m4840e(m3192c)) {
                                            if (C4540p.m4845a(this.f18663b).m4842c(m3192c) < 10) {
                                                C4540p.m4845a(this.f18663b).m4843b(m3192c);
                                                C4545u.m4818a(this.f18663b).m4802a(true, m3192c);
                                            } else {
                                                C4540p.m4845a(this.f18663b).m4841d(m3192c);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                synchronized (C4540p.class) {
                                    if (C4540p.m4845a(this.f18663b).m4840e(m3192c)) {
                                        C4540p.m4845a(this.f18663b).m4841d(m3192c);
                                        if ("disable_syncing".equals(C4540p.m4845a(this.f18663b).m4846a())) {
                                            C4540p.m4845a(this.f18663b).m4839f("disable_synced");
                                            MiPushClient.clearNotification(this.f18663b);
                                            MiPushClient.clearLocalNotificationType(this.f18663b);
                                            PushMessageHandler.m4921a();
                                            C4545u.m4818a(this.f18663b).m4801b();
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (m4838a instanceof C4772ae) {
                            C4772ae c4772ae = (C4772ae) m4838a;
                            if ("registration id expired".equalsIgnoreCase(c4772ae.f19687e)) {
                                MiPushClient.reInitialize(this.f18663b, EnumC4827t.RegIdExpired);
                                break;
                            } else if ("client_info_update_ok".equalsIgnoreCase(c4772ae.f19687e)) {
                                if (c4772ae.m3688i() != null && c4772ae.m3688i().containsKey(Constants.EXTRA_KEY_APP_VERSION)) {
                                    C4520a.m4909a(this.f18663b).m4907a(c4772ae.m3688i().get(Constants.EXTRA_KEY_APP_VERSION));
                                    break;
                                }
                            } else if ("awake_app".equalsIgnoreCase(c4772ae.f19687e)) {
                                if (c4772ae.m3688i() != null && c4772ae.m3688i().containsKey("packages")) {
                                    MiPushClient.awakeApps(this.f18663b, c4772ae.m3688i().get("packages").split(Constants.ACCEPT_TIME_SEPARATOR_SP));
                                    break;
                                }
                            } else if (EnumC4818o.NormalClientConfigUpdate.f20376N.equalsIgnoreCase(c4772ae.f19687e)) {
                                C4770ad c4770ad = new C4770ad();
                                try {
                                    C4796aq.m3470a(c4770ad, c4772ae.m3684m());
                                    C4610ai.m4388a(C4609ah.m4394a(this.f18663b), c4770ad);
                                    break;
                                } catch (C5389f e) {
                                    AbstractC4478b.m5039a(e);
                                    break;
                                }
                            } else if (EnumC4818o.CustomClientConfigUpdate.f20376N.equalsIgnoreCase(c4772ae.f19687e)) {
                                C4768ac c4768ac = new C4768ac();
                                try {
                                    C4796aq.m3470a(c4768ac, c4772ae.m3684m());
                                    C4610ai.m4389a(C4609ah.m4394a(this.f18663b), c4768ac);
                                    break;
                                } catch (C5389f e2) {
                                    AbstractC4478b.m5039a(e2);
                                    break;
                                }
                            } else if (EnumC4818o.SyncInfoResult.f20376N.equalsIgnoreCase(c4772ae.f19687e)) {
                                C4549x.m4786a(this.f18663b, c4772ae);
                                break;
                            } else if (EnumC4818o.ForceSync.f20376N.equalsIgnoreCase(c4772ae.f19687e)) {
                                AbstractC4478b.m5041a("receive force sync notification");
                                C4549x.m4785a(this.f18663b, false);
                                break;
                            } else if (EnumC4818o.GeoRegsiter.f20376N.equalsIgnoreCase(c4772ae.f19687e)) {
                                C4528f.m4867a(this.f18663b).m4866a(c4772ae);
                                break;
                            } else if (EnumC4818o.GeoUnregsiter.f20376N.equalsIgnoreCase(c4772ae.f19687e)) {
                                C4528f.m4867a(this.f18663b).m4863b(c4772ae);
                                break;
                            } else if (EnumC4818o.GeoSync.f20376N.equalsIgnoreCase(c4772ae.f19687e)) {
                                C4528f.m4867a(this.f18663b).m4862c(c4772ae);
                                break;
                            } else if (EnumC4818o.CancelPushMessage.f20376N.equals(c4772ae.f19687e) && c4772ae.m3688i() != null) {
                                if (c4772ae.m3688i().containsKey(AbstractC4618am.f18983H)) {
                                    String str3 = c4772ae.m3688i().get(AbstractC4618am.f18983H);
                                    if (!TextUtils.isEmpty(str3)) {
                                        try {
                                            i = Integer.parseInt(str3);
                                        } catch (NumberFormatException e3) {
                                            e3.printStackTrace();
                                            i = -2;
                                        }
                                        if (i >= -1) {
                                            String str4 = "";
                                            if (c4772ae.m3688i().containsKey(AbstractC4618am.f18981F)) {
                                                str4 = c4772ae.m3688i().get(AbstractC4618am.f18981F);
                                            }
                                            MiPushClient.clearNotification(this.f18663b, str4, c4772ae.m3688i().containsKey(AbstractC4618am.f18982G) ? c4772ae.m3688i().get(AbstractC4618am.f18982G) : "");
                                            break;
                                        } else {
                                            MiPushClient.clearNotification(this.f18663b, i);
                                            break;
                                        }
                                    }
                                }
                                i = -2;
                                if (i >= -1) {
                                }
                            }
                        }
                        break;
                }
            } else {
                AbstractC4478b.m5036d("receiving an un-recognized message. " + c4766ab.f19624a);
            }
        } catch (C4525c e4) {
            AbstractC4478b.m5039a(e4);
            m4826a(c4766ab);
        } catch (C5389f e5) {
            AbstractC4478b.m5039a(e5);
            AbstractC4478b.m5036d("receive a message which action string is not valid. is the reg expired?");
        }
        return miPushCommandMessage;
    }

    /* renamed from: a */
    private PushMessageHandler.AbstractC4519a m4824a(C4766ab c4766ab, byte[] bArr) {
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        r1 = null;
        String str = null;
        miPushMessage = null;
        miPushMessage = null;
        try {
            AbstractC5358a m4838a = C4541q.m4838a(this.f18663b, c4766ab);
            if (m4838a != null) {
                AbstractC4478b.m5037c("message arrived: receive a message." + m4838a);
                EnumC4763a m3751a = c4766ab.m3751a();
                AbstractC4478b.m5041a("message arrived: processing an arrived message, action=" + m3751a);
                switch (C4544t.f18664a[m3751a.ordinal()]) {
                    case 1:
                        C4782aj c4782aj = (C4782aj) m4838a;
                        C4821q m3580l = c4782aj.m3580l();
                        if (m3580l != null) {
                            if (c4766ab.f19631h != null && c4766ab.f19631h.m3271s() != null) {
                                str = c4766ab.f19631h.f20460j.get("jobkey");
                            }
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(c4782aj, c4766ab.m3727m(), false);
                            generateMessage.setArrivedMessage(true);
                            AbstractC4478b.m5041a("message arrived: receive a message, msgid=" + m3580l.m3320b() + ", jobkey=" + str);
                            miPushMessage = generateMessage;
                            break;
                        } else {
                            AbstractC4478b.m5036d("message arrived: receive an empty message without push content, drop it");
                            break;
                        }
                        break;
                }
            } else {
                AbstractC4478b.m5036d("message arrived: receiving an un-recognized message. " + c4766ab.f19624a);
            }
        } catch (C4525c e) {
            AbstractC4478b.m5039a(e);
            AbstractC4478b.m5036d("message arrived: receive a message but decrypt failed. report when click.");
        } catch (C5389f e2) {
            AbstractC4478b.m5039a(e2);
            AbstractC4478b.m5036d("message arrived: receive a message which action string is not valid. is the reg expired?");
        }
        return miPushMessage;
    }

    /* renamed from: a */
    public static C4543s m4830a(Context context) {
        if (f18660a == null) {
            f18660a = new C4543s(context);
        }
        return f18660a;
    }

    /* renamed from: a */
    private void m4831a() {
        SharedPreferences sharedPreferences = this.f18663b.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f18663b, EnumC4827t.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    /* renamed from: a */
    private void m4826a(C4766ab c4766ab) {
        AbstractC4478b.m5041a("receive a message but decrypt failed. report now.");
        C4772ae c4772ae = new C4772ae(c4766ab.m3727m().f20451a, false);
        c4772ae.m3695c(EnumC4818o.DecryptMessageFail.f20376N);
        c4772ae.m3698b(c4766ab.m3732h());
        c4772ae.m3693d(c4766ab.f19629f);
        c4772ae.f19690h = new HashMap();
        c4772ae.f19690h.put("regid", MiPushClient.getRegId(this.f18663b));
        C4545u.m4818a(this.f18663b).m4807a(c4772ae, EnumC4763a.Notification, false, null);
    }

    /* renamed from: a */
    private void m4823a(C4782aj c4782aj, C4766ab c4766ab) {
        C4823r m3727m = c4766ab.m3727m();
        C4832w c4832w = new C4832w();
        c4832w.m3225b(c4782aj.m3587e());
        c4832w.m3230a(c4782aj.m3589c());
        c4832w.m3232a(c4782aj.m3580l().m3312h());
        if (!TextUtils.isEmpty(c4782aj.m3584h())) {
            c4832w.m3221c(c4782aj.m3584h());
        }
        if (!TextUtils.isEmpty(c4782aj.m3582j())) {
            c4832w.m3218d(c4782aj.m3582j());
        }
        c4832w.m3229a(C4796aq.m3472a(this.f18663b, c4766ab));
        C4545u.m4818a(this.f18663b).m4809a((C4545u) c4832w, EnumC4763a.AckMessage, m3727m);
    }

    /* renamed from: a */
    private static boolean m4829a(Context context, String str) {
        boolean z = false;
        synchronized (f18662d) {
            SharedPreferences m4894j = C4520a.m4909a(context).m4894j();
            if (f18661c == null) {
                String[] split = m4894j.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f18661c = new LinkedList();
                for (String str2 : split) {
                    f18661c.add(str2);
                }
            }
            if (f18661c.contains(str)) {
                z = true;
            } else {
                f18661c.add(str);
                if (f18661c.size() > 25) {
                    f18661c.poll();
                }
                String m4947a = C4507d.m4947a(f18661c, Constants.ACCEPT_TIME_SEPARATOR_SP);
                SharedPreferences.Editor edit = m4894j.edit();
                edit.putString("pref_msg_ids", m4947a);
                edit.commit();
            }
        }
        return z;
    }

    /* renamed from: b */
    private void m4821b(C4766ab c4766ab) {
        C4823r m3727m = c4766ab.m3727m();
        C4832w c4832w = new C4832w();
        c4832w.m3225b(c4766ab.m3732h());
        c4832w.m3230a(m3727m.m3298b());
        c4832w.m3232a(m3727m.m3289d());
        if (!TextUtils.isEmpty(m3727m.m3284f())) {
            c4832w.m3221c(m3727m.m3284f());
        }
        c4832w.m3229a(C4796aq.m3472a(this.f18663b, c4766ab));
        C4545u.m4818a(this.f18663b).m4807a(c4832w, EnumC4763a.AckMessage, false, c4766ab.m3727m());
    }

    /* renamed from: a */
    public PushMessageHandler.AbstractC4519a m4827a(Intent intent) {
        String action = intent.getAction();
        AbstractC4478b.m5041a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                AbstractC4478b.m5036d("receiving an empty message, drop");
                return null;
            }
            C4766ab c4766ab = new C4766ab();
            try {
                C4796aq.m3470a(c4766ab, byteArrayExtra);
                C4520a m4909a = C4520a.m4909a(this.f18663b);
                C4823r m3727m = c4766ab.m3727m();
                if (c4766ab.m3751a() == EnumC4763a.SendMessage && m3727m != null && !m4909a.m4892l() && !booleanExtra) {
                    if (m3727m != null) {
                        c4766ab.m3727m().m3301a("mrt", stringExtra);
                        c4766ab.m3727m().m3301a("mat", Long.toString(System.currentTimeMillis()));
                    }
                    m4821b(c4766ab);
                }
                if (c4766ab.m3751a() == EnumC4763a.SendMessage && !c4766ab.m3739c()) {
                    if (!C4600ac.m4414b(c4766ab)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = c4766ab.m3730j();
                        objArr[1] = m3727m != null ? m3727m.m3298b() : "";
                        AbstractC4478b.m5041a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr));
                        return null;
                    } else if (!booleanExtra || m3727m.m3271s() == null || !m3727m.m3271s().containsKey("notify_effect")) {
                        AbstractC4478b.m5041a(String.format("drop an un-encrypted messages. %1$s, %2$s", c4766ab.m3730j(), m3727m.m3298b()));
                        return null;
                    }
                }
                if (m4909a.m4895i() || c4766ab.f19624a == EnumC4763a.Registration) {
                    if (!m4909a.m4895i() || !m4909a.m4890n()) {
                        return m4825a(c4766ab, booleanExtra, byteArrayExtra);
                    }
                    if (c4766ab.f19624a == EnumC4763a.UnRegistration) {
                        m4909a.m4896h();
                        MiPushClient.clearExtras(this.f18663b);
                        PushMessageHandler.m4921a();
                    } else {
                        MiPushClient.unregisterPush(this.f18663b);
                    }
                } else if (C4600ac.m4414b(c4766ab)) {
                    return m4825a(c4766ab, booleanExtra, byteArrayExtra);
                } else {
                    AbstractC4478b.m5036d("receive message without registration. need re-register!");
                    m4831a();
                }
            } catch (C5389f e) {
                AbstractC4478b.m5039a(e);
            } catch (Exception e2) {
                AbstractC4478b.m5039a(e2);
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            C4766ab c4766ab2 = new C4766ab();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    C4796aq.m3470a(c4766ab2, byteArrayExtra2);
                }
            } catch (C5389f e3) {
            }
            miPushCommandMessage.setCommand(String.valueOf(c4766ab2.m3751a()));
            miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            AbstractC4478b.m5036d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                AbstractC4478b.m5036d("message arrived: receiving an empty message, drop");
                return null;
            }
            C4766ab c4766ab3 = new C4766ab();
            try {
                C4796aq.m3470a(c4766ab3, byteArrayExtra3);
                C4520a m4909a2 = C4520a.m4909a(this.f18663b);
                if (C4600ac.m4414b(c4766ab3)) {
                    AbstractC4478b.m5036d("message arrived: receive ignore reg message, ignore!");
                } else if (!m4909a2.m4895i()) {
                    AbstractC4478b.m5036d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!m4909a2.m4895i() || !m4909a2.m4890n()) {
                    return m4824a(c4766ab3, byteArrayExtra3);
                } else {
                    AbstractC4478b.m5036d("message arrived: app info is invalidated");
                }
            } catch (C5389f e4) {
                AbstractC4478b.m5039a(e4);
            } catch (Exception e5) {
                AbstractC4478b.m5039a(e5);
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<String> m4822a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(":")[0]) * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = (((Long.parseLong(list.get(1).split(":")[1]) + (60 * Long.parseLong(list.get(1).split(":")[0]))) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }
}
