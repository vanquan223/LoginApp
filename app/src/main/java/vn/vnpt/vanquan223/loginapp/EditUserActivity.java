package vn.vnpt.vanquan223.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditUserActivity extends AppCompatActivity {

    EditText editUser;
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        editUser = findViewById(R.id.editUser);
        btnDone = findViewById(R.id.btnDone);

        Intent intent = getIntent();
        editUser.setText(intent.getStringExtra(Contants.KEY_USER_PROFILE));

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editUser.getText().toString().isEmpty()){
                    Toast.makeText(EditUserActivity.this, "Bạn chưa nhập Username!", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent1 = new Intent();
                    intent1.putExtra(Contants.KEY_USER_EDIT, editUser.getText().toString());
                    setResult(456, intent1);
                    finish();
                }
            }
        });
    }
}
