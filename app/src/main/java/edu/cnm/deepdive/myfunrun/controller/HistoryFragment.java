package edu.cnm.deepdive.myfunrun.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import edu.cnm.deepdive.myfunrun.R;

public class HistoryFragment extends Fragment {

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_history, container, false);
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

   // String myArg = SecondFragment.fromBundle(getArguments()).getMyArg();
    //TextView textView = view.findViewById(R.id.textview_second);
   // textView.setText(getString(R.string.hello_second_fragment, myArg));

    view.findViewById(R.id.button_second).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        NavHostFragment.findNavController(HistoryFragment.this)
            .navigate(R.id.action_SecondFragment_to_ThirdFragment);
      }
    });
  }
}
