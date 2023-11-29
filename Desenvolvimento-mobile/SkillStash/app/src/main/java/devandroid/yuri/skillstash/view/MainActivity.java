package devandroid.yuri.skillstash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import devandroid.yuri.skillstash.R;

public class MainActivity extends AppCompatActivity {

    Button btnAdicionar;
    Button btnDeletar;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnDeletar = findViewById(R.id.btnDeletar);




    }


}