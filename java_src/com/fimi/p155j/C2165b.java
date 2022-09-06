package com.fimi.p155j;

import android.util.Xml;
import com.tencent.open.GameAppOperation;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
/* renamed from: com.fimi.j.b */
/* loaded from: classes.dex */
public class C2165b {
    /* renamed from: a */
    public List<C2164a> m13345a(InputStream inputStream) {
        ArrayList arrayList = null;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        C2164a c2164a = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    if ("firmwares".equals(newPullParser.getName())) {
                        arrayList = new ArrayList();
                        break;
                    } else if ("firmware".equals(newPullParser.getName())) {
                        c2164a = new C2164a();
                        break;
                    } else if ("name".equals(newPullParser.getName())) {
                        c2164a.m13348a(newPullParser.nextText());
                        break;
                    } else if (GameAppOperation.QQFAV_DATALINE_VERSION.equals(newPullParser.getName())) {
                        c2164a.m13346b(newPullParser.nextText());
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ("firmware".equals(newPullParser.getName())) {
                        arrayList.add(c2164a);
                        break;
                    } else {
                        break;
                    }
            }
        }
        inputStream.close();
        return arrayList;
    }
}
