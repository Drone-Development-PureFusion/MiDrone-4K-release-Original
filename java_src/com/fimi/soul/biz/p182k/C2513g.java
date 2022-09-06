package com.fimi.soul.biz.p182k;

import android.content.Context;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p170c.C2374a;
import com.fimi.soul.entity.FdsMsg;
import com.fimi.soul.entity.PlaneMsg;
import com.xiaomi.infra.galaxy.fds.android.FDSClientConfiguration;
import com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClient;
import com.xiaomi.infra.galaxy.fds.android.GalaxyFDSClientImpl;
import com.xiaomi.infra.galaxy.fds.android.auth.OAuthCredential;
import com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException;
import com.xiaomi.infra.galaxy.fds.android.model.ExpiresParam;
import com.xiaomi.infra.galaxy.fds.android.model.FDSObject;
import com.xiaomi.infra.galaxy.fds.android.model.ObjectMetadata;
import com.xiaomi.infra.galaxy.fds.android.model.ProgressListener;
import com.xiaomi.infra.galaxy.fds.android.model.PutObjectResult;
import com.xiaomi.infra.galaxy.fds.android.model.UserParam;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.biz.k.g */
/* loaded from: classes.dex */
public class C2513g {

    /* renamed from: a */
    private Context f8696a;

    /* renamed from: b */
    private GalaxyFDSClient f8697b;

    /* renamed from: c */
    private String f8698c = null;

    /* renamed from: d */
    private String f8699d = null;

    /* renamed from: e */
    private List<UserParam> f8700e;

    /* renamed from: f */
    private AbstractC2514a f8701f;

    /* renamed from: com.fimi.soul.biz.k.g$a */
    /* loaded from: classes.dex */
    public interface AbstractC2514a {
        /* renamed from: a */
        void mo11680a(C2515h c2515h);
    }

    public C2513g(Context context) {
        this.f8700e = null;
        this.f8700e = new ArrayList();
        this.f8696a = context;
    }

