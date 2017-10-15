package com.example.david.gadgeothek;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Stack;

import layout.LoginFragment;
import layout.RegistrierenFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    enum Pages {Login, Regist}

    private Stack<Pages> pages = new Stack<>();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttonGoToLogin).setOnClickListener(this);
        findViewById(R.id.buttonGoToReg).setOnClickListener(this);
        fragmentManager = getFragmentManager();

        // Wir starten mit dem StepHelloFragment
        pages.push(Pages.Login);
        switchTo(new LoginFragment());
    }
    @Override
    public void onClick(View v) {
        switch (pages.peek()) {
            case Login:
                pages.push(Pages.Regist);
                switchTo(new RegistrierenFragment());
                break;
            case Regist:
                pages.push(Pages.Login);
                switchTo(new LoginFragment());
                break;
        }
    }

    private void switchTo(Fragment fragment) {
        //Bundle args = new Bundle();
        //args.putSerializable(Constants.REGISTRATION_DATA, userRegistrationData);
        //fragment.setArguments(args);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, fragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
