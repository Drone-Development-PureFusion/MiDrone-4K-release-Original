.class public final Lcom/mob/tools/network/NetworkHelper$SimpleX509TrustManager;
.super Ljava/lang/Object;

# interfaces
.implements Ljavax/net/ssl/X509TrustManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mob/tools/network/NetworkHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "SimpleX509TrustManager"
.end annotation


# instance fields
.field private standardTrustManager:Ljavax/net/ssl/X509TrustManager;


# direct methods
.method public constructor <init>(Ljava/security/KeyStore;)V
    .locals 5

    const/4 v4, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    :try_start_0
    const-string v0, "X509"

    invoke-static {v0}, Ljavax/net/ssl/TrustManagerFactory;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljavax/net/ssl/TrustManagerFactory;->init(Ljava/security/KeyStore;)V

    invoke-virtual {v0}, Ljavax/net/ssl/TrustManagerFactory;->getTrustManagers()[Ljavax/net/ssl/TrustManager;

    move-result-object v0

    if-eqz v0, :cond_0

    array-length v1, v0

    if-nez v1, :cond_1

    :cond_0
    new-instance v0, Ljava/security/NoSuchAlgorithmException;

    const-string v1, "no trust manager found."

    invoke-direct {v0, v1}, Ljava/security/NoSuchAlgorithmException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception v0

    invoke-static {}, Lcom/mob/tools/MobLog;->getInstance()Lcom/mob/tools/log/NLog;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "failed to initialize the standard trust manager: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-array v2, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v0, v2}, Lcom/mob/tools/log/NLog;->d(Ljava/lang/Object;[Ljava/lang/Object;)I

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mob/tools/network/NetworkHelper$SimpleX509TrustManager;->standardTrustManager:Ljavax/net/ssl/X509TrustManager;

    :goto_0
    return-void

    :cond_1
    const/4 v1, 0x0

    :try_start_1
    aget-object v0, v0, v1

    check-cast v0, Ljavax/net/ssl/X509TrustManager;

    iput-object v0, p0, Lcom/mob/tools/network/NetworkHelper$SimpleX509TrustManager;->standardTrustManager:Ljavax/net/ssl/X509TrustManager;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
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
    # .locals 2
    #
    # if-nez p1, :cond_0
    #
    # new-instance v0, Ljava/lang/IllegalArgumentException;
    #
    # const-string v1, "there were no certificates."
    #
    # invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    #
    # throw v0
    #
    # :cond_0
    # array-length v0, p1
    #
    # const/4 v1, 0x1
    #
    # if-ne v0, v1, :cond_1
    #
    # const/4 v0, 0x0
    #
    # aget-object v0, p1, v0
    #
    # invoke-virtual {v0}, Ljava/security/cert/X509Certificate;->checkValidity()V
    #
    # :goto_0
    # return-void
    #
    # :cond_1
    # iget-object v0, p0, Lcom/mob/tools/network/NetworkHelper$SimpleX509TrustManager;->standardTrustManager:Ljavax/net/ssl/X509TrustManager;
    #
    # if-eqz v0, :cond_2
    #
    # iget-object v0, p0, Lcom/mob/tools/network/NetworkHelper$SimpleX509TrustManager;->standardTrustManager:Ljavax/net/ssl/X509TrustManager;
    #
    # invoke-interface {v0, p1, p2}, Ljavax/net/ssl/X509TrustManager;->checkServerTrusted([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V
    #
    # goto :goto_0
    #
    # :cond_2
    # new-instance v0, Ljava/security/cert/CertificateException;
    #
    # const-string v1, "there were one more certificates but no trust manager found."
    #
    # invoke-direct {v0, v1}, Ljava/security/cert/CertificateException;-><init>(Ljava/lang/String;)V
    #
    # throw v0
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
    # new-array v0, v0, [Ljava/security/cert/X509Certificate;
    #
    # return-object v0
.end method
