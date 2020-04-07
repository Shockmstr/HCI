package hieubd.prototype.hci;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void onClickFinishChange(View view) {
        new AlertDialog.Builder(this).setTitle("Xác nhận hoàn thành!").setIcon(R.drawable.icons8ok512)
                                            .setMessage("Đổi mật khẩu thành công!\nQuay trở lại trang đăng nhập...")
                                        .setPositiveButton("Tiếp tục", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                ForgotPasswordActivity.this.setResult(1555);
                                                ForgotPasswordActivity.this.finish();
                                            }
                                        }).show();

    }
}
