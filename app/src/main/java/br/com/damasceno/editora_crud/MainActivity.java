package br.com.damasceno.editora_crud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.damasceno.editora_crud.controller.DBController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = (Button) findViewById(R.id.btnSend);
        final EditText edtTitulo = (EditText) findViewById(R.id.edtTitle);
        final EditText edtAuthor = (EditText) findViewById(R.id.edtAuthor);
        final EditText edtPublisher = (EditText) findViewById(R.id.edtPublisher);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBController crud = new DBController(getBaseContext());
                String title = edtTitulo.getText().toString();
                String author = edtAuthor.getText().toString();
                String publisher = edtPublisher.getText().toString();

            }
        });
    }
}
