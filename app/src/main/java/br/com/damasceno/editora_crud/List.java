package br.com.damasceno.editora_crud;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.damasceno.editora_crud.controller.DBController;
import br.com.damasceno.editora_crud.controller.OpenDB;

public class List extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        DBController crud = new DBController(getBaseContext());
        final Cursor cursor = crud.loadData();

        String[] fieldsName = new String[] {OpenDB.ID, OpenDB.TITLE};
        int[] idViews = new int[] {R.id.idBook, R.id.nameBook};

        SimpleCursorAdapter adpter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.layout_books, cursor, fieldsName, idViews, 0);
        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adpter);

        // edita o item clicado
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String code;
                cursor.moveToPosition(position);
                code = cursor.getString(cursor.getColumnIndexOrThrow(OpenDB.ID));
                Intent intent = new Intent(List.this, Update.class);
                intent.putExtra("code", code);
                startActivity(intent);
                finish();
            }
        });

        // botao para retornar
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List.this, Insert.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
