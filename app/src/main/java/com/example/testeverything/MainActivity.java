package com.example.testeverything;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.DriverPropertyInfo;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btncc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                UserInfoDialog userInfoDialog = UserInfoDialog.newInstance("Chạy đi");
                userInfoDialog.show(fm,null);
            }
        });
        initView();
    }

    public void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ArrayList<dataShop> DataShop = new ArrayList<>();
        DataShop.add(new dataShop(R.drawable.bg1,"A"));
        DataShop.add(new dataShop(R.drawable.bg2,"B"));
        DataShop.add(new dataShop(R.drawable.bg3,"C"));
        DataShop.add(new dataShop(R.drawable.bg4,"D"));

        shopAdapter ShopAdapter = new shopAdapter(DataShop,getApplicationContext());

        recyclerView.setAdapter(ShopAdapter);
    }

}
