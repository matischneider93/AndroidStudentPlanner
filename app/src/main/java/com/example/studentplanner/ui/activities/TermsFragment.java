package com.example.studentplanner.ui.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.studentplanner.R;
import com.example.studentplanner.view_models.PageViewModel;
import com.example.studentplanner.view_models.TermViewModel;

public class TermsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private TermViewModel termViewModel;

    public static TermsFragment newInstance(int index) {
        TermsFragment fragment = new TermsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        termViewModel = ViewModelProviders.of(this).get(TermViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        termViewModel.setIndex(index);


    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_term, container, false);
        final TextView textView = root.findViewById(R.id.section_label);



        termViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText("Terms");
            }
        });




        return root;
    }
}
