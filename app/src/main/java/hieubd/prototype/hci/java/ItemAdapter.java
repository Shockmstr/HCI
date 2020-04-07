package hieubd.prototype.hci.java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hieubd.prototype.hci.R;

public class ItemAdapter extends BaseAdapter {
    private List<Item> list = new ArrayList<>();

    public ItemAdapter(List<Item> list) {
        this.list = list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.indexOf(list.get(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.item, viewGroup, false);
        }
        Item item = list.get(i);
        ImageView imgItem = view.findViewById(R.id.imgItem);
        TextView txtTitle = view.findViewById(R.id.txtTitle);
        TextView txtWeight = view.findViewById(R.id.txtWeight);
        TextView txtAddre = view.findViewById(R.id.txtAddr);
        imgItem.setImageResource(item.resId);
        txtTitle.setText(item.title);
        txtWeight.setText(item.weight + " Kg");
        txtAddre.setText(item.address);
        return view;
    }
}
