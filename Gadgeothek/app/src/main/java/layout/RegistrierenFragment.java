package layout;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.gadgeothek.R;

public class RegistrierenFragment extends Fragment implements  View.OnClickListener{

    private View.OnClickListener activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_registrieren, container, false);
        root.findViewById(R.id.buttonReg).setOnClickListener(this);
        return root;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        if (activity instanceof View.OnClickListener) {
            this.activity = (View.OnClickListener) activity;
        } else {
            throw new AssertionError("Activity must implement View.OnClickListener!");
        }
    }

    @Override
    public void onClick(View view) {
        activity.onClick(view);
    }
}
