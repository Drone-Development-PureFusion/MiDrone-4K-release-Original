.class public Lcom/b/a$c;
.super Landroid/os/Handler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/b/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "c"
.end annotation


# instance fields
.field a:Lcom/b/a;


# direct methods
.method public constructor <init>(Lcom/b/a;)V
    .locals 1

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iput-object p1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    return-void
.end method

.method public constructor <init>(Lcom/b/a;Landroid/os/Looper;)V
    .locals 1

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iput-object p1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 8

    const/16 v6, 0xa

    const/4 v5, 0x1

    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    const/4 v1, 0x0

    iget v0, p1, Landroid/os/Message;->what:I

    sparse-switch v0, :sswitch_data_0

    :cond_0
    :goto_0
    :sswitch_0
    return-void

    :sswitch_1
    :try_start_0
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_10

    const-class v2, Lcom/autonavi/aps/amapapi/model/AmapLoc;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    const-string v2, "location"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/autonavi/aps/amapapi/model/AmapLoc;

    invoke-static {v0}, Lcom/b/cx;->a(Lcom/autonavi/aps/amapapi/model/AmapLoc;)Lcom/amap/api/location/AMapLocation;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v2

    if-nez v2, :cond_f

    :try_start_1
    new-instance v1, Lcom/amap/api/location/AMapLocation;

    const-string v0, ""

    invoke-direct {v1, v0}, Lcom/amap/api/location/AMapLocation;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_a

    const/16 v0, 0x8

    :try_start_2
    invoke-virtual {v1, v0}, Lcom/amap/api/location/AMapLocation;->setErrorCode(I)V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_3

    move-object v0, v1

    :goto_1
    :try_start_3
    const-string v1, "lbs"

    invoke-virtual {v0, v1}, Lcom/amap/api/location/AMapLocation;->setProvider(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_b

    :goto_2
    move-object v1, v0

    :goto_3
    :try_start_4
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v0, v0, Lcom/b/a;->e:Lcom/b/dg;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v0, v0, Lcom/b/a;->e:Lcom/b/dg;

    invoke-virtual {v0, v1}, Lcom/b/dg;->a(Lcom/amap/api/location/AMapLocation;)V
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_8

    :cond_1
    :goto_4
    if-eqz v1, :cond_6

    :try_start_5
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v0}, Lcom/b/a;->g(Lcom/b/a;)Z

    move-result v0

    if-nez v0, :cond_6

    invoke-virtual {v1}, Lcom/amap/api/location/AMapLocation;->getErrorCode()I
    :try_end_5
    .catch Ljava/lang/Throwable; {:try_start_5 .. :try_end_5} :catch_1

    move-result v0

    if-nez v0, :cond_3

    :try_start_6
    invoke-virtual {v1}, Lcom/amap/api/location/AMapLocation;->getTime()J

    move-result-wide v2

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v4, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v4, v4, Lcom/b/a;->q:Lcom/amap/api/location/AMapLocation;

    invoke-static {v0, v4, v1}, Lcom/b/a;->a(Lcom/b/a;Lcom/amap/api/location/AMapLocation;Lcom/amap/api/location/AMapLocation;)Lcom/amap/api/location/AMapLocation;

    move-result-object v1

    invoke-virtual {v1, v2, v3}, Lcom/amap/api/location/AMapLocation;->setTime(J)V

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v0}, Lcom/b/a;->h(Lcom/b/a;)I

    move-result v0

    if-nez v0, :cond_d

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v2}, Lcom/b/a;->h(Lcom/b/a;)I

    move-result v2

    invoke-static {v0, v1, v2}, Lcom/b/a;->a(Lcom/b/a;Lcom/amap/api/location/AMapLocation;I)Lcom/b/a$a;

    move-result-object v0

    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v2}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-gt v2, v5, :cond_c

    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v2}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ne v2, v5, :cond_b

    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v2}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3, v0}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    :cond_2
    :goto_5
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v0}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lt v0, v6, :cond_3

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v0}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_6
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_e

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/b/a$a;

    invoke-virtual {v0}, Lcom/b/a$a;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v0, "#"

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_0

    goto :goto_6

    :catch_0
    move-exception v0

    :try_start_7
    const-string v2, "AMapLocationManager"

    const-string v3, "handleMessage"

    invoke-static {v0, v2, v3}, Lcom/b/cx;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    :cond_3
    :goto_7
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {}, Lcom/b/bs;->b()J

    move-result-wide v2

    iput-wide v2, v0, Lcom/b/a;->r:J

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iput-object v1, v0, Lcom/b/a;->q:Lcom/amap/api/location/AMapLocation;

    const-string v0, "gps"

    invoke-virtual {v1}, Lcom/amap/api/location/AMapLocation;->getProvider()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v0}, Lcom/b/a;->c(Lcom/b/a;)Z

    move-result v0

    if-eqz v0, :cond_6

    :cond_4
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v0, v0, Lcom/b/a;->g:Lcom/b/di;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v0, v0, Lcom/b/a;->g:Lcom/b/di;

    invoke-virtual {v0, v1}, Lcom/b/di;->a(Lcom/amap/api/location/AMapLocation;)V

    :cond_5
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v0, v0, Lcom/b/a;->d:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_8
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amap/api/location/AMapLocationListener;

    invoke-interface {v0, v1}, Lcom/amap/api/location/AMapLocationListener;->onLocationChanged(Lcom/amap/api/location/AMapLocation;)V
    :try_end_7
    .catch Ljava/lang/Throwable; {:try_start_7 .. :try_end_7} :catch_1

    goto :goto_8

    :catch_1
    move-exception v0

    const-string v1, "AMapLocationManager"

    const-string v2, "handleMessage part7"

    invoke-static {v0, v1, v2}, Lcom/b/cx;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    :cond_6
    :try_start_8
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v0, v0, Lcom/b/a;->a:Lcom/amap/api/location/AMapLocationClientOption;

    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocationClientOption;->isOnceLocation()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-virtual {v0}, Lcom/b/a;->stopLocation()V
    :try_end_8
    .catch Ljava/lang/Throwable; {:try_start_8 .. :try_end_8} :catch_2

    goto/16 :goto_0

    :catch_2
    move-exception v0

    const-string v1, "AMapLocationManager"

    const-string v2, "handleMessage part8"

    invoke-static {v0, v1, v2}, Lcom/b/cx;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :catch_3
    move-exception v0

    :goto_9
    const-string v2, "AMapLocationManager"

    const-string v3, "handleMessage LBS_LOCATIONSUCCESS"

    invoke-static {v0, v2, v3}, Lcom/b/cx;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_3

    :sswitch_2
    :try_start_9
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/amap/api/location/AMapLocation;
    :try_end_9
    .catch Ljava/lang/Throwable; {:try_start_9 .. :try_end_9} :catch_4

    :try_start_a
    invoke-virtual {v0}, Lcom/amap/api/location/AMapLocation;->getErrorCode()I

    move-result v1

    if-nez v1, :cond_7

    iget-object v1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {}, Lcom/b/bs;->b()J

    move-result-wide v2

    iput-wide v2, v1, Lcom/b/a;->o:J

    iget-object v1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    const/4 v2, 0x1

    iput-boolean v2, v1, Lcom/b/a;->n:Z

    :cond_7
    sget-boolean v1, Lcom/b/a;->t:Z

    if-nez v1, :cond_8

    iget-object v1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v1, v1, Lcom/b/a;->h:Landroid/os/Messenger;

    if-eqz v1, :cond_8

    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v1

    const/4 v2, 0x0

    iput v2, v1, Landroid/os/Message;->what:I

    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v2, v2, Lcom/b/a;->i:Landroid/os/Messenger;

    iput-object v2, v1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v2, v2, Lcom/b/a;->h:Landroid/os/Messenger;

    invoke-virtual {v2, v1}, Landroid/os/Messenger;->send(Landroid/os/Message;)V

    const/4 v1, 0x1

    sput-boolean v1, Lcom/b/a;->t:Z
    :try_end_a
    .catch Ljava/lang/Throwable; {:try_start_a .. :try_end_a} :catch_9

    :cond_8
    move-object v1, v0

    goto/16 :goto_3

    :catch_4
    move-exception v0

    :goto_a
    const-string v2, "AMapLocationManager"

    const-string v3, "handleMessage GPS_LOCATIONSUCCESS"

    invoke-static {v0, v2, v3}, Lcom/b/cx;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_3

    :sswitch_3
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {}, Lcom/b/bs;->b()J

    move-result-wide v2

    iput-wide v2, v0, Lcom/b/a;->o:J

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iput-boolean v5, v0, Lcom/b/a;->n:Z

    goto/16 :goto_0

    :sswitch_4
    :try_start_b
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v0}, Lcom/b/a;->f(Lcom/b/a;)V
    :try_end_b
    .catch Ljava/lang/Throwable; {:try_start_b .. :try_end_b} :catch_5

    goto/16 :goto_0

    :catch_5
    move-exception v0

    const-string v1, "AMapLocationManager"

    const-string v2, "handleMessage FASTSKY"

    invoke-static {v0, v1, v2}, Lcom/b/cx;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :sswitch_5
    :try_start_c
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    const/4 v1, 0x2

    iput v1, v0, Landroid/os/Message;->what:I

    iget-object v1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v1, v1, Lcom/b/a;->h:Landroid/os/Messenger;

    if-eqz v1, :cond_9

    iget-object v1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    const/4 v2, 0x0

    iput v2, v1, Lcom/b/a;->m:I

    iget-object v1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v1, v1, Lcom/b/a;->h:Landroid/os/Messenger;

    invoke-virtual {v1, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_c
    .catch Ljava/lang/Throwable; {:try_start_c .. :try_end_c} :catch_6

    goto/16 :goto_0

    :catch_6
    move-exception v0

    const-string v1, "AMapLocationManager"

    const-string v2, "handleMessage START_SOCKET"

    invoke-static {v0, v1, v2}, Lcom/b/cx;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_9
    :try_start_d
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget v1, v0, Lcom/b/a;->m:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/b/a;->m:I

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget v0, v0, Lcom/b/a;->m:I

    if-ge v0, v6, :cond_0

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v0, v0, Lcom/b/a;->b:Lcom/b/a$c;

    const/16 v1, 0x65

    const-wide/16 v2, 0x32

    invoke-virtual {v0, v1, v2, v3}, Lcom/b/a$c;->sendEmptyMessageDelayed(IJ)Z
    :try_end_d
    .catch Ljava/lang/Throwable; {:try_start_d .. :try_end_d} :catch_6

    goto/16 :goto_0

    :sswitch_6
    :try_start_e
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    const/4 v1, 0x3

    iput v1, v0, Landroid/os/Message;->what:I

    iget-object v1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v1, v1, Lcom/b/a;->h:Landroid/os/Messenger;

    if-eqz v1, :cond_a

    iget-object v1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    const/4 v2, 0x0

    iput v2, v1, Lcom/b/a;->m:I

    iget-object v1, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v1, v1, Lcom/b/a;->h:Landroid/os/Messenger;

    invoke-virtual {v1, v0}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_e
    .catch Ljava/lang/Throwable; {:try_start_e .. :try_end_e} :catch_7

    goto/16 :goto_0

    :catch_7
    move-exception v0

    const-string v1, "AMapLocationManager"

    const-string v2, "handleMessage STOP_SOCKET"

    invoke-static {v0, v1, v2}, Lcom/b/cx;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_a
    :try_start_f
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget v1, v0, Lcom/b/a;->m:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/b/a;->m:I

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget v0, v0, Lcom/b/a;->m:I

    if-ge v0, v6, :cond_0

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v0, v0, Lcom/b/a;->b:Lcom/b/a$c;

    const/16 v1, 0x66

    const-wide/16 v2, 0x32

    invoke-virtual {v0, v1, v2, v3}, Lcom/b/a$c;->sendEmptyMessageDelayed(IJ)Z
    :try_end_f
    .catch Ljava/lang/Throwable; {:try_start_f .. :try_end_f} :catch_7

    goto/16 :goto_0

    :catch_8
    move-exception v0

    const-string v2, "AMapLocationManager"

    const-string v3, "handleMessage part6"

    invoke-static {v0, v2, v3}, Lcom/b/cx;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_4

    :cond_b
    :try_start_10
    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v2}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_5

    :cond_c
    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v2}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_5

    :cond_d
    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v2}, Lcom/b/a;->j(Lcom/b/a;)Lcom/amap/api/location/AMapLocation;

    move-result-object v2

    iget-object v3, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v3}, Lcom/b/a;->h(Lcom/b/a;)I

    move-result v3

    invoke-static {v0, v2, v3}, Lcom/b/a;->a(Lcom/b/a;Lcom/amap/api/location/AMapLocation;I)Lcom/b/a$a;

    move-result-object v0

    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v2}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v2}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/16 v3, 0x9

    if-gt v2, v3, :cond_2

    iget-object v2, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v2}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_5

    :cond_e
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/b/cx;->b(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/b/a$c;->a:Lcom/b/a;

    invoke-static {v0}, Lcom/b/a;->i(Lcom/b/a;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V
    :try_end_10
    .catch Ljava/lang/Throwable; {:try_start_10 .. :try_end_10} :catch_0

    goto/16 :goto_7

    :catch_9
    move-exception v1

    move-object v7, v1

    move-object v1, v0

    move-object v0, v7

    goto/16 :goto_a

    :catch_a
    move-exception v0

    move-object v1, v2

    goto/16 :goto_9

    :catch_b
    move-exception v1

    move-object v7, v1

    move-object v1, v0

    move-object v0, v7

    goto/16 :goto_9

    :cond_f
    move-object v0, v2

    goto/16 :goto_1

    :cond_10
    move-object v0, v1

    goto/16 :goto_2

    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x2 -> :sswitch_2
        0x5 -> :sswitch_3
        0x6 -> :sswitch_0
        0x64 -> :sswitch_4
        0x65 -> :sswitch_5
        0x66 -> :sswitch_6
    .end sparse-switch
.end method
