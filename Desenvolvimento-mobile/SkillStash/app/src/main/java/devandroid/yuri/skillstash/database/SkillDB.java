package devandroid.yuri.skillstash.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import devandroid.yuri.skillstash.model.Curso;

public class SkillDB extends SQLiteOpenHelper {


    private static final String DB_Name = "skill_db";

    private static final int DB_VERSION = 1;


    Cursor cursor;

    SQLiteDatabase db;


    public SkillDB(Context context){

        super(context, DB_Name, null, DB_VERSION);

        db =getWritableDatabase();

    }






    public SkillDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTable =
                "CREATE TABLE curso(nome TEXT," +
                        "descricao TEXT)";

        db.execSQL(sqlTable);
        Log.d("SkillDB", "Tabela curso criada com sucesso!");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void salvarCurso(String tabela, ContentValues dados){

        db.insert(tabela, null, dados);

    }

    public List<Curso> obterCursos() {

        List<Curso> cursos = new ArrayList<>();

        SQLiteDatabase db = null;

        Cursor cursor = null;

        try {
            db = getReadableDatabase();
            cursor = db.query("curso", null, null, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String nome = cursor.getString(cursor.getColumnIndex("nome"));

                    @SuppressLint("Range") String descricao = cursor.getString(cursor.getColumnIndex("descricao"));

                    cursos.add(new Curso(nome, descricao));

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }

        return cursos;
    }

    public void deletarCursos(){

        SQLiteDatabase db = null;


        try {
            db = getWritableDatabase();
            // Deleta todos os cursos

            db.delete("curso", null, null);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (db != null) {

                db.close();
            }
        }
    }

    public void deletarCurso(String nome){

        SQLiteDatabase db = null;

        try {
            db = getWritableDatabase();

            // Deleta um curso específico com base no nome

            db.delete("curso", "nome=?", new String[]{nome});

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (db != null) {

                db.close();

            }
        }


    }



}
