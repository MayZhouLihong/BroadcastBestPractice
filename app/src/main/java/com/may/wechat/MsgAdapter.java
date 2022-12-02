package com.may.wechat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * DES:
 * <p>
 * Date: 2022/11/22  20:52
 *
 * @author Jason
 */
public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    public List<MsgBean> mData;

    public MsgAdapter(List<MsgBean> data) {
        mData = data;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        MsgBean msgBean = mData.get(position);
        holder.ivMsg.setImageResource(msgBean.getIconRes());
        holder.tvMsgDetail.setText(msgBean.getMsgDetail());
        holder.tvNickName.setText(msgBean.getNickName());
        holder.tvTime.setText(msgBean.getTime());
        holder.clRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivMsg;
        private final TextView tvNickName;
        private final TextView tvMsgDetail;
        private final TextView tvTime;
        private final ConstraintLayout clRoot;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ivMsg = itemView.findViewById(R.id.iv_msg);
            tvNickName = itemView.findViewById(R.id.tv_nick_name);
            tvMsgDetail = itemView.findViewById(R.id.tv_msg_detail);
            tvTime = itemView.findViewById(R.id.tv_time);
            clRoot = itemView.findViewById(R.id.cl_root);
        }
    }

    interface OnItemClickListener{
        void onItemClick(int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener=onItemClickListener;
    }
}
