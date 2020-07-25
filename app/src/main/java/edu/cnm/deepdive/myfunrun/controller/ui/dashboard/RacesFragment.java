package edu.cnm.deepdive.myfunrun.controller.ui.dashboard;

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
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.view.RaceAdapter;
import edu.cnm.deepdive.myfunrun.view.RaceAdapter.OnClickListener;


public class RacesFragment extends Fragment implements OnClickListener {

  private RaceViewModel raceViewModel;
  private RecyclerView raceList;
  private FloatingActionButton addRace;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_races, container, false);
    raceList = root.findViewById(R.id.race_list);
    addRace = root.findViewById(R.id.add_race);
    addRace.setOnClickListener((v) -> { /* TODO invoke race edit functionality for race */ });
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    raceViewModel = new ViewModelProvider(this).get(RaceViewModel.class);
    getLifecycle().addObserver(raceViewModel);
    raceViewModel.getRaces().observe(getViewLifecycleOwner(), (races) -> {
      RaceAdapter adapter = new RaceAdapter(getContext(), races, this);
      raceList.setAdapter(adapter);

    });
  }

  @Override
  public void onClick(View view, int position, Race race) {
// TODO invoke raceEdit functionality.
  }
}
