.class Lcom/amap/api/mapcore/util/ha$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljavax/net/ssl/HostnameVerifier;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amap/api/mapcore/util/ha;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/amap/api/mapcore/util/ha;


# direct methods
.method constructor <init>(Lcom/amap/api/mapcore/util/ha;)V
    .locals 0

    iput-object p1, p0, Lcom/amap/api/mapcore/util/ha$1;->a:Lcom/amap/api/mapcore/util/ha;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public verify(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z
    # inserted by apk-mitm to disable certificate pinning
    .locals 1
    const/4 v0, 0x1
    return v0

    # commented out by apk-mitm to disable old method body
    #
    # .locals 2
    #
    # invoke-static {}, Ljavax/net/ssl/HttpsURLConnection;->getDefaultHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;
    #
    # move-result-object v0
    #
    # const-string v1, "*.amap.com"
    #
    # invoke-interface {v0, v1, p2}, Ljavax/net/ssl/HostnameVerifier;->verify(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z
    #
    # move-result v1
    #
    # if-nez v1, :cond_0
    #
    # const-string v1, "*.apilocate.amap.com"
    #
    # invoke-interface {v0, v1, p2}, Ljavax/net/ssl/HostnameVerifier;->verify(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z
    #
    # move-result v0
    #
    # if-eqz v0, :cond_1
    #
    # :cond_0
    # const/4 v0, 0x1
    #
    # :goto_0
    # return v0
    #
    # :cond_1
    # const/4 v0, 0x0
    #
    # goto :goto_0
.end method
