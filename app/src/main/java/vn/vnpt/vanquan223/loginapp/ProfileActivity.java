package vn.vnpt.vanquan223.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvUser;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvUser = findViewById(R.id.tvUser);
        btnEdit = findViewById(R.id.btnEdit);

        Intent intent = getIntent();
        tvUser.setText(intent.getStringExtra(Contants.KEY_USER));
        /*Cách 1
        * Phải implements View.OnClickListener
        * Sử dựng được cho nhiều Button
        * btnEdit1.setOnClickListener(this);
        * btnEdit2.setOnClickListener(this);
        * */
        btnEdit.setOnClickListener(this);

        //Cách 2
        /*btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == 456){/*Có thể có nhiều Activity trả về nên kiểm tra đúng requestCode và resultCode*/
            String username = data.getStringExtra(Contants.KEY_USER_EDIT);
            tvUser.setText(username);
        }

    }

    @Override
    public void onClick(View v) {
        /*
        * Nếu có nhiều Button thì phải kiểm tra v.getId() là Button nào
        * */
        Intent intent1 = new Intent(this, EditUserActivity.class);
        intent1.putExtra(Contants.KEY_USER_PROFILE, tvUser.getText().toString());
        startActivityForResult(intent1, 123); /*Lấy giá trị trả về theo requestCode -> trả về trong onActivityResult*/
    }
}
