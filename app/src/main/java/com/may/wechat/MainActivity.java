package com.may.wechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvMessage = findViewById(R.id.rv_message);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rvMessage.setLayoutManager(manager);
        List<MsgBean> list =new ArrayList<>();
        MsgBean msg =new MsgBean(R.mipmap.ic_launcher,"小花","收到","19:00");
        list.add(msg);
        MsgBean abc =new MsgBean(R.mipmap.ic_launcher,"小李","好的呀，一会儿就回来","17:00");
        list.add(abc);
        MsgBean efg =new MsgBean(R.mipmap.ic_launcher,"大表姐","明天降温，注意保暖","昨天");
        list.add(efg);
        MsgAdapter adapter=new MsgAdapter(list);
        rvMessage.setAdapter(adapter);

        adapter.setOnItemClickListener(new MsgAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(MainActivity.this,ChatActivity.class);
                MsgBean msgBean = list.get(position);
                intent.putExtra("name",msgBean.getNickName());
                startActivity(intent);
            }
        });
    }
}