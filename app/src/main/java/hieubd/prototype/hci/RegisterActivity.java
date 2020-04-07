package hieubd.prototype.hci;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onClickRegister(View view) {
        new AlertDialog.Builder(this).setTitle("Thông báo").setMessage("Đăng kí thành công!\nQuay trở lại đăng nhập...")
                .setIcon(R.drawable.icons8ok512).setPositiveButton("Tiếp tục", null).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
