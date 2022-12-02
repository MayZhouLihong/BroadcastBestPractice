package com.may.wechat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * DES:
 * <p>
 * Date: 2022/11/23  21:03
 *
 * @author Jason
 */
public class MsgHistoryAdapter extends RecyclerView.Adapter<MsgHistoryAdapter.ViewHolder> {
    public List<MsgHistory> mList;
    public MsgHistoryAdapter(List<MsgHistory> list) {
        mList=list;

    }
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        MsgHistory msgHistory = mList.get(position);
        if (msgHistory.getType()==MsgHistory.MSG_TYPE_REC){
            holder.clRecMsg.setVisibility(View.VISIBLE);
            holder.clSendMsg.setVisibility(View.GONE);
            holder.tvRecMsg.setText(msgHistory.getMsg());
        }else {
            holder.clRecMsg.setVisibility(View.GONE);
            holder.clSendMsg.setVisibility(View.VISIBLE);
            holder.tvSendMsg.setText(msgHistory.getMsg());
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final ConstraintLayout clRecMsg;
        private final ConstraintLayout clSendMsg;
        private final TextView tvRecMsg;
        private final TextView tvSendMsg;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            clRecMsg = itemView.findViewById(R.id.cl_rec_msg);
            clSendMsg = itemView.findViewById(R.id.cl_send_msg);
            tvRecMsg = itemView.findViewById(R.id.tv_rec_msg);
            tvSendMsg = itemView.findViewById(R.id.tv_send_msg);
        }
    }

}
