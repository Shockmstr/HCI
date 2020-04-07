package hieubd.prototype.hci;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //ConstraintLayout view = findViewById(R.id.loginView);
        //view.getBackground().setAlpha(50);
    }

    public void onClickRealLogin(View view) {
        Intent intent = new Intent(this, ChooseRoleActivity.class);
        startActivity(intent);
    }

    public void onClickToForgotPassword(View view) {
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivityForResult(intent, 7878);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
