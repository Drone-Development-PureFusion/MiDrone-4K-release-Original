package com.fimi.soul.module.update.p210a;

import android.util.Log;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p163c.C2241c;
import com.fimi.kernel.utils.C2276u;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.update.C2649e;
import com.fimi.soul.biz.update.C2654j;
import com.fimi.soul.biz.update.C2656k;
import com.fimi.soul.entity.FirmwareInfo;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.service.InitAppService;
import com.fimi.soul.utils.C3681j;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* renamed from: com.fimi.soul.module.update.a.a */
/* loaded from: classes.dex */
public class C3579a {

    /* renamed from: c */
    private static C3579a f14494c = new C3579a();

    /* renamed from: b */
    private Map<Integer, C3583e> f14496b = new HashMap();

    /* renamed from: a */
    AbstractC3581c f14495a = new C3584f();

    /* renamed from: a */
    public static synchronized C3579a m7971a() {
        C3579a c3579a;
        synchronized (C3579a.class) {
            if (f14494c == null) {
                f14494c = new C3579a();
            }
            c3579a = f14494c;
        }
        return c3579a;
    }

    /* renamed from: a */
    public C3583e m7970a(int i) {
        return this.f14496b.containsKey(Integer.valueOf(i)) ? this.f14496b.get(Integer.valueOf(i)) : new C3583e();
    }

    /* renamed from: a */
    public void m7969a(int i, int i2) {
        this.f14495a.mo7898a(i, i2);
    }

    /* renamed from: a */
    public void m7968a(C3583e c3583e) {
        if (c3583e == null) {
            return;
        }
        this.f14496b.put(Integer.valueOf(c3583e.m7912d()), c3583e);
    }

