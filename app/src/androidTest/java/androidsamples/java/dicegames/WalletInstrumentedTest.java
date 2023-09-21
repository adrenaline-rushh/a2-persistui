package androidsamples.java.dicegames;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class WalletInstrumentedTest {
  @Rule
  public ActivityScenarioRule<WalletActivity> activityRule = new ActivityScenarioRule<>(WalletActivity.class);

  @Test
  public void check_persistent_state() {
    try {
      onView(withId(R.id.btn_die)).perform(click());
      Thread.sleep(600);
      onView(withId(R.id.btn_die)).perform(click());
      Thread.sleep(600);
      onView(withId(R.id.btn_die)).perform(click());
      Thread.sleep(600);
      onView(withId(R.id.btn_die)).perform(click());
      Thread.sleep(600);
      onView(withId(R.id.btn_die)).perform(click());
      Thread.sleep(600);

    }
    catch (InterruptedException e)
    {

    }
  }
}