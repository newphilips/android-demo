package com.example.fragmenttofragmentexample;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements InfromMainActivity {

    FrameLayout mFrameLayout;
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrameLayout = findViewById(R.id.main_activity_fragment_container);
        mToolbar = findViewById(R.id.toolbar);

        mToolbar.setTitleTextColor(Color.WHITE);
        FragmentA fragmentA = new FragmentA();
        addFragment(fragmentA, "fragment_a", false);
    }

    public void addFragment(Fragment fragment, String fragmentTag, boolean addToBackStack){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.main_activity_fragment_container, fragment);

        if(addToBackStack){
            fragmentTransaction.addToBackStack(fragmentTag);
        }

        fragmentTransaction.commit();
    }

    @Override
    public void fragmentClicked(String tag, String message) {
        if(tag.equals("fragment_a")) {

            mToolbar.setTitle("Fragment A");

            Bundle args = new Bundle();
            args.putString("message_received", message);
            FragmentA fragmentA = new FragmentA();
            fragmentA.setArguments(args);

            addFragment(fragmentA, tag, false);
            Log.d("inflating Fragment-A", "on button clicked");
        }
        else if(tag.equals("fragment_b")) {
            mToolbar.setTitle("Fragment B");

            Bundle args = new Bundle();
            args.putString("message", message);
            FragmentB fragmentB = new FragmentB();
            fragmentB.setArguments(args);

            addFragment(fragmentB, tag, false);
            Log.d("inflating Fragment-B", "on button clicked");

        }
        else
            mToolbar.setTitle("Fragment C");
    }
}
