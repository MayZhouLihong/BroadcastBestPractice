package com.may.wechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etMsg;
    private List<MsgHistory> list;
    private MsgHistoryAdapter msgHistoryAdapter;
    private RecyclerView rvMsgHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        ImageView ivBack = findViewById(R.id.iv_back);
        TextView tvTitle = findViewById(R.id.tv_title);
        rvMsgHistory = findViewById(R.id.rv_msg_history);
        etMsg = findViewById(R.id.et_msg);
        Button btnSend = findViewById(R.id.btn_send);

        tvTitle.setText(name);


        ivBack.setOnClickListener(this);
        btnSend.setOnClickListener(this);

        LinearLayoutManager manager=new LinearLayoutManager(this);
        rvMsgHistory.setLayoutManager(manager);
        list = new ArrayList<>();
        MsgHistory msgHistory1=new MsgHistory(MsgHistory.MSG_TYPE_REC,"什么时候下班");
        MsgHistory msgHistory2=new MsgHistory(MsgHistory.MSG_TYPE_SEND,"六点");
        MsgHistory msgHistory3=new MsgHistory(MsgHistory.MSG_TYPE_REC,"那我等你吃饭");
        MsgHistory msgHistory4=new MsgHistory(MsgHistory.MSG_TYPE_SEND,"好的");
        list.add(msgHistory1);
        list.add(msgHistory2);
        list.add(msgHistory3);
        list.add(msgHistory4);
        msgHistoryAdapter = new MsgHistoryAdapter(list);
        rvMsgHistory.setAdapter(msgHistoryAdapter);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id==R.id.btn_send){
            String msg = etMsg.getText().toString();
            if (!TextUtils.isEmpty(msg)){
                MsgHistory msgHistory=new MsgHistory(MsgHistory.MSG_TYPE_SEND,msg);
                list.add(msgHistory);
                msgHistoryAdapter.notifyItemInserted(list.size()-1);
                rvMsgHistory.scrollToPosition(list.size()-1);
                etMsg.setText("");
            }

        }else if (id==R.id.iv_back){
            finish();
        }
    }
}