package br.com.damasceno.editora_crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.damasceno.editora_crud.controller.DBController;

public class Insert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBController crud = new DBController(getBaseContext());
                EditText edtTitulo = (EditText) findViewById(R.id.edtTitle);
                EditText edtAuthor = (EditText) findViewById(R.id.edtAuthor);
                EditText edtPublisher = (EditText) findViewById(R.id.edtPublisher);
                String title = edtTitulo.getText().toString();
                String author = edtAuthor.getText().toString();
                String publisher = edtPublisher.getText().toString();

                String result = crud.insertData(title, author, publisher);

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Insert.this, List.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
