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
import com.kschat.mychat.adapter.CgListAdapter;
import com.kschat.mychat.adapter.ChatListAdapter;
import com.kschat.mychat.adapter.ContactListAdapter;
import com.kschat.mychat.pojo.ContactGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DOLPHIN on 16-Nov-17.
 */

public class ThreeFragment extends Fragment {
    private View view;
    private Context context;

    private RecyclerView recyclerView;
    private List<ContactGroup> contactGroupList = new ArrayList<>();
    private CgListAdapter mAdapter;
    public ThreeFragment() {
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
            view = inflater.inflate(R.layout.fragment_three, container, false);
//            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.cgRecycler);

        mAdapter = new CgListAdapter(contactGroupList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareChatData();
        // Inflate the layout for this fragment
        return view;
    }

    private void prepareChatData() {
        ContactGroup contactGroup = new ContactGroup("Mad Max: Fury Road", "Action & Adventure");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Inside Out", "Animation, Kids & Family");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Star Wars: Episode VII - The Force Awakens", "Action");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Shaun the Sheep", "Animation");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("The Martian", "Science Fiction & Fantasy");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Mission: Impossible Rogue Nation", "Action");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Up", "Animation");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Star Trek", "Science Fiction");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("The LEGO Movie", "Animation");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Iron Man", "Action & Adventure");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Aliens", "Science Fiction");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Chicken Run", "Animation");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Back to the Future", "Science Fiction");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Raiders of the Lost Ark", "Action & Adventure");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Goldfinger", "Action & Adventure");
        contactGroupList.add(contactGroup);

        contactGroup = new ContactGroup("Guardians of the Galaxy", "Science Fiction & Fantasy");
        contactGroupList.add(contactGroup);

        mAdapter.notifyDataSetChanged();
    }
}
