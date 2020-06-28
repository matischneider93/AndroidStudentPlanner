package com.example.studentplanner.ui.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.studentplanner.R;
import com.example.studentplanner.view_models.AssessmentViewModel;
import com.example.studentplanner.view_models.PageViewModel;

public class AssessmentsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private AssessmentViewModel assessmentViewModel;

    public static AssessmentsFragment newInstance(int index) {
        AssessmentsFragment fragment = new AssessmentsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assessmentViewModel = ViewModelProviders.of(this).get(AssessmentViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        assessmentViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_assessment, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        assessmentViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }
}
