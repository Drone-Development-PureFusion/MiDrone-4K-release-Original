package com.fimi.soul.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import java.util.List;
/* renamed from: com.fimi.soul.view.h */
/* loaded from: classes.dex */
public class C3820h extends Drawable {

    /* renamed from: a */
    private final List<Drawable> f15988a;

    public C3820h(List<Drawable> list) {
        this.f15988a = list;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f15988a.size() == 1) {
            this.f15988a.get(0).draw(canvas);
            return;
        }
        int width = getBounds().width();
        int height = getBounds().height();
        canvas.save();
        canvas.clipRect(0, 0, width, height);
        if (this.f15988a.size() == 2 || this.f15988a.size() == 3) {
            canvas.save();
            canvas.clipRect(0, 0, width / 2, height);
            canvas.translate((-width) / 4, 0.0f);
            this.f15988a.get(0).draw(canvas);
            canvas.restore();
        }
        if (this.f15988a.size() == 2) {
            canvas.save();
            canvas.clipRect(width / 2, 0, width, height);
            canvas.translate(width / 4, 0.0f);
            this.f15988a.get(1).draw(canvas);
            canvas.restore();
        } else {
            canvas.save();
            canvas.scale(0.5f, 0.5f);
            canvas.translate(width, 0.0f);
            this.f15988a.get(1).draw(canvas);
            canvas.translate(0.0f, height);
            this.f15988a.get(2).draw(canvas);
            canvas.restore();
        }
        if (this.f15988a.size() >= 4) {
            canvas.save();
            canvas.scale(0.5f, 0.5f);
            this.f15988a.get(0).draw(canvas);
            canvas.translate(0.0f, height);
            this.f15988a.get(3).draw(canvas);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
