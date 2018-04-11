package vn.vnpt.vanquan223.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edUser;
    EditText edPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin){
            onLogin();
        }
    }

    private void onLogin(){
        String username = edUser.getText().toString();
        String password = edPass.getText().toString();

        if (username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Bạn phải nhập đầy đủ Username và Password!", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(Contants.KEY_USER, username);
        intent.putExtra(Contants.KEY_PASS, password);
        startActivity(intent);/*Không cần lấy giá trị trở về*/
    }
}
