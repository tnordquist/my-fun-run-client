package edu.cnm.deepdive.myfunrun.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.myfunrun.R;
import edu.cnm.deepdive.myfunrun.model.entity.History;
import edu.cnm.deepdive.myfunrun.model.pojo.HistoryWithDetails;
import edu.cnm.deepdive.myfunrun.view.HistoryAdapter.Holder;
import java.text.DateFormat;
import java.util.List;

/**
 * The type History adapter.
 */
public class HistoryAdapter extends RecyclerView.Adapter<Holder> {


  private final Context context;
  private final List<HistoryWithDetails> histories;
  private final OnClickListener listener;
  private final DateFormat dateFormat;
  private final DateFormat timeFormat;
  private final String distanceFormat;
  private final String paceFormat;

  /**
   * Instantiates a new History adapter.
   *
   * @param context   the context
   * @param histories the histories
   * @param listener  the listener
   */
  public HistoryAdapter(Context context,
      List<HistoryWithDetails> histories, OnClickListener listener) {
    this.context = context;
    this.histories = histories;
    this.listener = listener;
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    timeFormat = android.text.format.DateFormat.getTimeFormat(context);
    distanceFormat = "%,d km";
    paceFormat = "%.2f km/hr";
    // TODO extract these formats to string resources.
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.item_history, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);

  }

  @Override
  public int getItemCount() {
    return histories.size();
  }

  /**
   * The type Holder.
   */
  class Holder extends RecyclerView.ViewHolder {

    private final TextView date;
    private final TextView start;
    private final TextView end;
    private final TextView distance;
    private final TextView pace;
    private final TextView race;

    /**
     * Instantiates a new Holder.
     *
     * @param itemView the item view
     */
    public Holder(@NonNull View itemView) {
      super(itemView);
      date = itemView.findViewById(R.id.date);
      start = itemView.findViewById(R.id.start);
      end = itemView.findViewById(R.id.end);
      distance = itemView.findViewById(R.id.distance);
      pace = itemView.findViewById(R.id.pace);
      race = itemView.findViewById(R.id.race);
    }

    private void bind(int position) {
      HistoryWithDetails history = histories.get(position);
      date.setText(dateFormat.format(history.getStart()));
      start.setText(timeFormat.format(history.getStart()));
      end.setText(timeFormat.format(history.getEnd()));
      distance.setText(String.format(distanceFormat, history.getDistance()));
      pace.setText(String.format(paceFormat, history.getPace()));
      if (history.getRace() != null) {
        race.setText(history.getRace().getName());
      } else {
        race.setText("");
      }
      itemView.setOnClickListener((v) -> listener.onClick(v, position, history));
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
     * @param history  the history
     */
    void onClick(View view, int position, History history);
  }
}



