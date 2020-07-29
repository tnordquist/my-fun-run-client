package edu.cnm.deepdive.myfunrun.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.myfunrun.R;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.view.HistoryAdapter;
import edu.cnm.deepdive.myfunrun.view.HistoryAdapter.OnClickListener;
import edu.cnm.deepdive.myfunrun.viewmodel.HistoryViewModel;


/**
 * This class contains static methods, with convenience annotations,
 *  which control the histories posted by users.
 */
public class HistoryFragment extends Fragment implements OnClickListener{

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

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_history, container, false);
    historyList = root.findViewById(R.id.history_list);
    addHistory = root.findViewById(R.id.ADD_HISTORY);
    addHistory.setOnClickListener((v) -> editHistory(0));
    return root;
  }


  @Override
  public void onClick(View view, int position, History history) {
    editHistory(history.getId());
  }
  private void editHistory(long id) {
    RaceEditFragment fragment = RaceEditFragment.newInstance(id);
    fragment.show(getChildFragmentManager(), fragment.getClass().getName());
  }
}
