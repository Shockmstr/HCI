package hieubd.prototype.hci.seller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import hieubd.prototype.hci.AccountActivity;
import hieubd.prototype.hci.R;
import hieubd.prototype.hci.java.User;

public class SellDetailActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_detail1);
    }

    public void onClickViewHistory(View view) {
        Intent intent =new Intent(this, SellerHistoryActivity.class);
        startActivity(intent);
    }

    public void onClickContinueTo2(View view) {
        Intent intent =new Intent(this, SellDetailActivity2.class);
        intent.putExtra("NAME", ((TextInputEditText)findViewById(R.id.editText3_1)).getText().toString());
        intent.putExtra("PHONE", ((TextInputEditText)findViewById(R.id.editText4_1)).getText().toString());
        intent.putExtra("ADDRESS", ((TextInputEditText)findViewById(R.id.editText5_1)).getText().toString());
        intent.putExtra("WEIGHT", ((TextInputEditText)findViewById(R.id.editText6_1)).getText().toString());
        intent.putExtra("STATUS", ((TextInputEditText)findViewById(R.id.editText7_1)).getText().toString());
        intent.putExtra("NOTE", ((TextInputEditText)findViewById(R.id.editText8_1)).getText().toString());
        startActivityForResult(intent, 1111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1111){
            if (resultCode == RESULT_CANCELED){
                ((TextInputEditText)findViewById(R.id.editText3_1)).setText(data.getStringExtra("NAME"));
                ((TextInputEditText)findViewById(R.id.editText4_1)).setText(data.getStringExtra("PHONE"));
                ((TextInputEditText)findViewById(R.id.editText5_1)).setText(data.getStringExtra("ADDRESS"));
                ((TextInputEditText)findViewById(R.id.editText6_1)).setText(data.getStringExtra("WEIGHT"));
                ((TextInputEditText)findViewById(R.id.editText7_1)).setText(data.getStringExtra("STATUS"));
                ((TextInputEditText)findViewById(R.id.editText8_1)).setText(data.getStringExtra("NOTE"));
            }
        }
    }

    public void onClickCancel(View view) {
        setResult(4321);
        finish();
    }

    public void onClickViewProfile(View view) {
        User user = new User(R.drawable.avatar96,"nguyenvana", "Nguyễn Văn A", 28, "Nam", "0147258369", "Số 21 Trúc Bạch, Thành Phố Y", "vanaa@gmail.com");
        Intent intent = new Intent(this, AccountActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
