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
import com.kschat.mychat.adapter.ChatListAdapter;
import com.kschat.mychat.pojo.Chat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DOLPHIN on 16-Nov-17.
 */

public class OneFragment extends Fragment {
    private View view;
    private Context context;

    private RecyclerView recyclerView;
    private List<Chat> chatList = new ArrayList<>();
    private ChatListAdapter mAdapter;

    public OneFragment() {
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
            view = inflater.inflate(R.layout.fragment_one, container, false);
//            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.chatRecycler);

        mAdapter = new ChatListAdapter(chatList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareChatData();
        // Inflate the layout for this fragment
        return view;
    }

    private void prepareChatData() {
        Chat chat = new Chat("Mad Max: Fury Road", "Action & Adventure");
        chatList.add(chat);

        chat = new Chat("Inside Out", "Animation, Kids & Family");
        chatList.add(chat);

        chat = new Chat("Star Wars: Episode VII - The Force Awakens", "Action");
        chatList.add(chat);

        chat = new Chat("Shaun the Sheep", "Animation");
        chatList.add(chat);

        chat = new Chat("The Martian", "Science Fiction & Fantasy");
        chatList.add(chat);

        chat = new Chat("Mission: Impossible Rogue Nation", "Action");
        chatList.add(chat);

        chat = new Chat("Up", "Animation");
        chatList.add(chat);

        chat = new Chat("Star Trek", "Science Fiction");
        chatList.add(chat);

        chat = new Chat("The LEGO Movie", "Animation");
        chatList.add(chat);

        chat = new Chat("Iron Man", "Action & Adventure");
        chatList.add(chat);

        chat = new Chat("Aliens", "Science Fiction");
        chatList.add(chat);

        chat = new Chat("Chicken Run", "Animation");
        chatList.add(chat);

        chat = new Chat("Back to the Future", "Science Fiction");
        chatList.add(chat);

        chat = new Chat("Raiders of the Lost Ark", "Action & Adventure");
        chatList.add(chat);

        chat = new Chat("Goldfinger", "Action & Adventure");
        chatList.add(chat);

        chat = new Chat("Guardians of the Galaxy", "Science Fiction & Fantasy");
        chatList.add(chat);

        mAdapter.notifyDataSetChanged();
    }
}
