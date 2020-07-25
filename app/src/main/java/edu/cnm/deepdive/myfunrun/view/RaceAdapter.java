package edu.cnm.deepdive.myfunrun.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.myfunrun.R;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.view.RaceAdapter.Holder;
import java.util.List;

public class RaceAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final List<Race> races;
  private final OnClickListener listener;

  public RaceAdapter(Context context,
      List<Race> races, OnClickListener listener) {
    this.context = context;
    this.races = races;
    this.listener = listener;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_race, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);

  }

  @Override
  public int getItemCount() {
    return races.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final TextView name;

    public Holder(@NonNull View itemView) {
      super(itemView);
      name = itemView.findViewById(R.id.name);
    }

    private void bind(int position) {
      Race race = races.get(position);
      name.setText(race.getName());
      itemView.setOnClickListener((v) -> listener.onClick(v, position, race));
    }
  }

  public interface OnClickListener {

    void onClick(View view, int position, Race race);
  }
}
