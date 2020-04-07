package hieubd.prototype.hci;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import hieubd.prototype.hci.java.User;

public class AccountActivity extends AppCompatActivity {
    TextInputEditText fullname, age, gender, phone, address, email;
    TextView username;
    ImageView avatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        fullname = findViewById(R.id.editText14_1);
        age = findViewById(R.id.editText14_2);
        gender = findViewById(R.id.editText14_3);
        phone = findViewById(R.id.editText14_4);
        address = findViewById(R.id.editText14_5);
        email = findViewById(R.id.editText14_6);
        username = findViewById(R.id.textView52);
        avatar = findViewById(R.id.imageView24);
        fillInfo();
        Intent intent = this.getIntent();
        String s = intent.getStringExtra("FORBIDDEN");
        if (s != null){
            if (s.equals("forbidden")){
                fullname.setFocusable(false);
                age.setFocusable(false);
                gender.setFocusable(false);
                phone.setFocusable(false);
                address.setFocusable(false);
                email.setFocusable(false);
                ((ImageView)findViewById(R.id.imageView25)).setVisibility(View.GONE);
            }
        }
    }

    private void fillInfo(){
        Intent intent = this.getIntent();
        User user = (User) intent.getSerializableExtra("USER");
        if (user != null){
            fullname.setText(user.getFullname());
            age.setText(user.getAge()+"");
            gender.setText(user.getGender());
            phone.setText(user.getPhone());
            address.setText(user.getAddress());
            email.setText(user.getEmail());
            username.setText(user.getUsername());
            avatar.setImageResource(user.getResId());
        }
    }

    public void onClickSave(View view) {
        new AlertDialog.Builder(this).setTitle("Thông báo").setMessage("Lưu thành công")
                .setPositiveButton("Xác nhận", null).show();
    }
}
