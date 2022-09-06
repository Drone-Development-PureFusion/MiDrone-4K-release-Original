package com.baidu.tts.client.model;

import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class AvailableConditions {

    /* renamed from: a */
    private Set<String> f5833a;

    /* renamed from: b */
    private Set<String> f5834b;

    public void appendGender(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.f5833a == null) {
            this.f5833a = new HashSet();
        }
        this.f5833a.add(str);
    }

    public void appendSpeaker(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.f5834b == null) {
            this.f5834b = new HashSet();
        }
        this.f5834b.add(str);
    }

    public Set<String> getGenders() {
        return this.f5833a;
    }

    public Set<String> getSpeakers() {
        return this.f5834b;
    }

    public void setGenders(Set<String> set) {
        this.f5833a = set;
    }

    public void setSpeakers(Set<String> set) {
        this.f5834b = set;
    }
}
