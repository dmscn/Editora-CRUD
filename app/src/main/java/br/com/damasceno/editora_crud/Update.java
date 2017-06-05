package br.com.damasceno.editora_crud;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.damasceno.editora_crud.controller.DBController;
import br.com.damasceno.editora_crud.controller.OpenDB;

public class Update extends AppCompatActivity {
    EditText book;
    EditText author;
    EditText publisher;
    Button update;
    Button delete;
    Cursor cursor;
    DBController crud;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        code = this.getIntent().getStringExtra("code");

        crud = new DBController(getBaseContext());

        book = (EditText) findViewById(R.id.edtTitle);
        author = (EditText) findViewById(R.id.edtAuthor);
        publisher = (EditText) findViewById(R.id.edtPublisher);

        cursor = crud.laodDataById(Integer.parseInt(code));
        book.setText(cursor.getString(cursor.getColumnIndexOrThrow(OpenDB.TITLE)));
        author.setText(cursor.getString(cursor.getColumnIndexOrThrow(OpenDB.AUTHOR)));
        publisher.setText(cursor.getString(cursor.getColumnIndexOrThrow(OpenDB.PUBLISHER)));

        update = (Button) findViewById(R.id.btnUpdate);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.updateRegister(Integer.parseInt(code), book.getText().toString(), author.getText().toString(), publisher.getText().toString());
                Toast.makeText(getApplicationContext(), "Registro atualizado com sucesso", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Update.this, List.class);
                startActivity(intent);
                finish();
            }
        });

        delete = (Button) findViewById(R.id.btnDelete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deleteRegister(Integer.parseInt(code));
                Toast.makeText(getApplicationContext(), "Registro deletado com sucesso", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Update.this, List.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
