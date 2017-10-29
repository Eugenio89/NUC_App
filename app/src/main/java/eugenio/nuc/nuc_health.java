package eugenio.nuc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;


public class nuc_health extends AppCompatActivity {


    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;


    EditText altura;
    EditText peso;
    EditText edad;
    TextView bmi_result;
    TextView bmr_result;
    Button calculate_button;

    double height, weight, age, bmi, bmr;





    public void onRadioButtonClicked(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch (view.getId()) {

            case R.id.radio_male:
                if (checked)
                    //male formula
                    altura = (EditText)findViewById(R.id.altura);
                    peso = (EditText)findViewById(R.id.peso);
                    edad = (EditText)findViewById(R.id.edad);
                    height = Double.parseDouble(altura.getText().toString());
                    weight = Double.parseDouble(peso.getText().toString());
                    age = Double.parseDouble(edad.getText().toString());
                    bmr = (10 * weight) + (6.25 * height) - (5 * age) + 5;


                break;

            case R.id.radio_female:
                if (checked)
                    //female formula
                    altura = (EditText)findViewById(R.id.altura);
                    peso = (EditText)findViewById(R.id.peso);
                    edad = (EditText)findViewById(R.id.edad);
                    height = Double.parseDouble(altura.getText().toString());
                    weight = Double.parseDouble(peso.getText().toString());
                    age = Double.parseDouble(edad.getText().toString());
                    bmr = (10 * weight) + (6.25 * height) - (5 * age) - 161;

                break;
        }
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nuc_health);

        //Variables

        altura = (EditText)findViewById(R.id.altura);
        peso = (EditText)findViewById(R.id.peso);
        edad = (EditText)findViewById(R.id.edad);
        bmi_result = (TextView)findViewById(R.id.bmi_result);
        calculate_button = (Button) findViewById(R.id.calculate_button);


        //Acciones cuando se presiona el boton de calcular

        calculate_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //Aqui van las operaciones

                height = Double.parseDouble(altura.getText().toString());
                weight = Double.parseDouble(peso.getText().toString());
                bmi = weight/(height*height);

                //Show Double with Decimal Format
                bmi_result.setText(new DecimalFormat("##.##").format(bmi));

                //Show Double to String
                final TextView txtValue = (TextView) findViewById(R.id.bmr_result);
                txtValue.setText(Double.toString(bmr));




            }

        });


    }


}
