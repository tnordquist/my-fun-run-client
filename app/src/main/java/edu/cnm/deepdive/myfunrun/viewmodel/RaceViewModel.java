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

public class RaceViewModel extends AndroidViewModel implements LifecycleObserver {

  private final RaceRepository raceRepository;
  private final MutableLiveData<RaceWithHistory> race;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  public RaceViewModel(@NonNull Application application) {
    super(application);
    raceRepository = new RaceRepository(application);
    race = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();

  }

  public LiveData<RaceWithHistory> getRace() {
    return race;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public LiveData<List<Race>> getRaces() {
    throwable.setValue(null);
    return raceRepository.getAll();
  }

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
}