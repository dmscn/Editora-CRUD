package br.com.damasceno.editora_crud;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.damasceno.editora_crud.controller.DBController;
import br.com.damasceno.editora_crud.controller.OpenDB;

public class Consulta extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        DBController crud = new DBController(getBaseContext());
        Cursor cursor = crud.loadData();

        String[] fieldsName = new String[] {OpenDB.ID, OpenDB.TITLE};
        int[] idViews = new int[] {R.id.idBook, R.id.nameBook};

        SimpleCursorAdapter adpter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.layout_books, cursor, fieldsName, idViews, 0);
        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adpter);

        // botao para retornar
        Button btnReturn = (Button) findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consulta.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
