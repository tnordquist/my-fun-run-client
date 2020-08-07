package edu.cnm.deepdive.myfunrun.service;

import static com.facebook.stetho.BuildConfig.*;
import static edu.cnm.deepdive.myfunrun.BuildConfig.CLIENT_ID;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


/**
 * The type Google sign in service.
 */
public class GoogleSignInService {
// Need to review Quotes for additional code. Quotes has errors, fix before proceeding

  private static Application context;

  private final GoogleSignInClient client;
  private final MutableLiveData<GoogleSignInAccount> account;
  private final MutableLiveData<Throwable> throwable;

  private GoogleSignInService() {
    account = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
        .requestIdToken(CLIENT_ID)
        .build();
    client = GoogleSignIn.getClient(context, options);
  }

  /**
   * Sets context.
   *
   * @param context the context
   */
  public static void setContext(Application context) {
    GoogleSignInService.context = context;
  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Gets account.
   *
   * @return the account
   */
  public LiveData<GoogleSignInAccount> getAccount() {
    return account;
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
   * Refresh task.
   *
   * @return the task
   */
  public Task<GoogleSignInAccount> refresh() {
    return client.silentSignIn()
        .addOnSuccessListener(this::update)
        .addOnFailureListener(this::update);
  }

  /**
   * Start sign in.
   *
   * @param activity    the activity
   * @param requestCode the request code
   */
  public void startSignIn(Activity activity, int requestCode) {
    update((GoogleSignInAccount) null);
    Intent intent = client.getSignInIntent();
    activity.startActivityForResult(intent, requestCode);
  }

  /**
   * Complete sign in task.
   *
   * @param data the data
   * @return the task
   */
  public Task<GoogleSignInAccount> completeSignIn(Intent data) {
    Task<GoogleSignInAccount> task = null;
    try {
      task = GoogleSignIn.getSignedInAccountFromIntent(data);
      update(task.getResult(ApiException.class));
    } catch (ApiException e) {
      update(e);
    }
    return task;
  }

  /**
   * Sign out task.
   *
   * @return the task
   */
  public Task<Void> signOut() {
    return client.signOut()
        .addOnCompleteListener((account) -> update((GoogleSignInAccount) null));
  }

  private void update(GoogleSignInAccount account) {
    if (account != null) {
      Log.d(getClass().getName(), account.getIdToken());
    }
    this.account.setValue(account);
    this.throwable.setValue(null);
  }

  private void update(Throwable throwable) {
    this.account.setValue(null);
    this.throwable.setValue(throwable);
  }
  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }

}
