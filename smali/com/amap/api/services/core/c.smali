.class public Lcom/amap/api/services/core/c;
.super Ljava/lang/Object;


# static fields
.field public static final a:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "com.amap.api.services"

    aput-object v2, v0, v1

    sput-object v0, Lcom/amap/api/services/core/c;->a:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Z)Lcom/amap/api/services/core/ad;
    .locals 6

    const-string v2, "getSDKInfo"

    const/4 v0, 0x0

    :try_start_0
    new-instance v1, Lcom/amap/api/services/core/ad$a;

    const-string v3, "sea"

    const-string v4, "2.5.0"

    const-string v5, "AMAP SDK Android Search 2.5.0"

    invoke-direct {v1, v3, v4, v5}, Lcom/amap/api/services/core/ad$a;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v3, Lcom/amap/api/services/core/c;->a:[Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/amap/api/services/core/ad$a;->a([Ljava/lang/String;)Lcom/amap/api/services/core/ad$a;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/amap/api/services/core/ad$a;->a(Z)Lcom/amap/api/services/core/ad$a;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amap/api/services/core/ad$a;->a()Lcom/amap/api/services/core/ad;
    :try_end_0
    .catch Lcom/amap/api/services/core/v; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    const-string v3, "ConfigableConst"

    invoke-static {v1, v3, v2}, Lcom/amap/api/services/core/d;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static a()Ljava/lang/String;
    .locals 2

    invoke-static {}, Lcom/amap/api/services/core/ServiceSettings;->getInstance()Lcom/amap/api/services/core/ServiceSettings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amap/api/services/core/ServiceSettings;->getProtocol()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    const-string v0, "http://restapi.amap.com/v3"

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "https://restapi.amap.com/v3"

    goto :goto_0
.end method

.method public static b()Ljava/lang/String;
    .locals 1

    invoke-static {}, Lcom/amap/api/services/core/ServiceSettings;->getInstance()Lcom/amap/api/services/core/ServiceSettings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amap/api/services/core/ServiceSettings;->getLanguage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