    /* renamed from: a */
    public PlaneMsg m11824a() {
        boolean z;
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            this.f8698c = C2374a.m12422c(this.f8696a, 0);
            this.f8699d = C2374a.m12424b(this.f8696a, 0);
            FDSClientConfiguration withFdsServiceBaseUri = new FDSClientConfiguration().withCredential(new OAuthCredential(C2353b.f7955m, "2882303761517328945", "2882303761517328945", this.f8698c, C2353b.f7966x, this.f8699d, C2353b.f7957o)).withFdsServiceBaseUri(C2353b.f7955m);
            withFdsServiceBaseUri.setUploadPartSize(1048576);
            this.f8697b = new GalaxyFDSClientImpl(withFdsServiceBaseUri);
            this.f8700e.add(new ExpiresParam(System.currentTimeMillis() + 3153600000000L));
            z = true;
        } catch (GalaxyFDSClientException e) {
            e.printStackTrace();
            planeMsg.setErrorMessage(e.getMessage());
            z = false;
        }
        planeMsg.setSuccess(z);
        return planeMsg;
    }

    /* renamed from: a */
    public PlaneMsg m11822a(File file) {
        boolean z = false;
        FdsMsg fdsMsg = new FdsMsg();
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            if (this.f8697b == null) {
                m11824a();
            }
            if (this.f8697b != null) {
                PutObjectResult putObject = this.f8697b.putObject(C2353b.f7956n, file, this.f8700e);
                fdsMsg.setBucketName(C2353b.f7956n);
                fdsMsg.setObjectName(putObject.getObjectName());
                fdsMsg.setUrl(putObject.getAbsolutePresignedUri());
                z = true;
            }
        } catch (GalaxyFDSClientException e) {
            e.printStackTrace();
            planeMsg.setErrorMessage(e.getMessage());
        }
        planeMsg.setSuccess(z);
        planeMsg.setData(fdsMsg);
        return planeMsg;
    }

    /* renamed from: a */
    public PlaneMsg m11821a(File file, ProgressListener progressListener) {
        boolean z = false;
        FdsMsg fdsMsg = new FdsMsg();
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            if (this.f8697b == null) {
                m11824a();
            }
            if (this.f8697b != null) {
                PutObjectResult putObject = this.f8697b.putObject(C2353b.f7956n, file, this.f8700e, progressListener);
                fdsMsg.setBucketName(C2353b.f7956n);
                fdsMsg.setObjectName(putObject.getObjectName());
                fdsMsg.setUrl(putObject.getAbsolutePresignedUri());
                z = true;
            }
        } catch (GalaxyFDSClientException e) {
            e.printStackTrace();
            planeMsg.setErrorMessage(e.getMessage());
        }
        planeMsg.setSuccess(z);
        planeMsg.setData(fdsMsg);
        return planeMsg;
    }

    /* renamed from: a */
    public PlaneMsg m11820a(InputStream inputStream, ObjectMetadata objectMetadata) {
        PlaneMsg planeMsg = new PlaneMsg();
        FdsMsg fdsMsg = new FdsMsg();
        boolean z = false;
        try {
            if (this.f8697b == null) {
                m11824a();
            }
            if (this.f8697b != null) {
                PutObjectResult putObject = this.f8697b.putObject(C2353b.f7956n, inputStream, objectMetadata, this.f8700e);
                fdsMsg.setBucketName(C2353b.f7956n);
                fdsMsg.setObjectName(putObject.getObjectName());
                fdsMsg.setUrl(putObject.getAbsolutePresignedUri());
                z = true;
            }
        } catch (GalaxyFDSClientException e) {
            e.printStackTrace();
            planeMsg.setErrorMessage(e.getMessage());
        }
        planeMsg.setSuccess(z);
        planeMsg.setData(fdsMsg);
        return planeMsg;
    }

    /* renamed from: a */
    public PlaneMsg m11819a(InputStream inputStream, ObjectMetadata objectMetadata, ProgressListener progressListener) {
        boolean z;
        PlaneMsg planeMsg = new PlaneMsg();
        FdsMsg fdsMsg = new FdsMsg();
        try {
            if (this.f8697b == null) {
                m11824a();
            }
        } catch (GalaxyFDSClientException e) {
            e.printStackTrace();
            planeMsg.setErrorMessage(e.getMessage());
        }
        if (this.f8697b != null) {
            PutObjectResult putObject = this.f8697b.putObject(C2353b.f7956n, inputStream, objectMetadata, this.f8700e, progressListener);
            fdsMsg.setBucketName(C2353b.f7956n);
            fdsMsg.setObjectName(putObject.getObjectName());
            fdsMsg.setUrl(putObject.getAbsolutePresignedUri());
            z = true;
            planeMsg.setSuccess(z);
            planeMsg.setData(fdsMsg);
            return planeMsg;
        }
        z = false;
        planeMsg.setSuccess(z);
        planeMsg.setData(fdsMsg);
        return planeMsg;
    }

    /* renamed from: a */
    public File m11818a(String str) {
        try {
            if (this.f8697b == null) {
                m11824a();
            }
            this.f8697b.getObject(C2353b.f7956n, str, null);
        } catch (GalaxyFDSClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public void m11823a(AbstractC2514a abstractC2514a) {
        this.f8701f = abstractC2514a;
    }

    /* renamed from: b */
    public PlaneMsg m11817b(File file, ProgressListener progressListener) {
        FdsMsg fdsMsg = new FdsMsg();
        PlaneMsg planeMsg = new PlaneMsg();
        this.f8698c = C2374a.m12422c(this.f8696a, 0);
        this.f8699d = C2374a.m12424b(this.f8696a, 0);
        try {
            C2510d m11869b = new C2510d().m11870b(new OAuthCredential(C2353b.f7955m, "2882303761517328945", "2882303761517328945", this.f8698c, C2353b.f7966x, this.f8699d, C2353b.f7957o)).m11869b(C2353b.f7955m);
            m11869b.m11850g(1048576);
            this.f8700e.add(new ExpiresParam(System.currentTimeMillis() + 3153600000000L));
            C2515h c2515h = new C2515h(m11869b);
            if (this.f8701f != null) {
                this.f8701f.mo11680a(c2515h);
            }
            c2515h.m11812a(C2353b.f7956n, file, this.f8700e, progressListener);
            fdsMsg.setBucketName(C2353b.f7956n);
            C2512f m11807b = c2515h.m11807b();
            if (m11807b != null) {
                fdsMsg.setObjectName(m11807b.m11827c());
                fdsMsg.setUrl(m11807b.m11825d());
                planeMsg.setSuccess(m11807b.m11832a());
            }
        } catch (GalaxyFDSClientException e) {
            e.printStackTrace();
            planeMsg.setErrorMessage(e.getMessage());
            planeMsg.setSuccess(false);
        }
        planeMsg.setData(fdsMsg);
        planeMsg.setFile(file);
        return planeMsg;
    }

    /* renamed from: b */
    public InputStream m11816b(String str) {
        FDSObject fDSObject;
        try {
            if (this.f8697b == null) {
                m11824a();
            }
            fDSObject = this.f8697b.getObject(C2353b.f7956n, str);
        } catch (GalaxyFDSClientException e) {
            e.printStackTrace();
            fDSObject = null;
        }
        if (fDSObject != null) {
            return fDSObject.getObjectContent();
        }
        return null;
    }
}