    /* renamed from: a */
    public void m7967a(List<UpdateVersonBean> list, List<UpdateVersonBean> list2) {
        boolean z;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                list2.add(list.get(i));
            }
            int i2 = 0;
            while (true) {
                if (i2 >= list2.size()) {
                    z = false;
                    break;
                }
                UpdateVersonBean updateVersonBean = list.get(i);
                UpdateVersonBean updateVersonBean2 = list2.get(i2);
                if (!updateVersonBean.getSysname().equals(updateVersonBean2.getSysname())) {
                    i2++;
                } else if (Integer.valueOf(updateVersonBean.getNewVersion()).intValue() > Integer.valueOf(updateVersonBean2.getNewVersion()).intValue()) {
                    list2.set(i2, list.get(i));
                    z = true;
                } else {
                    z = true;
                }
            }
            if (!z) {
                list2.add(list.get(i));
            }
        }
    }

    /* renamed from: b */
    public Map<Integer, C3583e> m7966b() {
        return this.f14496b;
    }

    /* renamed from: b */
    public void m7965b(int i) {
        this.f14495a.mo7896a(this.f14496b.get(Integer.valueOf(i)));
        this.f14495a.mo7892d(i);
    }

    /* renamed from: c */
    public void m7964c() {
        C2238c.m13125c().mo13117a(C3587b.f14534C, new C3580b());
        this.f14496b.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x01aa, code lost:
        if (r13 <= 0) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01ac, code lost:
        r0 = true;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<FirmwareInfo> m7963d() {
        C3583e c3583e;
        int m7921b;
        C3583e c3583e2;
        ArrayList arrayList = new ArrayList();
        List<UpdateVersonBean> mo13111b = C2241c.m13122a().mo13111b(InitAppService.f14690a, UpdateVersonBean.class);
        if (mo13111b != null && mo13111b.size() > 0) {
            for (UpdateVersonBean updateVersonBean : mo13111b) {
                int intValue = Integer.valueOf(updateVersonBean.getNewVersion()).intValue();
                int m11358c = C2654j.m11358c(updateVersonBean.getSysid());
                File file = updateVersonBean.getSysid() == 11 ? new File(C3681j.m7457v() + C2654j.m11367a(updateVersonBean.getFileEncode())) : updateVersonBean.getSysid() == 15 ? new File(C3681j.m7457v() + C2654j.m11366a(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion())) : updateVersonBean.getSysid() == 26 ? new File(C3681j.m7457v() + C2654j.m11361b(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion())) : updateVersonBean.getSysid() == 14 ? new File(C3681j.m7457v() + C2654j.m11356c(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion())) : updateVersonBean.getSysid() == 25 ? new File(C3681j.m7457v() + C2654j.m11356c(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion())) : new File(this.f14495a.mo7893c(m11358c));
                boolean z = C2277v.m12784a(DroidPlannerApp.m12520g()).m12746o() == 1;
                if (!C2367d.m12459a().m12437l() || z) {
                    if (!C2367d.m12459a().m12440i() || (updateVersonBean.getSysid() != 6 && updateVersonBean.getSysid() != 9 && updateVersonBean.getSysid() != 10 && updateVersonBean.getSysid() != 0 && updateVersonBean.getSysid() != 3 && updateVersonBean.getSysid() != 1 && updateVersonBean.getSysid() != 11 && updateVersonBean.getSysid() != 4 && updateVersonBean.getSysid() != 253 && updateVersonBean.getSysid() != 5)) {
                        if (!C2367d.m12459a().m12439j() || (updateVersonBean.getSysid() != 12 && updateVersonBean.getSysid() != 14 && updateVersonBean.getSysid() != 25 && updateVersonBean.getSysid() != 15 && updateVersonBean.getSysid() != 26 && updateVersonBean.getSysid() != 17 && updateVersonBean.getSysid() != 16 && updateVersonBean.getSysid() != 20 && updateVersonBean.getSysid() != 18 && updateVersonBean.getSysid() != 19 && updateVersonBean.getSysid() != 13 && updateVersonBean.getSysid() != 23)) {
                            if (updateVersonBean.getSysid() != 27 || z) {
                                if (updateVersonBean.getFileEncode().equals(C2276u.m12789a(file)) && (c3583e = f14494c.m7966b().get(Integer.valueOf(m11358c))) != null && ((m7921b = c3583e.m7921b()) >= 1335 || m7921b == 1 || (updateVersonBean.getSysid() != 5 && updateVersonBean.getSysid() != 23))) {
                                    if (updateVersonBean.getSysid() != 11 || (c3583e2 = f14494c.m7966b().get(1)) == null || c3583e2.m7921b() >= 1707) {
                                        boolean z2 = false;
                                        boolean z3 = "1".equals(updateVersonBean.getForceSign()) && intValue != m7921b;
                                        boolean z4 = "2".equals(updateVersonBean.getForceSign()) && intValue > m7921b;
                                        if (z2 || z3 || z4) {
                                            int m11363b = C2654j.m11363b(m11358c);
                                            int intValue2 = C2654j.m11373a().get(Integer.valueOf(m11358c)).intValue();
                                            FirmwareInfo firmwareInfo = new FirmwareInfo(m11358c, m11358c, updateVersonBean.getSysname(), "", "", updateVersonBean.getNewVersion(), 1, m11363b, updateVersonBean.getSysname());
                                            firmwareInfo.setFileEncode(updateVersonBean.getFileEncode());
                                            firmwareInfo.setUpdcontents(updateVersonBean.getUpdcontents());
                                            firmwareInfo.setSource(1);
                                            firmwareInfo.setUpdateTime(intValue2);
                                            firmwareInfo.setForceSign(updateVersonBean.getForceSign());
                                            firmwareInfo.setFileSize(Long.valueOf(updateVersonBean.getSize()).longValue());
                                            if (m7921b == 1) {
                                                firmwareInfo.setVersionError(true);
                                            }
                                            arrayList.add(firmwareInfo);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList, new C2649e());
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01fa, code lost:
        if (r5 <= 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01fc, code lost:
        r2 = true;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<UpdateVersonBean> m7962e() {
        List<UpdateVersonBean> mo13111b = C2238c.m13125c().mo13111b(InitAppService.f14690a, UpdateVersonBean.class);
        ArrayList arrayList = new ArrayList();
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null || c3580b.m7943i() == null || c3580b.m7943i().size() == 0) {
            return arrayList;
        }
        if (mo13111b != null && mo13111b.size() > 0) {
            for (UpdateVersonBean updateVersonBean : mo13111b) {
                int m11358c = C2654j.m11358c(updateVersonBean.getSysid());
                File file = updateVersonBean.getSysid() == 11 ? new File(C3681j.m7457v() + C2654j.m11367a(updateVersonBean.getFileEncode())) : updateVersonBean.getSysid() == 15 ? new File(C3681j.m7457v() + C2654j.m11366a(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion())) : updateVersonBean.getSysid() == 26 ? new File(C3681j.m7457v() + C2654j.m11361b(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion())) : updateVersonBean.getSysid() == 14 ? new File(C3681j.m7457v() + C2654j.m11356c(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion())) : updateVersonBean.getSysid() == 25 ? new File(C3681j.m7457v() + C2654j.m11352d(updateVersonBean.getFileEncode(), updateVersonBean.getNewVersion())) : new File(this.f14495a.mo7893c(m11358c));
                String fileEncode = updateVersonBean.getFileEncode();
                String m12789a = C2276u.m12789a(file);
                boolean z = C2277v.m12784a(DroidPlannerApp.m12520g()).m12746o() == 1;
                if (!C2367d.m12459a().m12437l() || z) {
                    if ((!C2367d.m12459a().m12440i() && !z) || (updateVersonBean.getSysid() != 6 && updateVersonBean.getSysid() != 9 && updateVersonBean.getSysid() != 10 && updateVersonBean.getSysid() != 0 && updateVersonBean.getSysid() != 3 && updateVersonBean.getSysid() != 1 && updateVersonBean.getSysid() != 11 && updateVersonBean.getSysid() != 4 && updateVersonBean.getSysid() != 253 && updateVersonBean.getSysid() != 5)) {
                        if (!C2367d.m12459a().m12439j() || (updateVersonBean.getSysid() != 12 && updateVersonBean.getSysid() != 14 && updateVersonBean.getSysid() != 15 && updateVersonBean.getSysid() != 26 && updateVersonBean.getSysid() != 17 && updateVersonBean.getSysid() != 16 && updateVersonBean.getSysid() != 20 && updateVersonBean.getSysid() != 18 && updateVersonBean.getSysid() != 19 && updateVersonBean.getSysid() != 25 && updateVersonBean.getSysid() != 13 && updateVersonBean.getSysid() != 23 && updateVersonBean.getSysid() != 27)) {
                            Log.d("moweiru", "fileURL:" + this.f14495a.mo7893c(m11358c));
                            Log.d("moweiru", "SysName:" + updateVersonBean.getSysname() + ";Net Md5:" + fileEncode + ";Local Md5:" + m12789a + ";SysID:" + m11358c);
                            if (!fileEncode.equals(m12789a)) {
                                int intValue = Integer.valueOf(updateVersonBean.getNewVersion()).intValue();
                                int intValue2 = c3580b.m7943i().get(Integer.valueOf(m11358c)) == null ? 0 : c3580b.m7943i().get(Integer.valueOf(m11358c)).intValue();
                                if (intValue2 >= 1335 || intValue2 == 1 || (updateVersonBean.getSysid() != 5 && updateVersonBean.getSysid() != 23)) {
                                    boolean z2 = false;
                                    boolean z3 = "1".equals(updateVersonBean.getForceSign()) && intValue != intValue2 && intValue2 > 0;
                                    boolean z4 = "2".equals(updateVersonBean.getForceSign()) && intValue > intValue2 && intValue2 > 0;
                                    if (z2 || z3 || z4) {
                                        updateVersonBean.setSort(C2654j.m11363b(m11358c));
                                        arrayList.add(updateVersonBean);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (arrayList != null) {
            Collections.sort(arrayList, new C2656k());
        }
        return arrayList;
    }

    /* renamed from: f */
    public AbstractC3581c m7961f() {
        return this.f14495a;
    }

    /* renamed from: g */
    public UpdateVersonBean m7960g() {
        List mo13111b = C2238c.m13125c().mo13111b(InitAppService.f14690a, UpdateVersonBean.class);
        if (mo13111b != null && mo13111b.size() > 0) {
            Iterator it2 = mo13111b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                UpdateVersonBean updateVersonBean = (UpdateVersonBean) it2.next();
                if (updateVersonBean.getSysid() == 24) {
                    if (!updateVersonBean.getFileEncode().equals(C2276u.m12789a(new File(C3681j.m7457v() + C2654j.m11364b())))) {
                        return updateVersonBean;
                    }
                }
            }
        }
        return null;
    }
}
