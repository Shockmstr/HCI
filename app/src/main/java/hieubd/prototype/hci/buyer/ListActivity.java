package hieubd.prototype.hci.buyer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hieubd.prototype.hci.AccountActivity;
import hieubd.prototype.hci.R;
import hieubd.prototype.hci.java.Item;
import hieubd.prototype.hci.java.ItemAdapter;
import hieubd.prototype.hci.java.User;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    List<Item> items;
    ItemAdapter itemAdapter;
    String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.list2);
        Intent intent = this.getIntent();
        category = intent.getStringExtra("CATEGORY");
        switch (category){
            case "paper":
                createListViewPaper();
                break;
            case "electronics":
                createListViewElectronics();
                break;
        }

    }

    private void createListViewPaper(){
        items = new ArrayList<>();
        items.add(new Item(R.drawable.fc0943f8c0df27f82c8ff738eeae4ce3, "Giấy vở", "2", "Số 20 đường XXX thành phố YY",15000, "Lưu ý của người bán: giấy vở tập học sinh đã qua sử dụng 3 năm."));
        items.add(new Item(R.drawable.untitled, "Giấy báo đã qua sử dụng", "3.75", "Số 267 đường Y thành phố A",12000 ,"Lưu ý của người bán: giấy báo xếp thành từng chồng nặng từ 0.5 ~ 1kg."));
        items.add(new Item(R.drawable.thumuagiayphelieu, "Giấy vụn, cạc tông", "5", "Số 245 đường XXX thành phố B", 20000,"Lưu ý của người bán: thùng carton to nhỏ khác nhau có hết, thùng đã xài nhiều lần trong nhiều năm."));
        items.add(new Item(R.drawable.a90028722_1712543892216073_1705810583036624896_n, "Giấy 3 lớp đựng bột PVC", "3.2", "Số 31 Trúc Bạch thành phố X",50000, "Lưu ý của người bán: giấy kraft 3 lớp giấy đựng bôt PVC (không có lớp PP). Đã qua sử dụng 1 lần. Kích thước 73 x 42 x 8 cm, 3.2 Kg"));
        itemAdapter = new ItemAdapter(items);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                Item item = (Item) itemAdapter.getItem(i);
                intent.putExtra("ITEM", (Serializable) item);
                startActivity(intent);
            }
        });
    }

    private void createListViewElectronics(){
        items = new ArrayList<>();
        items.add(new Item(R.drawable.a89849573_1706684472818158_3920213261777108992_o, "Tủ lạnh Toshiba cũ", "40", "Số 20 đường XXX thành phố YY",1600000, "Bán tủ lạnh Toshiba cũ dung tích 130 lít cũ. Mới dùng 6 tháng nhưng có nhu cầu phải thay mới. Tủ chạy êm, đông đá nhanh, tiết kiệm điện năng."));
        items.add(new Item(R.drawable.a89910133_1706684509484821_7336045956816699392_o, "Tủ lạnh hư 1 cánh", "43", "Số 267 đường Y thành phố A",1250000, "Cần thanh lí 1 tủ lạnh Sanyo đã bị hỏng 1 cánh ở ngăn bảo quản như hình."));
        items.add(new Item(R.drawable.ewaste_recycling_70270590031024x682, "Vi mạch, dây điện cũ", "5", "Số 245 đường XXX thành phố B",200000, "Lưu ý của người bán: cần bán các bo mạch, vi mạch điện tử đã cháy, hết hạn, quá hạn sử dụng, sử dụng không được nữa."));
        items.add(new Item(R.drawable.ff55febd6ed37c5c4, "Tivi 22-inch cũ", "4.5", "Số 31 Trúc Bạch thành phố X",1530000, "Ti vi 22-inch cũ có thể sử dụng truyền hình vệ tinh, đầu đĩa dvd..."));
        itemAdapter = new ItemAdapter(items);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                Item item = (Item) itemAdapter.getItem(i);
                intent.putExtra("ITEM", (Serializable) item);
                startActivity(intent);
            }
        });
    }

    public void onClickSortByWeight(View view) {
        Collections.sort(items);
        itemAdapter.setList(items);
        listView.setAdapter(itemAdapter);
    }

    public void onClickSortByAddress(View view) {
        Comparator<Item> adreComp = Comparator.comparing(Item::getAddress);
        Collections.sort(items, adreComp);
        itemAdapter.setList(items);
        listView.setAdapter(itemAdapter);
    }

    public void onClickViewHistory(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    public void onClickViewProfile(View view) {
        User user = new User(R.drawable.avatar,"user123", "Nguyễn Thị C", 32, "Nữ", "0369258147", "Số 3 Hồ Tùng Mậu, Quận.X, TP.XX", "user123@gmail.com");
        Intent intent = new Intent(this, AccountActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
