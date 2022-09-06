package com.tencent.p227mm.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* renamed from: com.tencent.mm.sdk.MMSharedPreferences */
/* loaded from: classes.dex */
public class MMSharedPreferences implements SharedPreferences {

    /* renamed from: i */
    private final ContentResolver f17750i;
    private final String[] columns = {"_id", "key", "type", "value"};

    /* renamed from: j */
    private final HashMap<String, Object> f17751j = new HashMap<>();

    /* renamed from: k */
    private REditor f17752k = null;

    /* renamed from: com.tencent.mm.sdk.MMSharedPreferences$REditor */
    /* loaded from: classes.dex */
    private static class REditor implements SharedPreferences.Editor {

        /* renamed from: i */
        private ContentResolver f17753i;

        /* renamed from: l */
        private Map<String, Object> f17754l = new HashMap();

        /* renamed from: m */
        private Set<String> f17755m = new HashSet();

        /* renamed from: n */
        private boolean f17756n = false;

        public REditor(ContentResolver contentResolver) {
            this.f17753i = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f17756n = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            ContentValues contentValues = new ContentValues();
            if (this.f17756n) {
                this.f17753i.delete(MMPluginProviderConstants.SharedPref.CONTENT_URI, null, null);
                this.f17756n = false;
            }
            Iterator<String> it2 = this.f17755m.iterator();
            while (it2.hasNext()) {
                this.f17753i.delete(MMPluginProviderConstants.SharedPref.CONTENT_URI, "key = ?", new String[]{it2.next()});
            }
            for (Map.Entry<String, Object> entry : this.f17754l.entrySet()) {
                if (MMPluginProviderConstants.Resolver.unresolveObj(contentValues, entry.getValue())) {
                    this.f17753i.update(MMPluginProviderConstants.SharedPref.CONTENT_URI, contentValues, "key = ?", new String[]{entry.getKey()});
                }
            }
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f17754l.put(str, Boolean.valueOf(z));
            this.f17755m.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            this.f17754l.put(str, Float.valueOf(f));
            this.f17755m.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.f17754l.put(str, Integer.valueOf(i));
            this.f17755m.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.f17754l.put(str, Long.valueOf(j));
            this.f17755m.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.f17754l.put(str, str2);
            this.f17755m.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.f17755m.add(str);
            return this;
        }
    }

    public MMSharedPreferences(Context context) {
        this.f17750i = context.getContentResolver();
    }

    private Object getValue(String str) {
        try {
            Cursor query = this.f17750i.query(MMPluginProviderConstants.SharedPref.CONTENT_URI, this.columns, "key = ?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            Object resolveObj = query.moveToFirst() ? MMPluginProviderConstants.Resolver.resolveObj(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
            return resolveObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return getValue(str) != null;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.f17752k == null) {
            this.f17752k = new REditor(this.f17750i);
        }
        return this.f17752k;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            Cursor query = this.f17750i.query(MMPluginProviderConstants.SharedPref.CONTENT_URI, this.columns, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.f17751j.put(query.getString(columnIndex), MMPluginProviderConstants.Resolver.resolveObj(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.f17751j;
        } catch (Exception e) {
            e.printStackTrace();
            return this.f17751j;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Float)) ? f : ((Float) value).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Integer)) ? i : ((Integer) value).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Long)) ? j : ((Long) value).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof String)) ? str2 : (String) value;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
