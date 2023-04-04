package com.example.yogabot;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatRVAdapter extends RecyclerView.Adapter {
    private ArrayList<ChatsModel> chatsModelArrayList;
    private Context context;

    // Constructor
    public ChatRVAdapter(ArrayList<ChatsModel> chatsModelArrayList, Context context) {
        this.chatsModelArrayList = chatsModelArrayList;
        this.context = context;
    }

    // Overloaded Constructor
    public ChatRVAdapter(ArrayList<ChatsModel> chatsModelArrayList, HomeFragment homeFragment) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case 0:
                // Inflate user message view
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg_rv_item,parent,false);
                // Return ViewHolder for user message view
                return new UserVieHolder(view);
            case 1:
                // Inflate bot message view
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg_rv_item,parent,false);
                // Return ViewHolder for bot message view
                return new BotViewHolder(view);
        }
        // Return null if viewType is not recognized
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // Get current chat message
        ChatsModel chatsModel = chatsModelArrayList.get(position);
        switch (chatsModel.getSender()){
            case "user":
                // Bind user message to ViewHolder for user message view
                ((UserVieHolder)holder).userTV.setText(chatsModel.getMessage());
                break;
            case "bot":
                // Bind bot message to ViewHolder for bot message view
                ((BotViewHolder)holder).BotMsgTV.setText(chatsModel.getMessage());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        // Get sender of chat message at given position and return view type based on sender
        switch (chatsModelArrayList.get(position).getSender()){
            case "user":
                return 0; // User message view
            case "bot":
                return 1; // Bot message view
            default:
                return -1; // Invalid view type
        }
    }

    @Override
    public int getItemCount() {
        return chatsModelArrayList.size();
    }

    // ViewHolder for user message view
    public static class UserVieHolder extends RecyclerView.ViewHolder{
        TextView userTV;
        public UserVieHolder(@NonNull View itemView) {
            super(itemView);
            userTV = itemView.findViewById(R.id.idTVUser);
        }
    }

    // ViewHolder for bot message view
    public static class BotViewHolder extends RecyclerView.ViewHolder{
        TextView BotMsgTV;
        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            BotMsgTV = itemView.findViewById(R.id.idTVBot);
        }
    }
}



