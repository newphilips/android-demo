package com.example.fragmenttofragmentexample;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment{

    TextView mTextMessage;

    InfromMainActivity mInfromMainActivityListener;
    String messageReceived="";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mInfromMainActivityListener = (InfromMainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            Bundle args = getArguments();
            messageReceived = args.getString("message_received");
            Log.d("messageReceived", messageReceived);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        mTextMessage = view.findViewById(R.id.text_message);

        if(messageReceived != null)
            mTextMessage.setText(messageReceived);

        return view;
    }
}
