package com.example.delluna;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetail extends AppCompatActivity {
    ImageView imageView;
    TextView pName, pPrice;
    EditText quantity;
    Button buyBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        imageView = findViewById(R.id.IV_itemImg);
        pName = findViewById(R.id.TV_itemName);
        pPrice = findViewById(R.id.TV_itemPrice);

        Bundle Extras = getIntent().getExtras();
        String itemname = Extras.getString("name");
        String itemprice = Extras.getString("price");
        Object itemimage = Extras.get("image");
        pName.setText(itemname);
        pPrice.setText(itemprice);
        imageView.setImageResource((Integer) itemimage);
    }
}
