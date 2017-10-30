package eugenio.nuc;

import android.content.Intent;
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
    TextView tdee_result;
    Button calculate_button;

    double height, weight, age, bmi, bmr, tdee;





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
                    bmr = (10 * weight) + (6.25 * height*100) - (5 * age) + 5;
                    //66 + (6.23 * weight) + (12.7 * height) - (6.76 * age);

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
                    bmr = (10 * weight) + (6.25 * height*100) - (5 * age) - 161;
                    //665 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
                    //
                break;
        }
    }













    public void onRadioButtonClickedAF(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch (view.getId()) {

            case R.id.Sedentary:
                if (checked)
                    //male formula
                    altura = (EditText)findViewById(R.id.altura);
                    peso = (EditText)findViewById(R.id.peso);
                    edad = (EditText)findViewById(R.id.edad);
                    height = Double.parseDouble(altura.getText().toString());
                    weight = Double.parseDouble(peso.getText().toString());
                    age = Double.parseDouble(edad.getText().toString());
                    tdee = bmr * 1.2;
                break;

            case R.id.LightlyActive:
                if (checked)
                    //female formula
                    altura = (EditText)findViewById(R.id.altura);
                    peso = (EditText)findViewById(R.id.peso);
                    edad = (EditText)findViewById(R.id.edad);
                    height = Double.parseDouble(altura.getText().toString());
                    weight = Double.parseDouble(peso.getText().toString());
                    age = Double.parseDouble(edad.getText().toString());
                    tdee = bmr * 1.375;
                break;

            case R.id.ModeratelyActive:
                if (checked)
                    //female formula
                    altura = (EditText)findViewById(R.id.altura);
                peso = (EditText)findViewById(R.id.peso);
                edad = (EditText)findViewById(R.id.edad);
                height = Double.parseDouble(altura.getText().toString());
                weight = Double.parseDouble(peso.getText().toString());
                age = Double.parseDouble(edad.getText().toString());
                tdee = bmr * 1.55;
                break;

            case R.id.VeryActive:
                if (checked)
                    //female formula
                    altura = (EditText)findViewById(R.id.altura);
                peso = (EditText)findViewById(R.id.peso);
                edad = (EditText)findViewById(R.id.edad);
                height = Double.parseDouble(altura.getText().toString());
                weight = Double.parseDouble(peso.getText().toString());
                age = Double.parseDouble(edad.getText().toString());
                tdee = bmr * 1.725;
                break;

            case R.id.ExtremelyActive:
                if (checked)
                    //female formula
                    altura = (EditText)findViewById(R.id.altura);
                peso = (EditText)findViewById(R.id.peso);
                edad = (EditText)findViewById(R.id.edad);
                height = Double.parseDouble(altura.getText().toString());
                weight = Double.parseDouble(peso.getText().toString());
                age = Double.parseDouble(edad.getText().toString());
                tdee = bmr * 1.9;
                break;
        }
    }












    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nuc_health);

    //Boton para ir a la Actividad Basic Juices

        final Button button = findViewById(R.id.button_go_juices);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //codigo
                    startActivity(new Intent(nuc_health.this, BasicJuices.class));
            }
        });


        //Variables

        altura = (EditText)findViewById(R.id.altura);
        peso = (EditText)findViewById(R.id.peso);
        edad = (EditText)findViewById(R.id.edad);
        bmi_result = (TextView)findViewById(R.id.bmi_result);
        calculate_button = (Button) findViewById(R.id.calculate_button);


        //Acciones cuando se presiona el boton de calcular

        calculate_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                //Aqui van las operaciones

                height = Double.parseDouble(altura.getText().toString());
                weight = Double.parseDouble(peso.getText().toString());
                bmi = weight / (height * height);

                //Show Double with Decimal Format BMI
                bmi_result.setText(new DecimalFormat("##.##").format(bmi));


                //Show Double to String BMR
                final TextView txtValue = (TextView) findViewById(R.id.bmr_result);
                txtValue.setText(Double.toString(bmr));


                //Show Double to String TDEE
                final TextView txtValue2 = (TextView) findViewById(R.id.tdee_result);
                txtValue2.setText(Double.toString(tdee));


                //Recommendacion basada en BMI

                if (bmi <= 15) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Very Severely Underweight");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Orange Juice \nGrape Juice ");
                } else if (bmi > 15 && bmi <= 16) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Severely Underweight");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Carrot and Celery Juice \nPurple Cabbage Juice ");
                } else if (bmi > 16 && bmi <= 18.5) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Underweight");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Cabbage Juice \nDetox Green Juice \nTangy Tomato ");
                } else if (bmi > 18.5 && bmi <= 25) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Normal (Healthy Weight)");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Celeb Celery Juice \nPear Juice \nBaby Spinach Juice \nCarrot Juice ");
                } else if (bmi > 25 && bmi <= 30) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Overweight");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Bell Pepper Juice \n Apple Juice \n Wheatgrass Juice ");
                } else if (bmi > 30 && bmi <= 35) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Moderately Obese");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Spinach Juice \nMultivitamin Juice \n Pomegranate Juice ");
                } else if (bmi > 35 && bmi <= 40) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Severely Obese");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Dreamy Carrot Juice \n Kale Juice ");
                } else {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Very Severely Obese");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Celery Juice \nTomato Juice ");
                }
            }

        });



    }







}
