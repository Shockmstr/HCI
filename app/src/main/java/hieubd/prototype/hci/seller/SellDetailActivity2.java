package hieubd.prototype.hci.seller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import hieubd.prototype.hci.AccountActivity;
import hieubd.prototype.hci.R;
import hieubd.prototype.hci.java.User;

public class SellDetailActivity2 extends AppCompatActivity {

    ImageView mainImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_detail2);
        mainImage = findViewById(R.id.imageView19);
    }

    public void onClickViewHistory(View view) {
        Intent intent =new Intent(this, SellerHistoryActivity.class);
        startActivity(intent);
    }

    public void onClickImage1(View view) {
        ImageView img = findViewById(R.id.imageView20);
        Bitmap m = ((BitmapDrawable)img.getDrawable()).getBitmap();
        mainImage.setImageBitmap(m);
    }

    public void onClickImage2(View view) {
        ImageView img = findViewById(R.id.imageView21);
        Bitmap m = ((BitmapDrawable)img.getDrawable()).getBitmap();
        mainImage.setImageBitmap(m);
    }

    public void onClickAddImage(View view) {
    }

    public void onClickPriceRef(View view) {
    }

    public void onClickBackTo1(View view) {
        Intent intent = this.getIntent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    public void onClickProceed(View view) {
        new AlertDialog.Builder(this).setTitle("Hoàn tất!")
                                            .setMessage("Xin hãy chờ duyệt từ phía admin của chúng tôi!")
                                            .setIcon(R.drawable.icons8ok512)
                                            .setPositiveButton("Tiếp tục", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    Intent intent = new Intent(SellDetailActivity2.this, SellerCategoryActivity.class);
                                                    startActivity(intent);
                                                }
                                            }).show();
    }

    public void onClickViewProfile(View view) {
        User user = new User(R.drawable.avatar96,"nguyenvana", "Nguyễn Văn A", 28, "Nam", "0147258369", "Số 21 Trúc Bạch, Thành Phố Y", "vanaa@gmail.com");
        Intent intent = new Intent(this, AccountActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
