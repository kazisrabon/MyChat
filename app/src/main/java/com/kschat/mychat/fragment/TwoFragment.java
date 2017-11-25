package com.kschat.mychat.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kschat.mychat.R;
import com.kschat.mychat.adapter.ContactListAdapter;
import com.kschat.mychat.pojo.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DOLPHIN on 16-Nov-17.
 */

public class TwoFragment extends Fragment {
    private View view;
    private Context context;

    private RecyclerView recyclerView;
    private List<Contact> contactList = new ArrayList<>();
    private ContactListAdapter mAdapter;

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_two, container, false);
//            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.contactRecycler);

        mAdapter = new ContactListAdapter(contactList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareContactData();
        // Inflate the layout for this fragment
        return view;
    }

    private void prepareContactData() {
        Contact contact = new Contact("ADD CONTACT");
        contactList.add(contact);

        contact = new Contact("Group Chat");
        contactList.add(contact);

        contact = new Contact("Star Wars: Episode VII - The Force Awakens");
        contactList.add(contact);

        contact = new Contact("Shaun the Sheep");
        contactList.add(contact);

        contact = new Contact("The Martian");
        contactList.add(contact);

        contact = new Contact("Mission: Impossible Rogue Nation");
        contactList.add(contact);

        contact = new Contact("Up");
        contactList.add(contact);

        contact = new Contact("Star Trek");
        contactList.add(contact);

        contact = new Contact("The LEGO Movie");
        contactList.add(contact);

        contact = new Contact("Iron Man");
        contactList.add(contact);

        contact = new Contact("Aliens");
        contactList.add(contact);

        contact = new Contact("Chicken Run");
        contactList.add(contact);

        contact = new Contact("Back to the Future");
        contactList.add(contact);

        contact = new Contact("Raiders of the Lost Ark");
        contactList.add(contact);

        contact = new Contact("Goldfinger");
        contactList.add(contact);

        contact = new Contact("Guardians of the Galaxy");
        contactList.add(contact);

        mAdapter.notifyDataSetChanged();
    }
}
