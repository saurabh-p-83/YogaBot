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
    private RecyclerView chatsRV;
    private EditText usrMsgEdt;
    private FloatingActionButton sendMsgFab;
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";
    private ArrayList<ChatsModel> chatsModelArrayList;
    private ChatRVAdapter chatRVAdapter;



    public chatbot() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_chatbot, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);



        // Inflate the layout for this fragment
        chatsRV = root.findViewById(R.id .idRVchats);
        usrMsgEdt = root.findViewById(R.id.idEdtMsg);
        sendMsgFab = root.findViewById(R.id.idFABSend);
        chatsModelArrayList = new ArrayList<>();
        chatRVAdapter = new ChatRVAdapter(chatsModelArrayList,getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        chatsRV.setLayoutManager(manager);
        chatsRV.setAdapter(chatRVAdapter);
        sendMsgFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usrMsgEdt.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Enter Your message", Toast.LENGTH_SHORT).show();
                    return;
                }
                getResponse(usrMsgEdt.getText().toString());
                usrMsgEdt.setText("");
            }


        });
        return root;


    }
    private void getResponse(String message){
        chatsModelArrayList.add(new ChatsModel(message,USER_KEY));
        chatRVAdapter.notifyDataSetChanged();
        String url = "http://api.brainshop.ai/get?bid=173716&key=nsCnkuu4FsWmB1Zl&uid=[uid]&msg="+ message;
        String BASE_URL = "http://api.brainshop.ai/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<MsgModel> call = retrofitAPI.getMessage(url);
        call.enqueue(new Callback<MsgModel>() {
            @Override
            public void onResponse(Call<MsgModel> call, Response<MsgModel> response) {
                if (response.isSuccessful()){
                    MsgModel model =response.body();
                    chatsModelArrayList.add(new ChatsModel(model.getCnt(),BOT_KEY));
                    chatRVAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MsgModel> call, Throwable t) {
                chatsModelArrayList.add(new ChatsModel("please revert your question",BOT_KEY));
                chatRVAdapter.notifyDataSetChanged();

            }
        });


    }

}
