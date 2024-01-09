package devandroid.yuri.skillstash.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import devandroid.yuri.skillstash.database.SkillDB;

public class cursoController extends SkillDB {
    public cursoController(Context context) {
        super(context);
    }

    public cursoController(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
}
