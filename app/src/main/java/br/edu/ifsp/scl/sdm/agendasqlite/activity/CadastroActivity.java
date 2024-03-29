package br.edu.ifsp.scl.sdm.agendasqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.scl.sdm.agendasqlite.R;
import br.edu.ifsp.scl.sdm.agendasqlite.data.ContatoDAO;
import br.edu.ifsp.scl.sdm.agendasqlite.model.Contato;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_salvarContato) {
            ContatoDAO dao = new ContatoDAO(this);
            Contato c = new Contato();
            c.setNome(((EditText) findViewById(R.id.editTextNome)).getText().toString());
            c.setFone(((EditText) findViewById(R.id.editTextTelefone)).getText().toString());
            c.setEmail(((EditText) findViewById(R.id.editTextEmail)).getText().toString());
            c.setFoneSecundario(((EditText) findViewById(R.id.editTextTelefoneSecundario)).getText().toString());
            c.setDataAniversario(((EditText) findViewById(R.id.editTextDataAniversario)).getText().toString());

            int idContato = (int) dao.incluirContato(c);
            c.setId(idContato);

            MainActivity.adapter.adicionaContatoAdapter(c);

            Toast.makeText(getApplicationContext(), "Contato Inserido", Toast.LENGTH_LONG).show();

            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
