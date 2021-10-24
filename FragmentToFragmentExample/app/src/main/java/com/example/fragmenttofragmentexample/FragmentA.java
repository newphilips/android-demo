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

public class FragmentA extends Fragment implements View.OnClickListener{

    EditText mEditMessage;
    TextView mTextMessage;
    Button mBtnFragmentA, mBtnFragmentB, mBtnFragmentC;

    InfromMainActivity mInfromMainActivityListener;
    String messageReceived="";
    String messageSent="";

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

        mEditMessage = view.findViewById(R.id.fragment_a_edit_text);
        mBtnFragmentA = view.findViewById(R.id.btn_fragment_a);
        mBtnFragmentB = view.findViewById(R.id.btn_fragment_b);
        mBtnFragmentC = view.findViewById(R.id.btn_fragment_c);
        mTextMessage = view.findViewById(R.id.text_message);

        mBtnFragmentB.setOnClickListener(this);
        mBtnFragmentA.setOnClickListener(this);
        mBtnFragmentC.setOnClickListener(this);

        mEditMessage = view.findViewById(R.id.fragment_a_edit_text);

        if(messageReceived != null)
            mTextMessage.setText(messageReceived);

        return view;
    }

    @Override
    public void onClick(View v) {

        messageSent = mEditMessage.getText().toString();

        switch(v.getId()){
            case (R.id.btn_fragment_a):
                mInfromMainActivityListener.fragmentClicked("fragment_a", messageSent);
                break;

            case (R.id.btn_fragment_b):
                mInfromMainActivityListener.fragmentClicked("fragment_b", messageSent);
                break;

            case (R.id.btn_fragment_c):
                mInfromMainActivityListener.fragmentClicked("fragment_c", messageSent);
                break;
        }
    }
}
