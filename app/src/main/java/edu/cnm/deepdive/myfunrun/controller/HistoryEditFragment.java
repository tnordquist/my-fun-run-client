package edu.cnm.deepdive.myfunrun.controller;

import androidx.fragment.app.DialogFragment;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cnm.deepdive.myfunrun.R;
import edu.cnm.deepdive.myfunrun.model.entity.History;


public class HistoryEditFragment extends DialogFragment {

  private static final String ID_KEY = "id";

  private long historyId;
  private History history;
  private View root;
  private AlertDialog dialog;
  // TODO declare fields for all of the view widgets from Fragment history edit.
  // TODO Declare a field for viewmodel.

  public static HistoryEditFragment newInstance(long historyId) {
    HistoryEditFragment fragment = new HistoryEditFragment();
    Bundle args = new Bundle();
    args.putLong(ID_KEY, historyId);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    historyId = getArguments().getLong(ID_KEY, 0);
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    super.onCreateDialog(savedInstanceState);
    root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_history_edit, null, false);
    dialog = new AlertDialog.Builder(getContext())
        .setTitle("Run History")
        .setView(root)
        .setNegativeButton(android.R.string.cancel, null)
        .setPositiveButton(android.R.string.ok, (dlg, wh) -> { /* TODO save. */ })
        .create();
    //TODO Attach listener for dialog listener display.
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
    //TODO connect to the view model
  }

}
