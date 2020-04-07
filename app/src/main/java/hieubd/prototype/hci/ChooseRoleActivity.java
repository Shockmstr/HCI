package hieubd.prototype.hci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import hieubd.prototype.hci.buyer.CategoryActivity;
import hieubd.prototype.hci.seller.SellerCategoryActivity;

public class ChooseRoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_role);
       // setupButtonBuyerHover();
       // setupButtonSellerHover();
    }

    public void setupButtonBuyerHover(){
        final ImageButton btnBuyer = findViewById(R.id.imageButton);
        final TextView txtBuyer = findViewById(R.id.textView8);
        btnBuyer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(getApplicationContext(), "touch", Toast.LENGTH_SHORT).show();
                if (motionEvent.getAction() == MotionEvent.ACTION_HOVER_ENTER){
                    Toast.makeText(getApplicationContext(), "touchOn", Toast.LENGTH_SHORT).show();
                    btnBuyer.setImageResource(R.drawable.setpeoplecarryingshoppingbags_232148251354_3);
                    txtBuyer.setVisibility(View.VISIBLE);
                }else if (motionEvent.getAction() == MotionEvent.ACTION_HOVER_EXIT){
                    Toast.makeText(getApplicationContext(), "touchOff", Toast.LENGTH_SHORT).show();
                    btnBuyer.setImageResource(R.drawable.setpeoplecarryingshoppingbags_232148251354_2);
                    txtBuyer.setVisibility(View.GONE);
                }
                return true;
            }
        });
        btnBuyer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == true){
                    Toast.makeText(getApplicationContext(), "focusOn", Toast.LENGTH_SHORT).show();
                    btnBuyer.setImageResource(R.drawable.setpeoplecarryingshoppingbags_232148251354_3);
                    txtBuyer.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(getApplicationContext(), "focusOff", Toast.LENGTH_SHORT).show();
                    btnBuyer.setImageResource(R.drawable.setpeoplecarryingshoppingbags_232148251354_2);
                    txtBuyer.setVisibility(View.GONE);
                }
            }
        });
    }

    public void setupButtonSellerHover(){
        final ImageButton btnBuyer = findViewById(R.id.imageButton2);
        final TextView txtBuyer = findViewById(R.id.textView9);
        btnBuyer.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_HOVER_ENTER){
                    btnBuyer.setImageResource(R.drawable.a4454_3);
                    txtBuyer.setVisibility(View.VISIBLE);
                }else if (motionEvent.getAction() == MotionEvent.ACTION_HOVER_EXIT){
                    btnBuyer.setImageResource(R.drawable.a4454_2);
                    txtBuyer.setVisibility(View.GONE);
                }
                return true;
            }
        });
    }

    public void onClickBuyer(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }

    public void onClickSeller(View view) {
        Intent intent = new Intent(this, SellerCategoryActivity.class);
        startActivity(intent);
    }
}
