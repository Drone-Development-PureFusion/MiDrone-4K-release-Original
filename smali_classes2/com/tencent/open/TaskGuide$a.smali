.class abstract Lcom/tencent/open/TaskGuide$a;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/tencent/tauth/IRequestListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/open/TaskGuide;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "a"
.end annotation


# instance fields
.field final synthetic a:Lcom/tencent/open/TaskGuide;


# direct methods
.method private constructor <init>(Lcom/tencent/open/TaskGuide;)V
    .locals 0

    iput-object p1, p0, Lcom/tencent/open/TaskGuide$a;->a:Lcom/tencent/open/TaskGuide;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/tencent/open/TaskGuide;Lcom/tencent/open/TaskGuide$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/tencent/open/TaskGuide$a;-><init>(Lcom/tencent/open/TaskGuide;)V

    return-void
.end method


# virtual methods
.method protected abstract a(Ljava/lang/Exception;)V
.end method

.method public onConnectTimeoutException(Lorg/apache/http/conn/ConnectTimeoutException;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/tencent/open/TaskGuide$a;->a(Ljava/lang/Exception;)V

    return-void
.end method

.method public onHttpStatusException(Lcom/tencent/open/utils/HttpUtils$HttpStatusException;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/tencent/open/TaskGuide$a;->a(Ljava/lang/Exception;)V

    return-void
.end method

.method public onIOException(Ljava/io/IOException;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/tencent/open/TaskGuide$a;->a(Ljava/lang/Exception;)V

    return-void
.end method

.method public onJSONException(Lorg/json/JSONException;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/tencent/open/TaskGuide$a;->a(Ljava/lang/Exception;)V

    return-void
.end method

.method public onMalformedURLException(Ljava/net/MalformedURLException;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/tencent/open/TaskGuide$a;->a(Ljava/lang/Exception;)V

    return-void
.end method

.method public onNetworkUnavailableException(Lcom/tencent/open/utils/HttpUtils$NetworkUnavailableException;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/tencent/open/TaskGuide$a;->a(Ljava/lang/Exception;)V

    return-void
.end method

.method public onSocketTimeoutException(Ljava/net/SocketTimeoutException;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/tencent/open/TaskGuide$a;->a(Ljava/lang/Exception;)V

    return-void
.end method

.method public onUnknowException(Ljava/lang/Exception;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/tencent/open/TaskGuide$a;->a(Ljava/lang/Exception;)V

    return-void
.end method
