package edu.cnm.deepdive.myfunrun.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.myfunrun.R;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.view.HistoryAdapter;
import edu.cnm.deepdive.myfunrun.view.HistoryAdapter.OnClickListener;
import edu.cnm.deepdive.myfunrun.viewmodel.HistoryViewModel;

public class HistoryFragment extends Fragment {

  private HistoryViewModel historyViewModel;
  private RecyclerView historyList;
  private FloatingActionButton addHistory;



  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
    getLifecycle().addObserver(historyViewModel);
    historyViewModel.getHistories().observe(getViewLifecycleOwner(), (histories) -> {
      HistoryAdapter adapter = new HistoryAdapter(getContext(), histories, (OnClickListener) this);
      historyList.setAdapter(adapter);

    });
  }

  @Override
  public void onClick(View view, int position, Race race) {
    editHistory(race.getId());
  }

  private void editHistory(long id) {
    RaceEditFragment fragment = RaceEditFragment.newInstance(id);
    fragment.show(getChildFragmentManager(), fragment.getClass().getName());
  }

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    historyViewModel =
        ViewModelProviders.of(this).get(HistoryViewModel.class);
    View root = inflater.inflate(R.layout.fragment_history, container, false);
    final TextView textView = root.findViewById(R.id.text_notifications);
    historyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}
