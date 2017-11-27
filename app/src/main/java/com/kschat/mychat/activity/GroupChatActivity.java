package com.kschat.mychat.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.kschat.mychat.R;
import com.kschat.mychat.adapter.ChatAdapter;
import com.kschat.mychat.pojo.ChatMessage;

import java.util.ArrayList;
import java.util.Random;

public class GroupChatActivity extends BaseActivity implements View.OnClickListener {
    private EditText msg_edittext;
    private String user1 = "khushi", user2 = "khushi1";
    private Random random;
    public static ArrayList<ChatMessage> chatlist;
    public static ChatAdapter chatAdapter;
    ListView msgListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupDrawer(savedInstanceState, GroupChatActivity.this, GroupChatActivity.this, toolbar, "user_name", "", 4, 0);

        random = new Random();
        msg_edittext = (EditText) findViewById(R.id.messageEditText);
        msgListView = (ListView) findViewById(R.id.msgListView);
        ImageButton sendButton = (ImageButton) findViewById(R.id.sendMessageButton);
        sendButton.setOnClickListener(this);

        // ----Set autoscroll of listview when a new message arrives----//
        msgListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        msgListView.setStackFromBottom(true);

        chatlist = new ArrayList<ChatMessage>();
        chatAdapter = new ChatAdapter(this, chatlist);
        msgListView.setAdapter(chatAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    public void sendTextMessage(View v) {
        String message = msg_edittext.getEditableText().toString();
        if (!message.equalsIgnoreCase("")) {
            final ChatMessage chatMessage = new ChatMessage(user1, user2,
                    message, "" + random.nextInt(1000), true);
            chatMessage.setMsgID();
            chatMessage.body = message;
            chatMessage.Date = getCurrentDate();
            chatMessage.Time = getCurrentTime();
            msg_edittext.setText("");
            chatAdapter.add(chatMessage);
            chatAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendMessageButton:
                sendTextMessage(v);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_add_people:
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_more_vart:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
