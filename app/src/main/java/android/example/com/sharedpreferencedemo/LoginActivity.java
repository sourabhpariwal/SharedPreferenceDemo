package android.example.com.sharedpreferencedemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText user, pass;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    protected static final String Email = "key1";
    String id=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        sharedPreferences = getSharedPreferences("sharedPreference", MODE_PRIVATE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.putString(Email, user.getText().toString());
                editor.apply();
                Toast.makeText(LoginActivity.this, "Values has been Stored ", Toast.LENGTH_LONG).show();
                id = sharedPreferences.getString(Email, "");
                System.out.println(id);

            }
        });


    }

}
