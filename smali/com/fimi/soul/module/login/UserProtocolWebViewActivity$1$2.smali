.class Lcom/fimi/soul/module/login/UserProtocolWebViewActivity$1$2;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/fimi/soul/module/login/UserProtocolWebViewActivity$1;->onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/webkit/SslErrorHandler;

.field final synthetic b:Lcom/fimi/soul/module/login/UserProtocolWebViewActivity$1;


# direct methods
.method constructor <init>(Lcom/fimi/soul/module/login/UserProtocolWebViewActivity$1;Landroid/webkit/SslErrorHandler;)V
    .locals 0

    iput-object p1, p0, Lcom/fimi/soul/module/login/UserProtocolWebViewActivity$1$2;->b:Lcom/fimi/soul/module/login/UserProtocolWebViewActivity$1;

    iput-object p2, p0, Lcom/fimi/soul/module/login/UserProtocolWebViewActivity$1$2;->a:Landroid/webkit/SslErrorHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    iget-object v0, p0, Lcom/fimi/soul/module/login/UserProtocolWebViewActivity$1$2;->a:Landroid/webkit/SslErrorHandler;

    invoke-virtual {v0}, Landroid/webkit/SslErrorHandler;->cancel()V

    return-void
.end method
