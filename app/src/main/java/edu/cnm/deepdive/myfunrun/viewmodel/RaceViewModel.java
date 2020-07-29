package edu.cnm.deepdive.myfunrun.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.myfunrun.model.entity.Race;
import edu.cnm.deepdive.myfunrun.model.pojo.RaceWithHistory;
import edu.cnm.deepdive.myfunrun.service.RaceRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

/**
 * The type Race view model.
 */
public class RaceViewModel extends AndroidViewModel implements LifecycleObserver {

  private final RaceRepository raceRepository;
  private final MutableLiveData<RaceWithHistory> race;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  /**
   * Instantiates a new Race view model.
   *
   * @param application the application
   */
  public RaceViewModel(@NonNull Application application) {
    super(application);
    raceRepository = new RaceRepository(application);
    race = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();

  }

  /**
   * Gets race.
   *
   * @return the race
   */
  public LiveData<RaceWithHistory> getRace() {
    return race;
  }

  /**
   * Gets throwable.
   *
   * @return the throwable
   */
  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  /**
   * Gets races.
   *
   * @return the races
   */
  public LiveData<List<Race>> getRaces() {
    throwable.setValue(null);
    return raceRepository.getAll();
  }

  /**
   * Set race id.
   *
   * @param id the id
   */
  public void setRaceId(long id){
    throwable.setValue(null);
    pending.add(
        raceRepository.get(id)
            .subscribe(
                value -> this.race.postValue(value),
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending(){
    pending.clear();
  }

  /**
   * Save.
   *
   * @param race the race
   */
  public void save(Race race) {
    throwable.setValue(null);
    pending.add(
        raceRepository.save(race)
            .subscribe(
                () -> {},
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  /**
   * Delete.
   *
   * @param race the race
   */
  public void delete (Race race) {
    throwable.setValue(null);
    pending.add(
        raceRepository.delete(race)
            .subscribe(
                () -> {},
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }
}