package com.example.gamw_wanti;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button guess_number;
    EditText guess_number_value;

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guess_number = findViewById(R.id.guess_number);
        guess_number_value = findViewById(R.id.user_number);

        guess_number.setOnClickListener(this);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.guess_number){
            try {
                String message = "";
                int userInput = Integer.parseInt(guess_number_value.getText().toString());

                if (userInput < randomNumber) {
                    message = "Nilai lebih kecil dari angka sebenarnya";
                } else if (userInput > randomNumber) {
                    message = "Nilai lebih besar dari angka sebenarnya";
                } else {
                    message = "Tebakan anda benar !";
                    randomGeneratorNumber();
                }

                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Opps kayak nya ada error deh !", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void randomGeneratorNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;

    }
}