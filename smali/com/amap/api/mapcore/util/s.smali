.class public Lcom/amap/api/mapcore/util/s;
.super Ljava/lang/Object;


# instance fields
.field private a:Lcom/amap/api/maps/model/BitmapDescriptor;

.field private b:I


# direct methods
.method public constructor <init>(Lcom/amap/api/maps/model/BitmapDescriptor;I)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/amap/api/mapcore/util/s;->a:Lcom/amap/api/maps/model/BitmapDescriptor;

    iput p2, p0, Lcom/amap/api/mapcore/util/s;->b:I

    return-void
.end method


# virtual methods
.method public a()Lcom/amap/api/maps/model/BitmapDescriptor;
    .locals 1

    iget-object v0, p0, Lcom/amap/api/mapcore/util/s;->a:Lcom/amap/api/maps/model/BitmapDescriptor;

    return-object v0
.end method

.method public b()I
    .locals 1

    iget v0, p0, Lcom/amap/api/mapcore/util/s;->b:I

    return v0
.end method
