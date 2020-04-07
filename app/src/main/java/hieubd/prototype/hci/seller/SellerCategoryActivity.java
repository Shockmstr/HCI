package hieubd.prototype.hci.seller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import hieubd.prototype.hci.AccountActivity;
import hieubd.prototype.hci.R;
import hieubd.prototype.hci.java.User;

public class SellerCategoryActivity extends AppCompatActivity {
    TextView title, description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_category);
        title = findViewById(R.id.textView36);
        description = findViewById(R.id.textView37);
    }

    public void onClickSellBottle(View view) {
        title.setText("Thuỷ tinh");
        description.setText("Bạn có thể bày bán các mặt hàng liên quan đến thuỷ tinh như: chai thuỷ tinh, " +
                "hộp đựng thức ăn, ly tách, chén đĩa,... đã qua sử dụng, hư hỏng hoặc có thể vẫn sử dụng tiếp");
    }

    public void onClickGoToSellDetail(View view) {
        Intent intent =new Intent(this, SellDetailActivity1.class);
        startActivityForResult(intent,1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onClickSellElectronics(View view) {
        title.setText("Điện tử");
        description.setText("Bạn có thể bày bán các mặt hàng liên quan đến điện tử như: ti vi, " +
                "tủ lạnh, ổ điện, vi mạch,... đã qua sử dụng, hư hỏng hoặc có thể vẫn sử dụng tiếp");
    }

    public void onClickSellPaper(View view) {
        title.setText("Giấy");
        description.setText("Bạn có thể bán các mặt hàng liên quan đến giấy như: sách vở, giấy bao gói, giấy các tông, giấy báo... đã qua sử dụng, hư hỏng hoặc vẫn có thể sử dụng tiếp");
    }

    public void onClickSellBattery(View view) {
        title.setText("Pin, Năng lượng");
        description.setText("Bạn có thể bày bán các mặt hàng liên quan đến pin và năng lượng như: pin các loại, " +
                "máy phát điện, máy bơm nước,... đã qua sử dụng, hư hỏng hoặc có thể vẫn sử dụng tiếp");
    }

    public void onClickSellMetal(View view) {
        title.setText("Phế liệu");
        description.setText("Bạn có thể bày bán các mặt hàng liên quan đến phế liệu như: đồng, " +
                "sắt, nhôm, chì,... đã qua sử dụng, hư hỏng hoặc có thể vẫn sử dụng tiếp");
    }

    public void onClickSellMisc(View view) {
        title.setText("Các loại khác");
        description.setText("Nếu bạn thấy đồ mình bán không nằm trong 1 các mục trước, bạn có thể bán nó ở đây");
    }

    public void onClickViewHistory(View view) {
        Intent intent =new Intent(this, SellerHistoryActivity.class);
        startActivity(intent);
    }

    public void onClickViewProfile(View view) {
        User user = new User(R.drawable.avatar96,"nguyenvana", "Nguyễn Văn A", 28, "Nam", "0147258369", "Số 21 Trúc Bạch, Thành Phố Y", "vanaa@gmail.com");
        Intent intent = new Intent(this, AccountActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
