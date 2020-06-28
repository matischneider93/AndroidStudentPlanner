package com.example.studentplanner.ui.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.studentplanner.R;
import com.example.studentplanner.models.Assessment;
import com.example.studentplanner.view_models.AssessmentViewModel;
import com.example.studentplanner.view_models.CourseViewModel;
import com.example.studentplanner.view_models.PageViewModel;
import com.example.studentplanner.view_models.TermViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private TermViewModel termViewModel;
    private CourseViewModel courseViewModel;
    private AssessmentViewModel assessmentViewModel;

    public static MainFragment newInstance(int index) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        termViewModel = ViewModelProviders.of(this).get(TermViewModel.class);
        assessmentViewModel = ViewModelProviders.of(this).get(AssessmentViewModel.class);
        courseViewModel = ViewModelProviders.of(this).get(CourseViewModel.class);

        int index = getArguments().getInt(ARG_SECTION_NUMBER);
        switch (index) {
            case 1:
                termViewModel.setIndex(index);
                TermsFragment.newInstance(index);
                break;
            case 2:
                courseViewModel.setIndex(index);
                CoursesFragment.newInstance(index);
                break;
            case 3:
                assessmentViewModel.setIndex(index);
                AssessmentsFragment.newInstance(index);
            default:
                pageViewModel.setIndex(index);

        }




    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        int index = getArguments().getInt(ARG_SECTION_NUMBER);
        final TextView textView = root.findViewById(R.id.section_label);

        switch (index){
            case 1:
                termViewModel.getText().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                    }
                });
                root = inflater.inflate(R.layout.fragment_term, container, false);
                return root;

            case 2:
                courseViewModel.getText().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                    }
                });
                root = inflater.inflate(R.layout.fragment_course, container, false);
                return root;
            case 3:
                assessmentViewModel.getText().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                    }
                });
                root = inflater.inflate(R.layout.fragment_assessment, container, false);
                return root;
            default:
                termViewModel.getText().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                    }
                });
                root = inflater.inflate(R.layout.fragment_term, container, false);
                return root;

        }


    }
}