package com.example.yogabot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class chatbot extends Fragment {

    // Define UI elements
    private RecyclerView chatsRV;
    private EditText usrMsgEdt;
    private FloatingActionButton sendMsgFab;

    // Define keys for identifying bot and user messages
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";

    // Create list to hold chat messages
    private ArrayList<ChatsModel> chatsModelArrayList;

    // Create adapter for RecyclerView
    private ChatRVAdapter chatRVAdapter;

    // Constructor
    public chatbot() {
        // Required empty public constructor
    }

    // Inflate layout for fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_chatbot, container, false);

        // Adjust keyboard to not cover EditText when it appears
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        // Initialize UI elements
        chatsRV = root.findViewById(R.id.idRVchats);
        usrMsgEdt = root.findViewById(R.id.idEdtMsg);
        sendMsgFab = root.findViewById(R.id.idFABSend);

        // Initialize list and adapter for RecyclerView
        chatsModelArrayList = new ArrayList<>();
        chatRVAdapter = new ChatRVAdapter(chatsModelArrayList,getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        chatsRV.setLayoutManager(manager);
        chatsRV.setAdapter(chatRVAdapter);

        // Set listener for send button
        sendMsgFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usrMsgEdt.getText().toString().isEmpty()){
                    // If message is empty, show error message and return
                    Toast.makeText(getActivity(), "Enter Your message", Toast.LENGTH_SHORT).show();
                    return;
                }
                // If message is not empty, send it to the chatbot
                getResponse(usrMsgEdt.getText().toString());
                usrMsgEdt.setText("");
            }
        });

        return root;
    }

    // Send user message to chatbot and receive response
    private void getResponse(String message){
        // Add user message to list
        chatsModelArrayList.add(new ChatsModel(message,USER_KEY));
        chatRVAdapter.notifyDataSetChanged();

        // Build URL for chatbot API
        String url = "http://api.brainshop.ai/get?bid=173716&key=nsCnkuu4FsWmB1Zl&uid=uid&msg="+ message;
        String BASE_URL = "http://api.brainshop.ai/";

        // Create Retrofit object and interface for making API call
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        // Make API call to chatbot
        Call<MsgModel> call = retrofitAPI.getMessage(url);
        call.enqueue(new Callback<MsgModel>() {
            @Override
            public void onResponse(Call<MsgModel> call, Response<MsgModel> response) {
                if (response.isSuccessful()){
                    // If response is successful, add chatbot message to list
                    MsgModel model =response.body();
                    chatsModelArrayList.add(new ChatsModel(model.getCnt(),BOT_KEY));
                    chatRVAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MsgModel> call, Throwable t) {
                // If API call fails, show error message and add chatbot message to list
                chatsModelArrayList.add(new ChatsModel("please revert your question",BOT_KEY));
                chatRVAdapter.notifyDataSetChanged();

            }
        });


    }

}
