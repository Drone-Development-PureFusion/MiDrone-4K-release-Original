.class public Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;
.super Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager;


# static fields
.field private static final CREATE_DIR_COUNT:I = 0x5

.field private static final Style_Update_Internal_Time:J = 0x2932e00L

.field private static volatile instance:Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;


# instance fields
.field private mCachePath:Ljava/lang/String;

.field private mContext:Landroid/content/Context;

.field private mMapBaseDataPath:Ljava/lang/String;

.field private mMapExtResPath:Ljava/lang/String;

.field private mMapOfflinePath:Ljava/lang/String;

.field private mMapOnlineTilesPath:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->instance:Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager;-><init>()V

    iput-object p1, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mContext:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->init()V

    return-void
.end method

.method private addUdateRecorder(Ljava/lang/String;)V
    .locals 4

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mContext:Landroid/content/Context;

    const-string v1, "styles_icons_update_recorder"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-interface {v0, p1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    return-void
.end method

.method static copyAssertToTmp(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)V
    .locals 2

    invoke-virtual {p2}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    :try_start_0
    invoke-virtual {p2}, Ljava/io/File;->createNewFile()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0, p1}, Lcom/autonavi/amap/mapcore/ResUtil;->decodeAssetResData(Landroid/content/Context;Ljava/lang/String;)[B

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, p2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v1, v0}, Ljava/io/FileOutputStream;->write([B)V

    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private declared-synchronized doReset()V
    .locals 1

    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    sput-object v0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->instance:Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private getFilePreName(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    const-string v0, "_"

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v2, 0x0

    aget-object v2, v0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x1

    aget-object v2, v0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x2

    aget-object v0, v0, v2

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getStyleIconsData(Ljava/lang/String;ILcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;)[B
    .locals 9

    const/4 v0, 0x0

    invoke-direct {p0, p1}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->getFilePreName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;

    invoke-direct {v3}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;-><init>()V

    invoke-direct {p0, v3, p1}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->setRetFile(Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;Ljava/lang/String;)V

    new-instance v1, Ljava/io/File;

    iget-object v4, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapExtResPath:Ljava/lang/String;

    invoke-direct {v1, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v4

    if-eqz v4, :cond_4

    :try_start_0
    array-length v5, v4

    move v1, v0

    :goto_0
    if-ge v1, v5, :cond_4

    aget-object v6, v4, v1

    invoke-virtual {v6}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {v6}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p3, v0}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->setRetFile(Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;Ljava/lang/String;)V

    iget v0, v3, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;->serverVersion:I

    iget v7, p3, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;->serverVersion:I

    if-ge v0, v7, :cond_3

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/autonavi/amap/mapcore/FileUtil;->readFileContents(Ljava/lang/String;)[B

    move-result-object v0

    if-eqz v0, :cond_2

    array-length v7, v0

    if-lez v7, :cond_2

    const/4 v7, 0x1

    if-ne p2, v7, :cond_0

    const/4 v7, 0x0

    invoke-static {v0, v7}, Lcom/autonavi/amap/mapcore/Convert;->getInt([BI)I

    move-result v7

    array-length v8, v0

    add-int/lit8 v7, v7, 0x4

    if-ne v8, v7, :cond_1

    :cond_0
    :goto_1
    return-object v0

    :cond_1
    invoke-static {v6}, Lcom/autonavi/amap/mapcore/FileUtil;->deleteFile(Ljava/io/File;)Z

    :cond_2
    :goto_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_3
    invoke-static {v6}, Lcom/autonavi/amap/mapcore/FileUtil;->deleteFile(Ljava/io/File;)Z
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    :catch_0
    move-exception v0

    :cond_4
    invoke-direct {p0, p3, p1}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->setRetFile(Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mContext:Landroid/content/Context;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "map_assets/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/autonavi/amap/mapcore/ResUtil;->decodeAssetResData(Landroid/content/Context;Ljava/lang/String;)[B

    move-result-object v0

    goto :goto_1
.end method

.method private initRelease()V
    .locals 6

    const/4 v5, 0x5

    const/4 v1, 0x0

    new-instance v0, Ljava/io/File;

    iget-object v2, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/autonavi/amap/mapcore/FileUtil;->getMapBaseStorage(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {v0}, Ljava/io/File;->mkdir()Z

    :cond_0
    new-instance v2, Ljava/io/File;

    const-string v3, "data"

    invoke-direct {v2, v0, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {v2}, Ljava/io/File;->mkdir()Z

    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "/"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapBaseDataPath:Ljava/lang/String;

    new-instance v0, Ljava/io/File;

    const-string v3, "vmap"

    invoke-direct {v0, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v3

    if-nez v3, :cond_2

    invoke-virtual {v0}, Ljava/io/File;->mkdir()Z

    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "/"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapOfflinePath:Ljava/lang/String;

    new-instance v3, Ljava/io/File;

    const-string v0, "cache"

    invoke-direct {v3, v2, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    move v0, v1

    :goto_0
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_3

    add-int/lit8 v2, v0, 0x1

    if-ge v0, v5, :cond_3

    invoke-virtual {v3}, Ljava/io/File;->mkdir()Z

    move v0, v2

    goto :goto_0

    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mCachePath:Ljava/lang/String;

    new-instance v4, Ljava/io/File;

    const-string v0, "vmap4tiles"

    invoke-direct {v4, v3, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    move v0, v1

    :goto_1
    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_4

    add-int/lit8 v2, v0, 0x1

    if-ge v0, v5, :cond_4

    invoke-virtual {v4}, Ljava/io/File;->mkdir()Z

    move v0, v2

    goto :goto_1

    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapOnlineTilesPath:Ljava/lang/String;

    new-instance v2, Ljava/io/File;

    const-string v0, "vmap4res"

    invoke-direct {v2, v3, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    :goto_2
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_5

    add-int/lit8 v0, v1, 0x1

    if-ge v1, v5, :cond_5

    invoke-virtual {v2}, Ljava/io/File;->mkdir()Z

    move v1, v0

    goto :goto_2

    :cond_5
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapExtResPath:Ljava/lang/String;

    return-void
.end method

.method public static instance(Landroid/content/Context;)Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;
    .locals 1

    sget-object v0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->instance:Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;

    if-nez v0, :cond_0

    new-instance v0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;

    invoke-direct {v0, p0}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->instance:Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;

    :cond_0
    sget-object v0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->instance:Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;

    return-object v0
.end method

.method private setRetFile(Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;Ljava/lang/String;)V
    .locals 3

    if-nez p1, :cond_0

    :goto_0
    return-void

    :cond_0
    iput-object p2, p1, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;->fullName:Ljava/lang/String;

    const-string v0, "_|\\."

    invoke-virtual {p2, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v2, 0x0

    aget-object v2, v0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x1

    aget-object v2, v0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p1, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;->name:Ljava/lang/String;

    const/4 v1, 0x2

    aget-object v1, v0, v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p1, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;->clientVersion:I

    const/4 v1, 0x3

    aget-object v0, v0, v1

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p1, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;->serverVersion:I

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized canUpate(Ljava/lang/String;)Z
    .locals 6

    const/4 v0, 0x0

    monitor-enter p0

    const/4 v1, 0x1

    :try_start_0
    iget-object v2, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mContext:Landroid/content/Context;

    const-string v3, "styles_icons_update_recorder"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    const-wide/16 v4, -0x1

    invoke-interface {v2, p1, v4, v5}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-lez v4, :cond_1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v2, v4, v2

    const-wide/32 v4, 0x2932e00

    cmp-long v2, v2, v4

    if-gez v2, :cond_1

    :goto_0
    if-eqz v0, :cond_0

    invoke-direct {p0, p1}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->addUdateRecorder(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method public checkDir()V
    .locals 0

    invoke-virtual {p0}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->init()V

    return-void
.end method

.method public clearOnlineMapTilsCache()V
    .locals 2

    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapOnlineTilesPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {v0}, Lcom/autonavi/amap/mapcore/FileUtil;->deleteFile(Ljava/io/File;)Z

    invoke-virtual {p0}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->init()V

    :cond_0
    return-void
.end method

.method public getBaseMapPath()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapBaseDataPath:Ljava/lang/String;

    return-object v0
.end method

.method public getIconsData(Ljava/lang/String;Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;)[B
    .locals 1

    const/4 v0, 0x2

    :try_start_0
    invoke-direct {p0, p1, v0, p2}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->getStyleIconsData(Ljava/lang/String;ILcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;)[B
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getMapCachePath()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mCachePath:Ljava/lang/String;

    return-object v0
.end method

.method public getMapExtResPath()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapExtResPath:Ljava/lang/String;

    return-object v0
.end method

.method public getMapOfflineDataPath()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapOfflinePath:Ljava/lang/String;

    return-object v0
.end method

.method public getMapOnlineDataPath()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapOnlineTilesPath:Ljava/lang/String;

    return-object v0
.end method

.method public getOtherResData(Ljava/lang/String;)[B
    .locals 3

    iget-object v0, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mContext:Landroid/content/Context;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "map_assets/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/autonavi/amap/mapcore/ResUtil;->decodeAssetResData(Landroid/content/Context;Ljava/lang/String;)[B

    move-result-object v0

    return-object v0
.end method

.method public getStyleData(Ljava/lang/String;Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;)[B
    .locals 1

    const/4 v0, 0x1

    :try_start_0
    invoke-direct {p0, p1, v0, p2}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->getStyleIconsData(Ljava/lang/String;ILcom/autonavi/amap/mapcore/MapTilsCacheAndResManager$RetStyleIconsFile;)[B
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public init()V
    .locals 1

    :try_start_0
    invoke-direct {p0}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->initRelease()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method initDebug()V
    .locals 0

    return-void
.end method

.method public reset()V
    .locals 0

    invoke-direct {p0}, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->doReset()V

    return-void
.end method

.method public saveFile(Ljava/lang/String;II[B)V
    .locals 5

    if-eqz p4, :cond_0

    array-length v0, p4

    if-gtz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapExtResPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v1

    if-eqz v1, :cond_2

    array-length v2, v1

    const/4 v0, 0x0

    :goto_1
    if-ge v0, v2, :cond_2

    aget-object v3, v1, v0

    invoke-virtual {v3}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".data"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/autonavi/amap/mapcore/MapTilsCacheAndResManagerImpl;->mMapExtResPath:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p4}, Lcom/autonavi/amap/mapcore/FileUtil;->writeDatasToFile(Ljava/lang/String;[B)V

    goto :goto_0

    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method
