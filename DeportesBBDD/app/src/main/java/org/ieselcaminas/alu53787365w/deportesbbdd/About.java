package org.ieselcaminas.alu53787365w.deportesbbdd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        // Nuestra colección de datos
        final ArrayList<AndroidDeporte> deportes = new ArrayList<AndroidDeporte>();

        // Ara no definim les dales directament i agafem les imatges des de res/drawable,
        // sinó que ho agafem tot de la Base de Dades
        /*deportes.add(new AndroidDeporte(R.drawable.whale2, "María Mata","2014"));
        deportes.add(new AndroidDeporte(R.drawable.whale2, "Antonio Sanz", "1890"));
        deportes.add(new AndroidDeporte(R.drawable.whale3, "Carlos", "967"));
        deportes.add(new AndroidDeporte(R.drawable.whale4, "Berta", "945"));
        deportes.add(new AndroidDeporte(R.drawable.whale5, "Héctor Campos", "879"));
        deportes.add(new AndroidDeporte(R.drawable.whale6, "Ismael ", "678"));
        deportes.add(new AndroidDeporte(R.drawable.whale7, "Anna Tena", "543"));
        deportes.add(new AndroidDeporte(R.drawable.whale8, "Patricia", "531"));*/

        SQLiteGestor bdg = null;
        try {
            bdg = new SQLiteGestor(this,"esports.sqlite",null,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SQLiteDatabase bd = bdg.getReadableDatabase();

        Cursor rs = bd.rawQuery("SELECT * FROM USUARIS",null);

        while (rs.moveToNext())
            deportes.add(new AndroidDeporte(rs.getBlob(3),rs.getString(1), rs.getString(2)));

        rs.close();
        bd.close();
        bdg.close();

        ListView lstOpciones = (ListView) findViewById(R.id.lstOpcions);
        final DeportesAdapter adapter = new DeportesAdapter(About.this, deportes);
        lstOpciones.setAdapter(adapter);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String opcionSeleccionada =((AndroidDeporte)a.getItemAtPosition(position)).getTitulo();
                Toast.makeText(About.this, opcionSeleccionada, Toast.LENGTH_LONG).show();
            }
        });
    }
}
