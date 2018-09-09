package projeto11.com.br.projeto11;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declarar os atributos da Classe
    EditText edtCustoFabrica;
    Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtCustoFabrica = (EditText) findViewById(R.id.edtCustoFabrica);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtCustoFabrica.getText().length() <= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtCustoFabrica.requestFocus();
                } else {

                    Double custoFabrica = Double.parseDouble(edtCustoFabrica.getText().toString());

                    Double desc28 = custoFabrica * 0.28;

                    Double desc45 = custoFabrica * 0.45;

                    Double custoConsumidor = custoFabrica + desc28 + desc45;

                    AlertDialog.Builder alerta = new
                            AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("CUSTO CONSUMIDOR");
                    alerta.setMessage("O custo total para o consumidor é de : "
                            + new DecimalFormat("0.00").format(custoConsumidor));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtCustoFabrica.setText("");
                edtCustoFabrica.requestFocus();
            }
        });
    }
}
