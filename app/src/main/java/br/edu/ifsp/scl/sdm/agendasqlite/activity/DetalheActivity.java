package br.edu.ifsp.scl.sdm.agendasqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.scl.sdm.agendasqlite.R;
import br.edu.ifsp.scl.sdm.agendasqlite.data.ContatoDAO;
import br.edu.ifsp.scl.sdm.agendasqlite.model.Contato;

public class DetalheActivity extends AppCompatActivity {

    Contato c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        if (getIntent().hasExtra("contato")) {

            this.c = (Contato)getIntent().getSerializableExtra("contato");

            EditText nome = findViewById(R.id.editTextNome);
            nome.setText(c.getNome());

            EditText fone = findViewById(R.id.editTextTelefone);
            fone.setText(c.getFone());

            EditText email = findViewById(R.id.editTextEmail);
            email.setText(c.getEmail());

            EditText foneAlternativo = findViewById(R.id.editTextTelefoneSecundario);
            foneAlternativo.setText(c.getFoneSecundario());

            EditText dataAniversario = findViewById(R.id.editTextDataAniversario);
            dataAniversario.setText(c.getDataAniversario());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalhe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_alterarContato) {
            ContatoDAO dao = new ContatoDAO(this);
            c.setNome(((EditText) findViewById(R.id.editTextNome)).getText().toString());
            c.setFone(((EditText) findViewById(R.id.editTextTelefone)).getText().toString());
            c.setEmail(((EditText) findViewById(R.id.editTextEmail)).getText().toString());
            c.setFoneSecundario(((EditText) findViewById(R.id.editTextTelefoneSecundario)).getText().toString());
            c.setDataAniversario(((EditText) findViewById(R.id.editTextDataAniversario)).getText().toString());
            dao.alterarContato(c);
            Log.d("ID: ", Integer.toString(c.getId()));
            Log.d("NOME: ",c.getNome());

            MainActivity.adapter.atualizaContatoAdapter(c);

            Toast.makeText(getApplicationContext(), "Contato Alterado", Toast.LENGTH_LONG).show();

            finish();
        }

        if (id == R.id.action_excluirContato) {
            ContatoDAO dao = new ContatoDAO(this);
            dao.excluirContato(c);
            MainActivity.adapter.apagaContatoAdapter(c);

            Toast.makeText(getApplicationContext(), "Contato Excluído", Toast.LENGTH_LONG).show();

            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
