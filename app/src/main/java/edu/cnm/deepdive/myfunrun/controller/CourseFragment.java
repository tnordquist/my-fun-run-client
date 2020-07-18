package edu.cnm.deepdive.myfunrun.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import edu.cnm.deepdive.myfunrun.R;

public class CourseFragment extends Fragment {

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {
    // Inflate the layout for this fragment
   View root = inflater.inflate(R.layout.fragment_course, container, false);
   root.findViewById(R.id.navigate_to_history).setOnClickListener((v) -> {
     NavHostFragment.findNavController(this)
         .navigate(R.id.action_course_fragment_to_history_fragment);

   });
    return root;
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);


  }
}
