.class final Lcom/amap/api/services/core/bw;
.super Ljava/lang/Object;

# interfaces
.implements Ljavax/net/ssl/X509TrustManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amap/api/services/core/bq;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public checkClientTrusted([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V
    # inserted by apk-mitm to disable certificate pinning
    .locals 0
    return-void

    # commented out by apk-mitm to disable old method body
    #
    # .locals 0
    #
    # return-void
.end method

.method public checkServerTrusted([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V
    # inserted by apk-mitm to disable certificate pinning
    .locals 0
    return-void

    # commented out by apk-mitm to disable old method body
    #
    # .locals 0
    #
    # return-void
.end method

.method public getAcceptedIssuers()[Ljava/security/cert/X509Certificate;
    # inserted by apk-mitm to disable certificate pinning
    .locals 1
    const/4 v0, 0x0
    new-array v0, v0, [Ljava/security/cert/X509Certificate;
    return-object v0

    # commented out by apk-mitm to disable old method body
    #
    # .locals 1
    #
    # const/4 v0, 0x0
    #
    # return-object v0
.end method
