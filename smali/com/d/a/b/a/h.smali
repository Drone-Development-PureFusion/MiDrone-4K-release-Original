.class public final enum Lcom/d/a/b/a/h;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/d/a/b/a/h$1;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/d/a/b/a/h;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/d/a/b/a/h;

.field public static final enum b:Lcom/d/a/b/a/h;

.field private static final synthetic c:[Lcom/d/a/b/a/h;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/d/a/b/a/h;

    const-string v1, "FIT_INSIDE"

    invoke-direct {v0, v1, v2}, Lcom/d/a/b/a/h;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/d/a/b/a/h;->a:Lcom/d/a/b/a/h;

    new-instance v0, Lcom/d/a/b/a/h;

    const-string v1, "CROP"

    invoke-direct {v0, v1, v3}, Lcom/d/a/b/a/h;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/d/a/b/a/h;->b:Lcom/d/a/b/a/h;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/d/a/b/a/h;

    sget-object v1, Lcom/d/a/b/a/h;->a:Lcom/d/a/b/a/h;

    aput-object v1, v0, v2

    sget-object v1, Lcom/d/a/b/a/h;->b:Lcom/d/a/b/a/h;

    aput-object v1, v0, v3

    sput-object v0, Lcom/d/a/b/a/h;->c:[Lcom/d/a/b/a/h;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static a(Landroid/widget/ImageView;)Lcom/d/a/b/a/h;
    .locals 2

    sget-object v0, Lcom/d/a/b/a/h$1;->a:[I

    invoke-virtual {p0}, Landroid/widget/ImageView;->getScaleType()Landroid/widget/ImageView$ScaleType;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ImageView$ScaleType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    sget-object v0, Lcom/d/a/b/a/h;->b:Lcom/d/a/b/a/h;

    :goto_0
    return-object v0

    :pswitch_0
    sget-object v0, Lcom/d/a/b/a/h;->a:Lcom/d/a/b/a/h;

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/d/a/b/a/h;
    .locals 1

    const-class v0, Lcom/d/a/b/a/h;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/d/a/b/a/h;

    return-object v0
.end method

.method public static values()[Lcom/d/a/b/a/h;
    .locals 1

    sget-object v0, Lcom/d/a/b/a/h;->c:[Lcom/d/a/b/a/h;

    invoke-virtual {v0}, [Lcom/d/a/b/a/h;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/d/a/b/a/h;

    return-object v0
.end method
