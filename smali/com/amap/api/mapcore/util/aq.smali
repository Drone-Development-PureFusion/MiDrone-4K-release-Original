.class public Lcom/amap/api/mapcore/util/aq;
.super Lcom/amap/api/maps/model/IndoorBuildingInfo;


# instance fields
.field public a:Ljava/lang/String;

.field public b:Ljava/lang/String;

.field public c:I

.field public d:[Ljava/lang/String;

.field public e:I

.field public f:[I

.field public g:Lcom/autonavi/amap/mapcore/IPoint;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/amap/api/maps/model/IndoorBuildingInfo;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amap/api/mapcore/util/aq;->g:Lcom/autonavi/amap/mapcore/IPoint;

    return-void
.end method
