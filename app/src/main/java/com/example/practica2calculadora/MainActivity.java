package com.example.practica2calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double n1;
    double n2;
    String operacion;
    double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView digitos = findViewById(R.id.digitos);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnparentesis1 = findViewById(R.id.btnparentecis1);
        Button btnporcentaje = findViewById(R.id.btnporcentaje);
        Button btndivision = findViewById(R.id.btndivision);
        Button btnmulti = findViewById(R.id.btnmulti);
        Button btnresta = findViewById(R.id.btnresta);
        Button btnsuma = findViewById(R.id.btnsuma);
        Button btnigual = findViewById(R.id.btnigual);
        Button btnpunto = findViewById(R.id.btnpunto);
        Button btnac = findViewById(R.id.btnac);
        Button btnc = findViewById(R.id.btnc);

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(btn0);
        nums.add(btn1);
        nums.add(btn2);
        nums.add(btn3);
        nums.add(btn4);
        nums.add(btn5);
        nums.add(btn6);
        nums.add(btn7);
        nums.add(btn8);
        nums.add(btn9);

        for(Button b : nums)
        {
            b.setOnClickListener(view ->{
                if (!digitos.getText().toString().equals("0")){
                  digitos.setText(digitos.getText().toString() + b.getText().toString());
                }
                else {
                    digitos.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(btndivision);
        opers.add(btnsuma);
        opers.add(btnparentesis1);
        opers.add(btnporcentaje);
        opers.add(btnresta);
        opers.add(btnmulti);

        for(Button b : opers)
        {
            b.setOnClickListener(view -> {
                n1 = Double.parseDouble(digitos.getText().toString());
                operacion = b.getText().toString();
                digitos.setText("0");
            });
        }
        
        btnc.setOnClickListener(view -> {
            String num = digitos.getText().toString();
            if(num.length()>1) {
                digitos.setText(num.substring(0, num.length()-1));
            } else if (num.length() == 1 && !num.equals("0")) {
                digitos.setText("0");
            }
        });

        btnparentesis1.setOnClickListener(view -> {
            digitos.setText("");
            digitos.append("0");
        });

        /* btnpunto.setOnClickListener(view -> {
            if(!digitos.getText().toString().contains(".")){
                digitos.setText(digitos.getText().toString() + ".");
            }
        }); */

        btnigual.setOnClickListener(view -> {
            if (n1 != 0 && operacion != null && !digitos.getText().toString().isEmpty()) {
            n2 = Double.parseDouble(digitos.getText().toString());

            switch (operacion)
            {
                case "÷":
                    if (n2 != 0) {
                        resultado = n1 / n2;
                    } else {
                        resultado = 0;
                    }
                    break;

                case "X":
                    resultado = n1*n2;
                    break;

                case "+":
                    resultado= n1+n2;
                    break;

                case "-":
                    resultado = n1-n2;
                    break;

                case "%":
                    resultado = (n1 * n2) / 100;
                    break;

                default:
                    resultado= n1+n2;
            }

            digitos.setText(String.valueOf(resultado));
            n1 = resultado;
            operacion = null;
            }
            else {
                digitos.setText("0");
            }
        });

        btnac.setOnClickListener(view -> {
            if (resultado != 0 ||!digitos.getText().toString().equals("0") || n2 != 0 || n1 != 0) {
                digitos.setText("0");
                resultado = 0;
                n1 = 0;
                n2 = 0;
            }
        });
    }
}