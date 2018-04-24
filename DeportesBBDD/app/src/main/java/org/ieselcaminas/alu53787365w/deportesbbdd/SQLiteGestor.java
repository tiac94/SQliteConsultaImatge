package org.ieselcaminas.alu53787365w.deportesbbdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SQLiteGestor extends SQLiteOpenHelper {
    private static String PATH_BD = "";
    private static String NOM_BD = "esports.sqlite";
    private Context myContext=null;
    public SQLiteGestor(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) throws IOException {
        super(context, name, factory, version);

        PATH_BD =  "/data/data/" + context.getPackageName() + "/databases";
        File dir = new File (PATH_BD);
        if (! dir.exists())
            dir.mkdir();
        File f = new File(dir,NOM_BD);
        if (! f.exists()) {
            FileOutputStream f_out = new FileOutputStream(f);
            byte[] b = new byte[1024];
            int length;
            InputStream f_in = context.getResources().openRawResource(R.raw.esports);
            while ((length = f_in.read(b)) > 0) {
                f_out.write(b, 0, length);
            }
            f_in.close();
            f_out.close();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*String sql = "CREATE TABLE `USUARIS` (\n" +
                "        `num`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "        `nom`\tTEXT,\n" +
                "        `punts`\tINTEGER,\n" +
                "        `imatge`\tBLOB\n" +
                "        );";
        sqLiteDatabase.execSQL(sql);
        String sql2 = "INSERT INTO USUARIS (`nom`,`punts`,`imatge`) VALUES\n" +
                "('María Mata', 2014, 'file:///home/santi/AndroidStudioProjects/Acces%20a%20dades/sqlite/sqlite-images/whale.jpg\n'),\n" +
                "('Antonio Sanz', 1890, 'file:///home/santi/AndroidStudioProjects/Acces%20a%20dades/sqlite/sqlite-images/whale.jpg'),\n" +
                "('Carlos', 967, 'file:///home/santi/AndroidStudioProjects/Acces%20a%20dades/sqlite/sqlite-images/whale.jpg'),\n" +
                "('Berta', 945, 'file:///home/santi/AndroidStudioProjects/Acces%20a%20dades/sqlite/sqlite-images/whale.jpg'),\n" +
                "('Héctor Campos', 879, 'file:///home/santi/AndroidStudioProjects/Acces%20a%20dades/sqlite/sqlite-images/whale.jpg'),\n" +
                "('Ismael', 678, 'file:///home/santi/AndroidStudioProjects/Acces%20a%20dades/sqlite/sqlite-images/whale.jpg'),\n" +
                "('Anna Tena', 543, 'file:///home/santi/AndroidStudioProjects/Acces%20a%20dades/sqlite/sqlite-images/whale.jpg'),\n" +
                "('Patricia', 531, 'file:///home/santi/AndroidStudioProjects/Acces%20a%20dades/sqlite/sqlite-images/whale.jpg');\n";
        sqLiteDatabase.execSQL(sql2);*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
    }
}