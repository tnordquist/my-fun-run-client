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

/**
 * The type Race adapter.
 */
public class RaceAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final List<Race> races;
  private final OnClickListener listener;

  /**
   * Instantiates a new Race adapter.
   *
   * @param context  the context
   * @param races    the races
   * @param listener the listener
   */
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

  /**
   * The type Holder.
   */
  class Holder extends RecyclerView.ViewHolder {

    private final TextView name;

    /**
     * Instantiates a new Holder.
     *
     * @param itemView the item view
     */
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

  /**
   * The interface On click listener.
   */
  public interface OnClickListener {

    /**
     * On click.
     *
     * @param view     the view
     * @param position the position
     * @param race     the race
     */
    void onClick(View view, int position, Race race);
  }
}
