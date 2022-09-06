package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
/* loaded from: classes.dex */
public class DataSources {
    private DataSources() {
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(final Throwable th) {
        return new Supplier<DataSource<T>>() { // from class: com.facebook.datasource.DataSources.1
            @Override // com.facebook.common.internal.Supplier
            /* renamed from: get */
            public DataSource<T> mo21803get() {
                return DataSources.immediateFailedDataSource(th);
            }
        };
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        SettableDataSource create = SettableDataSource.create();
        create.setFailure(th);
        return create;
    }
}
