package edu.cnm.deepdive.myfunrun;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.myfunrun.service.GoogleSignInService;
import edu.cnm.deepdive.myfunrun.service.MyFunRunDatabase;
import io.reactivex.schedulers.Schedulers;

/**
 * The type My fun run application.
 */
public class MyFunRunApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    GoogleSignInService.setContext(this);
    MyFunRunDatabase.setContext(this);
    MyFunRunDatabase database = MyFunRunDatabase.getInstance();
    database.getUserDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
    Stetho.initializeWithDefaults(this);
  }
}
