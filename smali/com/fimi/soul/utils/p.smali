.class public Lcom/fimi/soul/utils/p;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    .locals 34

    if-eqz p2, :cond_0

    move-object/from16 v2, p0

    :goto_0
    const/4 v3, 0x1

    move/from16 v0, p1

    if-ge v0, v3, :cond_1

    const/4 v2, 0x0

    :goto_1
    return-object v2

    :cond_0
    invoke-virtual/range {p0 .. p0}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v2

    const/4 v3, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v3}, Landroid/graphics/Bitmap;->copy(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;

    move-result-object v2

    goto :goto_0

    :cond_1
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v9

    mul-int v3, v5, v9

    new-array v3, v3, [I

    const/4 v4, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move v8, v5

    invoke-virtual/range {v2 .. v9}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    add-int/lit8 v21, v5, -0x1

    add-int/lit8 v22, v9, -0x1

    mul-int v4, v5, v9

    add-int v6, p1, p1

    add-int/lit8 v23, v6, 0x1

    new-array v0, v4, [I

    move-object/from16 v24, v0

    new-array v0, v4, [I

    move-object/from16 v25, v0

    new-array v0, v4, [I

    move-object/from16 v26, v0

    invoke-static {v5, v9}, Ljava/lang/Math;->max(II)I

    move-result v4

    new-array v0, v4, [I

    move-object/from16 v27, v0

    add-int/lit8 v4, v23, 0x1

    shr-int/lit8 v4, v4, 0x1

    mul-int v6, v4, v4

    mul-int/lit16 v4, v6, 0x100

    new-array v0, v4, [I

    move-object/from16 v28, v0

    const/4 v4, 0x0

    :goto_2
    mul-int/lit16 v7, v6, 0x100

    if-ge v4, v7, :cond_2

    div-int v7, v4, v6

    aput v7, v28, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    :cond_2
    const/4 v6, 0x0

    const/4 v4, 0x3

    move/from16 v0, v23

    filled-new-array {v0, v4}, [I

    move-result-object v4

    sget-object v7, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {v7, v4}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [[I

    add-int/lit8 v29, p1, 0x1

    const/4 v7, 0x0

    move/from16 v19, v6

    move v13, v6

    move/from16 v20, v7

    :goto_3
    move/from16 v0, v20

    if-ge v0, v9, :cond_7

    const/4 v6, 0x0

    move/from16 v0, p1

    neg-int v7, v0

    move v8, v6

    move v10, v6

    move v11, v6

    move v12, v6

    move v14, v7

    move v15, v6

    move/from16 v16, v6

    move/from16 v17, v6

    move v7, v6

    :goto_4
    move/from16 v0, p1

    if-gt v14, v0, :cond_4

    const/16 v18, 0x0

    move/from16 v0, v18

    invoke-static {v14, v0}, Ljava/lang/Math;->max(II)I

    move-result v18

    move/from16 v0, v21

    move/from16 v1, v18

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v18

    add-int v18, v18, v13

    aget v18, v3, v18

    add-int v30, v14, p1

    aget-object v30, v4, v30

    const/16 v31, 0x0

    const/high16 v32, 0xff0000

    and-int v32, v32, v18

    shr-int/lit8 v32, v32, 0x10

    aput v32, v30, v31

    const/16 v31, 0x1

    const v32, 0xff00

    and-int v32, v32, v18

    shr-int/lit8 v32, v32, 0x8

    aput v32, v30, v31

    const/16 v31, 0x2

    move/from16 v0, v18

    and-int/lit16 v0, v0, 0xff

    move/from16 v18, v0

    aput v18, v30, v31

    invoke-static {v14}, Ljava/lang/Math;->abs(I)I

    move-result v18

    sub-int v18, v29, v18

    const/16 v31, 0x0

    aget v31, v30, v31

    mul-int v31, v31, v18

    add-int v17, v17, v31

    const/16 v31, 0x1

    aget v31, v30, v31

    mul-int v31, v31, v18

    add-int v16, v16, v31

    const/16 v31, 0x2

    aget v31, v30, v31

    mul-int v18, v18, v31

    add-int v15, v15, v18

    if-lez v14, :cond_3

    const/16 v18, 0x0

    aget v18, v30, v18

    add-int v8, v8, v18

    const/16 v18, 0x1

    aget v18, v30, v18

    add-int v7, v7, v18

    const/16 v18, 0x2

    aget v18, v30, v18

    add-int v6, v6, v18

    :goto_5
    add-int/lit8 v14, v14, 0x1

    goto :goto_4

    :cond_3
    const/16 v18, 0x0

    aget v18, v30, v18

    add-int v12, v12, v18

    const/16 v18, 0x1

    aget v18, v30, v18

    add-int v11, v11, v18

    const/16 v18, 0x2

    aget v18, v30, v18

    add-int v10, v10, v18

    goto :goto_5

    :cond_4
    const/4 v14, 0x0

    move/from16 v18, v17

    move/from16 v17, v16

    move/from16 v16, v15

    move v15, v14

    move v14, v13

    move/from16 v13, p1

    :goto_6
    if-ge v15, v5, :cond_6

    aget v30, v28, v18

    aput v30, v24, v14

    aget v30, v28, v17

    aput v30, v25, v14

    aget v30, v28, v16

    aput v30, v26, v14

    sub-int v18, v18, v12

    sub-int v17, v17, v11

    sub-int v16, v16, v10

    sub-int v30, v13, p1

    add-int v30, v30, v23

    rem-int v30, v30, v23

    aget-object v30, v4, v30

    const/16 v31, 0x0

    aget v31, v30, v31

    sub-int v12, v12, v31

    const/16 v31, 0x1

    aget v31, v30, v31

    sub-int v11, v11, v31

    const/16 v31, 0x2

    aget v31, v30, v31

    sub-int v10, v10, v31

    if-nez v20, :cond_5

    add-int v31, v15, p1

    add-int/lit8 v31, v31, 0x1

    move/from16 v0, v31

    move/from16 v1, v21

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v31

    aput v31, v27, v15

    :cond_5
    aget v31, v27, v15

    add-int v31, v31, v19

    aget v31, v3, v31

    const/16 v32, 0x0

    const/high16 v33, 0xff0000

    and-int v33, v33, v31

    shr-int/lit8 v33, v33, 0x10

    aput v33, v30, v32

    const/16 v32, 0x1

    const v33, 0xff00

    and-int v33, v33, v31

    shr-int/lit8 v33, v33, 0x8

    aput v33, v30, v32

    const/16 v32, 0x2

    move/from16 v0, v31

    and-int/lit16 v0, v0, 0xff

    move/from16 v31, v0

    aput v31, v30, v32

    const/16 v31, 0x0

    aget v31, v30, v31

    add-int v8, v8, v31

    const/16 v31, 0x1

    aget v31, v30, v31

    add-int v7, v7, v31

    const/16 v31, 0x2

    aget v30, v30, v31

    add-int v6, v6, v30

    add-int v18, v18, v8

    add-int v17, v17, v7

    add-int v16, v16, v6

    add-int/lit8 v13, v13, 0x1

    rem-int v13, v13, v23

    rem-int v30, v13, v23

    aget-object v30, v4, v30

    const/16 v31, 0x0

    aget v31, v30, v31

    add-int v12, v12, v31

    const/16 v31, 0x1

    aget v31, v30, v31

    add-int v11, v11, v31

    const/16 v31, 0x2

    aget v31, v30, v31

    add-int v10, v10, v31

    const/16 v31, 0x0

    aget v31, v30, v31

    sub-int v8, v8, v31

    const/16 v31, 0x1

    aget v31, v30, v31

    sub-int v7, v7, v31

    const/16 v31, 0x2

    aget v30, v30, v31

    sub-int v6, v6, v30

    add-int/lit8 v14, v14, 0x1

    add-int/lit8 v15, v15, 0x1

    goto/16 :goto_6

    :cond_6
    add-int v6, v19, v5

    add-int/lit8 v7, v20, 0x1

    move/from16 v19, v6

    move v13, v14

    move/from16 v20, v7

    goto/16 :goto_3

    :cond_7
    const/4 v15, 0x0

    :goto_7
    if-ge v15, v5, :cond_d

    const/4 v7, 0x0

    move/from16 v0, p1

    neg-int v6, v0

    mul-int/2addr v6, v5

    move/from16 v0, p1

    neg-int v8, v0

    move v10, v7

    move v11, v7

    move v12, v7

    move v13, v7

    move/from16 v18, v8

    move v14, v7

    move/from16 v16, v7

    move/from16 v17, v7

    move v8, v7

    :goto_8
    move/from16 v0, v18

    move/from16 v1, p1

    if-gt v0, v1, :cond_a

    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-static {v0, v6}, Ljava/lang/Math;->max(II)I

    move-result v19

    add-int v20, v19, v15

    add-int v19, v18, p1

    aget-object v21, v4, v19

    const/16 v19, 0x0

    aget v30, v24, v20

    aput v30, v21, v19

    const/16 v19, 0x1

    aget v30, v25, v20

    aput v30, v21, v19

    const/16 v19, 0x2

    aget v30, v26, v20

    aput v30, v21, v19

    invoke-static/range {v18 .. v18}, Ljava/lang/Math;->abs(I)I

    move-result v19

    sub-int v30, v29, v19

    aget v19, v24, v20

    mul-int v19, v19, v30

    add-int v19, v19, v17

    aget v17, v25, v20

    mul-int v17, v17, v30

    add-int v17, v17, v16

    aget v16, v26, v20

    mul-int v16, v16, v30

    add-int v16, v16, v14

    if-lez v18, :cond_9

    const/4 v14, 0x0

    aget v14, v21, v14

    add-int/2addr v10, v14

    const/4 v14, 0x1

    aget v14, v21, v14

    add-int/2addr v8, v14

    const/4 v14, 0x2

    aget v14, v21, v14

    add-int/2addr v7, v14

    :goto_9
    move/from16 v0, v18

    move/from16 v1, v22

    if-ge v0, v1, :cond_8

    add-int/2addr v6, v5

    :cond_8
    add-int/lit8 v14, v18, 0x1

    move/from16 v18, v14

    move/from16 v14, v16

    move/from16 v16, v17

    move/from16 v17, v19

    goto :goto_8

    :cond_9
    const/4 v14, 0x0

    aget v14, v21, v14

    add-int/2addr v13, v14

    const/4 v14, 0x1

    aget v14, v21, v14

    add-int/2addr v12, v14

    const/4 v14, 0x2

    aget v14, v21, v14

    add-int/2addr v11, v14

    goto :goto_9

    :cond_a
    const/4 v6, 0x0

    move/from16 v18, v16

    move/from16 v19, v17

    move/from16 v16, v6

    move/from16 v17, v14

    move v14, v15

    move v6, v7

    move v7, v8

    move v8, v10

    move v10, v11

    move v11, v12

    move v12, v13

    move/from16 v13, p1

    :goto_a
    move/from16 v0, v16

    if-ge v0, v9, :cond_c

    const/high16 v20, -0x1000000

    aget v21, v3, v14

    and-int v20, v20, v21

    aget v21, v28, v19

    shl-int/lit8 v21, v21, 0x10

    or-int v20, v20, v21

    aget v21, v28, v18

    shl-int/lit8 v21, v21, 0x8

    or-int v20, v20, v21

    aget v21, v28, v17

    or-int v20, v20, v21

    aput v20, v3, v14

    sub-int v19, v19, v12

    sub-int v18, v18, v11

    sub-int v17, v17, v10

    sub-int v20, v13, p1

    add-int v20, v20, v23

    rem-int v20, v20, v23

    aget-object v20, v4, v20

    const/16 v21, 0x0

    aget v21, v20, v21

    sub-int v12, v12, v21

    const/16 v21, 0x1

    aget v21, v20, v21

    sub-int v11, v11, v21

    const/16 v21, 0x2

    aget v21, v20, v21

    sub-int v10, v10, v21

    if-nez v15, :cond_b

    add-int v21, v16, v29

    invoke-static/range {v21 .. v22}, Ljava/lang/Math;->min(II)I

    move-result v21

    mul-int v21, v21, v5

    aput v21, v27, v16

    :cond_b
    aget v21, v27, v16

    add-int v21, v21, v15

    const/16 v30, 0x0

    aget v31, v24, v21

    aput v31, v20, v30

    const/16 v30, 0x1

    aget v31, v25, v21

    aput v31, v20, v30

    const/16 v30, 0x2

    aget v21, v26, v21

    aput v21, v20, v30

    const/16 v21, 0x0

    aget v21, v20, v21

    add-int v8, v8, v21

    const/16 v21, 0x1

    aget v21, v20, v21

    add-int v7, v7, v21

    const/16 v21, 0x2

    aget v20, v20, v21

    add-int v6, v6, v20

    add-int v19, v19, v8

    add-int v18, v18, v7

    add-int v17, v17, v6

    add-int/lit8 v13, v13, 0x1

    rem-int v13, v13, v23

    aget-object v20, v4, v13

    const/16 v21, 0x0

    aget v21, v20, v21

    add-int v12, v12, v21

    const/16 v21, 0x1

    aget v21, v20, v21

    add-int v11, v11, v21

    const/16 v21, 0x2

    aget v21, v20, v21

    add-int v10, v10, v21

    const/16 v21, 0x0

    aget v21, v20, v21

    sub-int v8, v8, v21

    const/16 v21, 0x1

    aget v21, v20, v21

    sub-int v7, v7, v21

    const/16 v21, 0x2

    aget v20, v20, v21

    sub-int v6, v6, v20

    add-int/2addr v14, v5

    add-int/lit8 v16, v16, 0x1

    goto/16 :goto_a

    :cond_c
    add-int/lit8 v15, v15, 0x1

    goto/16 :goto_7

    :cond_d
    const/4 v4, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move v8, v5

    invoke-virtual/range {v2 .. v9}, Landroid/graphics/Bitmap;->setPixels([IIIIIII)V

    goto/16 :goto_1
.end method
