package com.p080b;

import java.io.IOException;
/* renamed from: com.b.bj */
/* loaded from: classes.dex */
public class C1465bj extends C1466bk<String, C1457be> {
    public C1465bj() {
        super(1048576);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p080b.C1466bk
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int mo16077a(String str, C1457be c1457be) {
        if (c1457be == null) {
            return 0;
        }
        try {
            return (int) c1457be.m16118g();
        } catch (IOException e) {
            C1514cx.m15728a(e, "OfflineFileCache", "sizeOf");
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p080b.C1466bk
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo16076a(boolean z, String str, C1457be c1457be, C1457be c1457be2) {
        if (c1457be != null) {
            try {
                c1457be.m16123b();
            } catch (IOException e) {
                C1514cx.m15728a(e, "OfflineFileCache", "entryRemoved");
            }
        }
        super.mo16076a(z, (boolean) str, c1457be, c1457be2);
    }
}
