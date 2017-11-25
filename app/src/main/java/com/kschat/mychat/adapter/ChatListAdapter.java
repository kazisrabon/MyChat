package com.kschat.mychat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kschat.mychat.R;
import com.kschat.mychat.pojo.Chat;

import java.util.List;

/**
 * Created by DOLPHIN on 25-Nov-17.
 */

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.MyViewHolder>{
    private List<Chat> chatList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frag_chat_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Chat chat = chatList.get(position);
        holder.nameTV.setText(chat.getName());
        holder.lastChatTV.setText(chat.getLastChatLine());
//        holder.profileIcon.setImageBitmap(chat.getBitmap());
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTV, lastChatTV;
        public ImageView profileIcon;

        public MyViewHolder(View view) {
            super(view);
            nameTV = (TextView) view.findViewById(R.id.name);
            lastChatTV = (TextView) view.findViewById(R.id.lastChatLine);
            profileIcon = (ImageView) view.findViewById(R.id.profileIcon);
        }
    }

    public ChatListAdapter(List<Chat> chatList) {
        this.chatList = chatList;
    }
}
