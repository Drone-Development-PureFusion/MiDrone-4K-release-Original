.class Lcom/fimi/soul/media/gallery/DroneImagePagerActivity$6;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/fimi/soul/biz/n/q$b;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/fimi/soul/media/gallery/DroneImagePagerActivity;->e()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/fimi/soul/media/gallery/DroneImagePagerActivity;


# direct methods
.method constructor <init>(Lcom/fimi/soul/media/gallery/DroneImagePagerActivity;)V
    .locals 0

    iput-object p1, p0, Lcom/fimi/soul/media/gallery/DroneImagePagerActivity$6;->a:Lcom/fimi/soul/media/gallery/DroneImagePagerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 2

    iget-object v0, p0, Lcom/fimi/soul/media/gallery/DroneImagePagerActivity$6;->a:Lcom/fimi/soul/media/gallery/DroneImagePagerActivity;

    invoke-static {v0}, Lcom/fimi/soul/media/gallery/DroneImagePagerActivity;->a(Lcom/fimi/soul/media/gallery/DroneImagePagerActivity;)Lcom/fimi/soul/view/HackyViewPager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/fimi/soul/view/HackyViewPager;->setDrawingCacheEnabled(Z)V

    return-void
.end method
