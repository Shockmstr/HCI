package hieubd.prototype.hci.seller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import hieubd.prototype.hci.AccountActivity;
import hieubd.prototype.hci.R;
import hieubd.prototype.hci.java.User;

public class SellerHistoryActivity extends AppCompatActivity {
    String reason;
    int state = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_history);
    }

    private void reasonToCancel(final int resId, final int resId2){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Xin hãy nêu lí do huỷ: ");
        final EditText edtEdit = new EditText(this);
        edtEdit.setSingleLine(false);
        edtEdit.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        edtEdit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
      //  edtEdit.setLines(5);
        edtEdit.setMaxLines(10);
        edtEdit.setVerticalScrollBarEnabled(true);
        edtEdit.setMovementMethod(ScrollingMovementMethod.getInstance());
        edtEdit.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);
        builder.setView(edtEdit);
        builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reason = edtEdit.getText().toString();
                MaterialButton button = findViewById(resId);
                button.setText("Đã huỷ");
                button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_light)));
                TextView textCancel = findViewById(resId2);
                textCancel.setText("Lí do huỷ: " + reason);
                textCancel.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
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

    public void onClickCancel(View view) {
        if (state == 0){
            new AlertDialog.Builder(this).setTitle("Thông báo").setMessage("Bạn có chắc chắn muốn huỷ?")
                    .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            reasonToCancel(R.id.button_8, R.id.textView_24);
                            state = 1;
                        }
                    })
                    .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
        }
        else{
            final ConstraintLayout layout = findViewById(R.id.constraintLayout_2);
            new AlertDialog.Builder(this).setTitle("Thông báo").setMessage("Bạn có chắc chắn muốn xoá đơn hàng khỏi lịch sử?")
                    .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            layout.setVisibility(View.GONE);
                        }
                    })
                    .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    }).show();
        }
    }

    public void onClickDelete1(View view) {
        final ConstraintLayout layout = findViewById(R.id.constraintLayout_4);
        new AlertDialog.Builder(this).setTitle("Thông báo").setMessage("Bạn có chắc chắn muốn xoá đơn hàng khỏi lịch sử")
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        layout.setVisibility(View.GONE);
                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                }).show();
    }

    public void onClickDelete2(View view) {
        final ConstraintLayout layout = findViewById(R.id.constraintLayout_5);
        new AlertDialog.Builder(this).setTitle("Thông báo").setMessage("Bạn có chắc chắn muốn xoá đơn hàng khỏi danh sách đã đăng?")
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        layout.setVisibility(View.GONE);
                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
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
