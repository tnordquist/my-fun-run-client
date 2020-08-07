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
import edu.cnm.deepdive.myfunrun.viewmodel.RaceViewModel;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.view.RaceAdapter;
import edu.cnm.deepdive.myfunrun.view.RaceAdapter.OnClickListener;


/**
 * This class contains static methods, with convenience annotations,
 *  *  which allows us to view races.
 */
public class RaceFragment extends Fragment implements OnClickListener {

  private RaceViewModel raceViewModel;
  private RecyclerView raceList;
  private FloatingActionButton addRace;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_races, container, false);
    raceList = root.findViewById(R.id.race_list);
    addRace = root.findViewById(R.id.ADD_HISTORY);
    addRace.setOnClickListener((v) -> editRace(0));
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    raceViewModel = new ViewModelProvider(getActivity()).get(RaceViewModel.class);
    getLifecycle().addObserver(raceViewModel);
    raceViewModel.getRaces().observe(getViewLifecycleOwner(), (races) -> {
      RaceAdapter adapter = new RaceAdapter(getContext(), races, this);
      raceList.setAdapter(adapter);

    });
  }

  @Override
  public void onClick(View view, int position, Race race) {
    editRace(race.getId());
  }

  private void editRace(long id) {
    RaceEditFragment fragment = RaceEditFragment.newInstance(id);
    fragment.show(getChildFragmentManager(), fragment.getClass().getName());
  }
}
