package android.support.p001v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.p001v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
/* renamed from: android.support.v4.content.CursorLoader */
/* loaded from: classes.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {
    Cursor mCursor;
    final Loader<Cursor>.ForceLoadContentObserver mObserver = new Loader.ForceLoadContentObserver();
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    Uri mUri;

    public CursorLoader(Context context) {
        super(context);
    }

    public CursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.mUri = uri;
        this.mProjection = strArr;
        this.mSelection = str;
        this.mSelectionArgs = strArr2;
        this.mSortOrder = str2;
    }

    @Override // android.support.p001v4.content.Loader
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor == null) {
                return;
            }
            cursor.close();
            return;
        }
        Cursor cursor2 = this.mCursor;
        this.mCursor = cursor;
        if (isStarted()) {
            super.deliverResult((CursorLoader) cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // android.support.p001v4.content.AsyncTaskLoader, android.support.p001v4.content.Loader
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.mUri);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.mProjection));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.mSelection);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.mSelectionArgs));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.mSortOrder);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.mCursor);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }

    public String[] getProjection() {
        return this.mProjection;
    }

    public String getSelection() {
        return this.mSelection;
    }

    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    public String getSortOrder() {
        return this.mSortOrder;
    }

    public Uri getUri() {
        return this.mUri;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.support.p001v4.content.AsyncTaskLoader
    /* renamed from: loadInBackground */
    public Cursor mo21690loadInBackground() {
        Cursor query = getContext().getContentResolver().query(this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder);
        if (query != null) {
            query.getCount();
            query.registerContentObserver(this.mObserver);
        }
        return query;
    }

    @Override // android.support.p001v4.content.AsyncTaskLoader
    public void onCanceled(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.content.Loader
    public void onReset() {
        super.onReset();
        onStopLoading();
        if (this.mCursor != null && !this.mCursor.isClosed()) {
            this.mCursor.close();
        }
        this.mCursor = null;
    }

    @Override // android.support.p001v4.content.Loader
    protected void onStartLoading() {
        if (this.mCursor != null) {
            deliverResult(this.mCursor);
        }
        if (takeContentChanged() || this.mCursor == null) {
            forceLoad();
        }
    }

    @Override // android.support.p001v4.content.Loader
    protected void onStopLoading() {
        cancelLoad();
    }

    public void setProjection(String[] strArr) {
        this.mProjection = strArr;
    }

    public void setSelection(String str) {
        this.mSelection = str;
    }

    public void setSelectionArgs(String[] strArr) {
        this.mSelectionArgs = strArr;
    }

    public void setSortOrder(String str) {
        this.mSortOrder = str;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }
}
