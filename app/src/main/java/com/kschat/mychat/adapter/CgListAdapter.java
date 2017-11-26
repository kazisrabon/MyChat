package com.kschat.mychat.adapter;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.kschat.mychat.R;
import com.kschat.mychat.pojo.Chat;
import com.kschat.mychat.pojo.ContactGroup;

import java.util.List;

/**
 * Created by DOLPHIN on 25-Nov-17.
 */

public class CgListAdapter extends RecyclerView.Adapter<CgListAdapter.MyViewHolder>{
    private List<ContactGroup> contactGroupList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(viewType, parent, false);

        MyViewHolder holder = null;
        switch (viewType) {
            case R.layout.frag_cg_header_item:
                holder = new CgHeaderViewHolder(view);
                break;
            case R.layout.frag_cg_list_item:
                holder = new CgListViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.e("Position", position+"");
        switch (position) {
            case 0:
                holder.bind("Contact Group");
                break;

            default:
                holder.bind(contactGroupList.get(holder.getAdapterPosition()));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return contactGroupList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return R.layout.frag_cg_header_item;
            default:
                return R.layout.frag_cg_list_item;
        }
    }

    public static abstract class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

            // perform action specific to all viewholders, e.g.
            // ButterKnife.bind(this, itemView);
        }

        abstract void bind(ContactGroup contactGroup);
        abstract void bind(String s);
    }

    public class CgListViewHolder extends MyViewHolder{
        public TextView nameTV, lastChatTV;
        public ImageView profileIcon;
        public CheckBox checkBox;

        public CgListViewHolder(View view) {
            super(view);
            nameTV = (TextView) view.findViewById(R.id.name);
            lastChatTV = (TextView) view.findViewById(R.id.lastChatLine);
            profileIcon = (ImageView) view.findViewById(R.id.profileIcon);
            checkBox = (CheckBox) view.findViewById(R.id.cg_item_checkbox);
        }

        @Override
        void bind(ContactGroup contactGroup) {
            Log.e("View Holder name", "cg list");
            nameTV.setText(contactGroup.getName());
            lastChatTV.setText(contactGroup.getLastChatLine());
//            profileIcon.setImageBitmap(contactGroup.getBitmap());
//            checkBox.setChecked(false);
        }

        @Override
        void bind(String s) {

        }
    }

    public class CgHeaderViewHolder extends MyViewHolder{
        public TextView nameTV;
        public CheckBox checkBox;

        public CgHeaderViewHolder(View view) {
            super(view);
            nameTV = (TextView) view.findViewById(R.id.name);
            checkBox = (CheckBox) view.findViewById(R.id.cg_item_checkbox);
        }

        @Override
        void bind(ContactGroup contactGroup) {

        }

        @Override
        void bind(String s) {
            Log.e("View Holder name", "cg header");
            nameTV.setText(s);
//            checkBox.setChecked(false);
        }
    }

    public CgListAdapter(List<ContactGroup> contactGroupList) {
        this.contactGroupList = contactGroupList;
    }
     public CgListAdapter(){}
}
