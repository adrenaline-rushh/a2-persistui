package androidsamples.java.dicegames;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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

  @Mock
  private Die6 die;

  @InjectMocks


  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void dice_rolls_66633616654() {
    when(die.value()).thenReturn(6);
    onView(withId(R.id.btn_die)).perform(click());
    assertEquals(5, walletViewModel.balance());
    when(die.value()).thenReturn(6);
    onView(withId(R.id.btn_die)).perform(click());
    assertEquals(15, walletViewModel.balance());
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    assertEquals(25, walletViewModel.balance());
    when(die.value()).thenReturn(3);
    walletViewModel.rollDie();
    assertEquals(25, walletViewModel.balance());
    when(die.value()).thenReturn(3);
    walletViewModel.rollDie();
    assertEquals(20, walletViewModel.balance());
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    assertEquals(25, walletViewModel.balance());
    when(die.value()).thenReturn(1);
    walletViewModel.rollDie();
    assertEquals(25, walletViewModel.balance());
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    assertEquals(30, walletViewModel.balance());
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    assertEquals(40, walletViewModel.balance());
    when(die.value()).thenReturn(5);
    walletViewModel.rollDie();
    assertEquals(40, walletViewModel.balance());
    when(die.value()).thenReturn(4);
    walletViewModel.rollDie();
    assertEquals(40, walletViewModel.balance());
  }
}