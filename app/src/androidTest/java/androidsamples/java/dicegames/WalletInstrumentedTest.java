package androidsamples.java.dicegames;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static androidx.test.espresso.assertion.ViewAssertions.matches;

import android.content.pm.ActivityInfo;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class WalletInstrumentedTest {
  String currBalance, numSingleSixes, numTotalRolls, numDoubleSixes, numDoubleOthers, previousRollValue, currRollValue;

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

      activityRule.getScenario().onActivity(activity -> {
        currBalance = ((TextView)activity.findViewById(R.id.txt_coins)).getText().toString();
        numSingleSixes = ((TextView)activity.findViewById(R.id.txt_single_sixes)).getText().toString();
        numTotalRolls = ((TextView)activity.findViewById(R.id.txt_total_rolls)).getText().toString();
        numDoubleSixes = ((TextView)activity.findViewById(R.id.txt_double_sixes)).getText().toString();
        numDoubleOthers = ((TextView)activity.findViewById(R.id.txt_double_others)).getText().toString();
        previousRollValue = ((TextView)activity.findViewById(R.id.txt_prev_roll)).getText().toString();
        currRollValue = ((Button)activity.findViewById(R.id.btn_die)).getText().toString();

        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
      });

      onView(withId(R.id.txt_coins)).check(matches(withText(currBalance)));
      onView(withId(R.id.txt_single_sixes)).check(matches(withText(numSingleSixes)));
      onView(withId(R.id.txt_total_rolls)).check(matches(withText(numTotalRolls)));
      onView(withId(R.id.txt_double_sixes)).check(matches(withText(numDoubleSixes)));
      onView(withId(R.id.txt_double_others)).check(matches(withText(numDoubleOthers)));
      onView(withId(R.id.txt_prev_roll)).check(matches(withText(previousRollValue)));
      onView(withId(R.id.btn_die)).check(matches(withText(currRollValue)));

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

      activityRule.getScenario().onActivity(activity -> {
        currBalance = ((TextView)activity.findViewById(R.id.txt_coins)).getText().toString();
        numSingleSixes = ((TextView)activity.findViewById(R.id.txt_single_sixes)).getText().toString();
        numTotalRolls = ((TextView)activity.findViewById(R.id.txt_total_rolls)).getText().toString();
        numDoubleSixes = ((TextView)activity.findViewById(R.id.txt_double_sixes)).getText().toString();
        numDoubleOthers = ((TextView)activity.findViewById(R.id.txt_double_others)).getText().toString();
        previousRollValue = ((TextView)activity.findViewById(R.id.txt_prev_roll)).getText().toString();
        currRollValue = ((Button)activity.findViewById(R.id.btn_die)).getText().toString();

        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
      });

      onView(withId(R.id.txt_coins)).check(matches(withText(currBalance)));
      onView(withId(R.id.txt_single_sixes)).check(matches(withText(numSingleSixes)));
      onView(withId(R.id.txt_total_rolls)).check(matches(withText(numTotalRolls)));
      onView(withId(R.id.txt_double_sixes)).check(matches(withText(numDoubleSixes)));
      onView(withId(R.id.txt_double_others)).check(matches(withText(numDoubleOthers)));
      onView(withId(R.id.txt_prev_roll)).check(matches(withText(previousRollValue)));
      onView(withId(R.id.btn_die)).check(matches(withText(currRollValue)));
    }
    catch (InterruptedException e)
    {
      Log.d("Instrumented Test", "check_persistent_state: sleep was interrupted");
    }
  }
}