package com.example.administrator.bounceview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            stringList.add("阿西吧"+i);
        }

        myAdapter = new MyAdapter(this,stringList) {
            @Override
            protected int ItemLayoutId() {
                return R.layout.item;
            }

            @Override
            protected void onBindHolder(MyViewHolder myViewHolder, int position) {
                TextView textView = myViewHolder.getTextView(R.id.text);
                textView.setText(stringList.get(position));
            }

        };

    }

    public void click(View view){
        BounceMenu bounceMenu = BounceMenu.makeBounce(findViewById(R.id.activity_main),R.layout.bounce_view_layout,myAdapter);
        bounceMenu.show();
    }
}
