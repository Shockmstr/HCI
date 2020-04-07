package hieubd.prototype.hci.buyer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import hieubd.prototype.hci.AccountActivity;
import hieubd.prototype.hci.R;
import hieubd.prototype.hci.java.Item;
import hieubd.prototype.hci.java.User;

public class DetailActivity extends AppCompatActivity {
    TextView title, address, note, price;
    ImageView img;
    int resDynamic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = findViewById(R.id.textView27);
        address = findViewById(R.id.textView32);
        note = findViewById(R.id.textView17);
        price = findViewById(R.id.textView16);
        img = findViewById(R.id.imageView5);
        Intent intent = this.getIntent();
        Item item = (Item) intent.getSerializableExtra("ITEM");
        if (item != null){
            title.setText(item.title);
            address.setText(item.address);
            note.setText(item.note);
            price.setText("Giá: " + formatPrice(item.price) + " đ");
            resDynamic = item.resId;
            img.setImageResource(resDynamic);
        }
    }

    private String formatPrice(int price){
        //String.format("%,d", )
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(price);
    }
    public void onClickChangePic1(View view) {
        img.setImageResource(resDynamic);
    }

    public void onClickChangePic2(View view) {
        img.setImageResource(R.drawable.untitled);
    }

    public void onClickChangePic3(View view) {
        img.setImageResource(R.drawable.a90246261_612332836277678_6421946220373082112_n);
    }

    public void onClickOrder(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có chắc chắn muốn mua sản phẩm này?");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new AlertDialog.Builder(DetailActivity.this).setTitle("Hoàn tất yêu cầu")
                                                                .setMessage("Hãy liên hệ với người bán để sắp xếp thời gian lấy hàng của bạn")
                                                                .setIcon(R.drawable.icons8ok512)
                                                                .setPositiveButton("Tiếp tục", new DialogInterface.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        Intent intent = new Intent(DetailActivity.this, HistoryActivity.class);
                                                                        startActivity(intent);
                                                                    }
                                                                })
                                                                .show();
            }
        });
        builder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //
            }
        });
        builder.show();
    }

    public void onClickViewSellerProfile(View view) {
        User user = new User(R.drawable.avatar96,"nguyenvana", "Nguyễn Văn A", 28, "Nam", "0147258369", "Số 21 Trúc Bạch, Thành Phố Y", "vanaa@gmail.com");
        Intent intent = new Intent(this, AccountActivity.class);
        intent.putExtra("USER", user);
        intent.putExtra("FORBIDDEN", "forbidden");
        startActivity(intent);
    }
}
