package org.codehaus.jackson.mrbean;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.Module;
/* loaded from: classes2.dex */
public class MrBeanModule extends Module {
    private static final Version VERSION = new Version(1, 8, 0, null);
    private final String NAME;
    protected AbstractTypeMaterializer _materializer;

    public MrBeanModule() {
        this(new AbstractTypeMaterializer());
    }

    public MrBeanModule(AbstractTypeMaterializer abstractTypeMaterializer) {
        this.NAME = "MrBeanModule";
        this._materializer = abstractTypeMaterializer;
    }

    @Override // org.codehaus.jackson.map.Module
    public String getModuleName() {
        return "MrBeanModule";
    }

    @Override // org.codehaus.jackson.map.Module
    public void setupModule(Module.SetupContext setupContext) {
        setupContext.addAbstractTypeResolver(this._materializer);
    }

    @Override // org.codehaus.jackson.map.Module, org.codehaus.jackson.Versioned
    public Version version() {
        return VERSION;
    }
}
