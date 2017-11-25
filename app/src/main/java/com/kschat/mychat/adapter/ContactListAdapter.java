package com.kschat.mychat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kschat.mychat.R;
import com.kschat.mychat.pojo.Contact;

import java.util.List;

/**
 * Created by DOLPHIN on 25-Nov-17.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.MyViewHolder>{
    private List<Contact> contactList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frag_contact_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.nameTV.setText(contact.getName());
//        holder.profileIcon.setImageBitmap(chat.getBitmap());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTV;
        public ImageView profileIcon;

        public MyViewHolder(View view) {
            super(view);
            nameTV = (TextView) view.findViewById(R.id.name);
            profileIcon = (ImageView) view.findViewById(R.id.profileIcon);
        }
    }

    public ContactListAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
