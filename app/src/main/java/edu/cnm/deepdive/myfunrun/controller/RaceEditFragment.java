package edu.cnm.deepdive.myfunrun.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.myfunrun.R;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.viewmodel.RaceViewModel;


/**
 This class contains static methods, with convenience annotations,
 *  which allows the user to edit the race details.
 */
public class RaceEditFragment extends DialogFragment implements TextWatcher {

  private static final String ID_KEY = "id";

  private long id;
  private Race race;
  private View root;
  private AlertDialog dialog;
  private RaceViewModel raceViewModel;
  private EditText name;

  /**
   * New instance race edit fragment.
   *
   * @param id the id
   * @return the race edit fragment
   */
  public static RaceEditFragment newInstance(long id) {
    RaceEditFragment fragment = new RaceEditFragment();
    Bundle args = new Bundle();
    args.putLong(ID_KEY, id);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    id = (getArguments() != null) ? getArguments().getLong(ID_KEY, 0) : 0;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
     super.onCreateDialog(savedInstanceState);
     root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_race_edit, null, false);
     name = root.findViewById(R.id.name);
     name.addTextChangedListener(this);
     dialog = new AlertDialog.Builder(getContext())
         // TODO Create icon and set it here.
        .setTitle("Race Details")
         .setView(root)
         .setPositiveButton(android.R.string.ok, (dlg, which) -> {
           race.setName(name.getText().toString().trim());
           raceViewModel.save(race);
         })
         .setNegativeButton(android.R.string.cancel, (dlg, which) -> {})
         .create();
     dialog.setOnShowListener((dlg) -> checkSubmitConditions());
     return dialog;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    raceViewModel = new ViewModelProvider(getActivity()).get(RaceViewModel.class);
    if (id > 0) {
      raceViewModel.getRace().observe(getViewLifecycleOwner(), (race) -> {
        this.race = race;
        name.setText(race.getName());
      });
      raceViewModel.setRaceId(id);
    } else {
      race = new Race();
      name.setText("");
    }
  }

  @Override
  public void beforeTextChanged(CharSequence s, int start, int count, int after) {

  }

  @Override
  public void onTextChanged(CharSequence s, int start, int before, int count) {

  }

  @Override
  public void afterTextChanged(Editable s) {
    checkSubmitConditions();
  }

  private void checkSubmitConditions() {
    Button positive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
    if (positive!= null) {
      positive.setEnabled(!name.getText().toString().trim().isEmpty());
    }
  }
}
